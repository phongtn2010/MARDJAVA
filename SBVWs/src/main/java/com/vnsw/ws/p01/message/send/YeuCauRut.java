package com.vnsw.ws.p01.message.send;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.vnsw.ws.annotations.DateSerialization;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RequestCancel")
@XmlType(propOrder = { "ngayRut" , "noiDung"})
public class YeuCauRut{

	@XmlTransient
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlTransient
	private long idHS;

	public long getIdHS() {
		return this.idHS;
	}

	public void setIdHS(long idHS) {
		this.idHS = idHS;
	}

	@XmlElement(name = "RequestDate")
	@XmlJavaTypeAdapter(DateSerialization.class)
	private Date ngayRut;

	public Date getNgayRut() {
		return this.ngayRut;
	}

	public void setNgayRut(Date ngayRut) {
		this.ngayRut = ngayRut;
	}

	@XmlElement(name = "Reason")
	private String noiDung;
	public String getNoiDung() {
		return this.noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@XmlTransient
	private String noiDungPhanHoi;
	public String getNoiDungPhanHoi() {
		return this.noiDungPhanHoi;
	}
	public void setNoiDungPhanHoi(String noiDungPhanHoi) {
		this.noiDungPhanHoi = noiDungPhanHoi;
	}

	@Override
	public String toString() {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder builder = new StringBuilder();

		builder.append("TbdYeuCauRutHS: [ ");

		builder.append("id = " + id);

		builder.append(" | ");

		builder.append("idHS = " + idHS);

		builder.append(" | ");

		builder.append("ngayRut = " + df.format(ngayRut));

		builder.append(" | ");

		builder.append("noiDung = " + noiDung);

		builder.append(" | ");

		builder.append("noiDungPhanHoi = " + noiDungPhanHoi);

		builder.append(" | ");

		return builder.toString();

	}
}