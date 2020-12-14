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
import com.nsw.constant.AppConstant;
import com.nsw.controller.FileUploadController;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.State;
import com.nsw.common.model.Unit;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.most.p01.model.*;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import com.nsw.util.DateTimeUtils;
import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PhongNguyen
 */
@RestController
@RequestMapping("/most/01")
@MultipartConfig(fileSizeThreshold = ThuTuc01Constant.FileUpload.fileSizeThreshold)
public class ThuTuc01FileController {

    static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static final String CLASS_NAME = "FileUploadController";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    private static final int BUFFER_SIZE = 4096;
    ThuTuc01Helper helper = new ThuTuc01Helper();
    FileServiceHelper fileHelper = new FileServiceHelper();

    @RequestMapping(value = "/kqdg/{fiIdCqxl}/{code}", method = RequestMethod.GET)
    public void downloadKqdg(HttpServletResponse response,
            @PathVariable("fiIdCqxl") String fiIdCqxl,
            @PathVariable("code") String code) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_GCN));

            TbdkqdgHh1 result = helper.getGCN(uri, Long.parseLong(fiIdCqxl), mqInfo);

            if (result != null) {
                downloadFile(response, code, result.getFiFileName(), result.getFiFileCode(), result.getFiFilePath());
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

    }

    @RequestMapping(value = "/kqktfile/{fiIdCqxl}/{code}", method = RequestMethod.GET)
    public void downloadKqkt(HttpServletResponse response,
            @PathVariable("fiIdCqxl") String fiIdCqxl,
            @PathVariable("code") String code) {
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_KQKT));
            TbdkqktHh1 result = helper.getKQKT(uri, Long.parseLong(fiIdCqxl), mqInfo);

            if (result != null) {
                downloadFile(response, code, result.getFiFileName(), result.getFiFileCode(), result.getFiFilePath());
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
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
            String uri = getFullUri("/most/01/download2/");
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
            String apiURI = environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND);
            if (file.isEmpty()) {
                json.setSuccess(false);
                json.setData(null);
                json.setMessage("");
            } else {
                String url = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.EXCEL));
                json = helper.importExcel(url, file, environment.getProperty(AppConstant.Download.TemSaveFolder), mqInfo);
                if (json.getSuccess()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    //Lay thong tin ho so import
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso1 hoso = mapper.readValue(jsonData, Tbdhoso1.class);

                    //Lay danh muc quoc gia
                    ResponseJson jsonState = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_QG), mqInfo);
                    String stateVal = mapper.writeValueAsString(jsonState.getData());
                    List<State> states = mapper.readValue(stateVal, new TypeReference<List<State>>() {
                    });

                    //Lay danh muc nhom hang hoa
                    ResponseJson jsonNHH = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_NHH), mqInfo);
                    String nhhVal = mapper.writeValueAsString(jsonNHH.getData());
                    List<Tbsnhomhh> tsbNhomHH = mapper.readValue(nhhVal, new TypeReference<List<Tbsnhomhh>>() {
                    });

                    //Lay danh muc loai hang hoa mien kiem
                    ResponseJson jsonLHHMK = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_MIENKIEM), mqInfo);
                    String hhmkVal = mapper.writeValueAsString(jsonLHHMK.getData());
                    List<Tbshhmienkiem> tbsHHMK = mapper.readValue(hhmkVal, new TypeReference<List<Tbshhmienkiem>>() {
                    });

                    //Lay danh muc QCVN
                    ResponseJson jsonQCVN = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_QCVN), mqInfo);
                    String qcvnVal = mapper.writeValueAsString(jsonQCVN.getData());
                    List<Tbsquychuanvn> tbsQCVN = mapper.readValue(qcvnVal, new TypeReference<List<Tbsquychuanvn>>() {
                    });

                    //Lay danh TCKT
                    ResponseJson jsonTCKT = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCKT), mqInfo);
                    String tcktVal = mapper.writeValueAsString(jsonTCKT.getData());
                    List<Tbstckiemtra> tbsTCKT = mapper.readValue(tcktVal, new TypeReference<List<Tbstckiemtra>>() {
                    });

                    //Lay danh TCDG
                    ResponseJson jsonTCDG = helper.getDanhMuc(apiURI + environment.getRequiredProperty(ThuTuc01Constant.API.DANHMUC_TCDG), mqInfo);
                    String tcdgVal = mapper.writeValueAsString(jsonTCDG.getData());
                    List<Tbstcgiamdinh> tbsTCDG = mapper.readValue(tcdgVal, new TypeReference<List<Tbstcgiamdinh>>() {
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
                        Date now = Calendar.getInstance().getTime();

                        if (!containQCVN(tbsQCVN, hoso.getFiMaQcvn())) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiTenQcvn");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                            errorItem.setExcelRow(7);
                            errorItem.setExcelCol(4);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        } else if (hoso.getFiMaQcvn().equals("8")) {
                            if (hoso.getFiTenQcvn() == null || "".equals(hoso.getFiTenQcvn())) {
                                errorItem = new ErrorEntity();
                                errorItem.setFieldName("fiTenQcvn");
                                errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                                errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                errorItem.setExcelRow(7);
                                errorItem.setExcelCol(4);
                                errors.add(errorItem);
                                json.setSuccess(false);
                                json.setData(errors);
                                return json;
                            }
                        }

                        //Check voi danh muc
                        //Check TCKT
                        if (!containTCKT(tbsTCKT, hoso.getFiMaTckt())) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiMaTckt");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                            errorItem.setExcelRow(2);
                            errorItem.setExcelCol(2);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        }
                        //Check TCCN
                        if (!containTCGD(tbsTCDG, hoso.getFiMaTcdg())) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiMaTcdg");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                            errorItem.setExcelRow(5);
                            errorItem.setExcelCol(4);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        }
                        //Kiem tra ngay nhap tu ngay den ngay
                        if (DateTimeUtils.compare2Date(hoso.getFiTuNgay(), now) == -1) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiTuNgay");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGNHOHON_NGAYHIENTAI);
                            errorItem.setExcelRow(0);
                            errorItem.setExcelCol(0);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        } else if (DateTimeUtils.compare2Date(hoso.getFiDenNgay(), now) == -1) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiDenNgay");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.KHONGNHOHON_NGAYHIENTAI);
                            errorItem.setExcelRow(0);
                            errorItem.setExcelCol(0);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        } else if (DateTimeUtils.compare2Date(hoso.getFiTuNgay(), hoso.getFiDenNgay()) == 1) {
                            errorItem = new ErrorEntity();
                            errorItem.setFieldName("fiDenNgay:fiTuNgay");
                            errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HS);
                            errorItem.setError(Constants.ErrorCode.V1_KHONGNHOHON_V2);
                            errorItem.setExcelRow(0);
                            errorItem.setExcelCol(0);
                            errors.add(errorItem);
                            json.setSuccess(false);
                            json.setData(errors);
                            return json;
                        } else {
                            //Kiem tra to khai
                            List<Tbdtokhaihq1> tokhaiList = hoso.getToKhaiHQ();
                            List<Tbdhanghoa1> hanghoaList = hoso.getHangHoa1();
                            Tbdtokhaihq1 tokhaiItem;

                            if (tokhaiList == null || (tokhaiList != null && tokhaiList.size() == 0)) {
                                ErrorEntity err = new ErrorEntity();
                                err.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.TK);
                                err.setError(Constants.ErrorCode.SHEETINVAILD);
                                err.setExcelRow(0);
                                err.setExcelCol(0);
                                errors.add(err);
                                json.setSuccess(false);
                                json.setData(errors);
                                return json;
                            }

                            if (hanghoaList == null || (hanghoaList != null && hanghoaList.size() == 0)) {
                                ErrorEntity err = new ErrorEntity();
                                err.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HH);
                                err.setError(Constants.ErrorCode.SHEETINVAILD);
                                err.setExcelRow(0);
                                err.setExcelCol(0);
                                errors.add(err);
                                json.setSuccess(false);
                                json.setData(errors);
                                return json;
                            }

                            int r = 12;
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
                            Tbdhanghoa1 item;
                            int startRow = 5;
                            State stateItem = null;
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
                                    errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HH);
                                    errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                    errorItem.setExcelRow(i + startRow);
                                    errorItem.setExcelCol(6);
                                    errors.add(errorItem);
                                    json.setSuccess(false);
                                    json.setData(errors);
                                    break;
                                } else if (!containNhomHH(tsbNhomHH, item.getFiManhom())) {
                                    errorItem = new ErrorEntity();
                                    errorItem.setFieldName("fiManhom");
                                    errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HH);
                                    errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                    errorItem.setExcelRow(i + startRow);
                                    errorItem.setExcelCol(2);
                                    errors.add(errorItem);
                                    json.setSuccess(false);
                                    json.setData(errors);
                                    break;
                                } else if (!containNhomHHMK(tbsHHMK, item.getFiMaMk())) {
                                    errorItem = new ErrorEntity();
                                    errorItem.setFieldName("fiMaMk");
                                    errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HH);
                                    errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                    errorItem.setExcelRow(i + startRow);
                                    errorItem.setExcelCol(15);
                                    errors.add(errorItem);
                                    json.setSuccess(false);
                                    json.setData(errors);
                                    break;
                                } else if (!containUnit(tbsUnit, item.getFiMaDv())) {
                                    errorItem = new ErrorEntity();
                                    errorItem.setFieldName("fiMaDv");
                                    errorItem.setSheetName(ThuTuc01Constant.EXCEL_SHEET_CODE.HH);
                                    errorItem.setError(Constants.ErrorCode.KHONGCOGIATRI);
                                    errorItem.setExcelRow(i + startRow);
                                    errorItem.setExcelCol(10);
                                    errors.add(errorItem);
                                    json.setSuccess(false);
                                    json.setData(errors);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND) + restUri;
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

    public static boolean containNhomHH(Collection<Tbsnhomhh> c, String code) {
        for (Tbsnhomhh s : c) {
            if (s != null && s.getFiMa().trim().equals(code)
                    && s.getFiHoatdong().equals(ThuTuc01Constant.DefaultValue.VALUE_1L)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containNhomHHMK(Collection<Tbshhmienkiem> c, String code) {
        for (Tbshhmienkiem s : c) {
            if (s != null && s.getFiMa().trim().equals(code)
                    && s.getFiHoatdong().equals(ThuTuc01Constant.DefaultValue.VALUE_1L)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containQCVN(Collection<Tbsquychuanvn> c, String code) {
        for (Tbsquychuanvn s : c) {
            if (s != null && s.getFiMa().trim().equals(code)
                    && s.getFiHoatdong().equals(ThuTuc01Constant.DefaultValue.VALUE_1L)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containTCGD(Collection<Tbstcgiamdinh> c, String code) {
        for (Tbstcgiamdinh s : c) {
            if (s != null && s.getFiMa().trim().equals(code)
                    && s.getFiHoatdong().equals(ThuTuc01Constant.DefaultValue.VALUE_1L)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containTCKT(Collection<Tbstckiemtra> c, String code) {
        for (Tbstckiemtra s : c) {
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

}
