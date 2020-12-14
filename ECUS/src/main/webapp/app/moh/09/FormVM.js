/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function FormVM(data) {
    var self = this;

    var query = app.parseQuerystring();

    var hosoInfo = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : {};

    self.isKtChat = ko.computed(function () {
        return query.maThuTuc == 'BYTE0500010';
    }, self);

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);

    self.fiTenCh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCh = ko.observable(null);
    self.fiSdtCh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiFaxCh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailCh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiTenNgXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiNgXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiSdtNgXk = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxNgXk = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailNgXk = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 50}
    });

    self.fiSoTkhq = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgayNkTu = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        }
    });
    self.fiNgayNkDen = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        }
    });
    self.fiMaCkDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCkDi = ko.observable(null);
    self.fiMaCkDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCkDen = ko.observable(null);
    self.fiNgayKtTu = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        }
    });
    self.fiNgayKtDen = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        }
    });
    self.fiDiadiemKt = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        },
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMaTckt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTckt = ko.observable(null);
    self.fiNgayKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNguoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiSoChungnhan = ko.observable(null);
    self.fiNgaycapGcn = ko.observable(null);
    self.fiMaThutuc = ko.observable(null);
    self.fiTenThutuc = ko.observable(null);

    self.showAddProductBtn = ko.observable(true);
    //hangHoa
    self.lstHangHoas = new ko.observableArray([]);
    self.lstNguoiChiuTrachNhiems = new ko.observableArray([]);

    self.lstCoQuanKiemTra = ko.observableArray(mapCategory(data.hasOwnProperty('lstCoQuanKiemTra') ? data.lstCoQuanKiemTra : [], 'fiMaTckt', 'fiTenTckt'));
    self.lstCuaKhau = ko.observableArray(mapCategory(data.hasOwnProperty('lstCuaKhau') ? data.lstCuaKhau : [], "fiMaCuakhau", "fiTenCuakhau"));
    self.lstNhomSanPham = ko.observableArray(mapCategory(data.hasOwnProperty('lstNhomSanPham') ? data.lstNhomSanPham : []));
    self.lstLoaiThanhToan = ko.observableArray(mapCategory(data.hasOwnProperty('lstLoaiThanhToan') ? data.lstLoaiThanhToan : []));

    var hosoVG = [self.fiTenCh, self.fiDiachiCh, self.fiSdtCh, self.fiEmailCh,
        self.fiTenNgXk, self.fiDiachiNgXk, self.fiMaCkDi,
        self.fiMaCkDen, self.fiMaTckt, self.fiNguoiKy, self.fiEmailCh,
        self.fiDiadiemKt, self.fiNgayKtDen, self.fiNgayKtTu, self.fiNgayNkTu, self.fiNgayNkDen,
        self.fiSoTkhq];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.hangHoaErrorMsg = ko.observable(null);
    self.thuongNhanTnErrorMsg = ko.observable(null);

    self.currentAttach = null;

    self.init = function (hoso) {

        self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
        self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

        self.fiTenCh(hoso.hasOwnProperty('fiTenCh') ? hoso.fiTenCh : user.companyName);
        self.fiDiachiCh(hoso.hasOwnProperty('fiDiachiCh') ? hoso.fiDiachiCh : user.companyAddress);
        self.fiSdtCh(hoso.hasOwnProperty('fiSdtCh') ? hoso.fiSdtCh : null);
        self.fiFaxCh(hoso.hasOwnProperty('fiFaxCh') ? hoso.fiFaxCh : null);
        self.fiEmailCh(hoso.hasOwnProperty('fiEmailCh') ? hoso.fiEmailCh : null);

        //self.fiTenNgTn(hoso.hasOwnProperty('fiTenNgTn') ? hoso.fiTenNgTn : null);
        //self.fiDiachiNgTn(hoso.hasOwnProperty('fiDiachiNgTn') ? hoso.fiDiachiNgTn : null);
        //self.fiSdtNgTn(hoso.hasOwnProperty('fiSdtNgTn') ? hoso.fiSdtNgTn : null);
        //self.fiFaxNgTn(hoso.hasOwnProperty('fiFaxNgTn') ? hoso.fiFaxNgTn : null);
        //self.fiEmailNgTn(hoso.hasOwnProperty('fiEmailNgTn') ? hoso.fiEmailNgTn : null);

        self.fiTenNgXk(hoso.hasOwnProperty('fiTenNgXk') ? hoso.fiTenNgXk : null);
        self.fiDiachiNgXk(hoso.hasOwnProperty('fiDiachiNgXk') ? hoso.fiDiachiNgXk : null);
        self.fiSdtNgXk(hoso.hasOwnProperty('fiSdtNgXk') ? hoso.fiSdtNgXk : null);
        self.fiFaxNgXk(hoso.hasOwnProperty('fiFaxNgXk') ? hoso.fiFaxNgXk : null);
        self.fiEmailNgXk(hoso.hasOwnProperty('fiEmailNgXk') ? hoso.fiEmailNgXk : null);

        self.fiSoTkhq(hoso.hasOwnProperty('fiSoTkhq') ? hoso.fiSoTkhq : null);
        if (hoso.hasOwnProperty('fiNgayNkTu') && null != hoso.fiNgayNkTu) {
            self.fiNgayNkTu(new Date(hoso.fiNgayNkTu));
        }

        if (hoso.hasOwnProperty('fiNgayNkDen') && null != hoso.fiNgayNkDen) {
            self.fiNgayNkDen(new Date(hoso.fiNgayNkDen));
        }
        self.fiMaCkDi(hoso.hasOwnProperty('fiMaCkDi') ? hoso.fiMaCkDi : null);
        self.fiTenCkDi(hoso.hasOwnProperty('fiTenCkDi') ? hoso.fiTenCkDi : null);
        self.fiMaCkDen(hoso.hasOwnProperty('fiMaCkDen') ? hoso.fiMaCkDen : null);
        self.fiTenCkDen(hoso.hasOwnProperty('fiTenCkDen') ? hoso.fiTenCkDen : null);

        if (hoso.hasOwnProperty('fiNgayKtDen') && null != hoso.fiNgayKtDen) {
            self.fiNgayKtTu(new Date(hoso.fiNgayKtTu));
        }

        if (hoso.hasOwnProperty('fiNgayKtDen') && null != hoso.fiNgayKtDen) {
            self.fiNgayKtDen(hoso.hasOwnProperty('fiNgayKtDen') ? new Date(hoso.fiNgayKtDen) : null);
        }

        self.fiDiadiemKt(hoso.hasOwnProperty('fiDiadiemKt') ? hoso.fiDiadiemKt : null);
        self.fiMaTckt(hoso.hasOwnProperty('fiMaTckt') ? hoso.fiMaTckt : null);
        self.fiTenTckt(hoso.hasOwnProperty('fiTenTckt') ? hoso.fiTenTckt : null);

        self.fiNgayKy(hoso.hasOwnProperty('fiNgayKy') ? new Date(hoso.fiNgayKy) : null)
        self.fiNguoiKy(hoso.hasOwnProperty('fiNguoiKy') ? hoso.fiNguoiKy : null);

        self.fiHoatdong(1);
        self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : user.username);
        self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
        self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
        self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
        self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
        self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
        self.fiSoChungnhan(hoso.hasOwnProperty('fiSoChungnhan') ? hoso.fiSoChungnhan : null);
        self.fiNgaycapGcn(hoso.hasOwnProperty('fiNgaycapGcn') ? new Date(hoso.fiNgaycapGcn) : null);
        self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : data.maThuTuc);
        self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);

        self.hosoErrors.showAllMessages(false);

        self.lstHangHoas(mapProductVM(hoso.hasOwnProperty('lstHangHoas') ? hoso.lstHangHoas : [], self));
        self.lstNguoiChiuTrachNhiems(mapNguoiTnVM(hoso.hasOwnProperty('lstNguoiChiuTrachNhiems') ? hoso.lstNguoiChiuTrachNhiems : [], self));

        if (self.fiTrangthai() == YC_BO_SUNG) {
            self.showAddProductBtn(false);
        }
    };

    self.init(hosoInfo);

    self.onEditHangHoa = function (item, isView) {
        var html = [
            $('#chitiethanghoa-template').html()
        ].join('');
        delete self.popup;
        delete self.productVM;

        var obj = {};

        if (null !== item) {
            obj = ko.toJS(item);
        }

        obj.lstNhomSanPham = data.lstNhomSanPham;
        obj.lstNguoiChiuTrachNhiems = ko.toJS(self.lstNguoiChiuTrachNhiems());
        obj.lstQuocGia = data.lstQuocGia;

        self.productVM = new ProductVM(obj, self);

        var buttons = [];
        if (!isView) {
            buttons = [
                {
                    name: "Lưu",
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        var isVaild = self.productVM.isVaild();
                        if (isVaild) {
                            if (null == item) {
                                self.productVM.fiStt(self.lstHangHoas().length + 1);
                                self.lstHangHoas.push(self.productVM);
                            } else {
                                var index = self.lstHangHoas.firstIndexOf(function (o) {
                                    return o.fiIdHanghoa() == item.fiIdHanghoa();
                                });
                                self.lstHangHoas.splice(index, 1, self.productVM);
                            }
                            app.popupRemove(self.popup.selector);
                        }
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popup.selector);
                    }
                }
            ];
        } else {
            buttons = [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popup.selector);
                    }
                }
            ];
        }
        self.popup = app.popup({
            title: 'Thêm mới mặt hàng',
            html: html,
            width: 1050,
            //height: 700,
            buttons: buttons
        }, function () {
            $('#chitiethanghoa-form').find("#fiMaNhomHh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        });

        ko.applyBindings(self.productVM, document.getElementById('chitiethanghoa-form'));
    };

    self.onKhaiBaoLoHang = function () {
        self.onEditHangHoa(null, false);
        return false;
    };

    self.onSuaLoHang = function (item) {
        self.onEditHangHoa(item, false);
        return false;
    };

    self.onXemChiTietHang = function (item) {
        self.onEditHangHoa(item, true);
        return false;
    };

    self.onXoaChiTietHang = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstHangHoas.remove(function (o) {
                            return o.fiIdHanghoa() == item.fiIdHanghoa();
                        });
                        for (var i = 0; i < self.lstHangHoas().length; i++) {
                            self.lstHangHoas()[i].fiStt(i + 1);
                        }
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return false;
    };


    //Thuong nhan tiep nhan
    self.onEditThuongNhanTN = function (item) {
        var html = [
            $('#thuongnhantn-template').html()
        ].join('');
        delete self.popup;
        delete self.thuongNhanVM;

        var obj = {};

        if (null !== item) {
            obj = ko.toJS(item);
        }

        self.thuongNhanVM = new NguoiTnVM(obj, self);

        self.popup = app.popup({
            title: 'Thêm mới thông tin thương nhân',
            html: html,
            width: 1050,
            //height: 700,
            buttons: [
                {
                    name: "Lưu",
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        var isVaild = self.thuongNhanVM.isVaild();
                        if (isVaild) {
                            if (null == item) {
                                self.thuongNhanVM.fiStt(self.lstHangHoas().length + 1);
                                self.lstNguoiChiuTrachNhiems.push(self.thuongNhanVM);
                            } else {
                                var index = self.lstNguoiChiuTrachNhiems.firstIndexOf(function (o) {
                                    return o.fiIdNguoiTn() == item.fiIdNguoiTn();
                                });
                                self.lstNguoiChiuTrachNhiems.splice(index, 1, self.thuongNhanVM);
                            }
                            app.popupRemove(self.popup.selector);
                        }
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popup.selector);
                    }
                }
            ]
        }, function () {

        });

        ko.applyBindings(self.thuongNhanVM, document.getElementById('chitietthuongnhan-form'));
    };
    self.onKhaiBaoThuongNhan = function () {
        self.onEditThuongNhanTN(null);
        return false;
    };
    self.onXemChiTietThuongNhan = function (item) {
        self.onEditThuongNhanTN(item);
        return false;
    };
    self.onXoaChiTietThuongNhan = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstNguoiChiuTrachNhiems.remove(function (o) {
                            return o.fiIdNguoiTn() == item.fiIdNguoiTn();
                        });
                        for (var i = 0; i < self.lstNguoiChiuTrachNhiems().length; i++) {
                            self.lstNguoiChiuTrachNhiems()[i].fiStt(i + 1);
                        }
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return false;
    };

    self.onFiMaCkDiChange = function () {
        if (self.fiMaCkDi()) {

            self.fiTenCkDi(null);

            var index = self.lstCuaKhau.firstIndexOf(function (item) {
                return item.id == self.fiMaCkDi();
            });

            if (index >= 0) {
                self.fiTenCkDi(self.lstCuaKhau()[index].name);
            }
        }
    };

    self.onFiMaCkDenChange = function () {
        if (self.fiMaCkDen()) {

            self.fiTenCkDen(null);

            var index = self.lstCuaKhau.firstIndexOf(function (item) {
                return item.id == self.fiMaCkDen();
            });

            if (index >= 0) {
                self.fiTenCkDen(self.lstCuaKhau()[index].name);
            }
        }
    };

    self.onFiMaDvNhanChange = function () {
        if (self.fiMaTckt()) {

            self.fiTenTckt(null);

            var index = self.lstCoQuanKiemTra.firstIndexOf(function (item) {
                return item.id == self.fiMaTckt();
            });

            if (index >= 0) {
                self.fiTenTckt(self.lstCoQuanKiemTra()[index].name);
            }
        }
    };

    self.isValidForm = function () {
        //console.log(self.hosoErrors());
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }

        if (self.lstHangHoas().length <= 0) {
            self.hangHoaErrorMsg('Thông tin chi tiết lô hàng cần được khai báo.');
            return false;
        } else {
            self.hangHoaErrorMsg(null);
        }

        if (self.lstNguoiChiuTrachNhiems().length <= 0) {
            self.thuongNhanTnErrorMsg('Thông tin thương nhân chịu trách nhiệm cần được khai báo.');
            return false;
        } else {
            self.thuongNhanTnErrorMsg(null);
        }

        return true;
    };

    self.onAddCKDi = function () {
        self.showCuaKhauWindow(1);
    };

    self.onAddCKDen = function () {
        self.showCuaKhauWindow(2);
    };

    self.updateGateInfo = function (item, type) {
        if(parseInt(type) == 1) {
            self.fiMaCkDi(item.fiMaCuakhau());            
            self.fiTenCkDi(item.fiTenCuakhau());            
        } else {
            self.fiMaCkDen(item.fiMaCuakhau());            
            self.fiTenCkDen(item.fiTenCuakhau());             
        }
        app.popupRemove(self.cuaKhauPop.selector);
        delete self.cuaKhauPop;
    };

    self.showCuaKhauWindow = function (type) {
        var html = [
            $('#cuakhau-tmpl').html()
        ].join('');
        delete self.cuaKhauVM;
        delete self.cuaKhauPop;

        var cb = function () {
            self.cuaKhauPop = app.popup({
                title: 'Thông tin cửa khẩu',
                html: html,
                width: 1000,
                buttons: [
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(self.cuaKhauPop.selector);
                            delete self.cuaKhauPop;
                        }
                    }
                ]
            }, function () {
                ko.applyBindings(self.cuaKhauVM, document.getElementById('cuakhau-form'));
            });
        };
        self.cuaKhauVM = new CuaKhauVM(type, self);
        self.cuaKhauVM.search(cb);
        return false;
    };

    self.toJSON = function () {
        var d = {
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso(),
            fiTenCh: self.fiTenCh(),
            fiDiachiCh: self.fiDiachiCh(),
            fiSdtCh: self.fiSdtCh(),
            fiFaxCh: self.fiFaxCh(),
            fiEmailCh: self.fiEmailCh(),
            fiTenNgXk: self.fiTenNgXk(),
            fiDiachiNgXk: self.fiDiachiNgXk(),
            fiSdtNgXk: self.fiSdtNgXk(),
            fiFaxNgXk: self.fiFaxNgXk(),
            fiEmailNgXk: self.fiEmailNgXk(),
            fiSoTkhq: self.fiSoTkhq(),
            fiNgayNkTu: self.fiNgayNkTu(),
            fiNgayNkDen: self.fiNgayNkDen(),
            fiMaCkDi: self.fiMaCkDi(),
            fiTenCkDi: self.fiTenCkDi(),
            fiMaCkDen: self.fiMaCkDen(),
            fiTenCkDen: self.fiTenCkDen(),
            fiNgayKtTu: self.fiNgayKtTu(),
            fiNgayKtDen: self.fiNgayKtDen(),
            fiDiadiemKt: self.fiDiadiemKt(),
            fiMaTckt: self.fiMaTckt(),
            fiTenTckt: self.fiTenTckt(),
            fiNgayKy: self.fiNgayKy(),
            fiNguoiKy: self.fiNguoiKy(),
            fiNguoitao: self.fiNguoitao(),
            fiNgaytao: self.fiNgaytao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            fiTrangthai: self.fiTrangthai(),
            fiTenTt: self.fiTenTt(),
            fiNgaynop: self.fiNgaynop(),
            fiSoChungnhan: self.fiSoChungnhan(),
            fiNgaycapGcn: self.fiNgaycapGcn(),
            fiMaThutuc: data.maThuTuc,
            fiTenThutuc: self.fiTenThutuc(),
            lstHangHoas: [],
            lstDinhKems: [],
            lstNguoiChiuTrachNhiems: []
        };

        ko.utils.arrayForEach(self.lstHangHoas(), function (item) {
            d.lstHangHoas.push(item.toJson());
        });

        ko.utils.arrayForEach(self.lstNguoiChiuTrachNhiems(), function (item) {
            d.lstNguoiChiuTrachNhiems.push(item.toJson());
        });

        return d;
    };
}
