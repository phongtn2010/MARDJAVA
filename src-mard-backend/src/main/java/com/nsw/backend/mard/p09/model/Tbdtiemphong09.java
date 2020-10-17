package com.nsw.backend.mard.p09.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDTIEMPHONG09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDTIEMPHONG09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdtiemphong09.countAll", query = "SELECT COUNT(x) FROM Tbdtiemphong09 x")
})
@NoArgsConstructor
public class Tbdtiemphong09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_TP", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTIEMPHONG09_SEQ")
    @SequenceGenerator(sequenceName = "TBDTIEMPHONG09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDTIEMPHONG09_SEQ")
    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_ID_GIAY_CNKD")
    private Long fiIdQuarantineCer;

    @Column(name = "FI_DISEASE_NAME", length = 250)
    private String fiDiseaseName;

    @Column(name = "FI_VACCINATION_DATE", length = 250)
    private Date fiVaccinationDate;

}
