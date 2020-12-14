package com.nsw.monre.p01.searchitem;




public class TbdCapGiayXacNhan1SearchItem {

	private long fiidgxn = -1;

	public long getFiidgxn() {
		return this.fiidgxn;
	}

	public void setFiidgxn(long fiidgxn) {
		this.fiidgxn = fiidgxn;
	}

	private String fisogiayxn = null;

	public String getFisogiayxn() {
		return this.fisogiayxn;
	}

	public void setFisogiayxn(String fisogiayxn) {
		this.fisogiayxn = fisogiayxn;
	}

	private long fihinhthuc = 0;

	public long getFihinhthuc() {
		return this.fihinhthuc;
	}

	public void setFihinhthuc(long fihinhthuc) {
		this.fihinhthuc = fihinhthuc;
	}

	private int filoaihs = -1;

	public int getFiloaihs() {
		return this.filoaihs;
	}

	public void setFiloaihs(int filoaihs) {
		this.filoaihs = filoaihs;
	}

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
	}

	private String fitenteptin = null;

	public String getFitenteptin() {
		return this.fitenteptin;
	}

	public void setFitenteptin(String fitenteptin) {
		this.fitenteptin = fitenteptin;
	}

	private String fimasothue = null;

	public String getFimasothue() {
		return this.fimasothue;
	}

	public void setFimasothue(String fimasothue) {
		this.fimasothue = fimasothue;
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

		builder.append("TbdCapGiayXacNhan1: [ ");

		builder.append("FIIDGXN = " + fiidgxn);

		builder.append(" | ");

		builder.append("FISOGIAYXN = " + fisogiayxn);

		builder.append(" | ");

		builder.append("FIHINHTHUC = " + fihinhthuc);

		builder.append(" | ");

		builder.append("FILOAIHS = " + filoaihs);

		builder.append(" | ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | ");

		builder.append("FITENTEPTIN = " + fitenteptin);

		builder.append(" | ");

		builder.append("FIMASOTHUE = " + fimasothue);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}