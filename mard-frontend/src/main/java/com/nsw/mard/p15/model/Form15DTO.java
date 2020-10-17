package com.nsw.mard.p15.model;

import com.nsw.mard.p14.model.TbsMucDich14;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Form15DTO implements Serializable {

	@NotNull
	private com.nsw.mard.p15.model.TbdHoSo15DTO hoSo;
	private List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p15.model.TbdDinhKem15> tepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p15.model.TbdThuoc15> thuocs = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbsMucDich14> danhMucMucDichs = Collections.emptyList();
	private int action;


	public com.nsw.mard.p15.model.TbdHoSo15DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(com.nsw.mard.p15.model.TbdHoSo15DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<com.nsw.mard.p14.model.TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<com.nsw.mard.p15.model.TbdDinhKem15> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<com.nsw.mard.p15.model.TbdDinhKem15> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<com.nsw.mard.p15.model.TbdThuoc15> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<com.nsw.mard.p15.model.TbdThuoc15> thuocs) {
		this.thuocs = thuocs;
	}

	public List<TbsMucDich14> getDanhMucMucDichs() {
		return danhMucMucDichs;
	}

	public void setDanhMucMucDichs(List<TbsMucDich14> danhMucMucDichs) {
		this.danhMucMucDichs = danhMucMucDichs;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Form15DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				'}';
	}
}
