package com.nsw.backend.dic.model;

import lombok.Data;

@Data
public class FilterFormCmonSF {
    private String macssx;
    private String tencssx;
    private int page;
    private int size=20;
    private String sortBy = "seafoodprocessorscode";
    private String order = "asc";
}
