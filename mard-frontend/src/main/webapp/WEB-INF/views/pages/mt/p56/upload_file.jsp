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
        <tbody data-bind="foreach: { data: danhSachThuTucFile, as: 'ifile' }">
        <tr>
            <td class="text-center" data-bind="text: $index()+1"></td>
            <td>
                <!--ko text: ifile.fiTenDanhmuc--><!--/ko-->
                <span style="color : red;" data-bind="if : ifile.fiMaDanhmuc() != 'GTK'">*</span>

            </td>
            <td>
                <div>
                    <input type="file"  class="form-group form-control input-file-margin" multiple="multiple"
                           data-bind="attr: { id: ifile.fiMaDanhmuc }, event:{ change: $root.uploadFileChangeEvent }, visible: editMode">
                    <div>
                        <div data-bind="foreach: { data: $root.getDsByName(ifile.fiMaDanhmuc()), as: 'item' }">
                            <p>
                                <%----%>
                                <i> <a data-bind="text: item.fiTenChungTu,click: $root.download"
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
                    <span data-bind="if: ($root.getDsByName(ifile.fiMaDanhmuc()).length > 0)">
                        <a
                                data-bind="click: $root.downloadAll.bind($data, ifile.fiMaDanhmuc()), visible: editMode"
                                class="btn bt-center"> <i
                                class="fa fa-2x fa-download" aria-hidden="true"></i>&nbsp;
						</a>
                        <a
                                data-bind="click: $root.xoaTepTin.bind($data, ifile.fiMaDanhmuc()), visible: editMode"
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