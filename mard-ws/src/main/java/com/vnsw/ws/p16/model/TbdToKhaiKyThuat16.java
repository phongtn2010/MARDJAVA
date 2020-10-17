package com.vnsw.ws.p16.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TbdToKhaiKyThuat16 {
    private static final long serialVersionUID = 1L;
    private Long fiId;
    private Long fiIdHoSo;
    private Integer fiSortDeclaration;
    private String fiNameOfGoodsDeclaration;
    private String fiNameSicenceOfGoodsDeclaration;
    private String fiDescription;
    private String fiPartUsed;
    private String fiUsingValue;
    private String fiOtherValueSpecified;
    private String fiRequiredEcological;
    private String fiPlantingSeason;
    private String fiDensity;
    private String fiMainDiseases ;
    private String fiWarnings;

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

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
        return "TbdToKhaiKyThuat16{" +
                "fiId=" + fiId +
                ", fiIdHoSo=" + fiIdHoSo +
                ", fiSortDeclaration=" + fiSortDeclaration +
                ", fiNameOfGoodsDeclaration='" + fiNameOfGoodsDeclaration + '\'' +
                ", fiNameSicenceOfGoodsDeclaration='" + fiNameSicenceOfGoodsDeclaration + '\'' +
                ", fiDescription='" + fiDescription + '\'' +
                ", fiPartUsed='" + fiPartUsed + '\'' +
                ", fiUsingValue='" + fiUsingValue + '\'' +
                ", fiOtherValueSpecified='" + fiOtherValueSpecified + '\'' +
                ", fiRequiredEcological='" + fiRequiredEcological + '\'' +
                ", fiPlantingSeason='" + fiPlantingSeason + '\'' +
                ", fiDensity='" + fiDensity + '\'' +
                ", fiMainDiseases='" + fiMainDiseases + '\'' +
                ", fiWarnings='" + fiWarnings + '\'' +
                '}';
    }
}
