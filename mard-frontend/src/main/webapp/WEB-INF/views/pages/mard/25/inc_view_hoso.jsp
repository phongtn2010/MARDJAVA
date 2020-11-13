<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="mard25ViewHSModal" data-bind="with: selectedHoSo" class="modal container in modal-overflow" tabindex="-1">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container" style="display: flex">
        <div id="content-hoso" size="a4" class="a4 col-md-12">
            <div class="text-right" style="padding-top: 10px">
                <h5 class="text-border" style="font-weight: bold">Mẫu số 12.TACN</h5>
            </div>
            <div class="text-center">
                <h4 style="font-weight: bold;">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                </h4>
                <h5 style="font-weight: bold">
                    Độc lập - Tự do - Hạnh phúc
                </h5>

                <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>

            </div>
            <div class="text-center" style="padding-top: 15px;">
                <h4 class="uppercase" style="font-weight: bold">ĐƠN <spring:message code="mard.25.don_dk"></spring:message></h4>
                <p class="code">
                    <span class="text-border">Số: <span></span></span>
                </p>
                <br/>
                <br/>
                <p>
                    <b>Kính gửi: Cục Chăn nuôi</b>
                </p>
            </div>
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td>1. Bên bán hàng (hãng, nước): <span data-bind="text: fiSellName"/></td>
                    </tr>
                    <tr>
                        <td>2. Địa chỉ, số điện thoại, số fax:<span data-bind="text: fiSellAddress"></span> <span data-bind="text: fiSellTel"></span> <span data-bind="text: fiSellFax"></span></td>
                    </tr>
                    <tr>
                        <td>3. Nơi xuất hàng: <span data-bind="text: fiSellExport"></span></td>
                    </tr>
                    <tr>
                        <td>4. Bên mua hàng: <span data-bind="text: fiImporterName"></span></td>
                    </tr>
                    <tr>
                        <td>5. Địa chỉ, số điện thoại, số fax: <span data-bind="text: fiImporterAddress"></span> <span data-bind="text: fiImporterTel"></span> <span data-bind="text: fiImporterFax"></span></td>
                    </tr>
                    <tr>
                        <td>6. Nơi nhận hàng: <span data-bind="text: fiImporterAddress"></span></td>
                    </tr>
                    <tr>
                        <td>7. Thời gian nhập khẩu dự kiến: <span data-bind="date: fiPurchFromDate"></span>  - <span data-bind="date: fiPurchToDate"></span></td>
                    </tr>
                    <tr>
                        <td class="text-center"><b>MÔ TẢ HÀNG HÓA</b></td>
                    </tr>
                </tbody>
            </table>
            <table class="table table-bordered">
                <thead>
                    <tr style="font-weight: bold">
                        <td class="text-center">Số TT</td>
                        <td class="text-center">Tên TACN</td>
                        <td class="text-center">Mã số công nhận</td>
                        <td class="text-center">Nhóm TACN</td>
                        <td class="text-center">Loại TACN</td>
                        <td class="text-center">Hãng sản xuất</td>
                        <td class="text-center">Nước sản xuất</td>
                        <td class="text-center">Khối lượng</td>
                        <td class="text-center">Số lượng</td>
                    </tr>
                </thead>
                <tbody data-bind="foreach: fiTbdHanghoa26List">
                    <tr>
                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                        <td data-bind="text : fiProName"></td>
                        <td data-bind="text : fiProCode"></td>
                        <td data-bind="text : $root.getTenNhom(fiProIdNhom)"></td>
                        <td data-bind="text : $root.getTenNhom(fiProIdLoai)"></td>
                        <td data-bind="text : fiProMadeIn"></td>
                        <td data-bind="text : fiProCountryName"></td>
                        <td data-bind="text : fiProductKL"></td>
                        <td data-bind="text : fiProductSL"></td>
                    </tr>
                </tbody>
            </table>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>8. Địa điểm tập kết hàng: <span data-bind="text: fiAddressGath"></span></td>
                </tr>
                <tr>
                    <td>9. Ngày đăng ký lấy mẫu đánh giá: Từ ngày <span data-bind="date: fiRegSamFromDate"></span> đến ngày <span data-bind="date: fiRegSamToDate"></span></td>
                </tr>
                <tr>
                    <td>10. Địa điểm đăng ký lấy mẫu đánh giá: <span data-bind="text: fiAddressRegSample"></span></td>
                </tr>
                <tr>
                    <td>11. Thông tin người liên hệ: <span data-bind="text: fiContactName"></span></td>
                </tr>
                <tr>
                    <td>12. Hợp đồng mua bán: <span data-bind="foreach: lstHD">Số:<b style="text-decoration: none" data-bind="text: fiFileHD"></b> Ngày <b style="text-decoration: none" data-bind="date: fiFileHDDate"></b>  </span></td>
                </tr>
                <tr>
                    <td>13. Hóa đơn mua bán: <span data-bind="foreach: lstHoaDon">Số:<b style="text-decoration: none" data-bind="text: fiFileHD"></b> Ngày <b style="text-decoration: none" data-bind="date: fiFileHDDate"></b>  </span></td>
                </tr>
                <tr>
                    <td>14. Phiếu đóng gói số: <span data-bind="foreach: lstPhieu">Số:<b style="text-decoration: none" data-bind="text: fiFileHD"></b> Ngày <b style="text-decoration: none" data-bind="date: fiFileHDDate"></b>  </span></td>
                </tr>
                <tr>
                    <td class="text-center"><b>DÀNH CHO CƠ QUAN KIỂM TRA</b></td>
                </tr>
                <tr>
                    <td>15. Yêu cầu đánh giá chỉ tiêu(2): Xem chi tiết phụ lục kèm theo <br/>
                        Biện pháp kiểm tra(3): <span data-bind="text: $root.getHoSoTypeFull(fiHSType)"></span>
                    </td>
                </tr>
                <tr>
                    <td>15. Đơn vị thực hiện đánh giá: </td>
                </tr>
                <tr>
                    <td>Đối với hàng nhập khẩu, Giấy này có giá trị để làm thủ tục hải quan. Sau đó doanh nghiệp phải xuất trình toàn bộ hồ sơ và hàng hóa đã hoàn thành thủ tục hải quan cho cơ quan đánh giá để được đánh giá chất lượng theo quy định</td>
                </tr>
                </tbody>
            </table>
            <p>(1):Ghi tên loại thức ăn chăn nuôi nhập khẩu. Thức ăn truyền thống, thức ăn hỗn hợp hoàn chỉnh, thức ăn đậm đặc, nguyên liệu đơn, thức ăn dạng hỗn hợp, loại khác; trường hợp thức ăn truyền thống phải kèm theo bản mô tả chi tiết sản phẩm nhập khẩu (gồm: tên thương mại, bản chất sản phẩm).</p>
            <p>(2):Tối thiêu 01 chỉ tiêu chất lương trong tiêu chuẩn công bố áp dụng và các chỉ tiêu an toàn theo quye định tại quy chuẩn kỹ thuật quốc gia tương ứng.</p>
            <p>(3):Ghi "miễn kiểm tra" nếu lô hàng áp dụng chế độ miễn kiểm tra có thời hạn hoặc "kiểm tra theo điểm a khoản 2 Điều 18 của Nghị đinh này" hoặc "kiểm tra theo điểm b khoản 2 Điều 18 của Nghị định này".</p>
            <div class="row">
                <div class="col-md-6 text-center" style="">
                    <span data-bind="text: $root.getNoiKy(fiSignAddress)"></span> ngày <span data-bind="text: ngayKy"></span>  tháng <span data-bind="text: thangKy"></span>  năm <span data-bind="text: namKy"></span> <br/>
                    <b>TỔ CHỨC, CÁ NHÂN NHẬP KHẨU</b> <br/>
                    <i>(ký tên, đóng dấu)</i><br/><br/><br/><br/>
                    <span data-bind="text: fiSignName"></span>
                </div>
                <div class="col-md-6 text-center" style="">
                    ngày tháng năm<br/>
                    <b>TÊN CƠ QUAN KIỂM TRA</b> <br/>
                    <i>(ký tên, đóng dấu)</i>
                </div>
            </div>
            <div id="phuluc-hoso" data-bind="visible: fiHSStatus >=26">
                <div class="text-center">
                    <h4 style="font-weight: bold;">
                        PHỤ LỤC
                    </h4>
                    Kèm theo Giấy đăng ký kiểm tra xác nhận chất lượng số ngày (thay thế Giấy đăng ký kiểm tra xác nhận chất lượng số mã hồ sơ)
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr style="font-weight: bold">
                        <td class="text-center">Tên TACN</td>
                        <td class="text-center">Chỉ tiêu phân tích</td>
                        <td class="text-center">Hình thức công bố</td>
                        <td class="text-center">Hàm lượng</td>
                        <td class="text-center">Đơn vị tính</td>
                        <td class="text-center">Ghi chú</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr></tr>
                    </tbody>
                </table>
                <p style="font-weight: bold" data-bind="visible: $root.getHoSoType(fiHSType)=='2a'">Lưu ý: Trong thời gian 15 ngày làm việc kể từ ngày thông quan hàng hóa, người nhập khẩu phải nộp kết quả tự đánh giá sự phù hợp theo quy định về Cục Chăn nuôi thông qua hệ thống Một cửa Quốc gia.</p>
                <p style="font-weight: bold" data-bind="visible: $root.getHoSoType(fiHSType)=='2b'">Lưu ý: Trong thời hạn 15 ngày làm việc kể từ ngày thông quan hàng hóa, người nhập khẩu phải nộp bản sao ý bản chính (có ký tên và đóng dấu của người nhập khẩu) Giấy chứng nhận hợp quy lô hàng thức ăn chăn nuôi nhập khẩu theo quy định về Cục Chăn nuôi thông qua hệ thống Một cửa Quốc gia</p>
            </div>
        </div>

    </div>
    <div class="modal-footer">
        <div class="text-center">
            <a class="btn green" data-bind="">
                <spring:message code="common.button.tai_ve"/>
            </a>
            <a class="btn" href="javascript:void(0)" data-dismiss="modal">
                <spring:message code="conmon.button.dong"/>
            </a>
        </div>
    </div>
</div>
<style>
    .text-border {
        border: 1px solid;
        display: inline;
        padding: 5px;
    }
</style>
