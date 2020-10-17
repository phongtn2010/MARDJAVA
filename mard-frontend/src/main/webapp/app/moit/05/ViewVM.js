/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function ViewVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.resultVM = ko.observable(new ResultVM(options));
    self.showCert = ko.observable(false);
    if (options.tab) {
        self.showCert(true);
    }
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
    });

    var cb = function () {
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moit/05/hoso/t/' + options.fiIdHoso;
            var url_result = '/moit/05/hoso/vanban';
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
                                            options.vanban = obj.data;
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

