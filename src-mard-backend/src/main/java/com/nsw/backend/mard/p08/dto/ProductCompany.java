package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiProductCompanyId;

    private String fiProductCompanyName;
    private String fiProductCompanyAddress;
}
