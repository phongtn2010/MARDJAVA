package com.nsw.mard.p19.model;

import com.nsw.mard.p18.model.TbsTepDinhKem18;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Form19DTO implements Serializable {

	private TbdHoSo19DTO hoSo;
	private List<TbsTepDinhKem18> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdDinhKem19> tepDinhKems = Collections.emptyList();
	private List<TbdThuoc19> thuocs = Collections.emptyList();
	private List<TbsLoaiThuoc19> danhMucThuocs = Collections.emptyList();
	//private List<TbsMucDich19> danhMucMucDichs = Collections.emptyList();
	private List<TbsLoaiCN19> danhMucLoaiCN = Collections.emptyList();

	private int action;


	public TbdHoSo19DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdHoSo19DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem18> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem18> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdDinhKem19> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<TbdDinhKem19> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<TbdThuoc19> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdThuoc19> thuocs) {
		this.thuocs = thuocs;
	}

	public List<TbsLoaiThuoc19> getDanhMucThuocs() {
		return danhMucThuocs;
	}

	public void setDanhMucThuocs(List<TbsLoaiThuoc19> danhMucThuocs) {
		this.danhMucThuocs = danhMucThuocs;
	}
	public List<TbsLoaiCN19> getDanhMucLoaiCN() {
		return danhMucLoaiCN;
	}

	public void setDanhMucLoaiCN(List<TbsLoaiCN19> danhMucLoaiCN) {
		this.danhMucLoaiCN = danhMucLoaiCN;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	//public List<TbsMucDich19> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich19> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}

	@Override
	public String toString() {
		return "Form19DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				", loaiCNs="  + danhMucLoaiCN +
				'}';
	}
}
