package com.nsw.backend.mard.p09.service;

import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.mard.p09.dto.receive.*;
import com.nsw.backend.mard.p09.dto.send.RequestEditCer;
import com.nsw.backend.mard.p09.model.*;
import com.nsw.backend.mard.p09.repositories.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiayCN09Service {

    private static final String GIAY_VAN_CHUYEN = "gvc";
    private static final String CHUNG_NHAN_KIEM_DICH = "cnkd";
    private static final String XAC_NHAN_XAC_LUONG = "xncl";
    private final TbdGiayVC09Repository transportRepo;

    private final TbdGiayCNKD09Repository quarantineRepo;

    private final TbdGiayXNCL09Repository qualityRepo;

    private final TbdTbXNCL09Repository qualityNotiRepo;

    private final TbdYcsGcn09Repository editRequestRepo;

    private final TbdCnkdKd09Repository quarantineNotiRepo;

    @Autowired
    public GiayCN09Service(TbdGiayVC09Repository transportRepo, TbdGiayCNKD09Repository quarantineRepo, TbdGiayXNCL09Repository qualityRepo, TbdTbXNCL09Repository qualityNotiRepo, TbdYcsGcn09Repository editRequestRepo, TbdCnkdKd09Repository quarantineNotiRepo) {
        this.transportRepo = transportRepo;
        this.quarantineRepo = quarantineRepo;
        this.qualityRepo = qualityRepo;
        this.qualityNotiRepo = qualityNotiRepo;
        this.editRequestRepo = editRequestRepo;
        this.quarantineNotiRepo = quarantineNotiRepo;
    }


    public void xulyGVC(TransportResult transportResult) {
        Tbdgiayvc09 giayvc = new Tbdgiayvc09();
        BeanUtils.copyProperties(transportResult, giayvc);
        giayvc.setLstGood(new ArrayList<>());
        List<TbdGvcHh09> lstGoods = new ArrayList<>();
        transportResult.getFiGoodsList().forEach(goods -> lstGoods.add(CmonHh09.parse(goods, TbdGvcHh09.class)));
        giayvc.getLstGood().addAll(lstGoods);
        transportRepo.findFirstByFiCertificateNo(giayvc.getFiCertificateNo()).ifPresent(transportRepo::delete);
        transportRepo.save(giayvc);
    }

    public void xulyGiayCNKD(AnimalQuarantineResult quarantineResult) {
        Tbdgiaycnkd09 cnkd = new Tbdgiaycnkd09();
        BeanUtils.copyProperties(quarantineResult, cnkd);
        cnkd.setLstGood(new ArrayList<>());
        cnkd.setLstImmunes(new ArrayList<>());
        List<TbdCnkdHh09> lstGoods = new ArrayList<>();
        List<Tbdtiemphong09> lstImmunes = new ArrayList<>();
        quarantineResult.getFiGoodsList().forEach(goods -> lstGoods.add(CmonHh09.parse(goods, TbdCnkdHh09.class)));
        if (quarantineResult.getFiImmunesList() != null) {
            quarantineResult.getFiImmunesList().forEach(immune -> {
                Tbdtiemphong09 tp = new Tbdtiemphong09();
                BeanUtils.copyProperties(immune, tp);
                lstImmunes.add(tp);
            });
            cnkd.getLstImmunes().addAll(lstImmunes);
        }

        cnkd.getLstGood().addAll(lstGoods);
        quarantineRepo.findFirstByFiCertificateNo(quarantineResult.getFiCertificateNo()).ifPresent(quarantineRepo::delete);
        quarantineRepo.save(cnkd);
    }

    public void xulyXNCL(QualityResult qualityResult) {
        Tbdgiayxncl09 xncl = new Tbdgiayxncl09();
        BeanUtils.copyProperties(qualityResult, xncl);
        xncl.setLstGood(new ArrayList<>());
        List<TbdXnclHh09> lstGoods = new ArrayList<>();
        qualityResult.getFiGoodsList().forEach(goods -> lstGoods.add(CmonHh09.parse(goods, TbdXnclHh09.class)));
        xncl.getLstGood().addAll(lstGoods);
        qualityRepo.findFirstByFiQuanlityCerNo(qualityResult.getFiQuanlityCerNo()).ifPresent(qualityRepo::delete);
        qualityRepo.save(xncl);
    }

    public void xulyTbXNCL(QualityResultNotification qualityResultNotification) {
        TbdTbXncl09 tbXncl = new TbdTbXncl09();
        BeanUtils.copyProperties(qualityResultNotification, tbXncl);
        tbXncl.setFiAttachmentList(new ArrayList<>());
        tbXncl.setFiGoodsList(new ArrayList<>());
        List<TbdTbXnclHh09> lstGoods = new ArrayList<>();
        qualityResultNotification.getFiGoodsList().forEach(goods -> {
            TbdTbXnclHh09 hh = new TbdTbXnclHh09();
            BeanUtils.copyProperties(goods, hh);
            lstGoods.add(hh);
        });
        List<TbdDkTbXncl09> lstAttachment = new ArrayList<>();
        qualityResultNotification.getFiAttachmentList().forEach(atch -> {
            TbdDkTbXncl09 attachment = new TbdDkTbXncl09();
            attachment.setFiHoatdong(Constant09.ACTIVE);
            attachment.setFiGuid(atch.getFiAttachmentId());
            attachment.setFiDuongDan(atch.getFiLinkFile());
//            attachment.setFiMaLoai(atch.getFiAttachment());
            attachment.setFiTenLoai(TextUtils.isEmpty(atch.getFiAttachmentTypeName()) ? "" : atch.getFiAttachmentTypeName());
            attachment.setFiTenTep(TextUtils.isEmpty(atch.getFiAttachmentName()) ? "" : atch.getFiAttachmentName());
            lstAttachment.add(attachment);
        });
        tbXncl.getFiGoodsList().addAll(lstGoods);
        tbXncl.getFiAttachmentList().addAll(lstAttachment);
        qualityNotiRepo.save(tbXncl);
    }

    public void xulyCnkdKd(QuarantineFailedNotification failedNotification) {
        TbdCnkdKd09 cnkdKd = new TbdCnkdKd09();
        BeanUtils.copyProperties(failedNotification, cnkdKd);
        cnkdKd.setFiAttachmentList(new ArrayList<>());
        List<TbdDkCnkdKd09> lstAttachment = new ArrayList<>();
        failedNotification.getFiAttachmentList().forEach(atch -> {
            TbdDkCnkdKd09 attachment = new TbdDkCnkdKd09();
            attachment.setFiHoatdong(Constant09.ACTIVE);
            attachment.setFiGuid(atch.getFiAttachmentId());
            attachment.setFiDuongDan(atch.getFiLinkFile());
            attachment.setFiMaLoai(atch.getFiAttachment());
            attachment.setFiTenLoai(atch.getFiAttachmentTypeName());
            attachment.setFiTenTep(atch.getFiAttachmentName());
            lstAttachment.add(attachment);
        });
        cnkdKd.getFiAttachmentList().addAll(lstAttachment);
        quarantineNotiRepo.save(cnkdKd);
    }

    public void xulyKQYCSGCN(ResponseEditCer responseCertEditRequest) {
        if (responseCertEditRequest.isAccepted()) {
            updateCertStatus(responseCertEditRequest.getFiCertificateNo(), Constant09.CertEditStatus.DONG_Y_YEU_CAU.getId());
        } else {
            updateCertStatus(responseCertEditRequest.getFiCertificateNo(), Constant09.CertEditStatus.TU_CHOI_YEU_CAU.getId());
        }
    }

    public List<Tbdgiayvc09> findGVCByHSCode(String fiHSCode) {
        return transportRepo.findAllByFiNSWFileCodeOrderByFiIdTransportCerDesc(fiHSCode);
    }

    public List<Tbdgiaycnkd09> findGCNKDByHSCode(String fiHSCode) {
        return quarantineRepo.findAllByFiNSWFileCodeOrderByFiIdQuarantineCerDesc(fiHSCode);
    }

    public List<Tbdgiayxncl09> findXNCLByHSCode(String fiHSCode) {
        return qualityRepo.findAllByFiNSWFileCodeOrderByFiIdQualityCerDesc(fiHSCode);
    }

    public List<TbdTbXncl09> findTbXNCLByHSCode(String fiHSCode) {
        return qualityNotiRepo.findAllByFiNSWFileCodeOrderByFiIdTbDesc(fiHSCode);
    }

    public List<TbdCnkdKd09> findCnkdKdByHSCode(String fiHSCode) {
        return quarantineNotiRepo.findAllByFiNSWFileCodeOrderByFiIdDesc(fiHSCode);
    }

    public Tbdycsgcn09 requestModifyCertificate(RequestEditCer requestEditCer) {
        Tbdycsgcn09 requestEdit = new Tbdycsgcn09();
        BeanUtils.copyProperties(requestEditCer, requestEdit);
        requestEdit.setFiAttachmentList(new ArrayList<>());
        requestEdit.getFiAttachmentList().addAll(requestEditCer.getLstAtch());
        requestEdit = editRequestRepo.save(requestEdit);
        updateCertStatus(requestEditCer.getFiTypeCert(), requestEditCer.getFiIdCv(), Constant09.CertEditStatus.CHO_TIEP_NHAN.getId());
        return requestEdit;
    }

    public List<String> findLstNSWFileCode(FilterForm filterForm) {
        if (!filterForm.isValidForLicenseQuery()) return new ArrayList<>();
        List<String> listValidFiNSWFileCode = new ArrayList<>();
        listValidFiNSWFileCode.addAll(transportRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(Tbdgiayvc09::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(qualityRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(Tbdgiayxncl09::getFiNSWFileCode).collect(Collectors.toList()));
        listValidFiNSWFileCode.addAll(quarantineRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(Tbdgiaycnkd09::getFiNSWFileCode).collect(Collectors.toList()));
        return listValidFiNSWFileCode;
    }

    private void updateCertStatus(String certNo, int certStatus) {
        Tbdgiayvc09 transportCert = transportRepo.findFirstByFiCertificateNo(certNo).orElse(null);
        if (transportCert != null) {
            transportCert.setFiEditStatus(certStatus);
            transportRepo.save(transportCert);
        }
        Tbdgiaycnkd09 quarantineCert = quarantineRepo.findFirstByFiCertificateNo(certNo).orElse(null);
        if (quarantineCert != null) {
            quarantineCert.setFiEditStatus(certStatus);
            quarantineRepo.save(quarantineCert);
        }
        Tbdgiayxncl09 qualityCert = qualityRepo.findFirstByFiQuanlityCerNo(certNo).orElse(null);
        if (qualityCert != null) {
            qualityCert.setFiEditStatus(certStatus);
            qualityRepo.save(qualityCert);
        }
    }

    private void updateCertStatus(String certType, Long certId, int certStatus) {
        if (GIAY_VAN_CHUYEN.equals(certType)) {
            Tbdgiayvc09 transportCert = transportRepo.findOne(certId);
            transportCert.setFiEditStatus(certStatus);
            transportRepo.save(transportCert);
        }
        if (CHUNG_NHAN_KIEM_DICH.equals(certType)) {
            Tbdgiaycnkd09 quarantineCert = quarantineRepo.findOne(certId);
            quarantineCert.setFiEditStatus(certStatus);
            quarantineRepo.save(quarantineCert);
        }
        if (XAC_NHAN_XAC_LUONG.equals(certType)) {
            Tbdgiayxncl09 qualityCert = qualityRepo.findOne(certId);
            qualityCert.setFiEditStatus(certStatus);
            qualityRepo.save(qualityCert);
        }
    }
}
