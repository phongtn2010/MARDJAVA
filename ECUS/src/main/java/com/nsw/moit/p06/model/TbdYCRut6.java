package com.nsw.moit.p06.model;

import java.util.Date;

public class TbdYCRut6 {

	private Long idYCRut;
	public void setIdYCRut(Long idYCRut) {
		this.idYCRut = idYCRut;
	}
	public Long getIdYCRut() {
		return this.idYCRut;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private String noiDung;
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNoiDung() {
		return this.noiDung;
	}

	private Date ngayRut;
	public void setNgayRut(Date ngayRut) {
		this.ngayRut = ngayRut;
	}
	public Date getNgayRut() {
		return this.ngayRut;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdYCRut6 { ");
		stringBuilder.append("idYCRut=" + idYCRut); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDung=" + noiDung); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayRut=" + ngayRut); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}