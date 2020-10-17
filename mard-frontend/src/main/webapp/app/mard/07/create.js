function Mard07CreateVM() {
    var createVMSelf = this;
    createVMSelf.isEditable = ko.observable(true);
    createVMSelf.kdnkVM = ko.observable(null);

    createVMSelf.applyState = function (options) {
        createVMSelf.kdnkVM(new HangHoaNhapKhauVM(options));
    };

    createVMSelf.saveRegProfile = function() {
        if (!createVMSelf.kdnkVM().validateForm()) {
            return;
        }
        var body = null;
        body = createVMSelf.kdnkVM().getData();

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
                            url: '/mard/07/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/07/';
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

    createVMSelf.sendRegProfile = function() {
        if (!createVMSelf.kdnkVM().validateForm() || !createVMSelf.kdnkVM().validateAttachment()) {
            return;
        }
        var body = null;
        body = createVMSelf.kdnkVM().getData();

        if (!body) return;

        createVMSelf.verifySignature = function (signature, doc) {

            var data = {
                'signatureXml': signature,
                'messageXml': doc.sign.fiXml,
                'msgFunc': doc.sign.fiFunc,
                'msgType': doc.sign.fiMsgType,
                'documentCode': doc.data.fiMaHoso,
                'ministryCode': 'MARD',
                'proceduceCode': '07'
            };
            app.makePost({
                url: '/mard/07/verify',
                data: JSON.stringify(data),
                success: function (d) {
                    app.makePost({
                        url: '/mard/07/hoso/guihoso',
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
                            url: '/mard/07/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        window.location.href = app.appContext + '/mard/07/';
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

    createVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/07/";
    }
}

function init(options) {
    var mard07CreateVM = new Mard07CreateVM();
    ko.applyBindings(mard07CreateVM, document.getElementById('mard07Create'));
    mard07CreateVM.applyState(options);
}

$(document).ready(function () {
    $('.date-picker').datetimepicker({
        format: 'dd/mm/yyyy'
    });
    $('#loading08').show();
    var options = {
        fiTaxCode: hosoUsername,
        fiAddressOfRegistration: hosoCompanyAddress,
        fiNameOfRegistration: hosoCompanyName,
        fiPhoneOfRegistration: hosoCompanyPhoneNumber,
        fiFaxOfRegistration: hosoCompanyFax,
        fiEmailOfRegistration: hosoCompanyEmail,
        fiHSStatus: 0
    };
    options['lstPurpose'] = [
        {
            id: 1,
            name: "Kinh doanh thực phẩm"
        },
        {
            id: 2,
            name: "Làm giống nuôi thương phẩm"},
        {
            id: 3,
            name: "Làm giống bố mẹ"},
        {
            id: 4,
            name: "Làm thủ công mĩ nghệ"},
        {
            id: 5,
            name: "Làm cảnh"},
        {
            id: 6,
            name: "Chế biến thực phẩm"},
        {
            id: 7,
            name: "Làm nguyên liệu gia công, chế biến thực phẩm xuất khẩu"
        },
        {
            id: 8,
            name: "Hàng làm mẫu thử"
        },
        {
            id: 9,
            name: "Khác"
        },
        {
            id: 10,
            name: "Sản phẩm động vật thủy sản xuất khẩu bị triệu hồi hoặc bị trả về"
        }
    ]
    $.when(
        // Get list country
        app.sendGetRequest("/mard/07/danhmuc/quocgia", function (res) {
            options['lstCountry'] = res.data;
        }),
        // Get list province
        app.sendGetRequest("/mard/07/danhmuc/tinhthanh", function (res) {
            options['lstProvince'] = res.data;
        }),
        // Get list port
        app.sendGetRequest("/mard/07/danhmuc/cuakhau?countryCode=VN", function (res) {
            options['lstPort'] = res.data;
        }),
        // Get profile status
        app.sendGetRequest("/mard/07/danhmuc/trangthai?systemId=7", function (res) {
            options['lstProfileStatus'] = res.data;
        }),
        // Get list department
        app.sendGetRequest("/mard/09/dvxl", function (res) {
            var lstTramThuY = [];

            var lstChildPU = res.data[0].lstChildPU;

            lstChildPU.forEach(function(itemChicuc) {
                lstTramThuY.push({
                    id: itemChicuc.fiPUCode,
                    name: itemChicuc.fiPUDesc
                });
                itemChicuc.lstChildPU.forEach(function (itemTram) {
                    lstTramThuY.push({
                        id: itemTram.fiPUCode,
                        name: itemTram.fiPUDesc
                    });
                })
            });
            options['lstDepartment'] = lstTramThuY;
        }),
        // Get phan loai hang hoa
        app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=PHAN_LOAI", function (res) {
            options['lstClassification'] = res.data;
        }),
        // Get danh muc hang hoa
        app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=DANH_MUC_HANG_HOA", function (res) {
            options['lstCategory'] = res.data;
        }),
        // Get phuong thuc bao quan
        app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=LOAI", function (res) {
            options['lstSpecies'] = res.data;
        }),
        // Get UOMs
        app.sendGetRequest("/mard/07/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
            options['lstUOM'] = res.data;
        }),
        // Get attach types
        app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=N", function (res) {
            options['lstAtchType'] = res.data;
        }),
        // Get attach types gccb
        app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=GCCB", function (res) {
            options['lstAtchTypeGCCB'] = res.data;
        }),
        // Get attach types htc
        app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=HTC", function (res) {
            options['lstAtchTypeHTC'] = res.data;
        }),
        // Get list giay phep
        app.sendGetRequest("/mard/07/danhmuc/giayphep06", function (res) {
            options['lstCongVan'] = res.data;
        })
    ).done(function (data) {
        $('#loading08').hide();
        init(options);
    })
})
