package com.nsw.mard.p17.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Form17DTO implements Serializable {

	private TbdHoSo17DTO hoSo;
	private List<TbsTepDinhKem17> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdDinhKem17> tepDinhKems = Collections.emptyList();
	private List<TbdThuoc17> thuocs = Collections.emptyList();
	private List<TbsLoaiThuoc17> danhMucThuocs = Collections.emptyList();
	private List<TbsMucDich17> danhMucMucDichs = Collections.emptyList();
	private List<TbsLoaiCN17> danhMucLoaiCN = Collections.emptyList();

	private int action;


	public TbdHoSo17DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdHoSo17DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem17> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem17> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdDinhKem17> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<TbdDinhKem17> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<TbdThuoc17> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdThuoc17> thuocs) {
		this.thuocs = thuocs;
	}

	public List<TbsLoaiThuoc17> getDanhMucThuocs() {
		return danhMucThuocs;
	}

	public void setDanhMucThuocs(List<TbsLoaiThuoc17> danhMucThuocs) {
		this.danhMucThuocs = danhMucThuocs;
	}
	public List<TbsLoaiCN17> getDanhMucLoaiCN() {
		return danhMucLoaiCN;
	}

	public void setDanhMucLoaiCN(List<TbsLoaiCN17> danhMucLoaiCN) {
		this.danhMucLoaiCN = danhMucLoaiCN;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public List<TbsMucDich17> getDanhMucMucDichs() {
		return danhMucMucDichs;
	}

	public void setDanhMucMucDichs(List<TbsMucDich17> danhMucMucDichs) {
		this.danhMucMucDichs = danhMucMucDichs;
	}

	@Override
	public String toString() {
		return "Form17DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				", loaiCNs="  + danhMucLoaiCN +
				'}';
	}
}
