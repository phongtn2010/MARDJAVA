package com.nsw.moit.p07.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class KetQuaXuLy7Model {

	private Long idKQXL;
	public void setIdKQXL(Long idKQXL) {
		this.idKQXL = idKQXL;
	}
	public Long getIdKQXL() {
		return this.idKQXL;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	private Date ngayXuLy;
	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}
	public Date getNgayXuLy() {
		return this.ngayXuLy;
	}

	private String donViXuLy;
	public void setDonViXuLy(String donViXuLy) {
		this.donViXuLy = donViXuLy;
	}
	public String getDonViXuLy() {
		return this.donViXuLy;
	}

	private String nguoiXuLy;
	public void setNguoiXuLy(String nguoiXuLy) {
		this.nguoiXuLy = nguoiXuLy;
	}
	public String getNguoiXuLy() {
		return this.nguoiXuLy;
	}

	private String nguoiTao;
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public String getNguoiTao() {
		return this.nguoiTao;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
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

	private String loaiBTIN;
	public void setLoaiBTIN(String loaiBTIN) {
		this.loaiBTIN = loaiBTIN;
	}
	public String getLoaiBTIN() {
		return this.loaiBTIN;
	}

	private String noiDung;
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNoiDung() {
		return this.noiDung;
	}

	private Integer trangThai;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}
	
	private String tenTrangThai;
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenTrangThai() {
		return this.tenTrangThai;
	}
	
}
