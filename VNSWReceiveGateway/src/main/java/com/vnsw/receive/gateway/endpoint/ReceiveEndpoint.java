package com.vnsw.receive.gateway.endpoint;

/**
 * Tiếp nhận bản tin từ các bộ ngành gửi tới hải quan Lưu log message Chuyển
 * tiếp đến các service xử lý nội bộ Đợi và trả về kết quả
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.vnsw.receive.gateway.common.bo.Envelope;
import com.vnsw.receive.gateway.common.bo.Error;
import com.vnsw.receive.gateway.common.service.EnvelopXmlService;
import com.vnsw.receive.gateway.common.service.EnvelopeService;
import com.vnsw.receive.gateway.common.service.RabbitMQService;
import com.vnsw.receive.gateway.generated.ReceiveRequest;
import com.vnsw.receive.gateway.generated.ReceiveResponse;
import com.vnsw.receive.gateway.helper.RabbitMQErrorHelper;
import com.vnsw.receive.gateway.helper.RabbitMQInfo;
import com.vnsw.receive.gateway.helper.RabbitMQLogHelper;
import com.vnsw.receive.gateway.helper.SoapHelper;
import com.vnsw.receive.gateway.util.Constants;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Endpoint
public class ReceiveEndpoint {
    public static final Logger logger = LoggerFactory.getLogger(ReceiveEndpoint.class);
    
    private static final String CLASS_NAME = "ReceiveEndpoint";

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    private Environment environment;
    
    @Autowired
    private EnvelopXmlService xmlService;
    
    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Dau vao cua Endpoint, nhan message
     *
     * @param request
     * @return
     * @since 2017-05-24
     */
    @PayloadRoot(namespace = Constants.LOCAL_WEBSERVICE.NAMESPACE_URI,
            localPart = Constants.LOCAL_WEBSERVICE.COMMON_METHOD_TAG)
    @ResponsePayload
    public ReceiveResponse receive(@RequestPayload ReceiveRequest request)  {
        ReceiveResponse res = new ReceiveResponse();
        Envelope envl;
        Error error;
        String xml = request.getRequestPayload();
        String documentType = request.getDocumentType();
        String officeCode = request.getOfficeCode();
        String returnPayLoad;
        RabbitMQInfo mqLogInfo = rabbitMQService.getRabbitMQLogInfo();
        RabbitMQInfo mqErrInfo = rabbitMQService.getRabbitMQErrorInfo();
        logger.info("Message Den: " + xml);
        //logger.info("RabbitLogInfo: " + mqLogInfo.toString());
        // PhongNV9. Khi nhan duoc message boc tach va goi den Cac Service thanh phan tuong ung
        // Goi thu den service tren con 16  su dung SAAJ 
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            //Send SOAP Message to SOAP Server
            String url = environment.getProperty(officeCode);
            SOAPMessage soapResponse = soapConnection.call(SoapHelper.createSOAPRequest(xml, mqErrInfo), url);
            // Process the SOAP Response
            returnPayLoad = SoapHelper.getSOAPResponse(soapResponse, mqErrInfo);
            // Day du lieu vao RabbitMQ
            RabbitMQLogHelper.pushLogToRabbitMQ(xml + Constants.MESSAGE_SEPARATOR + returnPayLoad.replace(Constants.TAG_ENCODE.OPEN_TAG, Constants.TAG_NO_ENCODE.OPEN_TAG)
                    .replace(Constants.TAG_ENCODE.CLOSE_TAG, Constants.TAG_NO_ENCODE.CLOSE_TAG), mqLogInfo);
            soapConnection.close();
        } catch (Exception ex) {
            //LogUtils.addLog(ex);
            error = envelopeService.createError(
                    Constants.ERROR.ERR01_CODE, Constants.ERROR.ERR01);
            envl = envelopeService.createResponseError(xml,
                    documentType, Constants.RESPONSETYPE.ERROR, error);
            returnPayLoad = xmlService.ObjectToXml(envl);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqErrInfo);
        }
        logger.info("Message phan hoi: " + returnPayLoad);
        res.setResponsePayload(returnPayLoad);
        return res;
    }
}
