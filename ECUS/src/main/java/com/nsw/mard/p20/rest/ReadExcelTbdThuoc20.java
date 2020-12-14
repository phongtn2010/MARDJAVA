package com.nsw.mard.p20.rest;

import com.nsw.mard.p20.model.TbdThuoc20;
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

public class ReadExcelTbdThuoc20 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTbdThuoc20.class);

    public static List<TbdThuoc20> read(InputStream is) throws IOException, InvalidFormatException {

        List<TbdThuoc20> results = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(is);

        Sheet sheet = workbook.getSheetAt(0);
        int listColum  = sheet.getLastRowNum();
        for (int i = 2; i <= listColum; i++) {
            TbdThuoc20 tbdThuoc20 = new TbdThuoc20();
            Row row = sheet.getRow(i);
            if (row == null) continue;
            if (ExcelUtil.isRowEmpty(row)) continue;
            if (!validCell(row)) {
                throw new RuntimeException("Sai kieu du lieu!");
            }
            for (int k = 0; k < 7; k++) {
                Cell cell = row.getCell(k);
                if (cell == null) continue;
                makeValue(cell, tbdThuoc20, k);
            }



            results.add(tbdThuoc20);
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
                case 0:
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) check = false;
                    break;
                default:
            }
        }
        return check;
    }
    private static void makeValue(Cell cell, TbdThuoc20 tbdThuoc20, int k) {
        switch (k) {
            case 0:
                tbdThuoc20.setFiSort(ExcelUtil.getNumber(cell).intValue());
                break;
            case 1:
                tbdThuoc20.setFiNameOfGoods(ExcelUtil.getString(cell));
                break;
            case 2:
                tbdThuoc20.setFiDosageType(ExcelUtil.getString(cell));
                break;
            case 3:
                tbdThuoc20.setFiCirculationNo(ExcelUtil.getString(cell));
                break;
            case 4:
                tbdThuoc20.setFiImporterName(ExcelUtil.getString(cell));
                break;

            case 5:
                tbdThuoc20.setFiManufacturerName(ExcelUtil.getString(cell));
                break;

            case 6:
                tbdThuoc20.setFiTestResult(ExcelUtil.getString(cell));
                break;
            default:
        }
    }
}
