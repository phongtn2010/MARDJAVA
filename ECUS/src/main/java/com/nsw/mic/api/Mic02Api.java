/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mic.constant.Mic02Constant;
import com.nsw.mic.p02.model.SearchFormGP02;
import com.nsw.mic.p02.model.SearchFormLichsu02;
import com.nsw.monre.p09.model.FilterForm;
import com.nsw.mt.p13.model.SearchFormKqxl02;
import com.nsw.util.LogUtil;
import javax.servlet.ServletContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TamDT
 */
@RestController
@RequestMapping("/mic/p02")
public class Mic02Api extends BaseApi {

    static final String TAG = "Mic02Api";
    private static final int BUFFER_SIZE = 4096;

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;

        try {
            switch (key) {
                case Mic02Constant.DANHMUC.DM_NOICAPGP:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_NOICAPGP));
                    break;
                case Mic02Constant.DANHMUC.DM_CHATLUONG:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_CHATLUONG));
                    break;
                case Mic02Constant.DANHMUC.DM_DVTKHUANKHO:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_DVTKHUANKHO));
                    break;
                case Mic02Constant.DANHMUC.DM_TEVTV:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TENTV));
                    break;
                case Mic02Constant.DANHMUC.DM_KIEUIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_KIEUIN));
                    break;
                case Mic02Constant.DANHMUC.DM_DVTTOCDO:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_DVTOCDO));
                    break;
                case Mic02Constant.DANHMUC.DM_MUCDICH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_MUCDICH));
                    break;
                case Mic02Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Mic02Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TEPTIN));
                    break;
                default:
                    break;
            }
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return json;
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        try {
            filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_SEARCH), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }


    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
            
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

  
    @RequestMapping(value = "/hoso/lichsu", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson lichSuXuLyHoSo(
            @RequestBody SearchFormLichsu02 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
//            if (!isOwner(filterForm.getFiIdHoso())) {
//                return json;
//            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/vanban", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson XemGpHoSo(
            @RequestBody SearchFormGP02 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoSo());
        return json;
    }


    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody SearchFormKqxl02 message
    ) {
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.KQXL_SEARCH), message);
        return json;
    }

}
