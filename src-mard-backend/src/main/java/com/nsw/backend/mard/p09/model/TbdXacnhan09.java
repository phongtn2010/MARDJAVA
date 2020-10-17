package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDXACNHAN09", schema = "MARD")
public class TbdXacnhan09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "TBDXACNHAN09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_XND")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdConfirmation;

    @Column(name = "FI_HS_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_REGISTRATION_NO")
    private String fiRegistrationComfirmNo;

    @Column(name = "FI_QUAR_LOC_NAME")
    private String fiQuarantineLocationName;

    @Column(name = "FI_MONT_LOC_TIME_FR")
    private Date fiMonitoringLocationTimeFrom;

    @Column(name = "FI_MONT_LOC_TIME_TO")
    private Date fiMonitoringLocationTimeTo;

    @Column(name = "FI_INSPECTION_TYPE")
    private int fiInspectionType;

    @Column(name = "FI_NOE_FROM_INSPECTION_NO")
    private String fiNoticeOfExemptionFromInspectionNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_OF_TESTING_FROM")
    private Date fiDateOfTestingFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_OF_TESTING_TO")
    private Date fiDateOfTestingTo;

    @Column(name = "FI_UNIT_OF_TESTING")
    private String fiUnitOfTesting;

    @Column(name = "FI_ASSIGN_CODE")
    private String fiAssignCode;

    @Column(name = "FI_ASSIGN_NAME")
    private String fiAssignName;

    @Column(name = "FI_SAMPLING_LOC_CONFIRM")
    private String fiLocationOfSamplingConfirm;

    @Column(name = "FI_SAMPLING_TIME_CONFIRM")
    private String fiTimeOfSamplingConfirm;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SAMPLING_DATE_CONFIRM")
    private Date fiDateOfSamplingConfirm;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_CONFIRM_DATE")
    private Date fiSignConfirmDate;

    @Column(name = "FI_SIGN_CONFIRM_NAME")
    private String fiSignConfirmName;

    @Column(name = "FI_SIGN_CONFIRM_ADDR")
    private String fiSignConfirmAddress;

    @Column(name = "FI_REJECTED_REASON", length = 500)
    private String fiRejectionReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_CONFIRM_DATE_CUST")
    private Date fiSignConfirmDateOfCustoms;

    @Column(name = "FI_SIGN_CONFIRM_NAME_CUST")
    private String fiSignConfirmNameOfCustoms;

    @Column(name = "FI_SIGN_CONFIRM_ADDR_CUST")
    private String fiSignConfirmAddressOfCustoms;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FI_ID_XND")
    private List<TdbXnChitieu09> fiAnanyticalRequiredList;

    public TbdXacnhan09() {
        super();
        fiAnanyticalRequiredList = new ArrayList<>();
    }
}
