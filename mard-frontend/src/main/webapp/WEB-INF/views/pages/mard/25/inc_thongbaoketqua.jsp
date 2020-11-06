<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="mard25KQKT" data-bind="" class="modal container in modal-overflow" tabindex="-1">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container" style="display: flex">
        <div id="content-hoso" size="a4" class="a4 col-md-12">

            <div class="row">
                <div class="col-md-6 text-center">

                    <h5 style="font-weight: bold;">
                        BỘ NÔNG NGHIỆP <br/>
                        VÀ PHÁT TRIỂN NÔNG THÔN
                    </h5>
                    <h5 style="font-weight: bold">
                        CỤC CHĂN NUÔI
                    </h5>
                    <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    Số:
                </div>
                <div class="col-md-6 text-center">
                    <h4 style="font-weight: bold;">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h5 style="font-weight: bold">
                        Độc lập - Tự do - Hạnh phúc
                    </h5>
                    <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    ngày tháng năm
                </div>
            </div>
            <div class="row text-center">
                <h4 style="font-weight: bold">THÔNG BÁO</h4>
                <h5 style="font-weight: bold">Kết quả kiểm tra nhà nước về chất lượng thức ăn chăn nuôi nhập khẩu</h5>
                <div style="border-top: #000000 solid 1px; margin: auto; width: 320px"></div>
            </div>
            <div class="row">
                <b>1. Thông tin của lô TACN được kiểm tra</b>
            </div>
            <div class="row">
                <form role="form" class="form-horizontal">
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center bold"> <spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                            <th class="text-center bold"> Tên TACN</th>
                            <th class="text-center bold"> Mã số công nhận</th>
                            <th class="text-center bold"> Hãng sản xuất</th>
                            <th class="text-center bold"> Nước sản xuất</th>
                            <th class="text-center bold"> Khối lượng</th>
                            <th class="text-center bold"> Số lượng</th>
                            <th class="text-center bold"> Ghi chú</th>
                        </tr>
                        </thead>
                        <tbody >
                        <tr>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="row">
                - Cửa khẩu nhập:
            </div>
            <div class="row">
                - Thời gian nhập khẩu (tháng, năm):
            </div>
            <div class="row">
                - Thuộc lô hàng có các chứng từ sau: <br/>
                + Hợp đồng số:<br/>
                + Hóa đơn số:<br/>
                + Giấy đăng ký kiểm tra xác nhận chất lượng số:<br/>
                - Tên tổ chức nhập khẩu:<br/>
                Địa chỉ: <br/>
            </div>
            <div class="row">
                <b>2. Căn cứ kiểm tra:</b><br/>
                + Tiêu chuẩn công bố áp dụng (số hiệu TCCS):<br/>
                + Quy chuẩn kỹ thuật (nhóm, loại hàng hóa tại QCVN 01-190/BNNPTNT):<br/>
                <b>3. Kết quả đánh giá sự phù hợp</b><br/>
                Giấy chứng nhận hợp quy lô TACN nhập khẩu số:<br/>
                <b>3. Kết quả kiểm tra nhà nước:</b><br/>
                Lô hàng đáp ứng yêu cầu chất lượng hàng hóa nhập khẩu./.<br/>

            </div>
            <div class="row">
                <div class="col-md-6">

                </div>
                <div class="col-md-6 text-center">
                    <h4 style="font-weight: bold">CƠ QUAN KIỂM TRA</h4>
                    <i>(Ký tên, đóng dấu)</i>
                </div>
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
