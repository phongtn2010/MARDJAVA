package com.nsw.sbv.p01.model;


public class ChiNhanhNganHang1 {

	private long idChiNhanh;
	public void setIdChiNhanh(long idChiNhanh) {
		this.idChiNhanh = idChiNhanh;
	}
	public long getIdChiNhanh() {
		return this.idChiNhanh;
	}

	private String maChiNhanh;
	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}
	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	private String tenChiNhanh;
	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}
	public String getTenChiNhanh() {
		return this.tenChiNhanh;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("ChiNhanhNganHang1 { ");
		stringBuilder.append("idChiNhanh=" + idChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("maChiNhanh=" + maChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenChiNhanh=" + tenChiNhanh); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}