package com.nsw.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class TbdChiTieuDG25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCHITEUDG25_SEQ";
    private Integer fiId;
    private String fiNSWFileCode;
    private Integer fiIdProduct;
    private String fiTenHangHoa;
    private String fiTenChiTieu;
    private Integer fiHinhThucCB;
    private String fiHamLuong;
    private String fiMaDVT;
    private String fiTenDVT;
    private String fiGhiChu;
}
