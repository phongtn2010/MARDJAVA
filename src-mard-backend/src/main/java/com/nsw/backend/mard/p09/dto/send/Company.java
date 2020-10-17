package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;

@Data
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiCompanyName;
    private String fiCompanyAddress;
}
