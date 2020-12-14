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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(TienTeEditForm.class.getSimpleName() + " { ");
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