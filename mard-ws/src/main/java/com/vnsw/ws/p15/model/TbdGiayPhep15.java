package com.vnsw.ws.p15.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdGiayPhep15
* Created by Nguyen Van Quang
* 06/12/2018 10:158:42
*
*/
public class TbdGiayPhep15 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	@Size(max = 250)
	private String fiOrganization;

	@NotNull
	private String fiAddress;

	@NotNull
	@Size(max = 50)
	private String fiApplicationNo;

	@NotNull
	private Date fiSignDate;

	@NotNull
	@Size(max = 500)
	private String fiTotalQuantity;

	@Size(max = 500)
	@NotNull
	private String fiOtherContent;

	@NotNull
	private Date fiDealineImport;

	@Size(max = 2000)
	@NotNull
	private String fiRecipients;

	@NotNull
	@Size(max = 50)
	private String fiDispatchNo;

	@NotNull
	private Date fiSignConfirmDate;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmName;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmPosition;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmAddress;

	public Long getFiId() {
		return fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiOrganization() {
		return fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
	}

	public String getFiAddress() {
		return fiAddress;
	}

	public void setFiAddress(String fiAddress) {
		this.fiAddress = fiAddress;
	}

	public String getFiApplicationNo() {
		return fiApplicationNo;
	}

	public void setFiApplicationNo(String fiApplicationNo) {
		this.fiApplicationNo = fiApplicationNo;
	}

	public Date getFiSignDate() {
		return fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
	}

	public String getFiTotalQuantity() {
		return fiTotalQuantity;
	}

	public void setFiTotalQuantity(String fiTotalQuantity) {
		this.fiTotalQuantity = fiTotalQuantity;
	}

	public String getFiOtherContent() {
		return fiOtherContent;
	}

	public void setFiOtherContent(String fiOtherContent) {
		this.fiOtherContent = fiOtherContent;
	}

	public Date getFiDealineImport() {
		return fiDealineImport;
	}

	public void setFiDealineImport(Date fiDealineImport) {
		this.fiDealineImport = fiDealineImport;
	}

	public String getFiRecipients() {
		return fiRecipients;
	}

	public void setFiRecipients(String fiRecipients) {
		this.fiRecipients = fiRecipients;
	}

	public String getFiDispatchNo() {
		return fiDispatchNo;
	}

	public void setFiDispatchNo(String fiDispatchNo) {
		this.fiDispatchNo = fiDispatchNo;
	}

	public Date getFiSignConfirmDate() {
		return fiSignConfirmDate;
	}

	public void setFiSignConfirmDate(Date fiSignConfirmDate) {
		this.fiSignConfirmDate = fiSignConfirmDate;
	}

	public String getFiSignConfirmName() {
		return fiSignConfirmName;
	}

	public void setFiSignConfirmName(String fiSignConfirmName) {
		this.fiSignConfirmName = fiSignConfirmName;
	}

	public String getFiSignConfirmPosition() {
		return fiSignConfirmPosition;
	}

	public void setFiSignConfirmPosition(String fiSignConfirmPosition) {
		this.fiSignConfirmPosition = fiSignConfirmPosition;
	}

	public String getFiSignConfirmAddress() {
		return fiSignConfirmAddress;
	}

	public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
		this.fiSignConfirmAddress = fiSignConfirmAddress;
	}

	@Override
	public String toString() {
		return "TbdGiayPhep15{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiOrganization='" + fiOrganization + '\'' +
				", fiAddress='" + fiAddress + '\'' +
				", fiApplicationNo='" + fiApplicationNo + '\'' +
				", fiSignDate=" + fiSignDate +
				", fiTotalQuantity='" + fiTotalQuantity + '\'' +
				", fiOtherContent='" + fiOtherContent + '\'' +
				", fiDealineImport=" + fiDealineImport +
				", fiRecipients='" + fiRecipients + '\'' +
				", fiDispatchNo='" + fiDispatchNo + '\'' +
				", fiSignConfirmDate=" + fiSignConfirmDate +
				", fiSignConfirmName='" + fiSignConfirmName + '\'' +
				", fiSignConfirmPosition='" + fiSignConfirmPosition + '\'' +
				", fiSignConfirmAddress='" + fiSignConfirmAddress + '\'' +
				'}';
	}
}