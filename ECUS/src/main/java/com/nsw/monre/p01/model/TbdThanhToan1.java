package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;
import java.math.BigDecimal;
import java.util.Date;



public class TbdThanhToan1  extends TbdThanhToan1BaseModel{

	private long idThanhToan;

	public long getIdThanhToan() {
		return this.idThanhToan;
	}

	public void setIdThanhToan(long idThanhToan) {
		this.idThanhToan = idThanhToan;
	}

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	@ValidNotNull
	private BigDecimal lePhi;

	public BigDecimal getLePhi() {
		return this.lePhi;
	}

	public void setLePhi(BigDecimal lePhi) {
		this.lePhi = lePhi;
	}

	@ValidLength(maxLength = 2000)
	private String noiDung;

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 2000)
	private String link;

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private int trangThai;

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	private Date ngayXuLy;

	public Date getNgayXuLy() {
		return this.ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}

	@ValidLength(maxLength = 250)
	private String donViXuLy;

	public String getDonViXuLy() {
		return this.donViXuLy;
	}

	public void setDonViXuLy(String donViXuLy) {
		this.donViXuLy = donViXuLy;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdThanhToan1: [ ");

		builder.append("idThanhToan = " + idThanhToan);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("lePhi = " + lePhi);

		builder.append(" | ");

		builder.append("noiDung = " + noiDung);

		builder.append(" | ");

		builder.append("link = " + link);

		builder.append(" | ");

		builder.append("trangThai = " + trangThai);

		builder.append(" | ");

		builder.append("ngayXuLy = " + ngayXuLy);

		builder.append(" | ");

		builder.append("donViXuLy = " + donViXuLy);

		builder.append(" ]");

		return builder.toString();

	}




}