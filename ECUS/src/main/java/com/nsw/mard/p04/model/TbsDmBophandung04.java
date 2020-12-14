package com.nsw.mard.p04.model;

public class TbsDmBophandung04 {
    private Long id;
    private Long maBpSudung;
    private String tenBpSudung;
    
    public TbsDmBophandung04() {
    }

    public TbsDmBophandung04(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getMaBpSudung() {
        return this.maBpSudung;
    }

    public void setMaBpSudung(final Long maBpSudung) {
        this.maBpSudung = maBpSudung;
    }

    public String getTenBpSudung() {
        return this.tenBpSudung;
    }

    public void setTenBpSudung(final String tenBpSudung) {
        this.tenBpSudung = tenBpSudung;
    }
}