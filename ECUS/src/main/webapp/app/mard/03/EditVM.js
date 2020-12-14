/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

function EditVM(options) {
    self = this;
    self.showResult = ko.observable(false);
    self.formVM = ko.observable(new FormVM(options));
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);
    self.btnGuiSua = ko.observable(false);
    self.btnGuiSuaXNCL = ko.observable(false);

    // lay thong tin hien thi cho phan don xac nhan kiem dich
    if (self.formVM().fiTrangThaiMa() === 7) {
        self.showResult(true);
        self.resultVM = ko.observable(new XNDONVM(options));
    } else {
        self.showResult(false);
    }

    if (self.formVM().fiIdHoSo() > 0) {
        if (self.formVM().fiTrangThaiMa() == DA_TIEP_NHAN || self.formVM().fiTrangThaiMa() == DONGY_CHINHSUA_HS
            || self.formVM().fiTrangThaiMa() == TC_YC_SUA_HS || self.formVM().fiTrangThaiMa() == XACNHAN_DON_DK) {
            self.btnGuiSua(true);
        }

    } else {
        self.btnGuiSua(false);
    }

    if (self.formVM().fiIdHoSo() > 0) {
        if (self.formVM().fiTrangThaiMa() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }
    if (self.formVM().fiIdHoSo() > 0) {
        if (self.formVM().fiTrangThaiMa() == TAO_MOI
            || self.formVM().fiTrangThaiMa() == CHO_TIEP_NHAN
            || self.formVM().fiTrangThaiMa() == YC_BOSUNG_HS
            || self.formVM().fiTrangThaiMa() == DA_BOSUNG_HS
        ) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnGuiSuaClick = function () {
        var fiIdHoso = self.formVM().fiIdHoSo();
        var reason = self.formVM().reason();
        var dataSend = self.formVM().toJSON();
        delete dataSend['__ko_mapping__'];
        if (!self.formVM().isValidLydo()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }
        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi yêu cầu sửa hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(pop.selector);
                        app.makePost({
                            url: '/mard/p03/hoso/yc-sua',
                            data: JSON.stringify({
                                fiIdHoso: fiIdHoso,
                                reason: reason,
                                requestDate: new Date(),
                                tbdHoSo03: dataSend
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi sửa hồ sơ thành công');
//                                    cb(d);
                                    setTimeout(function () {
                                        History.go(-1);
                                    }, 500);
                                } else {
                                    app.Alert('Không gửi được yêu cầu');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
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

    };
    self.btnLuuClick = function () {
        var cb = function (d) {
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiMaHoSo(d.data.fiMaHoSo);
                self.formVM().createDate(new Date(d.data.createDate));
//                self.formVM().getLstTeptin();
            } else {
//                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }

            self.formVM().fiMaHoSo(d.data.fiMaHoSo);
            self.formVM().createBy(d.data.createBy);
            self.formVM().codeStatus(d.data.codeStatus);
            self.formVM().nameStatus(d.data.nameStatus);

        };

        if (!self.formVM().isValidForm()) {
            $("#a-tab-mt-1").tab('show');
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }
        if (!self.formVM().validFile()) {
            $("#a-tab-2").tab('show');
            app.Alert('Bạn cần nhập đủ dữ liệu tệp đính kèm');
            return;
        }


        var fiIdHoso = self.formVM().fiIdHoSo();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/mard/p03/hoso/taomoi' : '/mard/p03/hoso/capnhat';
        app.makePost({
            url: url,
            data: JSON.stringify(data),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    setTimeout(function () {
                        History.go(-1);
                    }, 500);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
            }
        });
    };
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiMaHoSo(d.data.fiMaHoSo);
                self.formVM().createDate(new Date(d.data.createDate));
            } else {
                self.formVM().fiMaHoSo(d.data.fiMaHoSo);
            }
            self.btnLuu(false);
            self.formVM().fiMaHoSo(d.data.fiMaHoSo);
            self.formVM().createBy(d.data.createBy);
            self.formVM().codeStatus(d.data.codeStatus);
        };


        if (!self.formVM().isValidForm()) {
            $("#a-tab-mt-1").tab('show');
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }
        if (!self.formVM().validFile()) {
            $("#a-tab-2").tab('show');
            app.Alert('Bạn cần nhập đủ dữ liệu tệp đính kèm');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoSo();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(pop.selector);
                        app.makePost({
                            url: '/mard/p03/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
//                                    cb(d);
                                    setTimeout(function () {
                                        History.go(-1);
                                    }, 500);
                                } else {
                                    app.Alert('Không gửi được hồ sơ');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được hồ sơ');
                            }
                        });
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
    };

    /**
     * button xin chuyển cửa khẩu
     */
    self.btnXinChuyenCkClick = function () {
        var fiIdHoso = self.formVM().fiIdHoSo();
        var fiMaHoso = self.formVM().fiMaHoSo();

        var data = self.formVM().toJSON();

        var html = [
            $('#xinchuyenck-tmpl').html()
        ].join('');
        delete data['__ko_mapping__'];

        var msg = "Bạn chắc chắn muốn gửi yêu cầu xin chuyển cửa khẩu";
        self.xinChuyenCk = new XinChuyenCK(msg, data);

        self.pop = app.popup({
            title: 'Xin chuyển cửa khẩu',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.makePost({
                            url: '/mard/p03/xinChuyenCk',
                            data: JSON.stringify({
                                fiIdHoso: fiIdHoso,
                                fiMaHoso: fiMaHoso,
                                reason: self.xinChuyenCk.fiNoiDungCK(),
                                soContainer: data.lstHangHoa03[0].ptVchuyenMoi,
                                fiSoGcn: data.fiSoGcnKdNk,
                                lstHanghoa: data.lstHangHoa03
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi xin chuyển cửa khẩu thành công.');
                                    setTimeout(function () {
                                        History.go(-1);
                                    }, 500);
                                } else {
                                    app.Alert('Không gửi được yêu cầu');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });

        ko.applyBindings(self.xinChuyenCk, document.getElementById('xinchuyenck-form'));
        return false;
    };

    /**
     *btn quay tro lai
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

var DINHKEMDATA = null;
var RAW_HS_STATUS = null;
$(document).ready(function () {
    var options = app.parseQuerystring();
    $('#loading10').show();
    $.when(
        app.getCategory('/mard/p03/danhmuc', 'DM_TRANGTHAI', null, function (res) {
            if (res.success) {
                options.lstDanhMuc = res.data;
            } else {
                options.lstDanhMuc = [];
            }
        }),
        app.getCategory('/mard/p03/danhmuc', 'DM_CQXL', null, function (res) {
            if (res.success) {
                options.lstCQXL = res.data;
            } else {
                options.lstCQXL = [];
            }
        }),
        app.getCategory('/mard/p03/danhmuc', 'DM_CUAKHAU', null, function (res) {
            if (res.success) {
                options.lstCuaKhau = res.data;
            } else {
                options.lstCuaKhau = [];
            }
        }),
        app.getCategory('/mard/p03/danhmuc', 'DM_QUOCGIA', null, function (res) {
            if (res.success) {
                options.lstQuocGia = res.data;
            } else {
                options.lstQuocGia = [];
            }
        })
    ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var cb = function () {
        var editVM = new EditVM(options);
        ko.applyBindings(editVM, document.getElementById('EditVM'));
    };

    var init = function () {

        options.lstRegPlace = [
            {maDky: "1", tenDky: "Cửa khẩu khập"},
            {maDky: "2", tenDky: "Cửa khẩu xuất"}
        ];
        options.lstSoLuongDvt = [
            {maDvt: "BAO", tenDvt: "Bao"},
            {maDvt: "KIEN", tenDvt: "Kiện"},
            {maDvt: "CONG", tenDvt: "Công"},
            {maDvt: "GOI", tenDvt: "Gói"}
        ];
        options.lstDvt = [
            {maDvt: "KG", tenDvt: "Kilogam"},
            {maDvt: "YEN", tenDvt: "Yến"},
            {maDvt: "TA", tenDvt: "Tạ"},
            {maDvt: "TAN", tenDvt: "Tấn"}
        ];
        options.lstGiong = [
            {maGiong: "0", tenGiong: "Cái"},
            {maGiong: "1", tenGiong: "Đực"}
        ];
        options.lstLoaiSp = [
            {maLoaiSp: 1, tenLoaiSp: "Động vật"},
            {maLoaiSp: 2, tenLoaiSp: "Sản phẩm động vật"},
        ];

        if (options && options.fiIdHoSo > 0) {
            var url = '/mard/p03/hoso/t/' + options.fiIdHoSo;
            var url_xndon = '/mard/p03/hoso/xacnhandon/' + options.fiIdHoSo;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        options.lstTepTin03 = DINHKEMDATA;
                        if (options.hoso.fiTrangThaiMa === 7) {
                            app.makePost({
                                url: url_xndon,
                                data: JSON.stringify({}),
                                success: function (obj) {
                                    if (obj.success) {
                                        if (obj.data != null) {
                                            options.xnDon = obj.data;
                                            cb();
                                        }
                                    }
                                },
                                error: function (e) {
                                    app.Alert('Không lấy được dữ liệu đơn đăng ký kiểm dịch.');
                                    cb();
                                }
                            });
                        } else {
                            cb();
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            cb();
        }
        $("#departmentCode").select2({placeholder: '-- Chọn cơ quan xử lý --', width: '100%', allowClear: true});
        $("#regPlace").select2({placeholder: '-- Chọn nơi đăng ký --', width: '100%', allowClear: true});
        $("#fiMaSoLuongDvt").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#fiMaTrongLuongTinhDvt").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#fiMaTrongLuongBaoBidvt").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#fiNuocXk").select2({placeholder: '-- Chọn nước xuất khẩu --', width: '100%', allowClear: true});
        $("#fiCuaKhauXuat").select2({placeholder: '-- Chọn cửa khẩu xuất khẩu --', width: '100%', allowClear: true});
        $("#fiNuocNk").select2({placeholder: '-- Chọn nước nhập khẩu --', width: '100%', allowClear: true});
        $("#fiCuaKhauNhap").select2({placeholder: '-- Chọn của khẩu nhập khẩu --', width: '100%', allowClear: true});
        $("#fiMaLoaiSp").select2({placeholder: '-- Chọn loại sản phẩm --', width: '100%', allowClear: true});
    };
});

function XinChuyenCK(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(item.fiMaHoso);
    self.fiNoiDungCK = ko.observable(null);
}