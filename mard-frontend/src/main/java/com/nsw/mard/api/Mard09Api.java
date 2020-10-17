package com.nsw.mard.api;

import com.google.common.util.concurrent.AtomicDouble;
import com.google.gson.Gson;
import com.nsw.api.BaseApi;
import com.nsw.common.model.Country;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard08Constant;
import com.nsw.mard.constant.Mard09Constant;
import com.nsw.mard.helper.Mard09Helper;
import com.nsw.mard.p9.model.*;
import com.nsw.mard.service.DinhkemService;
import com.nsw.util.Constants;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/mard/09")
public class Mard09Api extends BaseApi {
    static final String TAG = "mard09Api";

    @Autowired
    DinhkemService attachmentService;

    @RequestMapping(value = "/dvxl", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDvxl(
    ) {
        ResponseJson json = new ResponseJson();

        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.DANHMUC_DONVIXULY));
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

    @ResponseBody
    @RequestMapping(value = "/dinhkem/create", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseJson createAttachment(
            @RequestParam Long fiMaLoai,
            @RequestParam String fiTenLoai,
            @RequestParam MultipartFile file) {
        try {
            String format = file.getOriginalFilename().substring(
                    file.getOriginalFilename().lastIndexOf('.')
            ).toLowerCase();

            if (!".jpg,.jpeg,.pdf,.tif".contains(format.toLowerCase())) {
                ResponseJson responseJson = new ResponseJson();
                responseJson.setSuccess(false);
                responseJson.setMessage("Tệp đính kèm không đúng định dạng");
                return responseJson;
            }
            return attachmentService.uploadFile(file, fiMaLoai, "BNNPTNT0600012");
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return new ResponseJson(ex.getMessage());
        }
    }

    @RequestMapping(value = "/dinhkem/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseJson deleteAttachment(
            @RequestParam(value = "id") String id
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doCustomRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.ATTACHMENT_DELETE) + "?id=" + id, HttpMethod.DELETE, new Object(), new HashMap<>());
            return json;
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

    @RequestMapping(value = "/dinhkem/find", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson findAttachmentById(
            @RequestParam(value = "id") String id
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.ATTACHMENT_FIND_BY_ID) + "?id=" + id, null);
            return json;
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

    @RequestMapping(value = "/hoso/rollback", method = RequestMethod.GET)
    private @ResponseBody ResponseJson rollbackHoso(@RequestParam("nswFileCode") String nswFileCode) {
        ResponseJson rs = new ResponseJson();
        if (!isOwner(null, nswFileCode)) {
            rs.setSuccess(false);
            return rs;
        }
        try {
            rs = BackendRequestHelper.getInstance()
                    .doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.ROLL_BACK) + "?nswFileCode=" + nswFileCode);
            return rs;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            rs.setData(null);
            rs.setSuccess(false);
            rs.setMessage(ex.getMessage());
            return rs;
        }
    }

    @RequestMapping(value = "/hoso/create", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody Hoso09DTO tbdhoso09
    ) {
        return save(tbdhoso09);
    }


    @RequestMapping(value = "/hoso/ycs", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody Hoso09DTO tbdhoso09
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {

            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard09Constant.EnableSign))) {
                tbdhoso09.setFiSignedDate(new Date());
                ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.HOSO_UPDATE), tbdhoso09);
                return json;
            } else {
                tbdhoso09.setFiTaxCode(getUsername());
                tbdhoso09.setFiSignedDate(new Date());
                returnJson = saveBeforeUpdate(tbdhoso09);

                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiHSCode").toString());
                    sendMessage.setType(Mard09Constant.TYPE.TYPE_13);
                    sendMessage.setFunction(Mard09Constant.FUNCTION.FUNCTION_18);
                    sendMessage.setFiReason(tbdhoso09.getFiModifyReason());

                    SignData signData = getXMLForSign(sendMessage);
                    returnJson.setSign(signData);
                }

                returnJson.setData(tbdhoso09);

                return returnJson;
            }
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

    @RequestMapping(value = "/hoso/xnd", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson xacNhandon(
            @RequestParam("id") String registrationConfirmNo
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.GET_XND) + "?id=" + registrationConfirmNo);
            return json;
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

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody Hoso09DTO tbdhoso09
    ) {
        ResponseJson returnJson = new ResponseJson();
        returnJson.setSuccess(false);

        try {
            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard09Constant.EnableSign))) {
                returnJson = send(tbdhoso09);
            } else {
                tbdhoso09.setFiTaxCode(getUsername());
                tbdhoso09.setFiSignedDate(new Date());
                ResponseJson tmpJson = save(tbdhoso09);
                if (tmpJson.isSuccess() == false) {
                    return tmpJson;
                }
                HashMap<String, Object> tmpData = (HashMap<String, Object>) tmpJson.getData();
                returnJson = getHosoById(tmpData.get("fiIdHS").toString());
                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    Long fiTrangthai = Long.valueOf(data.get("fiHSStatus").toString());
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiHSCode").toString());
                    sendMessage.setType(Mard09Constant.TYPE.TYPE_10);

                    if (fiTrangthai.equals(Mard09Constant.HosoStatus.TAO_MOI)) {
                        sendMessage.setFunction(Mard09Constant.FUNCTION.FUNCTION_01);
                    } else if (fiTrangthai.equals(Mard09Constant.HosoStatus.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(Mard09Constant.FUNCTION.FUNCTION_02);
                    } else if (fiTrangthai.equals(Mard09Constant.HosoStatus.YEU_CAU_BO_SUNG)) {
                        sendMessage.setFunction(Mard09Constant.FUNCTION.FUNCTION_04);
                    }

                    SignData signData = getXMLForSign(sendMessage);
                    returnJson.setSign(signData);
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

    @RequestMapping(value = "/danhmuc/dinhkem/type/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson findListAttachmentByMaHoso(
            @PathVariable(value = "id") String id
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.ATTACHMENT_TYPE) + "/" + id);
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

    @RequestMapping(value = "/lichsu", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHistoryByHSCode(
            @RequestParam("fiHSCode") String fiHSCode,
            @RequestParam(required = false) Integer p,
            @RequestParam(required = false) Integer s
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(
                    Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.HISTORY_BY_HS_CODE) + "?fiHSCode=" + fiHSCode + "&p=" + p + "&s=" + s);
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

    @RequestMapping(value = "/apphi", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getApphiByHSCode(
            @RequestParam("fiHSCode") String fiHSCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.APPHI_BY_HS_CODE) + "?fiHSCode=" + fiHSCode);
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

    @RequestMapping(value = "/danhmuc/statusHoso", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhSachTrangThai() {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TRANGTHAI_HS) + "?systemId=9");
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

    @RequestMapping(value = "/hoso/find", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHosoByFilter(@RequestBody FilterForm tbdFindHosoFilter09) {
        ResponseJson responseJson = new ResponseJson();
        try {
            tbdFindHosoFilter09.setFiCompanyTaxCode(getUsername());
            responseJson = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TBDHOSO_09_FINDFILTER), tbdFindHosoFilter09);
            return responseJson;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            responseJson.setData(null);
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            return responseJson;
        }
    }

    @RequestMapping(value = "/danhmuc/tinhthanh", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhmucTinhthanh() {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.GET_DANHSACH_TINNHTHANH));
            return responseJson;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            responseJson.setData(null);
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            return responseJson;
        }
    }

    @RequestMapping(value = "/danhmuc/doctype", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDocumentTypes() {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.GET_DOCTYPE_BY_FILTER));
            return responseJson;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            responseJson.setData(null);
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            return responseJson;
        }
    }

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHosoById(@RequestParam("id") String id) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(id, null)){
                json.setSuccess(false);
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TBDHOSO_09_FINDFILTER) + "?id=" + id);
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

    @RequestMapping(value = "/hoso/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson xoaHoso(
            @RequestBody XoaHoso xoaHoso
    ) {
        ResponseJson json = new ResponseJson();
        try {
            xoaHoso.setFiTaxCode(getUsername());
            String body = String.format("?fiNSWFileCode=%s&fiTaxCode=%s", xoaHoso.getFiNSWFileCode(), xoaHoso.getFiTaxCode());
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TBDHOSO_09_XOA) + body);
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

    @RequestMapping(value = "/giayphep/view", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getGiayphepByHSID(
            @RequestParam("type") String type,
            @RequestParam("code") String hsCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.GIAYPHEP_FIND) + "?type=" + type + "&code=" + hsCode);
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

    @RequestMapping(value = "/phanhoixncl", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson phanHoiXNCLKhongDat(
            @RequestBody PhanHoiXNCLKhongDat phanHoiXNCLKhongDat
    ) {
        ResponseJson json = new ResponseJson();
        try {
            phanHoiXNCLKhongDat.setFiResponseDate(new Date());
            phanHoiXNCLKhongDat.setFiResponseUser(getUsername());
            json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.PHANHOI_XNCL_KHONGDAT), phanHoiXNCLKhongDat);
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

    @RequestMapping(value = "/xinsuagcn", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson xinSuaGCN(
            @RequestBody XinSuaGCN xinSuaGCN
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, xinSuaGCN.getFiNSWFileCode())) {
                json.setSuccess(false);
                json.setMessage("Bạn không có quyền với hồ sơ này");
                return json;
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.XINSUA_GCN), xinSuaGCN);
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

    @RequestMapping(value = "/xinrut", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson xinRutHoso(
            @RequestBody XinRutHoso xinRutHoso
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, xinRutHoso.getFiHSCode())) {
                json.setSuccess(false);
                json.setMessage("Bạn không có quyền với hồ sơ này");
                return json;
            }
            xinRutHoso.setFiRequestedDate(new Date());
            json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TBDHOSO_09_XINRUT), xinRutHoso);
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

    @RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson verify(@RequestBody TokenInfo token) {
        token.setUser(this.getUsername());
        ResponseJson responseJson = new ResponseJson();

//        responseJson.setSuccess(true);
//        return responseJson;
        return this.verifySignature(token);
    }

    private SignData getXMLForSign(SendMessage sendMessage) throws Exception {
        ResponseJson resultSignFlow = BackendRequestHelper.getInstance()
                .doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.GET_XML), sendMessage);

        if (resultSignFlow.isSuccess()) {
            SignData signData = new SignData();
            signData.setFiDocumentCode(sendMessage.getFiNSWFileCode());
            signData.setFiDocType("BNNPTNT0600012");
            signData.setFiFunc(sendMessage.getFunction());
            signData.setFiMsgType(sendMessage.getType());

            String xml = resultSignFlow.getData().toString();

            String hashVal = Utility.GetHashData(xml);
            signData.setFiXml(xml);
            signData.setFiXmlEncode(encodeXmlMessage(xml));
            signData.setFiHash(hashVal);
            signData.setFiHashEncode(encodeXmlMessage("<DS>" + hashVal + "</DS>"));
            return signData;
        } else {
            throw new Exception(resultSignFlow.getMessage());
        }
    }


    private ResponseJson send(Hoso09DTO tbdHoso) {
        ResponseJson returnJson = new ResponseJson();
        tbdHoso.setFiSignedDate(new Date());
        try {
            tbdHoso.setFiTaxCode(getUsername());
            //http://118.70.125.195:8100/MARDBackend/mard/09/hoso/send
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.HOSO_SEND), tbdHoso);
            return json;
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

    private ResponseJson save(Hoso09DTO tbdHoso) {
        ResponseJson returnJson = new ResponseJson();
        tbdHoso.setFiSignedDate(new Date());
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.HOSO_SAVE), tbdHoso);
            return json;
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

    private ResponseJson saveBeforeUpdate(Hoso09DTO tbdHoso) {
        try {
            tbdHoso.setFiSignedDate(new Date());
            tbdHoso.setFiTaxCode(getUsername());

            return BackendRequestHelper.getInstance()
                    .doPostRequest(
                            Mard09Constant.getInstance()
                                    .getApiUrl(environment, Mard09Constant.API.SAVE_BEFORE_UPDATE),
                            tbdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            ResponseJson returnJson = new ResponseJson();
            returnJson.setData(null);
            returnJson.setSuccess(false);
            returnJson.setMessage(ex.getMessage());
            return returnJson;
        }
    }

    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiHoso(
            @RequestBody Hoso09DTO tbdhoso
    ) {
        return send(tbdhoso);
    }


    @RequestMapping(value = "/hoso/guiycs", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiYeucauSuaHosoDaKy(
            @RequestBody Hoso09DTO tbdHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            tbdHoso.setFiSignedDate(new Date());
            tbdHoso.setFiTaxCode(getUsername());
            return BackendRequestHelper.getInstance().doPostRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.UPDATE_ONLY), tbdHoso);
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
                Mard09Constant.getInstance().getApiUrl(
                        environment,
                        Mard09Constant.API.TBDHOSO_09_FINDFILTER
                ) + "?id=" + (StringUtils.isEmpty(idHS) ? "" : idHS) + "&nswFileCode=" + (StringUtils.isEmpty(nswFileCode) ? "" : nswFileCode) + "&taxCode=" + getUsername());
        return json != null && json.getData() != null;
    }

    @RequestMapping(value = "/download/{type}/{fiNSWFileCode}")
    public void genGP(
            @PathVariable String type,
            @PathVariable String fiNSWFileCode,
            @RequestParam String certNo,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            String typeToRequest = "";
            if(type.contains("cnkd")) {
                typeToRequest = "cnkd";
            }

            if (type.contains("gvc")) {
                typeToRequest = "gvc";
            }

            if (type.contains("xncl")) {
                typeToRequest = "xncl";
            }

            ResponseJson json = getGiayphepByHSID(typeToRequest, fiNSWFileCode);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
//
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName;
            File tempFile;
            Docx docx;
            Variables variables = null;

            switch (type) {
                case "cnkda":
                    Tbdgiaycnkd09[] cnkds = GsonUtils.getInstance().transform(json.getData(), Tbdgiaycnkd09[].class);

                    for (int i = 0; i < cnkds.length; i++){
                        if (cnkds[i].getFiCertificateNo().equals(certNo)) {
                            templatePath = request.getRealPath("/WEB-INF/downloads/mard/09/15a.docx");
                            if (templatePath != null && !templatePath.isEmpty()) {
                                variables = Mard09Helper.genWord15A(cnkds[i]);
                                fileName = new Date().getTime() + "-15a.docx";
                                tempFile = new File(tempFoleder + fileName);
                                docx = new Docx(templatePath);
                                docx.setVariablePattern(new VariablePattern("#{", "}"));
                                docx.fillTemplate(variables);
                                docx.save(tempFile.getPath());
                                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                                response.setHeader("Pragma", "no-cache");
                                response.setHeader("Cache-Control", "no-cache");
                                response.getOutputStream().write(loadFile(tempFile));
                            }
                            break;
                        }
                    }

                    break;
                case "cnkdb":
                    Tbdgiaycnkd09[] cnkdbs = GsonUtils.getInstance().transform(json.getData(), Tbdgiaycnkd09[].class);

                    for (int i = 0; i < cnkdbs.length; i++){
                        if (cnkdbs[i].getFiCertificateNo().equals(certNo)) {
                            templatePath = request.getRealPath("/WEB-INF/downloads/mard/09/15b.docx");
                            if (templatePath != null && !templatePath.isEmpty()) {
                                variables = Mard09Helper.genWord15B(cnkdbs[i]);
                                fileName = new Date().getTime() + "-15b.docx";
                                tempFile = new File(tempFoleder + fileName);
                                docx = new Docx(templatePath);
                                docx.setVariablePattern(new VariablePattern("#{", "}"));
                                docx.fillTemplate(variables);
                                docx.save(tempFile.getPath());
                                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                                response.setHeader("Pragma", "no-cache");
                                response.setHeader("Cache-Control", "no-cache");
                                response.getOutputStream().write(loadFile(tempFile));
                            }
                            break;
                        }
                    }

                    break;

                case "gvca":
                    Tbdgiayvc09[] gvcas = GsonUtils.getInstance().transform(json.getData(), Tbdgiayvc09[].class);

                    for (int i = 0; i < gvcas.length; i++){
                        if (gvcas[i].getFiCertificateNo().equals(certNo)) {
                            templatePath = request.getRealPath("/WEB-INF/downloads/mard/09/14a.docx");
                            if (templatePath != null && !templatePath.isEmpty()) {
                                variables = Mard09Helper.genWord14A(gvcas[i]);
                                fileName = new Date().getTime() + "-14a.docx";
                                tempFile = new File(tempFoleder + fileName);
                                docx = new Docx(templatePath);
                                docx.setVariablePattern(new VariablePattern("#{", "}"));
                                docx.fillTemplate(variables);
                                docx.save(tempFile.getPath());
                                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                                response.setHeader("Pragma", "no-cache");
                                response.setHeader("Cache-Control", "no-cache");
                                response.getOutputStream().write(loadFile(tempFile));
                            }
                            break;
                        }
                    }
                    break;

                case "gvcb":
                    Tbdgiayvc09[] gvcbs = GsonUtils.getInstance().transform(json.getData(), Tbdgiayvc09[].class);

                    for (int i = 0; i < gvcbs.length; i++){
                        if (gvcbs[i].getFiCertificateNo().equals(certNo)) {
                            templatePath = request.getRealPath("/WEB-INF/downloads/mard/09/14b.docx");
                            if (templatePath != null && !templatePath.isEmpty()) {
                                variables = Mard09Helper.genWord14B(gvcbs[i]);
                                fileName = new Date().getTime() + "-14b.docx";
                                tempFile = new File(tempFoleder + fileName);
                                docx = new Docx(templatePath);
                                docx.setVariablePattern(new VariablePattern("#{", "}"));
                                docx.fillTemplate(variables);
                                docx.save(tempFile.getPath());
                                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                                response.setHeader("Pragma", "no-cache");
                                response.setHeader("Cache-Control", "no-cache");
                                response.getOutputStream().write(loadFile(tempFile));
                            }
                            break;
                        }
                    }
                    break;

                case "xncl":
                    break;

            }

        }catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }
    @RequestMapping(value = {"hoso/download/{mau}/{idHoSo}"}, method = RequestMethod.GET)
    public void getMauDon(
            @PathVariable("mau") String mau,
            @PathVariable("idHoSo") String idHoSo,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            if (!isOwner(idHoSo, null)){
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard09Constant.getInstance().getApiUrl(environment, Mard09Constant.API.TBDHOSO_09_FINDFILTER) + "?id=" + idHoSo);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso09 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso09.class);

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "E:\\LOGS\\";
            String fileName = new Date().getTime() + "-hoso-mard-09.docx";

            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            if ("03".equals(mau)) {
                variables = genMau03(hoso);
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/09/mau03.docx");
            } else {
                throw new Exception("123");
            }
            tempFile = new File(tempFoleder + fileName);
            docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiHSCode() + "-hoso.docx";
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(loadFile(tempFile));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }

    @RequestMapping(value = "/hdsd", method = RequestMethod.GET)
    public void getHDSD(
            HttpServletResponse response,
            HttpServletRequest request
    ){
        try {
            String templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/09/hdsd.docx");
            String fileName = "hdsd.docx";
            if (!templatePath.isEmpty() && !fileName.isEmpty()) {
                File tempFile = new File(templatePath);
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.getOutputStream().write(loadFile(tempFile));
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    private String optional(String option) {
        return option == null ? "" : option;
    }

    private String formatLocaleDate(Date date) {
        if (date == null) {
            return "ngày ...... tháng ...... năm ......";
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return String.format("ngày %02d tháng %02d năm %d",
                c.get(Calendar.DAY_OF_MONTH),
                1 + c.get(Calendar.MONTH),
                c.get(Calendar.YEAR));
    }

    private String listToStringComma(Collection<String> arrays) {
        StringBuilder sb = new StringBuilder("");
        for (String element : arrays) {
            if (StringUtils.isNotEmpty(element)) {
                sb.append(element);
                sb.append(", ");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private String getCountryname(String countrycode, List<Country> countries) {
        return countries.stream().filter(country -> country.getCountrycode().equals(countrycode)).findFirst().orElse(new Country()).getCountryname();
    }

    private Variables genMau03(Tbdhoso09 hoso) {
        List<Country> countries = new ArrayList<>();
        ResponseJson jsonCountry = BackendRequestHelper.getInstance().doGetRequest(Mard08Constant.getInstance().getApiUrl(environment, Mard08Constant.API.COUNTRY_GET));
        if (jsonCountry != null && jsonCountry.getSuccess() == true && jsonCountry.getData() != null) {
            Gson gson = new Gson();
            ((List<Object>) jsonCountry.getData()).forEach(obj -> countries.add(gson.fromJson(gson.toJson(obj), Country.class)));
        }
        SimpleDateFormat simleDate = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);

        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{FiNSWFileCode}", optional(hoso.getFiHSCode())));
        variables.addTextVariable(new TextVariable("#{FiSigningLocation}", optional(hoso.getFiSigningLocation())));
        variables.addTextVariable(new TextVariable("#{FiSignedDate}", formatLocaleDate(hoso.getFiSignedDate())));

        variables.addTextVariable(new TextVariable("#{FiQuarantineDepartmentName}", optional(hoso.getFiQuarantineDepartmentName())));
        variables.addTextVariable(new TextVariable("#{FiNameOfRegistration}", optional(hoso.getFiNameOfRegistration())));
        variables.addTextVariable(new TextVariable("#{FiAddressOfRegistration}", optional(hoso.getFiAddressOfRegistration())));
        variables.addTextVariable(new TextVariable("#{FiPhone}", optional(hoso.getFiPhone())));
        variables.addTextVariable(new TextVariable("#{FiFax}", optional(hoso.getFiFax())));
        variables.addTextVariable(new TextVariable("#{FiEmail}", optional(hoso.getFiEmail())));

        variables.addTextVariable(new TextVariable("#{FiSignedByTitle}", optional(hoso.getFiSignedByTitle())));
        variables.addTextVariable(new TextVariable("#{FiSignedBy}", optional(hoso.getFiSignedBy())));

        variables.addTextVariable(new TextVariable("#{FiContractNo}", optional(hoso.getFiContractNo())));
        variables.addTextVariable(new TextVariable("#{FiImportContactPerson}", optional(hoso.getFiImportContactPerson())));
        variables.addTextVariable(new TextVariable("#{FiExportContactPerson}", optional(hoso.getFiExportContactPerson())));
        variables.addTextVariable(new TextVariable("#{FiExportCountryName}", optional(getCountryname(hoso.getFiExportCountryCode(), countries))));
        variables.addTextVariable(new TextVariable("#{FiCertificateQuantity}", optional(hoso.getFiCertificateQuantity())));
        variables.addTextVariable(new TextVariable("#{FiExportPortDestName}", optional(hoso.getFiExportPortDestName())));
        variables.addTextVariable(new TextVariable("#{FiImportCountryName}", optional(getCountryname(hoso.getFiImportCountryCode(), countries))));
        variables.addTextVariable(new TextVariable("#{FiTransportType}", optional(hoso.getFiTransportType())));

        List<String> goodsDescription = new ArrayList<>();
        Set<String> packageType = new HashSet<>();
        Set<String> importPorts = new HashSet<>();
        List<String> manufacturer = new ArrayList<>();
        AtomicDouble totalNW = new AtomicDouble(0d);
        AtomicDouble totalGW = new AtomicDouble(0d);
        AtomicDouble totalQuantity = new AtomicDouble(0d);

        AtomicReference<String> unitName = new AtomicReference<>("");
        AtomicReference<String> nwUnitName = new AtomicReference<>("");
        AtomicReference<String> gwUnitName = new AtomicReference<>("");
        hoso.getLstGood().forEach(hh -> {
            packageType.add(hh.getFiPackingWay());
            importPorts.add(hh.getFiImportPortOfDestName());
            StringBuilder goodSB = new StringBuilder();
            goodSB.append(hh.getFiProductName());
            if (hoso.getFiProductType() == 2 || hoso.getFiProductType() == 3) {
                //SPDV + BTX
                goodSB.append(" (");
                goodSB.append(String.format("%s %s, %s %s", nf.format(hh.getFiNumber()), hh.getFiUnitName(), nf.format(hh.getFiNetWeight()), hh.getFiNWUnitName()));
                goodSB.append(")");
                totalNW.addAndGet(hh.getFiNetWeight());
                totalGW.addAndGet(hh.getFiGrossWeight());
                totalQuantity.addAndGet(hh.getFiNumber());
                unitName.set(hh.getFiUnitName());
                nwUnitName.set(hh.getFiNWUnitName());
                gwUnitName.set(hh.getFiGWUnitName());
            } else {
                //DV
                goodSB.append(" (");
                goodSB.append(String.format("%d đực, %d cái", hh.getFiQuantityMale(), hh.getFiQuantityFemale()));
                goodSB.append(")");
                totalQuantity.addAndGet(hh.getFiQuantityFemale() + hh.getFiQuantityMale());
                unitName.set("Con");
            }
            goodsDescription.add(goodSB.toString());
        });

        if (CollectionUtils.isEmpty(hoso.getLstProdMfr()) == false) {
            hoso.getLstProdMfr().forEach(nmsx -> manufacturer.add(nmsx.getFiCompanyName()));
        }else{
            hoso.getLstExporter().forEach(ctyxk -> manufacturer.add(ctyxk.getFiExporterName()));

        }
        variables.addTextVariable(new TextVariable("#{FiGoodsName}", listToStringComma(goodsDescription)));
        variables.addTextVariable(new TextVariable("#{FiGoodsOrigin}", listToStringComma(manufacturer)));
        variables.addTextVariable(new TextVariable("#{FiGoodsQuantity}", StringUtils.isEmpty(unitName.get()) ? ""
                : String.format("%s %s", nf.format(totalQuantity.get()), unitName.get())));
        variables.addTextVariable(new TextVariable("#{FiGoodsNetWeight}", StringUtils.isEmpty(nwUnitName.get()) ? ""
                : String.format("%s %s", nf.format(totalNW.get()), nwUnitName.get())));
        variables.addTextVariable(new TextVariable("#{FiGoodsGrossWeight}", StringUtils.isEmpty(gwUnitName.get()) ? ""
                : String.format("%s %s", nf.format(totalGW.get()), gwUnitName.get())));
        variables.addTextVariable(new TextVariable("#{FiImportPortsName}", listToStringComma(importPorts)));
        variables.addTextVariable(new TextVariable("#{FiPackageType}", listToStringComma(packageType)));

        variables.addTextVariable(new TextVariable("#{FiBillOfLadingNo}", optional(hoso.getFiBillOfLadingNo())));
        variables.addTextVariable(new TextVariable("#{FiBillOfLadingIssuedDate}", simleDate.format(hoso.getFiBillOfLadingIssuedDate())));
        variables.addTextVariable(new TextVariable("#{FiPurpose}", optional(hoso.getFiPurpose())));
        variables.addTextVariable(new TextVariable("#{FiAccQuarantineDoc}", optional(hoso.getFiAccQuarantineDoc())));
        variables.addTextVariable(new TextVariable("#{FiQuarantineName}", optional(hoso.getFiQuarantineName())));
        variables.addTextVariable(new TextVariable("#{FiQuarantineTimeFromTo}",
                String.format("từ %s đến %s", formatLocaleDate(hoso.getFiQuarantineTimeFrom()), formatLocaleDate(hoso.getFiQuarantineTimeTo()))));

        variables.addTextVariable(new TextVariable("#{FiMonitoringLocName}", optional(hoso.getFiMonitoringLocName())));
        variables.addTextVariable(new TextVariable("#{FiMonitoringLocTimeFromTo}",
                String.format("từ %s đến %s", formatLocaleDate(hoso.getFiMonitoringLocTimeFrom()), formatLocaleDate(hoso.getFiMonitoringLocTimeTo()))));

        //Xử lý XND
        variables.addTextVariable(new TextVariable("#{Break}", ""));
        variables.addTextVariable(new TextVariable("#{XNDTitle}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine1}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine2}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine3}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine4}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine5}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine6}", ""));
        variables.addTextVariable(new TextVariable("#{XNDLine7}", ""));
        if (StringUtils.isNotEmpty(hoso.getFiRegistrationComfirmNo())) {
            ResponseJson json = xacNhandon(hoso.getFiHSCode());
            if (json != null && json.getSuccess() == true && json.getData() != null) {
                TbdXacnhan09 xnd = GsonUtils.getInstance().transform(json.getData(), TbdXacnhan09.class);

                variables.addTextVariable(new TextVariable("#{Break}", " \n "));
                variables.addTextVariable(new TextVariable("#{XNDTitle}", "XÁC NHẬN CỦA CƠ QUAN KIỂM DỊCH ĐỘNG VẬT:"));
                variables.addTextVariable(new TextVariable("#{XNDLine1}", "Đồng ý đưa hàng hóa về địa điểm: " + optional(xnd.getFiQuarantineLocationName())));
                variables.addTextVariable(new TextVariable("#{XNDLine2}", String.format("để làm thủ tục kiểm dịch trong khoảng thời gian từ %s đến %s",
                        formatLocaleDate(xnd.getFiMonitoringLocationTimeFrom()),
                        formatLocaleDate(xnd.getFiMonitoringLocationTimeTo()))));
                variables.addTextVariable(new TextVariable("#{XNDLine3}", String.format("Vào sổ số %s, %s",
                        hoso.getFiRegistrationComfirmNo(),
                        formatLocaleDate(xnd.getFiSignConfirmDate()))));
                variables.addTextVariable(new TextVariable("#{XNDLine4}", hoso.getFiQuarantineDepartmentName() + "(**)"));
                variables.addTextVariable(new TextVariable("#{XNDLine5}", "(Ký, đóng dấu, ghi rõ họ tên)"));
                variables.addTextVariable(new TextVariable("#{XNDLine6}", "Đã ký"));
                variables.addTextVariable(new TextVariable("#{XNDLine7}", xnd.getFiSignConfirmName()));
            }
        }
        return variables;
    }
}
