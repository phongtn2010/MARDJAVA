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
@XmlType(name = "PhytosanitaryDetain")
public class TbdPhytosanitaryDetain04 {

    @XmlTransient
    private Long phytosanitaryId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "RegistrationComfirmNo")
    private String registrationComfirmNo;
    @XmlElement(name = "ImporterName")
    private String importerName;
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
    @XmlElement(name = "Importer")
    private String importer;
    @XmlElement(name = "ImporterAddress")
    private String importerAddress;
    @XmlElement(name = "Receiver")
    private String receiver;
    @XmlElement(name = "ReceiverAddress")
    private String receiverAddress;
    @XmlElement(name = "TransportType")
    private String transportType;
    @XmlElement(name = "NationalityTransportCode")
    private Long nationalityTransportCode;
    @XmlElement(name = "NationalityTransportName")
    private String nationalityTransportName;
    @XmlElement(name = "DangerousPest")
    private String dangerousPest;
    @XmlElement(name = "TreatmentMeasures")
    private TbdTreatmentMeasures04 bienphap;
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
    private Long registrationProfileId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdPhytosanitaryDetain04() {
    }

    public TbdPhytosanitaryDetain04(Long phytosanitaryId) {
        this.phytosanitaryId = phytosanitaryId;
    }

    public Long getPhytosanitaryId() {
        return phytosanitaryId;
    }

    public void setPhytosanitaryId(Long phytosanitaryId) {
        this.phytosanitaryId = phytosanitaryId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public String getRegistrationComfirmNo() {
        return registrationComfirmNo;
    }

    public void setRegistrationComfirmNo(String registrationComfirmNo) {
        this.registrationComfirmNo = registrationComfirmNo;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getImporterAddress() {
        return importerAddress;
    }

    public void setImporterAddress(String importerAddress) {
        this.importerAddress = importerAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Long getNationalityTransportCode() {
        return nationalityTransportCode;
    }

    public void setNationalityTransportCode(Long nationalityTransportCode) {
        this.nationalityTransportCode = nationalityTransportCode;
    }

    public String getNationalityTransportName() {
        return nationalityTransportName;
    }

    public void setNationalityTransportName(String nationalityTransportName) {
        this.nationalityTransportName = nationalityTransportName;
    }

    public String getDangerousPest() {
        return dangerousPest;
    }

    public void setDangerousPest(String dangerousPest) {
        this.dangerousPest = dangerousPest;
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

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
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

    public TbdTreatmentMeasures04 getBienphap() {
        return bienphap;
    }

    public void setBienphap(TbdTreatmentMeasures04 bienphap) {
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
