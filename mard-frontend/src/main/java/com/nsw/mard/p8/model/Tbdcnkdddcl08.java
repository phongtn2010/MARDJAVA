/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbdcnkdddcl08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdQuarLoc;

    private Long fiIdHS;

    private String fiIsoLocName;

    private String fiIsoLocAddress;

    public Tbdcnkdddcl08() {
    }

    public Tbdcnkdddcl08(String fiIsoLocName, String fiIsoLocAddress) {
        this.fiIsoLocName = fiIsoLocName;
        this.fiIsoLocAddress = fiIsoLocAddress;
    }

}
