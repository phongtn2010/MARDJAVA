package com.nsw.mard.p8.model;

import lombok.Data;


import java.io.Serializable;

@Data
public class Tbdctyxksp08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdExporter;

    private Long fiIdHS;

    private String fiExporterName;

    private String fiExporterAddress;

    public Tbdctyxksp08() {
    }

    public Tbdctyxksp08(String fiExporterName, String fiExporterAddress) {
        this.fiExporterName = fiExporterName;
        this.fiExporterAddress = fiExporterAddress;
    }

}

