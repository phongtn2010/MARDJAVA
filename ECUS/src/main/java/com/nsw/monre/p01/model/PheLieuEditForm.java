package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.ValidLength;
import com.nsw.monre.p01.util.ValidNotNullOrEmpty;

public class PheLieuEditForm {

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

	private Double khoiLuong6;

	public Double getKhoiLuong6() {
		return this.khoiLuong6;
	}

	public void setKhoiLuong6(Double khoiLuong6) {
		this.khoiLuong6 = khoiLuong6;
	}

	private Double klCongSuat;

	public Double getKlCongSuat() {
		return klCongSuat;
	}

	public void setKlCongSuat(Double klCongSuat) {
		this.klCongSuat = klCongSuat;
	}
	private Double klCongSuatInput;

	public Double getKlCongSuatInput() {
		return klCongSuatInput;
	}

	public void setKlCongSuatInput(Double klCongSuatInput) {
		this.klCongSuatInput = klCongSuatInput;
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
	
	private String khoiLuong6Input;
	
	private String khoiLuongInput;

	public String getKhoiLuong6Input() {
		return khoiLuong6Input;
	}

	public void setKhoiLuong6Input(String khoiLuong6Input) {
		this.khoiLuong6Input = khoiLuong6Input;
	}

	public String getKhoiLuongInput() {
		return khoiLuongInput;
	}

	public void setKhoiLuongInput(String khoiLuongInput) {
		this.khoiLuongInput = khoiLuongInput;
	}

	@Override
	public String toString() {
		return "PheLieuEditForm [idPL=" + idPL + ", idHS=" + idHS + ", tenPheLieu=" + tenPheLieu + ", maHS=" + maHS + ", moTa=" + moTa + ", khoiLuong6=" + khoiLuong6 + ", khoiLuong=" + khoiLuong + ", donViUyThac=" + donViUyThac + ", khoiLuong6Input=" + khoiLuong6Input + ", khoiLuongInput=" + khoiLuongInput + ", klCongSuatInput=" + klCongSuatInput + ",klCongSuat=" + klCongSuat +"]";
	}
	

	

	
}
