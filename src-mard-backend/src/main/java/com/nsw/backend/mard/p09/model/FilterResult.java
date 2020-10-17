package com.nsw.backend.mard.p09.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<Tbdhoso09> data;
    private Long total;
    private int size;
    private int page;
}
