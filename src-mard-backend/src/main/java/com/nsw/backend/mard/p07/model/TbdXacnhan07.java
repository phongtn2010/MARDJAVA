/*
 * Created on 5 May 2017 ( Time 10:32:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p07.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Persistent class for entity stored in table "TBDLICHSU06"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDXACNHAN07", schema = "MARD")
public class TbdXacnhan07 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDXACNHAN07_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_CONFIRM", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdConfirm;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_REG_COMFIRM_NO")
    private String fiRegistrationComfirmNo;

    @Lob
    @Column(name = "FI_CHECK_PLACE", length = 2000)
    private String fiCheckPlace;

    @Column(name = "FI_CHECK_TIME_FROM")
    @Temporal(TemporalType.DATE)
    private Date fiCheckTimeFrom;

    @Column(name = "FI_CHECK_TIME_TO")
    @Temporal(TemporalType.DATE)
    private Date fiCheckTimeTo;

    @Column(name = "FI_CREATER_NAME")
    private String fiCreaterName;

    public TbdXacnhan07() {
        super();
    }
}
