package com.nsw.moit.p07.model;

import java.util.Date;

public class TbdGiayPhep7 {

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

	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}

	private String coQuanChuQuan;
	public void setCoQuanChuQuan(String coQuanChuQuan) {
		this.coQuanChuQuan = coQuanChuQuan;
	}
	public String getCoQuanChuQuan() {
		return this.coQuanChuQuan;
	}
	
	private String coQuanCap;

	public String getCoQuanCap() {
		return coQuanCap;
	}
	public void setCoQuanCap(String coQuanCap) {
		this.coQuanCap = coQuanCap;
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

	private String mucDich;
	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}
	public String getMucDich() {
		return this.mucDich;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}

	private String nguoiTao;
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public String getNguoiTao() {
		return this.nguoiTao;
	}

	private Date ngayTao;
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayTao() {
		return this.ngayTao;
	}

	private String nguoiChungNhan;
	public void setNguoiChungNhan(String nguoiChungNhan) {
		this.nguoiChungNhan = nguoiChungNhan;
	}
	public String getNguoiChungNhan() {
		return this.nguoiChungNhan;
	}

	private Date ngayChungNhan;
	public void setNgayChungNhan(Date ngayChungNhan) {
		this.ngayChungNhan = ngayChungNhan;
	}
	public Date getNgayChungNhan() {
		return this.ngayChungNhan;
	}

	private Date xuatNhapKhauTuNgay;
	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}
	public Date getXuatNhapKhauTuNgay() {
		return this.xuatNhapKhauTuNgay;
	}

	private Date xuatNhapKhauDenNgay;
	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}
	public Date getXuatNhapKhauDenNgay() {
		return this.xuatNhapKhauDenNgay;
	}

	private String soLan;
	public void setSoLan(String soLan) {
		this.soLan = soLan;
	}
	public String getSoLan() {
		return this.soLan;
	}

	private Integer loaiHoSo;
	public void setLoaiHoSo(Integer loaiHoSo) {
		this.loaiHoSo = loaiHoSo;
	}
	public Integer getLoaiHoSo() {
		return this.loaiHoSo;
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
	
	private Date ngayHieuLuc;
	public Date getNgayHieuLuc() {
		return ngayHieuLuc;
	}
	public void setNgayHieuLuc(Date ngayHieuLuc) {
		this.ngayHieuLuc = ngayHieuLuc;
	}
	
	private Date ngayHetHan;
	
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdGiayPhep7 { ");
		stringBuilder.append("idGiayPhep=" + idGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maHoSo=" + maHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("coQuanChuQuan=" + coQuanChuQuan); 
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
		stringBuilder.append("mucDich=" + mucDich); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiTao=" + nguoiTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayTao=" + ngayTao); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiChungNhan=" + nguoiChungNhan); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayChungNhan=" + ngayChungNhan); 
		stringBuilder.append(", "); 
		stringBuilder.append("xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay); 
		stringBuilder.append(", "); 
		stringBuilder.append("xuatNhapKhauDenNgay=" + xuatNhapKhauDenNgay); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLan=" + soLan); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiHoSo=" + loaiHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepTin=" + tenTepTin); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}