/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.model;

/**
 *
 * @author Nguyen Phong
 */
public class XmlMessage {

    private String fiDocumentCode;
    private String fiXml;
    private String fiFunc;
    private String fiMsgType;
    private String fiMinistryCode;
    private Long fiDocumentId;
    private String fiDocumentType;
    private String fiData;

    public String getFiDocumentCode() {
        return fiDocumentCode;
    }

    public void setFiDocumentCode(String fiDocumentCode) {
        this.fiDocumentCode = fiDocumentCode;
    }

    public String getFiXml() {
        return fiXml;
    }

    public void setFiXml(String fiXml) {
        this.fiXml = fiXml;
    }

    public String getFiFunc() {
        return fiFunc;
    }

    public void setFiFunc(String fiFunc) {
        this.fiFunc = fiFunc;
    }

    public String getFiMsgType() {
        return fiMsgType;
    }

    public void setFiMsgType(String fiMsgType) {
        this.fiMsgType = fiMsgType;
    }

    public String getFiMinistryCode() {
        return fiMinistryCode;
    }

    public void setFiMinistryCode(String fiMinistryCode) {
        this.fiMinistryCode = fiMinistryCode;
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
}
