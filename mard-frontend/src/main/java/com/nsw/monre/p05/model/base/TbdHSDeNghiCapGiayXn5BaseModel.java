package com.nsw.monre.p05.model.base;

import java.util.List;

import com.nsw.monre.p05.model.TbdTepTin5;

public abstract class TbdHSDeNghiCapGiayXn5BaseModel {

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
	
	

	private List<TbdTepTin5> tepTin5s;

	public List<TbdTepTin5> getTepTin5s() {
		return tepTin5s;
	}

	public void setTepTin5s(List<TbdTepTin5> tepTin5s) {
		this.tepTin5s = tepTin5s;
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
	
	
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}