package com.nsw.backend.mard.p25.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterResultHH {
    private List<TbdHanghoa25> data;
    private Integer total;
    private int size;
    private int page;
    private Integer fiHSStatus;
}