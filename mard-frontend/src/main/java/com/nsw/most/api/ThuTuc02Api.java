/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.annotations.ErrorEntity;
import com.nsw.common.model.DataPost;
import com.nsw.common.model.TokhaiRequest;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.constant.ThuTuc02Constant;
import com.nsw.most.helper.ThuTuc02Helper;
import com.nsw.most.p02.model.CustomDocument2;
import com.nsw.most.p02.model.SearchForm02;
import com.nsw.most.p02.model.SearchFormLichsu02;
import com.nsw.most.p02.model.SendMessage02;
import com.nsw.most.p02.model.Tbdhoso2;
import com.nsw.most.p02.model.TbdkqktHh2;
import com.nsw.most.p02.model.Tbdlichsu2;
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
import java.util.Locale;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nhan
 */
@RestController
@RequestMapping("/most/02")
public class ThuTuc02Api {
    static final Logger logger = LoggerFactory.getLogger(ThuTuc02Api.class);
    private static final String CLASS_NAME = "ThuTuc02Api";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    MessageSource messageSource;

    ThuTuc02Helper helper = new ThuTuc02Helper();
    
    /**
     * Lay danh sach ho so theo tieu chi tim kiem
     *
     * @param search
     * @return
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson searchHoSo(@RequestBody SearchForm02 search) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        String uri = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_SEARCH));
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                search.setNguoiTao(user.getUsername());
                if (search.getNgayTaoDenNgay() != null) {
                    search.setNgayTaoDenNgay(DateTimeUtils.addHours(search.getNgayTaoDenNgay(), 23));
                }

                json = helper.searchHoSo(uri, search, mqInfo);
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
    ResponseJson createHoSo(@RequestBody Tbdhoso2 hoso, Locale loc) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                Date today = Calendar.getInstance().getTime();

                if (hoso.getFiIdHoso().equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    hoso.setFiTrangthai(ThuTuc02Constant.STATUS.TAO_MOI);
                    hoso.setFiTenTT(messageSource.getMessage(ThuTuc02Constant.STATUS.TAO_MOI_STR, null, loc));
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    if (checkPermission(hoso, ThuTuc02Constant.ACTION.UPDATE)) {
//                        Tbdhoso1 oldHoso = docExt.getDocument();
                    
                        hoso.setFiHoatdong(hoso.getFiHoatdong());
                        hoso.setFiIdHoso(hoso.getFiIdHoso());
                        hoso.setFiMaHoso(hoso.getFiMaHoso());
                        hoso.setFiMstDn(hoso.getFiMstDn());
                        hoso.setFiNgayGui(hoso.getFiNgayGui());
                        hoso.setFiNgaytao(hoso.getFiNgaytao());
                        hoso.setFiNguoitao(hoso.getFiNguoitao());
                        hoso.setFiTrangthai(hoso.getFiTrangthai());
                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                    
                    }

                     else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
                String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO));
                Tbdhoso2 hoso = helper.getHoSo(url, Long.parseLong(data.getFiIdHoso()), mqInfo);
                if (checkPermission(hoso, ThuTuc02Constant.ACTION.DELETE)) {
                    json = helper.deleteHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), data.getFiIdHoso(), mqInfo);
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
    ResponseJson history(@RequestBody SearchFormLichsu02 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument2 documentExt = checkPermissionByIdHoSo(data.getFiIdHoso());
                if (documentExt.getHasPermission()) {
                    json = helper.getHistory(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_SEARCH)), data, mqInfo);
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
                Tbdhoso2 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO)), Long.parseLong(data.getFiIdHoso()), mqInfo);

                if (checkPermission(hoso, ThuTuc02Constant.ACTION.DELAY)) {
                    String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_BY_IDHOSO_TRANGTHAI));

                    List<Tbdlichsu2> lichsuList = helper.findLichSuByHosoidAndTrangThai(hoso.getFiIdHoso(),
                            hoso.getFiTrangthai(), url, mqInfo);
                    
                    if (lichsuList != null) {
                        Tbdlichsu2 lichSu = lichsuList.get(0);
                        for(Tbdlichsu2 l : lichsuList){
                            if(l.getFiThoihan() != null){
                                System.out.println(l.getFiThoihan());
                                lichSu=l;
                                break;
                            }
                        }
                        if (lichSu != null) {
                            json.setSuccess(true);
                            json.setData(lichSu);
                        }
                    }
                    else{
                         json.setSuccess(true);
                        json.setData(null);
                    }

                } else {
                    json.setSuccess(false);
                    json.setData(null);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
     * lay thong tin ket qua kiem tra
     * @param data
     * @return 
     */
    @RequestMapping(value = {"/kqkt"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson kqktDetail(@RequestBody SearchFormLichsu02 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument2 documentExt = checkPermissionByIdHoSo(data.getFiIdHoso());
                if (documentExt.getHasPermission() != true) {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                } else {
                    TbdkqktHh2 result = helper.getKQKT(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_KQKT)), data.getFiIdHoso(), mqInfo);
                    json.setData(result);
                    json.setSuccess(true);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
    ResponseJson sendHoSo(@RequestBody Tbdhoso2 hoso, Locale loc) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        List<ErrorEntity> errors = new ArrayList<ErrorEntity>();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                Date today = Calendar.getInstance().getTime();
                if (hoso.getFiIdHoso() == 0) {
                    hoso.setFiNguoitao(user.getUsername());
                    hoso.setFiNgaytao(today);
                    hoso.setFiNgayGui(new Date());
                    hoso.setFiTrangthai(ThuTuc02Constant.STATUS.TAO_MOI);
                    hoso.setFiTenTT(messageSource.getMessage(ThuTuc02Constant.STATUS.TAO_MOI_STR, null, loc));
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    CustomDocument2 docExt = null;
                    if (hoso.getFiIdHoso() != null && !hoso.getFiIdHoso().equals(ThuTuc02Constant.DefaultValue.VALUE_0L)) {
                        docExt = checkPermissionByIdHoSo(hoso.getFiIdHoso());
                    }
                    if (null != docExt && docExt.getHasPermission()) {
                        Tbdhoso2 oldHoso = docExt.getDocument();
                        hoso.setFiHoatdong(oldHoso.getFiHoatdong());
                        hoso.setFiIdHoso(oldHoso.getFiIdHoso());
                        hoso.setFiMaHoso(oldHoso.getFiMaHoso());
                        hoso.setFiMstDn(oldHoso.getFiMstDn());
                        hoso.setFiNgayGui(new Date());
                        hoso.setFiNgaytao(oldHoso.getFiNgaytao());
                        hoso.setFiNguoitao(oldHoso.getFiNguoitao());
                        hoso.setFiTrangthai(oldHoso.getFiTrangthai());
                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                    } else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                        return json;
                    }
                }

                if (json.isSuccess()) {
                    SendMessage02 sendMessage = new SendMessage02();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso2 hosoData = mapper.readValue(jsonData, Tbdhoso2.class);
                    sendMessage.setFiIdHoso(hoso.getFiIdHoso());
                    Long trangThaiHoSo = hoso.getFiTrangthai();
                    String message = "";
                    //Kiem tra han xu ly neu ho so dang o trang thai xin gia han
                    boolean isVaild = true;
                    if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.YC_BO_SUNG)) {

                        List<Tbdlichsu2> lichsuList = helper.findLichSuByIdHoso(hoso.getFiIdHoso(), trangThaiHoSo,
                                getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_BY_IDHOSO)), mqInfo);

                        if (lichsuList != null) {
                            Tbdlichsu2 lichSu = helper.getYCBSHistory(lichsuList, trangThaiHoSo);
                            if (lichSu != null) {
                                if (lichSu.getFiThoihan() != null) {
                                    if (lichSu.getFiThoihan().before(today)) {
                                        isVaild = false;

                                        ErrorEntity errorItem = new ErrorEntity();
                                        errorItem.setError(Constants.ErrorCode.LOINGHIEPVU);
                                        errorItem.setFieldName(ThuTuc02Constant.ErrorMessage.ExpireProcessDate);
                                        errors.add(errorItem);
                                        json.setSuccess(false);
                                        json.setData(errors);
                                    }
                                }
                            }
                        }
                    }

                    if (isVaild) {
                        sendMessage.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_10);
                        if (trangThaiHoSo == null || Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.TAO_MOI)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_01);
                            sendMessage.setFiIdHoso(0L);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.CHO_TIEP_NHAN)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_02);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.YC_BO_SUNG)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_04);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.DA_TIEP_NHAN) ||
                                Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.THONGBAO_KIEMTRA) ||
                                Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.DA_BO_SUNG) ||
                                Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.DA_SUA_HOSO)){
                            sendMessage.setType(ThuTuc02Constant.KHCN02_TYPE.TYPE_13);
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_09);    
                            String reason = hoso.getFiLydoSua();
                            sendMessage.setReason(reason);
                        }
                        
                        sendMessage.setFiIdHoso(hosoData.getFiIdHoso());
                        json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_SEND)),
                                sendMessage, mqInfo);
                        
                            json.setData(hosoData);
                        
                    } else {
                        json.setSuccess(isVaild);
                        json.setMessage(message);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
    
     @RequestMapping(value = {"/getTbkt/"}, method = RequestMethod.POST)
    public ResponseJson getTbkt(@RequestBody DataPost data) {
        String apiURI = environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND);
        String id;
        id = data.getFiIdHoso();       
        ResponseJson history = helper.getDanhMuc(
                apiURI + environment.getRequiredProperty(ThuTuc02Constant.API.GET_TBKT) + id,
                rabbitMQService.getRabbitMQInfo()
        );
        return history;
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
    ResponseJson getXmlHoSo(@RequestBody Tbdhoso2 hoso) {
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
                    json = helper.createHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                } else {
                    
                    if (checkPermission(hoso, ThuTuc02Constant.ACTION.SEND)) {
                        json = helper.updateHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO)), hoso, mqInfo);
                    } else {
                        json.setSuccess(false);
                        json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                        return json;
                    }
                }

                if (json.isSuccess()) {
                    SendMessage02 sendMessage = new SendMessage02();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdhoso2 hosoData = mapper.readValue(jsonData, Tbdhoso2.class);

                    Long trangThaiHoSo = hosoData.getFiTrangthai();
                    sendMessage.setType(ThuTuc02Constant.MessageType.TYPE_10);
                    if (trangThaiHoSo == null || Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.TAO_MOI)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_01);
                            sendMessage.setFiIdHoso(0L);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.CHO_TIEP_NHAN)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_02);
                        } else if (Objects.equals(trangThaiHoSo, ThuTuc02Constant.STATUS.YC_BO_SUNG)) {
                            sendMessage.setFunction(ThuTuc02Constant.KHCN02_FUNCTION.FUNCTION_04);
                        }

                   
                    sendMessage.setFiIdHoso(hosoData.getFiIdHoso());
                    sendMessage.setGetXmlNotSend(true);

                    json = helper.sendHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_SEND)), sendMessage, mqInfo);
                    if (json.getSuccess()) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
                CustomDocument2 documentExt = checkPermissionByIdHoSo(Long.parseLong(data.getFiIdHoso()));
                if (documentExt.getHasPermission()) {
                    if (documentExt.getDocument().getFiTrangthai().equals(ThuTuc02Constant.STATUS.CHO_TIEP_NHAN)) {
                        json = helper.cancelHoSoChuaTiepNhan(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_CANCEL)), data, mqInfo);
                    } else {
                        json = helper.cancelHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_CANCEL)), data, mqInfo);
                    }
                    if (json.getSuccess() && data.getFiGetMessage() != null && data.getFiGetMessage()) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
                CustomDocument2 documentExt = checkPermissionByIdHoSo(Long.parseLong(data.getFiIdHoso()));
                if (documentExt.getHasPermission()) {
                    json = helper.delayHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_DELAY)), data, mqInfo);
                    if (json.getSuccess() && data.getFiGetMessage() != null && data.getFiGetMessage()) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }
            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson editHoSo(@RequestBody DataPost data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserCustom user = (UserCustom) principal;

            if (user != null) {
                CustomDocument2 documentExt = checkPermissionByIdHoSo(Long.parseLong(data.getFiIdHoso()));
                if (documentExt.getHasPermission()) {
                    json = helper.requestEditHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_REQUEST_EDIT)), data, mqInfo);
                    if (json.getSuccess() && data.getFiGetMessage()) {
                        String xmlBase64 = Base64.getEncoder().encodeToString(json.getData().toString().getBytes("utf-8"));
                        json.setData(xmlBase64);
                    }
                } else {
                    json.setSuccess(false);
                    json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
                }

            } else {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
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
        return environment.getRequiredProperty(ThuTuc02Constant.API.BACKEND) + restUri;
    }
    
    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }
    
    private Boolean checkPermission(Tbdhoso2 hoso, String action) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        //RabbitMQInfo mqInfo = getRabbitMQ();
        if (user.getUsername().equals(hoso.getFiNguoitao())) {
            if(action == "delete"){
                return Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.TAO_MOI);
            }
            if(action == ThuTuc02Constant.ACTION.UPDATE){
                return !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DACO_KQ_KIEMTRA)
                        || !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DA_RUT);
            }
            else if(action == ThuTuc02Constant.ACTION.DELAY){
//                  return true;
                return Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.YC_BO_SUNG);
            }
            else if(action == ThuTuc02Constant.ACTION.SEND){
                  return true;
//                return Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.YC_BO_SUNG);
            }
            else if(action == ThuTuc02Constant.ACTION.CANCEL){
//                return true;
                return !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DACO_KQ_KIEMTRA);
            }
        }
        return false;
    }
    
    private CustomDocument2 checkPermissionByIdHoSo(Long Id) {
        CustomDocument2 documentInfo = new CustomDocument2();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        RabbitMQInfo mqInfo = getRabbitMQ();

        documentInfo.setHasPermission(false);
        documentInfo.setDocument(null);

        if (Id.equals(ThuTuc02Constant.DefaultValue.VALUE_0L)) {
            return documentInfo;
        }

        String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO));

        Tbdhoso2 hoso = helper.getHoSo(url, Id, mqInfo);
        if (user.getUsername().equals(hoso.getFiNguoitao())) {
            documentInfo.setHasPermission(true);
            documentInfo.setDocument(hoso);
        }

        return documentInfo;
    }
    
}
