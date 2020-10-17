package com.nsw.backend.mard.p06.controller;


import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p06.model.*;
import com.nsw.backend.mard.p06.repositories.TbdCongvan06Repository;
import com.nsw.backend.mard.p06.service.TbdHoso06Service;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/mard/06/giayphep")
public class CmonGiayphep06Controller extends BaseController {
    private static final String CV_VSTY_TYPE = "vsty";
    private static final String CV_KDNK_TYPE = "kdnk";
    private static final String CV_ALL_TYPE = "all";

    private final TbdHoso06Service regProfileService;

    private final TbdCongvan06Repository certRepo;

    public CmonGiayphep06Controller(TbdHoso06Service tbdHoso06Service, TbdCongvan06Repository certRepo) {
        this.regProfileService = tbdHoso06Service;
        this.certRepo = certRepo;
    }

    @GetMapping("/view")
    public ResponseEntity<ResponseJson> viewGP(
            @RequestParam("code") String fiNSWFileCode,
            @RequestParam String type) {
        TbdHoso06 tbdHoso06 = regProfileService.findByFiHSCode(fiNSWFileCode);
        if (tbdHoso06 != null) {
            if (CV_VSTY_TYPE.equals(type)) {
                return createSuccessResponse(certRepo.findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(fiNSWFileCode, 1), HttpStatus.OK);
            } else if (CV_KDNK_TYPE.equals(type)) {
                return createSuccessResponse(certRepo.findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(fiNSWFileCode, 2), HttpStatus.OK);
            } else if (CV_ALL_TYPE.equals(type)) {
                Map<String, Object> map = new HashMap<>();
                map.put("vsty", certRepo.findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(fiNSWFileCode, 1));
                map.put("cnkd", certRepo.findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(fiNSWFileCode, 2));
                return createSuccessResponse(map, HttpStatus.OK);
            } else {
                return createErrorResponse("Loại giấy phép yêu cầu không tồn tại!", HttpStatus.OK);
            }
        } else {
            return createErrorResponse("Mã hồ sơ không tồn tại!", HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseJson> listGP(@RequestParam String fiTaxCode) {
        FilterForm ff = new FilterForm();
        ff.setFiCompanyTaxCode(fiTaxCode);
        ff.setSize(Integer.MAX_VALUE);
        List<TbdCongvan06> listCNKD = new ArrayList<>();
        Date currentDate = Calendar.getInstance().getTime();
        //KDNK hết hạn sau 3 tháng kể từ ngày cấp.
        currentDate = DateUtils.addMonths(currentDate, -3);
        for (TbdHoso06 tbdHoso06 : regProfileService.searchHoso(ff).getData()) {
            if (tbdHoso06 != null) {
                TbdCongvan06 license = certRepo.findByFiNSWFileCodeAndFiDispatchType(tbdHoso06.getFiNSWFileCode(), 2);
                if (license != null && license.getFiDispatchDate().after(currentDate)) {
                    listCNKD.add(license);
                }
            }
        }
        return createSuccessResponse(listCNKD, HttpStatus.OK);
    }

    @GetMapping("/taoCV")
    @Profile("blameo_test")
    public ResponseEntity<ResponseJson> taoCVDemo() {
        List<TbdHoso06> listPendingProfile = regProfileService.findAllByFiHSStatus(Constant06.HosoStatus.DA_TIEP_NHAN.getId());
        listPendingProfile.forEach(profile -> {
            if (profile.getFiHSType() == Constant06.HosoType.DKKD_DONG_VAT.getId()) {
                certRepo.save(createCVVSTY(profile));
                regProfileService.internalStatusUpdate(profile, Constant06.HosoStatus.DA_CAP_CV_VSTY.getId());
            }
            certRepo.save(createCVKDNK(profile));
            regProfileService.internalStatusUpdate(profile, Constant06.HosoStatus.DA_CAP_CV_KDNK.getId());
        });
        return createSuccessResponse("", HttpStatus.OK);
    }

    private TbdCongvan06 createCVKDNK(TbdHoso06 profile) {
        TbdCongvan06 quarantine = new TbdCongvan06();
        quarantine.setFiNSWFileCode(profile.getFiNSWFileCode());
        quarantine.setFiDispatchNo(generateDispatchNo());
        quarantine.setFiDispatchDate(new Date());
        quarantine.setFiDispatchType(2);
        quarantine.setFiDispatchAccountable("Cục thú y");
        quarantine.setFiProductType(profile.getFiHSType());
        quarantine.setFiSummary("Kiểm dịch nhập khẩu động vật, sản phẩm động vật thủy sản");
        quarantine.setFiPreamble("Cục thú y có công số "
                + generateDispatchNo()
                + " ngày " + DateFormatUtils.format(new Date(), "dd/MM/yyyy") + " gửi Công ty TNHH Giống thủy sản Minh Vũ về yêu cầu VSTY đối với động vật thủy sản..");

        quarantine.setFiBordergateName("Hải Phòng");
        quarantine.setFiTimeQuarantine("Từ ngày xx/xx/xxxx đến ngày xx/xx/xxxx");
        quarantine.setFiPurpose("Nuôi làm giống; Chế biến thức ăn chăn nuôi ");

        profile.getFiProductList().forEach(product -> {
            TbdCvHanghoa06 certProduct = new TbdCvHanghoa06();
            BeanUtils.copyProperties(product, certProduct);
            certProduct.setFiIdProduct(null);
            quarantine.getFiProductList().add(certProduct);
        });

        profile.getFiProcessingList().forEach(processing -> {
            TbdCvCssx06 certProcessing = new TbdCvCssx06();
            BeanUtils.copyProperties(processing, certProcessing);
            certProcessing.setFiIdProcessing(null);
            quarantine.getFiProcessingList().add(certProcessing);
        });

        profile.getFiLocationQuarantineList().forEach(location -> {
            TbdCvDdclkd06 certLocationQuarantine = new TbdCvDdclkd06();
            BeanUtils.copyProperties(location, certLocationQuarantine);
            certLocationQuarantine.setFiIdQuarLoc(null);
            quarantine.getFiLocationQuarantineList().add(certLocationQuarantine);
        });

        profile.getFiExporterCountryList().forEach(exporter -> {
            TbdCvCtyxk06 certExporter = new TbdCvCtyxk06();
            BeanUtils.copyProperties(exporter, certExporter);
            certExporter.setFiIdExporter(null);
            quarantine.getFiExporterCountryList().add(certExporter);
        });
        quarantine.setFiResponseContent("1/ Đồng ý để Công ty được kiểm dịch nhập khẩu số động vật trên. " +
                "Trước khi hàng đến cửa khẩu nhập Công ty phải khai báo kiểm dịch nhập khẩu với Chi cục " +
                "Thú y vùng VI.\n" +
                "2/ Chi cục Thú y vùng VI thực hiện việc kiểm dịch nhập khẩu; lấy mẫu xét nghiệm bệnh theo " +
                "hướng dẫn tại công văn số 2286/TY-KD ngày 10/11/2016 của Cục Thú y, theo dõi việc nuôi " +
                "cách ly kiểm dịch số động vật nêu trên, nếu động vật khỏe mạnh và kết quả xét nghiệm âm tính " +
                "thì cấp giấy chứng nhận kiểm dịch nhập khẩu theo quy định.");
        quarantine.setFiRecipient("- Như trên;\nCCTY vùng VI;\n- Lưu VP, KD.");
        quarantine.setFiSignConfirmAddress("Hà Nội");
        quarantine.setFiSignPosition("Phó cục trưởng");
        quarantine.setFiSignConfirmName("Đàm Xuân Thành");
        return quarantine;
    }

    private String generateDispatchNo() {
        return String.format("%04d/TY-KDTS", RandomUtils.nextInt(0, 10000));
    }

    private TbdCongvan06 createCVVSTY(TbdHoso06 profile) {
        TbdCongvan06 vetHyg = new TbdCongvan06();
        vetHyg.setFiNSWFileCode(profile.getFiNSWFileCode());
        vetHyg.setFiDispatchNo(generateDispatchNo());
        vetHyg.setFiDispatchDate(new Date());
        vetHyg.setFiDispatchType(1);
        vetHyg.setFiDispatchAccountable("Cục thú y");
        vetHyg.setFiProductType(profile.getFiHSType());
        vetHyg.setFiSummary("Yêu cầu VSTY, nơi nuôi cách ly kiểm dịch động vật thủy sản");
        vetHyg.setFiPreamble("Trả lời công văn số xxxx/CT ngày xx/xx/xxxx của Công ty TNHH Giống thủy sản Minh Vũ về việc xin kiểm dịch nhập khẩu động vật thủy sản");

        vetHyg.setFiBordergateName("Hải Phòng");
        vetHyg.setFiTimeQuarantine("Từ ngày xx/xx/xxxx đến ngày xx/xx/xxxx");
        vetHyg.setFiPurpose("Nuôi làm giống");

        profile.getFiProductList().forEach(product -> {
            TbdCvHanghoa06 certProduct = new TbdCvHanghoa06();
            BeanUtils.copyProperties(product, certProduct);
            certProduct.setFiIdProduct(null);
            vetHyg.getFiProductList().add(certProduct);
        });

        profile.getFiProcessingList().forEach(processing -> {
            TbdCvCssx06 certProcessing = new TbdCvCssx06();
            BeanUtils.copyProperties(processing, certProcessing);
            certProcessing.setFiIdProcessing(null);
            vetHyg.getFiProcessingList().add(certProcessing);
        });

        profile.getFiLocationQuarantineList().forEach(location -> {
            TbdCvDdclkd06 certLocationQuarantine = new TbdCvDdclkd06();
            BeanUtils.copyProperties(location, certLocationQuarantine);
            certLocationQuarantine.setFiIdQuarLoc(null);
            vetHyg.getFiLocationQuarantineList().add(certLocationQuarantine);
        });

        profile.getFiExporterCountryList().forEach(exporter -> {
            TbdCvCtyxk06 certExporter = new TbdCvCtyxk06();
            BeanUtils.copyProperties(exporter, certExporter);
            certExporter.setFiIdExporter(null);
            vetHyg.getFiExporterCountryList().add(certExporter);
        });

        vetHyg.setFiResponseContent("1/ Đồng ý để công ty được ký hợp đồng mua số động vật nêu trên. " +
                "Yêu cầu vệ sinh thú y đối với động vật nhập khẩu phải được cơ quan có thẩm quyền " +
                "nước xuất khẩu cấp giấy chứng nhận kiểm dịch, xác nhận; Động vật được lấy từ cơ sở nuôi " +
                "an toàn dịch bệnh; khỏe mạnh và không có bất kỳ một bệnh truyền nhiễm nào; đảm bảo " +
                "vệ sinh an toàn thực phẩm.\n" +
                "2/ Công ty phải khai báo với Chi cục Thú y vùng II để kiểm tra điều kiện về sinh thú y nơi nuôi " +
                "cách ly kiểm dịch thủy sản theo quy định.\n" +
                "3/ Chi cục Thú y vùng II kiểm tra điều kiện vệ sinh thú y nơi nuôi cách ly kiểm dịch thủy sản và " +
                "báo cáo kết quả kiểm tra về Cục Thú y 05 ngày trước khi động vật nhập khẩu vào Việt Nam.\n" +
                "4/ Căn cứ kết quả kiểm tra điều kiện vệ sinh thú y nơi nuôi cách ly kiểm dịch thủy sản giống " +
                "của Chi cục Thú y vùng II, Cục Thú y sẽ xem xét cho phép Công ty được kiểm dịch nhập khẩu thủy sản " +
                "theo quy định hiện hành.");
        vetHyg.setFiRecipient("- Như trên;\nCCTY vùng II;\n- Lưu VP, KD.");
        vetHyg.setFiSignConfirmAddress("Hà Nội");
        vetHyg.setFiSignPosition("Phó cục trưởng");
        vetHyg.setFiSignConfirmName("Đàm Xuân Thành");
        return vetHyg;
    }


}
