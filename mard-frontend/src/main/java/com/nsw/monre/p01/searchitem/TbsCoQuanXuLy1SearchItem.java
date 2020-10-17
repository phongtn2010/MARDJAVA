package com.nsw.monre.p01.searchitem;




public class TbsCoQuanXuLy1SearchItem {

	private String fimacoquan = null;

	public String getFimacoquan() {
		return this.fimacoquan;
	}

	public void setFimacoquan(String fimacoquan) {
		this.fimacoquan = fimacoquan;
	}

	private String fitencoquan = null;

	public String getFitencoquan() {
		return this.fitencoquan;
	}

	public void setFitencoquan(String fitencoquan) {
		this.fitencoquan = fitencoquan;
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

		builder.append("TbsCoQuanXuLy1: [ ");

		builder.append("FIMACOQUAN = " + fimacoquan);

		builder.append(" | ");

		builder.append("FITENCOQUAN = " + fitencoquan);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}