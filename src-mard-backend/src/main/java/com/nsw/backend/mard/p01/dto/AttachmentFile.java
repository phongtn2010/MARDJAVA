package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttachmentFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiID;
    private boolean fiActive;
    private String fiTaxCode;
    private String fiContent;
    private String fiFileName;

}
