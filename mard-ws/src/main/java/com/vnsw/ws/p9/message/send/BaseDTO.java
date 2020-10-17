package com.vnsw.ws.p9.message.send;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
    private Date fiCreatedDate;

    private String fiCreatedBy;

    private Date fiUpdatedDate;

    private String fiUpdatedBy;
}
