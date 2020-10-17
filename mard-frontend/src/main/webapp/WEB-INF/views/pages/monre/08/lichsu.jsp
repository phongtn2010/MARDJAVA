<%-- 
    Document   : lichsu
    Created on : Aug 7, 2017, 11:27:33 PM
    Author     : hieptran
--%>

<%@ page pageEncoding="UTF-8"%>

<fieldset>
    <legend>Quá trình xử lý hồ sơ</legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstLichsu10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center">STT</th>
                        <th class="text-center" style="width: 100px;">Ngày tạo</th>
                        <th class="text-center">Trạng thái</th>
                        <th class="text-center">Nội dung</th>
                        <th class="text-center">Người gửi</th>
                        <th class="text-center">Đơn vị gửi</th>
                        <th class="text-center">Người nhận</th>
                        <th class="text-center">Đơn vị nhận</th>
                    </tr>
                </thead>
                <tbody data-bind="template: { name: 'lstLichsu10Tmpl', foreach: lstLichsu10 }">
                </tbody>
                <script id="lstLichsu10Tmpl" type="text/html">
                    <tr>
                        <td data-bind="text : STT">
                        </td>  
                        <td data-bind="date : fiNgaytao" style="width: 100px;">
                        </td> 
                        <td data-bind="text : fiTenTt">
                        </td>
                        <td data-bind="text : fiNoidung">
                        </td>  
                        <td data-bind="text : fiTenNggui">
                        </td>    
                        <td data-bind="text : fiTenDvgui">
                        </td>    
                        <td data-bind="text : fiTenNgnhan">
                        </td>   
                        <td data-bind="text : fiTenDvnhan">
                        </td>
                    </tr>                      
                    </script>
                </table>
            </div>
        </div>

    </fieldset>