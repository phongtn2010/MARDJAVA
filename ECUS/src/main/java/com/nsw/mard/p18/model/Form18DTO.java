package com.nsw.mard.p18.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Form18DTO implements Serializable {

	private TbdHoSo18DTO hoSo;
	private List<TbsTepDinhKem18> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdDinhKem18> tepDinhKems = Collections.emptyList();
	private List<TbdThuoc18> thuocs = Collections.emptyList();
	private List<TbsLoaiThuoc18> danhMucThuocs = Collections.emptyList();
	//private List<TbsMucDich18> danhMucMucDichs = Collections.emptyList();
	private List<TbsLoaiCN18> danhMucLoaiCN = Collections.emptyList();

	private int action;


	public TbdHoSo18DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdHoSo18DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem18> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem18> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdDinhKem18> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<TbdDinhKem18> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<TbdThuoc18> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdThuoc18> thuocs) {
		this.thuocs = thuocs;
	}

	public List<TbsLoaiThuoc18> getDanhMucThuocs() {
		return danhMucThuocs;
	}

	public void setDanhMucThuocs(List<TbsLoaiThuoc18> danhMucThuocs) {
		this.danhMucThuocs = danhMucThuocs;
	}
	public List<TbsLoaiCN18> getDanhMucLoaiCN() {
		return danhMucLoaiCN;
	}

	public void setDanhMucLoaiCN(List<TbsLoaiCN18> danhMucLoaiCN) {
		this.danhMucLoaiCN = danhMucLoaiCN;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	//public List<TbsMucDich18> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich18> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}

	@Override
	public String toString() {
		return "Form18DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				", loaiCNs="  + danhMucLoaiCN +
				'}';
	}
}
