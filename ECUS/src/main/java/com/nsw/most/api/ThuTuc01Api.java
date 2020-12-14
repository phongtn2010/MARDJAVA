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
import com.nsw.most.p01.model.CustomDocument;
import com.nsw.most.p01.model.SearchForm;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.most.helper.ThuTuc01Helper;
import com.nsw.service.RabbitMQService;
import com.nsw.util.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhongNguyen
 */
@RestController
@RequestMapping("/most/01")
public class ThuTuc01Api {

    static final Logger logger = LoggerFactory.getLogger(ThuTuc01Api.class);
    private static final String CLASS_NAME = "ThuTuc01Api";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    ThuTuc01Helper helper = new ThuTuc01Helper();

    /**
     * Lay danh sach ho so theo tieu chi tim kiem
     *
     * @param search
     * @return
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson searchHoSo(@RequestBody SearchForm search) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        String uri = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_SEARCH));
        try {
            
            if (search.getNgayTaoDenNgay() != null) {
                search.setNgayTaoDenNgay(DateTimeUtils.addHours(search.getNgayTaoDenNgay(), 23));
            }

            if (search.getNgayGuiDenNgay() != null) {
                search.setNgayGuiDenNgay(DateTimeUtils.addHours(search.getNgayGuiDenNgay(), 23));
            }
            
            if (search.getThongBaoTuNgay()!= null) {
                search.setThongBaoTuNgay(DateTimeUtils.addHours(search.getThongBaoTuNgay(), 23));
            }
            
            if (search.getThongBaoDenNgay()!= null) {
                search.setThongBaoDenNgay(DateTimeUtils.addHours(search.getThongBaoDenNgay(), 23));
            }
            
            if (search.getNguoiTao() != null && "".equals(search.getNguoiTao().trim())) {
                search.setNguoiTao(null);
            }
            
            if (search.getSoThongBao() != null && "".equals(search.getSoThongBao().trim())) {
                search.setSoThongBao(null);
            }
            
            json = helper.searchHoSo(uri, search, mqInfo);
            
        } catch (Exception ex) {
            json.setSuccess(false);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return json;
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson history(@RequestBody SearchFormLichsu01 data) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            json = helper.getHistory(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_HISTORY)), data, mqInfo);

        } catch (Exception ex) {
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

            CustomDocument documentExt = checkPermission(data.getFiIdCqxl());
            if (documentExt.getHasPermission() != true) {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            } else {
                TbdkqdgHh1 result = helper.getGCN(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_GCN)), data.getFiIdCqxl(), mqInfo);
                json.setData(result);
                json.setSuccess(true);
            }

        } catch (Exception ex) {
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

            CustomDocument documentExt = checkPermission(data.getFiIdCqxl());
            if (documentExt.getHasPermission() != true) {
                json.setSuccess(false);
                json.setMessage(ThuTuc01Constant.ErrorMessage.ACCESS_DENIED);
            } else {
                TbdkqktHh1 result = helper.getKQKT(getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO_KQKT)), data.getFiIdCqxl(), mqInfo);
                json.setData(result);
                json.setSuccess(true);
            }

        } catch (Exception ex) {
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

        RabbitMQInfo mqInfo = getRabbitMQ();

        documentInfo.setHasPermission(false);
        documentInfo.setDocument(null);

        if (IdCqxl.equals(ThuTuc01Constant.DefaultValue.VALUE_0L)) {
            return documentInfo;
        }

        String url = getFullUri(environment.getRequiredProperty(ThuTuc01Constant.API.HOSO));

        Tbdhoso1 hoso = helper.getHoSo(url, IdCqxl, mqInfo);

        documentInfo.setHasPermission(true);
        documentInfo.setDocument(hoso);

        return documentInfo;
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }
}
