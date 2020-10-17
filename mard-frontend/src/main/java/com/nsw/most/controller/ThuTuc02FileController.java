/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.annotations.ErrorEntity;
import com.nsw.annotations.ValidatorUtil;
import com.nsw.common.model.ResponseDownload;
import com.nsw.constant.AppConstant;
import com.nsw.controller.FileUploadController;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.State;
import com.nsw.common.model.Unit;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.most.helper.ThuTuc02Helper;
import com.nsw.most.p02.model.SearchForm02;
import com.nsw.most.p02.model.SearchFormLichsu02;
import com.nsw.most.p02.model.Tbddinhkem2;
import com.nsw.most.p02.model.Tbdhanghoa2;
import com.nsw.most.p02.model.Tbdhoso2;
import com.nsw.most.p02.model.TbdkqktHh2;
import com.nsw.most.p02.model.Tbdlichsu2;
import com.nsw.most.p02.model.Tbdtokhaihq2;
import com.nsw.most.p02.model.Tbscqkt2;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import com.nsw.util.DateTimeUtils;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PhongNguyen
 */
@RestController
@RequestMapping("/most/02")
@MultipartConfig(fileSizeThreshold = ThuTuc01Constant.FileUpload.fileSizeThreshold)
public class ThuTuc02FileController {

    static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static final String CLASS_NAME = "FileUploadController";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    private static final int BUFFER_SIZE = 4096;
    ThuTuc02Helper helper = new ThuTuc02Helper();
    FileServiceHelper fileHelper = new FileServiceHelper();

    @RequestMapping(value = "/kqktfile/{code}", method = RequestMethod.GET)
    public void downloadKqkt(HttpServletResponse response,
            @PathVariable("code") String code) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                String uri = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_KQKT));
                TbdkqktHh2 result = helper.getKQKT(uri, Long.parseLong(code), mqInfo);

                if (result != null) {
                    downloadFile(response, result.getFiFileCode(), result.getFiFileName(), result.getFiFileCode(), result.getFiFilePath());
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    @RequestMapping(value = "/fileDinhKem/{hosoId}/{fileId}", method = RequestMethod.GET)
    public void downloadDinhKem(HttpServletResponse response,
            @PathVariable("hosoId") String hosoId,
            @PathVariable("fileId") String fileId) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                String uri = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO));
                Tbdhoso2 hoso = helper.getHoSo(uri, Long.parseLong(hosoId), mqInfo);

                if (hoso != null) {
                    Tbddinhkem2 dinhkem = null;
                    for (Tbddinhkem2 d : hoso.getTepDinhKems()) {
                        if (d.getFiIdDinhkem() == Long.parseLong(fileId)) {
                            dinhkem = d;
                        }
                    }
                    if (null != dinhkem) {
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
    }

    @RequestMapping(value = "/dinhkemLS/{lichsuId}/{hosoId}", method = RequestMethod.GET)
    public void downloadDinhKemLichSu(HttpServletResponse response,
            @PathVariable("lichsuId") String lichsuId,
            @PathVariable("hosoId") String hosoId) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                String uri = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_SEARCH));
                Tbdlichsu2 lichsu = null;
                List<Tbdlichsu2> lichsuLst = helper.findLichSuByIdHoso(Long.parseLong(hosoId), null, uri, mqInfo);
                for (Tbdlichsu2 ls : lichsuLst) {
                    if (ls.getFiIdLichsu() == Long.parseLong(lichsuId)) {
                        lichsu = ls;
                        break;
                    }
                }
                if (lichsu != null) {
                    downloadFile(response, lichsu.getFiFileCode(), lichsu.getFiFileName(), lichsu.getFiFileCode(), lichsu.getFiFilePath());
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

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson importExcel(@RequestParam("file") MultipartFile file) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND);
            if (file.isEmpty()) {
                json.setSuccess(false);
                json.setData(null);
                json.setMessage("");
            } else {
                String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.EXCEL));
                json = helper.importExcel(url, file, environment.getProperty(AppConstant.Download.TemSaveFolder), mqInfo);
                if (json.getSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    //Lay thong tin ho so import
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso2 hoso = mapper.readValue(jsonData, Tbdhoso2.class);

                    //Lay danh muc quoc gia
                    ResponseJson jsonState = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_QG), mqInfo);
                    String stateVal = mapper.writeValueAsString(jsonState.getData());
                    List<State> states = mapper.readValue(stateVal, new TypeReference<List<State>>() {
                    });

                    //Lay danh TCKT
                    ResponseJson jsonTCKT = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc02Constant.API.COQUANXULY), mqInfo);
                    String tcktVal = mapper.writeValueAsString(jsonTCKT.getData());
                    List<Tbscqkt2> tbsTCKT = mapper.readValue(tcktVal, new TypeReference<List<Tbscqkt2>>() {
                    });

                    //Lay danh muc DVT
                    ResponseJson jsonUnit = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_DVT), mqInfo);
                    String unitVal = mapper.writeValueAsString(jsonUnit.getData());
                    List<Unit> tbsUnit = mapper.readValue(unitVal, new TypeReference<List<Unit>>() {
                    });

                    ValidatorUtil.validateEntity(hoso);
                    ErrorEntity errorItem;
                    List<ErrorEntity> errors = new ArrayList<ErrorEntity>();
                    if (hoso.getErrors() != null && hoso.getErrors().size() > 0) {
                        json.setSuccess(false);
                        json.setData(hoso.getErrors());
                    } else {

                        //Check voi danh muc
                        //Check TCKT
                        if (!containTCKT(tbsTCKT, hoso.getFiMaCqCap())) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiMaTckt");
                            errorItem.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                            errorItem.setExcelRow(2);
                            errorItem.setExcelCol(2);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        } else if (hoso.getFiDiachiKho() == null || hoso.getFiDiachiKho().length() == 0) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiDiachiKho");
                            errorItem.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                            errorItem.setExcelRow(6);
                            errorItem.setExcelCol(4);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        }
                        //Kiem tra to khai
                        List<Tbdtokhaihq2> tokhaiList = hoso.getToKhaiHQs();
                        List<Tbdhanghoa2> hanghoaList = hoso.getHangHoas();
                        Tbdtokhaihq2 tokhaiItem;

                        //check null to khai
                        if (tokhaiList == null || (tokhaiList != null && tokhaiList.size() == 0)) {
                            ErrorEntity err = new ErrorEntity();
                            err.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.TK);
                            err.setError(Constants.ErrorCode.SHEETINVAILD);
                            err.setExcelRow(0);
                            err.setExcelCol(0);
                            errors.add(err);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        }

                        //check null hang hoa
                        if (hanghoaList == null || (hanghoaList != null && hanghoaList.size() == 0)) {
                            ErrorEntity err = new ErrorEntity();
                            err.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.HH);
                            err.setError(Constants.ErrorCode.SHEETINVAILD);
                            err.setExcelRow(0);
                            err.setExcelCol(0);
                            errors.add(err);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        }

                        int r = 9;
                        for (int i = 0, len = tokhaiList.size(); i < len; i++) {
                            r += i;
                            tokhaiItem = tokhaiList.get(i);
                            ValidatorUtil.validateEntity(tokhaiItem);
                            if (tokhaiItem.getErrors().size() > 0) {
                                errorItem = tokhaiItem.getErrors().get(0);
                                if (errorItem.getExcelRow() == 0) {
                                    errorItem.setExcelRow(r);
                                }
                                json.setSuccess(false);
                                json.setData(tokhaiItem.getErrors());
                                break;
                            }
                        }

                        //Kiem tra hang hoa                        
                        Tbdhanghoa2 item;
                        int startRow = 5;
                        State stateItem;
                        for (int i = 0, len = hanghoaList.size(); i < len; i++) {
                            item = hanghoaList.get(i);
                            ValidatorUtil.validateEntity(item);
                            stateItem = containState(states, item.getFiMaQg());
                            if (item.getFiMaQg() != null && ("".equals(item.getFiTenQg()) || null == item.getFiTenQg())) {
                                if (stateItem != null) {
                                    item.setFiTenQg(stateItem.getName());
                                }
                            }

                            if (item.getErrors().size() > 0) {
                                errorItem = item.getErrors().get(0);
                                if (errorItem.getExcelRow() == 0) {
                                    errorItem.setExcelRow(i + startRow);
                                }
                                json.setSuccess(false);
                                json.setData(item.getErrors());
                                break;
                            } else if (stateItem == null) {
                                errorItem = new ErrorEntity();
                                errorItem.setFieldName("fiMaQg");
                                errorItem.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.HH);
                                errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                errorItem.setExcelRow(i + startRow);
                                errorItem.setExcelCol(4);
                                errors.add(errorItem);
                                json.setSuccess(false);
                                json.setData(errors);
                                break;
                            } else if (!containUnit(tbsUnit, item.getFiMaDv())) {
                                errorItem = new ErrorEntity();
                                errorItem.setFieldName("fiMaDv");
                                errorItem.setSheetName(ThuTuc02Constant.EXCEL_SHEET_CODE.HH);
                                errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                errorItem.setExcelRow(i + startRow);
                                errorItem.setExcelCol(8);
                                errors.add(errorItem);
                                json.setSuccess(false);
                                json.setData(errors);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND) + restUri;
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }

    public static State containState(Collection<State> c, String code) {
        for (State s : c) {
            if (s != null && s.getStatecode().trim().equals(code)
                    && ThuTuc01Constant.DefaultValue.VALUE_0S.equals(s.getIsdelete())) {
                return s;
            }
        }
        return null;
    }

    public static boolean containTCKT(Collection<Tbscqkt2> c, String code) {
        for (Tbscqkt2 s : c) {
            if (s != null && s.getFiMa().trim().equals(code)
                    && s.getFiHoatdong().equals(ThuTuc01Constant.DefaultValue.VALUE_1L)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containUnit(Collection<Unit> c, String code) {
        for (Unit s : c) {
            if (s != null && s.getUnitcode().trim().equals(code)
                    && s.getIsdelete().equals(ThuTuc01Constant.DefaultValue.VALUE_0S)) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/hosofile/{code}", method = RequestMethod.GET)
    public void downloadHoso(HttpServletResponse response,
            @PathVariable("code") String code) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ResponseJson result;
        if (principal instanceof UserDetails) {

            try {
                Tbdhoso2 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO)), Long.parseLong(code), mqInfo);
                String uri = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.DOC_HOSO));
                result = downloadDoc(uri, hoso, mqInfo);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(result.getData());
                ResponseDownload res = mapper.readValue(jsonData, ResponseDownload.class);
                byte[] data = (byte[]) res.getContent();

                saveFile(data, response, mqInfo);

            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    private ResponseJson downloadDoc(String url, Tbdhoso2 hoso, RabbitMQInfo mqInfo) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Tbdhoso2> entity = new HttpEntity<>(hoso, headers);
            json = restTemplate.postForObject(url, entity, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            if (json == null) {
                json = new ResponseJson();
            }
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    private void saveFile(byte[] fileByte, HttpServletResponse response, RabbitMQInfo mqInfo) {
        String mimeType = "";
        try {
            String name = "HoSo" + AppConstant.getVersion() + ".pdf";
//        String savePath = "";
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
            response.setCharacterEncoding("UTF-8");
            try (OutputStream outStream = response.getOutputStream();
                    FileInputStream inputStream = new FileInputStream(downloadFile)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }

//            downloadFile.delete();
        } catch (Exception e) {
            LogUtil.addLog(e);
        }
    }
}
