/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.p02.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fujitsu
 */
public class TbdHoso02 implements Serializable {

    private static final long serialVersionUID = 1L;
   private Long fiIdHoSo;
    private String fiMaHoSo;
    private String fiSoDonDeNghi;
    private String fiNoiCapGpTen;
    private String fiNoiCapGpMa;
    private String fiTtcFax;
    private String fiCmnd;
    private String fiNoiCapCmnd;
    private Date fiNgayCapCmnd;
    private String fiNguoiLienHe;
    private String fiMucDichNk;
    private String fiMucDichNkKhac;
    private String fiDcDatMayLanDau;
    private String fiNguoiKy;
    private String fiChucDanh;
    private Long fiMaTrangThai;
    private Date fiNgayTao;
    private String fiNguoiTao;
    private Long fiHoatDong;
    private Date fiNgayGui;
    private Date fiNgayKy;
    private Date fiNgaycapGp;
    private String fiTenTrangThai;
    private String fiTtcTenToChuc;
    private String fiTtcDiaChi;
    private String fiTtcDienThoai;
    private String fiTtcMst;
    private String fiTtcEmail;
    private List<TbdThietBiNk02> lstThietBiNk02;
    private List<TbdDinhkem02> lstTeptin02;

    public TbdHoso02() {
    }

    public String getFiTtcTenToChuc() {
        return fiTtcTenToChuc;
    }

    public void setFiTtcTenToChuc(String fiTtcTenToChuc) {
        this.fiTtcTenToChuc = fiTtcTenToChuc;
    }

    public String getFiTtcDiaChi() {
        return fiTtcDiaChi;
    }

    public void setFiTtcDiaChi(String fiTtcDiaChi) {
        this.fiTtcDiaChi = fiTtcDiaChi;
    }

    public String getFiTtcDienThoai() {
        return fiTtcDienThoai;
    }

    public void setFiTtcDienThoai(String fiTtcDienThoai) {
        this.fiTtcDienThoai = fiTtcDienThoai;
    }

    public String getFiTtcFax() {
        return fiTtcFax;
    }

    public void setFiTtcFax(String fiTtcFax) {
        this.fiTtcFax = fiTtcFax;
    }

    public String getFiTtcEmail() {
        return fiTtcEmail;
    }

    public void setFiTtcEmail(String fiTtcEmail) {
        this.fiTtcEmail = fiTtcEmail;
    }

    public String getFiTtcMst() {
        return fiTtcMst;
    }

    public void setFiTtcMst(String fiTtcMst) {
        this.fiTtcMst = fiTtcMst;
    }

    public List<TbdThietBiNk02> getLstThietBiNk02() {
        return lstThietBiNk02;
    }

    public void setLstThietBiNk02(List<TbdThietBiNk02> lstThietBiNk02) {
        this.lstThietBiNk02 = lstThietBiNk02;
    }

    public List<TbdDinhkem02> getLstTeptin02() {
        return lstTeptin02;
    }

    public void setLstTeptin02(List<TbdDinhkem02> lstTeptin02) {
        this.lstTeptin02 = lstTeptin02;
    }

    public TbdHoso02(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public String getFiSoDonDeNghi() {
        return fiSoDonDeNghi;
    }

    public void setFiSoDonDeNghi(String fiSoDonDeNghi) {
        this.fiSoDonDeNghi = fiSoDonDeNghi;
    }

    public String getFiNoiCapGpTen() {
        return fiNoiCapGpTen;
    }

    public void setFiNoiCapGpTen(String fiNoiCapGpTen) {
        this.fiNoiCapGpTen = fiNoiCapGpTen;
    }

    public String getFiNoiCapGpMa() {
        return fiNoiCapGpMa;
    }

    public void setFiNoiCapGpMa(String fiNoiCapGpMa) {
        this.fiNoiCapGpMa = fiNoiCapGpMa;
    }

    public String getFiCmnd() {
        return fiCmnd;
    }

    public void setFiCmnd(String fiCmnd) {
        this.fiCmnd = fiCmnd;
    }

    public String getFiNoiCapCmnd() {
        return fiNoiCapCmnd;
    }

    public void setFiNoiCapCmnd(String fiNoiCapCmnd) {
        this.fiNoiCapCmnd = fiNoiCapCmnd;
    }

    public Date getFiNgayCapCmnd() {
        return fiNgayCapCmnd;
    }

    public void setFiNgayCapCmnd(Date fiNgayCapCmnd) {
        this.fiNgayCapCmnd = fiNgayCapCmnd;
    }

    public String getFiNguoiLienHe() {
        return fiNguoiLienHe;
    }

    public void setFiNguoiLienHe(String fiNguoiLienHe) {
        this.fiNguoiLienHe = fiNguoiLienHe;
    }

    public String getFiMucDichNk() {
        return fiMucDichNk;
    }

    public void setFiMucDichNk(String fiMucDichNk) {
        this.fiMucDichNk = fiMucDichNk;
    }

    public String getFiMucDichNkKhac() {
        return fiMucDichNkKhac;
    }

    public void setFiMucDichNkKhac(String fiMucDichNkKhac) {
        this.fiMucDichNkKhac = fiMucDichNkKhac;
    }

    public String getFiDcDatMayLanDau() {
        return fiDcDatMayLanDau;
    }

    public void setFiDcDatMayLanDau(String fiDcDatMayLanDau) {
        this.fiDcDatMayLanDau = fiDcDatMayLanDau;
    }

    public String getFiNguoiKy() {
        return fiNguoiKy;
    }

    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public String getFiChucDanh() {
        return fiChucDanh;
    }

    public void setFiChucDanh(String fiChucDanh) {
        this.fiChucDanh = fiChucDanh;
    }

    public Long getFiMaTrangThai() {
        return fiMaTrangThai;
    }

    public void setFiMaTrangThai(Long fiMaTrangThai) {
        this.fiMaTrangThai = fiMaTrangThai;
    }

    public String getFiTenTrangThai() {
        return fiTenTrangThai;
    }

    public void setFiTenTrangThai(String fiTenTrangThai) {
        this.fiTenTrangThai = fiTenTrangThai;
    }
 
    public Date getFiNgayTao() {
        return fiNgayTao;
    }

    public void setFiNgayTao(Date fiNgayTao) {
        this.fiNgayTao = fiNgayTao;
    }

    public String getFiNguoiTao() {
        return fiNguoiTao;
    }

    public void setFiNguoiTao(String fiNguoiTao) {
        this.fiNguoiTao = fiNguoiTao;
    }

    public Long getFiHoatDong() {
        return fiHoatDong;
    }

    public void setFiHoatDong(Long fiHoatDong) {
        this.fiHoatDong = fiHoatDong;
    }
    public Date getFiNgayGui() {
        return fiNgayGui;
    }

    public void setFiNgayGui(Date fiNgayGui) {
        this.fiNgayGui = fiNgayGui;
    }

    public Date getFiNgayKy() {
        return fiNgayKy;
    }

    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public Date getFiNgaycapGp() {
        return fiNgaycapGp;
    }

    public void setFiNgaycapGp(Date fiNgaycapGp) {
        this.fiNgaycapGp = fiNgaycapGp;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdHoSo != null ? fiIdHoSo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdHoso02)) {
            return false;
        }
        TbdHoso02 other = (TbdHoso02) object;
        if ((this.fiIdHoSo == null && other.fiIdHoSo != null) || (this.fiIdHoSo != null && !this.fiIdHoSo.equals(other.fiIdHoSo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mic.p02.model.TbdHoso02[ fiIdHoSo=" + fiIdHoSo + " ]";
    }
    
}
