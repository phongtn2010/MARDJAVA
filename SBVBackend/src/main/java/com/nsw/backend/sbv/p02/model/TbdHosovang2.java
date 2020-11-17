package com.nsw.backend.sbv.p02.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHOSOVANG2", schema = "SBV")
public class TbdHosovang2 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSOVANG2_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "SBV", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_ID_TRANG_THAI")
    private Integer fiIdTrangThai;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_MA_SO_THUE", length = 20)
    private String fiMaSoThue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_NGAY_TAO")
    private Date fiNgayTao;


    //Thông tin đăng ký
    @Column(name = "FI_SO_DON_DE_NGHI", length = 255)
    private String fiSoDonDN;

    @Column(name = "FI_NGUOI_KY_HS", length = 255)
    private String fiNguoiKy;

    @Column(name = "FI_NOI_KY", length = 500)
    private String fiNoiKy;

    @Column(name = "FI_NGAY_KY_HS")
    private Date fiNgayKy;

    @Column(name = "FI_CHUC_VU_KY", length = 255)
    private String fiChucVuKy;

    @Column(name = "FI_TEN_DOANH_NGHIEP", length = 255)
    private String fiTenDoanhNghiep;

    @Column(name = "FI_TRU_SO_CHINH", length = 255)
    private String fiTruSoChinh;

    @Column(name = "FI_DIEN_THOAI", length = 255)
    private String fiDienThoai;

    @Column(name = "FI_SO_FAX", length = 255)
    private String fiSoFax;

    @Column(name = "FI_NGUOI_DAI_DIEN", length = 255)
    private String fiNguoiDaiDien;

    @Column(name = "FI_GIAY_CNDT", length = 255)
    private String fiGiayCNDT;

    @Column(name = "FI_NGAY_CAP_GIAY")
    private Date fiNgayCapGiay;

    @Column(name = "FI_HINH_THUC_DAU_TU", length = 255)
    private String fiHinhThucDauTu;

    @Column(name = "FI_TONG_VON", length = 255)
    private String fiTongVon;

    @Column(name = "FI_VON_PHAP_DINH", length = 255)
    private String fiVonPhapDinh;

    @Column(name = "FI_VON_VAY", length = 255)
    private String fiVonVay;

    @Column(name = "FI_TI_LE_XK", length = 255)
    private String fiTiLeXK;

    @Column(name = "FI_SO_LUONG_CBCN", length = 255)
    private String fiSoLuongCBCN;

    @Column(name = "FI_THOI_GIAN_HD")
    private Date fiThoiGianHD;

    @Column(name = "FI_NAM_DE_NGHI", length = 255)
    private String fiNamDeNghi;

    @Column(name = "FI_ID_CUA_KHAU", length = 20)
    private Integer fiIdCuaKhau;

    @Column(name = "FI_THOI_GIAN_XNK")
    private Date fiThoiGianXNK;

    @Column(name = "FI_CAP_LAN_DAU", length = 1)
    private Integer fiCapLanDau;

    @Column(name = "FI_SO_GIAY_DA_CAP", length = 1)
    private String fiSoGiayDaCap;
    //Các field phục vụ yêu cầu sửa.

    @Column(name = "FI_LY_DO_SUA", length = 1000)
    private String fiLyDoSua;

    //Danh sách thông tin kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ID_HS")
    private List<TbdHanghoa2> fiProductList;

    public TbdHosovang2() {
        super();
        fiProductList = new ArrayList<>();
    }
}