package com.nsw.mard.p04.model;

import java.util.Date;
import java.util.List;

public class TbdDnXinGiahan04 {
    private Long fiId;
    private String fiMaHoso;
    private Long fiIdHoso;
    private String fiLydo;
    private Date fiThoihanNop;
    private Long fiMaTrangthai;
    private String fiTrangthai;
    private Long fiHoatdong;
    private Date fiNgaytao;

    private List<TbdDinhkemXinGh04> lstDinhkem;

    public TbdDnXinGiahan04() {
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Date getFiThoihanNop() {
        return fiThoihanNop;
    }

    public void setFiThoihanNop(Date fiThoihanNop) {
        this.fiThoihanNop = fiThoihanNop;
    }

    public Long getFiMaTrangthai() {
        return fiMaTrangthai;
    }

    public void setFiMaTrangthai(Long fiMaTrangthai) {
        this.fiMaTrangthai = fiMaTrangthai;
    }

    public String getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(String fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public List<TbdDinhkemXinGh04> getLstDinhkem() {
        return lstDinhkem;
    }

    public void setLstDinhkem(List<TbdDinhkemXinGh04> lstDinhkem) {
        this.lstDinhkem = lstDinhkem;
    }
}