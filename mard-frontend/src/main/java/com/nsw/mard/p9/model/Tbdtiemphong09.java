package com.nsw.mard.p9.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDTIEMPHONG09"
 *
 * @author Telosys Tools Generator
 */
@Data
@NoArgsConstructor
public class Tbdtiemphong09 implements Serializable {

    private Long fiId;

    private Long fiIdQuarantineCer;

    private String fiDiseaseName;

    private Date fiVaccinationDate;

}
