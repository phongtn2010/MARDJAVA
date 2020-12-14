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
import com.nsw.moh.constant.Moh03Constant;
import com.nsw.moh.p03.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author HuongMK
 */
@RestController
@RequestMapping("/moh/p03")
public class Moh03Api extends BaseApi {

    static final String TAG = "Moh03Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/hoso/send", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson sendHoso(
            @RequestBody TbdHoso03 tbdHoso
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
                tbdHoso.setFiTrangthai(Moh03Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Moh03Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_INSERT), tbdHoso);
            } else {
                json = BackendRequestHelper.getInstance().doCustomRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangThai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiTrangthai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoso").toString());
                    SendMessage03 message = new SendMessage03();
                    message.setType(Moh03Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangThai, Moh03Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Moh03Constant.MSG_FUNC.FUNCTION_01);
                    } else if (Objects.equals(fiTrangThai, Moh03Constant.FILE_STATUS.CHO_TIEP_NHAN) || Objects.equals(fiTrangThai, Moh03Constant.FILE_STATUS.TU_CHOI_HS)) {
                        message.setFunction(Moh03Constant.MSG_FUNC.FUNCTION_02);
                    } else if (Objects.equals(fiTrangThai, Moh03Constant.FILE_STATUS.YC_BOSUNG)) {
                        message.setFunction(Moh03Constant.MSG_FUNC.FUNCTION_04);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_SEND), message);
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
                case Moh03Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Moh03Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_TEPTIN));
                    break;
                case Moh03Constant.DANHMUC.DM_CUAKHAU:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_CUAKHAU));
                    break;
                case Moh03Constant.DANHMUC.DM_DUOCLIEU:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_DUOCLIEU));
                    break;
                case Moh03Constant.DANHMUC.DM_DONVI_TINH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_DONVI_TINH));
                    break;
                case Moh03Constant.DANHMUC.DM_TCCL:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_TCCL));
                    break;
                case Moh03Constant.DANHMUC.DM_QUOCGIA:
                    json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DANHMUC_QUOCGIA));
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
            String restUri = Moh03Constant.TOKEN.URL_API;
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
            @RequestBody SearchForm03 searchForm03
    ) {
        try {
            searchForm03.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_SEARCH), searchForm03);
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
            @RequestBody TbdHoso03 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdHoso != null) {
                tbdHoso.setFiNguoitao(getUsername());
                tbdHoso.setFiNgaytao(new Date());
                tbdHoso.setFiTrangthai(Moh03Constant.FILE_STATUS.TAO_MOI);
                tbdHoso.setFiTenTt(Moh03Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_INSERT), tbdHoso);
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
            @RequestBody TbdHoso03 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            tbdHoso.setFiNguoitao(getUsername());
            json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_UPDATE), tbdHoso);
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
            String url = Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_GET_BYID);
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
            @RequestBody SearchFormLichsu03 searchFormLichsu03
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.LICHSU_SEARCH), searchFormLichsu03);

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
            @RequestBody SendMessage03 message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            message.setType(Moh03Constant.MSG_TYPE.TYPE_12);
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiTrangthai").toString());
                    String fiMaHoso = ((LinkedHashMap) hosoJson.getData()).get("fiMaHoso").toString();
                    message.setFiMaHoso(fiMaHoso);
                    if (Objects.equals(fiTrangthai, Moh03Constant.FILE_STATUS.CHO_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Moh03Constant.FILE_STATUS.YC_BOSUNG)
                            || Objects.equals(fiTrangthai, Moh03Constant.FILE_STATUS.DA_BOSUNG)
                            || Objects.equals(fiTrangthai, Moh03Constant.FILE_STATUS.TU_CHOI_HS)) {
                        message.setFunction(Moh03Constant.MSG_FUNC.FUNCTION_03);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_SEND), message);
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
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_DELETE) + fiIdHoso);
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
            json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.HOSO_GET_GIAYPHEP) + fiMaHoso);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/download/{code}/{id}/{idHoso}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,
                             @PathVariable("code") String code,
                             @PathVariable("id") Long id,
                             @PathVariable("idHoso") Long idHoso) {
        RabbitMQInfo mqInfo = getRabbitMQ();
        try {
            ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.DINHKEM_GET_BYCODE) + idHoso);
            if (json == null || json.getSuccess() == false || json.getData() == null) {
                return;
            }

            TbdGiayphepNk03 fileInfo = GsonUtils.getInstance().transform(json.getData(), TbdGiayphepNk03.class);

            if (fileInfo.getFiIdGiayphep() > 0) {
                if (id == 1) {
                    downloadFile(response, code, fileInfo.getFiNoidungCv(), fileInfo.getFiNoidungCv(), fileInfo.getFiLinkNdCv());
                }
                if (id == 2) {
                    downloadFile(response, code, fileInfo.getFiNoidungTeptin(), fileInfo.getFiNoidungTeptin(), fileInfo.getFiLinkNdTt());
                }
                if (id == 3) {
                    downloadFile(response, code, fileInfo.getFiFileScan(), fileInfo.getFiFileScan(), fileInfo.getFiLinkFileScan());
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
        String mimeType;
        RabbitMQInfo mqInfo = getRabbitMQ();
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {

            String fileExtent = FilenameUtils.getExtension(fileCodeDb);

            String uri = getFullUri(environment.getProperty(Moh03Constant.API.ATTACHMENT_DOWNLOAD));
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

    String getFullUri(String restUri) {
        return environment.getRequiredProperty(Moh03Constant.API.BACKEND) + restUri;
    }

    @RequestMapping(value = "/downloadTemp", method = RequestMethod.GET)
    public void downloadTemplatePdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("BM_DANHSACH_DUOCLIEU_NK.xlsx").getFile());
        if (file.exists()) {
            String mineType = URLConnection.guessContentTypeFromName(file.getName());
            if (mineType == null) {
                mineType = "application/octet-stream";
            }
            response.setContentType(mineType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }

    @RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson uploadFile(@RequestParam("file") MultipartFile file) {
        ResponseJson json = new ResponseJson();
        try {
            File fileTemp = convertFile(file);

            // check dinh dang file temp
            checkFormatFileTemp(fileTemp, json);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }

    private void checkFormatFileTemp(File file, ResponseJson json) throws IOException, InvalidFormatException {
        List<TbdDonhang03> lstDonhang = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        HashSet unique = new HashSet();

        Row rowTitle = sheet.getRow(3); // dong title
        String stt = convertCellValue(rowTitle.getCell(0));
        String tenDuoclieu = convertCellValue(rowTitle.getCell(1));
        if (rowTitle.getLastCellNum() != 15 || !"STT".equals(stt) || !"Tên dược liệu (*)".equals(tenDuoclieu.trim())) {
            json.setSuccess(false);
            json.setMessage("Không đúng định dạng file mẫu. Vui lòng kiểm tra lại định dạng file mẫu.");
        } else {
            int rowData = 0;
            for (Row row : sheet) {
                if (rowData >= 3) { // dong du lieu bat dau
                    if (!isEmptyRow(row)) {
                        String c11 = convertCellValue(row.getCell(1)); // ten duoc lieu
                        String c12 = convertCellValue(row.getCell(2)); // ten duoc lieu khac
                        String c13 = convertCellValue(row.getCell(3)); // ma hs
                        String c14 = convertCellValue(row.getCell(4)); // bo phan dung
                        String c15 = convertCellValue(row.getCell(5)); // ten khoa hoc (ten latinh)
                        String c16 = convertCellValue(row.getCell(6)); // so luong
                        String c17 = convertCellValue(row.getCell(7)); // don vi tinh
                        String c18 = convertCellValue(row.getCell(8)); // tieu chuan chat luong
                        String c19 = convertCellValue(row.getCell(9)); // tieu chuan chat luong khac
                        String c110 = convertCellValue(row.getCell(10)); // ten nuoc san xuat
                        String c111 = convertCellValue(row.getCell(11)); // ten co so san xuat
                        String c112 = convertCellValue(row.getCell(12)); // ten nuoc cung cap
                        String c113 = convertCellValue(row.getCell(13)); // ten co so cung cap
                        String c114 = convertCellValue(row.getCell(14)); // ghi chu

                        TbdDonhang03 donhang = new TbdDonhang03();

                        if (isNullOrEmpty(c11)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên dược liệu</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTenDuoclieu(c11);
                        }
                        if (isNullOrEmpty(c12) && "Các dược liệu khác dùng làm thuốc chưa được liệt kê".equals(c11.trim())) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên dược liệu khác</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống khi điền tên dược liệu khác");
                            break;
                        } else if ("Các dược liệu khác dùng làm thuốc chưa được liệt kê".equals(c11.trim())) {
                            donhang.setFiTenKhac(c12);
                        } else {
                            donhang.setFiTenKhac(null);
                        }
                        if (isNullOrEmpty(c13)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Mã HS</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiMaHs(c13);
                        }
                        if (isNullOrEmpty(c14)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Bộ phận dùng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiBophanDung(c14);
                        }
                        if (isNullOrEmpty(c15)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên khoa học (tên Latinh)</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTenKh(c15);
                        }
                        if (isNullOrEmpty(c16)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            if (c16.length() >= 10L) {
                                json.setSuccess(false);
                                json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> độ dài không quá 10 ký tự số");
                                break;
                            } else {
                                try {
                                    Long c16Num = convertDataExcel(c16);
                                    donhang.setFiSoluong(c16Num);
                                } catch (Exception e) {
                                    json.setSuccess(false);
                                    json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không đúng định dạng số");
                                    break;
                                }
                            }
                        }
                        if (isNullOrEmpty(c17)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Đơn vị tính</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTenDvTinh(c17);
                        }
                        if (isNullOrEmpty(c18)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tiêu chuẩn chất lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTccl(c18);
                        }
                        if (isNullOrEmpty(c19) && "Tiêu chuẩn chất lượng khác".equals(c18.trim())) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên tiêu chuẩn chất lượng khác</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống khi điền tên tiêu chuẩn chất lượng khác");
                            break;
                        } else if ("Tiêu chuẩn chất lượng khác".equals(c18.trim())){
                            donhang.setFiTcclKhac(c19);
                        } else {
                            donhang.setFiTcclKhac(null);
                        }
                        if (isNullOrEmpty(c110)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên nước sản xuất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTenQgSx(c110);
                        }
                        if (isNullOrEmpty(c111)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên cơ sở sản xuất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiCosoSx(c111);
                        }
                        if (isNullOrEmpty(c112)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên nước cung cấp</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiTenQgCc(c112);
                        }
                        if (isNullOrEmpty(c113)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên cơ sở cung cấp</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            donhang.setFiCosoCc(c113);
                        }
                        donhang.setFiGhichu(c114);
                        lstDonhang.add(donhang);
                    }
                }
                rowData++;
            }
            for (TbdDonhang03 dh : lstDonhang) {
                if (!"Các dược liệu khác dùng làm thuốc chưa được liệt kê".equals(dh.getFiTenDuoclieu().trim())) {
                    if (!unique.add(dh.getFiTenDuoclieu())) {
                        json.setSuccess(false);
                        json.setMessage("Dữ liệu file Excel import vào đang tồn tại tên dược liệu <b>" + (dh.getFiTenDuoclieu()) + "</b> trùng nhau.");
                        break;
                    }
                }
            }
            if (isNullOrEmpty(json.getMessage())) {
                json.setSuccess(true);
                json.setData(lstDonhang);
                json.setTotal((long) lstDonhang.size());
            }
        }
    }

    private Long convertDataExcel(String data) {
        if (data != null && !"".equals(data.trim())) {
            return Long.parseLong(data);
        } else {
            return 0L;
        }
    }

    private boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    private boolean isEmptyRow(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                return false;
            }
        }
        return true;
    }

    private String convertCellValue(Cell cell) {
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }

    private File convertFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
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
            @RequestBody SearchFormKqxl03 message
    ) {
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Moh03Constant.getInstance().getApiUrl(environment, Moh03Constant.API.KQXL_SEARCH), message);
        return json;
    }

}
