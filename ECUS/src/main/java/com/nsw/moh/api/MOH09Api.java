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
//import com.nsw.helper.SecureHashHelper;
import com.nsw.moh.constant.MOH09Constant;
import com.nsw.moh.p06.model.UploadSecretKey;
import com.nsw.moh.p09.model.*;
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
@RequestMapping("/moh/09")
public class MOH09Api extends BaseApi {

    static final String TAG = "MOH09Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

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
                case MOH09Constant.DANHMUC.DANHMUC_CUAKHAU:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_CUAKHAU));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_LOAITHANHTOAN:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_LOAITHANHTOAN));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_DINHKEM:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_DINHKEM));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_COQUANKIEMTRA:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_COQUANKIEMTRA));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_TRANGTHAI:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_NHOMSP:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_NHOMSP));
                    break;
                case MOH09Constant.DANHMUC.DANHMUC_QUOCGIA:
                    json = BackendRequestHelper.getInstance()
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.DANHMUC_QUOCGIA));
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

    @RequestMapping(value = "/CuaKhau", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchCuaKhau(
            @RequestBody GateSearchForm filter
    ) {
        try {
            ResponseJson json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.DANHMUC_CUAKHAU), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    @RequestMapping(value = "/get-keypay", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchCuaKhau(
            @RequestBody FilterForm filter
    ) {
        try {
            ResponseJson json = new ResponseJson();
            String keyPayLink = environment.getRequiredProperty("moh.keypay.link");
            String secretkey = environment.getRequiredProperty("moh.keypay.secretkey");
            
            String result = keyPayLink + filter.getMaThuTuc() + "&reference=" + filter.getMaHoSo() + "&secure_hash="
                    + hashMD5SecureForLinkPay(filter.getMaHoSo(), filter.getMaThuTuc(), secretkey);
            json.setData(result);
            json.setSuccess(true);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    private String hashMD5SecureForLinkPay(String fileCode, String documentType, String secretkey) {
        //tinh secure_hash
        String result = null;
        //String yourString = "W3QYN2w4Fo6VvQArocpq";

//        Map map = new HashMap();
//        //Adding elements to map  
//        map.put("reference", fileCode);
//        map.put("documentType", documentType);
//        //Traversing Map  
//
//        result = SecureHashHelper.secureHash(map, secretkey);
        return result;
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
            // filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper
                    .getInstance()
                    .doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_SEARCH), filter);
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
//                .doGetRequest(MOH09Constant
//                        .getInstance()
//                        .getApiUrl(environment, MOH09Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
//        return json != null && json.getSuccess();
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
                .doPostRequest(MOH09Constant
                        .getInstance()
                        .getApiUrl(environment, MOH09Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
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
            // if (!isOwner(filterForm.getFiIdHoso())) {
                // return json;
            // }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.LICHSU_SEARCH), filterForm);

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
            message.setType(MOH09Constant.MSG_TYPE.TYPE_109);
            message.setFunction(MOH09Constant.MSG_FUNC.FUNC_14);
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_SEND), message);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
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
            String url = MOH09Constant.getInstance().getApiUrl(environment, MOH09Constant.API.HOSO_GET_BYID);
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

    @RequestMapping(value = "/hoso/gcn", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson quyetDinhHoSo(
            @RequestBody ResultFilterForm filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        // if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
            // return json;
        // }
        json = BackendRequestHelper.getInstance()
                .doGetRequest(MOH09Constant.getInstance()
                        .getApiUrl(environment, MOH09Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
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
            @RequestBody Tbdhoso9 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(MOH09Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(MOH09Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance()
                    .doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_INSERT), tbdHoso);

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
            @RequestBody Tbdhoso9 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
                return json;
            }

            json = BackendRequestHelper.getInstance()
                    .doCustomRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/guihoso", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendWithoutSave(
            @RequestBody Tbdhoso9 tbdHoso
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
            message.setType(MOH09Constant.MSG_TYPE.TYPE_101);
            message.setFiIdHoso(fiIdHoso);

            if (Objects.equals(tbdHoso.getFiTrangthai(), MOH09Constant.FILE_STATUS.TAO_MOI)) {
                message.setFunction(MOH09Constant.MSG_FUNC.FUNC_01);
            } else if (Objects.equals(tbdHoso.getFiTrangthai(), MOH09Constant.FILE_STATUS.YC_BO_SUNG)) {
                message.setFunction(MOH09Constant.MSG_FUNC.FUNC_03);
            }
            //Gui ho so
            ResponseJson jsonResult = BackendRequestHelper
                    .getInstance().doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_SEND), message);
            json.setSuccess(jsonResult.isSuccess());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody ProcessFilterForm message
    ) {
        // if (message == null || !isOwner(message.getFiIdHoso())) {
            // return new ResponseJson();
        // }
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH09Constant
                        .getInstance()
                        .getApiUrl(environment, MOH09Constant.API.KQXL_SEARCH), message);
        return json;
    }

    @RequestMapping(value = "/get-payment/{fiIdHoso}",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getPayment(
            @PathVariable Long fiIdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = MOH09Constant.getInstance().getApiUrl(environment, MOH09Constant.API.PAYMENT_GET);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/send-payment",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendPayment(
            @RequestBody TbdhsTtPhi9 message
    ) {
        if (message == null || !isOwner(message.getFiIdHoso())) {
            return new ResponseJson();
        }
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH09Constant
                        .getInstance()
                        .getApiUrl(environment, MOH09Constant.API.PAYMENT_SEND), message);
        if (json.getSuccess()) {
            SendMessage sendMsg = new SendMessage();
            sendMsg.setType(MOH09Constant.MSG_TYPE.TYPE_104);
            sendMsg.setFunction(MOH09Constant.MSG_FUNC.FUNC_09);
            sendMsg.setFiIdHoso(message.getFiIdHoso());

            json = BackendRequestHelper
                    .getInstance().doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_SEND), sendMsg);
        }

        return json;
    }

    @RequestMapping(value = "/send-report",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendReport(
            @RequestBody Tbdbaocao9 message
    ) {
        if (message == null || !isOwner(message.getFiIdHoso())) {
            return new ResponseJson();
        }
        ResponseJson json = BackendRequestHelper.getInstance()
                .doPostRequest(MOH09Constant
                        .getInstance()
                        .getApiUrl(environment, MOH09Constant.API.REPORT_SEND), message);
        if (json.getSuccess()) {
            SendMessage sendMsg = new SendMessage();
            sendMsg.setType(MOH09Constant.MSG_TYPE.TYPE_107);
            sendMsg.setFunction(MOH09Constant.MSG_FUNC.FUNC_12);
            sendMsg.setFiIdHoso(message.getFiIdHoso());

            json = BackendRequestHelper
                    .getInstance().doPostRequest(MOH09Constant
                            .getInstance()
                            .getApiUrl(environment, MOH09Constant.API.HOSO_SEND), sendMsg);
        }
        return json;
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
                            .doGetRequest(MOH09Constant
                                    .getInstance()
                                    .getApiUrl(environment, MOH09Constant.API.HOSO_THONGBAO) + maHoso);

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonData = mapper.writeValueAsString(json.getData());
                    Tbdgcn9 tdbCongVan = mapper.readValue(jsonData, Tbdgcn9.class);

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
            String uri = getFullUri(environment.getProperty(MOH09Constant.API.ATTACHMENT_DOWNLOAD));
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
        return environment.getRequiredProperty(MOH09Constant.API.BACKEND) + restUri;
    }

    @RequestMapping(value = {"/upload/key"}, method = RequestMethod.POST)
    public @ResponseBody
    String gegeneratekey(@RequestBody UploadSecretKey data) {
        String frameId = data.getFrameId();
        String tenTaiLieu = data.getTenTaiLieu();
        String maTaiLieu = data.getMaTaiLieu();
        Long currentTime = System.currentTimeMillis();
        String user = environment.getRequiredProperty(MOH09Constant.UploadAccount.USER);
        String userKey = environment.getRequiredProperty(MOH09Constant.UploadAccount.KEY);
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
