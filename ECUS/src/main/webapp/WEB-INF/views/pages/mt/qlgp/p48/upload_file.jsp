<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="table-responsive">
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center"><spring:message code="sbv.01.form.38"></spring:message></th>
            <th class="text-center"><spring:message code="sbv.01.form.46"></spring:message></th>
            <th class="text-center"><spring:message code="sbv.01.form.47"></spring:message></th>
            <th class="text-center" width="150px"><spring:message code="sbv.01.form.42"></spring:message></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="text-center">1</td>
            <td>Văn bản chấp thuận khai thác tuyến, văn bản thay thế phương tiện hoặc văn bản bổ sung phương tiện của cơ
                quan quản lý tuyến và hợp đồng đón trả khách tại bến xe ở Việt Nam và Lào
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
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.GPVTLV().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '1'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '1'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
            </td>
        </tr>
        <tr>
            <td class="text-center">2</td>
            <td>Giấy phép vận tải đường bộ quốc tế Việt - Lào<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <input type="file" id="VBCTKTT" class="form-group form-control input-file-margin"
                           multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 2, 'VBCTKTT') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: VBCTKTT, as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.VBCTKTT().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '2'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '2'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
            </td>
        </tr>
        <tr>
            <td class="text-center">3</td>
            <td>Hợp đồng thuê phương tiện hoặc hợp đồng hợp tác kinh doanh giữa các đơn vị kinh doanh vận tải hoặc hợp
                đồng dịch vụ giữa thành viên và hợp tác xã
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
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.HDTPT().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '3'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '3'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
            </td>
        </tr>
        <tr>
            <td class="text-center">4</td>
            <td>Giấy chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="GCN_001" class="form-group form-control input-file-margin"
                           multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 4, 'GCN_001') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GCN_001, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.GCN_001().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '4'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '4'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
            </td>
        </tr>
        <tr>
            <td class="text-center">5</td>
            <td>Giấy đăng ký phương tiện
                <span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="DKPT" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 5, 'DKPT') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: DKPT, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.DKPT().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '5'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '5'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
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
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaMotFile, visible: editMode"
                                       title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'>
                                        <i class="fa fa-lg fa-remove tooltips"></i>
                                    </a>
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
            <td class="text-center">
                <p>
                    <span data-bind="if: ($root.GTK().length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, '6'), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, '6'), visible: editMode"
                                title="<spring:message code="sbv.01.form.tiente.button.xoa" />"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
                </p>
            </td>
        </tr>
        </tbody>
    </table>
    <p style="color: red;"><b>Lưu ý : </b> </br>
        - Tệp đính kèm có dung lượng nhỏ hơn 1MB và có định dạng JPG, PDF, TIF </br>
        - Tổng dung lượng các file đính kèm nhỏ hơn 5MB </br>
    </p>
</div>