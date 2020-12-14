/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    var FIRST_GROUP = [1, 2];
    var SECOND_GROUP = [3];
    var THIRD_GROUP = [1];

    var proceduceId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    self.fiThuTucId = ko.observable(proceduceId());

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiLoaiDon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.isFirstGroup = ko.computed(function () {
        return null != self.fiLoaiDon() && FIRST_GROUP.indexOf(self.fiLoaiDon()) >= 0;
    }, self);

    self.isSecondGroup = ko.computed(function () {
        return null != self.fiLoaiDon() && SECOND_GROUP.indexOf(self.fiLoaiDon()) >= 0;
    }, self);

    self.fiMucDichNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    
    self.isThirdGroup = ko.computed(function () {
        return null != self.fiMucDichNk() && THIRD_GROUP.indexOf(self.fiMucDichNk()) >= 0;
    }, self);
    
    self.isRequireDeTai = ko.computed(function () {
        return null != self.fiMucDichNk() && 1 === self.fiMucDichNk();
    }, self);

    self.fiTenDeTai = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return 1 === self.fiMucDichNk();
            }
        }
    });

    self.fiSoQd = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return 1 === self.fiMucDichNk();
            }
        }
    });

    self.fiNgayKyQd = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}',
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return 1 === self.fiMucDichNk();
            }
        }
    });

    self.fiTenQd = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return 1 === self.fiMucDichNk();
            }
        }
    });

    self.fiMaCuaKhau = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        }
    });
    self.fiTenCuaKhau = ko.observable(null);

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiSoCongvan = ko.observable(null);
    self.fiNgaycapCv = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });

    //doanhNghiep
    self.fiIdDn = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTinh = ko.observable(null);
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiDd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucvuNgDd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    //Don hang
    self.fiIdDonhang = ko.observable(null);
    self.fiTenHang = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            params: true
        }
    });
    self.fiBaoChe = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            params: true
        }
    });
    self.fiDongGoi = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            params: true
        }
    });
    self.fiHoatChat = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiHamLuong = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiTenKhac = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBoPhanDung = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaDvtinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenDvtinh = ko.observable(null);
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Phải nhập số', params: true},
        maxLength: {message: 'Độ dài tối đa là 10', params: 10}
    });
    self.fiHanDung = ko.observable(null).extend({
        maxLength: {message: 'Độ dài tối đa là 10', params: 10}
    });

    self.fiTccl = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiChiDinh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMaQgSx = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgSx = ko.observable(null);

    self.fiTenCoSoSx = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCssx = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiMaQgXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgXk = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        }
    });
    self.fiTenCoSoXk = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCsXk = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenCsSh = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaQgSh = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isThirdGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgSh = ko.observable(null);

    self.lstNguyenLieus = ko.observableArray([]);
    self.lstDinhKems = ko.observableArray([]);

    //Danh muc
    self.lstMucDichNhapKhau = ko.observableArray(mapCategory(options ? options.lstMucDichNhapKhau : [], 'fiMaMdnk', 'fiTenMdnk'));
    self.lstTinhThanh = ko.observableArray(mapCategory(options ? options.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstDonViTinh = ko.observableArray(mapCategory(options ? options.lstDonViTinh : [], 'fiMaDvtinh', 'fiTenDvtinh'));
    self.ltsNuocSanXuat = ko.observableArray(mapCategory(options ? options.ltsNuocSanXuat : [], 'fiMaQg', 'fiTenQg'));
    self.lstCuaKhauNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstLoaiDonHang = ko.observableArray(mapCategory(options ? options.lstLoaiDonHang : [], 'fiMaLoaidon', 'fiTenLoaidon'));
    self.lstNguyenLieu = ko.observableArray(mapCategory(options ? options.lstNguyenLieu : [], 'fiMaNl', 'fiTenNl'));

    var hosoVG = [self.fiTenDn, self.fiChucvuNgDd, self.fiMstDn, self.fiDiachiDn, self.fiMaTinh, self.fiNguoiDd
                , self.fiMucDichNk, self.fiSoLuong, self.fiTenCoSoSx, self.fiMaQgSx, self.fiDiachiCssx
                , self.fiTccl, self.fiMaQgSh, self.fiDiachiCsXk, self.fiTenCoSoXk, self.fiTenQgXk,
        self.fiDiachiCssx, self.fiBoPhanDung, self.fiTenKhac, self.fiHamLuong, self.fiHoatChat,
        self.fiDongGoi, self.fiBaoChe, self.fiTenHang, self.fiMaCuaKhau, self.fiChiDinh, self.fiTenCsSh,
        self.fiTenDeTai, self.fiSoQd, self.fiNgayKyQd, self.fiTenQd];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorNguyenLieuMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiIdDn(hoso !== null && hoso.hasOwnProperty('fiIdDn') ? hoso.fiIdDn : null);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);

        if (hoso !== null) {
            self.fiMaTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiMaTinh') ? hoso.doanhNghiep.fiMaTinh : null);
            self.fiTenTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiTenTinh') ? hoso.doanhNghiep.fiTenTinh : null);
            self.fiNguoiDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiNguoiDd') ? hoso.doanhNghiep.fiNguoiDd : null);
            self.fiChucvuNgDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiChucvuNgDd') ? hoso.doanhNghiep.fiChucvuNgDd : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
            self.fiLoaiDon(hoso.hasOwnProperty('fiLoaiDon') ? hoso.fiLoaiDon : null);
            self.fiMucDichNk(hoso.hasOwnProperty('fiMucDichNk') ? hoso.fiMucDichNk : null);
            self.fiTenDeTai(hoso.hasOwnProperty('fiTenDeTai') ? hoso.fiTenDeTai : null);
            self.fiSoQd(hoso.hasOwnProperty('fiSoQd') ? hoso.fiSoQd : null);
            self.fiNgayKyQd(hoso.hasOwnProperty('fiNgayKyQd') ? new Date(hoso.fiNgayKyQd) : null);
            self.fiTenQd(hoso.hasOwnProperty('fiTenQd') ? hoso.fiTenQd : null);

            self.fiMaCuaKhau(hoso.hasOwnProperty('fiMaCuaKhau') ? hoso.fiMaCuaKhau : null);
            self.fiTenCuaKhau(hoso.hasOwnProperty('fiTenCuaKhau') ? hoso.fiTenCuaKhau : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiSoCongvan(hoso.hasOwnProperty('fiSoCongvan') ? hoso.fiSoCongvan : null);
            self.fiNgaycapCv(hoso.hasOwnProperty('fiNgaycapCv') ? new Date(hoso.fiNgaycapCv) : null);

            //Don hang
            self.fiIdDonhang(hoso.donHang.hasOwnProperty('fiIdDonhang') ? hoso.donHang.fiIdDonhang : null);
            self.fiTenHang(hoso.donHang.hasOwnProperty('fiTenHang') ? hoso.donHang.fiTenHang : null);
            self.fiBaoChe(hoso.donHang.hasOwnProperty('fiBaoChe') ? hoso.donHang.fiBaoChe : null);
            self.fiHoatChat(hoso.donHang.hasOwnProperty('fiHoatChat') ? hoso.donHang.fiHoatChat : null);
            self.fiHamLuong(hoso.donHang.hasOwnProperty('fiHamLuong') ? hoso.donHang.fiHamLuong : null);
            self.fiDongGoi(hoso.donHang.hasOwnProperty('fiDongGoi') ? hoso.donHang.fiDongGoi : null);
            self.fiTenKhac(hoso.donHang.hasOwnProperty('fiTenKhac') ? hoso.donHang.fiTenKhac : null);
            self.fiBoPhanDung(hoso.donHang.hasOwnProperty('fiBoPhanDung') ? hoso.donHang.fiBoPhanDung : null);
            self.fiMaDvtinh(hoso.donHang.hasOwnProperty('fiMaDvtinh') ? hoso.donHang.fiMaDvtinh : null);
            self.fiTenDvtinh(hoso.donHang.hasOwnProperty('fiTenDvtinh') ? hoso.donHang.fiTenDvtinh : null);
            self.fiSoLuong(hoso.donHang.hasOwnProperty('fiSoLuong') ? hoso.donHang.fiSoLuong : null);
            self.fiHanDung(hoso.donHang.hasOwnProperty('fiHanDung') ? hoso.donHang.fiHanDung : null);
            self.fiTccl(hoso.donHang.hasOwnProperty('fiTccl') ? hoso.donHang.fiTccl : null);
            self.fiChiDinh(hoso.donHang.hasOwnProperty('fiChiDinh') ? hoso.donHang.fiChiDinh : null);

            self.fiMaQgSx(hoso.donHang.hasOwnProperty('fiMaQgSx') ? hoso.donHang.fiMaQgSx : null);
            self.fiTenQgSx(hoso.donHang.hasOwnProperty('fiTenQgSx') ? hoso.donHang.fiTenQgSx : null);
            self.fiTenCoSoSx(hoso.donHang.hasOwnProperty('fiTenCoSoSx') ? hoso.donHang.fiTenCoSoSx : null);
            self.fiDiachiCssx(hoso.donHang.hasOwnProperty('fiDiachiCssx') ? hoso.donHang.fiDiachiCssx : null);

            self.fiMaQgXk(hoso.donHang.hasOwnProperty('fiMaQgXk') ? hoso.donHang.fiMaQgXk : null);
            self.fiTenQgXk(hoso.donHang.hasOwnProperty('fiTenQgNk') ? hoso.donHang.fiTenQgXk : null);
            self.fiTenCoSoXk(hoso.donHang.hasOwnProperty('fiTenCoSoXk') ? hoso.donHang.fiTenCoSoXk : null);
            self.fiDiachiCsXk(hoso.donHang.hasOwnProperty('fiDiachiCsXk') ? hoso.donHang.fiDiachiCsXk : null);

            self.fiMaQgSh(hoso.donHang.hasOwnProperty('fiMaQgSh') ? hoso.donHang.fiMaQgSh : null);
            self.fiTenQgSh(hoso.donHang.hasOwnProperty('fiTenQgSh') ? hoso.donHang.fiTenQgSh : null);
            self.fiTenCsSh(hoso.donHang.hasOwnProperty('fiTenCsSh') ? hoso.donHang.fiTenCsSh : null);

            self.lstNguyenLieus(mapTbdhsNglieu36(hoso.donHang.hasOwnProperty('lstNguyenLieus') ? hoso.donHang.lstNguyenLieus : []));
            self.lstDinhKems(mapTbdhsFile36(hoso.hasOwnProperty('lstDinhKems') ? hoso.lstDinhKems : []
                    , self.fiIdHoso()
                    , self));
        } else {
            self.lstDinhKems(mapFilesVM(options.lstDinhKems, self.fiIdHoso(), self));
        }
        self.hosoErrors.showAllMessages(false);
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorDinhkem = true;
        var errorNguyenLieu = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        if (self.isThirdGroup()) {
            if (!self.lstNguyenLieus() || self.lstNguyenLieus().length <= 0) {
                self.errorNguyenLieuMessage('* Chưa khai báo thông tin nguyên liệu');
                errorNguyenLieu = false;
                return errorNguyenLieu;
            }

            if (self.lstNguyenLieus() && self.lstNguyenLieus().length > 0) {
                for (var i = 0; i < self.lstNguyenLieus().length; i++) {
                    var item = self.lstNguyenLieus()[i];
                    if (!item.fiLoaiNglieu() || !item.fiMaNglieu() || (!item.fiTongKl() && isNaN(item.fiTongKl()))) {
                        errorNguyenLieu = false;
                        break;
                    }
                }
            }

            if (!errorNguyenLieu) {
                self.errorNguyenLieuMessage('* Bổ sung thêm thông tin của nguyên liệu trước khi lưu dữ liệu');
                return errorNguyenLieu;
            }
        }

        if (self.lstDinhKems() && self.lstDinhKems().length > 0) {
            for (var i = 0; i < self.lstDinhKems().length; i++) {
                var attach = self.lstDinhKems()[i];
                if (attach.isRequire()) {
                    if (!attach.fiTenTep() || !attach.fiDuongDan()) {
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return errorHoso && errorNguyenLieu && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.xoaNguyenLieuClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của nguyên liệu này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstNguyenLieus.remove(function (o) {
                                return o.fiIdNglieu() == item.fiIdNglieu();
                            });
                            for (var i = 0; i < self.lstNguyenLieus().length; i++) {
                                self.lstNguyenLieus()[i].fiStt(i + 1);
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
    self.themNguyenLieuClick = function () {
        var item = new TbdhsNglieu36({
            fiStt: self.lstNguyenLieus().length + 1,
            fiIdNglieu: -1 * new Date().getTime()
        });
        self.lstNguyenLieus.push(item);
        for (var i = 0; i < self.lstNguyenLieus().length; i++) {
            self.lstNguyenLieus()[i].fiStt(i + 1);
        }
        $("#fiMaNglieu-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.fiMaNglieuChange = function (item) {
        var idx = options.lstNguyenLieu.Search('fiMaNl', item.fiMaNglieu());
        item.fiLoaiNglieu(options.lstNguyenLieu[idx].fiLoaiNl);
        item.fiTenNglieu(options.lstNguyenLieu[idx].fiTenNl);
    };
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["xoaNguyenLieuClick", "themNguyenLieuClick", "isValidForm", "init",
            "hosoErrors", "errorNguyenLieuMessage", "errorDinhKemMessage", "lstMucDichNhapKhau", "lstTinhThanh", "lstDonViTinh",
            "toJSON", "ltsNuocSanXuat", "__ko_mapping__", 'lstCuaKhauNhap', 'lstLoaiDonHang', 'lstNguyenLieu',
            'pop', 'fiMaNglieuChange', 'isFirstGroup', 'isSecondGroup', 'fiTenThuoc', 'lstCoSoDeNghiCap',
            'lstXuatXuHangHoa', 'fiThuTucId', 'visibleNhomThuocTinhThuoc', 'visibleThongTinChungTiengAnh',
            'visibleTenNguyenLieu', 'visibleTenThuoc', 'visibleFiSoGpNkVn', 'visibleFiSoGpNkNn',
            'visibleFiTccl', 'fiThuTucId', 'isThirdGroup', 'isRequireDeTai'];

        self.fiTenQgSx($('#fiMaQgSx option:selected').text());
        self.fiTenQgXk($('#fiMaQgXk option:selected').text());
        self.fiTenQgSh($('#fiMaQgSh option:selected').text());
        self.fiTenTinh($('#fiMaTinh option:selected').text());
        self.fiTenDvtinh($('#fiMaDvtinh option:selected').text());
        self.fiTenCuaKhau($('#fiMaCuaKhau option:selected').text());

        var model = ko.toJS(self);

        //delete prop not use
        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        for (var i = 0; i < model.lstDinhKems.length; i++) {
            delete model.lstDinhKems[i]['canUpload'];
            delete model.lstDinhKems[i]['canDownload'];
            delete model.lstDinhKems[i]['canDelete'];
            delete model.lstDinhKems[i]['doUpload'];
            delete model.lstDinhKems[i]['doDelete'];
            delete model.lstDinhKems[i]['downloadUrl'];
            delete model.lstDinhKems[i]['fiBatBuoc'];
            delete model.lstDinhKems[i]['isRequire'];
            delete model.lstDinhKems[i]["__ko_mapping__"];
        }

        model.doanhNghiep = {
            fiIdDn: self.fiIdDn(),
            fiMstDn: self.fiMstDn(),
            fiTenDn: self.fiTenDn(),
            fiMaTinh: self.fiMaTinh(),
            fiTenTinh: self.fiTenTinh(),
            fiDiachiDn: self.fiDiachiDn(),
            fiNguoiDd: self.fiNguoiDd(),
            fiChucvuNgDd: self.fiChucvuNgDd()
        };

        for (var i = 0; i < model.lstNguyenLieus.length; i++) {
            delete model.lstNguyenLieus[i]['fiStt'];
        }

        model.donHang = {
            fiIdDonhang: self.fiIdDonhang(),
            fiTenHang: self.fiTenHang(),
            fiBaoChe: self.fiBaoChe(),
            fiDongGoi: self.fiDongGoi(),
            fiHoatChat: self.fiHoatChat(),
            fiHamLuong: self.fiHamLuong(),
            fiTenKhac: self.fiTenKhac(),
            fiBoPhanDung: self.fiBoPhanDung(),
            fiMaDvtinh: self.fiMaDvtinh(),
            fiTenDvtinh: self.fiTenDvtinh(),
            fiSoLuong: self.fiSoLuong(),
            fiHanDung: self.fiHanDung(),
            fiTccl: self.fiTccl(),
            fiChiDinh: self.fiChiDinh(),
            fiMaQgSx: self.fiMaQgSx(),
            fiTenQgSx: self.fiTenQgSx(),
            fiTenCoSoSx: self.fiTenCoSoSx(),
            fiDiachiCssx: self.fiDiachiCssx(),
            fiMaQgXk: self.fiMaQgXk(),
            fiTenQgXk: self.fiTenQgXk(),
            fiTenCoSoXk: self.fiTenCoSoXk(),
            fiDiachiCsXk: self.fiDiachiCsXk(),
            fiTenCsSh: self.fiTenCsSh(),
            fiMaQgSh: self.fiMaQgSh(),
            fiTenQgSh: self.fiTenQgSh(),
            lstNguyenLieus: model.lstNguyenLieus
        };

        var _exclude = ['fiIdDonhang', 'fiXuatXu', 'fiMaHang',
            'fiTenHang', 'fiBaoChe', 'fiHoatChat', 'fiHamLuong',
            'fiDongGoi', 'fiSoDkLh', 'fiSoGpNkVn', 'fiNgayGpNkVn',
            'fiSoGpNkNn', 'fiNgayGpNkNn', 'fiNoicapGpNn', 'fiHieulucGpNn',
            'fiMaDvtinh', 'fiTenDvtinh', 'fiSoLuong', 'fiTccl',
            'fiBoPhanDung', 'fiTenKhac', 'fiMaQgSx', 'fiTenQgSx',
            'fiTenCoSoSx', 'fiDiachiCssx', 'fiMaQgNk', 'fiTenQgNk',
            'fiTenCoSoNk', 'fiDiachiCsNk', 'fiGhiChu', 'lstNguyenLieus',
            'fiChiDinh', 'fiChucvuNgDd', 'fiDiachiCsXk', 'fiDiachiDn', 'fiHanDung', 'fiIdDn',
            'fiMaQgSh', 'fiMaQgXk', 'fiMaTinh', 'fiMstDn', 'fiNgayKyQd'
                    , 'fiNguoiDd', 'fiTenCoSoXk', 'fiTenCsSh', 'fiTenQgSh', 'fiTenQgXk', 'isRequireDeTai'];
        for (var key in model) {
            if (_exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}

