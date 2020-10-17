/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

/**
 *
 * @author Nhan
 */
public class Tbsdonvinhanhs {

    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String fiMadonvi;
    private String fiTendonvi;

    public Tbsdonvinhanhs() {
    }

    public Tbsdonvinhanhs(Long fiId, String fiMadonvi, String fiTendonvi) {
        this.fiId = fiId;
        this.fiMadonvi = fiMadonvi;
        this.fiTendonvi = fiTendonvi;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiMadonvi() {
        return fiMadonvi;
    }

    public void setFiMadonvi(String fiMadonvi) {
        this.fiMadonvi = fiMadonvi;
    }

    public String getFiTendonvi() {
        return fiTendonvi;
    }

    public void setFiTendonvi(String fiTendonvi) {
        this.fiTendonvi = fiTendonvi;
    }
    
    
}
