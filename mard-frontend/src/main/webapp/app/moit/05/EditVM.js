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
                || self.formVM().fiTrangthai() == DA_TIEP_NHAN
                || self.formVM().fiTrangthai() == DA_BO_SUNG_HOSO
                || self.formVM().fiTrangthai() == DONG_Y_YC_SUA
                || self.formVM().fiTrangthai() == TU_CHOI_YC_SUA) {
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
            } else {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };
        debugger;
        if (!self.formVM().isValidForm()) {
            app.Alert('Cần nhập đủ dữ liệu các trường BẮT BUỘC (*)');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moit/05/hoso/taomoi' : '/moit/05/hoso/capnhap';

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
                self.formVM().fiIdHoso(d.data.fiIdHoso);
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            } else {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Cần nhập đủ dữ liệu các trường BẮT BUỘC (*)');
            return;
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
                            url: '/moit/05/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
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
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();
    $.when(
            app.getCategory('/moit/05/danhmuc', 'DM_LOAIFILE', null, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            }),
            app.getCategory('/moit/05/danhmuc', 'DM_LOAINGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstLoaiNguyenlieu = res.data;
                } else {
                    options.lstLoaiNguyenlieu = [];
                }
            }),
            app.getCategory('/moit/05/danhmuc', 'DM_TENNGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstTenNguyenlieu = res.data;
                } else {
                    options.lstTenNguyenlieu = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moit/05/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhkems = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
        }
    };
});

