package com.nsw.moit.p07.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsw.moit.p06.model.TbsProvince6;
import com.nsw.moit.p06.model.TbsTepDinhKem6;

public class HoSo7EditForm {

	private String trangThaiHoSo;

	public String getTrangThaiHoSo() {
		return trangThaiHoSo;
	}

	public void setTrangThaiHoSo(String trangThaiHoSo) {
		this.trangThaiHoSo = trangThaiHoSo;
	}

	private Long idHoSo;

	private Long idHoSoGoc = 0L;

	public Long getIdHoSoGoc() {
		return idHoSoGoc;
	}

	public void setIdHoSoGoc(Long idHoSoGoc) {
		this.idHoSoGoc = idHoSoGoc;
	}

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

	private boolean saveFast = true;

	public boolean isSaveFast() {
		return saveFast;
	}

	public void setSaveFast(boolean saveFast) {
		this.saveFast = saveFast;
	}

	public void setChinhSua(boolean isChinhSua) {
		this.isChinhSua = isChinhSua;
	}

	@NotNull
	private String maSoThue;

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getMaSoThue() {
		return this.maSoThue;
	}

	private String tenDoanhNghiep;

	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}

	public String getTenDoanhNghiep() {
		return this.tenDoanhNghiep;
	}

	private String diaChiDoanhNghiep;

	public void setDiaChiDoanhNghiep(String diaChiDoanhNghiep) {
		this.diaChiDoanhNghiep = diaChiDoanhNghiep;
	}

	public String getDiaChiDoanhNghiep() {
		return this.diaChiDoanhNghiep;
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

	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	private String soGiayChungNhanDKKD;

	public void setSoGiayChungNhanDKKD(String soGiayChungNhanDKKD) {
		this.soGiayChungNhanDKKD = soGiayChungNhanDKKD;
	}

	public String getSoGiayChungNhanDKKD() {
		return this.soGiayChungNhanDKKD;
	}

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapGiayChungNhan;

	public void setNgayCapGiayChungNhan(Date ngayCapGiayChungNhan) {
		this.ngayCapGiayChungNhan = ngayCapGiayChungNhan;
	}

	public Date getNgayCapGiayChungNhan() {
		return this.ngayCapGiayChungNhan;
	}

	private Integer loaiHinh;

	public void setLoaiHinh(Integer loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public Integer getLoaiHinh() {
		return this.loaiHinh;
	}

	private String diaChiSanXuat;

	public void setDiaChiSanXuat(String diaChiSanXuat) {
		this.diaChiSanXuat = diaChiSanXuat;
	}

	public String getDiaChiSanXuat() {
		return this.diaChiSanXuat;
	}

	private String soGiayPhepTCTN;

	public void setSoGiayPhepTCTN(String soGiayPhepTCTN) {
		this.soGiayPhepTCTN = soGiayPhepTCTN;
	}

	public String getSoGiayPhepTCTN() {
		return this.soGiayPhepTCTN;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapGiayPhep;

	public void setNgayCapGiayPhep(Date ngayCapGiayPhep) {
		this.ngayCapGiayPhep = ngayCapGiayPhep;
	}

	public Date getNgayCapGiayPhep() {
		return this.ngayCapGiayPhep;
	}

	private Integer loaiGiayPhep;

	public void setLoaiGiayPhep(Integer loaiGiayPhep) {
		this.loaiGiayPhep = loaiGiayPhep;
	}

	public Integer getLoaiGiayPhep() {
		return this.loaiGiayPhep;
	}

	private Boolean isTemp;

	public void setIsTemp(Boolean isTemp) {
		this.isTemp = isTemp;
	}

	public Boolean getIsTemp() {
		return this.isTemp;
	}

	private Integer trangThai;

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public Integer getTrangThai() {
		return this.trangThai;
	}

	private String nguoiTao;

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public String getNguoiTao() {
		return this.nguoiTao;
	}

	private String lyDoSua;

	public void setLyDoSua(String lyDoSua) {
		this.lyDoSua = lyDoSua;
	}

	public String getLyDoSua() {
		return this.lyDoSua;
	}

	private String mucDich;

	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}

	public String getMucDich() {
		return this.mucDich;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngaySua;

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}

	public Date getNgaySua() {
		return this.ngaySua;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayNop;

	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}

	public Date getNgayNop() {
		return this.ngayNop;
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

	private boolean xemHoSo;

	public boolean isXemHoSo() {
		return xemHoSo;
	}

	public void setXemHoSo(boolean xemHoSo) {
		this.xemHoSo = xemHoSo;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayTao;

	private Boolean xoaBo;

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Boolean getXoaBo() {
		return xoaBo;
	}

	public void setXoaBo(Boolean xoaBo) {
		this.xoaBo = xoaBo;
	}

	private String soGiayPhepDaCap;

	private String lyDoGiaHan;

	public String getSoGiayPhepDaCap() {
		return soGiayPhepDaCap;
	}

	public void setSoGiayPhepDaCap(String soGiayPhepDaCap) {
		this.soGiayPhepDaCap = soGiayPhepDaCap;
	}

	public String getLyDoGiaHan() {
		return lyDoGiaHan;
	}

	public void setLyDoGiaHan(String lyDoGiaHan) {
		this.lyDoGiaHan = lyDoGiaHan;
	}

	private List<TbdCuaKhau7> cuaKhaus = new ArrayList<>();
	private List<TbdTTPT7> phuongTiens = new ArrayList<>();
	private List<TbdDinhKem7> tepDinhKems = new ArrayList<>();
	private List<TbdHangHoa7> hangHoas = new ArrayList<>();
	private List<TbdHangHoa7DTO> hangHoa7DTOs = new ArrayList<>();
	private List<TbsTienChat7> tienChats = new ArrayList<>();
	private List<TbdHaiQuan7> haiQuans = new ArrayList<>();

	public List<TbdHangHoa7DTO> getHangHoa7DTOs() {
		return hangHoa7DTOs;
	}

	public void setHangHoa7DTOs(List<TbdHangHoa7DTO> hangHoa7DTOs) {
		this.hangHoa7DTOs = hangHoa7DTOs;
	}

	public List<TbdHaiQuan7> getHaiQuans() {
		return haiQuans;
	}

	public void setHaiQuans(List<TbdHaiQuan7> haiQuans) {
		this.haiQuans = haiQuans;
	}

	public List<TbsTienChat7> getTienChats() {
		return tienChats;
	}

	public void setTienChats(List<TbsTienChat7> tienChats) {
		this.tienChats = tienChats;
	}

	public List<TbdCuaKhau7> getCuaKhaus() {
		return cuaKhaus;
	}

	public void setCuaKhaus(List<TbdCuaKhau7> cuaKhaus) {
		this.cuaKhaus = cuaKhaus;
	}

	public List<TbdTTPT7> getPhuongTiens() {
		return phuongTiens;
	}

	public void setPhuongTiens(List<TbdTTPT7> phuongTiens) {
		this.phuongTiens = phuongTiens;
	}

	public List<TbdDinhKem7> getTepDinhKems() {
		return tepDinhKems;
	}

	public void setTepDinhKems(List<TbdDinhKem7> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}

	public List<TbdHangHoa7> getHangHoas() {
		return hangHoas;
	}

	public void setHangHoas(List<TbdHangHoa7> hangHoas) {
		this.hangHoas = hangHoas;
	}

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date xuatNhapKhauTuNgay;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date xuatNhapKhauDenNgay;

	private String soLanThucHien;

	public Date getXuatNhapKhauTuNgay() {
		return xuatNhapKhauTuNgay;
	}

	public void setXuatNhapKhauTuNgay(Date xuatNhapKhauTuNgay) {
		this.xuatNhapKhauTuNgay = xuatNhapKhauTuNgay;
	}

	public Date getXuatNhapKhauDenNgay() {
		return xuatNhapKhauDenNgay;
	}

	public void setXuatNhapKhauDenNgay(Date xuatNhapKhauDenNgay) {
		this.xuatNhapKhauDenNgay = xuatNhapKhauDenNgay;
	}

	public String getSoLanThucHien() {
		return soLanThucHien;
	}

	public void setSoLanThucHien(String soLanThucHien) {
		this.soLanThucHien = soLanThucHien;
	}

	private boolean isChinhSua;

	public Boolean getIsChinhSua() {
		return isChinhSua;
	}

	public void setIsChinhSua(Boolean isChinhSua) {
		this.isChinhSua = isChinhSua;
	}

	private boolean guiHoSo;

	public boolean isGuiHoSo() {
		return guiHoSo;
	}

	public void setGuiHoSo(boolean guiHoSo) {
		this.guiHoSo = guiHoSo;
	}

	private String dienThoaiNoiSanXuat;

	private String faxNoiSanXuat;

	private String tenNguoiDaiDien;

	private String tenNguoiLienHe;

	private String dienThoaiNguoiLienHe;

	private String emailNguoiLienHe;

	public String getDienThoaiNoiSanXuat() {
		return dienThoaiNoiSanXuat;
	}

	public void setDienThoaiNoiSanXuat(String dienThoaiNoiSanXuat) {
		this.dienThoaiNoiSanXuat = dienThoaiNoiSanXuat;
	}

	public String getFaxNoiSanXuat() {
		return faxNoiSanXuat;
	}

	public void setFaxNoiSanXuat(String faxNoiSanXuat) {
		this.faxNoiSanXuat = faxNoiSanXuat;
	}

	public String getTenNguoiDaiDien() {
		return tenNguoiDaiDien;
	}

	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		this.tenNguoiDaiDien = tenNguoiDaiDien;
	}

	public String getTenNguoiLienHe() {
		return tenNguoiLienHe;
	}

	public void setTenNguoiLienHe(String tenNguoiLienHe) {
		this.tenNguoiLienHe = tenNguoiLienHe;
	}

	public String getDienThoaiNguoiLienHe() {
		return dienThoaiNguoiLienHe;
	}

	public void setDienThoaiNguoiLienHe(String dienThoaiNguoiLienHe) {
		this.dienThoaiNguoiLienHe = dienThoaiNguoiLienHe;
	}

	public String getEmailNguoiLienHe() {
		return emailNguoiLienHe;
	}

	public void setEmailNguoiLienHe(String emailNguoiLienHe) {
		this.emailNguoiLienHe = emailNguoiLienHe;
	}

	private int hinhThucXNK = 0;

	public int getHinhThucXNK() {
		return hinhThucXNK;
	}

	public void setHinhThucXNK(int hinhThucXNK) {
		this.hinhThucXNK = hinhThucXNK;
	}

	private String noiCapGDKKD;

	public String getNoiCapGDKKD() {
		return noiCapGDKKD;
	}

	public void setNoiCapGDKKD(String noiCapGDKKD) {
		this.noiCapGDKKD = noiCapGDKKD;
	}

	private long totalFileSize;
	
	public long getTotalFileSize() {
		return totalFileSize;
	}
	public void setTotalFileSize(long totalFileSize) {
		this.totalFileSize = totalFileSize;
	}
	private String maTinhTP;

	private String tinhTP;
	
	
	public String getMaTinhTP() {
		return maTinhTP;
	}
	public void setMaTinhTP(String maTinhTP) {
		this.maTinhTP = maTinhTP;
	}
	public String getTinhTP() {
		return tinhTP;
	}
	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}
	private List<TbsTepDinhKem6> danhMucTepDinhKems;
	
	
	public List<TbsTepDinhKem6> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem6> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	
	private List<TbsProvince6> provinces = new ArrayList<>();
	
	public List<TbsProvince6> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<TbsProvince6> provinces) {
		this.provinces = provinces;
	}

	@Override
	public String toString() {
		return "HoSo7EditForm [idHoSo=" + idHoSo + ", maHoSo=" + maHoSo + ", saveFast=" + saveFast + ", maSoThue=" + maSoThue + ", tenDoanhNghiep=" + tenDoanhNghiep + ", diaChiDoanhNghiep=" + diaChiDoanhNghiep + ", dienThoai=" + dienThoai + ", fax=" + fax + ", email=" + email + ", soGiayChungNhanDKKD=" + soGiayChungNhanDKKD + ", ngayCapGiayChungNhan=" + ngayCapGiayChungNhan + ", loaiHinh=" + loaiHinh + ", diaChiSanXuat=" + diaChiSanXuat + ", soGiayPhepTCTN=" + soGiayPhepTCTN + ", ngayCapGiayPhep=" + ngayCapGiayPhep + ", loaiGiayPhep=" + loaiGiayPhep + ", isTemp=" + isTemp + ", trangThai=" + trangThai + ", nguoiTao=" + nguoiTao + ", lyDoSua=" + lyDoSua + ", mucDich=" + mucDich + ", ngaySua=" + ngaySua + ", ngayNop=" + ngayNop + ", xmlContent=" + xmlContent + ", serialNumber=" + serialNumber
				+ ", isSign=" + isSign + ", xemHoSo=" + xemHoSo + ", ngayTao=" + ngayTao + ", xoaBo=" + xoaBo + ", soGiayPhepDaCap=" + soGiayPhepDaCap + ", lyDoGiaHan=" + lyDoGiaHan + ", cuaKhaus=" + cuaKhaus + ", phuongTiens=" + phuongTiens + ", tepDinhKems=" + tepDinhKems + ", hangHoas=" + hangHoas + ", hangHoa7DTOs=" + hangHoa7DTOs + ", tienChats=" + tienChats + ", haiQuans=" + haiQuans + ", xuatNhapKhauTuNgay=" + xuatNhapKhauTuNgay + ", xuatNhapKhauDenNgay=" + xuatNhapKhauDenNgay + ", soLanThucHien=" + soLanThucHien + ", isChinhSua=" + isChinhSua + ", dienThoaiNoiSanXuat=" + dienThoaiNoiSanXuat + ", faxNoiSanXuat=" + faxNoiSanXuat + ", tenNguoiDaiDien=" + tenNguoiDaiDien + ", tenNguoiLienHe=" + tenNguoiLienHe + ", dienThoaiNguoiLienHe=" + dienThoaiNguoiLienHe + ", emailNguoiLienHe="
				+ emailNguoiLienHe + ", hinhThucXNK=" + hinhThucXNK + ", noiCapGDKKD=" + noiCapGDKKD + "]";
	}

}
