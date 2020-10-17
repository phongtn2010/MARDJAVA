package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard07Constant;
import com.nsw.mard.p7.model.*;
import com.nsw.mard.service.DinhkemService;
import com.nsw.util.Constants;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mard/07")
public class Mard07Api extends BaseApi {
    static final String TAG = "mard07Api";
    @Autowired
    DinhkemService attachmentService;

    @RequestMapping(value = "/hoso/find", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHosoByFilter(@RequestBody FilterForm filterForm) {
        ResponseJson json = new ResponseJson();
        try {
            filterForm.setFiCompanyTaxCode(getUsername());
            json = BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.TIMKIEM), filterForm);
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

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByID(
            @RequestParam(name = "idHoSo") String idHoSo
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(idHoSo, null)){
                json.setSuccess(false);
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.TIMKIEM) + "?id=" + idHoSo);
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
    ResponseJson createHoso(
            @RequestBody TbdHoso07 tbdhoso07
    ) {
        return save(tbdhoso07);
    }

    @RequestMapping(value = "/hdsd", method = RequestMethod.GET)
    public void getHDSD(
            HttpServletResponse response,
            HttpServletRequest request
    ){
        try {
            String templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/07/hdsd.docx");
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

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoso07 tbdhoso07
    ) {
        ResponseJson returnJson = new ResponseJson();
        returnJson.setSuccess(false);

        try {
            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard07Constant.EnableSign))) {
                returnJson = send(tbdhoso07);
            } else {
                tbdhoso07.setFiTaxCode(getUsername());
                tbdhoso07.setFiSignDate(new Date());
                ResponseJson tmpJson = save(tbdhoso07);
                if (tmpJson.isSuccess() == false) {
                    return tmpJson;
                }
                HashMap<String, Object> tmpData = (HashMap<String, Object>) tmpJson.getData();
                returnJson = getHoSoByID(tmpData.get("fiIdHS").toString());
                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    Long fiTrangthai = Long.valueOf(data.get("fiHSStatus").toString());
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiNSWFileCode").toString());
                    sendMessage.setType(Mard07Constant.TYPE.TYPE_10);

                    if (fiTrangthai.equals(Mard07Constant.HosoStatus.TAO_MOI)) {
                        sendMessage.setFunction(Mard07Constant.FUNCTION.FUNCTION_01);
                    } else if (fiTrangthai.equals(Mard07Constant.HosoStatus.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(Mard07Constant.FUNCTION.FUNCTION_02);
                    } else if (fiTrangthai.equals(Mard07Constant.HosoStatus.YEU_CAU_BO_SUNG)) {
                        sendMessage.setFunction(Mard07Constant.FUNCTION.FUNCTION_04);
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

    @RequestMapping(value = "/hoso/edit", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson editHoso(
            @RequestBody TbdHoso07 tbdhoso07
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {

            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard07Constant.EnableSign))) {
                tbdhoso07.setFiSignDate(new Date());
                tbdhoso07.setFiTaxCode(getUsername());
                return BackendRequestHelper.getInstance().doCustomRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.EDIT_HOSO), HttpMethod.POST, tbdhoso07, new HashMap<>());
            } else {
                returnJson = saveBeforeUpdate(tbdhoso07);

                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiNSWFileCode").toString());
                    sendMessage.setType(Mard07Constant.TYPE.TYPE_12);
                    sendMessage.setFunction(Mard07Constant.FUNCTION.FUNCTION_08);
                    sendMessage.setFiReason(tbdhoso07.getFiModifyReason());

                    SignData signData = getXMLForSign(sendMessage);
                    returnJson.setSign(signData);
                }

                returnJson.setData(tbdhoso07);

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

    @RequestMapping(value = "/hoso/cancel", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson requestCancelHoso(
            @RequestBody TbdYcrut07 tbdhoso07
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (!isOwner(null, tbdhoso07.getFiNSWFileCode())){
                returnJson.setSuccess(false);
                return returnJson;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.CANCEL_HOSO), tbdhoso07);
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

    @RequestMapping(value = "/hoso/delete", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson deleteHoso(
            @RequestParam String fiNSWFileCode,
            @RequestParam String fiTaxCode
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (!isOwner(null, fiNSWFileCode)){
                returnJson.setSuccess(false);
                return returnJson;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DELETE_HOSO) + "?fiNSWFileCode=" + fiNSWFileCode + "&fiTaxCode=" + fiTaxCode);
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

    @RequestMapping(value = "/danhmuc/trangthai", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhSachTrangThai() {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_TRANGTHAI) + "?systemId=7");
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

    @RequestMapping(value = "/danhmuc/hanghoa", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhMucHangHoa(
            @RequestParam String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHMUC_HANGHOA) + "?type=" + type);
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

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_QUOCGIA));
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

    @RequestMapping(value = "/danhmuc/cuakhau", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getPort(
            @RequestParam(name = "countryCode", required = false) String countryCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_CUAKHAU) + "?countryCode=" + countryCode);
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

    @RequestMapping(value = "/danhmuc/tinhthanh", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhmucTinhthanh() {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_TINHTHANH));
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

    @RequestMapping(value = "/danhmuc/mdsd", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getDanhmucMDSD(
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_MUCDICHSD) + "?systemId=" + systemId);
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

    @RequestMapping(value = "/danhmuc/unit", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getUOMs(
            @RequestParam(name = "unitTypeId", required = true) String unitTypeId,
            @RequestParam(name = "systemId", required = true) String systemId
    ) {

        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_DONVITINH) + "?unitTypeId=" + unitTypeId + "&systemId=" + systemId);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json = new ResponseJson();
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/danhmuc/giayphep06", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getGiayPhep06() {
        ResponseJson responseJson = new ResponseJson();
        try {
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_GIAYPHEP06) + "?fiTaxCode=" + getUsername());
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

    @RequestMapping(value = "/danhmuc/dinhkem", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getAttachmentType(
            @RequestParam(name = "systemId") String systemId,
            @RequestParam(name = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.DANHSACH_DINHKEM) + "?systemId=" + systemId + "&type=" + type);
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
    ResponseJson getLicense(
            @RequestParam(value = "code") String code,
            @RequestParam(value = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, code)){
                json.setSuccess(false);
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.LICENSE_GET) + "?code=" + code + "&type=" + type);
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

    @RequestMapping(value = "/giayphep/edit", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson xinSuaGCN(
            @RequestBody XinSuaGCN xinSuaGCN
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, xinSuaGCN.getFiNSWFileCode())){
                json.setSuccess(false);
                return json;
            }
            xinSuaGCN.setFiRequestDate(new Date());
            json = BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.LICENSE_EDIT), xinSuaGCN);
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
    ResponseJson getApphiByHSID(
            @RequestParam("fiHSCode") String fiHSCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, fiHSCode)){
                json.setSuccess(false);
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.HOSO_APPHI) + "?fiHSCode=" + fiHSCode);
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
    ResponseJson getLichsu(
            @RequestParam("fiHSCode") String fiHSCode,
            @RequestParam(required = false) Integer p,
            @RequestParam(required = false) Integer s
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, fiHSCode)){
                json.setSuccess(false);
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.HOSO_LICHSUXULY) + "?fiHSCode=" + fiHSCode + "&p=" + p + "&s=" + s);
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
            if (!".jpg,.jpeg,.pdf,.tif".contains(format)) {
                ResponseJson responseJson = new ResponseJson();
                responseJson.setSuccess(false);
                responseJson.setMessage("Tệp đính kèm không đúng định dạng");
                return responseJson;
            }
            return attachmentService.uploadFile(file, fiMaLoai, "BNNPTNT0600010");

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return new ResponseJson(ex.getMessage());
        }
    }

    @RequestMapping(value = "/dinhkem/download/{id}", method = RequestMethod.GET)
    public void downloadAttachment(
            @PathVariable(value = "id") String fiGuid, HttpServletResponse response) {
        try {
            String restUri = Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.ATTACHMENT_DOWNLOAD) + "/" + fiGuid;
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.execute(
                    restUri,
                    HttpMethod.GET,
                    (ClientHttpRequest requestCallback) -> {
                    },
                    responseExtractor -> {
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                        response.addHeader(
                                HttpHeaders.CONTENT_DISPOSITION,
                                responseExtractor.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION));
                        IOUtils.copy(responseExtractor.getBody(), response.getOutputStream());
                        return null;
                    });
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson verify(@RequestBody TokenInfo token) {
        token.setUser(this.getUsername());
        ResponseJson responseJson = new ResponseJson();

        responseJson.setSuccess(true);
        return responseJson;
//        return this.verifySignature(token);
    }

    private SignData getXMLForSign(SendMessage sendMessage) throws Exception {
        ResponseJson resultSignFlow = BackendRequestHelper.getInstance()
                .doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.GET_XML), sendMessage);

        if (resultSignFlow.isSuccess()) {
            SignData signData = new SignData();
            signData.setFiDocumentCode(sendMessage.getFiNSWFileCode());
            signData.setFiDocType("BNNPTNT0600010");
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

    private ResponseJson send(TbdHoso07 tbdHoso) {
        try {
            tbdHoso.setFiTaxCode(getUsername());
            tbdHoso.setFiSignDate(new Date());
            return BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.SEND_HOSO), tbdHoso);
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

    private ResponseJson save(TbdHoso07 tbdHoso) {
        try {
            tbdHoso.setFiTaxCode(getUsername());
            tbdHoso.setFiSignDate(new Date());
            return BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.CREATE_HOSO), tbdHoso);
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

    private ResponseJson saveBeforeUpdate(TbdHoso07 tbdHoso) {
        try {
            tbdHoso.setFiSignDate(new Date());
            tbdHoso.setFiTaxCode(getUsername());

            return BackendRequestHelper.getInstance()
                    .doPostRequest(
                            Mard07Constant.getInstance()
                                    .getApiUrl(environment, Mard07Constant.API.SAVE_BEFORE_UPDATE),
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
            @RequestBody TbdHoso07 tbdhoso
    ) {
        return send(tbdhoso);
    }


    @RequestMapping(value = "/hoso/guiycs", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiYeucauSuaHosoDaKy(
            @RequestBody TbdHoso07 tbdHoso
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            tbdHoso.setFiSignDate(new Date());
            tbdHoso.setFiTaxCode(getUsername());
            return BackendRequestHelper.getInstance().doPostRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.UPDATE_ONLY), tbdHoso);
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
                Mard07Constant.getInstance().getApiUrl(
                        environment,
                        Mard07Constant.API.TIMKIEM
                ) + "?id=" + (StringUtils.isEmpty(idHS) ? "" : idHS) + "&nswFileCode=" + (StringUtils.isEmpty(nswFileCode) ? "" : nswFileCode) + "&taxCode=" + getUsername());
        return json != null && json.getData() != null;
    }


    @RequestMapping(value = "/gcn/download/{gcn}/{idHoso}", method = RequestMethod.GET)
    public void downloadGCN(
            @PathVariable String gcn,
            @PathVariable String idHoso,
            HttpServletResponse response,
            HttpServletRequest request) {
        try {
            if (!isOwner(null, idHoso)){
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = "";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;
            switch (gcn) {
                case "gvc":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/07/mard_07_gvc.docx");
                    fileName = new Date().getTime() + "-mard-07-gvc.docx";
                    ResponseJson gvcJSON = getLicense(idHoso, "gvc");

                    if (gvcJSON == null || !gvcJSON.getSuccess() || gvcJSON.getData() == null) {
                        return;
                    }

                    TbdCvCnvc07[] gvcs = GsonUtils.getInstance().transform(gvcJSON.getData(), TbdCvCnvc07[].class);
                    if (gvcs == null || gvcs.length == 0) {
                        return;
                    }

                    variables = genGVC(gvcs[0]);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gvcs[0].getFiCertificateNo() + "-gvc.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));
                    }
                    break;
                case "cnkd":
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/07/mard_07_cnkd.docx");
                    fileName = new Date().getTime() + "-mard-07-cnkd.docx";
                    ResponseJson gcnJSON = getLicense(idHoso, "cnkd");

                    if (gcnJSON == null || !gcnJSON.getSuccess() || gcnJSON.getData() == null) {
                        return;
                    }

                    TbdCvCnkd07[] gcns = GsonUtils.getInstance().transform(gcnJSON.getData(), TbdCvCnkd07[].class);
                    if (gcns == null || gcns.length == 0) {
                        return;
                    }


                    variables = genCNKD(gcns[0]);
                    if (templatePath != null && !templatePath.isEmpty()) {
                        tempFile = new File(tempFoleder + fileName);
                        docx = new Docx(templatePath);
                        docx.setVariablePattern(new VariablePattern("#{", "}"));
                        docx.fillTemplate(variables);
                        // save filled .docx file
                        docx.save(tempFile.getPath());
                        fileName = gcns[0].getFiCertificateNo() + "-cnkd.docx";
                        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getOutputStream().write(loadFile(tempFile));

                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }


    @RequestMapping(value = "/hoso/download/{idHoso}", method = RequestMethod.GET)
    public void downloadHoso(
            @PathVariable String idHoso,
            HttpServletResponse response,
            HttpServletRequest request) {
        try {
            ResponseJson hosoJson = getHoSoByID(idHoso);
            if (hosoJson == null || hosoJson.getSuccess() == false || hosoJson.getData() == null) {
                return;
            }
            TbdHoso07 hoso = GsonUtils.getInstance().transform(hosoJson.getData(), TbdHoso07.class);
            // Kiểm tra xem có đc upload lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiTaxCode())) {
                return;
            }
            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
        //    String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-mard-07-3ts.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;
            if ("4".equals(hoso.getFiRequestOption())) {
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/07/mard_07_3ts_1.docx");
            } else if ("6".equals(hoso.getFiRequestOption())) {
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/07/mard_07_3ts_2.docx");
            } else if ("10".equals(hoso.getFiRequestOption())) {
                templatePath = request.getRealPath("/WEB-INF/downloads/mard/07/mard_07_3ts_3.docx");
            }

            variables = genMau3TS(hoso);
            if (templatePath != null && !templatePath.isEmpty()) {
                tempFile = new File(tempFoleder + fileName);
                docx = new Docx(templatePath);
                docx.setVariablePattern(new VariablePattern("#{", "}"));
                docx.fillTemplate(variables);
                // save filled .docx file
                docx.save(tempFile.getPath());
                fileName = hoso.getFiNSWFileCode() + "-hoso.docx";
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.getOutputStream().write(loadFile(tempFile));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    private Variables genGVC(TbdCvCnvc07 giayPhep) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{SOCV}", giayPhep.getFiCertificateNo()));
        variables.addTextVariable(new TextVariable("#{DEPARTMENT}", giayPhep.getFiDepartmentLisenceName().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{HOTEN}", giayPhep.getFiNameOfRegistration() == null ? "" : giayPhep.getFiNameOfRegistration()));
        variables.addTextVariable(new TextVariable("#{DIADIEM}", giayPhep.getFiAddressOfRegistration() == null ? "" : giayPhep.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{PHONE}", giayPhep.getFiPhoneOfRegistration() == null ? "" : giayPhep.getFiPhoneOfRegistration()));
        variables.addTextVariable(new TextVariable("#{FAX}", giayPhep.getFiFaxOfRegistration() == null ? "" : giayPhep.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{EMAIL}", giayPhep.getFiEmailOfRegistration() == null ? "" : giayPhep.getFiEmailOfRegistration()));


        TableVariable tableVariable = new TableVariable();
        List<Variable> sttColumnVariables = new ArrayList<>();
        List<Variable> tenTMColumnVariables = new ArrayList<>();
        List<Variable> tenKHColumnVariables = new ArrayList<>();
        List<Variable> kickCoColumnVariables = new ArrayList<>();
        List<Variable> soLuongColumnVariables = new ArrayList<>();
        List<Variable> donViTinhColumnVariables = new ArrayList<>();
        List<Variable> nuocXuatXuColumnVariables = new ArrayList<>();

        String parentDepartmentName = "CỤC THÚ Y";

        if (!TextUtils.isEmpty(giayPhep.getFiParentDepartmentName())){
            parentDepartmentName = giayPhep.getFiParentDepartmentName();
        }

        variables.addTextVariable(new TextVariable("#{ParentDepartmentName}", parentDepartmentName.toUpperCase()));

        if (giayPhep.getFiGoodsList() != null && !giayPhep.getFiGoodsList().isEmpty()) {
            int index = 0;
            for (TbdCvCnvcHh07 hanghoa07 : giayPhep.getFiGoodsList()) {
                index++;
                sttColumnVariables.add(new TextVariable("#{STT}", index + ""));
                tenTMColumnVariables.add(new TextVariable("#{TENTM}", hanghoa07.getFiNameOfGoods() == null ? "" : hanghoa07.getFiNameOfGoods()));
                tenKHColumnVariables.add(new TextVariable("#{TENKH}", hanghoa07.getFiNameSicenceOfGoods() == null ? "" : hanghoa07.getFiNameSicenceOfGoods()));
                kickCoColumnVariables.add(new TextVariable("#{KICHCO}", hanghoa07.getFiSizeOrShape() == null ? "" : hanghoa07.getFiSizeOrShape()));
                soLuongColumnVariables.add(new TextVariable("#{SOLUONG}", hanghoa07.getFiQuantityOrWeight() == null ? "" : hanghoa07.getFiQuantityOrWeight()));
                donViTinhColumnVariables.add(new TextVariable("#{DONVITINH}", hanghoa07.getFiQuantityOrWeightUnitName() == null ? "" : hanghoa07.getFiQuantityOrWeightUnitName()));
                nuocXuatXuColumnVariables.add(new TextVariable("#{NUOCXUATXU}", hanghoa07.getFiOriginationName() == null ? "" : hanghoa07.getFiOriginationName()));
            }
        }

        variables.addTableVariable(tableVariable);

        tableVariable.addVariable(sttColumnVariables);
        tableVariable.addVariable(tenTMColumnVariables);
        tableVariable.addVariable(tenKHColumnVariables);
        tableVariable.addVariable(kickCoColumnVariables);
        tableVariable.addVariable(soLuongColumnVariables);
        tableVariable.addVariable(donViTinhColumnVariables);
        tableVariable.addVariable(nuocXuatXuColumnVariables);

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrWeight}", String.format("%.2f", giayPhep.getFiTotalQuantityOrWeight())));
        variables.addTextVariable(new TextVariable("#{fiTotalUnitName}", giayPhep.getFiTotalUnitName()));

        variables.addTextVariable(new TextVariable("#{MUCDICH}", giayPhep.getFiPurposeUse() == null ? "" : giayPhep.getFiPurposeUse()));
        variables.addTextVariable(new TextVariable("#{QUYCACH}", giayPhep.getFiPackage() == null ? "" : giayPhep.getFiPackage()));
        variables.addTextVariable(new TextVariable("#{SOBAOGOI}", giayPhep.getFiQuantityPackage() == null ? "" : giayPhep.getFiQuantityPackage() + ""));

        variables.addTextVariable((new TextVariable("#{TOCHUCXUATKHAU}", giayPhep.getFiNameOfExporter() == null ?
                "" : giayPhep.getFiNameOfExporter())));
        variables.addTextVariable((new TextVariable("#{DCTOCHUCXUATKHAU}", giayPhep.getFiAddressOfExporter() == null ?
                "" : giayPhep.getFiAddressOfExporter())));

        variables.addTextVariable((new TextVariable("#{TENCSSX}", giayPhep.getFiNameOfProduce() == null ?
                "" : giayPhep.getFiNameOfProduce())));
        variables.addTextVariable((new TextVariable("#{DCTENCSSX}", giayPhep.getFiAddressOfProduce() == null ?
                "" : giayPhep.getFiAddressOfProduce())));

        variables.addTextVariable(new TextVariable("#{VUNGNUOCXUATXU}", giayPhep.getFiOriginationExport() == null ? "" : giayPhep.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{NUOCQUACANH}", giayPhep.getFiOriginationTransit() == null ? "" : giayPhep.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{CUAKHAUNHAP}", giayPhep.getFiPortOfDestinationName() == null ? "" : giayPhep.getFiPortOfDestinationName()));

        if (giayPhep.getFiImportDate() != null) {
            Date date = sdf2.parse(giayPhep.getFiDeadlineOfTransfer());
            variables.addTextVariable(new TextVariable("#{THOIGIANNHAP}", sdf.format(date)));
        } else {
            variables.addTextVariable(new TextVariable("#{THOIGIANNHAP}", ""));
        }

        variables.addTextVariable(new TextVariable("#{GIAYTOLIENQUAN}", giayPhep.getFiDocumentAttch() == null ? "" : giayPhep.getFiDocumentAttch()));

        variables.addTextVariable(new TextVariable("#{THUCTRANG}", giayPhep.getFiHealthSituation() == null ? "" : giayPhep.getFiHealthSituation()));
        variables.addTextVariable(new TextVariable("#{KHUTRUNG}", giayPhep.getFiNameOfAntiseptic() == null ? "" : giayPhep.getFiNameOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{NONGDO}", giayPhep.getFiConcentrationOfAntiseptic() == null ? "" : giayPhep.getFiConcentrationOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{DUOCPHEPVCVE}", giayPhep.getFiNameOfTransfer() == null ? "" : giayPhep.getFiNameOfTransfer()));
        variables.addTextVariable(new TextVariable("#{DIACHICONGTY}", giayPhep.getFiAddressOfTransfer() == null ? "" : giayPhep.getFiAddressOfTransfer()));

        if (giayPhep.getFiDeadlineOfTransfer() != null) {
            Date date = sdf2.parse(giayPhep.getFiDeadlineOfTransfer());
            variables.addTextVariable(new TextVariable("#{NGAYVC}", sdf.format(date)));
        } else {
            variables.addTextVariable(new TextVariable("#{NGAYVC}", ""));
        }

        variables.addTextVariable(new TextVariable("#{LOTRINH}", giayPhep.getFiRouteOfTransfer() == null ? "" : giayPhep.getFiRouteOfTransfer()));

        if (giayPhep.getFiExpireDate() != null) {
            Date date = sdf2.parse(giayPhep.getFiExpireDate());
            variables.addTextVariable(new TextVariable("#{GIAYCOGIATRI}", sdf.format(date)));
        } else {
            variables.addTextVariable(new TextVariable("#{GIAYCOGIATRI}", ""));
        }

        variables.addTextVariable(new TextVariable("#{KIEMDICHVIEN}", giayPhep.getFiCreaterName() == null ? "" : giayPhep.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{THUTRUONGCOBAN}", giayPhep.getFiSignConfirmName() == null ? "" : giayPhep.getFiSignConfirmName()));
        variables.addTextVariable(new TextVariable("#{THUTRUONG}", giayPhep.getFiSignConfirmTitle() == null ? "" : giayPhep.getFiSignConfirmTitle().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{CAPTAI}", giayPhep.getFiSignConfirmAddress() == null ? "" : giayPhep.getFiSignConfirmAddress()));

        if (giayPhep.getFiExpireDate() != null) {
            Date date = sdf2.parse(giayPhep.getFiSignConfirmDate());
            variables.addTextVariable(new TextVariable("#{NGAYCAP}", sdf.format(date)));
        } else {
            variables.addTextVariable(new TextVariable("#{NGAYCAP}", ""));
        }

        return variables;
    }

    private Variables genCNKD(TbdCvCnkd07 giayPhep) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{CertificateNo}", giayPhep.getFiCertificateNo()));
        variables.addTextVariable(new TextVariable("#{DepartmentLisenceName}", giayPhep.getFiDepartmentLisenceName().toUpperCase()));

        variables.addTextVariable(new TextVariable("#{NameOfRegistration}", giayPhep.getFiNameOfRegistration() == null ? "" : giayPhep.getFiNameOfRegistration()));
        variables.addTextVariable(new TextVariable("#{AddressOfRegistration}", giayPhep.getFiAddressOfRegistration() == null ? "" : giayPhep.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{PhoneOfRegistration}", giayPhep.getFiPhoneOfRegistration() == null ? "" : giayPhep.getFiPhoneOfRegistration()));
        variables.addTextVariable(new TextVariable("#{NumberOfRegistration}", giayPhep.getFiNumberOfRegistration() == null ? "" : giayPhep.getFiNumberOfRegistration()));
        variables.addTextVariable(new TextVariable("#{EmailOfRegistration}", giayPhep.getFiEmailOfRegistration() == null ? "" : giayPhep.getFiEmailOfRegistration()));
        variables.addTextVariable(new TextVariable("#{FaxOfRegistration}", giayPhep.getFiFaxOfRegistration() == null ? "" : giayPhep.getFiFaxOfRegistration()));

        String parentDepartmentName = "CỤC THÚ Y";

        if (!TextUtils.isEmpty(giayPhep.getFiParentDepartmentName())){
            parentDepartmentName = giayPhep.getFiParentDepartmentName();
        }

        variables.addTextVariable(new TextVariable("#{ParentDepartmentName}", parentDepartmentName.toUpperCase()));

        TableVariable tableVariable = new TableVariable();
        List<Variable> sttColumnVariables = new ArrayList<>();
        List<Variable> tenTMColumnVariables = new ArrayList<>();
        List<Variable> tenKHColumnVariables = new ArrayList<>();
        List<Variable> kickCoColumnVariables = new ArrayList<>();
        List<Variable> soLuongColumnVariables = new ArrayList<>();
        List<Variable> donViTinhColumnVariables = new ArrayList<>();

        if (giayPhep.getFiGoodsList() != null && !giayPhep.getFiGoodsList().isEmpty()) {
            int index = 0;
            for (TbdCvCnkdHh07 hanghoa07 : giayPhep.getFiGoodsList()) {
                index++;
                sttColumnVariables.add(new TextVariable("#{STT}", index + ""));
                tenTMColumnVariables.add(new TextVariable("#{NameOfGoods}", hanghoa07.getFiNameOfGoods() == null ? "" : hanghoa07.getFiNameOfGoods()));
                tenKHColumnVariables.add(new TextVariable("#{NameSicenceOfGoods}", hanghoa07.getFiNameSicenceOfGoods() == null ? "" : hanghoa07.getFiNameSicenceOfGoods()));
                kickCoColumnVariables.add(new TextVariable("#{SizeOrShape}", hanghoa07.getFiSizeOrShape() == null ? "" : hanghoa07.getFiSizeOrShape()));
                soLuongColumnVariables.add(new TextVariable("#{QuantityOrWeight}", hanghoa07.getFiQuantityOrWeight() == null ? "" : hanghoa07.getFiQuantityOrWeight()));
                donViTinhColumnVariables.add(new TextVariable("#{QuantityOrWeightUnitName}", hanghoa07.getFiQuantityOrWeightUnitName() == null ? "" : hanghoa07.getFiQuantityOrWeightUnitName()));
            }
        }

        variables.addTableVariable(tableVariable);

        tableVariable.addVariable(sttColumnVariables);
        tableVariable.addVariable(tenTMColumnVariables);
        tableVariable.addVariable(tenKHColumnVariables);
        tableVariable.addVariable(kickCoColumnVariables);
        tableVariable.addVariable(soLuongColumnVariables);
        tableVariable.addVariable(donViTinhColumnVariables);

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrWeight}", giayPhep.getFiTotalQuantityOrWeight().toString()));
        variables.addTextVariable(new TextVariable("#{fiTotalUnitName}", giayPhep.getFiTotalUnitName()));

        variables.addTextVariable(new TextVariable("#{PurposeUse}", giayPhep.getFiPurposeUse() == null ? "" : giayPhep.getFiPurposeUse()));
        variables.addTextVariable(new TextVariable("#{Package}", giayPhep.getFiPackage() == null ? "" : giayPhep.getFiPackage()));
        variables.addTextVariable(new TextVariable("#{QuantityPackage}", giayPhep.getFiQuantityPackage() == null ? "" : giayPhep.getFiQuantityPackage() + ""));

        variables.addTextVariable((new TextVariable("#{NameOfExporter}", giayPhep.getFiNameOfExporter() == null ?
                "" : giayPhep.getFiNameOfExporter())));
        variables.addTextVariable((new TextVariable("#{AddressOfExporter}", giayPhep.getFiAddressOfExporter() == null ?
                "" : giayPhep.getFiAddressOfExporter())));

        variables.addTextVariable((new TextVariable("#{NameOfProduce}", giayPhep.getFiNameOfProduce() == null ?
                "" : giayPhep.getFiNameOfProduce())));
        variables.addTextVariable((new TextVariable("#{AddressOfProduce}", giayPhep.getFiAddressOfProduce() == null ?
                "" : giayPhep.getFiAddressOfProduce())));

        variables.addTextVariable(new TextVariable("#{OriginationExport}", giayPhep.getFiOriginationExport() == null ? "" : giayPhep.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{OriginationTransit}", giayPhep.getFiOriginationTransit() == null ? "" : giayPhep.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{PortOfDestinationName}", giayPhep.getFiPortOfDestinationName() == null ? "" : giayPhep.getFiPortOfDestinationName()));

        if (giayPhep.getFiDateOfTestResult() != null) {
            variables.addTextVariable(new TextVariable("#{DateOfTestResult}", sdf.format(giayPhep.getFiDateOfTestResult())));
        } else {
            variables.addTextVariable(new TextVariable("#{DateOfTestResult}", ""));
        }

        variables.addTextVariable(new TextVariable("#{TestResultNo}", giayPhep.getFiTestResultNo() == null ? "" : giayPhep.getFiTestResultNo()));

        variables.addTextVariable(new TextVariable("#{DepartmentOfTestResult}", giayPhep.getFiDepartmentOfTestResult() == null ? "" : giayPhep.getFiDepartmentOfTestResult()));
        variables.addTextVariable(new TextVariable("#{MeetRequirements}", giayPhep.getFiMeetRequirements() == null ? "" : giayPhep.getFiMeetRequirements()));

        if (giayPhep.getFiImportDate() != null) {
            variables.addTextVariable(new TextVariable("#{ImportDate}", sdf.format(giayPhep.getFiImportDate())));
        }

        variables.addTextVariable(new TextVariable("#{DocumentAttch}", giayPhep.getFiDocumentAttch() == null ? "" : giayPhep.getFiDocumentAttch()));
        variables.addTextVariable(new TextVariable("#{LocationOfQuarantine}", giayPhep.getFiLocationOfQuarantine() == null ? "" : giayPhep.getFiLocationOfQuarantine()));

        variables.addTextVariable(new TextVariable("#{NameOfAntiseptic}", giayPhep.getFiNameOfAntiseptic() == null ? "" : giayPhep.getFiNameOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{ConcentrationOfAntiseptic}", giayPhep.getFiConcentrationOfAntiseptic() == null ? "" : giayPhep.getFiConcentrationOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{SignConfirmAddress}", giayPhep.getFiSignConfirmAddress() == null ? "" : giayPhep.getFiSignConfirmAddress()));

        if (giayPhep.getFiNoExpireDate() == 0) {
            variables.addTextVariable(new TextVariable("#{ExpireDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{ExpireDate}", giayPhep.getFiExpireDate() == null ?
                    "" : "Giấy có giá trị đến " + sdf.format(giayPhep.getFiExpireDate())));
        }

        variables.addTextVariable(new TextVariable("#{SignConfirmAddress}", giayPhep.getFiSignConfirmAddress() == null ? "" : giayPhep.getFiSignConfirmAddress()));

        if (giayPhep.getFiSignConfirmDate() != null) {
            Date date = sdf2.parse(giayPhep.getFiSignConfirmDate());
            variables.addTextVariable(new TextVariable("#{SignConfirmDate}", sdf.format(date)));
        } else {
            variables.addTextVariable(new TextVariable("#{SignConfirmDate}", ""));
        }

        String fiNotesForItemNo1 = "";
        if (!TextUtils.isEmpty(giayPhep.getFiNotesForItemNo1())) {
            fiNotesForItemNo1 = String.format("(%s)", fiNotesForItemNo1);
        }

        String contentCertItem1 = "Có đầy đủ hồ sơ, giấy tờ hợp lệ khi nhập khẩu; " + fiNotesForItemNo1;
        String contentCertItem2 = "Động vật thủy sản không có triệu chứng lâm sàng của bệnh truyền nhiễm/Sản phẩm động vật thủy sản không có biểu hiện biến đổi, mang mầm bệnh; được bao gói, bảo quản đảm bảo yêu cầu vệ sinh thú y theo quy định;";
        String contentCertItem3 = "Số hàng trên trên đã được lấy mẫu kiểm tra, xét nghiệm theo kết quả xét nghiệm số: "
                + (giayPhep.getFiTestResultNo() == null ? "" : giayPhep.getFiTestResultNo())
                + " ngày "
                + (giayPhep.getFiDateOfTestResult() == null ? "" : sdf.format(giayPhep.getFiDateOfTestResult())) + " của "
                + (giayPhep.getFiDepartmentOfTestResult() == null ? "" : giayPhep.getFiDepartmentOfTestResult())
                + " (gửi kèm bản sao, nếu có);";
        String contentCertItem4 = "Số hàng trên đáp ứng các yêu cầu sau: "
                + (giayPhep.getFiMeetRequirements() == null ? "" : giayPhep.getFiMeetRequirements()) + ";";
        String contentCertItem5 = "Phương tiện vận chuyển, các vật dụng khác có liên quan kèm theo đảm bảo yêu cầu vệ sinh thú y, đã được khử trùng tiêu độc bằng "
                + (giayPhep.getFiNameOfAntiseptic() == null ? "" : giayPhep.getFiNameOfAntiseptic()) + " nồng độ "
                + (giayPhep.getFiConcentrationOfAntiseptic() == null ? "" : giayPhep.getFiConcentrationOfAntiseptic()) + ";";

        String item = giayPhep.getFiIncludeCertificateItems() != null ? giayPhep.getFiIncludeCertificateItems() : "";
        if (item.indexOf("1") > -1) {
            variables.addTextVariable(new TextVariable("#{contentCertItem1}", contentCertItem1));
            variables.addTextVariable(new TextVariable("#{contentCertItem1s}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{contentCertItem1}", ""));
            variables.addTextVariable(new TextVariable("#{contentCertItem1s}", contentCertItem1));
        }
        if (item.indexOf("2") > -1) {
            variables.addTextVariable(new TextVariable("#{contentCertItem2}", contentCertItem2));
            variables.addTextVariable(new TextVariable("#{contentCertItem2s}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{contentCertItem2}", ""));
            variables.addTextVariable(new TextVariable("#{contentCertItem2s}", contentCertItem2));
        }
        if (item.indexOf("3") > -1) {
            variables.addTextVariable(new TextVariable("#{contentCertItem3}", contentCertItem3));
            variables.addTextVariable(new TextVariable("#{contentCertItem3s}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{contentCertItem3}", ""));
            variables.addTextVariable(new TextVariable("#{contentCertItem3s}", contentCertItem3));
        }
        if (item.indexOf("4") > -1) {
            variables.addTextVariable(new TextVariable("#{contentCertItem4}", contentCertItem4));
            variables.addTextVariable(new TextVariable("#{contentCertItem4s}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{contentCertItem4}", ""));
            variables.addTextVariable(new TextVariable("#{contentCertItem4s}", contentCertItem4));
        }
        if (item.indexOf("5") > -1) {
            variables.addTextVariable(new TextVariable("#{contentCertItem5}", contentCertItem5));
            variables.addTextVariable(new TextVariable("#{contentCertItem5s}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{contentCertItem5}", ""));
            variables.addTextVariable(new TextVariable("#{contentCertItem5s}", contentCertItem5));
        }

        variables.addTextVariable(new TextVariable("#{CreaterName}", giayPhep.getFiCreaterName() == null ? "" : giayPhep.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{SignConfirmName}", giayPhep.getFiSignConfirmName() == null ? "" : giayPhep.getFiSignConfirmName()));
        variables.addTextVariable(new TextVariable("#{SignConfirmTitle}", giayPhep.getFiSignConfirmTitle() == null ? "" : giayPhep.getFiSignConfirmTitle().toUpperCase()));

        return variables;
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
                    .doGetRequest(Mard07Constant.getInstance().getApiUrl(environment, Mard07Constant.API.ROLL_BACK) + "?nswFileCode=" + nswFileCode);
            return rs;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            rs.setData(null);
            rs.setSuccess(false);
            rs.setMessage(ex.getMessage());
            return rs;
        }
    }


    private Variables genMau3TS(TbdHoso07 hoso07) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";
        String largeSpace = "................................................................................................................................................................";
        variables.addTextVariable(new TextVariable("#{THOIGIANDIADIEM}", String.format("%s, ngày %02d tháng %02d năm %d", hoso07.getFiSignAddress(), hoso07.getFiSignDate().getDate(), hoso07.getFiSignDate().getMonth() + 1, 1900 + hoso07.getFiSignDate().getYear())));
        variables.addTextVariable(new TextVariable("#{SODON}", hoso07.getFiNSWFileCode()));
        variables.addTextVariable(new TextVariable("#{KINHGUI}", hoso07.getFiDepartmentofQuarantineName()));
        variables.addTextVariable(new TextVariable("#{TOCHUCCANHAN}", hoso07.getFiNameOfRegistration()));
        variables.addTextVariable(new TextVariable("#{DIACHI}", hoso07.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{DIENTHOAI}", hoso07.getFiPhoneOfRegistration() == null ? space : hoso07.getFiPhoneOfRegistration()));
        variables.addTextVariable(new TextVariable("#{FAX}", hoso07.getFiFaxOfRegistration() == null ? space : hoso07.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{EMAIL}", hoso07.getFiEmailOfRegistration() == null ? space : hoso07.getFiEmailOfRegistration()));

        if (hoso07.getFiOptionOther() != null) {
            variables.addTextVariable(new TextVariable("#{KHAC}", "X"));
            variables.addTextVariable(new TextVariable("#{OTHER}", hoso07.getFiOptionOther()));
        } else {
            variables.addTextVariable(new TextVariable("#{OTHER}", ""));
        }

        variables.addTextVariable(new TextVariable("#{CMND}", hoso07.getFiIdentityNumber() == null ? space : hoso07.getFiIdentityNumber()));

        if (hoso07.getFiRequestOption() != null) {
            variables.addTextVariable(new TextVariable("#{NK}", 
                hoso07.getFiRequestOption().indexOf("4") > -1 ? "X" : ""));
            variables.addTextVariable(new TextVariable("#{NK_SXCB}", 
                hoso07.getFiRequestOption().indexOf("6") > -1 ? "X" : ""));
            variables.addTextVariable(new TextVariable("#{KHAC}", 
                hoso07.getFiRequestOption().indexOf("10") > -1 ? "X" : ""));
        } else {
            variables.addTextVariable(new TextVariable("#{NK}", ""));
            variables.addTextVariable(new TextVariable("#{NK_SXCB}", ""));
            variables.addTextVariable(new TextVariable("#{KHAC}", ""));
        }

        if (hoso07.getFiIdentityIssueDate() != null) {
            variables.addTextVariable(new TextVariable("#{NGAYCAP}", sdf.format(hoso07.getFiIdentityIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{NGAYCAP}", space));
        }

        variables.addTextVariable(new TextVariable("#{CAPTAI}", hoso07.getFiIdentityIssueAddress() == null ? space : hoso07.getFiIdentityIssueAddress()));
        variables.addTextVariable(new TextVariable("#{LOAIBAOBI}", hoso07.getFiPackage()));
        variables.addTextVariable(new TextVariable("#{SOHOPDONG}", hoso07.getFiContractsNo()));

        variables.addTextVariable((new TextVariable("#{TOCHUCCANHANXNK}", hoso07.getFiExporter() == null ?
                "" : hoso07.getFiExporter())));
        variables.addTextVariable((new TextVariable("#{DCTOCHUCCANHANXNK}", hoso07.getFiExporterCountryAddress() == null ?
                "" : hoso07.getFiExporterCountryAddress())));

        variables.addTextVariable(new TextVariable("#{NOISANXUAT}", hoso07.getFiProcessingName() == null ?
                "" : hoso07.getFiProcessingName()));
        variables.addTextVariable(new TextVariable("#{DCNOISANXUAT}", hoso07.getFiProcessingAddress() == null ?
                "" : hoso07.getFiProcessingAddress()));

        variables.addTextVariable(new TextVariable("#{NUOCXUATKHAU}", hoso07.getFiOriginationImport() == null ? space : hoso07.getFiOriginationImport()));
        variables.addTextVariable(new TextVariable("#{NUOCQUACANH}", hoso07.getFiOriginationTransit() == null ? space : hoso07.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{CUAKHAUXUAT}", hoso07.getFiPortOfDepartureName() == null ? space : hoso07.getFiPortOfDepartureName()));
        variables.addTextVariable(new TextVariable("#{CUAKHAUNHAP}", hoso07.getFiPortOfDestinationName() == null ? space : hoso07.getFiPortOfDestinationName()));
        variables.addTextVariable(new TextVariable("#{PHUONGTIENVC}", hoso07.getFiTransportType() == null ? space : hoso07.getFiTransportType()));
        variables.addTextVariable(new TextVariable("#{MUCDICHSD}", hoso07.getFiPurposeUse() == null ? space : hoso07.getFiPurposeUse()));
        variables.addTextVariable(new TextVariable("#{SOVANBAN}", hoso07.getFiLicenseNo() == null ? space : hoso07.getFiLicenseNo()));
        if (hoso07.getFiLicenseDate() != null) {
            variables.addTextVariable(new TextVariable("#{NGAYTHANGNAM}", sdf.format(hoso07.getFiLicenseDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{NGAYTHANGNAM}", ""));
        }

        variables.addTextVariable(new TextVariable("#{DIADIEMCACHLY}", hoso07.getFiLocationOfQuarantine()));
        variables.addTextVariable(new TextVariable("#{DIADIEMNUOITRONG}", hoso07.getFiLocationOfGrow() == null ? space : hoso07.getFiLocationOfQuarantine()));


        TableVariable tableVariable = new TableVariable();
        List<Variable> sttColumnVariables = new ArrayList<>();
        List<Variable> tenTMColumnVariables = new ArrayList<>();
        List<Variable> tenKHColumnVariables = new ArrayList<>();
        List<Variable> kickCoColumnVariables = new ArrayList<>();
        List<Variable> soLuongColumnVariables = new ArrayList<>();
        List<Variable> donViTinhColumnVariables = new ArrayList<>();
        List<Variable> nuocXuatXuColumnVariables = new ArrayList<>();

        if (hoso07.getFiGoodsList() != null && !hoso07.getFiGoodsList().isEmpty()) {
            int index = 0;
            for (TbdHanghoa07 hanghoa07 : hoso07.getFiGoodsList()) {
                index++;
                sttColumnVariables.add(new TextVariable("#{STT}", index + ""));
                tenTMColumnVariables.add(new TextVariable("#{TENTM}", hanghoa07.getFiNameOfGoods() == null ? "" : hanghoa07.getFiNameOfGoods()));
                tenKHColumnVariables.add(new TextVariable("#{TENKH}", hanghoa07.getFiNameSicenceOfGoods() == null ? "" : hanghoa07.getFiNameSicenceOfGoods()));
                kickCoColumnVariables.add(new TextVariable("#{KICHCO}", hanghoa07.getFiSizeOrShape() == null ? "" : hanghoa07.getFiSizeOrShape()));
                soLuongColumnVariables.add(new TextVariable("#{SOLUONG}", hanghoa07.getFiQuantityOrWeight() == null ? "" : hanghoa07.getFiQuantityOrWeight()));
                donViTinhColumnVariables.add(new TextVariable("#{DONVI}", hanghoa07.getFiQuantityOrWeightUnitName() == null ? "" : hanghoa07.getFiQuantityOrWeightUnitName()));
                nuocXuatXuColumnVariables.add(new TextVariable("#{NUOCXX}", hanghoa07.getFiOriginationName() == null ? "" : hanghoa07.getFiOriginationName()));
            }
        }

        variables.addTableVariable(tableVariable);

        tableVariable.addVariable(sttColumnVariables);
        tableVariable.addVariable(tenTMColumnVariables);
        tableVariable.addVariable(tenKHColumnVariables);
        tableVariable.addVariable(kickCoColumnVariables);
        tableVariable.addVariable(soLuongColumnVariables);
        tableVariable.addVariable(donViTinhColumnVariables);
        tableVariable.addVariable(nuocXuatXuColumnVariables);

        variables.addTextVariable(new TextVariable("#{THOIGIAN_KIEMDICH}", (hoso07.getFiDateOfQuarantineFrom() != null ?
                "từ " + sdf.format(hoso07.getFiDateOfQuarantineFrom()) : space) + (hoso07.getFiDateOfQuarantineTo() != null ?
                " đến " + sdf.format(hoso07.getFiDateOfQuarantineTo()) : "")));

        variables.addTextVariable(new TextVariable("#{DIADIEMGS}", hoso07.getFiLocationOfMonitor() == null ? space : hoso07.getFiLocationOfMonitor()));

        variables.addTextVariable(new TextVariable("#{THOIGIANGS}", (hoso07.getFiDateOfMonitorFrom() != null ?
                "từ " + sdf.format(hoso07.getFiDateOfMonitorFrom()) : "") +
                (hoso07.getFiDateOfMonitorTo() != null ? " đến " + sdf.format(hoso07.getFiDateOfMonitorTo()) : "")));

        variables.addTextVariable(new TextVariable("#{SOVANBANCANCAP}", hoso07.getFiQuantityLicense().toString()));

        variables.addTextVariable(new TextVariable("#{THOIGIANDANHBAT}", (hoso07.getFiDateOfCatchFrom() != null ?
                "từ " + sdf.format(hoso07.getFiDateOfCatchFrom()) : "") + (hoso07.getFiDateOfCatchTo() != null ?
                " đến " + sdf.format(hoso07.getFiDateOfCatchTo()) : "")
        ));

        variables.addTextVariable(new TextVariable("#{TENTAU}", hoso07.getFiNameOfFishingShip() == null ? space : hoso07.getFiNameOfFishingShip()));
        variables.addTextVariable(new TextVariable("#{QUOCTICHTAU}", hoso07.getFiOriginationOfFishingShip() == null ? space : hoso07.getFiOriginationOfFishingShip()));
        variables.addTextVariable(new TextVariable("#{SOHIEUTAU}", hoso07.getFiCodeOfFishingShip() == null ? space : hoso07.getFiCodeOfFishingShip()));
        variables.addTextVariable(new TextVariable("#{KHUVUCDANHBAT}", hoso07.getFiLocationOfCatch() == null ? space : hoso07.getFiLocationOfCatch()));
        variables.addTextVariable(new TextVariable("#{PHUONGPHAPDANHBAT}", hoso07.getFiMethodCatch() == null ? space : hoso07.getFiMethodCatch()));
        variables.addTextVariable(new TextVariable("#{HOTEN}", hoso07.getFiSignName()));
        variables.addTextVariable(new TextVariable("#{CHUCVU}", hoso07.getFiSignPosition()));

        if (hoso07.getFiRegistrationConfirm() != null) {
            variables.addTextVariable(new TextVariable("#{fiCheckPlace}", hoso07.getFiRegistrationConfirm().getFiCheckPlace() == null ? largeSpace : hoso07.getFiRegistrationConfirm().getFiCheckPlace()));

            if (hoso07.getFiRegistrationConfirm().getFiCheckTimeFrom() != null) {

                Date date = sdf2.parse(hoso07.getFiRegistrationConfirm().getFiCheckTimeFrom());
                variables.addTextVariable(new TextVariable("#{fiGio}", date.getHours() + ""));
                variables.addTextVariable(new TextVariable("#{fiNgay}", String.format("ngày %02d tháng %02d năm %d",
                        date.getDate(),
                        date.getMonth() + 1,
                        date.getYear() + 1900)));
            } else {
                variables.addTextVariable(new TextVariable("#{fiGio}", space));
                variables.addTextVariable(new TextVariable("#{fiNgay}", space));
            }
            Date date = new Date(Long.parseLong(hoso07.getFiRegistrationConfirm().getFiCreatedDate()));
            variables.addTextVariable(new TextVariable("#{fiSo}", hoso07.getFiRegistrationConfirm().getFiRegistrationComfirmNo() == null ? space : hoso07.getFiRegistrationConfirm().getFiRegistrationComfirmNo()));
            variables.addTextVariable(new TextVariable("#{fiNgayVaoSo}", String.format("ngày %02d tháng %02d năm %d",
                    date.getDate(),
                    date.getMonth() + 1,
                    date.getYear() + 1900)));
            variables.addTextVariable(new TextVariable("#{fiCoQuanKiemDich}", hoso07.getFiRegistrationConfirm().getFiCreaterName() == null ? space : hoso07.getFiRegistrationConfirm().getFiCreaterName()));
        } else {
            variables.addTextVariable(new TextVariable("#{fiCheckPlace}", largeSpace));
            variables.addTextVariable(new TextVariable("#{fiGio}", "......giờ"));
            variables.addTextVariable(new TextVariable("#{fiNgay}", "ngày.....tháng.....năm....."));
            variables.addTextVariable(new TextVariable("#{fiSo}", "......."));
            variables.addTextVariable(new TextVariable("#{fiNgayVaoSo}", "ngày.....tháng.....năm....."));
            variables.addTextVariable(new TextVariable("#{fiCoQuanKiemDich}", ""));
        }


        return variables;
    }

}
