package com.nsw.backend.sbv.p01.controller;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.Constants;
import com.nsw.backend.util.ResponseJson;
import com.nsw.backend.ws.client.ResponseDownload;
import com.nsw.backend.ws.client.ResponseUpload;

@RestController
@RequestMapping(value = "/sbv/01/file")
public class FileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	private static final String CLASS_NAME = "FileController";
	private static final String URL_FILE_SERVICE = "URL_FILE_SERVICE";
	private static final String URL_UPLOAD = "/file/upload";
	private static final String URL_DOWNLOAD = "/file/download";
	private static final String FOLDER_TEMP_FILE_SERVICE = "FOLDER_TEMP_FILE_SERVICE";

	@Autowired
	private RabbitMQService rabbitMQService;

	@Autowired
	private Environment environment;

	@RequestMapping(value = "/upload/", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> upload(@RequestParam("file") MultipartFile file,
			@RequestParam("fileName") String fileName, @RequestParam("ministry") String ministry,
			@RequestParam("procedure") String procedure) {
		String errorMessage = "";
		boolean isSuccess = false;
		ResponseUpload res = null;
		LOGGER.info("Upload: fileSize = {}, fileName = {},  ministry = {}, procedure = {}", file.getSize(),
				fileName, ministry, procedure);
		try {
			// Goi Service upload File
			res = uploadFile(environment.getRequiredProperty(URL_FILE_SERVICE) + URL_UPLOAD, file, fileName, ministry,
					procedure);
			if (res == null) {
				return createResponse(res, isSuccess, errorMessage);
			} 
			
			if (res.getErrorCode() != null && !"".equals(res.getErrorCode())) {
				errorMessage = logMessage(res.getErrorCode() + res.getErrorName());
			} else {
				res.setFileCode(res.getFileName());
				res.setFileName(fileName);
				isSuccess = true;
			}
			LOGGER.info("UPLOAD RESULT = {}", res);
		} catch (Exception ex) {
			errorMessage = logMessage(ex);
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			LOGGER.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}
		return createResponse(res, isSuccess, errorMessage);
	}

	private String logMessage(String string) {
		return "ERROR >> " + string;
	}

	private String logMessage(Exception ex) {
		return ex.getMessage();
	}

	private ResponseEntity<ResponseJson> createResponse(ResponseUpload res, boolean isSuccess, String errorMessage) {

		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(res);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);

		return new ResponseEntity<>(objResponse, HttpStatus.OK);
	}

	public ResponseUpload uploadFile(String url, MultipartFile multipart, String fileName, String ministry,
			String procedure) {

		try {
			URI uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
			String folederUpload = environment.getRequiredProperty(FOLDER_TEMP_FILE_SERVICE);

			Path parentDir = Paths.get(folederUpload);
			if (!parentDir.toFile().exists())
				Files.createDirectories(parentDir);
			String filePath = folederUpload + multipart.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, multipart.getBytes());
			
			File file = new File(filePath);
			parts.add("file", new FileSystemResource(file));
			parts.add("fileName", fileName);
			parts.add("ministry", ministry);
			parts.add("procedure", procedure);
			
			ResponseUpload responseUpload = restTemplate.postForObject(uri, parts, ResponseUpload.class);
			Files.delete(path);
			return responseUpload;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + e.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}

		return null;
	}

	@RequestMapping(value = "/download/", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> fileDownload(@RequestParam("filePath") String filePath,
			@RequestParam("fileName") String fileName) {
		String errorMessage = "";
		boolean isSuccess = false;
		ResponseDownload res = null;
		try {
			// Goi Service upload File
			res = downloadFile(environment.getRequiredProperty(URL_FILE_SERVICE) + URL_DOWNLOAD, filePath, fileName);
			if (res.getErrorCode() != null && !"".equals(res.getErrorCode())) {
				errorMessage = logMessage(res.getErrorCode() + res.getErrorName());
			} else {
				isSuccess = true;
			}
		} catch (Exception ex) {
			errorMessage = logMessage(ex);
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}
		return createResponse(res, isSuccess, errorMessage);
	}

	private ResponseEntity<ResponseJson> createResponse(ResponseDownload res, boolean isSuccess, String errorMessage) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(res);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);

		return new ResponseEntity<>(objResponse, HttpStatus.OK);
	}

	public ResponseDownload downloadFile(String url, String filePath, String fileName) {
		URI uri;
		try {
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
			parts.add("filePath", filePath);
			parts.add("fileName", fileName);
			return restTemplate.postForObject(uri, parts, ResponseDownload.class);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + e.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}

		return null;
	}
}
