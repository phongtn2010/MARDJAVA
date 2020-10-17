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
@Table(name = "TBDANIMALPRODUCTHKP01", schema = "MARD")
public class TbdAnimailProductHKP01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDANIMALPRODUCTHKP01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_PRODUCT_HKP", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdAnimailProductHKP;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID", length = 250)
    private String fiID;

    @Column(name = "FI_COMMODITY", length = 250)
    private String fiCommodity;

    @Column(name = "FI_QUANTITY")
    private Long fiQuantity;

    @Column(name = "FI_UNIT_CODE", length = 5)
    private String fiUnitCode;

    @Column(name = "FI_UNIT", length = 50)
    private String fiUnit;

    @Column(name = "FI_MARK_NO", length = 50)
    private String fiMarkNo;

    @Column(name = "FI_NET_WEIGHT")
    private float fiNetWeight;

    @Column(name = "FI_NET_WEIGHT_UNIT_NAME", length = 50)
    private String fiNetWeightUnitName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_FROM_DATE_PRODUCT")
    private Date fiFromDateProduct;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TO_DATE_PRODUCT")
    private Date fiToDateProduct;

    @Column(name = "FI_LOT_INDETIFICATION_NO", length = 100)
    private String fiLotIndetificationNo;

}
