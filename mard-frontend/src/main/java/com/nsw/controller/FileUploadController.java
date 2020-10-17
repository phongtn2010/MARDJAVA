/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.constant.AppConstant;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.most.p01.model.Tbddinhkem1;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import com.nsw.ws.message.send.FileServer;
import com.nsw.ws.util.Constants;
import java.io.File;
import java.io.FileInputStream;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author PhongNguyen
 */
@RestController
@RequestMapping("/file")
@MultipartConfig(fileSizeThreshold = ThuTuc01Constant.FileUpload.fileSizeThreshold)
public class FileUploadController {

    static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static final String CLASS_NAME = "FileUploadController";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    FileServiceHelper fileHelper = new FileServiceHelper();

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson uploadFile(@RequestParam("file") MultipartFile file,
            @RequestParam("mcode") String mcode,
            @RequestParam("pcode") String pcode) {
        ResponseJson json = new ResponseJson();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (file.isEmpty()) {
                    json.setSuccess(false);
                    json.setData(null);
                    json.setMessage("");
                } else {
                    String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
                    String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.UPLOAD));
                    json = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, rabbitMQService.getRabbitMQInfo());
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }

        return json;
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void download(HttpServletResponse response,
            @PathVariable("id") String id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.DOWNLOAD));
                FileServer fileInfo = getFile(uri, id);

                if (fileInfo.getFileByte() != null) {
                    downloadFile(response, fileInfo);
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }
    }

    private void downloadFile(HttpServletResponse response, FileServer fileInfo) throws IOException {
        String mimeType = "";
        byte[] fileByte = Base64.decodeBase64(fileInfo.getFileByte());

        Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + fileInfo.getFileName());
        Files.write(savePath, fileByte);

        File downloadFile = savePath.toFile();

        mimeType = URLConnection.guessContentTypeFromName(fileInfo.getFileName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileInfo.getFileName() + "\""));
        response.setContentLength((int) downloadFile.length());

        try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }

        downloadFile.delete();
    }

    public FileServer getFile(String restUri, String fileId) {
        FileServer fileInfo = null;
        try {
            URI uri = new URI(restUri);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(
                    new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("fileId", fileId);
            ResponseJson res = restTemplate.postForObject(uri, parts, ResponseJson.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonData = mapper.writeValueAsString(res.getData());
            fileInfo = mapper.readValue(jsonData, FileServer.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return fileInfo;
    }

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND) + restUri;
    }
}
