package com.nsw.sbv.p01.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HoSoNgoaiTeEditForm {

	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	private String maChiNhanh;
	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}
	public String getMaChiNhanh() {
		return this.maChiNhanh;
	}

	private String tenChiNhanh;
	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}
	public String getTenChiNhanh() {
		return this.tenChiNhanh;
	}

	private int hinhThucXNK = 1;
	

	public int getHinhThucXNK() {
		return hinhThucXNK;
	}
	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
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

	private Date xuatNhapKhauTuNgay;
	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}
	public Date getXuatNhapKhauTuNgay() {
		return this.xuatNhapKhauTuNgay;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date xuatNhapKhauTuNgayDateFormat;
	
	

	public Date getXuatNhapKhauTuNgayDateFormat() {
		return xuatNhapKhauTuNgayDateFormat;
	}
	public void setXuatNhapKhauTuNgayDateFormat(Date xuatNhapKhauTuNgayDateFormat) {
		this.xuatNhapKhauTuNgayDateFormat = xuatNhapKhauTuNgayDateFormat;
	}

	private Date xuatNhapKhauDenNgay;
	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}
	public Date getXuatNhapKhauDenNgay() {
		return this.xuatNhapKhauDenNgay;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date xuatNhapKhauDenNgayDateFormat;
	
	

	public Date getXuatNhapKhauDenNgayDateFormat() {
		return xuatNhapKhauDenNgayDateFormat;
	}
	public void setXuatNhapKhauDenNgayDateFormat(Date xuatNhapKhauDenNgayDateFormat) {
		this.xuatNhapKhauDenNgayDateFormat = xuatNhapKhauDenNgayDateFormat;
	}

	private boolean capGiayPhepLanDau = true;
	public void setCapGiayPhepLanDau(boolean capGiayPhepLanDau) {
		this.capGiayPhepLanDau = capGiayPhepLanDau;
	}
	public boolean isCapGiayPhepLanDau() {
		return this.capGiayPhepLanDau;
	}

	private String soGiayPhepDaCap;
	public void setSoGiayPhepDaCap(String soGiayPhepDaCap) {
		this.soGiayPhepDaCap = soGiayPhepDaCap;
	}
	public String getSoGiayPhepDaCap() {
		return this.soGiayPhepDaCap;
	}

	private String doiTacXuatNhapKhau;
	public void setDoiTacXuatNhapKhau(String doiTacXuatNhapKhau) {
		this.doiTacXuatNhapKhau = doiTacXuatNhapKhau;
	}
	public String getDoiTacXuatNhapKhau() {
		return this.doiTacXuatNhapKhau;
	}

	private Date ngayTao;
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayTao() {
		return this.ngayTao;
	}

	private int trangThai;
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return this.trangThai;
	}

	private boolean xoaHoSo;
	public void setXoaHoSo(boolean xoaHoSo) {
		this.xoaHoSo = xoaHoSo;
	}
	public boolean isXoaHoSo() {
		return this.xoaHoSo;
	}
	
	private boolean xemHoSo;

	public boolean isXemHoSo() {
		return xemHoSo;
	}

	public void setXemHoSo(boolean xemHoSo) {
		this.xemHoSo = xemHoSo;
	}
	
	private List<TienTeEditForm> tienTes = new ArrayList<>();
	
	public List<TienTeEditForm> getTienTes() {
		return tienTes;
	}
	public void setTienTes(List<TienTeEditForm> tienTes) {
		this.tienTes = tienTes;
	}
	
	private String tenTrangThai;
	
	
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
	private boolean guiHoSo;
	
	
	
	public boolean isGuiHoSo() {
		return guiHoSo;
	}
	public void setGuiHoSo(boolean guiHoSo) {
		this.guiHoSo = guiHoSo;
	}
	
	private List<TepDinhKemHoSoEditForm> tepTins = new ArrayList<>();
	private List<TepDinhKemHoSoEditForm> tepTin2s = new ArrayList<>();
	private List<TepDinhKemHoSoEditForm> tepTin3s = new ArrayList<>();
	
	public List<TepDinhKemHoSoEditForm> getTepTin2s() {
		return tepTin2s;
	}
	public void setTepTin2s(List<TepDinhKemHoSoEditForm> tepTin2s) {
		this.tepTin2s = tepTin2s;
	}
	public List<TepDinhKemHoSoEditForm> getTepTin3s() {
		return tepTin3s;
	}
	public void setTepTin3s(List<TepDinhKemHoSoEditForm> tepTin3s) {
		this.tepTin3s = tepTin3s;
	}
	public List<TepDinhKemHoSoEditForm> getTepTins() {
		return tepTins;
	}
	public void setTepTins(List<TepDinhKemHoSoEditForm> tepTins) {
		this.tepTins = tepTins;
	}
	
	private String maLoaiTepDinhKem = "1";
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}
	
	private List<ChiNhanhNganHang1> chiNhanhNganHang1s = new ArrayList<>();
	private List<CuaKhau1> cuaKhau1s = new ArrayList<>();
	private List<LoaiTienTe1> loaiTienTe1s = new ArrayList<>();
	
	
	public List<ChiNhanhNganHang1> getChiNhanhNganHang1s() {
		return chiNhanhNganHang1s;
	}
	public void setChiNhanhNganHang1s(List<ChiNhanhNganHang1> chiNhanhNganHang1s) {
		this.chiNhanhNganHang1s = chiNhanhNganHang1s;
	}
	public List<CuaKhau1> getCuaKhau1s() {
		return cuaKhau1s;
	}
	public void setCuaKhau1s(List<CuaKhau1> cuaKhau1s) {
		this.cuaKhau1s = cuaKhau1s;
	}
	
	
	public List<LoaiTienTe1> getLoaiTienTe1s() {
		return loaiTienTe1s;
	}
	public void setLoaiTienTe1s(List<LoaiTienTe1> loaiTienTe1s) {
		this.loaiTienTe1s = loaiTienTe1s;
	}
	
	@JsonProperty("ngayTaoDateFormat")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date getNgayTaoDateFormat() {
		return ngayTao;
	}
	
	private String tienTeJsonString;
	private String tepLoai1JsonString;
	private String tepLoai2JsonString;
	private String tepLoai3JsonString;
	
	
	
	public String getTienTeJsonString() {
		return tienTeJsonString;
	}
	public void setTienTeJsonString(String tienTeJsonString) {
		this.tienTeJsonString = tienTeJsonString;
	}
	public String getTepLoai1JsonString() {
		return tepLoai1JsonString;
	}
	public void setTepLoai1JsonString(String tepLoai1JsonString) {
		this.tepLoai1JsonString = tepLoai1JsonString;
	}
	public String getTepLoai2JsonString() {
		return tepLoai2JsonString;
	}
	public void setTepLoai2JsonString(String tepLoai2JsonString) {
		this.tepLoai2JsonString = tepLoai2JsonString;
	}
	
	public String getTepLoai3JsonString() {
		return tepLoai3JsonString;
	}
	public void setTepLoai3JsonString(String tepLoai3JsonString) {
		this.tepLoai3JsonString = tepLoai3JsonString;
	}
	
	private String xmlContent;
	private String serialNumber;
	private String xmlEnvelop;
	
	
	public String getXmlEnvelop() {
		return xmlEnvelop;
	}
	public void setXmlEnvelop(String xmlEnvelop) {
		this.xmlEnvelop = xmlEnvelop;
	}
	public String getXmlContent() {
		return xmlContent;
	}
	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	private boolean isSign;
	
	
	public boolean isSign() {
		return isSign;
	}
	public void setSign(boolean isSign) {
		this.isSign = isSign;
	}
	
	private long totalFileSize;
	
	public long getTotalFileSize() {
		return totalFileSize;
	}
	public void setTotalFileSize(long totalFileSize) {
		this.totalFileSize = totalFileSize;
	}
	
	private List<TbsTepDinhKem1> danhMucTepDinhKems = new ArrayList<>();
	
	
	
	public List<TbsTepDinhKem1> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem1> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}

	private List<TepDinhKemHoSo1> tepDinhKems = new ArrayList<>();
	
	
	public List<TepDinhKemHoSo1> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<TepDinhKemHoSo1> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
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
		return "HoSoNgoaiTeEditForm [idHoSo=" + idHoSo + ", maChiNhanh=" + maChiNhanh + ", tenChiNhanh=" + tenChiNhanh
				+ ", hinhThucXNK=" + hinhThucXNK + ", maSoThue=" + maSoThue + ", tenNganHang=" + tenNganHang
				+ ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", fax=" + fax + ", maCuaKhau=" + maCuaKhau
				+ ", tenCuaKhau=" + tenCuaKhau + ", xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay
				+ ", xuatNhapKhauTuNgayDateFormat=" + xuatNhapKhauTuNgayDateFormat + ", xuatNhapKhauDenNgay="
				+ xuatNhapKhauDenNgay + ", xuatNhapKhauDenNgayDateFormat=" + xuatNhapKhauDenNgayDateFormat
				+ ", capGiayPhepLanDau=" + capGiayPhepLanDau + ", soGiayPhepDaCap=" + soGiayPhepDaCap
				+ ", doiTacXuatNhapKhau=" + doiTacXuatNhapKhau + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai
				+ ", xoaHoSo=" + xoaHoSo + ", xemHoSo=" + xemHoSo + ", tienTes=" + tienTes + ", tenTrangThai="
				+ tenTrangThai + ", guiHoSo=" + guiHoSo + ", tepTins=" + tepTins + ", tepTin2s=" + tepTin2s
				+ ", tepTin3s=" + tepTin3s + ", maLoaiTepDinhKem=" + maLoaiTepDinhKem + ", chiNhanhNganHang1s="
				+ chiNhanhNganHang1s + ", cuaKhau1s=" + cuaKhau1s + ", loaiTienTe1s=" + loaiTienTe1s
				+ ", tienTeJsonString=" + tienTeJsonString + ", tepLoai1JsonString=" + tepLoai1JsonString
				+ ", tepLoai2JsonString=" + tepLoai2JsonString + ", tepLoai3JsonString=" + tepLoai3JsonString
				+ ", xmlContent=" + xmlContent + ", serialNumber=" + serialNumber + "]";
	}
	
	
	
	
}
