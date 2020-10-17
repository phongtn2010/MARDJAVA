package com.vnsw.ws.p14.message;

import com.vnsw.ws.annotations.DateSerialization;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class ThongBaoChuyenKhoan
* Created by Nguyen Van Quang
* 05/12/2018 17:514:46
*
*/
@XmlRootElement(name = "MedicinePPFeeReport")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiTotalFee", "fiTotalFeeChar", "fiNote", "fiPaymentName", "fiPaymentDate", "fiAttachedDocName", "fiAttach"})
public class ThongBaoChuyenKhoan {

	public ThongBaoChuyenKhoan() {}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	@XmlElement(name = "TotalFee", required = true)
	private Double fiTotalFee;

	@XmlElement(name = "TotalFeeChar", required = true)
	private String fiTotalFeeChar;

	@XmlElement(name = "Note")
	private String fiNote;

	@XmlElement(name = "PaymentName", required = true)
	private String fiPaymentName;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "PaymentDate")
	private Date fiPaymentDate;

	@XmlElement(name = "AttachedDocName")
	private String fiAttachedDocName;

	@XmlElement(name = "Attach", required = true)
	private Attach fiAttach;

	public Double getFiTotalFee() {
		return this.fiTotalFee;
	}

	public void setFiTotalFee(Double fiTotalFee) {
		this.fiTotalFee = fiTotalFee;
	}

	public String getFiTotalFeeChar() {
		return this.fiTotalFeeChar;
	}

	public void setFiTotalFeeChar(String fiTotalFeeChar) {
		this.fiTotalFeeChar = fiTotalFeeChar;
	}

	public String getFiNote() {
		return this.fiNote;
	}

	public void setFiNote(String fiNote) {
		this.fiNote = fiNote;
	}

	public String getFiPaymentName() {
		return this.fiPaymentName;
	}

	public void setFiPaymentName(String fiPaymentName) {
		this.fiPaymentName = fiPaymentName;
	}

	public Date getFiPaymentDate() {
		return this.fiPaymentDate;
	}

	public void setFiPaymentDate(Date fiPaymentDate) {
		this.fiPaymentDate = fiPaymentDate;
	}

	public String getFiAttachedDocName() {
		return this.fiAttachedDocName;
	}

	public void setFiAttachedDocName(String fiAttachedDocName) {
		this.fiAttachedDocName = fiAttachedDocName;
	}

	public Attach getFiAttach() {
		return this.fiAttach;
	}

	public void setFiAttach(Attach fiAttach) {
		this.fiAttach = fiAttach;
	}

	@Override
	public String toString() {
		return "ThongBaoChuyenKhoan [" +
				"fiTotalFee=" + fiTotalFee + "," + 
				"fiTotalFeeChar=" + fiTotalFeeChar + "," + 
				"fiNote=" + fiNote + "," + 
				"fiPaymentName=" + fiPaymentName + "," + 
				"fiPaymentDate=" + fiPaymentDate + "," + 
				"fiAttachedDocName=" + fiAttachedDocName + "," + 
				"fiAttach=" + fiAttach + "]";
	}
}