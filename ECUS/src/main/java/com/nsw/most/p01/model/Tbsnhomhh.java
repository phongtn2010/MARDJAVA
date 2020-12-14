package com.nsw.most.p01.model;

import java.util.Date;

public class Tbsnhomhh {
    
    private Long fiId;

    private String fiMa;

    private String fiTen;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    public Tbsnhomhh() {
        super();
    }

    
    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return this.fiId;
    }

    public void setFiMa(String fiMa) {
        this.fiMa = fiMa;
    }

    public String getFiMa() {
        return this.fiMa;
    }

    public void setFiTen(String fiTen) {
        this.fiTen = fiTen;
    }

    public String getFiTen() {
        return this.fiTen;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }
    
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }
    
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiId);
        sb.append("]:");
        sb.append(fiMa);
        sb.append("|");
        sb.append(fiTen);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        return sb.toString();
    }
}
