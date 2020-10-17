package com.nsw.backend.mard.p08.dto;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p08.model.Tbdhanghoa08;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegProfile19B {
    private String fiProductExecutionTime;
    private Date fiProductExecutionTimeFrom;
    private Date fiProductExecutionTimeTo;
    private String fiProductPurpose;
    private String fiProductAttachedDoc;

    private List<Product> fiProductList;
    private List<ProductCompany> fiProductCompanyList;
    private List<ProductManufacturer> fiProductManufactureList;

    private RegProfile19B() {
        super();
        fiProductList = new ArrayList<>();
        fiProductCompanyList = new ArrayList<>();
        fiProductManufactureList = new ArrayList<>();
    }

    public static RegProfile19B parse(Tbdhoso08 rootHS) {
        RegProfile19B rp = new RegProfile19B();


        rp.setFiProductExecutionTime(rootHS.getFiProcessingDate());
        rp.setFiProductExecutionTimeFrom(rootHS.getFiProcessingDateFrom());
        rp.setFiProductExecutionTimeTo(rootHS.getFiProcessingDateTo());
        rp.setFiProductPurpose((rootHS.getFiIntendedPurpose()));
        rp.setFiProductAttachedDoc(rootHS.getFiProvidedDocument());

        int idx = 1;
        for (Tbdhanghoa08 product : rootHS.getLstProduct()) {
            Product pr = new Product();
            pr.setFiProductId(product.getFiIdProduct());
            pr.setFiProductName(product.getFiProductName());
            pr.setFiProductCode(product.getFiProductCode());
            pr.setFiProductExporterStateCode(product.getFiCountryOrigin());
            pr.setFiProductExporterStateName(CmonHelper.instance().findCountryByCode(product.getFiCountryOrigin()).getCountryname());
            pr.setFiProductPortOfDestinationName(product.getFiPortName());
            pr.setFiProductQuantity(product.getFiNumber());
            pr.setFiProductQuantityUnitCode(product.getFiUnitCode());
            pr.setFiProductQuantityUnitName(CmonHelper.instance().findUomByCode(product.getFiUnitCode()).getUnitname());
            pr.setFiProductSort(idx);
            idx++;
            rp.getFiProductList().add(pr);
        }

        rootHS.getLstExporter().forEach(exporter -> {
            ProductCompany company = new ProductCompany();
            company.setFiProductCompanyId(exporter.getFiIdExporter());
            company.setFiProductCompanyName(exporter.getFiExporterName());
            company.setFiProductCompanyAddress(exporter.getFiExporterAddress());
            rp.getFiProductCompanyList().add(company);
        });

        rootHS.getLstProdMfr().forEach(mfr -> {
            ProductManufacturer manufacturer = new ProductManufacturer();
            manufacturer.setFiProductManufacturerId(mfr.getFiIdMfr());
            manufacturer.setFiProductManufactureName(mfr.getFiMfrName());
            manufacturer.setFiProductManufactureAddress(mfr.getFiMfrAddress());
            rp.getFiProductManufactureList().add(manufacturer);
        });

        return rp;
    }
}
