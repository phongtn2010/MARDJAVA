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
            <td>Phương án kinh doanh vận tải đường bộ quốc tế Việt – Lào<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <div>
                        <div data-bind="foreach: { data: NSW_VL_PAKD, as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                 
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>
          
        </tr>
        <tr>
            <td class="text-center">2</td>
            <td>Giấy phép kinh doanh vận tải bằng xe ô tô hoặc Giấy chứng nhận đăng ký kinh doanh có đăng ký kinh doanh
                ngành nghề vận tải bằng xe ô tô<span class="nsw-require-field">*</span>
            </td>
            <td>
                <div>
                    <div>
                        <div data-bind="foreach: { data: NSW_VL_GPKDVT_DKKD, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>
                                    
                                </i>
                            </p>
                        </div>
                    </div>
                </div>
            </td>

        </tr>
        <tr>
            <td class="text-center">3</td>
            <td>Giấy tờ khác (nếu có)
            </td>
            <td>
                <div>
                    <input type="file" id="GTK" class="form-group form-control input-file-margin"
                           multiple="multiple"
                           data-bind=" visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: GTK, as: 'item' }">
                            <p>
                                <i> <a data-bind="text: item.fiTenDinhkem,click: $root.download.bind(item)"
                                       target="_blank"></a>

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