package com.nsw.backend.mard.p08.dto;


import lombok.Data;

import java.util.Date;

@Data
public class Document {
    private Long fiIdProduct;
    private Long fiIdHS;
    private Long fiTypeDoc;
    private String fiNumber;
    private Date fiDate;
}
