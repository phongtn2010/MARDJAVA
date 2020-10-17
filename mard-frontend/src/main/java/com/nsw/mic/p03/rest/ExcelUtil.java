package com.nsw.mic.p03.rest;

import com.nsw.annotations.DecimalNumber;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    public static final String TILE14 = "Danh sách nhập thông tin thuốc BVTV";
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


    public static Cell createCell(Workbook workbook, Row row, int index, String value, short textAlign, short fontSize, boolean border, boolean italic, boolean underline) {
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(textAlign);
        headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBoldweight(fontSize);
        font.setItalic(italic);
        if (underline)
         font.setUnderline(HSSFFont.U_SINGLE);
        headerCellStyle.setFont(font);
        if (border) {
            headerCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            headerCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            headerCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            headerCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        }

        headerCellStyle.setWrapText(true);
        Cell cell = row.createCell(index);

        if (value != null)
            cell.setCellValue(value);
        cell.setCellStyle(headerCellStyle);
//        row.setHeight( (short) 800);
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
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return String.valueOf(cell.getNumericCellValue());
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) return String.valueOf(cell.getBooleanCellValue());
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) return String.valueOf(cell.getStringCellValue());
        return "";
    }

    public static Double getNumber(Cell cell) {
        if (cell == null) return 0D;
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) return cell.getNumericCellValue();
        return 0D;
    }

    public static Date getDate(Cell cell) {
        if (cell == null) return null;
        try {
            if (cell.getCellType() == Cell.CELL_TYPE_STRING && ExcelUtil.getString(cell).matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
                return new SimpleDateFormat("dd/MM/yyyy").parse(ExcelUtil.getString(cell));
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                return cell.getDateCellValue();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return null;
    }

    public static Row createRow(Sheet sheet, int index) {
        return sheet.createRow(index);
    }

    public static String formatNumberInt(int number, int so) {
        String pattern = "#";
        for (int i = 1; i < so; i++) pattern += "#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
}