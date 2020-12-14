package com.nsw.mard.p15.rest;

import com.nsw.mard.p14.rest.ExcelUtil;
import com.nsw.mard.p15.model.TbdThuoc15;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class ReadExcelTbdThuoc15 {


    public static List<TbdThuoc15> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc15> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc15 tbdThuoc15 = new TbdThuoc15();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 11; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc15, k);
            }


            tbdThuoc15.setFiIdHoSo(0L);
            results.add(tbdThuoc15);
        }
        return results;
    }

    private static boolean validCell(Row row) {
        boolean check = true;
        for (int k = 0; k < 11; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return false;
            switch (k) {
                case 0: case 8:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
                    default:
            }
        }
        return check;
    }

    private static void makeValue(Cell cell, TbdThuoc15 tbdThuoc15, int k) {
        switch (k) {
            case 0:
                tbdThuoc15.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                tbdThuoc15.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 2:
                tbdThuoc15.setFiNameSicenceOfGoods(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc15.setFiSpecies(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThuoc15.setFiOriginal(ExcelUtil.getString(cell));
                break;
            case 5:
                tbdThuoc15.setFiDateCollect(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdThuoc15.setFiOrganization(ExcelUtil.getString(cell));
                break;
            case 7:
                tbdThuoc15.setFiType(ExcelUtil.getString(cell));
                break;
            case 8:
                tbdThuoc15.setFiQuantity(ExcelUtil.getNumber(cell));
                break;
            case 9:
                String unit = ExcelUtil.getString(cell);
                String[] arr = unit.split("\\|");
                if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc15.setFiQuantityUnitCode(arr[0].trim());
                tbdThuoc15.setFiQuantityUnitName(arr[1].trim());
                break;
            case 10:
                tbdThuoc15.setFiGateOfImportationName(ExcelUtil.getString(cell));
                break;
                default:

        }
    }


}
