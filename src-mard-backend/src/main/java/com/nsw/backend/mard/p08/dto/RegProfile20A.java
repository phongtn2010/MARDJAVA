package com.nsw.backend.mard.p08.dto;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p08.model.Tbdhanghoa08;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegProfile20A {
    private static final long serialVersionUID = 1L;

    private String fiPortOfDepartureName;

    private String fiBuyerName;
    private String fiBuyerIdentityNo;
    private Date fiBuyerDateOfIdentityNo;
    private String fiBuyerPlaceOfIdentityNo;
    private String fiBuyerAddress;
    private String fiBuyerPhone;
    private String fiBuyerFax;

    private String fiPortOfDestinationCode;
    private String fiPortOfDestinationName;

    private Date fiImportingFromDate;
    private Date fiImportingToDate;
    private String fiLocationOfStorage;
    private Date fiDateOfSamplingFrom;
    private Date fiDateOfSamplingTo;
    private String fiLocationOfSampling;

    private String fiContactPerson;
    private String fiContactAddress;
    private String fiContactTel;
    private String fiContactEmail;

    private String fiPurposeUse;
    private String fiLicenseOfAnimalNo;
    private Integer fiTypeDoc;
    private String fiNumber;
    private Date fiDate;

    private List<Seller> fiSellerList;
    private List<Goods> fiGoodsList;
    private List<Manufacturer> fiManufacturerList;
    private List<Document> fiDocumentList;

    private RegProfile20A() {
        super();
        fiSellerList = new ArrayList<>();
        fiGoodsList = new ArrayList<>();
        fiManufacturerList = new ArrayList<>();
        fiDocumentList = new ArrayList<>();
    }

    public static RegProfile20A parse(Tbdhoso08 rootHS) {
        RegProfile20A rp = new RegProfile20A();

        rp.setFiPortOfDepartureName(rootHS.getFiSrcPortName());
        rp.setFiPortOfDestinationName(rootHS.getFiDstPortName());

        rp.setFiBuyerName(rootHS.getFiBuyerName());
        rp.setFiBuyerAddress(rootHS.getFiBuyerAddress());
        rp.setFiBuyerPhone(rootHS.getFiBuyerTel());
        rp.setFiBuyerFax(rootHS.getFiBuyerFax());
        rp.setFiBuyerIdentityNo(rootHS.getFiBuyerIdentityNumber());
        rp.setFiBuyerDateOfIdentityNo(rootHS.getFiBuyerIdentityDate());
        rp.setFiBuyerPlaceOfIdentityNo(rootHS.getFiBuyerIdentityPlace());

        rp.setFiImportingFromDate(rootHS.getFiImportingDateFrom());
        rp.setFiImportingToDate(rootHS.getFiImportingDateTo());
        rp.setFiLocationOfStorage(rootHS.getFiStorageLocation());
        rp.setFiDateOfSamplingFrom(rootHS.getFiSamplingDateFrom());
        rp.setFiDateOfSamplingTo(rootHS.getFiSamplingDateTo());
        rp.setFiLocationOfSampling(rootHS.getFiSamplingLocation());

        rp.setFiContactAddress(rootHS.getFiContactAddress());
        rp.setFiContactPerson(rootHS.getFiContactName());
        rp.setFiContactTel(rootHS.getFiContactTel());
        rp.setFiContactEmail(rootHS.getFiContactEmail());

        rp.setFiPurposeUse(rootHS.getFiIntendedPurpose());
        rp.setFiLicenseOfAnimalNo(rootHS.getFiAnimalLicenseNo());
        rp.setFiTypeDoc(rootHS.getFiDocType());
        rp.setFiNumber(rootHS.getFiDocNumber());
        rp.setFiDate(rootHS.getFiDocDate());

        int idx = 1;
        for (Tbdhanghoa08 product : rootHS.getLstProduct()) {
            Goods good = new Goods();
            good.setFiIdGoods(product.getFiIdProduct());
            good.setFiGoodsSort(idx);
            good.setFiNameOfGoods(product.getFiProductName());
            good.setFiCodeOfGoods(product.getFiProductCode());
            good.setFiNameSicenceOfGoods(product.getFiProductScienceName());
            good.setFiOriginationCode(product.getFiCountryOrigin());
            good.setFiOriginationName(CmonHelper.instance().findCountryByCode(product.getFiCountryOrigin()).getCountryname());

            good.setFiQuantity(product.getFiNumber());
            good.setFiQuantityUnitCode(product.getFiUnitCode());
            good.setFiQuantityUnitName(CmonHelper.instance().findUomByCode(product.getFiUnitCode()).getUnitname());

            good.setFiNetWeight(product.getFiNetWeight());
            good.setFiNetWeightUnitCode(product.getFiNWUnitCode());
            good.setFiNetWeightUnitName(CmonHelper.instance().findUomByCode(product.getFiNWUnitCode()).getUnitname());

            good.setFiGrossWeight(product.getFiGrossWeight());
            good.setFiGrossWeightUnitCode(product.getFiGWUnitCode());
            good.setFiGrossWeightUnitName(CmonHelper.instance().findUomByCode(product.getFiGWUnitCode()).getUnitname());

            good.setFiWayOfPackinglist(product.getFiPackingType());
            good.setFiCirculateNo(product.getFiCirculateNo());
            idx++;
            rp.getFiGoodsList().add(good);
        }

        rootHS.getLstExporter().forEach(exporter -> {
            Seller company = new Seller();
            company.setFiSellerId(exporter.getFiIdExporter());
            company.setFiSellerName(exporter.getFiExporterName());
            company.setFiSellerAddress(exporter.getFiExporterAddress());
            company.setFiSellerPhone(exporter.getFiExporterTel());
            company.setFiSellerFax(exporter.getFiExporterFax());
            company.setFiSellerStateCode(exporter.getFiCountryOrigin());
            company.setFiSellerStateName(CmonHelper.instance().findCountryByCode(exporter.getFiCountryOrigin()).getCountryname());
            rp.getFiSellerList().add(company);
        });

        rootHS.getLstDocument().forEach(doc -> {
            Document dtoDoc = new Document();
            BeanUtils.copyProperties(doc, dtoDoc);
            rp.getFiDocumentList().add(dtoDoc);
        });

        rootHS.getLstProdMfr().forEach(mfr -> {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setFiManufacturerId(mfr.getFiIdMfr());
            manufacturer.setFiManufacturerName(mfr.getFiMfrName());
            manufacturer.setFiManufactureFactoryAddress(mfr.getFiMfrAddress());
            manufacturer.setFiCountryCode(mfr.getFiMfrCountryrigin());
            manufacturer.setFiCountryName(CmonHelper.instance().findCountryByCode(mfr.getFiMfrCountryrigin()).getCountryname());
            rp.getFiManufacturerList().add(manufacturer);
        });

        return rp;
    }
}
