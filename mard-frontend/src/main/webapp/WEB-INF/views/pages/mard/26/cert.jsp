<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding" data-bind="with: selectedHoso">
    <table class="tb-none-border w100p">
        <tr>
            <td class="w35p">
                <div class="t-center t-bold">
                    <p class="content">BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN</p>
                    <span class="content t-bold">CỤC CHĂN NUÔI</span>
                </div>
            </td>
            <td style="vertical-align: text-top;">
                <div class="right t-center t-bold">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    <br/>
                    Độc lập - Tự do - Hạnh phúc
                </div>
            </td>
        </tr>
        <tr>
            <td class="w35p">
                <div class="left t-center">
                    <p class="content">Số <span class="content" data-bind="text: fiSoCv"></span></p>
                    <p>V/v áp dụng chế độ <span data-bind="text : fiCheDo"></span> có thời hạn</p>
                </div>
            </td>
            <td>
                <div class="right t-center">
                    Hà Nội, <span data-bind="text: fiNgayKyText"></span>
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        Kính gửi: <span data-bind="text : tenDN"></span>
    </p>
    <p class="content">
        Cục Chăn nuôi đã nhận được Văn bản số <span data-bind="text : fiMaHoso"></span>. ngày <span data-bind="text : fiNgaygui"></span>. của tổ chức, cá nhân đề nghị áp dụng chế độ <span data-bind="text : fiCheDo"></span> có thời hạn đối với thức ăn chăn nuôi nhập khẩu. Sau khi thẩm định hồ sơ, Cục Chăn nuôi có ý kiến như sau:
    </p>    
    <p class="content">
        1. Sản phẩm thức ăn chăn nuôi nhập khẩu dưới đây được áp dụng chế độ miễn giảm kiểm tra chất lượng theo quy định tại điểm a khoản 5 Điều 18 Nghị định số 13/2020/NĐ-CP kể từ ngày
        <span data-bind="text : fiHieuLucTuNgay"></span> đến hết ngày <span data-bind="text : fiHieuLucToiNgay"></span>
    </p>
    <p class="content">
        Tên TACN:
    </p>
    <p class="content">
        Mã số công nhận:
    </p>
    <p class="content">
        Nhóm TACN:
    </p>
    <p class="content">
        Loại TACN:
    </p>
    <p class="content">
        Hãng sản xuất:
    </p>
    <p class="content">
        Nước sản xuất:
    </p>
    <p class="content">
        Thành phần nguyên liệu:
    </p>
    <p class="content">
        Dạng, màu sản phẩm:
    </p>
    <p class="content">
        Tiêu chuẩn cơ sở:
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
            <tbody data-bind="">
                <tr>

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
        <tbody data-bind="">
        <tr>
        </tr>
        </tbody>
    </table>
    </p>

    <p class="content">	
        2. Trong thời gian được miễn giảm kiểm tra, <span data-bind="text : fiNguoitao"></span> thực hiện cập nhập thông tin lô hàng theo quy định tại điểm b khoản 5
        Điều 18 Nghị định số 13/2020/NĐ-CP và phải báo cáo về Cục Chăn nuôi tình hình nhập khẩu theo quy định tại Nghị định số 74/2018/NĐ-CP.
    </p>
    <p class="content">
        3. Yêu cầu tổ chức, cá nhân thực hiện đúng các quy định hiện hành về quản lý thức ăn chăn nuôi./.
    </p>

    <table class="tb-content tb-none-border w100p">
        <tr>
            <td class="left w50p">
                <span class="t-bold">Nơi nhận;</span><br/>
                <span>- Như trên;</span><br/>
                <span>- Hải quan, cửa khẩu;</span><br/>
                <span>- Lưu: VT, TACN</span><br/>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">LÃNH ĐẠO CỤC</span><br/>
                <br/>   
                <br/>   
                <span data-bind="text : fiNguoiKy"></span>
            </td>
        </tr>
    </table>
</page>

