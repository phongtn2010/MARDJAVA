/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.MARD26Constant;
import com.nsw.mard.p26.model.FilterForm;
import com.nsw.mard.p26.model.TbdHoso26;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard/26")
public class MARD26Api extends BaseApi {

    static final String TAG = "MARD26Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    @Autowired
    Environment environment;

    @RequestMapping(value = "/hanghoa/getlist", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByStatus(
            @RequestParam(name = "taxCode") String taxCode) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.SEARCH_PRODUCT_FROM_TACN) + "?taxCode=" + taxCode);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/getby-catno/{catNo}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getByCatNo(@PathVariable Long catNo) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.GET_BY_CAT_NO) + catNo);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/hoso/create", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(@RequestBody TbdHoso26 tbdhoso26) {
        ResponseJson returnJson = new ResponseJson();
        try {
            returnJson = BackendRequestHelper.getInstance().doPostRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.HOSO_INSERT), tbdhoso26);
            return returnJson;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            returnJson.setData(null);
            returnJson.setSuccess(false);
            returnJson.setMessage(ex.getMessage());
            return returnJson;
        }
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setNguoiTao(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.HOSO_SEARCH), filter);
        return json;
    }
}
