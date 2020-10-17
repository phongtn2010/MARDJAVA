/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.monre.constant.Monre06Constant;
import com.nsw.monre.p06.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
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

/**
 *
 * @author AnPhucNguyen
 */
@RestController
@RequestMapping("/monre/06")
public class Monre06Api extends BaseApi {

    static final String TAG = "monre06Api";
    private static final int BUFFER_SIZE = 4096;
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
                case "HS_STATUS":
                    json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_STATUS));
                    break;
                case "DVXL":
                    json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.DANHMUC_DVXL));
                    break;
                case "CUAKHAU":
                    json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getBackendCommonApiUrl(environment, Monre06Constant.API.DANHMUC_CUAKHAU));
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
        filter.setNguoiTao(getUsername());
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_SEARCH), filter);
        return json;
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
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
        return json;
    }

    /**
     * Lay thong tin GXN tu thu tuc 1
     *
     * @param soGxn
     * @param fiIdHoso
     * @return
     */
    @RequestMapping(value = "/hoso/gxn01/{soGxn}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson gxn1Hoso(
            @PathVariable String soGxn
    ) {
        if (soGxn == null) {
            return null;
        }
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_GXN1) + "/" + soGxn);
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
            json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.LICHSU_SEARCH), filterForm);

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
            message.setType(Monre06Constant.MSG_TYPE.TYPE_15);
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangthai").toString());
                    if (Objects.equals(fiTrangthai, Monre06Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Monre06Constant.MSG_FUNC.FUNC_03);
                    } else {
                        message.setFunction(Monre06Constant.MSG_FUNC.FUNC_11);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }
    
    @RequestMapping(value = "/hoso/kqycr/{fiMaHoSo}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqXuLyYCRutHoso(
            @PathVariable String fiMaHoSo
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (fiMaHoSo == null) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.KQRUT_SEARCH) + "/" + fiMaHoSo);
        return json;
    }

    /**
     * Ket qua tiep nhan ho so
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody SearchFormKqxl06 message
    ) {
        if (message == null || !isOwner(message.getFiIdHoso())) {
            return new ResponseJson();
        }
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.KQXL_SEARCH), message);
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
            String url = Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_GET_BYID);
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
            @RequestBody Tbdhoso6 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Kiểm tra dữ liệu đầu vào
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(Monre06Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Monre06Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_INSERT), tbdHoso);

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
            @RequestBody Tbdhoso6 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance().doCustomRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
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
            @RequestBody Tbdhoso6 tbdHoso
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
                tbdHoso.setFiTrangthai(Monre06Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Monre06Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_INSERT), tbdHoso);
            } else {
                if (!isOwner(fiIdHoso)) {
                    return json;
                }

                json = BackendRequestHelper.getInstance().doCustomRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Monre06Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, Monre06Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Monre06Constant.MSG_FUNC.FUNC_01);
                    } else if (Objects.equals(fiTrangthai, Monre06Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Monre06Constant.MSG_FUNC.FUNC_02);
                    } else if (Objects.equals(fiTrangthai, Monre06Constant.FILE_STATUS.YC_BO_SUNG)) {
                        message.setFunction(Monre06Constant.MSG_FUNC.FUNC_04);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_SEND), message);
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
     * Lay ket qua Thong bao
     *
     * @param filterForm
     * @return
     */
    @RequestMapping(value = "/hoso/thongbao", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            return json;
        }
        json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
        return json;
    }

    /**
     * Tai file ket qua thong bao
     *
     * @param response
     * @param fiIdHoso
     * @param fiMaHoso
     * @param code
     */
    @RequestMapping(value = "/tbfile/{fiIdHoso}/{fiMaHoso}/{code}", method = RequestMethod.GET)
    public void downloadThongBao(HttpServletResponse response,
            @PathVariable("fiIdHoso") String fiIdHoso,
            @PathVariable("fiMaHoso") String fiMaHoso,
            @PathVariable("code") String code) {
        RabbitMQInfo mqInfo = getRabbitMQ();

        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_THONGBAO) + fiMaHoso);
            Tbdcaptbnk6 tdbThongBao = GsonUtils.getInstance().transform(json.getData(), Tbdcaptbnk6.class);

            if (tdbThongBao != null) {
                Tbddinhkem6 tdbDinhKem = tdbThongBao.getDinhkem();
                if (tdbDinhKem != null) {
                    downloadFile(response, code, tdbDinhKem.getFiTenTep(), tdbDinhKem.getFiTenteptin(), tdbDinhKem.getFiDuongdan());
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
    }

    private void downloadFile(HttpServletResponse response, String fileCode,
            String fileName, String fileCodeDb, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;

        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        String mimeType = URLConnection.guessContentTypeFromName(name);

        if (fileCodeDb.equals(fileCode)) {
            String uri = getFullUri(environment.getProperty(Monre06Constant.API.DOWNLOAD));
            FileServiceHelper fileHelper = new FileServiceHelper();
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

            Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
            Files.write(savePath, fileByte);

            File downloadFile = savePath.toFile();

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
        return environment.getRequiredProperty(Monre06Constant.API.BACKEND) + restUri;
    }

    /**
     * *
     * Ham kiem tra phan quyen du lieu
     *
     * @param fiHoso
     * @return
     */
    private boolean isOwner(Object fiHoso) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Monre06Constant.getInstance().getApiUrl(environment, Monre06Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }
}
