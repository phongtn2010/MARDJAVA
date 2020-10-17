package com.nsw.backend.mard.p01.service;

import com.nsw.backend.mard.p01.model.*;
import com.nsw.backend.mard.p01.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GiayCN01Service {

    private final Tbdcnkd13aRepository cert13aRepository;

    private final Tbdcnkd13bRepository cert13bRepository;

    private final TbdcnkdCNRepository certCNRepository;

    private final TbdcnkdHKCRepostory certHKCRepository;

    private final TbdcnkdHKPRepostory certHKPRepository;

    private final TbdcnkdMRepostory certMRepository;

    private final Tbdcvkqfail01Repository exportRequestFailRepository;

    @Autowired
    public GiayCN01Service(Tbdcnkd13aRepository cert13aRepository, Tbdcnkd13bRepository cert13bRepository, TbdcnkdCNRepository certCNRepository, TbdcnkdHKCRepostory certHKCRepository, TbdcnkdHKPRepostory certHKPRepository, TbdcnkdMRepostory certMRepository, Tbdcvkqfail01Repository exportRequestFailRepository) {
        this.cert13aRepository = cert13aRepository;
        this.cert13bRepository = cert13bRepository;
        this.certCNRepository = certCNRepository;
        this.certHKCRepository = certHKCRepository;
        this.certHKPRepository = certHKPRepository;
        this.certMRepository = certMRepository;
        this.exportRequestFailRepository = exportRequestFailRepository;
    }

    public Optional<Tbdcvkqfail01> findFailExportRequest(String fiNSWFileCode) {
        return exportRequestFailRepository.findFirstByFiNSWFileCode(fiNSWFileCode);
    }


    public Tbdcnkd13a01 findGCN13A(Tbdhoso01 regProfile) {
        return cert13aRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public Tbdcnkd13b01 findGCN13B(Tbdhoso01 regProfile) {
        return cert13bRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public TbdcnkdHKC01 findGCNHKC(Tbdhoso01 regProfile) {
        return certHKCRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public TbdcnkdHKP01 findGCNHKP(Tbdhoso01 regProfile) {
        return certHKPRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public TbdcnkdChina01 findGCNCN(Tbdhoso01 regProfile) {
        return certCNRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public TbdcnkdM01 findGCNM(Tbdhoso01 regProfile) {
        return certMRepository.findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(regProfile.getFiNSWFileCode()).orElse(null);
    }

    public List<String> findLstNSWFileCode(FilterForm filterForm) {
        if (!filterForm.isValidForLicenseQuery()) return new ArrayList<>();
        List<String> listValidFiNSWFileCode = new ArrayList<>();
        listValidFiNSWFileCode.addAll(cert13aRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(Tbdcnkd13a01::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(cert13bRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(Tbdcnkd13b01::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(certHKCRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdcnkdHKC01::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(certHKPRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdcnkdHKP01::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(certCNRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdcnkdChina01::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(certMRepository.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdcnkdM01::getFiNSWFileCode).collect(Collectors.toList()));
        return listValidFiNSWFileCode;
    }

    public void markUnsyncCert(Tbdhoso01 regProfile){
        List<BaseCert01> listCert = new ArrayList<>();
        listCert.add(findGCN13A(regProfile));
        listCert.add(findGCN13B(regProfile));
        listCert.add(findGCNCN(regProfile));
        listCert.add(findGCNHKC(regProfile));
        listCert.add(findGCNHKP(regProfile));
        listCert.add(findGCNM(regProfile));
        listCert.forEach(cert ->{
            if(cert != null) cert.markUnsync();
        });
    }
}
