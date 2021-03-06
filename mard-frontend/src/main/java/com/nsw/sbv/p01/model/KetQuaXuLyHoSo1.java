package com.nsw.sbv.p01.model;

import java.util.Date;

public class KetQuaXuLyHoSo1 {

	private long idKetQuanXuLyHoSo;
	public void setIdKetQuanXuLyHoSo(long idKetQuanXuLyHoSo) {
		this.idKetQuanXuLyHoSo = idKetQuanXuLyHoSo;
	}
	public long getIdKetQuanXuLyHoSo() {
		return this.idKetQuanXuLyHoSo;
	}

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

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

	private String chuyenVienXuLy;
	public void setChuyenVienXuLy(String chuyenVienXuLy) {
		this.chuyenVienXuLy = chuyenVienXuLy;
	}
	public String getChuyenVienXuLy() {
		return this.chuyenVienXuLy;
	}

	private String noiDungXuLy;
	public void setNoiDungXuLy(String noiDungXuLy) {
		this.noiDungXuLy = noiDungXuLy;
	}
	public String getNoiDungXuLy() {
		return this.noiDungXuLy;
	}

	private String maLoaiTepDinhKem;
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}

	private String tenLoaiTepDinhKem;
	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}
	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}

	private String noiDungFile;
	public void setNoiDungFile(String noiDungFile) {
		this.noiDungFile = noiDungFile;
	}
	public String getNoiDungFile() {
		return this.noiDungFile;
	}

	private int trangThai;
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return this.trangThai;
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

		stringBuilder.append("KetQuaXuLyHoSo1 { ");
		stringBuilder.append("idKetQuanXuLyHoSo=" + idKetQuanXuLyHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXuLy=" + ngayXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("donViXuLy=" + donViXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("chuyenVienXuLy=" + chuyenVienXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungXuLy=" + noiDungXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungFile=" + noiDungFile); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}