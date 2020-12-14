/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p02.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity Thong bao ket qua kiem tra
 *
 * @author quannn5
 */
public class Tbdtbkqkt2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdTbkqkt;

    private String fiMaHoso;

    private String fiDiadiemKt;

    private Date fiKtTuNgay;

    private Date fiKtDenNgay;

    private String fiNoidung;

    public Long getFiIdTbkqkt() {
        return fiIdTbkqkt;
    }

    public Tbdtbkqkt2(Long fiIdTbkqkt, String fiMaHoso, String fiDiadiemKt, Date fiKtTuNgay, Date fiKtDenNgay, String fiNoidung) {
        this.fiIdTbkqkt = fiIdTbkqkt;
        this.fiMaHoso = fiMaHoso;
        this.fiDiadiemKt = fiDiadiemKt;
        this.fiKtTuNgay = fiKtTuNgay;
        this.fiKtDenNgay = fiKtDenNgay;
        this.fiNoidung = fiNoidung;
    }

    public void setFiIdTbkqkt(Long fiIdTbkqkt) {
        this.fiIdTbkqkt = fiIdTbkqkt;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiDiadiemKt() {
        return fiDiadiemKt;
    }

    public void setFiDiadiemKt(String fiDiadiemKt) {
        this.fiDiadiemKt = fiDiadiemKt;
    }

    public Date getFiKtTuNgay() {
        return fiKtTuNgay;
    }

    public void setFiKtTuNgay(Date fiKtTuNgay) {
        this.fiKtTuNgay = fiKtTuNgay;
    }

    public Date getFiKtDenNgay() {
        return fiKtDenNgay;
    }

    public void setFiKtDenNgay(Date fiKtDenNgay) {
        this.fiKtDenNgay = fiKtDenNgay;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Tbdtbkqkt2() {
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdTbkqkt);
        sb.append("]:");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiDiadiemKt);
        sb.append("|");
        sb.append(fiKtTuNgay);
        sb.append("|");
        sb.append(fiKtDenNgay);
        sb.append("|");
        sb.append(fiNoidung);
        return sb.toString();
    }
}
