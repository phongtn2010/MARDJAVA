package com.nsw.mard.p16.model;

import com.nsw.mard.p14.model.TbsTepDinhKem14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdGiayPhep16DTO hoSo;
	private List<TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdGPThuoc16> thuocs = Collections.emptyList();
	public TbdGiayPhep16DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdGiayPhep16DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdGPThuoc16> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdGPThuoc16> thuocs) {
		this.thuocs = thuocs;
	}

}
