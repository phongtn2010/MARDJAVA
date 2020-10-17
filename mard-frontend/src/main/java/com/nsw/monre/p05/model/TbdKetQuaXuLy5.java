package com.nsw.monre.p05.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p05.model.base.*;
import java.util.Date;



public class TbdKetQuaXuLy5  extends TbdKetQuaXuLy5BaseModel{

	private long idKQ;

	public long getIdKQ() {
		return this.idKQ;
	}

	public void setIdKQ(long idKQ) {
		this.idKQ = idKQ;
	}

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	@ValidLength(maxLength = 2000)
	private String noiDung;

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	private Date ngayXuLy;

	public Date getNgayXuLy() {
		return this.ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}
	
	private String ngayXuLyDateFormat;
	
	public String getNgayXuLyDateFormat() {
		return ngayXuLyDateFormat;
	}

	public void setNgayXuLyDateFormat(String ngayXuLyDateFormat) {
		this.ngayXuLyDateFormat = ngayXuLyDateFormat;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String donViXuLy;

	public String getDonViXuLy() {
		return this.donViXuLy;
	}

	public void setDonViXuLy(String donViXuLy) {
		this.donViXuLy = donViXuLy;
	}

	@ValidLength(maxLength = 2000)
	private String linkCongVan;

	public String getLinkCongVan() {
		return this.linkCongVan;
	}

	public void setLinkCongVan(String linkCongVan) {
		this.linkCongVan = linkCongVan;
	}

	private int trangThai;

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	private Date ngayTao;

	public Date getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbdKetQuaXuLy5: [ ");

		builder.append("idKQ = " + idKQ);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("noiDung = " + noiDung);

		builder.append(" | ");

		builder.append("ngayXuLy = " + ngayXuLy);

		builder.append(" | ");

		builder.append("donViXuLy = " + donViXuLy);

		builder.append(" | ");

		builder.append("linkCongVan = " + linkCongVan);

		builder.append(" | ");

		builder.append("trangThai = " + trangThai);

		builder.append(" | ");

		builder.append("ngayTao = " + ngayTao);

		builder.append(" ]");

		return builder.toString();

	}




}