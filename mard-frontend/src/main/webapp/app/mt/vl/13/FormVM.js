/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function XeVM(op) {
    var self = this;
    var maThuTuc = app.parseQuerystring().maThuTuc;
    var xe = op.item;

    self.fiId = ko.observable(null);
    self.fiIdXe = ko.observable(xe ? xe.fiIdXe() : null);
    self.fiIdHoso = ko.observable(xe ? xe.fiIdHoso() : null);
    self.fiStt = ko.observable(xe ? xe.fiStt() : null);

    self.fiBksXe = ko.observable(xe != null ? xe.fiBksXe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiTenChuxe = ko.observable(xe ? xe.fiTenChuxe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaLoaixe = ko.observable(xe ? xe.fiMaLoaixe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoaixe = ko.observable(xe ? xe.fiTenLoaixe() : null);
    self.fiSoGhe = ko.observable(xe ? xe.fiSoGhe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNamSx = ko.observable(xe ? xe.fiNamSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaCkXn = ko.observable(xe ? xe.fiMaCkXn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCkXn = ko.observable(xe ? xe.fiTenCkXn() : null);
    self.fiBksXeKoHd = ko.observable(xe ? xe.fiBksXeKoHd() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.lstXe = op.lstXe;
    
    self.lstCuaKhauXuatNhap = op.lstCuaKhauXuatNhap;
    self.lstLoaiXe = op.lstLoaiXe;

    var xeVG = [self.fiBksXe, self.fiTenChuxe, self.fiMaLoaixe, self.fiSoGhe, self.fiNamSx, self.fiMaCkXn];
    self.errors = ko.validation.group(xeVG, {deep: true, live: true, observable: true});

    self.getDetailXe = function () {
        if (self.fiId()) {
            $('#loading10').show();
            app.getCategory('/mt/13/danhmuc', 'HS_XE_CHITIET', self.fiId(), function (d) {
                if (d.success) {
                    
                    var xe = d.data;
                    if (xe) {
                        self.fiBksXe(xe.fiBksXe);
                        self.fiSoGhe(xe.fiSoGhe);
                        self.fiTenChuxe(xe.fiTenChuxe);
                        self.fiNamSx(xe.fiNamSx);
                        self.fiMaLoaixe(xe.fiMaLoaixe);
                        self.fiTenLoaixe(xe.fiTenLoaixe);
                        $("#fiMaLoaixe-New").select2('destroy').val(self.fiMaLoaixe()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                }
                $('#loading10').hide();
            });
        }
    };

    self.toJSON = function () {
        var exclude = ["getDetailXe", "lstLoaiXe", "lstCuaKhauXuatNhap", "lstXe",
            "toJSON", "__ko_mapping__", "errors", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValid = function () {
        if (self.errors().length > 0) {
            return true;
        } else if (self.fiBksXeKoHd() == null && maThuTuc == "BGTVT0600015") {
            return true;
        }

    };
}

function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMaCqxl = ko.observable(null);
    self.fiTenCqxl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoGtVb = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiFaxDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiEmailDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250},
        email: {message: 'Email không đúng định dạng', params: true}
    });
    self.fiWebDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSoGpVtdb = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapGp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    //Thong tin tuyen
    self.fiMaTuyen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTuyen = ko.observable(null);
    self.fiBenDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinhDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTinhDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinhDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTinhDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBenDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiKhoangcach = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHanhtrinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaCkXn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenCkXn = ko.observable(null).extend({
        //required: {message: '1111', params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiTenNgKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucDanh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiaDiem2 = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiIdThutuc = ko.observable(null);
    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);
    self.fiNgaygui = ko.observable(null);

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiDiaDiem = ko.observable(null);
    self.fiNgayDk = ko.observable(null);
    self.fiNgayNgung = ko.observable(null);
    self.fiNgayDchinh = ko.observable(null);
    self.fiSoVb = ko.observable(null);
    self.fiNgaycapVb = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });
    self.fiMstDn = ko.observable(null);
    self.fiSoChuyen = ko.observable(null);

    self.lstXe = ko.observableArray(hosoInfo ? hosoInfo.lstXe : []);
    self.lstDinhKem = ko.observableArray([]);

    //Danh muc
    self.lstDonViXuLy = ko.observableArray(mapCategory(options ? options.lstDonViXuLy : [], 'fiMaCqxl', 'fiTenCqxl'));
    self.lstTuyen = ko.observableArray(mapCategory(options ? options.lstTuyen : [], 'fiMaTuyen', 'fiTenTuyen'));
    self.lstLoaiXe = ko.observableArray(mapCategory(options ? options.lstLoaiXe : [], 'fiMaPhtien', 'fiTenPhtien'));
    self.lstCuaKhauDiDen = ko.observableArray(mapCategory(options ? options.lstCuaKhauDiDen : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstCuaKhauXuatNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauXuatNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));

    var hosoVG = [self.fiMaCqxl, self.fiTenDn, self.fiDiachiDn, self.fiSoGtVb, self.fiDiachiDn, self.fiSdtDn, self.fiFaxDn
                , self.fiSoGpVtdb, self.fiNgaycapGp, self.fiMaTuyen, self.fiBenDi, self.fiMaTinhDi,
        self.fiMaTinhDen, self.fiBenDen, self.fiKhoangcach, self.fiHanhtrinh, self.fiMaCkXn,
        self.fiMstDn, self.fiTenNgKy, self.fiDiaDiem2];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorXeMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
        self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);
        self.fiWebDn(hoso !== null && hoso.hasOwnProperty('fiWebDn') ? hoso.fiWebDn : null);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqxl(hoso.hasOwnProperty('fiMaCqxl') ? hoso.fiMaCqxl : null);
            self.fiTenCqxl(hoso.hasOwnProperty('fiTenCqxl') ? hoso.fiTenCqxl : null);

            self.fiSoGtVb(hoso.hasOwnProperty('fiSoGtVb') ? hoso.fiSoGtVb : null);
            self.fiSoGpVtdb(hoso.hasOwnProperty('fiSoGpVtdb') ? hoso.fiSoGpVtdb : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaycapGp != null ? new Date(hoso.fiNgaycapGp) : null);

            self.fiMaTuyen(hoso.hasOwnProperty('fiMaTuyen') ? hoso.fiMaTuyen : null);
            self.fiTenTuyen(hoso.hasOwnProperty('fiTenTuyen') ? new Date(hoso.fiTenTuyen) : null);
            self.fiBenDi(hoso.hasOwnProperty('fiBenDi') ? hoso.fiBenDi : null);
            self.fiMaTinhDi(hoso.hasOwnProperty('fiMaTinhDi') ? hoso.fiMaTinhDi : null);
            self.fiTenTinhDi(hoso.hasOwnProperty('fiTenTinhDi') ? hoso.fiTenTinhDi : null);
            self.fiMaTinhDen(hoso.hasOwnProperty('fiMaTinhDen') ? hoso.fiMaTinhDen : null);
            self.fiTenTinhDen(hoso.hasOwnProperty('fiTenTinhDen') ? hoso.fiTenTinhDen : null);
            self.fiBenDen(hoso.hasOwnProperty('fiBenDen') ? hoso.fiBenDen : null);
            self.fiKhoangcach(hoso.hasOwnProperty('fiKhoangcach') ? hoso.fiKhoangcach : null);
            self.fiHanhtrinh(hoso.hasOwnProperty('fiHanhtrinh') ? hoso.fiHanhtrinh : null);
            self.fiMaCkXn(hoso.hasOwnProperty('fiMaCkXn') ? hoso.fiMaCkXn : null);
            self.fiTenCkXn(hoso.hasOwnProperty('fiTenCkXn') ? hoso.fiTenCkXn : null);

            self.fiTenNgKy(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiTenNgKy : null);
            self.fiChucDanh(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiChucDanh : null);
            self.fiDiaDiem2(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiDiaDiem : null);

            self.fiIdThutuc(hoso.hasOwnProperty('fiIdThutuc') ? hoso.fiIdThutuc : null);
            self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : options.maThuTuc);
            self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? hoso.fiNgaygui : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiDiaDiem(hoso.hasOwnProperty('fiDiaDiem') ? hoso.fiDiaDiem : null);
            self.fiNgayDk(hoso.hasOwnProperty('fiNgayDk') ? new Date(hoso.fiNgayDk) : null);
            self.fiNgayNgung(hoso.hasOwnProperty('fiNgayNgung') ? new Date(hoso.fiNgayNgung) : null);
            self.fiNgayDchinh(hoso.hasOwnProperty('fiNgayDchinh') ? new Date(hoso.fiNgayDchinh) : null);
            self.fiSoVb(hoso.hasOwnProperty('fiSoVb') ? hoso.fiSoVb : null);
            self.fiNgaycapVb(hoso.hasOwnProperty('fiNgaycapVb') && hoso.fiNgaycapVb != null ? new Date(hoso.fiNgaycapVb) : null);

            self.fiSoChuyen(hoso.hasOwnProperty('fiSoChuyen') ? hoso.fiSoChuyen : null);

            self.lstXe(mapTbdhsXe2(hoso.hasOwnProperty('lstXe') ? hoso.lstXe : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));
        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }

        $("#fiMaCqxl").val(self.fiMaCqxl()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

        self.hosoErrors.showAllMessages(false);
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        delete self.xeVM;
        delete self.pop;
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorXe = true;
        var errorDinhkem = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        if (self.fiNgaycapGp() == null) {
            //app.Alert('Thông tin ngày cấp giấy phép vận tải đường bộ cần được cung cấp!');
            errorHoso = false;
            return errorHoso;
        }

        //Kiem tra thong tin Xe

        if (!self.lstXe() || self.lstXe().length <= 0) {
            self.errorXeMessage('* Chưa khai báo thông tin xe');
            errorXe = false;
            return errorXe;
        }

        if (self.lstXe() && self.lstXe().length > 0) {
            for (var i = 0; i < self.lstXe().length; i++) {
                var xe = self.lstXe()[i];
                if (!xe.fiBksXe() || !xe.fiTenChuxe() || !xe.fiMaLoaixe() || !xe.fiSoGhe() || !xe.fiNamSx() || !xe.fiMaCkXn()) {
                    errorXe = false;
                    break;
                }
            }
        }

        if (!errorXe) {
            self.errorXeMessage('* Bổ sung thêm thông tin của Xe trước khi lưu dữ liệu');
            return errorXe;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhKem() || self.lstDinhKem().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        } else {
            self.errorDinhKemMessage(null);
        }

        if (self.lstDinhKem() && self.lstDinhKem().length > 0) {
            for (var i = 0; i < self.lstDinhKem().length; i++) {
                var attach = self.lstDinhKem()[i];
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

        return errorHoso && errorXe && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeCarOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của xe này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            i
                            self.lstXe.remove(function (o) {
                                return o.fiIdXe() == item.fiIdXe();
                            });
                            for (var i = 0; i < self.lstXe().length; i++) {
                                self.lstXe()[i].fiStt(i + 1);
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

    self.addCarOnClick = function () {
        self.updateXeInfo(null);
        return false;
    };

    self.editCarOnClick = function (item) {
        self.updateXeInfo(item);
        return false;
    };

    self.updateXeInfo = function (item) {
        var html = [
            $('#thongtinxe-template').html()
        ].join('');

        var data = {
            item: item,
            lstLoaiXe: self.lstLoaiXe(),
            lstCuaKhauXuatNhap: self.lstCuaKhauXuatNhap()
        };

        delete self.pop;
        delete self.xeVM;

        var cb = function () {
            self.xeVM = new XeVM(data);
            self.pop = app.popup({
                title: 'Cập nhật thông tin xe',
                html: html,
                width: 1024,
                buttons: [
                    {
                        name: 'Lưu',
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            if (self.xeVM.isValid()) {
                                app.Alert('Bạn phải nhập vào đầy đủ thông tin của xe.');
                            } else {
                                var xeInfo = self.xeVM.toJSON();
                                if (null == xeInfo.fiIdXe) {
                                    xeInfo.fiIdXe = -1 * new Date().getTime();
                                    xeInfo.fiStt = self.lstXe().length + 1;
                                    var xeModel = new TbdhsXe2(xeInfo);
                                    self.lstXe.push(xeModel);
                                } else {
                                    for (var i = 0; i < self.lstXe().length; i++) {
                                        if (xeInfo.fiIdXe == self.lstXe()[i].fiIdXe()) {
                                            var xeModel = new TbdhsXe2(xeInfo);
                                            self.lstXe.replace(self.lstXe()[i], xeModel);
                                            break;
                                        }
                                    }
                                }

                                app.popupRemove(self.pop.selector);
                                $('.modal-scrollable').hide();
                                $('.modal-backdrop').hide();
                            }
                        }
                    },
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.popupRemove(self.pop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                        }
                    }
                ]
            });

            ko.applyBindings(self.xeVM, document.getElementById('thongtinxe-vm'));

            if (item != null) {
                $("#fiBksXe-New").val(item.fiId()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaLoaixe-New").val(item.fiMaLoaixe()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaCkXn-New").val(item.fiMaCkXn()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiBksXeKoHd-New").val(item.fiBksXeKoHd()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

            } else {
                $("#fiBksXe-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaLoaixe-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaCkXn-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiBksXeKoHd-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

            }

        };

        app.makePost({
            url: '/mt/13/xe/findall',
            data: JSON.stringify({
                pageSize: 10000,
                currentPage: 0
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    data.lstXe = d.data;
                    cb();
                } else {
                    msg = data.message ? data.message : 'Không load được danh mục xe, vui lòng thử lại!';
                    app.Alert(msg);
                }
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    };

    self.getTuyenInfoOnClick = function () {
        if (self.fiMaTuyen()) {
            $('#loading10').show();
            app.getCategory('/mt/13/danhmuc', 'HS_TUYENVANTAI_CHITIET', self.fiMaTuyen(), function (d) {
                if (d.success) {
                    var tuyenInfo = d.data;
                    if (tuyenInfo) {
                        self.fiTenTuyen(tuyenInfo.fiTenTuyen);
                        self.fiBenDi(tuyenInfo.fiTenBenDi);
                        self.fiMaTinhDi(tuyenInfo.fiMaTinhDi);
                        self.fiTenTinhDi(tuyenInfo.fiTenTinhDi);
                        self.fiMaTinhDen(tuyenInfo.fiMaTinhDen);
                        self.fiTenTinhDen(tuyenInfo.fiTenTinhDen);
                        self.fiBenDen(tuyenInfo.fiTenBenDen);
                        self.fiKhoangcach(tuyenInfo.fiKhoangcach);
                        self.fiHanhtrinh(tuyenInfo.fiHanhtrinh);
                        self.fiMaCkXn(tuyenInfo.fiMaCk);
                        //self.fiTenCkXn(tuyenInfo.fiTenTuyen);
                        $("#fiMaCkXn").select2('destroy').val(self.fiMaCkXn()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                    $('#loading10').hide();

                }
            });
        }
    };
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["removeCarOnClick", "addCarOnClick", "isValidForm", "init",
            "hosoErrors", "hosoErrors", "lstDonViXuLy", "lstTuyen", "lstLoaiXe", "lstCuaKhauDiDen",
            "toJSON", "lstCuaKhauXuatNhap", "__ko_mapping__", 'fiDiaDiem2', 'fiChucDanh', 'fiTenNgKy',
            'getTuyenInfoOnClick', 'errorXeMessage', 'errorDinhKemMessage', 'pop', 'editCarOnClick', 'updateXeInfo'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        for (var i = 0; i < model.lstDinhKem.length; i++) {
            delete model.lstDinhKem[i]['canUpload'];
            delete model.lstDinhKem[i]['canDownload'];
            delete model.lstDinhKem[i]['canDelete'];
            delete model.lstDinhKem[i]['doUpload'];
            delete model.lstDinhKem[i]['doDelete'];
            delete model.lstDinhKem[i]['downloadUrl'];
            delete model.lstDinhKem[i]['fiBatBuoc'];
            delete model.lstDinhKem[i]['isRequire'];
            delete model.lstDinhKem[i]["__ko_mapping__"];
        }

        //Fill chuKyDoanhNghiep object
        model.chuKyDoanhNghiep = {
            fiDiaDiem: self.fiDiaDiem2(),
            fiChucDanh: self.fiChucDanh(),
            fiTenNgKy: self.fiTenNgKy()
        };

        return model;
    };
}

