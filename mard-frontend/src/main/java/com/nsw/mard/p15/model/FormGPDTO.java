package com.nsw.mard.p15.model;

import com.nsw.mard.p14.model.TbsTepDinhKem14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdGiayPhep15DTO hoSo;
	private List<TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdGPThuoc15> thuocs = Collections.emptyList();
	public TbdGiayPhep15DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdGiayPhep15DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdGPThuoc15> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdGPThuoc15> thuocs) {
		this.thuocs = thuocs;
	}

}
