package com.nsw.moit.p06.model;

import java.util.Date;

public class TbsProvince6 {
	
	private Long provinceId;
	
	private String provinceName;
	
	private Date modifiedDate;
	
	private Boolean isDelete;
	
	private String provinceCode;
	
	private Long parentProviceCode;
	
	private Long publicLevel;
	
	private Long arrange;
	
	private Long role;

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public Long getParentProviceCode() {
		return parentProviceCode;
	}

	public void setParentProviceCode(Long parentProviceCode) {
		this.parentProviceCode = parentProviceCode;
	}

	public Long getPublicLevel() {
		return publicLevel;
	}

	public void setPublicLevel(Long publicLevel) {
		this.publicLevel = publicLevel;
	}

	public Long getArrange() {
		return arrange;
	}

	public void setArrange(Long arrange) {
		this.arrange = arrange;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
}
