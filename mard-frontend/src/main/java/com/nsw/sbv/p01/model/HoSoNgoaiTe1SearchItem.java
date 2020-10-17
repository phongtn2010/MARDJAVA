package com.nsw.sbv.p01.model;

import java.util.Date;

public class HoSoNgoaiTe1SearchItem {

	private String maSoThue;
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getMaSoThue() {
		return this.maSoThue;
	}

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}

	private Integer trangThai;
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

	private Date fromNgayTao;
	public void setFromNgayTao(Date fromNgayTao) {
		this.fromNgayTao = fromNgayTao;
	}
	public Date getFromNgayTao() {
		return this.fromNgayTao;
	}

	private Date toNgayTao;
	public void setToNgayTao(Date toNgayTao) {
		this.toNgayTao = toNgayTao;
	}
	public Date getToNgayTao() {
		return this.toNgayTao;
	}

	private Boolean xoaHoSo;
	public void setXoaHoSo(Boolean xoaHoSo) {
		this.xoaHoSo = xoaHoSo;
	}
	public Boolean isXoaHoSo() {
		return this.xoaHoSo;
	}

	private Integer pageIndex;
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageIndex() {
		return this.pageIndex;
	}

	private Integer pageSize;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return this.pageSize;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("HoSoNgoaiTe1SearchItem { ");
		stringBuilder.append("maSoThue=" + maSoThue); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("hinhThucXNK=" + hinhThucXNK); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("fromNgayTao=" + fromNgayTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("toNgayTao=" + toNgayTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("xoaHoSo=" + xoaHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("pageIndex=" + pageIndex); 
		stringBuilder.append(", "); 
		stringBuilder.append("pageSize=" + pageSize); 
		stringBuilder.append(", "); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}