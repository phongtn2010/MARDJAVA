/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);
ko.validation.makeBindingHandlerValidatable("datepicker");

ko.subscribable.fn.trimmed = function() {
    return ko.computed({
        read: function() {
            return this();
        },
        write: function(value) {
            this(value ? value.trim ? value.trim() : value : value);
            this.valueHasMutated();
        },
        owner: this
    }).extend({ notify: 'always' });
};

function EditVM(options) {
    var self = this;
    self.lstUOMs = ko.observable((options && options.hasOwnProperty('lstUOMs')) ? options.lstUOMs : []);
    self.dinhKem = ko.observable();
    self.showDinhKemTab = ko.observable(false);
    self.loaiHoso = ko.observable(1);

    self.isEnableEdit = ko.observable(disabled ? !disabled : true);

    self.isYCS = ko.observable(ycs ? ycs : false);

    self.fiModifyReason = ko.observable(null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.form20VM = ko.observable(null);
    self.form03VM = ko.observable(null);
    if (!options) {
        options = {}
    }
    var hoso = options ? options.hoso : null;

    self.fiHSType = 0;

    self.donViXuLyVM = ko.observable(hoso ? new DonViXyLyVM(options.lstTramThuY, hoso) : new DonViXyLyVM(options.lstTramThuY));
    self.thongtinChungVM = ko.observable(new ThongTinChungVM(options));
    self.fiAccQuarantineDoc = ko.observable(null);

    self.chooseLicenseVM = ko.observable(new ChooseLicenseTT8VM(options, function (currentLicense) {
        if (currentLicense.fiQuarantineType <= 3) {
            self.showDinhKemTab(true);
            self.fiHSType = 1;
            self.loaiHoso(1);

            self.fiAccQuarantineDoc(currentLicense.fiQuarantineNo);
            currentLicense.lstAtch = options.lstAtch;
            currentLicense.lstCuakhau = options.lstCuakhau;
            currentLicense.lstQuocgia = options.lstQuocgia;
            currentLicense.lstAtch3 = options.lstAtch3;
            self.form03VM(new Form03VM(currentLicense, options));
            $("#Form03").show();
            $("#Form20a").hide()
        } else {
            self.showDinhKemTab(true);
            self.fiAccQuarantineDoc(currentLicense.fiQuarantineNo);
            self.fiHSType = 2;
            self.loaiHoso(2);
            $("#Form03").hide();
            $("#Form20a").show();
            currentLicense.lstCuakhau = options.lstCuakhau;
            currentLicense.lstAtch = options.lstAtch;
            currentLicense.lstQuocgia = options.lstQuocgia;
            currentLicense.lstAtch20a = options.lstAtch20a;
            self.form20VM(new Form20VM(currentLicense, options));
        }
    }));

    self.btnLuu = ko.observable(true);
    self.btnGui = ko.observable(true);

    if (hoso) {
        if (hoso.fiHSStatus === 1 || hoso.fiHSStatus === 7) {
            self.btnLuu(false);
        }
        self.showDinhKemTab(true);
        self.loaiHoso(hoso.fiHSType);
        var currentLicense = options.mapKdnk[hoso.fiAccQuarantineDoc];
        if (currentLicense.fiQuarantineType <= 3) {
            self.fiHSType = 1;
            self.fiAccQuarantineDoc(currentLicense.fiQuarantineNo);
            currentLicense.lstAtch = options.lstAtch;
            currentLicense.lstCuakhau = options.lstCuakhau;
            currentLicense.lstQuocgia = options.lstQuocgia;
            currentLicense.lstAtch3 = options.lstAtch3;
            self.form03VM(new Form03VM(currentLicense, options));
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
            self.form20VM(new Form20VM(currentLicense, options));
        }
    }

    self.lstQuocgia = ko.observableArray(options.lstQuocgia);
    self.lstCuakhau = ko.observableArray(options.lstCuakhau);



    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {

        if (!self.donViXuLyVM().isValid()) {
            app.Alert('Bạn cần chọn đơn vị kiểm dịch và giám sát');
            return;
        }


        if (self.fiHSType == 0) {
            app.Alert('Bạn phải chọn Công văn Kiểm dịch nhập khẩu đã cấp');
            return;
        }

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
                fiModifyReason:  self.fiModifyReason()
            });

            data03 = $.extend(data03, self.donViXuLyVM().toJSON());
            data03.fiAccQuarantineDoc = self.fiAccQuarantineDoc();
            self.pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
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
                                        app.Alert('Hồ sơ đã được lưu');
                                        window.location.href = app.appContext + '/mard/09/';
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
                fiModifyReason:  self.fiModifyReason()
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
                html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
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
                                        window.location.href = app.appContext + '/mard/09/';
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
                            app.popupRemove(self.pop.selector);
                        }
                    }
                ]
            });
        }
    };
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        if (ycs && !self.fiModifyReason.isValid()) {
            var option = {
                fiModifyReason: self.fiModifyReason
            };

            var errors = ko.validation.group(option, { deep: true });
            if (errors().length > 0) {
                errors.showAllMessages();
                app.Alert('Cần nhập lý do xin sửa');
                return
            }
        }

        if (!self.donViXuLyVM().isValid()) {
            app.Alert('Bạn cần chọn đơn vị kiểm dịch và giám sát');
            return;
        }

        if (self.fiHSType == 0) {
            app.Alert('Bạn phải chọn Công văn Kiểm dịch nhập khẩu đã cấp');
            return;
        }

        self.verifySignature = function (signature, doc) {

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
                url: '/mard/09/verify',
                data: JSON.stringify(data),
                success: function (d) {
                    app.makePost({
                        url: ycs ? '/mard/09/hoso/guiycs' : '/mard/09/hoso/guihoso',
                        data: JSON.stringify(doc.data),
                        success: function (d) {
                            if (d.success) {
                                app.Alert('Gửi hồ sơ thành công');
                                setTimeout(function () {
                                    History.go(-1);
                                }, 1500);
                            } else {
                                app.Alert(d.message)
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

        if (self.fiHSType == 1){
            if (!self.form03VM().uploadFileVM().isValid()) {
                app.Alert('Cần đính kèm các tệp bắt buộc(có đánh dấu *)');
                return;
            }

            if (!self.form03VM().validateList()) {
                app.Alert('Cần nhập thông tin các danh sách');

                return;
            }
            if (!self.form03VM().validateForm()) {
                app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ)');
                return;
            }
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
                fiModifyReason:  self.fiModifyReason()
            });

            var url = "/mard/09/hoso/send";
            if (ycs) {
                url = "/mard/09/hoso/ycs";

                if (!self.fiModifyReason.isValid()){
                    app.Alert('Vui lòng nhập lý do yêu cầu xin sửa hồ sơ');

                    return;
                }
            }

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
                                url: url,
                                data: JSON.stringify(data03),
                                success: function (d) {
                                    if (!app.requireSigning) {
                                        if (d && d.success) {
                                            app.Alert('Gửi hồ sơ thành công');
                                            window.location.href = app.appContext + '/mard/09/'
                                        } else {
                                            app.Alert(d.message)
                                        }
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
                            app.popupRemove(self.pop.selector);
                        }
                    }
                ]
            });

        } else {

            if (!self.form20VM().uploadFileVM().isValid()) {
                app.Alert('Cần đính kèm các tệp bắt buộc(có đánh dấu *)');
                return;
            }


            if (!self.form20VM().isValidList()) {
                app.Alert('Cần nhập thông tin các danh sách');

                return;
            }
            if (!self.form20VM().validateForm()) {
                app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ)');
                return;
            }


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
                fiModifyReason:  self.fiModifyReason()
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

            var url = "/mard/09/hoso/send";
            if (ycs) {
                url = "/mard/09/hoso/ycs";
                if (!self.fiModifyReason.isValid()){
                    app.Alert('Vui lòng nhập lý do yêu cầu xin sửa hồ sơ');
                    return;
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
                                url: url,
                                data: JSON.stringify(data),
                                success: function (d) {
                                    if (!app.requireSigning) {
                                        if (d && d.success) {
                                            app.Alert('Gửi hồ sơ thành công');
                                            window.location.href = app.appContext + '/mard/09/'
                                        } else {
                                            app.Alert(d.message)
                                        }
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
        if (idHoSo > 0) {
            var url = '/mard/09/hoso/find?id=' + idHoSo;
            app.makeGet({
                url: url,
                success: function (d) {
                    $('#loading10').hide();
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiDvkd").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiDvgs").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    $('#loading10').hide();
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            $('#loading10').hide();
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
        app.sendGetRequest("/mard/08/giayphep/list?mst=",function (data) {
            options.lstKdnk = data.data;

            var mapKdnk = {};

            options.lstKdnk.forEach(function (item) {
                mapKdnk[item.fiQuarantineNo] = item
            });

            options.mapKdnk = mapKdnk;

        }),
        app.sendGetRequest("/mard/09/danhmuc/tinhthanh",function(data){
            options.lstProvince = data.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/quocgia", function (data) {
            options.lstQuocgia = data.data;
            options.lstQuocgia.forEach(function (value) {
                mapQuocgia[value.countrycode] = value.countryname
            });
            options.mapQuocgia = mapQuocgia;
        }),
        app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
            options['lstUOMs'] = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (data) {
            options.lstCuakhau = data.data;
            var mapCuakhau = {};
            options.lstCuakhau.forEach(function (value) {
                mapCuakhau[value.portcode] = value.portname
            });
            options.mapCuakhau = mapCuakhau;
        }),
        app.sendGetRequest( "/mard/09/danhmuc/doctype",function (data) {
            options.lstDocumentTypes = data.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=9&type=3", function (res) {
            options['lstAtchType3'] = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=9&type=20A", function (res) {
            options['lstAtchType20A'] = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/statusHoso?systemId=9", function (res) {
            options.lstTrangthai = res.data;
            var mapTrangthai = {};
            options.lstTrangthai.forEach(function (item) {
                mapTrangthai[item.id.toString()] = item.name
            });
            options.mapTrangthai = mapTrangthai;
        }),
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=9&type=3", function (res) {
            options.lstAtch3 = res.data;
        }),
        app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=9&type=20A", function (res) {
            options.lstAtch20a = res.data;
        })
    ).done(function (data) {
        init();
    });
});


