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
@XmlType(name = "QualityResult")
public class TbdQualityResult04 {

    @XmlTransient
    private Long qualityResultId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "RegistrationProfileNo")
    private String registrationProfileNo;
    @XmlElement(name = "QuanlityCerNo")
    private String quanlityCerNo;
    @XmlElement(name = "DepartmentCode")
    private String departmentCode;
    @XmlElement(name = "DepartmentName")
    private String departmentName;
    @XmlElement(name = "DepartmentAddress")
    private String departmentAddress;
    @XmlElement(name = "DepartmentPhone")
    private String departmentPhone;
    @XmlElement(name = "DepartmentFax")
    private String departmentFax;
    @XmlElement(name = "SellerName")
    private String sellerName;
    @XmlElement(name = "SellerAddress")
    private String sellerAddress;
    @XmlElement(name = "SellerPhone")
    private String sellerPhone;
    @XmlElement(name = "SellerFax")
    private String sellerFax;
    @XmlElement(name = "PortOfDepartureName")
    private String portOfDepartureName;
    @XmlElement(name = "BuyerName")
    private String buyerName;
    @XmlElement(name = "BuyerAddress")
    private String buyerAddress;
    @XmlElement(name = "BuyerPhone")
    private String buyerPhone;
    @XmlElement(name = "BuyerFax")
    private String buyerFax;
    @XmlElement(name = "PortOfDestinationCode")
    private String portOfDestinationCode;
    @XmlElement(name = "PortOfDestinationName")
    private String portOfDestinationName;
    @XmlElement(name = "CriteriaTestingNo")
    private String criteriaTestingNo;
    @XmlElement(name = "CriteriaTestingDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date criteriaTestingDate;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdGoodslist> tbdGoodslist;
    @XmlElement(name = "SignResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date signResultDate;
    @XmlElement(name = "SignResultName")
    private String signResultName;
    @XmlElement(name = "SignResultAddress")
    private String signResultAddress;
    @XmlElement(name = "LinkFile")
    private String linkFile;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdQualityResult04() {
    }

    public TbdQualityResult04(Long qualityResultId) {
        this.qualityResultId = qualityResultId;
    }

    public Long getQualityResultId() {
        return qualityResultId;
    }

    public void setQualityResultId(Long qualityResultId) {
        this.qualityResultId = qualityResultId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public String getRegistrationProfileNo() {
        return registrationProfileNo;
    }

    public void setRegistrationProfileNo(String registrationProfileNo) {
        this.registrationProfileNo = registrationProfileNo;
    }

    public String getQuanlityCerNo() {
        return quanlityCerNo;
    }

    public void setQuanlityCerNo(String quanlityCerNo) {
        this.quanlityCerNo = quanlityCerNo;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public String getDepartmentFax() {
        return departmentFax;
    }

    public void setDepartmentFax(String departmentFax) {
        this.departmentFax = departmentFax;
    }

    public Date getCriteriaTestingDate() {
        return criteriaTestingDate;
    }

    public void setCriteriaTestingDate(Date criteriaTestingDate) {
        this.criteriaTestingDate = criteriaTestingDate;
    }

    public Date getSignResultDate() {
        return signResultDate;
    }

    public void setSignResultDate(Date signResultDate) {
        this.signResultDate = signResultDate;
    }

    public String getSignResultName() {
        return signResultName;
    }

    public void setSignResultName(String signResultName) {
        this.signResultName = signResultName;
    }

    public String getSignResultAddress() {
        return signResultAddress;
    }

    public void setSignResultAddress(String signResultAddress) {
        this.signResultAddress = signResultAddress;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerFax() {
        return sellerFax;
    }

    public void setSellerFax(String sellerFax) {
        this.sellerFax = sellerFax;
    }

    public String getPortOfDepartureName() {
        return portOfDepartureName;
    }

    public void setPortOfDepartureName(String portOfDepartureName) {
        this.portOfDepartureName = portOfDepartureName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerFax() {
        return buyerFax;
    }

    public void setBuyerFax(String buyerFax) {
        this.buyerFax = buyerFax;
    }

    public String getPortOfDestinationCode() {
        return portOfDestinationCode;
    }

    public void setPortOfDestinationCode(String portOfDestinationCode) {
        this.portOfDestinationCode = portOfDestinationCode;
    }

    public String getPortOfDestinationName() {
        return portOfDestinationName;
    }

    public void setPortOfDestinationName(String portOfDestinationName) {
        this.portOfDestinationName = portOfDestinationName;
    }

    public String getCriteriaTestingNo() {
        return criteriaTestingNo;
    }

    public void setCriteriaTestingNo(String criteriaTestingNo) {
        this.criteriaTestingNo = criteriaTestingNo;
    }

    public List<TbdGoodslist> getTbdGoodslist() {
        return tbdGoodslist;
    }

    public void setTbdGoodslist(List<TbdGoodslist> tbdGoodslist) {
        this.tbdGoodslist = tbdGoodslist;
    }

}
