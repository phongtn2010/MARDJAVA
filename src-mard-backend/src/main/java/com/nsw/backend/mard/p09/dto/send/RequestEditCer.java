package com.nsw.backend.mard.p09.dto.send;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nsw.backend.mard.p09.model.TbdDkYcsGcn09;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class RequestEditCer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date fiRequestDate;
    private String fiReason;
    private String fiNSWFileCode;
    private String fiCertificateNo;

    private String fiTypeCert;
    private Long fiIdCv;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Attachment> fiAttachmentList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TbdDkYcsGcn09> lstAtch;
}
