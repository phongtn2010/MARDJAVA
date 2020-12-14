/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre09CreateVM(options) {
    self = this;

    self.monre09FormVM = ko.observable(new Monre09FormVM(options));
    self.ThongTinGen09FormVM = ko.observable(new ThongTinGen09FormVM(options));
    self.mauGen09FormVM = ko.observable(new mauGen09FormVM(options));
    self.monre09FilesVM = ko.observable(new Monre09FilesVM(options));
    self.btnLuu = ko.observable(false);
    if (self.monre09FormVM().fiIdHoso() > 0) {
        if (self.monre09FormVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }
    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.monre09FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre09FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre09FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre09FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre09FormVM().fiTenTt(d.data.fiTenTt);
            self.monre09FormVM().fiNgaytao(new Date(d.data.fiNgaytao));

            self.monre09FilesVM().fiIdHoso(self.monre09FormVM().fiIdHoso());
            self.monre09FilesVM().fiMaHoso(self.monre09FormVM().fiMaHoso());
            self.monre09FilesVM().assignDocToAttachments();
        };

        if (!self.monre09FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        if (!self.monre09FormVM().isValidDate()) {
            app.Alert('Thời gian bắt đầu nhỏ hơn thời gian kết thúc');
            return;
        }
        if (!self.monre09FilesVM().isValidForm()) {
            app.Alert('Bạn chưa chọn đủ các tệp đính kèm!');
            return;
        }
        var fiIdHoso = self.monre09FormVM().fiIdHoso();
        var data = self.monre09FormVM().toJSON();
        data["lstDinhKem9"] = self.monre09FilesVM().toJSON();

        delete data['__ko_mapping__'];
        var url = !fiIdHoso || fiIdHoso <= 0 ? '/monre/09/hoso/taomoi' : '/monre/09/hoso/capnhap';
        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    $("#btnGui").css("display", "block");
                    cb(d);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                    $("#btnGui").css("display", "none");
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
                $("#btnGui").css("display", "none");
            }
        });
    };
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.monre09FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre09FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre09FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre09FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre09FormVM().fiTenTt(d.data.fiTenTt);
            self.monre09FormVM().fiNgaytao(new Date(d.data.fiNgaytao));
            self.monre09FilesVM().fiIdHoso(self.monre09FormVM().fiIdHoso());
            self.monre09FilesVM().fiMaHoso(self.monre09FormVM().fiMaHoso());
            self.monre09FilesVM().assignDocToAttachments();

        };

        if (!self.monre09FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        if (!self.monre09FormVM().isValidDate()) {
            app.Alert('Thời gian bắt đầu nhỏ hơn thời gian kết thúc');
            return;
        }
        if (!self.monre09FilesVM().isValidForm()) {
            app.Alert('Bạn chưa chọn đủ các tệp đính kèm!');
            return;
        }

        var fiIdHoso = self.monre09FormVM().fiIdHoso();
        var data = self.monre09FormVM().toJSON();
        data["lstDinhKem9"] = self.monre09FilesVM().toJSON();

        delete data['__ko_mapping__'];
//        app.makePost({
//            url: '/monre/09/hoso/send',
//            data: JSON.stringify(ko.toJS(data)),
//            success: function (d) {
//                if (d && d.success) {
//                    app.Alert('Gửi hồ sơ thành công');
//                    cb(d);
//                    History.go(-1);
//                } else {
//                    app.Alert('Không gửi được hồ sơ');
//                }
//            },
//            error: function (e) {
//                app.Alert('Không gửi được hồ sơ');
//            }
//        });
        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ này không ?</b>' ,
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(pop.selector);
                        app.makePost({
                            url: '/monre/09/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
//                                     $('#btnLuu').hide();
                                      setTimeout(function(){
                                        History.go(-1);
                                    }, 500);
//                                    History.go(-1);
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

$(document).ready(function () {

    var options = app.parseQuerystring();
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

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/09/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        $("#btnGui").css("display", "block");
                        options.hoso = d.data;
                        var monre09CreateVM = new Monre09CreateVM(options);
                        ko.applyBindings(monre09CreateVM, document.getElementById('Monre09CreateVM'));
                        $("#fiMa").select2({placeholder: '---Chọn---', width: '100%', allowClear: true});

                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var monre09CreateVM = new Monre09CreateVM(options);
            ko.applyBindings(monre09CreateVM, document.getElementById('Monre09CreateVM'));
            $("#fiMa").select2({placeholder: '---Chọn---', width: '100%', allowClear: true});
        }
    };

});

