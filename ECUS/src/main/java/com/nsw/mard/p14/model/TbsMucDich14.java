package com.nsw.mard.p14.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsMucDich14
* Created by Nguyen Van Quang
* 21/12/2018 08:55:19
*
*/
public class TbsMucDich14 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private String fiDocumentType;

	private String fiCode;

	private String fiName;

	private String fiDisplayGroup;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public String getFiCode() {
		return this.fiCode;
	}

	public void setFiCode(String fiCode) {
		this.fiCode = fiCode;
	}

	public String getFiName() {
		return this.fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public String getFiDisplayGroup() {
		return this.fiDisplayGroup;
	}

	public void setFiDisplayGroup(String fiDisplayGroup) {
		this.fiDisplayGroup = fiDisplayGroup;
	}

	public String getFiDocumentType() {
		return fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	private String fiNameEN;

	public String getFiNameEN() {
		return fiNameEN;
	}

	public void setFiNameEN(String fiNameEN) {
		this.fiNameEN = fiNameEN;
	}
	@Override
	public String toString() {
		return "TbsMucDich14 [" +
				"fiId=" + fiId + "," + 
				"fiCode=" + fiCode + "," + 
				"fiName=" + fiName + "," + 
				"fiDisplayGroup=" + fiDisplayGroup + "]";
	}
}