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
            || self.formVM().fiTrangthai() == YC_BOSUNG
            || self.formVM().fiTrangthai() == TU_CHOI_HS
        ) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    // valid tong file dinh kem
    self.validTotalFiles = function(data) {
        debugger;
        var flag = true;
        var totalSize = 0;
        for (var i = 0; i < data.lstDinhkem03.length; i++) {
            var attach = data.lstDinhkem03[i];
            if (attach.fiBatbuoc) {
                totalSize += parseFloat(attach.fiSize);
            } else if (!attach.fiBatbuoc && attach.fiTenTailieu) {
                totalSize += parseFloat(attach.fiSize);
            }
        }
        if (totalSize > 15) {
            app.Alert('Tổng dung lượng các tệp đính kèm bắt buộc không quá 15MB');
            flag = false;
        }
        return flag;
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        if(!self.formVM().showValidHH()){
            app.Alert('Ngày cấp phải nhỏ hơn hoặc bằng ngày hiện tại');
            return;
        }
        if(!self.formVM().showValidGPS()){
            app.Alert('Ngày cấp GSP phải nhỏ hơn hoặc bằng ngày hiện tại');
            return;
        }
        if (!self.formVM().isValidForm()) {
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }
        var cb = function (d) {
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            }
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        if (!self.validTotalFiles(data)) {
            return;
        }

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moh/p03/hoso/taomoi' : '/moh/p03/hoso/capnhat';
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
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            }
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);

        };
        if(!self.formVM().showValidHH()){
            app.Alert('Ngày cấp phải nhỏ hơn hoặc bằng ngày hiện tại');
            return;
        }
        if(!self.formVM().showValidGPS()){
            app.Alert('Ngày cấp GSP phải nhỏ hơn hoặc bằng ngày hiện tại');
            return;
        }
        if (!self.formVM().isValidForm()) {
            $("#a-tab-mt-1").tab('show');
            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        if (!self.validTotalFiles(data)) {
            return;
        }

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
                            url: '/moh/p03/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
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
        app.getCategory('/moh/p03/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                DINHKEMDATA = res.data;
            } else {
                DINHKEMDATA = [];
            }
        }),
        app.getCategory('/moh/p03/danhmuc', 'DM_CUAKHAU', null, function (res) {
            if (res.success) {
                options.lstDmCuakhau = res.data;
            } else {
                options.lstDmCuakhau = [];
            }
        }),
        app.getCategory('/moh/p03/danhmuc', 'DM_DUOCLIEU', null, function (res) {
            if (res.success) {
                options.lstDuoclieu = res.data;
            } else {
                options.lstDuoclieu = [];
            }
        }),
        app.getCategory('/moh/p03/danhmuc', 'DM_DONVI_TINH', null, function (res) {
            if (res.success) {
                options.lstDvt = res.data;
            } else {
                options.lstDvt = [];
            }
        }),
        app.getCategory('/moh/p03/danhmuc', 'DM_TCCL', null, function (res) {
            if (res.success) {
                options.lstTccl = res.data;
            } else {
                options.lstTccl = [];
            }
        }),
        app.getCategory('/moh/p03/danhmuc', 'DM_QUOCGIA', null, function (res) {
            if (res.success) {
                options.lstQuocgia = res.data;
            } else {
                options.lstQuocgia = [];
            }
        })
    ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/p03/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        options.lstDinhkem03 = DINHKEMDATA;
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        for( var i = 0 ; i < d.data.lstCuakhau03.length; i++){
                            $("#fiMaCuakhau-" + d.data.lstCuakhau03[i].fiIdCuakhau).select2({placeholder: '--- Chọn ---', width: '100%', allowClear: true});
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhkem03 = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
        }
    };
});

