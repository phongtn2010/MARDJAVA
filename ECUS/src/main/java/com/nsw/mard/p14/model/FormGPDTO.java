package com.nsw.mard.p14.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdGiayPhep14DTO hoSo;
	private List<TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsLoaiThuoc14> dmLoaiThuoc;
	
	private List<TbdGPThuoc14> thuocs = Collections.emptyList();
	public TbdGiayPhep14DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdGiayPhep14DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdGPThuoc14> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdGPThuoc14> thuocs) {
		this.thuocs = thuocs;
	}
	public List<TbsLoaiThuoc14> getDmLoaiThuoc() {
		return dmLoaiThuoc;
	}
	public void setDmLoaiThuoc(List<TbsLoaiThuoc14> thuocs) {
		this.dmLoaiThuoc = thuocs;
	}

	private List<com.nsw.mard.p14.model.TbsMucDich14> danhMucMucDichs = Collections.emptyList();
	public List<TbsMucDich14> getDanhMucMucDichs() {
		return danhMucMucDichs;
	}

	public void setDanhMucMucDichs(List<TbsMucDich14> danhMucMucDichs) {
		this.danhMucMucDichs = danhMucMucDichs;
	}
}
