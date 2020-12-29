/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p25.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "25" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHANGHOACL25", schema = "MARD")
public class TbdHanghoaCL25 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOACL25_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdProCL;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_PRO_ID")
    private Integer fiIdProduct;

    @Column(name = "FI_PROCL_TARG")
    private String fiProCLTarg;

    @Column(name = "FI_PROCL_COMPARE")
    private String fiProCLCompare;

    @Column(name = "FI_PROCL_CONTENT")
    private String fiProCLContent;

    @Column(name = "FI_PROCL_UNIT_ID")
    private String fiProCLUnitID;

    @Column(name = "FI_PROCL_UNIT_NAME")
    private String fiProCLUnitName;

    public String tbdHanghoaCL25ToString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fiProCLTarg).append("|").append(fiProCLCompare).append("|").append(fiProCLContent).append("|").append(fiProCLUnitID);
        return stringBuffer.toString();
    }
}
