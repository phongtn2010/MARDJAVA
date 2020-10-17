package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationQuarantine implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiLocationQuarantineId;

    private String fiLocationQuarantineName;
    private String fiLocationQuarantineAddress;
}
