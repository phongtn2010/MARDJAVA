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
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_HS_STATUS")
    private Integer fiHSStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    //Các field phục vụ yêu cầu sửa.
    @Column(name = "FI_MODIFY_REASON", length = 250)
    private String fiReason;

    @Column(name = "FI_REQUEST_DATE")
    private String fiRequestDate;

    @Column(name = "FI_HS_ID_PARENT")
    private Integer fiIdHSParent;

    //Thông tin to chuc, ca nhan
    @Column(name = "FI_BUS_NAME", nullable = false, length = 250)
    private String fiBusName;

    @Column(name = "FI_BUS_ADDRESS", nullable = false, length = 500)
    private String fiBusAddress;

    @Column(name = "FI_BUS_TEL", nullable = false, length = 15)
    private String fiBusTel;

    @Column(name = "FI_BUS_FAX", length = 15)
    private String fiBusFax;

    @Column(name = "FI_BUS_EMAIL", nullable = false, length = 250)
    private String fiBusEmail;

    //Thông tin hồ sơ Doanh Nghiệp
    @Column(name = "FI_SIGN_PROVIN_CODE", nullable = false, length = 6)
    private String fiSignProvinCode;

    @Column(name = "FI_SIGN_PROVIN_NAME", nullable = false, length = 250)
    private String fiSignProvinName;

    @Column(name = "FI_SIGN_NAME", nullable = false, length = 250)
    private String fiSignName;

    @Column(name = "FI_SIGN_POSITION", nullable = false, length = 250)
    private String fiSignPosition;

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
