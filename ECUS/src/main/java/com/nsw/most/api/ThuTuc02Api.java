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

            if (search.getNguoiTao() != null && "".equals(search.getNguoiTao().trim())) {
                search.setNguoiTao(null);
            }

            if (search.getSoThongBao() != null && "".equals(search.getSoThongBao().trim())) {
                search.setSoThongBao(null);
            }
            if (search.getNgayTaoDenNgay() != null) {
                search.setNgayTaoDenNgay(DateTimeUtils.addHours(search.getNgayTaoDenNgay(), 23));
            }

            json = helper.searchHoSo(uri, search, mqInfo);

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

            CustomDocument2 documentExt = checkPermissionByIdHoSo(data.getFiIdHoso());
            if (documentExt.getHasPermission()) {
                json = helper.getHistory(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_SEARCH)), data, mqInfo);
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

            Tbdhoso2 hoso = helper.getHoSo(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO)), Long.parseLong(data.getFiIdHoso()), mqInfo);

            if (checkPermission(hoso, ThuTuc02Constant.ACTION.DELAY)) {
                String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_HISTORY_BY_IDHOSO_TRANGTHAI));

                List<Tbdlichsu2> lichsuList = helper.findLichSuByHosoidAndTrangThai(hoso.getFiIdHoso(),
                        hoso.getFiTrangthai(), url, mqInfo);

                if (lichsuList != null) {
                    Tbdlichsu2 lichSu = lichsuList.get(0);
                    for (Tbdlichsu2 l : lichsuList) {
                        if (l.getFiThoihan() != null) {
                            System.out.println(l.getFiThoihan());
                            lichSu = l;
                            break;
                        }
                    }
                    if (lichSu != null) {
                        json.setSuccess(true);
                        json.setData(lichSu);
                    }
                } else {
                    json.setSuccess(true);
                    json.setData(null);
                }

            } else {
                json.setSuccess(false);
                json.setData(null);
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
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/kqkt"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson kqktDetail(@RequestBody SearchFormLichsu02 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {

            CustomDocument2 documentExt = checkPermissionByIdHoSo(data.getFiIdHoso());
            if (documentExt.getHasPermission() != true) {
                json.setSuccess(false);
                json.setMessage(ThuTuc02Constant.ErrorMessage.ACCESS_DENIED);
            } else {
                TbdkqktHh2 result = helper.getKQKT(getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.HOSO_KQKT)), data.getFiIdHoso(), mqInfo);
                json.setData(result);
                json.setSuccess(true);
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

        if (action == "delete") {
            return Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.TAO_MOI);
        }
        if (action == ThuTuc02Constant.ACTION.UPDATE) {
            return !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DACO_KQ_KIEMTRA)
                    || !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DA_RUT);
        } else if (action == ThuTuc02Constant.ACTION.DELAY) {
            return Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.YC_BO_SUNG);
        } else if (action == ThuTuc02Constant.ACTION.SEND) {
            return true;
        } else if (action == ThuTuc02Constant.ACTION.CANCEL) {
            return !Objects.equals(hoso.getFiTrangthai(), ThuTuc02Constant.STATUS.DACO_KQ_KIEMTRA);
        }
        return true;
    }

    private CustomDocument2 checkPermissionByIdHoSo(Long Id) {
        CustomDocument2 documentInfo = new CustomDocument2();
        RabbitMQInfo mqInfo = getRabbitMQ();

        documentInfo.setHasPermission(false);
        documentInfo.setDocument(null);

        if (Id.equals(ThuTuc02Constant.DefaultValue.VALUE_0L)) {
            return documentInfo;
        }

        String url = getFullUri(environment.getRequiredProperty(ThuTuc02Constant.API.GETHOSO));

        Tbdhoso2 hoso = helper.getHoSo(url, Id, mqInfo);

        documentInfo.setHasPermission(true);
        documentInfo.setDocument(hoso);

        return documentInfo;
    }

}
