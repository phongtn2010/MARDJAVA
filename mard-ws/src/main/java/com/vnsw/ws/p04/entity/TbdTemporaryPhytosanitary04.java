/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporaryPhytosanitary")
public class TbdTemporaryPhytosanitary04 {

    @XmlTransient
    private Long temporaryPhytosanitaryId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "Importer")
    private String importer;
    @XmlElement(name = "ImporterPhone")
    private String importerPhone;
    @XmlElement(name = "ImporterAddress")
    private String importerAddress;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdGoodslist> HangHoa;
    @XmlElement(name = "TotalQuantity")
    private String totalQuantity;
    @XmlElement(name = "TotalQuantityByChar")
    private String totalQuantityByChar;
    @XmlElement(name = "TotalGrossWeight")
    private String totalGrossWeight;
    @XmlElement(name = "TotalGrossWeightByChar")
    private String totalGrossWeightByChar;
    @XmlElement(name = "LocationOfStorage")
    private String locationOfStorage;
    @XmlElement(name = "InspectionDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date inspectionDate;
    @XmlElement(name = "QuarantineResults")
    private String quarantineResults;
    @XmlElement(name = "TemporaryCertificate")
    private TbdTemporaryCertificate04 bienphap;
    @XmlElement(name = "EffectiveDateFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date effectiveDateFrom;
    @XmlElement(name = "EffectiveDateTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date effectiveDateTo;
    @XmlElement(name = "DispatchNo")
    private String dispatchNo;
    @XmlElement(name = "DepartmentLisenceName")
    private String departmentLisenceName;
    @XmlElement(name = "DepartmentSuperiorName")
    private String departmentSuperiorName;
    @XmlElement(name = "SignConfirmDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date signConfirmDate;
    @XmlElement(name = "SignConfirmName")
    private String signConfirmName;
    @XmlElement(name = "SignConfirmAddress")
    private String signConfirmAddress;
    @XmlElement(name = "LinkFile")
    private String linkFile;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdTemporaryPhytosanitary04() {
    }

    public TbdTemporaryPhytosanitary04(Long temporaryPhytosanitaryId) {
        this.temporaryPhytosanitaryId = temporaryPhytosanitaryId;
    }

    public Long getTemporaryPhytosanitaryId() {
        return temporaryPhytosanitaryId;
    }

    public void setTemporaryPhytosanitaryId(Long temporaryPhytosanitaryId) {
        this.temporaryPhytosanitaryId = temporaryPhytosanitaryId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getImporterPhone() {
        return importerPhone;
    }

    public void setImporterPhone(String importerPhone) {
        this.importerPhone = importerPhone;
    }

    public String getImporterAddress() {
        return importerAddress;
    }

    public void setImporterAddress(String importerAddress) {
        this.importerAddress = importerAddress;
    }

    public String getLocationOfStorage() {
        return locationOfStorage;
    }

    public void setLocationOfStorage(String locationOfStorage) {
        this.locationOfStorage = locationOfStorage;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getQuarantineResults() {
        return quarantineResults;
    }

    public void setQuarantineResults(String quarantineResults) {
        this.quarantineResults = quarantineResults;
    }

    public Date getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    public void setEffectiveDateFrom(Date effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    public Date getEffectiveDateTo() {
        return effectiveDateTo;
    }

    public void setEffectiveDateTo(Date effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }

    public String getDispatchNo() {
        return dispatchNo;
    }

    public void setDispatchNo(String dispatchNo) {
        this.dispatchNo = dispatchNo;
    }

    public Date getSignConfirmDate() {
        return signConfirmDate;
    }

    public void setSignConfirmDate(Date signConfirmDate) {
        this.signConfirmDate = signConfirmDate;
    }

    public String getSignConfirmName() {
        return signConfirmName;
    }

    public void setSignConfirmName(String signConfirmName) {
        this.signConfirmName = signConfirmName;
    }

    public String getSignConfirmAddress() {
        return signConfirmAddress;
    }

    public void setSignConfirmAddress(String signConfirmAddress) {
        this.signConfirmAddress = signConfirmAddress;
    }

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<TbdGoodslist> getHangHoa() {
        return HangHoa;
    }

    public void setHangHoa(List<TbdGoodslist> HangHoa) {
        this.HangHoa = HangHoa;
    }

    public TbdTemporaryCertificate04 getBienphap() {
        return bienphap;
    }

    public void setBienphap(TbdTemporaryCertificate04 bienphap) {
        this.bienphap = bienphap;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTotalQuantityByChar() {
        return totalQuantityByChar;
    }

    public void setTotalQuantityByChar(String totalQuantityByChar) {
        this.totalQuantityByChar = totalQuantityByChar;
    }

    public String getTotalGrossWeight() {
        return totalGrossWeight;
    }

    public void setTotalGrossWeight(String totalGrossWeight) {
        this.totalGrossWeight = totalGrossWeight;
    }

    public String getTotalGrossWeightByChar() {
        return totalGrossWeightByChar;
    }

    public void setTotalGrossWeightByChar(String totalGrossWeightByChar) {
        this.totalGrossWeightByChar = totalGrossWeightByChar;
    }

    public String getDepartmentLisenceName() {
        return departmentLisenceName;
    }

    public void setDepartmentLisenceName(String departmentLisenceName) {
        this.departmentLisenceName = departmentLisenceName;
    }

    public String getDepartmentSuperiorName() {
        return departmentSuperiorName;
    }

    public void setDepartmentSuperiorName(String departmentSuperiorName) {
        this.departmentSuperiorName = departmentSuperiorName;
    }

}
