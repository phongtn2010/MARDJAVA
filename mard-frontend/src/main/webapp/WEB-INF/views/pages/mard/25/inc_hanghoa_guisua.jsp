<div id="modal_guiSua" class="modal container in modal-overflow"
     tabindex="-1"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-header" style="background: #337ab7; color: #fff;">
        <b class="modal-title"><spring:message code="mard.25.tokhai.hang_hoa"/></b>
    </div>
    <div class="modal-body">
        <div class="panel panel-primary" id="model-congvan">
            <div class="panel-body">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.tokhai.ma_ho_so"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <label data-bind="text: fiNSWFileCode"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.tokhai.hang_hoa.name"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <label data-bind="text : fiProName"></label>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.ket_qua_danh_gia_su_phu_hop"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" data-bind="value: fiLoaiDanhGia">
                            <option value="0"> <spring:message code="mard.25.chon"/></option>
                            <option value="1"> <spring:message code="mard.25.hanghoa.hinh_thuc_danh_gia_ko_phu_hop"/></option>
                            <option value="2"> <spring:message code="mard.25.hanghoa.hinh_thuc_danh_gia_phu_hop"/></option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.to_chuc"/><a  class="nsw-require-field">**</a></label>
                    </div>
                    <div class="col-md-10">
                        <select
                                data-bind="options: lstToChucDanhGia,
                                                    optionsText: 'fiPUName',
                                                    optionsValue: 'fiPUCode',
                                                    selectedText: fiNameTCCD, optionsCaption:'<spring:message code="mard.25.chon"/>',
                                                    value: fiToChucDanhGia" class="form-control"></select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.gcn_hop_quy"/><a  class="nsw-require-field">**</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiSoGCNHopQuy, hasFocus: true"
                               type="text"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.ngay_cap"/><a  class="nsw-require-field">**</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="datepicker: fiNgayCap"
                                class="form-control form-control-inline date-picker"
                                data-date-format="dd/mm/yyyy" type="text" value=""
                                maxlength="10" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.gcn_hop_quy_file"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="file" data-bind="event:{change: fileKQChange},value: fiFileGCN"/>
                    </div>

                </div>
            </div>
        </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-body">
                <form role="form" class="form-horizontal">
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.grid_phieu_kq_pt"/><a  class="nsw-require-field">**</a></label></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.grid_thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstKetQuaPhanTich">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiTenFile"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $parent.removeFile.bind($data, $index())">
                                    <i class="fa fa-lg fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td></td>
                            <td><input id="fiFileKQ" class="form-control" type="file" data-bind="value: fiFileKQ" accept=".pdf, .jpg, .jpeg, .tif, .doc, .png, .zip"/></td>
                            <td class="nsw-text-center">
                                <a href="javascript:void(0)" data-bind="click: addFileKQ">
                                    <i class="fa fa-lg fa-plus-circle"></i>
                                </a>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </form>
            </div>
        </div>

        <div class="text-left">
            <span class="nsw-require-field">(**) </span><span><spring:message code="mard.25.guixncl.item1"/></span><br/>
            <span class="nsw-require-field"><span><spring:message code="mard.25.guixncl.item2"/></span></span>
        </div>
        <div class="text-center">
            <span class="nsw-require-field" style="font-size: large" data-bind="text: errorMsg"></span>
        </div>
    </div>
    <div class="modal-footer" style="">
        <div class="text-center">
            <button class="btn btn-primary" data-bind="click: guiKiemDinhHangHoa"><i class="fa fa-send"></i> <spring:message code="common.button.gui"/></button>
            <button class="btn btn-danger" data-bind="click: thoatOnClick"><i class="fa fa-sign-out"></i><spring:message code="common.button.thoat"/></button>
        </div>
    </div>
</div>