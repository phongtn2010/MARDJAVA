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
            <td>Giấy phép vận tải đường bộ quốc tế Việt Nam - Campuchia hết hạn (nộp lại)<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <%----%>
                    <input type="file" id="GPKDVTHH" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 0, 'GPKDVTHH') }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GPKDVTHH, as: 'item' }">
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
            <td class="text-center">2</td>
            <td>Giấy tờ khác (nếu có)
            </td>
            <td>
                <div>
                    <input type="file" id="GTK" class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 7, 'GTK') }, visible: editMode">
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