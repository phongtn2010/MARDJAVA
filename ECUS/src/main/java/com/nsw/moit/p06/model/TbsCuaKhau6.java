package com.nsw.moit.p06.model;


public class TbsCuaKhau6 {

	private Long idCuaKhau;
	public void setIdCuaKhau(Long idCuaKhau) {
		this.idCuaKhau = idCuaKhau;
	}
	public Long getIdCuaKhau() {
		return this.idCuaKhau;
	}

	private String tenCuaKhau;
	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}
	public String getTenCuaKhau() {
		return this.tenCuaKhau;
	}
	
	private String maCuaKhau;
	
	private Boolean delete;
	public String getMaCuaKhau() {
		return maCuaKhau;
	}
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public Boolean getDelete() {
		return delete;
	}
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	
}