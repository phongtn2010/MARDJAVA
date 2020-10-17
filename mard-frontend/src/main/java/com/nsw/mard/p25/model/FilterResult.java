package com.nsw.mard.p25.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<TbdHoso25> data;
    private Long total;
    private int size;
    private int page;
}


