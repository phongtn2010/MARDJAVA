package com.vnsw.ws.p01.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HSDK_GP_XNKngoaite")
@XmlType(propOrder = { "maSoThue","tenNganHang","diaChi","dienThoai","fax"})
public class HSCongTy {
	
	@XmlElement(name = "TaxCode")
	private String maSoThue;
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getMaSoThue() {
		return this.maSoThue;
	}

	@XmlElement(name = "BankName")
	private String tenNganHang;
	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}
	public String getTenNganHang() {
		return this.tenNganHang;
	}

	@XmlElement(name = "Address")
	private String diaChi;
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChi() {
		return this.diaChi;
	}

	@XmlElement(name = "Phone")
	private String dienThoai;
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDienThoai() {
		return this.dienThoai;
	}

	@XmlElement(name = "Fax")
	private String fax;
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFax() {
		return this.fax;
	}
}
