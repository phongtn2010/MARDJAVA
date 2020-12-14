package com.nsw.sbv.p01.model;

public class KySoModel {

	private String xml;
	private String serialNumber;
	private long idHoSo;
	private boolean requiredSign;
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
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
	@Override
	public String toString() {
		return "KySoModel [xml=" + xml + ", serialNumber=" + serialNumber + ", idHoSo=" + idHoSo + ", requiredSign="
				+ requiredSign + "]";
	}
	
	
	
}
