package com.nsw.mic.p04.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class TbdDinhKem04DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long fiId;

    @NotNull
    private Long fiIdHoSo;

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
