package com.nsw.mard.p17.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdGiayPhep17DTO hoSo;
	private List<TbsTepDinhKem17> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsLoaiThuoc17> dmLoaiThuoc;
	
	private List<TbdGPThuoc17> thuocs = Collections.emptyList();
	public TbdGiayPhep17DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdGiayPhep17DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem17> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem17> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdGPThuoc17> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdGPThuoc17> thuocs) {
		this.thuocs = thuocs;
	}
	public List<TbsLoaiThuoc17> getDmLoaiThuoc() {
		return dmLoaiThuoc;
	}
	public void setDmLoaiThuoc(List<TbsLoaiThuoc17> thuocs) {
		this.dmLoaiThuoc = thuocs;
	}

	private List<com.nsw.mard.p17.model.TbsMucDich17> danhMucMucDichs = Collections.emptyList();
	public List<TbsMucDich17> getDanhMucMucDichs() {
		return danhMucMucDichs;
	}

	public void setDanhMucMucDichs(List<TbsMucDich17> danhMucMucDichs) {
		this.danhMucMucDichs = danhMucMucDichs;
	}
}
