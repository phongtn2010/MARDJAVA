/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.annotations;

public class ErrorEntity extends AbstractEntity {
    
    private Integer excelRow;  
    private Integer excelCol; 
    private String error;        
    private String fieldName;
    private String sheetName;
    
    public ErrorEntity() {
    }

    public ErrorEntity(String fieldName, String errorCode, String sheetName) {
        this.fieldName = fieldName;
        this.error = errorCode; 
        this.sheetName = sheetName;
    }
    
    public ErrorEntity(Integer row, Integer col, String fieldName, 
            String errorCode, String sheetName) {
        this.fieldName = fieldName;
        this.error = errorCode;   
        this.excelRow = row;  
        this.excelCol = col;  
        this.sheetName = sheetName;
    }

    @Override
    public String toString() {
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(getFieldName());
        errorBuilder.append(" ");
        errorBuilder.append(getErrors());
        return errorBuilder.toString();
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getExcelRow() {
        return excelRow;
    }

    public void setExcelRow(Integer excelRow) {
        this.excelRow = excelRow;
    }

    public Integer getExcelCol() {
        return excelCol;
    }

    public void setExcelCol(Integer excelCol) {
        this.excelCol = excelCol;
    }      

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    
}
