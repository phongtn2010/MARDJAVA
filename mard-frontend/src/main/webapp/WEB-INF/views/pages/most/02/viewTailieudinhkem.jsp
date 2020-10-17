<fieldset>
    <legend><spring:message code="common.tai_lieu_dinh_kem" /></legend>
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.hopdong" /></b><a class="nsw-require-field">*</a></p>
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
      
    </table>
    </form>
            
    <!--danh muc hang hoa-->        
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.dmhanghoa" /></b><a class="nsw-require-field">*</a></p>
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
               
            </table>
        </form>
    </div>         
    <!--end tai lieu khac-->
</fieldset>   
