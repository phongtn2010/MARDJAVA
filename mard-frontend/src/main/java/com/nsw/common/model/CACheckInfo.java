/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model;

/**
 *
 * @author Nguyen Phong
 */
public class CACheckInfo {
    private String fiXmlSigned;
    private String fiTaxCode;

    public CACheckInfo() {
    }

    public CACheckInfo(String fiXmlSigned, String fiTaxCode) {
        this.fiXmlSigned = fiXmlSigned;
        this.fiTaxCode = fiTaxCode;
    }

    public String getFiXmlSigned() {
        return fiXmlSigned;
    }

    public void setFiXmlSigned(String fiXmlSigned) {
        this.fiXmlSigned = fiXmlSigned;
    }

    public String getFiTaxCode() {
        return fiTaxCode;
    }

    public void setFiTaxCode(String fiTaxCode) {
        this.fiTaxCode = fiTaxCode;
    }
}
