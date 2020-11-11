package com.vnsw.ws.p01.entity.db;


public class GPTienTe1 {

	private long idCapGXNTienTe;
	public void setIdCapGXNTienTe(long idCapGXNTienTe) {
		this.idCapGXNTienTe = idCapGXNTienTe;
	}
	public long getIdCapGXNTienTe() {
		return this.idCapGXNTienTe;
	}

	private long idCapGXNHoSo;
	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}
	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("GPTienTe1 { ");
		stringBuilder.append("idCapGXNTienTe=" + idCapGXNTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idCapGXNHoSo=" + idCapGXNHoSo); 
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