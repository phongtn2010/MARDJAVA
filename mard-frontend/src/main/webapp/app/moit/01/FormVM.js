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
    self.fiWeb = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiSoGcnDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNgaycapDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoicapDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });


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

    self.lstHanghoas = ko.observableArray(hosoInfo ? hosoInfo.lstHanghoas : []);
    self.lstDinhkems = ko.observableArray([]);

    self.lyDo = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    self.visibleLyDoXinSua = ko.observable(false);

    //Danh muc
    debugger;
    self.lstMaHS = ko.observableArray(mapCategory(options ? options.lstMaHS : [], 'fiMaHs', 'fiTenHh'));

    var hosoVG = [self.fiTenDn, self.fiMst, self.fiDiachiTsc, self.fiSdt, self.fiSoGcnDk, self.fiNgaycapDk
                , self.fiNoicapDk];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHHMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        debugger;
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMst(hoso !== null && hoso.hasOwnProperty('fiMst') ? hoso.fiMst : user.username);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSdt(hoso !== null && hoso.hasOwnProperty('fiSdt') ? hoso.fiSdt : user.companyPhoneNumber);
        self.fiFax(hoso !== null && hoso.hasOwnProperty('fiFax') ? hoso.fiFax : null);
        self.fiWeb(hoso !== null && hoso.hasOwnProperty('fiWeb') ? hoso.fiWeb : null);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.fiSoGcnDk(hoso.hasOwnProperty('fiSoGcnDk') ? hoso.fiSoGcnDk : null);
            self.fiNoicapDk(hoso.hasOwnProperty('fiNoicapDk') ? hoso.fiNoicapDk : null);
            self.fiNgaycapDk(hoso.hasOwnProperty('fiNgaycapDk') ? new Date(hoso.fiNgaycapDk) : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? hoso.fiNgaygui : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiSoVb(hoso.hasOwnProperty('fiSoVb') ? hoso.fiSoVb : null);
            self.fiNgaycapVb(hoso.hasOwnProperty('fiNgaycapVb') && hoso.fiNgaycapVb != null ? new Date(hoso.fiNgaycapVb) : null);

            self.fiIdHosocha(hoso.hasOwnProperty('fiIdHosocha') ? hoso.fiIdHosocha : null);
            self.fiLaHosotam(hoso.hasOwnProperty('fiLaHosotam') ? hoso.fiLaHosotam : null);
            self.fiSolanYcsua(hoso.hasOwnProperty('fiSolanYcsua') ? hoso.fiSolanYcsua : null);
            self.fiHauto(hoso.hasOwnProperty('fiHauto') ? hoso.fiHauto : null);
            self.lstHanghoas(mapTbdhsHanghoa1(hoso.hasOwnProperty('lstHanghoas') ? hoso.lstHanghoas : []));
            self.lstDinhkems(mapFilesVM(hoso.hasOwnProperty('lstDinhkems') ? hoso.lstDinhkems : [], self.fiIdHoso()));
            self.lyDo(hoso.hasOwnProperty('lyDo') ? hoso.lyDo : null);
        } else {
            self.lstDinhkems(mapFilesVM(options.lstDinhkems, self.fiIdHoso()));
        }

    };

    self.init(hosoInfo);

    self.validNgayCap = function () {
        if (self.fiNgaycapDk() === null)
            $("#fiNgaycapDk-lbl").show();
        else
            $("#fiNgaycapDk-lbl").hide();
    }

    self.validLyDo = function () {
        if (!self.lyDo()) {
            $("#msg_valid_lydo").show();
        } else {
            $("#msg_valid_lydo").hide();
        }
    }

    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorHH = true;
        var errorDinhkem = true;

        //show msg ngay cap
        self.validNgayCap();


        if (self.visibleLyDoXinSua()) {
            if (!self.lyDo()) {
//                app.Alert('Bạn phải nhập vào lý do xin sửa hồ sơ!');
                $("#msg_valid_lydo").show();
                return false;
            } else {
                $("#msg_valid_lydo").hide();
            }
        }

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        //Kiem tra thong tin HH
        if (!self.lstHanghoas() || self.lstHanghoas().length <= 0) {
            self.errorHHMessage('* Chưa khai báo thông tin hàng hoá');
            errorHH = false;
            return errorHH;
        } else {
            self.errorHHMessage('');
        }

        if (self.lstHanghoas() && self.lstHanghoas().length > 0) {
            for (var i = 0; i < self.lstHanghoas().length; i++) {
                var xe = self.lstHanghoas()[i];
                if (!xe.fiMaHs() || !xe.fiTenHh()) {
                    $('#Hanghoaserror').show();
                    errorHH = false;
                    break;
                }
            }
        }

        if (!errorHH) {
            self.errorHHMessage('* Bổ sung thêm thông tin của Hàng hoá trước khi lưu dữ liệu');
            return errorHH;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhkems() || self.lstDinhkems().length <= 0) {
            $("#msg-file-valid").show();
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
            $("#msg-file-valid").show();
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
                            self.lstHanghoas.remove(function (o) {
                                return o.fiIdHh() == item.fiIdHh();
                            });
                            for (var i = 0; i < self.lstHanghoas().length; i++) {
                                self.lstHanghoas()[i].fiStt(i + 1);
                            }
                            //tamdt
                            if (self.lstHanghoas().length === 0) {
                                self.errorHHMessage('* Chưa khai báo thông tin hàng hoá');
                                $('#Hanghoaserror').show();
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
    self.valueLoai = function () {
        var flag = true;
        var hhSize = self.lstHanghoas().length;
        if (hhSize > 0) {
            var objLast = self.lstHanghoas()[hhSize - 1];
            debugger;
            if (objLast.fiMaHs() != null) {
                $('#valueDVErroor_' + hhSize).hide();
            }
            if (objLast.fiTenHh() != null) {
                $('#itErroor_' + hhSize).hide();
            }
            if (objLast.fiMaHs() != null && objLast.fiTenHh() != null && objLast.fiMaHs() != undefined && objLast.fiTenHh() != "") {
                $('#Hanghoaserror').hide();
            } else {
                $('#Hanghoaserror').show();
                flag = false;
            }
        }
        return flag;
    }
    self.addHangHoaOnClick = function () {
        if (self.valueLoai() != false) {
            var item = new TbdhsHanghoa1({
                fiStt: self.lstHanghoas().length + 1,
                fiIdHh: -1 * new Date().getTime()
            });
            self.lstHanghoas.push(item);
            for (var i = 0; i < self.lstHanghoas().length; i++) {
                self.lstHanghoas()[i].fiStt(i + 1);
            }

            if (self.lstHanghoas().length != 0) {
                self.errorHHMessage('');
            }
            $("#valueDVErroor_" + item.fiStt()).show();
            $("#itErroor_" + item.fiStt()).show();
            $("#fiMaHs-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
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

