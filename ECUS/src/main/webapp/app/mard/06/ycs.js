function Mard06YCSVM() {
    var ycsVMSelf = this;
    ycsVMSelf.kdnkVM = ko.observable(null);
    ycsVMSelf.isEditable = ko.observable(true);

    ycsVMSelf.applyState = function (options) {
        options.isRequestEdit = true;
        ycsVMSelf.kdnkVM(new KiemDichNhapKhauVM(options))
    }

    ycsVMSelf.sendRegProfile = function() {
        if (!ycsVMSelf.kdnkVM().validateForm() || !ycsVMSelf.kdnkVM().validateAttachment()) return;
        var body = ycsVMSelf.kdnkVM().getData();
        // return;
        if (!body) return;
        ycsVMSelf.verifySignature = function (signature, doc) {

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
                        url: '/mard/06/hoso/guiycs',
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
                        if (body.fiReason == null || body.fiReason.length == 0){
                            app.Alert('Cần nhập lý do xin sửa');
                            app.popupRemove(ycsVMSelf.pop.selector);
                            return;
                        }
                        app.popupRemove(ycsVMSelf.pop.selector);
                        app.makePost({
                            url: '/mard/06/hoso/edit',
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
                                            ycsVMSelf.verifySignature(res.outputData, d);
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
                                    if (e.status === 403 || e.status === 405 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
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
        window.location.href = app.appContext + "/mard/06/";
    }
}

function init(options) {
    var mard06YCSVM = new Mard06YCSVM();
    ko.applyBindings(mard06YCSVM, document.getElementById('mard06YCS'));
    mard06YCSVM.applyState(options)
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
