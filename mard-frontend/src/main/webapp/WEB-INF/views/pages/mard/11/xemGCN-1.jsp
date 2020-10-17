<%-- 
    Document   : xemGCN
    Created on : Sep 22, 2017, 10:40:42 PM
    Author     : hieptran
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<style type="text/css">
    #gcn11View table p{
        margin: 0;
    }
    table {
        border-collapse: collapse;
    }

    table, td, th {
        border: 1px solid black;
    }
    th{
        text-align: center;
    }
</style>
<page size="A4" class="a4-padding" id="gcn11View">
    <table width="100%" >
        <tbody>
            <tr>
                <td colspan="6">

                    <p class="content t-bold t-center">
                        BỘ NÔNG NGHIỆP & PHÁT TRIỂN NÔNG THÔN
                    </p>
                    <p class="content t-center">
                        MINISTRY OF AGRICULTURE & RURAL DEVELOPMENT
                    </p>
                    <p class="content t-bold t-center">
                        CỤC BẢO VỆ THỰC VẬT
                    </p>
                    <p class="content t-center">
                        PLANT OF PROTECTION DEPARTMENT
                    </p>
                </td>
                <td colspan="6">
                    <p class="content t-bold t-center">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </p>
                    <p class="content t-center">
                        SOCIALIST REPUBLIC OF VIETNAM</p>
                    <p class="content t-bold t-center">
                        Độc lập – Tự do – Hạnh phúc
                    </p>
                    <p class="content t-center">
                        INDEPENDENCE – FREDOOM - HAPPINESS</p>
                </td>
                <td colspan="4" class="t-center">
                    <img width="70%" src="data:image/jpeg;base64,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"/>
                </td>
            </tr>
            <tr>
                <td colspan="12" rowspan="2">
                    <p class="content t-bold t-center">
                        GIẤY CHỨNG NHẬN KIỂM DỊCH THỰC VẬT
                    </p>

                    <p class="content">
                        Gửi: Cơ quan Bảo vệ thực vật nước</p>
                    <p class="content">
                        TO: THE PLANT PROTECTION ORGANIZATION(S) OF <span data-bind="text : fiTennuocXk"></span></p>
                </td>
            </tr>
            <tr>
                <td colspan="12">
                    Số (No) <span  data-bind="text : fiSoGcn" ></span>
                </td>
            </tr>
            <tr>
                <td colspan="16">
                    <p class="content t-bold t-center">
                        DIỄN GIẢI VỀ LÔ HÀNG (DESCRIPTION OF CONSIGNMENT)</p>
                </td>
            </tr>
            <tr>
                <td colspan="8" rowspan="2">
                    <p class="content t-bold">
                        1. Tên và địa chỉ người xuất khẩu:</p>
                    <p class="content ">
                        NAME AND ADRESS OF EXPORTER:
                        <span  data-bind="text : fiNguoiXk" style="text-transform: uppercase"></span> <span  data-bind="text :fiDiachiXk" style="text-transform: uppercase"></span>
                    </p>
                </td>
                <td colspan="8">
                    <p class="content t-bold">
                        5. Nơi sản xuất:</p>
                    <p class="content ">
                        PLACE OF ORIGIN:
                        <span  data-bind="text : fiTennuocSx" style="text-transform: uppercase"></span></p>

                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <p class="content t-bold">
                        6. Phương tiện chuyên chở:</p>
                    <p class="content ">
                        DECLARED MEANS OF CONVEYANCE:
                        <span  data-bind="text: fiTenHtcc" > </span> 
                        <span  data-bind="text: fiPtcc " > </span>
                        <span  data-bind="text: fiSohieuPt" > </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <p class="content t-bold">
                        2. Tên và địa chỉ người nhận:</p>
                    <p class="content ">
                        DECLARED NAME AND ADDRESS OF THE CONSIGNEE:                        
                        </p>
                    <p><span  data-bind="text : fiTenNn" ></span><br /> </p>
                    <p><span  data-bind="text :fiDiachiNn " style="text-transform: uppercase"></span></p>
                </td>
                <td colspan="8">
                    <p class="content t-bold">
                        7. Cửa khẩu nhập:
                        DECLARED POINT OF ENTRY:</p>
                    <p class="content ">
                        <span  data-bind="text :fiCkNhap " ></span> </p>

                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <p class="content t-bold">
                        3. Số lượng và loại bao bì:</p>
                    <p class="content ">
                        NUMBER AND DESCRIPTION OF PACKAGES:
                        <span  data-bind="text :fiSoluong " ></span> <span  data-bind="text :fiTenbaobi " ></span></p>


                </td>
                <td colspan="8">
                    <p class="content t-bold">
                        8. Tên và khối lượng sản phẩm:</p>
                    <p class="content ">
                        NAME OF PRODUCE AND QUANTITY DECLARED:
                    </p>
                        <div data-bind="template: { name: 'hhTmpl', foreach: hh}">
                        </div>
                        <script id="hhTmpl" type="text/html">
                            <p class="content">
                                <span data-bind="text : fiTenHh"></span>: <span data-bind="text : fiKhoiluong"></span> <span data-bind="text : fiTendvKl"></span>; <span data-bind="text : fiSoluong"></span> <span data-bind="text : fiTendvSl"></span>
                            </p>
                        </script>
                        <p>N.W: <a data-bind="text: fiTongkltinh"></a> <a data-bind="text: fiHienthiBi"></a></p>
                        <p>G.W: <a data-bind="text: fiTongklbi"></a> <a data-bind="text: fiHienthiBi"></a></p>
                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <p class="content t-bold">
                        4. Ký, mã hiệu:</p>
                    <p class="content ">
                        DISTINGUISHING MARKS:
                        <span  data-bind="text : fiMakyhieu" style="text-transform: uppercase"></span></p>

                </td>
                <td colspan="8">
                    <p class="content t-bold">
                        9. Tên khoa học của thực vật:</p>
                    <p class="content ">
                        BOTANICAL NAME OF PLANTS:
                        <span data-bind="text : tkh" style="font-style: italic; text-transform: uppercase"></span></p>
                </td>
            </tr>
            <tr>
                <td colspan="16">
                    Nay chứng nhận rằng thực vật, sản phẩm thực vật hoặc vật thể thuộc diện kiểm dịch thực vật khác nêu trên đã được kiểm tra và/ hoặc thử nghiệm theo quy trình thích hợp và được coi là không có đối tượng kiểm dịch thực vật của nước nhập khẩu cũng như phù hợp với yeu cầu kiểm dịch thực vật hiện hành của người nhập khẩu
                    This is to certify that the plaints, plant products or other regulated articles described herein have been inspected and/or tested according to appropriate official procedures and are considered to be free from the quarantine pests, specified by the importing contracting party and to conform with the current phytosanitary requirements of the importing contracting party
                </td>
            </tr>
            <tr>
                <td colspan="16">
                    <p class="content t-bold t-center">
                        KHAI BÁO BỔ SUNG (ADDITIONAL DECLARATION)</p>
                    <p class="content">
                        <span  data-bind="text : fiKbbs" ></span> </p>
                </td>
            </tr>
            <tr>
                <td colspan="16">
                    <p class="content t-bold t-center">
                        XỬ LÝ (DISINFESTATION AND / OR DISINFECTION TREATMENT)
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <p class="content t-bold">
                        10. Ngày (DATE): </p>
                    <p class="content ">
                        <span  data-bind="date : fiNgay" ></span></p>

                </td>
                <td colspan="5">
                    <p class="content t-bold">
                        12. Tên thuốc (hoạt chất) </p>
                    <p class="content ">
                        CHEMICAL (active ingredient): 
                        <span  data-bind="text : fiTenthuoc" ></span></p>

                </td>
                <td colspan="6">
                    <p class="content t-bold">
                        14. Thời gian và nhiệt độ</p>
                    <p class="content ">
                        DURATION AND TEMPERATURE:
                        <span  data-bind="text :fiTgNd "></span></p>

                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <p class="content t-bold">
                        11. Phương pháp xử lý </p>
                    <p class="content ">(TREATMENT): 
                        <span  data-bind="text : fiTenPpxl" ></span></p>
                </td>
                <td colspan="5">
                    <p class="content t-bold">
                        13. Nồng độ </p>
                    <p class="content ">(CONCENTRATION): 
                        <span  data-bind="text : fiNongdo" ></span></p>
                </td>
                <td colspan="6">
                    <p class="content t-bold">
                        15. Thông tin thêm </p>
                    <p class="content ">(ADDITIONAL INFORMATION): 
                        <span  data-bind="text : fiTtThem" ></span></p>
                </td>
            </tr>
            <tr>
                <td colspan="5" rowspan="2">
                    <p class="content t-bold">
                        16. Dấu cơ quan </p>
                    <p class="content ">
                        STAMP OF ORGANIATION: </p>

                </td>
                <td colspan="5">
                    <p class="content t-bold">
                        17. Nơi cấp giấy:</p>
                    <p class="content ">
                        PALCE OF ISSSUE
                        <span  data-bind="text : fiNoicapgiay" ></span></p>

                </td>
                <td colspan="6" rowspan="2">
                    <p class="content t-bold">
                        19. Tên, chữ ký của cán bộ Kiểm dịch thực vật có thẩm quyền</p>
                    <p class="content ">
                        NAME AND SIGNATURE OF AUTHORIZED OFFICER
                        <span  data-bind="text : fiChucvuCb" ></span>
                        <span  data-bind="text : fiTenCb" ></span></p>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <p class="content t-bold">
                        18. Ngày cấp</p>
                    <p class="content ">
                        DATE ISSUED:
                        <span  data-bind="date : fiNgaycap" ></span></p>


                </td>
            </tr>
            <tr>
                <td colspan="16">
                    Cục Bảo vệ thực vật hoặc viên chức Kiểm dịch thực vật của Việt Nam không có trách nhiệm nào về mặt tài chính liên quan đến giấy chứng nhận này
                    No financial liability with respect to this certificate shall to Plant Protection department of Vietnam or to any of its officers or representatives
                </td>
            </tr>
        </tbody>
    </table>

    <div>
        <p class="content t-bold t-center">
            <br/><br/><br/>
            Attachment to Phytosanitary Certificate No: <span  data-bind="text : fiSoGcn" ></span>
        </p>
        <table width="100%">
            <thead>
                <tr>
                    <th>ITEM</th>
                    <th>DESCRIPTION OF GOODS</th>
                    <th>Botanical name	</th>
                    <th>NUMBER AND DESCRIPTION OF PACKAGES</th>
                    <th>quantity (KGS)</th>
                </tr>
            </thead>

            <tbody data-bind="template: { name: 'tbdhhgcn11Tmpl', foreach: tbdhhgcn11 }">
            </tbody>
            <script id="tbdhhgcn11Tmpl" type="text/html">
                <tr>
                    <td  class="t-center"  data-bind="text : fiStt"></td>
                    <td data-bind="text : fiTenHh"></td>
                    <td data-bind="text : fiTenKh"></td>
                    <td  class="t-center" >
                        <span data-bind="text : fiSoluong"></span>
                        <span data-bind="text : fiTendvSl"></span>
                    </td>
                    <td  class="t-center" >
                        <span data-bind="text : fiKhoiluong"></span>
                        <span data-bind="text : fiTendvKl"></span>
                    </td>
                </tr>
            </script>
            <tfoot>
                <tr>
                    <td></td>
                    <td class="t-bold t-center">Tổng số</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tfoot>
        </table>
    </div>
</page>
