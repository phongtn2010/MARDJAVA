/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.file.controller;

import com.vnsw.ws.common.entity.json.ResponseUpload;
import com.vnsw.ws.common.envelop.*;
import com.vnsw.ws.file.envelop.*;
import com.vnsw.ws.file.message.FileServer;
import com.vnsw.ws.file.service.BaseService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.util.Constants;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author QUANGNV18
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	Constants constants = new Constants();
	static final String CLASS_NAME = "FileController";
	@Autowired
	public Environment environment;

	public interface FROM {

		public static final String NAME = "NSW";
		public static final String IDENTITY = "NSW";
		public static final String COUNTRY_CODE = "VN";
		public static final String MINISTRY_CODE = "BTC";
		public static final String ORAGANIZATION_CODE = "TCHQ";
		public static final String UNIT_CODE = "NSW";
	}

	public interface TO {

		public static final String NAME = "SBV";
		public static final String IDENTITY = "SBV";
		public static final String COUNTRY_CODE = "VN";
		public static final String MINISTRY_CODE = "SBV";
		public static final String ORAGANIZATION_CODE = "SBV";
		public static final String UNIT_CODE = "SBV";
	}

	public interface MSG_TYPE {

		public static final String MSG_22 = "22";
		public static final String MSG_23 = "23";
	}

	public interface MSG_FUNCTION {

		public static final String MSG_23 = "23";
		public static final String MSG_25 = "25";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseUpload uploadFile(@RequestParam("file") MultipartFile mfile,
			@RequestParam("fileName") String fileName, @RequestParam("ministry") String ministry,
			@RequestParam("procedure") String procedure) {
		ResponseUpload result = new ResponseUpload();
		try {
			if (mfile != null) {
				FileEnvelop envelope = null;
				Header header = null;
				FileBody body = null;
				FileContent content = new FileContent();

				String tempFolder = environment.getProperty(Constants.FileFolder.TempSaveFolder);
				String orignFileName = mfile.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				String code = uuid.toString();
				String filePath = tempFolder + code + "." + FilenameUtils.getExtension(orignFileName);

				Path path = Paths.get(filePath);
				Files.write(path, mfile.getBytes());
				File uploadFile = new File(filePath);

				FileServer file = new FileServer();
				file.setFileByte(encodeFileToBase64Binary(uploadFile));
				file.setFileName(fileName);

				header = createSendHeader("00000000", Constants.SBV_PRO.SBV1, MSG_TYPE.MSG_22, MSG_FUNCTION.MSG_23);
				content.setFileServer(file);
				body = createBody(content);
				envelope = createEnvelope(header, body);
				FileEnvelop evlReturn = sendMessage(envelope);
				if (evlReturn != null) {
					FileServer fileData = evlReturn.getBody().getContent().getFileServer();
					result.setFileName(fileData.getFileName());
					result.setFilePath(fileData.getFileId().toString());
				} else {
					result.setErrorCode("00");
					result.setErrorName("Lỗi không thể upload được file, vui lòng thử lại");
				}
			} else {
				result.setErrorCode("00");
				result.setErrorName("Dữ liệu file chưa được cung cấp!");
			}
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			result.setErrorCode("00");
			result.setErrorName(ex.getMessage());
			LOGGER.error(ex.getMessage(), ex);
		}
		return result;
	}

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public FileServer downFile(@RequestParam("fileId") String fileId) {
		try {
			if (fileId != null) {
				FileEnvelop envelope = null;
				Header header = null;
				FileBody body = null;
				FileContent content = new FileContent();

				FileServer file = new FileServer();
				file.setFileId(Long.valueOf(fileId));

				header = createSendHeader("00000000", Constants.SBV_PRO.SBV1, MSG_TYPE.MSG_23, MSG_FUNCTION.MSG_25);
				content.setFileServer(file);
				body = createBody(content);
				envelope = createEnvelope(header, body);
				FileEnvelop evlReturn = sendMessage(envelope);
				if (evlReturn != null) {
					return evlReturn.getBody().getContent().getFileServer();
				}
			}
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			LOGGER.error(ex.getMessage(), ex);
		}
		return null;
	}

	private FileEnvelop sendMessage(FileEnvelop envelopeSend) {
		String xml = "";
		Boolean isSuccess = false;
		String documentType = Constants.SBV_PRO.SBV1;
		String officeCode = Constants.SBV;

		try {
			xml = ObjectToXml(envelopeSend);
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			String url = environment.getProperty("GATEWAY_LINK");
			String nameSpace = environment.getProperty("GATEWAY_NAMESPACE");
			String nameSpaceKey = environment.getProperty("GATEWAY_NAMESPACE_KEY");
			String methodTag = environment.getProperty("GATEWAY_MOTHOD_TAG");
			String requestOfficeCode = environment.getProperty("GATEWAY_PAYLOAD_TAG_OFFICECODE");
			String requestDocumentType = environment.getProperty("GATEWAY_PAYLOAD_TAG_DOCUMENTTYPE");
			String requestPayload = environment.getProperty("GATEWAY_PAYLOAD_TAG_DATA");

			SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
					nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);

			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

			xml = SoapHelper.getSOAPResponse(soapResponse);
			// FAKE
			soapConnection.close();
			isSuccess = true;

		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			LOGGER.error(ex.getMessage(), ex);
		}

		FileEnvelop envelopeReturn = null;
		if (isSuccess) {
			envelopeReturn = xmlToEnvelope(xml, FileEnvelop.class);
		}

		return envelopeReturn;
	}

	Header createSendHeader(String code, String documentType, String msgType, String msgFunc) {
		Header hd = new Header();
		Date now = new Date();
		UUID uuid = UUID.randomUUID();

		try {
			hd.setReference(new Reference(Constants.VERSION.SEND_VERSION, uuid.toString()));
			hd.setFrom(new From(FROM.NAME, FROM.IDENTITY, FROM.COUNTRY_CODE, FROM.MINISTRY_CODE,
					FROM.ORAGANIZATION_CODE, FROM.UNIT_CODE));
			hd.setTo(new From(TO.NAME, TO.IDENTITY, TO.COUNTRY_CODE, TO.MINISTRY_CODE, TO.ORAGANIZATION_CODE,
					TO.UNIT_CODE));

			hd.setSubject(new Subject(documentType, msgType, msgFunc, code, constants.formatterYear.format(now),
					constants.formatterDateTime.format(now), code));
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

			hd.setReference(new Reference(Constants.VERSION.SEND_VERSION, uuid.toString()));
			hd.setFrom(new From(FROM.NAME, FROM.IDENTITY, FROM.COUNTRY_CODE, FROM.MINISTRY_CODE,
					FROM.ORAGANIZATION_CODE, FROM.UNIT_CODE));
			hd.setTo(new From(TO.NAME, TO.IDENTITY, TO.COUNTRY_CODE, TO.MINISTRY_CODE, TO.ORAGANIZATION_CODE,
					TO.UNIT_CODE));
			hd.setSubject(new Subject(documentType, msgType, Constants.FUNCTION.FUNC_ERROR, code,
					constants.formatterYear.format(now), constants.formatterDateTime.format(now), code));
			LOGGER.error(ex.getMessage(), ex);
		}
		return hd;
	}

	FileBody createBody(FileContent content) {
		try {
			FileBody body = new FileBody();
			body.setContent(content);
			body.setSignature("");
			return body;
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			LOGGER.error(ex.getMessage(), ex);
		}
		return new FileBody();
	}

	FileEnvelop createEnvelope(Header header, FileBody body) {
		try {
			FileEnvelop envl = new FileEnvelop();
			envl.setHeader(header);
			envl.setBody(body);
			envl.setSystemSignature("");
			return envl;
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			LOGGER.error(ex.getMessage(), ex);
		}
		return new FileEnvelop();
	}
}
