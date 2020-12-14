package com.nsw.moit.p07.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbdGiayPhep7DTO {

	private Long idGiayPhep;
	public void setIdGiayPhep(Long idGiayPhep) {
		this.idGiayPhep = idGiayPhep;
	}
	public Long getIdGiayPhep() {
		return this.idGiayPhep;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private String coQuanCap;
	public void setCoQuanCap(String coQuanCap) {
		this.coQuanCap = coQuanCap;
	}
	public String getCoQuanCap() {
		return this.coQuanCap;
	}

	private String maSoGP;
	public void setMaSoGP(String maSoGP) {
		this.maSoGP = maSoGP;
	}
	public String getMaSoGP() {
		return this.maSoGP;
	}

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayKy;
	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}
	public Date getNgayKy() {
		return this.ngayKy;
	}

	private String nguoiKy;
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}
	public String getNguoiKy() {
		return this.nguoiKy;
	}

	private Integer loaiHinh;
	public void setLoaiHinh(Integer loaiHinh) {
		this.loaiHinh = loaiHinh;
	}
	public Integer getLoaiHinh() {
		return this.loaiHinh;
	}

	private Integer loaiGiayPhep;
	public void setLoaiGiayPhep(Integer loaiGiayPhep) {
		this.loaiGiayPhep = loaiGiayPhep;
	}
	public Integer getLoaiGiayPhep() {
		return this.loaiGiayPhep;
	}

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayHetHan;
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayNop;
	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}
	public Date getNgayNop() {
		return this.ngayNop;
	}

	private String tenTepTin;
	public void setTenTepTin(String tenTepTin) {
		this.tenTepTin = tenTepTin;
	}
	public String getTenTepTin() {
		return this.tenTepTin;
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

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}
	
	private Double soLuong;
	public void setSoLuong(Double soLuong) {
		this.soLuong = soLuong;
	}
	public Double getSoLuong() {
		return this.soLuong;
	}
	
	private String hamLuong;
	public void setHamLuong(String hamLuong) {
		this.hamLuong = hamLuong;
	}
	public String getHamLuong() {
		return this.hamLuong;
	}
	
	private Integer loaiHinhHangHoa;
	public void setLoaiHinhHangHoa(Integer loaiHinhHangHoa) {
		this.loaiHinhHangHoa = loaiHinhHangHoa;
	}
	public Integer getLoaiHinhHangHoa() {
		return this.loaiHinhHangHoa;
	}
	
	private String mucDich;
	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}
	public String getMucDich() {
		return this.mucDich;
	}
	
	private String tenDoanhNghiep;
	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}
	public String getTenDoanhNghiep() {
		return this.tenDoanhNghiep;
	}
	
	private String soGiayPhepTCTN;
	public void setSoGiayPhepTCTN(String soGiayPhepTCTN) {
		this.soGiayPhepTCTN = soGiayPhepTCTN;
	}
	public String getSoGiayPhepTCTN() {
		return this.soGiayPhepTCTN;
	}
	
	private String maHoSo;
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getMaHoSo() {
		return this.maHoSo;
	}
	
	private List<TbdGPCuaKhau7> cuaKhaus = new ArrayList<>();
	private List<TbdGPTTPT7DTO> phuongTiens = new ArrayList<>();
	private List<TbdGPHangHoa7> hangHoas = new ArrayList<>();
	
	public List<TbdGPCuaKhau7> getCuaKhaus() {
		return cuaKhaus;
	}
	public void setCuaKhaus(List<TbdGPCuaKhau7> cuaKhaus) {
		this.cuaKhaus = cuaKhaus;
	}
	public List<TbdGPTTPT7DTO> getPhuongTiens() {
		return phuongTiens;
	}
	public void setPhuongTiens(List<TbdGPTTPT7DTO> phuongTiens) {
		this.phuongTiens = phuongTiens;
	}
	
	public List<TbdGPHangHoa7> getHangHoas() {
		return hangHoas;
	}
	public void setHangHoas(List<TbdGPHangHoa7> hangHoas) {
		this.hangHoas = hangHoas;
	}
	
	private String truSo;
	private String fax;
	private String dienThoai;
	
	
	public String getTruSo() {
		return truSo;
	}
	public void setTruSo(String truSo) {
		this.truSo = truSo;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	
	private String soLanThucHien;
	
	
	public String getSoLanThucHien() {
		return soLanThucHien;
	}
	public void setSoLanThucHien(String soLanThucHien) {
		this.soLanThucHien = soLanThucHien;
	}
	
	private String soGiayChungNhanDKKD;
	public void setSoGiayChungNhanDKKD(String soGiayChungNhanDKKD) {
		this.soGiayChungNhanDKKD = soGiayChungNhanDKKD;
	}
	public String getSoGiayChungNhanDKKD() {
		return this.soGiayChungNhanDKKD;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date ngayCapGiayChungNhan;
	public void setNgayCapGiayChungNhan(Date ngayCapGiayChungNhan) {
		this.ngayCapGiayChungNhan = ngayCapGiayChungNhan;
	}
	public Date getNgayCapGiayChungNhan() {
		return this.ngayCapGiayChungNhan;
	}
	private String noiCapGDKKD;
	
	public String getNoiCapGDKKD() {
		return noiCapGDKKD;
	}
	public void setNoiCapGDKKD(String noiCapGDKKD) {
		this.noiCapGDKKD = noiCapGDKKD;
	}

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date xuatNhapKhauTuNgay;

	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date xuatNhapKhauDenNgay;
	
	
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
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdGiayPhep7 { ");
		stringBuilder.append("idGiayPhep=" + idGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("coQuanCap=" + coQuanCap); 
		stringBuilder.append(", "); 
		stringBuilder.append("maSoGP=" + maSoGP); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayKy=" + ngayKy); 
		stringBuilder.append(", "); 
		stringBuilder.append("nguoiKy=" + nguoiKy); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiHinh=" + loaiHinh); 
		stringBuilder.append(", "); 
		stringBuilder.append("loaiGiayPhep=" + loaiGiayPhep); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayHetHan=" + ngayHetHan); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepTin=" + tenTepTin); 
		stringBuilder.append(", "); 
		stringBuilder.append("guID=" + guID); 
		stringBuilder.append(", "); 
		stringBuilder.append("duongDanFile=" + duongDanFile); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}