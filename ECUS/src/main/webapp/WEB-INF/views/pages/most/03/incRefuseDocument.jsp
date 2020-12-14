<%-- 
    Document   : incRefuseDocument
    Created on : Sep 19, 2017, 10:13:35 AM
    Author     : QUANGNV18
--%>
<%@ page pageEncoding="UTF-8"%>
<form role="form" class="form-horizontal" id="Most03TCFiles">
    <table class="table table-striped table-bordered table-hover table-checkable order-column">
        <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center w50">TT</th>
                <th class="text-center">Loại tệp</th>
                <th class="text-center">File đính kèm</th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'dsFileTCDK', foreach: dinhKems }">
        </tbody>
        <script id="dsFileTCDK" type="text/html">
            <tr>
                <td data-bind="text : stt"></td>                        
                <td class="text-center" data-bind="text : fiTenLoai"></td>
                <td class="text-center">
                    <a data-bind="text : fiTenTep, attr: { href: downloadUrl}"  target="_blank"></a>
                </td> 
            </tr>                      
            </script>
        </table>
    </form>
