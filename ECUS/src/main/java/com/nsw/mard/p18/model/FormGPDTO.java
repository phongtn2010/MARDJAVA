package com.nsw.mard.p18.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class FormGPDTO implements Serializable {

	private TbdThongBaoKetQua18DTO hoSo;
	private List<TbsTepDinhKem18> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsLoaiThuoc18> dmLoaiThuoc;
	
	private List<TbdTBKetQuaThuoc18> thuocs = Collections.emptyList();
	public TbdThongBaoKetQua18DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdThongBaoKetQua18DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem18> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem18> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdTBKetQuaThuoc18> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdTBKetQuaThuoc18> thuocs) {
		this.thuocs = thuocs;
	}
	public List<TbsLoaiThuoc18> getDmLoaiThuoc() {
		return dmLoaiThuoc;
	}
	public void setDmLoaiThuoc(List<TbsLoaiThuoc18> thuocs) {
		this.dmLoaiThuoc = thuocs;
	}

	//private List<com.nsw.mard.p18.model.TbsMucDich18> danhMucMucDichs = Collections.emptyList();
	//public List<TbsMucDich18> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich18> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}
}
