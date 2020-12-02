package com.nsw.backend.mard.p26.model;

import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import lombok.Data;

import java.util.List;

@Data
public class FilterResultHH {
    private List<TbdHanghoa26> data;
    private Integer total;
    private int size;
    private int page;
}