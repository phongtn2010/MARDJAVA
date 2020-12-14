package com.nsw.mard.p17.rest;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;

public class ExcelUtil {

    public static final String TILE17 = "Danh sách nhập thông tin thuốc Thú y";
    public static final String TILE15 = "Danh sách nhập thông tin nguồn gen";
    public static final String TILE16 = "Danh sách nhập thông tin giống cây trồng";
    public static void addDataVaditation(Sheet sheet, String name, int firstRow, int lastRow, int firstCol, int lastCol, int... types) {
        DataValidationHelper validationHelper = sheet.getDataValidationHelper();
        DataValidationConstraint explicitListConstraint = null;
        if (types != null && types.length > 0) {
            explicitListConstraint = validationHelper.createNumericConstraint(XSSFDataValidationConstraint.ValidationType.DECIMAL,
                    XSSFDataValidationConstraint.OperatorType.BETWEEN,
                    String.valueOf(Float.MIN_VALUE),
                    String.valueOf(Float.MAX_VALUE));
        } else {
            explicitListConstraint = validationHelper.createFormulaListConstraint(name);
        }
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidation validation = validationHelper.createValidation(explicitListConstraint, regions);
        validation.setSuppressDropDownArrow(true);
        if (types != null && types.length > 0) {
            validation.createErrorBox("Error","Bạn chưa nhập đúng giá trị số" );
        } else {
            validation.createErrorBox("Error","Bạn chưa chọn đúng giá trị" );
        }

        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);

    }


    public static Cell createCell(Workbook workbook, Row row, int index, String value, short... textAlign) {
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        if (textAlign != null && textAlign.length > 2) {
            headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        }

        CellStyle headerCellStyle = workbook.createCellStyle();
        if (textAlign != null && textAlign.length > 0) {
            headerCellStyle.setAlignment(textAlign[0]);
        }
        headerCellStyle.setFont(headerFont);
        if (textAlign != null && textAlign.length > 0) {
            headerCellStyle.setAlignment(textAlign[0]);
        }
        if (textAlign != null && textAlign.length > 1) {
            headerCellStyle.setVerticalAlignment(textAlign[1]);
        }

        Font font = workbook.createFont();
        font.setFontName("Arial");
        headerCellStyle.setFont(font);


        headerCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

        headerCellStyle.setWrapText(true);
        Cell cell = row.createCell(index);

        if (value != null)
            cell.setCellValue(value);
        cell.setCellStyle(headerCellStyle);
        return cell;
    }

    public static void setRegionBorderWithMedium(CellRangeAddress region, Sheet sheet) {
        Workbook wb = sheet.getWorkbook();
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, region, sheet, wb);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, region, sheet, wb);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, region, sheet, wb);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, region, sheet, wb);
    }

    public static void setRegionBorderWithNormal(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        Workbook wb = sheet.getWorkbook();
        CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
        RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, region, sheet, wb);
        RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, region, sheet, wb);
        RegionUtil.setBorderRight(CellStyle.BORDER_THIN, region, sheet, wb);
        RegionUtil.setBorderTop(CellStyle.BORDER_THIN, region, sheet, wb);
    }

    public static void mergeCell(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
        sheet.addMergedRegion(region);
    }

    public static boolean isRowEmpty(Row row) {
        int countCellBlank = 0;
        for (int k = 0; k < row.getLastCellNum(); k++) {
            Cell cell = row.getCell(k);
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) countCellBlank++;
        }
        return countCellBlank == row.getLastCellNum();
    }

    public static Object getValue(Cell cell) {
        if (cell == null) return null;
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return cell.getNumericCellValue();
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) return cell.getBooleanCellValue();
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
        return null;
    }

    public static String getString(Cell cell) {
        if (cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        String val = formatter.formatCellValue(cell);
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return val;
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) return String.valueOf(cell.getBooleanCellValue());
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) return String.valueOf(cell.getStringCellValue());
        return "";
    }

    public static Double getNumber(Cell cell) {
        if (cell == null) return 0D;
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return cell.getNumericCellValue();
        return 0D;
    }

}
