package com.vnsw.ws.p15.controller;

import com.vnsw.ws.common.envelop.*;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p15.component.Mard15CallBack;
import com.vnsw.ws.p15.component.Mard15DownloadFile;
import com.vnsw.ws.p15.constant.Mard15Constant;
import com.vnsw.ws.p15.envelop.Envelope;
import com.vnsw.ws.p15.message.*;
import com.vnsw.ws.p15.model.ResponseJson15;
import com.vnsw.ws.p15.model.SendMessage15;
import com.vnsw.ws.p15.model.TbdHoSo15;
import com.vnsw.ws.p15.model.TbdKetQuaXuLy15;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;
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
@RequestMapping("/send/15")
public class Send15Controller {

    public static final Logger logger = LoggerFactory.getLogger(Send15Controller.class);


    private final Environment environment;

    private final EnvelopXmlService convertXmlService;

    private final EncryptService encryptService;

    private final Mard15CallBack mard15CallBack;

    private final Mard15DownloadFile fdMard15DownloadFile;

    private ResponseJson15 fdResponseJson15;

    private TbdKetQuaXuLy15 fdTbdKetQuaXuLy15;

    @Autowired
    public Send15Controller(Environment environment, EnvelopXmlService convertXmlService, EncryptService encryptService, Mard15CallBack mard15CallBack, Mard15DownloadFile fdMard15DownloadFile) {
        this.environment = environment;
        this.convertXmlService = convertXmlService;
        this.encryptService = encryptService;
        this.mard15CallBack = mard15CallBack;
        this.fdMard15DownloadFile = fdMard15DownloadFile;
    }


    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson15> sendAll(@RequestBody @Valid SendMessage15 sendMessage) {

        fdResponseJson15 = new ResponseJson15();
        fdTbdKetQuaXuLy15 = new TbdKetQuaXuLy15();
        fdTbdKetQuaXuLy15.setFiProcessDate(new Date());
        fdTbdKetQuaXuLy15.setFiProcessor(sendMessage.getFiTaxCode());
        fdTbdKetQuaXuLy15.setFiNameOfRegistration(sendMessage.getFiUserName());
        fdTbdKetQuaXuLy15.setFiCreateDate(new Date());
        logger.info("SendMessage15: {}", sendMessage);
        try {

            TbdHoSo15 tbdHoSo15 = mard15CallBack.getTbdHoSo15(sendMessage.getFiIdHoSo()).getBody();
            Objects.requireNonNull(tbdHoSo15, "KHONG TIM THAY ID HO SO = " + sendMessage.getFiIdHoSo());
            tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
            Envelope envelopeSend = createEnvelope(tbdHoSo15, sendMessage);
            Objects.requireNonNull(envelopeSend, String.format("YEU CAU CUA BAN KHONG DUNG HANH DONG - %s", getAction(sendMessage.getFiAction())));
            if (sendMessage.isFiSign()) {
                fdResponseJson15.setData(convertXmlService.ObjectToXml(envelopeSend));
            } else {
                boolean isSuccess = send(envelopeSend, sendMessage.getFiXml(), "00", Mard15Constant.MARD1_PRO);
                if (isSuccess) {
                    tbdHoSo15.setFiSended(1);
                    tbdHoSo15 = mard15CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15).getBody();
                    fdResponseJson15.setStatus(HttpStatus.OK.value());
                    fdResponseJson15.setSuccess(true);
                    fdTbdKetQuaXuLy15.setFiContent(fdTbdKetQuaXuLy15.getFiContent() + ". Yêu cầu của bạn đựoc chấp thuận");
                    fdTbdKetQuaXuLy15.setFiStatus(tbdHoSo15.getFiStatus());
                } else {
                    fdTbdKetQuaXuLy15.setFiContent(fdTbdKetQuaXuLy15.getFiContent() + ". Yêu cầu của bạn không đựoc chấp thuận");
                    fdTbdKetQuaXuLy15.setFiStatus(tbdHoSo15.getFiOldStatus());
                }

                fdTbdKetQuaXuLy15.setFiIdHoSo(tbdHoSo15.getFiIdHoSo());
                fdTbdKetQuaXuLy15.setFiDocumentType(tbdHoSo15.getFiDocumentType());
                fdTbdKetQuaXuLy15.setFiDocumentName(tbdHoSo15.getFiDocumentName());
                fdTbdKetQuaXuLy15 = mard15CallBack.createTbdKetQuaXuLy15(fdTbdKetQuaXuLy15).getBody();
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            fdResponseJson15.setGatewayMessage(ex.getMessage() + " | " + ex.getLocalizedMessage());
            fdResponseJson15.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(fdResponseJson15, HttpStatus.OK);

    }

    private Envelope createEnvelope(TbdHoSo15 tbdHoSo15, SendMessage15 sendMessage15) {
        long idHoSo = tbdHoSo15.getFiIdHoSo().longValue();
        long trangThai = tbdHoSo15.getFiStatus().intValue();
        int action = sendMessage15.getFiAction().intValue();
        logger.info("Gui ho so: thu tuc = {} |  ID = {} | ma ho so = {} | trang thai = {} | action = {}", tbdHoSo15.getFiDocumentType(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiDocumentName(), tbdHoSo15.getFiStatus(), sendMessage15.getFiAction());

        Envelope envelope;
        TbdKetQuaXuLy15 tbdKetQuaXuLy15 = new TbdKetQuaXuLy15();
        tbdKetQuaXuLy15.setFiContent(sendMessage15.getFiReason());
        tbdKetQuaXuLy15.setFiProcessDate(new Date());
        switch (action) {
            case 1:
                //Gửi hồ sơ
                if (trangThai == 0) {
                    fdTbdKetQuaXuLy15.setFiContent("Gửi mới hồ sơ");
                    tbdHoSo15.setFiSendDate(new Date());
                    envelope = buildMessage(tbdHoSo15, "10", "01", 1);
                    return Mard15SendType10.send(envelope, tbdHoSo15, mard15CallBack.findByFiIdHoSoTbdThuoc15(idHoSo).getBody(), mard15CallBack.findByFiIdHoSoTbdDinhKem15(idHoSo).getBody(), fdMard15DownloadFile);
                }
                //Gửi sửa hồ sơ
                if (trangThai == 1) {
                    fdTbdKetQuaXuLy15.setFiContent("Gửi sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo15, "10", "02", 1);
                    return Mard15SendType10.send(envelope, tbdHoSo15, mard15CallBack.findByFiIdHoSoTbdThuoc15(idHoSo).getBody(), mard15CallBack.findByFiIdHoSoTbdDinhKem15(idHoSo).getBody(), fdMard15DownloadFile);
                }
                if (trangThai == 5 || trangThai == 6) {
                    //sua doi bo sung 10-03
                    fdTbdKetQuaXuLy15.setFiContent("Gửi bổ sung hồ sơ theo yêu cầu của BNN");
                    envelope = buildMessage(tbdHoSo15, "10", "03", 6);
                    return Mard15SendType10.send(envelope, tbdHoSo15, mard15CallBack.findByFiIdHoSoTbdThuoc15(idHoSo).getBody(), mard15CallBack.findByFiIdHoSoTbdDinhKem15(idHoSo).getBody(), fdMard15DownloadFile);
                }

                break;

            case 2:
                //xin sua ho so
                if (trangThai == 3 || trangThai == 7 || trangThai == 8 || trangThai == 9) {
                    //doanh nghiep xin sua ho so 13-08
                    fdTbdKetQuaXuLy15.setFiContent("DN xin sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo15, "13", "08", 7);
                    tbdKetQuaXuLy15.setFiContent(tbdHoSo15.getFiReasonCorrection());
                    return Mard15SendType13.send(envelope, tbdHoSo15, mard15CallBack.findByFiIdHoSoTbdThuoc15(idHoSo).getBody(), mard15CallBack.findByFiIdHoSoTbdDinhKem15(idHoSo).getBody(), tbdKetQuaXuLy15, fdMard15DownloadFile);
                }
                break;
            case 3:
                //xin rut ho so
                if (trangThai == 1 || trangThai == 5 || trangThai == 6) {
                    //xin rut ho so truoc tiep nhan 11-04
                    fdTbdKetQuaXuLy15.setFiContent("Gửi yêu cầu xin rút hồ sơ ( trước khi tiếp nhận )");
                    envelope = buildMessage(tbdHoSo15, "11", "04", 2);
                    return Mard15SendType11.send(envelope);
                }
                if (trangThai == 3 || trangThai == 7 || trangThai == 8 || trangThai == 9) {
                    //yeu cau xin rut ho so sau tiep nhan 15-11
                    fdTbdKetQuaXuLy15.setFiContent("Gửi yêu cầu xin rút hồ sơ ( sau khi tiếp nhận )");
                    envelope = buildMessage(tbdHoSo15, "15", "11", 10);

                    return Mard15SendType15.send(envelope, tbdKetQuaXuLy15);
                }
                break;
            case 4:
                //xin sua giay phep
                if (trangThai == 13) {
                    //xin rut ho so truoc tiep nhan 11-04
                    fdTbdKetQuaXuLy15.setFiContent("DN gửi yêu cầu xin chỉnh sửa thông tin GP");
                    envelope = buildMessage(tbdHoSo15, "18", "15", 15);
                    fdTbdKetQuaXuLy15.setFiProcessDate(new Date());
                    return Mard15SendType18.send(envelope, tbdKetQuaXuLy15);
                }
                break;
        }

        return null;
    }


    private Envelope buildMessage(TbdHoSo15 tbdHoSo15, String type, String function, int status) {
        Envelope envelope = new Envelope();
        envelope.setHeader(createHeader(tbdHoSo15.getFiDocumentName(), tbdHoSo15.getFiDocumentType(), type, function));
        envelope.getHeader().getSubject().setType(type);
        envelope.getHeader().getSubject().setFunction(function);
        tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
        tbdHoSo15.setFiStatus(status);

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

        String officeCode = Mard15Constant.MARD;

        logger.info("CALL WEBSERVICE URL: {}", url);
        fdResponseJson15.setData(xml);
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
            fdResponseJson15.setException(ex.getMessage() + " | " + ex.getLocalizedMessage());

            if (ex instanceof SocketTimeoutException) {
                fdResponseJson15.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            } else if (ex instanceof SOAPException) {
                fdResponseJson15.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                fdResponseJson15.setStatus(HttpStatus.BAD_GATEWAY.value());
            }
            fdTbdKetQuaXuLy15.setFiContent(fdTbdKetQuaXuLy15.getFiContent() + ". Gửi hồ sơ không thành công. Không kết nối sang đựợc Bộ Nông Nghiệp!");
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
            fdResponseJson15.setGatewayMessage(xml);
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
            fdResponseJson15.setGatewayMessage("KHONG CO BAN TIN TRA VE HOAC KHONG DUNG");
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
                && Mard15Constant.FUNCTION_99.equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

    public Header createHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header hd = new Header();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        hd.setReference(new Reference(Mard15Constant.SEND_VERSION, uuid.toString()));

        hd.setFrom(new From(Mard15Constant.FROM_NAME, Mard15Constant.FROM_IDENTITY, Mard15Constant.FROM_COUNTRY_CODE,
                Mard15Constant.FROM_MINISTRY_CODE, Mard15Constant.FROM_ORAGANIZATION_CODE, Mard15Constant.FROM_UNIT_CODE));
        hd.setTo(new From(Mard15Constant.TO_NAME, Mard15Constant.TO_IDENTITY, Mard15Constant.TO_COUNTRY_CODE,
                Mard15Constant.TO_MINISTRY_CODE, Mard15Constant.TO_ORAGANIZATION_CODE, Mard15Constant.TO_UNIT_CODE));
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
