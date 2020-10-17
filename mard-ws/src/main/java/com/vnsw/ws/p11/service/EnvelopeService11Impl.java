package com.vnsw.ws.p11.service;

/**
 * Xử lý Đóng gói bản tin
 */
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p11.envelop.Error11;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.p11.envelop.Body11;
import com.vnsw.ws.p11.envelop.Content11;
import com.vnsw.ws.p11.envelop.Envelope11;
import com.vnsw.ws.p11.envelop.From11;
import com.vnsw.ws.p11.envelop.Header11;
import com.vnsw.ws.p11.envelop.Reference11;
import com.vnsw.ws.p11.envelop.Subject11;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtils;
import javax.xml.XMLConstants;

/**
 *
 * @author Linhdx
 */
@Service("envelopeService11")
public class EnvelopeService11Impl implements EnvelopeService11 {

    private static final String CLASS_NAME = "EnvelopeServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

    public static final Logger logger = LoggerFactory
            .getLogger(EnvelopeService11.class);
    private final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * Lay thong tin loai thu tuc
     *
     * @param requestPayload
     * @return
     */
    public String getDocumentType(String xml) {
        try {
            return getValueFromXml(xml, "/Envelope/Header/Subject/documentType");

        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Lay thong tin ve thu tuc
     *
     * @param requestPayload
     * @return
     */
    public String getProcedure(String xml) {
        try {
            return getValueFromXml(xml, "/Envelope/Header/From/identity");

        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

        }
        return null;
    }

    /**
     * Lay thong tin ve Ham
     *
     * @param requestPayload
     * @return
     */
    public String getFunction(String xml) {
        try {
            return getValueFromXml(xml, "/Envelope/Header/Subject/function");
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return null;

    }

    /**
     * Tao bao tin phan hoi bi loi
     *
     */
    public Envelope11 createResponseError(String xml, String documentType, String type, Error11 error) {
        try {
            Envelope11 envl = new Envelope11();
            envl.setHeader(createHeaderError(xml, documentType, type));
            envl.setBody(createBodyError(error));
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Tao bao tin phan hoi bi loi
     *
     */
    public Envelope11 createResponseError(String xml, String documentType, String type, String code,
            String name, Exception ex) {
        try {
            Error11 error = createError(code, name, ex);
            Envelope11 envl = createResponseError(xml, documentType, type, error);
            logger.error("Error:" + ex.getCause());
            return envl;
        } catch (Exception ex2) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Tao bao tin phan hoi bi loi
     *
     */
    public Envelope11 createResponseError(String xml, String documentType, String type, String code,
            String name) {
        try {
            Error11 error = createError(code, name);
            Envelope11 envl = createResponseError(xml, documentType, type, error);
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    public Envelope11 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error11 error) {
        try {
            Envelope11 envl = new Envelope11();
            envl.setHeader(createHeaderError(fiMaHoSo, documentType, msgType));
            envl.setBody(createBodyError(error));
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Tao body thong bao loi
     *
     * @param error
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Body11 createBodyError(Error11 error) {
        try {
            Body11 body = new Body11();
            Content11 content = new Content11();
            List<Error11> errorList = new ArrayList();
            errorList.add(error);
            content.setErrorList(errorList);
            body.setContent(content);
            return body;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Tao header thong bao loi
     *
     * @param xml
     * @return
     */
    public Header11 createHeaderError(String fiMaHoSo, String documentType, String msgType) {
        Header11 hd = new Header11();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference11(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, Constants.TO.UNIT_CODE));
            hd.setSubject(new Subject11(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference11(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, Constants.TO.UNIT_CODE));
            hd.setSubject(new Subject11(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Lay gia tri tu xml key co dang /Envelope11/Header11/Subject11/function
     *
     * @param xml
     * @param key
     * @return
     */
    public String getValueFromXml(String xml, String key) {
        String value;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            Document doc = builder.parse(new ByteArrayInputStream(xml.trim()
                    .getBytes(Charset.forName("utf-8"))));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            value = getValueFromXml(xpath, doc, key);

        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            value = null;
        }
        return value;
    }

    /**
     * Lay gia tri tu xpath key co dang /Envelope11/Header11/Subject11/function
     */
    public String getValueFromXml(XPath xpath, Document doc, String key) {
        String value;
        try {
            XPathExpression functionExpr = xpath.compile(key);
            NodeList fucntionNode = (NodeList) functionExpr.evaluate(doc,
                    XPathConstants.NODESET);
            value = fucntionNode.item(0).getTextContent();
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            value = null;
        }
        return value;
    }

    /**
     * Tao ban tin Error11 de phan hoi
     */
    public Error11 createError(String code, String name, Exception ex) {
        try {
            String cause = "";
            if (ex.getCause() != null) {
                cause = String.valueOf(ex.getCause());
            }
            if (cause.length() > 200) {
                cause = cause.substring(200);
            }
            Error11 error = new Error11();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return null;
        }
    }

    /**
     * Tao ban tin Error11 de phan hoi
     */
    public Error11 createError(String code, String name) {
        try {
            Error11 error = new Error11();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex2.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return null;
        }

    }

    /**
     * Tao header thong bao cho msg nhan
     *
     * @param xml
     * @return
     */
    public Header11 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header11 hd = new Header11();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference11(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, Constants.TO.UNIT_CODE));
            hd.setSubject(new Subject11(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference11(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, Constants.TO.UNIT_CODE));
            hd.setSubject(new Subject11(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao header thong bao
     *
     * @param xml
     * @return
     */
    public Header11 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String unitCode) {
        Header11 hd = new Header11();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();

        try {
            hd.setReference(new Reference11(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, unitCode));
            hd.setSubject(new Subject11(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference11(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From11(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From11(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, unitCode));
            hd.setSubject(new Subject11(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao body thong bao
     *
     * @param error
     * @return
     */
    public Body11 createBody(Content11 content) {
        try {
            Body11 body = new Body11();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Body11();
    }

    public Envelope11 createResponse(Header11 header, Body11 body) {
        try {
            Envelope11 envl = new Envelope11();
            envl.setHeader(header);
            envl.setBody(body);
            envl.setSystemSignature("");
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Envelope11();
    }
    
    public Envelope11 createMessage(Header11 header, Body11 body) {
        try {
            Envelope11 envl = new Envelope11();
            envl.setHeader(header);
            envl.setBody(body);
            envl.setSystemSignature("");
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Envelope11();
    }

}
