package com.nsw.moit.p07.model;

public class TbdHaiQuan7 {
	
	private Long idHaiQuan;
	
	private String maHaiQuan;
	
	private String tenHaiQuan;
	
	private Integer hoatDong;

	
	private Long idHoSo;

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

	public Long getIdHoSo() {
		return idHoSo;
	}

	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}

	
	public Integer getHoatDong() {
		return hoatDong;
	}

	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}

	@Override
	public String toString() {
		return "TbdHaiQuan7 [idHaiQuan=" + idHaiQuan + ", maHaiQuan=" + maHaiQuan + ", tenHaiQuan=" + tenHaiQuan
				+ ", idHoSo=" + idHoSo + "]";
	}
	
	


}
