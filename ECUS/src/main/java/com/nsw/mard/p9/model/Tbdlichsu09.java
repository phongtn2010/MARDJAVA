package com.nsw.mard.p9.model;


import java.io.Serializable;
import java.util.Date;


/**
 * Persistent class for entity stored in table "TBDLICHSU09"
 *
 * @author Telosys Tools Generator
 *
 */
public class Tbdlichsu09 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    private Long fiIdHst;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

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

    private String fiProcName;

    private Long fiIdHS;

    private String fiHSCode;
    public Tbdlichsu09() {
        super();
    }

}
