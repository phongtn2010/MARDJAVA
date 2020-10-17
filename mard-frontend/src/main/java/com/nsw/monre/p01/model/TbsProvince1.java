package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;
import java.util.Date;



public class TbsProvince1  extends TbsProvince1BaseModel{

	@ValidLength(maxLength = 20)
	private String provinceId;

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 200)
	private String provinceName;

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	private Date modifyDate;

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@ValidSize(min = 0, max = 1)
	private int isDeleted;

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("TbsProvince1: [ ");

		builder.append("provinceId = " + provinceId);

		builder.append(" | ");

		builder.append("provinceName = " + provinceName);

		builder.append(" | ");

		builder.append("modifyDate = " + modifyDate);

		builder.append(" | ");

		builder.append("isDeleted = " + isDeleted);

		builder.append(" ]");

		return builder.toString();

	}




}