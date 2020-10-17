package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDANIMAL01", schema = "MARD")
public class TbdAnimal01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDANIMAL01_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_ANIMAIL", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdAnimail;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID", length = 10)
    private String fiID;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    @Column(name = "FI_ANIMAL_TYPE_VNI", length = 100, nullable = false)
    private String fiAnimalTypeVni;

    @Column(name = "FI_ANIMAL_TYPE", length = 100, nullable = false)
    private String fiAnimalType;

    @Column(name = "FI_BREED_VNI", length = 100, nullable = false)
    private String fiBreedVni;

    @Column(name = "FI_BREED", length = 100, nullable = false)
    private String fiBreed;

    @Column(name = "FI_AGE", length = 50, nullable = false)
    private String fiAge;

    @Column(name = "FI_SEX", nullable = false)
    private Integer fiSex;

    @Column(name = "FI_NUMBER", nullable = false)
    private Long fiNumber;

    @Column(name = "FI_ANIMAL_NET_WEIGHT", nullable = false)
    private Long fiAnimalNetWeight;

    @Column(name = "FI_ANIMAL_UNIT_CODE", length = 50, nullable = false)
    private String fiAnimalUnitCode;

    @Column(name = "FI_ANIMAL_UNIT_VNI", length = 50, nullable = false)
    private String fiAnimalUnitVni;

    @Column(name = "FI_ANIMAL_UNIT", length = 50, nullable = false)
    private String fiAnimalUnit;

    @Column(name = "FI_PURPOSE_VNI", length = 250)
    private String fiPurposeVni;

    @Column(name = "FI_PURPOSE", length = 250, nullable = false)
    private String fiPurpose;

    @Column(name = "FI_SHIPMENTVALUE")
    private Float fiShipmentvalue;
}
