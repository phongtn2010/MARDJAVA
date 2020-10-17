package com.nsw.monre.p01.model;

import java.util.Calendar;
import java.util.Date;

public class UserInfo {

	private String tenDN;
	
	private String maSoThue;
	
	private String truSoChinh;
	
	private String nguoiDaiDien;
	
	private String soDTNguoiDaiDien;
	
	private String faxNguoiDaiDien;
	
	private String emailNguoiDaiDien;
	
	private String soGCNDKKD;
	
	private Date ngayCapGCNDKKD;
	
	private String noiCapGCNDKKD;
	
	private String tenCoQuan;
	

	

	public String getTenDN() {
		return tenDN;
	}




	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}




	public String getMaSoThue() {
		return maSoThue;
	}




	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}




	public String getTruSoChinh() {
		return truSoChinh;
	}




	public void setTruSoChinh(String truSoChinh) {
		this.truSoChinh = truSoChinh;
	}




	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}




	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}




	public String getSoDTNguoiDaiDien() {
		return soDTNguoiDaiDien;
	}




	public void setSoDTNguoiDaiDien(String soDTNguoiDaiDien) {
		this.soDTNguoiDaiDien = soDTNguoiDaiDien;
	}




	public String getFaxNguoiDaiDien() {
		return faxNguoiDaiDien;
	}




	public void setFaxNguoiDaiDien(String faxNguoiDaiDien) {
		this.faxNguoiDaiDien = faxNguoiDaiDien;
	}




	public String getEmailNguoiDaiDien() {
		return emailNguoiDaiDien;
	}




	public void setEmailNguoiDaiDien(String emailNguoiDaiDien) {
		this.emailNguoiDaiDien = emailNguoiDaiDien;
	}




	public String getsoGCNDKKD() {
		return soGCNDKKD;
	}




	public void setsoGCNDKKD(String soGCNDKKD) {
		this.soGCNDKKD = soGCNDKKD;
	}




	public Date getNgayCapGCNDKKD() {
		return ngayCapGCNDKKD;
	}




	public void setNgayCapGCNDKKD(Date ngayCapGCNDKKD) {
		this.ngayCapGCNDKKD = ngayCapGCNDKKD;
	}




	public String getNoiCapGCNDKKD() {
		return noiCapGCNDKKD;
	}




	public void setNoiCapGCNDKKD(String noiCapGCNDKKD) {
		this.noiCapGCNDKKD = noiCapGCNDKKD;
	}




	public String getTenCoQuan() {
		return tenCoQuan;
	}




	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}


	private String maCoQuan;
	
	


	public String getMaCoQuan() {
		return maCoQuan;
	}




	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}




	public UserInfo() {
		
		tenDN = "Cong ty TNHH Hoang Thien Kim";
		
		maSoThue = "04222051118";
		
		truSoChinh = "91 Dinh Tien Hoang, Cau Giay, Ha Noi";
		
		soDTNguoiDaiDien = "04222051118";
		
		soGCNDKKD = "123/GCN";
		
		tenCoQuan = "MONRE";
		
		emailNguoiDaiDien = "monre@gmail.com";
		
		maCoQuan = "MONRE";
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		
		ngayCapGCNDKKD = calendar.getTime();
		
		noiCapGCNDKKD = "TP.Ha Noi";
	}




	@Override
	public String toString() {
		return "UserInfo [tenDN=" + tenDN + ", maSoThue=" + maSoThue + ", truSoChinh=" + truSoChinh + ", nguoiDaiDien="
				+ nguoiDaiDien + ", soDTNguoiDaiDien=" + soDTNguoiDaiDien + ", faxNguoiDaiDien=" + faxNguoiDaiDien
				+ ", emailNguoiDaiDien=" + emailNguoiDaiDien + ", soGCNDKKD=" + soGCNDKKD + ", ngayCapGCNDKKD="
				+ ngayCapGCNDKKD + ", noiCapGCNDKKD=" + noiCapGCNDKKD + ", tenCoQuan=" + tenCoQuan + ", maCoQuan="
				+ maCoQuan + "]";
	}
	
	
	
}
