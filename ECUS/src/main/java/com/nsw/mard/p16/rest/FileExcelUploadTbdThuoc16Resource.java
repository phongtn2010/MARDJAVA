package com.nsw.mard.p16.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.model.CmonCountry14;
import com.nsw.mard.p14.model.CmonUnit14;
import com.nsw.mard.p14.rest.*;
import com.nsw.mard.p16.model.TbdThuoc16;
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
@RequestMapping("/mard/api/16")
public class FileExcelUploadTbdThuoc16Resource extends Mard16CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadTbdThuoc16Resource.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard16TbdThuoc16Resource fldMard16TbdThuoc16Resource;

    @Autowired
    private Mard14CmonUnit14Resource fdMard14CmonUnit14Resource;

    @Autowired
    private Mard14CmonCountry14Resource fdMard14CmonCountry14Resource;


    @Autowired
    private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

    @Autowired
    private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/thuoc/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc16> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }

            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc16> tbdThuoc16s = ReadExcelTbdThuoc16.read(file.getInputStream());
            tbdThuoc16s.stream().forEach(System.out::println);
            if (valid(tbdThuoc16s)) {
                List<TbdThuoc16> oldTbdThuoc16s1 = fldMard16TbdThuoc16Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc16s1 != null && !oldTbdThuoc16s1.isEmpty()) {
                    oldTbdThuoc16s1.sort(Comparator.comparing(TbdThuoc16::getFiSort).reversed());
                    sort = oldTbdThuoc16s1.get(0).getFiSort();
                }
                for (TbdThuoc16 p : tbdThuoc16s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/16/tbdThuoc16/create"), p, HttpMethod.POST, null, TbdThuoc16.class);
                    }

                    data.add(p);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
                }

                json.setSuccess(true);
                json.setData(data);
            }


        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return ResponseEntity.ok(json);
    }

    public boolean valid(List<TbdThuoc16> tbdThuoc16s) {
        if (tbdThuoc16s == null || tbdThuoc16s.isEmpty()) return false;
        List<CmonUnit14> cmonUnit14List = fdMard14CmonUnit14Resource.findAll().getBody();
        List<CmonCountry14> tbsCmonCountry14s = fdMard14CmonCountry14Resource.findAll().getBody();
        for (int i = 0; i < tbdThuoc16s.size(); i++) {
            TbdThuoc16 item = tbdThuoc16s.get(i);
            if (!isValid(item)) return false;
            Optional<CmonUnit14> unit14 = cmonUnit14List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiQuantityUnitCode())).findFirst();
            if (!unit14.isPresent()) return false;
            item.setFiQuantityUnitName(unit14.get().getFiUnitName());
            Optional<CmonCountry14> cmonCountry14 = tbsCmonCountry14s.stream().filter(p -> Objects.equals(p.getFiCountryCode(), item.getFiExporterCode())).findFirst();
            if (!cmonCountry14.isPresent()) return false;
            item.setFiExporterName(cmonCountry14.get().getFiCountryName());

            TbdThuoc16 nextItem = i + 1 < tbdThuoc16s.size() ? tbdThuoc16s.get(i + 1) : null;
            if (nextItem != null && nextItem.getFiSort() - 1 != item.getFiSort()) return  false;
        }
        return true;
    }

    @RequestMapping(value = "/downloadTemplate/excel/thuoc", method = RequestMethod.GET)
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

        List<CmonCountry14> tbsCmonCountry14s = fdMard14CmonCountry14Resource.findAll().getBody();

        Sheet sheet0 = workbook.createSheet("DanhSachNhap");

        Row title = sheet0.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 7);
        sheet0.addMergedRegion(region);

        ExcelUtil.createCell(workbook, title, 0, ExcelUtil.TILE16.toUpperCase() + "\n" + messageSource.getMessage("mard.16.title", null, LocaleContextHolder.getLocale()).toUpperCase(), CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);


        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Tên giống", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Tên khoa học của giống", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Loại hình", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Số lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Tên đơn vị tính số lượng", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Nơi xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 7, "Cửa khẩu nhập", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        for(int i = 0; i < 8; i++) {
            sheet0.autoSizeColumn(i);
        }

        for (int i = 2; i < 10; i++) {
            Row row = sheet0.createRow(i);
            for (int j = 0; j < 8; j++) {
                ExcelUtil.createCell(workbook, row, j, null);
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 4, 4, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachDonVi!$A$2:$A$" + (cmonUnit14List.size() + 1), i, i, 5, 5);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachQuocGia!$A$2:$A$" + (tbsCmonCountry14s.size() + 1), i, i, 6, 6);

        }



        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit14List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0,  cmonUnit14List.get(i).getFiUnitCode() + " | " + cmonUnit14List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachQuocGia");
        Row rowSheet3 = sheet3.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsCmonCountry14s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, tbsCmonCountry14s.get(i).getFiCountryCode() + " | " + tbsCmonCountry14s.get(i).getFiCountryName());
        }
        sheet3.autoSizeColumn(0);

        workbook.setSheetHidden(1, true);
        workbook.setSheetHidden(2, true);
        sheet0.getRow(0).setHeight((short) (4*sheet0.getDefaultRowHeight()));
        sheet0.getRow(1).setHeight((short) (3*sheet0.getDefaultRowHeight()));
        ExcelUtil.setRegionBorderWithNormal(sheet0, 0, 9, 0, 7);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        // Closing the workbook
        return byteArrayOutputStream;
    }


}
