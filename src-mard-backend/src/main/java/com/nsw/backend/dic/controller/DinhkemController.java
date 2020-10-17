package com.nsw.backend.dic.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.util.ResponseJson;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/mard/dinhkem")
public class DinhkemController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(DinhkemController.class);
    private static final String TAG = "DinhkemController";
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String TMP_FOLDER = USER_DIRECTORY + "/tmp";

    private static final String TOKEN_URL = "GetToken";
    private static final String UPLOAD_URL = "Upload";

    @Autowired
    Environment environment;

    @PostMapping("/create")
    public ResponseEntity<ResponseJson> uploadFile(
            @RequestParam MultipartFile file,
            @RequestParam Long fiMaLoai,
            @RequestParam String documentType) throws UnsupportedEncodingException {
        if (file == null) {
            return createErrorResponse("No content", HttpStatus.NO_CONTENT);
        }
        if(file.getSize() > 50 * 1024 * 1024 /*50MB*/){
            return createErrorResponse("File size must not greater than 50MB", HttpStatus.OK);
        }
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
        } catch (IOException e) {
            log.debug("{}: Upload file failed: {}", TAG, e.getMessage());
            log.debug("Caught exception ", e);
            return createErrorResponse("Upload file failed", HttpStatus.OK);
        }

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
        ResponseJson responseForFE = new ResponseJson("Successful".equals(fileResponse.getStatus()), fileResponse.getData(), fileResponse.getMesage());
        try {
            Files.delete(Paths.get(currentFile.toURI()));
        } catch (IOException e) {
            log.debug("Cant delete TMP file: ", e);
        }
        return ResponseEntity.ok(responseForFE);
    }

    private Object getToken() {
        String uri = environment.getRequiredProperty("FILE_SERVICES_URL") + TOKEN_URL;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, ResponseJson.class).getBody().getData();
    }

    @GetMapping("/download/{path:.+}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String path) {
        try {
            if (StringUtils.isEmpty(path)) {
                return ResponseEntity.badRequest().build();
            }
            File storedFile = new File(TMP_FOLDER, path);
            Resource resource = new UrlResource(storedFile.toURI());
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\""
                                    + path.substring(0, path.lastIndexOf('_'))
                                    + "\"")
                    .body(resource);
        } catch (Exception ex) {
            log.error(TAG + ex.getMessage(), ex);
            return ResponseEntity.badRequest().build();
        }
    }

    @Data
    private static class FileResponse{
        private String mesage;
        private String status;
        private Object data;
    }
}
