/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMst = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiachiTsc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSdt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFax = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmail = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoGcnDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 50}
    });
    self.fiNgaycapDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoicapDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 50}
    });
    self.fiNguoiDaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 50}
    });
    self.fiNguoiLapbieu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 50}
    });
    self.fiNamdkNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 50}
    });
    self.fiNamX1 = ko.observable(null);


    self.fiNgaygui = ko.observable(null);
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSoVb = ko.observable(null);
    self.fiNgaycapVb = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });

    self.fiIdHosocha = ko.observable(null);
    self.fiLaHosotam = ko.observable(null);
    self.fiSolanYcsua = ko.observable(null);
    self.fiHauto = ko.observable(null);

    self.lstNguyenlieus = ko.observableArray(hosoInfo ? hosoInfo.lstNguyenlieus : []);
    self.lstDinhkems = ko.observableArray([]);

    self.lyDo = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 50}
    });

    self.visibleLyDoXinSua = ko.observable(false);

    //Danh muc
    self.lstLoaiNguyenlieu = ko.observableArray(mapCategory(options ? options.lstLoaiNguyenlieu : [], 'fiMaLnl', 'fiTenLnl'));
    self.lstTenNguyenlieu = ko.observableArray(mapCategory(options ? options.lstTenNguyenlieu : [], 'fiMaTnl', 'fiTenTnl'));


    var hosoVG = [self.fiTenDn, self.fiMst, self.fiDiachiTsc, self.fiSdt, self.fiEmail, self.fiSoGcnDk, self.fiNgaycapDk
                , self.fiNoicapDk, self.fiNguoiDaidien, self.fiNguoiLapbieu, self.fiNamdkNk];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHHMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMst(hoso !== null && hoso.hasOwnProperty('fiMst') ? hoso.fiMst : user.username);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSdt(hoso !== null && hoso.hasOwnProperty('fiSdt') ? hoso.fiSdt : user.companyPhoneNumber);
        self.fiFax(hoso !== null && hoso.hasOwnProperty('fiFax') ? hoso.fiFax : null);
        self.fiEmail(hoso !== null && hoso.hasOwnProperty('fiEmail') ? hoso.fiEmail : null);

        if (hoso !== null) {
            
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.fiSoGcnDk(hoso.hasOwnProperty('fiSoGcnDk') ? hoso.fiSoGcnDk : null);
            self.fiNoicapDk(hoso.hasOwnProperty('fiNoicapDk') ? hoso.fiNoicapDk : null);
            self.fiNgaycapDk(hoso.hasOwnProperty('fiNgaycapDk') ? new Date(hoso.fiNgaycapDk) : null);
            self.fiNguoiDaidien(hoso.hasOwnProperty('fiNguoiDaidien') ? hoso.fiNguoiDaidien : null);
            self.fiNguoiLapbieu(hoso.hasOwnProperty('fiNguoiLapbieu') ? hoso.fiNguoiLapbieu : null);
            self.fiNamdkNk(hoso.hasOwnProperty('fiNamdkNk') ? hoso.fiNamdkNk : null);
            self.fiNamX1(self.fiNamdkNk() != null ? self.fiNamdkNk() - 1 : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? hoso.fiNgaygui : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiSoVb(hoso.hasOwnProperty('fiSoVb') ? hoso.fiSoVb : null);
            self.fiNgaycapVb(hoso.hasOwnProperty('fiNgaycapVb') && hoso.fiNgaycapVb !=null  ? new Date(hoso.fiNgaycapVb) : null);

            self.fiIdHosocha(hoso.hasOwnProperty('fiIdHosocha') ? hoso.fiIdHosocha : null);
            self.fiLaHosotam(hoso.hasOwnProperty('fiLaHosotam') ? hoso.fiLaHosotam : null);
            self.fiSolanYcsua(hoso.hasOwnProperty('fiSolanYcsua') ? hoso.fiSolanYcsua : null);
            self.fiHauto(hoso.hasOwnProperty('fiHauto') ? hoso.fiHauto : null);

            self.lstNguyenlieus(mapTbdhsHanghoa5(hoso.hasOwnProperty('lstNguyenlieus') ? hoso.lstNguyenlieus : []));
            self.lstDinhkems(mapFilesVM(hoso.hasOwnProperty('lstDinhkems') ? hoso.lstDinhkems : [], self.fiIdHoso()));
            self.lyDo(hoso.hasOwnProperty('lyDo') ? hoso.lyDo : null);
        } else {
            self.lstDinhkems(mapFilesVM(options.lstDinhkems, self.fiIdHoso()));
        }
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorHH = true;
        var errorDinhkem = true;

        if (self.visibleLyDoXinSua()) {
            if (!self.lyDo()) {
                app.Alert('Bạn phải nhập vào lý do xin sửa hồ sơ!');
                return false;
            }
        }

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        //Kiem tra thong tin HH
        if (!self.lstNguyenlieus() || self.lstNguyenlieus().length <= 0) {
            self.errorHHMessage('* Chưa khai báo thông tin hàng hoá');
            errorHH = false;
            return errorHH;
        }

        if (self.lstNguyenlieus() && self.lstNguyenlieus().length > 0) {
            for (var i = 0; i < self.lstNguyenlieus().length; i++) {
                var nguyenLieu = self.lstNguyenlieus()[i];
                if (!nguyenLieu.fiLoaiNguyenlieu() || !nguyenLieu.fiMaNguyenlieu()
                        || !nguyenLieu.fiTenNguyenlieu() || !nguyenLieu.fiDangkyNhapkhauNamx1() || !nguyenLieu.fiSoluongCapX1()
                        || !nguyenLieu.fiUocThuchienX1() || !nguyenLieu.fiDangkyNhapkhauNamx()) {
                    errorHH = false;
                    break;
                } else if ((nguyenLieu.fiLoaiNguyenlieu()).charAt(0) != (nguyenLieu.fiMaNguyenlieu()).charAt(0)) {
                    self.errorHHMessage('Hàng ' + (i + 1) + ' Tên nguyên liệu và loại nguyên liệu không tương thích');
                    errorHH = false;
                    return errorHH;
                }
            }
        }

        if (!errorHH) {
            self.errorHHMessage('* Bổ sung thêm thông tin của Hàng hoá trước khi lưu dữ liệu');
            return errorHH;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhkems() || self.lstDinhkems().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        } else {
            self.errorDinhKemMessage(null);
        }

        if (self.lstDinhkems() && self.lstDinhkems().length > 0) {
            for (var i = 0; i < self.lstDinhkems().length; i++) {
                var attach = self.lstDinhkems()[i];
                if (attach.isRequire()) {
                    if (!attach.fiGuiid() || !attach.fiTenTep() || !attach.fiDuongDan()) {
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return errorHoso && errorHH && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeHangHoaOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hoá này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstNguyenlieus.remove(function (o) {
                                return o.fiIdHh() == item.fiIdHh();
                            });
                            for (var i = 0; i < self.lstNguyenlieus().length; i++) {
                                self.lstNguyenlieus()[i].fiStt(i + 1);
                            }
                            app.popupRemove(pop.selector);
                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }
    };
    self.addHangHoaOnClick = function () {
        var item = new TbdhsHanghoa5({
            fiStt: self.lstNguyenlieus().length + 1,
            fiIdHh: -1 * new Date().getTime()
        });
        self.lstNguyenlieus.push(item);
        for (var i = 0; i < self.lstNguyenlieus().length; i++) {
            self.lstNguyenlieus()[i].fiStt(i + 1);
        }
        $("#fiLoaiNguyenlieu-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaNguyenlieu-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.setFiNamX = function () {
        if (self.fiNamdkNk()) {
            self.fiNamX1(self.fiNamdkNk() - 1);
        }
    }
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            ignore: ['removeHangHoaOnClick', 'addHangHoaOnClick', 'isValidForm', 'init',
                'hosoErrors', 'errorHHMessage', 'toJSON', '__ko_mapping__', 'errorHHMessage',
                'errorDinhKemMessage', 'pop', 'lstMaHS', 'visibleLyDoXinSua']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        for (var i = 0; i < copy.lstDinhkems.length; i++) {
            delete copy.lstDinhkems[i]['canUpload'];
            delete copy.lstDinhkems[i]['canDownload'];
            delete copy.lstDinhkems[i]['canDelete'];
            delete copy.lstDinhkems[i]['doUpload'];
            delete copy.lstDinhkems[i]['doDelete'];
            delete copy.lstDinhkems[i]['downloadUrl'];
            delete copy.lstDinhkems[i]['fiBatBuoc'];
            delete copy.lstDinhkems[i]['isRequire'];
            delete copy.lstDinhkems[i]["__ko_mapping__"];
        }

        delete copy['__ko_mapping__'];
        return copy;
    };
}

