package com.vnsw.ws.p1.service;

import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p1.evelop.*;
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

@Service("envelopeService01")
public class EnvelopeService01Impl implements EnvelopeService01 {

    private static final String CLASS_NAME = "EnvelopeService01Impl";

    private static final String NAME = "BNNPTNT";
    private static final String IDENTITY = "BNNPTNT";
    private static final String COUNTRY_CODE = "VN";
    private static final String MINISTRY_CODE = "BNNPTNT";
    private static final String ORAGANIZATION_CODE = "06";
    private static final String UNIT_CODE = "BNNPTNT";
    
    @Autowired
    RabbitMQService rabbitMQService;

    public static final Logger logger = LoggerFactory
            .getLogger(EnvelopeService01.class);
    private final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");


    /**
     * Lay thong tin loai thu tuc
     *
     * @return
     */
    @Override
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
    @Override
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
    @Override
    public String getFunction(String xml) {
        try {
            return getValueFromXml(xml, "/Envelope/Header/Subject/function");
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return null;
    }

    /**
     * Lay gia tri tu xml key co dang /Envelope01/Header01/Subject01/function
     *
     * @param xml
     * @param key
     * @return
     */
    @Override
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
     * Lay gia tri tu xpath key co dang /Envelope01/Header01/Subject01/function
     */
    @Override
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
     * Tao ban tin Error01 de phan hoi
     */
    @Override
    public Error01 createError(String code, String name) {
        try {
            Error01 error = new Error01();
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
     * Tao ban tin Error07 de phan hoi
     */
    @Override
    public Error01 createError(String code, String name, Exception ex) {
        try {
            String cause = "";
            if (ex.getCause() != null) {
                cause = String.valueOf(ex.getCause());
            }
            if (cause.length() > 200) {
                cause = cause.substring(200);
            }
            Error01 error = new Error01();
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
    @Override
    public Header01 createHeaderError(String fiMaHoSo, String documentType, String msgType) {
        Header01 hd = new Header01();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference01(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject01(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference01(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject01(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao header thong bao cho msg nhan
     *
     * @return
     */
    @Override
    public Header01 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header01 hd = new Header01();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference01(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject01(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference01(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, UNIT_CODE));
            hd.setSubject(new Subject01(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao header thong bao
     *
     * @return
     */
    @Override
    public Header01 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode) {
        Header01 hd = new Header01();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();

        try {
            hd.setReference(new Reference01(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, mardUnitCode));
            hd.setSubject(new Subject01(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference01(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From01(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From01(NAME, IDENTITY, COUNTRY_CODE,
                    MINISTRY_CODE, ORAGANIZATION_CODE, mardUnitCode));
            hd.setSubject(new Subject01(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao body thong bao loi
     *
     * @param error
     * @return
     */
    @Override
    public Body01 createBodyError(Error01 error) {
        try {
            Body01 body = new Body01();
            Content01 content = new Content01();
            List<Error01> errorList = new ArrayList();
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
     * Tao body thong bao
     *
     * @return
     */
    @Override
    public Body01 createBody(Content01 content) {
        try {
            Body01 body = new Body01();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Body01();
    }

    @Override
    public Envelope01 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error01 error) {
        try {
            Envelope01 envl = new Envelope01();
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

    @Override
    public Envelope01 createResponse(Header01 header, Body01 body) {
        try {
            Envelope01 envl = new Envelope01();
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
        return new Envelope01();
    }

    @Override
    public Envelope01 createMessage(Header01 header, Body01 body) {
        try {
            Envelope01 envl = new Envelope01();
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
        return new Envelope01();
    }
}
