package com.nsw.mard.p16.rest;

import com.nsw.mard.p16.model.TbdToKhaiKyThuat16;
import com.nsw.mard.p16.model.TbdToKhaiKyThuat16;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class ReadExcelTbdToKhaiKyThua16 {


    public static List<TbdToKhaiKyThuat16> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdToKhaiKyThuat16> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 1; i <= listColum; i++) {
            TbdToKhaiKyThuat16 tbdThuoc16 = new TbdToKhaiKyThuat16();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 12; k++) {
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
        for (int k = 0; k < 12; k++) {
            Cell cell = row.getCell(k);
            switch (k) {
                case 0:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
                case  1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) check = false;
                    break;
                    default:
            }
        }
        return check;
    }

    private static void makeValue(Cell cell, TbdToKhaiKyThuat16 tbdThuoc16, int k) {
        Object data = getValue(cell);
        switch (k) {
            case 0:
                if (data != null) {
                    tbdThuoc16.setFiSortDeclaration(((Double)data).intValue());
                }
                break;
            case 1:
                tbdThuoc16.setFiNameOfGoodsDeclaration((String)getValue(cell));
                break;
            case 2:
                tbdThuoc16.setFiNameSicenceOfGoodsDeclaration((String)getValue(cell));
                break;
            case 3:
                tbdThuoc16.setFiDescription((String) getValue(cell));
                break;
            case 4:
                if (data != null) {
                    String[] arr = data.toString().split("\\|");
                    if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                    tbdThuoc16.setFiPartUsed(arr[1].trim());
                }
                break;
            case 5:
                if (data != null) {
                    String[] arr = data.toString().split("\\|");
                    if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                    tbdThuoc16.setFiUsingValue(arr[1].trim());
                }
                break;
            case 6:
                tbdThuoc16.setFiOtherValueSpecified((String) getValue(cell));
                break;
            case 7:
                tbdThuoc16.setFiRequiredEcological((String) getValue(cell));
                break;
            case 8:
                tbdThuoc16.setFiPlantingSeason((String) getValue(cell));
                break;
            case 9:
                tbdThuoc16.setFiDensity((String) getValue(cell));
                break;
            case 10:
                tbdThuoc16.setFiMainDiseases((String) getValue(cell));
                break;
            case 11:
                tbdThuoc16.setFiWarnings((String) getValue(cell));
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
