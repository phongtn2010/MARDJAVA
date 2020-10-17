/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.nsw.util.GenericUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

/**
 *
 * @author phongnv
 */
public final class ExcelReader {
    /**
     * Đọc ngẫu nhiên
     * @param <T>
     * @param datatypeSheet
     * @param t
     * @param em
     * @return 
     */
    public static <T> T readRandom(Sheet datatypeSheet, T t, ExcelMapping em){
        for (ExcelMappingItem emi : em.getData()) {
            CellReference cr = new CellReference(emi.getCol() + emi.getRow());
            Row row = datatypeSheet.getRow(cr.getRow());     
            if(row == null){
                break;
            }
            Cell cell = row.getCell(cr.getCol());        
            if(cell == null){
                break;
            }
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String value = cell.getStringCellValue();
            GenericUtils.set(t, emi.getField(), GenericUtils.convert(value, emi.getType()));
        }
        return t;
    }
    /**
     * Đọc dữ liệu dạng bảng
     * @param <T>
     * @param datatypeSheet
     * @param clazz
     * @param em
     * @return
     * @throws Exception 
     */
    public static <T> List<T> readTable(Sheet datatypeSheet, Class<T> clazz, ExcelMapping em) throws Exception{
        List<T> result = new ArrayList<>();
        int rowIndex = em.getStart();
        T item;
        while(rowIndex <= em.getEnd() || em.getEnd() == 0){
            boolean exit = false;
            item = clazz.newInstance();
            for (ExcelMappingItem emi : em.getData()) {
                CellReference cr = new CellReference(emi.getCol() + rowIndex);
                Row row = datatypeSheet.getRow(cr.getRow());    
                if(row == null){
                    exit = true;
                    break;
                }
                Cell cell = row.getCell(cr.getCol());     
                if(cell == null){
                    exit = true;
                    break;
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String value = cell.getStringCellValue();
                if((value == null || value.isEmpty()) && emi.isNullBreak()){
                    exit = true;
                    break;
                }
                GenericUtils.set(item, emi.getField(), GenericUtils.convert(value, emi.getType()));
            }
            if(exit){
                break;
            }
            else{
                result.add((T) item);
                rowIndex++;
            }
        }
        return result;
    }
}
