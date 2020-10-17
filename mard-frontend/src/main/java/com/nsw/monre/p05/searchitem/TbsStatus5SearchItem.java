package com.nsw.monre.p05.searchitem;




public class TbsStatus5SearchItem {

	private long fitrangthai = -5;

	public long getFitrangthai() {
		return this.fitrangthai;
	}

	public void setFitrangthai(long fitrangthai) {
		this.fitrangthai = fitrangthai;
	}

	private int fixoa = 0;

	public int getFixoa() {
		return this.fixoa;
	}

	public void setFixoa(int fixoa) {
		this.fixoa = fixoa;
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

		builder.append("TbsStatus5: [ ");

		builder.append("FITRANGTHAI = " + fitrangthai);

		builder.append(" | ");

		builder.append("FIXOA = " + fixoa);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}