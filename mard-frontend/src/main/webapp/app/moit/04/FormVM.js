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
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
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

    //thong tin hang hoa
    self.fiMucdichNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoluong = ko.observable(null);

    self.fiQuycachDonggoi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCachthucKiemsoat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDvGuihang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoigui = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSdtNguoigui = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Số điện thoại tối đa 50 ký tự', params: 50}
//        pattern: {
//            message: 'Số điện thoại phải nhập đúng định dạng',
//            params: /^[(\d{10})|(\+\d{12})]*$/
//        }
    });
    self.fiDvNhanhang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoinhan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSdtNguoinhan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Số điện thoại tối đa 50 ký tự', params: 50}
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
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    self.visibleLyDoXinSua = ko.observable(false);

    //Danh muc

    var hosoVG = [self.fiTenDn, self.fiMst, self.fiDiachiTsc, self.fiSdt, self.fiEmail, self.fiSoGcnDk, self.fiNgaycapDk
                , self.fiNoicapDk, self.fiMucdichNk, self.fiSoluong, self.fiQuycachDonggoi, self.fiCachthucKiemsoat
                , self.fiDvGuihang, self.fiNguoigui, self.fiSdtNguoigui, self.fiDvNhanhang, self.fiNguoinhan, self.fiSdtNguoinhan];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHHMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null)
    self.errorLyDo = ko.observable(null)
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMst(hoso !== null && hoso.hasOwnProperty('fiMst') ? hoso.fiMst : user.username);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSdt(hoso !== null && hoso.hasOwnProperty('fiSdt') ? hoso.fiSdt : user.companyPhoneNumber);
        self.fiFax(hoso !== null && hoso.hasOwnProperty('fiFax') ? hoso.fiFax : null);
        self.fiEmail(hoso !== null && hoso.hasOwnProperty('fiEmail') ? hoso.fiEmail : null);
        console.log(user);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.fiSoGcnDk(hoso.hasOwnProperty('fiSoGcnDk') ? hoso.fiSoGcnDk : null);
            self.fiNoicapDk(hoso.hasOwnProperty('fiNoicapDk') ? hoso.fiNoicapDk : null);
            self.fiNgaycapDk(hoso.hasOwnProperty('fiNgaycapDk') ? new Date(hoso.fiNgaycapDk) : null);

            //thong tin hang hoa
            self.fiMucdichNk(hoso.hasOwnProperty('fiMucdichNk') ? hoso.fiMucdichNk : null);
            self.fiSoluong(hoso.hasOwnProperty('fiSoluong') ? hoso.fiSoluong : null);
            self.fiQuycachDonggoi(hoso.hasOwnProperty('fiQuycachDonggoi') ? hoso.fiQuycachDonggoi : null);
            self.fiCachthucKiemsoat(hoso.hasOwnProperty('fiCachthucKiemsoat') ? hoso.fiCachthucKiemsoat : null);
            self.fiDvGuihang(hoso.hasOwnProperty('fiDvGuihang') ? hoso.fiDvGuihang : null);
            self.fiNguoigui(hoso.hasOwnProperty('fiNguoigui') ? hoso.fiNguoigui : null);
            self.fiSdtNguoigui(hoso.hasOwnProperty('fiSdtNguoigui') ? hoso.fiSdtNguoigui : null);
            self.fiDvNhanhang(hoso.hasOwnProperty('fiDvNhanhang') ? hoso.fiDvNhanhang : null);
            self.fiNguoinhan(hoso.hasOwnProperty('fiNguoinhan') ? hoso.fiNguoinhan : null);
            self.fiSdtNguoinhan(hoso.hasOwnProperty('fiSdtNguoinhan') ? hoso.fiSdtNguoinhan : null);

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
    self.validDateCreate = function () {
        if (self.fiNgaycapDk() != null)
            $("#fiNgaycapDk-lbl").hide();
        else
            $("#fiNgaycapDk-lbl").show();
    }
    self.Lydo = function () {
        if (self.lyDo() != null) {
            $("#lyDo-lbl").hide();
        } else {
            $("#lyDo-lbl").show();
        }
    }
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorHH = true;
        var errorDinhkem = true;
        self.valiTTlist();

        if (self.visibleLyDoXinSua()) {

            debugger;
            if (!self.lyDo()) {
//                app.Alert('Bạn phải nhập vào lý do xin sửa hồ sơ!');

                if (self.lyDo() != null) {
                    $("#lyDo-lbl").hide();
                } else {
                    $("#lyDo-lbl").show();
                    return false;
                }
            }
        }
        self.validDateCreate();
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
//            return errorHoso;
        }

        //Kiem tra thong tin HH
        if (!self.lstHanghoas() || self.lstHanghoas().length <= 0) {
            self.errorHHMessage('* Chưa khai báo thông tin hàng hoá');
            errorHH = false;
//            return errorHH;
        }

        if (self.lstHanghoas() && self.lstHanghoas().length > 0) {
            for (var i = 0; i < self.lstHanghoas().length; i++) {
                var hanghoa = self.lstHanghoas()[i];
                if (!hanghoa.fiMahang() || !hanghoa.fiSoluong()) {
                    errorHH = false;
                    break;
                }
            }
        }

        if (!errorHH) {
            self.errorHHMessage('* Bổ sung thêm thông tin của Hàng hoá trước khi lưu dữ liệu');
//            return errorHH;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhkems() || self.lstDinhkems().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
//            return errorDinhkem;
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

        self.lstHanghoas.remove(function (o) {
            return o.fiIdHh() == item.fiIdHh();
        });
        for (var i = 0; i < self.lstHanghoas().length; i++) {
            self.lstHanghoas()[i].fiStt(i + 1);
        }
        self.countSoluongBao(item);
        self.addHangHoavali();

//        if (item) {
//            var pop = app.popup({
//                title: 'Thông báo',
//                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hoá này?</b>',
//                width: 450,
//                buttons: [
//                    {
//                        name: NSWLang["common_button_toi_chac_chan"],
//                        class: 'btn',
//                        icon: 'fa-save',
//                        action: function () {
//                            
//                            app.popupRemove(pop.selector);
//                        }
//                    },
//                    {
//                        name: 'Huỷ',
//                        class: 'btn',
//                        icon: 'fa-close',
//                        action: function () {
//                            app.popupRemove(pop.selector);
//                        }
//                    }
//                ]
//            });
//        }
    };
    self.addHangHoavali = function () {
        if (self.lstHanghoas().length > 0)
            $('#errorMessagevali').hide();
        else
            $('#errorMessagevali').show();

    }
    self.addHangHoaOnClick = function () {
        var item = new TbdhsHanghoa1({
            fiStt: self.lstHanghoas().length + 1,
            fiIdHh: -1 * new Date().getTime()
        });
        self.lstHanghoas.push(item);
        for (var i = 0; i < self.lstHanghoas().length; i++) {
            self.lstHanghoas()[i].fiStt(i + 1);
        }
        self.addHangHoavali();
    };
    self.valiTTlist = function () {
        debugger;
        for (var i = 0; i < self.lstHanghoas().length; i++) {
            if (self.lstHanghoas()[i].fiSoluong() === undefined || self.lstHanghoas()[i].fiSoluong() === "") {
                $('#fiSoluongvali_' + (i + 1)).show();
            } else {
                $('#fiSoluongvali_' + (i + 1)).hide();
                $('#HanghoaError').hide();

            }
            if (self.lstHanghoas()[i].fiMahang() == null || self.lstHanghoas()[i].fiMahang() == "") {
                $('#fiMahangvali_' + (i + 1)).show();
            } else {
                $('#fiMahangvali_' + (i + 1)).hide();
                $('#HanghoaError').hide();
            }
            if (self.lstHanghoas()[i].fiSoluong() == null || self.lstHanghoas()[i].fiMahang() == null || self.lstHanghoas()[i].fiSoluong() === "" || self.lstHanghoas()[i].fiMahang() == "") {
                $('#HanghoaError').show();
            } else {
                $('#HanghoaError').hide();
            }
        }

    }

    self.countSoluongBao = function (item) {
        debugger;
        var slgb = item.fiSoluong();
        if (slgb.charAt(0) === '0') {
            $("#fiSoluong").removeAttr('value');
        } else {
            var count = 0;
            for (var i = 0; i < self.lstHanghoas().length; i++) {
                if (self.lstHanghoas()[i].fiSoluong() !== undefined
                        && self.lstHanghoas()[i].fiSoluong() !== "") {
                    count = count + parseInt(self.lstHanghoas()[i].fiSoluong());
                } else {
                    count = count + 0;
                }
            }
            self.fiSoluong(count);
            self.valiTTlist();
        }
    }
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            ignore: ['removeHangHoaOnClick', 'addHangHoaOnClick', 'isValidForm', 'init',
                'hosoErrors', 'errorHHMessage', 'toJSON', '__ko_mapping__', 'errorHHMessage',
                'errorDinhKemMessage', 'pop', 'visibleLyDoXinSua', 'countSoluongBao']
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

