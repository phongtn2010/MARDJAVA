package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;



public class TbsThongTinCoSoSX1  extends TbsThongTinCoSoSX1BaseModel{

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

	@ValidLength(maxLength = 255)
	private String tenTinh;

	public String getTenTinh() {
		return this.tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@ValidLength(maxLength = 255)
	private String tenHuyen;

	public String getTenHuyen() {
		return this.tenHuyen;
	}

	public void setTenHuyen(String tenHuyen) {
		this.tenHuyen = tenHuyen;
	}

	@ValidLength(maxLength = 255)
	private String tenXaPhuong;

	public String getTenXaPhuong() {
		return this.tenXaPhuong;
	}

	public void setTenXaPhuong(String tenXaPhuong) {
		this.tenXaPhuong = tenXaPhuong;
	}

	@ValidLength(maxLength = 13)
	private String maNguoiTao;

	public String getMaNguoiTao() {
		return this.maNguoiTao;
	}

	public void setMaNguoiTao(String maNguoiTao) {
		this.maNguoiTao = maNguoiTao;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsThongTinCoSoSX1: [ ");

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

		builder.append("tenTinh = " + tenTinh);

		builder.append(" | ");

		builder.append("tenHuyen = " + tenHuyen);

		builder.append(" | ");

		builder.append("tenXaPhuong = " + tenXaPhuong);

		builder.append(" | ");

		builder.append("maNguoiTao = " + maNguoiTao);

		builder.append(" ]");

		return builder.toString();

	}




}