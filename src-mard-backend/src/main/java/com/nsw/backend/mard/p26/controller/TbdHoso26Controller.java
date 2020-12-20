package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.helper.RabbitMQErrorHelper;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHanghoaAT25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbdHangHoa25Service;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.model.*;
import com.nsw.backend.mard.p26.service.TbdHoso26Service;
import com.nsw.backend.mard.p26.service.TbdLichsu26Service;
import com.nsw.backend.mard.p26.service.WebService26;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mard/26/hoso")
public class TbdHoso26Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(TbdHoso26Controller.class);
    private static final String TAG = "Tbdhoso26Controller";
    private final RabbitMQService rabbitMQService;
    private final TbdHoso26Service tbdHoso26Service;
    private final TbdLichsu26Service tbdLichsu26Service;
    private final TbdHangHoa25Service tbdHangHoa25Service;
    private final WebService26 webService26;
    @Autowired
    public TbdHoso26Controller(RabbitMQService rabbitMQService, TbdHoso26Service tbdHoso26Service, TbdLichsu26Service tbdLichsu26Service, WebService26 webService26, TbdHangHoa25Service tbdHangHoa25Service) {
        this.rabbitMQService = rabbitMQService;
        this.tbdHoso26Service = tbdHoso26Service;
        this.tbdLichsu26Service = tbdLichsu26Service;
        this.webService26 = webService26;
        this.tbdHangHoa25Service = tbdHangHoa25Service;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseJson> createHoso(@RequestBody TbdHoso26 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }
            TbdHanghoa26 tbdHanghoa26 = profile.getFiProductList().get(0);
            profile.setFiHangSX(tbdHanghoa26.getFiProMadeIn());
            profile.setFiNuocSX(tbdHanghoa26.getFiProCountryName());
            TbdHanghoa25 tbdHanghoa25 = tbdHangHoa25Service.findByFiIdProduct(tbdHanghoa26.getFiIdProduct());
            tbdHanghoa26= copyPropertiesHangHoa(tbdHanghoa25,tbdHanghoa26);

            List<TbdHanghoa26> hanghoa26List = new ArrayList<>();
            hanghoa26List.add(tbdHanghoa26);
            profile.setFiProductList(hanghoa26List);

            TbdHoso26 result = saveDraftTbdhoso26(profile);
            return createSuccessResponse(result, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    private TbdHoso26 saveDraftTbdhoso26(@RequestBody TbdHoso26 tbdHoso26) {
        String historyContent;
        if (tbdHoso26.getFiIdHoSo26() == null || tbdHoso26.getFiTrangthai() == null) {
            tbdHoso26.setFiTrangthai(Constant26.HosoStatus.TAO_MOI.getId());
            tbdHoso26.setFiNgaytao(new Date());
            tbdHoso26 = tbdHoso26Service.create(tbdHoso26);
            historyContent = "Tạo mới hồ sơ";
        } else {
            tbdHoso26 = tbdHoso26Service.update(tbdHoso26);
            historyContent = "Cập nhật hồ sơ";
        }
        TbdLichsu26 profileHst = new TbdLichsu26();
        profileHst.setFiIdHS(tbdHoso26.getFiIdHoSo26());
        profileHst.setFiHSCode(tbdHoso26.getFiMaHoso());
        profileHst.setFiStatus(tbdHoso26.getFiTrangthai());
        profileHst.setFiSenderCode(tbdHoso26.getFiCreatedBy());
        profileHst.setFiSenderUnitName(tbdHoso26.getFiTenDn());
        profileHst.setFiSenderName(tbdHoso26.getFiTenDn());
        profileHst.setFiContent(historyContent);
        tbdLichsu26Service.save(profileHst);
        return tbdHoso26;
    }
    @PostMapping("/timkiem")
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterForm filterForm) {
        return createSuccessResponse(tbdHoso26Service.searchHoso(filterForm), HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<ResponseJson> findById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String taxCode,
            @RequestParam(required = false) String nswFileCode) {
        TbdHoso26 regProfile;
        if (StringUtils.isNotEmpty(nswFileCode)) {
            regProfile = tbdHoso26Service.findByFiHSCode(nswFileCode);
        } else if (StringUtils.isNotEmpty(id)) {
            regProfile = tbdHoso26Service.findById(Integer.parseInt(id));
        } else {
            regProfile = null;
        }
        if (regProfile != null
                && StringUtils.isNotEmpty(taxCode)
                && taxCode.equals(regProfile.getFiMasothue()) == false) {
            regProfile = null;
        }
        return createSuccessResponse(regProfile, HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseJson> sendHoso(@RequestBody TbdHoso26 profile) {
        try {
            if (profile == null) {
                return createErrorResponse("No content", HttpStatus.NO_CONTENT);
            }

            TbdHoso26 result = saveDraftTbdhoso26(profile);
            TbdLichsu26 profileHst = new TbdLichsu26();
            profileHst.setFiIdHS(result.getFiIdHoSo26());
            profileHst.setFiHSCode(result.getFiMaHoso());
            profileHst.setFiStatus(result.getFiTrangthai());
            profileHst.setFiSenderCode(result.getFiCreatedBy());
            profileHst.setFiSenderName(result.getFiMasothue());
            profileHst.setFiSenderUnitName(result.getFiTenDn());
            profileHst.setFiContent("Cập nhập hồ sơ");
            profile.setFiTrangthai(profile.getFiTrangthai());
            profileHst.setFiStatus(profile.getFiTrangthai());
            tbdHoso26Service.update(profile);
            tbdLichsu26Service.save(profileHst);

            List<TbdHoso26> tbdHoso26List = checkTonTaiCongVanMienKiem(profile);
            if (null==tbdHoso26List||tbdHoso26List.isEmpty()){
                ResponseJson response = webService26.sendHoso26(result);
                return createResponse(null, response.isSuccess(),
                        response.isSuccess() ?
                                "Hồ sơ đã gửi thành công!" :
                                "Có lỗi trong quá trình gửi! " + response.getMessage(), HttpStatus.OK);
            }
            else{
                return createResponse(null,false, "Bạn đã được cấp công văn số: "+tbdHoso26List.get(0).getFiSoCVMienKiem()
                        +" vào ngày: "+tbdHoso26List.get(0).getFiNgayKyCV()+". Bạn không thể xin cấp công văn trước khi hiệu lực của công văn: " +tbdHoso26List.get(0).getFiSoCVMienKiem() +
                        " hết hạn vào ngày "+tbdHoso26List.get(0).getFiHieuLucToiNgay(), HttpStatus.OK);
            }


        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    private List<TbdHoso26> checkTonTaiCongVanMienKiem(TbdHoso26 tbdHoso26){
        List<TbdHoso26> tbdHoso26List=tbdHoso26Service.findCongVanMienKiem(new Date(),tbdHoso26.getFiMasothue());
        return tbdHoso26List;
    }
    @GetMapping("/delete")
    public ResponseEntity<ResponseJson> deleteHoso(
            @RequestParam Integer fiIdHS,
            @RequestParam String fiTaxCode) {
        try {
            TbdHoso26 regProfile = tbdHoso26Service.findById(fiIdHS);
            if (regProfile == null || !regProfile.getFiMasothue().equals(fiTaxCode)) {
                throw new IllegalArgumentException("Hồ sơ không thuộc đơn vị đăng ký");
            } else {
                regProfile.setFiActive(false);
                tbdHoso26Service.update(regProfile);
                return createResponse("", true, "", HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error(TAG + ex.getMessage(), ex);
            RabbitMQErrorHelper.pushLogToRabbitMQ(getErrorInfo(TAG, ex), rabbitMQService.getRabbitMQInfo());
            return createErrorResponse(ex.getMessage(), HttpStatus.OK);
        }
    }
    @GetMapping("/history")
    public ResponseEntity<ResponseJson> getListByHSCode(@RequestParam Integer fiIdHs,
                                                        @RequestParam(required = false) Integer p,
                                                        @RequestParam(required = false) Integer s) {
        if (p == null) {
            return createSuccessResponse(tbdLichsu26Service.findByFiIdHS(fiIdHs), HttpStatus.OK);
        } else {
            PageRequest pageRequest = new PageRequest(p, s);
            ResponseJson response = new ResponseJson();
            Page<TbdLichsu26> tbdLichsu26s=tbdLichsu26Service.findByFiIdHSOrderByFiCreatedDate(fiIdHs,pageRequest);
            response.setTotal(tbdLichsu26s.getTotalElements());
            response.setSuccess(true);
            response.setData(tbdLichsu26s.getContent());
            return ResponseEntity.ok(response);
        }
    }
    private TbdHanghoa26 copyPropertiesHangHoa(TbdHanghoa25 tbdHanghoa25, TbdHanghoa26 tbdHanghoa26){
        List<TbdHanghoaCL26> listCL26 = new ArrayList<>();
        List<TbdHanghoaAT26> listAT26 = new ArrayList<>();
        tbdHanghoa25.getFiProCLList().forEach(cl ->{
            TbdHanghoaCL26 tbdHanghoaCL26 = new TbdHanghoaCL26();
            BeanUtils.copyProperties(cl,tbdHanghoaCL26);
            listCL26.add(tbdHanghoaCL26);
        });
        tbdHanghoa25.getFiProATList().forEach(at ->{
            TbdHanghoaAT26 tbdHanghoaAT26 = new TbdHanghoaAT26();
            BeanUtils.copyProperties(at,tbdHanghoaAT26);
            listAT26.add(tbdHanghoaAT26);
        });
        return tbdHanghoa26;
    }
}
