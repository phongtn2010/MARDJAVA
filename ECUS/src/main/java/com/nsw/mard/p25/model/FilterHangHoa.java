package com.nsw.mard.p25.model;

import lombok.Data;


@Data
public class FilterHangHoa {
    private String fiProName;
    private Integer fiTrangThaiHangHoa;
    private Integer fiIdHS;
    private Integer page = 1;
    private Integer size = 10;
    private String sortBy = "fiProName";
    private String order = "desc";
}