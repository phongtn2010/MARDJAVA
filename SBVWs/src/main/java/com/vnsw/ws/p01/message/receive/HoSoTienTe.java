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
public class HoSoTienTe {

	@XmlTransient
	private long idTienTe;
	public void setIdTienTe(long idTienTe) {
		this.idTienTe = idTienTe;
	}
	public long getIdTienTe() {
		return this.idTienTe;
	}

	@XmlTransient
	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
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
	public void setMaLoaiTienTe(String maLoaiTienTe) {
		this.maLoaiTienTe = maLoaiTienTe;
	}
	public String getMaLoaiTienTe() {
		return this.maLoaiTienTe;
	}
	

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(HoSoTienTe.class.getSimpleName() + " { ");
		stringBuilder.append("idTienTe=" + idTienTe); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangSo=" + soLuongNgoaiTeBangSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("soLuongNgoaiTeBangChu=" + soLuongNgoaiTeBangChu); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTienTe=" + maLoaiTienTe); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}