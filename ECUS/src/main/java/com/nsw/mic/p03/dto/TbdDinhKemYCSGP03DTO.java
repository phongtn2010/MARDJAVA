package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TbdDinhKemYCSGP03DTO {

    @NotNull
    private Long fiId;

    @NotNull
    private Long fiIdYeuCauSGP;

    @NotNull
    private String fiFileTypeCode;

    @NotNull
    @Size(max = 500)
    private String fiFileTypeName;

    @NotNull
    private String fiFileGroup;

    @NotNull
    @Size(max = 250)
    private String fiFileName;

}
