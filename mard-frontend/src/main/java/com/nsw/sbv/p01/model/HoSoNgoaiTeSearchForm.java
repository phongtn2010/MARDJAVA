package com.nsw.sbv.p01.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HoSoNgoaiTeSearchForm {

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}
	
	private Integer trangThai = -1;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}
	
	private Integer hinhThucXNK;
	public void setHinhThucXNK(Integer hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}
	public Integer getHinhThucXNK() {
		return this.hinhThucXNK;
	}
	
	private String maCuaKhau;
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fromNgayTao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date toNgayTao;
	public Date getFromNgayTao() {
		return fromNgayTao;
	}
	public void setFromNgayTao(Date fromNgayTao) {
		this.fromNgayTao = fromNgayTao;
	}
	public Date getToNgayTao() {
		return toNgayTao;
	}
	public void setToNgayTao(Date toNgayTao) {
		this.toNgayTao = toNgayTao;
	}
	
	private Integer pageIndex = 1;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	@Override
	public String toString() {
		return "HoSoNgoaiTeSearchForm [maHoSo=" + maHoSo + ", trangThai=" + trangThai + ", hinhThucXNK=" + hinhThucXNK
				+ ", maCuaKhau=" + maCuaKhau + ", fromNgayTao=" + fromNgayTao + ", toNgayTao=" + toNgayTao
				+ ", pageIndex=" + pageIndex + "]";
	}
	

	
}
