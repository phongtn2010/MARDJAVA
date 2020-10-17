package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard06Constant;
import com.nsw.mard.helper.Mard06Helper;
import com.nsw.mard.p6.model.*;
import com.nsw.mard.service.DinhkemService;
import com.nsw.util.Constants;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mard/06")
public class Mard06Api extends BaseApi {
    static final String TAG = "mard06Api";
    @Autowired
    DinhkemService attachmentService;

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.COUNTRY_GET));
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
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.PROVINCE_GET));
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

    @RequestMapping(value = "/danhmuc/cuakhau", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getPort(
            @RequestParam(name = "countryCode", required = false) String countryCode
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.PORT_GET) + "?countryCode=" + countryCode);
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

    @RequestMapping(value = "/danhmuc/unit", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getUOMs(
            @RequestParam(name = "unitTypeId", required = true) String unitTypeId,
            @RequestParam(name = "systemId", required = true) String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.UOMS_GET) + "?unitTypeId=" + unitTypeId + "&systemId=" + systemId);
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
    ResponseJson getListStatusHoso(
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LIST_STATUS_HOSO_GET) + "?systemId=" + systemId);
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

    @RequestMapping(value = "/danhmuc/dinhkem", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getAttachmentType(
            @RequestParam(name = "systemId") String systemId
    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ATTACHMENT_TYPE_GET) + "?systemId=" + systemId);
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
            @RequestBody TbdHoso06 tbdhoso06
    ) {
        return save(tbdhoso06);
    }

    @RequestMapping(value = "/hdsd", method = RequestMethod.GET)
    public void getHDSD(
            HttpServletResponse response,
            HttpServletRequest request
    ){
        try {
            String templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/hdsd.docx");
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
            @RequestBody TbdHoso06 tbdhoso06
    ) {
        ResponseJson returnJson = new ResponseJson();
        returnJson.setSuccess(false);
        try {
            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard06Constant.EnableSign))) {
                returnJson = send(tbdhoso06);
            } else {
                tbdhoso06.setFiTaxCode(getUsername());
                tbdhoso06.setFiSignDate(new Date());
                ResponseJson tmpJson = save(tbdhoso06);
                if(tmpJson.isSuccess() == false) {
                    return tmpJson;
                }
                HashMap<String, Object> tmpData = (HashMap<String, Object>) tmpJson.getData();
                returnJson = getHoSoByID(tmpData.get("fiIdHS").toString());
                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    Long fiTrangthai = Long.valueOf(data.get("fiHSStatus").toString());
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiNSWFileCode").toString());
                    sendMessage.setType(Mard06Constant.TYPE.TYPE_10);

                    if (fiTrangthai.equals(Mard06Constant.HosoStatus.TAO_MOI)) {
                        sendMessage.setFunction(Mard06Constant.FUNCTION.FUNCTION_01);
                    } else if (fiTrangthai.equals(Mard06Constant.HosoStatus.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(Mard06Constant.FUNCTION.FUNCTION_02);
                    } else if (fiTrangthai.equals(Mard06Constant.HosoStatus.YEU_CAU_BO_SUNG)) {
                        sendMessage.setFunction(Mard06Constant.FUNCTION.FUNCTION_03);
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

    @RequestMapping(value = "/hoso/rollback", method = RequestMethod.GET)
    private @ResponseBody ResponseJson rollbackHoso(@RequestParam("nswFileCode") String nswFileCode) {
        ResponseJson rs = new ResponseJson();
        if (!isOwner(null, nswFileCode)) {
            rs.setSuccess(false);
            return rs;
        }
        try {
            rs = BackendRequestHelper.getInstance()
                    .doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ROLL_BACK) + "?nswFileCode=" + nswFileCode);
            return rs;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            rs.setData(null);
            rs.setSuccess(false);
            rs.setMessage(ex.getMessage());
            return rs;
        }
    }

    private SignData getXMLForSign(SendMessage sendMessage) throws Exception {
        ResponseJson resultSignFlow = BackendRequestHelper.getInstance()
                .doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.GET_XML), sendMessage);

        if (resultSignFlow.isSuccess()) {
            SignData signData = new SignData();
            signData.setFiDocumentCode(sendMessage.getFiNSWFileCode());
            signData.setFiDocType("BNNPTNT0600009");
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

    @RequestMapping(value = "/hoso/edit", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody TbdHoso06 tbdhoso06
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {

            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard06Constant.EnableSign))) {
                tbdhoso06.setFiSignDate(new Date());
                tbdhoso06.setFiTaxCode(getUsername());
                return BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_EDIT), tbdhoso06);
            } else {
                returnJson = saveBeforeUpdate(tbdhoso06);

                if (returnJson.isSuccess() && returnJson.getData() != null) {
                    HashMap<String, Object> data = (HashMap<String, Object>) returnJson.getData();
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setFiNSWFileCode(data.get("fiNSWFileCode").toString());
                    sendMessage.setType(Mard06Constant.TYPE.TYPE_15);
                    sendMessage.setFunction(Mard06Constant.FUNCTION.FUNCTION_11);
                    sendMessage.setFiReason(tbdhoso06.getFiReason());

                    SignData signData = getXMLForSign(sendMessage);
                    returnJson.setSign(signData);
                }

                returnJson.setData(tbdhoso06);

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

    private ResponseJson saveBeforeUpdate(TbdHoso06 tbdHoso06) {
        try {
            tbdHoso06.setFiSignDate(new Date());
            tbdHoso06.setFiTaxCode(getUsername());

            return BackendRequestHelper.getInstance()
                    .doPostRequest(
                            Mard06Constant.getInstance()
                                    .getApiUrl(environment, Mard06Constant.API.SAVE_BEFORE_UPDATE),
                            tbdHoso06);
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

    @RequestMapping(value = "/hoso/guiycs", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiYeucauSuaHosoDaKy(
            @RequestBody TbdHoso06 tbdHoso06
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            tbdHoso06.setFiSignDate(new Date());
            tbdHoso06.setFiTaxCode(getUsername());
            return BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.UPDATE_ONLY), tbdHoso06);
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
        if (!isOwner(null, fiNSWFileCode)) {
            returnJson.setSuccess(false);
            returnJson.setMessage("Không có quyền truy cập hồ sơ");
            return returnJson;
        }
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_DELETE) + "?fiNSWFileCode=" + fiNSWFileCode + "&fiTaxCode=" + fiTaxCode);
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

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setFiCompanyTaxCode(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER), filter);
        return json;
    }

    @RequestMapping(value = "/hoso/find", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByID(
            @RequestParam(name = "idHoSo") String idHoSo
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(idHoSo, null)) {
                json.setSuccess(false);
                json.setMessage("Không có quyền truy cập hồ sơ");
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
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

    @RequestMapping(value = "/hoso/cancel", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson requestCancelHoso(
            @RequestBody TbdYcrut06 tbdhoso06
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            if (!isOwner(tbdhoso06.getFiIdHS().toString(), tbdhoso06.getFiNSWFileCode())) {
                returnJson.setSuccess(false);
                returnJson.setMessage("Không có quyền truy cập hồ sơ");
                return returnJson;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_CANCEL), tbdhoso06);
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
            return attachmentService.uploadFile(file, fiMaLoai, "BNNPTNT0600009");

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
            String restUri = Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ATTACHMENT_DOWNLOAD) + "/" + fiGuid;
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

    @RequestMapping(value = "/dinhkem/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseJson deleteAttachment(
            @RequestParam(value = "fiGuid") String fiGuid
    ) {
        ResponseJson returnJson = new ResponseJson();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doCustomRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.ATTACHMENT_DELETE) + "?fiGuid=" + fiGuid, HttpMethod.DELETE, new Object(), new HashMap<>());
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

    @RequestMapping(value = "/giayphep/view", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getLicense(
            @RequestParam(value = "code") String code,
            @RequestParam(value = "type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            if (!isOwner(null, code)) {
                json.setSuccess(false);
                json.setMessage("Không có quyền truy cập hồ sơ");
                return json;
            }
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LICENSE_VIEW_GET) + "?code=" + code + "&type=" + type);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HISTORY_BY_HS_CODE) + "?fiHSCode=" + fiHSCode + "&p=" + p + "&s=" + s);
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

    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson readDataFromExcel(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type
    ) {
        ResponseJson json = new ResponseJson();
        try {
            switch (type) {
                case "animal":
                    List<TbdHanghoa06> listAnimal = Mard06Helper.readAnimalFromExcel(file.getInputStream());
                    json.setSuccess(true);
                    json.setData(listAnimal);
                    break;
                case "product":
                    List<TbdHanghoa06> listProduct = Mard06Helper.readProductFromExcel(file.getInputStream());
                    json.setSuccess(true);
                    json.setData(listProduct);
                    break;
                case "exporter":
                    List<TbdCtyxk06> listExporter = Mard06Helper.readExporterFromExcel(file.getInputStream());
                    json.setSuccess(true);
                    json.setData(listExporter);
                    break;
                case "processing":
                    List<TbdCssx06> listProcessing = Mard06Helper.readProcessingFromExcel(file.getInputStream());
                    json.setSuccess(true);
                    json.setData(listProcessing);
                    break;
                case "quaratine":
                    List<TbdDdclkd06> listQuaratine = Mard06Helper.readQuaratineFromExcel(file.getInputStream());
                    json.setSuccess(true);
                    json.setData(listQuaratine);
                    break;
            }
            return json;
        } catch (IOException ex) {
            LogUtil.addLog(ex);
            json.setData(null);
            json.setSuccess(false);
            json.setMessage("File excel tải lên không đúng định dạng");
            return json;
        } catch (ParseException e) {
            if (e.getErrorOffset() == 0) {
                json.setData(null);
                json.setSuccess(false);
                json.setMessage(e.getMessage());
                return json;
            } else {
                json.setData(null);
                json.setSuccess(false);
                json.setMessage("File excel tải lên không đúng định dạng");
                return json;
            }
        } catch (InvalidFormatException e) {
            LogUtil.addLog(e);
            json.setData(null);
            json.setSuccess(false);
            json.setMessage("File excel tải lên không đúng định dạng");
            return json;
        }
    }

    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public void getTemplateExcelFile(
            @RequestParam("type") String type,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            String templatePath = null;
            String fileName = null;
            switch (type) {
                case "animal":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_hanghoa.xlsx");
                    fileName = "mard_06_dv.xlsx";
                    break;
                case "product":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_hanghoa.xlsx");
                    fileName = "mard_06_spdv.xlsx";
                    break;
                case "exporter":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_ctxk.xlsx");
                    fileName = "mard_06_ctxk.xlsx";
                    break;
                case "processing":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_cssx.xlsx");
                    fileName = "mard_06_cssx.xlsx";
                    break;
                case "location_quarantine":
                    templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/06/mard_06_ddclkd.xlsx");
                    fileName = "mard_06_ddclkd.xlsx";
                    break;
            }
            if (templatePath != null && !templatePath.isEmpty()) {
                File tempFile = new File(templatePath);
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
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

    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiHoso(
            @RequestBody TbdHoso06 tbdhoso06
    ) {
        return send(tbdhoso06);
    }

    @RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson verify(@RequestBody TokenInfo token) {
        token.setUser(this.getUsername());
        ResponseJson responseJson = new ResponseJson();
//
        responseJson.setSuccess(true);
        return responseJson;
//        return this.verifySignature(token);
    }

    private ResponseJson save(TbdHoso06 tbdhoso06) {
        ResponseJson returnJson = new ResponseJson();
        tbdhoso06.setFiTaxCode(getUsername());
        tbdhoso06.setFiSignDate(new Date());
        try {
            returnJson = BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_CREATE), tbdhoso06);
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

    private ResponseJson send(TbdHoso06 tbdHoso06) {
        ResponseJson returnJson = new ResponseJson();
        tbdHoso06.setFiTaxCode(getUsername());
        tbdHoso06.setFiSignDate(new Date());
        try {
            return BackendRequestHelper.getInstance().doPostRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_SEND), tbdHoso06);
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

    @RequestMapping(value = {"hoso/download/{mau}/{idHoSo}"}, method = RequestMethod.GET)
    public void getMauDon(
            @PathVariable("mau") String mau,
            @PathVariable("idHoSo") String idHoSo,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            if (!isOwner(idHoSo, null)) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            TbdHoso06 hoso = GsonUtils.getInstance().transform(json.getData(), TbdHoso06.class);

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-hoso-mard-06.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            variables = genMau02(hoso);
            templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_02.docx");
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
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }

    @RequestMapping(path = "gcn/download/{mau}/{fiNSWFileCode}", method = RequestMethod.GET)
    public void getGCN(
            @PathVariable String mau,
            @PathVariable String fiNSWFileCode,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            if (!isOwner(null, fiNSWFileCode)) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard06Constant.getInstance().getApiUrl(environment, Mard06Constant.API.LICENSE_VIEW_GET) + "?code=" + fiNSWFileCode + "&type=" + mau);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            TbdCongvan06 congvan06 = GsonUtils.getInstance().transform(json.getData(), TbdCongvan06.class);

            String templatePath = null;
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
//            String tempFoleder = "/Users/hung/blameo/LOGS";
            String fileName = new Date().getTime() + "-vsty-06.docx";
            File tempFile;
            Docx docx;
            // preparing variables
            Variables variables = null;

            switch (mau) {
                case "kdnk":
                    variables = genCongvan(congvan06);
                    if (congvan06.getFiProductType() == 1) {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_kdnk.docx");
                    } else {
                        templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_kdnk_spdv.docx");
                    }
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = congvan06.getFiDispatchNo() + "-kdnk.docx";
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getOutputStream().write(loadFile(tempFile));
                    break;
                case "vsty":
                    variables = genCongvan(congvan06);
                    templatePath = request.getRealPath("/WEB-INF/downloads/mard/06/mau_vsty.docx");
                    tempFile = new File(tempFoleder + fileName);
                    docx = new Docx(templatePath);
                    docx.setVariablePattern(new VariablePattern("#{", "}"));
                    docx.fillTemplate(variables);
                    // save filled .docx file
                    docx.save(tempFile.getPath());
                    fileName = congvan06.getFiDispatchNo() + "-vsty.docx";
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getOutputStream().write(loadFile(tempFile));
                    break;
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            return;
        }
    }

    private Variables genMau02(TbdHoso06 hoso) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiNSWFileCode}", hoso.getFiNSWFileCode() == null ?
                "" : hoso.getFiNSWFileCode()));
        variables.addTextVariable(new TextVariable("#{fiImporterName}", hoso.getFiImporterName() == null ?
                "" : hoso.getFiImporterName()));
        variables.addTextVariable(new TextVariable("#{fiImporterAddress}", hoso.getFiImporterAddress() == null ?
                "" : hoso.getFiImporterAddress()));
        variables.addTextVariable(new TextVariable("#{fiImporterTel}", hoso.getFiImporterTel() == null ?
                "" : hoso.getFiImporterTel()));
        variables.addTextVariable(new TextVariable("#{fiImporterFax}", hoso.getFiImporterFax() == null ?
                "" : hoso.getFiImporterFax()));
        variables.addTextVariable(new TextVariable("#{fiImporterEmail}", hoso.getFiImporterEmail() == null ?
                "" : hoso.getFiImporterEmail()));
        variables.addTextVariable(new TextVariable("#{fiBordergateName}", hoso.getFiBordergateName() == null ?
                "" : hoso.getFiBordergateName()));
        variables.addTextVariable(new TextVariable("#{fiTimeQuarantine}", hoso.getFiTimeQuarantine() == null ?
                "" : hoso.getFiTimeQuarantine()));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", hoso.getFiPurpose() == null ?
                "" : hoso.getFiPurpose()));
        variables.addTextVariable(new TextVariable("#{fiRelatedDocuments}", hoso.getFiRelatedDocuments() == null ?
                "" : hoso.getFiRelatedDocuments()));
        variables.addTextVariable(new TextVariable("#{fiSignPosition}", hoso.getFiSignPosition() == null ?
                "" : hoso.getFiSignPosition().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiSignName}", hoso.getFiSignName() == null ?
                "" : hoso.getFiSignName()));
        variables.addTextVariable(new TextVariable("#{fiSignAddress}", hoso.getFiSignAddress() == null ?
                "" : hoso.getFiSignAddress()));
        variables.addTextVariable(new TextVariable("#{fiSignDate}", String.format("ngày %02d tháng %02d năm %d",
                hoso.getFiSignDate().getDate(),
                hoso.getFiSignDate().getMonth() + 1, 1900 + hoso.getFiSignDate().getYear())));

        // add list product
        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiProductBusinessNameVars = new ArrayList<>();
        List<Variable> fiProductScienceNameVar = new ArrayList<>();
        List<Variable> fiSizeOrTypeVar = new ArrayList<>();
        List<Variable> fiQuantityVar = new ArrayList<>();
        List<Variable> fiPackageUnitNameVar = new ArrayList<>();
        List<Variable> fiOriginCountryNameVar = new ArrayList<>();

        if (!hoso.getFiProductList().isEmpty()) {
            int index = 0;
            for (TbdHanghoa06 hanghoa06 : hoso.getFiProductList()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiProductBusinessNameVars.add(new TextVariable("#{fiProductBusinessName}",
                        hanghoa06.getFiProductBusinessName() == null ? "" : hanghoa06.getFiProductBusinessName()));
                fiProductScienceNameVar.add(new TextVariable("#{fiProductScienceName}",
                        hanghoa06.getFiProductScienceName() == null ? "" : hanghoa06.getFiProductScienceName()));
                fiSizeOrTypeVar.add(new TextVariable("#{fiSizeOrType}",
                        hanghoa06.getFiSizeOrType() == null ? "" : hanghoa06.getFiSizeOrType()));
                fiQuantityVar.add(new TextVariable("#{fiQuantity}",
                        hanghoa06.getFiQuantity() == null ? "" :
                                nf.format(hanghoa06.getFiQuantity())));
                fiPackageUnitNameVar.add(new TextVariable("#{fiPackageUnitName}",
                        hanghoa06.getFiPackageUnitName() == null ? "" : hanghoa06.getFiPackageUnitName()));
                fiOriginCountryNameVar.add(new TextVariable("#{fiOriginCountryName}",
                        hanghoa06.getFiOriginCountryName() == null ? "" : hanghoa06.getFiOriginCountryName()));
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiProductBusinessNameVars);
        productTableVariable.addVariable(fiProductScienceNameVar);
        productTableVariable.addVariable(fiSizeOrTypeVar);
        productTableVariable.addVariable(fiQuantityVar);
        productTableVariable.addVariable(fiPackageUnitNameVar);
        productTableVariable.addVariable(fiOriginCountryNameVar);
        variables.addTableVariable(productTableVariable);

        // add list exporter
        String exporterList = "";
        if (!hoso.getFiExporterCountryList().isEmpty()) {
            for(TbdCtyxk06 ctyxk06 : hoso.getFiExporterCountryList()) {
                exporterList += ctyxk06.getFiExporterCountryName() + " (" + ctyxk06.getFiExporterCountryAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiExporterList}", exporterList));

        // add list processing
        String processingList = "";
        String processingApproveNumnerList = "";
        if (!hoso.getFiProcessingList().isEmpty()) {
            for (TbdCssx06 cssx06 : hoso.getFiProcessingList()) {
                processingList += cssx06.getFiProcessingName() + " - " + cssx06.getFiProcessingAddress()
                         + (cssx06.getFiProcessingApprovalNumber() == null ? "" :
                        " (" + cssx06.getFiProcessingApprovalNumber() + ")") + "; ";
                processingApproveNumnerList += cssx06.getFiProcessingApprovalNumber() == null ?
                        "" : cssx06.getFiProcessingApprovalNumber() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiProcessingList}", processingList));
        variables.addTextVariable(new TextVariable("#{fiProcessingApproveNumberList}", processingApproveNumnerList));

        // add list quarantine
        String quarantineList = "";
        if (!hoso.getFiLocationQuarantineList().isEmpty()) {
            for (TbdDdclkd06 ddclkd06: hoso.getFiLocationQuarantineList()) {
                quarantineList += ddclkd06.getFiLocationQuarantineName() + " (" +
                        ddclkd06.getFiLocationQuarantineAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiLocationQuarantineList}", quarantineList));

        return variables;
    }

    private boolean isOwner(String idHS, String nswFileCode) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(
                Mard06Constant.getInstance().getApiUrl(
                        environment,
                        Mard06Constant.API.HOSO_GET_BY_FILTER
                ) + "?id=" +
                        (StringUtils.isEmpty(idHS)? "" : idHS) + "&nswFileCode=" +
                        (StringUtils.isEmpty(nswFileCode)? "" : nswFileCode) + "&taxCode=" + getUsername());

        return json != null && json.getData() != null;
    }

    private Variables genCongvan(TbdCongvan06 congvan06) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(6);
        nf.setGroupingUsed(false);
        Variables variables = new Variables();

        variables.addTextVariable(new TextVariable("#{fiCompanyName}", this.getUser().getCompanyName() != null ?
                this.getUser().getCompanyName() : ""));
        variables.addTextVariable(new TextVariable("#{fiDispatchNo}", congvan06.getFiDispatchNo() != null ?
                congvan06.getFiDispatchNo() : ""));
        variables.addTextVariable(new TextVariable("#{fiSummary}", congvan06.getFiSummary() != null ?
                congvan06.getFiSummary() : ""));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", congvan06.getFiSignConfirmAddress() != null ?
                congvan06.getFiSignConfirmAddress() : ""));
        variables.addTextVariable(new TextVariable("#{fiDispatchDate}", String.format("ngày %02d tháng %02d năm %d",
                congvan06.getFiDispatchDate().getDate(),
                congvan06.getFiDispatchDate().getMonth() + 1, 1900 + congvan06.getFiDispatchDate().getYear())));
        variables.addTextVariable(new TextVariable("#{fiPreamble}", congvan06.getFiPreamble() != null ?
                congvan06.getFiPreamble() : ""));
        variables.addTextVariable(new TextVariable("#{fiBordergateName}", congvan06.getFiBordergateName() != null ?
                congvan06.getFiBordergateName() : ""));
        variables.addTextVariable(new TextVariable("#{fiTimeQuarantine}", congvan06.getFiTimeQuarantine() != null ?
                congvan06.getFiTimeQuarantine() : ""));
        variables.addTextVariable(new TextVariable("#{fiPurpose}", congvan06.getFiPurpose() != null ?
                congvan06.getFiPurpose() : ""));
        variables.addTextVariable(new TextVariable("#{fiResponseContent}", congvan06.getFiResponseContent() != null ?
                congvan06.getFiResponseContent() : ""));
        if (congvan06.getFiRecipient() != null) {
            String splitRecipient[] = congvan06.getFiRecipient().split(",");
            String fiRecipient = "";
            for (int i = 0; i < splitRecipient.length; i++) {
                fiRecipient += "- " + splitRecipient[i].trim() + ";\n";
            }
            variables.addTextVariable(new TextVariable("#{fiRecipient}", fiRecipient));
        } else {
            variables.addTextVariable(new TextVariable("#{fiRecipient}", ""));
        }

        String signConfirmTitle = "";
        String signConfirmName = "";
        if (congvan06.getFiSignPosition() != null) {
            if ("cục trưởng".equalsIgnoreCase(congvan06.getFiSignPosition().trim())) {
                signConfirmTitle = congvan06.getFiSignPosition().toUpperCase();
                signConfirmName = congvan06.getFiSignConfirmName();
            } else {
                signConfirmTitle += "KT.CỤC TRƯỞNG\n" + congvan06.getFiSignPosition().toUpperCase();
                signConfirmName += "Đã ký\n" + congvan06.getFiSignConfirmName();
            }
        } else {
            signConfirmTitle += "KT.CỤC TRƯỞNG\n";
            signConfirmName += "Đã ký\n" + (congvan06.getFiSignConfirmName() != null ?
                    congvan06.getFiSignConfirmName() : "");
        }
        variables.addTextVariable(new TextVariable("#{fiSignPosition}", signConfirmTitle));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", signConfirmName));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> sttVars = new ArrayList<>();
        List<Variable> fiProductBusinessNameVars = new ArrayList<>();
        List<Variable> fiProductScienceNameVars = new ArrayList<>();
        List<Variable> fiSizeOrTypeVars = new ArrayList<>();
        List<Variable> fiQuantityVars = new ArrayList<>();
        List<Variable> fiCountryOriginVars = new ArrayList<>();
        List<Variable> fiBordergateNameVars = new ArrayList<>();
        List<Variable> fiPackageUnitNameVars = new ArrayList<>();

        String fiCountryOriginList = "";
        if (!congvan06.getFiProductList().isEmpty()) {
            int index = 0;
            for (TbdHanghoa06 hanghoa06: congvan06.getFiProductList()) {
                index++;
                sttVars.add(new TextVariable("#{stt}", Integer.toString(index)));
                fiProductBusinessNameVars.add(new TextVariable("#{fiProductBusinessName}",
                        hanghoa06.getFiProductBusinessName() == null ? "" : hanghoa06.getFiProductBusinessName()));
                fiProductScienceNameVars.add(new TextVariable("#{fiProductScienceName}",
                        hanghoa06.getFiProductScienceName() == null ? "" : hanghoa06.getFiProductScienceName()));
                fiSizeOrTypeVars.add(new TextVariable("#{fiSizeOrType}",
                        hanghoa06.getFiSizeOrType() == null ? "" : hanghoa06.getFiSizeOrType()));
                fiQuantityVars.add(new TextVariable("#{fiQuantity}",
                        hanghoa06.getFiQuantity() == null ? "" :
                                nf.format(hanghoa06.getFiQuantity())));
                fiPackageUnitNameVars.add(new TextVariable("#{fiPackageUnitName}",
                        hanghoa06.getFiPackageUnitName() == null ? "" : hanghoa06.getFiPackageUnitName()));
                fiCountryOriginVars.add(new TextVariable("#{fiOriginCountryName}",
                        hanghoa06.getFiOriginCountryName() == null ? "" : hanghoa06.getFiOriginCountryName()));
                fiBordergateNameVars.add(new TextVariable("#{fiBordergate}",
                        congvan06.getFiBordergateName() == null ? "" : congvan06.getFiBordergateName()));
                fiCountryOriginList += hanghoa06.getFiOriginCountryName() + "; ";
            }
        }
        productTableVariable.addVariable(sttVars);
        productTableVariable.addVariable(fiProductBusinessNameVars);
        productTableVariable.addVariable(fiProductScienceNameVars);
        productTableVariable.addVariable(fiSizeOrTypeVars);
        productTableVariable.addVariable(fiQuantityVars);
        productTableVariable.addVariable(fiPackageUnitNameVars);
        productTableVariable.addVariable(fiCountryOriginVars);
        productTableVariable.addVariable(fiBordergateNameVars);
        variables.addTableVariable(productTableVariable);
        variables.addTextVariable(new TextVariable("#{fiCountryOriginList}", fiCountryOriginList));

        // add list exporter
        String exporterList = "";
        if (!congvan06.getFiExporterCountryList().isEmpty()) {
            for(TbdCtyxk06 ctyxk06 : congvan06.getFiExporterCountryList()) {
                exporterList += ctyxk06.getFiExporterCountryName() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiExporterList}", exporterList));

        // add list processing
        String processingList = "";
        String processingApproveNumnerList = "";
        if (!congvan06.getFiProcessingList().isEmpty()) {
            for (TbdCssx06 cssx06 : congvan06.getFiProcessingList()) {
                processingList += cssx06.getFiProcessingName() + "; ";
                processingApproveNumnerList += cssx06.getFiProcessingApprovalNumber() == null ?
                        "" : cssx06.getFiProcessingApprovalNumber() + "; ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiProcessingList}", processingList));
        variables.addTextVariable(new TextVariable("#{fiProcessingApproveNumberList}", processingApproveNumnerList));

        // add list quarantine
        String quarantineList = "";
        if (!congvan06.getFiLocationQuarantineList().isEmpty()) {
            for (TbdDdclkd06 ddclkd06: congvan06.getFiLocationQuarantineList()) {
                quarantineList += ddclkd06.getFiLocationQuarantineName() + " (" +
                        ddclkd06.getFiLocationQuarantineAddress() + "); ";
            }
        }
        variables.addTextVariable(new TextVariable("#{fiLocationQuarantineList}", quarantineList));

        return variables;
    }
}
