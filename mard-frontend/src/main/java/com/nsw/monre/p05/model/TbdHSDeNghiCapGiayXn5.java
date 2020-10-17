package com.nsw.monre.p05.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;
import java.util.Date;



public class TbdHSDeNghiCapGiayXn5  extends TbdHSDeNghiCapGiayXn5BaseModel{

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 50)
	private String maCoQuan;

	public String getMaCoQuan() {
		return this.maCoQuan;
	}

	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenCoQuan;

	public String getTenCoQuan() {
		return this.tenCoQuan;
	}

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String maSoThue;

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String tenDN;

	public String getTenDN() {
		return this.tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String soGCNDKKD;

	public String getSoGCNDKKD() {
		return this.soGCNDKKD;
	}

	public void setSoGCNDKKD(String soGCNDKKD) {
		this.soGCNDKKD = soGCNDKKD;
	}

	@ValidNotNull
	private Date ngayCapGCNDKKD;

	public Date getNgayCapGCNDKKD() {
		return this.ngayCapGCNDKKD;
	}

	public void setNgayCapGCNDKKD(Date ngayCapGCNDKKD) {
		this.ngayCapGCNDKKD = ngayCapGCNDKKD;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String noiCapGCNDKKD;

	public String getNoiCapGCNDKKD() {
		return this.noiCapGCNDKKD;
	}

	public void setNoiCapGCNDKKD(String noiCapGCNDKKD) {
		this.noiCapGCNDKKD = noiCapGCNDKKD;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String truSoChinh;

	public String getTruSoChinh() {
		return this.truSoChinh;
	}

	public void setTruSoChinh(String truSoChinh) {
		this.truSoChinh = truSoChinh;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String nguoiDaiDien;

	public String getNguoiDaiDien() {
		return this.nguoiDaiDien;
	}

	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}

	@ValidLength(maxLength = 20)
	private String soDTNguoiDaiDien;

	public String getSoDTNguoiDaiDien() {
		return this.soDTNguoiDaiDien;
	}

	public void setSoDTNguoiDaiDien(String soDTNguoiDaiDien) {
		this.soDTNguoiDaiDien = soDTNguoiDaiDien;
	}

	@ValidLength(maxLength = 20)
	private String faxNguoiDaiDien;

	public String getFaxNguoiDaiDien() {
		return this.faxNguoiDaiDien;
	}

	public void setFaxNguoiDaiDien(String faxNguoiDaiDien) {
		this.faxNguoiDaiDien = faxNguoiDaiDien;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 500)
	private String emailNguoiDaiDien;

	public String getEmailNguoiDaiDien() {
		return this.emailNguoiDaiDien;
	}

	public void setEmailNguoiDaiDien(String emailNguoiDaiDien) {
		this.emailNguoiDaiDien = emailNguoiDaiDien;
	}

	@ValidSize(min = 0, max = 5)
	private int hinhThuc;

	public int getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(int hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayGuiStart;

	public Date getNgayGuiStart() {
		return this.ngayGuiStart;
	}

	public void setNgayGuiStart(Date ngayGuiStart) {
		this.ngayGuiStart = ngayGuiStart;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayGuiEnd;

	public Date getNgayGuiEnd() {
		return this.ngayGuiEnd;
	}

	public void setNgayGuiEnd(Date ngayGuiEnd) {
		this.ngayGuiEnd = ngayGuiEnd;
	}

	private Date ngayGui;

	public Date getNgayGui() {
		return this.ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}


	@ValidLength(maxLength = 500)
	private String soGXNDaCap;

	public String getSoGXNDaCap() {
		return this.soGXNDaCap;
	}

	public void setSoGXNDaCap(String soGXNDaCap) {
		this.soGXNDaCap = soGXNDaCap;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapStart;

	public Date getNgayCapStart() {
		return this.ngayCapStart;
	}

	public void setNgayCapStart(Date ngayCapStart) {
		this.ngayCapStart = ngayCapStart;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayCapEnd;

	public Date getNgayCapEnd() {
		return this.ngayCapEnd;
	}

	public void setNgayCapEnd(Date ngayCapEnd) {
		this.ngayCapEnd = ngayCapEnd;
	}

	private Date ngayCap;

	public Date getNgayCap() {
		return this.ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	private Date ngayHetHanStart;

	public Date getNgayHetHanStart() {
		return this.ngayHetHanStart;
	}

	public void setNgayHetHanStart(Date ngayHetHanStart) {
		this.ngayHetHanStart = ngayHetHanStart;
	}

	private Date ngayHetHanEnd;

	public Date getNgayHetHanEnd() {
		return this.ngayHetHanEnd;
	}

	public void setNgayHetHanEnd(Date ngayHetHanEnd) {
		this.ngayHetHanEnd = ngayHetHanEnd;
	}

	private Date ngayHetHan;

	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	@ValidLength(maxLength = 2000)
	private String lyDo;

	public String getLyDo() {
		return this.lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String maHoSo;

	public String getMaHoSo() {
		return this.maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	private int trangThai;

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	private int xoa;

	public int getXoa() {
		return this.xoa;
	}

	public void setXoa(int xoa) {
		this.xoa = xoa;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayTaoStart;

	public Date getNgayTaoStart() {
		return this.ngayTaoStart;
	}

	public void setNgayTaoStart(Date ngayTaoStart) {
		this.ngayTaoStart = ngayTaoStart;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayTaoEnd;

	public Date getNgayTaoEnd() {
		return this.ngayTaoEnd;
	}

	public void setNgayTaoEnd(Date ngayTaoEnd) {
		this.ngayTaoEnd = ngayTaoEnd;
	}

	@ValidNotNull
	private Date ngayTao;

	public Date getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String loaiThuTuc;

	public String getLoaiThuTuc() {
		return this.loaiThuTuc;
	}

	public void setLoaiThuTuc(String loaiThuTuc) {
		this.loaiThuTuc = loaiThuTuc;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdHSDeNghiCapGiayXn5: [ ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("maCoQuan = " + maCoQuan);

		builder.append(" | ");

		builder.append("tenCoQuan = " + tenCoQuan);

		builder.append(" | ");

		builder.append("maSoThue = " + maSoThue);

		builder.append(" | ");

		builder.append("tenDN = " + tenDN);

		builder.append(" | ");

		builder.append("soGCNDKKD = " + soGCNDKKD);

		builder.append(" | ");

		builder.append("ngayCapGCNDKKD = " + ngayCapGCNDKKD);

		builder.append(" | ");

		builder.append("noiCapGCNDKKD = " + noiCapGCNDKKD);

		builder.append(" | ");

		builder.append("truSoChinh = " + truSoChinh);

		builder.append(" | ");

		builder.append("nguoiDaiDien = " + nguoiDaiDien);

		builder.append(" | ");

		builder.append("soDTNguoiDaiDien = " + soDTNguoiDaiDien);

		builder.append(" | ");

		builder.append("faxNguoiDaiDien = " + faxNguoiDaiDien);

		builder.append(" | ");

		builder.append("emailNguoiDaiDien = " + emailNguoiDaiDien);

		builder.append(" | ");

		builder.append("hinhThuc = " + hinhThuc);

		builder.append(" | ");

		builder.append("ngayGuiStart = " + ngayGuiStart);

		builder.append(" | ");

		builder.append("ngayGuiEnd = " + ngayGuiEnd);

		builder.append("ngayGui = " + ngayGui);

		builder.append(" | ");


		builder.append("soGXNDaCap = " + soGXNDaCap);

		builder.append(" | ");

		builder.append("ngayCapStart = " + ngayCapStart);

		builder.append(" | ");

		builder.append("ngayCapEnd = " + ngayCapEnd);

		builder.append("ngayCap = " + ngayCap);

		builder.append(" | ");

		builder.append("ngayHetHanStart = " + ngayHetHanStart);

		builder.append(" | ");

		builder.append("ngayHetHanEnd = " + ngayHetHanEnd);

		builder.append("ngayHetHan = " + ngayHetHan);

		builder.append(" | ");

		builder.append("lyDo = " + lyDo);

		builder.append(" | ");

		builder.append("maHoSo = " + maHoSo);

		builder.append(" | ");

		builder.append("trangThai = " + trangThai);

		builder.append(" | ");

		builder.append("xoa = " + xoa);

		builder.append(" | ");

		builder.append("ngayTaoStart = " + ngayTaoStart);

		builder.append(" | ");

		builder.append("ngayTaoEnd = " + ngayTaoEnd);

		builder.append("ngayTao = " + ngayTao);

		builder.append(" | ");

		builder.append("loaiThuTuc = " + loaiThuTuc);

		builder.append(" ]");

		return builder.toString();

	}




}