/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import java.util.Date;

/**
 *
 * @author Nhan
 */
class Tbdketqua {

    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String fiTrangthai;

    private Date fiNgaytiepnhan;

    private Date fiNgayky;

    private Date fiNgaycap;

    private Date fiNgaythuhoi;

    private String fiLydothuhoi;

    private Long fiMadvthu;

    private String fiTendvthu;

    private String fiMatcgd;

    private String fiTentcgd;

    public Tbdketqua() {
    }

    public Tbdketqua(Long fiId, String fiTrangthai, Date fiNgaytiepnhan, Date fiNgayky, Date fiNgaycap, Date fiNgaythuhoi, String fiLydothuhoi, Long fiMadvthu, String fiTendvthu, String fiMatcgd, String fiTentcgd) {
        this.fiId = fiId;
        this.fiTrangthai = fiTrangthai;
        this.fiNgaytiepnhan = fiNgaytiepnhan;
        this.fiNgayky = fiNgayky;
        this.fiNgaycap = fiNgaycap;
        this.fiNgaythuhoi = fiNgaythuhoi;
        this.fiLydothuhoi = fiLydothuhoi;
        this.fiMadvthu = fiMadvthu;
        this.fiTendvthu = fiTendvthu;
        this.fiMatcgd = fiMatcgd;
        this.fiTentcgd = fiTentcgd;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(String fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Date getFiNgaytiepnhan() {
        return fiNgaytiepnhan;
    }

    public void setFiNgaytiepnhan(Date fiNgaytiepnhan) {
        this.fiNgaytiepnhan = fiNgaytiepnhan;
    }

    public Date getFiNgayky() {
        return fiNgayky;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public Date getFiNgaycap() {
        return fiNgaycap;
    }

    public void setFiNgaycap(Date fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public Date getFiNgaythuhoi() {
        return fiNgaythuhoi;
    }

    public void setFiNgaythuhoi(Date fiNgaythuhoi) {
        this.fiNgaythuhoi = fiNgaythuhoi;
    }

    public String getFiLydothuhoi() {
        return fiLydothuhoi;
    }

    public void setFiLydothuhoi(String fiLydothuhoi) {
        this.fiLydothuhoi = fiLydothuhoi;
    }

    public Long getFiMadvthu() {
        return fiMadvthu;
    }

    public void setFiMadvthu(Long fiMadvthu) {
        this.fiMadvthu = fiMadvthu;
    }

    public String getFiTendvthu() {
        return fiTendvthu;
    }

    public void setFiTendvthu(String fiTendvthu) {
        this.fiTendvthu = fiTendvthu;
    }

    public String getFiMatcgd() {
        return fiMatcgd;
    }

    public void setFiMatcgd(String fiMatcgd) {
        this.fiMatcgd = fiMatcgd;
    }

    public String getFiTentcgd() {
        return fiTentcgd;
    }

    public void setFiTentcgd(String fiTentcgd) {
        this.fiTentcgd = fiTentcgd;
    }

 
   
}
