package com.nsw.mard.p20.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTepDinhKem20
* Created by Nguyen Van Quang
* 11/12/2020 10:08:202
*
*/
public class TbsTepDinhKem20 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private String fiName;

	private String fiFileTypeCode;

	private String fiFileGroup;

	private String fiDocumentType;

	private Boolean fiRequired;

	private Integer fiSort;

	public Long getFiId() {
		return fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public String getFiFileTypeCode() {
		return fiFileTypeCode;
	}

	public void setFiFileTypeCode(String fiFileTypeCode) {
		this.fiFileTypeCode = fiFileTypeCode;
	}

	public String getFiFileGroup() {
		return fiFileGroup;
	}

	public void setFiFileGroup(String fiFileGroup) {
		this.fiFileGroup = fiFileGroup;
	}

	public String getFiDocumentType() {
		return fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	public Boolean getFiRequired() {
		return fiRequired;
	}

	public void setFiRequired(Boolean fiRequired) {
		this.fiRequired = fiRequired;
	}

	public Integer getFiSort() {
		return fiSort;
	}

	public void setFiSort(Integer fiSort) {
		this.fiSort = fiSort;
	}

	@Override
	public String toString() {
		return "TbsTepDinhKem20{" +
				"fiId=" + fiId +
				", fiName='" + fiName + '\'' +
				", fiFileTypeCode='" + fiFileTypeCode + '\'' +
				", fiFileGroup='" + fiFileGroup + '\'' +
				", fiDocumentType='" + fiDocumentType + '\'' +
				", fiRequired=" + fiRequired +
				", fiSort=" + fiSort +
				'}';
	}
}
