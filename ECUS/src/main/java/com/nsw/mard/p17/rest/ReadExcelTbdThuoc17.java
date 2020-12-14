package com.nsw.mard.p17.rest;

import com.nsw.mard.p17.model.TbdThuoc17;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class ReadExcelTbdThuoc17 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTbdThuoc17.class);

    public static List<TbdThuoc17> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc17> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc17 tbdThuoc17 = new TbdThuoc17();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 10; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc17, k, evaluator);
            }



            results.add(tbdThuoc17);
        }
        return results;
    }

    private static boolean validCell(Row row) {
        boolean check = true;
        for (int k = 0; k < 10; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            //if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return false;
            switch (k) {
                case 0: case 7:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC && cell.getCellType() != Cell.CELL_TYPE_FORMULA) check = false;
                    break;
                default:
            }
        }
        return check;
    }

    private static void makeValue(Cell cell, TbdThuoc17 tbdThuoc17, int k, FormulaEvaluator evaluator) {

        switch (k) {
            case 0:
                tbdThuoc17.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                String type = ExcelUtil.getString(cell);
                tbdThuoc17.setFiProductType(Integer.valueOf(type.split("\\|")[0].trim().replaceAll("\\D", "")));
                break;
            case 2:
                tbdThuoc17.setFiNameOfProduct(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc17.setFiSerialNo(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThuoc17.setFiManufacturerName(ExcelUtil.getString(cell));
                break;

            case 5:
                String country = ExcelUtil.getString(cell);
                String[] countries = country.split("\\|");
                if (countries.length != 2 ) throw new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc17.setFiCountryCode(countries[0].trim());
                tbdThuoc17.setFiCountryName(countries[1].trim());
                break;

            case 6:
                String unit = ExcelUtil.getString(cell);
                String[] arr = unit.split("\\|");
                if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc17.setFiWeightUnitCode(arr[0].trim());
                tbdThuoc17.setFiWeightUnitName(arr[1].trim());
                break;

            case 7:
                if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                    tbdThuoc17.setFiWeight(ExcelUtil.getNumber(evaluator.evaluateInCell(cell)));
                }
                else {
                tbdThuoc17.setFiWeight(ExcelUtil.getNumber(cell));}
                break;

            case 8:
                if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                    tbdThuoc17.setFiTotal(ExcelUtil.getNumber(evaluator.evaluateInCell(cell)));
                }
                else {
                    tbdThuoc17.setFiTotal(ExcelUtil.getNumber(cell));
                }
                break;
            case 9:
                String currency = ExcelUtil.getString(cell);
                if(currency != null && !currency.isEmpty()) {
                    String[] currencies = currency.split("\\|");
                    if (currencies.length != 2) throw new RuntimeException("Gia tri nhap khong dung dinh dang!");
                    tbdThuoc17.setFiMoneyUnitCode(currencies[0].trim());
                }
                else {
                    tbdThuoc17.setFiMoneyUnitCode(null);
                }
                //tbdThuoc17.setFiMoneyUnitName(currencies[1].trim());
                break;
                default:
        }
    }


}
