package com.nsw.moit.p06.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class KetQuaXuLy6Model {

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

	private String noiDung;
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNoiDung() {
		return this.noiDung;
	}

	private String donVi;
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getDonVi() {
		return this.donVi;
	}

	private Integer trangThai;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	private Date ngayXyLy;
	public void setNgayXyLy(Date ngayXyLy) {
		this.ngayXyLy = ngayXyLy;
	}
	public Date getNgayXyLy() {
		return this.ngayXyLy;
	}
	
	private String nguoiXuLy;
	
	public String getNguoiXuLy() {
		return nguoiXuLy;
	}
	public void setNguoiXuLy(String nguoiXuLy) {
		this.nguoiXuLy = nguoiXuLy;
	}
	
	private String tenTrangThai;
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenTrangThai() {
		return this.tenTrangThai;
	}
	
}
