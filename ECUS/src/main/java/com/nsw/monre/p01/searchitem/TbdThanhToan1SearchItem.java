package com.nsw.monre.p01.searchitem;

import java.util.Date;



public class TbdThanhToan1SearchItem {

	private long fiidthanhtoan = -1;

	public long getFiidthanhtoan() {
		return this.fiidthanhtoan;
	}

	public void setFiidthanhtoan(long fiidthanhtoan) {
		this.fiidthanhtoan = fiidthanhtoan;
	}

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
	}

	private int fitrangthai = -1;

	public int getFitrangthai() {
		return this.fitrangthai;
	}

	public void setFitrangthai(int fitrangthai) {
		this.fitrangthai = fitrangthai;
	}

	private Date fingayxuly = null;

	public Date getFingayxuly() {
		return this.fingayxuly;
	}

	public void setFingayxuly(Date fingayxuly) {
		this.fingayxuly = fingayxuly;
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

		builder.append("TbdThanhToan1: [ ");

		builder.append("FIIDTHANHTOAN = " + fiidthanhtoan);

		builder.append(" | ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | ");

		builder.append("FITRANGTHAI = " + fitrangthai);

		builder.append(" | ");

		builder.append("FINGAYXULY = " + fingayxuly);

		builder.append(" | ");

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}