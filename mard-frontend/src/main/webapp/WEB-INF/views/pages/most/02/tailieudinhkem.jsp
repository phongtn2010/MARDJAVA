<fieldset>
    <legend><spring:message code="common.tai_lieu_dinh_kem" /></legend>
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.hopdong" /></b></p>
    </div>
    <form id="hopdong-file-form"  role="form" class="form-horizontal">
    <table class="table table-striped table-bordered table-hover order-column">
        <thead>
            <tr>
                <th class="w70 nsw-text-center"> <spring:message code="common.table.col.stt" /></th>
                <th class="w150"> <spring:message code="most.01.hopdong.sohopdong" /></th>
                <th class="w150 nsw-text-center"> <spring:message code="most.01.hopdong.ngayhopdong" /> </th>
                <th> <spring:message code="most.01.hopdong.file" /> </th>
                <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.hopdong.chucnang" /> </th>                           
            </tr>
        </thead>
        <tbody id="hopdong-container">

        </tbody>
        <tfoot style="display: ${IsView}">
            <tr class="odd gradeX" id="hopdong-tmpl">
                <td> </td>
                <td class="w150"> 
                    <input class="form-control" name="fiSoVb" id="txtSohopdong"  field="most_01_hopdong_sohopdong" maxlength="50" placeholder="<spring:message code="most.01.hopdong.sohopdong" />" type="text">
                </td>
                <td class="w150">
                    <input name="fiNgayCap" id="txtNgayHopDong" style="width: 200px" field="most_02_hopdong_ngayhopdong" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />                                                            
                </td>
                <td>
                    <div class="fileinput fileinput-new" data-provides="fileinput">
                        <span class="btn grey btn-file">
                            <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                            <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                            <input value="" type="hidden"><input id="hopdong-ip" type="file" > </span>
                        <span class="fileinput-filename"></span> &nbsp;
                        <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                    </div>
                </td>
                <td class="nsw-text-center">
                    <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                          data-original-title="<spring:message code="most.01.hopdong.command.luu" />" 
                          data-container="body" id="btnFileHopDongThemMoi"></i></a>
                </td>
            </tr>
        </tfoot>
    </table>
    </form>
            
    <!--danh muc hang hoa-->        
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.dmhanghoa" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="dmhanghoa-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"><spring:message code="common.table.col.stt" /></th>
                        <th class="w150"><spring:message code="most.01.dmhanghoa.tendanhmuc" /></th>
                        <th class="w150 nsw-text-center"><spring:message code="most.01.dmhanghoa.ngay" /> </th>
                        <th> <spring:message code="most.02.common.filedinhkem" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.dmhanghoa.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="dmhanghoa-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="dmhanghoa-tmpl">
                        <td></td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtTenDM" field="most_01_dmhanghoa_tendanhmuc" class="form-control" placeholder="<spring:message code="most.01.dmhanghoa.tendanhmuc" />" maxlength="50" type="text">
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayDM" field="most_02_ngaycap" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="dmhanghoa-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.dmhanghoa.command.luu" />" 
                                  data-container="body" id="btnFileDMHangHoaThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
    <!--end danh muc hanghoa-->
    
    <!--chung nhan xuat xu so-->
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.02.chungnhanxuatxuso" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="chungnhan-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"><spring:message code="common.table.col.stt" /></th>
                        <th class="w150"><spring:message code="most.02.hoso.sochungchi" /></th>
                        <th class="w150 nsw-text-center"><spring:message code="most.02.common.ngaycap" /> </th>
                        <th> <spring:message code="most.02.common.filedinhkem" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.dmhanghoa.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="chungnhan-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="chungchi-tmpl">
                        <td></td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtSoChungChi" field="most_01_dmhanghoa_tendanhmuc" class="form-control" placeholder="<spring:message code="most.01.dmhanghoa.tendanhmuc" />" maxlength="50" type="text">
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayChungNhan" field="most_02_ngaycap" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="chungchi-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.dmhanghoa.command.luu" />" 
                                  data-container="body" id="btnFileChungNhanThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
    <!--end chung nhan xuat xu so-->
    
    <!--tai lieu khac-->                
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.02.hoso.talieukhac" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="tailieu-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"><spring:message code="common.table.col.stt" /></th>
                        <th class="w150"><spring:message code="most.02.hoso.loaitailieu" /></th>
                        <th class="w150 nsw-text-center"><spring:message code="most.02.hoso.ngay" /> </th>
                        <th> <spring:message code="most.02.common.filedinhkem" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.dmhanghoa.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="tailieukhac-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="tailieu-tmpl">
                        <td></td>
                        <td class="w150"> 
                            <select class="form-control select2" name="fiMaLoai" id="txtLoaiTaiLieu">
                                <option value=""><spring:message code="common.chon" /></option>
                                <option value="4"><spring:message code="most.02.filetypename.thuyetminh" /></option>
                                <option value="5"><spring:message code="most.02.filetypename.talieukhac" /></option>
                            </select>
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayTaiLieu" field="most_02_talieukhac_ngaytailieu" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="tailieu-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code='most.01.dmhanghoa.command.luu' />" data-container="body" id="btnFileTaiLieuThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>         
    <!--end tai lieu khac-->
</fieldset>   
