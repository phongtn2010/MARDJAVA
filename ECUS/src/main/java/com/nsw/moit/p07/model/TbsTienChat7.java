package com.nsw.moit.p07.model;


public class TbsTienChat7 {

	private Long idTienChat;
	public void setIdTienChat(Long idTienChat) {
		this.idTienChat = idTienChat;
	}
	public Long getIdTienChat() {
		return this.idTienChat;
	}
	
	private String maCAS;
	
	private String maHS;

	
	public String getMaCAS() {
		return maCAS;
	}
	public void setMaCAS(String maCAS) {
		this.maCAS = maCAS;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	private String tenTiengAnh;
	

	private String tenTiengViet;
	
	

	private String tenKhoaHoc;
	
	
	private String congThucHoaHoc;
	
	
	public String getTenTiengAnh() {
		return tenTiengAnh;
	}
	public void setTenTiengAnh(String tenTiengAnh) {
		this.tenTiengAnh = tenTiengAnh;
	}
	public String getTenTiengViet() {
		return tenTiengViet;
	}
	public void setTenTiengViet(String tenTiengViet) {
		this.tenTiengViet = tenTiengViet;
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
	public String getCongThucHoaHoc() {
		return congThucHoaHoc;
	}
	public void setCongThucHoaHoc(String congThucHoaHoc) {
		this.congThucHoaHoc = congThucHoaHoc;
	}

	private String loaiTienChat;
	
	

	public String getLoaiTienChat() {
		return loaiTienChat;
	}
	public void setLoaiTienChat(String loaiTienChat) {
		this.loaiTienChat = loaiTienChat;
	}
	@Override
	public String toString() {
		return "TbsTienChat7 [idTienChat=" + idTienChat + ", maCAS=" + maCAS + ", maHS=" + maHS + ", tenTiengAnh=" + tenTiengAnh + ", tenTiengViet=" + tenTiengViet + ", tenKhoaHoc=" + tenKhoaHoc + ", congThucHoaHoc=" + congThucHoaHoc + ", loaiTienChat=" + loaiTienChat + "]";
	}
	
}