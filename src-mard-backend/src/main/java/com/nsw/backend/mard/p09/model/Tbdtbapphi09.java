package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p09.dto.receive.AnimalFee;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDTBAPPHI09", schema = "MARD")
public class Tbdtbapphi09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_ANIMAL_FEE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTBAPPHI09_SEQ")
    @SequenceGenerator(sequenceName = "TBDTBAPPHI09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDTBAPPHI09_SEQ")
    private Long fiIdAnimalFee;

    @Column(name = "FI_HS_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_TOTAL_FEE", precision = 15, scale = 3)
    private Double fiTotalFee;

    @Column(name = "FI_AMOUNT_WORDS")
    private String fiAmountInWords;

    @Column(name = "FI_NOTE", length = 2000)
    private String fiNote;

    @Column(name = "FI_DEPARTMENT")
    private String fiDepartment;

    @Column(name = "FI_CREATOR_NAME")
    private String fiCreaterName;

    public static Tbdtbapphi09 parse(AnimalFee animalFee) {
        Tbdtbapphi09 fee = new Tbdtbapphi09();
        BeanUtils.copyProperties(animalFee, fee);
        return fee;
    }
}
