package com.nsw.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class TbdXacNhanDon25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDXACNHANDON25_SEQ";

    private Integer fiId;
    private String fiNSWFileCode;
    private String fiSoGXN;
    private String fiIdCqxl;
    private String fiNameCqxl;
    private String fiIdCqcd;
    private String fiNameCqcd;
    private String fiDvdg;
    private Date fiNgayXN;
    private String fiNoiXN;
    private String fiNguoiXN;
    private String fiGhiChu;
    private Date fiNgayThuHoi;

    private String fiLyDoThuHoi;
    private Date fiNgayKy;
    private String fiNguoiKy;
}
