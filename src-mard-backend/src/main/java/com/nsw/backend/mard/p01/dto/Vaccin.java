package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Vaccin implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fiVaccinationAgainstName;
    private Date fiVaccinationAgainstDate;

}
