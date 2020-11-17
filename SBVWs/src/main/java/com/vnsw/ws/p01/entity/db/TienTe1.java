package com.vnsw.ws.p01.entity.db;


public class TienTe1 {

	private long idTienTe;

	public long getIdTienTe() {
		return idTienTe;
	}


	public void setIdTienTe(long idTienTe) {
		this.idTienTe = idTienTe;
	}


	public long getIdHoSo() {
		return idHoSo;
	}


	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}


	public long getSoLuongNgoaiTeBangSo() {
		return soLuongNgoaiTeBangSo;
	}


	public void setSoLuongNgoaiTeBangSo(long soLuongNgoaiTeBangSo) {
		this.soLuongNgoaiTeBangSo = soLuongNgoaiTeBangSo;
	}


	public String getSoLuongNgoaiTeBangChu() {
		return soLuongNgoaiTeBangChu;
	}


	public void setSoLuongNgoaiTeBangChu(String soLuongNgoaiTeBangChu) {
		this.soLuongNgoaiTeBangChu = soLuongNgoaiTeBangChu;
	}


	public String getMaLoaiTienTe() {
		return maLoaiTienTe;
	}


	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}


	private long idHoSo;

	private long soLuongNgoaiTeBangSo;

	private String soLuongNgoaiTeBangChu;

	private String maLoaiTienTe;

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