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
//    self.formVM().hosoErrors.showAllMessages(false);
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    if (self.formVM().fiIdHoSo() > 0) {

        if (self.formVM().fiMaTrangThai() == TAO_MOI) {
            self.btnLuu(true);
        }

    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoSo() > 0) {
        if (self.formVM().fiMaTrangThai() == TAO_MOI
                || self.formVM().fiMaTrangThai() == CHO_TIEP_NHAN
                || self.formVM().fiMaTrangThai() == YC_BOSUNG_HS
                || self.formVM().fiMaTrangThai() == TU_CHOI_TIEPNHAN_HS
                || self.formVM().fiMaTrangThai() == YC_BOSUNG_THANHPHAN_HS) {
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
            if (!fiIdHoSo || fiIdHoSo <= 0) {
                self.formVM().fiIdHoSo(d.data.fiIdHoSo);
                self.formVM().fiNgayTao(new Date(d.data.fiNgayTao));
//                self.formVM().getLstTeptin();
            } else {
//                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }

//            if (d.data.fiTrangthai === 0) {
//                var TenTrangthai = "Mới tạo";
//            }
            self.formVM().fiIdHoSo(d.data.fiIdHoSo);
            self.formVM().fiNguoiTao(d.data.fiNguoiTao);
            self.formVM().fiMaTrangThai(d.data.fiMaTrangThai);
            self.formVM().fiTenTrangThai(d.data.fiTenTrangThai);
//            self.formVM().fiTenTrangThai(TenTrangthai);

        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }
//        if (!self.formVM().isValidTbnk()) {
//            app.Alert('Phải nhập đầy đủ thông tin thiết bị nhạp khẩu');
//            return;
//        } 


        var fiIdHoso = self.formVM().fiIdHoSo();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/mic/p02/hoso/taomoi' : '/mic/p02/hoso/capnhap';
        app.makePost({
            url: url,
            data: JSON.stringify(data),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
//                    cb(d);
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
                self.formVM().fiIdHoSo(d.data.fiIdHoSo);
                self.formVM().fiNgayTao(new Date(d.data.fiNgayTao));
            } else {
                self.formVM().fiIdHoSo(d.data.fiIdHoSo);
            }
            self.formVM().fiMaHoSo(d.data.fiMaHoSo);
            self.formVM().fiNguoiTao(d.data.fiNguoiTao);
            self.formVM().fiMaTrangThai(d.data.fiMaTrangThai);
//            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };
        if (!self.formVM().isValidForm()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
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
                            url: '/mic/p02/hoso/send',
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
            app.getCategory('/mic/p02/danhmuc', 'DM_NOICAPGP', null, function (res) {
                if (res.success) {
                    options.lstNoiCP = res.data;
                } else {
                    options.lstNoiCP = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_MUCDICH', null, function (res) {
                if (res.success) {
                    options.lstMucDich = res.data;
                } else {
                    options.lstMucDich = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                } else {
                    RAW_HS_STATUS = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_TEVTV', null, function (res) {
                if (res.success) {
                    options.lstDMTenTV = res.data;
                } else {
                    options.lstDMTenTV = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_KIEUIN', null, function (res) {
                if (res.success) {
                    options.lstDMKieuIn = res.data;
                } else {
                    options.lstDMKieuIn = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_CHATLUONG', null, function (res) {
                if (res.success) {
                    options.lstDMChatLuong = res.data;
                } else {
                    options.lstDMChatLuong = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_DVTKHUANKHO', null, function (res) {
                if (res.success) {
                    options.lstDMDvKhuankho = res.data;
                } else {
                    options.lstDMDvKhuankho = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_DVTTOCDO', null, function (res) {
                if (res.success) {
                    options.lstDMDvTocDo = res.data;
                } else {
                    options.lstDMDvTocDo = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_TEPTIN', null, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {

        if (options && options.fiIdHoSo > 0) {
            var url = '/mic/p02/hoso/t/' + options.fiIdHoSo;
            app.makePost({

                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {

                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiNoiCapGpMa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstTeptin02 = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiNoiCapGpMa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

        }
    };
});

