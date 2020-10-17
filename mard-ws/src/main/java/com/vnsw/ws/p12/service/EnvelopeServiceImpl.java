/*
 * To change this license header, choose License Header12s in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p12.service;

import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p12.envelop.Body12;
import com.vnsw.ws.p12.envelop.Content12;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.p12.envelop.Error12;
import com.vnsw.ws.p12.envelop.From12;
import com.vnsw.ws.p12.envelop.Header12;
import com.vnsw.ws.p12.envelop.Reference12;
import com.vnsw.ws.p12.envelop.Subject12;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service("envelopeService12")
@Transactional
public class EnvelopeServiceImpl implements EnvelopeService {

    private static final String CLASS_NAME = "EnvelopeServiceImpl";

    private final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    @Autowired
    RabbitMQService rabbitMQService;

    @Override
    public Error12 createError(String code, String name) {
        try {
            Error12 error = new Error12();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            LogUtil.addLog(ex2);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex2.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return null;
        }
    }

    @Override
    public String getDocumentType(String xml) {
        try {
            return getValueFromXml(xml, "/Envelope12/Header12/Subject/documentType");

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    /**
     * Lay gia tri tu xml key co dang /Envelope12/Header12/Subject/function
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
            Document doc = builder.parse(new ByteArrayInputStream(xml.trim()
                    .getBytes(Charset.forName("utf-8"))));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            value = getValueFromXml(xpath, doc, key);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            value = null;
        }
        return value;
    }

    /**
     * Lay gia tri tu xpath key co dang /Envelope12/Header12/Subject/function
     */
    public String getValueFromXml(XPath xpath, Document doc, String key) {
        String value;
        try {
            XPathExpression functionExpr = xpath.compile(key);
            NodeList fucntionNode = (NodeList) functionExpr.evaluate(doc,
                    XPathConstants.NODESET);
            value = fucntionNode.item(0).getTextContent();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            value = null;
        }
        return value;
    }

    @Override
    public Envelope12 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error12 error) {
        try {
            Envelope12 envl = new Envelope12();
            envl.setHeader(createHeaderError(fiMaHoSo, documentType, msgType));
            envl.setBody(createBodyError(error));
            return envl;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
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
     * @param fiMaHoSo
     * @param documentType
     * @param xml
     * @param msgType
     * @return
     */
    public Header12 createHeaderError(String fiMaHoSo, String documentType, String msgType) {
        Header12 hd = new Header12();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference12(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, null));
            hd.setSubject(new Subject12(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference12(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, null));
            hd.setSubject(new Subject12(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    /**
     * Tao body thong bao loi
     *
     * @param error
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Body12 createBodyError(Error12 error) {
        try {
            Body12 body = new Body12();
            Content12 content = new Content12();
            List<Error12> errorList = new ArrayList();
            errorList.add(error);
            content.setErrorList(errorList);
            body.setContent(content);
            return body;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    @Override
    public Error12 createError(String code, String name, Exception ex) {
        try {
//			String cause = "";
//			if (ex.getCause() != null) {
//				cause = String.valueOf(ex.getCause());
//			}
//			if (cause.length() > 200) {
//				cause = cause.substring(200);
//			}
            Error12 error = new Error12();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            LogUtil.addLog(ex2);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex2.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return null;
        }
    }

    @Override
    public Header12 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header12 hd = new Header12();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();
        try {
            hd.setReference(new Reference12(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, null));
            hd.setSubject(new Subject12(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference12(Constants.VERSION.RECEIVE_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, null));
            hd.setSubject(new Subject12(documentType, msgType, Constants.FUNCTION.FUNC_ERROR,
                    fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }

    @Override
    public Body12 createBody(Content12 content) {
        try {
            Body12 body = new Body12();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Body12();
    }

    @Override
    public Envelope12 createResponse(Header12 header, Body12 body) {
        try {
            Envelope12 envl = new Envelope12();
            envl.setHeader(header);
            envl.setBody(body);
            envl.setSystemSignature("");
            return envl;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return new Envelope12();
    }

    @Override
    public Header12 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Header12 hd = new Header12();
        Date now = new Date();
        UUID uuid = UUID.randomUUID();

        try {
            hd.setReference(new Reference12(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, Constants.TO.UNIT_CODE));
            hd.setSubject(new Subject12(documentType, msgType, msgFunc, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            hd.setReference(new Reference12(Constants.VERSION.SEND_VERSION, uuid.toString()));
            hd.setFrom(new From12(Constants.FROM.NAME, Constants.FROM.IDENTITY, Constants.FROM.COUNTRY_CODE,
                    Constants.FROM.MINISTRY_CODE, Constants.FROM.ORAGANIZATION_CODE, Constants.FROM.UNIT_CODE));
            hd.setTo(new From12(Constants.TO.NAME, Constants.TO.IDENTITY, Constants.TO.COUNTRY_CODE,
                    Constants.TO.MINISTRY_CODE, Constants.TO.ORAGANIZATION_CODE, null));
            hd.setSubject(new Subject12(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, fiMaHoSo,
                    formatterYear.format(now), formatterDateTime.format(now), fiMaHoSo, formatterYear.format(now)));
        }
        return hd;
    }
}
