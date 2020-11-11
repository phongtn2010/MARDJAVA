package com.vnsw.ws.p01.message.receive;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p01.message.send.TepDinhKemHoSo;
import com.vnsw.ws.p01.message.send.ThongTinCuaKhau;

import java.util.List;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GP_XNKngoaite")
@XmlType(propOrder = { "soGiayPhep","ngayHetHan","ngayCap","nguoiKy","maCoQuanCapGiay","tenCoQuanCapGiay","hsCongty","currencyList","gate","thoiGianXNKTu","thoiGianXNKDen", "ghiChu", "attachment"})

public class GiayPhep {
	
	@XmlElement(name = "AuthoDeptCode")
	private String maCoQuanCapGiay;
	public String getMaCoQuanCapGiay() {
		return maCoQuanCapGiay;
	}
	public void setMaCoQuanCapGiay(String maCoQuanCapGiay) {
		this.maCoQuanCapGiay = maCoQuanCapGiay;
	}
	
	@XmlElement(name = "AuthoDeptName")
	private String tenCoQuanCapGiay;
	public String getTenCoQuanCapGiay() {
		return tenCoQuanCapGiay;
	}
	public void setTenCoQuanCapGiay(String tenCoQuanCapGiay) {
		this.tenCoQuanCapGiay = tenCoQuanCapGiay;
	}
	
	@XmlElement(name = "Company")
	private HSCongTy hsCongty;
	public HSCongTy getHsCongty() {
		return hsCongty;
	}
	public void setHsCongty(HSCongTy hsCongty) {
		this.hsCongty = hsCongty;
	}
	
	@XmlElementWrapper(name = "CurrencyList")
    @XmlElement(name = "Currency")
	private List<GPTienTe> currencyList;
	public List<GPTienTe> getCurrencyList() {
		return currencyList;
	}
	public void setCurrencyList(List<GPTienTe> currencyList) {
		this.currencyList = currencyList;
	}
	
	@XmlElement(name = "Gate")
    private ThongTinCuaKhau gate;

	public ThongTinCuaKhau getGate() {
		return gate;
	}
	public void setGate(ThongTinCuaKhau gate) {
		this.gate = gate;
	}
	
	@XmlElement(name = "Remarks")
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@XmlElement(name = "Attachment")
	private TepDinhKemHoSo attachment;	

	public TepDinhKemHoSo getAttachment() {
		return attachment;
	}
	public void setAttachment(TepDinhKemHoSo attachment) {
		this.attachment = attachment;
	}

	@XmlTransient
	private long idCapGXNHoSo;
	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}
	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
	}

	@XmlElement(name = "LicenceNo")
	private String soGiayPhep;	
	public String getSoGiayPhep() {
		return soGiayPhep;
	}
	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}

	@XmlTransient
	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ConformityDate")
	private Date ngayCap;
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	public Date getNgayCap() {
		return this.ngayCap;
	}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ValidLicenceDate")
	private Date ngayHetHan;
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "TimeFrom")
	private Date thoiGianXNKTu;
	
    public Date getThoiGianXNKTu() {
		return thoiGianXNKTu;
	}
	public void setThoiGianXNKTu(Date thoiGianXNKTu) {
		this.thoiGianXNKTu = thoiGianXNKTu;
	}
	
	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "TimeTo")
	private Date thoiGianXNKDen;
	
    public Date getThoiGianXNKDen() {
		return thoiGianXNKDen;
	}
	public void setThoiGianXNKDen(Date thoiGianXNKDen) {
		this.thoiGianXNKDen = thoiGianXNKDen;
	}
	@XmlTransient
	private Date hieuLucDenNgay;
	public void setHieuLucDenNgay(Date hieuLucDenNgay) {
		this.hieuLucDenNgay = hieuLucDenNgay;
	}
	public Date getHieuLucDenNgay() {
		return this.hieuLucDenNgay;
	}

	@XmlElement(name = "SignConfirmName")
	private String nguoiKy;
	
	public String getNguoiKy() {
		return nguoiKy;
	}
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}
	@Override
	public String toString() {
		return "GiayPhep [maCoQuanCapGiay=" + maCoQuanCapGiay + ", tenCoQuanCapGiay=" + tenCoQuanCapGiay + ", hsCongty="
				+ hsCongty + ", currencyList=" + currencyList + ", gate=" + gate + ", attachment=" + attachment
				+ ", idCapGXNHoSo=" + idCapGXNHoSo + ", soGiayPhep=" + soGiayPhep + ", idHoSo=" + idHoSo + ", ngayCap="
				+ ngayCap + ", ngayHetHan=" + ngayHetHan + ", thoiGianXNKTu=" + thoiGianXNKTu + ", thoiGianXNKDen="
				+ thoiGianXNKDen + ", hieuLucDenNgay=" + hieuLucDenNgay + ", nguoiKy=" + nguoiKy + "]";
	}

}