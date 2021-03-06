/*
 * Created on 5 May 2017 ( Time 10:32:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tbdlichsu08 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHst;

    private Long fiIdProcUnit; //Cơ quan xử lý

    private String fiSenderCode;

    private String fiSenderName;

    private String fiSenderUnitCode;

    private String fiSenderUnitName;

    private String fiReceiverCode;

    private String fiReceiverName;

    private String fiReceiverUnitCode;

    private String fiReceiverUnitName;

    private String fiContent;

    private Date fiTimeline;

    private Long fiStatus;


    private Long fiIdHS;

    private String fiHSCode;

    public Tbdlichsu08() {
        super();
        this.fiSenderUnitName = "Cổng thông tin một cửa quốc gia";
        this.fiSenderUnitCode = "NSW";
    }
}

