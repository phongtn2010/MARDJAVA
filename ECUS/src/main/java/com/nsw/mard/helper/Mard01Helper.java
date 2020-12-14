package com.nsw.mard.helper;

import com.nsw.mard.p1.model.TbdAnimal01;
import com.nsw.mard.p1.model.TbdAnimalProduct01;
import com.nsw.mard.p1.model.TbdTest01;
import com.nsw.mard.p1.model.TbdVaccin01;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Mard01Helper {

    public static List<TbdAnimal01> readAnimalFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdAnimal01> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdAnimal01 tbdAnimal01 = new TbdAnimal01();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 13; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimal(cellValue, tbdAnimal01, k);
            }
            result.add(tbdAnimal01);
        }

        return result;
    }

    private static void makeValueAnimal(String cellValue, TbdAnimal01 tbdAnimal01, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdAnimal01.setFiAnimalTypeVni(cellValue);
                break;
            case 2:
                tbdAnimal01.setFiAnimalType(cellValue);
                break;
            case 3:
                tbdAnimal01.setFiHSCode(cellValue);
                break;
            case 4:
                tbdAnimal01.setFiBreedVni(cellValue);
                break;
            case 5:
                tbdAnimal01.setFiBreed(cellValue);
                break;
            case 6:
                tbdAnimal01.setFiAge(cellValue);
                break;
            case 7:
                tbdAnimal01.setFiSex((cellValue == "Đực" || cellValue == "đực") ? 1 : 2);
                break;
            case 8:
                tbdAnimal01.setFiNumber(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).longValue());
                break;
            case 9:
                tbdAnimal01.setFiAnimalNetWeight(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).longValue());
                break;
            case 10:
                tbdAnimal01.setFiAnimalUnitVni(cellValue);
                break;
            case 11:
                tbdAnimal01.setFiPurposeVni(cellValue);
                break;
            case 12:
                tbdAnimal01.setFiPurpose(cellValue);
                break;
            case 13:
                tbdAnimal01.setFiShipmentvalue(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
        }
    }

    public static List<TbdAnimalProduct01> readAnimalProductFromExcel(InputStream is) throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdAnimalProduct01> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdAnimalProduct01 tbdAnimalProduct01 = new TbdAnimalProduct01();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 16; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueAnimalProduct(cellValue, tbdAnimalProduct01, k);
            }
            result.add(tbdAnimalProduct01);
        }

        return result;
    }

    private static void makeValueAnimalProduct(String cellValue, TbdAnimalProduct01 tbdAnimalProduct01, int k) throws ParseException {
        switch (k) {
            case 1:
                tbdAnimalProduct01.setFiProductNameVni(cellValue);
                break;
            case 2:
                tbdAnimalProduct01.setFiProductName(cellValue);
                break;
            case 3:
                tbdAnimalProduct01.setFiHSCode(cellValue);
                break;
            case 4:
                tbdAnimalProduct01.setFiPackageTypeVni(cellValue);
                break;
            case 5:
                tbdAnimalProduct01.setFiPackageType(cellValue);
                break;
            case 6:
                tbdAnimalProduct01.setFiNumber(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).longValue());
                break;
            case 7:
                tbdAnimalProduct01.setFiUnitVni(cellValue);
                break;
            case 8:
                tbdAnimalProduct01.setFiNetWeight(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 9:
                tbdAnimalProduct01.setFiNetWeightUnitVni(cellValue);
                break;
            case 10:
                try {
                    tbdAnimalProduct01.setFiFromDateProduct(new SimpleDateFormat("dd/MM/yyyy").parse(cellValue));
                } catch (Exception ex) {
                }
                break;
            case 11:
                try {
                    tbdAnimalProduct01.setFiToDateProduct(new SimpleDateFormat("dd/MM/yyyy").parse(cellValue));
                } catch (Exception ex) {
                }
            case 12:
                tbdAnimalProduct01.setFiPurposeVni(cellValue);
                break;
            case 13:
                tbdAnimalProduct01.setFiPurpose(cellValue);
                break;
            case 14:
                tbdAnimalProduct01.setFiShipmentvalue(NumberFormat.getNumberInstance(Locale.US).parse(cellValue).doubleValue());
                break;
            case 15:
                tbdAnimalProduct01.setFiMarkNo(cellValue);
                break;
            case 16:
                tbdAnimalProduct01.setFiLotIdentificationNo(cellValue);
                break;
        }
    }

    public static List<TbdTest01> readTestFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdTest01> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdTest01 tbdTest01 = new TbdTest01();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 3; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueTest(cellValue, tbdTest01, k);
            }
            result.add(tbdTest01);
        }

        return result;
    }

    private static void makeValueTest(String cellValue, TbdTest01 tbdTest01, int k) {
        switch (k) {
            case 1:
                tbdTest01.setFiTestName(cellValue);
                break;
            case 2:
                tbdTest01.setFiTestNumber(cellValue);
                break;
            case 3:
                try {
                    tbdTest01.setFiTestDate(new SimpleDateFormat("dd/MM/yyyy").parse(cellValue));
                } catch (Exception ex) {
                }
                break;
        }
    }

    public static List<TbdVaccin01> readVaccinFromExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        int listColumn = ExcelUtil.getLastRowWithData(sheet);

        List<TbdVaccin01> result = new ArrayList<>();
        for (int i = 1; i <= listColumn; i++) {
            Row row = sheet.getRow(i);
            TbdVaccin01 tbdVaccin01 = new TbdVaccin01();
            DataFormatter dataFormatter = new DataFormatter();
            for (int k = 1; k <= 2; k++) {
                Cell cell = row.getCell(k);
                String cellValue = dataFormatter.formatCellValue(cell);
                makeValueVaccin(cellValue, tbdVaccin01, k);
            }
            result.add(tbdVaccin01);
        }

        return result;
    }

    private static void makeValueVaccin(String cellValue, TbdVaccin01 tbdVaccin01, int k) {
        switch (k) {
            case 1:
                tbdVaccin01.setFiVaccinationAgainstName(cellValue);
                break;
            case 2:
                try {
                    tbdVaccin01.setFiVaccinationAgainstDate(new SimpleDateFormat("dd/MM/yyyy").parse(cellValue));
                } catch (Exception ex) {
                }
                break;
        }
    }
}
