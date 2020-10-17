package com.nsw.sbv.p01.model;


public class TienTeEditForm {

	private long idTienTe;
	public void setIdTienTe(long idTienTe) {
		this.idTienTe = idTienTe;
	}
	public long getIdTienTe() {
		return this.idTienTe;
	}

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private String soLuongNgoaiTeBangSo;
	public void setSoLuongNgoaiTeBangSo(String soLuongNgoaiTeBangSo) {
		this.soLuongNgoaiTeBangSo = soLuongNgoaiTeBangSo;
	}
	public String getSoLuongNgoaiTeBangSo() {
		return this.soLuongNgoaiTeBangSo;
	}

	private String soLuongNgoaiTeBangChu;
	public void setSoLuongNgoaiTeBangChu(String soLuongNgoaiTeBangChu) {
		this.soLuongNgoaiTeBangChu = soLuongNgoaiTeBangChu;
	}
	public String getSoLuongNgoaiTeBangChu() {
		return this.soLuongNgoaiTeBangChu;
	}

	private String maLoaiTienTe;
	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
	}
	
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}
	

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "TienTeEditForm [idTienTe=" + idTienTe + ", idHoSo=" + idHoSo + ", soLuongNgoaiTeBangSo="
				+ soLuongNgoaiTeBangSo + ", soLuongNgoaiTeBangChu=" + soLuongNgoaiTeBangChu + ", maLoaiTienTe="
				+ maLoaiTienTe + ", ghiChu=" + ghiChu + "]";
	}

	
}