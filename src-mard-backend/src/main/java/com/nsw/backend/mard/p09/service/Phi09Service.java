package com.nsw.backend.mard.p09.service;

import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p09.client.Header;
import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.mard.p09.dto.receive.AnimalFee;
import com.nsw.backend.mard.p09.dto.receive.AnimalFeeConfirmation;
import com.nsw.backend.mard.p09.exception.NSWException;
import com.nsw.backend.mard.p09.model.Tbdhoso09;
import com.nsw.backend.mard.p09.model.Tbdlichsu09;
import com.nsw.backend.mard.p09.model.Tbdtbapphi09;
import com.nsw.backend.mard.p09.repositories.TbdTbApphi09Repository;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class Phi09Service {

    private final Tbdhoso09Service regProfileService;

    private final Tbdlichsu09Service historyService;

    private final TbdTbApphi09Repository feeRepository;

    @Autowired
    public Phi09Service(Tbdhoso09Service regProfileService, Tbdlichsu09Service historyService, TbdTbApphi09Repository feeRepository) {
        this.regProfileService = regProfileService;
        this.historyService = historyService;
        this.feeRepository = feeRepository;
    }

    public void xulyTbApPhi(AnimalFee animalFee, Header header) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(animalFee.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus((long) Constant09.PayStatus.DA_GUI_TB_AP_PHI.getId());
        regProfileService.update(regProfile);
        feeRepository.save(Tbdtbapphi09.parse(animalFee));
        header.getFrom().setUnitName(animalFee.getFiDepartment());
        header.getFrom().setName(animalFee.getFiCreaterName());
        historyService.save(createHistoryLog(regProfile, String.format("Thông báo áp phí: %s, %s, note: %s",
                Phi09Service.formatDouble(animalFee.getFiTotalFee()),
                animalFee.getFiAmountInWords(),
                animalFee.getFiNote()), header, animalFee.getFiCreaterName()));
    }

    public void xulyTbApPhiBS(AnimalFee animalFee, Header header) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(animalFee.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus((long) Constant09.PayStatus.DA_GUI_TB_AP_PHI.getId());
        regProfileService.update(regProfile);
        feeRepository.save(Tbdtbapphi09.parse(animalFee));
        header.getFrom().setUnitName(animalFee.getFiDepartment());
        header.getFrom().setName(animalFee.getFiCreaterName());
        historyService.save(createHistoryLog(
                regProfile,
                String.format("Thông báo áp phí bổ sung: %s, note: %s", animalFee.getFiTotalFee(), animalFee.getFiNote()), header, animalFee.getFiCreaterName()));
    }

    public void xulyTbXacNhanPhi(AnimalFeeConfirmation feeConfirmation, Header header) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(feeConfirmation.getFiNSWFileCode());
        if (regProfile == null) {
            throw new NSWException("Thông tin áp phí không hợp lệ");
        }
        regProfile.setFiPaymentStatus((long) Constant09.PayStatus.DA_XAC_NHAN_TT_PHI.getId());
        regProfileService.update(regProfile);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String contentHistory;
        switch (feeConfirmation.getFiTypeFee()) {
            case 1:
                contentHistory =
                        String.format(
                                "Xác nhận thanh toán phí: Thanh toán chuyển khoản<br>" +
                                        "Số hóa đơn: %s<br>" +
                                        "Số tài khoản: %s<br>" +
                                        "Người nộp tiền: %s<br>" +
                                        "Ngày nộp tiền: %s<br>" +
                                        "Tổng số tiền: %d<br>",
                                feeConfirmation.getFiInvoiceNumber(), feeConfirmation.getFiAccountNumber(), feeConfirmation.getFiName(), simpleDateFormat.format(feeConfirmation.getFiDatePayment()), feeConfirmation.getFiTotalFee());


                break;
            case 2:
                contentHistory =
                        String.format(
                                "Xác nhận thanh toán phí: Thanh toán trực tiếp<br>" +
                                        "Số hóa đơn: %s<br>" +
                                        "Người nộp tiền: %s<br>" +
                                        "Ngày nộp tiền: %s<br>" +
                                        "Tổng số tiền: %d<br>",
                                feeConfirmation.getFiInvoiceNumber(), feeConfirmation.getFiName(), simpleDateFormat.format(feeConfirmation.getFiDatePayment()), feeConfirmation.getFiTotalFee());
                break;

            case 3:
                contentHistory =
                        String.format(
                                "Xác nhận thanh toán phí: Xác nhận cho phép nộp sau<br>" +
                                        "Tổng số tiền: %d<br>" +
                                        "Nộp từ ngày: %s<br>" +
                                        "Nộp đến ngày: %s<br>",
                                feeConfirmation.getFiTotalFee(), simpleDateFormat.format(feeConfirmation.getFiFromDate()), simpleDateFormat.format(feeConfirmation.getFiToDate()));
                break;
            default:
                throw new NSWException("Thông tin phí không hợp lệ");
        }


        if (!StringUtils.isEmpty(feeConfirmation.getFiNote())) {
            contentHistory += String.format("Ghi chú: %s<br>", feeConfirmation.getFiNote());
        }

        if (!TextUtils.isEmpty(feeConfirmation.getFiFileName())) {
            contentHistory += String.format("<a download=\"%s\" href=\"data:application/octet-stream;base64,%s\">Tải đính kèm </a>",
                    feeConfirmation.getFiFileName(), feeConfirmation.getFiFileByte());
        }

        historyService.save(createHistoryLog(regProfile, contentHistory, header, feeConfirmation.getFiCreaterName()));

    }

    private Tbdlichsu09 createHistoryLog(Tbdhoso09 regProfile, String hstContent, Header sendHeader, String exactSenderName) {
        Tbdlichsu09 history = new Tbdlichsu09();
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiHSCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(exactSenderName);
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            history.setFiSenderUnitName(CmonHelper.instance().getUnitNameByUnitCode(sendHeader.getFrom().getUnitCode()));
        }
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }

    public static String formatDouble(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
}
