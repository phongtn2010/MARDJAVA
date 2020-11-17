package com.vnsw.ws.p01.entity.db;


public class CuaKhau1 {

	private long idCuaKhau;
	public void setIdCuaKhau(long idCuaKhau) {
		this.idCuaKhau = idCuaKhau;
	}
	public long getIdCuaKhau() {
		return this.idCuaKhau;
	}

	private String maChiNhanh;
	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}
	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	private String maCuaKhau;
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}

	private String tenCuaKhau;
	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}
	public String getTenCuaKhau() {
		return this.tenCuaKhau;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("CuaKhau1 { ");
		stringBuilder.append("idCuaKhau=" + idCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("maChiNhanh=" + maChiNhanh); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}