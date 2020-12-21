package com.nsw.backend.mard.p25.dto;

import lombok.Data;


@Data
public class FilterFormHangHoaMK25 {
    private String taxCode;
    private Integer page;
    private Integer size=15;
    private String sortBy="fiProHash";
    private String fiOrder="fiOrder";
    private String order="desc";
}
