/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model;

/**
 *
 * @author PhongNguyen
 */
public class ToKhai {

    private Long soToKhai;
    private String ngayDangKy;
    private String maHaiQuan;
    private Long status;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
    
    public Long getSoToKhai() {
        return soToKhai;
    }

    public void setSoToKhai(Long soToKhai) {
        this.soToKhai = soToKhai;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    

    public String getMaHaiQuan() {
        return maHaiQuan;
    }

    public void setMaHaiQuan(String maHaiQuan) {
        this.maHaiQuan = maHaiQuan;
    }

}
