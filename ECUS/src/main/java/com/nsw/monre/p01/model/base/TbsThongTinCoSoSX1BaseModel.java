package com.nsw.monre.p01.model.base;

import java.util.ArrayList;
import java.util.List;

import com.nsw.monre.p01.model.Page;

public abstract class TbsThongTinCoSoSX1BaseModel {


	private long tbdThongTinCoSoSXId;
	
	private boolean canUpdate;

	public long getTbdThongTinCoSoSXId() {
		return tbdThongTinCoSoSXId;
	}

	public void setTbdThongTinCoSoSXId(long tbdThongTinCoSoSXId) {
		this.tbdThongTinCoSoSXId = tbdThongTinCoSoSXId;
	}

	public boolean isCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}
	
	
	private boolean canDelete;

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	
	private int soThuTu;

	public int getSoThuTu() {
		return soThuTu;
	}

	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	
	private int pageIndex = 1;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
	private List<Page> pages = new ArrayList<>();

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	private long idHS;

	public long getIdHS() {
		return idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}
	
	
	
}