package com.nsw.mard.p26.model;

import lombok.Data;

@Data
public class FilterFormHangHoa26 {
    private String taxCode;
    private Integer page;
    private Integer size=20;
    private String sortBy;
    private String order;
}
