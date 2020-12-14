/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdDnChuyenCkHh03 {

    private Long id;
    private Long fiIdChuyenCk;
    private Long fiStt;//
    private Long fiIdHanghoa;//
    private String fiTenhang;//
    private Long fiSoluong;//
    private String fiMaDvSl;//
    private String fiTenDvSl;//
    private Long fiKhoiluong;//
    private String fiMaDvKl;//
    private String fiTenDvKl;//
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;

    public TbdDnChuyenCkHh03() {
    }

    public TbdDnChuyenCkHh03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFiIdChuyenCk() {
        return fiIdChuyenCk;
    }

    public void setFiIdChuyenCk(Long fiIdChuyenCk) {
        this.fiIdChuyenCk = fiIdChuyenCk;
    }

    public Long getFiStt() {
        return fiStt;
    }

    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiIdHanghoa() {
        return fiIdHanghoa;
    }

    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public String getFiTenhang() {
        return fiTenhang;
    }

    public void setFiTenhang(String fiTenhang) {
        this.fiTenhang = fiTenhang;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiMaDvSl() {
        return fiMaDvSl;
    }

    public void setFiMaDvSl(String fiMaDvSl) {
        this.fiMaDvSl = fiMaDvSl;
    }

    public String getFiTenDvSl() {
        return fiTenDvSl;
    }

    public void setFiTenDvSl(String fiTenDvSl) {
        this.fiTenDvSl = fiTenDvSl;
    }

    public Long getFiKhoiluong() {
        return fiKhoiluong;
    }

    public void setFiKhoiluong(Long fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public String getFiMaDvKl() {
        return fiMaDvKl;
    }

    public void setFiMaDvKl(String fiMaDvKl) {
        this.fiMaDvKl = fiMaDvKl;
    }

    public String getFiTenDvKl() {
        return fiTenDvKl;
    }

    public void setFiTenDvKl(String fiTenDvKl) {
        this.fiTenDvKl = fiTenDvKl;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdDnChuyenCkHh03)) {
            return false;
        }
        TbdDnChuyenCkHh03 other = (TbdDnChuyenCkHh03) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p03.model.TbdDnChuyenCkHh03[ id=" + id + " ]";
    }

}
