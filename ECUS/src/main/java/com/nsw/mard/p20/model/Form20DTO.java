package com.nsw.mard.p20.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Form20DTO implements Serializable {

	private TbdHoSo20DTO hoSo;
	private List<TbsTepDinhKem20> danhMucTepDinhKems = Collections.emptyList();
	private List<TbdDinhKem20> tepDinhKems = Collections.emptyList();
	private List<TbdThuoc20> thuocs = Collections.emptyList();
	private List<TbsLoaiThuoc20> danhMucThuocs = Collections.emptyList();
	//private List<TbsMucDich20> danhMucMucDichs = Collections.emptyList();
	private List<TbsLoaiCN20> danhMucLoaiCN = Collections.emptyList();

	private int action;


	public TbdHoSo20DTO getHoSo() {
		return hoSo;
	}
	public void setHoSo(TbdHoSo20DTO hoSo) {
		this.hoSo = hoSo;
	}
	public List<TbsTepDinhKem20> getDanhMucTepDinhKems() {
		return danhMucTepDinhKems;
	}
	public void setDanhMucTepDinhKems(List<TbsTepDinhKem20> danhMucTepDinhKems) {
		this.danhMucTepDinhKems = danhMucTepDinhKems;
	}
	public List<TbdDinhKem20> getTepDinhKems() {
		return tepDinhKems;
	}
	public void setTepDinhKems(List<TbdDinhKem20> tepDinhKems) {
		this.tepDinhKems = tepDinhKems;
	}
	public List<TbdThuoc20> getThuocs() {
		return thuocs;
	}
	public void setThuocs(List<TbdThuoc20> thuocs) {
		this.thuocs = thuocs;
	}

	public List<TbsLoaiThuoc20> getDanhMucThuocs() {
		return danhMucThuocs;
	}

	public void setDanhMucThuocs(List<TbsLoaiThuoc20> danhMucThuocs) {
		this.danhMucThuocs = danhMucThuocs;
	}
	public List<TbsLoaiCN20> getDanhMucLoaiCN() {
		return danhMucLoaiCN;
	}

	public void setDanhMucLoaiCN(List<TbsLoaiCN20> danhMucLoaiCN) {
		this.danhMucLoaiCN = danhMucLoaiCN;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	//public List<TbsMucDich20> getDanhMucMucDichs() {
		//return danhMucMucDichs;
	//}

	//public void setDanhMucMucDichs(List<TbsMucDich20> danhMucMucDichs) {
		//this.danhMucMucDichs = danhMucMucDichs;
	//}

	@Override
	public String toString() {
		return "Form20DTO{" +
				"hoSo=" + hoSo +
				", danhMucTepDinhKems=" + danhMucTepDinhKems +
				", tepDinhKems=" + tepDinhKems +
				", thuocs=" + thuocs +
				", loaiCNs="  + danhMucLoaiCN +
				'}';
	}
}
