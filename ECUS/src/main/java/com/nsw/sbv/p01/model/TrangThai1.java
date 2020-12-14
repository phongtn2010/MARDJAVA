package com.nsw.sbv.p01.model;


public class TrangThai1 {

	private long idTrangThai;
	public void setIdTrangThai(long idTrangThai) {
		this.idTrangThai = idTrangThai;
	}
	public long getIdTrangThai() {
		return this.idTrangThai;
	}

	private String tenTrangThai;
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenTrangThai() {
		return this.tenTrangThai;
	}

	private int giaTri;
	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
	public int getGiaTri() {
		return this.giaTri;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TrangThai1 { ");
		stringBuilder.append("idTrangThai=" + idTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTrangThai=" + tenTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("giaTri=" + giaTri); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}