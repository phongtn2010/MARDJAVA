package com.nsw.monre.p05.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;



public class TbdTepTin5  extends TbdTepTin5BaseModel{

	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	private int loaiTepTin;

	public int getLoaiTepTin() {
		return this.loaiTepTin;
	}

	public void setLoaiTepTin(int loaiTepTin) {
		this.loaiTepTin = loaiTepTin;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenLoaiTep;

	public String getTenLoaiTep() {
		return this.tenLoaiTep;
	}

	public void setTenLoaiTep(String tenLoaiTep) {
		this.tenLoaiTep = tenLoaiTep;
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
	@ValidLength(maxLength = 250)
	private String tenTepTinId;

	public String getTenTepTinId() {
		return this.tenTepTinId;
	}

	public void setTenTepTinId(String tenTepTinId) {
		this.tenTepTinId = tenTepTinId;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdTepTin5: [ ");

		builder.append("id = " + id);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("loaiTepTin = " + loaiTepTin);

		builder.append(" | ");

		builder.append("tenLoaiTep = " + tenLoaiTep);

		builder.append(" | ");

		builder.append("tenTepTin = " + tenTepTin);

		builder.append(" | ");

		builder.append("tenTepTinId = " + tenTepTinId);

		builder.append(" ]");

		return builder.toString();

	}




}