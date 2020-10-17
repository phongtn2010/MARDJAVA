package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiAnimalCompanyId;

    private String fiAnimalCompanyName;
    private String fiAnimalCompanyAddress;
}
