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
        <tbody data-bind="foreach: { data: danhSachThuTucFile, as: 'ifile' }">
        <tr>
            <td class="text-center" data-bind="text: $index()+1"></td>
            <td>
                <p data-bind="text : ifile.fiTenDanhmuc"></p>
            </td>
            <td>
                <div>
                    <div>
                        <div data-bind="foreach: { data: $root.getDsByName(ifile.fiMaDanhmuc()), as: 'item' }">
                            <p>
                                <i>
                                    <a data-bind="text: item.fiTenDinhkem,click: $root.download" target="_blank"></a>
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