package com.nsw.moit.p06.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class TbdHoSo6SearchDTO {
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
		return "TbdHoSo6SearchDTO [maSoThue=" + maSoThue + ", maHoSo=" + maHoSo + ", trangThai=" + trangThai + ", fromNgayNop=" + fromNgayNop + ", toNgayNop=" + toNgayNop + ", fromNgayCapGiayPhep=" + fromNgayCapGiayPhep + ", toNgayCapGiayPhep=" + toNgayCapGiayPhep + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", maSoGP=" + maSoGP + "]";
	}
	
	
}
