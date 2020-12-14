package com.nsw.monre.p08.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbdhsdsPhelieu8 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdPhelieu;

    private Long fiIdHoso;

    private String fiTenPhelieu;

    private String fiMaHoso;

    private BigDecimal fiKhoiLuong;

    private Long fiHoatdong;

    private String fiMaPhelieu;

    private Date fiNgaytao;

    private Date fiNgaycapnhat;
    private Long fiLoaiPheLieu;

    public TbdhsdsPhelieu8() {
        super();
    }

    public Long getFiIdPhelieu() {
        return fiIdPhelieu;
    }

    public void setFiIdPhelieu(Long fiIdPhelieu) {
        this.fiIdPhelieu = fiIdPhelieu;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiTenPhelieu() {
        return fiTenPhelieu;
    }

    public void setFiTenPhelieu(String fiTenPhelieu) {
        this.fiTenPhelieu = fiTenPhelieu;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }


    public BigDecimal getFiKhoiLuong() {
        return fiKhoiLuong;
    }

    public void setFiKhoiLuong(BigDecimal fiKhoiLuong) {
        this.fiKhoiLuong = fiKhoiLuong;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiMaPhelieu() {
        return fiMaPhelieu;
    }

    public void setFiMaPhelieu(String fiMaPhelieu) {
        this.fiMaPhelieu = fiMaPhelieu;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
    }

    public Long getFiLoaiPheLieu() {
        return fiLoaiPheLieu;
    }

    public void setFiLoaiPheLieu(Long fiLoaiPheLieu) {
        this.fiLoaiPheLieu = fiLoaiPheLieu;
    }

    

}
