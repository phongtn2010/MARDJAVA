package com.nsw.moit.p06.model;

public class TbdCuaKhau6Search {
	private String maCuaKhau;
	private String tenCuaKhau;
	private int pageSize;
	private int pageIndex;
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageIndex() {
		return this.pageIndex;
	}

	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return this.pageSize;
	}
	

	public String getMaCuaKhau() {
		return maCuaKhau;
	}
	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}
	public String getTenCuaKhau() {
		return tenCuaKhau;
	}
	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}
	public TbdCuaKhau6Search(String maCuaKhau, String tenCuaKhau, int pageSize, int pageIndex) {
		super();
		this.maCuaKhau = maCuaKhau;
		this.tenCuaKhau = tenCuaKhau;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	
	public TbdCuaKhau6Search() {
		
	}
}
