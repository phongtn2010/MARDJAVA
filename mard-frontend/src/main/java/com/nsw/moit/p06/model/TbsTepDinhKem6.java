package com.nsw.moit.p06.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTepDinhKem6
* Created by Nguyen Van Quang
* 22/08/2018 13:00:33
*
*/
public class TbsTepDinhKem6 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tepDinhKemId;

	private String tenTep;

	private String loaiTep;

	private String loaiThuTuc;

	private Boolean required;
	
	private Integer maLoaiTep;

	public Integer getMaLoaiTep() {
		return maLoaiTep;
	}

	public void setMaLoaiTep(Integer maLoaiTep) {
		this.maLoaiTep = maLoaiTep;
	}

	public Long getTepDinhKemId() {
		return this.tepDinhKemId;
	}

	public void setTepDinhKemId(Long tepDinhKemId) {
		this.tepDinhKemId = tepDinhKemId;
	}

	public String getTenTep() {
		return this.tenTep;
	}

	public void setTenTep(String tenTep) {
		this.tenTep = tenTep;
	}

	public String getLoaiTep() {
		return this.loaiTep;
	}

	public void setLoaiTep(String loaiTep) {
		this.loaiTep = loaiTep;
	}

	public String getLoaiThuTuc() {
		return this.loaiThuTuc;
	}

	public void setLoaiThuTuc(String loaiThuTuc) {
		this.loaiThuTuc = loaiThuTuc;
	}

	public Boolean getRequired() {
		return this.required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	private Integer order;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "TbsTepDinhKem6 [" +
				"tepDinhKemId=" + tepDinhKemId + "," + 
				"tenTep=" + tenTep + "," + 
				"loaiTep=" + loaiTep + "," + 
				"loaiThuTuc=" + loaiThuTuc + "," + 
				"required=" + required + "]";
	}
}