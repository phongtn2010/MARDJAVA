/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.api.BaseApi;
//import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moh.constant.MOH10Constant;
import com.nsw.moh.p06.model.UploadSecretKey;
import com.nsw.moh.p10.model.*;
import com.nsw.security.UserCustom;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
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

@RestController
@RequestMapping("/moh/10")
public class MOH10Api extends BaseApi {

    static final String TAG = "MOH10Api";
    
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();
    
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
                case MOH10Constant.DANHMUC.DANHMUC_TINHTHANH:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TINHTHANH));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_QUANHUYEN:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_QUANHUYEN) + "/" + id);
                            //.doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_QUANHUYEN));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_COSOSANXUAT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_COSOSANXUAT));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_QUOCGIA:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_QUOCGIA));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_DONVINHAN:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_DONVINHAN));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_DONDK_MDNK:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_DONDK_MDNK));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_DONDK_LOAITTBYT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_DONDK_LOAITTBYT));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_DONDK_LOAI_HOSO_TTBYT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_DONDK_LOAI_HOSO_TTBYT));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_TTB_NHOM:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TTB_NHOM));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_TTB_PHANNHOM:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TTB_PHANNHOM));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_TTB_LOAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TTB_LOAI));
                    break;
                case MOH10Constant.DANHMUC.DANHMUC_TAILIEU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TAILIEU) + id);
                    break;                
                case MOH10Constant.DANHMUC.DANHMUC_TRANGTHAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.DANHMUC_TRANGTHAI));
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
            //filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper
                    .getInstance()
                    .doPostRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.HOSO_SEARCH), filter);
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
//        ResponseJson json = BackendRequestHelper.getInstance()
//                .doGetRequest(MOH10Constant
//                        .getInstance()
//                        .getApiUrl(environment, MOH10Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
//        return json != null && Boolean.parseBoolean(json.getData().toString());
        return true;
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
                .doPostRequest(MOH10Constant
                        .getInstance()
                        .getApiUrl(environment, MOH10Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
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
                    .doPostRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.LICHSU_SEARCH), filterForm);

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
            if (!isOwner(message.getFiIdHoso())) {
                return json;
            }
            
            message.setType(MOH10Constant.MSG_TYPE.TYPE_102);
            message.setFunction(MOH10Constant.MSG_FUNC.FUNC_03);
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.HOSO_SEND), message);

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
            String url = MOH10Constant.getInstance().getApiUrl(environment, MOH10Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
//            if (json != null && (LinkedHashMap) json.getData() != null) {
//                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoitao"))) {
//                    return null;
//                }
//            }
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
    @RequestMapping(value = "/hoso/gcn", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance()
                .doGetRequest(MOH10Constant.getInstance()
                        .getApiUrl(environment, MOH10Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
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
            @RequestBody Tbdhoso10 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                UserCustom user = (UserCustom) principal;
                tbdHoso.setFiMstDn(user.getUsername());
                tbdHoso.setFiTenDn(user.getCompanyName());
                tbdHoso.setFiDiachiDn(user.getCompanyAddress());
                tbdHoso.setFiSdtDn(user.getCompanyPhoneNumber());
                tbdHoso.setFiFaxDn(user.getCompanyFax());
                tbdHoso.setFiEmailDn(null != user.getCompanyEmail() ? user.getCompanyEmail() : tbdHoso.getFiEmailDn());
                tbdHoso.setFiTenNdd(user.getRepresenterName());
                tbdHoso.setFiSdtDd(null != user.getRepresenterMobile() ? user.getRepresenterMobile() : tbdHoso.getFiSdtDd() );

                tbdHoso.setFiSdtCodinh(null != user.getRepresenterPhone() ? user.getRepresenterPhone() : tbdHoso.getFiSdtCodinh() );
                tbdHoso.setFiLoaihinh(null != user.getCompanyType() ?  user.getCompanyType() : "NA");
                tbdHoso.setFiPbanQuanly(user.getDepartmentManage());
                tbdHoso.setFiTenDnEn(user.getEngName());
                tbdHoso.setFiTenVtat(user.getShortName());
                tbdHoso.setFiSoDkkd(null != user.getRegistrationNo() ? user.getRegistrationNo() : "NA");
				
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(MOH10Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH10Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.HOSO_INSERT), tbdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
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
            @RequestBody Tbdhoso10 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance()
                    .doCustomRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
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
            @RequestBody Tbdhoso10 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null) {
                return json;
            }

            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;

            if (fiIdHoso == 0L) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                UserCustom user = (UserCustom) principal;
                tbdHoso.setFiMstDn(user.getUsername());
                tbdHoso.setFiTenDn(user.getCompanyName());
                tbdHoso.setFiDiachiDn(user.getCompanyAddress());
                tbdHoso.setFiSdtDn(user.getCompanyPhoneNumber());
                tbdHoso.setFiFaxDn(user.getCompanyFax());
                tbdHoso.setFiEmailDn(user.getCompanyEmail());
                tbdHoso.setFiTenNdd(user.getRepresenterName());
                tbdHoso.setFiSdtDd(user.getRepresenterMobile());

                tbdHoso.setFiSdtCodinh(user.getRepresenterPhone());
                tbdHoso.setFiLoaihinh(null != user.getCompanyType() ?  user.getCompanyType() : "NA");
                tbdHoso.setFiPbanQuanly(user.getDepartmentManage());
                tbdHoso.setFiTenDnEn(user.getEngName());
                tbdHoso.setFiTenVtat(user.getShortName());
                tbdHoso.setFiSoDkkd(null != user.getRegistrationNo() ? user.getRegistrationNo() : "NA");
                
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(MOH10Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH10Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance()
                        .doPostRequest(MOH10Constant
                                .getInstance()
                                .getApiUrl(environment, MOH10Constant.API.HOSO_INSERT), tbdHoso);
            } else {
                if (!isOwner(fiIdHoso)) {
                    return json;
                }

                json = BackendRequestHelper.getInstance()
                        .doCustomRequest(MOH10Constant
                                .getInstance()
                                .getApiUrl(environment, MOH10Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage message = new SendMessage();
                    message.setType(MOH10Constant.MSG_TYPE.TYPE_101);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, MOH10Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(MOH10Constant.MSG_FUNC.FUNC_01);
                    } else if (Objects.equals(fiTrangthai, MOH10Constant.FILE_STATUS.YC_BO_SUNG)) {
                        message.setFunction(MOH10Constant.MSG_FUNC.FUNC_07);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper
                            .getInstance().doPostRequest(MOH10Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH10Constant.API.HOSO_SEND), message);
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
    
    
    /**
     * Ham xu ly gui ho so
     *
     * @param tbdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendWithoutSave(
            @RequestBody Tbdhoso10 tbdHoso
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
            
            SendMessage message = new SendMessage();
            message.setType(MOH10Constant.MSG_TYPE.TYPE_101);
            message.setFiIdHoso(fiIdHoso);

           if (Objects.equals(tbdHoso.getFiTrangthai(), MOH10Constant.FILE_STATUS.TAO_MOI)) {
                message.setFunction(MOH10Constant.MSG_FUNC.FUNC_01);
            } else if (Objects.equals(tbdHoso.getFiTrangthai(), MOH10Constant.FILE_STATUS.YC_BO_SUNG)) {
                message.setFunction(MOH10Constant.MSG_FUNC.FUNC_07);
            }
           
            //Gui ho so
            ResponseJson jsonResult = BackendRequestHelper
                    .getInstance().doPostRequest(MOH10Constant
                            .getInstance()
                            .getApiUrl(environment, MOH10Constant.API.HOSO_SEND), message);
            
            json.setSuccess(jsonResult.isSuccess());
            json.setMessage(jsonResult.getMessage());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
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
                .doPostRequest(MOH10Constant
                        .getInstance()
                        .getApiUrl(environment, MOH10Constant.API.KQXL_SEARCH), message);
        return json;
    }

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(MOH10Constant.API.BACKEND) + restUri;
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
            String uri = getFullUri(environment.getProperty(MOH10Constant.API.ATTACHMENT_DOWNLOAD));
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
    
    @RequestMapping(value = "/result/{idHoso}/{maHoso}/{idCongVan}/{uiidRequest}", method = RequestMethod.GET)
    public void downloadResut(HttpServletResponse response,
            @PathVariable("idHoso") String idHoso,
            @PathVariable("maHoso") String maHoso,
            @PathVariable("idCongVan") String idCongVan,
            @PathVariable("uiidRequest") String uiidRequest) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (null != idHoso
                        && null != maHoso
                        && null != idCongVan
                        && null != uiidRequest
                        && isOwner(idHoso)) {
                    ResponseJson json = null;
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH10Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH10Constant.API.HOSO_THONGBAO) + maHoso);

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdgcn10 tdbCongVan = mapper.readValue(jsonData, Tbdgcn10.class);

                    String fileDbPath = null;
                    String uiidFileDb = null;

                    if (null != tdbCongVan && Long.parseLong(idCongVan) == tdbCongVan.getFiIdGcn()
                            && maHoso.equals(tdbCongVan.getFiMaHoso())) {
                        uiidFileDb = tdbCongVan.getDinhKem().getFiGuiId();
                        fileDbPath = tdbCongVan.getDinhKem().getFiPathLocal();
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
     * generate key hien thi upload dialog
     *
     * @param data
     * @return
     */
    @RequestMapping(value = {"/upload/key"}, method = RequestMethod.POST)
    public @ResponseBody
    String gegeneratekey(@RequestBody UploadSecretKey data) {
        String frameId = data.getFrameId();
        String tenTaiLieu = data.getTenTaiLieu();
        String maTaiLieu = data.getMaTaiLieu();
        Long currentTime = System.currentTimeMillis();
        String user = environment.getRequiredProperty(MOH10Constant.UploadAccount.USER);
        String userKey = environment.getRequiredProperty(MOH10Constant.UploadAccount.KEY);
        String generateStr = frameId + maTaiLieu + tenTaiLieu + currentTime
                + user + userKey;
        String token = generateMD5(generateStr).toUpperCase();
        String baseString = "frameId=" + frameId + "&matailieu=" + maTaiLieu + "&tentailieu=" + tenTaiLieu + "&thoigian=" + currentTime
                + "&user=" + user + "&token=" + token;

        String key = "";
        try {
            byte[] bytesEncoded = Base64.encodeBase64(baseString.getBytes("UTF-8"));
            key = new String(bytesEncoded, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(ThuTuc06Api.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
}
