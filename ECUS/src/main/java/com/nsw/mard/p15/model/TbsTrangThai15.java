package com.nsw.mard.p15.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTrangThai14
* Created by Nguyen Van Quang
* 11/12/2018 10:08:45
*
*/
public class TbsTrangThai15 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private String fiCode;

	private String fiStatusName;

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

	public String getFiStatusName() {
		return this.fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}

	@Override
	public String toString() {
		return "TbsTrangThai14 [" +
				"fiId=" + fiId + "," + 
				"fiCode=" + fiCode + "," + 
				"fiStatusName=" + fiStatusName + "]";
	}
}
