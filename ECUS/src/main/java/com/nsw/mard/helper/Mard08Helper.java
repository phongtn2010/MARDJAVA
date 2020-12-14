package com.nsw.mard.helper;

import com.nsw.mard.p8.model.*;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Mard08Helper {

    private Mard08Helper() {

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

    public static List<Tbdhanghoa08> readAnimalFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdhanghoa08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdhanghoa08 tbdhanghoa08 = new Tbdhanghoa08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 6; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimal(cellValue, tbdhanghoa08, k);
            }
            result.add(tbdhanghoa08);
        }

        return result;
    }

    private static void makeValueAnimal(String cellValue, Tbdhanghoa08 tbdhanghoa08, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdhanghoa08.setFiProductName(cellValue);
                break;
            case 2:
                tbdhanghoa08.setFiQtyMale(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).intValue());
                break;
            case 3:
                tbdhanghoa08.setFiQtyFemale(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).intValue());
                break;
            case 4:
                tbdhanghoa08.setFiUnitCode(cellValue);
                break;
            case 5:
                tbdhanghoa08.setFiCountryOrigin(cellValue);
                break;
            case 6:
                tbdhanghoa08.setFiPortName(cellValue);
                break;
        }
    }

    public static List<Tbdhanghoa08> readAnimalProductFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdhanghoa08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdhanghoa08 tbdhanghoa08 = new Tbdhanghoa08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 5; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimalProduct(cellValue, tbdhanghoa08, k);
            }
            result.add(tbdhanghoa08);
        }

        return result;
    }

    private static void makeValueAnimalProduct(String cellValue, Tbdhanghoa08 tbdhanghoa08, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdhanghoa08.setFiProductName(cellValue);
                break;
            case 2:
                tbdhanghoa08.setFiNumber(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 3:
                tbdhanghoa08.setFiUnitCode(cellValue);
                break;
            case 4:
                tbdhanghoa08.setFiCountryOrigin(cellValue);
                break;
            case 5:
                tbdhanghoa08.setFiPortName(cellValue);
                break;
        }
    }

    public static List<Tbdhanghoa08> readAnimal20aFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdhanghoa08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdhanghoa08 tbdhanghoa08 = new Tbdhanghoa08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 5; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimal20a(cellValue, tbdhanghoa08, k);
            }
            result.add(tbdhanghoa08);
        }

        return result;
    }

    private static void makeValueAnimal20a(String cellValue, Tbdhanghoa08 tbdhanghoa08, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdhanghoa08.setFiProductName(cellValue);
                break;
            case 2:
                tbdhanghoa08.setFiProductScienceName(cellValue);
                break;
            case 3:
                tbdhanghoa08.setFiNumber(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 4:
                tbdhanghoa08.setFiCountryOrigin(cellValue);
                break;
            case 5:
                tbdhanghoa08.setFiCirculateNo(cellValue);
                break;
        }
    }

    public static List<Tbdhanghoa08> readAnimalProduct20aFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdhanghoa08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdhanghoa08 tbdhanghoa08 = new Tbdhanghoa08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 11; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimalProduct20a(cellValue, tbdhanghoa08, k);
            }
            result.add(tbdhanghoa08);
        }

        return result;
    }

    private static void makeValueAnimalProduct20a(String cellValue, Tbdhanghoa08 tbdhanghoa08, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdhanghoa08.setFiProductName(cellValue);
                break;
            case 2:
                tbdhanghoa08.setFiProductScienceName(cellValue);
                break;
            case 3:
                tbdhanghoa08.setFiNumber(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 4:
                tbdhanghoa08.setFiUnitCode(cellValue);
                break;
            case 5:
                tbdhanghoa08.setFiPackingType(cellValue);
                break;
            case 6:
                tbdhanghoa08.setFiNetWeight(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 7:
                tbdhanghoa08.setFiNWUnitCode(cellValue);
                break;
            case 8:
                tbdhanghoa08.setFiGrossWeight(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 9:
                tbdhanghoa08.setFiGWUnitCode(cellValue);
                break;
            case 10:
                tbdhanghoa08.setFiCountryOrigin(cellValue);
                break;
            case 11:
                tbdhanghoa08.setFiCirculateNo(cellValue);
                break;
        }
    }

    public static List<Tbdctyxk08> readExporterFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdctyxk08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdctyxk08 tbdctyxk08 = new Tbdctyxk08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 2; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueExporter(cellValue, tbdctyxk08, k);
            }
            result.add(tbdctyxk08);
        }

        return result;
    }

    private static void makeValueExporter(String cellValue, Tbdctyxk08 tbdctyxk08, int k) {
        switch (k) {
            case 1:
                tbdctyxk08.setFiExporterName(cellValue);
                break;
            case 2:
                tbdctyxk08.setFiExporterAddress(cellValue);
                break;
        }
    }

    public static List<Tbdddclkd08> readQuaratineFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdddclkd08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdddclkd08 tbdddclkd08 = new Tbdddclkd08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 2; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueQuaratine(cellValue, tbdddclkd08, k);
            }
            result.add(tbdddclkd08);
        }

        return result;
    }

    private static void makeValueQuaratine(String cellValue, Tbdddclkd08 tbdddclkd08, int k) {
        switch (k) {
            case 1:
                tbdddclkd08.setFiIsoLocName(cellValue);
                break;
            case 2:
                tbdddclkd08.setFiIsoLocAddress(cellValue);
                break;
        }
    }

    public static List<Tbdcssxsp08> readProdMfrFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdcssxsp08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdcssxsp08 tbdcssxsp08 = new Tbdcssxsp08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 3; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueProdMfr(cellValue, tbdcssxsp08, k);
            }
            result.add(tbdcssxsp08);
        }

        return result;
    }

    private static void makeValueProdMfr(String cellValue, Tbdcssxsp08 tbdcssxsp08, int k) {
        switch (k) {
            case 1:
                tbdcssxsp08.setFiMfrName(cellValue);
                break;
            case 2:
                tbdcssxsp08.setFiMfrAddress(cellValue);
                break;
            case 3:
                tbdcssxsp08.setFiMfrCountryrigin(cellValue);
                break;
        }
    }

    public static List<Tbdnmsx08> readMfgFactoryFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdnmsx08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdnmsx08 tbdnmsx08 = new Tbdnmsx08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 3; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueMfgFactory(cellValue, tbdnmsx08, k);
            }
            result.add(tbdnmsx08);
        }

        return result;
    }

    private static void makeValueMfgFactory(String cellValue, Tbdnmsx08 tbdnmsx08, int k) {
        switch (k) {
            case 1:
                tbdnmsx08.setFiFactoryName(cellValue);
                break;
            case 2:
                tbdnmsx08.setFiFactoryAddress(cellValue);
                break;
        }
    }

    public static List<Tbdctyxk08> readBuyerFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<Tbdctyxk08> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            Tbdctyxk08 tbdctyxk08 = new Tbdctyxk08();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 5; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueBuyer(cellValue, tbdctyxk08, k);
            }
            result.add(tbdctyxk08);
        }

        return result;
    }

    private static void makeValueBuyer(String cellValue, Tbdctyxk08 tbdctyxk08, int k) {
        switch (k) {
            case 1:
                tbdctyxk08.setFiExporterName(cellValue);
                break;
            case 2:
                tbdctyxk08.setFiCountryOrigin(cellValue);
                break;
            case 3:
                tbdctyxk08.setFiExporterTel(cellValue);
                break;
            case 4:
                tbdctyxk08.setFiExporterFax(cellValue);
                break;
            case 5:
                tbdctyxk08.setFiExporterAddress(cellValue);
                break;
        }
    }
}
