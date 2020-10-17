package com.nsw.sbv.p01.model;

public class KySoModel {

	private String xmlContent;
	private String xmlEnvelop;
	private String serialNumber;
	private long idHoSo;
	private boolean requiredSign;
	
	public String getXmlContent() {
		return xmlContent;
	}
	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public long getIdHoSo() {
		return idHoSo;
	}
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public boolean isRequiredSign() {
		return requiredSign;
	}
	public void setRequiredSign(boolean requiredSign) {
		this.requiredSign = requiredSign;
	}
	
	
	public String getXmlEnvelop() {
		return xmlEnvelop;
	}
	public void setXmlEnvelop(String xmlEnvelop) {
		this.xmlEnvelop = xmlEnvelop;
	}
	
	public String toEnvelop() {
		String headerXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlEnvelop = xmlEnvelop.replace("<Body/>", xmlContent.replace(headerXML, ""));
		return xmlEnvelop;
	}
	
	@Override
	public String toString() {
		return "KySoModel [xmlContent=" + xmlContent + ", xmlEnvelop=" + xmlEnvelop + ", serialNumber=" + serialNumber + ", idHoSo=" + idHoSo + ", requiredSign=" + requiredSign + "]";
	}
	
	
	
	
	
}
