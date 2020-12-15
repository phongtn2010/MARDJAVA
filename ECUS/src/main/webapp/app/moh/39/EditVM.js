/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function EditVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.formVM().hosoErrors.showAllMessages(false);
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI
                || self.formVM().fiTrangthai() == CHO_TIEP_NHAN
                || self.formVM().fiTrangthai() == TU_CHOI_HOSO
                || self.formVM().fiTrangthai() == YC_BO_SUNG) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moh/39/hoso/taomoi' : '/moh/39/hoso/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
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
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        //console.log(data);

        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/moh/39/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
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
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    };
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

var DINHKEMDATA = null;
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();

    var pName = document.location.pathname;
    var items = pName.split('/');
    var _documentType = items[items.length - 2];
    
    var documentType = '';
    if (parseInt(_documentType) === 12) {
        documentType = '/1';
    } else if (parseInt(_documentType) === 34) {
        documentType = '/2';
    } else {
        documentType = '/0';
    }
    
    //console.log(documentType);

    $.when(
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_DONVITINH', null, function (res) {
                if (res.success) {
                    options.lstDonViTinh = res.data;
                } else {
                    options.lstDonViTinh = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_CUAKHAU_NHAPKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhauNhap = res.data;
                } else {
                    options.lstCuaKhauNhap = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_NUOCSANXUAT', null, function (res) {
                if (res.success) {
                    options.ltsNuocSanXuat = res.data;
                } else {
                    options.ltsNuocSanXuat = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_LOAIDONHANG', options.maThuTuc + documentType, function (res) {
                if (res.success) {
                    options.lstLoaiDonHang = res.data;
                } else {
                    options.lstLoaiDonHang = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_LOAIFILE', options.maThuTuc, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_NGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstNguyenLieu = res.data;
                } else {
                    options.lstNguyenLieu = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_MUCDICHNHAPKHAU', options.maThuTuc + '/0', function (res) {
                if (res.success) {
                    options.lstMucDichNhapKhau = res.data;
                } else {
                    options.lstMucDichNhapKhau = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/39/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiLoaiDon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKems = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiLoaiDon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});
