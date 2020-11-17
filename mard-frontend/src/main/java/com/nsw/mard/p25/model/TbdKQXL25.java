package com.nsw.mard.p25.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
public class TbdKQXL25 {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDKQXL25_SEQ";

    private Integer fiId;

    private String fiNSWFileCode;

    private String fiDVXLCode;

    private String fiDVXLName;

    private Integer fiProId;

    private String fiProName;

    private Integer fiLoaiKQDG;

    private String fiSoGCN;

    private Date fiNgayDG;

    private String fiIDFileGCN;

    private String fiLinkGCN;

    private String fiNameGCN;

    private List<TbdHangHoaFile25> fiListHangHoaFile;
}
