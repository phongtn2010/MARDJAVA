package com.nsw.monre.p01.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class HoSo1 {

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}


	private String tenDN;

	public String getTenDN() {
		return this.tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date ngayGui;

	public Date getNgayGui() {
		return this.ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	private String soGXNDaCap;

	public String getSoGXNDaCap() {
		return this.soGXNDaCap;
	}

	public void setSoGXNDaCap(String soGXNDaCap) {
		this.soGXNDaCap = soGXNDaCap;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date ngayCap;

	public Date getNgayCap() {
		return this.ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date ngayHetHan;

	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}


	private String maHoSo;

	public String getMaHoSo() {
		return this.maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	private int trangThai;

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
	private String tenTrangThai;

	
	
	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}


	private String soGiayXN;
	
	

	public String getSoGiayXN() {
		return soGiayXN;
	}

	public void setSoGiayXN(String soGiayXN) {
		this.soGiayXN = soGiayXN;
	}
	
	private int soThuTu;

	public int getSoThuTu() {
		return soThuTu;
	}

	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	
	private int pageIndex = 1;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("HoSo: { ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");
		
		builder.append("soGiayXN = " + soGiayXN);

		builder.append(" | ");

		builder.append("tenDN = " + tenDN);

		builder.append(" | ");

		builder.append("ngayGui = " + ngayGui);

		builder.append(" | ");

		builder.append("soGXNDaCap = " + soGXNDaCap);

		builder.append(" | ");

		builder.append("ngayCap = " + ngayCap);

		builder.append(" | ");

		builder.append("ngayHetHan = " + ngayHetHan);

		builder.append(" | ");

		builder.append("maHoSo = " + maHoSo);

		builder.append(" | ");

		builder.append("trangThai = " + trangThai);

		builder.append(" | ");
		
		builder.append("tenTrangThai = " + tenTrangThai);
		
		builder.append(" }");

		return builder.toString();

	}
}

