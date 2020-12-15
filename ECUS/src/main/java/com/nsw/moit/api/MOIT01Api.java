/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moit.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.moit.constant.MOIT01Constant;
import com.nsw.moit.p01.model.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
@RequestMapping("/moit/01")
public class MOIT01Api extends BaseApi {

    static final String TAG = "MOIT01Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    @Autowired
    Environment environment;

    /**
     * Ham lay danh muc
     *
     * @param key
     * @param id
     * @param key
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
                case MOIT01Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case MOIT01Constant.DANHMUC.DM_MAHS:
                    json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.DANHMUC_HS));
                    break;
                case MOIT01Constant.DANHMUC.DM_LOAIFILE:
                    json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.DANHMUC_LOAIFILE) + id);
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
//            filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_SEARCH), filter);
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
//        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_OWNER) + fiHoso + "/" + getUsername());
//        return json != null && Boolean.parseBoolean(json.getData().toString());
        return true;
    }

//    /**
//     * Xoa ho so
//     *
//     * @param fiIdHoso
//     * @return
//     */
//    @RequestMapping(value = "/hoso/xoa/{fiIdHoso}", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    ResponseJson deleteHoso(
//            @PathVariable Long fiIdHoso
//    ) {
//        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
//            return null;
//        }
//        HashMap map = new HashMap();
//        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
//        return json;
//    }
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
            json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    /**
     * Xin rut ho so(truoc va sau khi Bo CT tiep nhan)
     *
     * @param message
     * @return
     */
//    @RequestMapping(value = "/hoso/yc-rut", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    ResponseJson ycRutHoso(
//            @RequestBody SendMessage01 message
//    ) {
//        ResponseJson json = new ResponseJson();
//        json.setSuccess(false);
//        try {
//            if (!isOwner(message.getFiIdHoso())) {
//                return json;
//            }
//            message.setType(MOIT01Constant.MSG_TYPE.TYPE_15);
//            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
//            if (hosoJson.isSuccess()) {
//                if ((LinkedHashMap) hosoJson.getData() != null) {
//                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangthai").toString());
//                    if (Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.CHO_TIEP_NHAN)
//                            || Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.DA_BO_SUNG_HOSO)
//                            || Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.YC_BO_SUNG)) {
//                        message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_03);
//                    } else {
//                        message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_12);
//                    }
//                    json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_SEND), message);
//                }
//            }
//
//        } catch (Exception ex) {
//            LogUtil.addLog(ex);
//            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
//        }
//        return json;
//    }
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
            String url = MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_GET_BYID);
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
        json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoso());
        return json;
    }

    /**
     * Tao moi ho so
     *
     * @param tbdHoso
     * @return
     */
//    @RequestMapping(value = "/hoso/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    ResponseJson createHoso(
//            @RequestBody Tbdhoso1 tbdHoso
//    ) {
//        ResponseJson json = new ResponseJson();
//        json.setSuccess(false);
//        try {
//            // Bắt đầu gọi backend để thêm mới
//            if (tbdHoso != null) {
//                tbdHoso.setFiNguoitao(getUsername());
//                tbdHoso.setFiNgaytao(new Date());
//                tbdHoso.setFiTrangthai(MOIT01Constant.FILE_STATUS.TAO_MOI);
//                tbdHoso.setFiTenTt(MOIT01Constant.FILE_STATUS.TAO_MOI_STR);
//            }
//            json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_INSERT), tbdHoso);
//
//        } catch (Exception ex) {
//            LogUtil.addLog(ex);
//            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
//        }
//        return json;
//    }
    /**
     * Cap nhat ho so
     *
     * @param tbdHoso
     * @return
     */
//    @RequestMapping(value = "/hoso/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    ResponseJson updateHoso(
//            @RequestBody Tbdhoso1 tbdHoso
//    ) {
//        ResponseJson json = new ResponseJson();
//        json.setSuccess(false);
//        try {
//
//            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
//                return json;
//            }
//
//            json = BackendRequestHelper.getInstance().doCustomRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
//        } catch (Exception ex) {
//            LogUtil.addLog(ex);
//            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
//        }
//        return json;
//    }
    /**
     * Ham xu ly gui ho so
     *
     * @param tbdHoso
     * @return
     */
//    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
//    public @ResponseBody
//    ResponseJson sendHoso(
//            @RequestBody Tbdhoso1 tbdHoso
//    ) {
//        ResponseJson json = new ResponseJson();
//        json.setSuccess(false);
//        try {
//
//            if (tbdHoso == null) {
//                return json;
//            }
//
//            Long fiIdHoso = tbdHoso.getFiIdHoso() != null ? tbdHoso.getFiIdHoso() : 0L;
//
//            if (fiIdHoso == 0L) {
//                tbdHoso.setFiNguoitao(getUsername());
//                tbdHoso.setFiNgaytao(new Date());
//                tbdHoso.setFiTrangthai(MOIT01Constant.FILE_STATUS.TAO_MOI);
//                tbdHoso.setFiTenTt(MOIT01Constant.FILE_STATUS.TAO_MOI_STR);
//                json = BackendRequestHelper.getInstance().doPostRequest(
//                        MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_INSERT), tbdHoso);
//            } else {
//                if (!isOwner(fiIdHoso)) {
//                    return json;
//                }
//
//                json = BackendRequestHelper.getInstance().doCustomRequest(
//                        MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_UPDATE), HttpMethod.PUT, tbdHoso, new HashMap<>());
//            }
//
//            if (json.isSuccess()) {
//                if ((LinkedHashMap) json.getData() != null) {
//                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
//                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
//                    SendMessage01 message = new SendMessage01();
//                    message.setType(MOIT01Constant.MSG_TYPE.TYPE_10);
//                    message.setFiIdHoso(fiIdHoso);
//                    message.setLyDo(tbdHoso.getLyDo());
//
//                    if (Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.TAO_MOI)) {
//                        message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_01);
//                    } else if (Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.CHO_TIEP_NHAN)
//                            || Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.DA_BO_SUNG_HOSO)) {
//                        //Doanh nghiep gui cap nhat ho so khi Bo chua tiep nhan
//                        message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_02);
//                    } else if (Objects.equals(fiTrangthai, MOIT01Constant.FILE_STATUS.YC_BO_SUNG)) {
//                        //Doanh nghiep gui bo sung theo yeu cau cua ben Bo
//                        message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_04);
//                    } else {
//                        //Doanh nghiep xin sua ho so
//                        if (null != message.getLyDo() && message.getLyDo().length() > 0) {
//                            message.setType(MOIT01Constant.MSG_TYPE.TYPE_12);
//                            message.setFunction(MOIT01Constant.MSG_FUNC.FUNC_08);
//                        }
//                    }
//                    //Gui ho so
//                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.HOSO_SEND), message);
//                    json.setSuccess(jsonResult.isSuccess());
//                }
//            }
//        } catch (Exception ex) {
//            LogUtil.addLog(ex);
//            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
//        }
//        return json;
//    }
    /**
     * Ket qua xu ly ho so
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody SearchFormKqxl01 message
    ) {
        if (message == null || !isOwner(message.getFiIdHoso())) {
            return new ResponseJson();
        }
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.KQXL_SEARCH), message);
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
                ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(MOIT01Constant.getInstance().getApiUrl(environment, MOIT01Constant.API.DINHKEM_GET_BYID) + id);
                if (json == null || json.getSuccess() == false || json.getData() == null) {
                    return;
                }

                TbdhsDinhkem1 fileInfo = GsonUtils.getInstance().transform(json.getData(), TbdhsDinhkem1.class);

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
                    String uri = getFullUri(environment.getRequiredProperty(MOIT01Constant.API.ATTACHMENT_UPLOAD));
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
            String uri = getFullUri(environment.getProperty(MOIT01Constant.API.ATTACHMENT_DOWNLOAD));
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
        return environment.getRequiredProperty(MOIT01Constant.API.BACKEND) + restUri;
    }
}