package com.nsw.backend.mard.p09.model;


import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDDINHKEM09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDGIAYTO09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdgiayto09.countAll", query = "SELECT COUNT(x) FROM Tbdgiayto09 x")
})
public class Tbdgiayto09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_GIAY_TO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDGIAYTO09_SEQ")
    @SequenceGenerator(sequenceName = "TBDGIAYTO09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDGIAYTO09_SEQ")
    private Long fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_TYPE_DOC", nullable = false)
    private Long fiTypeDoc;

    @Column(name = "FI_NUMBER", nullable = false, length = 50)
    private String fiNumber;

    @Column(name = "FI_DATE", nullable = false)
    private Date fiDate;

    @Column(name = "FI_BILL_NO", length = 50)
    private String fiBillNo;
}
