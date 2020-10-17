/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.p02.model;

import java.util.Date;
import java.util.List;

public class SendMessage1 extends BaseMessage {

    private String reason;
    private String fiSoGp;
    private Long idGP;
    private String soGp;
    private Long idFile;
    private String tenFile;
    private String urlFile;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFiSoGp() {
        return fiSoGp;
    }

    public void setFiSoGp(String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public Long getIdGP() {
        return idGP;
    }

    public void setIdGP(Long idGP) {
        this.idGP = idGP;
    }

    public String getSoGp() {
        return soGp;
    }

    public void setSoGp(String soGp) {
        this.soGp = soGp;
    }

    public Long getIdFile() {
        return idFile;
    }

    public void setIdFile(Long idFile) {
        this.idFile = idFile;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    
    
}
