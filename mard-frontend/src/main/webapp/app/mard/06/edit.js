function Mard06EditVM() {
    var editVMSelf = this;
    editVMSelf.kdnkVM = ko.observable(null);
    editVMSelf.isEditable = ko.observable(true);

    editVMSelf.applyState = function (options) {
        editVMSelf.kdnkVM(new KiemDichNhapKhauVM(options))
    }

    editVMSelf.saveRegProfile = function() {
        if (!editVMSelf.kdnkVM().validateForm()) return;
        var body = editVMSelf.kdnkVM().getData();
        // return;
        if (!body) return;
        editVMSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSelf.pop.selector);
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
                        app.popupRemove(editVMSelf.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSelf.sendRegProfile = function() {
        if (!editVMSelf.kdnkVM().validateForm() || !editVMSelf.kdnkVM().validateAttachment()) return;
        var body = editVMSelf.kdnkVM().getData();
        // return;
        if (!body) return;

        editVMSelf.verifySignature = function (signature, doc) {

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

        editVMSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSelf.pop.selector);
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
                                            editVMSelf.verifySignature(res.outputData, d);
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
                        app.popupRemove(editVMSelf.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSelf.btnBack = function () {
        History.go(-1);
    }
    editVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/06/";
    }
}

function init(options) {
    var mard06EditVM = new Mard06EditVM();
    ko.applyBindings(mard06EditVM, document.getElementById('mard06Edit'));
    mard06EditVM.applyState(options)
}

function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/06/hoso/find' + "?idHoSo=" + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
            $('#loading08').hide();
        },
        error: function (x, t, m) {
            $('#loading08').hide();
        },
    })
}

$(document).ready(function () {
    var options = {};
    getThongTinHoSo(function (data) {
        options = data.data;
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
})
