package com.nsw.moit.p06.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class TbdHoSo6DTO {
	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}

	private String tenDoanhNghiep;
	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}
	public String getTenDoanhNghiep() {
		return this.tenDoanhNghiep;
	}

	
	private Integer trangThai;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}

	
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayNop;
	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}
	public Date getNgayNop() {
		return this.ngayNop;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayCapGiayPhep;
	public void setNgayCapGiayPhep(Date ngayCapGiayPhep) {
		this.ngayCapGiayPhep = ngayCapGiayPhep;
	}
	public Date getNgayCapGiayPhep() {
		return this.ngayCapGiayPhep;
	}
	
	private String maSoGP;
	public void setMaSoGP(String maSoGP) {
		this.maSoGP = maSoGP;
	}
	public String getMaSoGP() {
		return this.maSoGP;
	}
	
	private String tenTrangThai;
	
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
	private String maTinhTP;

	private String tinhTP;
	
	private String noiCapGiayChungNhanDKKD;
	
	private String tenNguoiDaiDien;
	
	private String daiDienChucVu;
	
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date daiDienNamSinh;
	
	private int daiDienGioiTinh;
		
	private String daiDienDiaChi;
	public String getMaTinhTP() {
		return maTinhTP;
	}
	public void setMaTinhTP(String maTinhTP) {
		this.maTinhTP = maTinhTP;
	}
	public String getTinhTP() {
		return tinhTP;
	}
	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}
	public String getNoiCapGiayChungNhanDKKD() {
		return noiCapGiayChungNhanDKKD;
	}
	public void setNoiCapGiayChungNhanDKKD(String noiCapGiayChungNhanDKKD) {
		this.noiCapGiayChungNhanDKKD = noiCapGiayChungNhanDKKD;
	}
	public String getTenNguoiDaiDien() {
		return tenNguoiDaiDien;
	}
	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		this.tenNguoiDaiDien = tenNguoiDaiDien;
	}
	public String getDaiDienChucVu() {
		return daiDienChucVu;
	}
	public void setDaiDienChucVu(String daiDienChucVu) {
		this.daiDienChucVu = daiDienChucVu;
	}
	public Date getDaiDienNamSinh() {
		return daiDienNamSinh;
	}
	public void setDaiDienNamSinh(Date daiDienNamSinh) {
		this.daiDienNamSinh = daiDienNamSinh;
	}
	public int getDaiDienGioiTinh() {
		return daiDienGioiTinh;
	}
	public void setDaiDienGioiTinh(int daiDienGioiTinh) {
		this.daiDienGioiTinh = daiDienGioiTinh;
	}
	public String getDaiDienDiaChi() {
		return daiDienDiaChi;
	}
	public void setDaiDienDiaChi(String daiDienDiaChi) {
		this.daiDienDiaChi = daiDienDiaChi;
	}
	
	@Override
	public String toString() {
		return "HoSo6Model [idHoSo=" + idHoSo + ", maHoSo=" + maHoSo + ", tenDoanhNghiep=" + tenDoanhNghiep + ", trangThai=" + trangThai + ", ngayNop=" + ngayNop + ", ngayCapGiayPhep=" + ngayCapGiayPhep + ", maSoGP=" + maSoGP + ", tenTrangThai=" + tenTrangThai + "]";
	}
}
