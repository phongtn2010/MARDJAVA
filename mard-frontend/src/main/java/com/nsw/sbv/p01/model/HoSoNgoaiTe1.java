package com.nsw.sbv.p01.model;

import java.util.Date;

public class HoSoNgoaiTe1 {

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private String maChiNhanh;
	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}
	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	private String tenChiNhanh;
	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}
	public String getTenChiNhanh() {
		return this.tenChiNhanh;
	}

	private int hinhThucXNK;
	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}
	public int getHinhThucXNK() {
		return this.hinhThucXNK;
	}

	private String maSoThue;
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getMaSoThue() {
		return this.maSoThue;
	}

	private String tenNganHang;
	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}
	public String getTenNganHang() {
		return this.tenNganHang;
	}

	private String diaChi;
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChi() {
		return this.diaChi;
	}

	private String dienThoai;
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDienThoai() {
		return this.dienThoai;
	}

	private String fax;
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFax() {
		return this.fax;
	}

	private String maCuaKhau;
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}

	private String tenCuaKhau;
	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}
	public String getTenCuaKhau() {
		return this.tenCuaKhau;
	}

	private Date xuatNhapKhauTuNgay;
	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}
	public Date getXuatNhapKhauTuNgay() {
		return this.xuatNhapKhauTuNgay;
	}

	private Date xuatNhapKhauDenNgay;
	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}
	public Date getXuatNhapKhauDenNgay() {
		return this.xuatNhapKhauDenNgay;
	}

	private boolean capGiayPhepLanDau;
	public void setCapGiayPhepLanDau(boolean capGiayPhepLanDau) {
		this.capGiayPhepLanDau = capGiayPhepLanDau;
	}
	public boolean isCapGiayPhepLanDau() {
		return this.capGiayPhepLanDau;
	}

	private String soGiayPhepDaCap;
	public void setSoGiayPhepDaCap(String soGiayPhepDaCap) {
		this.soGiayPhepDaCap = soGiayPhepDaCap;
	}
	public String getSoGiayPhepDaCap() {
		return this.soGiayPhepDaCap;
	}

	private String doiTacXuatNhapKhau;
	public void setDoiTacXuatNhapKhau(String doiTacXuatNhapKhau) {
		this.doiTacXuatNhapKhau = doiTacXuatNhapKhau;
	}
	public String getDoiTacXuatNhapKhau() {
		return this.doiTacXuatNhapKhau;
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

	private boolean xoaHoSo;
	public void setXoaHoSo(boolean xoaHoSo) {
		this.xoaHoSo = xoaHoSo;
	}
	public boolean isXoaHoSo() {
		return this.xoaHoSo;
	}

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}
	
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("HoSoNgoaiTe1 { ");
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maChiNhanh=" + maChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenChiNhanh=" + tenChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("hinhThucXNK=" + hinhThucXNK); 
		stringBuilder.append(", "); 
		stringBuilder.append("maSoThue=" + maSoThue); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenNganHang=" + tenNganHang); 
		stringBuilder.append(", "); 
		stringBuilder.append("diaChi=" + diaChi); 
		stringBuilder.append(", "); 
		stringBuilder.append("dienThoai=" + dienThoai); 
		stringBuilder.append(", "); 
		stringBuilder.append("fax=" + fax); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay); 
		stringBuilder.append(", "); 
		stringBuilder.append("xuatNhapKhauDenNgay=" + xuatNhapKhauDenNgay); 
		stringBuilder.append(", "); 
		stringBuilder.append("capGiayPhepLanDau=" + capGiayPhepLanDau); 
		stringBuilder.append(", "); 
		stringBuilder.append("soGiayPhepDaCap=" + soGiayPhepDaCap); 
		stringBuilder.append(", "); 
		stringBuilder.append("doiTacXuatNhapKhau=" + doiTacXuatNhapKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayTao=" + ngayTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("xoaHoSo=" + xoaHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}