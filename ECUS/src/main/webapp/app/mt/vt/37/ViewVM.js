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
        if (!self.isValidForm())
            return;

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

        self.yeuCauVM = new YeuCauVM('Bạn chắc chắn muốn gửi yêu cầu xin sửa Công văn:  ', self, '/mt/37/hoso/yc-suavanban');

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
                        });
                    }
                }
            ]
        });

        ko.applyBindings(self.yeuCauVM, document.getElementById('ruthoso-form'));
        return false;
    };
    /**
     * Tra lai CV
     * @returns {undefined}
     */
    self.btnTraLaiCVClick = function () {
        var html = [
            $('#yeucau-tmpl').html()
        ].join('');
        delete self.yeuCauVM;
        delete self.pop;

        self.yeuCauVM = new YeuCauVM('Bạn chắc chắn muốn gửi yêu cầu trả lại Công văn:  ', self, '/mt/37/hoso/yc-tralaivanban');

        self.pop = app.popup({
            title: 'Trả lại Công văn',
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
                            self.search(self.paging().currentPage());
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
    $('#loading10').show();
    var options = app.parseQuerystring();
    $.when(
            app.getCategory('/mt/37/danhmuc', 'HS_DONVIXULY', options.maThuTuc, function (res) {
                if (res.success) {
                    options.lstDonViXuLy = res.data;
                } else {
                    options.lstDonViXuLy = [];
                }
            }),
            app.getCategory('/mt/37/danhmuc', 'HS_HINHTHUC', options.maThuTuc, function (res) {
                if (res.success) {
                    options.lstHinhThuc = res.data;
                } else {
                    options.lstHinhThuc = [];
                }
            }),
            app.getCategory('/mt/37/danhmuc', 'HS_TUYENVANTAI', null, function (res) {
                if (res.success) {
                    options.lstTuyen = res.data;
                } else {
                    options.lstTuyen = [];
                }
            }),
            app.getCategory('/mt/37/danhmuc', 'HS_NHANHIEU', null, function (res) {
                if (res.success) {
                    options.lstLoaiXe = res.data;
                } else {
                    options.lstLoaiXe = [];
                }
            }),
            app.getCategory('/mt/37/danhmuc', 'HS_LOAIFILE', options.maThuTuc, function (res) {
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

    var cb = function () {
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/mt/37/hoso/t/' + options.fiIdHoso;
            var url_result = '/mt/37/hoso/vanban';
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

