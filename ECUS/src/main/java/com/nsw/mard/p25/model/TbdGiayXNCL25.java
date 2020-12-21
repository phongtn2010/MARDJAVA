package com.nsw.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class TbdGiayXNCL25 implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDGIAYXNCL25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    private String fiNSWFileCode;

    private String fiMaCQKT;

    private String fiTenCQKT;

    private String fiSoGCN;

    private String fiNoiKy;

    private Date fiNgayKy;

    private Integer fiIdHangHoa;

    private String fiTenHangHoa;

    private String fiGCNHopQuy;

    private String fiIDCoQuanDanhGia;

    private String fiNameCoQuanDanhGia;

    private Date fiNgayCap;

    private String fiNguoiKy;

    private Boolean isThuHoi;
    private List<TbdHanghoa25> fiProductList;
}
