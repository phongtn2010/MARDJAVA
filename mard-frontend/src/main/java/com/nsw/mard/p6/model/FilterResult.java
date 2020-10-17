package com.nsw.mard.p6.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<TbdHoso06> data;
    private Long total;
    private int size;
    private int page;
}


