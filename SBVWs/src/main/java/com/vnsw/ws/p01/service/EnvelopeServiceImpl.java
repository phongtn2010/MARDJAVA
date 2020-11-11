package com.vnsw.ws.p01.service;
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

import javax.xml.XMLConstants;
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
import com.vnsw.ws.p01.envelop.Body;
import com.vnsw.ws.p01.envelop.Content;
import com.vnsw.ws.p01.envelop.Envelope;
import com.vnsw.ws.p01.util.Constants;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.From;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.common.envelop.Reference;
import com.vnsw.ws.common.envelop.Subject;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.util.LogUtils;

/**
 * 
 * @author Linhdx
 */
@Service("envelopeService")
public class EnvelopeServiceImpl implements EnvelopeService {
	private static final String CLASS_NAME = "EnvelopeServiceImpl";
	
	@Autowired
    RabbitMQService rabbitMQService;
	
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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
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
			logger.error(ex.getMessage(), ex);
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
			logger.error(ex.getMessage(), ex);
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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * Tao bao tin phan hoi bi loi
	 * 
	 */
	public Envelope createResponseError(String xml,String documentType, String type, String code,
			String name, Exception ex) {
		try {
			Error error = createError(code, name, ex);
			Envelope envl = createResponseError(xml, documentType, type, error);
			logger.error("Error:" + ex.getCause());
			return envl;
		} catch (Exception ex2) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex2.getMessage(), ex2);
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
			return createResponseError(xml, documentType, type, error);
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}
	
	public Envelope createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error error) {
		try {			
			Envelope envl = new Envelope();
			envl.setHeader(createHeaderError(fiMaHoSo, documentType, msgType));
			envl.setBody(createBodyError(error));
			return envl;
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}
	

	/**
	 * Tao body thong bao loi
	 * 
	 * @param error
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * Tao header thong bao loi
	 * 
	 * @param xml
	 * @return
	 */
	public Header createHeaderError(String fiMaHoSo, String documentType, String msgType) {
		Header hd = new Header();
		Date now = new Date();
		UUID uuid = UUID.randomUUID();
		try {						
			hd.setReference(new Reference(Constants.RECEIVE_VERSION,uuid.toString()));
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));			
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, Constants.FUNC_ERROR, fiMaHoSo,
					formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			
			hd.setReference(new Reference(Constants.RECEIVE_VERSION, uuid.toString()));
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, Constants.FUNC_ERROR, 
					fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
			logger.error(ex.getMessage(), ex);
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
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder builder = factory.newDocumentBuilder();
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
			logger.error(ex.getMessage(), ex);
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
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			value = null;
			logger.error(ex.getMessage(), ex);
		}
		return value;
	}

	/**
	 * Tao ban tin Error de phan hoi
	 */
	public Error createError(String code, String name, Exception ex) {
		try {
			Error error = new Error();
			error.setErrorCode(code);
			error.setErrorName(name);
			return error;
		} catch (Exception ex2) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex2.getMessage(), ex2);
			return null;
		}
	}

	/**
	 * Tao ban tin Error de phan hoi
	 */
	public Error createError(String code, String name) {
		try {
			com.vnsw.ws.common.envelop.Error error = new Error();
			error.setErrorCode(code);
			error.setErrorName(name);
			return error;
		} catch (Exception ex2) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex2.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex2.getMessage(), ex2);
			return null;
		}

	}

	/**
	 * Tao header thong bao cho msg nhan
	 * 
	 * @param xml
	 * @return
	 */
	public Header createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
		Header hd = new Header();
		Date now = new Date();
		UUID uuid = UUID.randomUUID();
		try {						
			hd.setReference(new Reference(Constants.RECEIVE_VERSION,uuid.toString()));
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));			
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, msgFunc, fiMaHoSo,
					formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			
			hd.setReference(new Reference(Constants.RECEIVE_VERSION, uuid.toString()));
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, Constants.FUNC_ERROR, 
					fiMaHoSo, formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
			logger.error(ex.getMessage(), ex);
		}
		return hd;
	}
	
	/**
	 * Tao header thong bao
	 * 
	 * @param xml
	 * @return
	 */
	public Header createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc) {
		Header hd = new Header();
		Date now = new Date();
		UUID uuid = UUID.randomUUID();
		
		try {			
			hd.setReference(new Reference(Constants.SEND_VERSION, uuid.toString()));			
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, msgFunc, fiMaHoSo,
					formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
			
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			
			hd.setReference(new Reference(Constants.SEND_VERSION, uuid.toString()));			
			hd.setFrom(new From(Constants.FROM_NAME, Constants.FROM_IDENTITY, Constants.FROM_COUNTRY_CODE,
					Constants.FROM_MINISTRY_CODE, Constants.FROM_ORAGANIZATION_CODE, Constants.FROM_UNIT_CODE));
			hd.setTo(new From(Constants.TO_NAME, Constants.TO_IDENTITY, Constants.TO_COUNTRY_CODE, 
					Constants.TO_MINISTRY_CODE, Constants.TO_ORAGANIZATION_CODE, Constants.TO_UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, Constants.FUNC_ERROR,fiMaHoSo,
					formatterYear.format(now), formatterDateTime.format(now),fiMaHoSo));
			logger.error(ex.getMessage(), ex);
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
			body.setPersonSignature("");
			return body;
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return new Body();
	}

	public Envelope createResponse(Header header, Body body) {
		try {
			Envelope envl = new Envelope();
			envl.setHeader(header);
			envl.setBody(body);
			return envl;
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();					
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}
		return new Envelope();
	}

}
