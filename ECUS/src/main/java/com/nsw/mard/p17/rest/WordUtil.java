package com.nsw.mard.p17.rest;

import com.nsw.mard.p17.model.TbdGPThuoc17;
import com.nsw.mard.p18.model.TbdTBKetQuaThuoc18;
import com.nsw.mard.p18.model.TbdThuoc18;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WordUtil {

    public static void replace(XWPFDocument document,String findText, String replaceText) {
        replaceText = (replaceText != null) ? replaceText : " ";
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
    private static void setRun (XWPFRun run , String fontFamily , int fontSize  ,String text, boolean bold , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
      //  run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }
    //Giay Phep
    public static void createRow(XWPFDocument  document, Integer numberOfRow, List<TbdGPThuoc17> tbdGPThuoc17List, Double totalUSD,Double totalEUR, String totalUSDInWord, String totalEURInWord){
        XWPFTable table = document.getTableArray(3);//get table array position !!!
        for(int i = 0; i < numberOfRow; i++){
            XWPFTableRow tableRow = table.createRow();
            for(int j = 0;j < 8; j++) {
                writeToTable(tableRow.getCell(j), tbdGPThuoc17List.get(i), j, i + 1);
                //setRun(tableRow.getCell(j).addParagraph().createRun(), "Times New Roman", 14, tableRow.getCell(j).getText(), false, false);
            }
        }
        XWPFTableRow firstRow = table.createRow();


        XWPFTableRow secondRow = table.createRow();
        mergeCellHorizontally(table, table.getRows().size() - 2, 0, 2);
        mergeCellHorizontally(table, table.getRows().size() - 2, 3, 7);
        mergeCellHorizontally(table, table.getRows().size() - 1, 0, 2);
        mergeCellHorizontally(table, table.getRows().size() - 1, 3, 7);
//        firstRow.getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
//        firstRow.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        firstRow.getCell(0).setText("Tổng cộng");
        //XWPFTableRow secondRow = table.createRow();
        secondRow.getCell(0).setText("Tổng số tiền bằng chữ");
        firstRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        secondRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        firstRow.getCell(0).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        secondRow.getCell(0).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        firstRow.getCell(3).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        secondRow.getCell(3).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        firstRow.getCell(3).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        secondRow.getCell(3).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        if(totalEUR != 0 && totalUSD != 0){
            firstRow.getCell(3).setText(String.format("%.1f", totalUSD) + " USD " + " và " + String.format( "%.1f", totalEUR) + " Euro");
            secondRow.getCell(3).setText(capitalizeFirstLetter(totalUSDInWord + " Đô la Mỹ ") + " và " + capitalizeFirstLetter(totalEURInWord + " Euro" ));
        }
        else if (totalEUR != 0 && totalUSD == 0 ){
            firstRow.getCell(3).setText(String.format( "%.1f", totalEUR) + " EUR ");
            secondRow.getCell(3).setText(capitalizeFirstLetter(totalEURInWord + " Euro"));
        }
        else if (totalEUR == 0 && totalUSD != 0 ){
            firstRow.getCell(3).setText(String.format("%.1f", totalUSD) + " USD ");
            secondRow.getCell(3).setText(capitalizeFirstLetter(totalUSDInWord + " Đô la Mỹ"));
        }
        else if (totalEUR == 0 && totalUSD == 0){
            firstRow.getCell(3).setText("");
            secondRow.getCell(3).setText("");
        }
    }
    public static String capitalizeFirstLetter(String text){
        return text.substring(0,2).toUpperCase() + text.substring(2, text.length());
    }
   /* private static void setRun (XWPFRun run , String fontFamily , int fontSize  , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
       // run.setColor(colorRGB);
        //run.setText(text);
        //run.setBold(bold);
        if (addBreak) run.addBreak();
    }*/
  /* private static XWPFRun createRun(XWPFParagraph paragraph){
       XWPFRun run = paragraph.createRun();
       run.setFontSize(12);
       run.setFontFamily("Times New Roman");
       return run;
   }*/
   private static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
       for(int colIndex = fromCol; colIndex <= toCol; colIndex++){
           XWPFTableCell cell = table.getRow(row).getCell(colIndex);
           CTHMerge hmerge = CTHMerge.Factory.newInstance();
           if(colIndex == fromCol){
               // The first merged cell is set with RESTART merge value
               hmerge.setVal(STMerge.RESTART);
           } else {
               // Cells which join (merge) the first one, are set with CONTINUE
               hmerge.setVal(STMerge.CONTINUE);
               // and the content should be removed
               for (int i = cell.getParagraphs().size(); i > 0; i--) {
                   cell.removeParagraph(0);
               }
               cell.addParagraph();
           }
           // Try getting the TcPr. Not simply setting an new one every time.
           CTTcPr tcPr = cell.getCTTc().getTcPr();
           if (tcPr != null) {
               tcPr.setHMerge(hmerge);
           } else {
               // only set an new TcPr if there is not one already
               tcPr = CTTcPr.Factory.newInstance();
               tcPr.setHMerge(hmerge);
               cell.getCTTc().setTcPr(tcPr);
           }
       }
   }
    private static void writeToTable(XWPFTableCell cell, TbdGPThuoc17 tbdGPThuoc17, int k, int rowCount) {
       // String ghiChu = (tbdTBKetQuaThuoc18.getFiNote() != null) ? tbdTBKetQuaThuoc18.getFiNote() : "";
        //setRun(cell.getParagraphs().get(0).createRun(), "Times New Roman",  14, false);
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        //createRun(cell.getParagraphs().get(0));
        switch (k) {
            case 0:
                cell.setText(String.valueOf(rowCount));
                break;
            case 1:
                cell.setText(tbdGPThuoc17.getFiNameOfProduct());
                break;
            case 2:
                cell.setText(tbdGPThuoc17.getFiManufacturerName());
                break;
            case 3:
                cell.setText(tbdGPThuoc17.getFiCountryName());
                break;
            case 4:
                cell.setText(tbdGPThuoc17.getFiSerialNo());
                break;
            case 5:
                cell.setText(tbdGPThuoc17.getFiWeightUnitName());
                break;
            case 6:
                cell.setText(String.format("%.1f",tbdGPThuoc17.getFiWeight()));
                break;
            case 7:
                cell.setText(String.format("%.1f",tbdGPThuoc17.getFiTotal()));
                break;
            default:
                break;
        }

    }
    public static Integer handlerTemplate(String mucDich, Integer licenseType, String lyDoTuChoi, String mucDichKhac){
        List<String> mucDichsSdKd = new ArrayList<>();
        mucDichsSdKd.add("1");
        mucDichsSdKd.add("2");
        mucDichsSdKd.add("10");
        List<String> mucDichNotSdKd = new ArrayList<>();
        mucDichNotSdKd.add("3");
        mucDichNotSdKd.add("4");
        mucDichNotSdKd.add("5");
        mucDichNotSdKd.add("6");
        mucDichNotSdKd.add("7");
        mucDichNotSdKd.add("8");
        //duoc pham
        if(licenseType == 1) {
            if (mucDichsSdKd.contains(mucDich)) {
                //muc dich sdkd
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 1;// co tu choi
                } else {
                    return 2;// k co tu choi
                }
            } else if (mucDichNotSdKd.contains(mucDich)) {
                //muc dich kp su dung kinh doanh
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;// co tu choi
                } else {
                    return 4;// ko co tu choi
                }
            }
            else if ("9".equals(mucDich) && mucDichKhac != null && !mucDichKhac.isEmpty()){
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
        }
        //vac xin
        else if(licenseType == 2) {
            if (mucDichsSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 5;//muc dich sdkd co tu choi
                } else {
                    return 6;//mucdich sdkd k co tu choi
                }
            } else if (mucDichNotSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
            else if ("9".equals(mucDich) && mucDichKhac != null && !mucDichKhac.isEmpty()){
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
        }
        //Nguyen lieu
        else if(licenseType == 3) {
            if (mucDichsSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 9;//muc dich sdkd co tu choi
                } else {
                    return 10;//muc dich sdkd k co tu choi
                }
            } else if (mucDichNotSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
            else if ("9".equals(mucDich) && mucDichKhac != null && !mucDichKhac.isEmpty()){
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
        }
        //gp tong hop
        else if(licenseType == 6) {
            if (mucDichsSdKd.contains(mucDich) || mucDichNotSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 13;//muc dich sdkd co tu choi
                } else {
                    return 14;//mucdich sdkd k co tu choi
                }
            }
            else if ("9".equals(mucDich) && mucDichKhac != null && !mucDichKhac.isEmpty()){
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 13;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 14;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
        }
        //Bao bi
        else if(licenseType == 5) {
            if (mucDichsSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 9;//muc dich sdkd co tu choi
                } else {
                    return 10;//mucdich sdkd k co tu choi
                }
            } else if (mucDichNotSdKd.contains(mucDich)) {
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
            else if ("9".equals(mucDich) && mucDichKhac != null && !mucDichKhac.isEmpty()){
                if (lyDoTuChoi != null && !lyDoTuChoi.isEmpty()) {
                    return 3;//muc dich kp su dung kinh doanh co tu choi
                } else {
                    return 4;//muc dich kp su dung kinh doanh ko co tu choi
                }
            }
        }
        return 0;
    }
    //ho so
    public static void createRowHoSo(XWPFDocument  document, Integer numberOfRow, List<TbdThuoc18> tbdThuoc18List){
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
                writeToTableHoSo(tableRow.getCell(j), tbdThuoc18List.get(i), j, i + 1);
            }
        }

    }
    private static void writeToTableHoSo(XWPFTableCell cell, TbdThuoc18 tbdThuoc18, int k, int rowCount) {
        cell.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        String thoiGianNK = formatDate(tbdThuoc18.getFiImportTimeFrom()) + " - " + formatDate(tbdThuoc18.getFiImportTimeTo());
        switch (k) {
            case 0:
                cell.setText(String.valueOf(rowCount));
                break;
            case 1:
                cell.setText(tbdThuoc18.getFiNameOfGoods());
                break;
            case 2:
                cell.setText(tbdThuoc18.getFiCirculationNo());
                break;
            case 3:
                cell.setText(tbdThuoc18.getFiDocumentNo());
                break;
            case 4:
                cell.setText(tbdThuoc18.getFiSerialNo());
                break;
            case 5:
                cell.setText(tbdThuoc18.getFiTypeOfPackage());
                break;
            case 6:
                cell.setText(String.valueOf(tbdThuoc18.getFiWeight()));
                break;
            case 7:
                cell.setText(tbdThuoc18.getFiManufacturerName());
                break;
            case 8:
                cell.setText(tbdThuoc18.getFiGate());
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
