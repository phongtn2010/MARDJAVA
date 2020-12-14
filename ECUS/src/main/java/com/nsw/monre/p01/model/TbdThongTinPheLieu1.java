package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;

import com.nsw.monre.p01.model.base.*;



public class TbdThongTinPheLieu1  extends TbdThongTinPheLieu1BaseModel{

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

	private Double klCongSuat;

	public Double getKlCongSuat() {
		return this.klCongSuat;
	}

	private Double khoiLuong6;

	public Double getKhoiLuong6() {
		return khoiLuong6;
	}

	public void setKhoiLuong6(Double khoiLuong6) {
		this.khoiLuong6 = khoiLuong6;
	}

	public void setKlCongSuat(Double klCongSuat) {
		this.klCongSuat = klCongSuat;
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

	@Override
	public String toString() {
		return "TbdThongTinPheLieu1 [idPL=" + idPL + ", idHS=" + idHS + ", tenPheLieu=" + tenPheLieu + ", maHS=" + maHS + ", moTa=" + moTa + ", klCongSuat=" + klCongSuat + ", khoiLuong=" + khoiLuong + ", donViUyThac=" + donViUyThac + "]";
	}

	

	




}