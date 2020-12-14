<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="fiCertificateType1">
    <span><spring:message code="mard.17.tbdHoSo17.fiCertificateType"></spring:message></span><span
        class="nsw-require-field">*</span>
</div>
<!-- select option -->
<div class="col-md-12">
    <div class=" form-group" style="padding: 0 30px;">
        <!-- ko foreach: $root.fiCertificateType() -->
        <div class="col-md-4 row">
            <div class="form-group" style="margin-left:60px;">
                <div class="checkbox">
                    <label>
                        <input id="fiCertificateType" type="checkbox" name="fiCertificateType"
                               data-bind="checked: ($root.fiCertificateTypeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxCTSelected}, enable: !isView"/>
                        <span  data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
                    </label>
                </div>
            </div>
        </div>
        <!-- /ko -->
    </div>
</div>
<!-- ko if: ($root.checkCTDisplayGroup(['fiOtherCertificateType']))-->
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.17.TbdThuoc3.fiPurposeOtherCertificateType"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiPurposeOtherCertificateType" class="form-control"
                   placeholder="<spring:message code="mard.17.TbdThuoc3.fiPurposeOtherCertificateType" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo17.fiPurposeOtherCertificateType, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<!-- /ko -->
<!-- ko if: ($root.checkCTDisplayGroup(['NLTY'])) -->
<ul>
    <li style="list-style-type:circle;margin-left: -30px;"><i><b>Bộ hồ sơ nhập khẩu NGUYÊN LIỆU làm thuốc thú y (trừ hồ sơ nhập khẩu nguyên liệu làm thuốc thú y là dung môi, tá dược gồm tài liệu quy định tại điểm a, điểm d, điểm đ khoản này), đầy đủ, hợp lệ bao gồm:</b></i></li>
    <li><i>Đơn đăng ký nhập khẩu nguyên liệu làm thuốc thú y</i></li>
    <li><i>Giấy chứng nhận thực hành tốt sản xuất thuốc (GMP) hoặc giấy chứng nhận hệ thống quản lý chất lượng (ISO) hoặc giấy chứng nhận khác tương đương đối với một số hóa chất thông dụng</i></li>
    <li><i>Giấy chứng nhận lưu hành sản phẩm (CFS, CPP, MA) do cơ quan nhà nước có thẩm quyền của nước xuất khẩu cấp</i></li>
    <li><i>Phiếu phân tích chất lượng sản phẩm (CoA) của nhà sản xuất</i></li>
    <li><i>Bản sao giấy chứng nhận đủ điều kiện nhập khẩu thuốc thú y của cơ sở đề nghị cấp phép nhập khẩu do Cục Thú y cấp đối với cơ sở nhập khẩu nguyên liệu làm thuốc thú y lần đầu nhập khẩu</i></li>
    <li><i> Báo cáo số lượng, mục đích sử dụng nguyên liệu kháng sinh, địa chỉ cơ sở mua nguyên liệu kháng sinh của lô nguyên liệu kháng sinh nhập khẩu lần trước</i></li>
</ul>
<!-- /ko -->
<!-- ko if: ($root.checkCTDisplayGroup(['VXTY'])) -->
<ul>
    <li style="list-style-type:circle;margin-left: -30px;"><i><b>Bộ hồ sơ đầy đủ, hợp lệ cho nhập khẩu VẮC XIN dùng trong thú y bao gồm:</b></i></li>
    <li><i>Đơn đăng ký nhập khẩu vắc xin, vi sinh vật theo mẫu quy định</i></li>
    <li><i>Bản sao chụp giấy chứng nhận đủ điều kiện nhập khẩu thuốc thú y của cơ sở đề nghị cấp phép nhập khẩu do Cục Thú y cấp đối với tổ chức lần đầu nhập khẩu</i></li>
    <li><i>Giấy chứng nhận lưu hành sản phẩm (CFS, CPP, MA) do cơ quan nhà nước có thẩm quyền của nước xuất khẩu cấp</i></li>
    <li><i>Phiếu phân tích chất lượng sản phẩm (CoA) của nhà sản xuất</i></li>
    <li><i>Bản sao giấy chứng nhận đủ điều kiện nhập khẩu thuốc thú y của cơ sở đề nghị cấp phép nhập khẩu do Cục Thú y cấp đối với cơ sở nhập khẩu nguyên liệu làm thuốc thú y lần đầu nhập khẩu</i></li>
    <li><i> Báo cáo số lượng, mục đích sử dụng nguyên liệu kháng sinh, địa chỉ cơ sở mua nguyên liệu kháng sinh của lô nguyên liệu kháng sinh nhập khẩu lần trước</i></li>
</ul>
<!-- /ko -->
<!-- ko if: ($root.checkCTDisplayGroup(['DPTY'])) -->
<ul>
    <li style="list-style-type:circle;margin-left: -30px;"><b>Hồ sơ nhập khẩu mẫu thuốc thú y để kiểm nghiệm, khảo nghiệm, đăng ký lưu hành, gồm:</b></li>
    <li><i>Đơn đăng ký nhập khẩu thuốc thú y theo mẫu quy định </i></li>
    <li><i>Bản sao giấy chứng nhận đăng ký kinh doanh hoặc giấy chứng nhận đăng ký doanh nghiệp hoặc giấy phép đầu tư của tổ chức, cá nhân đề nghị cấp giấy phép nhập khẩu thuốc thú y đối với tổ chức lần đầu nhập khẩu</i></li>
    <li><i>Giấy chứng nhận thực hành tốt sản xuất thuốc (GMP) hoặc giấy chứng nhận hệ thống quản lý chất lượng (ISO) hoặc giấy chứng nhận khác tương đương đối với một số hóa chất thông dụng</i></li>
    <li><i>Phiếu phân tích chất lượng sản phẩm (CoA) của nhà sản xuất</i></li>
    <li><i>Tóm tắt đặc tính của sản phẩm</i></li>
</ul>
<!-- /ko -->
<div id="fiPurpose1">
    <span><spring:message code="mard.17.TbdThuoc3.mucdich"></spring:message></span><span
        class="nsw-require-field">*</span>
</div>
<p class="">

    <div class="col-md-12">
        <div class=" form-group" style="padding: 0 30px;">
            <!-- ko foreach: $root.fiPurposes() -->
            <div class="col-md-4 row">
                <div class="form-group" style="margin-left:60px;">
                    <div class="checkbox optionBox">
                        <label>
                            <input id="fiPurposes" type="checkbox"
                                   data-bind="checked: ($root.fiPurposeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxSelected}, enable: !isView"/>
                            <span  data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
                        </label>
                       <%-- <label>
                            <input type="checkbox" data-bind="attr: { value: fiId }, checked: $root.selectedPurposeNew() == fiId, event:{ change: $root.selectCheckboxNew.bind($root)}, enable: !isView" />
                            <span  data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
                        </label>--%>
                    </div>
                </div>
            </div>
            <!-- /ko -->
        </div>
    </div>


    <!-- ko if: ($root.checkDisplayGroup(['fiPurposeOtherNote']))-->
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.TbdThuoc3.purposeOtherNote"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <input id="fiPurposeOtherNote" class="form-control"
                       placeholder="<spring:message code="mard.17.TbdThuoc3.purposeOtherNote" />"
                       data-bind="value: moduleThongTinChung.tbdHoSo17.fiPurposeOtherNote, enable: !isView" autocomplete="off">
            </div>
        </div>
    </div>
    <!-- /ko -->

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.TbdHoSo17.fiImportGate"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <textarea id="fiImportGate" class="form-control"
                          placeholder="<spring:message code="mard.17.TbdHoSo17.fiImportGate"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo17.fiImportGate, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.tbdHoSo17.fiCertificateNumber"/><span
                    class="nsw-require-field">*</span></label>

            <div class="col-md-9">
                <textarea id="fiSogiaychungnhan" class="form-control"
                          placeholder="<spring:message code="mard.17.tbdHoSo17.fiCertificateNumber"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo17.fiCertificateNumber, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>


    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.tbdHoSo17.fiCertificateSignDate"/><span
                    class="nsw-require-field">*</span></label>

            <div class="col-md-9">
                <input onpaste="return false;"  id="fiCertificateSignDate" class="form-control date-picker"
                       data-date-format="dd/mm/yyyy" size="16"
                       placeholder="<spring:message code="mard.17.tbdHoSo17.fiCertificateSignDate"/>"
                       data-bind="value: moduleThongTinChung.tbdHoSo17.fiCertificateSignDate, dateInput, enable: !isView" autocomplete="off">
            </div>
        </div>
    </div>

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.TbdHoSo17.fiImportTimeFrom"/></label>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-6">
                        <div class="row form-group">
                            <div class="col-md-9">
                                <input onpaste="return false;"  id="fiImportTimeFrom" class="form-control date-picker"
                                       data-date-format="dd/mm/yyyy" size="16"
                                       placeholder="<spring:message code="mard.17.TbdHoSo17.fiImportTimeFrom"/>"
                                       data-bind="value: moduleThongTinChung.tbdHoSo17.fiImportTimeFrom, dateInput, enable: !isView" autocomplete="off">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row form-group">
                            <label class="col-md-3"><spring:message code="mard.17.TbdHoSo17.fiImportTimeTo"/><span
                                    class="nsw-require-field">*</span></label>
                            <div class="col-md-9">
                                <input onpaste="return false;"  id="fiImportTimeTo" class="form-control date-picker"
                                       data-date-format="dd/mm/yyyy" size="16"
                                       placeholder="<spring:message code="mard.17.TbdHoSo17.fiImportTimeTo"/>"
                                       data-bind="value: moduleThongTinChung.tbdHoSo17.fiImportTimeTo, dateInput, enable: !isView" autocomplete="off">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.17.TbdHoSo17.fiSenderNumber"/><span
                    class="nsw-require-field">*</span></label>

            <div class="col-md-9">
                <textarea id="fiSenderNumber" class="form-control"
                          placeholder="<spring:message code="mard.17.TbdHoSo17.fiSenderNumber"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo17.fiSenderNumber, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.17.TbdHoSo17.fiReceiptWritingAddress"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiReceiptWritingAddress" class="form-control"
                          placeholder="<spring:message code="mard.17.TbdHoSo17.fiReceiptWritingAddress"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo17.fiReceiptWritingAddress, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>

</div>


</div>



