package com.nsw.sbv.p02.model;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TbdHosovang2 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSOVANG2_SEQ";

    private String fiNSWFileCode;

    private Integer fiIdHS;

    private Integer fiIdTrangThai;

    private String fiSoDonDN;

    private String fiNguoiKy;

    private String fiNoiKy;

    private Date fiNgayKy;

    private String fiChucVuKy;

    private Integer fiHSType = 1;

    private Integer fiTrangThaiHoSo;

    private boolean fiActive = true;

    private String fiMaSoThue;

    private String fiTenDoanhNghiep;

    private String fiTruSoChinh;

    private String fiDienThoai;

    private String fiSoFax;

    private String fiNguoiDaiDien;

    private String fiGiayCNDT;

    private Date fiNgayCapGiay;

    private String fiHinhThucDauTu;

    private String fiTongVon;

    private String fiVonPhapDinh;

    private String fiVonVay;

    private String fiTiLeXK;

    private String fiSoLuongCBCN;

    private Date fiThoiGianHD;

    private String fiNamDeNghi;

    private Integer fiIdCuaKhau;

    private Date fiThoiGianXNK;

    private Integer fiCapLanDau;

    private String fiSoGiayDaCap;

    private String fiLyDoSua;

    private List<TbdHanghoa2> fiProductList;

//    private List<TbdDinhkem06> fiAttachmentList;
}
