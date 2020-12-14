package com.nsw.mard.p19.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdThongBaoKetQua19DTO hoSo;
	private List<TbsTepDinhKem19> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsLoaiThuoc19> dmLoaiThuoc;
	
	private List<TbdTBKetQuaThuoc19> thuocs = Collections.emptyList();
	public TbdThongBaoKetQua19DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdThongBaoKetQua19DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem19> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem19> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdTBKetQuaThuoc19> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdTBKetQuaThuoc19> thuocs) {
		this.thuocs = thuocs;
	}
	public List<TbsLoaiThuoc19> getDmLoaiThuoc() {
		return dmLoaiThuoc;
	}
	public void setDmLoaiThuoc(List<TbsLoaiThuoc19> thuocs) {
		this.dmLoaiThuoc = thuocs;
	}

	//private List<com.nsw.mard.p19.model.TbsMucDich19> danhMucMucDichs = Collections.emptyList();
	//public List<TbsMucDich19> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich19> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}
}
