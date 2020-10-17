/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre06ResultVM(options) {
    self = this;

    self.thongBaoVisible = ko.observable(false);
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    if (options.tab) {
        self.thongBaoVisible(true);
    }

    self.exportHref = ko.observable(app.appContext + "/monre/06/hoso/bieumau/" + options.fiIdHoso);

    self.monre06FormVM = ko.observable(new Monre06FormVM(options));
    self.monre06FilesVM = ko.observable(new Monre06FilesVM(options));
    self.monre06ThongBao = ko.observable(new ThongBaoVM(options));
}

$(document).ready(function () {

    var options = app.parseQuerystring();

    $.when(
            app.getCategory('/monre/06/danhmuc', 'DVXL', null, function (res) {
                if (res.success) {
                    options.lstDonViXuLy = res.data;
                }
            }),
            app.getCategory('/monre/06/danhmuc', 'CUAKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhau = res.data;
                } else {
                    options.lstCuaKhau = [];
                }
            })).done(function (data) {
        init();
    });

    var cb = function () {
        var most06ResultVM = new Monre06ResultVM(options);
        ko.applyBindings(most06ResultVM, document.getElementById('Monre06CreateVM'));
    };

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/06/hoso/t/' + options.fiIdHoso;
            var url_result = '/monre/06/hoso/thongbao';
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

