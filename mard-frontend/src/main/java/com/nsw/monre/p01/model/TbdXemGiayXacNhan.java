package com.nsw.monre.p01.model;

import java.util.List;

public class TbdXemGiayXacNhan {

	private List<TbdGXNThongTinCoSoSX1> tbdGXNThongTinCoSoSX;
	private List<TbdGXNThongTinPheLieu1> tbdGXNThongTinPheLieu;
	private TbdCapGiayXacNhan1 tbdCapGiayXacNhan;
	
	
	
	
	public List<TbdGXNThongTinCoSoSX1> getTbdGXNThongTinCoSoSX() {
		return tbdGXNThongTinCoSoSX;
	}




	public void setTbdGXNThongTinCoSoSX(List<TbdGXNThongTinCoSoSX1> tbdGXNThongTinCoSoSX) {
		this.tbdGXNThongTinCoSoSX = tbdGXNThongTinCoSoSX;
	}




	public List<TbdGXNThongTinPheLieu1> getTbdGXNThongTinPheLieu() {
		return tbdGXNThongTinPheLieu;
	}




	public void setTbdGXNThongTinPheLieu(List<TbdGXNThongTinPheLieu1> tbdGXNThongTinPheLieu) {
		this.tbdGXNThongTinPheLieu = tbdGXNThongTinPheLieu;
	}




	public TbdCapGiayXacNhan1 getTbdCapGiayXacNhan() {
		return tbdCapGiayXacNhan;
	}




	public void setTbdCapGiayXacNhan(TbdCapGiayXacNhan1 tbdCapGiayXacNhan) {
		this.tbdCapGiayXacNhan = tbdCapGiayXacNhan;
	}




	@Override
	public String toString() {
		return "TbdXemGiayXacNhan [tbdGXNThongTinCoSoSX=" + tbdGXNThongTinCoSoSX + ", tbdGXNThongTinPheLieu="
				+ tbdGXNThongTinPheLieu + ", tbdCapGiayXacNhan=" + tbdCapGiayXacNhan + "]";
	}
	
	
	
	
	
}
