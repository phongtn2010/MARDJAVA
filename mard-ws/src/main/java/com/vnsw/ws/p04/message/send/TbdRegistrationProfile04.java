/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

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
@XmlType(name = "RegistrationProfile")
public class TbdRegistrationProfile04 {

    @XmlTransient
    private Long registrationProfileId;
    @XmlElement(name = "NSWFileCode")
    private String nswfileCode;
    @XmlElement(name = "RegistrationComfirmNo")
    private String registrationComfirmNo;
    @XmlElement(name = "NameOfRegistration")
    private String nameOfRegistration;
    @XmlElement(name = "AddressOfRegistration")
    private String addressOfRegistration;
    @XmlElement(name = "Phone")
    private String phone;
    @XmlElement(name = "Email")
    private String email;
    @XmlElement(name = "TaxCode")
    private String taxCode;
    @XmlElement(name = "DepartmentCode")
    private String departmentCode;
    @XmlElement(name = "DepartmentName")
    private String departmentName;
    @XmlElement(name = "AssignCode")
    private String assignCode;
    @XmlElement(name = "AssignName")
    private String assignName;
    @XmlElement(name = "Seller")
    private String Seller;
    @XmlElement(name = "SellerName")
    private String sellerName;
    @XmlElement(name = "SellerStateCode")
    private String sellerStateCode;
    @XmlElement(name = "SellerStateName")
    private String sellerStateName;
    @XmlElement(name = "SellerAddress")
    private String sellerAddress;
    @XmlElement(name = "SellerPhone")
    private String sellerPhone;
    @XmlElement(name = "SellerFax")
    private String sellerFax;
    @XmlElement(name = "PortOfDepartureName")
    private String portOfDepartureName;
    @XmlElement(name = "Buyer")
    private String Buyer;
    @XmlElement(name = "BuyerName")
    private String buyerName;
    @XmlElement(name = "BuyerIdentityNo")
    private String buyerIdentityNo;
    @XmlElement(name = "BuyerDateOfIdentityNo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date buyerdateOfIdentityNo;
    @XmlElement(name = "BuyerPlaceOfIdentityNo")
    private String buyerplaceOfIdentityNo;
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
    @XmlElement(name = "ImportingFromDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date importingFromDate;
    @XmlElement(name = "ImportingToDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date importingToDate;
    @XmlElement(name = "TransportType")
    private String transportType;
    @XmlElement(name = "NationalityTransportCode")
    private String nationalityTransportCode;
    @XmlElement(name = "NationalityTransportName")
    private String nationalityTransportName;
    @XmlElement(name = "LocationOfStorage")
    private String locationOfStorage;
    @XmlElement(name = "DateOfSamplingFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date dateOfSamplingFrom;
    @XmlElement(name = "DateOfSamplingTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date dateOfSamplingTo;
    @XmlElement(name = "LocationOfSampling")
    private String locationOfSampling;
    @XmlElement(name = "ContactPerson")
    private String contactPerson;
    @XmlElement(name = "ContactAddress")
    private String contactAddress;
    @XmlElement(name = "ContactTel")
    private String contactTel;
    @XmlElement(name = "ContactEmail")
    private String contactEmail;
    @XmlElement(name = "PurposeUse")
    private String purposeUse;
    @XmlElement(name = "LicenseOfPhytosanitaryImportNo")
    private String licenseOfPhytosanitary;
    @XmlElement(name = "SignAddress")
    private String signAddress;
    @XmlElement(name = "SignDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date signDate;
    @XmlElement(name = "SignName")
    private String signName;
    @XmlElement(name = "SignPosition")
    private String signPosition;
    @XmlElement(name = "RegistrationType")
    private Long registrationType;
    @XmlElement(name = "FoodsType")
    private Long foodsType;
    @XmlElement(name = "InspectionType")
    private Long inspectionType;
    @XmlElement(name = "NoticeOfExemptionFromInspectionNo")
    private String noticeOfExemption;
    @XmlTransient
    private Long codeStatus;
    @XmlTransient
    private String nameStatus;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;
    @XmlTransient
    private Date updateDate;
    @XmlTransient
    private Date sendDate;
    @XmlTransient
    private Long feeStatus;
    @XmlTransient
    private Long isAnanyticalChecked;
    @XmlTransient
    private Long isReceived;
    @XmlTransient
    private Long isPhytosanitaryResult;
    @XmlTransient
    private Long isRegistration;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdGoods04> lstHangHoa04;
    @XmlElementWrapper(name = "DocumentList")
    @XmlElement(name = "Document")
    private List<TbdDocument04> lstHoaDon04;
    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<TbdAttachment04> lstTepTin04;

    public TbdRegistrationProfile04() {
    }

    public List<TbdGoods04> getLstHangHoa04() {
        return lstHangHoa04;
    }

    public void setLstHangHoa04(List<TbdGoods04> lstHangHoa04) {
        this.lstHangHoa04 = lstHangHoa04;
    }

    public List<TbdDocument04> getLstHoaDon04() {
        return lstHoaDon04;
    }

    public void setLstHoaDon04(List<TbdDocument04> lstHoaDon04) {
        this.lstHoaDon04 = lstHoaDon04;
    }

    public List<TbdAttachment04> getLstTepTin04() {
        return lstTepTin04;
    }

    public void setLstTepTin04(List<TbdAttachment04> lstTepTin04) {
        this.lstTepTin04 = lstTepTin04;
    }

    public TbdRegistrationProfile04(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public String getNswfileCode() {
        return nswfileCode;
    }

    public void setNswfileCode(String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public String getRegistrationComfirmNo() {
        return registrationComfirmNo;
    }

    public void setRegistrationComfirmNo(String registrationComfirmNo) {
        this.registrationComfirmNo = registrationComfirmNo;
    }

    public String getNameOfRegistration() {
        return nameOfRegistration;
    }

    public void setNameOfRegistration(String nameOfRegistration) {
        this.nameOfRegistration = nameOfRegistration;
    }

    public String getAddressOfRegistration() {
        return addressOfRegistration;
    }

    public void setAddressOfRegistration(String addressOfRegistration) {
        this.addressOfRegistration = addressOfRegistration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
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

    public String getAssignCode() {
        return assignCode;
    }

    public void setAssignCode(String assignCode) {
        this.assignCode = assignCode;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerStateCode() {
        return sellerStateCode;
    }

    public void setSellerStateCode(String sellerStateCode) {
        this.sellerStateCode = sellerStateCode;
    }

    public String getSellerStateName() {
        return sellerStateName;
    }

    public void setSellerStateName(String sellerStateName) {
        this.sellerStateName = sellerStateName;
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

    public String getBuyerIdentityNo() {
        return buyerIdentityNo;
    }

    public void setBuyerIdentityNo(String buyerIdentityNo) {
        this.buyerIdentityNo = buyerIdentityNo;
    }

    public Date getBuyerdateOfIdentityNo() {
        return buyerdateOfIdentityNo;
    }

    public void setBuyerdateOfIdentityNo(Date buyerdateOfIdentityNo) {
        this.buyerdateOfIdentityNo = buyerdateOfIdentityNo;
    }

    public String getBuyerplaceOfIdentityNo() {
        return buyerplaceOfIdentityNo;
    }

    public void setBuyerplaceOfIdentityNo(String buyerplaceOfIdentityNo) {
        this.buyerplaceOfIdentityNo = buyerplaceOfIdentityNo;
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

    public Date getImportingFromDate() {
        return importingFromDate;
    }

    public void setImportingFromDate(Date importingFromDate) {
        this.importingFromDate = importingFromDate;
    }

    public Date getImportingToDate() {
        return importingToDate;
    }

    public void setImportingToDate(Date importingToDate) {
        this.importingToDate = importingToDate;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getNationalityTransportCode() {
        return nationalityTransportCode;
    }

    public void setNationalityTransportCode(String nationalityTransportCode) {
        this.nationalityTransportCode = nationalityTransportCode;
    }

    public String getNationalityTransportName() {
        return nationalityTransportName;
    }

    public void setNationalityTransportName(String nationalityTransportName) {
        this.nationalityTransportName = nationalityTransportName;
    }

    public String getLocationOfStorage() {
        return locationOfStorage;
    }

    public void setLocationOfStorage(String locationOfStorage) {
        this.locationOfStorage = locationOfStorage;
    }

    public Date getDateOfSamplingFrom() {
        return dateOfSamplingFrom;
    }

    public void setDateOfSamplingFrom(Date dateOfSamplingFrom) {
        this.dateOfSamplingFrom = dateOfSamplingFrom;
    }

    public Date getDateOfSamplingTo() {
        return dateOfSamplingTo;
    }

    public void setDateOfSamplingTo(Date dateOfSamplingTo) {
        this.dateOfSamplingTo = dateOfSamplingTo;
    }

    public String getLocationOfSampling() {
        return locationOfSampling;
    }

    public void setLocationOfSampling(String locationOfSampling) {
        this.locationOfSampling = locationOfSampling;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPurposeUse() {
        return purposeUse;
    }

    public void setPurposeUse(String purposeUse) {
        this.purposeUse = purposeUse;
    }

    public String getLicenseOfPhytosanitary() {
        return licenseOfPhytosanitary;
    }

    public void setLicenseOfPhytosanitary(String licenseOfPhytosanitary) {
        this.licenseOfPhytosanitary = licenseOfPhytosanitary;
    }

    public String getSignAddress() {
        return signAddress;
    }

    public void setSignAddress(String signAddress) {
        this.signAddress = signAddress;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignPosition() {
        return signPosition;
    }

    public void setSignPosition(String signPosition) {
        this.signPosition = signPosition;
    }

    public Long getFoodsType() {
        return foodsType;
    }

    public void setFoodsType(Long foodsType) {
        this.foodsType = foodsType;
    }

    public Long getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(Long inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getNoticeOfExemption() {
        return noticeOfExemption;
    }

    public void setNoticeOfExemption(String noticeOfExemption) {
        this.noticeOfExemption = noticeOfExemption;
    }

    public Long getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(Long codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSeller() {
        return Seller;
    }

    public void setSeller(String Seller) {
        this.Seller = Seller;
    }

    public String getBuyer() {
        return Buyer;
    }

    public void setBuyer(String Buyer) {
        this.Buyer = Buyer;
    }

    public Long getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Long feeStatus) {
        this.feeStatus = feeStatus;
    }

    public Long getIsAnanyticalChecked() {
        return isAnanyticalChecked;
    }

    public void setIsAnanyticalChecked(Long isAnanyticalChecked) {
        this.isAnanyticalChecked = isAnanyticalChecked;
    }

    public Long getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Long isReceived) {
        this.isReceived = isReceived;
    }

    public Long getIsPhytosanitaryResult() {
        return isPhytosanitaryResult;
    }

    public void setIsPhytosanitaryResult(Long isPhytosanitaryResult) {
        this.isPhytosanitaryResult = isPhytosanitaryResult;
    }

    public Long getIsRegistration() {
        return isRegistration;
    }

    public void setIsRegistration(Long isRegistration) {
        this.isRegistration = isRegistration;
    }

    public Long getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(Long registrationType) {
        this.registrationType = registrationType;
    }

}
