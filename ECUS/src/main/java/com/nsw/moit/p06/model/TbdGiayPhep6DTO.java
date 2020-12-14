package com.nsw.moit.p06.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbdGiayPhep6DTO {

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
	
	private Float soLuong;
	public void setSoLuong(Float soLuong) {
		this.soLuong = soLuong;
	}
	public Float getSoLuong() {
		return this.soLuong;
	}
	
	private Float hamLuong;
	public void setHamLuong(Float hamLuong) {
		this.hamLuong = hamLuong;
	}
	public Float getHamLuong() {
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
	
	private List<TbdGPCuaKhau6> cuaKhaus = new ArrayList<>();
	private List<TbdGPTTPT6DTO> phuongTiens = new ArrayList<>();
	private List<TbdGPHangHoa6> hangHoas = new ArrayList<>();
	
	public List<TbdGPCuaKhau6> getCuaKhaus() {
		return cuaKhaus;
	}
	public void setCuaKhaus(List<TbdGPCuaKhau6> cuaKhaus) {
		this.cuaKhaus = cuaKhaus;
	}
	public List<TbdGPTTPT6DTO> getPhuongTiens() {
		return phuongTiens;
	}
	public void setPhuongTiens(List<TbdGPTTPT6DTO> phuongTiens) {
		this.phuongTiens = phuongTiens;
	}
	
	public List<TbdGPHangHoa6> getHangHoas() {
		return hangHoas;
	}
	public void setHangHoas(List<TbdGPHangHoa6> hangHoas) {
		this.hangHoas = hangHoas;
	}


	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdGiayPhep6 { ");
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