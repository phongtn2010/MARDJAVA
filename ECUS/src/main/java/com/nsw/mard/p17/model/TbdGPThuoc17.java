package com.nsw.mard.p17.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbdGPThuoc17
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
public class TbdGPThuoc17 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private Integer fiProductType;

	private String fiNameOfProduct;

	private Double fiWeight;

	private String fiWeightUnitCode;

	private String fiWeightUnitName;

	private String fiManufacturerName;

	private String fiCountryName;

	private String fiCountryCode;

	public String getFiCountryCode() {
		return fiCountryCode;
	}

	public void setFiCountryCode(String fiCountryCode) {
		this.fiCountryCode = fiCountryCode;
	}
	public String getFiSerialNo() {
		return fiSerialNo;
	}


	public void setFiSerialNo(String fiSerialNo) {
		this.fiSerialNo = fiSerialNo;
	}

	private String fiSerialNo;

	public Double getFiTotal() {
		return fiTotal;
	}

	public void setFiTotal(Double fiTotal) {
		this.fiTotal = fiTotal;
	}

	private Double fiTotal;



	private String fiMoneyUnitCode;

	//private String fiMoneyUnitName;




	public String getFiCountryName() {
			return fiCountryName;
	}

	public void setFiCountryName(String fiCountryName) {
		this.fiCountryName = fiCountryName;
	}

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public Integer getFiSort() {
		return this.fiSort;
	}

	public void setFiSort(Integer fiSort) {
		this.fiSort = fiSort;
	}

	public Integer getFiProductType() {
		return this.fiProductType;
	}

	public void setFiProductType(Integer fiProductType) {
		this.fiProductType = fiProductType;
	}

	public String getFiNameOfProduct() {
		return this.fiNameOfProduct;
	}

	public void setFiNameOfProduct(String fiNameOfProduct) {
		this.fiNameOfProduct = fiNameOfProduct;
	}

	public Double getFiWeight() {
		return this.fiWeight;
	}

	public void setFiWeight(Double fiWeight) {
		this.fiWeight = fiWeight;
	}

	public String getFiWeightUnitCode() {
		return this.fiWeightUnitCode;
	}

	public void setFiWeightUnitCode(String fiWeightUnitCode) {
		this.fiWeightUnitCode = fiWeightUnitCode;
	}

	public String getFiWeightUnitName() {
		return this.fiWeightUnitName;
	}

	public void setFiWeightUnitName(String fiWeightUnitName) {
		this.fiWeightUnitName = fiWeightUnitName;
	}

	public String getFiManufacturerName() {
		return this.fiManufacturerName;
	}

	public void setFiManufacturerName(String fiManufacturerName) {
		this.fiManufacturerName = fiManufacturerName;
	}
	public String getFiMoneyUnitCode() {
		return fiMoneyUnitCode;
	}

	public void setFiMoneyUnitCode(String fiMoneyUnitCode) {
		this.fiMoneyUnitCode = fiMoneyUnitCode;
	}

	/*public String getFiMoneyUnitName() {
		return fiMoneyUnitName;
	}

	public void setFiMoneyUnitName(String fiMoneyUnitName) {
		this.fiMoneyUnitName = fiMoneyUnitName;
	}
*/
	@Override
	public String toString() {
		return "TbdGPThuoc17 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiSort=" + fiSort + "," + 
				"fiProductType=" + fiProductType + "," +
				"fiNameOfProduct=" + fiNameOfProduct + "," +
				"fiSerialNo=" + fiSerialNo + "," +
				"fiWeight=" + fiWeight + "," + 
				"fiWeightUnitCode=" + fiWeightUnitCode + "," + 
				"fiWeightUnitName=" + fiWeightUnitName + "," +
				"fiManufacturerName=" + fiManufacturerName +
				"fiCountryCode=" + fiCountryCode + "," +
				"fiCountryName=" + fiCountryName + "," +
				"fiTotal=" + fiTotal +
				"fiMoneyUnitCode='" + "," +
				"fiMoneyUnitName='" + "," +
				"]";
	}
}
