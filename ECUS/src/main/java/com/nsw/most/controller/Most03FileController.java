/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.controller.FileUploadController;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.most.constant.Most03Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.helper.ThuTuc02Helper;
import com.nsw.most.p02.model.Tbdhoso2;
import com.nsw.most.p02.model.Tbdlichsu2;
import com.nsw.most.p03.model.HistoryFilterForm;
import com.nsw.most.p03.model.Tbddinhkem3;
import com.nsw.most.p03.model.Tbdlichsu3;
import com.nsw.most.p03.model.Tbdquyetdinh3;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/most/03")
@MultipartConfig(fileSizeThreshold = ThuTuc01Constant.FileUpload.fileSizeThreshold)
public class Most03FileController {

    static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static final String CLASS_NAME = "FileUploadController";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    private static final int BUFFER_SIZE = 4096;
    ThuTuc02Helper helper = new ThuTuc02Helper();
    FileServiceHelper fileHelper = new FileServiceHelper();

    @RequestMapping(value="/quyetDinhFile/{mahoso}/{maloai}", method = RequestMethod.GET)
    public void downloadQuyetdinh(HttpServletResponse response,
            @PathVariable("mahoso") String mahoso,
            @PathVariable("maloai") String maloai){
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try{
        json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_QUYETDINH) + mahoso);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonData = mapper.writeValueAsString(json.getData());
        Tbdquyetdinh3 qd = mapper.readValue(jsonData, Tbdquyetdinh3.class);
        Tbddinhkem3 dinhkem = null;
        if(qd != null){
            for(Tbddinhkem3 dk : qd.getDinhKems()){                
                if(maloai.equals(dk.getFiMaLoai())){
                    dinhkem = dk;
                    break;
                }
            }
            if(dinhkem != null){
                downloadFile(response, dinhkem.getFiGuiId(), dinhkem.getFiTenTep(), dinhkem.getFiGuiId(), dinhkem.getFiDuongDan());
            }
        }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
    }
    @RequestMapping(value = "/dinhkem/{lichsuId}/{hosoId}", method = RequestMethod.GET)
    public void downloadDinhKemLichSu(HttpServletResponse response,
            @PathVariable("lichsuId") String lichsuId,
            @PathVariable("hosoId") String hosoId) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                Tbdlichsu3 lichsu = null;
                HistoryFilterForm filterForm = new HistoryFilterForm();
                ResponseJson json;
                filterForm.setFiIdHoso(Long.parseLong(hosoId));
                filterForm.setPageSize(15);
                json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_HISTORY), filterForm);

                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                List<Tbdlichsu3> lichsuLst = mapper.readValue(jsonData, new TypeReference<List<Tbdlichsu3>>() {
                    });
                for(Tbdlichsu3 l : lichsuLst){
                    if(l.getFiIdLichsu() == Long.parseLong(lichsuId)){
                        lichsu = l;
                        break;
                    }
                }
                if (lichsu != null) {
                    downloadFile(response, lichsu.getFiFileName(), lichsu.getFiFileName(), lichsu.getFiFileName(), lichsu.getFiFilePath());
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    private void downloadFile(HttpServletResponse response, String fileCode,
            String fileName, String fileCodeDb, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;
        String mimeType = "";
        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {
            String uri = getFullUri(environment.getProperty(ThuTuc02Constant.API.DƠNLOADFILE));
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

            Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
            Files.write(savePath, fileByte);

            File downloadFile = savePath.toFile();

            mimeType = URLConnection.guessContentTypeFromName(name);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + name + "\""));
            response.setContentLength((int) downloadFile.length());

            try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }

            downloadFile.delete();
        }
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND) + restUri;
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }
}
