package com.nsw.monre.p05.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;



public class TbdGXNThongTinPheLieu5  extends TbdGXNThongTinPheLieu5BaseModel{

	private long idPL;

	public long getIdPL() {
		return this.idPL;
	}

	public void setIdPL(long idPL) {
		this.idPL = idPL;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenPheLieu;

	public String getTenPheLieu() {
		return this.tenPheLieu;
	}

	public void setTenPheLieu(String tenPheLieu) {
		this.tenPheLieu = tenPheLieu;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String maHS;

	public String getMaHS() {
		return this.maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	private float khoiLuong6;

	public float getKhoiLuong6() {
		return this.khoiLuong6;
	}

	public void setKhoiLuong6(float khoiLuong6) {
		this.khoiLuong6 = khoiLuong6;
	}

	private float khoiLuong;

	public float getKhoiLuong() {
		return this.khoiLuong;
	}

	public void setKhoiLuong(float khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	@ValidLength(maxLength = 250)
	private String donViUyThac;

	public String getDonViUyThac() {
		return this.donViUyThac;
	}

	public void setDonViUyThac(String donViUyThac) {
		this.donViUyThac = donViUyThac;
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

		builder.append("TbdGXNThongTinPheLieu5: [ ");

		builder.append("idPL = " + idPL);

		builder.append(" | ");

		builder.append("tenPheLieu = " + tenPheLieu);

		builder.append(" | ");

		builder.append("maHS = " + maHS);

		builder.append(" | ");

		builder.append("khoiLuong6 = " + khoiLuong6);

		builder.append(" | ");

		builder.append("khoiLuong = " + khoiLuong);

		builder.append(" | ");

		builder.append("donViUyThac = " + donViUyThac);

		builder.append(" | ");

		builder.append("idGXN = " + idGXN);

		builder.append(" ]");

		return builder.toString();

	}




}