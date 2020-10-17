package com.nsw.mic.p04.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TbdDinhKemYCSGP04DTO {

    @NotNull
    private Long fiId;

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
