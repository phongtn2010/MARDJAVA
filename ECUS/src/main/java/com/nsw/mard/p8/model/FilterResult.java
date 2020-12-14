package com.nsw.mard.p8.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<Tbdhoso08> data;
    private Long total;
    private int size;
    private int page;
}
