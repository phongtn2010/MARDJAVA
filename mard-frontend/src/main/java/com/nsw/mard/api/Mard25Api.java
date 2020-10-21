package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard06Constant;
import com.nsw.mard.constant.Mard25Constant;
import com.nsw.mard.constant.Mard25Constant;
import com.nsw.mard.p25.model.FilterForm;
import com.nsw.mard.p25.model.TbdHoso25;
import com.nsw.mard.p6.model.SendMessage;
import com.nsw.mard.service.DinhkemService;
import com.nsw.util.Constants;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/mard/25")
public class Mard25Api extends BaseApi {
    static final String TAG = "mard25Api";
    @Autowired
    DinhkemService attachmentService;

    @RequestMapping(value = "/danhmuc/quocgia", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.COUNTRY_GET));
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
            responseJson = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.PROVINCE_GET));
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.PORT_GET) + "?countryCode=" + countryCode);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.UOMS_GET) + "?unitTypeId=" + unitTypeId + "&systemId=" + systemId);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.LIST_STATUS_HOSO_GET) + "?systemId=" + systemId);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.ATTACHMENT_TYPE_GET) + "?systemId=" + systemId);
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

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setFiCompanyTaxCode(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.HOSO_GET_BY_FILTER), filter);
        return json;
    }

    @RequestMapping(value = "/danhmuc/getby-catno/{catNo}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getByCatNo(@PathVariable Long catNo) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.GET_BY_CAT_NO)+catNo);
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
            @RequestBody TbdHoso25 tbdhoso25
    ) {
        return save(tbdhoso25);
    }

    @RequestMapping(value = "/hdsd", method = RequestMethod.GET)
    public void getHDSD(
            HttpServletResponse response,
            HttpServletRequest request
    ){
        try {
            String templatePath = request.getSession().getServletContext().getRealPath("/WEB-INF/downloads/mard/25/hdsd.docx");
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

    private ResponseJson save(TbdHoso25 tbdhoso25) {
        ResponseJson returnJson = new ResponseJson();
        tbdhoso25.setFiTaxCode(getUsername());
        try {
            returnJson = BackendRequestHelper.getInstance().doPostRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.HOSO_CREATE), tbdhoso25);
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

    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiHoso(
            @RequestBody TbdHoso25 tbdhoso25
    ) {
        return send(tbdhoso25);
    }
    private ResponseJson send(TbdHoso25 tbdHoso25) {
        ResponseJson returnJson = new ResponseJson();
        tbdHoso25.setFiTaxCode(getUsername());
        try {
            return BackendRequestHelper.getInstance().doPostRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.HOSO_SEND), tbdHoso25);
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

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoso25 tbdHoso25
    ) {
        ResponseJson returnJson = new ResponseJson();
        returnJson.setSuccess(false);
        try {
            if (!Constants.SIGN.ON.equals(environment.getRequiredProperty(Mard25Constant.EnableSign))) {
                returnJson = send(tbdHoso25);
            } else {
                tbdHoso25.setFiTaxCode(getUsername());
                ResponseJson tmpJson = save(tbdHoso25);
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
                    sendMessage.setType(Mard25Constant.TYPE.TYPE_10);

                    if (fiTrangthai.equals(Mard25Constant.HosoStatus.TAO_MOI)) {
                        sendMessage.setFunction(Mard25Constant.FUNCTION.FUNCTION_01);
                    } else if (fiTrangthai.equals(Mard25Constant.HosoStatus.CHO_TIEP_NHAN)) {
                        sendMessage.setFunction(Mard25Constant.FUNCTION.FUNCTION_02);
                    } else if (fiTrangthai.equals(Mard25Constant.HosoStatus.YEU_CAU_BO_SUNG)) {
                        sendMessage.setFunction(Mard25Constant.FUNCTION.FUNCTION_03);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.HOSO_GET_BY_FILTER) + "?id=" + idHoSo);
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
    private SignData getXMLForSign(SendMessage sendMessage) throws Exception {
        ResponseJson resultSignFlow = BackendRequestHelper.getInstance()
                .doPostRequest(Mard25Constant.getInstance().getApiUrl(environment, Mard25Constant.API.GET_XML), sendMessage);

        if (resultSignFlow.isSuccess()) {
            SignData signData = new SignData();
            signData.setFiDocumentCode(sendMessage.getFiNSWFileCode());
            signData.setFiDocType("BNNPTNT2500009");
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
}
