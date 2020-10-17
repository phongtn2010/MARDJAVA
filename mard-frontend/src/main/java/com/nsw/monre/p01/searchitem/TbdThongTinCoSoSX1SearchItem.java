package com.nsw.monre.p01.searchitem;




public class TbdThongTinCoSoSX1SearchItem {

	private long fitbdthongtincososxid = -1;

	public long getFitbdthongtincososxid() {
		return this.fitbdthongtincososxid;
	}

	public void setFitbdthongtincososxid(long fitbdthongtincososxid) {
		this.fitbdthongtincososxid = fitbdthongtincososxid;
	}

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

	private String fisodienthoai = null;

	public String getFisodienthoai() {
		return this.fisodienthoai;
	}

	public void setFisodienthoai(String fisodienthoai) {
		this.fisodienthoai = fisodienthoai;
	}

	private String fitentinh = null;

	public String getFitentinh() {
		return this.fitentinh;
	}

	public void setFitentinh(String fitentinh) {
		this.fitentinh = fitentinh;
	}

	private String fitenhuyen = null;

	public String getFitenhuyen() {
		return this.fitenhuyen;
	}

	public void setFitenhuyen(String fitenhuyen) {
		this.fitenhuyen = fitenhuyen;
	}

	private String fitenxaphuong = null;

	public String getFitenxaphuong() {
		return this.fitenxaphuong;
	}

	public void setFitenxaphuong(String fitenxaphuong) {
		this.fitenxaphuong = fitenxaphuong;
	}

	private long fiidhs = -1;

	public long getFiidhs() {
		return this.fiidhs;
	}

	public void setFiidhs(long fiidhs) {
		this.fiidhs = fiidhs;
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

		builder.append("TbdThongTinCoSoSX1: [ ");

		builder.append("FITBDTHONGTINCOSOSXID = " + fitbdthongtincososxid);

		builder.append(" | ");

		builder.append("FIIDCS = " + fiidcs);

		builder.append(" | ");

		builder.append("FITENCOSO = " + fitencoso);

		builder.append(" | ");

		builder.append("FIDIACHICOSO = " + fidiachicoso);

		builder.append(" | ");

		builder.append("FISODIENTHOAI = " + fisodienthoai);

		builder.append(" | ");

		builder.append("FITENTINH = " + fitentinh);

		builder.append(" | ");

		builder.append("FITENHUYEN = " + fitenhuyen);

		builder.append(" | ");

		builder.append("FITENXAPHUONG = " + fitenxaphuong);

		builder.append(" | ");

		builder.append("FIIDHS = " + fiidhs);

		builder.append(" | pageIndex = " + pageIndex);

		builder.append(" | pageSize = " + pageSize);

		builder.append(" | orderBy = " + orderBy);

		builder.append(" ]");

		return builder.toString();

	}


}