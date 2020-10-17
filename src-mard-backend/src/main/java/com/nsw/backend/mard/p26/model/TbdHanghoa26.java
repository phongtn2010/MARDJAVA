package com.nsw.backend.mard.p26.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p25.model.TbdHanghoaAT25;
import com.nsw.backend.mard.p25.model.TbdHanghoaCL25;
import com.nsw.backend.mard.p25.model.TbdHanghoaSLKL25;
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
@Table(name = "TBDHANGHOA26", schema = "MARD")
public class TbdHanghoa26 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA26_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_ID")
    private Integer fiIdHS;

    @Column(name = "FI_ID")
    private Integer fiId;

    @Column(name = "FI_PRO_NAME", nullable = false, length = 500)
    private String fiProName;

    @Column(name = "FI_PRO_ID_NHOM")
    private Integer fiProIdNhom;

    @Column(name = "FI_PRO_ID_PHAN_NHOM")
    private Integer fiProIdPhanNhom;

    @Column(name = "FI_PRO_ID_LOAI")
    private Integer fiProIdLoai;

    @Column(name = "FI_PRO_ID_PHAN_LOAI")
    private Integer fiProIdPhanLoai;

    @Column(name = "FI_PRO_CODE", nullable = false, length = 150)
    private String fiProCode;

    @Column(name = "FI_PRO_MADEIN", nullable = false, length = 250)
    private String fiProMadeIn;

    @Column(name = "FI_PRO_COUNTRY_CODE")
    private String fiProCountryCode;

    @Column(name = "FI_PRO_COUNTRY_NAME")
    private String fiProCountryName;

    @Column(name = "FI_PRO_THANHPHAN", nullable = false, length = 250)
    private String fiProThanhPhan;

    @Column(name = "FI_PRO_COLOR", nullable = false, length = 150)
    private String fiProColor;

    @Column(name = "FI_PRO_SOHIEU", nullable = false, length = 150)
    private String fiProSoHieu;

    @Column(name = "FI_PRO_QUYCHUAN", nullable = false, length = 150)
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

    //Danh sách chất lượng kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaCL25> fiProCLList;

    //Danh sách an toàn kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaAT25> fiProATList;

    //Danh sách an toàn kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PRO_ID")
    private List<TbdHanghoaSLKL25> fiProSLKLList;

    public TbdHanghoa26() {
        super();
        fiProCLList = new ArrayList<>();
        fiProATList = new ArrayList<>();
        fiProSLKLList = new ArrayList<>();
    }
}
