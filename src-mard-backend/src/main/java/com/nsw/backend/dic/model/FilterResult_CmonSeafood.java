package com.nsw.backend.dic.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResult_CmonSeafood {
    private List<CmonSeafoodprocessors> data;
    private Integer total;
    private int size;
    private int page;
}
