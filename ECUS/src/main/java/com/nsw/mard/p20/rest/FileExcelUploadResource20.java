package com.nsw.mard.p20.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p20.model.*;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
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
@RequestMapping("/mard/api/20")
public class FileExcelUploadResource20 extends Mard20CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource20.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard20TbdThuoc20Resource fldMard20TbdThuoc20Resource;

    @Autowired
    private Mard20CmonUnit20Resource fdMard20CmonUnit20Resource;

    @Autowired
    private Mard20CmonCountry20Resource fdMard20CmonCountryResource;

    @Autowired
    private Mard20TbsLoaiThuoc20Resource fdMard20TbsLoaiThuoc20Resource;

    @Autowired
    private Mard20TbdKetQuaXuLy20Resource fldMard20TbdKetQuaXuLy20Resource;

    @Autowired
    private Mard20TbdHoSo20Resource fldMard20TbdHoSo20Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc20> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }
            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc20> tbdThuoc20s = ReadExcelTbdThuoc20.read(file.getInputStream());
            if (valid(tbdThuoc20s)) {
                List<TbdThuoc20> oldTbdThuoc20S1 = fldMard20TbdThuoc20Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc20S1 != null && !oldTbdThuoc20S1.isEmpty()) {
                    oldTbdThuoc20S1.sort(Comparator.comparing(TbdThuoc20::getFiSort).reversed());
                    sort = oldTbdThuoc20S1.get(0).getFiSort();
                }
                for (TbdThuoc20 p : tbdThuoc20s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(++sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), p, HttpMethod.POST, null, TbdThuoc20.class);
                    }
                    data.add(p);
                    LOGGER.info("data: {}", data);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
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

    public boolean valid(List<TbdThuoc20> tbdThuoc20s) {
        if (tbdThuoc20s == null || tbdThuoc20s.isEmpty()) return false;
       // List<CmonUnit20> cmonUnit20List = fdMard20CmonUnit20Resource.findAll().getBody();
       // List<CmonCountry20> cmonCountry20List = fdMard20CmonCountryResource.findAll().getBody();
        for (int i = 0; i < tbdThuoc20s.size(); i++) {
            TbdThuoc20 item = tbdThuoc20s.get(i);
            if (!isValid(item)) return false;
            //Optional<CmonCountry20> country20 = cmonCountry20List.stream().filter(p -> Objects.equals(p.getFiCountryCode(), item.getFiCountryCode())).findFirst();
           // Optional<CmonUnit20> unit20 = cmonUnit20List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiWeightUnitCode())).findFirst();
            //if (!unit20.isPresent()) return false;
           // item.setFiWeightUnitName(unit20.get().getFiUnitName());
           // item.setFiCountryName(country20.get().getFiCountryName());
            TbdThuoc20 nextItem = i + 1 < tbdThuoc20s.size() ? tbdThuoc20s.get(i + 1) : null;
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
    /*public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String fileName = "mau-file-dinh-kem.xlsx";
        FileInputStream fileInputStream = null;
        OutputStream responseOutputStream = null;
        try
        {
            String filePath = request.getServletContext().getRealPath("/WEB-INF/resources/20/")+ fileName;
            File file = new File(filePath);

            String mimeType = request.getServletContext().getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentLength((int) file.length());

            fileInputStream = new FileInputStream(file);
            responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fileInputStream.close();
            responseOutputStream.close();
        }
    }*/

    public ByteArrayOutputStream getAllUnit() throws IOException {
//        List<CmonUnit20> cmonUnit20List = fdMard20CmonUnit20Resource.findAll().getBody();
//        CellFormatType textCellFormatType = CellFormatType.TEXT;
        Workbook workbook = new XSSFWorkbook();
        DataFormat fmt = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(
                fmt.getFormat("@"));
//        List<TbsLoaiThuoc20> tbsLoaiThuoc20s = fdMard20TbsLoaiThuoc20Resource.findAllTbsLoaiThuoc20(new PageableDTO(100, 0)).getBody();
//        List<CmonCountry20> cmonCountry20List =fdMard20CmonCountryResource.findAll().getBody();

        Sheet sheet0 = workbook.createSheet("DanhSachNhap");
        ExcelUtil.mergeCell(sheet0, 0, 0, 0, 7);

        ExcelUtil.createCell(workbook, sheet0.createRow(0), 0,ExcelUtil.TILE20.toUpperCase() + "\n" + messageSource.getMessage("mard.20.title", null, LocaleContextHolder.getLocale()).toUpperCase() , CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);

        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Tên thuốc thú y", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Dạng bào chế", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Số đăng ký lưu hành", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Nhà nhập khẩu", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Xuất xứ, Nhà sản xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Kết quả kiểm tra 3 lô liên tiếp", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        for(int i = 0; i < 7; i++) {
            sheet0.autoSizeColumn(i);
        }
        for (int i = 2; i < 100; i++) {
            Row row = sheet0.createRow(i);
            for (int j = 0; j < 7; j++) {
                ExcelUtil.createCell(workbook, row, j, null);
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
        }

        /*Sheet sheet5 = workbook.createSheet("DanhSachQuocGia");
        Row rowSheet5 = sheet5.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet5,0,"Name");
        for (int i = 0; i < cmonCountry20List.size(); i++ ){
            Row r = sheet5.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonCountry20List.get(i).getFiCountryCode() + " | " + cmonCountry20List.get(i).getFiCountryName());
        }
        sheet5.autoSizeColumn(0);
        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit20List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonUnit20List.get(i).getFiUnitCode() + " | " + cmonUnit20List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachThuoc");
        Row rowSheet3 = sheet3.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsLoaiThuoc20s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, "\"" + tbsLoaiThuoc20s.get(i).getFiCode() + "\" | " + tbsLoaiThuoc20s.get(i).getFiName() + "");
        }
        sheet3.autoSizeColumn(0);*/

        sheet0.getRow(0).setHeight((short) (4*sheet0.getDefaultRowHeight()));
        sheet0.getRow(1).setHeight((short) (3*sheet0.getDefaultRowHeight()));
        ExcelUtil.setRegionBorderWithNormal(sheet0, 0, 100, 0, 6);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        return byteArrayOutputStream;
    }
}
