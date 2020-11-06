<div id="modal_view" class="modal container in modal-overflow"
     tabindex="-1"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-header" style="background: #337ab7; color: #fff;">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <b class="modal-title"><spring:message code="mard.25.tokhai.hang_hoa"/></b>
    </div>
    <div class="modal-body">
        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-2">
                            <label><spring:message code="mard.tokhai.ma_ho_so"/><a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <label data-bind="text: fiNSWFileCode"></label>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message code="mard.25.tokhai.hang_hoa.name"/>
                        </div>
                        <div class="col-md-4">
                            <label data-bind="text : fiProName"></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label><spring:message code="mard.25.hanghoa.to_chuc"/>
                        </div>
                        <div class="col-md-4">
                            <select
                                    data-bind="options: lstToChucDanhGia,,
                                                    optionsText: 'fiPUName',
                                                    optionsValue: 'fiPUCode',
                                                    value: fiMaCqkt" class="form-control" disabled></select>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message code="mard.25.hanghoa.ket_qua_danh_gia_su_phu_hop"/>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control" data-bind="value: fiLoaiDanhGia" disabled>
                                <option value="1"><spring:message
                                        code="mard.25.hanghoa.hinh_thuc_danh_gia_ko_phu_hop"/></option>
                                <option value="2"><spring:message
                                        code="mard.25.hanghoa.hinh_thuc_danh_gia_phu_hop"/></option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.hanghoa.gcn_hop_quy"/></th>
                        <th class="text-center"><spring:message code="mard.25.hanghoa.ngay_cap"/></th>
                        <th class="text-center"><spring:message code="mard.25.hanghoa.file_dinh_kem_gcn_hop_quy"/></th>
                        <th class="text-center"><spring:message code="mard.25.hanghoa.tai_file"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstFileGCN">
                    <tr>
                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                        <td data-bind="text : fiSoGcn"></td>
                        <td data-bind="date : fiNgaycap"></td>
                        <td data-bind="text : fiNameFileGcn"></td>
                        <td class="text-center">
                            <a href="javascript:void(0)" data-bind="click: $parent.downloadFile.bind($data, $data, $index())">
                                <i class="fa fa-lg fa-download"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <form role="form" class="form-horizontal">
                            <table class="table table-striped table-bordered table-hover order-column">
                                <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                                    <th class="text-center"> <spring:message code="mard.25.hanghoa.file_dinh_kem_kqpt"/></th>
                                    <th class="text-center"> <spring:message code="mard.25.hanghoa.tai_file"/></th>
                                </tr>
                                </thead>
                                <tbody data-bind="foreach: lstFilePT">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td data-bind="text : fiFileName"></td>
                                    <td class="text-center">
                                        <a href="javascript:void(0)" data-bind="click: $parent.downloadFile.bind($data, $data, $index())">
                                            <i class="fa fa-lg fa-download"></i>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
        <div class="text-center">
            <span class="nsw-require-field" data-bind="text: errorMsg"></span>
        </div>
    </div>
</div>