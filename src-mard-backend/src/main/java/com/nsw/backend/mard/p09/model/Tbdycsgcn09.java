package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDYCSUA09" - Yêu cầu sửa Hồ Sơ
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDYCSGCN09", schema = "MARD")
public class Tbdycsgcn09 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEQUENCE_NAME = "TBDYCSGCN09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_YC", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiRequestId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_CODE", nullable = false, length = 50)
    private String fiNSWFileCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUEST_DATE")
    private Date fiRequestDate;

    @Column(name = "FI_REASON", length = 500)
    private String fiReason;

    @Column(name = "FI_CERT_NO", length = 100)
    private String fiCertificateNo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FI_CERT_EDIT_REQUEST")
    private List<TbdDkYcsGcn09> fiAttachmentList;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdycsgcn09() {
        super();
    }
}
