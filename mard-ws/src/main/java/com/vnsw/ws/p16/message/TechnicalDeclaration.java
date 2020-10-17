package com.vnsw.ws.p16.message;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "TechnicalDeclaration")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiSortDeclaration", "fiNameOfGoodsDeclaration", "fiNameSicenceOfGoodsDeclaration",
		"fiDescription", "fiPartUsed", "fiUsingValue", "fiOtherValueSpecified", "fiRequiredEcological",
		"fiPlantingSeason", "fiDensity", "fiMainDiseases", "fiWarnings" })
public class TechnicalDeclaration {
	public TechnicalDeclaration() {
	}

	@XmlElement(name = "Sort", required = true)
	private Integer fiSortDeclaration;
	@XmlElement(name = "NameOfGoodsDeclaration", required = true)
	private String fiNameOfGoodsDeclaration;
	@XmlElement(name = "NameSicenceOfGoodsDeclaration", required = true)
	private String fiNameSicenceOfGoodsDeclaration;
	@XmlElement(name = "Description", required = true)
	private String fiDescription;
	@XmlElement(name = "PartUsed", required = true)
	private String fiPartUsed;
	@XmlElement(name = "UsingValue", required = true)
	private String fiUsingValue;
	@XmlElement(name = "OtherValueSpecified", required = true)
	private String fiOtherValueSpecified;
	@XmlElement(name = "RequiredEcological", required = true)
	private String fiRequiredEcological;
	@XmlElement(name = "PlantingSeason", required = true)
	private String fiPlantingSeason;
	@XmlElement(name = "Density", required = true)
	private String fiDensity;
	@XmlElement(name = "MainDiseases", required = true)
	private String fiMainDiseases;
	@XmlElement(name = "Warnings", required = true)
	private String fiWarnings;

	public Integer getFiSortDeclaration() {
		return fiSortDeclaration;
	}

	public void setFiSortDeclaration(Integer fiSortDeclaration) {
		this.fiSortDeclaration = fiSortDeclaration;
	}

	public String getFiNameOfGoodsDeclaration() {
		return fiNameOfGoodsDeclaration;
	}

	public void setFiNameOfGoodsDeclaration(String fiNameOfGoodsDeclaration) {
		this.fiNameOfGoodsDeclaration = fiNameOfGoodsDeclaration;
	}

	public String getFiNameSicenceOfGoodsDeclaration() {
		return fiNameSicenceOfGoodsDeclaration;
	}

	public void setFiNameSicenceOfGoodsDeclaration(String fiNameSicenceOfGoodsDeclaration) {
		this.fiNameSicenceOfGoodsDeclaration = fiNameSicenceOfGoodsDeclaration;
	}

	public String getFiDescription() {
		return fiDescription;
	}

	public void setFiDescription(String fiDescription) {
		this.fiDescription = fiDescription;
	}

	public String getFiPartUsed() {
		return fiPartUsed;
	}

	public void setFiPartUsed(String fiPartUsed) {
		this.fiPartUsed = fiPartUsed;
	}

	public String getFiUsingValue() {
		return fiUsingValue;
	}

	public void setFiUsingValue(String fiUsingValue) {
		this.fiUsingValue = fiUsingValue;
	}

	public String getFiOtherValueSpecified() {
		return fiOtherValueSpecified;
	}

	public void setFiOtherValueSpecified(String fiOtherValueSpecified) {
		this.fiOtherValueSpecified = fiOtherValueSpecified;
	}

	public String getFiRequiredEcological() {
		return fiRequiredEcological;
	}

	public void setFiRequiredEcological(String fiRequiredEcological) {
		this.fiRequiredEcological = fiRequiredEcological;
	}

	public String getFiPlantingSeason() {
		return fiPlantingSeason;
	}

	public void setFiPlantingSeason(String fiPlantingSeason) {
		this.fiPlantingSeason = fiPlantingSeason;
	}

	public String getFiDensity() {
		return fiDensity;
	}

	public void setFiDensity(String fiDensity) {
		this.fiDensity = fiDensity;
	}

	public String getFiMainDiseases() {
		return fiMainDiseases;
	}

	public void setFiMainDiseases(String fiMainDiseases) {
		this.fiMainDiseases = fiMainDiseases;
	}

	public String getFiWarnings() {
		return fiWarnings;
	}

	public void setFiWarnings(String fiWarnings) {
		this.fiWarnings = fiWarnings;
	}

	@Override
	public String toString() {
		return "TechnicalDeclaration{" + "fiSortDeclaration='" + fiSortDeclaration + '\''
				+ ", fiNameOfGoodsDeclaration='" + fiNameOfGoodsDeclaration + '\''
				+ ", fiNameSicenceOfGoodsDeclaration='" + fiNameSicenceOfGoodsDeclaration + '\'' + ", fiDescription='"
				+ fiDescription + '\'' + ", fiPartUsed='" + fiPartUsed + '\'' + ", fiUsingValue='" + fiUsingValue + '\''
				+ ", fiOtherValueSpecified='" + fiOtherValueSpecified + '\'' + ", fiRequiredEcological='"
				+ fiRequiredEcological + '\'' + ", fiPlantingSeason='" + fiPlantingSeason + '\'' + ", fiDensity='"
				+ fiDensity + '\'' + ", fiMainDiseases='" + fiMainDiseases + '\'' + ", fiWarnings='" + fiWarnings + '\''
				+ '}';
	}
}
