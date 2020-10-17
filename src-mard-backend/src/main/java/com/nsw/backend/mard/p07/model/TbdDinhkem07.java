package com.nsw.backend.mard.p07.model;

import com.google.common.base.Objects;
import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDDINHKEM06"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDDINHKEM07", schema = "MARD")
public class TbdDinhkem07 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDINHKEM07_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_DINH_KEM", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdDinhkem;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_FILE_TYPE_CODE", nullable = false)
    private Integer fiFileTypeCode;

    @Column(name = "FI_FILE_TYPE_NAME", nullable = false)
    private String fiFileTypeName;

    @Column(name = "FI_FILE_NAME", nullable = false)
    private String fiFileName;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Integer fiActive;

    @Lob
    @Column(name = "FI_PATH", length = 2000)
    private String fiPath;

    @Column(name = "FI_GUID", length = 200)
    private String fiGuid;

    // id hồ sơ
    @Column(name = "FI_HS_ID")
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdDinhkem07() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdDinhkem07 that = (TbdDinhkem07) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }
}
