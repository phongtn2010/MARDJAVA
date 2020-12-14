/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p02.model;

import java.util.Date;

/**
 *
 * @author quannn5
 */
public class SendMessage02 {
    private String type;
	private String function;
	private Long fiIdHoso;
	private Long fiIdCqxl; 
	private String reason;
	private Date delayDateTo;
	private Boolean getXmlNotSend;
	private String signedXml;
	
	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Long getFiIdHoso() {
		return fiIdHoso;
	}

	public void setFiIdHoso(Long fiIdHoso) {
		this.fiIdHoso = fiIdHoso;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDelayDateTo() {
		return delayDateTo;
	}

	public void setDelayDateTo(Date delayDateTo) {
		this.delayDateTo = delayDateTo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getFiIdCqxl() {
		return fiIdCqxl;
	}

	public void setFiIdCqxl(Long fiIdCqxl) {
		this.fiIdCqxl = fiIdCqxl;
	}

	public Boolean getGetXmlNotSend() {
		return getXmlNotSend;
	}

	public void setGetXmlNotSend(Boolean getXmlNotSend) {
		this.getXmlNotSend = getXmlNotSend;
	}

	public String getSignedXml() {
		return signedXml;
	}

	public void setSignedXml(String signedXml) {
		this.signedXml = signedXml;
	}
}
