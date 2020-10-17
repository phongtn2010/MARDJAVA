package com.nsw.mard.service;

import com.nsw.common.model.json.ResponseJson;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DinhkemService {
    private static final Logger log = LoggerFactory.getLogger(DinhkemService.class);
    private static final String TAG = "DinhkemService";
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String TMP_FOLDER = USER_DIRECTORY + "/tmp";

    private static final String TOKEN_URL = "GetToken";
    private static final String UPLOAD_URL = "Upload";

    @Autowired
    Environment environment;

    public ResponseJson uploadFile(
            MultipartFile file,
            Long fiMaLoai,
            String documentType) {
        ResponseJson response = new ResponseJson();
        //LOG.info("response = " + objResponse.toString());

        if (file == null) {
            response.setSuccess(false);
            response.setMessage("No content");
        }
        else if(file.getSize() > 50 * 1024 * 1024 /*50MB*/){
            response.setSuccess(false);
            response.setMessage("File size must not greater than 50MB");
        }
        else {
            String fileNameAndExtensions = file.getOriginalFilename();
            String fileName = fileNameAndExtensions.substring(0, fileNameAndExtensions.lastIndexOf('.'));
            String extensions = fileNameAndExtensions.substring(fileNameAndExtensions.lastIndexOf('.'));
            String path = fileName + "_" + System.currentTimeMillis() + extensions;
            File root = new File(TMP_FOLDER);
            if (!root.exists()) {
                root.mkdirs();
            }

            File currentFile = new File(root, path);
            try (FileOutputStream fos = new FileOutputStream(currentFile)) {
                IOUtils.copy(file.getInputStream(), fos);
                fos.flush();
                String uploadUrl = environment.getRequiredProperty("FILE_SERVICES_URL") + UPLOAD_URL;
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
                map.add("token", getToken());
                map.add("documentType", documentType);
                map.add("fileCode", fiMaLoai);
                map.add("fileName", URLEncoder.encode(fileName, "UTF-8"));
                map.add("file", new FileSystemResource(currentFile));
                HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
                FileResponse fileResponse = restTemplate.postForEntity(uploadUrl, request, FileResponse.class).getBody();
                response.setSuccess("Successful".equals(fileResponse.getStatus()));
                response.setData(fileResponse.getData());
                response.setMessage(fileResponse.getMesage());
            } catch (IOException e) {
                log.debug("{}: Upload file failed: {}", TAG, e.getMessage());
                log.debug("Caught exception ", e);
                response.setSuccess(false);
                response.setMessage("File size must not greater than 50MB");

            }
            try {
                Files.delete(Paths.get(currentFile.toURI()));
            } catch (IOException e) {
                log.debug("Cant delete TMP file: ", e);
            }

        }
        return response;
    }

    private Object getToken() {
        String uri = environment.getRequiredProperty("FILE_SERVICES_URL") + TOKEN_URL;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, ResponseJson.class).getBody().getData();
    }

    @Data
    private static class FileResponse{
        private String mesage;
        private String status;
        private Object data;
    }
}
