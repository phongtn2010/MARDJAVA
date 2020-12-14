package com.nsw.moit.p06.model;

import java.util.Date;

public class TbdHoSo6SearchItem {

	private String maSoThue;
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getMaSoThue() {
		return this.maSoThue;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
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

	private Date fromNgayNop;
	public void setFromNgayNop(Date fromNgayNop) {
		this.fromNgayNop = fromNgayNop;
	}
	public Date getFromNgayNop() {
		return this.fromNgayNop;
	}

	private Date toNgayNop;
	public void setToNgayNop(Date toNgayNop) {
		this.toNgayNop = toNgayNop;
	}
	public Date getToNgayNop() {
		return this.toNgayNop;
	}

	private Date fromNgayCapGiayPhep;
	public void setFromNgayCapGiayPhep(Date fromNgayCapGiayPhep) {
		this.fromNgayCapGiayPhep = fromNgayCapGiayPhep;
	}
	public Date getFromNgayCapGiayPhep() {
		return this.fromNgayCapGiayPhep;
	}

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
		return "TbdHoSo6SearchItem [maSoThue=" + maSoThue + ", hoatDong=" + hoatDong + ", maHoSo=" + maHoSo + ", trangThai=" + trangThai + ", fromNgayNop=" + fromNgayNop + ", toNgayNop=" + toNgayNop + ", fromNgayCapGiayPhep=" + fromNgayCapGiayPhep + ", toNgayCapGiayPhep=" + toNgayCapGiayPhep + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", maSoGP=" + maSoGP + "]";
	}
	

	
}