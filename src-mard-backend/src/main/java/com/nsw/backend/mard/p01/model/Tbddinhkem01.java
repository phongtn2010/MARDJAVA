package com.nsw.backend.mard.p01.model;

import com.google.common.base.Objects;
import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDDINHKEM01", schema = "MARD")
public class Tbddinhkem01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDDINHKEM01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_ATTACMENT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdAttacment;

    @Column(name = "FI_ACTIVE", nullable = false)
    private long fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ATTACHMENT_ID", length = 9)
    private String fiAttachmentId;

    @Column(name = "FI_ATTACHMENT_TYPE_CODE")
    private Integer fiAttachmentTypeCode;

    @Column(name = "FI_ATTACHMENT_TYPE_NAME", length = 250)
    private String fiAttachmentTypeName;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    // id hồ sơ
    @Column(name = "FI_MA_DT")
    private Long fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbddinhkem01() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbddinhkem01 that = (Tbddinhkem01) o;
        return Objects.equal(fiIdAttacment, that.fiIdAttacment);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdAttacment);
    }
}
