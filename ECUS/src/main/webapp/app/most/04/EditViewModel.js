/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Most04CreateVM(options) {
    self = this;

    self.most04FormVM = ko.observable(new Most04FormVM(options));
    self.most04FilesVM = ko.observable(new Most04FilesVM(options));

    self.btnLuuClick = function () {
        var cb = function (d) {
            self.most04FormVM().fiIdHoso(d.data.fiIdHoso);
            self.most04FormVM().fiMaHoso(d.data.fiMaHoso);
            self.most04FormVM().fiNguoitao(d.data.fiNguoitao);
            self.most04FormVM().fiTrangthai(d.data.fiTrangthai);
            self.most04FormVM().fiTenTt(d.data.fiTenTt);
            self.most04FormVM().hangHoas(ListTbdhanghoaModel(d.data.hangHoas));

            self.most04FilesVM().tepDinhKems(ListTbddinhkem4Model(d.data.tepDinhKems));
        };
        
        if (!self.most04FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-1').trigger('click');
            return;
        }
        if (!self.most04FilesVM().isValidForm()) {
            $('#a-tab-2').trigger('click');
            return;
        }

        var fiIdHoso = self.most04FormVM().fiIdHoso();
        var data = self.most04FormVM().toJSON();
        data["tepDinhKems"] = self.most04FilesVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/most/04/hoso/taomoi' : '/most/04/hoso/capnhap';

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

    self.fileUpload = function (data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
    };
    self.btnImportClick = function () {
        if (!self.formData) {
            app.Alert('Bạn chưa chọn tệp để import?');
            return;
        }

        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/most/04/import',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(app.config.CSRF_TOKEN_NAME, app.config.CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if (res && res.success) {
                    app.Alert('Import thành công!');
                    self.most04FormVM().afterImportExcel(res.data);
                } else {
                    app.Alert('Import không thành công!');
                }
            },
            error: function (x, t, m) { app.Alert('Import không thành công!');},
            complete: function (jqXHR, textStatus) { $('#loading10').hide(); }
        });
    };
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.most04FormVM().fiIdHoso(d.data.fiIdHoso);
            self.most04FormVM().fiMaHoso(d.data.fiMaHoso);
            self.most04FormVM().fiLydoXinsua(d.data.fiLydoXinsua);
            self.most04FormVM().fiNguoitao(d.data.fiNguoitao);
            self.most04FormVM().fiTrangthai(d.data.fiTrangthai);
            self.most04FormVM().fiTenTt(d.data.fiTenTt);
            self.most04FormVM().hangHoas(ListTbdhanghoaModel(d.data.hangHoas));

            self.most04FilesVM().fiIdHoso(d.data.fiIdHoso);
            self.most04FilesVM().tepDinhKems(ListTbddinhkem3Model(d.data.tepDinhKems));
        };

        if (!self.most04FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-1').trigger('click');
            return;
        }
        if (!self.most04FilesVM().isValidForm()) {
            $('#a-tab-2').trigger('click');
            return;
        }

        var fiIdHoso = self.most04FormVM().fiIdHoso();
        var data = self.most04FormVM().toJSON();
        data["tepDinhKems"] = self.most04FilesVM().toJSON();

        delete data['__ko_mapping__'];

        app.makePost({
            url: '/most/04/hoso/send',
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
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    self.exportHref = function () {};

}

$(document).ready(function () {

    var options = app.parseQuerystring();

    $.when(
            app.getCategory('/most/04/danhmuc', 'DM_NHOMHH', null, function (res) {
                if (res.success) {
                    options.lstNhomHangHoa = res.data;
                }
            }),
            app.getCategory('/most/04/danhmuc', 'DM_QUOCGIA', null, function (res) {
                if (res.success) {
                    options.lstQuocGia = res.data;
                } else {
                    options.lstQuocGia = [];
                }
            })).done(function (data) {
                init();
            });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/04/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most04CreateVM = new Most04CreateVM(options);
                        ko.applyBindings(most04CreateVM, document.getElementById('Most04CreateVM'));
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most04CreateVM = new Most04CreateVM(options);
            ko.applyBindings(most04CreateVM, document.getElementById('Most04CreateVM'));
        }
    };
});

