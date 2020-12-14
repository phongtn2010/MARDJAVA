/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);
function YeuCauVM(fiMsg, item, action) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiIdHoso = ko.observable(item.formVM().fiIdHoso());
    self.fiMaHoso = ko.observable(item.formVM().fiMaHoso());
    self.fiTrangthai = ko.observable(item.formVM().fiTrangthai());
    self.fiContent = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    var lstVG = [self.fiContent];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.fiTrangthai() > 1) {
            if (self.lstErrors().length > 0) {
                self.lstErrors.showAllMessages();
                return false;
            }
        }
        if (item.resultVM().toJson() == '') {
            return false;
        }
        return true;
    };

    self.makeRequest = function (cb) {

        app.makePost({
            url: action,
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiContent(),
                fiMaHoso: self.fiMaHoso(),
                fiSoGp: item.resultVM().toJson()
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                    cb();
                } else {
                    msg = data.message ? data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                }
                app.Alert(msg);
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
}
function ViewVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.resultVM = ko.observable(new ResultVM(options));
    self.showCert = ko.observable(false);

    if (options.tab) {
        self.showCert(true);
    }

    /**
     * Xin sua CV
     * @returns {undefined}
     */
    self.btnXinSuaCVClick = function () {
        var html = [
            $('#yeucau-tmpl').html()
        ].join('');
        delete self.yeuCauVM;
        delete self.pop;

        self.yeuCauVM = new YeuCauVM('Bạn chắc chắn muốn gửi yêu cầu xin sửa Công văn:  ', self, '/most/p05/hoso/yc-suavanban');
        if (!self.yeuCauVM.isValidForm)
            return;
        self.pop = app.popup({
            title: 'Xin sửa Công văn',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.yeuCauVM.makeRequest(function () {
                            app.popupRemove(self.pop.selector);
                            History.go(-1);
                        });
                    }
                }
            ]
        });

        ko.applyBindings(self.yeuCauVM, document.getElementById('ruthoso-form'));
        return false;
    };
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.formVM().hosoErrors.showAllMessages(false);
}

$(document).ready(function () {
    var options = app.parseQuerystring();
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
    });

    var cb = function () {
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/p05/hoso/t/' + options.fiIdHoso;
            var url_result = '/most/p05/hoso/vanban';
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        if (options.tab) {
                            app.makePost({
                                url: url_result,
                                data: JSON.stringify({
                                    fiIdHoso: options.fiIdHoso,
                                    fiMaHoso: options.fiMaHoso
                                }),
                                success: function (obj) {
                                    if (obj.success) {
                                        if (obj.data != null) {
                                            options.giayphep = obj.data;
                                            cb();
                                        }
                                    }
                                },
                                error: function (e) {
                                    app.Alert('Không lấy được dữ liệu công văn.');
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
        }
    };
});

