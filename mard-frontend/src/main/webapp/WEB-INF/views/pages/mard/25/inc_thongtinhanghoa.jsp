<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with: regAnimalVM">
    <fieldset data-bind="with: productVM">
        <div class="panel panel-primary">
            <div class="panel-heading" style="font-weight: bold;">
                 <span class="btn-group pull-right">
                      <a style="margin-left: 10px" class="btn green" title=""
                         data-bind="visible: $root.isEditable()"
                         data-target="#modal_addAnimal"
                         data-toggle="modal"><i class="fa fa-plus"></i>
                    </a>
<%--                    <a href="#" class="btn btn-default btn-sm">Thêm mới hàng hóa</a>--%>
                </span>
                <h5><b><spring:message code="mard.25.tokhai.hang_hoa"/></b></h5>
            </div>
            <div class="panel-body">
                <form role="form" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-12">
                            <span class="nsw-require-field" data-bind="validationMessage: fiProductList"></span>
                            <table class="table table-striped table-bordered table-hover order-column">
                                <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th style="width: 3%" class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_ten"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_soluong"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_khoiluong"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_thanhphan"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_nhomtacn"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_macongnhan"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_hangsanxuat"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_nuocsanxuat"/></th>
                                    <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_giatri"/></th>
                                    <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                        <spring:message code="mard.25.tokhai.hang_hoa_grid_thaotac"/></th>
                                </tr>
                                </thead>
                                <tbody data-bind="foreach: fiProductList">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td data-bind="text : fiProName"></td>
                                    <td class="text-right" data-bind="text : fiProductScienceName"></td>
                                    <td class="text-right" data-bind="text : fiSizeOrType"></td>
                                    <td data-bind="text : fiProThanhPhan"></td>
                                    <td data-bind="text : fiProIdNhom"></td>
                                    <td data-bind="text : fiProCode"></td>
                                    <td data-bind="text : fiProMadeIn"></td>
                                    <td data-bind="text : fiProCountryName"></td>
                                    <td data-bind="text : fiProValueVN"></td>
                                    <td class="text-center" data-bind="visible: $root.isEditable()">
                                        <a href="javascript:void(0)"
                                           data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                            <i class="fa fa-lg fa-eye"></i>
                                        </a>&nbsp;&nbsp;
                                        <a href="javascript:void(0)"
                                           data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                            <i class="fa fa-lg fa-edit"></i>
                                        </a>&nbsp;&nbsp;
                                        <a href="javascript:void(0)" data-bind="click: $parent.removeProduct.bind($data, $index())">
                                            <i class="fa fa-lg fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </fieldset>
    <!-- modal -->
    <div id="modal_addAnimal" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header" style="background: #337ab7; color: #fff;">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.25.tokhai.hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.congvan.title"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.congvan.so"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProCVMienGiam" class="form-control" value=""/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.congvan.ngay"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProCVMienGiamNgay" class="form-control" value=""/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.title"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.name"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProName" class="form-control" value=""/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.nhom"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.nhom"/>',
                                                    value: fiProIdNhom" class="form-control"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.phan_nhom"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.phan_nhom"/>',
                                                    value: fiProIdPhanNhom" class="form-control"></select>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.loai"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.loai"/>',
                                                    value: fiProIdLoai" class="form-control"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.phan_loai"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.phan_loai"/>',
                                                    value: fiProIdPhanLoai" class="form-control"></select>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.ma_so_cong_nhan"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProCode" class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.hang_san_xuat"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProMadeIn" class="form-control" value=""/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.nuoc_san_xuat"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.nuoc_san_xuat"/>',
                                                    value: fiProCountryCode" class="form-control"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.thanh_phan"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProThanhPhan" class="form-control" value=""/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.mau"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProColor" class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.so_hieu"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProSoHieu" class="form-control" value=""/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.quy_chuan"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control" data-bind="value: fiProQuyChuan">
                                    <option value="1">
                                        <spring:message code="mard.25.tokhai.hang_hoa.quy_chuan_item01"/>
                                    </option>
                                    <option value="2">
                                        <spring:message code="mard.25.tokhai.hang_hoa.quy_chuan_item02"/>
                                    </option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12">
                                <span class="nsw-require-field" data-bind="validationMessage: fiProCLList"></span>
                                <table class="table table-striped table-bordered table-hover order-column">
                                    <thead>
                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                        <th style="width: 3%" class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong.stt"/></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong.name"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong.hinhthuc"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong.hamluong"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.chat_luong.dvt"/><a class="nsw-require-field">(*)</a></th>
                                        <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                            <spring:message code="mard.25.tokhai.hang_hoa.chat_luong.capnhat"/></th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiProCLList">
                                    <tr>
                                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                        <td data-bind="text : fiProCLTarg"></td>
                                        <td class="text-left" data-bind="text : fiProCLCompare"></td>
                                        <td class="text-center" data-bind="text : fiProCLContent"></td>
                                        <td data-bind="text : fiProCLUnitName"></td>
                                        <td class="text-center" data-bind="visible: $root.isEditable()">
                                            <a href="javascript:void(0)"
                                               data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                                <i class="fa fa-lg fa-edit"></i>
                                            </a>&nbsp;&nbsp;
                                            <a href="javascript:void(0)" data-bind="click: $parent.removeProduct.bind($data, $index())">
                                                <i class="fa fa-lg fa-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                    <td></td>
                                    <td>
                                        <input class="form-control" data-bind="value: fiProCLTarg"/>
                                    </td>
                                    <td>
                                        <select class="form-control" data-bind="value: fiProCLCompare">
                                            <option value=">"> > </option>
                                            <option value="<"> < </option>
                                            <option value="="> = </option>
                                            <option value=">="> >= </option>
                                            <option value="<="> <= </option>
                                            <option value="min-max">min-max</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input class="form-control" data-bind="value: fiProCLContent"/>
                                    </td>
                                    <td>
                                        <select
                                                data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.chat_luong.dvt"/>',
                                                    value: fiProCLUnitID" class="form-control"></select>
                                    </td>
                                    <td data-bind="visible: $root.isEditable" class="text-center">
                                        <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                                    </td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.an_toan"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12">
                                <span class="nsw-require-field" data-bind="validationMessage: fiProCLList"></span>
                                <table class="table table-striped table-bordered table-hover order-column">
                                    <thead>
                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                        <th style="width: 3%" class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.an_toan.stt"/></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.an_toan.name"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.an_toan.hinhthuc"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.an_toan.hamluong"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.an_toan.dvt"/><a class="nsw-require-field">(*)</a></th>
                                        <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                            <spring:message code="mard.25.tokhai.hang_hoa.an_toan.capnhat"/></th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiProCLList">
                                    <tr>
                                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                        <td data-bind="text : fiProATTarg"></td>
                                        <td class="text-left" data-bind="text : fiProATCompare"></td>
                                        <td class="text-center" data-bind="text : fiProATContent"></td>
                                        <td data-bind="text : fiProATUnitName"></td>
                                        <td class="text-center" data-bind="visible: $root.isEditable()">
                                            <a href="javascript:void(0)"
                                               data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                                <i class="fa fa-lg fa-edit"></i>
                                            </a>&nbsp;&nbsp;
                                            <a href="javascript:void(0)" data-bind="click: $parent.removeProduct.bind($data, $index())">
                                                <i class="fa fa-lg fa-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input class="form-control" data-bind="value: fiProATTarg"/>
                                        </td>
                                        <td>
                                            <select class="form-control" data-bind="value: fiProATCompare">
                                                <option value=">"> > </option>
                                                <option value="<"> < </option>
                                                <option value="="> = </option>
                                                <option value=">="> >= </option>
                                                <option value="<="> <= </option>
                                                <option value="min-max">min-max</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input class="form-control" data-bind="value: fiProATContent"/>
                                        </td>
                                        <td>
                                            <select
                                                    data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.an_toan.dvt"/>',
                                                    value: fiProCLUnitID" class="form-control"></select>
                                        </td>
                                        <td data-bind="visible: $root.isEditable" class="text-center">
                                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12">
                                <span class="nsw-require-field" data-bind="validationMessage: fiProCLList"></span>
                                <table class="table table-striped table-bordered table-hover order-column">
                                    <thead>
                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                        <th style="width: 3%" class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.stt"/></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.khoiluong"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtkl"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.khoiluongtan"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.soluong"/><a class="nsw-require-field">(*)</a></th>
                                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtsl"/><a class="nsw-require-field">(*)</a></th>
                                        <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                            <spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.capnhat"/></th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiProCLList">
                                    <tr>
                                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                        <td data-bind="text : fiProSLKLMass"></td>
                                        <td class="text-left" data-bind="text : fiProSLKLMassUnitName"></td>
                                        <td class="text-center" data-bind="text : fiProSLKLMassTan"></td>
                                        <td class="text-center" data-bind="text : fiProSLKLAmount"></td>
                                        <td class="text-center" data-bind="text : fiProSLKLAmountUnitName"></td>
                                        <td class="text-center" data-bind="visible: $root.isEditable()">
                                            <a href="javascript:void(0)"
                                               data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                                <i class="fa fa-lg fa-edit"></i>
                                            </a>&nbsp;&nbsp;
                                            <a href="javascript:void(0)" data-bind="click: $parent.removeProduct.bind($data, $index())">
                                                <i class="fa fa-lg fa-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input class="form-control" data-bind="value: fiProSLKLMass"/>
                                        </td>
                                        <td>
                                            <select
                                                    data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtkl"/>',
                                                    value: fiProSLKLMassUnitCode" class="form-control"></select>
                                        </td>
                                        <td>
                                            <input class="form-control" data-bind="value: fiProSLKLMassTan"/>
                                        </td>
                                        <td>
                                            <input class="form-control" data-bind="value: fiProSLKLAmount"/>
                                        </td>
                                        <td>
                                            <select
                                                    data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtsl"/>',
                                                    value: fiProSLKLAmountUnitCode" class="form-control"></select>
                                        </td>
                                        <td data-bind="visible: $root.isEditable" class="text-center">
                                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.hang_hoa.gia_tri"/></div>
                <div class="panel-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.gia_tri.name"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="trimedValue: fiProValueVN" class="form-control" value=""/><br>
                                <input data-bind="trimedValue: fiProValueUSD" class="form-control" value=""/> <spring:message code="mard.25.tokhai.hang_hoa.gia_tri.usd"/>
                            </div>
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tokhai.hang_hoa.gia_tri.dvt"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.gia_tri.dvt"/>',
                                                    value: fiPackageUnitCode" class="form-control"></select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addProduct"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</div>