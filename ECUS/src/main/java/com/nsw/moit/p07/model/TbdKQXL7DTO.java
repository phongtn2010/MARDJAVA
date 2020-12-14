package com.nsw.moit.p07.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbdKQXL7DTO {
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
	
	private String tenTrangThai;
	
	private String nguoiXuLy;
	
	public String getNguoiXuLy() {
		return nguoiXuLy;
	}
	public void setNguoiXuLy(String nguoiXuLy) {
		this.nguoiXuLy = nguoiXuLy;
	}
	
	private List<ContentChange7DTO> contentChanges = new ArrayList<>();

	
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public List<ContentChange7DTO> getContentChanges() {
		return contentChanges;
	}
	public void setContentChanges(List<ContentChange7DTO> contentChanges) {
		this.contentChanges = contentChanges;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdKQXL7 { ");
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
