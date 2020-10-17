package com.nsw.sbv.p01.model;

import java.util.Date;

public class GiayPhep1 {

	private long idCapGXNHoSo;

	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}

	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
	}

	private long idHoSo;

	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}

	public long getIdHoSo() {
		return this.idHoSo;
	}

	private String soGiayPhep;

	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}

	public String getSoGiayPhep() {
		return this.soGiayPhep;
	}

	private String maCuaKhau;

	public void setMaCuaKhau(String maCuaKhau) {
		this.maCuaKhau = maCuaKhau;
	}

	public String getMaCuaKhau() {
		return this.maCuaKhau;
	}

	private String tenCuaKhau;

	public void setTenCuaKhau(String tenCuaKhau) {
		this.tenCuaKhau = tenCuaKhau;
	}

	public String getTenCuaKhau() {
		return this.tenCuaKhau;
	}

	private Date ngayXuatNhapKhauTu;

	public void setNgayXuatNhapKhauTu(Date ngayXuatNhapKhauTu) {
		this.ngayXuatNhapKhauTu = ngayXuatNhapKhauTu;
	}

	public Date getNgayXuatNhapKhauTu() {
		return this.ngayXuatNhapKhauTu;
	}

	private Date ngayXuatNhapKhauDen;

	public void setNgayXuatNhapKhauDen(Date ngayXuatNhapKhauDen) {
		this.ngayXuatNhapKhauDen = ngayXuatNhapKhauDen;
	}

	public Date getNgayXuatNhapKhauTuDen() {
		return this.ngayXuatNhapKhauDen;
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

	private String nguoiKy;

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getNguoiKy() {
		return this.nguoiKy;
	}

	private Date ngayCap;

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Date getNgayCap() {
		return this.ngayCap;
	}

	private Date ngayHetHan;

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	private String maSoThue;

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getMaSoThue() {
		return this.maSoThue;
	}

	private String tenNganHang;

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getTenNganHang() {
		return this.tenNganHang;
	}

	private String diaChi;

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	private String dienThoai;

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDienThoai() {
		return this.dienThoai;
	}

	private String fax;

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
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

	private String maCoQuan;

	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}

	public String getMaCoQuan() {
		return this.maCoQuan;
	}

	private String tenCoQuan;

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	public String getTenCoQuan() {
		return this.tenCoQuan;
	}

	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("GiayPhep1 { ");
		stringBuilder.append("idCapGXNHoSo=" + idCapGXNHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("idHoSo=" + idHoSo);
		stringBuilder.append(", ");
		stringBuilder.append("soGiayPhep=" + soGiayPhep);
		stringBuilder.append(", ");
		stringBuilder.append("maCuaKhau=" + maCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("tenCuaKhau=" + tenCuaKhau);
		stringBuilder.append(", ");
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem);
		stringBuilder.append(", ");
		stringBuilder.append("nguoiKy=" + nguoiKy);
		stringBuilder.append(", ");
		stringBuilder.append("ngayCap=" + ngayCap);
		stringBuilder.append(", ");
		stringBuilder.append("ngayHetHan=" + ngayHetHan);
		stringBuilder.append(", ");
		stringBuilder.append("maSoThue=" + maSoThue);
		stringBuilder.append(", ");
		stringBuilder.append("tenNganHang=" + tenNganHang);
		stringBuilder.append(", ");
		stringBuilder.append("diaChi=" + diaChi);
		stringBuilder.append(", ");
		stringBuilder.append("dienThoai=" + dienThoai);
		stringBuilder.append(", ");
		stringBuilder.append("fax=" + fax);
		stringBuilder.append(", ");
		stringBuilder.append("guID=" + guID);
		stringBuilder.append(", ");
		stringBuilder.append("duongDanFile=" + duongDanFile);
		stringBuilder.append(", ");
		stringBuilder.append("maCoQuan=" + maCoQuan);
		stringBuilder.append(", ");
		stringBuilder.append("tenCoQuan=" + tenCoQuan);
		stringBuilder.append(" }");

		return stringBuilder.toString();
	}
}