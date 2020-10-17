package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;



public class TbsCoQuanXuLy1  extends TbsCoQuanXuLy1BaseModel{

	@ValidLength(maxLength = 20)
	private String maCoQuan;

	public String getMaCoQuan() {
		return this.maCoQuan;
	}

	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenCoQuan;

	public String getTenCoQuan() {
		return this.tenCoQuan;
	}

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsCoQuanXuLy1: [ ");

		builder.append("maCoQuan = " + maCoQuan);

		builder.append(" | ");

		builder.append("tenCoQuan = " + tenCoQuan);

		builder.append(" ]");

		return builder.toString();

	}




}