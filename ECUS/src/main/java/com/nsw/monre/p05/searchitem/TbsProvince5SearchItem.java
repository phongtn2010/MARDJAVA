package com.nsw.monre.p05.searchitem;

import java.util.Date;



public class TbsProvince5SearchItem {

	private String fiprovinceid = null;

	public String getFiprovinceid() {
		return this.fiprovinceid;
	}

	public void setFiprovinceid(String fiprovinceid) {
		this.fiprovinceid = fiprovinceid;
	}

	private String fiprovincename = null;

	public String getFiprovincename() {
		return this.fiprovincename;
	}

	public void setFiprovincename(String fiprovincename) {
		this.fiprovincename = fiprovincename;
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

		builder.append("TbsProvince5: [ ");

		builder.append("FIPROVINCEID = " + fiprovinceid);

		builder.append(" | ");

		builder.append("FIPROVINCENAME = " + fiprovincename);

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