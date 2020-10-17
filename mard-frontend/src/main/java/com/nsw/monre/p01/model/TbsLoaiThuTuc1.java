package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;



public class TbsLoaiThuTuc1  extends TbsLoaiThuTuc1BaseModel{

	@ValidLength(maxLength = 20)
	private String loaiThuTuc;

	public String getLoaiThuTuc() {
		return this.loaiThuTuc;
	}

	public void setLoaiThuTuc(String loaiThuTuc) {
		this.loaiThuTuc = loaiThuTuc;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 500)
	private String tenThuTuc;

	public String getTenThuTuc() {
		return this.tenThuTuc;
	}

	public void setTenThuTuc(String tenThuTuc) {
		this.tenThuTuc = tenThuTuc;
	}

	@ValidLength(maxLength = 2000)
	private String moTa;

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsLoaiThuTuc1: [ ");

		builder.append("loaiThuTuc = " + loaiThuTuc);

		builder.append(" | ");

		builder.append("tenThuTuc = " + tenThuTuc);

		builder.append(" | ");

		builder.append("moTa = " + moTa);

		builder.append(" ]");

		return builder.toString();

	}




}