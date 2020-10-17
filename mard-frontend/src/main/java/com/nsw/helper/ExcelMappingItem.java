/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

/**
 *
 * @author phongnv
 */
public class ExcelMappingItem {

    private String col;
    private int row;
    private String field;
    private String type;
    private boolean nullBreak;

    public boolean isNullBreak() {
        return nullBreak;
    }

    public void setNullBreak(boolean nullBreak) {
        this.nullBreak = nullBreak;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
