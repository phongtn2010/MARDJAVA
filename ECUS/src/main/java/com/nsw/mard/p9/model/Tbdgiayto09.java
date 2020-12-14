package com.nsw.mard.p9.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDDINHKEM09"
 *
 * @author Telosys Tools Generator
 *
 */

@Data
public class Tbdgiayto09 implements Serializable {

    private Long fiIdProduct;

    private Long fiIdHS;

    private Long fiTypeDoc;

    private String fiNumber;

    private Date fiDate;

    private String fiBillNo;
}
