package com.nsw.monre.p01.model;

import com.nsw.monre.p01.util.*;
import com.nsw.monre.p01.model.base.*;
import java.util.Date;



public class TbsWard1  extends TbsWard1BaseModel{

	@ValidLength(maxLength = 20)
	private String wardId;

	public String getWardId() {
		return this.wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 20)
	private String districtId;

	public String getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	@ValidNotNullOrEmpty
	@ValidLength(maxLength = 255)
	private String wardName;

	public String getWardName() {
		return this.wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
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

		builder.append("TbsWard1: [ ");

		builder.append("wardId = " + wardId);

		builder.append(" | ");

		builder.append("districtId = " + districtId);

		builder.append(" | ");

		builder.append("wardName = " + wardName);

		builder.append(" | ");

		builder.append("modifyDate = " + modifyDate);

		builder.append(" | ");

		builder.append("isDeleted = " + isDeleted);

		builder.append(" ]");

		return builder.toString();

	}




}