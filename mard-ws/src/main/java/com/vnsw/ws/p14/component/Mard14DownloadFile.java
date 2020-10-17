package com.vnsw.ws.p14.component;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Mard14DownloadFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mard14DownloadFile.class);
    private static final String CLASS_NAME = "File14ResourceController";
    private static final String URL_FILE_SERVICE = "URI_ADDRESS_FILE_SERVER";
    private static final String URL_UPLOAD = "/file/upload";
    private static final String URL_DOWNLOAD = "/file/download";
    private static final String FOLDER_TEMP_FILE_SERVICE = "FOLDER_TEMP_FILE_SERVICE";

    private final Environment environment;

    @Autowired
    public Mard14DownloadFile(Environment environment) {
        this.environment = environment;
    }

    public  ResponseUpload upload(MultipartFile file,
                                  String fileName, String ministry,
                                  String procedure) {
        String errorMessage = "";
        boolean isSuccess = false;
        ResponseUpload res = null;
        LOGGER.info("Upload: fileSize = {}, fileName = {},  ministry = {}, procedure = {}, url upload = {}", file.getSize(),
                fileName, ministry, procedure, environment.getRequiredProperty(URL_FILE_SERVICE) );
        try {
            // Goi Service upload File
            res = uploadFile(environment.getRequiredProperty(URL_FILE_SERVICE) + URL_UPLOAD, file, fileName, ministry,
                    procedure);
            if (res == null) {
                return null;
            }

            LOGGER.info("UPLOAD RESULT = {}", res);
            return res;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return null;
    }

    private String logMessage(String string) {
        return "ERROR >> " + string;
    }

    private String logMessage(Exception ex) {
        return ex.getMessage();
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
        }

        return null;
    }

    public  ResponseDownload fileDownload(String filePath, String fileName) {
        String errorMessage = "";
        boolean isSuccess = false;
        ResponseDownload res = null;
        try {
            // Goi Service upload File
            res = downloadFile(environment.getRequiredProperty(URL_FILE_SERVICE) + URL_DOWNLOAD, filePath, fileName);
           return res;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }


    public  ResponseDownload downloadFile(String url, String filePath, String fileName) {
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
        }

        return null;
    }
}
