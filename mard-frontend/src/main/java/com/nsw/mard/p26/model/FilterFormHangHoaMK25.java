package com.nsw.mard.p26.model;

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
