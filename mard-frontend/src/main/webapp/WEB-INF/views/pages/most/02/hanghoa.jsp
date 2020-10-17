<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
            <th class="nsw-text-center"><spring:message code="common.table.col.sua" /></th>
            <th class="nsw-text-center"><spring:message code="common.table.col.xoa" /></th>            
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
    <spring:message code="most.02.hoso.diadiemluugiu" />
    </div>
    <div class="col-md-10">
        <input class="form-control form-control-inline" id="fiDiachiKho" name="fiDiachiKho" value="${hosoData.fiDiachiKho}" maxlength="250"
           placeholder='<spring:message code="most.02.hoso.diadiemluugiu" />' type="text" field='most_02_diachikho' />
    </div>
</fieldset>    
     <div id="hanghoa-tmpl" style="display: none;">
         <form role="form" class="form-horizontal hanghoa-form">
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hoso.hanghoa.loaidoituong" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                    <select id="fiMaLoaiHh" name="fiMaLoaiHh" require="true" field="most_02_hanghoa_loaidoituong" class="form-control select2" data="{{fixSelectData fiMaLoaiHh}}">
                        <option value="-1"><spring:message code="common.chon" /></option>
                        <option value="1"><spring:message code="most.02.hoso.hanghoa.loaidoituong.pt_do" /></option>
                        <option value="2"><spring:message code="most.02.hoso.hanghoa.loaidoituong.hangdonggoi" /></option>
                    </select>
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.tenhanghoa" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                    <input id="fiTenHh1" name="fiTenHh1" require="true"  value="{{fiTenHh}}" maxlength="255" field="most_01_hanghoa_tenhanghoa" class="form-control donggoi" placeholder="<spring:message code="most.02.hanghoa.tenhanghoa" />" type="text">
                    <div class="ptdo">
                        <select id="fiTenHh2" name="fiTenHh2" field="most_01_hanghoa_donvitinh" class="form-control select2 ptdo" data="{{fixSelectData fiTenHh}}">
                            <option value="-1"><spring:message code="common.chon" /></option>
                             <c:forEach items="${mauptLst.data}" var="mauPT">
                                 <option value="${fn:trim(mauPT.fiTen)}">${mauPT.fiTen}</option>
                             </c:forEach>
                        </select>
                    </div>
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.sotokhai" /></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiSoTk" name="fiSoTk" value="{{fiSoTk}}" maxlength="255" field="most_02_hanghoa_sotokhai" class="form-control" placeholder="" readonly type="text">
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.mahoso" /></label>
                 </div>
                 <div class="col-md-7">
                     <input id="fiMaHs" name="fiMaHs" value="{{fiMaHs}}" maxlength="12" field="most_02_hanghoa_mahoso" class="form-control" placeholder="<spring:message code="most.02.hanghoa.mahoso" />" type="text">
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
                         <c:forEach items="${dvt.data}" var="item">
                             <option value="${item.unitcode}">${item.name}</option>
                         </c:forEach>
                     </select>
                     <input type="hidden" name="fiTenDv" id="fiTenDv" value="{{fiTenDv}}" />
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
                             <option value="${item.statecode}">${item.namevi}</option>
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
                     <label><spring:message code="most.02.hanghoa.cuakhau_nhapkhau" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-7">
                     <select id="fiMaCuakhau" name="fiMaCuakhau" class="form-control select2" data="{{fixSelectData fiMaCuakhau}}" field="<spring:message code="most.01.hanghoa.doituong_mienkiem" />">
                            <option value="-1"><spring:message code="common.chon" /></option>
                            <c:forEach items="${cuakhau.data}" var="port">
                                <option value="${port.gateCode}">${port.gateName}</option>
                            </c:forEach>
                     </select>
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-5">
                     <label><spring:message code="most.02.hanghoa.ngaynk_tungay" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-2">
                     <input name="fiNkTu" id="fiNkTu" class="form-control form-control-inline date-picker" value="{{convertToDateFromTimeStamp fiNkTu false}}"
                            data-date-format="dd/mm/yyyy"  type="text" value="" field="most_02_hanghoa_ngaybatdaunk" />
                 </div>
                 <div class="col-md-2">
                     <label><spring:message code="most.02.hanghoa.ngaynk_denngay" /><a class="nsw-require-field">*</a></label>
                 </div>
                 <div class="col-md-2">
                     <input name="fiNkDen" id="fiNkDen" class="form-control form-control-inline date-picker"  value="{{convertToDateFromTimeStamp fiNkDen false}}"
                            data-date-format="dd/mm/yyyy"  type="text" value="" field="most_02_hanghoa_ngayketthucnk"/>
                 </div>
             </div>
             
         </form>
     </div>