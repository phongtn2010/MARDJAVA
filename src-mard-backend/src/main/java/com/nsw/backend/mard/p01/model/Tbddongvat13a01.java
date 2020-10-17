package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDDONGVAT13A01", schema = "MARD")
public class Tbddongvat13a01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDDONGVAT13A01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "fi_Id_DV_13A", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdDV13A;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID", length = 100)
    private String fiID;

    @Column(name = "FI_ANIMAL_TYPE_VNI", length = 100)
    private String fiAnimalTypeVni;

    @Column(name = "FI_ANIMAL_TYPE", length = 100)
    private String fiAnimalType;

    @Column(name = "FI_OFFICIAL_MARK", length = 100)
    private String fiOfficialMark;

    @Column(name = "FI_BREED_VNI", length = 100)
    private String fiBreedVni;

    @Column(name = "FI_BREED", length = 100)
    private String fiBreed;

    @Column(name = "FI_AGE", length = 100)
    private String fiAge;

    @Column(name = "FI_SEX")
    private Integer fiSex;
}
