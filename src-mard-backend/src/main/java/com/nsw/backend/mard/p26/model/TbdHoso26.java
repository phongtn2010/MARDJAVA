package com.nsw.backend.mard.p26.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p26.model.TbdHanghoa26;
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
@Table(name = "TBDHOSO26", schema = "MARD")
public class TbdHoso26 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO26_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false,name = "FI_HS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiMaHoso;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_HS_STATUS")
    private Integer fiTrangthai;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiNgaytao;

    //Các field phục vụ yêu cầu sửa.
    @Column(name = "FI_MODIFY_REASON", length = 250)
    private String fiReason;

    @Column(name = "FI_REQUEST_DATE")
    private String fiRequestDate;

    @Column(name = "FI_HS_ID_PARENT")
    private Integer fiIdHSParent;

    //Thông tin to chuc, ca nhan
    @Column(name = "FI_TAX_CODE", length = 25)
    private String fiMasothue;
    @Column(name = "FI_BUS_NAME", length = 250)
    private String fiTenDn;

    @Column(name = "FI_BUS_ADDRESS", length = 500)
    private String fiDiachiDn;

    @Column(name = "FI_BUS_TEL",length = 15)
    private String fiSdtDn;

    @Column(name = "FI_BUS_FAX", length = 15)
    private String fiFaxDn;

    @Column(name = "FI_BUS_EMAIL",  length = 250)
    private String fiEmailDn;

    //Thông tin hồ sơ Doanh Nghiệp
    @Column(name = "FI_SIGN_PROVIN_CODE", length = 6)
    private String fiSignProvinCode;

    @Column(name = "FI_SIGN_PROVIN_NAME", length = 250)
    private String fiSignProvinName;

    @Column(name = "FI_SIGN_NAME", length = 250)
    private String fiNguoiKy;

    @Column(name = "FI_SIGN_POSITION", length = 250)
    private String fiDiadiemKy;

    @Column(name = "FI_NGAYKY")
    private Date fiNgayKy;

    @Column(name = "FI_CONGVAN_MK", length = 250)
    private String fiSoCVMienKiem;

    @Column(name = "FI_NUOCSX", length = 250)
    private String fiNuocSX;
    @Column(name = "FI_HANGSX", length = 250)
    private String fiHangSX;
    //Danh sách thông tin kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdHanghoa26> fiProductList;

    @Transient
    private String fiCertNo;

    public TbdHoso26() {
        super();
        fiProductList = new ArrayList<>();
    }
}
