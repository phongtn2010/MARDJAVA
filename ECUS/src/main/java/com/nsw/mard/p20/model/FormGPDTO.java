package com.nsw.mard.p20.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdThongBaoKetQua20DTO hoSo;
	private List<TbsTepDinhKem20> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsLoaiThuoc20> dmLoaiThuoc;
	
	private List<TbdTBKetQuaThuoc20> thuocs = Collections.emptyList();
	public TbdThongBaoKetQua20DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdThongBaoKetQua20DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem20> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem20> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdTBKetQuaThuoc20> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdTBKetQuaThuoc20> thuocs) {
		this.thuocs = thuocs;
	}
	public List<TbsLoaiThuoc20> getDmLoaiThuoc() {
		return dmLoaiThuoc;
	}
	public void setDmLoaiThuoc(List<TbsLoaiThuoc20> thuocs) {
		this.dmLoaiThuoc = thuocs;
	}

	//private List<com.nsw.mard.p20.model.TbsMucDich20> danhMucMucDichs = Collections.emptyList();
	//public List<TbsMucDich20> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich20> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}
}
