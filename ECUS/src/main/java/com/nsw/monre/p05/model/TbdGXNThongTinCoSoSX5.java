package com.nsw.monre.p05.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;



public class TbdGXNThongTinCoSoSX5  extends TbdGXNThongTinCoSoSX5BaseModel{

	private long idCS;

	public long getIdCS() {
		return this.idCS;
	}

	public void setIdCS(long idCS) {
		this.idCS = idCS;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenCoSo;

	public String getTenCoSo() {
		return this.tenCoSo;
	}

	public void setTenCoSo(String tenCoSo) {
		this.tenCoSo = tenCoSo;
	}

	@ValidLength(maxLength = 250)
	private String diaChiCoSo;

	public String getDiaChiCoSo() {
		return this.diaChiCoSo;
	}

	public void setDiaChiCoSo(String diaChiCoSo) {
		this.diaChiCoSo = diaChiCoSo;
	}

	@ValidLength(maxLength = 50)
	private String soDienThoai;

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@ValidLength(maxLength = 50)
	private String fax;

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@ValidLength(maxLength = 50)
	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 50)
	private String maTinh;

	public String getMaTinh() {
		return this.maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 50)
	private String maHuyen;

	public String getMaHuyen() {
		return this.maHuyen;
	}

	public void setMaHuyen(String maHuyen) {
		this.maHuyen = maHuyen;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 50)
	private String maXaPhuong;

	public String getMaXaPhuong() {
		return this.maXaPhuong;
	}

	public void setMaXaPhuong(String maXaPhuong) {
		this.maXaPhuong = maXaPhuong;
	}

	private long idGXN;

	public long getIdGXN() {
		return this.idGXN;
	}

	public void setIdGXN(long idGXN) {
		this.idGXN = idGXN;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdGXNThongTinCoSoSX5: [ ");

		builder.append("idCS = " + idCS);

		builder.append(" | ");

		builder.append("tenCoSo = " + tenCoSo);

		builder.append(" | ");

		builder.append("diaChiCoSo = " + diaChiCoSo);

		builder.append(" | ");

		builder.append("soDienThoai = " + soDienThoai);

		builder.append(" | ");

		builder.append("fax = " + fax);

		builder.append(" | ");

		builder.append("email = " + email);

		builder.append(" | ");

		builder.append("maTinh = " + maTinh);

		builder.append(" | ");

		builder.append("maHuyen = " + maHuyen);

		builder.append(" | ");

		builder.append("maXaPhuong = " + maXaPhuong);

		builder.append(" | ");

		builder.append("idGXN = " + idGXN);

		builder.append(" ]");

		return builder.toString();

	}




}