<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
             <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row" >
                        <div class="col-md-10 center-body" style="margin-left: 8.5%">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class = "row">
                                        <h4 class="col col-lg-3 text-center">
                                            <b>${hoso.fiTendv}</b>
                                            <p>--------------</p>
                                            <p>Số: <span style="color:blue">${hoso.fiSovanban}</span></p>
                                        </h4>
                                        <div class="col col-lg-4">

                                        </div>
                                        <h4 class="col col-lg-5 text-center">
                                            <p style="font-weight: bold">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</p>
                                            <p style="font-weight: bold">Độc lập - Tự do - Hạnh phúc</p>
                                            <p>---------------------------</p>
                                        </h4>
                                    </div>
                                    <div class="row">
                                        <h4 class="nsw-text-center Bold" style = "text-transform: capitalize">
                                            <spring:message code="moh.typea.table.col.phieu_tiep_nhan" />
                                        </h4>
                                         <h4 class="nsw-text-center">
                                         <span class="Bold">Hồ sơ công bố tiêu chuẩn áp dụng của trang thiết bị y tế thuộc loại A</span>
                                         <p>--------------------------------------------------------------------</p>
                                        </h4>
                                        <br>
                                    </div>
                                        
                                    <div class="row" style="font-size: 14px">
                                        <div class="col col-lg-12">
                                            <div><div class="col col-lg-1 text-right">1.</div>  <div class="col col-lg-11"><spring:message code="moh.ten_co_so" />: <span style="color:blue">${hoso.fiTendn}</span></div></div>
                                            <div><div class="col col-lg-1 text-right">2.</div>  <div class="col col-lg-11"><spring:message code="moh.typea.hoso.dia_chi" />: <span style="color:blue">${hoso.fiDiachidn} </span></div></div>
                                            <div><div class="col col-lg-1 text-right">3.</div>  <div class="col col-lg-11"><spring:message code="moh.typea.so_van_ban" />: <span style="color:blue">${hoso.fiSovanban}</span> 
                                                Ngày:<span style="color:blue"> <fmt:formatDate value="${hoso.fiNgaytao}" pattern="dd-MM-yyyy" /></span></div></div> 
                                            <div>
                                                <div class="col col-lg-1 text-right">4.</div> 
                                                <div class="col col-lg-11">
                                                    <p><spring:message code="moh.06.trangtbytloaia" />:</p>
                                                    <p><spring:message code="moh.typea.thietbi.ten" />: <span style="color:blue">${hoso.thietBi.fiTentrangtb}</span></p>
                                                    <p><spring:message code="moh.typea.thietbi.ma_san_pham" />: <span style="color:blue">${hoso.thietBi.fiLoai}</span></p>   
                                                    <p><spring:message code="moh.typea.thietbi.ten_co_so_san_xuat" />: <span style="color:blue">${hoso.thietBi.fiHangsx}</span></p>                                                                                                       
                                                    <p><spring:message code="moh.typea.thietbi.dia_chi_co_so" />: <span style="color:blue">${hoso.thietBi.fiDiachisx}</span></p>                                                    
                                                    <p><spring:message code="moh.typea.thietbi.tieu_chuan_ap_dung" />: <span style="color:blue">${hoso.thietBi.fiTieuchuan}</span></p>
                                                </div>
                                            </div>
                                            <div>
                                                <div class="col col-lg-1 text-right">5.</div> 
                                                <div class="col col-lg-11">
                                                    <p><spring:message code="moh.06.thong_tin_chu_so_huu" />:</p>
                                                    <p><spring:message code="moh.typea.themthietbi.chu_so_huu" />: <span style="color:blue">${hoso.thietBi.fiChusohuu}</span></p>
                                                    <p><spring:message code="moh.typea.themthietbi.dc_chu_so_huu" />: <span style="color:blue">${hoso.thietBi.fiDiachicsh}</span></p>   
                                                </div>
                                            </div>
                                            <div>
                                                <div class="col col-lg-1 text-right">6.</div> 
                                                <div class="col col-lg-11">
                                                    <p><spring:message code="moh.06.thongtin_cosobaohanh" />:</p>
                                                    <ol>
                                                        <c:forEach items="${hoso.listOfTbdbaohanh}" var="baohanh">
                                                            <li class="col-lg-12">
                                                                <p><spring:message code="moh.typea.tencosobaohanh" />: <span style="color:blue">${baohanh.fiTencoso}</span></p>
                                                                <p><spring:message code="moh.typea.cosobaohanh.dia_chi" />: <span style="color:blue">${baohanh.fiDiachics }</span></p>   
                                                                <p>
                                                                <div style="width:50%; float:left">
                                                                    <spring:message code="moh.06.dt_codinh" />: <span style="color:blue">${baohanh.fiDienthoai}</span>
                                                                </div>
                                                                                                                
                                                                <p>
                                                                    <spring:message code="moh.06.dt_didong" />: <span style="color:blue">${baohanh.fiDidong}</span>
                                                                </p>    
                                                                </p>
                                                            </li>
                                                        </c:forEach>
                                                    </ol>
                                                </div>
                                            </div>   
                                            <div>
                                                <div class="col col-lg-1 text-right">7.</div> 
                                                <div class="col col-lg-11">
                                                     <spring:message code="moh.06.thanhphanhoso" />:
                                                    <br>
                                                    <br>
                                                    <table class="table table-striped table-bordered table-hover table-checkable order-column"
                                                        <tr>
                                                            <td>1</td>
                                                            <td>Văn bản đề nghị công bố tiêu chuẩn của trang thiết bị y tế thuộc loại A</td>
                                                            <td>
                                                                
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>2</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.banphanloaittbyte" /> </td>
                                                            <td>
                                                                <% int i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 1}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>3</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.phieutiepnhan" /></td>
                                                            <td>
                                                                
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 2}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>4</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.giayuyquyen" /></td>
                                                            <td>
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 3}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>5</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.giayxacnhandudkbaohanh" /></td>
                                                            <td>
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 4}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>6</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.tailieumotakythuat" /></td>
                                                            <td>
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 5}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>7</td>
                                                            <td>Bản tiêu chuẩn mà chủ sở hữu trang thiết bị y tế công bố áp dụng</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>8</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.giaychungnhanhopchuan" /></td>
                                                            <td>
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 6}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>9</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.tailieuhdsd" /></td>
                                                            <td>
                                                               
                                                                <% i = 0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 7}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if (i > 0) {
                                                                        out.print("X");
                                                                    } %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>10</td>
                                                            <td><spring:message code="moh.typea.tepdinhkem.loaitep.maunhansudung" /></td>
                                                            <td>
                                                                <% i =0; %>
                                                                <c:forEach items="${hoso.taptinList}" var="taptin">
                                                                    <c:choose>
                                                                        <c:when test="${taptin.fiLoai == 8}"><% i++; %></c:when>
                                                                    </c:choose>
                                                                </c:forEach>
                                                                <% if(i>0) out.print("X"); %>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                            <div class="col-md-3 pull-right nsw-text-center"><b><spring:message code="moh.06.nguoitiepnhan" /></b></div>
                                                    <div class="clearfix"></div>
                                                    <div class="col-md-3 pull-right nsw-text-center">${nguoitiepnhan}</div>
                                                    <br>
                                                     
                                                    <c:forEach items="${hoso.taptinList}" var="taptin">
                                                        <c:choose>
                                                            <c:when test="${taptin.fiLoai == 10}">
                                                                <a href="${taptin.fiUrltaptin}">
                                                                    <button class="btn blue"><i class="fa fa-book fa-lg"></i>Tải phiếu tiếp nhận</button>
                                                                </a>
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>    
                                                </div>
                                            </div>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <p class="nsw-text-center"><button class ="btn grey" onclick="{document.location = app.appContext + '/moh/06/home';}"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></button>
                        </div>
                    </div>
                </div>
             </div>
        </div>
    </div>
</div>
