package com.nsw.sbv.p01.model;

import java.util.Date;

public class YeuCauHuyHoSo1 {

	private long idYCHHoSo;
	public void setIdYCHHoSo(long idYCHHoSo) {
		this.idYCHHoSo = idYCHHoSo;
	}
	public long getIdYCHHoSo() {
		return this.idYCHHoSo;
	}

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private Date ngayXinHuy;
	public void setNgayXinHuy(Date ngayXinHuy) {
		this.ngayXinHuy = ngayXinHuy;
	}
	public Date getNgayXinHuy() {
		return this.ngayXinHuy;
	}

	private String lyDoHuyHoSo;
	public void setLyDoHuyHoSo(String lyDoHuyHoSo) {
		this.lyDoHuyHoSo = lyDoHuyHoSo;
	}
	public String getLyDoHuyHoSo() {
		return this.lyDoHuyHoSo;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("YeuCauHuyHoSo1 { ");
		stringBuilder.append("idYCHHoSo=" + idYCHHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXinHuy=" + ngayXinHuy); 
		stringBuilder.append(", "); 
		stringBuilder.append("lyDoHuyHoSo=" + lyDoHuyHoSo); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}