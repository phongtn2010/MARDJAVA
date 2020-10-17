<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
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
        1. Sản phẩm thức ăn chăn nuôi nhập khẩu đã được phép lưu hành tại Việt Nam có tên dưới đây:
    </p>
    <p class="content">
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tensanpham" /></th>
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.macongnhan" /></th>
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.mucchatluong" /></th>
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.hangsanxuat" /></th>
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.nuocsanxuat" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: lstHanghoas">
                <tr>
                    <td data-bind="text: fiStt"></td>  
                    <td data-bind="text: fiTenHh"></td> 
                    <td data-bind="text: fiMsChungnhan"></td>                        
                    <td data-bind="text: fiMucChatluong"></td> 
                    <td data-bind="text: fiHangSx"></td> 
                    <td data-bind="text: fiNuocSx"></td> 
                </tr>
            </tbody>
        </table>
    </p>
    <p class="content">
        Được áp dụng chế độ <span data-bind="text : fiCheDo"></span> có thời hạn theo quy định tại Nghị định số <span data-bind="text : fiTtApdung"></span> của Chính phủ kể từ ngày <span data-bind="text: fiNgayKyText2"></span> đến hết ngày <span data-bind="text: fiNgayHetHieuLuc"></span>(Không áp dụng khi thời gian lưu hành của sản phẩm đã hết hạn)        
    </p>
    <p class="content">	
        2. Cục Chăn nuôi giao <span data-bind="text : fiCqgsBac"></span> giám sát chất lượng mặt hàng nêu trên tại các tỉnh phía Bắc, giao <span data-bind="text : fiCqgsTrung"></span> giám sát chất lượng mặt hàng nêu trên tại các tỉnh phía Trung và giao <span data-bind="text : fiCqgsNam"></span> giám sát chất lượng mặt hàng nêu trên tại các tỉnh phía Nam được nhập khẩu bởi <span data-bind="text : tenDN"></span> trong thời gian áp dụng <span data-bind="text : fiCheDo"></span> có thời hạn
    </p>
    <p class="content">
        3. Yêu cầu tổ chức, cá nhân thực hiện đúng các quy định hiện hành về quản lý thức ăn chăn nuôi./.
    </p>

    <table class="tb-content tb-none-border w100p">
        <tr>
            <td class="left w50p">
                <span>- Như trên;</span><br/>
                <span>- Lưu: </span><br/>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">LÃNH ĐẠO CỤC</span><br/>
                (Ký, đóng dấu, ghi rõ họ tên)<br/>  
                <br/>   
                <br/>   
                <span data-bind="text : fiNguoiKy"></span>
            </td>
        </tr>
    </table>
</page>

