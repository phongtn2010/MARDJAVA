package com.vnsw.ws.p16.message;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class ThongTinApPhi
* Created by Nguyen Van Quang
* 05/12/2018 17:52:56
*
*/
@XmlRootElement(name = "MedicinePPFee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiTotalFee", "fiTotalFeeChar", "fiNote", "fiAccountNo", "fiAccountName"})
public class ThongTinApPhi {

	public ThongTinApPhi() {}

	@XmlElement(name = "TotalFee", required = true)
	private Double fiTotalFee;

	@XmlElement(name = "TotalFeeChar", required = true)
	private String fiTotalFeeChar;

	@XmlElement(name = "Note")
	private String fiNote;

	@XmlElement(name = "AccountNo")
	private String fiAccountNo;

	@XmlElement(name = "AccountName")
	private String fiAccountName;

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

	public String getFiAccountNo() {
		return this.fiAccountNo;
	}

	public void setFiAccountNo(String fiAccountNo) {
		this.fiAccountNo = fiAccountNo;
	}

	public String getFiAccountName() {
		return this.fiAccountName;
	}

	public void setFiAccountName(String fiAccountName) {
		this.fiAccountName = fiAccountName;
	}

	@Override
	public String toString() {
		return "ThongTinApPhi [" +
				"fiTotalFee=" + fiTotalFee + "," + 
				"fiTotalFeeChar=" + fiTotalFeeChar + "," + 
				"fiNote=" + fiNote + "," + 
				"fiAccountNo=" + fiAccountNo + "," + 
				"fiAccountName=" + fiAccountName + "]";
	}
}