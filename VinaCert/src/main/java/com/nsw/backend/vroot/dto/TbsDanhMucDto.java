package com.nsw.backend.vroot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TbsDanhMucDto {
    @JsonProperty(required = true)
    private Long fiCatNo;
    @JsonProperty(required = true)
    private String fiCatNote;
    //@JsonProperty(required = true)
    private Long fiCatType;
    @JsonProperty(required = true)
    private String fiCatTypeName;
    @JsonProperty(required = true)
    private int action;
}
