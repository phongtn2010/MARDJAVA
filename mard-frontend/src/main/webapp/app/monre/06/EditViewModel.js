/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Monre06CreateVM(options) {
    self = this;

    self.monre06FormVM = ko.observable(new Monre06FormVM(options));
    self.monre06FilesVM = ko.observable(new Monre06FilesVM(options));

    self.btnLuu = ko.observable(false);
    if (self.monre06FormVM().fiIdHoso() > 0) {
        if (self.monre06FormVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    //Remove from toJSON
    self.onTrucTiepClick = function () {
        self.monre06FormVM().fiHinhthuc(0);
        self.monre06FilesVM().updateList(0);
        return true;
    };
    //Remove from toJSON
    self.onUyThacClick = function () {
        self.monre06FormVM().fiHinhthuc(1);
        self.monre06FilesVM().updateList(1);
        return true;
    };
    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.monre06FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre06FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre06FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre06FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre06FormVM().fiTenTt(d.data.fiTenTt);
            
            self.monre06FilesVM().fiIdHoso(self.monre06FormVM().fiIdHoso());
            self.monre06FilesVM().fiMaHoso(self.monre06FormVM().fiMaHoso());
            self.monre06FilesVM().assignDocToAttachments();
        };

        if (!self.monre06FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        if (!self.monre06FilesVM().isValidForm()) {
            return;
        }

        var fiIdHoso = self.monre06FormVM().fiIdHoso();
        var data = self.monre06FormVM().toJSON();
        data["lstDinhKem"] = self.monre06FilesVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/monre/06/hoso/taomoi' : '/monre/06/hoso/capnhap';

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
            self.monre06FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre06FormVM().fiMaHoso(d.data.fiMaHoso);            
            self.monre06FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre06FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre06FormVM().fiTenTt(d.data.fiTenTt);
            
            self.monre06FilesVM().fiIdHoso(self.monre06FormVM().fiIdHoso());
            self.monre06FilesVM().fiMaHoso(self.monre06FormVM().fiMaHoso());
            self.monre06FilesVM().assignDocToAttachments();
            
        };

        if (!self.monre06FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        if (!self.monre06FilesVM().isValidForm()) {
            return;
        }

        var fiIdHoso = self.monre06FormVM().fiIdHoso();
        var data = self.monre06FormVM().toJSON();
        data["lstDinhKem"] = self.monre06FilesVM().toJSON();

        delete data['__ko_mapping__'];

        app.makePost({
            url: '/monre/06/hoso/send',
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

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/06/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most06CreateVM = new Monre06CreateVM(options);
                        ko.applyBindings(most06CreateVM, document.getElementById('Monre06CreateVM'));
                        $("#fiMaCqCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiLhMaCuakhau").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
                        $("#fiTenphelieu").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most06CreateVM = new Monre06CreateVM(options);
            ko.applyBindings(most06CreateVM, document.getElementById('Monre06CreateVM'));
            $("#fiMaCqCap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiLhMaCuakhau").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
            $("#fiTenphelieu").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
        }
    };
});

