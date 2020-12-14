package com.nsw.mard.p18.rest;

import com.nsw.mard.p18.model.TbdThuoc18;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import schemasMicrosoftComVml.STExt;

import java.io.*;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadExcelTbdThuoc18 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTbdThuoc18.class);

    public static List<TbdThuoc18> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc18> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc18 tbdThuoc18 = new TbdThuoc18();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                //throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 18; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc18, k);
            }
            results.add(tbdThuoc18);
        }
        return results;
    }

    private static boolean validCell(Row row) {
        boolean check = true;
        for (int k = 0; k < 18; k++) {
            Cell cell = row.getCell(k);
            if (cell == null) continue;
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return false;
            switch (k) {
                case 0: case 8:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
                case 14:
                    LOGGER.info("CellStyle: {}", cell.getCellType());

                default:
            }
        }
        return check;
    }



    private static void makeValue(Cell cell, TbdThuoc18 tbdThuoc18, int k) {
        switch (k) {
            case 0:
                tbdThuoc18.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                String type = ExcelUtil.getString(cell);
                tbdThuoc18.setFiProductType(Integer.valueOf(type.split("\\|")[0].trim().replaceAll("\\D", "")));
                break;
            case 2:
                tbdThuoc18.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc18.setFiManufacturerName(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThuoc18.setFiCirculationNo(ExcelUtil.getString(cell));
                break;
            case 5:
                tbdThuoc18.setFiDocumentNo(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdThuoc18.setFiSerialNo(ExcelUtil.getString(cell));
                break;
            case 7:
                tbdThuoc18.setFiTypeOfPackage(ExcelUtil.getString(cell));
                break;
            case 8:
                tbdThuoc18.setFiWeight(ExcelUtil.getNumber(cell));
                break;
            case 9:
                String unit = ExcelUtil.getString(cell);
                String[] arr = unit.split("\\|");
                if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc18.setFiWeightUnitCode(arr[0].trim());
                tbdThuoc18.setFiWeightUnitName(arr[1].trim());
                break;
            case 10:
                tbdThuoc18.setFiWeightKG(ExcelUtil.getNumber(cell));
                break;
            case 11:
                tbdThuoc18.setFiWeightML(ExcelUtil.getNumber(cell));
                break;
            case 12:
                String country = ExcelUtil.getString(cell);
                String[] countries = country.split("\\|");
                if (countries.length != 2 ) throw new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc18.setFiCountryCode(countries[0].trim());
                tbdThuoc18.setFiCountryName(countries[1].trim());
                break;
            case 13:
                tbdThuoc18.setFiGate(ExcelUtil.getString(cell));
                break;

            case 14:

                try {
                    tbdThuoc18.setFiImportTimeFrom(ExcelUtil.convertStringToDateExcel(String.valueOf(cell)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 15:

                try {
                    tbdThuoc18.setFiImportTimeTo(ExcelUtil.convertStringToDateExcel(String.valueOf(cell)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 16:
                tbdThuoc18.setFiActiveIngredient(ExcelUtil.getString(cell));
                break;

            case 17:
                tbdThuoc18.setFiLicenseFileNo(ExcelUtil.getString(cell));
                break;

        }
    }
}
