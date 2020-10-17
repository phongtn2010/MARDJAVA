<fieldset>
    <legend><spring:message code="most.02.hoso.danhsachhanghoa" /></legend>
    <a id="btnThemMoiHangHoa" class="btn grey" data-toggle="modal" style="display: ${IsView}">
        <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
    </a>
    <table class="table table-striped table-bordered table-hover order-column">
        <thead>
            <th class="nsw-text-center"><spring:message code="common.table.col.stt" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.tenhanghoa" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.hoso.hanghoa.loaidoituong" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.hanghoa.sotokhai" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.hanghoa.mahoso" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.nhan_hieu" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.kieuloai" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.dactinhkythuat" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.xuatxu" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.nhasanxuat" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.soluong_khoiluong" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.donvitinh" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.cuanhapkhau" /></th>
            <th class="nsw-text-center"><spring:message code="most.02.table.col.thoigiannhapkhau" /></th>     
        </thead>
        <tbody id="hanghoa-container">
            
        </tbody>
    </table>
        <div class="row">                            
            <div class="col col-md-6">

            </div>
            <div class="col col-md-6 nsw-text-right">
                <div id="hanghoa-pager"></div>
            </div>
        </div>
    <div class="col-md-2">
    <spring:message code="most.02.hoso.diadiemluugiu" /><a class="nsw-require-field">*</a> 
    </div>
    <div class="col-md-10">
     ${hosoData.fiDiachiKho}
    </div>
</fieldset>    
     <div id="hanghoa-tmpl" style="display: none;">
         <form role="form" class="form-horizontal hanghoa-form">
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.tenhanghoa" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiTenHh" name="fiTenHh"  value="{{fiTenHh}}" require="true" maxlength="255" field="most_01_hanghoa_tenhanghoa" class="form-control" placeholder="<spring:message code="most.01.hanghoa.tenhanghoa" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.nhanhieu" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiNhanHh" name="fiNhanHh" value="{{fiNhanHh}}" maxlength="255" require="true" field="most_01_hanghoa_nhanhieu" class="form-control" placeholder="<spring:message code="most.01.hanghoa.nhanhieu" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.kyhieu_kieuloai" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiKyhieu" name="fiKyhieu" value="{{fiKyhieu}}" maxlength="255" require="true" field="most_01_hanghoa_kyhieu_kieuloai" class="form-control" placeholder="<spring:message code="most.01.hanghoa.kyhieu_kieuloai" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.thongsokythuat" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiThongsoKt" name="fiThongsoKt" value="{{fiThongsoKt}}" maxlength="255" require="true" field="most_01_hanghoa_thongsokythuat" class="form-control" placeholder="<spring:message code="most.01.hanghoa.thongsokythuat" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.nuocxuatxu" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <select id="fiMaQg" name="fiMaQg" require="true" field="most_01_hanghoa_nuocxuatxu" class="form-control select2" data="{{fixSelectData fiMaQg}}">
                         <option value="-1"><spring:message code="common.chon" /></option>
                         <c:forEach items="${quocgia.data}" var="item">
                             <option value="${item.statecode}">${item.name}</option>
                         </c:forEach>
                     </select>
                     <input type="hidden" name="fiTenQg" id="fiTenQg" value="{{fiTenQg}}" field="<spring:message code="most.01.hanghoa.nuocxuatxu" />"/>
                 </div>
             </div> 
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.nhasanxuat" /></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiTenNsx" name="fiTenNsx" value="{{fiTenNsx}}" maxlength="255" class="form-control" placeholder="<spring:message code="most.01.hanghoa.nhasanxuat" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.soluong_khoiluong" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiKlSl" name="fiKlSl" value="{{fiKlSl}}" maxlength="17" is="float" nguyen="12" thapphan="3" require="true" field="most_01_hanghoa_soluong_khoiluong" class="form-control" placeholder="<spring:message code="most.01.hanghoa.soluong_khoiluong" />" type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.01.hanghoa.donvitinh" /></label><a class="nsw-require-field">*</a>
                 </div>
                 <div class="col-md-7">
                     <select id="fiMaDv" name="fiMaDv" require="true" field="most_01_hanghoa_donvitinh" class="form-control select2" data="{{fixSelectData fiMaDv}}">
                        <option value="-1"><spring:message code="common.chon" /></option>
                        <option value="1">kilogram</option>
                         <c:forEach items="${dvt.data}" var="item">
                             <option value="${item.unitcode}">${item.name}</option>
                             <c:forEach items="${dvt.data}" var="item">
                            <option value="${item.unitcode}">${item.name}</option>
                        </c:forEach>
                         </c:forEach>
                     </select>
                     <input type="hidden" name="fiTenDv" id="fiTenDv" value="{{fiTenDv}}" field="<spring:message code="most.01.hanghoa.donvitinh" />"/>
                 </div>
             </div> 
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.cuakhau_nhapkhau" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <select id="fiMaCuakhau" name="fiMaCuakhau" class="form-control select2" data="{{fixSelectData fiMaCuakhau}}" field="<spring:message code="most.01.hanghoa.doituong_mienkiem" />">
                             <option value="-1"><spring:message code="common.chon" /></option>
                            <option value="1">Tân Thanh</option>

                     </select>
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.ngaynk_tungay" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-2">
                     <input name="fiNkTu" id="fiNkTu" class="form-control form-control-inline date-picker" 
                            data-date-format="dd/mm/yyyy"  type="text" value="" field="most_02_hanghoa_ngaybatdaunk" />
                 </div>
                 <div class="col-md-2">
                     <label><spring:message code="most.02.hanghoa.ngaynk_denngay" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-2">
                     <input name="fiNkDen" id="fiNkDen" class="form-control form-control-inline date-picker" 
                            data-date-format="dd/mm/yyyy"  type="text" value="" field="most_02_hanghoa_ngayketthucnk"/>
                 </div>
             </div>
             
         </form>
     </div>