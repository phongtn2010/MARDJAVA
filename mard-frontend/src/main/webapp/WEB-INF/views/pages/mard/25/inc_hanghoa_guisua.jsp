<div id="modal_guiSua" class="modal container in modal-overflow"
     tabindex="-1"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-header" style="background: #337ab7; color: #fff;">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true" data-bind="click: thoatOnClick"></button>
        <b class="modal-title"><spring:message code="mard.25.tokhai.hang_hoa"/></b>
    </div>
    <div class="modal-body">
        <div class="panel panel-primary" id="model-congvan">
            <div class="form-group">
                <div class="row margin-top-15 margin-bottom-15">
                    <div class="col-md-2">
                        <label><spring:message code="mard.tokhai.ma_ho_so"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSCode, hasFocus: true"
                               type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.tokhai.hang_hoa.name"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.ket_qua_danh_gia_su_phu_hop"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.to_chuc"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.gcn_hop_quy"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.ngay_cap"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message code="mard.25.hanghoa.gcn_hop_quy_file"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSStatus, hasFocus: true"
                               type="text"/>
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
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.grid_phieu_kq_pt"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.grid_thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>

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
    <div class="modal-footer" style="">
        <div class="text-center">
            <button class="btn btn-primary" data-bind=""><i class="fa fa-save"></i> <spring:message code="common.button.luu"/></button>
            <button class="btn btn-warning" data-bind=""><i class="fa fa-send"></i> <spring:message code="common.button.gui"/></button>
            <button class="btn btn-danger" data-bind=""><i class="fa fa-sign-out"></i><spring:message code="common.button.thoat"/></button>
        </div>
    </div>
</div>