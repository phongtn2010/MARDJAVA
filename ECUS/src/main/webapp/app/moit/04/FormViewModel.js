/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function TbdHanghoaVM(options) {
    var self = this;
    var item = options ? options : null;
    var hangHoaData = item.hangHoa;

    self.fiIdHh = ko.observable(hangHoaData ? hangHoaData.fiIdHh() : null);
    self.fiIdHoso = ko.observable(hangHoaData ? hangHoaData.fiIdHoso() : null);

    self.fiMaNhomHh = ko.observable(hangHoaData ? hangHoaData.fiMaNhomHh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenNhomHh = ko.observable(hangHoaData ? hangHoaData.fiTenNhomHh() : null);
    
    self.fiTenHh = ko.observable(hangHoaData ? hangHoaData.fiTenHh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiSoDk = ko.observable(hangHoaData ? hangHoaData.fiSoDk() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    self.fiSoHieuTc = ko.observable(hangHoaData ? hangHoaData.fiSoHieuTc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    self.fiTpHlHchat = ko.observable(hangHoaData ? hangHoaData.fiTpHlHchat() : null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        //maxLength: {message: 'Tối đa 3 ký tự, bao gồm cả dấu .', params: 3},
        pattern: { message: 'Bạn phải nhập giá trị với tối đa là 2 số ở phần nguyên và 2 số ở phần thập phân, ví dụ: 10.2', params: /^\d{1,2}\.\d{1,2}$/}
    });

    self.fiMaQgNk = ko.observable(hangHoaData ? hangHoaData.fiMaQgNk() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenQgNk = ko.observable(hangHoaData ? hangHoaData.fiTenQgNk() : null);
    self.fiNgaytao = ko.observable(hangHoaData ? hangHoaData.fiNgaytao() : null);
    self.fiHoatdong = ko.observable(hangHoaData ? hangHoaData.fiHoatdong() : null);
    self.fiNguoitao = ko.observable(hangHoaData ? hangHoaData.fiNguoitao() : null);
    self.fiGhiChu = ko.observable(hangHoaData ? hangHoaData.fiGhiChu() : null);
    self.fiMaql = ko.observable(hangHoaData ? hangHoaData.fiMaql() : null);
    self.stt = ko.observable(hangHoaData ? hangHoaData.stt() : null);

    self.lstNhomHangHoa = ko.observableArray(item ? item.lstNhomHangHoa : []);
    self.lstQuocGia = ko.observableArray(item ? item.lstQuocGia : []);

    var lstVG = [self.fiMaNhomHh, self.fiTenHh, self.fiSoDk, self.fiSoHieuTc,self.fiTpHlHchat, self.fiMaQgNk];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.reset = function () {
        self.lstErrors.showAllMessages(false);
        self.fiIdHh(null);
        self.fiMaNhomHh(null);
        self.fiTenHh(null);
        self.fiSoDk(null);
        self.fiSoHieuTc(false);
        self.fiTpHlHchat(null);
        self.fiIdHoso(null);
        self.fiMaQgNk(null);
        self.fiTenQgNk(null);
        self.fiNgaytao(null);
        self.fiHoatdong(null);
        self.fiNguoitao(null);
        self.fiGhiChu(null);
        self.fiMaql(null);
    };
}

function Most04FormVM(options)
{
    var self = this;

    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiDtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiWebsiteDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });    
    self.fiNguoiDd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiChucVu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiIdHosocha = ko.observable(null);
    self.fiLaHosotam = ko.observable(null);
    self.fiDsMaNhomHH = ko.observable(null);
    self.fiDsTenNhomHH = ko.observable(null);
    self.fiLydoXinsua = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    self.tepDinhKems = ko.observableArray(null);
    self.hangHoas = ko.observableArray(null);
    
    self.lstNhomHangHoa = ko.observableArray(options ? options.lstNhomHangHoa : []);
    self.lstQuocGia = ko.observableArray(options ? options.lstQuocGia : []);

    self.errorHanghoaText = ko.observable(null);

    var hosoVG = [self.fiTenDn, self.fiMstDn, self.fiDiachiDn,
        self.fiDtDn, self.fiFaxDn, self.fiEmailDn, self.fiNguoiDd, self.fiChucVu];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});

    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiDtDn(hoso !== null && hoso.hasOwnProperty('fiDtDn') ? hoso.fiDtDn : user.companyPhoneNumber);        
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : user.companyFax);
        self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : user.companyEmail);
        self.fiWebsiteDn(hoso !== null && hoso.hasOwnProperty('fiWebsiteDn') ? hoso.fiWebsiteDn : null);
        self.fiNguoiDd(hoso !== null && hoso.hasOwnProperty('fiNguoiDd') ? hoso.fiNguoiDd : null);
        self.fiChucVu(hoso !== null && hoso.hasOwnProperty('fiChucVu') ? hoso.fiChucVu : null);

        if (hoso !== null) {
            self.hangHoas(hoso.hangHoas ? ListTbdhanghoaModel(hoso.hangHoas) : null);
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiLydoXinsua(hoso.hasOwnProperty('fiLydoXinsua') ? hoso.fiLydoXinsua : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? hoso.fiNgaytao : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiDsMaNhomHH(hoso.hasOwnProperty('fiDsMaNhomHH') ? hoso.fiDsMaNhomHH : null);
            self.fiDsTenNhomHH(hoso.hasOwnProperty('fiDsTenNhomHH') ? hoso.fiDsTenNhomHH : null);
        }
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    self.isValidForm = function () {
        delete self.hanghoaVM;
        delete self.popup;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }
        
        if (self.fiTrangthai() === STATUS_DA_TIEP_NHAN 
                || self.fiTrangthai() === STATUS_DA_BO_SUNG
                || self.fiTrangthai() === STATUS_DONG_Y_YC_XIN_SUA
                || self.fiTrangthai() === STATUS_TU_CHOI_YC_XIN_SUA) {
            if (self.fiLydoXinsua() === null || self.fiLydoXinsua() === '') {
                app.Alert('Bạn phải nhập vào lý do sửa hồ sơ.');
                $('#fiLydoXinsua').focus();
                return false;
            }
        }

        var errorHanghoa = false;
        if (!self.hangHoas() || self.hangHoas().length <= 0) {
            self.errorHanghoaText('* Chưa khai báo hàng hóa');
            return errorHanghoa;
        }
        
        if (self.hangHoas() && self.hangHoas().length > 0) {
            for (var i = 0; i < self.hangHoas().length; i++) {
                var hh = self.hangHoas()[i];
                if (!hh.fiMaNhomHh() || !hh.fiTenHh() || !hh.fiSoDk() || !hh.fiSoHieuTc()) {
                    errorHanghoa = true;
                    break;
                }
            }
        }

        if (errorHanghoa) {
            self.errorHanghoaText('* Bổ sung thêm thông tin của hàng hóa trước khi lưu dữ liệu');
        }

        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE   

    self.bThemMoiHangHoa = function () {
        self.showHangHoaPopup(null);
    };

    self.bSuaHangHoaClick = function (d) {
        self.showHangHoaPopup(d);
    };

    self.bXoaHangHoaClick = function (item) {
        if (item) {
            self.hangHoas.remove(function (hh) {
                return hh.fiIdHh() === item.fiIdHh();
            });
        }
    };

    //XU LY SU KIEN BUTTON, TABLE

    //HAM XU LY
    self.afterImportExcel = function (data) {
        if (!data) {
            return;
        }
        self.init(data);
    };

    self.showHangHoaPopup = function (d) {
        delete self.popup;
        delete self.hanghoaVM;

        var html = [
            $('#hanghoa-template').html()
        ].join('');
        var data = {
            lstQuocGia: self.lstQuocGia(),
            lstNhomHangHoa: self.lstNhomHangHoa(),
            hangHoa: d
        };

        self.hanghoaVM = new TbdHanghoaVM(data);

        self.popup = app.popup({
            title: 'Thêm mới hàng hoá',
            html: html,
            width: 650,
            buttons: [
                {
                    name: NSWLang["common_button_luu"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (!self.hanghoaVM.isValidForm()) {
                            return;
                        }
                        var mapping = {
                            'ignore': ['lstErrors', 'lstQuocGia', 'lstNhomHangHoa', 'isValidForm',
                                'reset', '__ko_mapping__']
                        };

                        var hanghoaItem = ko.mapping.fromJS(self.hanghoaVM, mapping);
                        
                        hanghoaItem.fiTenNhomHh($('#fiMaNhomHh option:selected').text());
                        hanghoaItem.fiTenQgNk($('#fiMaQgNk option:selected').text());

                        //Them moi hang hoa
                        if (self.hanghoaVM.fiIdHh() === null || self.hanghoaVM.fiIdHh() === "") {
                            hanghoaItem.stt(self.hangHoas().length + 1);
                            hanghoaItem.fiIdHh(-1 * new Date().getTime());
                            self.hangHoas.push(hanghoaItem);
                        } else {//Cap nhat hang hoa
                            var oldItem = ko.utils.arrayFirst(self.hangHoas(), function (item) {
                                return item.fiIdHh() === hanghoaItem.fiIdHh();
                            });

                            if (oldItem) {
                                oldItem.fiIdHh(hanghoaItem.fiIdHh());
                                oldItem.fiIdHoso(hanghoaItem.fiIdHoso());                                
                                oldItem.fiMaNhomHh(hanghoaItem.fiMaNhomHh());
                                oldItem.fiTenNhomHh(hanghoaItem.fiTenNhomHh());
                                oldItem.fiTenHh(hanghoaItem.fiTenHh());
                                oldItem.fiSoDk(hanghoaItem.fiSoDk());
                                oldItem.fiSoHieuTc(hanghoaItem.fiSoHieuTc());
                                oldItem.fiTpHlHchat(hanghoaItem.fiTpHlHchat());
                                oldItem.fiMaQgNk(hanghoaItem.fiMaQgNk());
                                oldItem.fiTenQgNk(hanghoaItem.fiTenQgNk());
                                oldItem.fiNgaytao(hanghoaItem.fiNgaytao());
                                oldItem.fiHoatdong(hanghoaItem.fiHoatdong());
                                oldItem.fiNguoitao(hanghoaItem.fiNguoitao());
                                oldItem.fiGhiChu(hanghoaItem.fiGhiChu());
                                oldItem.fiMaql(hanghoaItem.fiMaql());
                                oldItem.stt(hanghoaItem.stt());
                            }
                        }
                        app.popupRemove(self.popup.selector);
                    }
                }
            ]
        }, function (popup) {
            ko.applyBindings(self.hanghoaVM, document.getElementById('hanghoa-form'));
        });
    };

    self.toJSON = function () {
        var mapping = {
            'ignore': ["lstNhomHangHoa", "lstQuocGia", "errorHanghoaText",
                "hosoErrors", "isValidForm", "bThemMoiHangHoa", "bSuaHangHoaClick", "bXoaHangHoaClick", 
                "showHangHoaPopup", "toJSON", "hanghoaVM", "popup", "__ko_mapping__", 'afterImportExcel']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        if (copy.hangHoas && copy.hangHoas.length > 0) {
            for (var i = 0; i < copy.hangHoas.length; i++) {
                delete copy.hangHoas[i]["bSua"];
                delete copy.hangHoas[i]["bXoa"];
                delete copy.hangHoas[i]["stt"];
                delete copy.hangHoas[i]["__ko_mapping__"];
            }
        }
        
        delete copy['__ko_mapping__'];
        return copy;
    };
}
