package com.nsw.backend.mard.p01.dto;

import com.nsw.backend.mard.p01.model.Tbdhoso01;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestProEdit implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date fiRequestDate;
    private String fiReason;


    private Tbdhoso01 fiRegistrationProfile;
}
