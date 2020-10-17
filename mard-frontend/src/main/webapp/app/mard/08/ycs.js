function Mard08YCSVM () {
    var ycsVMSelf = this;
    ycsVMSelf.kdnkVM = ko.observable(null);
    ycsVMSelf.ktclVM = ko.observable(null);
    ycsVMSelf.errorMsg = ko.observable('');
    ycsVMSelf.fiHSType = ko.observable(null);
    ycsVMSelf.fiModifyReason = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ycsVMSelf.isEditable = ko.observable(true);

    ycsVMSelf.errors = ko.validation.group(ycsVMSelf);

    ycsVMSelf.clearForm = function() {
        ycsVMSelf.errorMsg('');
    }

    ycsVMSelf.applyState = function (options) {
        ycsVMSelf.fiHSType(options.fiHSType);
        if (options.fiHSType < 4) {
            ycsVMSelf.kdnkVM(new HangHoaNhapKhauVM(options));
        } else if (options.fiHSType >= 4) {
            ycsVMSelf.ktclVM(new KiemTraChatLuongVM(options));
        }
    }

    ycsVMSelf.sendRegProfile = function() {
        if (ycsVMSelf.errors().length > 0) {
            ycsVMSelf.errors.showAllMessages();
            return ;
        }

        var body = null;
        if (ycsVMSelf.fiHSType() < 4) {
            if (!ycsVMSelf.kdnkVM().validateForm() || !ycsVMSelf.kdnkVM().validateAttachment()) {
                return;
            }
            body = ycsVMSelf.kdnkVM().getData();
        } else {
            if (!ycsVMSelf.ktclVM().validateForm() || !ycsVMSelf.ktclVM().validateAttachment()) {
                return;
            }
            body = ycsVMSelf.ktclVM().getData();
        }
        if (!body) return;
        body.fiModifyReason = ycsVMSelf.fiModifyReason();

        ycsVMSelf.verifySignature = function (signature, doc) {

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
                        url: '/mard/08/hoso/guiycs',
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
                                if (e.status === 403 || e.status === 405 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
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

        ycsVMSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(ycsVMSelf.pop.selector);
                        app.makePut({
                            url: '/mard/08/hoso/edit',
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
                                            ycsVMSelf.verifySignature(res.outputData, d);
                                        } else {
                                            rollback(body.fiHSCode, function () {
                                                app.Alert('Ký số không thành công, vui lòng thử lại.');
                                            })
                                        }
                                    };
                                    var onFailed = function (e) {
                                        rollback(body.fiHSCode, function () {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        })
                                    };

                                    RTVNSignClient.ping(function(res){
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function(e){
                                        rollback(body.fiHSCode, function () {
                                            app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                        })
                                    });
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    rollback(body.fiHSCode, function () {
                                        if (e.status === 403 || e.status === 405 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                            app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                        } else {
                                            app.Alert('Không gửi được hồ sơ');
                                        }
                                    })
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
                        app.popupRemove(ycsVMSelf.pop.selector);
                    }
                }
            ]
        });
    }

    ycsVMSelf.btnBack = function () {
        History.go(-1);
    }
    ycsVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/08/";
    }
}

function rollback(nswFileCode, callback) {
    var settings = {
        "url": "/mard/08/hoso/rollback?nswFileCode=" + nswFileCode,
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(callback);
}


function init(options) {
    var mard08YCSVM = new Mard08YCSVM();
    ko.applyBindings(mard08YCSVM, document.getElementById('mard08YCS'));
    mard08YCSVM.applyState(options);
}

function getThongTinHoSo (callback) {
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/08/hoso/find' + "?idHoSo=" + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
        },
        error: function (x, t, m) {
        },
    })
}

$(document).ready(function () {
    var options = {};
    $('#loading10').show();
    getThongTinHoSo(function (data) {
        options = data.data;
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
            app.sendGetRequest("/mard/08/hoso/doctype", function (res) {
                options['lstDocType'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
});