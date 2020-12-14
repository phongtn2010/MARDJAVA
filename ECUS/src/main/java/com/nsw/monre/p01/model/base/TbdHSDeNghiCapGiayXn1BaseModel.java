package com.nsw.monre.p01.model.base;

import java.util.ArrayList;
import java.util.List;


import com.nsw.monre.p01.model.Page;
import com.nsw.monre.p01.model.TbdTepTin1;
import com.nsw.monre.p01.model.TbdThongTinPheLieu1;
import com.nsw.monre.p01.model.TbsPheLieu1;


public abstract class TbdHSDeNghiCapGiayXn1BaseModel {


	private List<Long> thongTinCoSoSXs = new ArrayList<>();
	
	private List<TbdThongTinPheLieu1> thongTinPheLieus = new ArrayList<>();

	public List<Long> getThongTinCoSoSXs() {
		return thongTinCoSoSXs;
	}

	public void setThongTinCoSoSXs(List<Long> thongTinCoSoSXs) {
		this.thongTinCoSoSXs = thongTinCoSoSXs;
	}

	public List<TbdThongTinPheLieu1> getThongTinPheLieus() {
		return thongTinPheLieus;
	}

	public void setThongTinPheLieus(List<TbdThongTinPheLieu1> thongTinPheLieus) {
		this.thongTinPheLieus = thongTinPheLieus;
	}
	
	private List<TbsPheLieu1> pheLieus;

	public List<TbsPheLieu1> getPheLieus() {
		return pheLieus;
	}

	public void setPheLieus(List<TbsPheLieu1> pheLieus) {
		this.pheLieus = pheLieus;
	}
	
	private boolean guiHoSo;

	public boolean isGuiHoSo() {
		return guiHoSo;
	}

	public void setGuiHoSo(boolean guiHoSo) {
		this.guiHoSo = guiHoSo;
	}
	
	private boolean taoMoiHoSo = false;

	public boolean isTaoMoiHoSo() {
		return taoMoiHoSo;
	}

	public void setTaoMoiHoSo(boolean taoMoiHoSo) {
		this.taoMoiHoSo = taoMoiHoSo;
	}
	
	private boolean capNhatHoSo;

	public boolean isCapNhatHoSo() {
		return capNhatHoSo;
	}

	public void setCapNhatHoSo(boolean capNhatHoSo) {
		this.capNhatHoSo = capNhatHoSo;
	}
	
	

	private List<TbdTepTin1> tepTin1s;

	public List<TbdTepTin1> getTepTin1s() {
		return tepTin1s;
	}

	public void setTepTin1s(List<TbdTepTin1> tepTin1s) {
		this.tepTin1s = tepTin1s;
	}
	
	
	private boolean xemHoSo = false;

	public boolean isXemHoSo() {
		return xemHoSo;
	}

	public void setXemHoSo(boolean xemHoSo) {
		this.xemHoSo = xemHoSo;
	}
	
	private String tenTrangThai;

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
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
	
	private String xmlEnvelop;
	private String xmlBody;

	public String getXmlEnvelop() {
		return xmlEnvelop;
	}

	public void setXmlEnvelop(String xmlEnvelop) {
		this.xmlEnvelop = xmlEnvelop;
	}

	public String getXmlBody() {
		return xmlBody;
	}

	public void setXmlBody(String xmlBody) {
		this.xmlBody = xmlBody;
	}
	
}