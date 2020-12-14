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
    self.formVM = ko.observable(new FormVM(options));
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);
    self.btnGuiSua = ko.observable(false);

    if (self.formVM().registrationId() > 0) {

        if (self.formVM().codeStatus() == TAO_MOI) {
            self.btnLuu(true);
        }

    } else {
        self.btnLuu(true);
    }

    if (self.formVM().registrationId() > 0) {
        if (self.formVM().codeStatus() == TAO_MOI
            || self.formVM().codeStatus() == CHO_TIEP_NHAN
            || self.formVM().codeStatus() == YC_BOSUNG
            || self.formVM().codeStatus() == TC_HOSO

        ) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }
    if (self.formVM().registrationId() > 0) {
        if (self.formVM().codeStatus() == DONGY_SUA_HOSO
            || self.formVM().codeStatus() == DA_TIEP_NHAN
            || self.formVM().codeStatus() == TC_SUA_HOSO
        ) {
            self.btnGuiSua(true);
        }
    } else {
        self.btnGuiSua(false);
    }

    self.btnGuiSuaClick = function () {
        var reason = self.formVM().reason();
        var dataSend = self.formVM().toJSON();
        var fiIdHoso = self.formVM().registrationId();
        delete dataSend['__ko_mapping__'];
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
                            url: '/mard/p02/hoso/yc-sua',
                            data: JSON.stringify({
                                fiIdHoso: fiIdHoso,
                                reason: reason,
                                tbdRegistration02: dataSend
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

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        debugger;
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
        var cb = function (d) {
            if (!registrationId || registrationId <= 0) {
                self.formVM().nswfileCode(d.data.nswfileCode);
                self.formVM().createDate(new Date(d.data.createDate));
//                self.formVM().getLstTeptin();
            } else {
//                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }

            self.formVM().nswfileCode(d.data.nswfileCode);
            self.formVM().createBy(d.data.createBy);
            self.formVM().codeStatus(d.data.codeStatus);
            self.formVM().nameStatus(d.data.nameStatus);

        };
        var fiIdHoso = self.formVM().registrationId();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];
        debugger;
        var url = !fiIdHoso || fiIdHoso <= 0 ? '/mard/p02/hoso/taomoi' : '/mard/p02/hoso/capnhat';
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
                self.formVM().nswfileCode(d.data.nswfileCode);
                self.formVM().createDate(new Date(d.data.createDate));
            } else {
                self.formVM().nswfileCode(d.data.nswfileCode);
            }
            self.btnLuu(false);
            self.formVM().nswfileCode(d.data.nswfileCode);
            self.formVM().createBy(d.data.createBy);
            self.formVM().codeStatus(d.data.codeStatus);
//            self.formVM().fiTenTt(d.data.fiTenTt);

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
        var fiIdHoso = self.formVM().registrationId();
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
                            url: '/mard/p02/hoso/send',
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
        app.getCategory('/mard/p02/danhmuc', 'DM_HINHTHUC_KT', null, function (res) {
            if (res.success) {
                options.lstHinhThucKT = res.data;
            } else {
                options.lstHinhThucKT = [];
            }
        }),
        app.getCategory('/mard/p02/danhmuc', 'DM_LOAIDON', null, function (res) {
            if (res.success) {
                options.lstLoaiDon = res.data;
            } else {
                options.lstLoaiDon = [];
            }
        }),
        app.getCategory('/mard/p02/danhmuc', 'DM_LOAI_SP', null, function (res) {
            if (res.success) {
                options.lstLoaiSP = res.data;
            } else {
                options.lstLoaiSP = [];
            }
        }),
        app.getCategory('/mard/p02/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                DINHKEMDATA = res.data;
            } else {
                DINHKEMDATA = [];
            }
        }),
        app.getCategory('/mard/p02/danhmuc', 'DM_DVTINH', null, function (res) {
            if (res.success) {
                options.lstDvTinh = res.data;
            } else {
                options.lstDvTinh = [];
            }
        })
    ).done(function (data) {
        init();
        $('#loading10').hide();
    });
    var init = function () {

        if (options && options.registrationId > 0) {
            var url = '/mard/p02/hoso/t/' + options.registrationId;
            app.makePost({

                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        options.lstDinhKem02 = DINHKEMDATA;
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#registrationType").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#typeProduct").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#templateType").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKem02 = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#registrationType").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#typeProduct").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#templateType").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

        }
    };
});

