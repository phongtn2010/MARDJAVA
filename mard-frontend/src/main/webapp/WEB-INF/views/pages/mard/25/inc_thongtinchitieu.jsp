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
                                <a href="javascript:void(0)" data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)"
                                >
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
                                <input id="EfiProCLTargTx" class="form-control" data-bind="value: EfiProCLTarg"/>
                            </td>
                            <td>
                                <select class="form-control" data-bind="value: EfiProCLCompare">
                                    <option value=">"> > </option>
                                    <option value="<"> < </option>
                                    <option value="="> = </option>
                                    <option value=">="> >= </option>
                                    <option value="<="> <= </option>
                                    <option value="min-max">min-max</option>
                                </select>
                            </td>
                            <td>
                                <input id="EfiProCLContentTx" class="form-control" data-bind="value: EfiProCLContent"/>
                            </td>
                            <td>
                                <select id="EfiProCLUnitIDCBB"
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.chat_luong.dvt"/>',
                                                    value: EfiProCLUnitID" class="form-control"></select>
                            </td>
                            <td data-bind="visible: $root.isEditable" class="text-center">
                                <a href="" data-bind="click: addThongTinChiTieuChatLuong, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                    <span class="nsw-require-field" data-bind="validationMessage: fiProATList"></span>
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
                        <tbody data-bind="foreach: fiProATList">
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
                                <input id="EfiProATTargTx" class="form-control" data-bind="value: EfiProATTarg"/>
                            </td>
                            <td>
                                <select class="form-control" data-bind="value: EfiProATCompare">
                                    <option value=">"> > </option>
                                    <option value="<"> < </option>
                                    <option value="="> = </option>
                                    <option value=">="> >= </option>
                                    <option value="<="> <= </option>
                                    <option value="min-max">min-max</option>
                                </select>
                            </td>
                            <td>
                                <input id="EfiProATContentTx" class="form-control" data-bind="value: EfiProATContent"/>
                            </td>
                            <td>
                                <select
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.an_toan.dvt"/>',
                                                    value: EfiProATUnitID" class="form-control"></select>
                            </td>
                            <td data-bind="visible: $root.isEditable" class="text-center">
                                <a href="#" data-bind="click: addThongTinChiTieuAT, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                    <span class="nsw-require-field" data-bind="validationMessage: fiProKLList"></span>
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
                        <tbody data-bind="foreach: fiProKLList">
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
                                <input id="EfiProSLKLMass" class="form-control" data-bind="value: EfiProSLKLMass"/>
                            </td>
                            <td>
                                <select
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtkl"/>',
                                                    value: EfiProSLKLMassUnitCode" class="form-control"></select>
                            </td>
                            <td>
                                <input id="EfiProSLKLMassTan" class="form-control" data-bind="value: EfiProSLKLMassTan"/>
                            </td>
                            <td>
                                <input id="EfiProSLKLAmount" class="form-control" data-bind="value: EfiProSLKLAmount"/>
                            </td>
                            <td>
                                <select
                                        data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.25.tokhai.hang_hoa.dinh_luong.dvtsl"/>',
                                                    value: EfiProSLKLAmountUnitCode" class="form-control"></select>
                            </td>
                            <td data-bind="visible: $root.isEditable" class="text-center">
                                <a href="#" data-bind="click: addThongTinChiTieuKL, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>