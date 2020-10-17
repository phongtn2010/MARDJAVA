package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsw.monre.p01.model.base.*;
import java.util.Date;



public class TbdCapGiayXacNhan1  extends TbdCapGiayXacNhan1BaseModel{

	private long idGxn;

	public long getIdGxn() {
		return this.idGxn;
	}

	public void setIdGxn(long idGxn) {
		this.idGxn = idGxn;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 50)
	private String coQuanCap;

	public String getCoQuanCap() {
		return this.coQuanCap;
	}

	public void setCoQuanCap(String coQuanCap) {
		this.coQuanCap = coQuanCap;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 100)
	private String soGiayXN;

	public String getSoGiayXN() {
		return this.soGiayXN;
	}

	public void setSoGiayXN(String soGiayXN) {
		this.soGiayXN = soGiayXN;
	}

        @JsonFormat(pattern="dd/MM/yyyy")
	private Date ngayKy;

	public Date getNgayKy() {
		return this.ngayKy;
	}
	
	@JsonProperty
	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getNgayKyDateFormat() {
		return this.ngayKy;
	}

	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String nguoiKy;

	public String getNguoiKy() {
		return this.nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	private Date hieuLucTuNgay;

	public Date getHieuLucTuNgay() {
		return this.hieuLucTuNgay;
	}
	
	@JsonProperty
	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getHieuLucTuNgayDateFormat() {
		return this.hieuLucTuNgay;
	}

	public void setHieuLucTuNgay(Date hieuLucTuNgay) {
		this.hieuLucTuNgay = hieuLucTuNgay;
	}

	private Date hieuLucDenNgay;

	public Date getHieuLucDenNgay() {
		return this.hieuLucDenNgay;
	}
	
	@JsonProperty
	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getHieuLucDenNgayDateFormat() {
		return this.hieuLucDenNgay;
	}

	public void setHieuLucDenNgay(Date hieuLucDenNgay) {
		this.hieuLucDenNgay = hieuLucDenNgay;
	}

	private long hinhThuc;

	public long getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(long hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	private int loaiHS;

	public int getLoaiHS() {
		return this.loaiHS;
	}

	public void setLoaiHS(int loaiHS) {
		this.loaiHS = loaiHS;
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
	private String tenTepTin;

	public String getTenTepTin() {
		return this.tenTepTin;
	}

	public void setTenTepTin(String tenTepTin) {
		this.tenTepTin = tenTepTin;
	}


	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String maSoThue;

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	
	private String linkGiayXN;
	
	

	public String getLinkGiayXN() {
		return linkGiayXN;
	}

	public void setLinkGiayXN(String linkGiayXN) {
		this.linkGiayXN = linkGiayXN;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdCapGiayXacNhan1: [ ");

		builder.append("idGxn = " + idGxn);

		builder.append(" | ");

		builder.append("coQuanCap = " + coQuanCap);

		builder.append(" | ");

		builder.append("soGiayXN = " + soGiayXN);

		builder.append(" | ");

		builder.append("ngayKy = " + ngayKy);

		builder.append(" | ");

		builder.append("nguoiKy = " + nguoiKy);

		builder.append(" | ");

		builder.append("hieuLucTuNgay = " + hieuLucTuNgay);

		builder.append(" | ");

		builder.append("hieuLucDenNgay = " + hieuLucDenNgay);

		builder.append(" | ");

		builder.append("hinhThuc = " + hinhThuc);

		builder.append(" | ");

		builder.append("loaiHS = " + loaiHS);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("tenTepTin = " + tenTepTin);

		builder.append(" | ");
		
		builder.append("maSoThue = " + maSoThue);

		builder.append(" ]");

		return builder.toString();

	}




}