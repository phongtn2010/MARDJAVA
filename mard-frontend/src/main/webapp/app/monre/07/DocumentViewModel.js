/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre07ResultVM(options) {
    self = this;

    self.thongBaoVisible = ko.observable(false);
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    if (options.tab) {
        self.thongBaoVisible(true);
    }

    self.exportHref = ko.observable(app.appContext + "/monre/07/hoso/bieumau/" + options.fiIdHoso);

    self.monre07FormVM = ko.observable(new Monre07FormVM(options));
    self.monre07FilesVM = ko.observable(new Monre07FilesVM(options));
    self.monre07ThongBao = ko.observable(new ThongBaoVM(options));
}

$(document).ready(function () {

    var options = app.parseQuerystring();

    $.when(
            app.getCategory('/monre/07/danhmuc', 'DVXL', null, function (res) {
                if (res.success) {
                    options.lstDonViXuLy = res.data;
                }
            }),
            app.getCategory('/monre/07/danhmuc', 'TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            })
    ).done(function (data) {
        init();
    });

    var cb = function () {
        var most07ResultVM = new Monre07ResultVM(options);
        ko.applyBindings(most07ResultVM, document.getElementById('Monre07ResultVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/07/hoso/t/' + options.fiIdHoso;
            var url_result = '/monre/07/hoso/thongbao';
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
                                success: function (d) {
                                    if (d.success) {
                                        if (d.data != null) {
                                            options.thongbao = d.data;
                                            cb();
                                        }
                                    }
                                },
                                error: function (e) {
                                    app.Alert('Không lấy được dữ liệu thông báo lô hàng.');
                                    cb();
                                }
                            });
                        } else {
                            cb();
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ.');
                }
            });

        } else {
            app.Alert('Bạn phải chọn hồ sơ cần xem.');
        }
    };
});

