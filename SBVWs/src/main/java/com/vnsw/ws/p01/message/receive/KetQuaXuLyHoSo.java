package com.vnsw.ws.p01.message.receive;


import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p01.message.send.TepDinhKemHoSo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Result")
@XmlType(propOrder = { "noiDungXuLy","ngayXuLy","donViXuLy","chuyenVienXuLy","attachment"})

public class KetQuaXuLyHoSo {

	@XmlTransient
	private long idKetQuanXuLyHoSo;
	public void setIdKetQuanXuLyHoSo(long idKetQuanXuLyHoSo) {
		this.idKetQuanXuLyHoSo = idKetQuanXuLyHoSo;
	}
	public long getIdKetQuanXuLyHoSo() {
		return this.idKetQuanXuLyHoSo;
	}
	
	@XmlTransient
	private long idHoSo;
	public void setIdHoSo(long idHoSo) {
		this.idHoSo = idHoSo;
	}
	public long getIdHoSo() {
		return this.idHoSo;
	}

	@XmlElement(name = "ResultDate")
	@XmlJavaTypeAdapter(DateSerialization.class)
	private Date ngayXuLy;
	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}
	public Date getNgayXuLy() {
		return this.ngayXuLy;
	}

	@XmlElement(name = "Department")
	private String donViXuLy;
	public void setDonViXuLy(String donViXuLy) {
		this.donViXuLy = donViXuLy;
	}
	public String getDonViXuLy() {
		return this.donViXuLy;
	}

	@XmlElement(name = "CreaterName")
	private String chuyenVienXuLy;
	public void setChuyenVienXuLy(String chuyenVienXuLy) {
		this.chuyenVienXuLy = chuyenVienXuLy;
	}
	public String getChuyenVienXuLy() {
		return this.chuyenVienXuLy;
	}

	@XmlElement(name = "Reason")
	private String noiDungXuLy;
	public void setNoiDungXuLy(String noiDungXuLy) {
		this.noiDungXuLy = noiDungXuLy;
	}
	public String getNoiDungXuLy() {
		return this.noiDungXuLy;
	}

	@XmlElement(name = "Attachment")
	private TepDinhKemHoSo attachment;	

	public TepDinhKemHoSo getAttachment() {
		return attachment;
	}
	public void setAttachment(TepDinhKemHoSo attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(KetQuaXuLyHoSo.class.getSimpleName() + " { ");
		stringBuilder.append("idKetQuanXuLyHoSo=" + idKetQuanXuLyHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("idHoSo=" + idHoSo); 
		stringBuilder.append(", "); 
		stringBuilder.append("ngayXuLy=" + ngayXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("donViXuLy=" + donViXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("chuyenVienXuLy=" + chuyenVienXuLy); 
		stringBuilder.append(", "); 
		stringBuilder.append("noiDungXuLy=" + noiDungXuLy); 

		stringBuilder.append(" }"); 

		return stringBuilder.toString();
	}
}