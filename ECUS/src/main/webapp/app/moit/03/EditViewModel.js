/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Most03CreateVM(options) {
    self = this;

    self.most03FormVM = ko.observable(new Most03FormVM(options));
    self.most03FilesVM = ko.observable(new Most03FilesVM(options));

    self.visibleBtnLuu = ko.observable(false);
    if (self.most03FormVM().fiIdHoso() > 0) {
        if (self.most03FormVM().fiTrangthai() == STATUS_TAO_MOI) {
            self.visibleBtnLuu(true);
        }
    } else {
        self.visibleBtnLuu(true);
    }

    self.btnLuuClick = function () {
        var cb = function (d) {
            self.most03FormVM().fiIdHoso(d.data.fiIdHoso);
            self.most03FormVM().fiMaHoso(d.data.fiMaHoso);
            self.most03FormVM().fiNguoitao(d.data.fiNguoitao);
            self.most03FormVM().fiTrangthai(d.data.fiTrangthai);
            self.most03FormVM().fiTenTt(d.data.fiTenTt);
            self.most03FormVM().hangHoas(ListTbdhanghoaModel(d.data.hangHoas));
            self.most03FormVM().toKhaiHQs(ListTbdHaiQuanModel(d.data.toKhaiHQs));

            self.most03FilesVM().fiIdHoso(d.data.fiIdHoso);
            self.most03FilesVM().tepDinhKems(ListTbddinhkem3Model(d.data.tepDinhKems));
        };

        var isVaild = self.most03FormVM().isValidForm();
        if (!isVaild) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-1').trigger('click');
            return;
        }
        isVaild = self.most03FilesVM().isValidForm();

        if (!isVaild) {
            $('#a-tab-2').trigger('click');
            return;
        }

        var fiIdHoso = self.most03FormVM().fiIdHoso();
        var data = self.most03FormVM().toJSON();
        data["tepDinhKems"] = self.most03FilesVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/most/03/hoso/taomoi' : '/most/03/hoso/capnhap';

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
            url: app.appContext + '/most/03/import',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(app.config.CSRF_TOKEN_NAME, app.config.CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if (res && res.success) {
                    self.most03FormVM().afterImportExcel(res.data);
                }
            },
            error: function (x, t, m) {
                app.Alert('Import không thành công!');
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.most03FormVM().fiIdHoso(d.data.fiIdHoso);
            self.most03FormVM().fiMaHoso(d.data.fiMaHoso);
            self.most03FormVM().fiNguoitao(d.data.fiNguoitao);
            self.most03FormVM().fiTrangthai(d.data.fiTrangthai);
            self.most03FormVM().fiTenTt(d.data.fiTenTt);
            self.most03FormVM().hangHoas(ListTbdhanghoaModel(d.data.hangHoas));
            self.most03FormVM().toKhaiHQs(ListTbdHaiQuanModel(d.data.toKhaiHQs));

            self.most03FilesVM().fiIdHoso(d.data.fiIdHoso);
            self.most03FilesVM().tepDinhKems(ListTbddinhkem3Model(d.data.tepDinhKems));
            setTimeout(function () {
                History.go(-1);
            }, 1500);
        };

        var isVaild = self.most03FormVM().isValidForm();
        if (!isVaild) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-1').trigger('click');
            return;
        }
//        isVaild = self.most03FilesVM().isValidForm();
//        
//        if (!isVaild) {
//            $('#a-tab-2').trigger('click');
//            return;
//        }

        var fiIdHoso = self.most03FormVM().fiIdHoso();
        var data = self.most03FormVM().toJSON();
        data["tepDinhKems"] = self.most03FilesVM().toJSON();

        delete data['__ko_mapping__'];

        app.makePost({
            url: '/most/03/hoso/send',
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    if (!app.requireSigning) {
                        app.Alert('Gửi hồ sơ thành công');
                        cb(d);
                    } else {
                        var result = d.sign;
                        var data = {
                            'fiIdHoso': d.data.fiIdHoso,
                            'type': result.fiMsgType,
                            'function': result.fiFunc
                        };
                        //Ky so
                        sendMessageToSign(result.fiXml,
                                result.fiMsgType, result.fiFunc,
                                d.data.fiMaHoso, 'MOST', data.fiIdHoso,
                                result.fiDocType, JSON.stringify(data));
                    }
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
            app.getCategory('/most/03/danhmuc', 'DM_LOAIHOSO', null, function (res) {
                if (res.success) {
                    options.lstLoaiHoSo = res.data;
                }
            })).done(function (data) {
        init();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/03/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most03CreateVM = new Most03CreateVM(options);
                        ko.applyBindings(most03CreateVM, document.getElementById('Most03CreateVM'));
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most03CreateVM = new Most03CreateVM(options);
            ko.applyBindings(most03CreateVM, document.getElementById('Most03CreateVM'));
        }
    };
});

