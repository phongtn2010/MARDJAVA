/*
 * Created on 5 May 2017 ( Time 10:32:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.nsw.most.p01.model;

import java.util.Date;

/**
 * 
 * 
 * @author Telosys Tools Generator
 * 
 */

public class Tbdlichsu1 {

	private Long fiIdLichsu;

	private Long fiIdCqxl;

	private String fiMaNggui;

	private String fiTenNggui;

	private String fiMaDvgui;

	private String fiTenDvgui;

	private String fiMaNgnhan;

	private String fiTenNgnhan;

	private String fiMaDvnhan;

	private String fiTenDvnhan;

	private String fiNoidung;

	private Date fiThoihan;

	private Date fiNgaytao;

	private Long fiTrangthai;
	
	private String fiTenTt;

	public Tbdlichsu1() {
		super();
	}

	public void setFiIdLichsu(Long fiIdLichsu) {
		this.fiIdLichsu = fiIdLichsu;
	}

	public Long getFiIdLichsu() {
		return this.fiIdLichsu;
	}

	public void setFiIdCqxl(Long fiIdCqxl) {
		this.fiIdCqxl = fiIdCqxl;
	}

	public Long getFiIdCqxl() {
		return this.fiIdCqxl;
	}

	public void setFiMaNggui(String fiMaNggui) {
		this.fiMaNggui = fiMaNggui;
	}

	public String getFiMaNggui() {
		return this.fiMaNggui;
	}

	public void setFiTenNggui(String fiTenNggui) {
		this.fiTenNggui = fiTenNggui;
	}

	public String getFiTenNggui() {
		return this.fiTenNggui;
	}

	public void setFiMaDvgui(String fiMaDvgui) {
		this.fiMaDvgui = fiMaDvgui;
	}

	public String getFiMaDvgui() {
		return this.fiMaDvgui;
	}

	public void setFiTenDvgui(String fiTenDvgui) {
		this.fiTenDvgui = fiTenDvgui;
	}

	public String getFiTenDvgui() {
		return this.fiTenDvgui;
	}

	public void setFiMaNgnhan(String fiMaNgnhan) {
		this.fiMaNgnhan = fiMaNgnhan;
	}

	public String getFiMaNgnhan() {
		return this.fiMaNgnhan;
	}

	public void setFiTenNgnhan(String fiTenNgnhan) {
		this.fiTenNgnhan = fiTenNgnhan;
	}

	public String getFiTenNgnhan() {
		return this.fiTenNgnhan;
	}

	public void setFiMaDvnhan(String fiMaDvnhan) {
		this.fiMaDvnhan = fiMaDvnhan;
	}

	public String getFiMaDvnhan() {
		return this.fiMaDvnhan;
	}

	public void setFiTenDvnhan(String fiTenDvnhan) {
		this.fiTenDvnhan = fiTenDvnhan;
	}

	public String getFiTenDvnhan() {
		return this.fiTenDvnhan;
	}

	public void setFiNoidung(String fiNoidung) {
		this.fiNoidung = fiNoidung;
	}

	public String getFiNoidung() {
		return this.fiNoidung;
	}

	public void setFiThoihan(Date fiThoihan) {
		this.fiThoihan = fiThoihan;
	}

	public Date getFiThoihan() {
		return this.fiThoihan;
	}

	public void setFiNgaytao(Date fiNgaytao) {
		this.fiNgaytao = fiNgaytao;
	}

	public Date getFiNgaytao() {
		return this.fiNgaytao;
	}

	public void setFiTrangthai(Long fiTrangthai) {
		this.fiTrangthai = fiTrangthai;
	}

	public Long getFiTrangthai() {
		return this.fiTrangthai;
	}
	
	public String getFiTenTt() {
		return fiTenTt;
	}
	
	public void setFiTenTt(String fiTenTt) {
		this.fiTenTt = fiTenTt;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(fiIdLichsu);
		sb.append("]:");
		sb.append(fiIdCqxl);
		sb.append("|");
		sb.append(fiMaNggui);
		sb.append("|");
		sb.append(fiTenNggui);
		sb.append("|");
		sb.append(fiMaDvgui);
		sb.append("|");
		sb.append(fiTenDvgui);
		sb.append("|");
		sb.append(fiMaNgnhan);
		sb.append("|");
		sb.append(fiTenNgnhan);
		sb.append("|");
		sb.append(fiMaDvnhan);
		sb.append("|");
		sb.append(fiTenDvnhan);
		sb.append("|");
		sb.append(fiNoidung);
		sb.append("|");
		sb.append(fiThoihan);
		sb.append("|");
		sb.append(fiNgaytao);
		sb.append("|");
		sb.append(fiTrangthai);
		return sb.toString();
	}
}
