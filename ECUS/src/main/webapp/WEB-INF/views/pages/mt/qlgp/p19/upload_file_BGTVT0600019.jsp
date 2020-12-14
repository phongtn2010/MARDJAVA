<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="table-responsive">
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center">STT</th>
            <th class="text-center">Tên tệp đính kèm</th>
            <th class="text-center">Xem</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="text-center">1</td>
            <td>Báo cáo tài chính của doanh nghiệp, hợp tác xã trong 3 năm liên tiếp gần nhất (được cơ quan tài chính địa phương hoặc đơn vị kiểm toán xác nhận)
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="VC_03" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VC_03, as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>
                                                    </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">2</td>
            <td>Phương án kinh doanh vận tải đường bộ quốc tế Việt – Cam<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="VC_02" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 2, 'VC_02') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VC_02, as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">3</td>
            <td>Hợp đồng lao động của người điều hành với doanh nghiệp, hợp tác xã
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="VC_04" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 3, 'VC_04') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VC_04, as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">4</td>
            <td>Giấy phép kinh doanh vận tải bằng xe ô tô hoặc Giấy chứng nhận đăng ký kinh doanh có đăng ký kinh doanh
                ngành nghề vận tải bằng xe ô tô<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="CNDKDN" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: CNDKDN, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">5</td>
            <td>Bản đăng ký chất lượng dịch vụ vận tải
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="DKCLVT" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: DKCLVT, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">6</td>
            <td>Văn bằng, chứng chỉ của người trực tiếp điều hành vận tải<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="VBCC" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind=" visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VBCC, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="text-center">7</td>
            <td>Giấy tờ khác (nếu có)
            </td>
            <td>
                <div>
                    <input type="file" id="GTK" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind=" visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GTK, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)" target="_blank"></a>

                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>