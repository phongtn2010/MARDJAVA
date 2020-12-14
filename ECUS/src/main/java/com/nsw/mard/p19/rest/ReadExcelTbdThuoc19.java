package com.nsw.mard.p19.rest;

import com.nsw.mard.p19.model.TbdThuoc19;
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

public class ReadExcelTbdThuoc19 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTbdThuoc19.class);

    public static List<TbdThuoc19> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc19> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);

        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc19 tbdThuoc19 = new TbdThuoc19();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                //throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 18; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc19, k);
            }
            results.add(tbdThuoc19);
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



    private static void makeValue(Cell cell, TbdThuoc19 tbdThuoc19, int k) {
        switch (k) {
            case 0:
                tbdThuoc19.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                String type = ExcelUtil.getString(cell);
                tbdThuoc19.setFiProductType(Integer.valueOf(type.split("\\|")[0].trim().replaceAll("\\D", "")));
                break;
            case 2:
                tbdThuoc19.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc19.setFiManufacturerName(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThuoc19.setFiCirculationNo(ExcelUtil.getString(cell));
                break;
            case 5:
                tbdThuoc19.setFiDocumentNo(ExcelUtil.getString(cell));
                break;
            case 6:
                tbdThuoc19.setFiSerialNo(ExcelUtil.getString(cell));
                break;
            case 7:
                tbdThuoc19.setFiTypeOfPackage(ExcelUtil.getString(cell));
                break;
            case 8:
                tbdThuoc19.setFiWeight(ExcelUtil.getNumber(cell));
                break;
            case 9:
                String unit = ExcelUtil.getString(cell);
                String[] arr = unit.split("\\|");
                if (arr.length != 2) throw  new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc19.setFiWeightUnitCode(arr[0].trim());
                tbdThuoc19.setFiWeightUnitName(arr[1].trim());
                break;
            case 10:
                tbdThuoc19.setFiWeightKG(ExcelUtil.getNumber(cell));
                break;
            case 11:
                tbdThuoc19.setFiWeightML(ExcelUtil.getNumber(cell));
                break;
            case 12:
                String country = ExcelUtil.getString(cell);
                String[] countries = country.split("\\|");
                if (countries.length != 2 ) throw new RuntimeException("Gia tri nhap khong dung dinh dang!");
                tbdThuoc19.setFiCountryCode(countries[0].trim());
                tbdThuoc19.setFiCountryName(countries[1].trim());
                break;
            case 13:
                tbdThuoc19.setFiGate(ExcelUtil.getString(cell));
                break;

            case 14:

                try {
                    tbdThuoc19.setFiImportTimeFrom(ExcelUtil.convertStringToDateExcel(String.valueOf(cell)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 15:

                try {
                    tbdThuoc19.setFiImportTimeTo(ExcelUtil.convertStringToDateExcel(String.valueOf(cell)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 16:
                tbdThuoc19.setFiActiveIngredient(ExcelUtil.getString(cell));
                break;

            case 17:
                tbdThuoc19.setFiLicenseFileNo(ExcelUtil.getString(cell));
                break;

        }
    }
}
