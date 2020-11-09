package com.nsw.backend.mard.p25.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class FilterHangHoa {
    private String fiProName;
    private Integer fiHSStatus;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiNSWFileCode";
    private String order = "asc";

    @JsonIgnore
    private List<String> fiLstNSWFileCode;

}