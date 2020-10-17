/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model;

/**
 *
 * @author QUANGNV18
 */
public class SignData {
    private Object fiXml;
    private Object fiXmlEncode;
    private Object fiHash;
    private Object fiHashEncode;
    private String fiMsgType;
    private String fiFunc;
    private String fiDocType;
    
    private String taxCode;
    private String fiDocumentCode;
    private String ministryCode;
    private Long fiDocumentId;
    private String fiDocumentType;
    private String fiData;

    public Object getFiXml() {
        return fiXml;
    }

    public void setFiXml(Object fiXml) {
        this.fiXml = fiXml;
    }

    public Object getFiHash() {
        return fiHash;
    }

    public void setFiHash(Object fiHash) {
        this.fiHash = fiHash;
    }

    public String getFiMsgType() {
        return fiMsgType;
    }

    public void setFiMsgType(String fiMsgType) {
        this.fiMsgType = fiMsgType;
    }

    public String getFiFunc() {
        return fiFunc;
    }

    public void setFiFunc(String fiFunc) {
        this.fiFunc = fiFunc;
    }

    public String getFiDocType() {
        return fiDocType;
    }

    public void setFiDocType(String fiDocType) {
        this.fiDocType = fiDocType;
    }    

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getFiDocumentCode() {
        return fiDocumentCode;
    }

    public void setFiDocumentCode(String fiDocumentCode) {
        this.fiDocumentCode = fiDocumentCode;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public Long getFiDocumentId() {
        return fiDocumentId;
    }

    public void setFiDocumentId(Long fiDocumentId) {
        this.fiDocumentId = fiDocumentId;
    }

    public String getFiDocumentType() {
        return fiDocumentType;
    }

    public void setFiDocumentType(String fiDocumentType) {
        this.fiDocumentType = fiDocumentType;
    }

    public String getFiData() {
        return fiData;
    }

    public void setFiData(String fiData) {
        this.fiData = fiData;
    }

    public Object getFiXmlEncode() {
        return fiXmlEncode;
    }

    public void setFiXmlEncode(Object fiXmlEncode) {
        this.fiXmlEncode = fiXmlEncode;
    }

    public Object getFiHashEncode() {
        return fiHashEncode;
    }

    public void setFiHashEncode(Object fiHashEncode) {
        this.fiHashEncode = fiHashEncode;
    }
}
