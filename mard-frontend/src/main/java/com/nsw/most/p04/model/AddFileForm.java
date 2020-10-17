/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p04.model;

import java.util.List;

/**
 *
 * @author QUANGNV18
 */
public class AddFileForm {
    private String fiThongtin;
    private Long fiIdHoso;
    private List<Tbddinhkem4> lstDinhkem;

    public String getFiThongtin() {
        return fiThongtin;
    }

    public void setFiThongtin(String fiThongtin) {
        this.fiThongtin = fiThongtin;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public List<Tbddinhkem4> getLstDinhkem() {
        return lstDinhkem;
    }

    public void setLstDinhkem(List<Tbddinhkem4> lstDinhkem) {
        this.lstDinhkem = lstDinhkem;
    }    
}
