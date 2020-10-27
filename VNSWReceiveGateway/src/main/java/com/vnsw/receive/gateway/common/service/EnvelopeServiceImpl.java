package com.vnsw.receive.gateway.common.service;

/**
 * Xử lý Đóng gói bản tin
 */
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.vnsw.receive.gateway.common.bo.Body;
import com.vnsw.receive.gateway.common.bo.Content;
import com.vnsw.receive.gateway.common.bo.Envelope;
import com.vnsw.receive.gateway.common.bo.Error;
import com.vnsw.receive.gateway.common.bo.From;
import com.vnsw.receive.gateway.common.bo.Header;
import com.vnsw.receive.gateway.common.bo.Reference;
import com.vnsw.receive.gateway.common.bo.Subject;
import com.vnsw.receive.gateway.util.LogUtils;

/**
 *
 * @author Linhdx
 */
@Service("envelopeService")
public class EnvelopeServiceImpl implements EnvelopeService {

    public static final Logger logger = LoggerFactory
            .getLogger(EnvelopeService.class);
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
            LogUtils.addLog(ex);

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
            LogUtils.addLog(ex);

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
    public Envelope createResponseError(String xml, String documentType, String type, Error error) {
        try {
            Envelope envl = new Envelope();
            envl.setHeader(createHeaderError(xml, documentType, type));
            envl.setBody(createBodyError(error));
            return envl;
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return null;
    }

    /**
     * Tao bao tin phan hoi bi loi
     *
     */
    public Envelope createResponseError(String xml, String documentType, String type, String code,
            String name, Exception ex) {
        try {
            Error error = createError(code, name, ex);
            Envelope envl = createResponseError(xml, documentType, type, error);
            logger.error("Error:" + ex.getCause());
            return envl;
        } catch (Exception ex2) {
            logger.error("Error.. " + ex2.getCause());
        }
        return null;
    }

    /**
     * Tao bao tin phan hoi bi loi
     *
     */
    public Envelope createResponseError(String xml, String documentType, String type, String code,
            String name) {
        try {
            Error error = createError(code, name);
            Envelope envl = createResponseError(xml, documentType, type, error);
            return envl;
        } catch (Exception ex) {
            LogUtils.addLog(ex);
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
    public Body createBodyError(Error error) {
        try {
            Body body = new Body();
            Content content = new Content();
            List<Error> errorList = new ArrayList();
            errorList.add(error);
            content.setErrorList(errorList);
            body.setContent(content);
            return body;
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return null;
    }

    /**
     * Tao header thong bao loi
     *
     * @param xml
     * @return
     */
    public Header createHeaderError(String xml, String documentType, String function) {
        Header hd = new Header();
        Date now = new Date();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.trim()
                    .getBytes(Charset.forName("utf-8"))));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String func = getValueFromXml(xpath, doc,
                    "/Envelope/Header/Subject/function");
            String reference = getValueFromXml(xpath, doc,
                    "/Envelope/Header/Subject/reference");
            String fromName = getValueFromXml(xpath, doc,
                    "/Envelope/Header/From/name");
            String fromId = getValueFromXml(xpath, doc,
                    "/Envelope/Header/From/identity");
            hd.setReference(new Reference("", ""));
            hd.setFrom(new From("NSW", "NSW", "VN", "TCHQ", "", ""));
            // gui phan hoi thi gui nguoc lai to=from
            hd.setTo(new From(fromId, fromName, "VN", "", "", ""));
            hd.setSubject(new Subject(documentType, function, func, reference,
                    formatterYear.format(now), formatterDateTime.format(now)));
        } catch (Exception ex) {
            LogUtils.addLog(ex);
            hd.setReference(new Reference("", ""));
            hd.setFrom(new From("NSW", "NSW", "VN", "TCHQ", "", ""));
            hd.setTo(new From("", "", "VN", "", "", ""));
            hd.setSubject(new Subject(documentType, "99", "99", "0", formatterYear
                    .format(now), formatterDateTime.format(now)));
        }
        return hd;
    }

    /**
     * Lay gia tri tu xml key co dang /Envelope/Header/Subject/function
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
            Document doc = builder.parse(new ByteArrayInputStream(xml.trim()
                    .getBytes(Charset.forName("utf-8"))));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            value = getValueFromXml(xpath, doc, key);

        } catch (Exception ex) {
            LogUtils.addLog(ex);
            value = null;
        }
        return value;
    }

    /**
     * Lay gia tri tu xpath key co dang /Envelope/Header/Subject/function
     */
    public String getValueFromXml(XPath xpath, Document doc, String key) {
        String value;
        try {
            XPathExpression functionExpr = xpath.compile(key);
            NodeList fucntionNode = (NodeList) functionExpr.evaluate(doc,
                    XPathConstants.NODESET);
            value = fucntionNode.item(0).getTextContent();
        } catch (Exception ex) {
            LogUtils.addLog(ex);
            value = null;
        }
        return value;
    }

    /**
     * Tao ban tin Error de phan hoi
     */
    public Error createError(String code, String name, Exception ex) {
        try {
            String cause = "";
            if (ex.getCause() != null) {
                cause = String.valueOf(ex.getCause());
            }
            if (cause.length() > 200) {
                cause = cause.substring(200);
            }
            Error error = new Error();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            logger.error("Error.. " + ex2.getCause());
            return null;
        }
    }

    /**
     * Tao ban tin Error de phan hoi
     */
    public Error createError(String code, String name) {
        try {
            com.vnsw.receive.gateway.common.bo.Error error = new Error();
            error.setErrorCode(code);
            error.setErrorName(name);
            return error;
        } catch (Exception ex2) {
            logger.error("Error.. " + ex2.getCause());
            return null;
        }

    }

    /**
     * Tao header thong bao
     *
     * @param xml
     * @return
     */
    public Header createHeader(String xml, String documentType, String type) {
        Header hd = new Header();
        Date now = new Date();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.trim()
                    .getBytes(Charset.forName("utf-8"))));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            String func = getValueFromXml(xpath, doc,
                    "/Envelope/Header/Subject/function");
            String reference = getValueFromXml(xpath, doc,
                    "/Envelope/Header/Subject/reference");
            String fromName = getValueFromXml(xpath, doc,
                    "/Envelope/Header/From/name");
            String fromId = getValueFromXml(xpath, doc,
                    "/Envelope/Header/From/identity");
            hd.setReference(new Reference("", ""));
            hd.setFrom(new From("NSW", "NSW", "VN", "TCHQ", "", ""));
            // gui phan hoi thi gui nguoc lai to=from
            hd.setTo(new From(fromId, fromName, "VN", "", "", ""));

            hd.setSubject(new Subject(documentType, func, type, reference,
                    formatterYear.format(now), formatterDateTime.format(now)));
        } catch (Exception ex) {
            LogUtils.addLog(ex);
            hd.setReference(new Reference("", ""));
            hd.setFrom(new From("NSW", "NSW", "VN", "TCHQ", "", ""));
            hd.setTo(new From("", "", "VN", "", "", ""));
            hd.setSubject(new Subject(documentType, "99", "99", "0", formatterYear
                    .format(now), formatterDateTime.format(now)));
        }
        return hd;
    }

    /**
     * Tao header thong bao
     *
     * @param xml
     * @return
     */
    public Header createHeader(String documentType, String type, String func, String reference, String toId, String toName) {
        Header hd = new Header();
        Date now = new Date();
        try {
            hd.setReference(new Reference("", ""));
            hd.setFrom(new From("NSW", "NSW", "VN", "TCHQ", "", ""));
            hd.setTo(new From(toId, toName, "VN", "", "", ""));
            hd.setSubject(new Subject(documentType, type, func, reference,
                    formatterYear.format(now), formatterDateTime.format(now)));
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return hd;
    }

    /**
     * Tao body thong bao
     *
     * @param error
     * @return
     */
    public Body createBody(Content content) {
        try {
            Body body = new Body();
            body.setContent(content);
            body.setSignature("");
            return body;
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return new Body();
    }

    public Envelope createResponse(Header header, Body body) {
        try {
            Envelope envl = new Envelope();
            envl.setHeader(header);
            envl.setBody(body);
            envl.setSystemSignature("");
            return envl;
        } catch (Exception ex) {
            LogUtils.addLog(ex);
        }
        return new Envelope();
    }

}
