package com.nsw.sbv.p01.model;


public class TienTe1 {

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

	private long soLuongNgoaiTeBangSo;
	public void setSoLuongNgoaiTeBangSo(long soLuongNgoaiTeBangSo) {
		this.soLuongNgoaiTeBangSo = soLuongNgoaiTeBangSo;
	}
	public long getSoLuongNgoaiTeBangSo() {
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
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TienTe1 { ");
		stringBuilder.append("idTienTe=" + idTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangSo=" + soLuongNgoaiTeBangSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangChu=" + soLuongNgoaiTeBangChu); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTienTe=" + maLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}