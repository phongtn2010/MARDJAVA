package com.nsw.backend.mard.p07.service;

import com.nsw.backend.mard.p07.client.QualityFail;
import com.nsw.backend.mard.p07.client.QuarantineResult;
import com.nsw.backend.mard.p07.client.ResponseEditCer;
import com.nsw.backend.mard.p07.client.TransportResult;
import com.nsw.backend.mard.p07.constant.Constant07;
import com.nsw.backend.mard.p07.dto.RequestEditCer;
import com.nsw.backend.mard.p07.model.*;
import com.nsw.backend.mard.p07.repositories.TbdCnkdKd07Repository;
import com.nsw.backend.mard.p07.repositories.TbdGiayCNKD07Repository;
import com.nsw.backend.mard.p07.repositories.TbdGiayVC07Repository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GiayCN07Service {

    private final TbdGiayVC07Repository transportRepo;

    private final TbdGiayCNKD07Repository quarantineRepo;

    private final TbdCnkdKd07Repository quarantineNotiRepo;

    @Autowired
    public GiayCN07Service(TbdGiayVC07Repository transportRepo, TbdGiayCNKD07Repository quarantineRepo, TbdCnkdKd07Repository quarantineNotiRepo) {
        this.transportRepo = transportRepo;
        this.quarantineRepo = quarantineRepo;
        this.quarantineNotiRepo = quarantineNotiRepo;
    }

    public void xulyGVC(TransportResult transportResult) {
        TbdCvCnvc07 giayvc = new TbdCvCnvc07();
        BeanUtils.copyProperties(transportResult, giayvc);
        giayvc.setFiGoodsList(new ArrayList<>());
        List<TbdCvCnvcHh07> lstGoods = new ArrayList<>();
        transportResult.getFiGoodsList().forEach(goods -> lstGoods.add(CmonHangHoa07.parse(goods, TbdCvCnvcHh07.class)));
        giayvc.getFiGoodsList().addAll(lstGoods);
        transportRepo.findFirstByFiCertificateNo(transportResult.getFiCertificateNo()).ifPresent(transportRepo::delete);
        transportRepo.save(giayvc);
        resetCertEditStatus(transportResult.getFiNSWFileCode());
    }

    public void xulyGiayCNKD(QuarantineResult quarantineResult) {
        TbdCvCnkd07 cnkd = new TbdCvCnkd07();
        BeanUtils.copyProperties(quarantineResult, cnkd);
        cnkd.setFiGoodsList(new ArrayList<>());
        List<TbdCvCnkdHh07> lstGoods = new ArrayList<>();
        quarantineResult.getFiGoodsList().forEach(goods -> lstGoods.add(CmonHangHoa07.parse(goods, TbdCvCnkdHh07.class)));
        cnkd.getFiGoodsList().addAll(lstGoods);
        quarantineRepo.findFirstByFiCertificateNo(quarantineResult.getFiCertificateNo()).ifPresent(quarantineRepo::delete);
        quarantineRepo.save(cnkd);
        resetCertEditStatus(quarantineResult.getFiNSWFileCode());
    }

    private void resetCertEditStatus(String fiNSWFileCode) {
        List<TbdCvCnvc07> listGVC = findGVCByHSCode(fiNSWFileCode);
        List<TbdCvCnkd07> listCNKD = findGCNKDByHSCode(fiNSWFileCode);
        TbdCvCnvc07 currentGVC = (CollectionUtils.isEmpty(listGVC)) ? null : listGVC.get(0);
        TbdCvCnkd07 currentCNKD = (CollectionUtils.isEmpty(listCNKD)) ? null : listCNKD.get(0);
        if (currentGVC != null && Objects.equals(currentGVC.getFiEditStatus(), Constant07.CertEditStatus.CHO_THUC_HIEN.getId())) {
            currentGVC.setFiEditStatus(null);
            transportRepo.save(currentGVC);
        }
        if (currentCNKD != null && Objects.equals(currentCNKD.getFiEditStatus(), Constant07.CertEditStatus.CHO_THUC_HIEN.getId())) {
            currentCNKD.setFiEditStatus(null);
            quarantineRepo.save(currentCNKD);
        }
    }

    public void xulyCnkdKd(QualityFail failedNotification) {
        TbdCnkdKd07 cnkdKd = new TbdCnkdKd07();
        BeanUtils.copyProperties(failedNotification, cnkdKd);
        quarantineNotiRepo.save(cnkdKd);
    }

    public List<TbdCvCnvc07> findGVCByHSCode(String fiHSCode) {
        return transportRepo.findAllByFiNSWFileCodeOrderByFiIdCVDesc(fiHSCode);
    }

    public List<TbdCvCnkd07> findGCNKDByHSCode(String fiHSCode) {
        return quarantineRepo.findAllByFiNSWFileCodeOrderByFiIdCVDesc(fiHSCode);
    }

    public List<TbdCnkdKd07> findCnkdKdByHSCode(String fiHSCode) {
        return quarantineNotiRepo.findAllByFiNSWFileCodeOrderByFiIdDesc(fiHSCode);
    }

    public RequestEditCer requestModifyCertificate(RequestEditCer requestEditCer) {
        String fiNSWFileCode = requestEditCer.getFiNSWFileCode();
        List<TbdCvCnvc07> listGVC = findGVCByHSCode(fiNSWFileCode);
        List<TbdCvCnkd07> listCNKD = findGCNKDByHSCode(fiNSWFileCode);
        TbdCvCnvc07 currentGVC = (CollectionUtils.isEmpty(listGVC)) ? null : listGVC.get(0);
        TbdCvCnkd07 currentCNKD = (CollectionUtils.isEmpty(listCNKD)) ? null : listCNKD.get(0);
        if (currentGVC != null) {
            currentGVC.setFiEditStatus(
                    (requestEditCer.getFiTypeOfRequest() == 3) ?
                            Constant07.CertEditStatus.CHO_THUC_HIEN.getId() :
                            Constant07.CertEditStatus.CHO_TIEP_NHAN.getId());
            transportRepo.save(currentGVC);
        }
        if (currentCNKD != null) {
            currentCNKD.setFiEditStatus(
                    (requestEditCer.getFiTypeOfRequest() == 2) ?
                            Constant07.CertEditStatus.CHO_THUC_HIEN.getId() :
                            Constant07.CertEditStatus.CHO_TIEP_NHAN.getId());
            quarantineRepo.save(currentCNKD);
        }
        return requestEditCer;
    }

    public List<String> findLstNSWFileCode(FilterForm filterForm) {
        if (!filterForm.isValidForLicenseQuery()) return new ArrayList<>();
        List<String> listValidFiNSWFileCode = new ArrayList<>();
        listValidFiNSWFileCode.addAll(transportRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdCvCnvc07::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(quarantineRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdCvCnkd07::getFiNSWFileCode).collect(Collectors.toList()));
        return listValidFiNSWFileCode;
    }

    public void xulyKQYCSGCN(ResponseEditCer responseCertEditRequest) {
        String fiNSWFileCode = responseCertEditRequest.getFiNSWFileCode();
        List<TbdCvCnvc07> listGVC = findGVCByHSCode(fiNSWFileCode);
        List<TbdCvCnkd07> listCNKD = findGCNKDByHSCode(fiNSWFileCode);
        TbdCvCnvc07 currentGVC = (CollectionUtils.isEmpty(listGVC)) ? null : listGVC.get(0);
        TbdCvCnkd07 currentCNKD = (CollectionUtils.isEmpty(listCNKD)) ? null : listCNKD.get(0);
        if (currentGVC != null) {
            currentGVC.setFiEditStatus(
                    (Objects.equals(currentGVC.getFiEditStatus(), Constant07.CertEditStatus.CHO_TIEP_NHAN.getId()) ?
                            Constant07.CertEditStatus.TU_CHOI_YEU_CAU.getId() :
                            null));
            transportRepo.save(currentGVC);
        }
        if (currentCNKD != null) {
            currentCNKD.setFiEditStatus(
                    (Objects.equals(currentCNKD.getFiEditStatus(), Constant07.CertEditStatus.CHO_TIEP_NHAN.getId()) ?
                            Constant07.CertEditStatus.TU_CHOI_YEU_CAU.getId() :
                            null));
            quarantineRepo.save(currentCNKD);
        }
    }
}
