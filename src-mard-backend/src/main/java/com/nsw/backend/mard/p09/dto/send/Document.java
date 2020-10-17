package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiTypeDoc;
    private String fiNumber;
    private Date fiDate;
    private String fiBillNo;
}
