package com.nsw.monre.p01.searchitem;

import java.util.Date;



public class TbdHSDeNghiCapGiayXn1SearchItem {

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
	}

	private String fimasothue = null;

	public String getFimasothue() {
		return this.fimasothue;
	}

	public void setFimasothue(String fimasothue) {
		this.fimasothue = fimasothue;
	}

	private String fitendn = null;

	public String getFitendn() {
		return this.fitendn;
	}

	public void setFitendn(String fitendn) {
		this.fitendn = fitendn;
	}

	private String fisogcndkkd = null;

	public String getFisogcndkkd() {
		return this.fisogcndkkd;
	}

	public void setFisogcndkkd(String fisogcndkkd) {
		this.fisogcndkkd = fisogcndkkd;
	}

	private Date fingaycapgcndkkd = null;

	public Date getFingaycapgcndkkd() {
		return this.fingaycapgcndkkd;
	}

	public void setFingaycapgcndkkd(Date fingaycapgcndkkd) {
		this.fingaycapgcndkkd = fingaycapgcndkkd;
	}

	private Date fingayguiStart = null;

	public Date getFingayguiStart() {
		return this.fingayguiStart;
	}

	public void setFingayguiStart(Date fingayguiStart) {
		this.fingayguiStart = fingayguiStart;
	}

	private Date fingayguiEnd = null;

	public Date getFingayguiEnd() {
		return this.fingayguiEnd;
	}

	public void setFingayguiEnd(Date fingayguiEnd) {
		this.fingayguiEnd = fingayguiEnd;
	}

	private String fisogxndacap = null;

	public String getFisogxndacap() {
		return this.fisogxndacap;
	}

	public void setFisogxndacap(String fisogxndacap) {
		this.fisogxndacap = fisogxndacap;
	}

	private Date fingaycapStart = null;

	public Date getFingaycapStart() {
		return this.fingaycapStart;
	}

	public void setFingaycapStart(Date fingaycapStart) {
		this.fingaycapStart = fingaycapStart;
	}

	private Date fingaycapEnd = null;

	public Date getFingaycapEnd() {
		return this.fingaycapEnd;
	}

	public void setFingaycapEnd(Date fingaycapEnd) {
		this.fingaycapEnd = fingaycapEnd;
	}

	private String fimahoso = null;

	public String getFimahoso() {
		return this.fimahoso;
	}

	public void setFimahoso(String fimahoso) {
		this.fimahoso = fimahoso;
	}

	private int fitrangthai = -1;

	public int getFitrangthai() {
		return this.fitrangthai;
	}

	public void setFitrangthai(int fitrangthai) {
		this.fitrangthai = fitrangthai;
	}

	private int fixoa = 0;

	public int getFixoa() {
		return this.fixoa;
	}

	public void setFixoa(int fixoa) {
		this.fixoa = fixoa;
	}

	private Date fingaytaoStart = null;

	public Date getFingaytaoStart() {
		return this.fingaytaoStart;
	}

	public void setFingaytaoStart(Date fingaytaoStart) {
		this.fingaytaoStart = fingaytaoStart;
	}

	private Date fingaytaoEnd = null;

	public Date getFingaytaoEnd() {
		return this.fingaytaoEnd;
	}

	public void setFingaytaoEnd(Date fingaytaoEnd) {
		this.fingaytaoEnd = fingaytaoEnd;
	}

	private String filoaithutuc = null;

	public String getFiloaithutuc() {
		return this.filoaithutuc;
	}

	public void setFiloaithutuc(String filoaithutuc) {
		this.filoaithutuc = filoaithutuc;
	}

	private int pageIndex;

	public int getPageIndex() {
		return this.pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	private int pageSize;

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private String orderBy;

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdHSDeNghiCapGiayXn1: [ ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | ");

		builder.append("FIMASOTHUE = " + fimasothue);

		builder.append(" | ");

		builder.append("FITENDN = " + fitendn);

		builder.append(" | ");

		builder.append("FISOGCNDKKD = " + fisogcndkkd);

		builder.append(" | ");

		builder.append("FINGAYCAPGCNDKKD = " + fingaycapgcndkkd);

		builder.append(" | ");

		builder.append("FINGAYGUIStart = " + fingayguiStart);

		builder.append(" | ");

		builder.append("FINGAYGUIEnd = " + fingayguiEnd);

		builder.append(" | ");

		builder.append("FISOGXNDACAP = " + fisogxndacap);

		builder.append(" | ");

		builder.append("FINGAYCAPStart = " + fingaycapStart);

		builder.append(" | ");

		builder.append("FINGAYCAPEnd = " + fingaycapEnd);

		builder.append(" | ");

		builder.append("FIMAHOSO = " + fimahoso);

		builder.append(" | ");

		builder.append("FITRANGTHAI = " + fitrangthai);

		builder.append(" | ");

		builder.append("FIXOA = " + fixoa);

		builder.append(" | ");

		builder.append("FINGAYTAOStart = " + fingaytaoStart);

		builder.append(" | ");

		builder.append("FINGAYTAOEnd = " + fingaytaoEnd);

		builder.append(" | ");

		builder.append("FILOAITHUTUC = " + filoaithutuc);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}