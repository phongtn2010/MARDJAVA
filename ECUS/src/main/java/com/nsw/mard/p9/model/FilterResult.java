package com.nsw.mard.p9.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<Hoso09DTO> data;
    private Long total;
    private int size;
    private int page;
}
