package com.vnsw.ws.p16.controller;

import com.vnsw.ws.common.envelop.*;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p16.component.Mard16CallBack;
import com.vnsw.ws.p16.component.Mard16DownloadFile;
import com.vnsw.ws.p16.constant.Mard16Constant;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.*;
import com.vnsw.ws.p16.model.ResponseJson16;
import com.vnsw.ws.p16.model.SendMessage16;
import com.vnsw.ws.p16.model.TbdHoSo16;
import com.vnsw.ws.p16.model.TbdKetQuaXuLy16;
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
@RequestMapping("/send/16")
public class Send16Controller {

    public static final Logger logger = LoggerFactory.getLogger(Send16Controller.class);


    private final Environment environment;

    private final EnvelopXmlService convertXmlService;

    private final EncryptService encryptService;

    private final Mard16CallBack mard16CallBack;

    private final Mard16DownloadFile fdMard16DownloadFile;

    private ResponseJson16 fdResponseJson16;

    private TbdKetQuaXuLy16 fdTbdKetQuaXuLy16;

    @Autowired
    public Send16Controller(Environment environment, EnvelopXmlService convertXmlService, EncryptService encryptService, Mard16CallBack mard16CallBack, Mard16DownloadFile fdMard16DownloadFile) {
        this.environment = environment;
        this.convertXmlService = convertXmlService;
        this.encryptService = encryptService;
        this.mard16CallBack = mard16CallBack;
        this.fdMard16DownloadFile = fdMard16DownloadFile;
    }


    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson16> sendAll(@RequestBody @Valid SendMessage16 sendMessage) {

        fdResponseJson16 = new ResponseJson16();
        fdTbdKetQuaXuLy16 = new TbdKetQuaXuLy16();
        fdTbdKetQuaXuLy16.setFiProcessDate(new Date());
        fdTbdKetQuaXuLy16.setFiProcessor(sendMessage.getFiTaxCode());
        fdTbdKetQuaXuLy16.setFiNameOfRegistration(sendMessage.getFiUserName());
        fdTbdKetQuaXuLy16.setFiCreateDate(new Date());
        logger.info("SendMessage16: {}", sendMessage);
        try {

            TbdHoSo16 tbdHoSo16 = mard16CallBack.getTbdHoSo16(sendMessage.getFiIdHoSo()).getBody();
            Objects.requireNonNull(tbdHoSo16, "KHONG TIM THAY ID HO SO = " + sendMessage.getFiIdHoSo());
            tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
            Envelope envelopeSend = createEnvelope(tbdHoSo16, sendMessage);

            Objects.requireNonNull(envelopeSend, String.format("YEU CAU CUA BAN KHONG DUNG HANH DONG - %s", getAction(sendMessage.getFiAction())));
            if (sendMessage.isFiSign()) {
                fdResponseJson16.setData(convertXmlService.ObjectToXml(envelopeSend));
            } else {
                boolean isSuccess = send(envelopeSend, sendMessage.getFiXml(), "00", Mard16Constant.MARD1_PRO);
                if (isSuccess) {
                    tbdHoSo16.setFiSended(1);
                    tbdHoSo16 = mard16CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16).getBody();
                    System.out.println(tbdHoSo16.toString());
                    fdResponseJson16.setStatus(HttpStatus.OK.value());
                    fdResponseJson16.setSuccess(true);
                    fdTbdKetQuaXuLy16.setFiContent(fdTbdKetQuaXuLy16.getFiContent() + ". Yêu cầu của bạn đựoc chấp thuận");
                    fdTbdKetQuaXuLy16.setFiStatus(tbdHoSo16.getFiStatus());
                } else {
                    fdTbdKetQuaXuLy16.setFiContent(fdTbdKetQuaXuLy16.getFiContent() + ". Yêu cầu của bạn không đựoc chấp thuận");
                    fdTbdKetQuaXuLy16.setFiStatus(tbdHoSo16.getFiOldStatus());
                }

                fdTbdKetQuaXuLy16.setFiIdHoSo(tbdHoSo16.getFiIdHoSo());
                fdTbdKetQuaXuLy16.setFiDocumentType(tbdHoSo16.getFiDocumentType());
                fdTbdKetQuaXuLy16.setFiDocumentName(tbdHoSo16.getFiDocumentName());
                fdTbdKetQuaXuLy16 = mard16CallBack.createTbdKetQuaXuLy16(fdTbdKetQuaXuLy16).getBody();

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            fdResponseJson16.setGatewayMessage(ex.getMessage() + " | " + ex.getLocalizedMessage());
            fdResponseJson16.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(fdResponseJson16, HttpStatus.OK);

    }

    private Envelope createEnvelope(TbdHoSo16 tbdHoSo16, SendMessage16 sendMessage16) {
        long idHoSo = tbdHoSo16.getFiIdHoSo().longValue();
        long trangThai = tbdHoSo16.getFiStatus().intValue();
        int action = sendMessage16.getFiAction().intValue();
        logger.info("Gui ho so: thu tuc = {} |  ID = {} | ma ho so = {} | trang thai = {} | action = {}", tbdHoSo16.getFiDocumentType(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiDocumentName(), tbdHoSo16.getFiStatus(), sendMessage16.getFiAction());

        Envelope envelope;
        TbdKetQuaXuLy16 tbdKetQuaXuLy16 = new TbdKetQuaXuLy16();
        tbdKetQuaXuLy16.setFiContent(sendMessage16.getFiReason());
        tbdKetQuaXuLy16.setFiProcessDate(new Date());
        System.out.println("action:"+action);

        switch (action) {
            case 1:
                //Gửi hồ sơ
                if (trangThai == 0) {
                    fdTbdKetQuaXuLy16.setFiContent("Gửi mới hồ sơ");
                    tbdHoSo16.setFiSendDate(new Date());
                    envelope = buildMessage(tbdHoSo16, "10", "01", 1);
                    return Mard16SendType10.sendType10(envelope, tbdHoSo16, mard16CallBack.findByFiIdHoSoTbdThuoc16(idHoSo).getBody(), mard16CallBack.findByFiIdHoSoTbdDinhKem16(idHoSo).getBody(), fdMard16DownloadFile, mard16CallBack.findByFiIdHoSoTbdToKhaiKyThuat16(idHoSo).getBody());
                }
                //Gửi sửa hồ sơ
                if (trangThai == 1) {
                    fdTbdKetQuaXuLy16.setFiContent("Gửi sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo16, "10", "02", 1);
                    return Mard16SendType10.sendType10(envelope, tbdHoSo16, mard16CallBack.findByFiIdHoSoTbdThuoc16(idHoSo).getBody(), mard16CallBack.findByFiIdHoSoTbdDinhKem16(idHoSo).getBody(), fdMard16DownloadFile,  mard16CallBack.findByFiIdHoSoTbdToKhaiKyThuat16(idHoSo).getBody());
                }
                if (trangThai == 5 || trangThai == 6) {
                    //sua doi bo sung 10-03
                    fdTbdKetQuaXuLy16.setFiContent("Gửi bổ sung hồ sơ theo yêu cầu của BNN");
                    envelope = buildMessage(tbdHoSo16, "10", "03", 6);
                    return Mard16SendType10.sendType10(envelope, tbdHoSo16, mard16CallBack.findByFiIdHoSoTbdThuoc16(idHoSo).getBody(), mard16CallBack.findByFiIdHoSoTbdDinhKem16(idHoSo).getBody(), fdMard16DownloadFile, mard16CallBack.findByFiIdHoSoTbdToKhaiKyThuat16(idHoSo).getBody());
                }

                break;

            case 2:
                //xin sua ho so
                if (trangThai == 3 || trangThai == 7 || trangThai == 8 || trangThai == 9) {
                    //doanh nghiep xin sua ho so 13-08
                    fdTbdKetQuaXuLy16.setFiContent("DN xin sửa hồ sơ");
                    envelope = buildMessage(tbdHoSo16, "13", "08", 7);
                    tbdKetQuaXuLy16.setFiContent(tbdHoSo16.getFiReasonCorrection());
                    return Mard16SendType13.send13(envelope, tbdHoSo16, mard16CallBack.findByFiIdHoSoTbdThuoc16(idHoSo).getBody(), mard16CallBack.findByFiIdHoSoTbdDinhKem16(idHoSo).getBody(), tbdKetQuaXuLy16, fdMard16DownloadFile,  mard16CallBack.findByFiIdHoSoTbdToKhaiKyThuat16(idHoSo).getBody());
                }
                break;
            case 3:
                //xin rut ho so
                if (trangThai == 1 || trangThai == 5 || trangThai == 6) {
                    //xin rut ho so truoc tiep nhan 11-04
                    fdTbdKetQuaXuLy16.setFiContent("Gửi yêu cầu xin rút hồ sơ ( trước khi tiếp nhận )");
                    envelope = buildMessage(tbdHoSo16, "11", "04", 2);
                    return Mard16SendType11.send(envelope);
                }
                if (trangThai == 3 || trangThai == 7 || trangThai == 8 || trangThai == 9 ) {
                    //yeu cau xin rut ho so sau tiep nhan 16-11
                    fdTbdKetQuaXuLy16.setFiContent("Gửi yêu cầu xin rút hồ sơ ( sau khi tiếp nhận )");
                    envelope = buildMessage(tbdHoSo16, "15", "11", 10);
                    return Mard16SendType15.send(envelope, tbdKetQuaXuLy16);
                }
                break;
            case 4:
                //xin sua giay phep
                if (trangThai == 13) {
                    //xin rut ho so truoc tiep nhan 11-04
                    fdTbdKetQuaXuLy16.setFiContent("DN gửi yêu cầu xin chỉnh sửa thông tin GP");
                    envelope = buildMessage(tbdHoSo16, "18", "15", 15);
                    fdTbdKetQuaXuLy16.setFiProcessDate(new Date());
                    return Mard16SendType18.send(envelope, tbdKetQuaXuLy16);
                }
                break;
        }

        return null;
    }


    private Envelope buildMessage(TbdHoSo16 tbdHoSo16, String type, String function, int status) {
        Envelope envelope = new Envelope();
        envelope.setHeader(createHeader(tbdHoSo16.getFiDocumentName(), tbdHoSo16.getFiDocumentType(), type, function));
        envelope.getHeader().getSubject().setType(type);
        envelope.getHeader().getSubject().setFunction(function);
        tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
        tbdHoSo16.setFiStatus(status);

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

        String officeCode = Mard16Constant.MARD;

        logger.info("CALL WEBSERVICE URL: {}", url);
        fdResponseJson16.setData(xml);
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
            fdResponseJson16.setException(ex.getMessage() + " | " + ex.getLocalizedMessage());

            if (ex instanceof SocketTimeoutException) {
                fdResponseJson16.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            } else if (ex instanceof SOAPException) {
                fdResponseJson16.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                fdResponseJson16.setStatus(HttpStatus.BAD_GATEWAY.value());
            }
            fdTbdKetQuaXuLy16.setFiContent(fdTbdKetQuaXuLy16.getFiContent() + ". Gửi hồ sơ không thành công. Không kết nối sang đựợc Bộ Nông Nghiệp!");
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
            fdResponseJson16.setGatewayMessage(xml);
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
            fdResponseJson16.setGatewayMessage("KHONG CO BAN TIN TRA VE HOAC KHONG DUNG");
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
                && Mard16Constant.FUNCTION_99.equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

    public Header createHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header hd = new Header();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        hd.setReference(new Reference(Mard16Constant.SEND_VERSION, uuid.toString()));

        hd.setFrom(new From(Mard16Constant.FROM_NAME, Mard16Constant.FROM_IDENTITY, Mard16Constant.FROM_COUNTRY_CODE,
                Mard16Constant.FROM_MINISTRY_CODE, Mard16Constant.FROM_ORAGANIZATION_CODE, Mard16Constant.FROM_UNIT_CODE));
        hd.setTo(new From(Mard16Constant.TO_NAME, Mard16Constant.TO_IDENTITY, Mard16Constant.TO_COUNTRY_CODE,
                Mard16Constant.TO_MINISTRY_CODE, Mard16Constant.TO_ORAGANIZATION_CODE, Mard16Constant.TO_UNIT_CODE));
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
