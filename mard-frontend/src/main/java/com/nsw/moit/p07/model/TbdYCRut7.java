package com.nsw.moit.p07.model;

import java.util.Date;

public class TbdYCRut7 {

	private Long idYCRut;
	public void setIdYCRut(Long idYCRut) {
		this.idYCRut = idYCRut;
	}
	public Long getIdYCRut() {
		return this.idYCRut;
	}

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

	private Date ngayRut;
	public void setNgayRut(Date ngayRut) {
		this.ngayRut = ngayRut;
	}
	public Date getNgayRut() {
		return this.ngayRut;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}

	private String nguoiTao;
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public String getNguoiTao() {
		return this.nguoiTao;
	}

	private Date ngayTao;
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayTao() {
		return this.ngayTao;
	}

	private String nguoiChungNhan;
	public void setNguoiChungNhan(String nguoiChungNhan) {
		this.nguoiChungNhan = nguoiChungNhan;
	}
	public String getNguoiChungNhan() {
		return this.nguoiChungNhan;
	}

	private Date ngayChungNhan;
	public void setNgayChungNhan(Date ngayChungNhan) {
		this.ngayChungNhan = ngayChungNhan;
	}
	public Date getNgayChungNhan() {
		return this.ngayChungNhan;
	}

	private Integer trangThai;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}

	private String noiDungPH;
	public void setNoiDungPH(String noiDungPH) {
		this.noiDungPH = noiDungPH;
	}
	public String getNoiDungPH() {
		return this.noiDungPH;
	}

	private Date ngayPH;
	public void setNgayPH(Date ngayPH) {
		this.ngayPH = ngayPH;
	}
	public Date getNgayPH() {
		return this.ngayPH;
	}

	private String donViPH;
	public void setDonViPH(String donViPH) {
		this.donViPH = donViPH;
	}
	public String getDonViPH() {
		return this.donViPH;
	}

	private String chuyeVienPH;
	public void setChuyeVienPH(String chuyeVienPH) {
		this.chuyeVienPH = chuyeVienPH;
	}
	public String getChuyeVienPH() {
		return this.chuyeVienPH;
	}

	private String tenTrangThaiCu;
	public void setTenTrangThaiCu(String tenTrangThaiCu) {
		this.tenTrangThaiCu = tenTrangThaiCu;
	}
	public String getTenTrangThaiCu() {
		return this.tenTrangThaiCu;
	}

	private Long trangThaiCu;
	public void setTrangThaiCu(Long trangThaiCu) {
		this.trangThaiCu = trangThaiCu;
	}
	public Long getTrangThaiCu() {
		return this.trangThaiCu;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdYCRut7 { ");
		stringBuilder.append("idYCRut=" + idYCRut); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayRut=" + ngayRut); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiTao=" + nguoiTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayTao=" + ngayTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiChungNhan=" + nguoiChungNhan); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayChungNhan=" + ngayChungNhan); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungPH=" + noiDungPH); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayPH=" + ngayPH); 
		stringBuilder.append(", "); 
		stringBuilder.append("donViPH=" + donViPH); 
		stringBuilder.append(", "); 
		stringBuilder.append("chuyeVienPH=" + chuyeVienPH); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTrangThaiCu=" + tenTrangThaiCu); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThaiCu=" + trangThaiCu); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}