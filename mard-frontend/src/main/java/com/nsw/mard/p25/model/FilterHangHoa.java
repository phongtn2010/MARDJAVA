package com.nsw.mard.p25.model;

import lombok.Data;


@Data
public class FilterHangHoa {
    private String fiProName;
    private Integer fiHSType;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiHSCode";
    private String order = "asc";
}