package com.nsw.moit.p06.model;


public class TbsTrangThai6 {

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

		stringBuilder.append("TbsTrangThai6 { ");
		stringBuilder.append("idTrangThai=" + idTrangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTrangThai=" + tenTrangThai); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}