/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre07CreateVM(options) {
    self = this;

    self.monre07FormVM = ko.observable(new Monre07FormVM(options));
    self.monre07FilesVM = ko.observable(new Monre07FilesVM(options));

    self.btnLuu = ko.observable(false);
    if (self.monre07FormVM().fiIdHoso() > 0) {
        if (self.monre07FormVM().fiTrangthai() == TAO_MOI) {
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
            self.monre07FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre07FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre07FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre07FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre07FormVM().fiTenTt(d.data.fiTenTt);

            self.monre07FilesVM().fiIdHoso(self.monre07FormVM().fiIdHoso());
            self.monre07FilesVM().fiMaHoso(self.monre07FormVM().fiMaHoso());
            self.monre07FilesVM().assignDocToAttachments();
        };

        if (!self.monre07FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        if (!self.monre07FilesVM().isValidForm()) {
            app.Alert('Bạn phải tải lên ít nhất 1 file đính kèm.');
            return;
        }

        var fiIdHoso = self.monre07FormVM().fiIdHoso();
        var data = self.monre07FormVM().toJSON();
        data["lstDinhKem"] = self.monre07FilesVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/monre/07/hoso/taomoi' : '/monre/07/hoso/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
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
            self.monre07FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre07FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre07FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre07FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre07FormVM().fiTenTt(d.data.fiTenTt);

            self.monre07FilesVM().fiIdHoso(self.monre07FormVM().fiIdHoso());
            self.monre07FilesVM().fiMaHoso(self.monre07FormVM().fiMaHoso());
            self.monre07FilesVM().assignDocToAttachments();

        };

        if (!self.monre07FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        if (!self.monre07FilesVM().isValidForm()) {
            return;
        }

        var fiIdHoso = self.monre07FormVM().fiIdHoso();
        var data = self.monre07FormVM().toJSON();
        data["lstDinhKem"] = self.monre07FilesVM().toJSON();
        
        delete data['__ko_mapping__'];

        app.makePost({
            url: '/monre/07/hoso/send',
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Gửi hồ sơ thành công');
                    cb(d);
                } else {
                    app.Alert('Không gửi được hồ sơ');
                }
            },
            error: function (e) {
                app.Alert('Không gửi được hồ sơ');
            }
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

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/07/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most07CreateVM = new Monre07CreateVM(options);
                        ko.applyBindings(most07CreateVM, document.getElementById('Monre07CreateVM'));
                        $("#fiMaCqCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most07CreateVM = new Monre07CreateVM(options);
            ko.applyBindings(most07CreateVM, document.getElementById('Monre07CreateVM'));
            $("#fiMaCqCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

