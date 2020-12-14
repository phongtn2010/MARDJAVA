/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import java.util.List;

/**
 *
 * @author phongnv
 */
public class ExcelMapping {
    private String object;
    private int sheetIndex;
    private String feed;
    private String reader;
    private int start;
    private int end;
    private List<ExcelMappingItem> data;

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public List<ExcelMappingItem> getData() {
        return data;
    }

    public void setData(List<ExcelMappingItem> data) {
        this.data = data;
    }
}
