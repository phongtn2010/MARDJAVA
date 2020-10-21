function Mard25EditVM () {
    var editVMSefl = this;
    editVMSefl.kdnkVM = ko.observable(null);
    editVMSefl.isEditable = ko.observable(true)

    editVMSefl.applyState = function (options) {
        options["fiHSType"] = "1";
        editVMSefl.kdnkVM(new HangHoaNhapKhauVM(options));
    }

    editVMSefl.saveRegProfile = function () {
        // if (!editVMSefl.kdnkVM().validateForm()) return;
        var body = editVMSefl.kdnkVM().getData();
        // return;
        if (!body) return;
        editVMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/25/';
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
                        app.popupRemove(editVMSefl.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSefl.sendRegProfile = function () {
        // if (!editVMSefl.kdnkVM().validateForm() || !editVMSefl.kdnkVM().validateAttachment()) return;
        var body = editVMSefl.kdnkVM().getData();
        // return;
        if (!body) return;
        editVMSefl.verifySignature = function (signature, doc) {

            var data = {
                'signatureXml': signature,
                'messageXml': doc.sign.fiXml,
                'msgFunc': doc.sign.fiFunc,
                'msgType': doc.sign.fiMsgType,
                'documentCode': doc.data.fiMaHoso,
                'ministryCode': 'MARD',
                'proceduceCode': '25'
            };
            app.makePost({
                    url: '/mard/25/verify',
                    data: JSON.stringify(data),
                    success: function (d) {
                    app.makePost({
                        url: '/mard/25/hoso/guihoso',
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
                }
            });
        };

        editVMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        window.location.href = app.appContext + '/mard/25/';
                                    } else {
                                        app.Alert(d.message);
                                    }
                                } else {
                                    var result = d.sign;
                                    var onSuccess = function (res) {
                                        if (res.status == 'ok') {
                                            editVMSefl.verifySignature(res.outputData, d);
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
                        app.popupRemove(editVMSefl.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSefl.btnBack = function () {
        History.go(-1);
    }
    editVMSefl.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/25/";
    }
}

function init(options) {
    var mard25EditVM = new Mard25EditVM();
    ko.applyBindings(mard25EditVM, document.getElementById('mard25Edit'));
    mard25EditVM.applyState(options);
}
function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/25/hoso/find' + "?idHoSo=" + idHoSo,
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
        options=data.data;
        console.log(options);
        $('#loading10').show();
        $.when(
            // Get list country
            app.sendGetRequest("/mard/25/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/25/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/25/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/25/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOMAnimal'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/1", function (res) {
                options['lstNhom'] = res.data;
                options['lstPhanNhom'] = res.data;
                options['lstPhanLoai'] = res.data;
                options['lstLoai'] = res.data;
            })
            // // Get attach types
            // app.sendGetRequest("/mard/25/danhmuc/dinhkem?systemId=6", function (res) {
            //     options['lstAtchType'] = res.data;
            // })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
})
