package com.vnsw.ws.p01.util;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.helper.RabbitMQInfo;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PhongNguyen
 */
public class FileServiceHelper {

	private static final String CLASS_NAME = "FileServiceHelper";
	static final Logger LOGGER = LoggerFactory.getLogger(FileServiceHelper.class);

	/**
	 * Upload file
	 *
	 * @param restUri
	 * @param multipartfile
	 * @param tempFolder
	 * @param mCode
	 * @param pCode
	 * @param mqInfo
	 * @return
	 */
	public ResponseJson uploadFile(String restUri, MultipartFile multipartfile, String tempFolder, String mCode,
			String pCode, RabbitMQInfo mqInfo) {
		ResponseJson json = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

			String fileName = multipartfile.getOriginalFilename();

			UUID uuid = UUID.randomUUID();
			String code = uuid.toString();

			Path parentDir = Paths.get(tempFolder);
			if (!parentDir.toFile().exists()) {
				Files.createDirectories(parentDir);
			}
			String filePath = tempFolder + code + "." + FilenameUtils.getExtension(fileName);
			Path path = Paths.get(filePath);

			Files.write(path, org.apache.commons.codec.binary.Base64.decodeBase64(multipartfile.getBytes()));

			File file = new File(filePath);
			parts.add("file", new FileSystemResource(file));
			parts.add("fileName", fileName);
			parts.add("ministry", mCode);
			parts.add("procedure", pCode);

			json = restTemplate.postForObject(restUri, parts, ResponseJson.class);
			json.setSuccess(true);
			Files.delete(path);
		} catch (IOException | RestClientException ex) {
			if (json == null) {
				json = new ResponseJson();
			}

			json.setSuccess(false);

			LOGGER.error(ex.getMessage(), ex);
		}

		return json;
	}

	/**
	 * Get base64 file content
	 *
	 * @param restUri
	 * @param filePath
	 * @param fileName
	 * @return
	 */
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
			LOGGER.error(e.getMessage(), errorInfo);
		}

		return null;
	}
}
