package com.vnsw.ws.p01.message.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment")
public class TepDinhKemHoSo {

	@XmlTransient
	private long idTepDK;
	public void setIdTepDK(long idTepDK) {
		this.idTepDK = idTepDK;
	}
	public long getIdTepDK() {
		return this.idTepDK;
	}

	@XmlTransient
	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	@XmlElement(name = "AttachTypeCode")
	private String maLoaiTepDinhKem;
	public void setMaLoaiTepDinhKem(String maLoaiTepDinhKem) {
		this.maLoaiTepDinhKem = maLoaiTepDinhKem;
	}
	public String getMaLoaiTepDinhKem() {
		return this.maLoaiTepDinhKem;
	}
	@XmlElement(name = "AttachTypeName")
	private String tenLoaiTepDinhKem;
	public void setTenLoaiTepDinhKem(String tenLoaiTepDinhKem) {
		this.tenLoaiTepDinhKem = tenLoaiTepDinhKem;
	}
	public String getTenLoaiTepDinhKem() {
		return this.tenLoaiTepDinhKem;
	}

	@XmlElement(name = "FileName")
	private String tenTepDinhKem;
	public void setTenTepDinhKem(String tenTepDinhKem) {
		this.tenTepDinhKem = tenTepDinhKem;
	}
	public String getTenTepDinhKem() {
		return this.tenTepDinhKem;
	}
	
	@XmlElement(name = "FileByte")
	private String noiDungFile;
	public void setNoiDungFile(String noiDungFile) {
		this.noiDungFile = noiDungFile;
	}
	public String getNoiDungFile() {
		return this.noiDungFile;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TepDinhKemHoSo1 { ");
		stringBuilder.append("idTepDK=" + idTepDK); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("maLoaiTepDinhKem=" + maLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenLoaiTepDinhKem=" + tenLoaiTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("tenTepDinhKem=" + tenTepDinhKem); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungFile=" + noiDungFile); 
		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}