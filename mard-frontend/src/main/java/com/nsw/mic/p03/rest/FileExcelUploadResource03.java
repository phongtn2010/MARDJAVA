package com.nsw.mic.p03.rest;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.TbdHoSo03DTO;
import com.nsw.mic.p03.dto.TbdThietBi03DTO;
import lombok.NonNull;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(Mic03Constant.ROOT_API)
public class FileExcelUploadResource03 extends Mic03CallBack {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileExcelUploadResource03.class);

    @Autowired
    private Mic03TbdHoSo03Api mic03TbdHoSo03Api;

    @Autowired
    private Mic03TbdKetQuaXuLy03Api mic03TbdKetQuaXuLy03Api;

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
            TbdHoSo03DTO data = new TbdHoSo03DTO();
            List<TbdThietBi03DTO> tbdThietBi03DTOS = read(file.getInputStream(), data);
            if (valid(tbdThietBi03DTOS)) {

                if (idHoSo > 0) {
                    TbdHoSo03DTO tbdHoSo03DTO = mic03TbdHoSo03Api.getTbdHoSo03(idHoSo).getBody();
                    if (tbdHoSo03DTO == null)  return ResponseEntity.badRequest().body(json);
                    int tongSoBangDia = tbdHoSo03DTO.getTbdThietBi03DTOS().stream().flatMap(this::toIntArray).reduce(0, (x, y) -> x + y);
                    for (TbdThietBi03DTO p : tbdThietBi03DTOS) {
                        p.setFiIdHoSo(idHoSo);
                        tbdHoSo03DTO.getTbdThietBi03DTOS().add(p);
                    }
                    tbdHoSo03DTO.setFiTongSoXBPham(tbdHoSo03DTO.getFiTongSoXBPham() + data.getFiTongSoXBPham());
                    tbdHoSo03DTO.setFiTongSoBangDia(tongSoBangDia + data.getFiTongSoBangDia());
                    tbdHoSo03DTO = mic03TbdHoSo03Api.updateTbdHoSo03(idHoSo, tbdHoSo03DTO).getBody();
                    json.setData(tbdHoSo03DTO.getTbdThietBi03DTOS());
                    createHistory(mic03TbdKetQuaXuLy03Api, mic03TbdHoSo03Api, "Upload dữ  liệu  từ file  excel", idHoSo);
                } else {
                    for (long i = 0; i < tbdThietBi03DTOS.size(); i++) {
                        tbdThietBi03DTOS.get((int)i).setFiId(++lastID);
                    }
                    json.setData(tbdThietBi03DTOS);
                }
                json.setSuccess(true);
                json.setMessage("Upload file thành công");
            } else {
                json.setMessage("Upload file không thành công");
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            json.setMessage(ex.getMessage());
        }

        return ResponseEntity.ok(json);
    }

    private Stream<Integer> toIntArray(TbdThietBi03DTO tbdThietBi03DTO) {
        return Stream.of(tbdThietBi03DTO.getFiSoLuongBang().intValue(), tbdThietBi03DTO.getFiSoLuongDia().intValue(), tbdThietBi03DTO.getFiSoLuongCatset().intValue());
    }

    private List<TbdThietBi03DTO> read(InputStream is, @NonNull TbdHoSo03DTO tbdHoSo03DTO) throws IOException, InvalidFormatException {

        List<TbdThietBi03DTO> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        int count = 0;
        tbdHoSo03DTO.setFiTongSoBangDia(0);
        tbdHoSo03DTO.setFiTongSoXBPham(0);
        for (int i = 11; i <= listColum; i++) {
            TbdThietBi03DTO tbdThietBi03DTO = new TbdThietBi03DTO();
            Row row = sheet.getRow(i);
            count++;
            if (row == null || ExcelUtil.isRowEmpty(row)) continue;
            validCell(row, count);
            for (int k = 0; k < 14; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThietBi03DTO, k);
            }
            System.out.println(tbdThietBi03DTO.toString());
            results.add(tbdThietBi03DTO);
            tbdHoSo03DTO.setFiTongSoBangDia(tbdHoSo03DTO.getFiTongSoBangDia() + tbdThietBi03DTO.getFiSoLuongBang().intValue());
            tbdHoSo03DTO.setFiTongSoBangDia(tbdHoSo03DTO.getFiTongSoBangDia() + tbdThietBi03DTO.getFiSoLuongDia().intValue());
            tbdHoSo03DTO.setFiTongSoBangDia(tbdHoSo03DTO.getFiTongSoBangDia() + tbdThietBi03DTO.getFiSoLuongCatset().intValue());
            tbdHoSo03DTO.setFiTongSoXBPham(tbdHoSo03DTO.getFiTongSoXBPham() + tbdThietBi03DTO.getFiSoBan().intValue());
        }

        if (results.isEmpty()) {
            throw new RuntimeException("Không có dữ liệu");
        }
        return results;
    }

    private boolean valid(List<TbdThietBi03DTO> TbdThietBi03DTOS) {

        boolean check = true;

        if (ObjectUtils.isEmpty(TbdThietBi03DTOS)) return check;
        for (TbdThietBi03DTO TbdThietBi03DTO : TbdThietBi03DTOS) {
            if (!isValid(TbdThietBi03DTO)) {
                check = false;
                break;
            }
        }

        return check;
    }

    private boolean validCell(Row row, int stt) {
        for (int k = 0; k < 14; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
                throw new RuntimeException("Dòng STT = " + stt + ". Cột " + COLUMNS[k] + ". " + "Cột dữ liệu chưa đầy đủ");
            switch (k) {
                case 0:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        if (!String.valueOf(stt).equals(ExcelUtil.getString(cell)))
                            throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột STT không đúng chỉ số dòng: " + stt);
                    } else {
                        if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) throw new RuntimeException("Cột số thứ tự không đúng");
                        if (stt != ExcelUtil.getNumber(cell).intValue())
                            throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột STT không đúng chỉ số dòng: " + stt);
                    }
                    break;
                case 1:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Mã ISBN chỉ được tối đa 255 ký tự");
                    break;
                case 2:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Tên gốc của XBP chỉ được tối đa 255 ký tự");
                    break;
                case 3:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Tên xuất bản phẩm bằng tiếng Việt được tối đa 255 ký tự");
                    break;
                case 4:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Tác giả chỉ được tối đa 255 ký tự");
                    break;
                case 5:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Nhà xuất bản / Nhà cung cấp chỉ được tối đa 255 ký tự");
                    break;
                case 6:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Thể loại chỉ được tối đa 255 ký tự");
                    break;
                case 7:
                    if (!isNumber(cell))
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Số bản phải là kiểu số. Và không có dấu thập phân");
                    break;
                case 8:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 1000)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Tóm tắt nội dung chỉ được tối đa 1000 ký tự");
                    break;
                case 9:
                    if (!isNumber(cell))
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Đĩa phải là kiểu số. Và không có dấu thập phân");
                    break;
                case 10:
                    if (!isNumber(cell))
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Băng phải là kiểu số");
                    break;
                case 11:
                    if (!isNumber(cell))
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Cassette phải là kiểu số. Và không có dấu thập phân");
                    break;
                case 12:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Phạm vi sử dụng chỉ được tối đa 255 ký tự");
                    break;
                case 13:
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).length() > 255)
                        throw new RuntimeException("Dòng STT = " + stt + ". " + "Cột Hình thức khác của xuất bản phẩm chỉ được tối đa 255 ký tự");
                    break;
                default:
            }
        }
        return true;
    }

    private static void makeValue(Cell cell, TbdThietBi03DTO tbdThietBi03DTO, int k) {
        switch (k) {
            case 0:
                break;
            case 1:
                tbdThietBi03DTO.setFiMaISBN(ExcelUtil.getString(cell));
                break;
            case 2:
                tbdThietBi03DTO.setFiTenGoc(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThietBi03DTO.setFiTenTiengViet(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThietBi03DTO.setFiTenTacGia(ExcelUtil.getString(cell));
                break;
            case 5:
                tbdThietBi03DTO.setFiTenNhaCC(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdThietBi03DTO.setFiTheLoai(ExcelUtil.getString(cell));
                break;
            case 7:
                tbdThietBi03DTO.setFiSoBan(ExcelUtil.getNumber(cell).longValue());
                break;
            case 8:
                tbdThietBi03DTO.setFiTomTat(ExcelUtil.getString(cell));
                break;
            case 9:
                tbdThietBi03DTO.setFiSoLuongDia(ExcelUtil.getNumber(cell).longValue());
                break;
            case 10:
                tbdThietBi03DTO.setFiSoLuongBang(ExcelUtil.getNumber(cell).longValue());
                break;
            case 11:
                tbdThietBi03DTO.setFiSoLuongCatset(ExcelUtil.getNumber(cell).longValue());
                break;
            case 12:
                tbdThietBi03DTO.setFiPhamViSuDung(ExcelUtil.getString(cell));
                break;
            case 13:
                tbdThietBi03DTO.setFiHinhThucKhac(ExcelUtil.getString(cell));
                break;
            default:
        }
    }

    private static boolean isNumber(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            if (!ExcelUtil.getString(cell).matches("\\d{1,15}")) {
                return false;
            }
        }
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            String number = String.valueOf(cell.getNumericCellValue());

            if (!number.matches("\\d{1,15}(\\.0)?")) {
                return false;
            }
        }
        return true;
    }
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private static final String[] COLUMNS = new String[]{ "STT", "Mã ISBN", "Tên gốc của XBP", "Tên xuất bản phẩm bằng tiếng Việt", "Tác giả", "Nhà xuất bản / Nhà cung cấp", "Thể loại", "Số  bản", "Tóm tắt nội dung", "Đĩa", "Băng", "Cassette", "Phạm vi sử dụng", "Hình thức khác của xuất bản phẩm"};

}
