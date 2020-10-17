package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDTBXNCLHH09", schema = "MARD")
public class TbdTbXnclHh09 implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "TBDTBXNCLHH09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdHh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_CV_ID")
    private Long fiIdCV;

    private String fiCodeOfGoods;
    private String fiNameOfGoods;

    private Double fiQuantityOrVolumn;
}
