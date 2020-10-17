/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model;

/**
 *
 * @author NguyenQuang
 */
public class TokenInfo {
    private String user; 
    private String signatureXml;    
    private String messageXml;
    private String msgFunc;
    private String msgType;
    private String ministryCode;
    private String proceduceCode;
    private String documentCode;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSignatureXml() {
        return signatureXml;
    }

    public void setSignatureXml(String signatureXml) {
        this.signatureXml = signatureXml;
    }

    public String getMessageXml() {
        return messageXml;
    }

    public void setMessageXml(String messageXml) {
        this.messageXml = messageXml;
    }

    public String getMsgFunc() {
        return msgFunc;
    }

    public void setMsgFunc(String msgFunc) {
        this.msgFunc = msgFunc;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public String getProceduceCode() {
        return proceduceCode;
    }

    public void setProceduceCode(String proceduceCode) {
        this.proceduceCode = proceduceCode;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }
}
