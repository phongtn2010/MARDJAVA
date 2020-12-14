package com.nsw.mard.p19.rest;

import com.nsw.mard.p18.model.TbdTBKetQuaThuoc18;
import com.nsw.mard.p18.model.TbdThuoc18;
import com.nsw.mard.p19.model.TbdTBKetQuaThuoc19;
import com.nsw.mard.p19.model.TbdThuoc19;
import org.apache.poi.xwpf.usermodel.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WordUtil {

   /* public static void replace(XWPFParagraph paragraph, String searchValue, String replacement) {
        String text = paragraph.getText();
        if (hasReplaceableItem(text, searchValue)) {

            String replacedText = StringUtils.replace(text, searchValue, replacement);
            removeAllRuns(paragraph);
            insertReplacementRuns(paragraph, replacedText);
        }
    }

    private static void insertReplacementRuns(XWPFParagraph paragraph, String replacedText) {
        String[] replacementTextSplitOnCarriageReturn = StringUtils.split(replacedText, "\n");

        for (int j = 0; j < replacementTextSplitOnCarriageReturn.length; j++) {
            String part = replacementTextSplitOnCarriageReturn[j];

            XWPFRun newRun = paragraph.insertNewRun(j);
            newRun.setText(part);

            if (j+1 < replacementTextSplitOnCarriageReturn.length) {
                newRun.addCarriageReturn();

            }
        }
    }

    private static void removeAllRuns(XWPFParagraph paragraph) {
        int size = paragraph.getRuns().size();
        for (int i = 0; i < size; i++) {
            paragraph.removeRun(0);
        }
    }

    private static boolean hasReplaceableItem(String runText, String searchValue) {
        return StringUtils.contains(runText, searchValue);
    }*/


  /* private static Map<Integer, XWPFRun> getPosToRuns(XWPFParagraph paragraph) {
       int pos = 0;
       Map<Integer, XWPFRun> map = new HashMap<Integer, XWPFRun>(10);
       for (XWPFRun run : paragraph.getRuns()) {
           String runText = run.getText(run.getTextPosition());
           if (runText != null) {
               for (int i = 0; i < runText.length(); i++) {
                   map.put(pos + i, run);
               }
               pos += runText.length();
           }
       }
       return (map);
   }

    public static <V> void replace(XWPFDocument document, Map<String, V> map) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            replace(paragraph, map);
        }
    }

    public static <V> void replace(XWPFDocument document, String searchText, V replacement) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            replace(paragraph, searchText, replacement);

        }
    }

    private static <V> void replace(XWPFParagraph paragraph, Map<String, V> map) {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            replace(paragraph, entry.getKey(), entry.getValue());
        }
    }

    public static <V> void replace(XWPFParagraph paragraph, String searchText, V replacement) {
        boolean found = true;
        while (found) {
            found = false;
            int pos = paragraph.getText().indexOf(searchText);
            if (pos >= 0) {
                found = true;
                Map<Integer, XWPFRun> posToRuns = getPosToRuns(paragraph);
                XWPFRun run = posToRuns.get(pos);
                XWPFRun lastRun = posToRuns.get(pos + searchText.length() - 1);
                int runNum = paragraph.getRuns().indexOf(run);
                int lastRunNum = paragraph.getRuns().indexOf(lastRun);
                String texts[] = replacement.toString().split("\n");
                run.setText(texts[0], 0);
                XWPFRun newRun = run;
                for (int i = 1; i < texts.length; i++) {
                    newRun.addCarriageReturn();
                    newRun = paragraph.insertNewRun(runNum + i);
                *//*
                    We should copy all style attributes
                    to the newRun from run
                    also from background color, ...
                    Here we duplicate only the simple attributes...
                 *//*
                    newRun.setText(texts[i]);
                    newRun.setBold(run.isBold());
                    //newRun.setTextPosition(run.getTextPosition());
                   // newRun.setCapitalized(run.isCapitalized());
                    // newRun.setCharacterSpacing(run.getCharacterSpacing());
                    newRun.setColor(run.getColor());
                    //newRun.setDoubleStrikethrough(run.isDoubleStrikeThrough());
                   // newRun.setEmbossed(run.isEmbossed());
                    newRun.setFontFamily(run.getFontFamily());
                    newRun.setFontSize(run.getFontSize());
                    //newRun.setImprinted(run.isImprinted());
                    newRun.setItalic(run.isItalic());
                   // newRun.setKerning(run.getKerning());
                    //newRun.setShadow(run.isShadowed());
                    //newRun.setSmallCaps(run.isSmallCaps());
                    //newRun.setStrikeThrough(run.isStrikeThrough());
                    newRun.setSubscript(run.getSubscript());
                    newRun.setUnderline(run.getUnderline());
                }
                *//*for (int i = lastRunNum + texts.length - 1; i > runNum + texts.length - 1; i--) {
                    paragraph.removeRun(i);
                }*//*
            }
        }
    }*/
    public static void replace(XWPFDocument document,String findText, String replaceText) {
        replaceText = (replaceText != null) ? replaceText : "..................";
        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains(findText)) {
                        text = text.replace(findText, replaceText);//your content
                        r.setText(text, 0);
                    }
                }
            }
        }

        for (XWPFTable tbl : document.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains(findText)) {
                                text = text.replace(findText, replaceText);
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }

    }
    //Giay Phep
    public static void createRow(XWPFDocument  document, Integer numberOfRow, List<TbdTBKetQuaThuoc19> tbdTBKetQuaThuoc19List){
        XWPFTable table = document.getTableArray(1);
        /*XWPFTable table = null;
        for (int z = 1; z < document.getTables().size(); z++)
        {
            //table.getColBandSize();
            String tableElemnt =  document.getTables().get(z).getText();
            if (tableElemnt.startsWith("Số TT")) {
                table = document.getTableArray(z);
            }
        }*/

        //XWPFTableRow oldRow = table.getRow(1);
        for(int i = 0; i < numberOfRow; i++){
            XWPFTableRow tableRow = table.createRow();
            for(int j = 0;j < 8; j++) {
                writeToTable(tableRow.getCell(j), tbdTBKetQuaThuoc19List.get(i), j, i + 1);
            }
        }

    }
    private static void writeToTable(XWPFTableCell cell, TbdTBKetQuaThuoc19 tbdTBKetQuaThuoc19, int k, int rowCount) {
        String ghiChu = (tbdTBKetQuaThuoc19.getFiNote() != null) ? tbdTBKetQuaThuoc19.getFiNote() : "";
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        switch (k) {
            case 0:
                cell.setText(String.valueOf(rowCount));
                break;
            case 1:
                cell.setText(tbdTBKetQuaThuoc19.getFiNameOfGoods());
                break;
            case 2:
                cell.setText(tbdTBKetQuaThuoc19.getFiCirculationNo());
                break;
            case 3:
                cell.setText(tbdTBKetQuaThuoc19.getFiSerialNo());
                break;
            case 4:
                cell.setText(tbdTBKetQuaThuoc19.getFiTypeOfPackage());
                break;
            case 5:
                cell.setText(String.format("%.1f",tbdTBKetQuaThuoc19.getFiWeight()));
                break;
            case 6:
                cell.setText(tbdTBKetQuaThuoc19.getFiManufacturerName());
                break;
            case 7:
                cell.setText(tbdTBKetQuaThuoc19.getFiWeightUnitName());
                break;
            case 8:
                cell.setText(ghiChu);
                break;
            default:
                break;
        }

    }
    //ho so
    public static void createRowHoSo(XWPFDocument  document, Integer numberOfRow, List<TbdThuoc19> tbdthuoc19List){
        XWPFTable table = document.getTableArray(1);
        //XWPFTable table = null;
       /* for (int z = 1; z < document.getTables().size(); z++)
        {
            //table.getColBandSize();
            String tableElemnt =  document.getTables().get(z).getText();
            if (tableElemnt.startsWith("Số TT")) {
                table = document.getTableArray(z);
            }
        }*/
        //XWPFTableRow oldRow = table.getRow(1);
        for(int i = 0; i < numberOfRow; i++){
            XWPFTableRow tableRow = table.createRow();
            for(int j = 0;j < 10; j++) {
                writeToTableHoSo(tableRow.getCell(j), tbdthuoc19List.get(i), j, i + 1);
            }
        }

    }
    private static void writeToTableHoSo(XWPFTableCell cell, TbdThuoc19 tbdThuoc19, int k, int rowCount) {
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        String thoiGianNK = formatDate(tbdThuoc19.getFiImportTimeFrom()) + " - " + formatDate(tbdThuoc19.getFiImportTimeTo());
        switch (k) {
            case 0:
                cell.setText(String.valueOf(rowCount));
                break;
            case 1:
                cell.setText(tbdThuoc19.getFiNameOfGoods());
                break;
            case 2:
                cell.setText(tbdThuoc19.getFiCirculationNo());
                break;
            case 3:
                cell.setText(tbdThuoc19.getFiDocumentNo());
                break;
            case 4:
                cell.setText(tbdThuoc19.getFiSerialNo());
                break;
            case 5:
                cell.setText(tbdThuoc19.getFiTypeOfPackage());
                break;
            case 6:
                cell.setText(String.format("%.1f",tbdThuoc19.getFiWeight()));
                break;
            case 7:
                cell.setText(tbdThuoc19.getFiManufacturerName());
                break;
            case 8:
                cell.setText(tbdThuoc19.getFiGate());
                break;
            case 9:
                cell.setText(thoiGianNK);
                break;
            default:
                break;
        }

    }
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(date != null){
            return simpleDateFormat.format(date);
        }
        else{
            return "...........";
        }
    }

}
