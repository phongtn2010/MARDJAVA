package com.nsw.mard.p26.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TbdHanghoa26 implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    private Integer fiIdHS;
    private String fiNSWFileCode;
    private String fiProName;
    private Integer fiTrangThaiHangHoa;
    private String fiProIdNhom;
    private String fiProNameNhom;
    private String fiProIdPhanNhom;
    private String fiProNamePhanNhom;
    private String fiProIdLoai;
    private String fiProNameLoai;
    private String fiProIdPhanLoai;
    private String fiProNamePhanLoai;
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
    private Date fiProCVMienGiamNgay;
    private String fiProHash;
    private String fiProductKL;
    private String fiProductSL;
    private String fiSoGCN;
    private Integer fiKqdgsph;
    private List<TbdHanghoaCL26> fiProCLList;
    private List<TbdHanghoaAT26> fiProATList;
    private List<TbdHanghoaSLKL26> fiProSLKLList;
}
