var TAO_MOI = "Tạo mới";
var FILL_FORM_REQUIRE = "Vui lòng điền đầy đủ các trường bắt buộc";

function Mard08CreateVM() {
    var createVMSelf = this;
    createVMSelf.kdnkVM = ko.observable(null);
    createVMSelf.ktclVM = ko.observable(null);
    createVMSelf.errorMsg = ko.observable('');
    createVMSelf.fiRegType = ko.observable("1");
    createVMSelf.isEditable = ko.observable(true);

    createVMSelf.applyState = function (data) {
        createVMSelf.kdnkVM(new KiemDichNhapKhauVM(data));
        createVMSelf.ktclVM(new KiemTraChatLuongVM(data));
    };

    createVMSelf.clearForm = function() {
        createVMSelf.errorMsg('');
    };

    createVMSelf.saveRegProfile = function() {
        var body = null;
        if (createVMSelf.fiRegType() == 1) {
            if (!createVMSelf.kdnkVM().validateForm()) {
                return;
            }
            body = createVMSelf.kdnkVM().getData();
        } else {
            if (!createVMSelf.ktclVM().validateForm()) {
                return;
            }
            body = createVMSelf.ktclVM().getData();
        }
        if (!body) return;
        createVMSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(createVMSelf.pop.selector);
                        app.makePost({
                            url: '/mard/08/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/08/'
                                } else {
                                    app.Alert('Không lưu được hồ sơ');
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không lưu được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(createVMSelf.pop.selector);
                    }
                }
            ]
        });
    }

    createVMSelf.sendRegProfile = function() {
        var body = null;
        if (createVMSelf.fiRegType() == 1) {
            if (!createVMSelf.kdnkVM().validateForm() || !createVMSelf.kdnkVM().validateAttachment()) {
                return;
            }
            body = createVMSelf.kdnkVM().getData();
        } else {
            if (!createVMSelf.ktclVM().validateForm() || !createVMSelf.ktclVM().validateAttachment()) {
                return;
            }
            body = createVMSelf.ktclVM().getData();
        }
        if (!body) return;

        createVMSelf.verifySignature = function (signature, doc) {

            var data = {
                'signatureXml': signature,
                'messageXml': doc.sign.fiXml,
                'msgFunc': doc.sign.fiFunc,
                'msgType': doc.sign.fiMsgType,
                'documentCode': doc.data.fiMaHoso,
                'ministryCode': 'MARD',
                'proceduceCode': '08'
            };
            app.makePost({
                url: '/mard/08/verify',
                data: JSON.stringify(data),
                success: function (d) {
                    app.makePost({
                        url: '/mard/08/hoso/guihoso',
                        data: JSON.stringify(doc.data),
                        success: function (d) {
                            if (d.success) {
                                app.Alert('Gửi hồ sơ thành công');
                                setTimeout(function () {
                                    History.go(-1);
                                }, 1500);
                            } else {
                                app.Alert(d.message);
                            }
                        },
                        error: function (e) {
                            if(e.hasOwnProperty('message')) {
                                app.Alert(e.message);
                            } else {
                                if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                    app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                } else {
                                    app.Alert('Không lưu được hồ sơ');
                                }

                            }
                        }
                    });
                },
                error: function (e) {
                    if(e.hasOwnProperty('message')) {
                        app.Alert(e.message);
                    } else {
                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                    }
                }
            });
        };

        createVMSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(createVMSelf.pop.selector);
                        app.makePost({
                            url: '/mard/08/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        window.location.href = app.appContext + '/mard/08/';
                                    } else {
                                        app.Alert(d.message);
                                    }
                                } else {
                                    var result = d.sign;
                                    var onSuccess = function (res) {
                                        if (res.status == 'ok') {
                                            createVMSelf.verifySignature(res.outputData, d);
                                        } else {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        }
                                    };
                                    var onFailed = function (e) {
                                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                                    };

                                    RTVNSignClient.ping(function(res){
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function(e){
                                        app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                    });
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không gửi được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(createVMSelf.pop.selector);
                    }
                }
            ]
        });
    }

    createVMSelf.btnBack = function () {
        History.go(-1);
    }
    createVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/08/";
    }
}

function init(options) {
    var mard08CreateVM = new Mard08CreateVM();
    ko.applyBindings(mard08CreateVM, document.getElementById('mard08Create'));
    mard08CreateVM.applyState(options);
}

$(document).ready(function () {
    var options = {
        fiTaxCode: hosoUsername,
        fiImporterAddress: hosoCompanyAddress,
        fiImporterName: hosoCompanyName,
        fiImporterTel: hosoCompanyPhoneNumber,
        fiImporterFax: hosoCompanyFax,
        fiImporterEmail: hosoCompanyEmail,
        fiHSCreatedDate: new Date(),
        fiHSStatus: 0,
        fiHSType: "1",

    };
    $('#loading10').show();
    $.when(
        // Get list country
        app.sendGetRequest("/mard/08/danhmuc/quocgia", function (res) {
            options['lstCountry'] = res.data;
        }),
        // Get list province
        app.sendGetRequest("/mard/08/danhmuc/tinhthanh", function (res) {
            options['lstProvince'] = res.data;
        }),
        // Get list port
        app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (res) {
            options['lstPort'] = res.data;
        }),
        // Get UOMs
        app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
            options['lstUOMs'] = res.data;
        }),
        // Get profile status
        app.sendGetRequest("/mard/08/danhmuc/statusHoso?systemId=8", function (res) {
            options['lstProfileStatus'] = res.data;
        }),
        // Get attach types
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=8&type=20", function (res) {
            options['lstAtchType20'] = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=8&type=20A", function (res) {
            options['lstAtchType20A'] = res.data;
        }),
        // Get document types
        app.sendGetRequest("/mard/08/hoso/doctype", function (res) {
            options['lstDocType'] = res.data;
        })
    ).done(function (data) {
        $('#loading10').hide();
        init(options);
    })
})
