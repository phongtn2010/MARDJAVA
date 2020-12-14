package com.nsw.mard.p04.model;

public class TbsDmQuocgia04 {
    private Long id;
    private String maQuocgia;
    private String tenQuocgia;

    public TbsDmQuocgia04() {
    }

    public TbsDmQuocgia04(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMaQuocgia() {
        return this.maQuocgia;
    }

    public void setMaQuocgia(final String maQuocgia) {
        this.maQuocgia = maQuocgia;
    }

    public String getTenQuocgia() {
        return this.tenQuocgia;
    }

    public void setTenQuocgia(final String tenQuocgia) {
        this.tenQuocgia = tenQuocgia;
    }
}