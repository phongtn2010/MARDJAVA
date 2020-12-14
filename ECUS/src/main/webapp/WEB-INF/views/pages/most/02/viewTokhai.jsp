<fieldset>
    <legend><spring:message code="most.02.hoso.danhsachtokhai" /></legend>
    <a id="btnThemMoiToKhai" class="btn grey" data-toggle="modal" style="display: ${IsView}">
        <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
    </a>
    <table class="table table-striped table-bordered table-hover order-column">
        <thead>
            <th class="nsw-text-center"><spring:message code="common.table.col.stt" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.tokhaihanghoankso" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.ngaydangky" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.mahaiquan" /></th>
            <th class="nsw-text-center"><spring:message code="conmon.button.view" /></th>
        </thead>
        <tbody id="tokhai-container">
            
        </tbody>
    </table>
</fieldset>   
<div id="tokhai-tmpl" style="display: none;">
    <form role="form" class="form-horizontal tokhai-form">
        <p><b class="nsw-text-underline">{{ _lang "most_02_tokhai_thongtintimkiem" }}</b></p>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.02.tokhai.hanghoa_nhapkhau_so" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiSoTk" value="{{fiSoTk}}" name="fiSoTk" require="true" field="most_02_tokhai_hanghoa_nhapkhau_so" class="form-control" placeholder="<spring:message code="most.02.tokhai.hanghoa_nhapkhau_so" />" type="text">
            </div>            
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.02.tokhai.namdangky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input id="fiNamdk" name="fiNamdk" require="true" field="most_02_tokhai_namdangky" class="form-control" placeholder="<spring:message code="most.02.tokhai.namdangky" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.02.tokhai.ma_hai_quan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiMaHq" name="fiMaHq" value="{{fiMaHq}}" require="true" field="
                       " class="form-control" placeholder="<spring:message code="most.02.tokhai.ma_hai_quan" />" type="text">                
            </div>
            <div class="col-md-6">
                <select id="fiDVHQ" class="form-control select2" data="{{fixSelectData fiMaHq}}">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${danhsachdonvihq.data.haiQuan}" var="item">
                        <option value="${item.ma_HQ}">${item.ten_HQ}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12 nsw-text-center">
                <a href="javascript:;" class="btn blue" id="btnToKhaiSearch" style="display: ${IsView}"><i class="fa fa-search" ></i> <spring:message code="common.button.tim_kiem" /></a>
            </div>
        </div>
        <p><b class="nsw-text-underline red">{{ _lang "most_02_tokhai_ketquatimkiem" }}</b></p>
        <hr />    
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_thongtinchung" }}</b></p>
        <div class="panel-body"> 
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_sotokhai"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKSo"></b>
                </div>
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_mahaiquan"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKMaHq"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_ngaydangky"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKNgayDK"></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_hanghoa" }}</b></p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th><b>{{_lang "common_tokhai_hanghoa_stt"}}</b></th>
                    <th class="nsw-text-center"><input id="cbAllProducts" type="checkbox" name="cbAllProducts"/></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_mahs"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_tenhanghoa"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_klsl"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_donvitinh"}}</th>
                </tr>
            </thead>
            <tbody class="tokhai-hanghoa-container">

            </tbody>
        </table>
        <div class="row">                            
            <div class="col col-md-6">
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div id="tokhai-hanghoa-pager"></div>
            </div>
        </div> 
    </form>
</div>