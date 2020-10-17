package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoneMealCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiBoneMealCompanyId;

    private String fiBoneMealCompanyName;
    private String fiBoneMealCompanyAddress;
}
