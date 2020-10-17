package com.nsw.moit.p07.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class TbdHoSo7SearchDTO {
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

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date fromNgayNop;
	public void setFromNgayNop(Date fromNgayNop) {
		this.fromNgayNop = fromNgayNop;
	}
	public Date getFromNgayNop() {
		return this.fromNgayNop;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date toNgayNop;
	public void setToNgayNop(Date toNgayNop) {
		this.toNgayNop = toNgayNop;
	}
	public Date getToNgayNop() {
		return this.toNgayNop;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date fromNgayCapGiayPhep;
	public void setFromNgayCapGiayPhep(Date fromNgayCapGiayPhep) {
		this.fromNgayCapGiayPhep = fromNgayCapGiayPhep;
	}
	public Date getFromNgayCapGiayPhep() {
		return this.fromNgayCapGiayPhep;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date toNgayCapGiayPhep;
	public void setToNgayCapGiayPhep(Date toNgayCapGiayPhep) {
		this.toNgayCapGiayPhep = toNgayCapGiayPhep;
	}
	public Date getToNgayCapGiayPhep() {
		return this.toNgayCapGiayPhep;
	}

	private int pageIndex;
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageIndex() {
		return this.pageIndex;
	}

	private int pageSize;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return this.pageSize;
	}

	private String maSoGP;
	public void setMaSoGP(String maSoGP) {
		this.maSoGP = maSoGP;
	}
	public String getMaSoGP() {
		return this.maSoGP;
	}
	

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdHoSo6SearchItem { ");
		stringBuilder.append("maSoThue=" + maSoThue); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("fromNgayNop=" + fromNgayNop); 
		stringBuilder.append(", "); 
		stringBuilder.append("toNgayNop=" + toNgayNop); 
		stringBuilder.append(", "); 
		stringBuilder.append("fromNgayCapGiayPhep=" + fromNgayCapGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("toNgayCapGiayPhep=" + toNgayCapGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("pageIndex=" + pageIndex); 
		stringBuilder.append(", "); 
		stringBuilder.append("pageSize=" + pageSize); 
		stringBuilder.append(", "); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}
