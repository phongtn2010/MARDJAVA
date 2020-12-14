package com.nsw.mard.p16.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.model.CmonCountry14;
import com.nsw.mard.p14.model.CmonUnit14;
import com.nsw.mard.p14.model.TbsLoaiThuoc14;
import com.nsw.mard.p14.rest.*;
import com.nsw.mard.p16.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/mard/api/16")
public class FileExcelUploadTbdToKhaiKyThuat16Resource extends Mard16CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadTbdToKhaiKyThuat16Resource.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard16TbdToKhaiKyThuat16Reource fdMard16TbdToKhaiKyThuat16Reource;

    @Autowired
    private Mard16TbsBoPhan16Resource fdMard16TbsBoPhan16Resource;

    @Autowired
    private Mard16TbsGiaTriSuDung16Resource fdMard16TbsGiaTriSuDung16Resource;

    @Autowired
    private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

    @Autowired
    private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

    @RequestMapping(value = "/uploadFileExcel/toKhaiKyThuat/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdToKhaiKyThuat16> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }

            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdToKhaiKyThuat16> tbdToKhaiKyThuat16s = ReadExcelTbdToKhaiKyThua16.read(file.getInputStream());
            if (valid(tbdToKhaiKyThuat16s)) {
                List<TbdToKhaiKyThuat16> oldTbdToKhaiKyThuat16s1 = fdMard16TbdToKhaiKyThuat16Reource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdToKhaiKyThuat16s1 != null && !oldTbdToKhaiKyThuat16s1.isEmpty()) {
                    oldTbdToKhaiKyThuat16s1.sort(Comparator.comparing(TbdToKhaiKyThuat16::getFiSortDeclaration).reversed());
                    sort = oldTbdToKhaiKyThuat16s1.get(0).getFiSortDeclaration();
                }
                for (TbdToKhaiKyThuat16 p : tbdToKhaiKyThuat16s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSortDeclaration(sort);
                    p = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/create"), p, HttpMethod.POST, null, TbdToKhaiKyThuat16.class);
                    data.add(p);
                }
                createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
                json.setSuccess(true);
                json.setData(data);
            }


        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return ResponseEntity.ok(json);
    }

    public boolean valid(List<TbdToKhaiKyThuat16> tbdThuoc16s) {
        if (tbdThuoc16s == null || tbdThuoc16s.isEmpty()) return false;
        for (TbdToKhaiKyThuat16 item : tbdThuoc16s) {
            if (!isValid(item)) return false;
        }
        return true;
    }

    @RequestMapping(value = "/downloadTemplate/excel/toKhaiKyThuat", method = RequestMethod.GET)
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

    public ByteArrayOutputStream getAllUnit() throws IOException {
        List<TbsBoPhan16> tbsBoPhan16s = fdMard16TbsBoPhan16Resource.findAll(new PageableDTO(100, 0)).getBody();
        List<TbsGiaTriSuDung16> tbsGiaTriSuDung16s = fdMard16TbsGiaTriSuDung16Resource.findAll(new PageableDTO(100, 0)).getBody();

        Workbook workbook = new XSSFWorkbook();


        Sheet sheet0 = workbook.createSheet("DanhSachNhap");
        Row headerRow = sheet0.createRow(0);
        createCell(workbook, headerRow, 0, "Stt");
        createCell(workbook, headerRow, 1, "Tên giống");
        createCell(workbook, headerRow, 2, "Tên khoa học của giống");
        createCell(workbook, headerRow, 3, "Đặc điểm của thực vật học chủ yếu");
        createCell(workbook, headerRow, 4, "Danh sách bộ phận sử dụng");
        createCell(workbook, headerRow, 5, "Danh sách giá trị sử dụng");
        createCell(workbook, headerRow, 6, "Các giá trị khác");
        createCell(workbook, headerRow, 7, "Yêu cầu điều kiện sinh thái");
        createCell(workbook, headerRow, 8, "Thời vụ trồng");
        createCell(workbook, headerRow, 9, "Mật độ, lượng giống/ha");
        createCell(workbook, headerRow, 10, "Sâu bệnh hại chính");
        createCell(workbook, headerRow, 11, "Cảnh báo các tác hại");

        for(int i = 0; i < 12; i++) {
            sheet0.autoSizeColumn(i);
        }
        addDataVaditation(sheet0, "DanhSachBoPhanSuDung!$A$2:$A$" + (tbsBoPhan16s.size() + 1), 1, 1, 4, 4);
        addDataVaditation(sheet0, "DanhSachGiaTriSuDung!$A$2:$A$" + (tbsGiaTriSuDung16s.size() + 1), 1, 1, 5, 5);

        Sheet sheet1 = workbook.createSheet("DanhSachBoPhanSuDung");
        Row rowSheet1 = sheet1.createRow(0);
        createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < tbsBoPhan16s.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            createCell(workbook, r, 0, tbsBoPhan16s.get(i).getFiName() + " | " + tbsBoPhan16s.get(i).getFiCode());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachGiaTriSuDung");
        Row rowSheet3 = sheet3.createRow(0);
        createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsGiaTriSuDung16s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            createCell(workbook, r, 0, tbsGiaTriSuDung16s.get(i).getFiName() + " | " + tbsGiaTriSuDung16s.get(i).getFiCode());
        }
        sheet3.autoSizeColumn(0);

        workbook.setSheetHidden(1, true);
        workbook.setSheetHidden(2, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        // Closing the workbook
        return byteArrayOutputStream;
    }


    private void addDataVaditation(Sheet sheet, String name, int firstRow, int lastRow, int firstCol, int lastCol) {
        DataValidationHelper validationHelper = sheet.getDataValidationHelper();
        DataValidationConstraint explicitListConstraint = validationHelper.createFormulaListConstraint(name);

        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidation validation = validationHelper.createValidation(explicitListConstraint, regions);
        validation.setSuppressDropDownArrow(true);
        validation.createErrorBox("Error","Bạn chưa chọn  đúng  giá trị" );
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);

    }


    private Cell createCell(Workbook workbook, Row row, int index, String value, int... cellType) {
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Cell cell = row.createCell(index);

        if (value != null)
            cell.setCellValue(value);
        cell.setCellStyle(headerCellStyle);
        return cell;
    }


}
