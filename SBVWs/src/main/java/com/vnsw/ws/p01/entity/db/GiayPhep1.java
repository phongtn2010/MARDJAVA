package com.vnsw.ws.p01.entity.db;
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
	

	public Date getNgayXuatNhapKhauDen() {
		return ngayXuatNhapKhauDen;
	}
	public void setNgayXuatNhapKhauDen(Date ngayXuatNhapKhauDen) {
		this.ngayXuatNhapKhauDen = ngayXuatNhapKhauDen;
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
	
	

	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
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
	
	private String maCoQuan;
	
	private String tenCoQuan;
	
	
	
	public String getMaCoQuan() {
		return maCoQuan;
	}
	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}
	public String getTenCoQuan() {
		return tenCoQuan;
	}
	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
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
		return "GiayPhep1 [idCapGXNHoSo=" + idCapGXNHoSo + ", idHoSo=" + idHoSo + ", soGiayPhep=" + soGiayPhep
				+ ", maCuaKhau=" + maCuaKhau + ", tenCuaKhau=" + tenCuaKhau + ", ngayXuatNhapKhauTu="
				+ ngayXuatNhapKhauTu + ", ngayXuatNhapKhauDen=" + ngayXuatNhapKhauDen + ", maLoaiTepDinhKem="
				+ maLoaiTepDinhKem + ", tenLoaiTepDinhKem=" + tenLoaiTepDinhKem + ", tenTepDinhKem=" + tenTepDinhKem
				+ ", nguoiKy=" + nguoiKy + ", ngayCap=" + ngayCap + ", ngayHetHan=" + ngayHetHan + ", maSoThue="
				+ maSoThue + ", tenNganHang=" + tenNganHang + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai
				+ ", fax=" + fax + ", guID=" + guID + ", duongDanFile=" + duongDanFile + ", maCoQuan=" + maCoQuan
				+ ", tenCoQuan=" + tenCoQuan + "]";
	}

}