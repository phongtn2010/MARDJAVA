<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>

<div class="row">

    <div class="col-md-12">
      <form role="form" class="form-horizontal" id="listLicense">                      

				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="caption-subject bold uppercase">PHẦN I: Thông tin chung</span>
					</div>
					<div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Mã hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="value: Tbdhoso.fiMaHoso()"
                                           type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.unit"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                               
                                  <input class="form-control" disabled="true"
                                  			data-bind=" value: nameCQXL()"
                                           
                                           type="text">
                                   
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Trạng thái hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"  type="text"
                                           value="Trạng thái đã trả kết quả" />
                                          
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.organization"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"><input class="form-control" disabled="true"                                                             
                                                             data-bind="value: Tbdhoso.fiTendoanhnghiep"
                                                             type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.tax"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                          
                                           data-bind="value: Tbdhoso.fiManguoitao" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.address"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                         
                                           data-bind="value: Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.phone"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
								<input class="form-control" disabled="true"
									
									data-bind="value: Tbdgiayphep.fiDienthoai" type="text">
							</div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.fax"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                          
                                           data-bind="value: Tbdgiayphep.fiFax" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.email"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                         
                                           data-bind="value: Tbdhoso.fiEmail" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.website"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" data-bind="value: Tbdgiayphepgiahan.fiWebsite"
                                         
                                           type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Giấy chứng nhận đăng ký kinh doanh hoặc giấy phép đầu tư số</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                    		placeholder="Số giấy phép kinh doanh vận tải bằng xe ô tô"
                                           data-bind="value: Tbdgiayphepgiahan.fiGiayphepkinhdoanh" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Ngày cấp</label>
                                </div>
                                <div class="col-md-4">
                                    <input name="fiNgaydangky" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                          data-bind="datepicker:Tbdgiayphep.fiNgayky" />
                                          
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Cơ quan cấp</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                          
                                           data-bind="value: Tbdgiayphepgiahan.fiCoquancapphep" type="text">
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>      
<%--              thông tin gia hạn  --%>

 				<div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần II: Thông tin đề nghị gia hạn như sau</span>
                    </div>
                    <div class="panel-body">
                        
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Biển số xe xin gia hạn<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" >
									<input class="form-control"
										data-bind="value: Tbdgiayphepgiahan.fiSoDangKyPhuongTien"
										placeholder="Biển số xe xin gia hạn" type="text">
								</div>
                                
                               
                                <div class="col-md-2 label-text-right" >
                                    <label>Giấy phép liên vận số<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: Tbdgiayphepgiahan.fiSoGiayPhepPhuongTien"
										placeholder="Giấy phép liên vận số" type="text">
								</div>
                            </div>
                        </div>
                    
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
								<label>Ngày cấp<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4"
									>
									<input name="fiNgayNhapCanh" id="fiNgayNhapCanh"
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"										
										data-bind="datepicker: Tbdgiayphepgiahan.fiHieuLucSoGPPhuongTienTuNgay" />
								</div>
                                <div class="col-md-2 label-text-right" >
                                    <label>Cơ quan cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: Tbdgiayphepgiahan.fiNoiCapSoGPPhuongTien"
										 type="text">
								</div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">                       
                                <div class="col-md-2  label-text-right">
								<label>Giấy phép có giá trị đến</label>
								</div>
								<div class="col-md-4">
									<input 
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										
										data-bind="datepicker: Tbdgiayphepgiahan.fiHieuLucSoGPPhuongTienDenNgay" />
								</div>
								<div class="col-md-2  label-text-right">
								<label>Thời gian nhập cảnh vào Việt Nam<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4"
									>
								<input
									field="common_tracuu_ngay_tao_tu"
									class="form-control form-control-inline date-picker"
									data-date-format="dd/mm/yyyy" size="16" type="text"
									
									data-bind="datepicker: Tbdgiayphepgiahan.fiNgayNhapCanh" />
							</div>
								
                            </div>
                        </div>
                                  
                   <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12 row">
                        	<div class="col-md-4  label-text-right">
							    <label class="radio-inline">
							      Thời hạn đề nghị được gia hạn thêm <span class="nsw-require-field">*</span>(lựa chọn 1 trong 2 nội dung sau để khai): 
							    </label>
							</div>
							<div class="col-md-4  label-text-right">							
							    <label class="radio-inline" >
							       <input                                            
                                           type="radio"
                                           name="fiLoaiTbdGiaHan" 
                                           value=0                                                                                                               
                                           data-bind="checked: Tbdgiayphepgiahan.fiLoaiGiaHan"/> Gia hạn giấy phép liên vận
							    </label>
							 </div>
							 <div class="col-md-4  label-text-right">
							    <label class="radio-inline">
							    <input                                           
                                           type="radio"
                                           value = 1 
                                           name="fiLoaiTbdGiaHan"                                          
                                           data-bind="checked: Tbdgiayphepgiahan.fiLoaiGiaHan"/>  Gia hạn chuyến đi							     
							    </label>
							</div>
						</div>
				</div>
                <div class="col-md-12 row" data-bind="visible: Tbdgiayphepgiahan.fiLoaiGiaHan() ==0 ">   
                	  <span class="caption-subject bold ">Gia hạn giấy phép</span>                                           
                     <fieldset>
                          <legend></legend>
                            <div class="col-md-12 row" >
                                <div  class="col-md-12 row" >
                                    <div class="col-md-3  label-text-right">
                                        <label>Số ngày gia hạn<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-3"
                                       >
                                        <input 
                                           class="form-control"
                                           size="16" type="text"
                                           placeholder="Số ngày gia hạn"
                                           data-bind="value: Tbdgiayphepgiahan.fiSoGiaHan"/>
                                    </div>

                                </div>
                                                         
                                </div>
                                <div  class="col-md-6 row" style="margin-top: 15px;">
                                    <div class="col-md-6  label-text-right">
                                        <label>Thời gian gia hạn từ ngày<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-6"
                                       >
                                        <input 
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: Tbdgiayphepgiahan.fiGiaHanTuNgay"/>
                                    </div>
                                </div>
                                <div  class="col-md-6 row" style="margin-top: 15px;">
                                    <div class="col-md-6  label-text-right">
                                        <label>Đến ngày<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-6"
                                      >
                                        <input 
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: Tbdgiayphepgiahan.fiGiaHanDenNGay"/>
                                    </div>

                                </div>                                                          
                         </fieldset>                        
                         
                    </div>
               
                <div class="col-md-12 row" data-bind="visible: Tbdgiayphepgiahan.fiLoaiGiaHan() ==1 ">   
                	  <span class="caption-subject bold ">Gia hạn chuyến đi</span>                                           
                     <fieldset>
                          <legend></legend>
                            <div class="col-md-12 row" >
                                <div  class="col-md-12 row" >
                                    <div class="col-md-3  label-text-right">
                                        <label>Số ngày gia hạn<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-3"
                                        >
                                        <input 
                                           class="form-control"
                                           size="16" type="text"
                                           placeholder="Số ngày gia hạn"
                                           data-bind="value: Tbdgiayphepgiahan.fiSoGiaHan"/>
                                    </div>

                                </div>
                                                         
                                </div>
                                <div  class="col-md-6 row" style="margin-top: 15px;">
                                    <div class="col-md-6  label-text-right">
                                        <label>Thời gian gia hạn từ ngày<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-6">
                                      
                                        <input 
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                          
                                           data-bind="datepicker: Tbdgiayphepgiahan.fiGiaHanTuNgay"/>
                                    </div>

                                </div>
                                <div  class="col-md-6 row" style="margin-top: 15px;">
                                    <div class="col-md-6  label-text-right">
                                        <label>Đến ngày<span class="nsw-require-field">*</span></label>
                                    </div>
                                     <div class="col-md-6"
                                        >
                                        <input 
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                          
                                           data-bind="datepicker: Tbdgiayphepgiahan.fiGiaHanDenNGay"/>
                                    </div>

                                </div>                  
                         </fieldset>                        
                         
                    </div>
                    <div class="form-group">
                        <div class="col-md-12 row" style="margin-top: 15px;">
                        	<div class="col-md-2  label-text-right">
                                      <label>Lý do đề nghị gia hạn<span class="nsw-require-field">*</span></label>
                             </div>
                             <div class="col-md-10" >                            
                                        <input 
                                           class="form-control"
                                           size="100" type="text"
                                           
                                           data-bind="value: Tbdgiayphepgiahan.fiLyDoGiaHan"/>                                                                                                         
                             </div>							
						</div>
					</div>                                       
		   			 
		 		</div>	
		 		</div>
		 			        
               <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: THÔNG TIN TỆP ĐÍNH KÈM</span>
                    </div>
                    <div class="panel-body">
                           <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
						        <thead>
						        <tr class="nsw-tr tr-nsw1-bgcolor">
						            <th class="text-center;"><spring:message code="sbv.01.form.38"></spring:message></th>
						            <th class="text-center"><spring:message code="sbv.01.form.46"></spring:message></th>
						            <th class="text-center">Đường dẫn file đính kèm</th>
						         
						        </tr>
						        </thead>
						        <tbody >
 						        <tr data-bind="foreach: { data: Tbdgiayphepdinhkem, as: 'ifile' }">
					            	<td class="text-center" data-bind="text: $index()+1"></td>
					            	<td class="text-center" data-bind="text: fiTenFile"></td>
           							<td class="text-center" data-bind="text: fiUrlDinhkem"></td>
						        				           
 						        </tr>
						       
						        </tbody>
						    </table>
						                        
                    </div>
                </div>
                	
                    
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần IV: THÔNG TIN KÝ ĐƠN</span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="form-group" style="margin-top: 15px;">
                                <div class="col-md-12">
                                    <div class="col-md-2 label-text-right">
                                        <label>Người ký<span class="nsw-require-field">*</span></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="text"
                                       		   placeholder="Người ký"
                                               data-bind="value: Tbdgiayphep.fiNguoiky">
                                    </div>
                                    <div class="col-md-2 label-text-right">
                                        <label>Chức danh</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="text"
                                        	   placeholder="Chức danh"
                                               data-bind="value: Tbdgiayphep.fiChucdanh">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12" style="margin-top: 15px;">
                                    <div class="col-md-2 label-text-right">
                                        <label>Địa điểm ký<span class="nsw-require-field">*</span></label>
                                    </div>
                                    <div class="col-md-4"><input class="form-control" type="text"
                                    							placeholder="Địa điểm ký"
                                                                 data-bind="value: Tbdgiayphep.fiNoiky">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>            

             
            </form>


    </div>
    <div class="form-group nsw-text-center">
        <a href="javascript:;"
           data-bind="click: $root.dong" class="btn green bt-center btwidth" id="btDong"> <i
                class="fa fa-times" aria-hidden="true"></i></i>&nbsp;
            <spring:message code="common.button.dong"/> </a>
    </div>
</div>
<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    var procedureId = '${procedureId}';
</script>
<script>
    var type = "${type}";
</script>
<script type="text/javascript" src="<c:url value="/app/mt/p18/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p18/model.js?v=${ version }"/>"
        charset="utf-8"></script>
