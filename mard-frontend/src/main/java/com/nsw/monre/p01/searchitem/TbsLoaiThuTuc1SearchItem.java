package com.nsw.monre.p01.searchitem;




public class TbsLoaiThuTuc1SearchItem {

	private String filoaithutuc = null;

	public String getFiloaithutuc() {
		return this.filoaithutuc;
	}

	public void setFiloaithutuc(String filoaithutuc) {
		this.filoaithutuc = filoaithutuc;
	}

	private String fitenthutuc = null;

	public String getFitenthutuc() {
		return this.fitenthutuc;
	}

	public void setFitenthutuc(String fitenthutuc) {
		this.fitenthutuc = fitenthutuc;
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

		builder.append("TbsLoaiThuTuc1: [ ");

		builder.append("FILOAITHUTUC = " + filoaithutuc);

		builder.append(" | ");

		builder.append("FITENTHUTUC = " + fitenthutuc);

		builder.append(" | ");

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}