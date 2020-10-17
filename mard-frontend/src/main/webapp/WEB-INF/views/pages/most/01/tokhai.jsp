<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.tokhai" /></b><a class="nsw-require-field">*</a></p>
    </div>
    <div class="row-border">
        <a href="javascript:void(0);" id="btnThemMoiToKhai" class="btn grey" data-toggle="modal" style="display: ${IsView}">
            <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
        </a>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th><spring:message code="common.table.col.stt" /></th>
                    <th><spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" /> </th>
                    <th><spring:message code="most.01.tokhai.ngay_dang_ky" /> </th>
                    <th><spring:message code="most.01.tokhai.ma_hai_quan" /> </th>
                    <th style="display: ${IsView}"> # </th>
                    <th style="display: ${IsView}"> <spring:message code="common.button.sua" /> </th>
                    <th style="display: ${IsView}"> <spring:message code="common.button.xoa" /> </th>
                </tr>
            </thead>
            <tbody id="tokhai-container">

            </tbody>
        </table>
    </div>
</div>
<div id="tokhai-tmpl" style="display: none;">
    <form role="form" class="form-horizontal tokhai-form">
        <p><b class="nsw-text-underline">{{ _lang "most_01_tokhai_thongtintimkiem" }}</b></p>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiSoTk" value="{{fiSoTk}}" name="fiSoTk" require="true" field="most_01_tokhai_hanghoa_nhapkhau_so" class="form-control" placeholder="<spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" />" type="text">
            </div>            
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.namdangky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input id="fiNamdk" name="fiNamdk" require="true" field="most_01_tokhai_namdangky" class="form-control" placeholder="<spring:message code="most.01.tokhai.namdangky" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.ma_hai_quan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiMaHq" name="fiMaHq" value="{{fiMaHq}}" require="true" field="most_01_tokhai_ma_hai_quan" class="form-control" placeholder="<spring:message code="most.01.tokhai.ma_hai_quan" />" type="text">                
            </div>
            <div class="col-md-6">
                <select id="fiDVHQ" class="form-control select2" data="{{fixSelectData fiMaHq}}">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <option value="01AB">01AB - CC HQ CK Sân bay QT Nội Bài</option>
                    <option value="01AC">01AC - CC HQ Gia Lâm Hà Nội</option>
                    <option value="01B1">01B1 - CC HQ Sân bay Nội bài-Đội Xuất</option>
                    <option value="01B2">01B2 - CC HQ Sân bay Nội bài-Đội CPN</option>
                    <option value="01B3">01B3 - CC HQ Sân bay Nội bài-Đội Nhập</option>
                    <option value="01B5">01B5 - Chi cục HQ SB Nội Bài - Đội hành lý XC</option>
                    <option value="01B6">01B6 - Chi cục HQ SB Nội Bài - Đội hành lý NC</option>
                    <option value="01BT">01BT - CC HQ Yên Bái</option>
                    <option value="01D1">01D1 - HQ Mỹ Đình (thuộc HQ Bưu điện HN)</option>
                    <option value="01D2">01D2 - HQ Bưu điện Hà Nội - FeDex</option>
                    <option value="01D3">01D3 - HQ Bưu điện Hà Nội - UPS</option>
                    <option value="01DD">01DD - Chi cục Hải quan Chuyển phát nhanh</option>
                    <option value="01E1">01E1 - Đội Nghiệp vụ - CCHQ Bắc Hà Nội</option>
                    <option value="01E2">01E2 - Đội hàng không - CC HQ Bắc Hà Nội</option>
                    <option value="01E3">01E3 - Đội TT CPN - CC HQ Bắc Hà Nội</option>
                    <option value="01IK">01IK - CC HQ Gia Thụy Hà Nội</option>
                    <option value="01K1">01K1 - Đội Kiểm soát Hải quan</option>
                    <option value="01K2">01K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="01KK">01KK - Phòng thuế XNK</option>
                    <option value="01M1">01M1 - CC HQ Hà Tây - Đội TT HQ Hà Đông</option>
                    <option value="01M2">01M2 - Đội TT HQ Khu CNC Hoà Lạc</option>
                    <option value="01NV">01NV - Chi cục hải quan Bắc Thăng Long</option>
                    <option value="01PJ">01PJ - Chi cục hải quan Việt Trì</option>
                    <option value="01PL">01PL - CC HQ quản lý hàng ĐT-GC Hà Nội</option>
                    <option value="01PM">01PM - CC HQ Hà Tây (Thuộc HQ Hà Nội)</option>
                    <option value="01PQ">01PQ - Chi cục Hải quan Hòa Bình</option>
                    <option value="01PR">01PR - CC HQ Vĩnh Phúc (HQ Hà Nội)</option>
                    <option value="01QQ">01QQ - Chi cục KTSTQ HN</option>
                    <option value="01SI">01SI - CC HQ Ga Yên Viên (Hà Nội)</option>
                    <option value="01TE">01TE - CCHQ Bắc Hà Nội</option>
                    <option value="02AB">02AB - CC HQ Sân bay QT Tân Sơn Nhất</option>
                    <option value="02B1">02B1 - Đội TT HH XNK TCS - SB TSN HCM</option>
                    <option value="02B4">02B4 - Đội TT HH XNK SCSC - SB TSN HCM</option>
                    <option value="02CC">02CC - CC HQ CK Cảng Sài Gòn KV II</option>
                    <option value="02CH">02CH - CC HQ CK Cảng Sài Gòn KV III</option>
                    <option value="02CI">02CI - CC HQ CK Cảng Sài Gòn KV I</option>
                    <option value="02CV">02CV - CC HQ CK Cảng Hiệp Phước (HCM)</option>
                    <option value="02CX">02CX - CC HQ CK Tân Cảng (Hồ Chí Minh)</option>
                    <option value="02DS">02DS - CC HQ Chuyển phát nhanh</option>
                    <option value="02F1">02F1 - HQ KCX Linh Trung I (Hồ Chí Minh)</option>
                    <option value="02F2">02F2 - HQ KCX Linh Trung II (Hồ Chí Minh)</option>
                    <option value="02F3">02F3 - Chi cục Hải quan Khu công nghệ cao</option>
                    <option value="02H1">02H1 - Đội TT Cảng Bến Nghé-CSG KV III</option>
                    <option value="02H2">02H2 - Đội TT và GS XDầu XNK-CSG KVIII</option>
                    <option value="02H3">02H3 - Đội TT Cảng VICT-CSG KV III</option>
                    <option value="02IK">02IK - CC HQ CK Cảng Sài Gòn khu vực IV</option>
                    <option value="02K1">02K1 - CC HQ KV IV ( ICD Tanamexco)</option>
                    <option value="02K2">02K2 - CC HQ KV IV ( ICD Transimex)</option>
                    <option value="02K3">02K3 - CC HQ KV IV (ICD Sotrans)</option>
                    <option value="02K4">02K4 - Đội Kiểm soát Hải quan</option>
                    <option value="02K5">02K5 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="02PG">02PG - CC HQ quản lý hàng đầu tư HCM</option>
                    <option value="02PJ">02PJ - CC HQ quản lý hàng gia công HCM</option>
                    <option value="02QQ">02QQ - Chi cục KTSTQ HQ TP Hồ Chí Minh</option>
                    <option value="02XE">02XE - CC HQ KCX Tân Thuận (HCM)</option>
                    <option value="02XF">02XF - CC HQ KCX Linh Trung (HCM)</option>
                    <option value="03CC">03CC - CC HQ CK cảng HP KV I</option>
                    <option value="03CD">03CD - CC HQ Thái Bình</option>
                    <option value="03CE">03CE - CC HQ CK cảng HP KV II</option>
                    <option value="03EE">03EE - CC HQ Cảng Đình Vũ Hải Phòng</option>
                    <option value="03K1">03K1 - Đội Kiểm soát Hải quan</option>
                    <option value="03NK">03NK - CC HQ KCX và KCN Hải Phòng</option>
                    <option value="03PA">03PA - CC HQ QL hàng ĐT-GC Hải Phòng</option>
                    <option value="03PJ">03PJ - CC HQ Hải dương</option>
                    <option value="03PL">03PL - CC HQ Hưng yên</option>
                    <option value="03QM">03QM - Chi cục kiểm tra sau thông quan</option>
                    <option value="03RR">03RR - Phòng QLRR Hải Phòng</option>
                    <option value="03TG">03TG - CC HQ CK cảng HP KV III</option>
                    <option value="10BB">10BB - CC HQ CK Thanh Thủy Hà Giang</option>
                    <option value="10BC">10BC - CC HQ CK Xín Mần Hà Giang</option>
                    <option value="10BD">10BD - CC HQ CK Phó Bảng Hà Giang</option>
                    <option value="10BF">10BF - CC HQ CK Săm Pun</option>
                    <option value="10BI">10BI - CC HQ Tuyên Quang</option>
                    <option value="10K1">10K1 - Đội Kiểm soát Hải quan</option>
                    <option value="10QG">10QG - Chi cục KTSTQ HQ Hà Giang</option>
                    <option value="11B1">11B1 - CC HQ CK Tà Lùng Cao Bằng</option>
                    <option value="11B2">11B2 - Đội NV số 2 Nà Lạn</option>
                    <option value="11BB">11BB - CC HQ CK Tà Lùng Cao Bằng</option>
                    <option value="11BE">11BE - CC HQ CK Trà Lĩnh Cao Bằng</option>
                    <option value="11BF">11BF - CC HQ CK Sóc Giang Cao Bằng</option>
                    <option value="11BG">11BG - CC HQ CK Bí Hà Cao Bằng</option>
                    <option value="11BH">11BH - CC HQ CK Pò Peo Cao Bằng</option>
                    <option value="11G1">11G1 - CC HQ CK Bí Hà Cao Bằng</option>
                    <option value="11G2">11G2 - Đội NV Lý Vạn - Chi cục HQCK Bí Hà</option>
                    <option value="11K1">11K1 - Đội Kiểm soát Hải quan</option>
                    <option value="11PK">11PK - CC HQ Bắc Kạn Cao Bằng</option>
                    <option value="11QL">11QL - Chi cục KTSTQ HQ Cao Bằng</option>
                    <option value="12B1">12B1 - Đội Nghiệp vụ - CC Tây Trang ĐB</option>
                    <option value="12B2">12B2 - Đội TT Huổi Puốc-CC Tây Trang ĐB</option>
                    <option value="12BB">12BB - CC HQ CK Tây Trang Điện Biên</option>
                    <option value="12BE">12BE - CC HQ CK Lóng Sập Điện Biên</option>
                    <option value="12BH">12BH - CC HQ CK Ma Lu Thàng Điện Biên</option>
                    <option value="12BI">12BI - CC HQ CK Chiềng Khương Điện Biên</option>
                    <option value="12F1">12F1 - HQ Thị xã Sơn La - Điện Biên</option>
                    <option value="12F2">12F2 - Đội NV HQCK Nà Cài-HQ Sơn La ĐB</option>
                    <option value="12H1">12H1 - Đội Nghiệp vụ-CC Ma Lu Thàng ĐB</option>
                    <option value="12H2">12H2 - Đội HQ Pô Tô-CC Ma Lu Thàng ĐB</option>
                    <option value="12K1">12K1 - Đội Kiểm soát Hải quan</option>
                    <option value="12K2">12K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="12PF">12PF - HQ Thị xã Sơn La - Điện Biên</option>
                    <option value="12QK">12QK - Chi cục KTSTQ HQ Điện Biên</option>
                    <option value="13BB">13BB - CC HQ CK QT Lào Cai</option>
                    <option value="13BC">13BC - CC HQ CK Mường Khương Lào Cai</option>
                    <option value="13BD">13BD - CC HQ Bát Xát Lào Cai</option>
                    <option value="13G1">13G1 - Đội Nghiệp vụ-CC Ga Đường Sắt LC</option>
                    <option value="13G2">13G2 - ICD Vinalines-CC Ga Đường Sắt LC</option>
                    <option value="13K1">13K1 - Đội Kiểm soát Hải quan</option>
                    <option value="13QH">13QH - Chi cục KTSTQ HQ Lào Cai</option>
                    <option value="13SG">13SG - CC HQ Ga Đường sắt QT Lào Cai</option>
                    <option value="15B1">15B1 - Đội nghiệp vụ chi cục HQ Hữu Nghị</option>
                    <option value="15B2">15B2 - Đội nghiệp vụ Con Sâu - chi cục Hữu nghị</option>
                    <option value="15B3">15B3 - Đội nghiệp vụ Pò Nhùng</option>
                    <option value="15BB">15BB - CC HQ CK Hữu Nghị Lạng Sơn</option>
                    <option value="15BC">15BC - CC HQ CK Chi Ma Lạng Sơn</option>
                    <option value="15BD">15BD - CC HQ Cốc Nam Lạng Sơn</option>
                    <option value="15BE">15BE - CC HQ Tân Thanh Lạng Sơn</option>
                    <option value="15E1">15E1 - Đội Nghiệp vụ Na Hình</option>
                    <option value="15E2">15E2 - Đội nghiệp vụ Nà Nưa</option>
                    <option value="15E3">15E3 - Đội nghiệp vụ Bình Nghi</option>
                    <option value="15E4">15E4 - Đội nghiệp vụ Tân Thanh</option>
                    <option value="15K1">15K1 - Đội Kiểm soát Hải quan</option>
                    <option value="15QL">15QL - Chi cục kiểm tra STQ</option>
                    <option value="15SI">15SI - CC HQ Ga đường sắt QT Đồng Đăng</option>
                    <option value="18A1">18A1 - Đội TT HQ quản lý KCN Yên Phong</option>
                    <option value="18A2">18A2 - Đội TT HQ quản lý KCN Quế Võ</option>
                    <option value="18A3">18A3 - Đội nghiệp vụ CC HQ Bắc Ninh</option>
                    <option value="18B1">18B1 - CC Hải quan Thái Nguyên</option>
                    <option value="18B2">18B2 - Đội TT HQ Yên Bình - Thái Nguyên</option>
                    <option value="18BA">18BA - CC Hải quan Bắc Ninh</option>
                    <option value="18BB">18BB - CC Hải quan Thái Nguyên</option>
                    <option value="18BC">18BC - CC HQ Quản lý các KCN Bắc Giang</option>
                    <option value="18BE">18BE - Chi cục quản lý các KCN Yên Phong</option>
                    <option value="18ID">18ID - CC HQ Cảng nội địa Tiên Sơn</option>
                    <option value="18K1">18K1 - Đội Kiểm soát Hải quan</option>
                    <option value="18QE">18QE - Chi cục Kiểm tra sau thông quan - Cục Hải quan tỉnh Bắc Ninh</option>
                    <option value="20B1">20B1 - HQ Cửa khẩu Bắc Luân</option>
                    <option value="20B2">20B2 - HQ Cửa khẩu Ka Long</option>
                    <option value="20B3">20B3 - Đội nghiệp vụ IDC Thành Đạt</option>
                    <option value="20BB">20BB - CC HQ CK Móng Cái</option>
                    <option value="20BC">20BC - CC HQ CK Hoành Mô Quảng Ninh</option>
                    <option value="20BD">20BD - CC HQ Bắc Phong Sinh Quảng Ninh</option>
                    <option value="20CD">20CD - HQ Cảng Biển Cái Lân</option>
                    <option value="20CE">20CE - CC HQ cửa khẩu Cảng Vạn Gia</option>
                    <option value="20CF">20CF - CC HQ CK Cảng Hòn Gai</option>
                    <option value="20CG">20CG - CC HQ CK Cảng Cẩm Phả</option>
                    <option value="20K1">20K1 - Đội Kiểm soát Hải quan số 1</option>
                    <option value="20K2">20K2 - Đội Kiểm soát Hải quan số 2</option>
                    <option value="20K3">20K3 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="20K4">20K4 - Trạm KSLH Km15 - BTDT (Trạm kiểm soát liên hợp Km15 - Bến tàu Dân Tiến)</option>
                    <option value="20QK">20QK - Chi cục KTSTQ HQ Quảng Ninh</option>
                    <option value="27B1">27B1 - CC HQ CK Na Mèo Thanh Hoá</option>
                    <option value="27B2">27B2 - Đội thủ tục Hải quan CK Tén Tằn</option>
                    <option value="27BB">27BB - CC HQ CK Na Mèo Thanh Hoá</option>
                    <option value="27CF">27CF - CC HQ Cảng Thanh Hoá</option>
                    <option value="27F1">27F1 - Đội thủ tục-CCHQ Cảng Thanh Hóa</option>
                    <option value="27F2">27F2 - Chi cục Hải quan cửa khẩu cảng Nghi Sơn</option>
                    <option value="27K1">27K1 - Đội Kiểm soát Hải quan</option>
                    <option value="27K2">27K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="27NJ">27NJ - CC HQ KCN tỉnh Hà Nam</option>
                    <option value="27PC">27PC - CC HQ Ninh Bình</option>
                    <option value="27PE">27PE - CC HQ Nam Định</option>
                    <option value="27QH">27QH - Chi cục kiểm tra Sau thông quan</option>
                    <option value="28K1">28K1 - Đội Kiểm soát Hải quan</option>
                    <option value="28NJ">28NJ - Chi cục Hải quan Hà Nam</option>
                    <option value="28PC">28PC - CC HQ Ninh Bình</option>
                    <option value="28PE">28PE - CC HQ Nam Định</option>
                    <option value="29BB">29BB - CC HQ CK Nậm Cắn Nghệ An</option>
                    <option value="29BH">29BH - Chi cục HQ CK Thanh Thủy</option>
                    <option value="29C1">29C1 - Đội TT - CC HQ Cảng Nghệ An</option>
                    <option value="29C2">29C2 - Đội TTSB Vinh-CCHQ Cảng Nghệ An</option>
                    <option value="29CC">29CC - Chi cục HQ CK Cảng Nghệ An</option>
                    <option value="29K1">29K1 - Đội Kiểm soát Hải quan</option>
                    <option value="29K2">29K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="29PF">29PF - CC HQ Vinh Nghệ An</option>
                    <option value="29QG">29QG - Chi cục KTSTQ HQ Nghệ An</option>
                    <option value="30BB">30BB - CC HQ CK Cầu Treo Hà Tĩnh</option>
                    <option value="30BE">30BE - CC HQ Hồng Lĩnh Hà Tĩnh</option>
                    <option value="30BI">30BI - CC HQ khu kinh tế CK Cầu Treo</option>
                    <option value="30CC">30CC - CC HQ CK Cảng Xuân Hải Hà Tĩnh</option>
                    <option value="30CF">30CF - CC HQ CK Cảng Vũng Áng Hà Tĩnh</option>
                    <option value="30F1">30F1 - CC HQ CK Cảng Vũng Áng Hà Tĩnh</option>
                    <option value="30F2">30F2 - Đội nghiệp vụ cảng Sơn Dương</option>
                    <option value="30K1">30K1 - Đội Kiểm soát Hải quan</option>
                    <option value="30K2">30K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="30QH">30QH - Chi cục KTSTQ - Hà Tĩnh</option>
                    <option value="31BB">31BB - CC HQ CK Cha Lo Quảng Bình</option>
                    <option value="31BF">31BF - CC HQ CK Cà Roòng Quảng Bình</option>
                    <option value="31CD">31CD - CC HQ CK Cảng Hòn La</option>
                    <option value="31D1">31D1 - Đội Nghiệp vụ Cảng Hòn La</option>
                    <option value="31D2">31D2 - Đội Nghiệp vụ Đồng Hới</option>
                    <option value="31D3">31D3 - Đội Nghiệp vụ Cảng Gianh</option>
                    <option value="31K1">31K1 - Đội Kiểm soát Hải quan</option>
                    <option value="31QG">31QG - Chi cục KTSTQ HQ Quảng Bình</option>
                    <option value="32BB">32BB - CC HQ CK Lao Bảo Quảng Trị</option>
                    <option value="32BC">32BC - CC HQ CK La Lay Quảng Trị</option>
                    <option value="32BD">32BD - CC HQ Khu Thương mại Lao Bảo</option>
                    <option value="32CD">32CD - CC HQ CK Cảng Cửa Việt Quảng Trị</option>
                    <option value="32K1">32K1 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="32QH">32QH - Chi cục KTSTQ HQ Quảng Trị</option>
                    <option value="32VG">32VG - Đội Kiểm soát HQ Quảng Trị</option>
                    <option value="33A1">33A1 - Đội Nghiệp vụ - CC HQ CK AĐớt</option>
                    <option value="33A2">33A2 - Đội NV Hồng Vân - CC HQ CK AĐớt</option>
                    <option value="33BA">33BA - CC HQ CK Ađớt</option>
                    <option value="33CC">33CC - CC HQ Cảng Thuận An TT Huế</option>
                    <option value="33CF">33CF - CC HQ CK Cảng Chân Mây TT Huế</option>
                    <option value="33K1">33K1 - Đội Kiểm soát Hải quan</option>
                    <option value="33PD">33PD - CC HQ Thuỷ An</option>
                    <option value="33QG">33QG - Chi cục KTSTQ HQ Thừa Thiên - Huế</option>
                    <option value="34AB">34AB - CC HQ Sân bay QT Đà Nẵng</option>
                    <option value="34CC">34CC - CC quản lý hàng đầu tư gia công</option>
                    <option value="34CE">34CE - CC HQ CK Cảng Đà Nẵng</option>
                    <option value="34K1">34K1 - Đội Kiểm soát Hải quan</option>
                    <option value="34K2">34K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="34NG">34NG - CC HQ KCN Hòa khánh-Liên chiểu</option>
                    <option value="34NH">34NH - CC HQ KCN Đà Nẵng</option>
                    <option value="34QN">34QN - Chi cục KTSTQ Đà Nẵng</option>
                    <option value="35CB">35CB - CC HQ CK Cảng Dung Quất</option>
                    <option value="35K1">35K1 - Đội Kiểm soát Hải quan</option>
                    <option value="35NC">35NC - CC HQ các KCN Quảng Ngãi</option>
                    <option value="35QE">35QE - Chi cục KTSTQ HQ Quảng Ngãi</option>
                    <option value="37CB">37CB - CC HQ Cảng Qui Nhơn Bình Định</option>
                    <option value="37K1">37K1 - Đội Kiểm soát Hải quan</option>
                    <option value="37QF">37QF - Chi cục KTSTQ HQ Bình Định</option>
                    <option value="37TC">37TC - CC HQ Phú Yên Bình Định</option>
                    <option value="38B1">38B1 - Đội NVụ THợp-CC HQ CK Lệ Thanh</option>
                    <option value="38B2">38B2 - Đội TT-CC HQ CK Lệ Thanh</option>
                    <option value="38BB">38BB - CC HQCK Lệ Thanh (Gia Lai)</option>
                    <option value="38BC">38BC - CC HQCK Quốc tế Bờ Y (Kon Tum)</option>
                    <option value="38K1">38K1 - Đội Kiểm soát Hải quan</option>
                    <option value="38PD">38PD - CC HQ CK Kon Tum</option>
                    <option value="38QF">38QF - Chi cục KTSTQ HQ Gia Lai - Kontum</option>
                    <option value="40B1">40B1 - Đội Nghiệp vụ I – CCHQ CK Buprăng</option>
                    <option value="40BB">40BB - CC HQ CK BupRăng Đắc Lắc</option>
                    <option value="40BC">40BC - CC HQ Buôn Mê Thuột</option>
                    <option value="40D1">40D1 - Đội Nghiệp vụ - CC HQ Đà Lạt</option>
                    <option value="40K1">40K1 - Đội Kiểm soát Hải quan</option>
                    <option value="40PD">40PD - CC HQ Đà lạt</option>
                    <option value="40QF">40QF - Chi cục KTSTQ HQ Đắc Lắc</option>
                    <option value="41AB">41AB - Chi cục HQCK Sân bay quốc tế Cam Ranh</option>
                    <option value="41BH">41BH - CC HQ Ninh Thuận Khánh Hòa</option>
                    <option value="41CB">41CB - CC HQ CK Cảng Nha Trang KH</option>
                    <option value="41CC">41CC - CC HQ CK cảng Cam Ranh Khánh Hòa</option>
                    <option value="41K1">41K1 - Đội Kiểm soát Hải quan</option>
                    <option value="41PE">41PE - CC HQ Vân Phong Khánh Hoà</option>
                    <option value="41QG">41QG - Chi cục HQ STQ</option>
                    <option value="43CN">43CN - CC HQ CK Cảng tổng hợp Bình Dương</option>
                    <option value="43IH">43IH - CC HQ Sóng Thần</option>
                    <option value="43K1">43K1 - Đội nghiệp vụ-CC HQ KCN Mỹ Phước</option>
                    <option value="43K2">43K2 - CC HQ Mỹ Phước-Đội TT Khu liên hợp</option>
                    <option value="43K3">43K3 - Đội TT K.Liên hợp-CCHQ Mỹ Phước</option>
                    <option value="43K4">43K4 - Đội Kiểm soát Hải quan</option>
                    <option value="43ND">43ND - CC HQ KCN Sóng thần Bình Dương</option>
                    <option value="43NF">43NF - CC HQ KCN Viet Nam - Singapore</option>
                    <option value="43NG">43NG - CC HQ KCN Việt Hương</option>
                    <option value="43NK">43NK - CC HQ KCN Mỹ Phước Bình Dương</option>
                    <option value="43PB">43PB - CC HQ QL ngoài KCN Bình Dương</option>
                    <option value="43PC">43PC - Chi Cục Hải quan Thủ Dầu Một</option>
                    <option value="43QL">43QL - Chi cục KTSTQ HQ Bình Dương</option>
                    <option value="45B1">45B1 - Đội Nghiệp vụ - CCHQ Mộc Bài TN</option>
                    <option value="45B2">45B2 - Đội Quản lý Khu TM - CN Mộc Bài</option>
                    <option value="45BB">45BB - CC HQ CK Mộc Bài Tây Ninh</option>
                    <option value="45BC">45BC - CC HQ CK Xa Mát Tây Ninh</option>
                    <option value="45BD">45BD - CC HQ Phước Tân Tây Ninh</option>
                    <option value="45BE">45BE - CC HQ CK Katum Tây Ninh</option>
                    <option value="45C1">45C1 - Đội Nghiệp vụ - CCHQ Xa Mát TN</option>
                    <option value="45C2">45C2 - Đội TT Chàng Riệc-CCHQ Xa Mát TN</option>
                    <option value="45F1">45F1 - Đội Nghiệp vụ-CCHQ Trảng Bàng TN</option>
                    <option value="45F2">45F2 - Đội TTHQ Khu C.Nghiệp Phước Đông</option>
                    <option value="45K1">45K1 - Đội Kiểm soát Hải quan</option>
                    <option value="45K2">45K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="45NF">45NF - CC HQ KCN Trảng Bàng Tây Ninh</option>
                    <option value="45QH">45QH - Chi cục KTSTQ HQ Tây Ninh</option>
                    <option value="47CD">47CD - CC HQ Long Thành Đồng Nai</option>
                    <option value="47CI">47CI - CC HQ Long Bình Tân</option>
                    <option value="47D1">47D1 - Đội nghiệp vụ - HQ Long Thành</option>
                    <option value="47D2">47D2 - Đội nghiệp vụ 2 - HQ Long Thành</option>
                    <option value="47D3">47D3 - Đội NV3, HQ Long Thành, Đồng Nai</option>
                    <option value="47I1">47I1 - Đội nghiệp vụ - HQ Long Bình Tân</option>
                    <option value="47I2">47I2 - Đội NV2, HQ Long Bình Tân, Đ.Nai</option>
                    <option value="47K1">47K1 - Đội Kiểm soát Hải quan</option>
                    <option value="47NB">47NB - CC HQ Biên Hoà</option>
                    <option value="47NF">47NF - CC HQ Thống Nhất Đồng Nai</option>
                    <option value="47NG">47NG - CC HQ Nhơn Trạch Đồng Nai</option>
                    <option value="47NM">47NM - CC HQ QL KCN Bình Thuận Đồng Nai</option>
                    <option value="47QN">47QN - Chi cục KTSTQ HQ Đồng Nai</option>
                    <option value="47XE">47XE - CC HQ KCX Long Bình Đồng Nai</option>
                    <option value="48BC">48BC - CC HQ Mỹ Quý Tây Long An</option>
                    <option value="48BD">48BD - Chi cục HQCK Quốc Tế Bình Hiệp</option>
                    <option value="48BE">48BE - CC HQ Hưng Điền Long An</option>
                    <option value="48BF">48BF - CC HQ Bến Lức</option>
                    <option value="48BI">48BI - CC HQ Đức Hòa Long An</option>
                    <option value="48CF">48CF - Chi cục HQ Bến Lức</option>
                    <option value="48CG">48CG - Chi cục HQCK Cảng Mỹ Tho</option>
                    <option value="48F1">48F1 - Đội nghiệp vụ KCN Long Hậu</option>
                    <option value="48F2">48F2 - Đội thủ tục- Chi cục HQ Bến Lức</option>
                    <option value="48K1">48K1 - Đội Kiểm soát Hải quan</option>
                    <option value="48QH">48QH - Chi cục KTSTQ HQ Long An</option>
                    <option value="49BB">49BB - CC HQ CK Thường Phước Đồng Tháp</option>
                    <option value="49BE">49BE - Chi cục HQ Sở Thượng Đồng Tháp</option>
                    <option value="49BF">49BF - CC HQ CK Thông Bình Đồng Tháp</option>
                    <option value="49BG">49BG - CC HQ cửa khẩu Dinh Bà</option>
                    <option value="49C1">49C1 - CCHQ CK Cảng Đ.Tháp-KV Cao Lãnh</option>
                    <option value="49C2">49C2 - CCHQ CK Cảng Đ.Tháp-KV Sa Đéc</option>
                    <option value="49CC">49CC - CC HQ Cảng Đồng Tháp</option>
                    <option value="49K1">49K1 - Đội Kiểm soát Hải quan</option>
                    <option value="49QJ">49QJ - Chi cục KTSTQ HQ Đồng Tháp</option>
                    <option value="50BB">50BB - CC HQ CK Tịnh Biên An Giang</option>
                    <option value="50BC">50BC - CC HQ Vĩnh Hội Đông An Giang</option>
                    <option value="50BD">50BD - CC HQ CK Vĩnh Xương An Giang</option>
                    <option value="50BJ">50BJ - CC HQ Bắc Đai An Giang</option>
                    <option value="50BK">50BK - CC HQ Khánh Bình An Giang</option>
                    <option value="50CE">50CE - CC HQ Cảng Mỹ Thới An Giang</option>
                    <option value="50K1">50K1 - Đội Kiểm soát Hải quan</option>
                    <option value="50K2">50K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="50QM">50QM - Chi cục KTSTQ HQ An Giang</option>
                    <option value="51BE">51BE - CC HQ Cảng Cát Lở Vũng Tàu</option>
                    <option value="51C1">51C1 - Đội TTHHXNK Kho ngoại quan</option>
                    <option value="51C2">51C2 - CC HQCK Phú Mỹ V.Tàu-Đội TT SP-PSA</option>
                    <option value="51CB">51CB - Chi cục HQ CK cảng Vũng tàu</option>
                    <option value="51CC">51CC - CC HQ CK Cảng Phú Mỹ Vũng Tàu</option>
                    <option value="51CH">51CH - CC HQ CK Cảng Côn Đảo Vũng Tàu</option>
                    <option value="51CI">51CI - CC HQ CK cảng Cái Mép (Vũng Tàu)</option>
                    <option value="51K1">51K1 - Đội Kiểm soát Hải quan</option>
                    <option value="51QJ">51QJ - Chi cục KTSTQ HQ Bà Rịa - Vũng Tàu</option>
                    <option value="53BC">53BC - Đội TT - CC HQCK Quốc Tế Hà Tiên</option>
                    <option value="53BK">53BK - CC HQ CK Giang Thành</option>
                    <option value="53CD">53CD - CC HQ CK Cảng Hòn Chông KG</option>
                    <option value="53CH">53CH - CC HQ Phú Quốc</option>
                    <option value="53K1">53K1 - Đội Kiểm soát Hải quan</option>
                    <option value="53K2">53K2 - Đội Kiểm soát phòng, chống ma túy</option>
                    <option value="53QJ">53QJ - Chi cục KTSTQ HQ Kiên Giang</option>
                    <option value="54CB">54CB - CC HQ CK Cảng Cần Thơ</option>
                    <option value="54CD">54CD - CC HQ CK Vĩnh Long</option>
                    <option value="54CE">54CE - Chi cục Hải quan Hậu Giang</option>
                    <option value="54K1">54K1 - Đội Kiểm soát Hải quan</option>
                    <option value="54PH">54PH - CC HQ Tây Đô Cần Thơ</option>
                    <option value="54PK">54PK - CC HQ Sóc Trăng</option>
                    <option value="54QJ">54QJ - Chi cục KTSTQ</option>
                    <option value="59BD">59BD - CC HQ Hòa Trung (Cà Mau)</option>
                    <option value="59CB">59CB - CC HQ CK Cảng Năm Căn Cà Mau</option>
                    <option value="59K1">59K1 - Đội Kiểm soát Hải quan</option>
                    <option value="59QE">59QE - Chi cục KTSTQ HQ Cà Mau</option>
                    <option value="60BD">60BD - CC HQ CK Nam Giang (Quảng Nam)</option>
                    <option value="60C1">60C1 - Đội NV-KCN ĐNam ĐNgọc QN</option>
                    <option value="60C2">60C2 - Đội Tây Giang-KCN ĐNam ĐNgọc QN</option>
                    <option value="60CB">60CB - CC HQ CK Cảng Kỳ Hà</option>
                    <option value="60K1">60K1 - Đội Kiểm soát Hải quan</option>
                    <option value="60NC">60NC - CC HQ KCN Điện Nam - Điện Ngọc</option>
                    <option value="60QE">60QE - Chi cục KTSTQ</option>
                    <option value="61A1">61A1 - Đội Nghiệp vụ Tổng hợp</option>
                    <option value="61A2">61A2 - Đội Thủ tục HQCK Tà Vát</option>
                    <option value="61A3">61A3 - Đội Nghiệp vụ - CC HQ Chơn Thành</option>
                    <option value="61A4">61A4 - Đội Nghiệp vụ 2 - CC HQ Chơn Thành</option>
                    <option value="61B1">61B1 - Đội NV Tổng hợp-CC Hoàng Diệu</option>
                    <option value="61B2">61B2 - Đội NV CK Tân Tiến-CC Hoàng Diệu</option>
                    <option value="61BA">61BA - Chi cục HQCK QT Hoa Lư</option>
                    <option value="61BB">61BB - CC HQ CK Hoàng Diệu Bình Phước</option>
                    <option value="61BC">61BC - CC HQ Cửa Khẩu Lộc Thịnh</option>
                    <option value="61K1">61K1 - Đội Kiểm soát Hải quan</option>
                    <option value="61PA">61PA - CC Hải quan Chơn Thành</option>
                    <option value="61QC">61QC - Chi cục KTSTQ HQ Bình Phước</option>
                    <option value="88AB">88AB - Chi Cuc HQ Thu nghiem RR</option>
                    <option value="A1K1">A1K1 - Phòng Tham mưu tổng hợp (Phòng 1)</option>
                    <option value="A1K2">A1K2 - Phòng Giám sát Hải quan trực tuyến (Phòng 3)</option>
                    <option value="A1K3">A1K3 - Phòng Xử lý vi phạm (Phòng 4)</option>
                    <option value="A1K4">A1K4 - Hải đội kiểm soát trên biển khu vực miền Bắc (Hải đội 1)</option>
                    <option value="A1K5">A1K5 - Hải đội kiểm soát trên biển khu vực miền Trung (Hải đội 2)</option>
                    <option value="A1K6">A1K6 - Hải đội kiểm soát trên biển khu vực miền Nam (Hải đội 3)</option>
                    <option value="A1K7">A1K7 - Đội Kiểm soát chống buôn lậu khu vực miền Bắc (Đội 1)</option>
                    <option value="A1K8">A1K8 - Đội Kiểm soát chống buôn lậu khu vực miền Trung (Đội 2)</option>
                    <option value="A1K9">A1K9 - Đội Kiểm soát chống buôn lậu khu vực miền Nam (Đội 3)</option>
                    <option value="A1S1">A1S1 - Đội Kiểm soát chống buôn lậu hàng giả và bảo vệ quyền sở hữu trí tuệ (Đội 4)</option>
                    <option value="A1S2">A1S2 - Đội Kiểm soát ma túy khu vực Miền Bắc (Đội 5)</option>
                    <option value="A1S3">A1S3 - Đội Kiểm soát ma túy khu vực Miền Nam (Đội 6)</option>
                    <option value="A1S4">A1S4 - Đội Điều tra hình sự (Đội 7)</option>
                    <option value="A2K1">A2K1 - Phòng Tổng hợp (Phòng 1)</option>
                    <option value="A2K2">A2K2 - Phòng Tham mưu xử lý &amp; quản lý doanh nghiệp ưu tiên (Phòng 2)</option>
                    <option value="A2K3">A2K3 - Phòng Tham mưu, hướng dẫn KTSTQ hàng hóa XNK theo loại hình kinh doanh (Phòng 3)</option>
                    <option value="A2K4">A2K4 - Phòng Tham mưu, hướng dẫn KTSTQ hàng hóa XNK theo loại hình khác (Phòng 4)</option>
                    <option value="A2K5">A2K5 - Phòng Thu thập, xác minh và xử lý thông tin (Phòng 5)</option>
                    <option value="A2K6">A2K6 - Chi cục KTSTQ khu vực miền Bắc (Chi cục 1)</option>
                    <option value="A2K7">A2K7 - Chi cục KTSTQ khu vực miền Trung (Chi cục 2)</option>
                    <option value="A2K8">A2K8 - Chi cục KTSTQ khu vực miền Nam (Chi cục 3)</option>
                    <option value="A3K1">A3K1 - Phòng Tổng hợp</option>
                    <option value="A3K2">A3K2 - Trung tâm phân tích</option>
                    <option value="A3K3">A3K3 - Chi cục Kiểm định Hải quan 1 (Hà Nội)</option>
                    <option value="A3K4">A3K4 - Chi cục Kiểm định Hải quan 2 (Hải Phòng)</option>
                    <option value="A3K5">A3K5 - Chi cục Kiểm định Hải quan 3 (TP. Hồ Chí Minh)</option>
                    <option value="A3K6">A3K6 - Chi cục Kiểm định Hải quan 4 (Đà Nẵng)</option>
                    <option value="A3K7">A3K7 - Chi cục Kiểm định Hải quan 5 (Quảng Ninh)</option>
                    <option value="A3K8">A3K8 - Chi cục Kiểm định Hải quan 6 (Lạng Sơn)</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12 nsw-text-center">
                <a href="javascript:;" class="btn blue" id="btnToKhaiSearch" style="display: ${IsView}"><i class="fa fa-search" ></i> <spring:message code="common.button.tim_kiem" /></a>
            </div>
        </div>
        <p><b class="nsw-text-underline red">{{ _lang "most_01_tokhai_ketquatimkiem" }}</b></p>
        <hr />    
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_thongtinchung" }}</b></p>
        <div class="panel-body"> 
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_sotokhai"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKSo"></b>
                </div>
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_mahaiquan"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKMaHq"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_ngaydangky"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKNgayDK"></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_hanghoa" }}</b></p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column table_tokhai_hanghoa">
            <thead>
                <tr>
                    <th><b>{{_lang "common_tokhai_hanghoa_stt"}}</b></th>
                    <th class="nsw-text-center"><input id="cbAllProducts" data="0" type="checkbox" name="cbAllProducts"/></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_mahs"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_tenhanghoa"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_klsl"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_donvitinh"}}</th>
                </tr>
            </thead>
            <tbody class="tokhai-hanghoa-container">

            </tbody>
        </table>
        <div class="row">                            
            <div class="col col-md-6">
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div class="tokhai-hanghoa-pager"></div>
            </div>
        </div> 
    </form>

</div>