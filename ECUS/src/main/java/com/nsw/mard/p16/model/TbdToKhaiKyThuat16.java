package com.nsw.mard.p16.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TbdToKhaiKyThuat16 {

    private Long fiId;

    @NotNull
    private Long fiIdHoSo;

    @NotNull
    private Integer fiSortDeclaration;

    @NotEmpty
    @NotNull
    @Size(max = 250)
    private String fiNameOfGoodsDeclaration;

    @NotEmpty
    @NotNull
    @Size(max = 250)
    private String fiNameSicenceOfGoodsDeclaration;

    @NotEmpty
    @NotNull
    @Size(max = 2000)
    private String fiDescription;

    @NotEmpty
    @NotNull
    @Size(max = 50)
    private String fiPartUsed;

    @NotEmpty
    @NotNull
    @Size(max = 50)
    private String fiUsingValue;

    @Size(max = 500)
    private String fiOtherValueSpecified;

    @NotEmpty
    @NotNull
    @Size(max = 2000)
    private String fiRequiredEcological;

    @NotEmpty
    @NotNull
    @Size(max = 2000)
    private String fiPlantingSeason;

    @NotEmpty
    @NotNull
    @Size(max = 2000)
    private String fiDensity;

    @NotEmpty
    @NotNull
    @Size(max = 2000)
    private String fiMainDiseases;

    @Size(max = 2000)
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
