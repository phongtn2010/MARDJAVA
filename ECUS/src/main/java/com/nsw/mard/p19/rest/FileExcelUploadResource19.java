package com.nsw.mard.p19.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p19.model.*;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/mard/api/19")
public class FileExcelUploadResource19 extends Mard19CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource19.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard19TbdThuoc19Resource fldMard19TbdThuoc19Resource;

    @Autowired
    private Mard19CmonUnit19Resource fdMard19CmonUnit19Resource;

    @Autowired
    private Mard19CmonCountry19Resource fdMard19CmonCountryResource;

    @Autowired
    private Mard19TbsLoaiThuoc19Resource fdMard19TbsLoaiThuoc19Resource;

    @Autowired
    private Mard19TbdKetQuaXuLy19Resource fldMard19TbdKetQuaXuLy19Resource;

    @Autowired
    private Mard19TbdHoSo19Resource fldMard19TbdHoSo19Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc19> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }
            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc19> tbdThuoc19s = ReadExcelTbdThuoc19.read(file.getInputStream());
            if (valid(tbdThuoc19s)) {
                List<TbdThuoc19> oldTbdThuoc19S1 = fldMard19TbdThuoc19Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc19S1 != null && !oldTbdThuoc19S1.isEmpty()) {
                    oldTbdThuoc19S1.sort(Comparator.comparing(TbdThuoc19::getFiSort).reversed());
                    sort = oldTbdThuoc19S1.get(0).getFiSort();
                }
                for (TbdThuoc19 p : tbdThuoc19s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(++sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), p, HttpMethod.POST, null, TbdThuoc19.class);
                    }
                    data.add(p);
                    LOGGER.info("data: {}", data);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
                }

                json.setSuccess(true);
                json.setData(data);
                LOGGER.info("json: {}", json.toString());
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return ResponseEntity.ok(json);
    }

    public boolean valid(List<TbdThuoc19> tbdThuoc19s) {
        if (tbdThuoc19s == null || tbdThuoc19s.isEmpty()) return false;
        List<CmonUnit19> cmonUnit19List = fdMard19CmonUnit19Resource.findAll().getBody();
        List<CmonCountry19> cmonCountry19List = fdMard19CmonCountryResource.findAll().getBody();
        for (int i = 0; i < tbdThuoc19s.size(); i++) {
            TbdThuoc19 item = tbdThuoc19s.get(i);
            if (!isValid(item)) return false;
            Optional<CmonCountry19> country19 = cmonCountry19List.stream().filter(p -> Objects.equals(p.getFiCountryCode(), item.getFiCountryCode())).findFirst();
            Optional<CmonUnit19> unit19 = cmonUnit19List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiWeightUnitCode())).findFirst();
            if (!unit19.isPresent()) return false;
            item.setFiWeightUnitName(unit19.get().getFiUnitName());
            item.setFiCountryName(country19.get().getFiCountryName());
            TbdThuoc19 nextItem = i + 1 < tbdThuoc19s.size() ? tbdThuoc19s.get(i + 1) : null;
            if (nextItem != null && nextItem.getFiSort() - 1 != item.getFiSort()) return  false;
        }
        return true;
    }

    @RequestMapping(value = "/downloadTemplate/excel", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletResponse response) {
        try {
            String mimeType = "application/octet-stream";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("filename=\"mau-file-dinh-kem.xlsx\""));
            FileCopyUtils.copy(getAllUnit().toByteArray(), response.getOutputStream());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
//    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException{
//
//        String fileName = "mau-file-dinh-kem.xlsx";
//        FileInputStream fileInputStream = null;
//        OutputStream responseOutputStream = null;
//        try
//        {
//            String filePath = request.getServletContext().getRealPath("/WEB-INF/resources/19/")+ fileName;
//            File file = new File(filePath);
//
//            String mimeType = request.getServletContext().getMimeType(filePath);
//            if (mimeType == null) {
//                mimeType = "application/octet-stream";
//            }
//            response.setContentType(mimeType);
//            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
//            response.setContentLength((int) file.length());
//
//            fileInputStream = new FileInputStream(file);
//            responseOutputStream = response.getOutputStream();
//            int bytes;
//            while ((bytes = fileInputStream.read()) != -1) {
//                responseOutputStream.write(bytes);
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            fileInputStream.close();
//            responseOutputStream.close();
//        }
//    }

    public ByteArrayOutputStream getAllUnit() throws IOException {
        List<CmonUnit19> cmonUnit19List = fdMard19CmonUnit19Resource.findAll().getBody();
        Workbook workbook = new XSSFWorkbook();

        DataFormat fmt = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        //cellStyle.setLocked(true);
        cellStyle.setDataFormat(
                fmt.getFormat("@"));

        List<TbsLoaiThuoc19> tbsLoaiThuoc19s = fdMard19TbsLoaiThuoc19Resource.findAllTbsLoaiThuoc19(new PageableDTO(100, 0)).getBody();
        List<CmonCountry19> cmonCountry19List =fdMard19CmonCountryResource.findAll().getBody();

        Sheet sheet0 = workbook.createSheet("DanhSachNhap");
        ExcelUtil.mergeCell(sheet0, 0, 0, 0, 17);

        ExcelUtil.createCell(workbook, sheet0.createRow(0), 0,ExcelUtil.TILE19.toUpperCase() + "\n" + messageSource.getMessage("mard.19.title", null, LocaleContextHolder.getLocale()).toUpperCase() , CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Loại thuốc thú y", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Tên thuốc thú y", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Nhà sản xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Số đăng ký lưu hành", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Số hiệu văn bản đồng ý nhập khẩu( vắc xin )", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Số lô sản xuất ", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 7, "Quy cách đóng gói", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 8, "Khối lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 9, "Tên đơn vị tính khối lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 10, "Khối lượng ( quy đổi theo Kilogram)", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 11, "Khối lượng ( quy đổi theo Mililit)", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 12, "Nước sản xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 13, "Cửa nhập khẩu", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 14, "Thời gian nhập khẩu từ ngày (dd/mm/yyyy)", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 15, "Thời gian nhập khẩu đến ngày (dd/mm/yyyy)", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 16, "Hàm lượng hoạt chất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 17, "Số thông báo miễn kiểm tra", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        for(int i = 0; i < 18; i++) {
            sheet0.autoSizeColumn(i);
        }

        for (int i = 2; i < 100; i++) {
            Row row = sheet0.createRow(i);

            for (int j = 0; j < 18; j++) {
                ExcelUtil.createCell(workbook, row, j, null);
                Cell cellSpecify =  ExcelUtil.createCell(workbook, row, j, null);
                if(j == 14 || j ==15){
                    cellStyle.setLocked(true);//lock k cho user thay đổi format cell kể cả trường hợp copy paste
                    cellSpecify.setCellStyle(cellStyle);
                }
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 8, 8, 1);

            //ExcelUtil.addDataVaditation(sheet0,null, i, i, 8,8, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachDonVi!$A$2:$A$" + (cmonUnit19List.size() + 1), i, i, 9, 9);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachThuoc!$A$2:$A$" + (tbsLoaiThuoc19s.size() + 1), i, i, 1, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachQuocGia!$A$2:$A$" + (cmonCountry19List.size() + 1), i, i, 12,12);
        }

        Sheet sheet5 = workbook.createSheet("DanhSachQuocGia");
        Row rowSheet5 = sheet5.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet5,0,"Name");
        for (int i = 0; i < cmonCountry19List.size(); i++ ){
            Row r = sheet5.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonCountry19List.get(i).getFiCountryCode() + " | " + cmonCountry19List.get(i).getFiCountryName());
        }
        sheet5.autoSizeColumn(0);
        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit19List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonUnit19List.get(i).getFiUnitCode() + " | " + cmonUnit19List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachThuoc");
        Row rowSheet3 = sheet3.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsLoaiThuoc19s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, "\"" + tbsLoaiThuoc19s.get(i).getFiCode() + "\" | " + tbsLoaiThuoc19s.get(i).getFiName() + "");
        }
        sheet3.autoSizeColumn(0);

        workbook.setSheetHidden(1, true);
        workbook.setSheetHidden(2, true);
        sheet0.getRow(0).setHeight((short) (4*sheet0.getDefaultRowHeight()));
        sheet0.getRow(1).setHeight((short) (3*sheet0.getDefaultRowHeight()));
        ExcelUtil.setRegionBorderWithNormal(sheet0, 0, 9, 0, 6);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        return byteArrayOutputStream;
    }




}
