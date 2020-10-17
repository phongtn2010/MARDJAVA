/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.TokhaiRequest;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.ExcelMapping;
import com.nsw.helper.ExcelReader;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.most.p03.model.*;
import com.nsw.most.constant.Most03Constant;
import com.nsw.util.Constants;
import com.nsw.util.FileNameUtils;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.BulletListVariable;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 *
 * @author QUANGNV18
 */
@RestController
@RequestMapping("/most/03")
public class Most03Api extends BaseApi {

    static final String TAG = "Most03Api";

    @Autowired
    Environment environment;

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;
        try {
            switch (key) {
                case "HS_STATUS":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_STATUS));
                    break;
                case "DM_MPTD":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_MAUPHUONGTIENDO));
                    break;
                case "DM_QUOCGIA":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, Most03Constant.API.DM_QUOCGIA));
                    break;
                case "DM_LOAIHOSO":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_LOAIHOSO));
                    break;
                case "DM_LOAIFILE":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_LOAIFILE));
                    break;
                case "DM_DVTHUNGHIEM":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.DM_DVTHUNGHIEM));
                    break;
                case "HS_LOAIPTDO":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_LOAIPHUONGTIENDO));
                    break;
                case "DM_DVHAIQUAN":
                    json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, AppConstant.API.NSW_API_DSHQ));
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
        return null;
    }

    @RequestMapping(value = "/hoso/search", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        filter.setNguoiTao(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEARCH), filter);
        return json;
    }

    @RequestMapping(value = {"/tokhai"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getToKhai(@RequestBody TokhaiRequest data) {
        data.setMst(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getBackendCommonApiUrl(environment, AppConstant.API.NSW_API_TOKHAI), data);
        return json;
    }

    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
            if (json != null && (LinkedHashMap) json.getData() != null) {
                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoitao"))) {
                    return null;
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody Tbdhoso3 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Kiểm tra dữ liệu đầu vào
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(Most03Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Most03Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_INSERT), tbdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody Tbdhoso3 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            tbdHoso.setFiNgaytao(new Date());
            json = BackendRequestHelper.getInstance().doCustomRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/delete/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
            return json;
        }
        HashMap map = new HashMap();
        json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_DELETE) + "/" + fiIdHoso, map);
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
            if (!isOwner(message.getFiIdHoso())) {
                return json;
            }
            message.setFunction(Most03Constant.MSG_FUNC.FUNC_18);
            message.setType(Most03Constant.MSG_TYPE.TYPE_11);
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangthai").toString());
                    if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.YC_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_SUA_HOSO)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_03);
                        message.setType(Most03Constant.MSG_TYPE.TYPE_12);
                    }
                }
            }
            
            ResponseJson result;
            result = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEND), message);
            json.setSuccess(result.getSuccess());
            json.setMessage(result.getMessage());

            if (result.isSuccess() 
                    && Constants.SIGN.ON.equals(message.getGetXmlNotSend())) {
                SignData signData = new SignData();
                signData.setFiDocType(Most03Constant.DocType);
                
                signData.setFiFunc(message.getFunction());
                signData.setFiMsgType(message.getType());
                
                String xml = result.getData().toString();
                String hashVal = Utility.GetHashData(xml);
                signData.setFiXml(xml);
                signData.setFiXmlEncode(encodeXmlMessage(xml));
                signData.setFiHash(hashVal);
                signData.setFiHashEncode(encodeXmlMessage("<DS>" + hashVal + "</DS>"));
        
                json.setSign(signData);
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/tt-giahan/", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getThongTinGiaHan(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_THONGTINGIAHAN);
            json = BackendRequestHelper.getInstance().doGetRequest(url + message.getFiIdHoso());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/yc-giahanbosung", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson xinGiaHanBoSungHoSo(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (!isOwner(message.getFiIdHoso())) {
                return json;
            }

            message.setFunction(Most03Constant.MSG_FUNC.FUNC_16);
            message.setType(Most03Constant.MSG_TYPE.TYPE_18);
            ResponseJson result = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEND), message);
            json.setSuccess(result.getSuccess());
            json.setMessage(result.getMessage());
            
            //Thiet lap cau hinh ky so
            if (result.isSuccess() 
                    && Constants.SIGN.ON.equals(message.getGetXmlNotSend())) {
                
                SignData signData = new SignData();
                signData.setFiDocType(Most03Constant.DocType);
                signData.setFiFunc(message.getFunction());
                signData.setFiMsgType(message.getType());
                
                String xml = result.getData().toString();
                String hashVal = Utility.GetHashData(xml);
                signData.setFiXml(xml);
                signData.setFiXmlEncode(encodeXmlMessage(xml));
                signData.setFiHash(hashVal);
                signData.setFiHashEncode(encodeXmlMessage("<DS>" + hashVal + "</DS>"));
        
                json.setSign(signData);
            }
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
            @RequestBody Tbdhoso3 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;

            if (fiIdHoso == 0L) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(Most03Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Most03Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_INSERT), tbdHoso);
            } else {
                json = BackendRequestHelper.getInstance().doCustomRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Most03Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_01);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_02);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.YC_BO_SUNG)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_05);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.YC_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_SUA_HOSO)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_04);
                        String reason = tbdHoso.getFiReasonSDBS();
                        message.setReason(reason);
                    }
                    //Thiet lap cau hinh ky so
                    if (Constants.SIGN.ON.equals(environment.getRequiredProperty(Most03Constant.EnableSign))) {
                        message.setGetXmlNotSend(Constants.SIGN.ON);
                    }

                    //Gui ho so || lay ban tin de DN thuc hien ky so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEND), message);
                    json.setSuccess(jsonResult.isSuccess());
                    json.setMessage(jsonResult.getMessage());
                    if (jsonResult.isSuccess()
                            && Constants.SIGN.ON.equals(environment.getRequiredProperty(Most03Constant.EnableSign))) {
                        SignData signData = new SignData();
                        signData.setFiDocumentCode(((LinkedHashMap) json.getData()).get("fiMaHoso").toString());
                        signData.setFiDocType(Most03Constant.DocType);
                        signData.setFiFunc(message.getFunction());
                        signData.setFiMsgType(message.getType());
                        String xml = jsonResult.getData().toString();
                        //String body = getMessageBody(xml);
                        String hashVal = Utility.GetHashData(xml);
                        signData.setFiXml(xml);
                        signData.setFiXmlEncode(encodeXmlMessage(xml));
                        signData.setFiHash(hashVal);
                        signData.setFiHashEncode(encodeXmlMessage("<DS>" + hashVal + "</DS>"));
                        json.setSign(signData);
                    }
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/send-doc", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson guiHoso(
            @RequestBody Tbdhoso3 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;
            json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID) + fiIdHoso);

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Most03Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_01);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_02);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.YC_BO_SUNG)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_05);
                    } else if (Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.YC_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_BO_SUNG)
                            || Objects.equals(fiTrangthai, Most03Constant.FILE_STATUS.DA_SUA_HOSO)) {
                        message.setFunction(Most03Constant.MSG_FUNC.FUNC_04);
                        String reason = tbdHoso.getFiReasonSDBS();
                        message.setReason(reason);
                    }

                    //Gui ho so 
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_SEND), message);
                    json.setSuccess(jsonResult.isSuccess());
                    json.setMessage(jsonResult.getMessage());
                }
            }
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
            @RequestBody HistoryFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (!isOwner(filterForm.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance().doPostRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_HISTORY), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/congvan", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson congVanHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_CONGVAN) + filterForm.getFiMaHoso());
        return json;
    }

    @RequestMapping(value = "/hoso/quyetdinh", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_QUYETDINH) + filterForm.getFiMaHoso());
        return json;
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson importExcel(@RequestParam("file") MultipartFile file) {
        ResponseJson json = new ResponseJson();
        try {
            String folederUpload = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);

            String fileName = FileNameUtils.toSafeFileName(file.getOriginalFilename(), 100);
            UUID uuid = UUID.randomUUID();
            String code = uuid.toString();
            String filePath = folederUpload + code + "." + FilenameUtils.getExtension(fileName);

            File uploadFile = new File(filePath);
            file.transferTo(uploadFile);

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ExcelMapping>>() {
            }.getType();
            List<ExcelMapping> response = gson.fromJson(Most03Constant.JSON_IMPORT, listType);
            FileInputStream excelFile = new FileInputStream(uploadFile);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Tbdhoso3 hoso = new Tbdhoso3();
            List<Tbdhanghoa3> lstHanghoa = new ArrayList<>();
            List<Tbdtokhaihq3> lstToKhai = new ArrayList<>();
            for (ExcelMapping em : response) {
                switch (em.getReader()) {
                    case "hoso":
                        hoso = ExcelReader.readRandom(workbook.getSheetAt(em.getSheetIndex()), hoso, em);
                        break;
                    case "hanghoa":
                        lstHanghoa = ExcelReader.readTable(workbook.getSheetAt(em.getSheetIndex()), Tbdhanghoa3.class, em);
                        break;
                    case "tokhai":
                        lstToKhai = ExcelReader.readTable(workbook.getSheetAt(em.getSheetIndex()), Tbdtokhaihq3.class, em);
                        break;
                    default:
                        break;
                }
            }

            hoso.setToKhaiHQs(lstToKhai);
            hoso.setHangHoas(lstHanghoa);
            hoso.setFiNgaytao(new Date());
            hoso.setFiHoatdong(0L);
            hoso.setFiTrangthai(0L);
            hoso.setFiNguoitao(getUsername());
            //Validate data
            //Return 
            json.setData(hoso);
            excelFile.close();
            json.setSuccess(true);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/bieumau/{fiIdHoso}", method = RequestMethod.GET)
    public void exportHoso(
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable("fiIdHoso") Long fiIdHoso) {
        try {
            if (fiIdHoso == null) {
                return;
            }
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_GETBYID) + fiIdHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }
            Tbdhoso3 hoso = GsonUtils.getInstance().transform(json.getData(), Tbdhoso3.class);
            // Kiểm tra xem có đc export lên cho hồ sơ này không?
            if (hoso == null || !getUsername().equals(hoso.getFiNguoitao())) {
                return;
            }
            String templatePath = request.getRealPath("/WEB-INF/downloads/most/bm_most_03.docx");
            String tempFoleder = environment.getRequiredProperty(AppConstant.Folder.TemSaveFolder);
            String fileName = new Date().getTime() + "-" + hoso.getFiMaHoso() + "-bm.docx";
            File tempFile = new File(tempFoleder + fileName);
            Docx docx = new Docx(templatePath);
            docx.setVariablePattern(new VariablePattern("#{", "}"));
            // preparing variables
            Variables variables = new Variables();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //DecimalFormat df = new DecimalFormat("#0.###");
            variables.addTextVariable(new TextVariable("#{ngay}", "" + hoso.getFiNgaytao().getDate()));
            variables.addTextVariable(new TextVariable("#{thang}", "" + (1 + hoso.getFiNgaytao().getMonth())));
            variables.addTextVariable(new TextVariable("#{nam}", "" + (1900 + hoso.getFiNgaytao().getYear())));

            String keyName = "";
            if (hoso.getFiLoaiHoso() != null) {
                if (hoso.getFiLoaiHoso().equals(Most03Constant.HOSO_TYPE.TYPE_1)) {
                    keyName = Most03Constant.HOSO_TYPE.TYPE_1_STR;
                } else {
                    keyName = Most03Constant.HOSO_TYPE.TYPE_2_STR;
                }
            }
            variables.addTextVariable(new TextVariable("#{fiLoaiHoso}", keyName));

            keyName = "";
//            if (hoso.getFiLoaiPtd() != null) {
//                if (hoso.getFiLoaiPtd().equals(Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_1)) {
//                    keyName = Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_1_STR;
//                } else {
//                    keyName = Most03Constant.PHUONG_TIEN_DO_TYPE.TYPE_2_STR;
//                }
//            }

            variables.addTextVariable(new TextVariable("#{fiMaHoso}", hoso.getFiMaHoso()));
            variables.addTextVariable(new TextVariable("#{fiLoaiPtd}", keyName));
            variables.addTextVariable(new TextVariable("#{fiTenCoso}", hoso.getFiTenCoso() == null ? "" : hoso.getFiTenCoso()));
            variables.addTextVariable(new TextVariable("#{fiMstDn}", hoso.getFiMstDn() == null ? "" : hoso.getFiMstDn()));
            variables.addTextVariable(new TextVariable("#{fiDiachiTsc}", hoso.getFiDiachiTsc() == null ? "" : hoso.getFiDiachiTsc()));
            variables.addTextVariable(new TextVariable("#{fiDiachiVpgg}", hoso.getFiDiachiVpgg() == null ? "" : hoso.getFiDiachiVpgg()));
            variables.addTextVariable(new TextVariable("#{fiSdt}", hoso.getFiSdt() == null ? "" : hoso.getFiSdt()));
            variables.addTextVariable(new TextVariable("#{fiFax}", hoso.getFiFax() == null ? "" : hoso.getFiFax()));
            variables.addTextVariable(new TextVariable("#{fiEmail}", hoso.getFiEmail() == null ? "" : hoso.getFiEmail()));
            variables.addTextVariable(new TextVariable("#{fiSoDkkd}", hoso.getFiSoDkkd() == null ? "" : hoso.getFiSoDkkd()));
            variables.addTextVariable(new TextVariable("#{fiNgaycap}", hoso.getFiNgaycap() == null ? "" : dateFormat.format(hoso.getFiNgaycap())));
            variables.addTextVariable(new TextVariable("#{fiCqCap}", hoso.getFiCqCap() == null ? "" : hoso.getFiCqCap()));
            variables.addTextVariable(new TextVariable("#{fiDnMienTnm}", hoso.getFiDnMienTnm() == null ? "" : hoso.getFiDnMienTnm()));
            variables.addTextVariable(new TextVariable("#{fiLydoDnMien}", hoso.getFiLydoDnMien() == null ? "" : hoso.getFiLydoDnMien()));
            variables.addTextVariable(new TextVariable("#{fiNguoiDaidien}", hoso.getFiNguoiDaidien() == null ? "" : hoso.getFiNguoiDaidien()));
            variables.addTextVariable(new TextVariable("#{fiChucvuNguoidaidien}", hoso.getFiChucvuNguoidaidien() == null ? "" : hoso.getFiChucvuNguoidaidien()));

            TableVariable toKhaiTableVariable = new TableVariable();
            List<Variable> sttColumnVariables = new ArrayList<Variable>();
            List<Variable> soTkColumnVariables = new ArrayList<Variable>();
            List<Variable> ngayDkColumnVariables = new ArrayList<Variable>();
            List<Variable> maHqColumnVariables = new ArrayList<Variable>();
            int i = 0;
            List<Tbdtokhaihq3> lstToKhai = hoso.getToKhaiHQs();
            if (lstToKhai == null || lstToKhai.isEmpty()) {
                sttColumnVariables.add(new TextVariable("#{stt}", ""));
                soTkColumnVariables.add(new TextVariable("#{fiSoTk}", ""));
                ngayDkColumnVariables.add(new TextVariable("#{fiNgayDk}", ""));
                maHqColumnVariables.add(new TextVariable("#{fiMaHq}", ""));
            } else {
                for (Tbdtokhaihq3 toKhai : lstToKhai) {
                    i++;
                    sttColumnVariables.add(new TextVariable("#{stt}", String.valueOf(i)));
                    soTkColumnVariables.add(new TextVariable("#{fiSoTk}", toKhai.getFiSoTk()));
                    ngayDkColumnVariables.add(new TextVariable("#{fiNgayDk}", dateFormat.format(toKhai.getFiNgayDk())));
                    maHqColumnVariables.add(new TextVariable("#{fiMaHq}", toKhai.getFiMaHq()));
                }
            }

            toKhaiTableVariable.addVariable(sttColumnVariables);
            toKhaiTableVariable.addVariable(soTkColumnVariables);
            toKhaiTableVariable.addVariable(ngayDkColumnVariables);
            toKhaiTableVariable.addVariable(maHqColumnVariables);
            variables.addTableVariable(toKhaiTableVariable);

            TableVariable hanghoaTableVariable = new TableVariable();
            i = 0;
            List<Variable> sttClmnVariables = new ArrayList<Variable>();
            List<Variable> tenHHColumnVariables = new ArrayList<Variable>();
            List<Variable> soTKColumnVariables = new ArrayList<Variable>();
            List<Variable> maHSColumnVariables = new ArrayList<Variable>();
            List<Variable> kieuColumnVariables = new ArrayList<Variable>();

            List<Variable> thongTinNSXVariables = new ArrayList<Variable>();
            List<Variable> dacTinhKTVariables = new ArrayList<Variable>();

            //List<Variable> soSXColumnVariables = new ArrayList<Variable>();
            List<Variable> ghiChuColumnVariables = new ArrayList<Variable>();

            List<Tbdhanghoa3> lstHanghoa = hoso.getHangHoas();
            List<Variable> thongTinNhaSX;
            List<Variable> thongTinDacTKT;
            //List<Variable> thongtinFileDinhKem = new ArrayList<Variable>();

            if (lstHanghoa == null || lstHanghoa.isEmpty()) {
                sttClmnVariables.add(new TextVariable("#{b.stt}", ""));
                tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", ""));
                soTKColumnVariables.add(new TextVariable("#{b.fiSotk}", ""));
                maHSColumnVariables.add(new TextVariable("#{b.fiMaHs}", ""));
                kieuColumnVariables.add(new TextVariable("#{b.fiKieu}", ""));

                thongTinNhaSX = new ArrayList<Variable>();
                thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", ""));
                thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", ""));
                thongTinNSXVariables.add(new BulletListVariable("#{b.thongTinNhaSX}", thongTinNhaSX));

                thongTinDacTKT = new ArrayList<Variable>();
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", ""));
                dacTinhKTVariables.add(new BulletListVariable("#{b.thongTinDacTinhKT}", thongTinDacTKT));

//                soSXColumnVariables.add(new TextVariable("#{b.fiSoSx}", ""));
                ghiChuColumnVariables.add(new TextVariable("#{b.fiGhiChu}", ""));
            } else {

                for (Tbdhanghoa3 hangHoa : lstHanghoa) {
                    i++;
                    sttClmnVariables.add(new TextVariable("#{b.stt}", String.valueOf(i)));
                    tenHHColumnVariables.add(new TextVariable("#{b.fiTenHh}", hangHoa.getFiTenHh() == null ? "" : hangHoa.getFiTenHh()));
                    soTKColumnVariables.add(new TextVariable("#{b.fiSotk}", hangHoa.getFiSotk() == null ? "" : hangHoa.getFiSotk()));
                    maHSColumnVariables.add(new TextVariable("#{b.fiMaHs}", hangHoa.getFiMaHs() == null ? "" : hangHoa.getFiMaHs()));
                    kieuColumnVariables.add(new TextVariable("#{b.fiKieu}", hangHoa.getFiKieu() == null ? "" : hangHoa.getFiKieu()));

                    thongTinNhaSX = new ArrayList<Variable>();
                    thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", hangHoa.getFiTenNsx() == null ? "" : hangHoa.getFiTenNsx()));
                    thongTinNhaSX.add(new TextVariable("#{b.thongTinNhaSX}", hangHoa.getFiTenQg() == null ? "" : hangHoa.getFiTenQg()));
                    thongTinNSXVariables.add(new BulletListVariable("#{b.thongTinNhaSX}", thongTinNhaSX));

                    thongTinDacTKT = new ArrayList<Variable>();
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiKyhieu() == null ? "" : "- " + hangHoa.getFiKyhieu()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiPhamvido() == null ? "" : "- " + hangHoa.getFiPhamvido()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiCapCx() == null ? "" : "- " + hangHoa.getFiCapCx()));
                    thongTinDacTKT.add(new TextVariable("#{b.thongTinDacTinhKT}", hangHoa.getFiDactinhKt() == null ? "" : "- " + hangHoa.getFiDactinhKt()));
                    dacTinhKTVariables.add(new BulletListVariable("#{b.thongTinDacTinhKT}", thongTinDacTKT));

                    //soSXColumnVariables.add(new TextVariable("#{b.fiSoSx}", hangHoa.getFiSoSx() == null ? "" : hangHoa.getFiSoSx()));
                    ghiChuColumnVariables.add(new TextVariable("#{b.fiGhiChu}", hangHoa.getFiGhiChu() == null ? "" : hangHoa.getFiGhiChu()));
                }
            }
            hanghoaTableVariable.addVariable(sttClmnVariables);
            hanghoaTableVariable.addVariable(tenHHColumnVariables);
            hanghoaTableVariable.addVariable(soTKColumnVariables);
            hanghoaTableVariable.addVariable(maHSColumnVariables);
            hanghoaTableVariable.addVariable(kieuColumnVariables);
            hanghoaTableVariable.addVariable(thongTinNSXVariables);
            hanghoaTableVariable.addVariable(dacTinhKTVariables);
//            hanghoaTableVariable.addVariable(soSXColumnVariables);
            hanghoaTableVariable.addVariable(ghiChuColumnVariables);
            variables.addTableVariable(hanghoaTableVariable);

            //Fill file dinh kem
            List<Tbddinhkem3> lstFiles = hoso.getTepDinhKems();
            TableVariable fileDinhKemTableVariable = new TableVariable();
            List<Variable> tenLoaiFileColumnVariables = new ArrayList<Variable>();
            List<Variable> tenFileColumnVariables = new ArrayList<Variable>();

            if (lstFiles == null || lstFiles.isEmpty()) {
                tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", ""));
                tenFileColumnVariables.add(new TextVariable("#{tenfile}", ""));
            } else {
                for (Tbddinhkem3 dinhKem : lstFiles) {
                    tenLoaiFileColumnVariables.add(new TextVariable("#{loaifile}", dinhKem.getFiTenLoai()));
                    tenFileColumnVariables.add(new TextVariable("#{tenfile}", dinhKem.getFiTenTep()));
                }
            }

            fileDinhKemTableVariable.addVariable(tenLoaiFileColumnVariables);
            fileDinhKemTableVariable.addVariable(tenFileColumnVariables);
            variables.addTableVariable(fileDinhKemTableVariable);

            // fill template
            docx.fillTemplate(variables);
            // save filled .docx file
            docx.save(tempFile.getPath());
            fileName = hoso.getFiMaHoso() + ".docx";
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.getOutputStream().write(loadFile(tempFile));
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
    }

    private boolean isOwner(Object fiHoso) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Most03Constant.getInstance().getApiUrl(environment, Most03Constant.API.HS_OWNER) + fiHoso + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }

    @RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson verify(@RequestBody TokenInfo token) {
//        ResponseJson json = BackendRequestHelper
//                .getInstance()
//                .doPostRequest(environment.getRequiredProperty(Most03Constant.API.BACKEND) + "/ca/checkCA/", token);
        token.setUser(this.getUsername());
        token.setMinistryCode(Most03Constant.PROCEDUCE_INFO.MINISTRY_CODE);
        token.setProceduceCode(Most03Constant.PROCEDUCE_INFO.PROCEDUCE_CODE);
        return this.verifySignature(token);
    }
}
