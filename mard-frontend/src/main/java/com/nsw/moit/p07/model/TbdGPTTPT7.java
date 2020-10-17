package com.nsw.moit.p07.model;

import java.util.Date;

public class TbdGPTTPT7 {

	private Long idPhuongTien;
	public void setIdPhuongTien(Long idPhuongTien) {
		this.idPhuongTien = idPhuongTien;
	}
	public Long getIdPhuongTien() {
		return this.idPhuongTien;
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

	private Integer loaiPhuongTien;
	public void setLoaiPhuongTien(Integer loaiPhuongTien) {
		this.loaiPhuongTien = loaiPhuongTien;
	}
	public Integer getLoaiPhuongTien() {
		return this.loaiPhuongTien;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdGPTTPT7 { ");
		stringBuilder.append("idPhuongTien=" + idPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiPhuongTien=" + loaiPhuongTien); 
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
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}