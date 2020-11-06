package com.nsw.backend.mard.p25.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDGIAYXNCL25", schema = "MARD")
public class TbdGiayXNCL25 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDGIAYXNCL25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_HS_CODE", length = 20)
    private String fiNSWFileCode;

    @Column(name = "FI_DP_CODE", length = 12)
    private String fiDPCode;

    @Column(name = "FI_DP_NAME", length = 250)
    private String fiDPName;

    @Column(name = "FI_CER_NO")
    private Date fiCerNo;

    @Column(name = "FI_SIGN_CER_PLACE", length = 100)
    private String fiSignCerPlace;

    @Column(name = "FI_SIGN_CER_DATE")
    private Date fiSignCerDate;

    @Column(name = "FI_GOOD_ID", length = 20)
    private Integer fiGoodId;

    @Column(name = "FI_GOOD_NAME", length = 250)
    private String fiGoodName;

    @Column(name = "FI_IMPORT_CER_NO", length = 50)
    private String fiImportCerNo;

    @Column(name = "FI_ASSIGN_CODE", length = 12)
    private String fiAssignCode;

    @Column(name = "FI_ASSIGN_NAME", length = 250)
    private String fiAssignName;

    @Column(name = "FI_IMPORT_CER_DATE")
    private Date fiImportCerDate;

    @Column(name = "FI_SIGN_CER_NAME", length = 100)
    private String fiSignCerName;
}
