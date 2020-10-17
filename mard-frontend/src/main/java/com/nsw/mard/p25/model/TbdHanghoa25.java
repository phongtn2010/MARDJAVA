package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TbdHanghoa25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA25_SEQ";

    private Long fiIdProduct;

    private Long fiIdHS;

    private Long fiId;

    private String fiProName;

    private Integer fiProIdNhom;

    private Integer fiProIdPhanNhom;

    private Integer fiProIdLoai;

    private Integer fiProIdPhanLoai;

    private String fiProCode;

    private String fiProMadeIn;

    private String fiProCountryCode;

    private String fiProCountryName;

    private String fiProThanhPhan;

    private String fiProColor;

    private String fiProSoHieu;

    private String fiProQuyChuan;

    private Float fiProValueVN;

    private Float fiProValueUSD;

    private String fiPackageUnitCode;

    private String fiPackageUnitName;

    private String fiProCVMienGiam;

    private String fiProCVMienGiamNgay;

    private String fiProHash;

    private List<TbdHanghoaCL25> fiProCLList;

    private List<TbdHanghoaAT25> fiProATList;

    private List<TbdHanghoaSLKL25> fiProSLKLList;
}
