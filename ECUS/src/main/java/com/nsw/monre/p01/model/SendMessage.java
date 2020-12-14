package com.nsw.monre.p01.model;


public class SendMessage {

	private String type;

	private String function;

	private Long fiIdHoso;// Id hồ sơ
	private Long fIdBanTin;

	private String getXmlNotSend;// Tráº£ vá»� báº£n tin Ä‘á»ƒ kÃ½, khÃ´ng gá»­i Ä‘i
	private String signedXml;//

	
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



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	@Override
	public String toString() {
		return "SendMessage [type=" + type 	+ ", function=" + function + ", preReference=" + ", fiIdHoso=" + fiIdHoso + 
				", fIdBantin=" + fIdBanTin + ", getXmlNotSend=" + getXmlNotSend + ", signedXml=" + signedXml + "]";
	}

	public Long getfIdBanTin() {
		return fIdBanTin;
	}

	public void setfIdBanTin(Long fIdBanTin) {
		this.fIdBanTin = fIdBanTin;
	}
	
	
	
}
