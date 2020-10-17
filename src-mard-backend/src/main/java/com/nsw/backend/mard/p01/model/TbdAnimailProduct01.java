package com.nsw.backend.mard.p01.model;


import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDANIMAILPRODUCT01", schema = "MARD")
public class TbdAnimailProduct01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDANIMAILPRODUCT01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_ANIMAIL_PRODUCT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdAnimailProduct;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ANIMAL_PRODUCT_ID", length = 10)
    private String fiAnimalProductID;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    @Column(name = "FI_PRODUCT_NAME_VNI", length = 250, nullable = false)
    private String fiProductNameVni;

    @Column(name = "FI_PRODUCT_NAME", length = 250, nullable = false)
    private String fiProductName;

    @Column(name = "FI_PACKAGE_TYPE_VNI", length = 250, nullable = false)
    private String fiPackageTypeVni;

    @Column(name = "FI_PACKAGE_TYPE", length = 250, nullable = false)
    private String fiPackageType;

    @Column(name = "FI_NUMBER", nullable = false)
    private Long fiNumber;

    @Column(name = "FI_UNIT_CODE", length = 5, nullable = false)
    private String fiUnitCode;

    @Column(name = "FI_UNIT_VNI", length = 50, nullable = false)
    private String fiUnitVni;

    @Column(name = "FI_UNIT", length = 50, nullable = false)
    private String fiUnit;

    @Column(name = "FI_NET_WEIGHT", nullable = false)
    private float fiNetWeight;

    @Column(name = "FI_NET_WEIGHT_UNIT_CODE", length = 5, nullable = false)
    private String fiNetWeightUnitCode;

    @Column(name = "FI_NET_WEIGHT_UNIT_VNI", length = 50, nullable = false)
    private String fiNetWeightUnitVni;

    @Column(name = "FI_NET_WEIGHT_UNIT", length = 50, nullable = false)
    private String fiNetWeightUnit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_FROM_DATE_PRODUCT", nullable = false)
    private Date fiFromDateProduct;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TO_DATE_PRODUCT", nullable = false)
    private Date fiToDateProduct;

    @Column(name = "FI_LOT_IDENTIFICATION_NO", length = 50, nullable = false)
    private String fiLotIdentificationNo;

    @Column(name = "FI_PURPOSE_VNI", length = 50, nullable = false)
    private String fiPurposeVni;

    @Column(name = "FI_MARK_NO", length = 50)
    private String fiMarkNo;

    @Column(name = "FI_PURPOSE", length = 50, nullable = false)
    private String fiPurpose;

    @Column(name = "FI_SHIPMENTVALUE")
    private Float fiShipmentvalue;

}
