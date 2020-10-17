package com.nsw.backend.mard.p08.dto;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p08.model.Tbdhanghoa08;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegProfile19A {
    private String fiAnimalFarm;
    private String fiAnimalFarmAddress;
    private String fiAnimalExecutionTime;
    private Date fiAnimalExecutionTimeFrom;
    private Date fiAnimalExecutionTimeTo;
    private String fiAnimalPurpose;
    private String fiAnimalAttachedDoc;

    private List<Animal> fiAnimalList;
    private List<AnimalCompany> fiAnimalCompanyList;
    private List<LocationQuarantine> fiLocationQuarantineList;

    private RegProfile19A() {
        fiAnimalList = new ArrayList<>();
        fiAnimalCompanyList = new ArrayList<>();
        fiLocationQuarantineList = new ArrayList<>();
    }

    public static RegProfile19A parse(Tbdhoso08 rootHS) {
        RegProfile19A rp = new RegProfile19A();

        rp.setFiAnimalFarm(rootHS.getFiAnimalFarm());
        rp.setFiAnimalFarmAddress(rootHS.getFiAnimalFarmAddress());

        rp.setFiAnimalExecutionTime(rootHS.getFiProcessingDate());
        rp.setFiAnimalExecutionTimeFrom(rootHS.getFiProcessingDateFrom());
        rp.setFiAnimalExecutionTimeTo(rootHS.getFiProcessingDateTo());
        rp.setFiAnimalPurpose(rootHS.getFiIntendedPurpose());
        rp.setFiAnimalAttachedDoc(rootHS.getFiProvidedDocument());
        Integer idx = 1;
        for (Tbdhanghoa08 product : rootHS.getLstProduct()) {
            Animal animal = new Animal();
            animal.setFiAnimalSort(idx);
            idx++;
            animal.setFiIdAnimal(product.getFiIdProduct());
            animal.setFiAnimalName(product.getFiProductName());
            animal.setFiAnimalCode(product.getFiProductCode());
            animal.setFiAnimalExporterStateCode(product.getFiCountryOrigin());
            animal.setFiAnimalExporterStateName(CmonHelper.instance().findCountryByCode(product.getFiCountryOrigin()).getCountryname());
            animal.setFiAnimalPortOfDestinationName(product.getFiPortName());
            animal.setFiAnimalQuantityFemale(product.getFiQtyFemale());
            animal.setFiAnimalQuantityMale(product.getFiQtyMale());
            rp.getFiAnimalList().add(animal);
        }

        rootHS.getLstExporter().forEach(exporter -> {
            AnimalCompany ac = new AnimalCompany();
            ac.setFiAnimalCompanyId(exporter.getFiIdExporter());
            ac.setFiAnimalCompanyName(exporter.getFiExporterName());
            ac.setFiAnimalCompanyAddress(exporter.getFiExporterAddress());
            rp.getFiAnimalCompanyList().add(ac);
        });

        rootHS.getLstIsolatedLocation().forEach(isoLoc -> {
            LocationQuarantine lq = new LocationQuarantine();
            lq.setFiLocationQuarantineId(isoLoc.getFiIdQuarLoc());
            lq.setFiLocationQuarantineName(isoLoc.getFiIsoLocName());
            lq.setFiLocationQuarantineAddress(isoLoc.getFiIsoLocAddress());
            rp.getFiLocationQuarantineList().add(lq);
        });

        return rp;
    }
}
