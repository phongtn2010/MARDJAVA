package com.nsw.mard.p17.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdThanhToan24
* Created by Nguyen Van Quang
* 04/12/2018 08:56:20
*
*/
public class TbdThanhToan17DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdThanhToan17DTO() {}

	public TbdThanhToan17DTO(Long fiId, Long fiIdHoSo, Double fiTotalFee, String fiTotalFeeChar, String fiNote, String fiPaymentName, Date fiPaymentDate, String fiAttachedDocName, String fiFileName, String fiPath, String fiUuid) {
		this.fiId = fiId;
		this.fiIdHoSo = fiIdHoSo;
		this.fiTotalFee = fiTotalFee;
		this.fiTotalFeeChar = fiTotalFeeChar;
		this.fiNote = fiNote;
		this.fiPaymentName = fiPaymentName;
		this.fiPaymentDate = fiPaymentDate;
		this.fiAttachedDocName = fiAttachedDocName;
		this.fiFileName = fiFileName;
		this.fiPath = fiPath;
		this.fiUuid = fiUuid;
	}

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Double fiTotalFee;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiTotalFeeChar;

	@Size(max = 250)
	private String fiNote;

	@NotNull
	@NotEmpty
	@Size(max = 250)
	private String fiPaymentName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiPaymentDate;

	@Size(max = 250)
	private String fiAttachedDocName;

	@Size(max = 250)
	private String fiFileName;

	@Size(max = 250)
	private String fiPath;

	@Size(max = 250)
	private String fiUuid;

	@Size(max = 75)
	private String fiFileCode;

	private Integer fiSended;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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

	public String getFiFileName() {
		return this.fiFileName;
	}

	public void setFiFileName(String fiFileName) {
		this.fiFileName = fiFileName;
	}

	public String getFiPath() {
		return this.fiPath;
	}

	public void setFiPath(String fiPath) {
		this.fiPath = fiPath;
	}

	public String getFiUuid() {
		return this.fiUuid;
	}

	public void setFiUuid(String fiUuid) {
		this.fiUuid = fiUuid;
	}

	public Date getFiCreateDate() {
		return fiCreateDate;
	}

	public void setFiCreateDate(Date fiCreateDate) {
		this.fiCreateDate = fiCreateDate;
	}

	public Integer getFiSended() {
		return fiSended;
	}

	public void setFiSended(Integer fiSended) {
		this.fiSended = fiSended;
	}

	public String getFiFileCode() {
		return fiFileCode;
	}

	public void setFiFileCode(String fiFileCode) {
		this.fiFileCode = fiFileCode;
	}


	@Override
	public String toString() {
		return "TbdThanhToan24 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiTotalFee=" + fiTotalFee + "," + 
				"fiTotalFeeChar=" + fiTotalFeeChar + "," + 
				"fiNote=" + fiNote + "," + 
				"fiPaymentName=" + fiPaymentName + "," + 
				"fiPaymentDate=" + fiPaymentDate + "," + 
				"fiAttachedDocName=" + fiAttachedDocName + "," + 
				"fiFileName=" + fiFileName + "," + 
				"fiPath=" + fiPath + "," + 
				"fiUuid=" + fiUuid + "]";
	}
}
