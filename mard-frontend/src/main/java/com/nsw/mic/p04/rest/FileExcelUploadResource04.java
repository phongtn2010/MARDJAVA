package com.nsw.mic.p04.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.rest.ExcelUtil;
import com.nsw.mic.p03.rest.FileExcelUploadResource03;
import com.nsw.mic.p03.rest.Mic03CommonApi;
import com.nsw.mic.p04.dto.TbdHoSo04DTO;
import com.nsw.mic.p04.dto.TbdNguoiThamDinh04DTO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping(Mic04Constant.ROOT_API)
public class FileExcelUploadResource04 extends Mic04CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource03.class);

    @Autowired
    private Mic04TbdHoSo04Api mic04TbdHoSo04Api;


    @Autowired
    private Mic04TbdKetQuaXuLy04Api mic04TbdKetQuaXuLy04Api;

    private Long lastID = 0L;

    @RequestMapping(value = "/uploadFileExcel/{idHoSo}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseJson> uploadFileExcel(@RequestParam("file") MultipartFile file, @PathVariable("idHoSo") long idHoSo) {

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        json.setMessage("Upload file không thành công");

        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body(json);
            }
            LOGGER.info("Upload file excel: {}", file.getOriginalFilename());
            List<TbdNguoiThamDinh04DTO> tbdNguoiThamDinh04DTOs = read(file.getInputStream());
            if (valid(tbdNguoiThamDinh04DTOs)) {

                if (idHoSo > 0) {
                    TbdHoSo04DTO tbdHoSo04DTO = mic04TbdHoSo04Api.getTbdHoSo04(idHoSo).getBody();
                    if (tbdHoSo04DTO == null)  return ResponseEntity.badRequest().body(json);
                    for (TbdNguoiThamDinh04DTO p : tbdNguoiThamDinh04DTOs) {
                        p.setFiIdHoSo(idHoSo);
                        tbdHoSo04DTO.getTbdNguoiThamDinh04DTOS().add(p);
                    }
                    tbdHoSo04DTO = mic04TbdHoSo04Api.updateTbdHoSo04(idHoSo, tbdHoSo04DTO).getBody();
                    json.setData(tbdHoSo04DTO.getTbdNguoiThamDinh04DTOS());
                    createHistory(mic04TbdKetQuaXuLy04Api, mic04TbdHoSo04Api, "Upload dữ  liệu  từ file  excel", idHoSo);
                } else {
                    for (long i = 0; i < tbdNguoiThamDinh04DTOs.size(); i++) {
                        tbdNguoiThamDinh04DTOs.get((int)i).setFiId(++lastID);
                    }
                    json.setData(tbdNguoiThamDinh04DTOs);
                }


                json.setSuccess(true);
                json.setMessage("Upload file thành công");
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            json.setMessage(ex.getMessage());
        }

        return ResponseEntity.ok(json);
    }

    private List<TbdNguoiThamDinh04DTO> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdNguoiThamDinh04DTO> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        int count = 0;
        for (int i = 10; i <= listColum; i++) {
            TbdNguoiThamDinh04DTO tbdNguoiThamDinh04DTO = new TbdNguoiThamDinh04DTO();
            Row row = sheet.getRow(i);
            count++;
            if (row == null || ExcelUtil.isRowEmpty(row)) continue;

            validCell(row, count);
            for (int k = 0; k < 7; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdNguoiThamDinh04DTO, k);
            }
            results.add(tbdNguoiThamDinh04DTO);

        }
        if (results.isEmpty()) {
            throw new RuntimeException("Không có dữ liệu");
        }
        return results;
    }

    private boolean valid(List<TbdNguoiThamDinh04DTO> tbdNguoiThamDinh04DTOS) {

        boolean check = true;

        if (ObjectUtils.isEmpty(tbdNguoiThamDinh04DTOS)) return check;
        for (TbdNguoiThamDinh04DTO tbdNguoiThamDinh04DTO : tbdNguoiThamDinh04DTOS) {
            if (!isValid(tbdNguoiThamDinh04DTO)) {
                check = false;
                break;
            }
        }

        return check;
    }

    private boolean validCell(Row row, int stt) {
        for (int k = 0; k < 7; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
                throw new RuntimeException("Dòng STT = " + stt + ". Cột " + COLUMNS[k] + ". " + "Cột dữ liệu chưa đầy đủ");
            switch (k) {
                case 0:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        if (!String.valueOf(stt).equals(ExcelUtil.getString(cell)))
                            throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột STT không đúng chỉ số dòng: " + ExcelUtil.getNumber(cell).intValue());
                    } else {
                        if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) throw new RuntimeException("Cột số thứ tự không đúng");
                        if (stt != ExcelUtil.getNumber(cell).intValue())
                            throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột STT không đúng chỉ số dòng: " + ExcelUtil.getNumber(cell).intValue());
                    }
                    break;
                case 1:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Họ và tên chỉ được tối đa 255 ký tự");
                    break;
                case 2:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && !ExcelUtil.getString(cell).matches(DATE_FORMAT)) {
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Ngày, tháng, năm sinh không đúng định dạng dd/MM/yyyy. Ví du: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
                    } else if (!isDate(ExcelUtil.getString(cell))) {
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Ngày, tháng, năm sinh không đúng giá trị ngày tháng");
                    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cell.getDateCellValue() == null )
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Ngày, tháng, năm sinh sai kiểu dữ liệu");

                    break;
                case 3:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 500)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Trình độ nghiệp vụ được tối đa 500 ký tự");
                    break;
                case 4:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 500)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Trình độ chuyên môn chỉ được tối đa 500 ký tự");
                    break;
                case 5:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Trình độ ngoại ngữ chỉ được tối đa 255 ký tự");
                    break;
                case 6:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 1000)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Thâm niên công tác trong hoạt động xuất bản tại Việt Nam chỉ được tối đa 1000 ký tự");
                    break;
                default:
            }
        }
        return true;
    }

    private boolean isDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    private static void makeValue(Cell cell, TbdNguoiThamDinh04DTO tbdNguoiThamDinh04DTO, int k) {
        switch (k) {
            case 0:
                break;
            case 1:
                tbdNguoiThamDinh04DTO.setFiHoTen(ExcelUtil.getString(cell));
                break;
            case 2:
                tbdNguoiThamDinh04DTO.setFiNgaySinh(ExcelUtil.getDate(cell));
                break;
            case 3:
                tbdNguoiThamDinh04DTO.setFiTrinhDoNghiepVu(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdNguoiThamDinh04DTO.setFiTrinhDoChuyenMon(ExcelUtil.getString(cell));
                break;
            case 5:
                tbdNguoiThamDinh04DTO.setFiTrinhDoNgoaiNgu(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdNguoiThamDinh04DTO.setFiThamNienCongTac(ExcelUtil.getString(cell));
                break;
            default:
        }
    }

    private static final String DATE_FORMAT = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|10|11|12)/((19|2[0-9])[0-9]{2})";
    private static Pattern DATE_PATTERN = Pattern.compile("^(29/02/(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$" +
            "|^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$" +
            "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$" +
            "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$");

    private static final String[] COLUMNS = new String[]{ "STT", "Họ và tên", "Ngày, tháng, năm sinh", "Trình độ nghiệp vụ", "Trình độ chuyên môn", "Trình độ ngoại ngữ", "Thâm niên công tác trong hoạt động xuất bản tại Việt Nam"};

}
