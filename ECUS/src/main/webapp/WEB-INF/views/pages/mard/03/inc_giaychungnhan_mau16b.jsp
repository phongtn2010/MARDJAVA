<%@ page pageEncoding="UTF-8" %>
<fieldset>
    <page size="A4" class="a4-padding">
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class="t-center">
                        <p><b>CỤC THÚ Y</b></p>
                        <span class="content" style="white-space: nowrap">DEPARTMENT OF ANIMAL HEALTH</span>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b>
                        <br/>
                        THE SOCIALIST REPUBLIC OF VIETNAM <br/>
                        --------------------------
                    </div>
                </td>
            </tr>
            <tr>
                <td class="">
                    <div class="left t-center">
                        <p><b>TÊN CƠ QUAN KIỂM DỊCH ĐỘNG VẬT</b></p>
                        NAME OF ANIMAL HEALTH ORGANIZATION
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b>Mẫu 16b</b> <br/>
                        <i>Form:</i>
                    </div>
                </td>
            </tr>
        </table>
        <p class="title">
            <span style="font-size: medium">Chứng Nhận Kiểm Dịch Sản Phẩm Động Vật Tạm Nhập Tái Xuất, Chuyển Cửa Khẩu, Quá Cảnh Lãnh Thổ Việt Nam</span>
            <br/>
            <span style="font-size: small" class="t-italic">Veterinary certificate for temporatily imported for re-export, transport of point, transit of animal product through Viet Nam</span>
        </p>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-5 nsw-text-right">
                    <span>Số: </span> <br/>
                    <span class="t-italic">Number: </span>
                </div>
                <div class="col-md-4">
                    <span data-bind="text: fiSoGcn" class="t-bold "></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4 nsw-text-left">
                    <span>Tên, địa chỉ người xuất hàng: </span> <br/>
                    <span class="t-italic">Name and address of exporter: </span>
                </div>
                <div class="col-md-8">
                    <span data-bind="text: fiTenNgXh" class="t-bold sizeF"></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-7 nsw-text-left">
                    <span>Tên, địa chủ hàng (hoặc người đại diện): </span> <br/>
                    <span class="t-italic">Name and address of owner of commodity of his representative: </span>
                </div>
                <div class="col-md-5">
                    <span data-bind="text: fiTenChuhang" class="t-bold sizeF"></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-5 nsw-text-left">
                    <span>Tên, địa chỉ người nhận hàng cuối cùng: </span> <br/>
                    <span class="t-italic">Name and address of final consignee: </span>
                </div>
                <div class="col-md-7">
                    <span data-bind="text: fiNguoiNhanhang" class="t-bold sizeF"></span>
                </div>
            </div>
        </div>
        <legend style="color: dodgerblue;">Danh sách sản phẩm động vật :</legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa03">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center">Mã HS</th>
                <th class="text-center">Loại sản phẩm (Type of products)</th>
                <th class="text-center">Quy cách đóng gói (Type of package)</th>
                <th class="text-center">Số kiện hàng (Number of package)</th>
                <th class="text-center">Khối lượng (Net weight)</th>
                <th class="text-center">Phương thức bảo quản</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHanghoaSpdv">
            <tr>
                <td data-bind="text: fiIdHanghoa"></td>
                <td data-bind="text : fiTenhang"></td>
                <td data-bind="text : fiDonggoi"></td>
                <td data-bind="text : fiSoluong" class="text-right"></td>
                <td data-bind="text : fiKhoiluong" class="text-right"></td>
                <td data-bind="text : fiDonggoi"></td>
            </tr>
            </tbody>
        </table>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-left">
                    <span>Cửa khẩu nhập: </span> <br/>
                    <span class="t-italic">Declared point of entry: </span>
                </div>
                <div class="col-md-9">
                    <span data-bind="text: fiTenCkn" class="t-bold "></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Cửa khẩu xuất: </span> <br/>
                    <span class="t-italic">Declared point of exit: </span>
                </div>
                <div class="col-md-9">
                    <span data-bind="text: fiTenCkx" class="t-bold "></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Tờ khai kiểm dịch số: </span> <br/>
                </div>
                <div class="col-md-9">
                    <span data-bind="text: fiSoGcn" class="t-bold"></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Container No: </span> <br/>
                    <span class="t-italic">Container No: </span>
                </div>
                <div class="col-md-9">
                    <span data-bind="text: fiSoContainer" class="t-bold"></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-5 nsw-text-right">
                    <span>Thời gian lưu lại trên lãnh thổ Việt Nam: Từ </span> <br/>
                    <span class="t-italic">The duration transport or storage in Vietnam: From </span>
                </div>
                <div class="col-md-3">
                    <span data-bind="text: fiTgTung" class="t-bold"></span>
                </div>
                <div class="col-md-1 nsw-text-right">
                    <span>Đến: </span> <br/>
                    <span class="t-italic">To: </span>
                </div>
                <div class="col-md-3">
                    <span data-bind="text: fiTgDenng" class="t-bold"></span>
                </div>
            </div>
        </div>
        <p class="title">
            <span class="title" style="font-size: medium">CHỨNG NHẬN KIỂM DỊCH</span><br/>
            <span class="title t-italic" style="font-size: small">HEALTH CERTIFICATE</span>
        </p>
        <p class="borderCus">
            Tôi, bác sỹ thú y ký tên dưới đây chứng nhận:<br/>
            I, the undersigned official Veterinarian certifies that<br/>
            1/ Lô hàng trên đã hoàn thành đầy đủ giấy tờ khi nhập vào Việt Nam;<br/>
            The commodities described above have been completed with all the documents when imported into Vietnam;<br/>
            2/ Sản phẩm động vật được bao gói, bảo quản bảo đảm yêu cầu vệ sinh thú y;<br/>
            The animal product/s packaged and stored in accordance with Vet. sanitary requirement<br/>
            3/ Phương tiện vận chuyển bảo đảm yêu cầu vệ sinh thú y, đã được khử trùng tiêu độc và niêm phong theo quy định.<br/>
            Transport means meet sanitary requirement and have been disinfected and sealed.<br/>
        </p>
        <p class="title">
            <span style="font-size: medium">NHỮNG YÊU CẦU KHI VẬN CHUYỂN TRÊN LÃNH THỔ VIỆT NAM</span>
            <br/>
            <span style="font-size: small" class="t-italic">REQUIREMENTS DURING TRANSPORT IN VIETNAMESE TERRITORY</span>
        </p>
        <span>1/ Chỉ được phép vận chuyển theo lộ trình: </span><br/>
        <span class="t-italic">Allowed itinerary:</span><br/>
        <span data-bind="text: fiLotrinh" class="t-bold sizeF"></span><br/>
        <span>
        2/ Nghiêm cấm vứt chất thải, sản phẩm động vật trong quá trình vận chuyển;<br/>
        Disposal of waste and animal products during the transport is prohibited;<br/>
        3/ Phải thông báo cho cơ quan thú y nơi gần nhất khi phát hiện thấy sản phẩm động vật có biểu hiện hư hỏng;<br/>
        Any sign of animals products decayed shall be reported to the nearest veterinary authority;<br/>
        4/ Thực hiện nghiêm túc các quy định của Pháp luật về thú y khi vận chuyển trên lãnh thổ Việt Nam.<br/>
        Obey the stipulation of veterinary ordinance while in Vietnamese territory.<br/>
    </span>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-left">
                    <span>Giấy có giá trị đến: </span> <br/>
                    <span class="t-italic">Valid up to: </span>
                </div>
                <div class="col-md-2">
                    <span data-bind="date: fiGiatriDenng" class="t-bold "></span>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <span>Giấy này làm tại: </span> <br/>
                    <span class="t-italic">Issued at: </span>
                </div>
                <div class="col-md-2">
                    <span data-bind="text: fiNoiky" class="t-bold "></span>
                </div>
                <div class="col-md-1 nsw-text-right">
                    <span>Ngày: </span> <br/>
                    <span class="t-italic">On: </span>
                </div>
                <div class="col-md-2">
                    <span data-bind="date: fiNgayky" class="t-bold "></span>
                </div>
            </div>
        </div>
        <p class="title">
            <span style="font-size: medium">CHỨNG NHẬN CỦA CƠ QUAN KIỂM DỊCH ĐỘNG VẬT NƠI XUẤT</span>
            <br/>
            <span style="font-size: small" class="t-italic">CERTIFICATION OF ANIMAL QUARANTINE ORGANIZATION AT POINT OF EXIT</span>
        </p>
        <span data-bind="text: noidungCNText" class="t-center t-bold sizeF"></span>
    </page>
</fieldset>

<template id="suaGCN-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="suaGcn-form" id="suaGCN-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label></p>
            </div>
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="common.msg.ly_do"/></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                    <textarea name="fiNoidungYc" id="fiNoidungYc" data-bind="value: fiNoidungYc" require="true"
                              placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;resize: none;"
                              maxlength="2000"></textarea>
                </div>
            </div>
        </form>
    </div>
</template>

<%--form xin huy gcn--%>
<template id="xinhuyGcn-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="xinhuyGcn-form" id="xinhuyGcn-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label></p>
            </div>
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="common.msg.ly_do"/></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                    <textarea name="lydoHuy" id="lydoHuy" data-bind="value: lydoHuy" require="true"
                              placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;resize: none;"
                              maxlength="2000"></textarea>
                </div>
            </div>
        </form>
    </div>
</template>
<%--end form xin huy gcn--%>