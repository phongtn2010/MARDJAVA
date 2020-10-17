package com.nsw.backend.mard.p06.service;

import com.nsw.backend.mard.p06.dto.QuarantineDispatch;
import com.nsw.backend.mard.p06.dto.VeterinaryHygiene;
import com.nsw.backend.mard.p06.model.TbdCongvan06;
import com.nsw.backend.mard.p06.repositories.TbdCongvan06Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GiayCN06Service {

    private final TbdCongvan06Repository certRepo;

    @Autowired
    public GiayCN06Service(TbdCongvan06Repository certRepo) {
        this.certRepo = certRepo;
    }


    public void xulyVSTY(VeterinaryHygiene veterinaryHygiene) {
        TbdCongvan06 cvVSTY = new TbdCongvan06();
        BeanUtils.copyProperties(veterinaryHygiene, cvVSTY);
        cvVSTY.setFiDispatchType(1);
        cvVSTY.setFiProductList(new ArrayList<>());
        cvVSTY.setFiProcessingList(new ArrayList<>());
        cvVSTY.setFiLocationQuarantineList(new ArrayList<>());
        cvVSTY.setFiExporterCountryList(new ArrayList<>());
        cvVSTY.getFiProductList().addAll(veterinaryHygiene.getFiProductList());
        cvVSTY.getFiProcessingList().addAll(veterinaryHygiene.getFiProcessingList());
        cvVSTY.getFiLocationQuarantineList().addAll(veterinaryHygiene.getFiLocationQuarantineList());
        cvVSTY.getFiExporterCountryList().addAll(veterinaryHygiene.getFiExporterCountryList());
        removeOldCv(veterinaryHygiene.getFiNSWFileCode(), 1);
        certRepo.save(cvVSTY);
    }

    public void xulyKDNK(QuarantineDispatch quarantineResult) {
        TbdCongvan06 cvKDNK = new TbdCongvan06();
        BeanUtils.copyProperties(quarantineResult, cvKDNK);
        cvKDNK.setFiDispatchType(2);
        cvKDNK.setFiProductList(new ArrayList<>());
        cvKDNK.setFiProcessingList(new ArrayList<>());
        cvKDNK.setFiLocationQuarantineList(new ArrayList<>());
        cvKDNK.setFiExporterCountryList(new ArrayList<>());
        cvKDNK.getFiProductList().addAll(quarantineResult.getFiProductList());
        cvKDNK.getFiProcessingList().addAll(quarantineResult.getFiProcessingList());
        cvKDNK.getFiLocationQuarantineList().addAll(quarantineResult.getFiLocationQuarantineList());
        cvKDNK.getFiExporterCountryList().addAll(quarantineResult.getFiExporterCountryList());
        removeOldCv(quarantineResult.getFiNSWFileCode(), 2);
        certRepo.save(cvKDNK);
    }

    private void removeOldCv(String fiDispatchNo, int type) {
        TbdCongvan06 oldCv = certRepo.findByFiNSWFileCodeAndFiDispatchType(fiDispatchNo, type);
        if (oldCv != null) {
            certRepo.delete(oldCv);
        }
    }
}
