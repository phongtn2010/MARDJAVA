package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TbdHanghoa25 implements Serializable {

    private Long fiIdProduct;

    private Long fiIdHS;

    private String fiProName;

    private Integer fiProIdNhom;
    private String fiProNameNhom;
    private Integer fiProIdPhanNhom;
    private String fiProNamePhanNhom;
    private Integer fiProIdLoai;
    private String fiProNameLoai;
    private Integer fiProIdPhanLoai;
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

    private String fiProCVMienGiamNgay;

    private String fiProHash;

    private String fiProductKL;

    private String fiProductSL;
    private Long fiTrangThaiHangHoa;

    private List<TbdHanghoaCL25> fiProCLList;

    private List<TbdHanghoaAT25> fiProATList;

    private List<TbdHanghoaSLKL25> fiProSLKLList;

    private List<Ananytical> fiListChiTieu;
}
