/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.api;

import com.nsw.most.p01.model.SearchFormLichsu01;
import com.nsw.most.p01.model.Tbdhoso1;
import com.nsw.most.p01.model.TbdkqdgHh1;
import com.nsw.most.p01.model.TbdkqktHh1;
import com.nsw.most.p01.model.Tbdlichsu1;
import com.nsw.most.p01.model.CustomDocument;
import com.nsw.most.p01.model.SearchForm01;
import com.nsw.most.p01.model.SendMessage;
import com.nsw.common.model.TokhaiRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.annotations.ErrorEntity;
import com.nsw.api.BaseApi;
import com.nsw.common.model.DataPost;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.most.p01.model.Tbdhosocqxl1;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import com.nsw.util.DateTimeUtils;
import com.nsw.util.LogUtil;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhongNguyen
 */
@RestController
@RequestMapping("/most/01")
public class ThuTuc01Api extends BaseApi{

    static final Logger logger = LoggerFactory.getLogger(ThuTuc01Api.class);
    private static final String CLASS_NAME = "ThuTuc01Api";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    ThuTuc01Helper helper = new ThuTuc01Helper();
    
    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;
        try {
            switch (key) {
                case "HS_NHH":
                    json = BackendRequestHelper.getInstance().doGetRequest(ThuTuc01Constant.getInstance().getApiUrl(environment, ThuTuc01Constant.API.DANHMUC_NHH));
                    break;
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }
    /**
     * Lay danh sach ho so theo tieu chi tim kiem
     *
     * @param search
     * @return
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson searchHoSo(@RequestBody SearchForm01 search) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_SEARCH));
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                search.setNguoiTao(user.getUsername());
                if (search.getNgayTaoDenNgay() != null) {
                    search.setNgayTaoDenNgay(DateTimeUtils.addHours(search.getNgayTaoDenNgay(), 23));
                }

                if (search.getNgayGuiDenNgay() != null) {
                    search.setNgayGuiDenNgay(DateTimeUtils.addHours(search.getNgayGuiDenNgay(), 23));
                }

                json = helper.searchHoSo(uri, search, mqInfo);
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Tao moi ho so
     *
     * @param hoso
     * @return
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson createHoSo(@RequestBody Tbdhoso1 hoso) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;
            boolean addTCCN = false;
            boolean allowUpdate = true;
            if (user != null) {
                Date today = Calendar.getInstance().getTime();

                if (hoso.getFiIdHoso().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    CustomDocument docExt;
                    if (hoso.getFiIdCqxl() != null && !hoso.getFiIdCqxl().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                        docExt = checkPermission(hoso.getFiIdCqxl());
                    } else {
                        docExt = checkPermissionByIdHoSo(hoso.getFiIdHoso());
                    }

                    Tbdhoso1 oldHoso = docExt.getDocument();
                    if (docExt.getHasPermission()) {
                        hoso.setFiHoatdong(oldHoso.getFiHoatdong());
                        hoso.setFiIdHoso(oldHoso.getFiIdHoso());
                        hoso.setFiMaHoSo(oldHoso.getFiMaHoSo());
                        hoso.setFiMst(oldHoso.getFiMst());
                        hoso.setFiNgayGui(oldHoso.getFiNgayGui());
                        hoso.setFiNgaytao(oldHoso.getFiNgaytao());
                        hoso.setFiNguoitao(oldHoso.getFiNguoitao());
                        hoso.setFiTrangThai(oldHoso.getFiTrangThai());

                        //Co phai chon/bo chon TCCN?
                        if (oldHoso.getFiMaTcdg() == null && oldHoso.getFiTenTcdg() == null
                                && hoso.getFiMaTcdg() != null && hoso.getFiTenTcdg() != null) {
                            addTCCN = true;
                        } else if (oldHoso.getFiMaTcdg() != null && oldHoso.getFiTenTcdg() != null
                                && hoso.getFiMaTcdg() == null && hoso.getFiTenTcdg() == null) {
                            addTCCN = true;
                        }

                        if (addTCCN) {
                            List<Tbdhosocqxl1> lstCqxl = helper.findCqxl(hoso.getFiIdHoso(),
                                    getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_CQXL_GETALL)), mqInfo);
                            if (lstCqxl != null) {
                                int len = lstCqxl.size();
                                for (int c = 0; c < len; c++) {
                                    if (!Objects.equals(lstCqxl.get(c).getFiTrangthai(), ThuTuc01Constant.Status.MOI_TAO)
                                            && !Objects.equals(lstCqxl.get(c).getFiTrangthai(), ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                                        json.setSuccess(false);
                                        json.setMessage(ThuTuc01Constant.ErrorMessage.NOT_SAVE_DOCUMENT);
                                        allowUpdate = false;
                                        break;
                                    }
                                }
                            } else {
                                allowUpdate = false;
                                json.setSuccess(false);
                                json.setMessage(ThuTuc01Constant.ErrorMessage.NOT_FOUND_CQXL);
                            }
                        }

                        if (allowUpdate) {
                            json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                        }
                    } else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * *
     * Luu va gui ho so sang BKHCN
     *
     * @param hoso
     * @return
     */
    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson sendHoSo(@RequestBody Tbdhoso1 hoso) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        List<ErrorEntity> errors = new ArrayList<ErrorEntity>();
        boolean addTCCN = false;
        boolean allowUpdate = true;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                Date today = Calendar.getInstance().getTime();

                if (hoso.getFiIdHoso() == 0) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    CustomDocument docExt;
                    if (hoso.getFiIdCqxl() != null && !hoso.getFiIdCqxl().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                        docExt = checkPermission(hoso.getFiIdCqxl());
                    } else {
                        docExt = checkPermissionByIdHoSo(hoso.getFiIdHoso());
                    }
                    if (docExt.getHasPermission()) {
                        Tbdhoso1 oldHoso = docExt.getDocument();

                        hoso.setFiHoatdong(oldHoso.getFiHoatdong());
                        hoso.setFiIdHoso(oldHoso.getFiIdHoso());
                        hoso.setFiMaHoSo(oldHoso.getFiMaHoSo());
                        hoso.setFiMst(oldHoso.getFiMst());
                        hoso.setFiNgayGui(oldHoso.getFiNgayGui());
                        hoso.setFiNgaytao(oldHoso.getFiNgaytao());
                        hoso.setFiNguoitao(oldHoso.getFiNguoitao());
                        hoso.setFiTrangThai(oldHoso.getFiTrangThai());

                        //Co phai chon them TCCN vao ho so?
                        if (oldHoso.getFiMaTcdg() == null && oldHoso.getFiTenTcdg() == null
                                && hoso.getFiMaTcdg() != null && hoso.getFiTenTcdg() != null) {
                            addTCCN = true;
                        } else if (oldHoso.getFiMaTcdg() != null && oldHoso.getFiTenTcdg() != null
                                && hoso.getFiMaTcdg() == null && hoso.getFiTenTcdg() == null) {
                            addTCCN = true;
                        }

                        if (addTCCN) {
                            List<Tbdhosocqxl1> lstCqxl = helper.findCqxl(hoso.getFiIdHoso(),
                                    getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_CQXL_GETALL)), mqInfo);
                            if (lstCqxl != null) {
                                int len = lstCqxl.size();
                                for (int c = 0; c < len; c++) {
                                    if (!Objects.equals(lstCqxl.get(c).getFiTrangthai(), ThuTuc01Constant.Status.MOI_TAO)
                                            && !Objects.equals(lstCqxl.get(c).getFiTrangthai(), ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                                        json.setSuccess(false);
                                        json.setMessage(ThuTuc01Constant.ErrorMessage.NOT_SAVE_DOCUMENT);
                                        allowUpdate = false;
                                        break;
                                    }
                                }
                            } else {
                                allowUpdate = false;
                                json.setSuccess(false);
                                json.setMessage(ThuTuc01Constant.ErrorMessage.NOT_FOUND_CQXL);
                            }
                        }

                        if (allowUpdate) {
                            json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                        }
                    } else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                        return json;
                    }
                }

                if (json.isSuccess()) {
                    SendMessage sendMessage = new SendMessage();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso1 hosoData = mapper.readValue(jsonData, Tbdhoso1.class);
                    sendMessage.setFiIdCqxl(hoso.getFiIdCqxl());
                    Long trangThaiHoSo = hoso.getFiTrangThai();
                    String message = "";
                    //Kiem tra han xu ly neu ho so dang o trang thai xin gia han
                    boolean isVaild = true;
                    if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_XIN_LUI_HAN_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_YEU_CAU_BS_HOSO)) {

                        List<Tbdlichsu1> lichsuList = helper.findLichSuByCqxlAndTrangThai(hoso.getFiIdCqxl(), trangThaiHoSo,
                                getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_HISTORY_BY_CQXL_TRANGTHAI)), mqInfo);

                        if (lichsuList != null) {
                            Tbdlichsu1 lichSu = helper.getYCBSHistory(lichsuList, trangThaiHoSo);
                            if (lichSu != null) {
                                if (lichSu.getFiThoihan() != null) {
                                    if (lichSu.getFiThoihan().before(today)) {
                                        isVaild = false;

                                        ErrorEntity errorItem = new ErrorEntity();
                                        errorItem.setError(Constants.ErrorCode.LOINGHIEPVU);
                                        errorItem.setFieldName(ThuTuc01Constant.ErrorMessage.ExpireProcessDate);
                                        errors.add(errorItem);
                                        json.setSuccess(false);
                                        json.setData(errors);
                                    }
                                }
                            }
                        }
                    }

                    if (isVaild) {
                        sendMessage.setType(ThuTuc01Constant.MessageType.TYPE_10);
                        if (trangThaiHoSo == null || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.MOI_TAO)) {
                            sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_01);
                            sendMessage.setFiIdCqxl(0L);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                            sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_02);
                            //Neu chon them TCCN vao ho so thi set gia tri IdCQXL = 0 de gui ho so cho TCCN luon
                            if (addTCCN) {
                                sendMessage.setFiIdCqxl(0L);
                            }
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_YEU_CAU_BS_HOSO)
                                || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_YEU_CAU_XIN_SUA_HOSO)
                                || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_XIN_LUI_HAN_HOSO)) {
                            sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_04);
                        }

                        sendMessage.setFiIdHoso(hosoData.getFiIdHoso());
                        json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_SEND)),
                                sendMessage, mqInfo);
                        if (json.getSuccess()) {
                            json.setData(hosoData);
                        }
                    } else {
                        json.setSuccess(isVaild);
                        json.setMessage(message);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }
        return json;
    }

    /**
     * *
     * Luu va lay ban tin xml
     *
     * @param hoso
     * @return
     */
    @RequestMapping(value = {"/xml"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getXmlHoSo(@RequestBody Tbdhoso1 hoso) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                Date today = Calendar.getInstance().getTime();

                if (hoso.getFiIdHoso() == 0) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    CustomDocument documentExt = checkPermission(hoso.getFiIdCqxl());
                    if (documentExt.getHasPermission()) {
                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), hoso, mqInfo);
                    } else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                        return json;
                    }
                }

                if (json.isSuccess()) {
                    SendMessage sendMessage = new SendMessage();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso1 hosoData = mapper.readValue(jsonData, Tbdhoso1.class);

                    Long trangThaiHoSo = hosoData.getFiTrangThai();

                    sendMessage.setType(ThuTuc01Constant.MessageType.TYPE_10);
                    if (trangThaiHoSo == null || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.MOI_TAO)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_01);
                        sendMessage.setFiIdCqxl(0L);
                    } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_02);
                    } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_YEU_CAU_BS_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_YEU_CAU_XIN_SUA_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_XIN_LUI_HAN_HOSO)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_04);
                    }

                    sendMessage.setFiIdCqxl(hosoData.getFiIdCqxl());
                    sendMessage.setFiIdHoso(hosoData.getFiIdHoso());
                    sendMessage.setGetXmlNotSend(true);

                    json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_SEND)), sendMessage, mqInfo);
                    if (json.getSuccess()) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * *
     * Luu va lay ban tin xml
     *
     * @param message
     * @param hoso
     * @return
     */
    @RequestMapping(value = {"/sendwithsignature"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson sendDocumentSignedXml(@RequestBody DataPost message) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = new CustomDocument();
                if (message.getFiIdCqxl() == null || message.getFiIdCqxl().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    documentExt.setHasPermission(true);
                } else {
                    documentExt = checkPermission(Long.valueOf(message.getFiIdCqxl()));
                }
                if (documentExt.getHasPermission()) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setSignedXml(message.getFiSignedXml());
                    sendMessage.setType(ThuTuc01Constant.MessageType.TYPE_10);

                    Long trangThaiHoSo = documentExt.getDocument().getFiTrangThai();
                    if (trangThaiHoSo == null || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.MOI_TAO)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_01);
                        sendMessage.setFiIdCqxl(0L);
                    } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_02);
                    } else if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_YEU_CAU_BS_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_YEU_CAU_XIN_SUA_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_XIN_LUI_HAN_HOSO)) {
                        sendMessage.setFunction(ThuTuc01Constant.MessageFunction.FUN_04);
                    }

                    sendMessage.setFiIdCqxl(Long.valueOf(message.getFiIdCqxl()));
                    sendMessage.setFiIdHoso(Long.valueOf(message.getFiIdHoso()));
                    sendMessage.setGetXmlNotSend(false);

                    json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), sendMessage, mqInfo);

                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                    return json;
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Xoa ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson deleteHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(Long.parseLong(data.getFiIdCqxl()));
                if (documentExt.getHasPermission()) {
                    json = helper.deleteHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO)), data.getFiIdHoso(), mqInfo);
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Xin huy ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/cancel"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson cancelHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(Long.parseLong(data.getFiIdCqxl()));
                if (documentExt.getHasPermission()) {
                    if (documentExt.getDocument().getFiTrangThai().equals(ThuTuc01Constant.Status.CHO_TIEP_NHAN)) {
                        json = helper.cancelHoSoChuaTiepNhan(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_REQUEST_CANCEL)), data, mqInfo);
                    } else {
                        json = helper.cancelHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_REQUEST_CANCEL)), data, mqInfo);
                    }
                    if (json.getSuccess() && data.getFiGetMessage() != null) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Xin gia han ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/delay"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson delayHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(Long.parseLong(data.getFiIdCqxl()));
                if (documentExt.getHasPermission()) {
                    json = helper.delayHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_REQUEST_DELAY)), data, mqInfo);
                    if (json.getSuccess() && data.getFiGetMessage() != null) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Lay thong tin lui han hien tai
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/getcurrentdelay"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getDelayTime(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt;

                if (data.getFiIdCqxl() != null && !data.getFiIdCqxl().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    documentExt = checkPermission(Long.valueOf(data.getFiIdCqxl()));
                } else {
                    documentExt = checkPermissionByIdHoSo(Long.valueOf(data.getFiIdHoso()));
                }

                if (documentExt.getHasPermission()) {
                    Long trangThaiHoSo = documentExt.getDocument().getFiTrangThai();
                    String url = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_HISTORY_BY_CQXL_TRANGTHAI));
                    if (Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_DONG_Y_XIN_LUI_HAN_HOSO)
                            || Objects.equals(trangThaiHoSo, ThuTuc01Constant.Status.BKHCN_YEU_CAU_BS_HOSO)) {

                        List<Tbdlichsu1> lichsuList = helper.findLichSuByCqxlAndTrangThai(documentExt.getDocument().getFiIdCqxl(),
                                trangThaiHoSo, url, mqInfo);

                        if (lichsuList != null) {
                            Tbdlichsu1 lichSu = lichsuList.get(0);
                            if (lichSu != null) {
                                json.setSuccess(true);
                                json.setData(lichSu);
                            }
                        }
                    } else {
                        json.setSuccess(true);
                        json.setData(null);
                    }
                } else {
                    json.setSuccess(false);
                    json.setData(null);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Xin chinh sua ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/redit"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson editHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(Long.parseLong(data.getFiIdCqxl()));
                if (documentExt.getHasPermission()) {
                    json = helper.requestEditHoSo(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_REQUEST_DEDIT)), data, mqInfo);
                    if (json.getSuccess() && data.getFiGetMessage() != null) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }

            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Lay thong tin to khai
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/tokhai"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getToKhai(@RequestBody TokhaiRequest data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                data.setMst(user.getUsername());
                String url = environment.getRequiredProperty(AppConstant.Common.COMMONURL) + environment.getRequiredProperty(AppConstant.API.NSW_API_TOKHAI);
                json = helper.getToKhai(url, data, mqInfo);
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    /**
     * Lay du lieu lich su xu ly ho so
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/history"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson history(@RequestBody SearchFormLichsu01 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(data.getFiIdCqxl());
                if (documentExt.getHasPermission()) {
                    json = helper.getHistory(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_HISTORY)), data, mqInfo);
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    @RequestMapping(value = {"/gcn"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson gcnDetail(@RequestBody SearchFormLichsu01 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(data.getFiIdCqxl());
                if (documentExt.getHasPermission() != true) {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                } else {
                    TbdkqdgHh1 result = helper.getGCN(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_GCN)), data.getFiIdCqxl(), mqInfo);
                    json.setData(result);
                    json.setSuccess(true);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    @RequestMapping(value = {"/kqkt"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson kqktDetail(@RequestBody SearchFormLichsu01 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument documentExt = checkPermission(data.getFiIdCqxl());
                if (documentExt.getHasPermission() != true) {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
                } else {
                    TbdkqktHh1 result = helper.getKQKT(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_KQKT)), data.getFiIdCqxl(), mqInfo);
                    json.setData(result);
                    json.setSuccess(true);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    private String getFullUri(String restUri) {
        return environment.getRequiredProperty(ThuTuc01Constant.API.BACKEND) + restUri;
    }

    /**
     * Kiem tra quyen nguoi dung doi voi ho so
     *
     * @param documentId
     * @return
     */
    private CustomDocument checkPermission(Long IdCqxl) {
        CustomDocument documentInfo = new CustomDocument();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        RabbitMQInfo mqInfo = getRabbitMQ();

        documentInfo.setHasPermission(false);
        documentInfo.setDocument(null);

        if (IdCqxl.equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
            return documentInfo;
        }

        String url = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO));

        Tbdhoso1 hoso = helper.getHoSo(url, IdCqxl, mqInfo);
        if (user.getUsername().equals(hoso.getFiNguoitao())) {
            documentInfo.setHasPermission(true);
            documentInfo.setDocument(hoso);
        }

        return documentInfo;
    }

    private CustomDocument checkPermissionByIdHoSo(Long IdHoSo) {
        CustomDocument documentInfo = new CustomDocument();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        RabbitMQInfo mqInfo = getRabbitMQ();

        documentInfo.setHasPermission(false);
        documentInfo.setDocument(null);

        if (IdHoSo.equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
            return documentInfo;
        }
        String url = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_ID));
        Tbdhoso1 hoso = helper.getHoSo(url, IdHoSo, mqInfo);
        if (user.getUsername().equals(hoso.getFiNguoitao())) {
            documentInfo.setHasPermission(true);
            documentInfo.setDocument(hoso);
        }

        return documentInfo;
    }
}
