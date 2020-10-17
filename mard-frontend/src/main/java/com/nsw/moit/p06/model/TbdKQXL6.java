package com.nsw.moit.p06.model;

import java.util.Date;

public class TbdKQXL6 {

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
	
	private Date ngayTao;

	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdKQXL6 { ");
		stringBuilder.append("idKQXL=" + idKQXL); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDung=" + noiDung); 
		stringBuilder.append(", "); 
		stringBuilder.append("donVi=" + donVi); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXyLy=" + ngayXyLy); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}