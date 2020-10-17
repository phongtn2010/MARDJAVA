/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p25.model;

import com.google.common.base.Objects;
import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDDINHKEM25"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDDINHKEM25", schema = "MARD")
public class TbdDinhkem25 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDINHKEM25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdDinhkem;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_FILE_TYPE_ID", nullable = false)
    private Integer fiFileTypeID;

    @Column(name = "FI_FILE_TYPE_NAME", nullable = false)
    private String fiFileTypeName;

    @Column(name = "FI_FILE_MAHOSO")
    private String fiFileMaHoSo;

    @Column(name = "FI_FILE_NAME", nullable = false)
    private String fiFileName;

    @Column(name = "FI_FILE_HD", length = 250)
    private String fiFileHD;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_FILE_HD_DATE")
    private Date fiFileHDDate;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Integer fiActive;

    @Column(name = "FI_PATH", length = 2000)
    private String fiPath;

    @Column(name = "FI_GUID", length = 200)
    private String fiGuid;

    // id hồ sơ
    @Column(name = "FI_HS_ID")
    private Integer fiIdHS;

    // id Sản Phẩm
    @Column(name = "FI_PRO_ID")
    private Integer fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdDinhkem25() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdDinhkem25 that = (TbdDinhkem25) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }
}
