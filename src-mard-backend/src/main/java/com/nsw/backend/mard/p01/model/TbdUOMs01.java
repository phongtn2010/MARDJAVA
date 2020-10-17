package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDUOMS01", schema = "MARD")
public class TbdUOMs01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDUOMS01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_UOM", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdUOM;

    @Column(name = "FI_UNIT_CODE")
    private String fiUnitCode;

    @Column(name = "FI_UNIT_CODE_VNI")
    private String fiUnitNameVni;

    @Column(name = "FI_UNIT_NAME")
    private String fiUnitName;

    public TbdUOMs01(String fiUnitCode, String fiUnitNameVni, String fiUnitName) {
        this.fiUnitCode = fiUnitCode;
        this.fiUnitNameVni = fiUnitNameVni;
        this.fiUnitName = fiUnitName;
    }

    public TbdUOMs01() {
        super();
    }
}
