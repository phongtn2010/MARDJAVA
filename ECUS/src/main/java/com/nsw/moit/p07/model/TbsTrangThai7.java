package com.nsw.moit.p07.model;


public class TbsTrangThai7 {

	private Long idTrangThai;
	public void setIdTrangThai(Long idTrangThai) {
		this.idTrangThai = idTrangThai;
	}
	public Long getIdTrangThai() {
		return this.idTrangThai;
	}

	private String tenTrangThai;
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenTrangThai() {
		return this.tenTrangThai;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbsTrangThai7 { ");
		stringBuilder.append("idTrangThai=" + idTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTrangThai=" + tenTrangThai); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}