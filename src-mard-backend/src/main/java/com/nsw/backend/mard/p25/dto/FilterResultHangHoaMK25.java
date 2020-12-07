package com.nsw.backend.mard.p25.dto;

import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;
import lombok.Data;

import java.util.List;

@Data
public class FilterResultHangHoaMK25 {
    private String taxCode;
    private Integer page;
    private Integer size=15;
    private String sortBy;
    private String order;
    private List<TbdHanghoaMK25> listTbdHanghoaMK25;
    private Integer total;
}
