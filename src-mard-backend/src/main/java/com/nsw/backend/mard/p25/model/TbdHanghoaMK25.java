/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p25.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "25" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHANGHOAMK25", schema = "MARD")
public class TbdHanghoaMK25 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOAMK25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FI_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdMienKiem;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_ID_HH")
    private Integer fiIdProduct;

    @Column(name = "FI_HS_ID")
    private Integer fiIdHS;

    @Column(name = "FI_TAXCODE", length = 50)
    private String fiTaxCode;

    @Column(name = "FI_PRO_NAME", nullable = false, length = 500)
    private String fiProName;

    @Column(name = "FI_TRANGTHAI_HH")
    private Integer fiTrangThaiHangHoa;

    @Column(name = "FI_PRO_ID_NHOM")
    private String fiProIdNhom;
    @Column(name = "FI_PRO_NAME_NHOM")
    private String fiProNameNhom;
    @Column(name = "FI_PRO_ID_PHAN_NHOM")
    private String fiProIdPhanNhom;
    @Column(name = "FI_PRO_NAME_PHAN_NHOM")
    private String fiProNamePhanNhom;
    @Column(name = "FI_PRO_ID_LOAI")
    private String fiProIdLoai;
    @Column(name = "FI_PRO_NAME_LOAI")
    private String fiProNameLoai;
    @Column(name = "FI_PRO_ID_PHAN_LOAI")
    private String fiProIdPhanLoai;
    @Column(name = "FI_PRO_NAME_PHAN_LOAI")
    private String fiProNamePhanLoai;
    @Column(name = "FI_PRO_CODE", length = 150)
    private String fiProCode;

    @Column(name = "FI_PRO_MADEIN",length = 250)
    private String fiProMadeIn;

    @Column(name = "FI_PRO_COUNTRY_CODE")
    private String fiProCountryCode;

    @Column(name = "FI_PRO_COUNTRY_NAME")
    private String fiProCountryName;

    @Column(name = "FI_PRO_THANHPHAN",  length = 250)
    private String fiProThanhPhan;

    @Column(name = "FI_PRO_COLOR", length = 150)
    private String fiProColor;

    @Column(name = "FI_PRO_SOHIEU", length = 150)
    private String fiProSoHieu;

    @Column(name = "FI_PRO_QUYCHUAN",  length = 150)
    private String fiProQuyChuan;

    @Column(name = "FI_PRO_VALUE_VN", precision = 15, scale = 6)
    private Float fiProValueVN;

    @Column(name = "FI_PRO_VALUE_USD", precision = 15, scale = 6)
    private Float fiProValueUSD;

    @Column(name = "FI_PACKAGE_UNIT_CODE")
    private String fiPackageUnitCode;

    @Column(name = "FI_PACKAGE_UNIT_NAME")
    private String fiPackageUnitName;

    //Thong tin cong van mien giảm
    @Column(name = "FI_PRO_CV_MIENGIAM")
    private String fiProCVMienGiam;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PRO_CV_MIENGIAM_NGAY")
    private Date fiProCVMienGiamNgay;

    //Thong tin hash một số thông tin của sản phẩm
    @Column(name = "FI_PRO_HASH")
    private String fiProHash;

    @Column(name="FI_PRO_KL")
    private String fiProductKL;

    @Column(name="FI_PRO_SL")
    private String fiProductSL;

    @Column(name="FI_KQDGSPH")
    private Integer fiKqdgsph;

    @Column(name = "FI_CER_NO")
    private String fiSoGCN;

    @Column(name = "FI_ID_DVXL")
    private String fiIDDVXL;

    @Column(name = "FI_NAME_DVXL")
    private String fiNameDVXL;

    @Column(name = "FI_ORDER")
    private Integer fiOrder;


    //Danh sách chất lượng kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaCL25> fiProCLList;

    //Danh sách an toàn kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaAT25> fiProATList;

    //Danh sách số lượng khối lượng kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaSLKL25> fiProSLKLList;


    //File kèm theo
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "FI_ID_HANGHOA")
//    private List<TbdHangHoaFile25> fiHangHoaFileList;

    @Transient
    private List<TbdChiTieuDG25> fiListChiTieu;
    public TbdHanghoaMK25() {
        super();
        fiProCLList = new ArrayList<>();
        fiProATList = new ArrayList<>();
        fiProSLKLList = new ArrayList<>();
    }


}
