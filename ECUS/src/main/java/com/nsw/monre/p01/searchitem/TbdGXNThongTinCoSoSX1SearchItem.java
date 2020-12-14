package com.nsw.monre.p01.searchitem;




public class TbdGXNThongTinCoSoSX1SearchItem {

	private long fiidcs = -1;

	public long getFiidcs() {
		return this.fiidcs;
	}

	public void setFiidcs(long fiidcs) {
		this.fiidcs = fiidcs;
	}

	private String fitencoso = null;

	public String getFitencoso() {
		return this.fitencoso;
	}

	public void setFitencoso(String fitencoso) {
		this.fitencoso = fitencoso;
	}

	private String fidiachicoso = null;

	public String getFidiachicoso() {
		return this.fidiachicoso;
	}

	public void setFidiachicoso(String fidiachicoso) {
		this.fidiachicoso = fidiachicoso;
	}

	private String fiemail = null;

	public String getFiemail() {
		return this.fiemail;
	}

	public void setFiemail(String fiemail) {
		this.fiemail = fiemail;
	}

	private String fimatinh = null;

	public String getFimatinh() {
		return this.fimatinh;
	}

	public void setFimatinh(String fimatinh) {
		this.fimatinh = fimatinh;
	}

	private String fimahuyen = null;

	public String getFimahuyen() {
		return this.fimahuyen;
	}

	public void setFimahuyen(String fimahuyen) {
		this.fimahuyen = fimahuyen;
	}

	private String fimaxaphuong = null;

	public String getFimaxaphuong() {
		return this.fimaxaphuong;
	}

	public void setFimaxaphuong(String fimaxaphuong) {
		this.fimaxaphuong = fimaxaphuong;
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

		builder.append("TbdGXNThongTinCoSoSX1: [ ");

		builder.append("FIIDCS = " + fiidcs);

		builder.append(" | ");

		builder.append("FITENCOSO = " + fitencoso);

		builder.append(" | ");

		builder.append("FIDIACHICOSO = " + fidiachicoso);

		builder.append(" | ");

		builder.append("FIEMAIL = " + fiemail);

		builder.append(" | ");

		builder.append("FIMATINH = " + fimatinh);

		builder.append(" | ");

		builder.append("FIMAHUYEN = " + fimahuyen);

		builder.append(" | ");

		builder.append("FIMAXAPHUONG = " + fimaxaphuong);

		builder.append(" | ");

		builder.append("FIIDGXN = " + fiidgxn);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}