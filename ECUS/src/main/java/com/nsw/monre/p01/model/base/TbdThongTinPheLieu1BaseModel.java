package com.nsw.monre.p01.model.base;




public abstract class TbdThongTinPheLieu1BaseModel {


	private int xoaBo = 0;

	public int getXoaBo() {
		return xoaBo;
	}

	public void setXoaBo(int xoaBo) {
		this.xoaBo = xoaBo;
	}
	
	private int capNhat  = 0;

	public int getCapNhat() {
		return capNhat;
	}

	public void setCapNhat(int capNhat) {
		this.capNhat = capNhat;
	}
	
	private int taoMoi = 0;

	public int getTaoMoi() {
		return taoMoi;
	}

	public void setTaoMoi(int taoMoi) {
		this.taoMoi = taoMoi;
	}
	
	private String khoiLuong6Input;
	
	private String khoiLuongInput;

	private String klCongSuatInput;

	public String getKlCongSuatInput() {
		return klCongSuatInput;
	}

	public void setKlCongSuatInput(String klCongSuatInput) {
		this.klCongSuatInput = klCongSuatInput;
	}

	private Double klCongSuat;

	public Double getKlCongSuat() {
		return klCongSuat;
	}
	public void setKlCongSuat(Double klCongSuat) {
		this.klCongSuat = klCongSuat;
	}
	public String getKhoiLuong6Input() {
		return khoiLuong6Input;
	}

	public void setKhoiLuong6Input(String khoiLuong6Input) {
		this.khoiLuong6Input = khoiLuong6Input;
	}

	public String getKhoiLuongInput() {
		return khoiLuongInput;
	}

	public void setKhoiLuongInput(String khoiLuongInput) {
		this.khoiLuongInput = khoiLuongInput;
	}
	
	private boolean canUpdate;
	
	private boolean canDelete;

	public boolean isCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	
	
	
	
}