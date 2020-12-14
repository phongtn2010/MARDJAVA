package com.nsw.mard.p04.model;

import java.math.BigDecimal;

public class TbdDinhkemXinGh04 {
    private Long fiIdDk;
    private Long fiIdXinGh;
    private String fiIdServer;
    private Long fiMaLoaiTailieu;
    private String fiTenLoaiTailieu;
    private String fiTenTailieu;
    private String linkFile;
    private Long fiHoatdong;
    private BigDecimal fiSize;

    public TbdDinhkemXinGh04() {
    }

    public Long getFiIdDk() {
        return fiIdDk;
    }

    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdXinGh() {
        return fiIdXinGh;
    }

    public void setFiIdXinGh(Long fiIdXinGh) {
        this.fiIdXinGh = fiIdXinGh;
    }

    public String getFiIdServer() {
        return fiIdServer;
    }

    public void setFiIdServer(String fiIdServer) {
        this.fiIdServer = fiIdServer;
    }

    public Long getFiMaLoaiTailieu() {
        return fiMaLoaiTailieu;
    }

    public void setFiMaLoaiTailieu(Long fiMaLoaiTailieu) {
        this.fiMaLoaiTailieu = fiMaLoaiTailieu;
    }

    public String getFiTenLoaiTailieu() {
        return fiTenLoaiTailieu;
    }

    public void setFiTenLoaiTailieu(String fiTenLoaiTailieu) {
        this.fiTenLoaiTailieu = fiTenLoaiTailieu;
    }

    public String getFiTenTailieu() {
        return fiTenTailieu;
    }

    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public BigDecimal getFiSize() {
        return fiSize;
    }

    public void setFiSize(BigDecimal fiSize) {
        this.fiSize = fiSize;
    }
}