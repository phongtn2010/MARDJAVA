package com.vnsw.ws.p04.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GoodsList1")
public class TbdAnanyticalGoods04{

	@XmlTransient
	private Long id;

	@XmlElement(name = "CodeOfGoods")
	private String codeOfGoods;

	@XmlElement(name = "NameOfGoods")
	private String nameOfGoods;

	@XmlElementWrapper(name = "AnanyticalRequiredList")
	@XmlElement(name = "Ananytical")
	private List<TbdAnanytical04> lstAnanytical;

	@XmlTransient
	private Long ananyticalCheckedListId;

	@XmlTransient
	private String maHoSo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeOfGoods() {
		return codeOfGoods;
	}

	public void setCodeOfGoods(String codeOfGoods) {
		this.codeOfGoods = codeOfGoods;
	}

	public String getNameOfGoods() {
		return nameOfGoods;
	}

	public void setNameOfGoods(String nameOfGoods) {
		this.nameOfGoods = nameOfGoods;
	}

	public List<TbdAnanytical04> getLstAnanytical() {
		return lstAnanytical;
	}

	public void setLstAnanytical(List<TbdAnanytical04> lstAnanytical) {
		this.lstAnanytical = lstAnanytical;
	}

	public Long getAnanyticalCheckedListId() {
		return ananyticalCheckedListId;
	}

	public void setAnanyticalCheckedListId(Long ananyticalCheckedListId) {
		this.ananyticalCheckedListId = ananyticalCheckedListId;
	}

	public String getMaHoSo() {
		return maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
}