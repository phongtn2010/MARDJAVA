package com.vnsw.ws.p01.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Currency")
@XmlType(propOrder = { "soLuongNgoaiTeBangSo","soLuongNgoaiTeBangChu","maLoaiTienTe"})
public class GPTienTe {

	@XmlTransient
	private long idCapGXNTienTe;
	public void setIdCapGXNTienTe(long idCapGXNTienTe) {
		this.idCapGXNTienTe = idCapGXNTienTe;
	}
	public long getIdCapGXNTienTe() {
		return this.idCapGXNTienTe;
	}
	
	@XmlTransient
	private long idCapGXNHoSo;
	public void setIdCapGXNHoSo(long idCapGXNHoSo) {
		this.idCapGXNHoSo = idCapGXNHoSo;
	}
	public long getIdCapGXNHoSo() {
		return this.idCapGXNHoSo;
	}
	
	@XmlElement(name = "QuantityNumber")
	private long soLuongNgoaiTeBangSo;
	public void setSoLuongNgoaiTeBangSo(long soLuongNgoaiTeBangSo) {
		this.soLuongNgoaiTeBangSo = soLuongNgoaiTeBangSo;
	}
	public long getSoLuongNgoaiTeBangSo() {
		return this.soLuongNgoaiTeBangSo;
	}
	@XmlElement(name = "QuantitySaying")
	private String soLuongNgoaiTeBangChu;
	public void setSoLuongNgoaiTeBangChu(String soLuongNgoaiTeBangChu) {
		this.soLuongNgoaiTeBangChu = soLuongNgoaiTeBangChu;
	}
	public String getSoLuongNgoaiTeBangChu() {
		return this.soLuongNgoaiTeBangChu;
	}
	
	@XmlElement(name = "CurrencyCode")
	private String maLoaiTienTe;
	public void setMaLoaiTienTe(String maTienTe) {
		this.maLoaiTienTe = maTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(GPTienTe.class.getSimpleName() + " { ");
		stringBuilder.append("idCapGXNTienTe=" + idCapGXNTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idCapGXNHoSo=" + idCapGXNHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangSo=" + soLuongNgoaiTeBangSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangChu=" + soLuongNgoaiTeBangChu); 
		stringBuilder.append(", "); 
		stringBuilder.append("maTienTe=" + maLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}