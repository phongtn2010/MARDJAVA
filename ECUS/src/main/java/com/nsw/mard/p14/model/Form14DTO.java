package com.nsw.mard.p14.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Form14DTO implements Serializable {

	private com.nsw.mard.p14.model.TbdHoSo14DTO hoSo;
	private List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbdDinhKem14> tepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbdThuoc14> thuocs = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbsLoaiThuoc14> danhMucThuocs = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbsMucDich14> danhMucMucDichs = Collections.emptyList();

	private int action;


	public com.nsw.mard.p14.model.TbdHoSo14DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(com.nsw.mard.p14.model.TbdHoSo14DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<com.nsw.mard.p14.model.TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<com.nsw.mard.p14.model.TbdDinhKem14> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<com.nsw.mard.p14.model.TbdDinhKem14> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<com.nsw.mard.p14.model.TbdThuoc14> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<com.nsw.mard.p14.model.TbdThuoc14> thuocs) {
		this.thuocs = thuocs;
	}

	public List<com.nsw.mard.p14.model.TbsLoaiThuoc14> getDanhMucThuocs() {
		return danhMucThuocs;
	}

	public void setDanhMucThuocs(List<com.nsw.mard.p14.model.TbsLoaiThuoc14> danhMucThuocs) {
		this.danhMucThuocs = danhMucThuocs;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public List<TbsMucDich14> getDanhMucMucDichs() {
		return danhMucMucDichs;
	}

	public void setDanhMucMucDichs(List<TbsMucDich14> danhMucMucDichs) {
		this.danhMucMucDichs = danhMucMucDichs;
	}

	@Override
	public String toString() {
		return "Form14DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				'}';
	}
}
