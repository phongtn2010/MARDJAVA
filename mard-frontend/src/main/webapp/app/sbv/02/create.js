function SBV02CreateVM () {
    var createVMSelf = this;
    createVMSelf.hsxnkv = ko.observable(null);
    createVMSelf.isEditable = ko.observable(true)

    createVMSelf.applyState = function (options) {
        options["fiHSType"] = "1";
        createVMSelf.hsxnkv(new ThongTinHoSoVM(options));
    }

    createVMSelf.saveRegProfile = function () {
        // if (!createVMSelf.kdnkVM().validateForm()) return;
        var body = createVMSelf.hsxnkv().getData();
        if (!body) return;
        console.log(body);
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
                            url: '/sbv/02/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/sbv/02/';
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
            // Get list Cua Khau
            app.sendGetRequest("/sbv/02/danhmuc/cuakhau", function (res) {
                options['lstCuaKhau'] = res.data;
            }),
            // Get list danh muc vang
            app.sendGetRequest("/sbv/02/danhmuc/vang", function (res) {
                options['lstVang'] = res.data;
            }),
            // Get list danh muc tien
            app.sendGetRequest("/sbv/02/danhmuc/donvitinh", function (res) {
                options['lstDVT'] = res.data;
            }),
            // Get list danh muc tien te
            app.sendGetRequest("/sbv/02/danhmuc/tiente", function (res) {
                options['lstTienTe'] = res.data;
            }),
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
            console.log(options);
        })
    })
function init(options) {
    var sbv02CreateVM = new SBV02CreateVM();
    ko.applyBindings(sbv02CreateVM, document.getElementById('sbv02Create'));
    sbv02CreateVM.applyState(options);
}


