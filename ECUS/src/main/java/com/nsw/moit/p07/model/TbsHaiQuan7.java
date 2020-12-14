package com.nsw.moit.p07.model;

public class TbsHaiQuan7 {

	private Long idHaiQuan;
	
	private String maHaiQuan;
	
	private String tenHaiQuan;

	public Long getIdHaiQuan() {
		return idHaiQuan;
	}

	public void setIdHaiQuan(Long idHaiQuan) {
		this.idHaiQuan = idHaiQuan;
	}

	public String getMaHaiQuan() {
		return maHaiQuan;
	}

	public void setMaHaiQuan(String maHaiQuan) {
		this.maHaiQuan = maHaiQuan;
	}

	public String getTenHaiQuan() {
		return tenHaiQuan;
	}

	public void setTenHaiQuan(String tenHaiQuan) {
		this.tenHaiQuan = tenHaiQuan;
	}

	@Override
	public String toString() {
		return "TbsHaiQuan7 [idHaiQuan=" + idHaiQuan + ", maHaiQuan=" + maHaiQuan + ", tenHaiQuan=" + tenHaiQuan + "]";
	}
	
	
}
