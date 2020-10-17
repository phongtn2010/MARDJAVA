package com.nsw.backend.mard.p26.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsw.backend.mard.p26.model.TbdHoso26;
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
    private TbdHoso26 regProfile;
}
