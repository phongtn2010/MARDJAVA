package com.nsw.backend.mard.p26.model;

import com.nsw.backend.mard.p26.model.TbdHoso26;
import lombok.Data;

import java.util.List;

@Data
public class FilterResult {
    private List<TbdHoso26> data;
    private Integer total;
    private int size;
    private int page;
}
