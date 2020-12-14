package com.nsw.moit.p06.model;


public class TbdTTPT6 {

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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdTTPT6 { ");
		stringBuilder.append("idPhuongTien=" + idPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiPhuongTien=" + loaiPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}