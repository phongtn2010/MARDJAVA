package com.nsw.backend.mard.p08.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestEdit implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiIdHS;
    private String fiNSWFileCode;
    private Date fiRequestDate;
    private String fiReason;

    @JsonIgnore
    private Tbdhoso08 regProfile;
}
