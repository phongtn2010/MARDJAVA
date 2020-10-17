package com.nsw.backend.mard.p01.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<Tbdhoso01> data;
    private Long total;
    private int size;
    private int page;
}
