package com.nsw.monre.p05.searchitem;

import java.util.Date;



public class TbsWard5SearchItem {

	private String fiwardid = null;

	public String getFiwardid() {
		return this.fiwardid;
	}

	public void setFiwardid(String fiwardid) {
		this.fiwardid = fiwardid;
	}

	private String fidistrictid = null;

	public String getFidistrictid() {
		return this.fidistrictid;
	}

	public void setFidistrictid(String fidistrictid) {
		this.fidistrictid = fidistrictid;
	}

	private String fiwardname = null;

	public String getFiwardname() {
		return this.fiwardname;
	}

	public void setFiwardname(String fiwardname) {
		this.fiwardname = fiwardname;
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

		builder.append("TbsWard5: [ ");

		builder.append("FIWARDID = " + fiwardid);

		builder.append(" | ");

		builder.append("FIDISTRICTID = " + fidistrictid);

		builder.append(" | ");

		builder.append("FIWARDNAME = " + fiwardname);

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