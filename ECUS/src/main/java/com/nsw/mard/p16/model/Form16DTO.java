package com.nsw.mard.p16.model;

import com.nsw.mard.p14.model.TbsMucDich14;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Form16DTO implements Serializable {

	@NotNull
	private com.nsw.mard.p16.model.TbdHoSo16DTO hoSo;
	private List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p16.model.TbdDinhKem16> tepDinhKems = Collections.emptyList();
	private List<com.nsw.mard.p16.model.TbdThuoc16> thuocs = Collections.emptyList();
	private List<com.nsw.mard.p14.model.TbsMucDich14> danhMucMucDichs = Collections.emptyList();
	private List<TbdToKhaiKyThuat16> toKhaiKyThuats = Collections.emptyList();
	private List<TbsLoaiGiayTo16> tbsLoaiGiayTo16s = Collections.emptyList();
	private List<TbsGiaTriSuDung16> tbsGiaTriSuDung16s = Collections.emptyList();
	private List<TbsBoPhan16> tbsBoPhan16s = Collections.emptyList();
	private int action;


	public com.nsw.mard.p16.model.TbdHoSo16DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(com.nsw.mard.p16.model.TbdHoSo16DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<com.nsw.mard.p14.model.TbsTepDinhKem14> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<com.nsw.mard.p14.model.TbsTepDinhKem14> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<com.nsw.mard.p16.model.TbdDinhKem16> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<com.nsw.mard.p16.model.TbdDinhKem16> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<com.nsw.mard.p16.model.TbdThuoc16> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<com.nsw.mard.p16.model.TbdThuoc16> thuocs) {
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

	public List<TbdToKhaiKyThuat16> getToKhaiKyThuats() {
		return toKhaiKyThuats;
	}

	public void setToKhaiKyThuats(List<TbdToKhaiKyThuat16> toKhaiKyThuats) {
		this.toKhaiKyThuats = toKhaiKyThuats;
	}

	public List<TbsLoaiGiayTo16> getTbsLoaiGiayTo16s() {
		return tbsLoaiGiayTo16s;
	}

	public void setTbsLoaiGiayTo16s(List<TbsLoaiGiayTo16> tbsLoaiGiayTo16s) {
		this.tbsLoaiGiayTo16s = tbsLoaiGiayTo16s;
	}

	public List<TbsGiaTriSuDung16> getTbsGiaTriSuDung16s() {
		return tbsGiaTriSuDung16s;
	}

	public void setTbsGiaTriSuDung16s(List<TbsGiaTriSuDung16> tbsGiaTriSuDung16s) {
		this.tbsGiaTriSuDung16s = tbsGiaTriSuDung16s;
	}

	public List<TbsBoPhan16> getTbsBoPhan16s() {
		return tbsBoPhan16s;
	}

	public void setTbsBoPhan16s(List<TbsBoPhan16> tbsBoPhan16s) {
		this.tbsBoPhan16s = tbsBoPhan16s;
	}
}
