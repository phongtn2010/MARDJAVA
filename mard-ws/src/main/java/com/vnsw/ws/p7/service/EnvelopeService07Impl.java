package com.vnsw.ws.p7.service;

import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p7.evelope.*;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("envelopeService07")
public class EnvelopeService07Impl implements EnvelopeService07 {

    private static final String CLASS_NAME = "EnvelopeService07Impl";

    private static final String NAME = "BNNPTNT";
    private static final String IDENTITY = "BNNPTNT";
    private static final String COUNTRY_CODE = "VN";
    private static final String MINISTRY_CODE = "BNNPTNT";
    private static final String ORAGANIZATION_CODE = "06";
    private static final String UNIT_CODE = "BNNPTNT";
    
    @Autowired
    RabbitMQService rabbitMQService;

    public static final Logger logger = LoggerFactory
            .getLogger(EnvelopeService07.class);
    private final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * Lay thong tin loai thu tuc
     *
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
    public Envelope07 createResponseError(String xml, String documentType, String type, Error07 error) {
        try {
            Envelope07 envl = new Envelope07();
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
    public Envelope07 createResponseError(String xml, String documentType, String type, String code,
                                          String name, Exception ex) {
        try {
            Error07 error = createError(code, name, ex);
            Envelope07 envl = createResponseError(xml, documentType, type, error);
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
    public Envelope07 createResponseError(String xml, String documentType, String type, String code,
                                          String name) {
        try {
            Error07 error = createError(code, name);
            Envelope07 envl = createResponseError(xml, documentType, type, error);
            return envl;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    public Envelope07 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error07 error) {
        try {
            Envelope07 envl = new Envelope07();
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
    public Body07 createBodyError(Error07 error) {
        try {
            Body07 body = new Body07();
            Content07 content = new Content07();
            List<Error07> errorList = new ArrayList();
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
     * @return
     */
    public Header07 createHeaderError(String fiMaHoSo, String documentType, String msgType) {
        Header07 hd = new Header07();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference07(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject07(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference07(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject07(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Lay gia tri tu xml key co dang /Envelope07/Header07/Subject07/function
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
     * Lay gia tri tu xpath key co dang /Envelope07/Header07/Subject07/function
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
     * Tao ban tin Error07 de phan hoi
     */
    public Error07 createError(String code, String name, Exception ex) {
        try {
            String cause = "";
            if (ex.getCause() != null) {
                cause = String.valueOf(ex.getCause());
            }
            if (cause.length() > 200) {
                cause = cause.substring(200);
            }
            Error07 error = new Error07();
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
     * Tao ban tin Error07 de phan hoi
     */
    public Error07 createError(String code, String name) {
        try {
            Error07 error = new Error07();
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
     * @return
     */
    public Header07 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header07 hd = new Header07();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference07(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject07(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference07(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject07(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao header thong bao
     *
     * @return
     */
    public Header07 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode) {
        Header07 hd = new Header07();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();

        try {
            hd.setReference(new Reference07(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, mardUnitCode));
            hd.setSubject(new Subject07(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference07(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From07(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From07(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, mardUnitCode));
            hd.setSubject(new Subject07(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao body thong bao
     *
     * @return
     */
    public Body07 createBody(Content07 content) {
        try {
            Body07 body = new Body07();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Body07();
    }

    public Envelope07 createResponse(Header07 header, Body07 body) {
        try {
            Envelope07 envl = new Envelope07();
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
        return new Envelope07();
    }

    public Envelope07 createMessage(Header07 header, Body07 body) {
        try {
            Envelope07 envl = new Envelope07();
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
        return new Envelope07();
    }
}
