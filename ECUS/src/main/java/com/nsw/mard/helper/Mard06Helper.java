package com.nsw.mard.helper;

import com.nsw.mard.p6.model.TbdCssx06;
import com.nsw.mard.p6.model.TbdCtyxk06;
import com.nsw.mard.p6.model.TbdDdclkd06;
import com.nsw.mard.p6.model.TbdHanghoa06;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Mard06Helper {

    private Mard06Helper() {
    }

    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String TMP_FOLDER = USER_DIRECTORY + "/tmp";

    public static File saveMultipartFileToTmpFolder(MultipartFile file) throws IOException {
        return saveInputstreamToTmpFolder(file.getOriginalFilename(), file.getInputStream());
    }

    public static File saveInputstreamToTmpFolder(String fileName, InputStream inputStream) throws IOException {
        File root = new File(TMP_FOLDER);
        if (!root.exists()) {
            root.mkdirs();
        }
        File currentFile = new File(root, fileName);
        FileOutputStream fos = new FileOutputStream(currentFile);
        IOUtils.copy(inputStream, fos);
        fos.flush();
        fos.close();
        return currentFile;
    }

    public static List<TbdHanghoa06> readProductFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listRow = ExcelUtil.getLastRowWithData(sheet);

        List<TbdHanghoa06> result = new ArrayList<>();
        for (int i = 1; i <= listRow; i++) {
            Row row = sheet.getRow(i);
            TbdHanghoa06 tbdHangHoa6 = new TbdHanghoa06();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k < 7; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueProduct(cellValue, tbdHangHoa6, k);
            }
            result.add(tbdHangHoa6);
        }

        return result;
    }

    private static void makeValueProduct(String cellValue, TbdHanghoa06 tbdHangHoa6, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdHangHoa6.setFiProductBusinessName(cellValue);
                break;
            case 2:
                tbdHangHoa6.setFiProductScienceName(cellValue);
                break;
            case 3:
                tbdHangHoa6.setFiSizeOrType(cellValue);
                break;
            case 4:
                tbdHangHoa6.setFiQuantity(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 5:
                tbdHangHoa6.setFiPackageUnitName(cellValue);
                break;
            case 6:
                tbdHangHoa6.setFiOriginCountryName(cellValue);
                break;
        }
    }

    public static List<TbdCtyxk06> readExporterFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdCtyxk06> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdCtyxk06 tbdCtyxk06 = new TbdCtyxk06();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k < 3; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueExporter(cellValue, tbdCtyxk06, k);
            }
            result.add(tbdCtyxk06);
        }

        return result;
    }

    private static void makeValueExporter(String cellValue, TbdCtyxk06 tbdCtyxk06, int k) {
        switch (k) {
            case 1:
                tbdCtyxk06.setFiExporterCountryName(cellValue);
                break;
            case 2:
                tbdCtyxk06.setFiExporterCountryAddress(cellValue);
                break;
        }
    }

    public static List<TbdCssx06> readProcessingFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdCssx06> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdCssx06 tbdCssx06 = new TbdCssx06();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k < 4; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueProcessing(cellValue, tbdCssx06, k);
            }
            result.add(tbdCssx06);
        }

        return result;
    }

    private static void makeValueProcessing(String cellValue, TbdCssx06 tbdCssx06, int k) {
        switch (k) {
            case 1:
                tbdCssx06.setFiProcessingName(cellValue);
                break;
            case 2:
                tbdCssx06.setFiProcessingAddress(cellValue);
                break;
            case 3:
                tbdCssx06.setFiProcessingApprovalNumber(cellValue);
                break;
        }
    }

    public static List<TbdDdclkd06> readQuaratineFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdDdclkd06> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdDdclkd06 tbdDdclkd06 = new TbdDdclkd06();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k < 4; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueQuaratine(cellValue, tbdDdclkd06, k);
            }
            result.add(tbdDdclkd06);
        }

        return result;
    }

    private static void makeValueQuaratine(String cellValue, TbdDdclkd06 tbdDdclkd06, int k) {
        switch (k) {
            case 1:
                tbdDdclkd06.setFiLocationQuarantineName(cellValue);
                break;
            case 2:
                tbdDdclkd06.setFiLocationQuarantineAddress(cellValue);
                break;
        }
    }
}
