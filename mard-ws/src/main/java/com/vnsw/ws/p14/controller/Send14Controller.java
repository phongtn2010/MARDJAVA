package com.vnsw.ws.p14.controller;

import com.vnsw.ws.common.envelop.*;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p14.component.Mard14CallBack;
import com.vnsw.ws.p14.component.Mard14DownloadFile;
import com.vnsw.ws.p14.constant.Mard14Constant;
import com.vnsw.ws.p14.envelop.Envelope;
import com.vnsw.ws.p14.message.*;
import com.vnsw.ws.p14.model.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/send/14")
public class Send14Controller {

    public static final Logger logger = LoggerFactory.getLogger(Send14Controller.class);


    private final Environment environment;

    private final EnvelopXmlService convertXmlService;

    private final EncryptService encryptService;

    private final Mard14CallBack mard14CallBack;

    private final Mard14DownloadFile fdMard14DownloadFile;

    private ResponseJson14 fdResponseJson14;

    private TbdKetQuaXuLy14 fdTbdKetQuaXuLy14;

    private TbdThanhToan14 fdTbdThanhToan14;

    @Autowired
    public Send14Controller(Environment environment, EnvelopXmlService convertXmlService, EncryptService encryptService, Mard14CallBack mard14CallBack, Mard14DownloadFile fdMard14DownloadFile) {
        this.environment = environment;
        this.convertXmlService = convertXmlService;
        this.encryptService = encryptService;
        this.mard14CallBack = mard14CallBack;
        this.fdMard14DownloadFile = fdMard14DownloadFile;
    }


    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson14> sendAll(@RequestBody @Valid SendMessage14 sendMessage) {

        fdResponseJson14 = new ResponseJson14();
        fdTbdKetQuaXuLy14 = new TbdKetQuaXuLy14();
        fdTbdKetQuaXuLy14.setFiProcessDate(new Date());
        fdTbdKetQuaXuLy14.setFiProcessor(sendMessage.getFiTaxCode());
        fdTbdKetQuaXuLy14.setFiNameOfRegistration(sendMessage.getFiUserName());
        fdTbdKetQuaXuLy14.setFiCreateDate(new Date());
        logger.info("SendMessage14: {}", sendMessage);
        try {

            TbdHoSo14 tbdHoSo14 = mard14CallBack.getTbdHoSo14(sendMessage.getFiIdHoSo()).getBody();
            Objects.requireNonNull(tbdHoSo14, "KHONG TIM THAY ID HO SO = " + sendMessage.getFiIdHoSo());
            tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
            Envelope envelopeSend = createEnvelope(tbdHoSo14, sendMessage);
            Objects.requireNonNull(envelopeSend, String.format("YEU CAU CUA BAN KHONG DUNG HANH DONG - %s", getAction(sendMessage.getFiAction())));
            if (sendMessage.isFiSign()) {
                fdResponseJson14.setData(convertXmlService.ObjectToXml(envelopeSend));
            } else {
                boolean isSuccess = send(envelopeSend, sendMessage.getFiXml(), "00", Mard14Constant.MARD1_PRO);
                if (isSuccess) {
                    tbdHoSo14.setFiSended(1);
                    tbdHoSo14 = mard14CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14).getBody();
                    fdResponseJson14.setStatus(HttpStatus.OK.value());
                    fdResponseJson14.setSuccess(true);
                    if (tbdHoSo14.getFiStatus().intValue() == 16 || tbdHoSo14.getFiStatus().intValue() == 17) {
                        fdTbdThanhToan14.setFiSended(1);
                        mard14CallBack.updateTbdThanhToan14(fdTbdThanhToan14.getFiId(), fdTbdThanhToan14);
                    }
                    fdTbdKetQuaXuLy14.setFiContent(fdTbdKetQuaXuLy14.getFiContent() + ". Yêu cầu của bạn đựoc chấp thuận");
                    fdTbdKetQuaXuLy14.setFiStatus(tbdHoSo14.getFiStatus());
                } else {
                    fdTbdKetQuaXuLy14.setFiContent(fdTbdKetQuaXuLy14.getFiContent() + ". Yêu cầu của bạn không đựoc chấp thuận");
                    fdTbdKetQuaXuLy14.setFiStatus(tbdHoSo14.getFiOldStatus());
                }
                fdTbdKetQuaXuLy14.setFiIdHoSo(tbdHoSo14.getFiIdHoSo());
                fdTbdKetQuaXuLy14.setFiDocumentType(tbdHoSo14.getFiDocumentType());
                fdTbdKetQuaXuLy14.setFiDocumentName(tbdHoSo14.getFiDocumentName());
                fdTbdKetQuaXuLy14 = mard14CallBack.createTbdKetQuaXuLy14(fdTbdKetQuaXuLy14).getBody();

            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            fdResponseJson14.setGatewayMessage(ex.getMessage() + " | " + ex.getLocalizedMessage());
            fdResponseJson14.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(fdResponseJson14, HttpStatus.OK);

    }

    private Envelope createEnvelope(TbdHoSo14 tbdHoSo14, SendMessage14 sendMessage14) {
        long idHoSo = tbdHoSo14.getFiIdHoSo().longValue();
        long trangThai = tbdHoSo14.getFiStatus().intValue();
        int action = sendMessage14.getFiAction().intValue();
        logger.info("Gui ho so: thu tuc = {} |  ID = {} | ma ho so = {} | trang thai = {} | action = {}", tbdHoSo14.getFiDocumentType(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiDocumentName(), tbdHoSo14.getFiStatus(), sendMessage14.getFiAction());

        Envelope envelope;
        TbdKetQuaXuLy14 tbdKetQuaXuLy14 = new TbdKetQuaXuLy14();
        tbdKetQuaXuLy14.setFiContent(sendMessage14.getFiReason());
        tbdKetQuaXuLy14.setFiProcessDate(new Date());
        switch (action) {
            case 1:
                //Gửi hồ sơ
                if (trangThai == 0) {
                    fdTbdKetQuaXuLy14.setFiContent("Gửi mới hồ sơ");
                    tbdHoSo14.setFiSendDate(new Date());
                    envelope = buildMessage(tbdHoSo14, "10", "01", 1);
                    return Mard14SendType10.send(envelope, tbdHoSo14, mard14CallBack.findByFiIdHoSoTbdThuoc14(idHoSo).getBody(), mard14CallBack.findByFiIdHoSoTbdDinhKem14(idHoSo).getBody(), fdMard14DownloadFile);
                }
                //Gửi sửa hồ sơ
                if (trangThai == 1) {
                    fdTbdKetQuaXuLy14.setFiContent("Gửi sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo14, "10", "02", 1);
                    return Mard14SendType10.send(envelope, tbdHoSo14, mard14CallBack.findByFiIdHoSoTbdThuoc14(idHoSo).getBody(), mard14CallBack.findByFiIdHoSoTbdDinhKem14(idHoSo).getBody(), fdMard14DownloadFile);
                }
                if (trangThai == 5) {
                    //sua doi bo sung 10-03
                    fdTbdKetQuaXuLy14.setFiContent("Gửi bổ sung hồ sơ theo yêu cầu của BNN(chưa xác nhận phí )");
                    envelope = buildMessage(tbdHoSo14, "10", "03", 6);
                    return Mard14SendType10.send(envelope, tbdHoSo14, mard14CallBack.findByFiIdHoSoTbdThuoc14(idHoSo).getBody(), mard14CallBack.findByFiIdHoSoTbdDinhKem14(idHoSo).getBody(), fdMard14DownloadFile);
                }
                if (trangThai == 7) {
                    //yeu cau sua doi bo sung 10-19
                    fdTbdKetQuaXuLy14.setFiContent("Gửi chỉnh sửa hs theo yêu cầu của BNN(đã xác nhận phí )");
                    envelope = buildMessage(tbdHoSo14, "10", "19", 8);
                    return Mard14SendType10.send(envelope, tbdHoSo14, mard14CallBack.findByFiIdHoSoTbdThuoc14(idHoSo).getBody(), mard14CallBack.findByFiIdHoSoTbdDinhKem14(idHoSo).getBody(), fdMard14DownloadFile);
                }
                break;

            case 2:
                //xin sua ho so
                if (trangThai == 3 || trangThai == 9 || trangThai == 11) {
                    //doanh nghiep xin sua ho so 13-08
                    fdTbdKetQuaXuLy14.setFiContent("DN xin sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo14, "13", "08", 9);
                    tbdKetQuaXuLy14.setFiContent(tbdHoSo14.getFiReasonCorrection());
                    return Mard14SendType13.send(envelope, tbdHoSo14, mard14CallBack.findByFiIdHoSoTbdThuoc14(idHoSo).getBody(), mard14CallBack.findByFiIdHoSoTbdDinhKem14(idHoSo).getBody(), tbdKetQuaXuLy14, fdMard14DownloadFile);
                }
                break;
            case 3:
                //xin rut ho so
                if (trangThai == 1 || trangThai == 5 || trangThai == 6) {
                    //xin rut ho so truoc tiep nhan 11-04
                    fdTbdKetQuaXuLy14.setFiContent("Gửi yêu cầu xin rút hồ sơ ( trước khi tiếp nhận )");
                    envelope = buildMessage(tbdHoSo14, "11", "04", 2);
                    return Mard14SendType11.send(envelope);
                }
                break;
            case 4:
                //thong bao app phi
                List<TbdThanhToan14> tbdThanhToan14s = mard14CallBack.findByFiIdHoSoTbdThanhToan14(idHoSo).getBody();
                Assert.notEmpty(tbdThanhToan14s, "KHONG TIM THAY THANH TOAN PHI");
                if (trangThai == 15) {
                    Optional<TbdThanhToan14> find = tbdThanhToan14s.stream().filter(p -> p.getFiSended() == 0).findFirst();
                    if (find.isPresent()) {
                        fdTbdKetQuaXuLy14.setFiContent("Thông báo đã thanh toán phí chuyển khoản");
                        envelope = buildMessage(tbdHoSo14, "18", "15", 16);
                        tbdThanhToan14s.sort(Comparator.comparing(TbdThanhToan14::getFiCreateDate).reversed());
                        fdTbdThanhToan14 = tbdThanhToan14s.get(0);
                        return Mard14SendType18.send(envelope, fdTbdThanhToan14, fdMard14DownloadFile);
                    }
                } else if (trangThai == 20) {
                    fdTbdKetQuaXuLy14.setFiContent("Thông báo đã thanh toán phí chuyển khoản bổ sung");
                    envelope = buildMessage(tbdHoSo14, "18", "17", 17);
                    tbdThanhToan14s.sort(Comparator.comparing(TbdThanhToan14::getFiCreateDate).reversed());
                    fdTbdThanhToan14 = tbdThanhToan14s.get(0);
                    return Mard14SendType18.send(envelope, fdTbdThanhToan14, fdMard14DownloadFile);
                }
                break;
        }

        return null;
    }


    private Envelope buildMessage(TbdHoSo14 tbdHoSo14, String type, String function, int status) {
        Envelope envelope = new Envelope();
        envelope.setHeader(createHeader(tbdHoSo14.getFiDocumentName(), tbdHoSo14.getFiDocumentType(), type, function));
        envelope.getHeader().getSubject().setType(type);
        envelope.getHeader().getSubject().setFunction(function);
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        tbdHoSo14.setFiStatus(status);

        return envelope;
    }


    /**
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private boolean send(Envelope envelopeSend, String signedXml, String msgType, String documentType) {
        Boolean isSuccess = false;
        String xml = "";
        if (signedXml == null || (signedXml != null && "".equals(signedXml))) {
            xml = convertXmlService.ObjectToXml(envelopeSend);
        } else {
            xml = signedXml;
        }
        String isEncrypt = environment.getProperty("ENCRYPT");
        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.encrypt(key, xml);
        }

        String logXml = xml;
        logXml = logXml.replaceAll("<FileByte>\\d*\\D*\\W*\\w*\\s*\\S*</FileByte>", "<FileByte>"+ Base64Utils.encodeToString("NOI DUNG FILE DA DUOC CAT".getBytes()) +"</FileByte>");
        logger.info("BAN TIN SEND RUT GON: {}", logXml);


        String url = environment.getRequiredProperty("GATEWAY_LINK");
        String nameSpace = environment.getRequiredProperty("GATEWAY_NAMESPACE");
        String nameSpaceKey = environment.getRequiredProperty("GATEWAY_NAMESPACE_KEY");
        String methodTag = environment.getRequiredProperty("GATEWAY_MOTHOD_TAG");
        String requestOfficeCode = environment.getRequiredProperty("GATEWAY_PAYLOAD_TAG_OFFICECODE");
        String requestDocumentType = environment.getRequiredProperty("GATEWAY_PAYLOAD_TAG_DOCUMENTTYPE");
        String requestPayload = environment.getRequiredProperty("GATEWAY_PAYLOAD_TAG_DATA");

        String responseStr = "";

        String officeCode = Mard14Constant.MARD;

        logger.info("CALL WEB SERVICE URL: {}", url);
        fdResponseJson14.setData(xml);
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
                    nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);

            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            soapConnection.close();

        } catch (Exception ex) {

            logger.error(ex.getMessage(), ex);

            fdResponseJson14.setException(ex.getMessage() + " | " + ex.getLocalizedMessage());
            if (ex instanceof SocketTimeoutException) {
                fdResponseJson14.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            } else if (ex instanceof SOAPException) {
                fdResponseJson14.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                fdResponseJson14.setStatus(HttpStatus.BAD_GATEWAY.value());
            }
            fdTbdKetQuaXuLy14.setFiContent(fdTbdKetQuaXuLy14.getFiContent() + ". Gửi hồ sơ không thành công. Không kết nối sang đựợc Bộ Nông Nghiệp!");
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, responseStr);
        } else {
            xml = responseStr;
        }
        xml = StringEscapeUtils.unescapeXml(xml);
        xml = StringEscapeUtils.unescapeHtml4(xml);
        final String envelopStartTag = "<Envelope>";
        final String envelopEndTag = "</Envelope>";
        int index = xml.indexOf(envelopStartTag);
        int end = xml.indexOf(envelopEndTag);
        if (index != -1 && end != -1) {
            xml = xml.substring(index, end + envelopEndTag.length());
            fdResponseJson14.setGatewayMessage(xml);
            xml = xml.replace("&", "&amp;");
            Envelope envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope.class);
            String errorMessage = String.format("BAN TIN TRA VE KHONG CO HOAC KHONG HOP LE HOAC CO CHUA KY TU DAC BIET: %s", xml);
            Objects.requireNonNull(envelopeReturn, errorMessage);
            Objects.requireNonNull(envelopeReturn.getHeader(), errorMessage);
            Objects.requireNonNull(envelopeReturn.getHeader().getSubject(), errorMessage);
            Objects.requireNonNull(envelopeReturn.getHeader().getSubject().getFunction(), errorMessage);
            Objects.requireNonNull(envelopeReturn, errorMessage);
            isSuccess = checkTypeReturn(envelopeReturn);
        } else {
            fdResponseJson14.setGatewayMessage("KHONG CO BAN TIN TRA VE HOAC KHONG DUNG");
        }


        logger.info("KET QUA GUI HO SO: {}", isSuccess);
        return isSuccess;
    }

    /**
     * Kiểm tra bản tin trả về
     *
     * @param envelopeReturn
     * @return
     */
    private boolean checkTypeReturn(Envelope envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null
                && Mard14Constant.FUNCTION_99.equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

    public Header createHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header hd = new Header();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        hd.setReference(new Reference(Mard14Constant.SEND_VERSION, uuid.toString()));

        hd.setFrom(new From(Mard14Constant.FROM_NAME, Mard14Constant.FROM_IDENTITY, Mard14Constant.FROM_COUNTRY_CODE,
                Mard14Constant.FROM_MINISTRY_CODE, Mard14Constant.FROM_ORAGANIZATION_CODE, Mard14Constant.FROM_UNIT_CODE));
        hd.setTo(new From(Mard14Constant.TO_NAME, Mard14Constant.TO_IDENTITY, Mard14Constant.TO_COUNTRY_CODE,
                Mard14Constant.TO_MINISTRY_CODE, Mard14Constant.TO_ORAGANIZATION_CODE, Mard14Constant.TO_UNIT_CODE));
        hd.setSubject(new Subject(documentType, msgType, msgFunc, fiMaHoSo,
                getFormatDate("yyyy", now), getFormatDate("yyyy-MM-dd HH:mm:ss", now), fiMaHoSo));
        return hd;
    }
    private String getFormatDate(String pattern, Date date) {
        if (date == null) return "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    private String getAction(int action) {
        String message = "KHÔNG TÌM THẤY QUY TRÌNH XỬ LÝ NGHIỆP VỤ VÓI HÀNH ĐỘNG ";
        switch (action) {
            case 1: return message + "SỬA HỒ SƠ";
            case 2: return message + "XIN SỬA HỒ SƠ";
            case 3: return message + "XIN RÚT HỒ SƠ";
            case 4: return message + "XIN SỬA GIẤY PHÉP";
            default: return message;
        }
    }

}
