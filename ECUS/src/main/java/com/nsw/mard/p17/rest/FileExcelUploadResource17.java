package com.nsw.mard.p17.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p17.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
@RequestMapping("/mard/api/17")
public class FileExcelUploadResource17 extends Mard17CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource17.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard17TbdThuoc17Resource fldMard17TbdThuoc17Resource;

    @Autowired
    private Mard17CmonUnit17Resource fdMard17CmonUnit17Resource;

    @Autowired
    private Mard17CmonCountry17Resource fdMard17CmonCountryResource;

    @Autowired
    private Mard17TbsLoaiThuoc17Resource fdMard17TbsLoaiThuoc17Resource;

    @Autowired
    private Mard17TbdKetQuaXuLy17Resource fldMard17TbdKetQuaXuLy17Resource;
    @Autowired
    private Mard17TbsLoaiTienTe17Resource fdMard17TbsLoaiTienTe17Resource;


    @Autowired
    private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        List<TbdThuoc17> data = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                return ResponseEntity.ok(json);
            }
            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdThuoc17> tbdThuoc17s = ReadExcelTbdThuoc17.read(file.getInputStream());
            if (valid(tbdThuoc17s)) {
                List<TbdThuoc17> oldTbdThuoc17S1 = fldMard17TbdThuoc17Resource.findByFiIdHoSo(idHoSo).getBody();
                int sort = 0;
                if (oldTbdThuoc17S1 != null && !oldTbdThuoc17S1.isEmpty()) {
                    oldTbdThuoc17S1.sort(Comparator.comparing(TbdThuoc17::getFiSort).reversed());
                    sort = oldTbdThuoc17S1.get(0).getFiSort();
                }
                for (TbdThuoc17 p : tbdThuoc17s) {
                    p.setFiIdHoSo(idHoSo);
                    p.setFiSort(++sort);
                    if (idHoSo > 0) {
                        p = createRestTemplate(getURL("/mard/17/tbdThuoc17/create"), p, HttpMethod.POST, null, TbdThuoc17.class);
                    }
                    data.add(p);
                    LOGGER.info("data: {}", data);
                }
                if (idHoSo > 0) {
                    createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Upload dữ  liệu  từ file  excel", idHoSo);
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

    public boolean valid(List<TbdThuoc17> tbdThuoc17s) {
        if (tbdThuoc17s == null || tbdThuoc17s.isEmpty()) return false;
        List<CmonUnit17> cmonUnit17List = fdMard17CmonUnit17Resource.findAll().getBody();
        List<CmonCountry17> cmonCountry17List = fdMard17CmonCountryResource.findAll().getBody();
       // List<TbsLoaiTienTe17> tbsLoaiTienTe17s = fdMard17TbsLoaiTienTe17Resource.findAll().getBody();
        for (int i = 0; i < tbdThuoc17s.size(); i++) {
            TbdThuoc17 item = tbdThuoc17s.get(i);
            if (!isValid(item)) return false;
            Optional<CmonCountry17> country17 = cmonCountry17List.stream().filter(p -> Objects.equals(p.getFiCountryCode(), item.getFiCountryCode())).findFirst();
            Optional<CmonUnit17> unit17 = cmonUnit17List.stream().filter(p -> Objects.equals(p.getFiUnitCode(), item.getFiWeightUnitCode())).findFirst();
            if (!unit17.isPresent()) return false;
            item.setFiWeightUnitName(unit17.get().getFiUnitName());
            item.setFiCountryName(country17.get().getFiCountryName());
            TbdThuoc17 nextItem = i + 1 < tbdThuoc17s.size() ? tbdThuoc17s.get(i + 1) : null;
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
       /* public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException{

            String fileName = "mau-file-dinh-kem.xlsx";
            FileInputStream fileInputStream = null;
            OutputStream responseOutputStream = null;
            try
            {
                String filePath = request.getServletContext().getRealPath("/WEB-INF/resources/17/")+ fileName;
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
        List<CmonUnit17> cmonUnit17List = fdMard17CmonUnit17Resource.findAll().getBody();

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


        List<TbsLoaiThuoc17> tbsLoaiThuoc17s = fdMard17TbsLoaiThuoc17Resource.findAllTbsLoaiThuoc17(new PageableDTO(100, 0)).getBody();
        List<CmonCountry17> cmonCountry17List =fdMard17CmonCountryResource.findAll().getBody();
        List<TbsLoaiTienTe17> tbsLoaiTienTe17s = fdMard17TbsLoaiTienTe17Resource.findAll().getBody();
        Sheet sheet0 = workbook.createSheet("DanhSachNhap");

       //((XSSFSheet)sheet0).lockFormatCells();// ko cho user thay đổi format cell

        ExcelUtil.mergeCell(sheet0, 0, 0, 0, 9);
        ExcelUtil.createCell(workbook, sheet0.createRow(0), 0,ExcelUtil.TILE17.toUpperCase() + "\n" + messageSource.getMessage("mard.17.title", null, LocaleContextHolder.getLocale()).toUpperCase() , CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        Row headerRow = sheet0.createRow(1);
        ExcelUtil.createCell(workbook, headerRow, 0, "Stt", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 1, "Loại hàng hóa", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 2, "Tên hàng hóa", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 3, "Số lô sản xuất hoặc số ĐKLH", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 4, "Nhà sản xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 5, "Nước sản xuất", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 6, "Tên đơn vị tính", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 7, "Số lượng nhập", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 8, "Thành tiền", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
        ExcelUtil.createCell(workbook, headerRow, 9, "Đơn vị tiền tệ", CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, Font.BOLDWEIGHT_BOLD);
       // ((XSSFSheet)sheet0).setActiveCell(String.valueOf(new CellRangeAddress(1,1000,7,7)));
        for(int i = 0; i < 10; i++) {
            sheet0.autoSizeColumn(i);
        }
        for (int i = 2; i < 100; i++) {
            Row row = sheet0.createRow(i);
            for (int j = 0; j < 10; j++) {
                ExcelUtil.createCell(workbook, row, j, null).setCellStyle(cellStyle);
                Cell cellSpecify =  ExcelUtil.createCell(workbook, row, j, null);
                if(j == 3){
                    cellStyle.setLocked(true);//lock k cho user thay đổi format cell kể cả trường hợp copy paste
                    cellSpecify.setCellStyle(cellStyle);
                }
            }
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 0, 0, 1);
            ExcelUtil.addDataVaditation(sheet0, null, i, i, 7, 7, 1);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachDonVi!$A$2:$A$" + (cmonUnit17List.size() + 1), i, i, 6, 6);
            ExcelUtil.addDataVaditation(sheet0, "DanhSachThuoc!$A$2:$A$" + (tbsLoaiThuoc17s.size() + 1), i, i, 1, 1);
            ExcelUtil.addDataVaditation(sheet0,"DanhSachQuocGia!$A$2:$A$" + (cmonCountry17List.size() + 1), i, i, 5,5);
            ExcelUtil.addDataVaditation(sheet0,"DanhSachDonViTien!$A$2:$A$" + (tbsLoaiTienTe17s.size() + 1), i, i, 9,9);
        }

        Sheet sheet5 = workbook.createSheet("DanhSachQuocGia");
        Row rowSheet5 = sheet5.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet5,0,"Name");
        for (int i = 0; i < cmonCountry17List.size(); i++ ){
            Row r = sheet5.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonCountry17List.get(i).getFiCountryCode() + " | " + cmonCountry17List.get(i).getFiCountryName());
        }
        sheet5.autoSizeColumn(0);
        Sheet sheet1 = workbook.createSheet("DanhSachDonVi");
        Row rowSheet1 = sheet1.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet1, 0, "Name");
        for (int i = 0; i < cmonUnit17List.size(); i++) {
            Row r = sheet1.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, cmonUnit17List.get(i).getFiUnitCode() + " | " + cmonUnit17List.get(i).getFiUnitName());
        }
        sheet1.autoSizeColumn(0);

        Sheet sheet3 = workbook.createSheet("DanhSachThuoc");
        Row rowSheet3 = sheet3.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet3, 0, "Name");

        for (int i = 0; i < tbsLoaiThuoc17s.size(); i++) {
            Row r = sheet3.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0, "\"" + tbsLoaiThuoc17s.get(i).getFiCode() + "\" | " + tbsLoaiThuoc17s.get(i).getFiName() + "");
        }
        sheet3.autoSizeColumn(0);
        Sheet sheet8 = workbook.createSheet("DanhSachDonViTien");
        Row rowSheet8 = sheet8.createRow(0);
        ExcelUtil.createCell(workbook, rowSheet8, 0, "Name");

        for (int i = 0; i < tbsLoaiTienTe17s.size(); i++) {
            Row r = sheet8.createRow(i + 1);
            ExcelUtil.createCell(workbook, r, 0,  tbsLoaiTienTe17s.get(i).getFiMoneyUnitCode() + " | " + tbsLoaiTienTe17s.get(i).getFiMoneyUnitName() + "");
        }
        sheet8.autoSizeColumn(0);

        workbook.setSheetHidden(1, true);
        workbook.setSheetHidden(2, true);
        sheet0.getRow(0).setHeight((short) (4*sheet0.getDefaultRowHeight()));
        sheet0.getRow(1).setHeight((short) (3*sheet0.getDefaultRowHeight()));
        ExcelUtil.setRegionBorderWithNormal(sheet0, 0, 10, 0, 6);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);

        return byteArrayOutputStream;
    }

}
