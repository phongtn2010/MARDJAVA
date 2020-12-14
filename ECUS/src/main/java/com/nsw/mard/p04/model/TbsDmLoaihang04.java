package com.nsw.mard.p04.model;

public class TbsDmLoaihang04 {
    private Long fiId;
    private Long fiMaLoaihang;
    private String fiTenLoaihang;
    private String fiLoaiDonDangky;

    public Long getFiId() {
        return this.fiId;
    }

    public void setFiId(final Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiMaLoaihang() {
        return this.fiMaLoaihang;
    }

    public void setFiMaLoaihang(final Long fiMaLoaihang) {
        this.fiMaLoaihang = fiMaLoaihang;
    }

    public String getFiTenLoaihang() {
        return this.fiTenLoaihang;
    }

    public void setFiTenLoaihang(final String fiTenLoaihang) {
        this.fiTenLoaihang = fiTenLoaihang;
    }

    public String getFiLoaiDonDangky() {
        return fiLoaiDonDangky;
    }

    public void setFiLoaiDonDangky(String fiLoaiDonDangky) {
        this.fiLoaiDonDangky = fiLoaiDonDangky;
    }
}