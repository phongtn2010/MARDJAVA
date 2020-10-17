package com.nsw.moit.p06.model;


public class TbdCuaKhau6 {

	private Long idCuaKhau;
	public void setIdCuaKhau(Long idCuaKhau) {
		this.idCuaKhau = idCuaKhau;
	}
	public Long getIdCuaKhau() {
		return this.idCuaKhau;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
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

		stringBuilder.append("TbdCuaKhau6 { ");
		stringBuilder.append("idCuaKhau=" + idCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maCuaKhau=" + maCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}