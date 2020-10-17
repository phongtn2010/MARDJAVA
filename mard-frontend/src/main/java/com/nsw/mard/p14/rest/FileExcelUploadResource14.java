package com.nsw.mard.p14.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.model.CmonUnit14;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdThuoc14;
import com.nsw.mard.p14.model.TbsLoaiThuoc14;
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
@RequestMapping("/mard/api/14")
public class FileExcelUploadResource14 extends Mard14CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource14.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard14TbdThuoc14Resource fldMard14TbdThuoc14Resource;

    @Autowired
    private Mard14CmonUnit14Resource fdMard14CmonUnit14Resource;

    @Autowired
    private Mard14TbsLoaiThuoc14Resource fdMard14TbsLoaiThuoc14Resource;

    @Autowired
    private Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource;

    @Autowired
    private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc14> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }
            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc14> tbdThuoc14s = ReadExcelTbdThuoc14.read(file.getInputStream());
            if (valid(tbdThuoc14s)) {
                List<TbdThuoc14> oldTbdThuoc14s1 = fldMard14TbdThuoc14Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc14s1 != null && !oldTbdThuoc14s1.isEmpty()) {
                    oldTbdThuoc14s1.sort(Comparator.comparing(TbdThuoc14::getFiSort).reversed());
                    sort = oldTbdThuoc14s1.get(0).getFiSort();
                }
                for (TbdThuoc14 p : tbdThuoc14s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(++sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/14/tbdThuoc14/create"), p, HttpMethod.POST, null, TbdThuoc14.class);
                    }
                    data.add(p);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
                }

                json.setSuccess(true);
                json.setData(data);
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return ResponseEntity.ok(json);
    }

    public boolean valid(List<TbdThuoc14> tbdThuoc14s) {
        if (tbdThuoc14s == null || tbdThuoc14s.isEmpty()) return false;
        List<CmonUnit14> cmonUnit14List = fdMard14CmonUnit14Resource.findAll().getBody();
        for (int i = 0; i < tbdThuoc14s.size(); i++) {
            TbdThuoc14 item = tbdThuoc14s.get(i);
            if (!isValid(item)) return false;
            Optional<CmonUnit14> unit14 = cmonUnit14List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiWeightUnitCode())).findFirst();
            if (!unit14.isPresent()) return false;
            item.setFiWeightUnitName(unit14.get().getFiUnitName());
            TbdThuoc14 nextItem = i + 1 < tbdThuoc14s.size() ? tbdThuoc14s.get(i + 1) : null;
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

        List<TbsLoaiThuoc14> tbsLoaiThuoc14s = fdMard14TbsLoaiThuoc14Resource.findAllTbsLoaiThuoc14(new PageableDTO(100, 0)).getBody();

        Sheet sheet0 = workbook.createSheet("DanhSachNhap");
        ExcelUtil.mergeCell(sheet0, 0, 0, 0, 6);

        ExcelUtil.createCell(workbook, sheet0.createRow(0), 0,ExcelUtil.TILE14.toUpperCase() + "\n" + messageSource.getMessage("mard.14.title", null, LocaleContextHolder.getLocale()).toUpperCase() , CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Loại thuốc bảo vệ thực vật", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Tên thuốc bảo vệ thực vật", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Khối lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Tên đơn vị tính khối lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Công dụng thuốc", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Xuất xứ", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        for(int i = 0; i < 7; i++) {
            sheet0.autoSizeColumn(i);
        }

        for (int i = 2; i < 10; i++) {
            Row row = sheet0.createRow(i);
            for (int j = 0; j < 7; j++) {
                ExcelUtil.createCell(workbook, row, j, null);
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 3, 3, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachDonVi!$A$2:$A$" + (cmonUnit14List.size() + 1), i, i, 4, 4);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachThuoc!$A$2:$A$" + (tbsLoaiThuoc14s.size() + 1), i, i, 1, 1);
        }


        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit14List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonUnit14List.get(i).getFiUnitCode() + " | " + cmonUnit14List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachThuoc");
        Row rowSheet3 = sheet3.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsLoaiThuoc14s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, "\"" + tbsLoaiThuoc14s.get(i).getFiCode() + "\" | " + tbsLoaiThuoc14s.get(i).getFiName() + "");
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
