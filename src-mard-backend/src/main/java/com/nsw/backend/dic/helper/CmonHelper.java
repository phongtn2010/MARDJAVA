package com.nsw.backend.dic.helper;

import com.nsw.backend.dic.model.CmonCountry;
import com.nsw.backend.dic.model.CmonUnit;
import com.nsw.backend.dic.service.CmonCountryService;
import com.nsw.backend.dic.service.CmonUnitService;
import com.nsw.backend.mard.p08.model.Tbddvxl08;
import com.nsw.backend.mard.p08.repositories.Tbddvxl08Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CmonHelper {
    private static CmonHelper mInstance;

    @Autowired
    private Tbddvxl08Repository processingUnitRepository;

    @Autowired
    private CmonCountryService countryService;

    @Autowired
    private CmonUnitService cmonUnitService;

    public static CmonHelper instance() {
        return mInstance;
    }

    @PostConstruct
    public void init() {
        CmonHelper.mInstance = this;
    }

    public CmonCountry findCountryByCode(String countryCode) {
        CmonCountry country = countryService.findByCountryCode(countryCode);
        if(country == null) return new CmonCountry();
        return country;
    }

    public CmonUnit findUomByCode(String uomCode) {
        CmonUnit uom = cmonUnitService.findByUomCode(uomCode);
        if(uom == null) return new CmonUnit();
        return uom;
    }

    public String getUnitNameByUnitCode(String unitCode){
        if("MARD".equals(unitCode)) return "Cục Thú Y";
        if("NSW".equals(unitCode)) return "Cổng thông tin một cửa quốc gia";
        Tbddvxl08 processingUnit = processingUnitRepository.findByFiPUCode(unitCode).orElse(null);
        return processingUnit == null ? "Cổng thông tin một cửa quốc gia" : processingUnit.getFiPUDesc();
    }
}
