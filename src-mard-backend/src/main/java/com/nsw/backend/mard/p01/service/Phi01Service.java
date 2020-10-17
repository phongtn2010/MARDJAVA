package com.nsw.backend.mard.p01.service;

import com.nsw.backend.mard.p01.client.FeeRequest;
import com.nsw.backend.mard.p01.client.PhytosanitaryFee;
import com.nsw.backend.mard.p01.constant.Constant01;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.model.*;
import com.nsw.backend.mard.p01.repositories.TbdApphi01Repository;
import com.nsw.backend.mard.p01.repositories.TbdAttachmentFileRepository;
import com.nsw.backend.mard.p01.repositories.TbdTbttPhi01Repository;
import com.nsw.backend.mard.p09.service.Phi09Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class Phi01Service {

    private final Tbdhoso01Service regProfileService;

    private final TbdAttachmentFileRepository fileRepository;

    private final Tbdlichsu01Service historyService;

    private final TbdApphi01Repository feeRepository;

    private final TbdTbttPhi01Repository feeReqRepository;

    @Autowired
    public Phi01Service(Tbdhoso01Service regProfileService, TbdAttachmentFileRepository fileRepository, Tbdlichsu01Service historyService, TbdApphi01Repository feeRepository, TbdTbttPhi01Repository feeReqRepository) {
        this.regProfileService = regProfileService;
        this.fileRepository = fileRepository;
        this.historyService = historyService;
        this.feeRepository = feeRepository;
        this.feeReqRepository = feeReqRepository;
    }

    public void xulyTbApphi(PhytosanitaryFee phytosanitaryFee) throws NSWException {
        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(phytosanitaryFee.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông báo áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus((long) Constant01.Hoso01pPaymentStatus.TB_AP_PHI.getId());
        regProfileService.update(regProfile);
        feeRepository.save(Tbdtbap01.parse(phytosanitaryFee));
        historyService.save(createHistoryLog(regProfile,
                String.format("Thông báo áp phí: <br> " +
                                "Tổng số tiền: %s, <br>" +
                                "Tổng số tiền bằng chữ: %s, <br>" +
                                "Ghi chú: %s",
                        Phi09Service.formatDouble(phytosanitaryFee.getFiTotalFee()),
                        phytosanitaryFee.getFiTotalFeeText(),
                        phytosanitaryFee.getFiNote()), phytosanitaryFee.getFiCreaterName()));
    }

    public void xulyTbXacNhanPhi(FeeRequest feeRequest) throws NSWException {

        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(feeRequest.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String contentHistory;
        if (feeRequest.getFiPaymentStatus() == 1) {
            regProfile.setFiPaymentStatus((long) Constant01.Hoso01pPaymentStatus.XAC_NHAN_THANH_TOAN_PHI.getId());
            switch (feeRequest.getFiTypeFee()) {
                case 1:
                    contentHistory =
                            String.format(
                                    "Xác nhận thanh toán phí: Thanh toán chuyển khoản<br>" +
                                            "Số hóa đơn: %s<br>" +
                                            "Số tài khoản: %s<br>" +
                                            "Người nộp tiền: %s<br>" +
                                            "Tổng số tiền: %d<br>" +
                                            "Tổng số tiền bằng chữ: %s<br>",
                                    feeRequest.getFiInvoiceNumber(), feeRequest.getFiAccountNumber(), feeRequest.getFiName(), feeRequest.getFiTotalFee(), feeRequest.getFiTotalFeeText());


                    break;
                case 2:
                    contentHistory =
                            String.format(
                                    "Xác nhận thanh toán phí: Thanh toán trực tiếp<br>" +
                                            "Số hóa đơn: %s<br>" +
                                            "Người nộp tiền: %s<br>" +
                                            "Tổng số tiền: %d<br>" +
                                            "Tổng số tiền bằng chữ: %s<br>",
                                    feeRequest.getFiInvoiceNumber(), feeRequest.getFiName(), feeRequest.getFiTotalFee(), feeRequest.getFiTotalFeeText());
                    break;

                case 3:
                    contentHistory =
                            String.format(
                                    "Xác nhận thanh toán phí: Xác nhận cho phép nộp sau<br>" +
                                            "Tổng số tiền: %d<br>" +
                                            "Tổng số tiền bằng chữ %s<br>" +
                                            "Nộp từ ngày: %s<br>" +
                                            "Nộp đến ngày: %s<br>",
                                    feeRequest.getFiTotalFee(), feeRequest.getFiTotalFeeText(), simpleDateFormat.format(feeRequest.getFiFromDate()), simpleDateFormat.format(feeRequest.getFiToDate()));
                    break;
                default:
                    throw new NSWException("Thông tin phí không hợp lệ");
            }
        } else {
            regProfile.setFiPaymentStatus((long) Constant01.Hoso01pPaymentStatus.YC_NOP_PHI_BO_XUNG.getId());
            contentHistory =
                    String.format(
                            "Xác nhận thanh toán phí: Yêu cầu bổ sung phí<br>" +
                                    "Số tiền đã thanh toán: %d, số tiền đã thanh toán bằng chữ: %s<br>" +
                                    "Số tài khoản: %s<br>" +
                                    "Người nộp tiền: %s<br>",
                            feeRequest.getFiTotalFee(), feeRequest.getFiTotalFeeText(),
                            feeRequest.getFiAccountNumber(), feeRequest.getFiName());

        }
        regProfileService.update(regProfile);
        feeReqRepository.save(TbdTbttphi01.parse(feeRequest));

        if (feeRequest.getFiNote() != null) {
            contentHistory += String.format("Ghi chú: %s<br>", feeRequest.getFiNote());
        }

        if (feeRequest.getFiAttachment() != null && feeRequest.getFiAttachment().getFiFileByte() != null) {
            TbdAttachmentFile01 file = new TbdAttachmentFile01();
            file.setFiContent(feeRequest.getFiAttachment().getFiFileByte());
            file.setFiFileName(feeRequest.getFiAttachment().getFiFileName() == null ? UUID.randomUUID().toString() : feeRequest.getFiAttachment().getFiFileName());
            file.setFiTaxCode(regProfile.getFiTaxCode());
            file = fileRepository.save(file);
            contentHistory += String.format("<a href=\"%s\">Tải đính kèm</a>", String.format("/mard/01/attachment/fee/%d", file.getFiID()));
        }

        historyService.save(createHistoryLog(regProfile, contentHistory, feeRequest.getFiCreaterName()));

    }

    private Tbdlichsu01 createHistoryLog(Tbdhoso01 profile, String historyContent, String senderName) {
        Tbdlichsu01 profileHst = new Tbdlichsu01();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy("CTY");
        profileHst.setFiSenderUnitName("Cục Thú Y");
        profileHst.setFiSenderName(senderName);
        return profileHst;
    }

}
