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
            <td>Văn bản chấp thuận khai thác tuyến, văn bản thay thế phương tiện hoặc văn bản bổ sung phương tiện của cơ quan quản lý tuyến và hợp đồng đón trả khách tại bến xe ở Việt Nam và Lào
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="GPVTLV" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 1, 'GPVTLV') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GPVTLV, as: 'item' }">
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
            <td>Giấy phép vận tải đường bộ quốc tế Việt - Lào<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="VBCTKTT" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 2, 'VBCTKTT') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VBCTKTT, as: 'item' }">
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
            <td>Hợp đồng thuê phương tiện hoặc hợp đồng hợp tác kinh doanh giữa các đơn vị kinh doanh vận tải hoặc hợp đồng dịch vụ giữa thành viên và hợp tác xã
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="HDTPT" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 3, 'HDTPT') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: HDTPT, as: 'item' }">
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
            <td>Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="GCN_001" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 4, 'GCN_001') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GCN_001, as: 'item' }">
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
            <td>Giấy đăng ký xe ô tô
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="GDK_003" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 5, 'GDK_003') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GDK_003, as: 'item' }">
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
            <td>Giấy tờ khác (nếu có)
            </td>
            <td>
                <div>
                    <input type="file" id="GTK" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 6, 'GTK') }, visible: editMode">
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