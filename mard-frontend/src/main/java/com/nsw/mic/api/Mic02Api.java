/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mic.constant.Mic02Constant;
import com.nsw.mic.p02.model.SearchFormGP02;
import com.nsw.mic.p02.model.SearchFormLichsu02;
import com.nsw.mic.p02.model.SendMessage;
import com.nsw.mic.p02.model.SendMessage1;
import com.nsw.mic.p02.model.TbdDinhkem02;
import com.nsw.mic.p02.model.TbdThietBiNk02;
import com.nsw.mic.p02.model.TbdHoso02;
import com.nsw.monre.p09.model.FilterForm;
import com.nsw.mt.p13.model.SearchFormKqxl02;
import com.nsw.util.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 *
 * @author TamDT
 */
@RestController
@RequestMapping("/mic/p02")
public class Mic02Api extends BaseApi {

    static final String TAG = "Mic02Api";
    private static final int BUFFER_SIZE = 4096;

    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;

        try {
            switch (key) {
                case Mic02Constant.DANHMUC.DM_NOICAPGP:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_NOICAPGP));
                    break;
                case Mic02Constant.DANHMUC.DM_CHATLUONG:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_CHATLUONG));
                    break;
                case Mic02Constant.DANHMUC.DM_DVTKHUANKHO:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_DVTKHUANKHO));
                    break;
                case Mic02Constant.DANHMUC.DM_TEVTV:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TENTV));
                    break;
                case Mic02Constant.DANHMUC.DM_KIEUIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_KIEUIN));
                    break;
                case Mic02Constant.DANHMUC.DM_DVTTOCDO:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_DVTOCDO));
                    break;
                case Mic02Constant.DANHMUC.DM_MUCDICH:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_MUCDICH));
                    break;
                case Mic02Constant.DANHMUC.DM_TRANGTHAI:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TRANGTHAI));
                    break;
                case Mic02Constant.DANHMUC.DM_TEPTIN:
                    json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.DANHMUC_TEPTIN));
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

    @RequestMapping(value = "/hoso/timkiem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchHoso(
            @RequestBody FilterForm filter
    ) {
        try {
            filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_SEARCH), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    //TamDT Start
    @RequestMapping("/downloadTemp")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource("BM_THIETBIIN_NK_BTTTT.xlsx").getFile());

        if (file.exists()) {
            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
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

            List<TbdThietBiNk02> lstTbNk = new ArrayList<>();

//            //check dinh dang file temp
//            readFile(fileTemp, lstTbNk);
//
//            json.setSuccess(true);
//            json.setData(lstTbNk);
//            json.setTotal((long) lstTbNk.size());
            checkFormatFileTemp(fileTemp, json);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return json;
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

    private void checkFormatFileTemp(File file, ResponseJson json) throws IOException, InvalidFormatException {
        List<TbdThietBiNk02> lstTbNk = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        //check dinh dang file
        Row rowTitle = sheet.getRow(3);
        String stt = convertCellValue(rowTitle.getCell(0));
        String tenmay = convertCellValue(rowTitle.getCell(1));
        if (rowTitle.getLastCellNum() != 16 || !"STT".equals(stt) || !"Tên máy (*)".equals(tenmay.trim())) {
            //khong dung dinh dang file temp
            json.setSuccess(false);
            json.setMessage("Không đúng định dạng file mẫu. Vui lòng kiểm tra lại định dạng file.");
        } else {
            //dung dinh dang file temp. doc file excel
            int rowData = 0;
            for (Row row : sheet) {
                if (rowData >= 4) {
                    if (!isEmptyRow(row)) {
                        String cl1 = convertCellValue(row.getCell(1));
                        String cl2 = convertCellValue(row.getCell(2));
                        String cl3 = convertCellValue(row.getCell(3));
                        String cl4 = convertCellValue(row.getCell(4));
                        String cl5 = convertCellValue(row.getCell(5));
                        String cl6 = convertCellValue(row.getCell(6));
                        String cl7 = convertCellValue(row.getCell(7));
                        String cl8 = convertCellValue(row.getCell(8));
                        String cl9 = convertCellValue(row.getCell(9));
                        String cl10 = convertCellValue(row.getCell(10));
                        String cl11 = convertCellValue(row.getCell(11));
                        String cl12 = convertCellValue(row.getCell(12));
                        String cl13 = convertCellValue(row.getCell(13));
                        String cl14 = convertCellValue(row.getCell(14));

                        String cl15 = convertCellValue(row.getCell(15));
//                    BigDecimal cl15 = BigDecimal.valueOf(convertDataExcel(str15.replaceAll(",", "")));

                        TbdThietBiNk02 tbnk02 = new TbdThietBiNk02();
                        //valid
                        if (isNullOrEmpty(cl1)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên máy</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiTenMay(cl1);
                        }
                        if (isNullOrEmpty(cl2)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Kiểu in</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiKieuIn(cl2);
                        }

                        ///////
                        if (isNullOrEmpty(cl3)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Số mầu in</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            if (cl3.length() > 9L) {
                                json.setSuccess(false);
                                json.setMessage("Dữ liệu trong cột <b>Số mầu in</b> ở dòng <b>" + (rowData + 1) + "</b> độ dài không quá 9 ký tự số");
                                break;
                            } else {
                                try {
                                    Long cl3Number = convertDataExcel(cl3);
                                    tbnk02.setFiSoMauIn(cl3Number);
                                } catch (Exception ex) {
                                    json.setSuccess(false);
                                    json.setMessage("Dữ liệu trong cột <b>Số mầu in</b> ở dòng <b>" + (rowData + 1) + "</b> không đúng định dạng số");
                                    break;
                                }
                            }
                        }
                        /////////////

                        if (isNullOrEmpty(cl4)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tên hãng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiTenHangSx(cl4);
                        }
                        if (isNullOrEmpty(cl5)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Model</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiModelMay(cl5);
                        }
                        if (isNullOrEmpty(cl6)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Số định danh máy</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiSoDinhDanhMay(cl6);
                        }
                        if (isNullOrEmpty(cl7)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Nước sản xuất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiNuocSx(cl7);
                        }
                        if (isNullOrEmpty(cl8)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Năm sản xuất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiNamSx(cl8);
                        }

                        ////////
                        if (isNullOrEmpty(cl9)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {

                            if (cl9.length() > 9L) {
                                json.setSuccess(false);
                                json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> độ dài không quá 9 ký tự số");
                                break;
                            } else {
                                try {
                                    Long cl9Number = convertDataExcel(cl9);
                                    tbnk02.setFiSoLuong(cl9Number);
                                } catch (Exception ex) {
                                    json.setSuccess(false);
                                    json.setMessage("Dữ liệu trong cột <b>Số lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không đúng định dạng số");
                                    break;
                                }
                            }

                        }
                        //////

                        if (isNullOrEmpty(cl10)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Chất lượng</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiChatLuong(cl10);
                        }
                        if (isNullOrEmpty(cl11)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Khuôn khổ bản in hoặc bản photo lớn nhất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiKhuanKhoBanIn(cl11);
                        }
                        if (isNullOrEmpty(cl12)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Đơn vị kích thước</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiDonViTinhKhuonKho(cl12);
                        }
                        if (isNullOrEmpty(cl13)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Tốc độ in hoặc photo lớn nhất</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiTocDoIn(cl13);
                        }
                        if (isNullOrEmpty(cl14)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Đơn vị tốc độ</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            tbnk02.setFiDonViTocDoIn(cl14);
                        }

                        ///////
                        if (isNullOrEmpty(cl15)) {
                            json.setSuccess(false);
                            json.setMessage("Dữ liệu trong cột <b>Giá trị thiết bị</b> ở dòng <b>" + (rowData + 1) + "</b> không được để trống");
                            break;
                        } else {
                            if (cl15.length() > 15L) {
                                json.setSuccess(false);
                                json.setMessage("Dữ liệu trong cột <b>Giá trị thiết bị</b> ở dòng <b>" + (rowData + 1) + "</b> độ dài không quá 9 ký tự số");
                                break;
                            } else {
                                try {
                                    Long cl15long = convertDataExcel(cl15.replaceAll(",", ""));
                                    BigDecimal cl15Number = BigDecimal.valueOf(cl15long);
                                    tbnk02.setFiGiaThietBi(cl15Number);
                                } catch (Exception ex) {
                                    json.setSuccess(false);
                                    json.setMessage("Dữ liệu trong cột <b>Giá trị thiết bị</b> ở dòng <b>" + (rowData + 1) + "</b> không đúng định dạng số");
                                    break;
                                }
                            }
                        }
                        //////
                        lstTbNk.add(tbnk02);
                    }
                }
                rowData++;
            }
            if (isNullOrEmpty(json.getMessage())) {
                json.setSuccess(true);
                json.setData(lstTbNk);
                json.setTotal((long) lstTbNk.size());
            }
        }
    }

    private boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    private void readFile(File file, List<TbdThietBiNk02> lstTbNk) throws IOException, InvalidFormatException {

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        int rowData = 0;
        for (Row row : sheet) {
            if (rowData >= 4) {
                TbdThietBiNk02 tbnk02 = new TbdThietBiNk02();
                tbnk02.setFiTenMay(convertCellValue(row.getCell(1)));
                tbnk02.setFiKieuIn(convertCellValue(row.getCell(2)));
                tbnk02.setFiSoMauIn(convertDataExcel(convertCellValue(row.getCell(3))));
                tbnk02.setFiTenHangSx(convertCellValue(row.getCell(4)));
                tbnk02.setFiModelMay(convertCellValue(row.getCell(5)));
                tbnk02.setFiSoDinhDanhMay(convertCellValue(row.getCell(6)));
                tbnk02.setFiNuocSx(convertCellValue(row.getCell(7)));
                tbnk02.setFiNamSx(convertCellValue(row.getCell(8)));
                tbnk02.setFiSoLuong(convertDataExcel(convertCellValue(row.getCell(9))));
                tbnk02.setFiChatLuong(convertCellValue(row.getCell(10)));
                tbnk02.setFiKhuanKhoBanIn(convertCellValue(row.getCell(11)));
                tbnk02.setFiDonViTinhKhuonKho(convertCellValue(row.getCell(12)));
                tbnk02.setFiTocDoIn(convertCellValue(row.getCell(13)));
                tbnk02.setFiDonViTocDoIn(convertCellValue(row.getCell(14)));

                String str = convertCellValue(row.getCell(15));
                tbnk02.setFiGiaThietBi(BigDecimal.valueOf(convertDataExcel(str.replaceAll(",", ""))));
                lstTbNk.add(tbnk02);
            }
            rowData++;
        }

        System.out.println("Length: " + lstTbNk.size());
        for (TbdThietBiNk02 obj : lstTbNk) {
            System.out.println("obj: " + obj.getFiTenMay());
        }

        System.out.println();

    }

    private Long convertDataExcel(String data) {
        if (data != null && !"".equals(data.trim())) {
            return Long.parseLong(data);
        } else {
            return 0L;
        }
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
    //end TamDT

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
                tbdHoso.setFiNguoiTao(getUsername());
                tbdHoso.setFiNgayTao(new Date());
                tbdHoso.setFiMaTrangThai(Mic02Constant.FILE_STATUS.TAO_MOI);
//                tbdHoso.setFiTenTt(Most05Constant.FILE_STATUS.TAO_MOI_STR);
            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_INSERT), tbdHoso);
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
            @RequestBody TbdHoso02 tbdHoso
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

//            if (tbdHoso == null || !isOwner(tbdHoso.getFiIdHoso())) {
//                return json;
//            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_UPDATE), tbdHoso);
//            json = BackendRequestHelper.getInstance().doCustomRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
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
            String url = Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_GET_BYID);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdHoso);
            if (json != null && (LinkedHashMap) json.getData() != null) {
                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoiTao"))) {
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

            Long fiIdHoso = tbdHoso.getFiIdHoSo() != null ? tbdHoso.getFiIdHoSo() : 0L;

            if (fiIdHoso == 0L) {
                tbdHoso.setFiNguoiTao(getUsername());
                tbdHoso.setFiNgayTao(new Date());
                tbdHoso.setFiMaTrangThai(Mic02Constant.FILE_STATUS.TAO_MOI);
//                tbdHoso.setFiTenTt(Most05Constant.FILE_STATUS.TAO_MOI_STR);
                json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_INSERT), tbdHoso);
            } else {
//                if (!isOwner(fiIdHoso)) {
//                    return json;
//                }

                json = BackendRequestHelper.getInstance().doCustomRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_UPDATE), HttpMethod.POST, tbdHoso, new HashMap<>());
            }

            if (json.isSuccess()) {
                if ((LinkedHashMap) json.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) json.getData()).get("fiMaTrangThai").toString());
                    fiIdHoso = Long.valueOf(((LinkedHashMap) json.getData()).get("fiIdHoSo").toString());
                    SendMessage message = new SendMessage();
                    message.setType(Mic02Constant.MSG_TYPE.TYPE_10);
                    message.setFiIdHoso(fiIdHoso);

                    if (Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.TAO_MOI)) {
                        message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_01);
                    } else if (Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.CHO_TIEP_NHAN)) {
                        message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_02);
                    } else if (Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.YC_BOSUNG_HS)
                            || Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.TC_CAP_GP)
                            || Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.YC_BOSUNG_THANHPHAN_HS)) {
                        message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_04);
                    }
                    //Gui ho so
                    ResponseJson jsonResult = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_SEND), message);
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

    @RequestMapping(value = "/hoso/yc-rut", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycRutHoso(
            @RequestBody SendMessage message
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
//            if (!isOwner(message.getFiIdHoso())) {
//                return json;
//            }
            message.setType(Mic02Constant.MSG_TYPE.TYPE_15);
            ResponseJson hosoJson = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_GET_BYID) + message.getFiIdHoso());
            if (hosoJson.isSuccess()) {
                if ((LinkedHashMap) hosoJson.getData() != null) {
                    Long fiTrangthai = Long.valueOf(((LinkedHashMap) hosoJson.getData()).get("fiMaTrangThai").toString());
                    if (Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.DA_TIEP_NHAN)
                            || Objects.equals(fiTrangthai, Mic02Constant.FILE_STATUS.DA_BOSUNG_HOSO)) {
                        message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_11);
                    } else {
                        message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_03);
                    }
                    json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_SEND), message);
                }
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/lichsu", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson lichSuXuLyHoSo(
            @RequestBody SearchFormLichsu02 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
//            if (!isOwner(filterForm.getFiIdHoso())) {
//                return json;
//            }
            json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.LICHSU_SEARCH), filterForm);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    @RequestMapping(value = "/hoso/vanban", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson XemGpHoSo(
            @RequestBody SearchFormGP02 filterForm
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
//        if (filterForm == null || !isOwner(filterForm.getFiIdHoso())) {
//            return json;
//        }
        json = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_THONGBAO) + filterForm.getFiMaHoSo());
        return json;
    }

    @RequestMapping(value = "/giayphep/yc-sua", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson ycSuaGP(
            @RequestBody SendMessage1 message1
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
//            if (!isOwner(message.getFiIdHoso())) {
//                return json;
//            }

            List<TbdDinhkem02> lstDK = new ArrayList<>();
            TbdDinhkem02 dk02 = new TbdDinhkem02();
            dk02.setFiTepTinId(message1.getIdFile());
            dk02.setFiTenTepTin(message1.getTenFile());
            lstDK.add(dk02);

            SendMessage message = new SendMessage();
            message.setReason(message1.getReason());
            message.setIdGP(message1.getIdGP());
            message.setFiMaHoso(message1.getFiMaHoso());
            message.setFiIdHoso(message1.getFiIdHoso());
            message.setLstDinhKem(lstDK);

            message.setType(Mic02Constant.MSG_TYPE.TYPE_19);
            ResponseJson GiayPhepJson = BackendRequestHelper.getInstance().doGetRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.GET_GP_BYID) + message.getFiMaHoso());
            if (GiayPhepJson.isSuccess()) {
                message.setFunction(Mic02Constant.MSG_FUNC.FUNCTION_18);
                json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_SEND), message);
            }

        } catch (NumberFormatException ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
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
            @PathVariable Long fiIdHoso) {
//        if (fiIdHoso == null || !isOwner(fiIdHoso)) {
//            return null;
//        }
        HashMap map = new HashMap();
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.HOSO_DELETE) + "/" + fiIdHoso, map);
        return json;
    }

    @RequestMapping(value = "/hoso/kqxl", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson kqxlHoso(
            @RequestBody SearchFormKqxl02 message
    ) {
//        if (message == null || !isOwner(message.getFiIdHoso())) {
//            return new ResponseJson();
//        }
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(Mic02Constant.getInstance().getApiUrl(environment, Mic02Constant.API.KQXL_SEARCH), message);
        return json;
    }

}
