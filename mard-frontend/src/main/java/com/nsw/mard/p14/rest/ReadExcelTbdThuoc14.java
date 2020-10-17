package com.nsw.mard.p14.rest;

import com.nsw.mard.p14.model.TbdThuoc14;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ReadExcelTbdThuoc14 {


    public static List<TbdThuoc14> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc14> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc14 tbdThuoc14 = new TbdThuoc14();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 7; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc14, k);
            }



            results.add(tbdThuoc14);
        }
        return results;
    }

    private static boolean validCell(Row row) {
        boolean check = true;
        for (int k = 0; k < 7; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return false;
            switch (k) {
                case 0: case 3:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
                default:
            }
        }
        return check;
    }



    private static void makeValue(Cell cell, TbdThuoc14 tbdThuoc14, int k) {
        switch (k) {
            case 0:
                tbdThuoc14.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                String type = ExcelUtil.getString(cell);
                tbdThuoc14.setFiTypeGood(Integer.valueOf(type.split("\\|")[0].trim().replaceAll("\\D", "")));
                break;
            case 2:
                tbdThuoc14.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc14.setFiWeight(ExcelUtil.getNumber(cell));
                break;
            case 4:
                String unit = ExcelUtil.getString(cell);
                String[] arr = unit.toString().split("\\|");
                if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc14.setFiWeightUnitCode(arr[0].trim());
                tbdThuoc14.setFiWeightUnitName(arr[1].trim());
                break;
            case 5:
                tbdThuoc14.setFiMainUse(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdThuoc14.setFiOrigin(ExcelUtil.getString(cell));
                break;
                default:
        }
    }


}
