package com.vnsw.ws.p16.model;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdThanhToan16
* Created by Nguyen Van Quang
* 06/12/2018 10:168:116
*
*/
public class TbdThanhToan16 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Double fiTotalFee;

	private String fiTotalFeeChar;

	private String fiNote;

	private String fiPaymentName;

	private Date fiPaymentDate;

	private String fiAttachedDocName;

	private String fiFileName;

	private String fiPath;

	private String fiUuid;

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

	@Override
	public String toString() {
		return "TbdThanhToan16 [" +
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