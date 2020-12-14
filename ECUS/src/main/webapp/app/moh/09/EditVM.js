/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function EditVM(options) {
    self = this;
    self.formVM = ko.validatedObservable(new FormVM(options));
    self.fileVM = ko.validatedObservable(new FileVM(options, self.formVM()));

    self.fiThuTucId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };
    
    self.propTitle = ko.observable(NSWLang["moh." + options.maThuTuc + ".tenthutuc"]);

    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI
                || self.formVM().fiTrangthai() == CHO_THONG_BAO_PHI
                || self.formVM().fiTrangthai() == YC_NOP_LAI_PHI
                || self.formVM().fiTrangthai() == THONG_BAO_AP_PHI
                || self.formVM().fiTrangthai() == DA_XAC_NHAN_PHI
				|| self.formVM().fiTrangthai() == CHO_XAC_NHAN_PHI				
                || self.formVM().fiTrangthai() == YC_BO_SUNG) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };

        var resultForm = self.formVM().isValidForm();
        if (!resultForm) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
       
        var fileIsVaild = self.fileVM().isVaild();
        if (!fileIsVaild) {
            app.Alert('File đính kèm cần được cập nhật đầy đủ.');
            return;
        }
        
        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();
        data.lstDinhKems = self.fileVM().toJSON();

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moh/09/hoso/taomoi' : '/moh/09/hoso/capnhap';

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

    self.verifySignature = function (signature, doc) {

        var data = {
            'signatureXml': signature,
            'messageXml': doc.sign.fiXml,
            'msgFunc': doc.sign.fiFunc,
            'msgType': doc.sign.fiMsgType,
            'documentCode': doc.data.fiMaHoso,
            'ministryCode': 'MOH',
            'proceduceCode': options.maThuTuc
        };
        app.makePost({
            url: '/moh/09/verify',
            data: JSON.stringify(data),
            success: function (d) {
                app.makePost({
                    url: '/moh/09/hoso/guihoso',
                    data: JSON.stringify(doc.data),
                    success: function (d) {
                        app.Alert('Gửi hồ sơ thành công');
                        setTimeout(function () {
                            History.go(-1);
                        }, 1500);
                    },
                    error: function (e) {
                        app.Alert('Gửi hồ sơ không thành công');
                    }
                });
            },
            error: function (e) {
                if (e.hasOwnProperty('message')) {
                    app.Alert(e.message);
                } else {
                    app.Alert('Ký số không thành công, vui lòng thử lại.');
                }
            }
        });
    };

    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };

        var resultForm = self.formVM().isValidForm();
        if (!resultForm) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        
        var fileIsVaild = self.fileVM().isVaild();
        if (!fileIsVaild) {
            app.Alert('File đính kèm cần được cập nhật đầy đủ.');
            return;
        }

        var data = self.formVM().toJSON();
        data.lstDinhKems = self.fileVM().toJSON();
        
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/moh/09/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
                                } else {
                                    var result = d.sign;
                                    var onSuccess = function (res) {
                                        if (res.status == 'ok') {
                                            self.verifySignature(res.outputData, d);
                                        } else {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        }
                                    };
                                    var onFailed = function (e) {
                                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                                    };

                                    RTVNSignClient.ping(function (res) {
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function (e) {
                                        app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                    });
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
                        app.popupRemove(self.pop.selector);
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
        document.location = context + '/moh/09/home?maThuTuc=' + options.maThuTuc;
    };
}

var DINHKEMDATA = null;
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();

    $.when(
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_LOAITHANHTOAN', options.maThuTuc, function (res) {
                if (res.success) {
                    options.lstLoaiThanhToan = res.data;
                } else {
                    options.lstLoaiThanhToan = [];
                }
            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_DINHKEM', null, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_COQUANKIEMTRA', null, function (res) {
                if (res.success) {
                    options.lstCoQuanKiemTra = res.data;
                } else {
                    options.lstCoQuanKiemTra = [];
                }
            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_NHOMSP', options.maThuTuc, function (res) {
                if (res.success) {
                    options.lstNhomSanPham = res.data;
                } else {
                    options.lstNhomSanPham = [];
                }
            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_QUOCGIA', null, function (res) {
                if (res.success) {
                    options.lstQuocGia = res.data;
                } else {
                    options.lstQuocGia = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/09/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;

                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));

                        $("#fiMaTckt").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCkDi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCkDen").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKems = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaTckt").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCkDi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCkDen").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

