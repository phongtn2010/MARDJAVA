package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDANIMALPRODUCTCN01", schema = "MARD")
public class TbdAnimailProductCN01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDANIMALPRODUCTCN01_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_ANIMAIL_PRODUCT_CN", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdAnimailProductCN;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID", length = 250)
    private String fiID;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    @Column(name = "FI_TYPE_PRODUCT", length = 250)
    private String fiTypeProduct;

    @Column(name = "FI_BACTCH_NUMBER", length = 250)
    private String fiBactchNumber;

    @Column(name = "FI_PACKAGE_TYPE", length = 250)
    private String fiPackageType;

    @Column(name = "FI_NUMBER_PACKAGE")
    private long fiNumberPackage;

    @Column(name = "FI_UNIT_CODE", length = 5)
    private String fiUnitCode;

    @Column(name = "FI_UNIT", length = 50)
    private String fiUnit;

    @Column(name = "FI_NET_WEIGHT")
    private float fiNetWeight;

    @Column(name = "FI_NET_WEIGHT_UNIT_NAME", length = 50)
    private String fiNetWeightUnitName;

    @Column(name = "FI_MARK_NO", length = 50)
    private String fiMarkNo;
}
