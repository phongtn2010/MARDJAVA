/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre09ResultVM(options) {
    self = this;

    self.thongBaoVisible = ko.observable(false);
    self.btnTroLaiClick = function () {
        History.go(-1);
    };


    if (options.tab) {
        self.thongBaoVisible(true);
    }

    self.exportHref = ko.observable(app.appContext + "/monre/09/hoso/bieumau/" + options.fiIdHoso);

    self.monre09FormVM = ko.observable(new Monre09FormVM(options));
    self.monre09FilesVM = ko.observable(new Monre09FilesVM(options));
    self.monre09ThongBao = ko.observable(new ThongBaoVM(options));
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    debugger;
    $.when(
            app.getCategory('/monre/09/danhmuc', 'DVXL', null, function (res) {
                if (res.success) {
                    options.lstDonViXuLy = res.data;
                }
            }),
            app.getCategory('/monre/09/danhmuc', 'DINHKEM', null, function (res) {
                if (res.success) {
                    options.dmDinhKem = res.data;
                }
            })

    ).done(function (data) {
        init();
    });

    var cb = function () {
        var monre09ResultVM = new Monre09ResultVM(options);
        ko.applyBindings(monre09ResultVM, document.getElementById('Monre09ResultVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {

            debugger;

            var url = '/monre/09/hoso/t/' + options.fiIdHoso;
            var url_result = '/monre/09/hoso/thongbao';
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

