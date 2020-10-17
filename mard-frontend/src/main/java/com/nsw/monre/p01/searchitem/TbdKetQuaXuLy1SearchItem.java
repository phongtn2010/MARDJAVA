package com.nsw.monre.p01.searchitem;

import java.util.Date;



public class TbdKetQuaXuLy1SearchItem {

	private long fiidkq = -1;

	public long getFiidkq() {
		return this.fiidkq;
	}

	public void setFiidkq(long fiidkq) {
		this.fiidkq = fiidkq;
	}

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
	}

	private Date fingaytao = null;

	public Date getFingaytao() {
		return this.fingaytao;
	}

	public void setFingaytao(Date fingaytao) {
		this.fingaytao = fingaytao;
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

		builder.append("TbdKetQuaXuLy1: [ ");

		builder.append("FIIDKQ = " + fiidkq);

		builder.append(" | ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | ");

		builder.append("FINGAYTAO = " + fingaytao);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}