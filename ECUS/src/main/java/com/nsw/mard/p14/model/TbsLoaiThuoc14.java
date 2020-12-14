package com.nsw.mard.p14.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsLoaiThuoc14
* Created by Nguyen Van Quang
* 11/12/2018 10:08:06
*
*/
public class TbsLoaiThuoc14 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Integer fiCode;

	private String fiName;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Integer getFiCode() {
		return this.fiCode;
	}

	public void setFiCode(Integer fiCode) {
		this.fiCode = fiCode;
	}

	public String getFiName() {
		return this.fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
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
		return "TbsLoaiThuoc14 [" +
				"fiId=" + fiId + "," + 
				"fiCode=" + fiCode + "," + 
				"fiName=" + fiName + "]";
	}
}