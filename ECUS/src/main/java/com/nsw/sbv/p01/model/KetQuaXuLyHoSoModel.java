package com.nsw.sbv.p01.model;

import java.util.Date;


public class KetQuaXuLyHoSoModel {

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

	
	private int trangThai;
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return this.trangThai;
	}

	private String tenTrangThai;
	private int soThuTu;
	private String ngayTacDongDateFormat;
	
	
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public int getSoThuTu() {
		return soThuTu;
	}
	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	public String getNgayTacDongDateFormat() {
		return ngayTacDongDateFormat;
	}
	public void setNgayTacDongDateFormat(String ngayTacDongDateFormat) {
		this.ngayTacDongDateFormat = ngayTacDongDateFormat;
	}
	
	private String guID;
	
	private String duongDanFile;

	public String getGuID() {
		return guID;
	}
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getDuongDanFile() {
		return duongDanFile;
	}
	public void setDuongDanFile(String duongDanFile) {
		this.duongDanFile = duongDanFile;
	}
	
	private String loaiTep;

	public String getLoaiTep() {
		return loaiTep;
	}
	public void setLoaiTep(String loaiTep) {
		this.loaiTep = loaiTep;
	}
	
	private String link;
	
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "KetQuaXuLyHoSoModel [idKetQuanXuLyHoSo=" + idKetQuanXuLyHoSo + ", idHoSo=" + idHoSo + ", ngayXuLy="
				+ ngayXuLy + ", donViXuLy=" + donViXuLy + ", chuyenVienXuLy=" + chuyenVienXuLy + ", noiDungXuLy="
				+ noiDungXuLy + ", maLoaiTepDinhKem=" + maLoaiTepDinhKem + ", tenLoaiTepDinhKem=" + tenLoaiTepDinhKem
				+ ", tenTepDinhKem=" + tenTepDinhKem + ", trangThai=" + trangThai + ", tenTrangThai=" + tenTrangThai
				+ ", soThuTu=" + soThuTu + ", ngayTacDongDateFormat=" + ngayTacDongDateFormat + ", guID=" + guID
				+ ", duongDanFile=" + duongDanFile + ", loaiTep=" + loaiTep + ", link=" + link + "]";
	}
	
}