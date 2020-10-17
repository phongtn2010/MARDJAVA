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
        if (options.requestedit) {
            self.formVM().visibleLyDoXinSua(true);
        }

    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI
                || self.formVM().fiTrangthai() == CHO_TIEP_NHAN
                || self.formVM().fiTrangthai() == YC_BO_SUNG
                || self.formVM().fiTrangthai() == TU_CHOI_TIEP_NHAN_HS) {
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
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
//                self.formVM().getLstTeptin();
            } else {
//                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }

            if (d.data.fiTrangthai === 0) {
                var TenTrangthai = "Mới tạo";
            }
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTrangthai(TenTrangthai);

        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        } else {
            if (!self.formVM().isValidPhongXa()) {
                app.Alert('Phải nhập hoặc nguồn phóng xạ kín hoặc nguồn phóng xạ hở.');
                return;
            }
        }


        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/most/p05/hoso/taomoi' : '/most/p05/hoso/capnhap';
        debugger;
        app.makePost({
            url: url,
            data: JSON.stringify(data),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
                    setTimeout(function () {
                        History.go(-1);
                    }, 500);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
//                    app.Alert('Lưu dữ liệu thành công');
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
//                app.Alert('Lưu dữ liệu thành công');
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
                self.formVM().fiIdHoso(d.data.fiIdHoso);
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            } else {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
//            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        } else {
            if (!self.formVM().isValidPhongXa()) {
                app.Alert('Phải nhập nguồn phóng xạ kín hoặc nguồn phóng xạ hở.');
            }
        }

        var fiIdHoso = self.formVM().fiIdHoso();
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
                            url: '/most/p05/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    //cb(d);
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
     * Tro lai man hinh danh sach
     * @returns {undefined}
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
            app.getCategory('/most/p05/danhmuc', 'DM_CQXL', null, function (res) {
                if (res.success) {
                    options.lstCQXL = res.data;
                } else {
                    options.lstCQXL = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_HINHTHUCCAP', null, function (res) {
                if (res.success) {
                    options.lstHinhThuccap = res.data;
                } else {
                    options.lstHinhThuccap = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_HOATDODONVI', null, function (res) {
                if (res.success) {
                    options.lstHoatDoDonVi = res.data;
                } else {
                    options.lstHoatDoDonVi = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_DONGVIPX', null, function (res) {
                if (res.success) {
                    options.lstDongViPX = res.data;
                } else {
                    options.lstDongViPX = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_NGUONKIN', null, function (res) {
                if (res.success) {
                    options.lstNguonPXK = res.data;
                } else {
                    options.lstNguonPXK = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_NGUONHO', null, function (res) {
                if (res.success) {
                    options.lstNguonPXH = res.data;
                } else {
                    options.lstNguonPXH = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_LYDODN', null, function (res) {
                if (res.success) {
                    options.lstLyDoDN = res.data;
                } else {
                    options.lstLyDoDN = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_CUAKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhau = res.data;
                } else {
                    options.lstCuaKhau = [];
                }
            }),
            app.getCategory('/most/p05/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                } else {
                    RAW_HS_STATUS = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });
    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/p05/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiMaCoQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiHinhThucCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#lydocaplai").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiNkcpxMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiNkcpxMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
//            options.lstDinhKem = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaCoQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiHinhThucCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#lydocaplai").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiNkcpxMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiNkcpxMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

