package com.nsw.moit.p07.model;

import java.util.Date;

public class TbdDinhKem7 {

	private Long idTepTin;
	public void setIdTepTin(Long idTepTin) {
		this.idTepTin = idTepTin;
	}
	public Long getIdTepTin() {
		return this.idTepTin;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private String loaiTep;
	public void setLoaiTep(String loaiTep) {
		this.loaiTep = loaiTep;
	}
	public String getLoaiTep() {
		return this.loaiTep;
	}

	private String tenTep;
	public void setTenTep(String tenTep) {
		this.tenTep = tenTep;
	}
	public String getTenTep() {
		return this.tenTep;
	}

	private String duongDanFile;
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	public String getDuongDanFile() {
		return this.duongDanFile;
	}

	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
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

	private Integer loaiHS;
	public void setLoaiHS(Integer loaiHS) {
		this.loaiHS = loaiHS;
	}
	public Integer getLoaiHS() {
		return this.loaiHS;
	}

	private String guID;
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getGuID() {
		return this.guID;
	}

	private Integer maLoaiTep;
	public void setMaLoaiTep(Integer maLoaiTep) {
		this.maLoaiTep = maLoaiTep;
	}
	public Integer getMaLoaiTep() {
		return this.maLoaiTep;
	}

	private Long size;

	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdDinhKem7 { ");
		stringBuilder.append("idTepTin=" + idTepTin); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiTep=" + loaiTep); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTep=" + tenTep); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem); 
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
		stringBuilder.append("loaiHS=" + loaiHS); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTep=" + maLoaiTep); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}