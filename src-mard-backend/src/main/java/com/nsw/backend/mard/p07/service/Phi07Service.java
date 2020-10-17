package com.nsw.backend.mard.p07.service;

import com.nsw.backend.mard.p07.client.FeeConfirmation;
import com.nsw.backend.mard.p07.client.FeeConfirmationAttachment;
import com.nsw.backend.mard.p07.client.PhytosanitaryFee;
import com.nsw.backend.mard.p07.constant.Constant07;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.model.TbdApphi07;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.model.TbdLichsu07;
import com.nsw.backend.mard.p07.repositories.TbdApphi07Repository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class Phi07Service {

    private final TbdHoso07Service regProfileService;

    private final TbdLichsu07Service historyService;

    private final TbdApphi07Repository feeRepository;

    @Autowired
    public Phi07Service(TbdHoso07Service regProfileService, TbdLichsu07Service historyService, TbdApphi07Repository feeRepository) {
        this.regProfileService = regProfileService;
        this.historyService = historyService;
        this.feeRepository = feeRepository;
    }

    public void xulyTbApPhi(PhytosanitaryFee phytosanitaryFee) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(phytosanitaryFee.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus(Constant07.PayStatus.DA_GUI_TB_AP_PHI.getId());
        regProfileService.update(regProfile);
        feeRepository.save(TbdApphi07.parse(phytosanitaryFee));
        historyService.save(createHistoryLog(regProfile,
                String.format("Thông báo áp phí: %d, note: %s", phytosanitaryFee.getFiTotalFee().longValue(), phytosanitaryFee.getFiNote()),
                phytosanitaryFee.getFiCreaterName()));
    }

    public void xulyTbApPhiBS(PhytosanitaryFee phytosanitaryFee) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(phytosanitaryFee.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus(Constant07.PayStatus.DA_GUI_TB_AP_PHI.getId());
        regProfileService.update(regProfile);
        feeRepository.save(TbdApphi07.parse(phytosanitaryFee));
        historyService.save(createHistoryLog(
                regProfile,
                String.format("Thông báo áp phí bổ sung: %d, note: %s", phytosanitaryFee.getFiTotalFee().longValue(), phytosanitaryFee.getFiNote()),
                phytosanitaryFee.getFiCreaterName()));
    }


    public void xulyTbXacNhanPhi(FeeConfirmation feeConfirmation) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(feeConfirmation.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus(Constant07.PayStatus.DA_XAC_NHAN_TT_PHI.getId());
        regProfileService.update(regProfile);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder contentHistory;
        switch (feeConfirmation.getFiTypeFee()) {
            case 1:
                contentHistory = new StringBuilder(String.format(
                        "Xác nhận thanh toán phí: Thanh toán chuyển khoản<br>" +
                                "Số hóa đơn: %s<br>" +
                                "Số tài khoản: %s<br>" +
                                "Người nộp tiền: %s<br>" +
                                "Ngày nộp tiền: %s<br>" +
                                "Tổng số tiền: %.0f<br>",
                        feeConfirmation.getFiInvoiceNumber(), feeConfirmation.getFiAccountNumber(), feeConfirmation.getFiName(), simpleDateFormat.format(feeConfirmation.getFiDatePayment()), feeConfirmation.getFiTotalFee()));


                break;
            case 2:
                contentHistory = new StringBuilder(String.format(
                        "Xác nhận thanh toán phí: Thanh toán trực tiếp<br>" +
                                "Số hóa đơn: %s<br>" +
                                "Người nộp tiền: %s<br>" +
                                "Ngày nộp tiền: %s<br>" +
                                "Tổng số tiền: %.0f<br>",
                        feeConfirmation.getFiInvoiceNumber(), feeConfirmation.getFiName(), simpleDateFormat.format(feeConfirmation.getFiDatePayment()), feeConfirmation.getFiTotalFee()));
                break;

            case 3:
                contentHistory = new StringBuilder(String.format(
                        "Xác nhận thanh toán phí: Xác nhận cho phép nộp sau<br>" +
                                "Nộp từ ngày: %s<br>" +
                                "Nộp đến ngày: %s<br>",
                        simpleDateFormat.format(feeConfirmation.getFiFromDate()), simpleDateFormat.format(feeConfirmation.getFiToDate())));
                break;
            default:
                throw new NSWException("Thông tin phí không hợp lệ");
        }

        if (!StringUtils.isEmpty(feeConfirmation.getFiNote())) {
            contentHistory.append(String.format("Ghi chú: %s<br>", feeConfirmation.getFiNote()));
        }
        if(CollectionUtils.isNotEmpty(feeConfirmation.getFiAttachmentList())){
            for(int i = 0; i < feeConfirmation.getFiAttachmentList().size(); i++) {
                FeeConfirmationAttachment attachment = feeConfirmation.getFiAttachmentList().get(i);
                contentHistory.append(String.format("<a download=\"%s\" href=\"data:application/octet-stream;base64,%s\">Tải đính kèm %d</a><br>",
                        attachment.getFiFileName(), attachment.getFiFileByte(), (i+1)));
            }
        }

        historyService.save(createHistoryLog(regProfile, contentHistory.toString(), feeConfirmation.getFiCreaterName()));
    }

    private TbdLichsu07 createHistoryLog(TbdHoso07 profile, String historyContent, String exactSenderName) {
        TbdLichsu07 profileHst = new TbdLichsu07();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy(profile.getFiSignName());
        profileHst.setFiSenderUnitName("Cục Thú Y");
        profileHst.setFiSenderName(exactSenderName);
        return profileHst;
    }

}
