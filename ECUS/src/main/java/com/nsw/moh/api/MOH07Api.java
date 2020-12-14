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
import com.nsw.moh.constant.MOH07Constant;
import com.nsw.moh.p06.model.UploadSecretKey;
import com.nsw.moh.p07.model.*;
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
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/moh/07")
public class MOH07Api extends BaseApi {

    static final String TAG = "MOH07Api";
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
                case MOH07Constant.DANHMUC.DANHMUC_TINHTHANH:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TINHTHANH));
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_THONGTINTKTT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_THONGTINTKTT) + "/" + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_QUANHUYEN:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_QUANHUYEN) + "/" + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_COSOSANXUAT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_COSOSANXUAT) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_QUOCGIA:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_QUOCGIA));
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_DONVINHAN:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_DONVINHAN));
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_DONDK_NHOMTTBYT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_DONDK_NHOMTTBYT) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_DONDK_LOAITTBYT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_DONDK_LOAITTBYT) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_DONDK_LOAI_HOSO_TTBYT:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_DONDK_LOAI_HOSO_TTBYT) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TTB_NHOM:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TTB_NHOM) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TTB_PHANNHOM:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TTB_PHANNHOM) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TTB_LOAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TTB_LOAI) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TAILIEU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TAILIEU) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TAILIEU_TTB:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TAILIEU_TTB) + id);
                    break;
                case MOH07Constant.DANHMUC.DANHMUC_TRANGTHAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DANHMUC_TRANGTHAI));
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
                    .doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.HOSO_SEARCH), filter);
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
//                .doGetRequest(MOH07Constant
//                        .getInstance()
//                        .getApiUrl(environment, MOH07Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
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
                .doPostRequest(MOH07Constant
                        .getInstance()
                        .getApiUrl(environment, MOH07Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
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
                    .doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.LICHSU_SEARCH), filterForm);

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
            message.setType(MOH07Constant.MSG_TYPE.TYPE_102);
            message.setFunction(MOH07Constant.MSG_FUNC.FUNC_03);
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.HOSO_SEND), message);

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
            String url = MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.HOSO_GET_BYID);
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
                .doGetRequest(MOH07Constant.getInstance()
                        .getApiUrl(environment, MOH07Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
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
            @RequestBody Tbdhoso7 tbdHoso
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
                tbdHoso.setFiSdtDd(null != user.getRepresenterMobile() ? user.getRepresenterMobile() : tbdHoso.getFiSdtDd());

                tbdHoso.setFiSdtCodinh(null != user.getRepresenterPhone() ? user.getRepresenterPhone() : tbdHoso.getFiSdtCodinh());
                tbdHoso.setFiLoaihinh(null != user.getCompanyType() ? user.getCompanyType() : "NA");
                tbdHoso.setFiPbanQuanly(user.getDepartmentManage());
                tbdHoso.setFiTenDnEn(user.getEngName());
                tbdHoso.setFiTenVtat(user.getShortName());
                tbdHoso.setFiSoDkkd(null != user.getRegistrationNo() ? user.getRegistrationNo() : "NA");

                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(MOH07Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH07Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.HOSO_INSERT), tbdHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/dklh/check", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson checkDKLH(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                json = BackendRequestHelper.getInstance()
                        .doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.DKLH_CHECK) + message.getFiSoVb());

            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            }
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
            @RequestBody Tbdhoso7 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance()
                    .doCustomRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
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
            @RequestBody Tbdhoso7 tbdHoso
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
            message.setType(MOH07Constant.MSG_TYPE.TYPE_101);
            message.setFiIdHoso(fiIdHoso);

            if (Objects.equals(tbdHoso.getFiTrangthai(), MOH07Constant.FILE_STATUS.TAO_MOI)) {
                message.setFunction(MOH07Constant.MSG_FUNC.FUNC_01);
            } else if (Objects.equals(tbdHoso.getFiTrangthai(), MOH07Constant.FILE_STATUS.YC_BO_SUNG)) {
                message.setFunction(MOH07Constant.MSG_FUNC.FUNC_07);
            }
            //Gui ho so
            ResponseJson jsonResult = BackendRequestHelper
                    .getInstance().doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.HOSO_SEND), message);
            json.setSuccess(jsonResult.isSuccess());
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
                .doPostRequest(MOH07Constant
                        .getInstance()
                        .getApiUrl(environment, MOH07Constant.API.KQXL_SEARCH), message);
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
//        RabbitMQInfo mqInfo = getRabbitMQ();
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            try {
//                ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(MOH07Constant.getInstance().getApiUrl(environment, MOH07Constant.API.HOSO_GET_BYID) + id);
//                if (json == null || json.getSuccess() == false || json.getData() == null) {
//                    return;
//                }
//                TbdhsDinhkem19 fileInfo = GsonUtils.getInstance().transform(json.getData(), TbdhsDinhkem19.class);
//
//                if (fileInfo.getFiIdDk() > 0) {
//                    downloadFile(response, code, fileInfo.getFiTenTep(), fileInfo.getFiGuiid(), fileInfo.getFiDuongDan());
//                }
//            } catch (Exception ex) {
//                LogUtil.addLog(ex);
//                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
//                        + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//
//                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
//            }
//        }
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
                            .doGetRequest(MOH07Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH07Constant.API.HOSO_THONGBAO) + maHoso);

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdgcn7 tdbCongVan = mapper.readValue(jsonData, Tbdgcn7.class);

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
                    String uri = getFullUri(environment.getRequiredProperty(MOH07Constant.API.ATTACHMENT_UPLOAD));
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
            String uri = getFullUri(environment.getProperty(MOH07Constant.API.ATTACHMENT_DOWNLOAD));
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

    @RequestMapping(value = "/csbh/search", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchCoSoBaoHanh(
            @RequestBody CsbhFilterForm filter
    ) {
        try {
            filter.setFiMst(this.getUsername());
            ResponseJson json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH07Constant.getInstance()
                            .getApiUrl(environment, MOH07Constant.API.DANHMUC_CSBH), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    @RequestMapping(value = "/csbh/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createCsbh(
            @RequestBody TbdCsbaohanh7 tbdCsbaohanh7
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (tbdCsbaohanh7 != null) {
                tbdCsbaohanh7.setFiNguoitao(getUsername());
                tbdCsbaohanh7.setFiNgaytao(new Date());
            }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.DANHMUC_CSBH_ADD), tbdCsbaohanh7);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/csbh/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateCsbh(
            @RequestBody TbdCsbaohanh7 tbdCsbaohanh7
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

//            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
//                return json;
//            }
            json = BackendRequestHelper.getInstance()
                    .doCustomRequest(MOH07Constant
                            .getInstance()
                            .getApiUrl(environment, MOH07Constant.API.DANHMUC_CSBH_UPDATE), HttpMethod.PUT, tbdCsbaohanh7, new HashMap<>());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/csbh/xoa/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteCsbh(
            @PathVariable Long fiIdHoso
    ) {
//        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
//            return null;
//        }
        HashMap map = new HashMap();
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH07Constant
                        .getInstance()
                        .getApiUrl(environment, MOH07Constant.API.DANHMUC_CSBH_DELETE) + "/" + fiIdHoso, map);
        return json;
    }

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(MOH07Constant.API.BACKEND) + restUri;
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
        String user = environment.getRequiredProperty(MOH07Constant.UploadAccount.USER);
        String userKey = environment.getRequiredProperty(MOH07Constant.UploadAccount.KEY);
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
