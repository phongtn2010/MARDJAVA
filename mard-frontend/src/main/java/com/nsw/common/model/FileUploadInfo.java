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
public class FileUploadInfo {
    private String fileName;
    private String ministryCode;
    private String procedureCode;
    
    public FileUploadInfo(String fName, String minCode, String proCode) {
        this.fileName = fName;
        this.ministryCode = minCode;
        this.procedureCode = proCode;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }
}
