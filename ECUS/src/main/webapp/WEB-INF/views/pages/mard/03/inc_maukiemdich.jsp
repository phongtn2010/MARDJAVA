<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <page size="A4" class="a4-padding">
        <p class="title text-centers">
            <span style="font-size: medium">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</span>
            <br/>
            <span style="font-size: small">Độc lập - Tự do - Hạnh phúc</span> <br/>
            -------------------------
        </p>
        <p class="text-right">
            <b data-bind="text : fiDiaDiemKiemDich"></b>, <span data-bind="html: strNgayKy"></span>
        </p>
        <p class="title">
            <span style="font-size: medium">ĐƠN KHAI BÁO KIỂM DỊCH (*)</span>
            <br/>
            <span style="font-size: small" class="t-italic">Số: <b data-bind="text : fiSoDonKhaiBao"></b>  /ĐK_KD</span>
        </p>
        <p class="content text-center">
            Kính gửi: <b data-bind="text : fiTenCQ"></b> (**)
        </p>
        <p class="content">
            Tên tổ chức, cá nhân đăng ký:  <b data-bind="text : fiTenDn"></b>
        </p>
        <p class="content">
            Địa chỉ:  <b data-bind="text : fiTenDn"></b>
        </p>
        <p class="content">
            Điện thoại: <b data-bind="text : fiSdtDn"></b>&nbsp; Fax: <b data-bind="text : fiFaxDn"></b>&nbsp; Email: <b data-bind="text : fiEmailDn"></b>
        </p>
        <p class="content">
            Đề nghị quý Cơ quan kiểm dịch lô hàng (***): <b data-bind="text : fiTenNoiDK"></b> (nhập khẩu, TNTX, quá cảnh lãnh thổ,...)
        </p>
        <p class="content">
            1. Tên hàng: <b data-bind="text : fiTenHang"></b>
        </p>
        <p class="content">
            2. Nơi sản xuất: <b data-bind="text : fiNoiSx"></b>
        </p>
        <p class="content">
            3. Số lượng: <b data-bind="text : fiSoluongHH"></b>
        </p>
        <p class="content">
            4. Trọng lượng tịnh: <b data-bind="text : fiTrongluong"></b>
        </p>
        <p class="content">
            5. Trọng lượng cả bì: <b data-bind="text : fiTrongluongcabi"></b>
        </p>
        <p class="content">
            6. Loại bao bì: <b data-bind="text : fiLoaibaobi"></b>
        </p>
        <p class="content">
            7. Số hợp đồng hoặc số chứng từ thanh toán (L/C, TTr...): <b data-bind="text : fiSoHopDongCt"></b>
        </p>
        <p class="content">
            8. Tổ chức, cá nhân xuất khẩu: <b data-bind="text : fiToChucXk"></b>
        </p>
        <p class="content">
            9. Nước xuất khẩu: <b data-bind="text : fiTenNuocXk"></b>
        </p>
        <p class="content">
            10. Cửa khẩu xuất: <b data-bind="text : fiTenCuaKhauXuat"></b>
        </p>
        <p class="content">
            11. Tổ chức, cá nhân nhập khẩu: <b data-bind="text : fiToChucNk"></b>
        </p>
        <p class="content">
            12. Nước nhập khẩu: <b data-bind="text : fiTenNuocNk"></b>
        </p>
        <p class="content">
            13. Phương tiện vận chuyển: <b data-bind="text : fiPtVanChuyen"></b>
        </p>
        <p class="content">
            14. Cửa khẩu nhập: <b data-bind="text : fiTenCuaKhauNhap"></b>
        </p>
        <p class="content">
            15. Mục đích sử dụng: <b data-bind="text : fiMucDichSuDung"></b>
        </p>
        <p class="content">
            16. Văn bản chấp thuận kiểm dịch của Cục Thú y (nếu có): <b data-bind="text : fiVbChapThuanKiemDich"></b>
        </p>
        <p class="content">
            17. Địa điểm kiểm dịch: <b data-bind="text : fiDiaDiemKiemDich"></b>
        </p>
        <p class="content">
            18. Thời gian kiểm dịch: từ &nbsp;<b data-bind="date : fiTgKiemDichTu"></b> &nbsp; đến &nbsp;<b data-bind="date : fiTgKiemDichDen"></b>
        </p>
        <p class="content">
            19. Địa điểm giám sát (nếu có): <b data-bind="text : fiDiaDiemGs"></b>
        </p>
        <p class="content">
            20. Thời gian giám sát: từ &nbsp;<b data-bind="date : fiTgGsTu"></b> &nbsp; đến &nbsp;<b data-bind="date : fiTgGsDen"></b>
        </p>
        <p class="content">
            21. Số bản giấy chứng nhận kiểm dịch cần cấp: <b data-bind="text : fiSoGcnKiemDich"></b>
        </p>
        <p class="content">
            Chúng tôi xin cam kết: bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa về đúng địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông sau khi được quý Cơ quan cấp Giấy chứng nhận kiểm dịch (****).
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="left ">
                </td>
                <td class="t-center pb-long">
                    <span class="t-bold">TỔ CHỨC/ CÁ NHÂN ĐĂNG KÝ</span><br/>
                    (Ký, đóng dấu, ghi rõ họ tên)<br/>
                </td>
            </tr>
            <tr>
                <td class="left "></td>
                <td class="t-center pb-long">
                    <b data-bind="text: fiNguoiKy"></b>
                </td>
            </tr>
        </table>
    </page>
</fieldset>