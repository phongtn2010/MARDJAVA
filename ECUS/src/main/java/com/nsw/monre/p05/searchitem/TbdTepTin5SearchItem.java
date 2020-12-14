package com.nsw.monre.p05.searchitem;




public class TbdTepTin5SearchItem {

	private long fiid = -1;

	public long getFiid() {
		return this.fiid;
	}

	public void setFiid(long fiid) {
		this.fiid = fiid;
	}

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
	}

	private int filoaiteptin = -1;

	public int getFiloaiteptin() {
		return this.filoaiteptin;
	}

	public void setFiloaiteptin(int filoaiteptin) {
		this.filoaiteptin = filoaiteptin;
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

		builder.append("TbdTepTin5: [ ");

		builder.append("FIID = " + fiid);

		builder.append(" | ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | ");

		builder.append("FILOAITEPTIN = " + filoaiteptin);

		builder.append(" | ");

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}