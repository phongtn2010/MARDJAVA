package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;



public class TbsStatus1  extends TbsStatus1BaseModel{

	private long idTrangThai;

	public long getIdTrangThai() {
		return this.idTrangThai;
	}

	public void setIdTrangThai(long idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 255)
	private String tenTrangThai;

	public String getTenTrangThai() {
		return this.tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	@ValidLength(maxLength = 500)
	private String ghiChu;

	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	private int xoa;

	public int getXoa() {
		return this.xoa;
	}

	public void setXoa(int xoa) {
		this.xoa = xoa;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsStatus1: [ ");

		builder.append("idTrangThai = " + idTrangThai);

		builder.append(" | ");

		builder.append("tenTrangThai = " + tenTrangThai);

		builder.append(" | ");

		builder.append("ghiChu = " + ghiChu);

		builder.append(" | ");

		builder.append("xoa = " + xoa);

		builder.append(" ]");

		return builder.toString();

	}




}