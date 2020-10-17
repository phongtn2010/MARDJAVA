package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;
/**
 * Persistent class for entity stored in table "TBDCTYXK09"
 *
 * @author Telosys Tools Generator
 *
 */

@Data
public class Tbdctyxk09 implements Serializable {
    private Long fiIdExporter;

    private Long fiIdHS;

    private String fiExporterName;

    private String fiExporterAddress;

    private String fiCountryOrigin;

    private String fiExporterTel;

    private String fiExporterFax;

    public Tbdctyxk09() {
    }

    public Tbdctyxk09(String fiExporterName, String fiExporterAddress) {
        this.fiExporterName = fiExporterName;
        this.fiExporterAddress = fiExporterAddress;
    }

    public Tbdctyxk09(String fiExporterName, String fiExporterAddress, String fiCountryOrigin, String fiExporterTel, String fiExporterFax) {
        this.fiExporterName = fiExporterName;
        this.fiExporterAddress = fiExporterAddress;
        this.fiCountryOrigin = fiCountryOrigin;
        this.fiExporterTel = fiExporterTel;
        this.fiExporterFax = fiExporterFax;
    }
}

