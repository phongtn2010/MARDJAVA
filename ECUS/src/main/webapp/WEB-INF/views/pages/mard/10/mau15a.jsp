<%-- 
    Document   : mau15a
    Created on : Aug 7, 2017, 2:25:28 PM
    Author     : hieptran
--%>
<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td class="w35p">
                <div class="left t-center t-bold">
                    <p class="content t-bold">CỤC THÚ Y</p>
                    <span data-bind="text : fiTenCqkddv"></span>
                </div>
            </td>
            <td>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFgAAABjCAYAAAAfKMdaAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QUQ1NTEyRDU3QjUzMTFFNzg4OThBOTFERUMxMEUzOEYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QUQ1NTEyRDY3QjUzMTFFNzg4OThBOTFERUMxMEUzOEYiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpBRDU1MTJEMzdCNTMxMUU3ODg5OEE5MURFQzEwRTM4RiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpBRDU1MTJENDdCNTMxMUU3ODg5OEE5MURFQzEwRTM4RiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Po7v9RAAAB/4SURBVHja7N150PV1ed/xm01AQATBFRVBQXxYxMLULtPGadNkph1jO9NmOv7RNFM73RKn2rTT/FO6xaWVLkmc/pF0MulMm9iaTKadWtNMQ4IBN5RNEAVFWQTcUFQQEHu9zpz3Mz8P54bneXhQSJ4zc+Y+5/x+v+/yuT7X8r2+y33Yd7/73Z1DryfvddghgA8BfAjgQ69DAB8C+BDAP6DXI4888qJvfOMbex566KGdb33rWzuHHXbYzlFHHbXzjGc8Y+fII49c3XPsscfeOp8/dQjgfXh94Qtf+Kl77rnn7Pvuu2/nO9/5zs4DDzzwQ3fcccee+++/f+fb3/72zhFHHAH0naOPPnrn+OOP3zn88MMBfPsLX/jC3zr55JNX4M+1u1/0ohf9yz/yAA+Ap379618/ZQB808c+9rHXY+e058x777137z0AA+wxxxwTo1fM9VsMJoiHH3549R3w/g7At/g8wF/50pe+9Oem7PumrNv/SAD81a9+9cdvu+220z73uc+96dZbbz37mc985g4ToC0ABFjgYa7rgP70pz+9AvKss85amQomw++BjN1+9/LZbwTj+dNOO+2eM888853Pf/7z3z333P+HEeAjv/nNb57/oQ996NKbb775z37pS1/aec5znrOypUADMFYCg+rPvSsAX/CCF+yMIHZOOOGEnbvvvnt130te8hJC2nn5y1++c+edd65APfHEE1fPe/uOvb38xpQcd9xxO694xSuuOf300//78573vHeT3/z+wNMe4K997Ws/dsMNN/zd66677i8MIw8bm7kCIVCxzHcgfuYzn9k59dRTVwwc+7vDrgKa2fjiF7+4euakk05aAe+5cYA5up0xNUzDSjgAzcTQCt/11fPPfvazd5773Oc+PObj6mH026eO9z4tAZ7Ov+6mm25600c+8pG//uCDD65ACDiAYi5WcWiuYyYAXMNsKj7CWbERwBgMrAFnBbJngOztd2/lf/nLX16VQRswneCYGvUHdHUTyJiOXxg7/VNPK4CHRX/mfe97328Pq47WEUzCLJ/9BSDGYSKTkM0dp7cCB0hAmM7v3HLLLStwCAboWI3Nr3zlK1dlYPGo/Irpw8i99tfz1eFZbfCb8pVHeO4bcAH9hZe97GX/cMzWrz+lAR4WnTKA/IOrrrrqrQPS8cDLaWEYJgKC/VS3N5a5Po5v55RTTlnZZkLA0Bjt+mc/+9lV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"/>
            </td>
            <td>
                <div class="right t-center t-bold">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    <br/>
                    Độc lập - Tự do - Hạnh phúc
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT NHẬP KHẨU
    </p>
    <p class="code">
        Số: <span data-bind="text : fiSocv"></span>
    </p>
    <p class="content">
        Họ tên chủ hàng (hoặc người đại diện): <span data-bind="text : fiTenCh"></span>
    </p>
    <p class="content">	
        Địa chỉ giao dịch: <span data-bind="text : fiDiachiCh"></span>	
    </p>
    <p class="content">
        Chứng minh nhân dân số: <span data-bind="text : fiCmnd"></span>.Cấp ngày <span data-bind="date : fiNgaycapCmnd"></span> tại <span data-bind="text : fiNoicapCmnd"></span>
    </p>
    <p class="content">	
        Điện thoại:  <span data-bind="text : fiDienthoaiCh"></span> Fax: <span data-bind="text : fiFaxCh"></span>. Email:	<span data-bind="text : fiEmailCh"></span>
    </p>
    <p class="content">
        Có nhập khẩu số động vật sau: 
    </p>
    <table class="tb-content w100p">
        <thead>
            <tr>
                <th rowspan="2">Loại động vật</th>
                <th rowspan="2">Tuổi</th>
                <th colspan="2">Tính biệt</th>
                <th rowspan="2">Số lượng (con)</th>
                <th rowspan="2">Mục đích sử dụng</th>
            </tr>
            <tr>
                <th>Đực</th>
                <th>Cái</th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'lstHanghoa15aTmpl', foreach: lstHanghoa15a }">
        </tbody>
        <script id="lstHanghoa15aTmpl" type="text/html">
            <tr>
                <td data-bind="text : fiTenHh"></td>
                <td data-bind="text : fiTuoi"></td>
                <td data-bind="text : fiTinhbiet"></td>
                <td data-bind="text : fiTinhbiet"></td>
                <td>
                    <span data-bind="text : fiSoluong"></span>
                    <span data-bind="text : fiTenSl"></span>
                </td>
                <td data-bind="text : fiMucdich"></td>
            </tr>
        </script>			
       	<tfoot>
            <tr>
                <td class="t-bold t-center">Tổng số</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tfoot>	
    </table>

    <p class="content pt-10">				
        Tổng số <span data-bind="text : fiTongSl"></span>			
    </p>
    <p class="content">		
        Tổng số (viết bằng chữ): <span data-bind="text : fiNdTongsl"></span>	
    </p>
    <p class="content">
        Tên, địa chỉ tổ chức, cá nhân xuất khẩu: <span data-bind="text : fiDtXk"></span>
    </p>	
    <p class="content">
        Nước xuất khẩu: <span data-bind="text : fiTenqgXk"></span> Nước quá cảnh (nếu có) <span data-bind="text : fiQgQc"></span>	
    </p>
    <p class="content">
        Nơi chuyển đến: <span data-bind="text : fiNoiden"></span>	
    </p>
    <p class="content">
        Các vật dụng khác có liên quan: 	<span data-bind="text : fiVdLq"></span>
    </p>
    <p class="content">
        Hồ sơ giấy tờ có liên quan: 	<span data-bind="text : fiHsLq"></span>
    </p>
    <p class="content">
        Phương tiện vận chuyển:	<span data-bind="text : fiPtVc"></span>
    </p>
    <p class="content t-bold t-center">
        CHỨNG NHẬN KIỂM DỊCH
    </p>
    <p class="content">
        Tôi kiểm dịch viên động vật ký tên dưới đây chứng nhận số động vật nêu trên:
    </p>
    <p class="content">
        1. Có đầy đủ giấy tờ hợp lệ.
    </p>
    <p class="content">
        2. Đã được kiểm tra và không có triệu chứng lâm sàng của bệnh truyền nhiễm khi nhập khẩu.
    </p>
    <p class="content">
        3. Số động vật trên đã được tiêm phòng và có miễn dịch với các bệnh:
    </p>
    <p class="content">
        <span data-bind="text : fiBenhMd"></span>
    </p>
    <p class="content">
        4. Phương tiện vận chuyển, các vật dụng khác có liên quan kèm theo bảo đảm yêu cầu vệ sinh thú y, đã được khử trùng tiêu độc bằng  <span data-bind="text : fiPptdkt"></span> nồng độ <span data-bind="text : fiNongdo"></span>
    </p>
    <table class="tb-content w100p">
        <tr>
            <td class="t-center w50p t-italic">Giấy có giá trị đến: <span data-bind="date : fiGiatriDn"></span></td>
            <td class="t-center w50p t-italic">Cấp tại <span data-bind="text : fiNoiky"></span>, ngày <span data-bind="date : fiNgayky"></span></td>
        </tr>
        <tr>
            <td class="t-center  w50p pb-long">
                <span class="t-bold">Kiểm dịch viên động vật</span><br/>
                (Ký, ghi rõ họ tên)<br/>
                <span data-bind="text : fiKddv"></span>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">THỦ TRƯỞNG CƠ QUAN</span><br/>
                (Ký, đóng dấu, ghi rõ họ tên)<br/>
                <span data-bind="text : fiNguoiky"></span>
            </td>
        </tr>
    </table>
</page>
