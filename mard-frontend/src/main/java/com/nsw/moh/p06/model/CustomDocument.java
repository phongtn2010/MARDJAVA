/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

public class CustomDocument {
    private Boolean hasPermission;
    private Tbdhoso6 document;
    
    public CustomDocument(){}
    
    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Tbdhoso6 getDocument() {
        return document;
    }

    public void setDocument(Tbdhoso6 document) {
        this.document = document;
    }
}