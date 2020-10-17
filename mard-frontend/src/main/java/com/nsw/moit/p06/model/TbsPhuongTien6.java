package com.nsw.moit.p06.model;


public class TbsPhuongTien6 {

	private Long idPhuongTien;
	public void setIdPhuongTien(Long idPhuongTien) {
		this.idPhuongTien = idPhuongTien;
	}
	public Long getIdPhuongTien() {
		return this.idPhuongTien;
	}

	private String tenPhuongTien;
	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}
	public String getTenPhuongTien() {
		return this.tenPhuongTien;
	}

	private Integer loaiPhuongTien;
	public void setLoaiPhuongTien(Integer loaiPhuongTien) {
		this.loaiPhuongTien = loaiPhuongTien;
	}
	public Integer getLoaiPhuongTien() {
		return this.loaiPhuongTien;
	}

	private String tenLoaiPhuongTien;
	public void setTenLoaiPhuongTien(String tenLoaiPhuongTien) {
		this.tenLoaiPhuongTien = tenLoaiPhuongTien;
	}
	public String getTenLoaiPhuongTien() {
		return this.tenLoaiPhuongTien;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbsPhuongTien6 { ");
		stringBuilder.append("idPhuongTien=" + idPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenPhuongTien=" + tenPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiPhuongTien=" + loaiPhuongTien); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiPhuongTien=" + tenLoaiPhuongTien); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}