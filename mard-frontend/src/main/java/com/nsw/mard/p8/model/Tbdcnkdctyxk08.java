/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbdcnkdctyxk08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdExporter;

    private Long fiIdCV;

    private String fiExporterName;

    private String fiExporterAddress;

    public Tbdcnkdctyxk08() {
    }

    public Tbdcnkdctyxk08(String fiExporterName, String fiExporterAddress) {
        this.fiExporterName = fiExporterName;
        this.fiExporterAddress = fiExporterAddress;
    }

}
