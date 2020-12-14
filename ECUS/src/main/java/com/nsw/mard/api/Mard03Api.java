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
import com.nsw.mard.constant.Mard03Constant;
import com.nsw.mard.p03.model.*;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * @author TamDT
 */
@RestController
@RequestMapping("/mard/p03")
public class Mard03Api extends BaseApi {

    static final String TAG = "Mard03Api";
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
                case Mard03Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Mard03Constant.DANHMUC.DM_CQXL:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_CQXL));
                    break;
                case Mard03Constant.DANHMUC.DM_KHONGOAIQUAN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_KHO_NGOAI_QUAN));
                    break;
                case Mard03Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_TEPTIN));
                    break;
                case Mard03Constant.DANHMUC.DM_CUAKHAU:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_CUAKHAU));
                    break;
                case Mard03Constant.DANHMUC.DM_QUOCGIA:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.DANHMUC_QUOCGIA));
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
            @RequestBody SearchForm03 searchForm03
    ) {
        try {
            searchForm03.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEARCH), searchForm03);
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
            @RequestBody TbdHoSo03 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiMstDn(getUsername());
                tbdHoso.setFiNgayTao(new Date());
                tbdHoso.setFiTrangThaiMa(Mard03Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTrangThai(Mard03Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_INSERT), tbdHoso);
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
            @RequestBody SearchFormLichsu03 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/t/{fiIdHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoSo);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xacnhandon/{fiIdHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataXnDon(
            @PathVariable Long fiIdHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_DATA_XN_DON_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoSo);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xoa/{fiMaHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(@PathVariable String fiMaHoSo) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_DELETE) + fiMaHoSo);
        return json;
    }

    @RequestMapping(value = "/hoso/capnhat", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody TbdHoSo03 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_UPDATE), tbdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoSo03 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long fiIdHoSo = tbdHoso.getFiIdHoSo() != null ? tbdHoso.getFiIdHoSo() : 0L;

            if (fiIdHoSo == 0L) {
                tbdHoso.setFiNgayTao(new Date());
                tbdHoso.setFiTrangThaiMa(Mard03Constant.FILE_STATUS.TAO_MOI);
                json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_INSERT), tbdHoso);
            } else {

                json = BackendRequestHelper.getInstance().doCustomRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangThaiMa = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangThaiMa").toString());
                    fiIdHoSo = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoSo").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Mard03Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoSo);

                    if (Objects.equals(fiTrangThaiMa, Mard03Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_01);
                    } else if (Objects.equals(fiTrangThaiMa, Mard03Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_02);
                    } else if (Objects.equals(fiTrangThaiMa, Mard03Constant.FILE_STATUS.YC_BOSUNG_HS)) {
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_03);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
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

    @RequestMapping(value = "/hoso/yc-rut", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycRutHoso(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangThaiMa").toString());
                    String fiMaHoso = ((LinkedHashMap) hosoJson.getData()).get("fiMaHoSo").toString();
                    message.setFiMaHoso(fiMaHoso);
                    if (Objects.equals(fiTrangthai, Mard03Constant.FILE_STATUS.CHO_TIEP_NHAN) || Objects.equals(fiTrangthai, Mard03Constant.FILE_STATUS.YC_BOSUNG_HS)) {
                        message.setType(Mard03Constant.MSG_TYPE.TYPE_11);
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_04);
                    } else {
                        message.setType(Mard03Constant.MSG_TYPE.TYPE_14);
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_09);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
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
        message.setType(Mard03Constant.MSG_TYPE.TYPE_16);
        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_12);
        try {
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doCustomRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_UPDATE), HttpMethod.POST, message.getTbdHoSo03(), new HashMap<>());
            if (hosoJson.isSuccess()) {
                json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/giayCnkddv/{fiMaHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataGiayChungnhan(
            @PathVariable String fiMaHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_GCN_A) + fiMaHoSo);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/giayCnkdspdv/{fiMaHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataGiayChungnhanSpdv(
            @PathVariable String fiMaHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_GCN_B) + fiMaHoSo);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/yc-suaGCN", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycSuaGcn(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        message.setType(Mard03Constant.MSG_TYPE.TYPE_25);
        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_25);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/thongtinapphi/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataTBApphi(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.GET_INFO_TB_AP) + fiIdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/thongbaoXnphi/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataTBXnphi(
                    @PathVariable Long fiIdHoso
            ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.GET_INFO_TB_XNPHI) + fiIdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/lohangxl/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataLohangXl(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.GET_DATA_LOHANG_XL) + fiIdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xinHuyGCN", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson xinHuyGcn(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        message.setType(Mard03Constant.MSG_TYPE.TYPE_27);
        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_31);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/xinChuyenCk", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson xinChuyenCk(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangThaiMa").toString());
                    String fiMaHoso = ((LinkedHashMap) hosoJson.getData()).get("fiMaHoSo").toString();
                    message.setFiMaHoso(fiMaHoso);
                    if (Objects.equals(fiTrangthai, Mard03Constant.FILE_STATUS.DN_XIN_CHUYEN_CK)) {
                        message.setType(Mard03Constant.MSG_TYPE.TYPE_29);
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_38);
                    } else {
                        message.setType(Mard03Constant.MSG_TYPE.TYPE_29);
                        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_34);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/congvan/{fiMaHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataCongvan(
            @PathVariable String fiMaHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_GET_CONGVAN) + fiMaHoSo);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xinRutCv", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson xinRutCv(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        message.setType(Mard03Constant.MSG_TYPE.TYPE_32);
        message.setFunction(Mard03Constant.MSG_FUNC.FUNCTION_39);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.HOSO_SEND), message);
        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/kddv/getData", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataKddv() {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.GET_DATA_KDDV));

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/kdspdv/getData", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataKdSpdv() {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard03Constant.getInstance().getApiUrl(environment, Mard03Constant.API.GET_DATA_KDSPDV));

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

}
