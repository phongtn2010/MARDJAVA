package com.nsw.sbv.p01.model;


public class LoaiTienTe1 {

	private long idLoaiTienTe;
	public void setIdLoaiTienTe(long idLoaiTienTe) {
		this.idLoaiTienTe = idLoaiTienTe;
	}
	public long getIdLoaiTienTe() {
		return this.idLoaiTienTe;
	}

	private String maLoaiTienTe;
	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
	}

	private String tenLoaiTienTe;
	public void setTenLoaiTienTe(String tenLoaiTienTe) {
		this.tenLoaiTienTe = tenLoaiTienTe;
	}
	public String getTenLoaiTienTe() {
		return this.tenLoaiTienTe;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("LoaiTienTe1 { ");
		stringBuilder.append("idLoaiTienTe=" + idLoaiTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTienTe=" + maLoaiTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTienTe=" + tenLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}