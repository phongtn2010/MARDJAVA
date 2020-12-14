package com.nsw.monre.p01.model;

import com.nsw.monre.p01.model.base.*;



public class TbsPheLieu1  extends TbsPheLieu1BaseModel{

	private String maHS;

	public String getMaHS() {
		return this.maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	private String tenPheLieu;

	public String getTenPheLieu() {
		return this.tenPheLieu;
	}

	public void setTenPheLieu(String tenPheLieu) {
		this.tenPheLieu = tenPheLieu;
	}

	private long tongKhoiLuong;

	public long getTongKhoiLuong() {
		return this.tongKhoiLuong;
	}

	public void setTongKhoiLuong(long tongKhoiLuong) {
		this.tongKhoiLuong = tongKhoiLuong;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsPheLieu1: [ ");

		builder.append("maHS = " + maHS);

		builder.append(" | ");

		builder.append("tenPheLieu = " + tenPheLieu);

		builder.append(" | ");

		builder.append("tongKhoiLuong = " + tongKhoiLuong);

		builder.append(" ]");

		return builder.toString();

	}




}