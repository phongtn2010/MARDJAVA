package com.nsw.sbv.p01.model;

import java.util.ArrayList;
import java.util.List;

public class ChiTietGiayPhep {

	private String soGiayPhep;
	private String diaDanh;
	private String ngay;
	private String thang;
	private String nam;
	private String tenNganHang;
	private String diaChi;
	private String dienThoai;
	private String fax;
	private String tenCuaKhau;
	private String hieuLucDenNgay;
	private String hieuLucTuNgay;
	private String nguoiKy;
	private String kinhGui;
	private String ghiChu;

	private boolean hinhThucNhapKhau;
	private boolean hinhThucXuatKhau;
	
	
	public boolean isHinhThucNhapKhau() {
		return hinhThucNhapKhau;
	}

	public void setHinhThucNhapKhau(boolean hinhThucNhapKhau) {
		this.hinhThucNhapKhau = hinhThucNhapKhau;
	}

	
	public boolean isHinhThucXuatKhau() {
		return hinhThucXuatKhau;
	}

	public void setHinhThucXuatKhau(boolean hinhThucXuatKhau) {
		this.hinhThucXuatKhau = hinhThucXuatKhau;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	private List<TienTe1> tienTes = new ArrayList<>();

	public String getSoGiayPhep() {
		return soGiayPhep;
	}

	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}

	public String getDiaDanh() {
		return diaDanh;
	}

	public void setDiaDanh(String diaDanh) {
		this.diaDanh = diaDanh;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getThang() {
		return thang;
	}

	public void setThang(String thang) {
		this.thang = thang;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getTenNganHang() {
		return tenNganHang;
	}

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTenCuaKhau() {
		return tenCuaKhau;
	}

	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}

	public String getHieuLucDenNgay() {
		return hieuLucDenNgay;
	}

	public void setHieuLucDenNgay(String hieuLucDenNgay) {
		this.hieuLucDenNgay = hieuLucDenNgay;
	}

	

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getKinhGui() {
		return kinhGui;
	}

	public void setKinhGui(String kinhGui) {
		this.kinhGui = kinhGui;
	}

	public List<TienTe1> getTienTes() {
		return tienTes;
	}

	public void setTienTes(List<TienTe1> tienTes) {
		this.tienTes = tienTes;
	}
	
	private String thoiGian;
	
	

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	private String tenChiNhanh;
	
	
	public String getTenChiNhanh() {
		return tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}

	private String doiTacXuatNhapKhau;
	
	
	public String getDoiTacXuatNhapKhau() {
		return doiTacXuatNhapKhau;
	}

	public void setDoiTacXuatNhapKhau(String doiTacXuatNhapKhau) {
		this.doiTacXuatNhapKhau = doiTacXuatNhapKhau;
	}

	
	public String getHieuLucTuNgay() {
		return hieuLucTuNgay;
	}

	public void setHieuLucTuNgay(String hieuLucTuNgay) {
		this.hieuLucTuNgay = hieuLucTuNgay;
	}

	@Override
	public String toString() {
		return "ChiTietGiayPhep [soGiayPhep=" + soGiayPhep + ", diaDanh=" + diaDanh + ", ngay=" + ngay + ", thang=" + thang + ", nam=" + nam + ", tenNganHang=" + tenNganHang + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", fax=" + fax + ", tenCuaKhau=" + tenCuaKhau + ", hieuLucDenNgay=" + hieuLucDenNgay + ", nguoiKy=" + nguoiKy + ", kinhGui=" + kinhGui + ", tienTes=" + tienTes + ", thoiGian=" + thoiGian + ", tenChiNhanh=" + tenChiNhanh + ", doiTacXuatNhapKhau=" + doiTacXuatNhapKhau + "]";
	}

	
	
	
	
}
