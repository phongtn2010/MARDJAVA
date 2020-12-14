package com.nsw.monre.p05.model;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;


public class HoSoEditForm {

	private String serialNumber;
	private String xmlEnvelop;
	private String xmlBody;
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

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

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	private String maCoQuan;

	public String getMaCoQuan() {
		return this.maCoQuan;
	}

	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}

	private String tenCoQuan;

	public String getTenCoQuan() {
		return this.tenCoQuan;
	}

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	private String maSoThue;

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	private String tenDN;

	public String getTenDN() {
		return this.tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	private String soGCNDKKD;

	public String getSoGCNDKKD() {
		return this.soGCNDKKD;
	}

	public void setSoGCNDKKD(String soGCNDKKD) {
		this.soGCNDKKD = soGCNDKKD;
	}


	private Date ngayCapGCNDKKD;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapGCNDKKDDateFormat;

	public Date getNgayCapGCNDKKD() {
		return this.ngayCapGCNDKKD;
	}

	public void setNgayCapGCNDKKD(Date ngayCapGCNDKKD) {
		this.ngayCapGCNDKKD = ngayCapGCNDKKD;
	}

	private String noiCapGCNDKKD;

	public String getNoiCapGCNDKKD() {
		return this.noiCapGCNDKKD;
	}

	public void setNoiCapGCNDKKD(String noiCapGCNDKKD) {
		this.noiCapGCNDKKD = noiCapGCNDKKD;
	}

	private String truSoChinh;

	public String getTruSoChinh() {
		return this.truSoChinh;
	}

	public void setTruSoChinh(String truSoChinh) {
		this.truSoChinh = truSoChinh;
	}

	private String nguoiDaiDien;

	public String getNguoiDaiDien() {
		return this.nguoiDaiDien;
	}

	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}

	private String soDTNguoiDaiDien;

	public String getSoDTNguoiDaiDien() {
		return this.soDTNguoiDaiDien;
	}

	public void setSoDTNguoiDaiDien(String soDTNguoiDaiDien) {
		this.soDTNguoiDaiDien = soDTNguoiDaiDien;
	}

	private String faxNguoiDaiDien;

	public String getFaxNguoiDaiDien() {
		return this.faxNguoiDaiDien;
	}

	public void setFaxNguoiDaiDien(String faxNguoiDaiDien) {
		this.faxNguoiDaiDien = faxNguoiDaiDien;
	}

	private String emailNguoiDaiDien;

	public String getEmailNguoiDaiDien() {
		return this.emailNguoiDaiDien;
	}

	public void setEmailNguoiDaiDien(String emailNguoiDaiDien) {
		this.emailNguoiDaiDien = emailNguoiDaiDien;
	}

	private int hinhThuc;

	public int getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(int hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	private int loaiHoSo;

	public int getLoaiHoSo() {
		return this.loaiHoSo;
	}

	public void setLoaiHoSo(int loaiHoSo) {
		this.loaiHoSo = loaiHoSo;
	}

	private String soGXNDaCap;

	public String getSoGXNDaCap() {
		return this.soGXNDaCap;
	}

	public void setSoGXNDaCap(String soGXNDaCap) {
		this.soGXNDaCap = soGXNDaCap;
	}

	
	private Date ngayCap;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapDateFormat;

	public Date getNgayCap() {
		return this.ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}


	private Date ngayHetHan;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayHetHanDateFormat;
	

	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	private String lyDo;

	public String getLyDo() {
		return this.lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	private String maHoSo;

	public String getMaHoSo() {
		return this.maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	private int trangThai;

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	private int xoa;

	public int getXoa() {
		return this.xoa;
	}

	public void setXoa(int xoa) {
		this.xoa = xoa;
	}


	private Date ngayTao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayTaoDateFormat;
	public Date getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	private String loaiThuTuc;

	public String getLoaiThuTuc() {
		return this.loaiThuTuc;
	}

	public void setLoaiThuTuc(String loaiThuTuc) {
		this.loaiThuTuc = loaiThuTuc;
	}

	public Date getNgayCapGCNDKKDDateFormat() {
		return ngayCapGCNDKKDDateFormat;
	}

	public void setNgayCapGCNDKKDDateFormat(Date ngayCapGCNDKKDDateFormat) {
		this.ngayCapGCNDKKDDateFormat = ngayCapGCNDKKDDateFormat;
	}

	public Date getNgayCapDateFormat() {
		return ngayCapDateFormat;
	}

	public void setNgayCapDateFormat(Date ngayCapDateFormat) {
		this.ngayCapDateFormat = ngayCapDateFormat;
	}

	public Date getNgayHetHanDateFormat() {
		return ngayHetHanDateFormat;
	}

	public void setNgayHetHanDateFormat(Date ngayHetHanDateFormat) {
		this.ngayHetHanDateFormat = ngayHetHanDateFormat;
	}

	public Date getNgayTaoDateFormat() {
		return ngayTaoDateFormat;
	}

	public void setNgayTaoDateFormat(Date ngayTaoDateFormat) {
		this.ngayTaoDateFormat = ngayTaoDateFormat;
	}
	
	private List<TbsCoQuanXuLy1> coQuanXuLyList = Collections.emptyList();
	

	public List<TbsCoQuanXuLy1> getCoQuanXuLyList() {
		return coQuanXuLyList;
	}

	public void setCoQuanXuLyList(List<TbsCoQuanXuLy1> coQuanXuLyList) {
		this.coQuanXuLyList = coQuanXuLyList;
	}
	

	private List<TbdTepTin5> tepDinhKemList = Collections.emptyList();
	
	
	public List<TbdTepTin5> getTepDinhKemList() {
		return tepDinhKemList;
	}

	public void setTepDinhKemList(List<TbdTepTin5> tepDinhKemList) {
		this.tepDinhKemList = tepDinhKemList;
	}
	
	private String tepDinhKemtJsonString;
	
	


	public String getTepDinhKemtJsonString() {
		return tepDinhKemtJsonString;
	}

	public void setTepDinhKemtJsonString(String tepDinhKemtJsonString) {
		this.tepDinhKemtJsonString = tepDinhKemtJsonString;
	}

	private boolean guiHoSo;

	public boolean isGuiHoSo() {
		return guiHoSo;
	}

	public void setGuiHoSo(boolean guiHoSo) {
		this.guiHoSo = guiHoSo;
	}

	@Override
	public String toString() {
		return "HoSoEditForm [idHS=" + idHS + ", maCoQuan=" + maCoQuan + ", tenCoQuan=" + tenCoQuan + ", maSoThue=" + maSoThue + ", tenDN=" + tenDN + ", soGCNDKKD=" + soGCNDKKD + ", ngayCapGCNDKKD=" + ngayCapGCNDKKD + ", ngayCapGCNDKKDDateFormat=" + ngayCapGCNDKKDDateFormat + ", noiCapGCNDKKD=" + noiCapGCNDKKD + ", truSoChinh=" + truSoChinh + ", nguoiDaiDien=" + nguoiDaiDien + ", soDTNguoiDaiDien=" + soDTNguoiDaiDien + ", faxNguoiDaiDien=" + faxNguoiDaiDien + ", emailNguoiDaiDien="
				+ emailNguoiDaiDien + ", hinhThuc=" + hinhThuc + ", loaiHoSo=" + loaiHoSo + ", soGXNDaCap=" + soGXNDaCap + ", ngayCap=" + ngayCap + ", ngayCapDateFormat=" + ngayCapDateFormat + ", ngayHetHan=" + ngayHetHan + ", ngayHetHanDateFormat=" + ngayHetHanDateFormat + ", lyDo=" + lyDo + ", maHoSo=" + maHoSo + ", trangThai=" + trangThai + ", xoa=" + xoa + ", ngayTao=" + ngayTao + ", ngayTaoDateFormat=" + ngayTaoDateFormat + ", loaiThuTuc=" + loaiThuTuc + ", coQuanXuLyList=" + coQuanXuLyList
				+ ", tepDinhKemList=" + tepDinhKemList + ", tepDinhKemtJsonString=" + tepDinhKemtJsonString + ", guiHoSo=" + guiHoSo + "]";
	}
	
	

	
	
	
}
