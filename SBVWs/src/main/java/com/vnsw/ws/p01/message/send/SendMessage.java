package com.vnsw.ws.p01.message.send;

public class SendMessage {
	private String type;
	private String function;
	private Long fiIdHoso;// Id hồ sơ
	private Long fIdBanTin;
	private String lyDo;

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Long getfIdBanTin() {
		return fIdBanTin;
	}

	public void setfIdBanTin(Long fIdBanTin) {
		this.fIdBanTin = fIdBanTin;
	}

	private String getXmlNotSend;// Trả về bản tin để ký, không gửi đi
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
	
}
