package com.nsw.mard.p14.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdThongBaoPhi14
* Created by Nguyen Van Quang
* 04/12/2018 08:54:41
*
*/
public class TbdThongBaoPhi14DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdThongBaoPhi14DTO() {}

	public TbdThongBaoPhi14DTO(Long fiId, Long fiIdHoSo, Double fiTotalFee, String fiTotalFeeChar, String fiNote, String fiAccountNo, String fiAccountName) {
		this.fiId = fiId;
		this.fiIdHoSo = fiIdHoSo;
		this.fiTotalFee = fiTotalFee;
		this.fiTotalFeeChar = fiTotalFeeChar;
		this.fiNote = fiNote;
		this.fiAccountNo = fiAccountNo;
		this.fiAccountName = fiAccountName;
	}

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Double fiTotalFee;

	@NotNull
	@Size(max = 250)
	private String fiTotalFeeChar;

	@Size(max = 250)
	private String fiNote;

	@Size(max = 250)
	private String fiAccountNo;

	@Size(max = 250)
	private String fiAccountName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
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
		return "TbdThongBaoPhi14 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiTotalFee=" + fiTotalFee + "," + 
				"fiTotalFeeChar=" + fiTotalFeeChar + "," + 
				"fiNote=" + fiNote + "," + 
				"fiAccountNo=" + fiAccountNo + "," + 
				"fiAccountName=" + fiAccountName + "]";
	}
}