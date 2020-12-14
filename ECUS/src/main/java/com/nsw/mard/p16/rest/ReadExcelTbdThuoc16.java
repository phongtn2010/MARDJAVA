package com.nsw.mard.p16.rest;

import com.nsw.mard.p14.rest.ExcelUtil;
import com.nsw.mard.p16.model.TbdThuoc16;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;

public class ReadExcelTbdThuoc16 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTbdThuoc16.class);

    public static List<TbdThuoc16> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc16> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc16 tbdThuoc16 = new TbdThuoc16();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 8; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc16, k);
            }
            tbdThuoc16.setFiIdHoSo(0L);
            results.add(tbdThuoc16);
        }
        return results;
    }

    private static boolean validCell(Row row) {
        boolean check = true;
        for (int k = 0; k < 8; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return false;
            switch (k) {
                case 0: case 4:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
            }
        }
        return check;
    }

    private static void makeValue(Cell cell, TbdThuoc16 tbdThuoc16, int k) {
        switch (k) {
            case 0:
                tbdThuoc16.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                tbdThuoc16.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 2:
                tbdThuoc16.setFiNameSicenceOfGoods((String)getValue(cell));
                break;
            case 3:
                tbdThuoc16.setFiType((String) getValue(cell));
                break;
            case 4:
                tbdThuoc16.setFiQuantity((Double)getValue(cell));
                break;
            case 5:
                String unit = ExcelUtil.getString(cell);
                String[] units = unit.split("\\|");
                if (units.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc16.setFiQuantityUnitCode(units[0].trim());
                tbdThuoc16.setFiQuantityUnitName(units[1].trim());
                break;
            case 6:
                String exporterCode = ExcelUtil.getString(cell);
                String[] exporterCodes = exporterCode.split("\\|");
                if (exporterCodes.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc16.setFiExporterCode(exporterCodes[0].trim());
                tbdThuoc16.setFiExporterName(exporterCodes[1].trim());
                break;
            case 7:
                tbdThuoc16.setFiGateOfImportation((String) getValue(cell));
                break;
                default:

        }
    }

    private static Object getValue(Cell cell) {
        if (cell == null) return null;
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return cell.getNumericCellValue();
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) return cell.getBooleanCellValue();
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
        return null;
    }


}
