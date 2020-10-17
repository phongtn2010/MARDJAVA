package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDCTYXK09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDCTYXK09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdctyxk09.countAll", query = "SELECT COUNT(x) FROM Tbdctyxk09 x")
})
public class Tbdctyxk09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_COMPANY", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCTYXK09_SEQ")
    @SequenceGenerator(sequenceName = "TBDCTYXK09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDCTYXK09_SEQ")
    private Long fiIdExporter;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_EXPORTER_NAME", length = 250)
    private String fiExporterName;

    @Column(name = "FI_EXPORTER_ADDRESS", length = 500)
    private String fiExporterAddress;

    @Column(name = "FI_COUNTRY_ORIGIN", length = 12)
    private String fiCountryOrigin;

    @Column(name = "FI_EXPORTER_TEL", length = 50)
    private String fiExporterTel;

    @Column(name = "FI_EXPORTER_FAX", length = 50)
    private String fiExporterFax;

    public Tbdctyxk09() {
    }

}
