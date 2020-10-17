package com.nsw.backend.mard.p08.dto;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p08.model.Tbdhanghoa08;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import com.nsw.backend.mard.p08.model.Tbdnmsx08;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegProfile20 {
    private static final long serialVersionUID = 1L;

    private String fiBoneMealExecutionTime;
    private Date fiBoneMealExecutionTimeFrom;
    private Date fiBoneMealExecutionTimeTo;
    private String fiBoneMealPurpose;
    private String fiBoneMealOtherPurpose;
    private String fiBoneMealAttachedDoc;
    private String fiBoneMealFactoryName;
    private String fiBoneMealFactoryAddress;

    private List<BoneMeal> fiBoneMealList;
    private List<BoneMealCompany> fiBoneMealCompanyList;
    private List<BoneMealManufacturer> fiBoneMealManufactureList;

    private RegProfile20() {
        super();
        fiBoneMealList = new ArrayList<>();
        fiBoneMealCompanyList = new ArrayList<>();
        fiBoneMealManufactureList = new ArrayList<>();
    }

    public static RegProfile20 parse(Tbdhoso08 rootHS) {
        RegProfile20 rp = new RegProfile20();

        rp.setFiBoneMealExecutionTime(rootHS.getFiProcessingDate());
        rp.setFiBoneMealExecutionTimeFrom(rootHS.getFiProcessingDateFrom());
        rp.setFiBoneMealExecutionTimeTo(rootHS.getFiProcessingDateTo());
        rp.setFiBoneMealPurpose(rootHS.getFiIntendedPurpose());
        rp.setFiBoneMealOtherPurpose(rootHS.getFiOtherPurpose());
        rp.setFiBoneMealAttachedDoc(rootHS.getFiProvidedDocument());

        if(CollectionUtils.isEmpty(rootHS.getLstMfgFactory()) == false){
            Tbdnmsx08 factory = rootHS.getLstMfgFactory().get(0);
            rp.setFiBoneMealFactoryName(factory.getFiFactoryName());
            rp.setFiBoneMealFactoryAddress(factory.getFiFactoryAddress());
        }

        int idx = 1;
        for (Tbdhanghoa08 product : rootHS.getLstProduct()) {
            BoneMeal bm = new BoneMeal();
            bm.setFiBoneMealId(product.getFiIdProduct());
            bm.setFiBoneMealName(product.getFiProductName());
            bm.setFiBoneMealCode(product.getFiProductCode());
            bm.setFiBoneMealExporterStateCode(product.getFiCountryOrigin());
            bm.setFiBoneMealExporterStateName(CmonHelper.instance().findCountryByCode(product.getFiCountryOrigin()).getCountryname());
            bm.setFiBoneMealPortOfDestinationName(product.getFiPortName());
            bm.setFiBoneMealQuantity(product.getFiNumber());
            bm.setFiBoneMealQuantityUnitCode(product.getFiUnitCode());
            bm.setFiBoneMealQuantityUnitName(CmonHelper.instance().findUomByCode(product.getFiUnitCode()).getUnitname());
            bm.setFiBoneMealSort(idx);
            idx++;
            rp.getFiBoneMealList().add(bm);
        }

        rootHS.getLstExporter().forEach(exporter -> {
            BoneMealCompany company = new BoneMealCompany();
            company.setFiBoneMealCompanyId(exporter.getFiIdExporter());
            company.setFiBoneMealCompanyName(exporter.getFiExporterName());
            company.setFiBoneMealCompanyAddress(exporter.getFiExporterAddress());
            rp.getFiBoneMealCompanyList().add(company);
        });

        rootHS.getLstProdMfr().forEach(mfr -> {
            BoneMealManufacturer manufacturer = new BoneMealManufacturer();
            manufacturer.setFiBoneMealManufacturerId(mfr.getFiIdMfr());
            manufacturer.setFiBoneMealManufactureName(mfr.getFiMfrName());
            manufacturer.setFiBoneMealManufactureAddress(mfr.getFiMfrAddress());
            rp.getFiBoneMealManufactureList().add(manufacturer);
        });

        return rp;
    }
}
