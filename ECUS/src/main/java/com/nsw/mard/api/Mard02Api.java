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
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard02Constant;
import com.nsw.mard.p02.model.ResponseToken;
import com.nsw.mard.p02.model.SearchFormLichsu02;
import com.nsw.mard.p02.model.SendMessage;
import com.nsw.mard.p02.model.TbdRegistration02;
//import com.nsw.mard.p04.model.SearchFormChiTieu04;
import com.nsw.mic.p02.model.SearchForm02;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * @author TamDT
 */
@RestController
@RequestMapping("/mard/p02")
public class Mard02Api extends BaseApi {

    static final String TAG = "Mard02Api";
    private static final int BUFFER_SIZE = 4096;

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdRegistration02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long registrationId = tbdHoso.getRegistrationId() != null ? tbdHoso.getRegistrationId() : 0L;

            if (registrationId == 0L) {
                tbdHoso.setCreateBy(getUsername());
                tbdHoso.setCreateDate(new Date());
                tbdHoso.setCodeStatus(Mard02Constant.FILE_STATUS.TAO_MOI);
                json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_INSERT), tbdHoso);
            } else {

                json = BackendRequestHelper.getInstance().doCustomRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long codeStatus = Long.valueOf(((LinkedHashMap) json.getData()).get("codeStatus").toString());
                    registrationId = Long.valueOf(((LinkedHashMap) json.getData()).get("registrationId").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Mard02Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(registrationId);

                    if (Objects.equals(codeStatus, Mard02Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_01);
                    } else if (Objects.equals(codeStatus, Mard02Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_02);
                    } else if (Objects.equals(codeStatus, Mard02Constant.FILE_STATUS.YC_BOSUNG)) {
                        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_03);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_SEND), message);
                    json.setSuccess(jsonResult.isSuccess());
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;

        try {
            switch (key) {
                case Mard02Constant.DANHMUC.DM_DVTINH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_DVTINH));
                    break;
                case Mard02Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Mard02Constant.DANHMUC.DM_HINHTHUC_KT:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_HINHTHUC_KT));
                    break;
                case Mard02Constant.DANHMUC.DM_LOAIDON:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_LOAIDON));
                    break;
                case Mard02Constant.DANHMUC.DM_LOAI_SP:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_LOAI_SP));
                    break;
                case Mard02Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.DANHMUC_TEPTIN));
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

    @RequestMapping(value = "/gettoken", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getToken(
            @RequestBody ResponseToken tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String restUri = Mard02Constant.TOKEN.URL_API;
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseToken token = restTemplate.getForObject(restUri, ResponseToken.class);
            json.setData(token);
            json.setSuccess(true);
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
            @RequestBody SearchForm02 searchForm02
    ) {
        try {
            searchForm02.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_SEARCH), searchForm02);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody TbdRegistration02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setCreateBy(getUsername());
                tbdHoso.setCreateDate(new Date());
                tbdHoso.setCodeStatus(Mard02Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setNameStatus(Mard02Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_INSERT), tbdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/capnhat", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody TbdRegistration02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            tbdHoso.setCreateBy(getUsername());
            json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_UPDATE), tbdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/t/{registrationId}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long registrationId
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + registrationId);
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
            json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/yc-rut", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycRutHoso(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("codeStatus").toString());
                    //huy ho so 11_04
                    if (Objects.equals(fiTrangthai, Mard02Constant.FILE_STATUS.CHO_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Mard02Constant.FILE_STATUS.YC_BOSUNG)) {
                        message.setType(Mard02Constant.MSG_TYPE.TYPE_11);
                        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_04);
                    } else { // yeu cau rut ho so
                        message.setType(Mard02Constant.MSG_TYPE.TYPE_13);
                        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_08);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

	/**
    @RequestMapping(value = "/hoso/chitieu", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson danhSachChitieu(
            @RequestBody SearchFormChiTieu04 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.CHITIEU_SEARCH_NEW), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }
	*/

    @RequestMapping(value = "/hoso/xacNhanChatLuong/{nswfileCode}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataXacNhanChatLuong(
            @PathVariable String nswfileCode
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GET_XNCL) + nswfileCode);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/giulaiVaxuly/{nswfileCode}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataGiuLaiXuLy(
            @PathVariable String nswfileCode
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GIULAI_VA_XULY) + nswfileCode);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/giayTamCap/{nswfileCode}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataGiayTamCap(
            @PathVariable String nswfileCode
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GIAY_TAMCAP) + nswfileCode);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xoa/{registrationId}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(
            @PathVariable Long registrationId) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_DELETE) + registrationId);
        return json;
    }

    @RequestMapping(value = "/hoso/congVan/{nswFilecode}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataCongVan(
            @PathVariable String nswFilecode
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_GET_CONGVAN) + nswFilecode);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/yc-sua", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycSuaHoso(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        message.setType(Mard02Constant.MSG_TYPE.TYPE_15);
        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_11);
        try {
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doCustomRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_UPDATE), HttpMethod.POST, message.getTbdRegistration02(), new HashMap<>());
            if (hosoJson.isSuccess()) {
                json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_SEND), message);
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/yc-suaCV", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycSuaCV(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        message.setType(Mard02Constant.MSG_TYPE.TYPE_18);
        message.setFunction(Mard02Constant.MSG_FUNC.FUNCTION_16);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard02Constant.getInstance().getApiUrl(environment, Mard02Constant.API.HOSO_SEND), message);
        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

}
