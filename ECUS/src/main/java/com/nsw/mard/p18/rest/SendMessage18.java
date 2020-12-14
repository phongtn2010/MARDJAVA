package com.nsw.mard.p18.rest;

import javax.validation.constraints.NotNull;

public class SendMessage18 {

	private String fiReason;
	
	private String fiXml;
	
	private String fiTaxCode;
	
	private String fiUserName;
	
	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Integer fiAction;

	private boolean fiSign;

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
	public boolean isFiSign() {
		return fiSign;
	}

	public void setFiSign(boolean fiSign) {
		this.fiSign = fiSign;
	}

	@Override
	public String toString() {
		return "SendMessage18 [fiReason=" + fiReason + ", fiXml=" + fiXml + ", fiTaxCode=" + fiTaxCode + ", fiUserName=" + fiUserName + ", fiIdHoSo=" + fiIdHoSo + ", fiAction=" + fiAction + ", fiSign=" + fiSign +"]";
	}

	
}
