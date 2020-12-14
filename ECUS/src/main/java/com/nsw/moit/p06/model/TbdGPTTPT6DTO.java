package com.nsw.moit.p06.model;

public class TbdGPTTPT6DTO {
	
	private Long idPhuongTien;
	public void setIdPhuongTien(Long idPhuongTien) {
		this.idPhuongTien = idPhuongTien;
	}
	public Long getIdPhuongTien() {
		return this.idPhuongTien;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private Integer loaiPhuongTien;
	public void setLoaiPhuongTien(Integer loaiPhuongTien) {
		this.loaiPhuongTien = loaiPhuongTien;
	}
	public Integer getLoaiPhuongTien() {
		return this.loaiPhuongTien;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}

	private String tenPhuongTien;
	public String getTenPhuongTien() {
		return tenPhuongTien;
	}
	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}
	
	private String tenLoaiPhuongTien;
	
	
	public String getTenLoaiPhuongTien() {
		return tenLoaiPhuongTien;
	}
	public void setTenLoaiPhuongTien(String tenLoaiPhuongTien) {
		this.tenLoaiPhuongTien = tenLoaiPhuongTien;
	}
	@Override
	public String toString() {
		return "TbdTTPT6DTO [idPhuongTien=" + idPhuongTien + ", idHoSo=" + idHoSo + ", loaiPhuongTien=" + loaiPhuongTien + ", hoatDong=" + hoatDong + ", tenPhuongTien=" + tenPhuongTien + "]";
	}
	
	
}
