package com.nsw.monre.p01.searchitem;

import java.util.Date;



public class TbsDistrict1SearchItem {

	private String fidistrictid = null;

	public String getFidistrictid() {
		return this.fidistrictid;
	}

	public void setFidistrictid(String fidistrictid) {
		this.fidistrictid = fidistrictid;
	}

	private String fiprovinceid = null;

	public String getFiprovinceid() {
		return this.fiprovinceid;
	}

	public void setFiprovinceid(String fiprovinceid) {
		this.fiprovinceid = fiprovinceid;
	}

	private String fidistrictname = null;

	public String getFidistrictname() {
		return this.fidistrictname;
	}

	public void setFidistrictname(String fidistrictname) {
		this.fidistrictname = fidistrictname;
	}

	private Date fimodifydate = null;

	public Date getFimodifydate() {
		return this.fimodifydate;
	}

	public void setFimodifydate(Date fimodifydate) {
		this.fimodifydate = fimodifydate;
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

		builder.append("TbsDistrict1: [ ");

		builder.append("FIDISTRICTID = " + fidistrictid);

		builder.append(" | ");

		builder.append("FIPROVINCEID = " + fiprovinceid);

		builder.append(" | ");

		builder.append("FIDISTRICTNAME = " + fidistrictname);

		builder.append(" | ");

		builder.append("FIMODIFYDATE = " + fimodifydate);

		builder.append(" | ");

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}