package com.nsw.monre.p05.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;



public class TbdThongTinPheLieu5  extends TbdThongTinPheLieu5BaseModel{

	private long idPL;

	public long getIdPL() {
		return this.idPL;
	}

	public void setIdPL(long idPL) {
		this.idPL = idPL;
	}

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
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

	@ValidLength(maxLength = 2000)
	private String moTa;

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	private float khoiLuong6;

	public float getKhoiLuong6() {
		return this.khoiLuong6;
	}

	public void setKhoiLuong6(float khoiLuong6) {
		this.khoiLuong6 = khoiLuong6;
	}

	public Double getKlCongSuat() {
		return klCongSuat;
	}

	public void setKlCongSuat(Double klCongSuat) {
		this.klCongSuat = klCongSuat;
	}

	private Double klCongSuat;

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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdThongTinPheLieu5: [ ");

		builder.append("idPL = " + idPL);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("tenPheLieu = " + tenPheLieu);

		builder.append(" | ");

		builder.append("maHS = " + maHS);

		builder.append(" | ");

		builder.append("moTa = " + moTa);

		builder.append(" | ");

		builder.append("khoiLuong6 = " + khoiLuong6);

		builder.append(" | ");

		builder.append("khoiLuong = " + khoiLuong);

		builder.append(" | ");

		builder.append("donViUyThac = " + donViUyThac);

		builder.append(" ]");

		return builder.toString();

	}




}