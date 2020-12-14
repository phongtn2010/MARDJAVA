package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;
import java.util.Date;



public class TbdYeuCauRutHS1  extends TbdYeuCauRutHS1BaseModel{

	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	private Date ngayRut;

	public Date getNgayRut() {
		return this.ngayRut;
	}

	public void setNgayRut(Date ngayRut) {
		this.ngayRut = ngayRut;
	}

	@ValidLength(maxLength = 2000)
	private String noiDung;

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	private String noiDungPhanHoi;

	public String getNoiDungPhanHoi() {
		return this.noiDungPhanHoi;
	}

	public void setNoiDungPhanHoi(String noiDungPhanHoi) {
		this.noiDungPhanHoi = noiDungPhanHoi;
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

		builder.append("TbdYeuCauRutHS1: [ ");

		builder.append("id = " + id);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("ngayRut = " + ngayRut);

		builder.append(" | ");

		builder.append("noiDung = " + noiDung);

		builder.append(" | ");

		builder.append("noiDungPhanHoi = " + noiDungPhanHoi);

		builder.append(" | ");

		builder.append("ngayXuLy = " + ngayXuLy);

		builder.append(" | ");

		builder.append("donViXuLy = " + donViXuLy);

		builder.append(" ]");

		return builder.toString();

	}




}