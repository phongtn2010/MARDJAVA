package com.nsw.mard.p17.model;

import com.nsw.mard.p18.model.TbdDinhKem18;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


/***
*
*
* @Model
* @class TbdThuoc17
* Created by Nguyen Van Quang
* 11/12/2018 10:06:246
*
*/
public class TbdThuoc17 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;


	private Integer fiSort;

	@NotNull
	private Integer fiProductType;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String fiNameOfProduct;

	@NotNull
	private Double fiWeight;

	@NotNull
	@NotBlank
	private String fiWeightUnitCode;

	@NotNull
	@NotBlank
	private String fiWeightUnitName;


	@NotNull
	@NotBlank
	private String fiSerialNo;

	@NotEmpty
	@NotNull
	@Size(max = 6)
	private String fiCountryCode;

	@NotEmpty
	@NotNull
	@Size(max = 255)
	private String fiCountryName;


	@NotNull
	@NotEmpty
	private String fiManufacturerName;

	private List<TbdDinhKem17> fiTepDinhKemThuocs;

	public List<TbdDinhKem17> getFiTepDinhKemThuocs() {
		return fiTepDinhKemThuocs;
	}

	public void setFiTepDinhKemThuocs(List<TbdDinhKem17> fiTepDinhKemThuocs) {
		this.fiTepDinhKemThuocs = fiTepDinhKemThuocs;
	}


	public Double getFiTotal() {
		return fiTotal;
	}

	public void setFiTotal(Double fiTotal) {
		this.fiTotal = fiTotal;
	}

	@NotNull
	private Double fiTotal;



	//private String fiMoneyUnitName;

	private String fiMoneyUnitCode;

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

	public String getFiSerialNo() {
		return fiSerialNo;
	}

	public void setFiSerialNo(String fiSerialNo) {
		this.fiSerialNo = fiSerialNo;
	}

	public String getFiManufacturerName() {
		return fiManufacturerName;
	}

	public void setFiManufacturerName(String fiManufacturerName) {
		this.fiManufacturerName = fiManufacturerName;
	}
	public String getFiCountryCode() {
		return fiCountryCode;
	}

	public void setFiCountryCode(String fiCountryCode) {
		this.fiCountryCode = fiCountryCode;
	}

	public String getFiCountryName() {
		return fiCountryName;
	}

	public void setFiCountryName(String fiCountryName) {
		this.fiCountryName = fiCountryName;
	}
	/*public String getFiMoneyUnitName() {
		return fiMoneyUnitName;
	}

	public void setFiMoneyUnitName(String fiMoneyUnitName) {
		this.fiMoneyUnitName = fiMoneyUnitName;
	}*/

	public String getFiMoneyUnitCode() {
		return fiMoneyUnitCode;
	}

	public void setFiMoneyUnitCode(String fiMoneyUnitCode) {
		this.fiMoneyUnitCode = fiMoneyUnitCode;
	}



	@Override
	public String toString() {
		return "TbdThuoc17 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiSort=" + fiSort + "," + 
				"fiProductType=" + fiProductType + "," +
				"fiNameOfProduct=" + fiNameOfProduct + "," +
				"fiWeight=" + fiWeight + "," + 
				"fiWeightUnitCode=" + fiWeightUnitCode + "," + 
				"fiWeightUnitName=" + fiWeightUnitName + "," +
				"fiSerialNo=" + fiSerialNo + "," +
				"fiManufacturerName=" + fiManufacturerName + "," +
				"fiCountryCode=" + fiCountryCode + "," +
				"fiCountryName=" + fiCountryName + "," +
				"fiTotal=" + fiTotal + "," +
				"]";
	}
}
