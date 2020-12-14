package com.nsw.moit.p06.model;


public class TbsTienChat6 {

	private Long idTienChat;
	public void setIdTienChat(Long idTienChat) {
		this.idTienChat = idTienChat;
	}
	public Long getIdTienChat() {
		return this.idTienChat;
	}
	
	private String maCAS;
	
	
	public String getMaCAS() {
		return maCAS;
	}
	public void setMaCAS(String maCAS) {
		this.maCAS = maCAS;
	}


	private String tenKhoaHoc;
	
	
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
	
	private String congThucHoaHoc;
	
	
	public String getCongThucHoaHoc() {
		return congThucHoaHoc;
	}
	public void setCongThucHoaHoc(String congThucHoaHoc) {
		this.congThucHoaHoc = congThucHoaHoc;
	}
	@Override
	public String toString() {
		return "TbsTienChat6 [idTienChat=" + idTienChat + ", maCAS=" + maCAS + ", tenKhoaHoc=" + tenKhoaHoc + ", congThucHoaHoc=" + congThucHoaHoc + "]";
	}
	
	
	
	
}