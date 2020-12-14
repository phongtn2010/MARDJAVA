package com.nsw.moit.p06.model;

import java.util.Date;

public class TbdGiayPhep6 {

	private Long idGiayPhep;
	public void setIdGiayPhep(Long idGiayPhep) {
		this.idGiayPhep = idGiayPhep;
	}
	public Long getIdGiayPhep() {
		return this.idGiayPhep;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private String coQuanCap;
	public void setCoQuanCap(String coQuanCap) {
		this.coQuanCap = coQuanCap;
	}
	public String getCoQuanCap() {
		return this.coQuanCap;
	}

	private String maSoGP;
	public void setMaSoGP(String maSoGP) {
		this.maSoGP = maSoGP;
	}
	public String getMaSoGP() {
		return this.maSoGP;
	}

	private Date ngayKy;
	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}
	public Date getNgayKy() {
		return this.ngayKy;
	}

	private String nguoiKy;
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}
	public String getNguoiKy() {
		return this.nguoiKy;
	}

	private Integer loaiHinh;
	public void setLoaiHinh(Integer loaiHinh) {
		this.loaiHinh = loaiHinh;
	}
	public Integer getLoaiHinh() {
		return this.loaiHinh;
	}

	private Integer loaiGiayPhep;
	public void setLoaiGiayPhep(Integer loaiGiayPhep) {
		this.loaiGiayPhep = loaiGiayPhep;
	}
	public Integer getLoaiGiayPhep() {
		return this.loaiGiayPhep;
	}

	private Date ngayHetHan;
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	private String tenTepTin;
	public void setTenTepTin(String tenTepTin) {
		this.tenTepTin = tenTepTin;
	}
	public String getTenTepTin() {
		return this.tenTepTin;
	}

	private String guID;
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getGuID() {
		return this.guID;
	}

	private String duongDanFile;
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	public String getDuongDanFile() {
		return this.duongDanFile;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdGiayPhep6 { ");
		stringBuilder.append("idGiayPhep=" + idGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("coQuanCap=" + coQuanCap); 
		stringBuilder.append(", "); 
		stringBuilder.append("maSoGP=" + maSoGP); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayKy=" + ngayKy); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiKy=" + nguoiKy); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiHinh=" + loaiHinh); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiGiayPhep=" + loaiGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayHetHan=" + ngayHetHan); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepTin=" + tenTepTin); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}