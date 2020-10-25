package com.vnsw.ws.endpoint;

/**
 * Tiếp nhận bản tin gửi từ BNN Phân tích bản tin và gửi vào các thủ tục tương
 * ứng
 */
import com.vnsw.ws.common.envelop.Envelope;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.EnvelopeService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.generated.ReceiveRequest;
import com.vnsw.ws.generated.ReceiveResponse;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p04.service.ReceiveService04;
import com.vnsw.ws.p1.evelop.Envelope01;
import com.vnsw.ws.p1.service.ReceiveService01;
import com.vnsw.ws.p10.envelop.Envelope10;
import com.vnsw.ws.p10.service.EnvelopXmlService10;
import com.vnsw.ws.p10.service.ReceiveService10;
import com.vnsw.ws.p11.envelop.Envelope11;
import com.vnsw.ws.p11.service.EnvelopXmlService11;
import com.vnsw.ws.p11.service.ReceiveService11;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.p12.service.ReceiveService12;
import com.vnsw.ws.p14.constant.Mard14Constant;
import com.vnsw.ws.p14.service.ReceiveService14;
import com.vnsw.ws.p15.constant.Mard15Constant;
import com.vnsw.ws.p15.service.ReceiveService15;
import com.vnsw.ws.p16.constant.Mard16Constant;
import com.vnsw.ws.p16.service.ReceiveService16;
import com.vnsw.ws.p25.service.ReceiveService25;
import com.vnsw.ws.p6.envelop.Envelope06;
import com.vnsw.ws.p6.service.ReceiveService06;
import com.vnsw.ws.p7.evelope.Envelope07;
import com.vnsw.ws.p7.service.ReceiveService07;
import com.vnsw.ws.p8.evelop.Envelope08;
import com.vnsw.ws.p8.service.EnvelopXmlService08;
import com.vnsw.ws.p8.service.ReceiveService08;
import com.vnsw.ws.p9.envelop.Envelope09;
import com.vnsw.ws.p9.service.ReceiveService09;
import com.vnsw.ws.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//http://localhost:8080/MARDWs/ws/mard.wsdl
@Endpoint
public class ReceiveEndpoint {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveEndpoint.class);
    private static final String NAMESPACE_URI = "http://com/vnsw/ws/generated";
    private static final String CLASS_NAME = "ReceiveEndpoint";

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    private EnvelopXmlService10 convertXmlService10;

    @Autowired
    private EnvelopXmlService11 convertXmlService11;

    @Autowired
    private EnvelopXmlService08 convertXmlService08;

    @Autowired
    private Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    private ReceiveService01 receiveService01;

    @Autowired
    private ReceiveService07 receiveService07;

    @Autowired
    private ReceiveService06 receiveService06;

    @Autowired
    private ReceiveService08 receiveService08;

    @Autowired
    private ReceiveService09 receiveService09;

    @Autowired
    private ReceiveService10 receiveService10;

    @Autowired
    private ReceiveService11 receiveService11;

    @Autowired
    private ReceiveService12 receiveService12;

    @Autowired
    private ReceiveService14 receiveService14;
    
    @Autowired
    private ReceiveService15 receiveService15;
     
    @Autowired
    private ReceiveService16 receiveService16;

    @Autowired
    private ReceiveService04 receiveEndpoint04;
    @Autowired
    private ReceiveService25 receiveEndpoint25;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "receiveRequest")
    @ResponsePayload
    public ReceiveResponse receive(@RequestPayload ReceiveRequest request) {
        ReceiveResponse res = new ReceiveResponse();
        Error error;
        String xml = request.getRequestPayload();
        String xmlReturn = "";
        String isEncrypt = environment.getProperty("ENCRYPT");
        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, xml);
        }
        try {
            String documentType = envelopeService.getDocumentType(xml);
            String msgType = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/type");
            String reference = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/reference");
            if (documentType != null) {
                switch (documentType) {
                    case Constants.MARD_PRO.MARD01:
                        Envelope01 envl01 = receiveService01.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl01);
                        break;
                    case Constants.MARD_PRO.MARD06:
                        Envelope06 envl06 = receiveService06.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl06);
                        break;

                    case Constants.MARD_PRO.MARD07:
                        Envelope07 envl07 = receiveService07.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl07);
                        break;
                    case Constants.MARD_PRO.MARD08: // Thu tuc QUY TRÌNH CẤP GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT TRÊN CẠN NHẬP KHẨU
                        Envelope08 envl08 = receiveService08.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl08);
                        break;
                    case Constants.MARD_PRO.MARD09: // Thu tuc QUY TRÌNH CẤP GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT TRÊN CẠN NHẬP KHẨU
                        Envelope09 envl09 = receiveService09.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl09);
                        break;
                    case Constants.MARD_PRO.MARD10: // Thu tuc QUY TRÌNH CẤP GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT TRÊN CẠN NHẬP KHẨU
                        Envelope10 envl10 = receiveService10.receive(xml);
                        xmlReturn = convertXmlService10.ObjectToXml(envl10);
                        break;
                    case Constants.MARD_PRO.MARD11: // Thu tuc Quy trình cấp giấy chứng nhận kiểm dịch thực vật xuất khẩu, tái xuất khẩu
                        Envelope11 envl11 = receiveService11.receive(xml);
                        xmlReturn = convertXmlService11.ObjectToXml(envl11);
                        break;
                    case Constants.MARD_PRO.MARD12_01: // Mien kiem
                    case Constants.MARD_PRO.MARD12_02: // Giam kiem
                        Envelope12 envl12 = receiveService12.receive(xml);
                        xmlReturn = convertXmlService11.ObjectToXml(envl12);
                        break;
                    case Mard14Constant.MARD1_PRO:
                        com.vnsw.ws.p14.envelop.Envelope envelope14 = receiveService14.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envelope14);
                         break;
                    case Mard15Constant.MARD1_PRO:
                        com.vnsw.ws.p15.envelop.Envelope envelope15 = receiveService15.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envelope15);;
                         break;
                    case Mard16Constant.MARD1_PRO:
                        com.vnsw.ws.p16.envelop.Envelope envelope16 = receiveService16.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envelope16);
                         break;
				    case Constants.BNNPTNT_PRO.BNNPTNT04:
                        com.vnsw.ws.p04.envelop.Envelope env2 = receiveEndpoint04.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(env2);
                        break;

                    case Constants.MARD_PRO.MARD25:
                        com.vnsw.ws.p25.envelop.Envelope25 env25 = receiveEndpoint25.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(env25);
                        break;
                    default:
                        error = envelopeService.createError(Constants.ERROR.ERR01_CODE, Constants.ERROR.ERR01);
                        Envelope env = envelopeService.createEnvelopeError(reference, documentType, msgType, error);
                        xmlReturn = convertXmlService.ObjectToXml(env);
                        break;
                }
            } else {
                error = envelopeService.createError(Constants.ERROR.ERR02_CODE, Constants.ERROR.ERR02);
                Envelope envl = envelopeService.createEnvelopeError(reference, "", msgType, error);
                xmlReturn = convertXmlService.ObjectToXml(envl);
            }
        } catch (Exception ex) {
            error = envelopeService.createError(Constants.ERROR.ERR03_CODE, Constants.ERROR.ERR03, ex);
            Envelope envl = envelopeService.createEnvelopeError("00", "", "00", error);
            xmlReturn = convertXmlService.ObjectToXml(envl);

            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xmlReturn = encryptService.encrypt(key, xmlReturn);
        }
        res.setResponsePayload(xmlReturn);
        logger.info("Response to BNN: " + xmlReturn);
        return res;
    }

}
