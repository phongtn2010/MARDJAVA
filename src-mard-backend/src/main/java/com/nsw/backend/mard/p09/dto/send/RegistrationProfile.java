package com.nsw.backend.mard.p09.dto.send;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p09.model.Tbdbenmua09;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegistrationProfile {
    private static final long serialVersionUID = 1L;

    private Long fiRegistrationType;
    private Long fiProductType;
    private String fiTaxCode;
    //
    private String fiNSWFileCode;
    private String fiRegistrationNo;
    private String fiNameOfRegistration;
    private String fiAddressOfRegistration;
    private String fiPhone;
    private String fiEmail;
    private String fiRegistrationComfirmNo;
    private String fiQuarantineDepartmentNameCode;
    private String fiQuarantineDepartmentName;
    private String fiMonitoringDepartmentNameCode;
    private String fiMonitoringDepartmentName;

    private List<Seller> fiSellerList;

    private String fiBuyerName;

    private String fiBuyerIdentityNo;
    private Date fiBuyerDateOfIdentity;
    private String fiBuyerPlaceOfIdentity;
    private String fiBuyerAddress;
    private String fiBuyerPhone;
    private String fiBuyerFax;

    private String fiPortOfDestinationCode;
    private String fiPortOfDestinationName;

    private String fiBillOfLadingNo;
    private Date fiBillOfLadingIssuedDate;

    private Date fiImportingDateFrom;
    private Date fiImportingDateTo;

    private List<Goods> fiGoodsList;

    private String fiMealPurpose;
    private String fiQuarantineNo;

    private List<Manufacturer> fiManufactureList;

    private String fiLocationOfStorage;
    private Date fiDateOfSamplingFrom;
    private Date fiDateOfSamplingTo;
    private String fiLocationOfSampling;
    private String fiContactPerson;
    private String fiContactName;
    private String fiContactAddress;
    private String fiContactTel;
    private String fiContactEmail;

    private String fiSignAddress;
    private Date fiSignDate;
    private String fiSignName;
    private String fiSignPosition;

    private List<Document> fiDocumentList;
    private List<Attachment> fiAttachmentList;

    //Mau 3
    private List<Company> fiCompanyList;
    private List<LocationQuarantine> fiLocationQuarantineList;

    private String fiQuarantineName;
    private String fiQuarantineTime;
    private Date fiQuarantineTimeFrom;
    private Date fiQuarantineTimeTo;
    private String fiExportPortOfDestinationCode;
    private String fiExportPortOfDestinationName;
    private String fiExportCountryCode;
    private String fiExportCountryName;
    private String fiImportCountryCode;
    private String fiImportCountryName;

    private String fiTransportType;
    private String fiDispatchNo;
    private String fiMonitoringLocationName;
    private Date fiMonitoringLocationTimeFrom;
    private Date fiMonitoringLocationTimeTo;
    private String fiCertificateQuantity;
    private String fiContractNo;
    private String fiImportContactPerson;
    private String fiExportContactPerson;

    private RegistrationProfile() {
        this.fiGoodsList = new ArrayList<>();
        this.fiManufactureList = new ArrayList<>();
        this.fiAttachmentList = new ArrayList<>();
        this.fiCompanyList = new ArrayList<>();
        this.fiDocumentList = new ArrayList<>();
        this.fiSellerList = new ArrayList<>();
        this.fiLocationQuarantineList = new ArrayList<>();
    }

    public static RegistrationProfile parse(Tbdhoso09 regProfile) {
        RegistrationProfile dto = new RegistrationProfile();
        regProfile.initEmptyCollectionsIfNull();
        BeanUtils.copyProperties(regProfile, dto);
        dto.setFiNSWFileCode(regProfile.getFiHSCode());
        dto.setFiRegistrationType(regProfile.getFiHSType());
        dto.setFiQuarantineDepartmentNameCode(regProfile.getFiQuarantineDepartmentCode());
        dto.setFiQuarantineDepartmentName(regProfile.getFiQuarantineDepartmentName());
        dto.setFiMonitoringDepartmentNameCode(regProfile.getFiMonitoringDepartmentCode());
        dto.setFiMonitoringDepartmentName(regProfile.getFiMonitoringDepartmentName());
        dto.setFiMealPurpose(regProfile.getFiPurpose());
        dto.setFiMealPurpose(regProfile.getFiPurpose());
        dto.setFiDispatchNo(regProfile.getFiAccQuarantineDoc());
        dto.setFiQuarantineNo(regProfile.getFiAccQuarantineDoc());
        dto.setFiExportPortOfDestinationCode(regProfile.getFiExportPortDestCode());
        dto.setFiExportPortOfDestinationName(regProfile.getFiExportPortDestName());
        dto.setFiSignAddress(regProfile.getFiSigningLocation());
        dto.setFiSignDate(regProfile.getFiSignedDate());
        dto.setFiSignName(regProfile.getFiSignedBy());
        dto.setFiSignPosition(regProfile.getFiSignedByTitle());
        if(StringUtils.isEmpty(dto.getFiExportCountryName())) {
            dto.setFiExportCountryName(CmonHelper.instance().findCountryByCode(dto.getFiExportCountryCode()).getCountryname());
        }
        if(StringUtils.isEmpty(dto.getFiImportCountryName())) {
            dto.setFiImportCountryName(CmonHelper.instance().findCountryByCode(dto.getFiImportCountryCode()).getCountryname());
        }
        dto.setFiBillOfLadingNo(regProfile.getFiBillOfLadingNo());
        dto.setFiBillOfLadingIssuedDate(regProfile.getFiBillOfLadingIssuedDate());
        if (regProfile.getFiBuyer() != null) {
            dto.setFiBuyer(regProfile.getFiBuyer());
        }

        dto.setFiLocationOfStorage(regProfile.getFiStorageLocation());
        dto.setFiDateOfSamplingFrom(regProfile.getFiSamplingDateFrom());
        dto.setFiDateOfSamplingTo(regProfile.getFiSamplingDateTo());
        dto.setFiLocationOfSampling(regProfile.getFiSamplingLocation());
        dto.setFiContactName(StringUtils.isEmpty(regProfile.getFiContactName())? "" : regProfile.getFiContactName());
        dto.setFiContactAddress(StringUtils.isEmpty(regProfile.getFiContactAddress())? "" : regProfile.getFiContactAddress());
        dto.setFiContactTel(StringUtils.isEmpty(regProfile.getFiContactTel())? "" : regProfile.getFiContactTel());
        dto.setFiContactEmail(StringUtils.isEmpty(regProfile.getFiContactEmail())? "" : regProfile.getFiContactEmail());

        StringBuilder contactPerson = new StringBuilder();
        if(StringUtils.isNotEmpty(dto.getFiContactName()) ) contactPerson.append(dto.getFiContactName());
        if(StringUtils.isNotEmpty(dto.getFiContactAddress())) contactPerson.append(", ").append(dto.getFiContactAddress());
        if(StringUtils.isNotEmpty(dto.getFiContactTel())) contactPerson.append(", ").append(dto.getFiContactTel());
        if(StringUtils.isNotEmpty(dto.getFiContactEmail())) contactPerson.append(", ").append(dto.getFiContactEmail());

        dto.setFiContactPerson(contactPerson.toString());
        dto.setFiQuarantineName(regProfile.getFiQuarantineName());
        dto.setFiMonitoringLocationName(regProfile.getFiMonitoringLocName());
        dto.setFiMonitoringLocationTimeFrom(regProfile.getFiMonitoringLocTimeFrom());
        dto.setFiMonitoringLocationTimeTo(regProfile.getFiMonitoringLocTimeTo());
        regProfile.getLstGood().forEach(goods -> {
            Goods dtoGoods = new Goods();
            BeanUtils.copyProperties(goods, dtoGoods);
            dtoGoods.setFiCodeOfGoods(goods.getFiProductCode());
            dtoGoods.setFiNameOfGoods(goods.getFiProductName());
            dtoGoods.setFiNameSicenceOfGoods(goods.getFiProductScienceName());
            dtoGoods.setFiAnimalQuantityFemale(goods.getFiQuantityFemale());
            dtoGoods.setFiAnimalQuantityMale(goods.getFiQuantityMale());
            dtoGoods.setFiAge(goods.getFiAge());
            dtoGoods.setFiWayOfPackinglist(goods.getFiPackingWay());
            dtoGoods.setFiQuantityOrVolumn(goods.getFiNumber());
            dtoGoods.setFiQuantityUnitCode(goods.getFiUnitCode());
            dtoGoods.setFiQuantityUnitName(goods.getFiUnitName());
            dtoGoods.setFiNetWeight(goods.getFiNetWeight());
            dtoGoods.setFiNetWeightUnitCode(goods.getFiNWUnitCode());
            dtoGoods.setFiNetWeightUnitName(goods.getFiNWUnitName());
            dtoGoods.setFiGrossWeight(goods.getFiGrossWeight());
            dtoGoods.setFiGrossWeightUnitCode(goods.getFiGWUnitCode());
            dtoGoods.setFiGrossWeightUnitName(goods.getFiGWUnitName());
            dtoGoods.setFiRegistrationNo(goods.getFiCirculateNo());
            dtoGoods.setFiOriginationCode(goods.getFiCountryOrigin());
            dtoGoods.setFiOriginationName(goods.getFiCountryOriginName());
            dtoGoods.setFiImportPortOfDestinationCode(goods.getFiImportPortDestCode());
            dtoGoods.setFiImportPortOfDestinationName(goods.getFiImportPortOfDestName());
            dto.getFiGoodsList().add(dtoGoods);
        });

        regProfile.getLstProdMfr().forEach(mfr -> {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setFiManufacturerAddress(mfr.getFiCompanyAddress());
            manufacturer.setFiManufacturerName(mfr.getFiCompanyName());
            dto.getFiManufactureList().add(manufacturer);
        });

        regProfile.getLstAtch().forEach(atch -> {
            Attachment attachment = new Attachment();
            attachment.setFiAttachmentId(atch.getFiGuid());
            attachment.setFiAttachmentName(atch.getFiTenTep());
            attachment.setFiAttachmentTypeCode(atch.getFiMaLoai());
            attachment.setFiAttachmentTypeName(atch.getFiTenLoai());
            attachment.setFiLinkFile(atch.getFiDuongDan());
            dto.getFiAttachmentList().add(attachment);
        });


        regProfile.getLstDocument().forEach(doc -> {
            Document dtoDoc = new Document();
            dtoDoc.setFiTypeDoc(doc.getFiTypeDoc());
            dtoDoc.setFiDate(doc.getFiDate());
            dtoDoc.setFiNumber(doc.getFiNumber());
            dtoDoc.setFiBillNo(doc.getFiBillNo());
            dto.getFiDocumentList().add(dtoDoc);
        });


        regProfile.getLstIsolatedLocation().forEach(isoLoc -> {
            LocationQuarantine quarLoc = new LocationQuarantine();
            quarLoc.setFiLocationQuarantineAddress(isoLoc.getFiIsoLocAddress());
            quarLoc.setFiLocationQuarantineName(isoLoc.getFiIsoLocName());
            dto.getFiLocationQuarantineList().add(quarLoc);
        });

        regProfile.getLstExporter().forEach(exporter -> {
            Company dtoCompany = new Company();
            dtoCompany.setFiCompanyAddress(exporter.getFiExporterAddress());
            dtoCompany.setFiCompanyName(exporter.getFiExporterName());
            dto.getFiCompanyList().add(dtoCompany);
        });
        regProfile.getLstSeller().forEach(seller -> {
            Seller dtoSeller = new Seller();
            dtoSeller.setFiPortOfDepartureName(seller.getFiPortOfDepartureName());
            dtoSeller.setFiSellerAddress(seller.getFiSellerAddress());
            dtoSeller.setFiSellerFax(seller.getFiSellerFax());
            dtoSeller.setFiSellerStateCode(seller.getFiSellerStateCode());
            dtoSeller.setFiSellerStateName(seller.getFiSellerName() + ", " + seller.getFiSellerStateName());
            dtoSeller.setFiSellerPhone(seller.getFiSellerPhone());
            dtoSeller.setFiSellerName(seller.getFiSellerName());
            dto.getFiSellerList().add(dtoSeller);
        });

        return dto;
    }

    private void setFiBuyer(Tbdbenmua09 buyer) {
        this.fiImportingDateFrom = buyer.getFiImportingDateFrom();
        this.fiImportingDateTo = buyer.getFiImportingDateTo();
        this.fiBuyerName = buyer.getFiBuyerName();
        this.fiBuyerAddress = buyer.getFiBuyerAddress();
        this.fiBuyerPhone = buyer.getFiBuyerTel();
        this.fiBuyerFax = buyer.getFiBuyerFax();
        this.fiBuyerIdentityNo = buyer.getFiBuyerIdentityNo();
        this.fiBuyerDateOfIdentity = buyer.getFiBuyerDateOfIdentity();
        this.fiBuyerPlaceOfIdentity = buyer.getFiBuyerPlaceOfIdentity();
        this.fiPortOfDestinationCode = buyer.getFiPortOfDestinationCode();
        this.fiPortOfDestinationName = buyer.getFiPortOfDestinationName();
        this.fiBillOfLadingNo = buyer.getFiLadingBill();
        this.fiBillOfLadingIssuedDate = buyer.getFiLadingBillDate();
    }
}
