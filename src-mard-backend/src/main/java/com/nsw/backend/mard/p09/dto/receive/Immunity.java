package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.util.Date;

@Data
public class Immunity {
    private String fiDiseaseName;

    private Date fiVaccinationDate;
}
