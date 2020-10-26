<div class="col-md-12 panel panel-primary">
    <div class="portlet light">
        <div class="portlet-title">
            <div class="caption font-dark">
                <span class="caption-subject bold uppercase"> <spring:message code="mard.25.ten_thu_tuc"/></span>
            </div>
        </div>
        <div class="portlet-body">
            <div class="table-toolbar">
                <div class="row">
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
                <div class="row">
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
                </div>
                <div class="row">
                    <div class="col-md-12" style="padding-top: 10px;">
                        <div class="text-center">
                            <p><span class="nsw-require-field" data-bind=""></span></p>
                            <button class="btn btn-primary" data-bind=""><i class="fa fa-save"></i> <spring:message code="common.button.luu"/></button>
                            <button class="btn btn-warning" data-bind=""><i class="fa fa-send"></i> <spring:message code="conmon.button.huy"/></button>
                            <button class="btn btn-danger" data-bind="">Thoát</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p>
        <a style="color: red">(**)</a> bắt buộc đối với hình thức kiểm tra 2c<br/>
        - File đính kèm
        - Định dạng: jpg, jpeg, pdf, tif</br>
        - Kích cỡ tối đa: 50MB </br>
    </p>
</div>