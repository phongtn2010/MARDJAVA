/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moh.constant.Moh02Constant;
import com.nsw.moh.p02.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author HuongMK
 */
@RestController
@RequestMapping("/moh/p02")
public class Moh02Api extends BaseApi {

    static final String TAG = "Moh02Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoso02 tbdHoso
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
                tbdHoso.setFiTrangthai(Moh02Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Moh02Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_INSERT), tbdHoso);
            } else {
                json = BackendRequestHelper.getInstance().doCustomRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangThai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage02 message = new SendMessage02();
                    message.setType(Moh02Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangThai, Moh02Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Moh02Constant.MSG_FUNC.FUNCTION_01);
                    } else if (Objects.equals(fiTrangThai, Moh02Constant.FILE_STATUS.CHO_TIEP_NHAN) || Objects.equals(fiTrangThai, Moh02Constant.FILE_STATUS.TU_CHOI_HS)) {
                        message.setFunction(Moh02Constant.MSG_FUNC.FUNCTION_02);
                    } else if (Objects.equals(fiTrangThai, Moh02Constant.FILE_STATUS.YC_BOSUNG)) {
                        message.setFunction(Moh02Constant.MSG_FUNC.FUNCTION_04);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_SEND), message);
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

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;

        try {
            switch (key) {
                case Moh02Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Moh02Constant.DANHMUC.DM_QUOCGIA:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_QUOCGIA));
                    break;
                case Moh02Constant.DANHMUC.DM_TINHTHANH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_TINHTHANH));
                    break;
                case Moh02Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_TEPTIN));
                    break;
                case Moh02Constant.DANHMUC.DM_DONVI_TINH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_DONVI_TINH));
                    break;
                case Moh02Constant.DANHMUC.DM_HINHTHUC:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_HINHTHUC));
                    break;
                case Moh02Constant.DANHMUC.DM_VANCHUYEN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DANHMUC_VANCHUYEN));
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

        return json;
    }

    @RequestMapping(value = "/gettoken", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getToken(
            @RequestBody ResponseToken tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String restUri = Moh02Constant.TOKEN.URL_API;
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseToken token = restTemplate.getForObject(restUri, ResponseToken.class);
            json.setData(token);
            json.setSuccess(true);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody SearchForm02 searchForm02
    ) {
        try {
            searchForm02.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_SEARCH), searchForm02);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody TbdHoso02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(Moh02Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Moh02Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_INSERT), tbdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/capnhat", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updateHoso(
            @RequestBody TbdHoso02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            tbdHoso.setFiNguoitao(getUsername());
            json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_UPDATE), tbdHoso);
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
            String url = Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
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
            @RequestBody SearchFormLichsu02 searchFormLichsu02
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.LICHSU_SEARCH), searchFormLichsu02);

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
            @RequestBody SendMessage02 message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            message.setType(Moh02Constant.MSG_TYPE.TYPE_12);
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangthai").toString());
                    String fiMaHoso = ((LinkedHashMap) hosoJson.getData()).get("fiMaHoso").toString();
                    message.setFiMaHoso(fiMaHoso);
                    if (Objects.equals(fiTrangthai, Moh02Constant.FILE_STATUS.CHO_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Moh02Constant.FILE_STATUS.YC_BOSUNG)
                            || Objects.equals(fiTrangthai, Moh02Constant.FILE_STATUS.DA_BOSUNG)
                            || Objects.equals(fiTrangthai, Moh02Constant.FILE_STATUS.TU_CHOI_HS)) {
                        message.setFunction(Moh02Constant.MSG_FUNC.FUNCTION_03);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/xoa/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deleteHoso(
            @PathVariable Long fiIdHoso) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_DELETE) + fiIdHoso);
        return json;
    }

    @RequestMapping(value = "/hoso/giayphep/{fiMaHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getDataGiayphep(
            @PathVariable String fiMaHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_GET_GIAYPHEP) + fiMaHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/uploadFile/", method = RequestMethod.POST)
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
//                    String tempFolder = environment.getProperty(AppConstant.Folder.TemSaveFolder);
//                    String uri = getFullUri(environment.getRequiredProperty(Moh02Constant.API.ATTACHMENT_UPLOAD));
//                    json = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, mqInfo);

                    String uri = environment.getRequiredProperty("moh.api.upload");
                    RestTemplate restTemplate = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

                    json = restTemplate.postForObject(uri, entity, ResponseJson.class);

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

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(Moh02Constant.API.BACKEND) + restUri;
    }

    @RequestMapping(value = "/download/{code}/{idHoso}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,
                             @PathVariable("code") String code,
                             @PathVariable("idHoso") Long idHoso) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.DINHKEM_GET_BYCODE) + idHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }

            TbdGiayphepNk02 fileInfo = GsonUtils.getInstance().transform(json.getData(), TbdGiayphepNk02.class);

            if (fileInfo.getFiIdGiayphep() > 0) {
                downloadFile(response, code, fileInfo.getFiTenCongvan(), fileInfo.getFiNoidungTeptin(), fileInfo.getFiLinkNoidung());
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
        String mimeType;
        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {

            String fileExtent = FilenameUtils.getExtension(fileCodeDb);

            String uri = getFullUri(environment.getProperty(Moh02Constant.API.ATTACHMENT_DOWNLOAD));
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

            Path savePath = Paths.get(environment.getProperty(AppConstant.Folder.TemSaveFolder) + name);
            Files.write(savePath, fileByte);

            File downloadFile = savePath.toFile();

            mimeType = URLConnection.guessContentTypeFromName(name);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + name + "." + fileExtent + "\""));
//            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + name + "\""));
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
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.KQXL_SEARCH), message);
        return json;
    }

    /**
     * *
     * Ham kiem tra phan quyen du lieu
     *
     * @param fiHoso
     * @return
     */
    private boolean isOwner(Object fiHoso) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Moh02Constant.getInstance().getApiUrl(environment, Moh02Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }

}
