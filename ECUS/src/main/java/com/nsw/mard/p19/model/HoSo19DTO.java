package com.nsw.mard.p19.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class HoSo24DTO
* Created by Nguyen Van Quang
* 11/12/2019 09:58:20
*
*/
public class HoSo19DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public HoSo19DTO() {}

	public HoSo19DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiSendDate, String fiNameOfRegistration , String fiDispatchNo, String fiSignConfirmName, Date fiSignConfirmDate, String fiStatusName) {
		this.fiIdHoSo = fiIdHoSo;
		this.fiDocumentType = fiDocumentType;
		this.fiDocumentName = fiDocumentName;
		this.fiStatus = fiStatus;
		this.fiSendDate = fiSendDate;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiDispatchNo = fiDispatchNo;
		this.fiSignConfirmName = fiSignConfirmName;
		this.fiSignConfirmDate = fiSignConfirmDate;
		this.fiStatusName = fiStatusName;
	}

	private Long fiIdHoSo;

	@NotNull
	@Size(max = 255)
	private String fiDocumentType;

	@NotNull
	@Size(max = 255)
	private String fiDocumentName;

	@NotNull
	private Integer fiStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiSendDate;

	@NotNull
	@Size(max = 255)
	private String fiNameOfRegistration;

	@NotNull
	@Size(max = 50)
	private String fiDispatchNo;

	@Size(max = 100)
	private String fiSignConfirmName;



	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiSignConfirmDate;

	@NotNull
	private String fiStatusName;

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiDocumentType() {
		return fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	public String getFiDocumentName() {
		return fiDocumentName;
	}

	public void setFiDocumentName(String fiDocumentName) {
		this.fiDocumentName = fiDocumentName;
	}

	public Integer getFiStatus() {
		return fiStatus;
	}

	public void setFiStatus(Integer fiStatus) {
		this.fiStatus = fiStatus;
	}

	public Date getFiSendDate() {
		return fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}

	public String getFiNameOfRegistration() {
		return fiNameOfRegistration;
	}

	public void setFiNameOfRegistration(String fiNameOfRegistration) {
		this.fiNameOfRegistration = fiNameOfRegistration;
	}

	public String getFiDispatchNo() {
		return fiDispatchNo;
	}

	public void setFiDispatchNo(String fiDispatchNo) {
		this.fiDispatchNo = fiDispatchNo;
	}

	public String getFiSignConfirmName() {
		return fiSignConfirmName;
	}

	public void setFiSignConfirmName(String fiSignConfirmName) {
		this.fiSignConfirmName = fiSignConfirmName;
	}

	public Date getFiSignConfirmDate() {
		return fiSignConfirmDate;
	}

	public void setFiSignConfirmDate(Date fiSignConfirmDate) {
		this.fiSignConfirmDate = fiSignConfirmDate;
	}

	public String getFiStatusName() {
		return fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}
	@Override
	public String toString() {
		return "HoSo19DTO{" +
				"fiIdHoSo=" + fiIdHoSo +
				", fiDocumentType='" + fiDocumentType + '\'' +
				", fiDocumentName='" + fiDocumentName + '\'' +
				", fiStatus=" + fiStatus +
				", fiSendDate=" + fiSendDate +
				", fiNameOfRegistration='" + fiNameOfRegistration + '\'' +
				", fiDispatchNo='" + fiDispatchNo + '\'' +
				", fiSignConfirmName='" + fiSignConfirmName + '\'' +
				", fiSignConfirmDate=" + fiSignConfirmDate +
				", fiStatusName='" + fiStatusName + '\'' +
				'}';
	}
}
