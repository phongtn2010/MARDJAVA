/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function XeVM(op) {
    var self = this;

    var xe = op.item;

    self.fiIdXe = ko.observable(xe ? xe.fiIdXe() : null);
    self.fiIdHoso = ko.observable(xe ? xe.fiIdHoso() : null);
    self.fiStt = ko.observable(xe ? xe.fiStt() : null);

    console.log(xe);
    self.fiBksXe = ko.observable(xe != null ? xe.fiBksXe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDncpDenNg = ko.observable(xe != null ? xe.fiDncpDenNg() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDncpTuNg = ko.observable(xe != null ? xe.fiDncpTuNg() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenHieu = ko.observable(xe != null ? xe.fiTenHieu() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaNhanhieu = ko.observable(xe != null ? xe.fiMaNhanhieu() : null);
    self.fiSoGhe = ko.observable(xe ? xe.fiSoGhe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMauSon = ko.observable(xe ? xe.fiMauSon() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSoKhung = ko.observable(xe ? xe.fiSoKhung() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSoMay = ko.observable(xe ? xe.fiSoMay() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiLoaihang = ko.observable(xe ? xe.fiLoaihang() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiHanhtrinh = ko.observable(xe ? xe.fiHanhtrinh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMaTuyen = ko.observable(xe != null ? xe.fiMaTuyen() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTuyen = ko.observable(xe ? xe.fiTenTuyen() : null);


    self.fiDiemDung = ko.observable(xe ? xe.fiDiemDung() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDkKhoihanh = ko.observable(xe ? xe.fiDkKhoihanh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNamSx = ko.observable(xe ? xe.fiNamSx : null);


    self.lstXe = op.lstXe;
    self.lstTuyen = op.lstTuyen;

    var xeVG = [self.fiBksXe, self.fiSoGhe, self.fiDncpDenNg, self.fiDncpTuNg, self.fiMaNhanhieu, self.fiMaTuyen, self.fiSoGpMat, self.fiDiemDung];
    self.errors = ko.validation.group(xeVG, {deep: true, live: true, observable: true});

    self.getDetailXe = function () {
        if (self.fiBksXe()) {
            $('#loading10').show();
            app.getCategory('/mt/13/danhmuc', 'HS_XE_CHITIET', self.fiBksXe(), function (d) {
                if (d.success) {
                    var xe = d.data;
                    if (xe) {
                        self.fiBksXe(xe.fiBksXe);
                        self.fiSoGhe(xe.fiSoGhe);
                        self.fiTenHieu(xe.fiTenNhanhieu);
                        self.fiMaNhanhieu(xe.fiMaNhanhieu);
                        self.fiSoMay(xe.fiSoMay);
                        self.fiSoKhung(xe.fiSoKhung);
                        self.fiMauSon(xe.fiTenMauson);
                        self.fiNamSx(xe.fiNamSx);
                    }
                }
                $('#loading10').hide();
            });
        }
    };

    self.toJSON = function () {
        var exclude = ["getDetailXe", "lstLoaiXe", "lstCuaKhauXuatNhap", "lstXe", "lstTuyen",
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
        var errorphuongtien = false;
        if (new Date(self.fiDncpTuNg()).getTime() > new Date(self.fiDncpDenNg()).getTime()) {
            app.Alert('Thời gian đề nghị cấp giấy phép từ ngày không được lớn hơn Thời gian đề nghị cấp giấy phép đến ngày');
            errorphuongtien = true;
            return errorphuongtien;
        }
        if (new Date(self.fiDncpDenNg()).getTime() > new Date(self.fiDkKhoihanh()).getTime()) {
            app.Alert('Thời gian đề nghị cấp giấy phép đến ngày không được lớn hơn Dự kiến thời gian khởi hành');
            errorphuongtien = true;
            return errorphuongtien;
        }
        if (self.errors().length > 0) {
            app.Alert('Bạn phải nhập vào đầy đủ thông tin của xe.');
            errorphuongtien = true;
            return errorphuongtien;
        }
        return errorphuongtien;
    };
}
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMaCqxl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCqxl = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });


    self.fiFaxDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 200}
    });
    self.fiEmailDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 200}
    });



    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });


    self.fiCqcapGpVn = ko.observable(null);
    self.fiSoGpvtVn = ko.observable(null);
    self.fiNgayGpvtVn = ko.observable(null);
    self.fiCqcapGpTq = ko.observable(null);
    self.fiSoGpvtTq = ko.observable(null);
    self.fiNgayGpvtTq = ko.observable(null);

    self.fiTenNgLh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtNgLh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiNgaygui = ko.observable(null);
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSoGp = ko.observable(null);
    self.fiNgaycapGp = ko.observable(null);

    // Thong tin nguoi ky
    self.fiTenNgKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucDanh = ko.observable(null).extend({
        //required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiaDiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.lstXe = ko.observableArray(hosoInfo ? hosoInfo.lstXe : []);
    self.lstDinhKem = ko.observableArray([]);

    //Danh muc
    self.lstDonViXuLy = ko.observableArray(mapCategory(options ? options.lstDonViXuLy : [], 'fiMaCqxl', 'fiTenCqxl'));
    self.lstTuyen = ko.observableArray(mapCategory(options ? options.lstTuyen : [], 'fiMaTuyen', 'fiTenTuyen'));
    self.lstLoaiXe = ko.observableArray(mapCategory(options ? options.lstLoaiXe : [], 'fiMaNhanhieu', 'fiTenHieu'));

    var hosoVG = [self.fiMaCqxl, self.fiTenDn, self.fiDiachiDn, self.fiSdtDn,
        self.fiMstDn, self.fiTenNgKy, self.fiDiaDiem, self.fiFaxDn];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorXeMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqxl(hoso.hasOwnProperty('fiMaCqxl') ? hoso.fiMaCqxl : null);
            self.fiTenCqxl(hoso.hasOwnProperty('fiTenCqxl') ? hoso.fiTenCqxl : null);
            self.fiFaxDn(hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
            self.fiEmailDn(hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);
            debugger;
            self.fiSoGpvtVn(hoso.hasOwnProperty('fiSoGpvtVn') ? hoso.fiSoGpvtVn : null);
            self.fiCqcapGpVn(hoso.hasOwnProperty('fiCqcapGpVn') ? hoso.fiCqcapGpVn : null);
            self.fiNgayGpvtVn(hoso.hasOwnProperty('fiNgayGpvtVn') && hoso.fiNgayGpvtVn != null ? new Date(hoso.fiNgayGpvtVn) : null);

            self.fiSoGpvtTq(hoso.hasOwnProperty('fiSoGpvtTq') ? hoso.fiSoGpvtTq : null);
            self.fiCqcapGpTq(hoso.hasOwnProperty('fiCqcapGpTq') ? hoso.fiCqcapGpTq : null);
            self.fiNgayGpvtTq(hoso.hasOwnProperty('fiNgayGpvtTq') && hoso.fiNgayGpvtVn != null ? new Date(hoso.fiNgayGpvtTq) : null);

            self.fiTenNgLh(hoso.hasOwnProperty('fiTenNgLh') ? hoso.fiTenNgLh : null);
            self.fiSdtNgLh(hoso.hasOwnProperty('fiSdtNgLh') ? hoso.fiSdtNgLh : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? hoso.fiNgaygui : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') && hoso.fiNgaytao != null ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiSoGp(hoso.hasOwnProperty('fiSoGp') ? hoso.fiSoGp : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaytao != null ? new Date(hoso.fiNgaycapGp) : null);

            self.fiTenNgKy(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiTenNgKy : null);
            self.fiChucDanh(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiChucDanh : null);
            self.fiDiaDiem(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiDiaDiem : null);

            self.lstXe(mapTbdhsXe43(hoso.hasOwnProperty('lstXe') ? hoso.lstXe : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));

        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }

        if (!self.fiMaCqxl()) {
            self.fiMaCqxl('TCDBVN');
            self.fiTenCqxl('Tổng Cục Đường Bộ Việt Nam');
        }

        $("#fiMaCqxl").val(self.fiMaCqxl()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        delete self.xeVM;
        delete self.pop;

        var errorHoso = true;
        var errorXe = true;
        var errorDinhkem = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
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
                if (!xe.fiBksXe() || !xe.fiMaNhanhieu() || !xe.fiSoGhe() || !xe.fiDncpTuNg() || !xe.fiDncpDenNg() || !xe.fiMaTuyen()) {
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
                            app.popupRemove(pop.selector);
                            self.lstXe.remove(function (o) {
                                return o.fiIdXe() == item.fiIdXe();
                            });
                            for (var i = 0; i < self.lstXe().length; i++) {
                                self.lstXe()[i].fiStt(i + 1);
                            }
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
//        var xeInfo = new TbdhsXe43({
//            fiStt: self.lstXe().length + 1,
//            fiIdXe: -1 * new Date().getTime()
//        });
//        self.lstXe.push(xeInfo);
//        for (var i = 0; i < self.lstXe().length; i++) {
//            self.lstXe()[i].fiStt(i + 1);
//        }
//        $("#fiMaNhanhieu-" + xeInfo.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
//        $("#fiHanhtrinh-" + xeInfo.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
//        $("#fiMaTuyen-" + xeInfo.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        self.updateXeInfo(null);
        return false;
    };
    self.editCarOnClick = function (item) {
        self.updateXeInfo(item);
        return false;
    }
    self.updateXeInfo = function (item) {
        var html = [
            $('#thongtinxe-template').html()
        ].join('');

        var data = {
            item: item,
            lstLoaiXe: self.lstLoaiXe(),
            lstTuyen: self.lstTuyen()
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
                                return;
                            } else {
                                var xeInfo = self.xeVM.toJSON();
                                if (null == xeInfo.fiIdXe) {
                                    xeInfo.fiIdXe = -1 * new Date().getTime();
                                    xeInfo.fiStt = self.lstXe().length + 1;
                                    var xeModel = new TbdhsXe43(xeInfo);
                                    self.lstXe.push(xeModel);
                                } else {
                                    for (var i = 0; i < self.lstXe().length; i++) {
                                        if (xeInfo.fiIdXe == self.lstXe()[i].fiIdXe()) {
                                            var xeModel = new TbdhsXe43(xeInfo);
                                            console.log(xeInfo);
                                            self.lstXe.replace(self.lstXe()[i], xeModel);
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
                $("#fiBksXe-New").val(item.fiBksXe()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaTuyen-New").val(item.fiMaTuyen()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            } else {
                $("#fiBksXe-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaTuyen-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
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
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            'ignore': ["removeCarOnClick", "addCarOnClick", "isValidForm", "init",
                "hosoErrors", "hosoErrors", "lstDonViXuLy", "lstTuyen", "lstLoaiXe",
                "toJSON", "__ko_mapping__", 'fiDiaDiem', 'fiChucDanh', 'fiTenNgKy',
                'errorXeMessage', 'errorDinhKemMessage']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        for (var i = 0; i < copy.lstDinhKem.length; i++) {
            delete copy.lstDinhKem[i]['canDelete'];
            delete copy.lstDinhKem[i]['canDownload'];
            delete copy.lstDinhKem[i]['canUpload'];
            delete copy.lstDinhKem[i]['downloadUrl'];
            delete copy.lstDinhKem[i]['fiBatBuoc'];
            delete copy.lstDinhKem[i]['isRequire'];
            delete copy.lstDinhKem[i]["__ko_mapping__"];
        }

        //Fill chuKyDoanhNghiep object
        copy.chuKyDoanhNghiep = {
            fiDiaDiem: self.fiDiaDiem(),
            fiChucDanh: self.fiChucDanh(),
            fiTenNgKy: self.fiTenNgKy()
        };

        delete copy['__ko_mapping__'];
        return copy;
    };
}

