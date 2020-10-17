package com.nsw.backend.mard.p01.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p01.client.*;
import com.nsw.backend.mard.p01.constant.Constant01;
import com.nsw.backend.mard.p01.dto.RequestCancelCer;
import com.nsw.backend.mard.p01.dto.RequestEditCer;
import com.nsw.backend.mard.p01.dto.RequestProEdit;
import com.nsw.backend.mard.p01.dto.SendMessage;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.helper.WsServiceHelper;
import com.nsw.backend.mard.p01.model.*;
import com.nsw.backend.mard.p01.repositories.*;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional(rollbackFor = NSWException.class)
public class WsService01Impl implements WsService01 {

    private static final Logger log = LoggerFactory.getLogger(com.nsw.backend.mard.p01.service.WsService01Impl.class);
    private final Tbdcnkd13bRepository tbdcnkd13bRepository;
    private final Tbdhoso01Service regProfileService;
    private final Tbdlichsu01Service hstService;
    private final Tbdcnkd13aRepository tbdcnkd13aRepository;
    private final TbdcnkdCNRepository tbdcnkdCNRepository;
    private final TbdcnkdHKCRepostory tbdcnkdHKCRepostory;
    private final TbdcnkdMRepostory tbdcnkdMRepostory;
    private final TbdcnkdHKPRepostory tbdcnkdHKPRepostory;
    private final Tbdcvkqfail01Repository tbdcvkqfail01Repository;
    private final Environment environment;
    private final TbdtbpdHS01Repository tbdtbpdHS01Repository;
    private final TbdAttachmentFileRepository fileRepository;

    private final GiayCN01Service certService;
    private final Phi01Service feeService;

    private Gson gson;

    @Autowired
    public WsService01Impl(Phi01Service feeService, TbdcnkdCNRepository tbdcnkdCNRepository, Tbdcnkd13bRepository tbdcnkd13bRepository, Tbdhoso01Service regProfileService, Tbdlichsu01Service hstService, Tbdcnkd13aRepository tbdcnkd13aRepository, TbdcnkdHKCRepostory tbdcnkdHKCRepostory, TbdAttachmentFileRepository fileRepository, TbdcnkdMRepostory tbdcnkdMRepostory, TbdcnkdHKPRepostory tbdcnkdHKPRepostory, Tbdcvkqfail01Repository tbdcvkqfail01Repository, Environment environment, TbdtbpdHS01Repository tbdtbpdHS01Repository, GiayCN01Service certService) {
        this.feeService = feeService;
        this.tbdcnkdCNRepository = tbdcnkdCNRepository;
        this.tbdcnkd13bRepository = tbdcnkd13bRepository;
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.tbdcnkd13aRepository = tbdcnkd13aRepository;
        this.tbdcnkdHKCRepostory = tbdcnkdHKCRepostory;
        this.fileRepository = fileRepository;
        this.tbdcnkdMRepostory = tbdcnkdMRepostory;
        this.tbdcnkdHKPRepostory = tbdcnkdHKPRepostory;
        this.tbdcvkqfail01Repository = tbdcvkqfail01Repository;
        this.environment = environment;
        this.tbdtbpdHS01Repository = tbdtbpdHS01Repository;
        this.certService = certService;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }

    private void internalStatusUpdate(Header header, String exactSenderName, long status, String... reasons) throws NSWException {
        if (status != -1) {
            Tbdhoso01 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
            if (regProfile == null) {
                throw new NSWException("Mã hồ sơ không tồn tại: " + header);
            }
            regProfile.setFiHSStatus(status);
            String hstContent;
            if (reasons.length > 0 && !"".equals(reasons[0])) {
                hstContent = reasons[0];
            } else
                hstContent = "Cập nhật trạng thái hồ sơ: " + Constant01.Hoso01Status.findById((int) status).getName();

            if (status == Constant01.Hoso01Status.DONG_Y_HUY_GIAY_CNKD.getId()) {
                certService.markUnsyncCert(regProfile);
            }
            header.getFrom().setName(exactSenderName);
            hstService.save(createHistory(regProfile, hstContent, header));
            regProfileService.save(regProfile);
        } else {
            throw new IllegalArgumentException("Status must not be -1");
        }
    }

    public void internalUpdateLicenseInfo(Header header, Long id, String licenseNo, Integer licenType) {
        try {
            Tbdhoso01 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
            if (regProfile == null) {
                throw new NSWException("Mã hồ sơ không tồn tại");
            }
            regProfile.setFiCNKDId(id);
            regProfile.setFiLicenseNo(licenseNo);
            regProfile.setFiLicenseType(licenType);
            regProfileService.save(regProfile);
        } catch (Exception e) {
            log.error("Có lỗi xảy ra", e);
        }
    }


    @Override
    public ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException {
        UpdateStatusBO statusBO = getGson().fromJson(getGson().toJson(request.getData()), UpdateStatusBO.class);
        internalStatusUpdate(request.getHeader(), "Cục Thú Y", statusBO.getFiTrangthai());
        return new ResponseJson(true, "", "Cập nhật trạng thái hồ sơ thành công");
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(sendMessage.getFiNSWFileCode());
        if (regProfile == null) throw new NSWException("Hồ sơ không tồn tại");
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(sendMessage.getType());
        message.setXmlOnly(Boolean.TRUE);
        if (Constant01.MessageType.TYPE_10.equals(message.getType())) {
            if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.TAO_MOI.getId() ||
                    regProfile.getFiNSWFileCode() == null) {
                message.setFunction(Constant01.MessageFunction.FUNC_01);
            } else if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.CHO_TIEP_NHAN.getId()) {
                message.setFunction(Constant01.MessageFunction.FUNC_02);
            } else if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId()) {
                message.setFunction(Constant01.MessageFunction.FUNC_03);
            } else {
                throw new NSWException("Hồ sơ không hợp lệ");
            }
        } else if (Constant01.MessageType.TYPE_14.equals(message.getType())) {
            message.setType(Constant01.MessageType.TYPE_14);
            message.setFunction(Constant01.MessageFunction.FUNC_08);
            message.setFiReason(sendMessage.getFiReason());
        } else {
            throw new NSWException("Bản tin yêu cầu chưa hỗ trợ ký số");
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant01.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        return response;
    }

    @Override
    public ResponseJson sendProfile(Tbdhoso01 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant01.MessageType.TYPE_10);
        String hstContent = "Gửi mới hồ sơ";
        if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.TAO_MOI.getId() ||
                regProfile.getFiNSWFileCode() == null) {
            message.setFunction(Constant01.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.CHO_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant01.Hoso01Status.DONG_Y_SUA_HS.getId()) {
            hstContent = "Sửa hồ sơ";
            message.setFunction(Constant01.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId()) {
            hstContent = "Gửi cập nhật hồ sơ theo yêu cầu của BNN";
            message.setFunction(Constant01.MessageFunction.FUNC_03);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = WsServiceHelper.createSendRequest(Constant01.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            int statusYCBS = Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId();
            int updateStatus = Constant01.Hoso01Status.CHO_TIEP_NHAN.getId();
            if (regProfile.getFiHSStatus() == statusYCBS) {
                updateStatus = Constant01.Hoso01Status.CHO_TIEP_NHAN_SUA_HS.getId();
            }
            regProfile.setFiHSStatus((long) updateStatus);
            regProfile.setFiCreatedDate(new Date());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, hstContent));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }

    @Override
    public ResponseJson processRequestCancelCer(RequestCancelCer requestCancelCer) throws NSWException {
        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(requestCancelCer.getFiNSWFileCode());
        if (regProfile.getFiHSStatus() != Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId()) {
            throw new NSWException("Hồ chưa được cấp giấy CNKD");
        }

        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant01.MessageType.TYPE_27);
        message.setFunction(Constant01.MessageFunction.FUNC_34);
        message.setFiReason(requestCancelCer.getFiReason());
        ResponseJson response = WsServiceHelper.createSendRequest(Constant01.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            regProfile.setFiHSStatus((long) Constant01.Hoso01Status.YC_HUY_GIAY_CNKD.getId());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Yêu cầu hủy giấy chứng nhận"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi yêu cầu hủy GCN! " + response.getMessage());
        }
        return response;
    }

    @Override
    public ResponseJson processRequestEditCer(RequestEditCer requestEditCer) throws NSWException {
        Tbdhoso01 regProfile = regProfileService.findByFiHSCode(requestEditCer.getFiNSWFileCode());
        if (regProfile.getFiHSStatus() != Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId()) {
            if ((regProfile.getFiHSStatus() == Constant01.Hoso01Status.YC_SUA_GIAY_CNKD.getId()))
                throw new NSWException("Hồ sơ đang xin sửa giấy CNKD");
            throw new NSWException("Hồ chưa được cấp giấy CNKD");
        }
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant01.MessageType.TYPE_29);
        message.setFunction(Constant01.MessageFunction.FUNC_43);
        message.setFiReason(requestEditCer.getFiReason());
        if (requestEditCer.getFiFileName() != null)
            message.setFiFileName(requestEditCer.getFiFileName());
        if (requestEditCer.getFiFileAttack() != null)
            message.setFiFileAttack(requestEditCer.getFiFileAttack());
        ResponseJson response = WsServiceHelper.createSendRequest(Constant01.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            regProfile.setFiHSStatus((long) Constant01.Hoso01Status.YC_SUA_GIAY_CNKD.getId());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Yêu cầu sửa giấy CNKD"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi yêu cầu sửa GCN! " + response.getMessage());
        }
        return response;
    }

    @Override
    public ResponseJson processCertificateForAnimal(ResponseWrapper request) throws NSWException {
        // lấy dữ
        CertificateForAnimal certificateForAnimal = getGson().fromJson(getGson().toJson((request.getData())), CertificateForAnimal.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateForAnimal.setFiNSWFileCode(requestSubject.getReference());
        Tbdhoso01 tbdhoso01 = regProfileService.findByFiHSCode(requestSubject.getReference());
        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_20:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateForAnimal.getFiNote() != null) {
                    hstContent += "Note: " + certificateForAnimal.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_37:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu 13A";
                break;
            case Constant01.MessageFunction.FUNC_45:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(),
                certificateForAnimal.getFiSignResultName(),
                Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(),
                hstContent);
        TbdAttachmentFile01 file = new TbdAttachmentFile01();
        file.setFiContent(certificateForAnimal.getFiHealthCertificateFile());
        file.setFiTaxCode(tbdhoso01.getFiTaxCode());
        file.setFiActive(true);
        file = fileRepository.save(file);
        Tbdcnkd13a01 tbdcnkd13A01 = new Tbdcnkd13a01();
        BeanUtils.copyProperties(certificateForAnimal, tbdcnkd13A01);
        tbdcnkd13A01.setFiAnimalList(new ArrayList<>());
        certificateForAnimal.getFiAnimalList().forEach(animalProduct -> {
            Tbddongvat13a01 tbddongvat13A01 = new Tbddongvat13a01();
            BeanUtils.copyProperties(animalProduct, tbddongvat13A01);
            tbdcnkd13A01.setFiNSWFileCode(tbdcnkd13A01.getFiNSWFileCode());
            tbdcnkd13A01.getFiAnimalList().add(tbddongvat13A01);
        });
        tbdcnkd13A01.setFiAttachmentID(file.getFiID());
        tbdcnkd13aRepository.save(tbdcnkd13A01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkd13A01.getFiIdCNKD13A(),
                tbdcnkd13A01.getFiHealthCertificateNo(), Constant01.Hoso01LicenseType.MAU_13A.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateProductAnimal(ResponseWrapper request) throws NSWException {
        // lấy được dữ liệu
        CertificateProductAnimal certificateProductAnimal = getGson().fromJson(getGson().toJson((request.getData())), CertificateProductAnimal.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateProductAnimal.setFiNSWFileCode(requestSubject.getReference());
        Tbdhoso01 tbdhoso01 = regProfileService.findByFiHSCode(requestSubject.getReference());
        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_21:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateProductAnimal.getFiNote() != null) {
                    hstContent += "Note: " + certificateProductAnimal.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_38:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu 13B";
                break;
            case Constant01.MessageFunction.FUNC_46:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(), certificateProductAnimal.getFiSignResultName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);

        TbdAttachmentFile01 file = new TbdAttachmentFile01();
        file.setFiContent(certificateProductAnimal.getFiHealthCertificateFile());
        file = fileRepository.save(file);
        file.setFiTaxCode(tbdhoso01.getFiTaxCode());
        file.setFiActive(true);
        Tbdcnkd13b01 tbdcnkd13B01 = new Tbdcnkd13b01();
        BeanUtils.copyProperties(certificateProductAnimal, tbdcnkd13B01);
        tbdcnkd13B01.setFiAnimalProductList(new ArrayList<>());
        if (certificateProductAnimal.getFiAnimalProductList() != null)
            certificateProductAnimal.getFiAnimalProductList().forEach(animalProduct -> {
                Tbdspdv13b01 animalProductDoc = new Tbdspdv13b01();
                BeanUtils.copyProperties(animalProduct, animalProductDoc);
                animalProductDoc.setFiNSWFileCode(requestSubject.getReference());
                tbdcnkd13B01.getFiAnimalProductList().add(animalProductDoc);
            });

        tbdcnkd13B01.setFiAttachmentID(file.getFiID());
        tbdcnkd13bRepository.save(tbdcnkd13B01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkd13B01.getFiIdCNKD13B(),
                tbdcnkd13B01.getFiHealthCertificateNo(), Constant01.Hoso01LicenseType.MAU_13B.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateHongKongPig(ResponseWrapper request) throws NSWException {
        CertificateHongKongPig certificateHongKongPig = getGson().fromJson(getGson().toJson((request.getData())), CertificateHongKongPig.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateHongKongPig.setFiNSWFileCode(requestSubject.getReference());

        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_22:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateHongKongPig.getFiNote() != null) {
                    hstContent += "Note: " + certificateHongKongPig.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_39:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu Hong Kong Pig";
                break;
            case Constant01.MessageFunction.FUNC_47:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(), certificateHongKongPig.getFiSignResultName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);

        TbdcnkdHKP01 tbdcnkdHKP01 = new TbdcnkdHKP01();
        BeanUtils.copyProperties(certificateHongKongPig, tbdcnkdHKP01);
        tbdcnkdHKP01.setFiAnimalProductList(new ArrayList<>());
        if (certificateHongKongPig.getFiAnimalProductList() != null)
            certificateHongKongPig.getFiAnimalProductList().forEach(animalProduct -> {
                TbdAnimailProductHKP01 tbdAnimailProductHKP01 = new TbdAnimailProductHKP01();
                BeanUtils.copyProperties(animalProduct, tbdAnimailProductHKP01);
                tbdAnimailProductHKP01.setFiNSWFileCode(requestSubject.getReference());
                tbdcnkdHKP01.getFiAnimalProductList().add(tbdAnimailProductHKP01);
            });
        tbdcnkdHKPRepostory.save(tbdcnkdHKP01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkdHKP01.getFiIdCNKDHKP(),
                tbdcnkdHKP01.getFiHealthCertificateNoVni(), Constant01.Hoso01LicenseType.MAU_HK_PIG.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateMalaysia(ResponseWrapper request) throws NSWException {
        CertificateMalaysia certificateMalaysia = getGson().fromJson(getGson().toJson((request.getData())), CertificateMalaysia.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateMalaysia.setFiNSWFileCode(requestSubject.getReference());

        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_23:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateMalaysia.getFiNote() != null) {
                    hstContent += "Note: " + certificateMalaysia.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_40:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu Malaysia";
                break;
            case Constant01.MessageFunction.FUNC_48:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(), certificateMalaysia.getFiSignResultName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);

        TbdcnkdM01 tbdcnkdM01 = new TbdcnkdM01();
        BeanUtils.copyProperties(certificateMalaysia, tbdcnkdM01);
        tbdcnkdM01.setFiAnimalProductList(new ArrayList<>());
        if (certificateMalaysia.getFiAnimalProductList() != null)
            certificateMalaysia.getFiAnimalProductList().forEach(animalProduct -> {
                TbdAnimailProductM01 tbdAnimailProductM01 = new TbdAnimailProductM01();
                BeanUtils.copyProperties(animalProduct, tbdAnimailProductM01);
                tbdAnimailProductM01.setFiNSWFileCode(requestSubject.getReference());
                tbdcnkdM01.getFiAnimalProductList().add(tbdAnimailProductM01);
            });
        tbdcnkdMRepostory.save(tbdcnkdM01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkdM01.getFiIdCNKDM(),
                tbdcnkdM01.getFiHealthCertificateNoVni(), Constant01.Hoso01LicenseType.MAU_MALAY_SPDV.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateHongKongChicken(ResponseWrapper request) throws NSWException {
        CertificateHongKongChicken certificateHongKongChicken = getGson().fromJson(getGson().toJson((request.getData())), CertificateHongKongChicken.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateHongKongChicken.setFiNSWFileCode(requestSubject.getReference());
        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_24:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateHongKongChicken.getFiNote() != null) {
                    hstContent += "Note: " + certificateHongKongChicken.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_41:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu HongKongChicken";
                break;
            case Constant01.MessageFunction.FUNC_49:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(), certificateHongKongChicken.getFiSignResultName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);


        TbdcnkdHKC01 tbdcnkdHKC01 = new TbdcnkdHKC01();
        BeanUtils.copyProperties(certificateHongKongChicken, tbdcnkdHKC01);
        tbdcnkdHKC01.setFiAnimalProductList(new ArrayList<>());
        if (certificateHongKongChicken.getFiAnimalProductList() != null)
            certificateHongKongChicken.getFiAnimalProductList().forEach(animalProduct -> {
                TbdAnimailProductHKC01 tbdAnimailProductHKC01 = new TbdAnimailProductHKC01();
                BeanUtils.copyProperties(animalProduct, tbdAnimailProductHKC01);
                tbdAnimailProductHKC01.setFiNSWFileCode(requestSubject.getReference());
                tbdcnkdHKC01.getFiAnimalProductList().add(tbdAnimailProductHKC01);
            });
        tbdcnkdHKCRepostory.save(tbdcnkdHKC01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkdHKC01.getFiIdCNKDHKC(),
                tbdcnkdHKC01.getFiHealthCertificateNo(), Constant01.Hoso01LicenseType.MAU_HK_CHICKEN.getId());

        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateChina(ResponseWrapper request) throws NSWException {
        CertificateChina certificateChina = getGson().fromJson(getGson().toJson((request.getData())), CertificateChina.class);
        Subject requestSubject = request.getHeader().getSubject();
        certificateChina.setFiNSWFileCode(requestSubject.getReference());
        String hstContent;
        String function = requestSubject.getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_25:
                hstContent = "Cập nhật trạng thái hồ sơ: Đã cấp giấy chứng nhận <br>";
                if (certificateChina.getFiNote() != null) {
                    hstContent += "Note: " + certificateChina.getFiNote();
                }
                break;
            case Constant01.MessageFunction.FUNC_43:
                hstContent = "BNN sửa thông tin giấy CNKD mẫu China";
                break;
            case Constant01.MessageFunction.FUNC_50:
                hstContent = "BNN đồng ý sửa giấy chứng nhận kiểm dịch";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        internalStatusUpdate(request.getHeader(), certificateChina.getFiSignResultName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);

        TbdcnkdChina01 tbdcnkdChina01 = new TbdcnkdChina01();
        BeanUtils.copyProperties(certificateChina, tbdcnkdChina01);
        tbdcnkdChina01.setFiAnimalProductList(new ArrayList<>());
        if (certificateChina.getFiAnimalProductList() != null)
            certificateChina.getFiAnimalProductList().forEach(animalProduct -> {
                TbdAnimailProductCN01 tbdAnimailProductCN01 = new TbdAnimailProductCN01();
                BeanUtils.copyProperties(animalProduct, tbdAnimailProductCN01);
                tbdAnimailProductCN01.setFiNSWFileCode(requestSubject.getReference());
                tbdcnkdChina01.getFiAnimalProductList().add(tbdAnimailProductCN01);
            });
        tbdcnkdCNRepository.save(tbdcnkdChina01);
        internalUpdateLicenseInfo(request.getHeader(), tbdcnkdChina01.getFiIdCNKDCN(),
                tbdcnkdChina01.getFiHealthCertificateNoVni(), Constant01.Hoso01LicenseType.MAU_TQ_SPDV.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processPhytosanitaryFee(ResponseWrapper request) throws NSWException {
        PhytosanitaryFee phytosanitaryFee = getGson().fromJson(getGson().toJson((request.getData())), PhytosanitaryFee.class);
        Subject requestSubject = request.getHeader().getSubject();
        phytosanitaryFee.setFiNSWFileCode(requestSubject.getReference());
        feeService.xulyTbApphi(phytosanitaryFee);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processFeeRequest(ResponseWrapper request) throws NSWException {
        FeeRequest feeRequest = getGson().fromJson(getGson().toJson((request.getData())), FeeRequest.class);
        Subject requestSubject = request.getHeader().getSubject();
        feeRequest.setFiNSWFileCode(requestSubject.getReference());
        feeService.xulyTbXacNhanPhi(feeRequest);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processResult(ResponseWrapper request) throws NSWException {
        ResultConfirm result = getGson().fromJson(getGson().toJson((request.getData())), ResultConfirm.class);
        Subject requestSubject = request.getHeader().getSubject();
        result.setFiNSWFileCode(requestSubject.getReference());
        Tbdkqtd01 tbdkqtd01 = new Tbdkqtd01();
        BeanUtils.copyProperties(result, tbdkqtd01);
        String function = request.getHeader().getSubject().getFunction();
        String hstContent = "";

        int status;
        switch (function) {
            case Constant01.MessageFunction.FUNC_05:
                status = Constant01.Hoso01Status.BI_TU_CHOI.getId();
                break;
            case Constant01.MessageFunction.FUNC_06:
                status = Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId();
                break;
            // Đồng ý tiếp nhận hồ sơ
            case Constant01.MessageFunction.FUNC_07:
                status = Constant01.Hoso01Status.DA_TIEP_NHAN.getId();
                Tbdhoso01 tbdhoso01 = regProfileService.findByFiHSCode(requestSubject.getReference());
                tbdhoso01.setFiRegistrationNo(result.getFiRegistationConfirmNo());
                tbdhoso01.setFiRegistrationDate(result.getFiRegistationConfirmDate());
                tbdhoso01.setFiCheckPlace(result.getFiCheckPlace());
                tbdhoso01.setFiCheckTime(result.getFiCheckTime());
                tbdhoso01.setFiCreaterName(result.getFiCreaterName());
                regProfileService.save(tbdhoso01);
                TbdPheDuyetHS01 duyetHS01 = new TbdPheDuyetHS01();
                BeanUtils.copyProperties(result, duyetHS01);
                tbdtbpdHS01Repository.save(duyetHS01);
                break;
            // trước khi soạn GCN
            case Constant01.MessageFunction.FUNC_14:
                status = Constant01.Hoso01Status.BI_TU_CHOI.getId();
                break;
            case Constant01.MessageFunction.FUNC_15:
                status = Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId();
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        if (result.getFiReason() != null) {
            hstContent = "Cập nhật trạng thái hồ sơ: " + Constant01.Hoso01Status.findById(status).getName()
                    + " <br>Lý do: " + result.getFiReason();
        }
        internalStatusUpdate(request.getHeader(), result.getFiCreaterName(), status, hstContent);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateResponseEdit(ResponseWrapper request) throws NSWException {
        ProResponseEdit proResponseEdit = getGson().fromJson(getGson().toJson((request.getData())), ProResponseEdit.class);
        Subject requestSubject = request.getHeader().getSubject();
        proResponseEdit.setFiNSWFileCode(requestSubject.getReference());
        int status;
        String mess;
        String hstContent = "";
        if (proResponseEdit.getFiReason() != null) {
            hstContent = "Lý do: " + proResponseEdit.getFiReason();
        }
        String function = request.getHeader().getSubject().getFunction();
        switch (function) {
            case Constant01.MessageFunction.FUNC_09:
                status = Constant01.Hoso01Status.DONG_Y_SUA_HS.getId();
                mess = "BNN đồng ý sửa hồ sơ";
                break;
            case Constant01.MessageFunction.FUNC_10:
                status = Constant01.Hoso01Status.TU_CHOI_SUA_HS.getId();
                mess = "BNN từ chối sửa hồ sơ";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }

        if (Constant01.MessageFunction.FUNC_10.equals(function)) {
            Tbdhoso01 currentHS = regProfileService.findByFiHSCode(requestSubject.getReference());
            Tbdhoso01 archivedHS = regProfileService.findById(currentHS.getFiIdHSParent());
            archivedHS.setFiActive(true);
            currentHS.setFiActive(false);

            regProfileService.save(currentHS);
            regProfileService.save(archivedHS);
        }

        internalStatusUpdate(request.getHeader(), proResponseEdit.getFiCreaterName(), status, mess + "<br>" + hstContent);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processResponseCancel(ResponseWrapper request) throws NSWException {
        ResponseCancel responseCancel = getGson().fromJson(getGson().toJson((request.getData())), ResponseCancel.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseCancel.setFiNSWFileCode(requestSubject.getReference());
        String function = request.getHeader().getSubject().getFunction();
        int status;
        String hstContent;
        switch (function) {
            case Constant01.MessageFunction.FUNC_12:
                status = Constant01.Hoso01Status.DA_RUT_HS.getId();
                hstContent = "BNN đồng ý rút hồ sơ <br>";
                break;
            case Constant01.MessageFunction.FUNC_13:
                status = Constant01.Hoso01Status.TU_CHOI_RUT_HS.getId();
                hstContent = "BNN từ chối rút hồ sơ <br>";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        if (responseCancel.getFiReason() != null) {
            hstContent += "Nội dung : " + responseCancel.getFiReason();
        }
        internalStatusUpdate(request.getHeader(), responseCancel.getFiCreaterName(), status, hstContent);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson requestCancelProfile(RequestProEdit requestProEdit) throws NSWException {
        Tbdhoso01 regProfile = requestProEdit.getFiRegistrationProfile();
        SendMessage message = SendMessage.parse(regProfile);
        message.setFiReason(requestProEdit.getFiReason());
        message.setFiNSWFileCode(regProfile.getFiNSWFileCode());
        message.setFiIdHoso(regProfile.getFiIdHS());
        message.setFiNguoitao(regProfile.getFiSignName());

        if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.DA_TIEP_NHAN.getId() ||
                regProfile.getFiHSStatus() == Constant01.Hoso01Status.TU_CHOI_RUT_HS.getId()
        ) {
            message.setType(Constant01.MessageType.TYPE_16);
            message.setFunction(Constant01.MessageFunction.FUNC_11);
        } else if (regProfile.getFiHSStatus() == Constant01.Hoso01Status.CHO_TIEP_NHAN.getId() ||
                regProfile.getFiHSStatus() == Constant01.Hoso01Status.DA_RUT_HS.getId() ||
                regProfile.getFiHSStatus() == Constant01.Hoso01Status.DONG_Y_SUA_HS.getId() ||
                regProfile.getFiHSStatus() == Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId()
        ) {
            message.setType(Constant01.MessageType.TYPE_11);
            message.setFunction(Constant01.MessageFunction.FUNC_04);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        return WsServiceHelper.createSendRequest(Constant01.WebServiceURL.get(environment), message);

    }

    @Override
    public ResponseJson processNotificationFailed(ResponseWrapper request) throws NSWException {
        NotificationFailed notificationFailed = getGson().fromJson(getGson().toJson((request.getData())), NotificationFailed.class);
        Subject requestSubject = request.getHeader().getSubject();
        notificationFailed.setFiNSWFileCode(requestSubject.getReference());
        Tbdcvkqfail01 tbdcvkqfail01 = new Tbdcvkqfail01();
        Tbdhoso01 tbdhoso01 = regProfileService.findByFiHSCode(requestSubject.getReference());
        TbdAttachmentFile01 file = new TbdAttachmentFile01();
        file.setFiContent(notificationFailed.getFiDispatchFile());
        file.setFiFileName(notificationFailed.getFiFileName());
        file.setFiTaxCode(tbdhoso01.getFiTaxCode());
        file = fileRepository.save(file);
        BeanUtils.copyProperties(notificationFailed, tbdcvkqfail01);
        tbdcvkqfail01.setFiAttachmentID(file.getFiID());
        tbdcvkqfail01Repository.save(tbdcvkqfail01);
        internalStatusUpdate(request.getHeader(), notificationFailed.getFiCreaterName(), Constant01.Hoso01Status.LO_HANG_KHONG_DAT.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processResponseCancelCer(ResponseWrapper request) throws NSWException {
        ResponseCancelCer responseCancelCer = getGson().fromJson(getGson().toJson((request.getData())), ResponseCancelCer.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseCancelCer.setFiNSWFileCode(requestSubject.getReference());
        int status;
        String function = request.getHeader().getSubject().getFunction();
        String mess;
        switch (function) {
            case Constant01.MessageFunction.FUNC_35:
                status = Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId();
                mess = "BNN từ chối hủy GCN";
                break;
            case Constant01.MessageFunction.FUNC_36:
                status = Constant01.Hoso01Status.DONG_Y_HUY_GIAY_CNKD.getId();
                mess = "BNN đồng ý hủy GCN";
                break;
            default:
                throw new NSWException("Invalid Function " + function + " on ProfileRegistration Response");
        }
        if (responseCancelCer.getFiReason() != null) {
            mess = mess + "<br>Lý do: " + responseCancelCer.getFiReason();
        }
        internalStatusUpdate(request.getHeader(), "Cục Thú Y", status, mess);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processResponseEditCer(ResponseWrapper request) throws NSWException {
        ResponseEditCer responseEditCer = getGson().fromJson(getGson().toJson((request.getData())), ResponseEditCer.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseEditCer.setFiNSWFileCode(requestSubject.getReference());
        String hstContent = "BNN từ chối sửa GCNKD";
        if (responseEditCer.getFiReason() != null) {
            hstContent += " <br>Lý do: " + responseEditCer.getFiReason();
        }
        internalStatusUpdate(request.getHeader(), responseEditCer.getFiCreaterName(), Constant01.Hoso01Status.DA_CAP_GIAY_CNKD.getId(), hstContent);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson updateProfile(RequestProEdit requestProEdit) {
        Tbdhoso01 tbdhoso01 = new Tbdhoso01();
        BeanUtils.copyProperties(requestProEdit.getFiRegistrationProfile(), tbdhoso01);
        SendMessage message = SendMessage.parse(tbdhoso01);
        message.setType(Constant01.MessageType.TYPE_14);
        message.setFunction(Constant01.MessageFunction.FUNC_08);
        message.setFiReason(requestProEdit.getFiReason());
        return createSendRequest(Constant01.WebServiceURL.get(environment), message);
    }

    private static ResponseJson createSendRequest(String url, SendMessage sendData) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
        return restTemplate.postForObject(url, entity, ResponseJson.class);
    }

    private Tbdlichsu01 createHistory(Tbdhoso01 regProfile, String hstContent, Header sendHeader) {
        Tbdlichsu01 history = new Tbdlichsu01();
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiNSWFileCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(sendHeader.getFrom().getName());
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        history.setFiNSWFileCode(regProfile.getFiNSWFileCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            history.setFiSenderUnitName(String.format("%s",
                    sendHeader.getFrom().getUnitCode()));
        }
        if(history.getFiSenderCode().equals("MARD")){
            history.setFiSenderUnitName("Cục Thú Y");
        }
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }

    private Tbdlichsu01 createHistory(Tbdhoso01 regProfile, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant01.SENDER.CODE);
        from.setUnitName(regProfile.getFiExporterNameVni());
        from.setName(regProfile.getFiTaxCode());
        from.setIdentity(regProfile.getFiTaxCode());
        header.setFrom(from);
        return createHistory(regProfile, hstContent, header);
    }

}
