package com.nsw.mard.p15.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.model.CmonUnit14;
import com.nsw.mard.p14.rest.*;
import com.nsw.mard.p15.model.TbdThuoc15;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/mard/api/15")
public class FileExcelUploadResource15 extends Mard15CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource15.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard15TbdThuoc15Resource fldMard15TbdThuoc15Resource;

    @Autowired
    private Mard14CmonUnit14Resource fdMard14CmonUnit14Resource;

    @Autowired
    private Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource;

    @Autowired
    private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc15> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }

            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc15> tbdThuoc15s = ReadExcelTbdThuoc15.read(file.getInputStream());
            if (valid(tbdThuoc15s)) {
                List<TbdThuoc15> oldTbdThuoc15s1 = fldMard15TbdThuoc15Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc15s1 != null && !oldTbdThuoc15s1.isEmpty()) {
                    oldTbdThuoc15s1.sort(Comparator.comparing(TbdThuoc15::getFiSort).reversed());
                    sort = oldTbdThuoc15s1.get(0).getFiSort();
                }
                for (TbdThuoc15 p : tbdThuoc15s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(++sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/15/tbdThuoc15/create"), p, HttpMethod.POST, null, TbdThuoc15.class);
                    }

                    data.add(p);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
                }

                json.setSuccess(true);
                json.setData(data);
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return ResponseEntity.ok(json);
    }

    public boolean valid(List<TbdThuoc15> tbdThuoc15s) {
        if (tbdThuoc15s == null || tbdThuoc15s.isEmpty()) return false;
        List<CmonUnit14> cmonUnit14List = fdMard14CmonUnit14Resource.findAll().getBody();
        for (int i = 0; i < tbdThuoc15s.size(); i++) {
            TbdThuoc15 item = tbdThuoc15s.get(i);
            if (!isValid(item)) return false;
            Optional<CmonUnit14> unit14 = cmonUnit14List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiQuantityUnitCode())).findFirst();
            if (!unit14.isPresent()) return false;
            item.setFiQuantityUnitName(unit14.get().getFiUnitName());
            TbdThuoc15 nextItem = i + 1 < tbdThuoc15s.size() ? tbdThuoc15s.get(i + 1) : null;
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

    public ByteArrayOutputStream getAllUnit() throws IOException {
        List<CmonUnit14> cmonUnit14List = fdMard14CmonUnit14Resource.findAll().getBody();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet0 = workbook.createSheet("DanhSachNhap");

        Row title = sheet0.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 10);
        sheet0.addMergedRegion(region);

        ExcelUtil.createCell(workbook, title, 0, ExcelUtil.TILE15.toUpperCase() + "\n" + messageSource.getMessage("mard.15.title", null, LocaleContextHolder.getLocale()).toUpperCase(), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);


        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Tên nguồn gen", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Tên khoa học", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Thuộc loài", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Nguồn gốc", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Thời gian thu thập", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Cơ quan lưu giữ giống", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 7, "Thể loại", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 8, "Số lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 9, "Tên đơn vị tính số lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 10, "Cửa khẩu nhập", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        for(int i = 0; i < 11; i++) {
            sheet0.autoSizeColumn(i);
        }
        for (int i = 2; i < 10; i++) {
            Row row = sheet0.createRow(i);
            for (int j = 0; j < 11; j++) {
                ExcelUtil.createCell(workbook, row, j, null);
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 8, 8, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachDonVi!$A$2:$A$" + (cmonUnit14List.size() + 1), i, i, 9, 9);

        }


        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit14List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0,  cmonUnit14List.get(i).getFiUnitCode() + " | " + cmonUnit14List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        workbook.setSheetHidden(1, true);
        sheet0.getRow(0).setHeight((short) (4*sheet0.getDefaultRowHeight()));
        sheet0.getRow(1).setHeight((short) (3*sheet0.getDefaultRowHeight()));
        ExcelUtil.setRegionBorderWithNormal(sheet0, 0, 9, 0, 10);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        return byteArrayOutputStream;
    }




}
