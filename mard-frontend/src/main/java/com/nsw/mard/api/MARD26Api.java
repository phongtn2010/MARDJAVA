/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.MARD26Constant;
import com.nsw.mard.constant.Mard25Constant;
import com.nsw.mard.p25.model.TbdHoso25;
import com.nsw.mard.p26.model.FilterForm;
import com.nsw.mard.p26.model.TbdHoso26;
import com.nsw.mard.p6.model.SendMessage;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByID(
            @RequestParam(name = "id") String idHoSo
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(idHoSo, null)) {
                json.setSuccess(false);
                json.setMessage("Không có quyền truy cập hồ sơ");
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.HOSO_FIND_BY_FILTER) + "?id=" + idHoSo);
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
    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoso26 tbdHoso26
    ) {
        ResponseJson returnJson = new ResponseJson();
        returnJson.setSuccess(false);
        try {
            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(MARD26Constant.EnableSign))) {
                returnJson = send(tbdHoso26);
            } else {
                tbdHoso26.setFiMasothue(getUsername());
                ResponseJson tmpJson = createHoso(tbdHoso26);
                if(tmpJson.isSuccess() == false) {
                    return tmpJson;
                }
                HashMap<String, Object> tmpData = (HashMap<String, Object>) tmpJson.getData();
                returnJson = getHoSoByID(tmpData.get("fiIdHS").toString());
                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    Long fiTrangthai = Long.valueOf(data.get("fiTrangthai").toString());
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiMaHoso").toString());
                    sendMessage.setType(MARD26Constant.MSG_TYPE.TYPE_10);

                    if (fiTrangthai.equals(MARD26Constant.FILE_STATUS.TAO_MOI)) {
                        sendMessage.setFunction(MARD26Constant.MSG_FUNC.FUNC_01);
                    }
//                    SignData signData = getXMLForSign(sendMessage);
//                    returnJson.setSign(signData);
                }
            }
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
    private ResponseJson send(TbdHoso26 tbdHoso26) {
        ResponseJson returnJson = new ResponseJson();
        tbdHoso26.setFiMasothue(getUsername());
        try {
            return BackendRequestHelper.getInstance().doPostRequest(MARD26Constant.getInstance().getApiUrl(environment, MARD26Constant.TbdHoso26API.HOSO_SEND), tbdHoso26);
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
    private boolean isOwner(String idHS, String nswFileCode) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                MARD26Constant.getInstance().getApiUrl(
                        environment,
                        MARD26Constant.TbdHoso26API.HOSO_FIND_BY_FILTER
                ) + "?id=" +
                        (StringUtils.isEmpty(idHS)? "" : idHS) + "&nswFileCode=" +
                        (StringUtils.isEmpty(nswFileCode)? "" : nswFileCode) + "&taxCode=" + getUsername());

        return json != null && json.getData() != null;
    }
}
