/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbdcnkdnmsx08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdFactory;

    private Long fiIdCV;

    private String fiFactoryName;

    private String fiFactoryAddress;

    private String fiCountryOrigin;

    public Tbdcnkdnmsx08() {
    }

    public Tbdcnkdnmsx08(String fiFactoryName, String fiFactoryAddress, String fiCountryOrigin) {
        this.fiFactoryName = fiFactoryName;
        this.fiFactoryAddress = fiFactoryAddress;
        this.fiCountryOrigin = fiCountryOrigin;
    }

}
