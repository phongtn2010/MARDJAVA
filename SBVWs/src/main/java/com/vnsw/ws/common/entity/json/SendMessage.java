package com.vnsw.ws.common.entity.json;

import java.util.Date;

public class SendMessage {
	private String type;
	private String documentType; //kiểu hồ sơ
	private int documentYear; //năm 
	private String function;
	private String preReference; //mã hồ sơ
	private String reference; //mã hồ sơ
	private Date sendDate; // ngày gửi
	private Long fiIdHoso;// Id hồ sơ
	private Long fiIdCqxl; //Id co quan xu ly
	private String reason;// Content của lý do
	private Date delayDateTo;// Hạn mới
	private String getXmlNotSend;// Trả về bản tin để ký, không gửi đi
	private String signedXml;//
//	private Long reference; 
//	
//	public Long getReference() {
//		return reference;
//	}
//
//	public void setReference(Long reference) {
//		this.reference = reference;
//	}
	

	public String getFunction() {
		return function;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getDocumentYear() {
		return documentYear;
	}

	public void setDocumentYear(int documentYear) {
		this.documentYear = documentYear;
	}

	public String getPreReference() {
		return preReference;
	}

	public void setPreReference(String preReference) {
		this.preReference = preReference;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
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

	public String getGetXmlNotSend() {
		return getXmlNotSend;
	}

	public void setGetXmlNotSend(String getXmlNotSend) {
		this.getXmlNotSend = getXmlNotSend;
	}

	public String getSignedXml() {
		return signedXml;
	}

	public void setSignedXml(String signedXml) {
		this.signedXml = signedXml;
	}	
}
