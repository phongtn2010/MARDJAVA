<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b>Phần III: Thông tin giấy phép</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên cơ quan cấp</label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="readonly" data-bind="value : fiCoQuanCap" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số giấy phép</label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" readonly="readonly" data-bind="value : fiSoCongVan" />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày ký</label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="readonly" data-bind="value : fiNgayKyText" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Người ký</label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" readonly="readonly" data-bind="value : fiNguoiKy" />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày hết hiệu lực của công văn cấp phép</label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="readonly" data-bind="value : fiNgayHetHlText" />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2"></div>
            <div class="col-md-6">
                <table style="border: 0">                
                    <tbody data-bind="template: { name: 'resultAttachTmpl', foreach: lstDinhKems }">
                    </tbody>
                    <script id="resultAttachTmpl" type="text/html">
                        <tr>
                            <td>
                                <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                            </td>
                            <td class="text-center">
                                <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: downloadUrl}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                            </td>  
                        </tr>                      
                    </script>
                </table>
            </div>                            
        </div>
    </div>    
</fieldset>