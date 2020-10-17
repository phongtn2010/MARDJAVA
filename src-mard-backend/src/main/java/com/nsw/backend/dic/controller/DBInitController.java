package com.nsw.backend.dic.controller;

import com.nsw.backend.dic.model.*;
import com.nsw.backend.dic.repositories.*;
import com.nsw.backend.mard.p01.model.TbdUOMs01;
import com.nsw.backend.mard.p01.model.Tbddvxl01;
import com.nsw.backend.mard.p01.repositories.TbdUOMs01Repository;
import com.nsw.backend.mard.p01.repositories.Tbddvxl01Repository;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p06.model.TbdDonViXuLy06;
import com.nsw.backend.mard.p06.repositories.TbdDVXL06Repository;
import com.nsw.backend.mard.p08.constant.Constant08;
import com.nsw.backend.mard.p08.model.Tbddvxl08;
import com.nsw.backend.mard.p08.repositories.Tbddvxl08Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mard/init")
public class DBInitController {
    @Autowired
    private TbdDVXL06Repository pu06Repository;

    @Autowired
    private Tbddvxl08Repository pu08Repository;

    @Autowired
    private Tbddvxl01Repository pu01Repository;

    @Autowired
    private CmonUnitRepository uomRepo;

    @Autowired
    private CmonUnittypeRepository uomTypeRepo;

    @Autowired
    private CmonCountryRepository countryRepo;

    @Autowired
    private CmonPortRepository portRepo;

    @Autowired
    private CmonProvinceRepository provinceRepo;

    @Autowired
    private CmonAtchPhs2Repository attachRepo;

    @Autowired
    private TbdUOMs01Repository uomProc1Repo;

    private void initDVXL06() {
        pu06Repository.deleteAll();
        TbdDonViXuLy06 pu1 = new TbdDonViXuLy06("A", "Cơ quan thú y vùng I", "Hà Nội");
        TbdDonViXuLy06 pu2 = new TbdDonViXuLy06("B", "Cơ quan thú y vùng II", "Hải Phòng");
        TbdDonViXuLy06 pu3 = new TbdDonViXuLy06("C", "Cơ quan thú y vùng III", "Nghệ An");
        TbdDonViXuLy06 pu4 = new TbdDonViXuLy06("D", "Cơ quan thú y vùng IV", "Đà Nẵng");
        TbdDonViXuLy06 pu5 = new TbdDonViXuLy06("E", "Cơ quan thú y vùng V", "Đắk Lắk");
        TbdDonViXuLy06 pu6 = new TbdDonViXuLy06("F", "Cơ quan thú y vùng VI", "Hồ Chí Minh");
        TbdDonViXuLy06 pu7 = new TbdDonViXuLy06("G", "Cơ quan thú y vùng VII", "Cần Thơ");
        TbdDonViXuLy06 pu8 = new TbdDonViXuLy06("H", "Chi cục KDĐV vùng Quảng Ninh", "Quảng Ninh");
        TbdDonViXuLy06 pu9 = new TbdDonViXuLy06("I", "Chi cục KDĐV vùng Lào Cai", "Lào Cai");
        TbdDonViXuLy06 pu10 = new TbdDonViXuLy06("K", "Chi cục KDĐV vùng Lạng Sơn", "Lạng Sơn");

        pu06Repository.save(Arrays.asList(pu1, pu2, pu3, pu4, pu5, pu6, pu7, pu8, pu9, pu10));
    }

    private void initUOM() {
        uomRepo.deleteAll();

        List<CmonUnit> listUom = new ArrayList<>();

        listUom.add(newInstanceUom("TAN", "Tấn", Constant06.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("CON", "Con", Constant06.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("QUA", "Quả", Constant06.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("KHAC", "Khác", Constant06.SYSTEM_ID, 4L));

        listUom.add(newInstanceUom("ONE", "Con", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("DOZ", "Tá", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("HUN", "Trăm con", Constant08.SYSTEM_ID, 4L));

        listUom.add(newInstanceUom("KG", "Kilogram", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("HWG", "Tạ", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("TON", "Tấn", Constant08.SYSTEM_ID, 4L));

        listUom.add(newInstanceUom("PACK", "Bao", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("BOX", "Hộp", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("PIPE", "Ống", Constant08.SYSTEM_ID, 4L));
        listUom.add(newInstanceUom("OTHER", "Khác", Constant08.SYSTEM_ID, 4L));
        uomRepo.findAll().stream().max((o1, o2) -> (int) (o1.getUnitid() - o2.getUnitid()));
        for (int i = 0; i < listUom.size(); i++) {
            listUom.get(i).setUnitid((long) (i + 1));
        }
        uomRepo.save(listUom);
    }

    private CmonUnit newInstanceUom(String code, String name, Long systemId, Long unitTypeId) {
        CmonUnit uom = new CmonUnit();
        uom.setUnitcode(code);
        uom.setUnitname(name);
        uom.setSystemid(systemId);
        uom.setUnittypeid(unitTypeId);
        return uom;
    }

    @GetMapping
    @Transactional
    public String initDB() {
        initDVXL01();
        initDVXL06();
        initDVXL08();
        initUOM();
        initUOMProc1();
        initAttachType();
        initPort();
        initProvince();
        initCountry();
        return "OK";
    }

    private void initUOMProc1() {
        uomProc1Repo.deleteAll();
        List<TbdUOMs01> listUom = new ArrayList<>();
        listUom.add(new TbdUOMs01("TAN", "Tấn", "Ton"));
        listUom.add(new TbdUOMs01("CON", "Con", "Unit"));
        listUom.add(new TbdUOMs01("QUA", "Quả", "Piece"));
        listUom.add(new TbdUOMs01("KHAC", "Khác", "Other"));
        for(int i = 0; i < listUom.size(); i++){
            listUom.get(i).setFiIdUOM((long) (i + 1));
        }
        uomProc1Repo.save(listUom);
    }

    private void initAttachType() {
        attachRepo.deleteAll();
        List<CmonAttachmentTypePhase2> listAttach = new ArrayList<>();
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1",
                "Giấy chứng nhận vùng, cơ sở an toàn dịch bệnh nơi xuất phát cửa động vật(nếu có)",
                "", 1L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2",
                "Bản sao giấy chứng nhận tiêm phòng, phiếu kết quả xét nghiệm bệnh động vật (nếu có)",
                "", 1L, false));
        listAttach.add(new CmonAttachmentTypePhase2(3L, "3",
                "Bản sao yêu cầu vệ sinh thú y của chủ hàng hoặc nước nhập khẩu đối với động vật xuất khẩu (nếu có)",
                "", 1L, false));
        listAttach.add(new CmonAttachmentTypePhase2(4L, "4",
                "Bản sao hợp đồng mua bán (nếu có)",
                "", 1L, false));
        listAttach.add(new CmonAttachmentTypePhase2(5L, "5",
                "File nội dung cần chứng nhận kiểm dịch (nếu có)",
                "", 1L, false));
        listAttach.add(new CmonAttachmentTypePhase2(6L, "6",
                "Các giấy tờ khác có liên quan (nếu có)",
                "", 1L, false));

        //PROC 6
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1",
                "Bản sao mẫu giấy CNKD của nước xuất khẩu", 6L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2",
                "Bản sao giấy phép CITES có xác nhận của Doanh nghiệp", 6L));
        listAttach.add(new CmonAttachmentTypePhase2(3L, "3",
                "Bản sao giấy phép nhập khẩu thủy sản của Tổng cục Thủy sản có xác nhận của Doanh nghiệp", 6L));
        listAttach.add(new CmonAttachmentTypePhase2(4L, "4",
                "Khác", 6L));

        //PROC 7
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1",
                "Bản sao có xác nhận của doanh nghiệp hoặc bản gốc Giấy chứng nhận kiểm dịch của nước xuất khẩu", "N", 7L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2",
                "Bản sao có xác nhận của doanh nghiệp Vận tải đơn", "N", 7L, true));

        listAttach.add(new CmonAttachmentTypePhase2(4L, "4",
                "Bản sao Giấy phép CITES có xác nhận của doanh nghiệp", "HTC", 7L, true));
        listAttach.add(new CmonAttachmentTypePhase2(5L, "5",
                "Bản sao có xác nhận của doanh nghiệp Vận tải đơn", "HTC", 7L, true));
        listAttach.add(new CmonAttachmentTypePhase2(6L, "6",
                "Bản sao có xác nhận của doanh nghiệp Giấy chứng nhận của thuyền trưởng \"Captain's statement\" hoặc Giấy xác nhận của người bán", "HTC", 7L, true));

        listAttach.add(new CmonAttachmentTypePhase2(8L, "8",
                "Bản sao có xác nhận của doanh nghiệp hoặc bản gốc Giấy chứng nhận kiểm dịch của nước xuất khẩu", "GCCB", 7L, true));
        listAttach.add(new CmonAttachmentTypePhase2(9L, "9",
                "Bản sao Giấy phép CITES có xác nhận của doanh nghiệp", "GCCB", 7L));
        listAttach.add(new CmonAttachmentTypePhase2(10L, "10",
                "Bản sao có xác nhận của doanh nghiệp Vận tải đơn", "GCCB", 7L));
        listAttach.add(new CmonAttachmentTypePhase2(11L, "11",
                "Bản sao có xác nhận của doanh nghiệp các giấy tờ liên quan đến lô hàng khi xuất khẩu", "GCCB", 7L));
        listAttach.add(new CmonAttachmentTypePhase2(12L, "12",
                "Bản sao có xác nhận của doanh nghiệp Giấy chứng nhận của thuyền trưởng \"Captain's statement\" hoặc Giấy xác nhận của người bán", "GCCB", 7L));

        //PROC 8
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1", "Bản sao mẫu giấy CNKD của nước xuất", "20", 8L, true));
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1", "Bản sao mẫu giấy CNKD của nước xuất", "20A", 8L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2", "Hợp đồng mua bán", "20A", 8L, true));
        listAttach.add(new CmonAttachmentTypePhase2(3L, "3", "Phiếu đóng gói", "20A", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(4L, "4", "Hóa đơn mua bán", "20A", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(5L, "5", "Kết quả phân tích chất lượng của nước xuất xứ cấp cho lô hàng", "20A", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(6L, "6", "Hãng sản phẩm của Nhà sản xuất", "20A", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(7L, "7", "Bản tiêu chuẩn công bố áp dụng của ĐV nhập khẩu", "20A", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(8L, "8", "Tài liệu khác", "20", 8L));
        listAttach.add(new CmonAttachmentTypePhase2(8L, "8", "Tài liệu khác", "20A", 8L));
        //PROC 9
        listAttach.add(new CmonAttachmentTypePhase2(1L, "1", "Giấy chứng nhận điều kiện vệ sinh thú y (đối với động vật, sản phẩm động vật nhập khẩu để gia công, chế biến hàng xuất khẩu)", "20A", 9L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2", "Giấy chứng thực Giấy phép KDTV nhập khẩu (trường hợp quy định phải có giấy phép)", "20A", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(3L, "3", "Hợp đồng mua bán", "20A", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(4L, "4", "Phiếu đóng gói (Packing list)", "20A", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(5L, "5", "Hóa đơn mua bán (Invoice)", "20A", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(6L, "6", "Tài liệu khác", "20A", 9L));

        listAttach.add(new CmonAttachmentTypePhase2(1L, "1", "Giấy chứng nhận điều kiện vệ sinh thú y (đối với động vật, sản phẩm động vật nhập khẩu để gia công, chế biến hàng xuất khẩu)", "3", 9L, true));
        listAttach.add(new CmonAttachmentTypePhase2(2L, "2", "Giấy chứng thực Giấy phép KDTV nhập khẩu (trường hợp quy định phải có giấy phép)", "3", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(3L, "3", "Hợp đồng mua bán", "3", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(4L, "4", "Phiếu đóng gói (Packing list)", "3", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(5L, "5", "Hóa đơn mua bán (Invoice)", "3", 9L));
        listAttach.add(new CmonAttachmentTypePhase2(6L, "6", "Tài liệu khác", "3", 9L));

        attachRepo.save(listAttach);
    }


    public void initDVXL08() {
        pu08Repository.deleteAll();

        Tbddvxl08 root = new Tbddvxl08("BNN-KDDV", "Cục thú y", 0);

        Tbddvxl08 kv1 = new Tbddvxl08("BNN-KDDV-I", "Cơ quan thú y vùng 1", 1);
        kv1.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-I-1", "Trạm chuẩn đoán xét nghiệm vùng 1", 2));

        Tbddvxl08 kv2 = new Tbddvxl08("BNN-KDDV-II", "Cơ quan thú y vùng 2", 1);
        kv2.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-II-1", "Trạm kiểm dịch động vật cửa khẩu cảng Lạch Huyện", 2));

        Tbddvxl08 kv3 = new Tbddvxl08("BNN-KDDV-III", "Cơ quan thú y vùng 3", 1);
        kv3.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-III-1", "Trạm Kiểm dịch động vật Cửa khẩu Lao Bảo", 2));
        kv3.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-III-2", "Trạm Kiểm dịch động vật Cửa khẩu ChaLo", 2));
        kv3.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-III-3", "Kiểm dịch động vật Cầu Treo", 2));

        Tbddvxl08 kv4 = new Tbddvxl08("BNN-KDDV-IV", "Cơ quan thú y vùng 4", 1);
        kv4.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-IV-1", "Trạm chuẩn đoán xét nghiệm vùng 4", 2));

        Tbddvxl08 kv5 = new Tbddvxl08("BNN-KDDV-V", "Cơ quan thú y vùng 5", 1);
        kv5.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-V-1", "Trạm chuẩn đoán xét nghiệm vùng 5", 2));

        Tbddvxl08 kv6 = new Tbddvxl08("BNN-KDDV-VI", "Cơ quan thú y vùng 6", 1);
        kv6.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VI-1", "Trạm KDĐV Tân Sơn Nhất", 2));
        kv6.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VI-2", "Trạm KDĐV Cảng-Bưu điện", 2));
        kv6.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VI-3", "Trạm KDĐV Vũng Tàu", 2));
        kv6.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VI-4", "Trạm KDĐV Mộc Bài", 2));
        kv6.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VI-5", "Trạm KDĐV Bình Hiệp", 2));

        Tbddvxl08 kv7 = new Tbddvxl08("BNN-KDDV-VII", "Cơ quan thú y vùng 7", 1);
        kv7.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-VII-1", "Trạm chuẩn đoán xét nghiệm vùng 7", 2));

        Tbddvxl08 kvLC = new Tbddvxl08("BNN-KDDV-LC", "Cơ quan thú y Lào Cai", 1);
        kvLC.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LC-1", "Trạm kiểm dịch động vật Cầu Kiều", 2));
        kvLC.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LC-2", "Trạm kiểm dịch động vật Kim Thành", 2));
        kvLC.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LC-3", "Trạm kiểm dịch động vật Ga đường sắt quốc tế Lào Cai", 2));

        Tbddvxl08 kvLS = new Tbddvxl08("BNN-KDDV-LS", "Cơ quan thú y Lạng Sơn", 1);
        kvLS.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LS-1", "Trạm KDĐV Chi Ma", 2));
        kvLS.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LS-2", "Trạm KDĐV Trạm Hữu Nghị", 2));
        kvLS.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LS-3", "Trạm KDĐV Cốc Nam", 2));
        kvLS.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-LS-4", "Trạm KDĐV Tân Thanh", 2));

        Tbddvxl08 kvQN = new Tbddvxl08("BNN-KDDV-QN", "Cơ quan thú y Quảng Ninh", 1);
        kvQN.getLstChildPU().add(new Tbddvxl08("BNN-KDDV-QN-1", "Trạm KDĐV Móng Cái", 2));
        root.getLstChildPU().addAll(Arrays.asList(kv1, kv2, kv3, kv4, kv5, kv6, kv7, kvLC, kvLS, kvQN));
        pu08Repository.save(root);
    }

    public void initDVXL01() {
        pu01Repository.deleteAll();
        Tbddvxl01 root = new Tbddvxl01("", "Cục thú y", "", 0);

        Tbddvxl01 kv1 = new Tbddvxl01("B00", "Chi cục thú y vùng 1", "Regional Animal Health Office No. I", 1);
        kv1.getLstChildPU().add(new Tbddvxl01("B01", "Trạm kiểm dịch động vật Nội Bài", "Noi Bai Animal Quarantine Station", 2));
        Tbddvxl01 kv2 = new Tbddvxl01("A00", "Chi cục thú y vùng 2", "Regional Animal Health Office No. II", 1);
        kv2.getLstChildPU().add(new Tbddvxl01("A01",
                "Trạm kiểm dịch động vật cửa khẩu cảng Lạch Huyện",
                "Lach Huyen Animal Quarantine Station", 2));
        Tbddvxl01 kv3 = new Tbddvxl01("C00", "Chi cục thú y vùng 3", "Regional Animal Health Office No. III", 1);
        kv3.getLstChildPU().add(new Tbddvxl01("C01",
                "Trạm kiểm dịch động vật Nậm Cắn",
                "Nam Can Animal Quarantine Station", 2));
        kv3.getLstChildPU().add(new Tbddvxl01("C02",
                "Trạm kiểm dịch động vật Cầu Treo",
                "Cau Treo Animal Quarantine Station", 2));
        kv3.getLstChildPU().add(new Tbddvxl01("C03",
                "Trạm kiểm dịch động vật Cửa khẩu ChaLo",
                "Chalo Animal Quarantine Station", 2));
        kv3.getLstChildPU().add(new Tbddvxl01("C04",
                "Trạm kiểm dịch động vật Lao Bảo",
                "Lao Bao Animal Quarantine Station", 2));
        Tbddvxl01 kv4 = new Tbddvxl01("D00", "Chi cục thú y vùng 4", "Regional Animal Health Office No. IV", 1);
        kv4.getLstChildPU().add(new Tbddvxl01("D01",
                "Trạm chuẩn đoán xét nghiệm vùng 4",
                "Regional Animal Diagnostic Station No. IV", 2));
        Tbddvxl01 kv5 = new Tbddvxl01("H00", "Chi cục thú y vùng 5", "Regional Animal Health Office No. V", 1);
        kv5.getLstChildPU().add(new Tbddvxl01("H01",
                "Trạm kiểm dịch động vật Bờ Y",
                "Bo Y Animal Quarantine Station", 2));
        Tbddvxl01 kv6 = new Tbddvxl01("E00", "Chi cục thú y vùng 6", "Regional Animal Health Office No. VI", 1);
        kv6.getLstChildPU().add(new Tbddvxl01("E05",
                "Trạm kiểm dịch động vật Bình Hiệp",
                "Binh Hiep Animal Quarantine Station", 2));
        kv6.getLstChildPU().add(new Tbddvxl01("E03",
                "Trạm kiểm dịch động vật Cảng - Bưu Điện",
                "Cang - Buu Dien Animal Quarantine Station", 2));
        kv6.getLstChildPU().add(new Tbddvxl01("E02",
                "Trạm kiểm dịch động vật Tân Sơn Nhất",
                "Tan Son Nhat Animal Quarantine Station", 2));
        kv6.getLstChildPU().add(new Tbddvxl01("E04",
                "Trạm kiểm dịch động vật Vũng Tàu",
                "Vung Tau Animal Quarantine Station", 2));
        kv6.getLstChildPU().add(new Tbddvxl01("E01",
                "Trạm kiểm dịch động vật Mộc Bài",
                "Moc Bai Animal Quarantine Station", 2));
        Tbddvxl01 kv7 = new Tbddvxl01("G00", "Chi cục thú y vùng 7", "Regional Animal Health Office No. VII", 1);
        kv7.getLstChildPU().add(new Tbddvxl01("G01",
                "Trạm kiểm dịch động vật sân bay Phú Quốc",
                "Phu Quoc Airport Animal Quarantine Station", 2));
        Tbddvxl01 kvLC = new Tbddvxl01("K00", "Chi cục kiểm dịch đồng vật vùng Lào Cai", "Lao Cai Regional Sub-Department of Animal Quarantine and Inspection", 1);
        kvLC.getLstChildPU().add(new Tbddvxl01("K01",
                "Trạm kiểm dịch động vật Cầu Kiều",
                "Cau Kieu Animal Quarantine Station", 2));
        kvLC.getLstChildPU().add(new Tbddvxl01("K03",
                "Trạm kiểm dịch động vật Kim Thành",
                "Kim Thanh Animal Quarantine Station", 2));
        kvLC.getLstChildPU().add(new Tbddvxl01("K02",
                "Trạm kiểm dịch động vật Ga đường sắt quốc tế Lào Cai",
                "Lao Cai International Railway Station Animal Quarantine Station", 2));
        Tbddvxl01 kvQN = new Tbddvxl01("L00", "Chi cục kiểm dịch đồng vật vùng Quảng Ninh", "Quang Ninh Regional Sub-Department of Animal Quarantine and Inspection", 1);
        kvQN.getLstChildPU().add(new Tbddvxl01("L02",
                "Trạm kiểm dịch động vật Hạ Long",
                "Ha Long Animal Quarantine Station", 2));
        kvQN.getLstChildPU().add(new Tbddvxl01("L01",
                "Trạm kiểm dịch động vật Hạ Long",
                "Mong Cai Animal Quarantine Station", 2));
        Tbddvxl01 kvLS = new Tbddvxl01("I00", "Chi cục kiểm dịch đồng vật vùng Lạng Sơn", "Lang Son Regional Sub-Department of Animal Quarantine and Inspection", 1);
        kvLS.getLstChildPU().add(new Tbddvxl01("I05",
                "Trạm kiểm dịch động vật Hữu Nghị",
                "Huu Nghi Animal Quarantine Station", 2));
        kvLS.getLstChildPU().add(new Tbddvxl01("I02",
                "Trạm kiểm dịch động vật Tân Thanh",
                "Tan Thanh Animal Quarantine Station", 2));
        kvLS.getLstChildPU().add(new Tbddvxl01("I04",
                "Trạm kiểm dịch động vật Cốc Nam",
                "Coc Nam Animal Quarantine Station", 2));
        kvLS.getLstChildPU().add(new Tbddvxl01("I03",
                "Trạm Kiểm dịch động vật Chi Ma",
                "Chi Ma Animal Quarantine Station", 2));
        kvLS.getLstChildPU().add(new Tbddvxl01("I01",
                "Trạm kiểm dịch Ga Đồng Đăng",
                "Dong Dang Railway Station Animal Quarantine Station", 2));
        root.getLstChildPU().addAll(Arrays.asList(kv1, kv2, kv3, kv4, kv5, kv6, kv7, kvLC, kvLS, kvQN));
        pu01Repository.save(root);
    }
    private void initCountry() {
        countryRepo.deleteAll();
        List<CmonCountry> countries = new ArrayList<>();
        countries.add(new CmonCountry("VN", "Việt Nam"));
        countries.add(new CmonCountry("US", "Mỹ"));
        countries.add(new CmonCountry("UK", "Anh"));
        countries.add(new CmonCountry("CN", "Trung Quốc"));
        countries.add(new CmonCountry("MY", "Malaysia"));
        countries.add(new CmonCountry("JP", "Nhật Bản"));
        for (int i = 0; i < countries.size(); i++) {
            countries.get(i).setCountryid((long) (i + 1));
        }
        countryRepo.save(countries);
    }

    private void initProvince() {
        provinceRepo.deleteAll();
        List<CmonProvince> provinces = new ArrayList<>();
        provinces.add(new CmonProvince("Hà Giang", "HG"));
        provinces.add(new CmonProvince("Hà Nội", "HN"));
        provinces.add(new CmonProvince("Hải Phòng", "HP"));
        provinces.add(new CmonProvince("Đà Nẵng", "ĐN"));
        provinces.add(new CmonProvince("Hồ Chí Minh", "HCM"));
        provinces.add(new CmonProvince("Cà Mau", "CM"));
        for (int i = 0; i < provinces.size(); i++) {
            provinces.get(i).setProvinceId((long) (i + 1));
        }
        provinceRepo.save(provinces);
    }

    private void initPort() {
        portRepo.deleteAll();
        List<CmonPort> ports = new ArrayList<>();
        ports.add(new CmonPort("MC", "Móng Cái", 8L, "VN", "Mong Cai Port"));
        ports.add(new CmonPort("HK", "Hải Phòng", 8L, "VN", "Ha Khau Port"));
        ports.add(new CmonPort("WS", "Cảng 1", 8L, "US", "Port One"));
        ports.add(new CmonPort("WS2", "Cảng 2", 8L, "US", "Port Two"));
        ports.add(new CmonPort("JP", "Cảng JP 1", 8L, "JP", "Port One JP"));
        ports.add(new CmonPort("JP2", "Cảng JP 2", 8L, "JP", "Port Two JP"));
        for (int i = 0; i < ports.size(); i++) {
            ports.get(i).setPortid((long) (i + 1));
        }
        portRepo.save(ports);
    }
}
