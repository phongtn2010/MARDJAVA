package com.nsw.mard.p17.model;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdThongBaoPhi17
* Created by Nguyen Van Quang
* 11/12/2018 10:07:40
*
*/
public class TbdThongBaoPhi17 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Double fiTotalFee;

	private String fiTotalFeeChar;

	private String fiNote;

	private String fiAccountNo;

	private String fiAccountName;

	private Date fiCreateDate;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

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

	public Date getFiCreateDate() {
		return fiCreateDate;
	}

	public void setFiCreateDate(Date fiCreateDate) {
		this.fiCreateDate = fiCreateDate;
	}

	@Override
	public String toString() {
		return "TbdThongBaoPhi17 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiTotalFee=" + fiTotalFee + "," + 
				"fiTotalFeeChar=" + fiTotalFeeChar + "," + 
				"fiNote=" + fiNote + "," + 
				"fiAccountNo=" + fiAccountNo + "," + 
				"fiAccountName=" + fiAccountName + "]";
	}
}
