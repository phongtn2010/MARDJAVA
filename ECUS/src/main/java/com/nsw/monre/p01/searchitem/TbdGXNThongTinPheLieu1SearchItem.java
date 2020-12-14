package com.nsw.monre.p01.searchitem;




public class TbdGXNThongTinPheLieu1SearchItem {

	private long fiidpl = -1;

	public long getFiidpl() {
		return this.fiidpl;
	}

	public void setFiidpl(long fiidpl) {
		this.fiidpl = fiidpl;
	}

	private String fitenphelieu = null;

	public String getFitenphelieu() {
		return this.fitenphelieu;
	}

	public void setFitenphelieu(String fitenphelieu) {
		this.fitenphelieu = fitenphelieu;
	}

	private String fimahs = null;

	public String getFimahs() {
		return this.fimahs;
	}

	public void setFimahs(String fimahs) {
		this.fimahs = fimahs;
	}

	private long fiidgxn = -1;

	public long getFiidgxn() {
		return this.fiidgxn;
	}

	public void setFiidgxn(long fiidgxn) {
		this.fiidgxn = fiidgxn;
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

		builder.append("TbdGXNThongTinPheLieu1: [ ");

		builder.append("FIIDPL = " + fiidpl);

		builder.append(" | ");

		builder.append("FITENPHELIEU = " + fitenphelieu);

		builder.append(" | ");

		builder.append("FIMAHS = " + fimahs);

		builder.append(" | ");

		builder.append("FIIDGXN = " + fiidgxn);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}