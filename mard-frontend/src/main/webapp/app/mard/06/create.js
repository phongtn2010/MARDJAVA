function Mard06CreateVM () {
    var createVMSelf = this;
    createVMSelf.kdnkVM = ko.observable(null);
    createVMSelf.isEditable = ko.observable(true)

    createVMSelf.applyState = function (options) {
        options["fiHSType"] = "1";
        createVMSelf.kdnkVM(new KiemDichNhapKhauVM(options));
    }

    createVMSelf.saveRegProfile = function () {
        if (!createVMSelf.kdnkVM().validateForm()) return;
        var body = createVMSelf.kdnkVM().getData();
        // return;
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
                            url: '/mard/06/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/06/';
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

    createVMSelf.sendRegProfile = function () {
        if (!createVMSelf.kdnkVM().validateForm() || !createVMSelf.kdnkVM().validateAttachment()) return;
        var body = createVMSelf.kdnkVM().getData();
        // return;
        if (!body) return;
        createVMSelf.verifySignature = function (signature, doc) {

            var data = {
                'signatureXml': signature,
                'messageXml': doc.sign.fiXml,
                'msgFunc': doc.sign.fiFunc,
                'msgType': doc.sign.fiMsgType,
                'documentCode': doc.data.fiMaHoso,
                'ministryCode': 'MARD',
                'proceduceCode': '06'
            };
            app.makePost({
                url: '/mard/06/verify',
                data: JSON.stringify(data),
                success: function (d) {
                    app.makePost({
                        url: '/mard/06/hoso/guihoso',
                        data: JSON.stringify(doc.data),
                        success: function (d) {
                            app.Alert('Gửi hồ sơ thành công');
                            setTimeout(function () {
                                History.go(-1);
                            }, 1500);
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
                            url: '/mard/06/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        window.location.href = app.appContext + '/mard/06/';
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
        window.location.href = app.appContext + "/mard/06/";
    }
}

function init(options) {
    var mard06CreateVM = new Mard06CreateVM();
    ko.applyBindings(mard06CreateVM, document.getElementById('mard06Create'));
    mard06CreateVM.applyState(options);
}

$(document).ready(function () {
    var options = {
        fiTaxCode: hosoUsername,
        fiImporterAddress: hosoCompanyAddress,
        fiImporterName: hosoCompanyName,
        fiImporterTel: hosoCompanyPhoneNumber,
        fiImporterFax: hosoCompanyFax,
        fiImporterEmail: hosoCompanyEmail,
        fiHSStatus: 0
    };
    $('#loading10').show();
    $.when(
        // Get list country
        app.sendGetRequest("/mard/06/danhmuc/quocgia", function (res) {
            options['lstCountry'] = res.data;
        }),
        // Get list province
        app.sendGetRequest("/mard/06/danhmuc/tinhthanh", function (res) {
            options['lstProvince'] = res.data;
        }),
        // Get list port
        app.sendGetRequest("/mard/06/danhmuc/cuakhau?countryCode=VN", function (res) {
            options['lstPort'] = res.data;
        }),
        // Get UOMs
        app.sendGetRequest("/mard/06/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
            options['lstUOMAnimal'] = res.data;
        }),
        // Get profile status
        app.sendGetRequest("/mard/06/danhmuc/statusHoso?systemId=6", function (res) {
            options['lstProfileStatus'] = res.data;
        }),
        // Get attach types
        app.sendGetRequest("/mard/06/danhmuc/dinhkem?systemId=6", function (res) {
            options['lstAtchType'] = res.data;
        })
    ).done(function (data) {
        $('#loading10').hide();
        init(options);
    })
})
