package com.nsw.mic.p04.model;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SendMessage04 {

    private String fiReason;

    private String fiXml;

    private String fiTaxCode;

    private String fiUserName;

    private boolean fiSign;

    @NotNull
    private Long fiIdHoSo;

    @NotNull
    private Integer fiAction;

    private Long fiIdYeuCauSuaGP;



}
