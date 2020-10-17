package com.nsw.mt.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.ResponseDownload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * @author PhongNguyen
 */
public class FileServiceHelper {
    private static final String CLASS_NAME = "FileServiceHelper";
    static final Logger LOGGER = LoggerFactory.getLogger(FileServiceHelper.class);

    /**
     * Upload file
     *
     * @param restUri
     * @param multipartfiles
     * @param tempFolder
     * @param mCode
     * @param pCode
     * @param mqInfo
     * @return
     */
    public ResponseJson uploadFile(String restUri, MultipartFile[] multipartfiles, String mCode, String pCode, Object object) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(
                    new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            for (MultipartFile file : multipartfiles) {
                ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
                    @Override
                    public String getFilename() {
                        return file.getOriginalFilename();
                    }
                };
                parts.add("files", resource);
            }
            parts.add("ministry", mCode);
            parts.add("procedure", pCode);
            parts.add("object", object);
            json = restTemplate.postForObject(restUri, parts, ResponseJson.class);
            json.setSuccess(true);
        } catch (IOException | RestClientException ex) {
            if (json == null) {
                json = new ResponseJson();
            }
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

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
    public byte[] downloadFile(String restUri, String filePath, String fileName, RabbitMQInfo mqInfo) {
        byte[] b = null;
        try {
            URI uri = new URI(restUri);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(
                    new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("filePath", filePath);
            parts.add("fileName", fileName);

            ResponseJson res = restTemplate.postForObject(uri, parts, ResponseJson.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonData = mapper.writeValueAsString(res.getData());
            ResponseDownload downloadInfo = mapper.readValue(jsonData, ResponseDownload.class);
            b = downloadInfo.getContent();
        } catch (URISyntaxException | RestClientException | IOException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            b = null;

            LOGGER.error(ex.getMessage(), ex);
        }

        return b;
    }

    public ResponseEntity downloadFile(String uri, Long idDinhKem, String mcode, String pcode, String filename)
            throws IOException {
        String mimeType = "";
        RestTemplate restTemplate = new RestTemplate();
        FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
        formConverter.setCharset(Charset.forName("UTF8"));
        restTemplate.getMessageConverters().add(formConverter);
        restTemplate.getMessageConverters().add(
                new MappingJackson2HttpMessageConverter());
        ResponseEntity<ByteArrayResource> response = restTemplate.exchange(uri + "/" + mcode + "/" + pcode + "/" + idDinhKem, HttpMethod.POST, null, ByteArrayResource.class);
        return response;
    }
}
