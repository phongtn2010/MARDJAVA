package com.nsw.mard.p04.model;

public class TbsPhuongthucKt04 {
    private Long id;
    private String maPhuongthuc;
    private String tenPhuongthuc;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMaPhuongthuc() {
        return this.maPhuongthuc;
    }

    public void setMaPhuongthuc(final String maPhuongthuc) {
        this.maPhuongthuc = maPhuongthuc;
    }

    public String getTenPhuongthuc() {
        return this.tenPhuongthuc;
    }

    public void setTenPhuongthuc(final String tenPhuongthuc) {
        this.tenPhuongthuc = tenPhuongthuc;
    }
}