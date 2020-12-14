/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function EditVM(options) {
    var self = this;
    self.form20VM = ko.observable(null);
    self.form03VM = ko.observable(null);
    self.lstUOMs = ko.observable((options && options.hasOwnProperty('lstUOMs')) ? options.lstUOMs : []);
    self.donViXuLyVM = ko.observable(new DonViXyLyVM(options.lstTramThuY));
    self.thongtinChungVM = ko.observable(new ThongTinChungVM(options));
    self.fiAccQuarantineDoc = ko.observable(null);
    self.chooseLicenseVM = ko.observable(new ChooseLicenseTT8VM(options.lstKdnk, function (currentLicense) {
        if (currentLicense.fiQuarantineType <= 3) {
            self.fiHSType = 1;
            self.fiAccQuarantineDoc(currentLicense.fiQuarantineNo);
            currentLicense.lstAtch = options.lstAtch;
            currentLicense.lstCuakhau = options.lstCuakhau;
            currentLicense.lstQuocgia = options.lstQuocgia;
            currentLicense.lstAtch3 = options.lstAtch3;
            self.form03VM(new Form03VM(currentLicense));
            $("#Form03").show();
            $("#Form20a").hide()
        } else {
            self.fiAccQuarantineDoc(currentLicense.fiQuarantineNo);
            self.fiHSType = 2;
            $("#Form03").hide();
            $("#Form20a").show();
            currentLicense.lstCuakhau = options.lstCuakhau;
            currentLicense.lstAtch = options.lstAtch;
            currentLicense.lstQuocgia = options.lstQuocgia;
            currentLicense.lstAtch20a = options.lstAtch20a;
            self.form20VM(new Form20VM(currentLicense));
        }
    }));

    self.lstQuocgia = ko.observableArray(options.lstQuocgia);
    self.lstCuakhau = ko.observableArray(options.lstCuakhau);

    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    if (options.fiIdHoso > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    if (options.fiIdHoso > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI) {
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
        if (self.fiHSType == 1){
            var data03 = self.form03VM().toJSON();
            var data = $.extend(data03, {
                fiDocumentNo: self.fiDocumentNo,
                fiTaxCode: self.thongtinChungVM().fiTaxCode(),
                fiHSCreatedDate: self.thongtinChungVM().fiHSCreatedDate(),
                fiAddressOfRegistration: self.thongtinChungVM().fiAddressOfRegistration(),
                fiEmail: self.thongtinChungVM().fiEmail(),
                fiFax: self.thongtinChungVM().fiFax(),
                fiNameOfRegistration: self.thongtinChungVM().fiNameOfRegistration(),
                fiPhone: self.thongtinChungVM().fiPhone(),
                fiRegistrationNo: self.thongtinChungVM().fiRegistrationNo(),
            });

            data = $.extend(data, self.donViXuLyVM().toJSON());
        } else {
            var data20a = self.form20VM().toJSON();

            var data = $.extend(data20a, {
                fiDocumentNo: self.fiDocumentNo,
                fiTaxCode: self.thongtinChungVM().fiTaxCode(),
                fiHSCreatedDate: self.thongtinChungVM().fiHSCreatedDate(),
                fiAddressOfRegistration: self.thongtinChungVM().fiAddressOfRegistration(),
                fiEmail: self.thongtinChungVM().fiEmail(),
                fiFax: self.thongtinChungVM().fiFax(),
                fiNameOfRegistration: self.thongtinChungVM().fiNameOfRegistration(),
                fiPhone: self.thongtinChungVM().fiPhone(),
                fiRegistrationNo: self.thongtinChungVM().fiRegistrationNo(),
            });
            data = $.extend(data, self.donViXuLyVM().toJSON());

            var exclude = ["lstGoodForChoose", "fiMaDvkd", "updateXeInfo",
                "addProductOnClick", "isValidForm", "init", "hosoErrors", "errorHangHoaMessage",
                "lstCqgsBac", "lstCqgsNam", "lstCqgsTrung", "pop", "hangHoaVM",
                "fiDocument1Number", "fiDocument2Number", "fiDocument3Number",
                "fiDocument1Date", "fiDocument2Date", "fiDocument3Date", "fiNgayTaoHS", "fiSoCv", "fiTenTt", "filesVM"];

            for (var key in data) {
                if (exclude.indexOf(key) >= 0) {
                    delete data[key];
                }
            }

            delete data['__ko_mapping__'];
        }
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
            self.btnGui(false);
        };

        // if (!self.formVM().isValidForm()) {
        //     app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
        //     return;
        // }

        if (self.fiHSType == 1){
            var data03 = self.form03VM().toJSON();

            data03 = $.extend(data03, {
                fiDocumentNo: self.fiDocumentNo,
                fiTaxCode: self.thongtinChungVM().fiTaxCode(),
                fiHSCreatedDate: self.thongtinChungVM().fiHSCreatedDate(),
                fiAddressOfRegistration: self.thongtinChungVM().fiAddressOfRegistration(),
                fiEmail: self.thongtinChungVM().fiEmail(),
                fiFax: self.thongtinChungVM().fiFax(),
                fiNameOfRegistration: self.thongtinChungVM().fiNameOfRegistration(),
                fiPhone: self.thongtinChungVM().fiPhone(),
                fiRegistrationNo: self.thongtinChungVM().fiRegistrationNo()
            });

            data03 = $.extend(data03, self.donViXuLyVM().toJSON());
            data03.fiAccQuarantineDoc = self.fiAccQuarantineDoc();
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
                                url: '/mard/09/hoso/create',
                                data: JSON.stringify(data03),
                                success: function (d) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        cb(d);
                                        window.location.href = app.appContext + '/mard/09/'
                                    } else {
                                        app.Alert(d.message);
                                    }
                                },
                                error: function (e) {
                                    if(e.hasOwnProperty('message')) {
                                        app.Alert(e.message);
                                    } else {
                                        app.Alert('Không gửi được hồ sơ');
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
                            app.popupRemove(self.pop.selector);
                        }
                    }
                ]
            });

        } else {
            var data20a = self.form20VM().toJSON();

            var data = $.extend(data20a, {
                fiDocumentNo: self.fiDocumentNo,
                fiTaxCode: self.thongtinChungVM().fiTaxCode(),
                fiHSCreatedDate: self.thongtinChungVM().fiHSCreatedDate(),
                fiAddressOfRegistration: self.thongtinChungVM().fiAddressOfRegistration(),
                fiEmail: self.thongtinChungVM().fiEmail(),
                fiFax: self.thongtinChungVM().fiFax(),
                fiNameOfRegistration: self.thongtinChungVM().fiNameOfRegistration(),
                fiPhone: self.thongtinChungVM().fiPhone(),
                fiRegistrationNo: self.thongtinChungVM().fiRegistrationNo()
            });

            data = $.extend(data, self.donViXuLyVM().toJSON());
            data.fiAccQuarantineDoc = self.fiAccQuarantineDoc();

            var exclude = ["lstGoodForChoose", "fiMaDvkd", "updateXeInfo",
                "addProductOnClick", "isValidForm", "init", "hosoErrors", "errorHangHoaMessage",
                "lstCqgsBac", "lstCqgsNam", "lstCqgsTrung", "pop", "hangHoaVM",
                "fiDocument1Number", "fiDocument2Number", "fiDocument3Number",
                "fiDocument1Date", "fiDocument2Date", "fiDocument3Date", "fiNgayTaoHS", "fiSoCv", "fiTenTt", "filesVM"];

            for (var key in data) {
                if (exclude.indexOf(key) >= 0) {
                    delete data[key];
                }
            }

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
                                url: '/mard/09/hoso/create',
                                data: JSON.stringify(data),
                                success: function (d) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        cb(d);
                                        window.location.href = app.appContext + '/mard/09/'
                                    } else {
                                        app.Alert(d.message);
                                    }
                                },
                                error: function (e) {
                                    if(e.hasOwnProperty('message')) {
                                        app.Alert(e.message);
                                    } else {
                                        app.Alert('Không gửi được hồ sơ');
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
                            app.popupRemove(self.pop.selector);
                        }
                    }
                ]
            });
        }
    };
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    $('#loading10').show();

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/mard/09/hoso/find?id=' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiDvkd").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiDvgs").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiDvkd").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiDvgs").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };

    $.when(
        app.sendGetRequest("/mard/09/dvxl", function (data) {
            var lstTramThuY = [];

            var lstChildPU = data.data[0].lstChildPU;

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
            options.lstTramThuY = lstTramThuY;
        }),
        app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
            options['lstUOMs'] = res.data;
        }),
        app.sendGetRequest("/mard/08/giayphep/list?mst=" + user.username,function (data) {
            options.lstKdnk = data.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/quocgia", function (res) {
            options.lstQuocgia = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (res) {
            options.lstCuakhau = res.data;
        }),
        app.sendGetRequest("/mard/09/danhmuc/dinhkem/type/3", function (data) {
            options.lstAtch3 = data.data;
        }),
        app.sendGetRequest("/mard/09/danhmuc/dinhkem/type/20A", function (data) {
            options.lstAtch20a = data.data;
        })
    ).done(function (data) {
        $('#loading10').hide();
        init();

    });
});

