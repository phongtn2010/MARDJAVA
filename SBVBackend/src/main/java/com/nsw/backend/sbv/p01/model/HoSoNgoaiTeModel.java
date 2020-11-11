package com.nsw.backend.sbv.p01.model;

import java.util.Date;



public class HoSoNgoaiTeModel {

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private int hinhThucXNK;
	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}
	public int getHinhThucXNK() {
		return this.hinhThucXNK;
	}

	private String tenNganHang;
	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}
	public String getTenNganHang() {
		return this.tenNganHang;
	}

	private Date ngayTao;
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayTao() {
		return this.ngayTao;
	}

	private int trangThai;
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return this.trangThai;
	}

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}

	private String soGiayPhep;
	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}
	public String getSoGiayPhep() {
		return this.soGiayPhep;
	}
	
	private Date ngayCap;
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	public Date getNgayCap() {
		return this.ngayCap;
	}
	@Override
	public String toString() {
		return "HoSoNgoaiTeModel [idHoSo=" + idHoSo + ", hinhThucXNK=" + hinhThucXNK + ", tenNganHang=" + tenNganHang + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + ", maHoSo=" + maHoSo + ", soGiayPhep=" + soGiayPhep + ", ngayCap=" + ngayCap + "]";
	}
	public HoSoNgoaiTeModel(long idHoSo, int hinhThucXNK, String tenNganHang, Date ngayTao, int trangThai, String maHoSo, String soGiayPhep, Date ngayCap) {
		this.idHoSo = idHoSo;
		this.hinhThucXNK = hinhThucXNK;
		this.tenNganHang = tenNganHang;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.maHoSo = maHoSo;
		this.soGiayPhep = soGiayPhep;
		this.ngayCap = ngayCap;
	}
	
	
	
}
