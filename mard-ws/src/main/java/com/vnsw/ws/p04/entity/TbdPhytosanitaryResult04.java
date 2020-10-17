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
@XmlType(name = "PhytosanitaryResult")
public class TbdPhytosanitaryResult04 {

    @XmlTransient
    private Long phytosanitaryResultId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "Importer")
    private String importer;
    @XmlElement(name = "ImporterAddress")
    private String importerAddress;
    @XmlElement(name = "Phone")
    private String phone;
    @XmlElement(name = "Base")
    private TbdBase04 canCu;
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
    @XmlElement(name = "TransportType")
    private String transportType;
    @XmlElement(name = "Departure")
    private String departure;
    @XmlElement(name = "Destination")
    private String destination;
    @XmlElement(name = "Certificate")
    private TbdCertificate04 chungNhan;
    @XmlElement(name = "Regulation")
    private TbdRegulation04 quyDinh;
    @XmlElement(name = "Reported")
    private Long reported;
    @XmlElement(name = "ReportNo")
    private String reportNo;
    @XmlElement(name = "ReportDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date reportDate;
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

    public TbdPhytosanitaryResult04() {
    }

    public TbdPhytosanitaryResult04(Long phytosanitaryResultId) {
        this.phytosanitaryResultId = phytosanitaryResultId;
    }

    public Long getPhytosanitaryResultId() {
        return phytosanitaryResultId;
    }

    public void setPhytosanitaryResultId(Long phytosanitaryResultId) {
        this.phytosanitaryResultId = phytosanitaryResultId;
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

    public String getImporterAddress() {
        return importerAddress;
    }

    public void setImporterAddress(String importerAddress) {
        this.importerAddress = importerAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getReported() {
        return reported;
    }

    public void setReported(Long reported) {
        this.reported = reported;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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

    public TbdBase04 getCanCu() {
        return canCu;
    }

    public void setCanCu(TbdBase04 canCu) {
        this.canCu = canCu;
    }

    public TbdCertificate04 getChungNhan() {
        return chungNhan;
    }

    public void setChungNhan(TbdCertificate04 chungNhan) {
        this.chungNhan = chungNhan;
    }

    public TbdRegulation04 getQuyDinh() {
        return quyDinh;
    }

    public void setQuyDinh(TbdRegulation04 quyDinh) {
        this.quyDinh = quyDinh;
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
