/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.moh.p39.model.SearchFormKqxl02;
import com.nsw.moh.p39.model.HistoryFilterForm;
import com.nsw.moh.p39.model.FilterForm;
import com.nsw.moh.p39.model.ResultFilterForm;
import com.nsw.moh.p39.model.SendMessage;
import com.nsw.api.BaseApi;
import com.nsw.common.model.SignData;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moh.constant.MOH01Constant;
import com.nsw.moh.constant.MOH36Constant;
import com.nsw.moh.constant.MOH39Constant;
import com.nsw.moh.p39.model.Tbdcongvan39;
import com.nsw.moh.p39.model.Tbdhoso39;
import com.nsw.moh.p39.model.TbdhsDinhkem39;
import com.nsw.most.constant.Most03Constant;
import com.nsw.util.Constants;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import com.nsw.util.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/moh/39")
public class MOH39Api extends BaseApi {
    public static final Logger LOGGER = LoggerFactory.getLogger(MOH39Api.class);
    static final String TAG = "MOH39Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    private static final int DOCUMENT_ATTACHMENT = 1;
    private static final int RESULT_ATTACHMENT = 2;

    @Autowired
    Environment environment;

    /**
     * Ham lay danh muc
     *
     * @param key
     * @param id
     * @return
     */
    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;
        try {
            switch (key) {
                case MOH39Constant.DANHMUC.DANHMUC_TRANGTHAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_DONVITINH:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_DONVITINH));
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_TINHTHANH:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_TINHTHANH) + id);
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_CUAKHAU_NHAPKHAU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_CUAKHAU_NHAPKHAU) + id);
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_NUOCSANXUAT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_NUOCSANXUAT));
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_LOAIDONHANG:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_LOAIDONHANG) + id);
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_NUOCCUNGCAP:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_NUOCCUNGCAP));
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_LOAIFILE:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_LOAIFILE) + id);
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_NGUYENLIEU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_NGUYENLIEU) + id);
                    break;
                case MOH39Constant.DANHMUC.DANHMUC_MUCDICHNHAPKHAU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.DANHMUC_MUCDICHNHAPKHAU) + id);
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

    /**
     * Ham tim kiem theo dieu kien dau vao tu nguoi dung
     *
     * @param filter
     * @return
     */
    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        try {
            filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper
                    .getInstance()
                    .doPostRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.HOSO_SEARCH), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    /**
     * *
     * Ham kiem tra phan quyen du lieu
     *
     * @param fiHoso
     * @return
     */
    private boolean isOwner(Object fiHoso) {
        ResponseJson json = BackendRequestHelper.getInstance()
                .doGetRequest(MOH39Constant
                        .getInstance()
                        .getApiUrl(environment, MOH39Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }

    /**
     * Xoa ho so
     *
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/xoa/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(
            @PathVariable Long fiIdHoso
    ) {
        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
            return null;
        }
        HashMap map = new HashMap();
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH39Constant
                        .getInstance()
                        .getApiUrl(environment, MOH39Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
        return json;
    }

    /**
     * Xem lich su xu ly ho so
     *
     * @param filterForm
     * @return
     */
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
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    /**
     * Xin rut ho so(truoc va sau khi Bo TNMT tiep nhan)
     *
     * @param message
     * @return
     */
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
            message.setType(MOH39Constant.MSG_TYPE.TYPE_12);
            ResponseJson hosoJson = BackendRequestHelper.getInstance()
                    .doGetRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    message.setFunction(MOH39Constant.MSG_FUNC.FUNC_03);
                    json = BackendRequestHelper.getInstance()
                            .doPostRequest(MOH39Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH39Constant.API.HOSO_SEND), message);
                }
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    /**
     * Lay chi tiet ho so
     *
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/t/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getHoso(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.HOSO_GET_BYID);
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

    /**
     * Lay thong bao ho so
     *
     * @param filterForm
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/vanban", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
        return json;
    }

    /**
     * Tao moi ho so
     *
     * @param tbdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody Tbdhoso39 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(MOH39Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH39Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.HOSO_INSERT), tbdHoso);

        } catch (Exception ex) {
            LOGGER.info("moh_36_createHoso: {}", ex);
            pushLog(ex);
        }
        return json;
    }

    /**
     * Cap nhat ho so
     *
     * @param tbdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody Tbdhoso39 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance()
                    .doCustomRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
        } catch (Exception ex) {
            LOGGER.info("moh_36_updateHoso: {}", ex);
            pushLog(ex);
        }
        return json;
    }

    /**
     * Ham xu ly gui ho so
     *
     * @param tbdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody Tbdhoso39 tbdHoso
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
                tbdHoso.setFiTrangthai(MOH39Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH39Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance()
                        .doPostRequest(MOH39Constant
                                .getInstance()
                                .getApiUrl(environment, MOH39Constant.API.HOSO_INSERT), tbdHoso);
            } else {
                if (!isOwner(fiIdHoso)) {
                    return json;
                }

                json = BackendRequestHelper.getInstance()
                        .doCustomRequest(MOH39Constant
                                .getInstance()
                                .getApiUrl(environment, MOH39Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage message = new SendMessage();
                    message.setType(MOH39Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(MOH39Constant.MSG_FUNC.FUNC_01);
                    } else if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.CHO_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.TU_CHOI_HOSO)) {
                        message.setFunction(MOH39Constant.MSG_FUNC.FUNC_02);
                    } else if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.YC_BO_SUNG)) {
                        message.setFunction(MOH39Constant.MSG_FUNC.FUNC_04);
                    }
                    //Thiet lap cau hinh ky so
                    if (Constants.SIGN.ON.equals(environment.getRequiredProperty("nsw.moh.39.sign"))) {
                        message.setGetXmlNotSend(Constants.SIGN.ON);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper
                            .getInstance().doPostRequest(MOH39Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH39Constant.API.HOSO_SEND), message);
                    json.setSuccess(jsonResult.isSuccess());
                    json.setMessage(jsonResult.getMessage());

                    if (jsonResult.isSuccess()
                            && Constants.SIGN.ON.equals(environment.getRequiredProperty("nsw.moh.39.sign"))) {
                        SignData signData = new SignData();
                        signData.setFiDocumentCode(((LinkedHashMap) json.getData()).get("fiMaHoso").toString());
                        signData.setFiDocType(((LinkedHashMap) json.getData()).get("fiMaThutuc").toString());
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
            LOGGER.info("moh_36_sendHoso: {}", ex);
            pushLog(ex);
        }
        return json;
    }

    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendWithoutUpdateHoso(
            @RequestBody Tbdhoso39 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;

            if (!isOwner(fiIdHoso)) {
                return json;
            }

            Long fiTrangthai = tbdHoso.getFiTrangthai();

            SendMessage message = new SendMessage();
            message.setType(MOH39Constant.MSG_TYPE.TYPE_10);
            message.setFiIdHoso(fiIdHoso);

            if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.TAO_MOI)) {
                message.setFunction(MOH39Constant.MSG_FUNC.FUNC_01);
            } else if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.CHO_TIEP_NHAN)
                    || Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.TU_CHOI_HOSO)) {
                message.setFunction(MOH39Constant.MSG_FUNC.FUNC_02);
            } else if (Objects.equals(fiTrangthai, MOH39Constant.FILE_STATUS.YC_BO_SUNG)) {
                message.setFunction(MOH39Constant.MSG_FUNC.FUNC_04);
            }
            
            message.setGetXmlNotSend(Constants.SIGN.OFF);
            //Gui ho so
            ResponseJson jsonResult = BackendRequestHelper
                    .getInstance().doPostRequest(MOH39Constant
                            .getInstance()
                            .getApiUrl(environment, MOH39Constant.API.HOSO_SEND), message);
            json.setSuccess(jsonResult.isSuccess());
            json.setMessage(jsonResult.getMessage());
            
            if(!jsonResult.isSuccess()) {
                json.setSuccess(hasChangeDocument(fiIdHoso, fiTrangthai));
            }
            
        } catch (Exception ex) {
            LOGGER.info("moh_36_sendWithoutUpdateHoso: {}", ex);
            pushLog(ex);
            
            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;
            if(fiIdHoso > 0) {
                Long fiTrangthai = tbdHoso.getFiTrangthai();
                json.setSuccess(hasChangeDocument(fiIdHoso, fiTrangthai));
            }
        }
        return json;
    }
    
    private boolean hasChangeDocument(Long fiIdHoso, Long oldStatus){
        try {
            ResponseJson data = new ResponseJson();
            data.setSuccess(false);
            
            String url = MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.HOSO_GET_BYID);
            data = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
            
            if(null != data) {
                Long newStatus = Long.valueOf(((LinkedHashMap) data.getData()).get("fiTrangthai").toString());
                return !oldStatus.equals(newStatus);
            }
            
        } catch(Exception ex) {
            pushLog(ex);
        }
        
        return false;
    }

    /**
     * Ket qua xu ly ho so
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody SearchFormKqxl02 message
    ) {
        if (message == null || !isOwner(message.getFiIdHoso())) {
            return new ResponseJson();
        }
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH39Constant
                        .getInstance()
                        .getApiUrl(environment, MOH39Constant.API.KQXL_SEARCH), message);
        return json;
    }

    /**
     * Download file dinh kem
     *
     * @param response
     * @param code
     * @param id
     */
    @RequestMapping(value = "/download/{code}/{id}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,
            @PathVariable("code") String code,
            @PathVariable("id") String id) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(MOH39Constant.getInstance().getApiUrl(environment, MOH39Constant.API.HOSO_GET_BYID) + id);
                if (json == null || json.getSuccess() == false || json.getData() == null) {
                    return;
                }
                TbdhsDinhkem39 fileInfo = GsonUtils.getInstance().transform(json.getData(), TbdhsDinhkem39.class);

                if (fileInfo.getFiIdDk() > 0) {
                    downloadFile(response, code, fileInfo.getFiTenTep(), fileInfo.getFiGuiid(), fileInfo.getFiDuongDan());
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    /**
     * Download file dinh kem khi chua luu ho so
     *
     * @param response
     * @param code
     * @param mCode
     * @param pCode
     */
    @RequestMapping(value = "/file/{mcode}/{pcode}/{code}", method = RequestMethod.GET)
    public void downloadNewFile(HttpServletResponse response,
            @PathVariable("code") String code,
            @PathVariable("mcode") String mCode,
            @PathVariable("pcode") String pCode) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (code != null) {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    String filePath = mCode + "/" + pCode + "/" + dateFormat.format(date);
                    downloadFile(response, code, code, code, filePath);
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    @RequestMapping(value = "/result/{idHoso}/{maHoso}/{attachType}/{idCongVan}/{uiidRequest}", method = RequestMethod.GET)
    public void downloadResut(HttpServletResponse response,
            @PathVariable("idHoso") String idHoso,
            @PathVariable("maHoso") String maHoso,
            @PathVariable("attachType") String attachType,
            @PathVariable("idCongVan") String idCongVan,
            @PathVariable("uiidRequest") String uiidRequest) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (null != idHoso
                        && null != maHoso
                        && null != attachType
                        && null != idCongVan
                        && null != uiidRequest
                        && isOwner(idHoso)) {
                    ResponseJson json = null;
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH39Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH39Constant.API.HOSO_THONGBAO) + maHoso);

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdcongvan39 tdbCongVan = mapper.readValue(jsonData, Tbdcongvan39.class);

                    String fileDbPath = null;
                    String uiidFileDb = null;

                    if (null != tdbCongVan && Long.parseLong(idCongVan) == tdbCongVan.getFiIdCv()
                            && maHoso.equals(tdbCongVan.getFiMaHoso())) {
                        if (Integer.parseInt(attachType.trim()) == DOCUMENT_ATTACHMENT) {
                            uiidFileDb = tdbCongVan.getDinhKemCongVan().getFiGuiid();
                            fileDbPath = tdbCongVan.getDinhKemCongVan().getFiDuongDan();
                        } else if (Integer.parseInt(attachType.trim()) == RESULT_ATTACHMENT) {
                            uiidFileDb = tdbCongVan.getDinhKemDonHang().getFiGuiid();
                            fileDbPath = tdbCongVan.getDinhKemDonHang().getFiDuongDan();
                        }
                    }

                    if (null != fileDbPath && null != uiidFileDb) {
                        downloadFile(response, uiidRequest, uiidRequest, uiidFileDb, fileDbPath);
                    }
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }
    }

    /**
     * Ham xu ly Upload file dinh kem
     *
     * @param file
     * @param mcode
     * @param pcode
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson uploadFile(@RequestParam("file") MultipartFile file,
            @RequestParam("mcode") String mcode,
            @RequestParam("pcode") String pcode) {
        ResponseJson json = new ResponseJson();
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (file.isEmpty()) {
                    json.setSuccess(false);
                    json.setData(null);
                    json.setMessage("");
                } else {
                    String tempFolder = environment.getProperty(AppConstant.Folder.TemSaveFolder);
                    String uri = getFullUri(environment.getRequiredProperty(MOH39Constant.API.ATTACHMENT_UPLOAD));
                    json = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, mqInfo);
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            }
        }

        return json;
    }

    private void downloadFile(HttpServletResponse response, String fileCode,
            String fileName, String fileCodeDb, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;
        String mimeType;
        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {
            String uri = getFullUri(environment.getProperty(MOH39Constant.API.ATTACHMENT_DOWNLOAD));
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

            Path savePath = Paths.get(environment.getProperty(AppConstant.Folder.TemSaveFolder) + name);
            Files.write(savePath, fileByte);

            File downloadFile = savePath.toFile();

            mimeType = URLConnection.guessContentTypeFromName(name);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + name + "\""));
            response.setContentLength((int) downloadFile.length());

            try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }

            downloadFile.delete();
        }
    }

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(MOH39Constant.API.BACKEND) + restUri;
    }

    @RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson verify(@RequestBody TokenInfo token) {
        token.setUser(this.getUsername());
        return this.verifySignature(token);
    }

    protected void pushLog(Exception ex) {
        try {

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName() + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());

        } catch (Exception e) {
            LOGGER.error("[pushLog]", e);
        }
    }
}
