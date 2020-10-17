package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p01.client.PhytosanitaryFee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDTBAP01", schema = "MARD")
public class Tbdtbap01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDTBAP01_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_TBAP", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdTBAP;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_NSW_FILE_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_TOTAL_FEE")
    private float fiTotalFee;

    @Column(name = "FI_TOTAL_FEE_TEXT", length = 50)
    private String fiTotalFeeText;

    @Column(name = "FI_NOTE", length = 250)
    private String fiNote;

    @Column(name = "FI_CREATER_NAME", length = 250)
    private String fiCreaterName;

    public static Tbdtbap01 parse(PhytosanitaryFee phytosanitaryFee) {
        Tbdtbap01 fee = new Tbdtbap01();
        BeanUtils.copyProperties(phytosanitaryFee, fee);
        return fee;
    }
}
