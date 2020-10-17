/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

/**
 *
 * @author PhongNguyen
 */
public class CustomDocument {
    private Boolean hasPermission;
    private Tbdhoso1 document;
    
    public CustomDocument(){}
    
    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Tbdhoso1 getDocument() {
        return document;
    }

    public void setDocument(Tbdhoso1 document) {
        this.document = document;
    }
}
