package com.nsw.mard.p1.model;
import java.util.Date;
import lombok.Data;
@Data

public class Tbdlichsu01  {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDLICHSU01_SEQ";
    private Long fiIdHst;
    private Long fiIdProcUnit; //Cơ quan xử lý

    private String fiSenderCode;

    private String fiSenderName; // chuyen vien xu ly

    private String fiSenderUnitCode;

    private String fiSenderUnitName; // don vi xu ly

    private String fiReceiverCode;

    private String fiReceiverName;

    private String fiReceiverUnitCode;

    private String fiReceiverUnitName;

    private String fiContent;

    private Date fiTimeline;

    private Long fiStatus;

    private String fiProcName;

    private Long fiIdHS;

    private Long fiHSCode;

    public Tbdlichsu01() {
        super();
        this.fiSenderUnitName = "Cổng thông tin một cửa quốc gia";
        this.fiSenderUnitCode = "NSW";
    }
}
