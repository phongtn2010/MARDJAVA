/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function HangHoaVM(options) {
    var hanghoa26Sefl = this;
    hanghoa26Sefl.previousPageActive = ko.observable(null);

    hanghoa26Sefl.currentPage = ko.observable(null);
    hanghoa26Sefl.totalCount = ko.observable(null);
    hanghoa26Sefl.paging = ko.observable(null);

    hanghoa26Sefl.nextPageActive = ko.observable(null);
    hanghoa26Sefl.lastPageActive = ko.observable(null);
    hanghoa26Sefl.firstPageActive = ko.observable(null);
    hanghoa26Sefl.lstHangHoaChosen = ko.observableArray([]);
    hanghoa26Sefl.errorMsg = ko.observable(null);
    hanghoa26Sefl.lstProductList = ko.observableArray([]);

    hanghoa26Sefl.goToFirst =function () {

    }
    hanghoa26Sefl.goToLast =function () {

    }
    hanghoa26Sefl.goToNext =function () {

    }
    hanghoa26Sefl.goToPrevious  =function () {

    }
    hanghoa26Sefl.onChoose =function (item) {

        if (item.isSelected()){
            item.isSelected(false);
            item.label('Bỏ chọn');
            hanghoa26Sefl.lstHangHoaChosen.push(item);
        }else{
            item.isSelected(true);
            item.label('Chọn');
            hanghoa26Sefl.lstHangHoaChosen.splice(item,1);
        }
    }

}

function FormVM(options) {
    var form26Sefl =this;
    form26Sefl.hangHoa26VM = ko.observable(new HangHoaVM());
    form26Sefl.lstHanghoa = ko.observableArray((options && options.hasOwnProperty('lstHanghoa')) ? options.lstHanghoa :[]);
    form26Sefl.errorHangHoaMessage = ko.observable(null);
    form26Sefl.fiIdHoso = ko.observable(null);
    form26Sefl.fiMaHoso = ko.observable(null);
    form26Sefl.fiMstDn = ko.observable(null).extend({
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

    form26Sefl.fiNgayKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    form26Sefl.fiDiadiemKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    form26Sefl.fiNguoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    form26Sefl.fiNgaygui = ko.observable(null);
    form26Sefl.fiHoatdong = ko.observable(1);
    form26Sefl.fiNguoitao = ko.observable(null);
    form26Sefl.fiNgaytao = ko.observable(new Date());
    form26Sefl.fiNgCapnhat = ko.observable(null);
    form26Sefl.fiTrangthai = ko.observable(0);
    form26Sefl.fiTenTt = ko.observable(null);

    form26Sefl.fiSoCv = ko.observable(null);
    form26Sefl.fiNgaycapCv = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });

    form26Sefl.closePopup  =function () {
        $("#modal_add_hanghoa").modal('hide');
    }
    form26Sefl.addHangHoa  =function () {
        form26Sefl.lstHanghoa(form26Sefl.hangHoa26VM().lstHangHoaChosen());
        $("#modal_add_hanghoa").modal('hide');
    }
    form26Sefl.removeProductClick =function (item) {
        form26Sefl.lstHanghoa.splice(item,1)
    }
    form26Sefl.addProductOnClick = function (){
        app.makeGet({
            url: '/mard/26/hanghoa/getlist?taxCode='+hosoUsername,
            success: function (res) {
                if (res.success) {
                    ko.utils.arrayForEach(res.data, function(product) {
                        product.isSelected = ko.observable(true);
                        product.label = ko.observable('Chọn');
                        product.fiIdHS = ko.observable(null);
                        product.fiIdProduct = ko.observable(null);
                        ko.utils.arrayForEach(product.fiProCLList, function(cl) {
                            cl.fiIdProCL=ko.observable(null);
                            cl.fiIdProduct=ko.observable(null);
                        });
                        ko.utils.arrayForEach(product.fiProATList, function(at) {
                            at.fiIdProAT=ko.observable(null);
                            at.fiIdProduct=ko.observable(null);
                        });
                        ko.utils.arrayForEach(product.fiProSLKLList, function(at) {
                            at.fiIdProSLKL=ko.observable(null);
                            at.fiIdProduct=ko.observable(null);
                        });
                    });
                    form26Sefl.hangHoa26VM().lstProductList(res.data);
                }
            },
            error: function (e) { }
        });

    }
    form26Sefl.getData = function () {
        var item={
            fiIdHoso:form26Sefl.fiIdHoso(),
            fiMaHoso:form26Sefl.fiMaHoso(),
            fiHSStatus:form26Sefl.fiTrangthai(),
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
        return item;
    }
}

