package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;
import java.util.Date;



public class TbsDistrict1  extends TbsDistrict1BaseModel{

	@ValidLength(maxLength = 20)
	private String districtId;

	public String getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String provinceId;

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 250)
	private String districtName;

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

		builder.append("TbsDistrict1: [ ");

		builder.append("districtId = " + districtId);

		builder.append(" | ");

		builder.append("provinceId = " + provinceId);

		builder.append(" | ");

		builder.append("districtName = " + districtName);

		builder.append(" | ");

		builder.append("modifyDate = " + modifyDate);

		builder.append(" | ");

		builder.append("isDeleted = " + isDeleted);

		builder.append(" ]");

		return builder.toString();

	}




}