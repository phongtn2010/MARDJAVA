<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">P18-Edit ${editMode}
    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i> <span
                        class="caption-subject bold uppercase"> ${titleLabel}</span>
                </div>
            </div>
            <form role="form" class="form-horizontal" id="detailForm">
            
            
<%--                <jsp:include page="thongtinchung.jsp"></jsp:include>  --%>

				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="caption-subject bold uppercase">PHẦN I: Thông tin chung</span>
					</div>
					<div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;" data-bind="visible: hoSoId>0">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Mã hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: hoSoChiTiet.TbdGiaHan.fiSoGiayPhepPhuongTien()"
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
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiIdBophan ">
                                    <select name="bophanHoSo"
                                            class="form-control select2" data-bind="options: $root.danhSachDonVi,
                                             optionsText: 'fiTenCqxl',
                                             optionsValue: 'fiIdCqxl',
                                             value: hoSoChiTiet.Tbdhoso.fiIdBophan ,
                                             optionsCaption: '--Chọn đơn vị--',
                                             valueAllowUnset: true">
                                    </select>
                                </div>
                                <div class="col-md-2 label-text-right" data-bind="visible: hoSoId>0">
                                    <label>Trạng thái hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: $root.getTenTrangthai(hoSoChiTiet.Tbdhoso.fiTrangthai())"
                                           type="text">
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
                                                             placeholder="Tên doanh nghiệp"
                                                             data-bind="value: hoSoChiTiet.Tbdhoso.fiTendoanhnghiep"
                                                             type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.tax"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.27" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiManguoitao" type="text">
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
                                           placeholder="<spring:message code="sbv.01.form.29" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.phone"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.30" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDienthoai" type="text">
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
                                           placeholder="<spring:message code="sbv.01.form.31" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiFax" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.email"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="Email"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiEmail" type="text">
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
                                    <input class="form-control" data-bind="value: hoSoChiTiet.Tbdhoso.fiWebsite"
                                           placeholder="Website"
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
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiGiayphepkinhdoanh" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Ngày cấp</label>
                                </div>
                                <div class="col-md-4">
                                    <input name="fiNgaydangky" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgaydangky"/>
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
                                           placeholder="Cơ quan cấp"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiCoquancapphep" type="text">
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
										data-bind="value: hoSoChiTiet.TbdGiaHan.fiSoDangKyPhuongTien"
										placeholder="Biển số xe xin gia hạn" type="text">
								</div>
                                
                               
                                <div class="col-md-2 label-text-right" >
                                    <label>Giấy phép liên vận số<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: hoSoChiTiet.TbdGiaHan.fiSoGiayPhepPhuongTien"
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
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiHieuLucSoGPPhuongTienTuNgay" />
								</div>
                                <div class="col-md-2 label-text-right" >
                                    <label>Cơ quan cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: hoSoChiTiet.TbdGiaHan.fiNoiCapSoGPPhuongTien"
										placeholder="Cơ quan cấp" type="text">
								</div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
<!--                                 <div class="col-md-2  label-text-right"> -->
<!-- 								<label>Giá trị giấy phép từ ngày</label> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-4" -->
<!-- 									> -->
<!-- 									<input -->
<!-- 										field="common_tracuu_ngay_tao_tu" -->
<!-- 										class="form-control form-control-inline date-picker" -->
<!-- 										data-date-format="dd/mm/yyyy" size="16" type="text" -->
<!-- 										placeholder="dd/mm/yyyy" -->
<!-- 										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiHieuLucSoGPPhuongTienTuNgay" /> -->
<!-- 								</div> -->
                                <div class="col-md-2  label-text-right">
								<label>Giấy phép có giá trị đến</label>
								</div>
								<div class="col-md-4">
									<input 
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiHieuLucSoGPPhuongTienDenNgay" />
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
									placeholder="dd/mm/yyyy"
									data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiNgayNhapCanh" />
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
                                           data-bind="checked: hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan"/> Gia hạn giấy phép liên vận
							    </label>
							 </div>
							 <div class="col-md-4  label-text-right">
							    <label class="radio-inline">
							    <input                                           
                                           type="radio"
                                           value = 1 
                                           name="fiLoaiTbdGiaHan"                                          
                                           data-bind="checked: hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan"/>  Gia hạn chuyến đi							     
							    </label>
							</div>
						</div>
				</div>
<!--                 <h1 class="col-md-12 row" data-bind="text: hoSoChiTiet.TbdhoSoChiTiet.TbdGiaHan.fiLoaiTbdGiaHan() ">   </h1> -->
                <div class="col-md-12 row" data-bind="visible: hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan() ==0 ">   
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
                                           data-bind="value: hoSoChiTiet.TbdGiaHan.fiSoGiaHan"/>
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
                                           data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanTuNgay"/>
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
                                           data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanDenNGay"/>
                                    </div>

                                </div>                                                          
                         </fieldset>                        
                         
                    </div>
               
                <div class="col-md-12 row" data-bind="visible: hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan() ==1 ">   
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
                                           data-bind="value: hoSoChiTiet.TbdGiaHan.fiSoGiaHan"/>
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
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanTuNgay"/>
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
                                           data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanDenNGay"/>
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
                                           placeholder="Lý do đề nghị gia hạn"
                                           data-bind="value: hoSoChiTiet.TbdGiaHan.fiLyDoGiaHan"/>                                                                                                         
                             </div>							
						</div>
					</div>                                       
		   			 
		 		</div>	
		 		</div>
		 			
		 				
                
<!--                 Thông tin tệp đính kèm -->

               <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: THÔNG TIN TỆP ĐÍNH KÈM</span>
                    </div>
                    <div class="panel-body">
                          <jsp:include page="upload_file_${procedureId}.jsp"></jsp:include>
                        
                    </div>
                </div>
                <%-- 	 <jsp:include page="thongtinkydon.jsp"></jsp:include>  --%>
                    
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
                                               data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiTenNguoiKy">
                                    </div>
                                    <div class="col-md-2 label-text-right">
                                        <label>Chức danh</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="text"
                                        	   placeholder="Chức danh"
                                               data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiChucdanh">
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
                                                                 data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiDiadiemKy">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>            

                <div class="form-group nsw-text-center">
                    <a href="javascript:;" class="btn green"
                       data-bind="click: $root.luuHoSo, visible: editMode"><i
                            class="fa fa-save"></i>Ghi lại</a>
                    <a href="javascript:;"
                       data-bind="click: $root.guiHoSo, visible: editMode"
                       class="btn green"><i
                            class="fa fa-send-o"></i>Gửi hồ sơ</a>
                    <a href="javascript:;"
                       data-bind="click: $root.dong"
                       class="btn green"><i
                            class="fa fa-close"></i>Trở lại</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    var hoSoId =${hoSoId};
</script>
<script>
    var userCustom = ${userCustom};
</script>
<script>
    var procedureId = '${procedureId}';
</script>
<script>
    var editMode = ${editMode};
</script>

<script type="text/javascript" src="<c:url value="/app/mt/p18/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p18/model.js?v=${ version }"/>"
        charset="utf-8"></script>