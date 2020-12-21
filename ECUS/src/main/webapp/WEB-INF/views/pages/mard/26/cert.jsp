<%@ page pageEncoding="UTF-8"%>
<div size="A4" class="a4-padding a4 col-md-12">
    <%--    <table class="tb-none-border w100p">--%>
    <%--        <tr>--%>
    <%--            <td class="w35p">--%>
    <%--                <div class="t-center t-bold">--%>
    <%--                    <p class="content">BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN</p>--%>
    <%--                    <span class="content t-bold">CỤC CHĂN NUÔI</span>--%>
    <%--                </div>--%>
    <%--            </td>--%>
    <%--            <td style="vertical-align: text-top;">--%>
    <%--                <div class="right t-center t-bold">--%>
    <%--                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM--%>
    <%--                    <br/>--%>
    <%--                    Độc lập - Tự do - Hạnh phúc--%>
    <%--                </div>--%>
    <%--            </td>--%>
    <%--        </tr>--%>
    <%--        <tr>--%>
    <%--            <td class="w35p">--%>
    <%--                <div class="left t-center">--%>
    <%--                    <p class="content">Số <span class="content" data-bind="text: fiSoCVMienKiem"></span></p>--%>
    <%--                    <p>V/v áp dụng chế độ miễn giảm kiểm tra chất lượng TACN có thời hạn</p>--%>
    <%--                </div>--%>
    <%--            </td>--%>
    <%--            <td>--%>
    <%--                <div class="right text-right-center">--%>
    <%--                    Hà Nội, <span data-bind="text: fiNgayKyCV"></span>--%>
    <%--                </div>--%>
    <%--            </td>--%>
    <%--        </tr>--%>
    <%--    </table>--%>
    <div class="row">
        <div class="col-md-6">
            <div style="text-align: center">
                <h4 style="font-weight: bold">
                    BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN
                </h4>
                <h4 style="font-weight: bold">
                    CỤC CHĂN NUÔI
                </h4>

                <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                <p class="content">Số <span class="content" data-bind="text: fiSoCVMienKiem"></span></p>
                <p>V/v áp dụng chế độ miễn giảm kiểm tra chất lượng TACN có thời hạn</p>
            </div>

        </div>
        <div class="col-md-6">
            <div style="text-align: center">
                <h4 style="font-weight: bold;">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                </h4>
                <h5 style="text-align: center">
                    <b>Độc lập - Tự do - Hạnh phúc</b>
                </h5>

                <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                <div class="right text-right-center">
                    Hà Nội, <span data-bind="date: fiNgayKyCV"></span>
                </div>
            </div>
        </div>
    </div>
    <br/><br/>
    <p class="title text-center">
        Kính gửi: <span data-bind="text : fiTenDn"></span>
    </p><br/>
    <p class="content">
        Cục Chăn nuôi đã nhận được Văn bản số <span data-bind="text : fiMaHoso"></span>. ngày <span data-bind="date : fiNgayGui"></span>. của <span data-bind="text : fiTenDn"></span> đề nghị
        miễn giảm kiểm tra chất lượng có thời hạn đối với thức ăn chăn nuôi nhập khẩu. Sau khi thẩm định hồ sơ, Cục Chăn nuôi có ý kiến như sau:
    </p>
    <p class="content">
        1. Sản phẩm thức ăn chăn nuôi nhập khẩu dưới đây được áp dụng chế độ miễn giảm kiểm tra chất lượng theo quy định tại điểm a khoản 5 Điều 18 Nghị định số 13/2020/NĐ-CP kể từ ngày
        <span data-bind="date : fiHieuLucTuNgay"></span> đến hết ngày <span data-bind="date : fiHieuLucToiNgay"></span>
    </p>
    <p class="content">
        Tên TACN: <span data-bind="text : tenTACN"></span>
    </p>
    <p class="content">
        Mã số công nhận: <span data-bind="text : maSCN"></span>
    </p>
    <p class="content">
        Nhóm TACN: <span data-bind="text : nhomTACN"></span>
    </p>
    <p class="content">
        Loại TACN: <span data-bind="text : loaiTACN"></span>
    </p>
    <p class="content">
        Hãng sản xuất: <span data-bind="text : hangSX"></span>
    </p>
    <p class="content">
        Nước sản xuất: <span data-bind="text : nuocSX"></span>
    </p>
    <p class="content">
        Thành phần nguyên liệu: <span data-bind="text : thanhPhan"></span>
    </p>
    <p class="content">
        Dạng, màu sản phẩm: <span data-bind="text : dangMau"></span>
    </p>
    <p class="content">
        Tiêu chuẩn cơ sở: <span data-bind="text : tieuchuan"></span>
    </p>
    <p class="content">
        Chỉ tiêu chất lượng của sản phẩm:
    </p>
    <p class="content">
    <table class="table table-striped table-bordered table-hover table-checkable order-column" >
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
            <th class="text-center">Tên chỉ tiêu chất lượng</th>
            <th class="text-center">Hình thức công bố</th>
            <th class="text-center">Hàm lượng</th>
            <th class="text-center">Đơn vị tính</th>
        </tr>
        </thead>
        <tbody data-bind="foreach: CLList">
        <tr>
            <td class="text-center" data-bind="text: $index() + 1">
            <td class="text-center" data-bind="text: fiProCLTarg">
            <td class="text-center" data-bind="text: $root.getHinhThucCB(fiProCLCompare)">
            <td class="text-center" data-bind="text: fiProCLContent">
            <td class="text-center" data-bind="text: fiProCLUnitName">
            </td>
        </tr>
        </tbody>
    </table>
    </p>
    <p class="content">
        Chỉ tiêu an toàn của sản phẩm:
    </p>
    <p class="content">
    <table class="table table-striped table-bordered table-hover table-checkable order-column" >
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
            <th class="text-center">Tên chỉ tiêu an toàn</th>
            <th class="text-center">Hình thức công bố</th>
            <th class="text-center">Hàm lượng</th>
            <th class="text-center">Đơn vị tính</th>
        </tr>
        </thead>
        <tbody data-bind="foreach: ATList">
        <tr>
            <td class="text-center" data-bind="text: $index() + 1">
            <td class="text-center" data-bind="text: fiProATTarg">
            <td class="text-center" data-bind="text: $root.getHinhThucCB(fiProATCompare)">
            <td class="text-center" data-bind="text: fiProATContent">
            <td class="text-center" data-bind="text: fiProATUnitName">
            </td>
        </tr>
        </tbody>
        </tbody>
    </table>
    </p>

    <p class="content">
        2. Trong thời gian được miễn giảm kiểm tra, <span data-bind="text : fiTenDn"></span> thực hiện cập nhập thông tin lô hàng theo quy định tại điểm b khoản 5
        Điều 18 Nghị định số 13/2020/NĐ-CP và phải báo cáo về Cục Chăn nuôi tình hình nhập khẩu theo quy định tại Nghị định số 74/2018/NĐ-CP.
    </p>
    <p class="content">
        3. Yêu cầu tổ chức, cá nhân thực hiện đúng các quy định hiện hành về quản lý thức ăn chăn nuôi./.
    </p>
    <br/><br/><br/>
    <div class="row">
        <div class="col-md-6 text-left">
            <span class="bold">Nơi nhận;</span><br/>
            <span>- Như trên;</span><br/>
            <span>- Hải quan, cửa khẩu;</span><br/>
            <span>- Lưu: VT, TACN</span><br/>
        </div>
        <div class="col-md-6 text-center">
            <span class="bold">LÃNH ĐẠO CỤC</span><br/>
            <br/>
            <br/>
            <span class="bold" data-bind="text : fiNguoiKy"></span>
        </div>
    </div>
    <%--    <table class="tb-content tb-none-border w100p">--%>
    <%--        <tr>--%>
    <%--            <td class="left w50p">--%>
    <%--                <span class="t-bold">Nơi nhận;</span><br/>--%>
    <%--                <span>- Như trên;</span><br/>--%>
    <%--                <span>- Hải quan, cửa khẩu;</span><br/>--%>
    <%--                <span>- Lưu: VT, TACN</span><br/>--%>
    <%--            </td>--%>
    <%--            <td class="t-center pb-long">--%>
    <%--                <span class="t-bold">LÃNH ĐẠO CỤC</span><br/>--%>
    <%--                <br/>   --%>
    <%--                <br/>   --%>
    <%--                <span data-bind="text : fiNguoiKy"></span>--%>
    <%--            </td>--%>
    <%--        </tr>--%>
    <%--    </table>--%>
</div>

