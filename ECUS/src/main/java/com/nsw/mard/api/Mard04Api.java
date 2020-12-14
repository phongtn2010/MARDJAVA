package com.nsw.mard.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.mard.constant.Mard04Constant;
import com.nsw.mard.p04.model.SearchForm04;
import com.nsw.mard.p04.model.SearchFormKqxl04;
import com.nsw.mard.p04.model.SearchFormLichsu04;
import com.nsw.mard.p04.model.TbdDinhkemTtphi04;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author HuongMK
 */
@RestController
@RequestMapping({"/mard/p04"})
public class Mard04Api extends BaseApi {
    static final String TAG = "Mard04Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper;
    @Autowired
    private Environment environment;

    public Mard04Api() {
        fileHelper = new FileServiceHelper();
    }

    @RequestMapping(value = {"/danhmuc"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseJson getCategory(@RequestParam("key") String key, @RequestParam(name = "id", required = false) String id) {
        ResponseJson json = null;
        try {
            switch (key) {
                case Mard04Constant.DANHMUC.DM_TEPTIN: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_TEPTIN));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_BAOBI: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_BAOBI));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_BOPHANDUNG: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_BOPHANDUNG));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_CQ_KIEMTRA: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_CQ_KIEMTRA));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_CQXL: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_CQXL));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_CUAKHAU: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_CUAKHAU));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_DONVI_TINH: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_DV_TINH));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_HANGHOA: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_HANGHOA));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_LOAI_GIAYTO: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_LOAI_GIAYTO));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_LOAIHANG: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_LOAIHANG));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_LOAI_THUCAN: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_LOAI_THUCAN));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_PHUONGTIEN: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_PHUONGTIEN));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_QUOCGIA: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_QUOCGIA));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_TRANGTHAI: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_TRANGTHAI));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_DV_TIENTE: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_DV_TIENTE));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_LOAIDON: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_LOAIDON));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_LOAI_KIEMTRA: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_LOAI_KIEMTRA));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_TRANGTHAI_PHI: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_TRANGTHAI_PHI));
                    break;
                }
                case Mard04Constant.DANHMUC.DM_PHUONGTHUC_KT: {
                    json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DANHMUC_PHUONGTHUC_KT));
                    break;
                }
            }
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
            return json;
        }
    }

    @RequestMapping(value = {"/hoso/timkiem"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson searchHoso(@RequestBody SearchForm04 searchForm04) {
        try {
            searchForm04.setNguoiTao(this.getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_SEARCH), (Object) searchForm04);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
            return null;
        }
    }

    @RequestMapping(value = {"/hoso/t/{fiIdHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getHoso(@PathVariable Long fiIdHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/lichsu"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson lichSuXuLyHoSo(@RequestBody SearchFormLichsu04 filterForm) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.LICHSU_SEARCH), (Object) filterForm);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/xacnhandon/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataXacNhanDon(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_XACNHAN_DON) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giulaiVaxuly/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiuLaiXuLy(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIULAI_VA_XULY) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giayCNKDTV/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiayCNKDTV(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIAY_CNKDTV) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giayXNCL/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiayXNCL(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIAY_XNCL) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giayCNTP/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiayCNTP(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIAY_CNTP) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giayATTP/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiayATTP(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIAY_ATTP) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/giayTamCap/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getDataGiayTamCap(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GIAY_TAMCAP) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/tbphi/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getThongBaoPhi(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GET_THONGBAO_PHI) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/tbphibs/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getThongBaoPhiBS(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_GET_THONGBAO_PHI_BS) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/thanhtoanphi/{fiMaHoso}"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson getXacNhanPhiBS(@PathVariable String fiMaHoso) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.HOSO_XACNHAN_PHI) + fiMaHoso);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/hoso/kqxl"}, method = {RequestMethod.POST}, headers = {"content-type=application/json"})
    @ResponseBody
    public ResponseJson kqxlHoso(@RequestBody SearchFormKqxl04 message) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.KQXL_SEARCH), (Object) message);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, this.getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = {"/downloadFileTtp/{code}/{id}"}, method = {RequestMethod.GET})
    public void downloadFileTtp(HttpServletResponse response, @PathVariable("code") String code, @PathVariable("id") String id) {
        RabbitMQInfo mqInfo = this.getRabbitMQ();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Mard04Constant.getInstance().getApiUrl(this.environment, Mard04Constant.API.DINHKEM_GET_BYID) + id);
                if (json == null || !json.getSuccess() || json.getData() == null) {
                    return;
                }
                TbdDinhkemTtphi04 fileInfo = (TbdDinhkemTtphi04) GsonUtils.getInstance().transform(json.getData(), (Class) TbdDinhkemTtphi04.class);
                if (fileInfo.getFiIdDk() > 0L) {
                    this.downloadFile(response, code, fileInfo.getFiTenDinhkem(), fileInfo.getFiGuiid(), fileInfo.getFiDuongdan());
                }
            } catch (Exception ex) {
                LogUtil.addLog(ex);
                String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
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

            String fileExtent = FilenameUtils.getExtension(fileCodeDb);

            String uri = getFullUri(environment.getProperty(Mard04Constant.API.ATTACHMENT_DOWNLOAD));
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

    String getFullUri(final String restUri) {
        return this.environment.getRequiredProperty(Mard04Constant.API.BACKEND) + restUri;
    }
}
