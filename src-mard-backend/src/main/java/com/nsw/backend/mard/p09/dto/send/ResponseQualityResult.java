package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseQualityResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private String fiDeescription;
    private Date fiResponseDate;
    private String fiResponseUser;
}
