package com.nsw.moit.p06.model;


public class TbdHangHoa6 {

	private Long idHangHoa;
	public void setIdHangHoa(Long idHangHoa) {
		this.idHangHoa = idHangHoa;
	}
	public Long getIdHangHoa() {
		return this.idHangHoa;
	}

	private String chiTiet;
	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
	public String getChiTiet() {
		return this.chiTiet;
	}

	private Long idHoSo;
	public void setIdHoSo(Long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public Long getIdHoSo() {
		return this.idHoSo;
	}

	private Double soLuong;
	public void setSoLuong(Double soLuong) {
		this.soLuong = soLuong;
	}
	public Double getSoLuong() {
		return this.soLuong;
	}

	private String donViTinh;
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getDonViTinh() {
		return this.donViTinh;
	}

	private String tenHangHoa;
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public String getTenHangHoa() {
		return this.tenHangHoa;
	}

	private String tenTCTN;
	public void setTenTCTN(String tenTCTN) {
		this.tenTCTN = tenTCTN;
	}
	public String getTenTCTN() {
		return this.tenTCTN;
	}

	private Double hamLuong;
	public void setHamLuong(Double hamLuong) {
		this.hamLuong = hamLuong;
	}
	public Double getHamLuong() {
		return this.hamLuong;
	}

	private Integer trangThai;
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public Integer getTrangThai() {
		return this.trangThai;
	}

	private Integer hoatDong;
	public void setHoatDong(Integer hoatDong) {
		this.hoatDong = hoatDong;
	}
	public Integer getHoatDong() {
		return this.hoatDong;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TbdHangHoa6 { ");
		stringBuilder.append("idHangHoa=" + idHangHoa); 
		stringBuilder.append(", "); 
		stringBuilder.append("chiTiet=" + chiTiet); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuong=" + soLuong); 
		stringBuilder.append(", "); 
		stringBuilder.append("donViTinh=" + donViTinh); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenHangHoa=" + tenHangHoa); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTCTN=" + tenTCTN); 
		stringBuilder.append(", "); 
		stringBuilder.append("hamLuong=" + hamLuong); 
		stringBuilder.append(", "); 
		stringBuilder.append("trangThai=" + trangThai); 
		stringBuilder.append(", "); 
		stringBuilder.append("hoatDong=" + hoatDong); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}