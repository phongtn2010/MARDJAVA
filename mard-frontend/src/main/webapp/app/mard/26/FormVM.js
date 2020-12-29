/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MAX_PAGE_SIZE=15;
function HangHoaVM(options) {
    // var hanghoa26Sefl = this;
    //
    // hanghoa26Sefl.lstHangHoaChosen = ko.observableArray([]);
    // hanghoa26Sefl.errorMsg = ko.observable(null);
    // hanghoa26Sefl.lstProductList = ko.observableArray([]);
    //
    // hanghoa26Sefl.size = ko.observable(MAX_PAGE_SIZE);
    // hanghoa26Sefl.searchFieldEnter = function(){
    //
    // };
    // hanghoa26Sefl.sortBy = ko.observable("fiMaHoso");
    // hanghoa26Sefl.order = ko.observable("desc");
    // hanghoa26Sefl.pagination = ko.observable(new PagingVM({
    //     pageSize: MAX_PAGE_SIZE,
    //     totalCount: 0,
    //     currentPage: 1
    // }));
    //
    // hanghoa26Sefl.currentPage = ko.observable(1);
    //
    // hanghoa26Sefl.pagination().currentPage.subscribe(function (newCurrentPage) {
    //     hanghoa26Sefl.currentPage(newCurrentPage);
    //     hanghoa26Sefl.searchHoso(newCurrentPage);
    // })
    // hanghoa26Sefl.searchHoSoClick = function () {
    //     hanghoa26Sefl.searchHoso(0, true);
    // };
    // hanghoa26Sefl.onChoose =function (item) {
    //     if(hanghoa26Sefl.lstHangHoaChosen().length>0 && item.isSelected()){
    //         app.Alert("Bạn chỉ được chọn duy nhất một hàng hóa.");
    //         return;
    //     }
    //     if (item.isSelected()){
    //         item.isSelected(false);
    //         item.label('Bỏ chọn');
    //         hanghoa26Sefl.lstHangHoaChosen.push(item);
    //     }else{
    //         item.isSelected(true);
    //         item.label('Chọn');
    //         hanghoa26Sefl.lstHangHoaChosen.splice(item,1);
    //     }
    //
    // }

}

function FormVM(options) {
    var form26Sefl =this;
    form26Sefl.fiTbdHoso26 = ko.observable((options && options.hasOwnProperty('fiTbdHoso26')) ? options.fiTbdHoso26 :null);
    if(isCopy &&form26Sefl.fiTbdHoso26()){
        console.log(isCopy);
        console.log(form26Sefl.fiTbdHoso26());
        form26Sefl.fiTbdHoso26().fiIdHoSo26=null;
        form26Sefl.fiTbdHoso26().fiMaHoso=null;
        form26Sefl.fiTbdHoso26().fiTrangthai=0;
        form26Sefl.fiTbdHoso26().fiNgaytao=new Date();
        ko.utils.arrayForEach(form26Sefl.fiTbdHoso26().fiProductList, function(product) {

            product.isSelected = ko.observable(false);
            product.label = ko.observable('Bỏ chọn');
            product.fiIdHH26=null;
            var getLstCL = product.fiProCLList;
            var getLstAT = product.fiProATList;
            var getLstSLKL = product.fiProSLKLList;
            product.fiTrangThaiHangHoa =ko.observable(null);
            // form26Sefl.lstHanghoa=ko.observableArray(product);
            for (var j =0;j<getLstCL.length;j++){
                getLstCL[j].fiIdHH26=null;
                getLstCL[j].fiIdCL26=null;
            }
            for (var j =0;j<getLstAT.length;j++){
                getLstAT[j].fiIdHH26=null;
                getLstAT[j].fiIdAT26=null;
            }
            for (var j =0;j<getLstSLKL.length;j++){
                getLstSLKL[j].fiIdHH26=null;
                getLstSLKL[j].fiIdSLKL26=null;
            }
        });

    }
    // form26Sefl.hangHoa26VM = ko.observable(new HangHoaVM());
    form26Sefl.lstHanghoa = ko.observableArray(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiProductList :[]);
    console.log(form26Sefl.lstHanghoa());
    form26Sefl.errorHangHoaMessage = ko.observable(null);
    form26Sefl.fiIdHoso = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiIdHoSo26 :null);
    form26Sefl.fiMaHoso = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiMaHoso :null);
    form26Sefl.fiMstDn = ko.observable(hosoUsername).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });

    form26Sefl.fiTenDn = ko.observable(hosoCompanyName).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    form26Sefl.fiDiachiDn = ko.observable(hosoCompanyAddress).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    form26Sefl.fiSdtDn = ko.observable(hosoCompanyPhoneNumber).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    form26Sefl.fiFaxDn = ko.observable(hosoCompanyFax).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    form26Sefl.fiEmailDn = ko.observable(hosoCompanyEmail).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50},
        email: {message: 'Email không đúng định dạng', params: true}
    });

    form26Sefl.fiNgayKy = ko.observable(form26Sefl.fiTbdHoso26()  ? new Date(form26Sefl.fiTbdHoso26().fiNgayKy) :new Date()).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    form26Sefl.fiDiadiemKy = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiDiadiemKy :null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    form26Sefl.fiNguoiKy = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiNguoiKy :null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    form26Sefl.fiNgaygui = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiNgaygui :null);
    form26Sefl.fiHoatdong = ko.observable(1);
    form26Sefl.fiNguoitao = ko.observable(hosoUsername);
    form26Sefl.fiNgaytao = ko.observable(form26Sefl.fiTbdHoso26()  ? new Date(form26Sefl.fiTbdHoso26().fiNgaytao) :new Date());
    form26Sefl.fiNgCapnhat = ko.observable(null);
    form26Sefl.fiTrangthai = ko.observable(form26Sefl.fiTbdHoso26()  ? form26Sefl.fiTbdHoso26().fiTrangthai :0);
    form26Sefl.fiTenTt = ko.observable(null);

    form26Sefl.fiSoCv = ko.observable(null);
    form26Sefl.fiNgaycapCv = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });
    //hang hoa


    form26Sefl.lstHangHoaChosen = ko.observableArray([]);
    form26Sefl.errorMsg = ko.observable(null);
    form26Sefl.lstProductList = ko.observableArray([]);

    form26Sefl.size = ko.observable(MAX_PAGE_SIZE);
    form26Sefl.searchFieldEnter = function(){

    };
    form26Sefl.sortBy = ko.observable("fiMaHoso");
    form26Sefl.order = ko.observable("desc");
    form26Sefl.pagination = ko.observable(new PagingVM({
        pageSize: MAX_PAGE_SIZE,
        totalCount: 0,
        currentPage: 1
    }));

    form26Sefl.currentPage = ko.observable(1);

    form26Sefl.pagination().currentPage.subscribe(function (newCurrentPage) {
        form26Sefl.currentPage(newCurrentPage);
        form26Sefl.searchHangHoa(newCurrentPage);
    })
    form26Sefl.searchHoSoClick = function () {
        form26Sefl.searchHoso(0, true);
    };
    form26Sefl.onChoose =function (item) {
        if(form26Sefl.lstHangHoaChosen().length>0 && item.isSelected()){
            app.Alert("Bạn chỉ được chọn duy nhất một hàng hóa.");
            return;
        }
        if (item.isSelected()){
            item.isSelected(false);
            item.label('Bỏ chọn');
            form26Sefl.lstHangHoaChosen.push(item);
        }else{
            item.isSelected(true);
            item.label('Chọn');
            form26Sefl.lstHangHoaChosen.splice(item,1);
        }

    }

    form26Sefl.closePopup  =function () {
        $("#modal_add_hanghoa").modal('hide');
    }
    form26Sefl.addHangHoa  =function () {
        form26Sefl.lstHanghoa(form26Sefl.lstHangHoaChosen());
        form26Sefl.lstHangHoaChosen([]);
        $("#modal_add_hanghoa").modal('hide');
    }
    form26Sefl.removeProductClick =function (item) {
        form26Sefl.lstHanghoa.splice(item,1)
    }
    form26Sefl.addProductOnClick = function (page){
        // console.log(page);
        if(form26Sefl.lstHanghoa().length>0){
            form26Sefl.pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn đã chọn 1 hàng hóa trước đó, bạn có chắc chắn muốn chọn lại?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            app.popupRemove(form26Sefl.pop.selector);
                            form26Sefl.lstHanghoa([]);
                            form26Sefl.lstHangHoaChosen([]);
                            form26Sefl.searchHangHoa(page,true);

                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(form26Sefl.pop.selector);
                        }
                    }
                ]
            });
        }else{
            form26Sefl.lstHangHoaChosen([]);
            form26Sefl.searchHangHoa(page,true);
            console.log(form26Sefl.lstProductList());
            $("#modal_add_hanghoa").modal("show");
        }
    }
    form26Sefl.searchHangHoa =function(page){
        var filter ={
            page: page,
            size: MAX_PAGE_SIZE
        }
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/26/hanghoa/getlist",
            data: JSON.stringify(filter),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                if (res.success) {
                    console.log(res.data);
                    var list = res.data ? res.data.data : [];
                    ko.utils.arrayForEach(list, function(product) {
                        product.isSelected = ko.observable(true);
                        product.label = ko.observable('Chọn');
                    });
                    form26Sefl.lstProductList(list);
                    form26Sefl.pagination().update({
                        totalCount: res.data.total,
                        pageSize: MAX_PAGE_SIZE,
                        currentPage: 1
                    });
                    $("#modal_add_hanghoa").modal("show");
                }else{
                    app.Alert("Có lỗi xảy ra: "+res.message);
                }
            },
            error: function (err) {
                app.Alert("Có lỗi xảy ra: "+err);
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
                window.stateChanging = false;
            }
        });

    }
    form26Sefl.getData = function () {
        var item={
            fiIdHoSo26:form26Sefl.fiIdHoso(),
            fiMaHoso:form26Sefl.fiMaHoso(),
            fiTrangthai:form26Sefl.fiTrangthai(),
            fiNgaytao:form26Sefl.fiNgaytao(),
            fiTenDn:form26Sefl.fiTenDn(),
            fiDiachiDn:form26Sefl.fiDiachiDn(),
            fiSdtDn:form26Sefl.fiSdtDn(),
            fiFaxDn:form26Sefl.fiFaxDn(),
            fiEmailDn:form26Sefl.fiEmailDn(),
            fiNguoiKy:form26Sefl.fiNguoiKy(),
            fiNgayKy:form26Sefl.fiNgayKy(),
            fiDiadiemKy:form26Sefl.fiDiadiemKy(),
            fiProductList:form26Sefl.lstHanghoa(),
            fiMasothue:hosoUsername,
        }
        console.log(item);
        return item;
    }
    // form26Sefl.applyStates =function () {
    //     app.makeGet({
    //         url: '/mard/26/hanghoa/getlist?taxCode='+hosoUsername,
    //         success: function (res) {
    //             if (res.success) {
    //                 ko.utils.arrayForEach(res.data, function(product) {
    //                     product.isSelected = ko.observable(true);
    //                     product.label = ko.observable('Chọn');
    //
    //                 });
    //                 form26Sefl.hangHoa26VM().lstProductList(res.data);
    //             }
    //         },
    //         error: function (e) { }
    //     });
    // };
    form26Sefl.validateHoso= function () {
        if (form26Sefl.lstHanghoa().length<1){
            app.Alert("Bạn chưa nhập hàng hóa");
            return false;
        }
        var check = [form26Sefl.fiNguoiKy,form26Sefl.fiDiadiemKy];
        form26Sefl.errors = ko.validation.group({check}, {deep: true, live: true, observable: true});
        if (form26Sefl.errors().length > 0) {
            form26Sefl.errors.showAllMessages();
            app.Alert("Bạn cần nhập đầy đủ các trường bắt buộc");
            return false;
        }
        return true;
    }
}

