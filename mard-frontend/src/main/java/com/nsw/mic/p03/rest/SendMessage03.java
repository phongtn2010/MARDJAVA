package com.nsw.mic.p03.rest;

import javax.validation.constraints.NotNull;

public class SendMessage03 {

	private String fiReason;
	
	private String fiXml;
	
	private String fiTaxCode;
	
	private String fiUserName;
	
	@NotNull
	private Long fiIdHoSo;

	private Long fiIdYeuCauSuaGP;

	@NotNull
	private Integer fiAction;

	public String getFiReason() {
		return fiReason;
	}

	public void setFiReason(String fiReason) {
		this.fiReason = fiReason;
	}

	public String getFiXml() {
		return fiXml;
	}

	public void setFiXml(String fiXml) {
		this.fiXml = fiXml;
	}

	public String getFiTaxCode() {
		return fiTaxCode;
	}

	public void setFiTaxCode(String fiTaxCode) {
		this.fiTaxCode = fiTaxCode;
	}

	public String getFiUserName() {
		return fiUserName;
	}

	public void setFiUserName(String fiUserName) {
		this.fiUserName = fiUserName;
	}

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public Integer getFiAction() {
		return fiAction;
	}

	public void setFiAction(Integer fiAction) {
		this.fiAction = fiAction;
	}

	public Long getFiIdYeuCauSuaGP() {
		return fiIdYeuCauSuaGP;
	}

	public void setFiIdYeuCauSuaGP(Long fiIdYeuCauSuaGP) {
		this.fiIdYeuCauSuaGP = fiIdYeuCauSuaGP;
	}
}
