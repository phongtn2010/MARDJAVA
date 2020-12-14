var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var ERROR_FILL_INPUT = 'Vui lòng nhập trường này';
var ERROR_FILL_TABLE = 'Vui lòng nhập bảng này';
var ERROR_FILL_CHUNG_NHAN = 'Vui lòng nhập nội dung chứng nhận hoặc đính kèm giấy chứng nhận';

function Mard01CreateVM(options) {
    var createVMSelf = this;
    var hoso = options.hoso;
    createVMSelf.fiIdHS = ko.observable((hoso && hoso.hasOwnProperty('fiIdHS')) ? hoso.fiIdHS : null);
    createVMSelf.isView = ko.observable(options.isView);
    createVMSelf.fiHSStatus = ko.observable((hoso && hoso.hasOwnProperty('fiHSStatus')) ? hoso.fiHSStatus : null);
    createVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(hoso, options));
    createVMSelf.errorMsg = ko.observable('');
    createVMSelf.fiObjectType = ko.observable((hoso && hoso.hasOwnProperty('fiObjectType')) ? hoso.fiObjectType.toString() : "1");
    createVMSelf.registerAnimalVM = ko.observable(new RegisterAnimalVM(hoso, options));
    createVMSelf.registerAnimalProductVM = ko.observable(new RegisterAnimalProductVM(hoso, options));
    createVMSelf.thongTinKhacVM = ko.observable(new ThongTinKhacVM(hoso, options));
    createVMSelf.noiDungKyVM = ko.observable(new KyHoSoVM(hoso, options.lstProvince));

    createVMSelf.fiModifyReason = ko.observable(null);
    createVMSelf.btnBack = function () {
        History.go(-1);
    };

    createVMSelf.uploadFileVM = ko.observable(new UploadFileVM((hoso != null && hoso.fiAttachmentList != null) ? hoso.fiAttachmentList : [], options.lstAttachmentType));

    createVMSelf.luuHosoClick = function () {
        if (!createVMSelf.validateData()) {
            $('#validate-data').text(ERROR_FILL_FORM);
            return;
        } else {
            var data = {};
            var url = "/mard/01/hoso/create";

            data = createVMSelf.toJSON();
        }

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
                            url: url,
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    fiIdHS = d.data.fiIdHS;
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/01/'
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
    };


    createVMSelf.validateData = function () {
        $('.validate').empty();
        var checkValidate = true;
        var regProfile = createVMSelf.toJSON();
        if (regProfile.fiExporterEmail) {
            if(regProfile.fiExporterEmail.indexOf('@') ==-1) {
                $('#fiExporterEmail-validate').text('Email chưa đúng định dạng');
                checkValidate = false;
            }
        }
        if (regProfile.fiImporterEmail) {
            if(regProfile.fiImporterEmail.indexOf('@') ==-1) {
                $('#fiImporterEmail-validate').text('Email chưa đúng định dạng');
                checkValidate = false;
            }
        }
        if (regProfile.fiSignName == null || regProfile.fiSignName == '') {
            $('#fiSignedBy-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiSignAddress == null || regProfile.fiSignAddress == '') {
            $('#fiSignAddress-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if ((regProfile.fiHealthCertificateContent == null
            || regProfile.fiHealthCertificateContent == '')) {
            var checkFile = false
            if (regProfile.fiAttachmentList.length > 0) {
                for(var i = 0; i < regProfile.fiAttachmentList.length; i++) {
                    if (regProfile.fiAttachmentList[i].fiAttachmentTypeCode == 5)
                        checkFile=true;
                }
            }
            if (!checkFile) {
                $('#file-dinh-kem').text(ERROR_FILL_CHUNG_NHAN);
                $('#fiHealthCertificateContentVni-validate').text(ERROR_FILL_CHUNG_NHAN);
                checkValidate = false;
            }
        }
        //thong tin chung
        if (regProfile.fiDepartmentNameVni == null || regProfile.fiDepartmentNameVni == '') {
            $('#fiDepartment-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiTaxCode == null || regProfile.fiTaxCode == '') {
            $('#fiTaxCode-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterNameVni == null || regProfile.fiExporterNameVni == '') {
            $('#fiExporterNameVni-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterName == null || regProfile.fiExporterName == '') {
            $('#fiExporterName-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterAdressVni == null || regProfile.fiExporterAdressVni == '') {
            $('#fiExporterAdressVni-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterAdress == null || regProfile.fiExporterAdress == '') {
            $('#fiExporterAdress-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterTel == null || regProfile.fiExporterTel == '') {
            $('#fiExporterTel-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterFax == null || regProfile.fiExporterFax == '') {
            $('#fiExporterFax-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiExporterEmail == null || regProfile.fiExporterEmail == '') {
            $('#fiExporterEmail-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }

        if (regProfile.fiObjectType == 1) {
            // thong tin dong vat
            if (regProfile.fiTotalAnimalByCharVni == null || regProfile.fiTotalAnimalByCharVni == '') {
                $('#fiTotalAnimalByCharVni-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiTotalAnimalByChar == null || regProfile.fiTotalAnimalByChar == '') {
                $('#fiTotalAnimalByChar-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiDeparturePlaceOfAnimalVni == null || regProfile.fiDeparturePlaceOfAnimalVni == '') {
                $('#fiDeparturePlaceOfAnimalVni-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiDeparturePlaceOfAnimal == null || regProfile.fiDeparturePlaceOfAnimal == '') {
                $('#fiDeparturePlaceOfAnimal-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiAnimalHealthStatus == null || regProfile.fiAnimalHealthStatus == '') {
                $('#fiAnimalHealthStatus-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (!regProfile.fiAnimalList.length) {
                $('#fiAnimalList-validate').text(ERROR_FILL_TABLE);
                checkValidate = false;
            }
        } else {
            // thong tin san pham dong vat
            if (!regProfile.fiAnimalProductList.length) {
                $('#fiAnimalList-validate').text(ERROR_FILL_TABLE);
                checkValidate = false;
            }
            if (regProfile.fiTotalAnimalProductByCharVni == null || regProfile.fiTotalAnimalProductByCharVni == '') {
                $('#fiTotalAnimalProductByCharVni-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiTotalAnimalProductByChar == null || regProfile.fiTotalAnimalProductByChar == '') {
                $('#fiTotalAnimalProductByChar-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiProcessingNameAddressVni == null || regProfile.fiProcessingNameAddressVni == '') {
                $('#fiProcessingNameAddressVni-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiProcessingNameAddress == null || regProfile.fiProcessingNameAddress == '') {
                $('#fiProcessingNameAddress-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiProcessingTel == null || regProfile.fiProcessingTel == '') {
                $('#fiProcessingTel-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiProcessingFax == null || regProfile.fiProcessingFax == '') {
                $('#fiProcessingFax-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
        }
        if (regProfile.fiImporteNameAddressVni == null || regProfile.fiImporteNameAddressVni == '') {
            $('#fiImporteNameAddressVni-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiImporteNameAddress == null || regProfile.fiImporteNameAddress == '') {
            $('#fiImporteNameAddress-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiImporterEmail == null || regProfile.fiImporterEmail == '') {
            $('#fiImporterEmail-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiImporterTel == null || regProfile.fiImporterTel == '') {
            $('#fiImporterTel-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiImporterFax == null || regProfile.fiImporterFax == '') {
            $('#fiImporterFax-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiBordergateNameVni == null || regProfile.fiBordergateNameVni == '') {
            $('#fiBordergateNameVni-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiBordergateName == null || regProfile.fiBordergateName == '') {
            $('#fiBordergateName-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiMeansTransportNameVni == null || regProfile.fiMeansTransportNameVni == '') {
            $('#fiMeansTransportNameVni-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiMeansTransportName == null || regProfile.fiMeansTransportName == '') {
            $('#fiMeansTransportName-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        // if (regProfile.fiTransitCountryCode == null || regProfile.fiTransitCountryCode == '') {
        //     $('#fiTransitCountryCode-validate').text(ERROR_FILL_INPUT);
        //     checkValidate = false;
        // }
        if (regProfile.fiImporterCountryCode == null || regProfile.fiImporterCountryCode == '') {
            $('#fiImporterCountry-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiConditionsTransport == null || regProfile.fiConditionsTransport == '') {
            $('#fiConditionsTransport-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiOtherTransport == null || regProfile.fiOtherTransport == '') {
            $('#fiOtherTransport-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiTransportAttrachFile == null || regProfile.fiTransportAttrachFile == '') {
            $('#fiTransportAttrachFile-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiLocationQuarantineVni == null || regProfile.fiLocationQuarantineVni == '') {
            $('#fiTransportAttrachFile-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiTimeQuarantine == null || regProfile.fiTimeQuarantine == '') {
            $('#fiTimeQuarantine-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiLocationQuarantine == null || regProfile.fiLocationQuarantine == '') {
            $('#fiLocationQuarantine-validate').text(ERROR_FILL_INPUT);
            checkValidate = false;
        }
        if (regProfile.fiImporterCountry && regProfile.fiImporterCountry.countryid == 4) {
            if (regProfile.fiEntryPointNameVni == null || regProfile.fiEntryPointNameVni == '') {
                $('#fiEntryPointNameVni-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
            if (regProfile.fiEntryPointName == null || regProfile.fiEntryPointName == '') {
                $('#fiEntryPointName-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
        }

        if (window.location.pathname.indexOf('ycs') > -1) {
            if (createVMSelf.fiModifyReason() == null || createVMSelf.fiModifyReason() == '') {
                $('#fiModifyReason-validate').text(ERROR_FILL_INPUT);
                checkValidate = false;
            }
        }
        if (checkValidate)
            return true;
        else
            return false;
    };

    createVMSelf.bGuiHoSoClick = function () {
        if (!createVMSelf.validateData()) {
            $('#validate-data').text(ERROR_FILL_FORM);
            app.Alert("Vui lòng nhập các trường thông tin bắt buộc (có đánh dấu *)");
            return;
        } else {
            if (!createVMSelf.uploadFileVM().isValid()) {
                app.Alert('Cần đính kèm các tệp bắt buộc(có đánh dấu *)');
                return;
            }
            var data = {};
            var url = "/mard/01/hoso/send";
            var method = 1;
            if (window.location.pathname.indexOf('edit') > -1) {
                method = 2;
            } else if (window.location.pathname.indexOf('ycs') > -1) {
                method = 3;
            }
            if (method === 3) {
                data = {
                    fiRegistrationProfile: createVMSelf.toJSON(),
                    fiReason: createVMSelf.fiModifyReason()
                };
                if (options.hoso)
                    data.fiRegistrationProfile.fiHSStatus = options.hoso.fiHSStatus;
                url = '/mard/01/hoso/ycs';
            } else {
                data = createVMSelf.toJSON();
                if (options.hoso)
                    data.fiHSStatus = options.hoso.fiHSStatus;
            }


            createVMSelf.verifySignature = function (signature, doc) {

                var data = {
                    'signatureXml': signature,
                    'messageXml': doc.sign.fiXml,
                    'msgFunc': doc.sign.fiFunc,
                    'msgType': doc.sign.fiMsgType,
                    'documentCode': doc.data.fiMaHoso,
                    'ministryCode': 'MARD',
                    'proceduceCode': '01'
                };
                app.makePost({
                    url: '/mard/01/verify',
                    data: JSON.stringify(data),
                    success: function (d) {
                        app.makePost({
                            url: method === 3 ? '/mard/01/hoso/guiycs' : '/mard/01/hoso/guihoso',
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
                                url: url,
                                data: JSON.stringify(data),
                                success: function (d) {
                                    if (!app.requireSigning) {
                                        if (d && d.success) {
                                            app.Alert('Gửi hồ sơ thành công');
                                            window.location.href = app.appContext + '/mard/01/'
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
    };

    createVMSelf.clearForm = function () {
        createVMSelf.errorMsg('');
    };

    createVMSelf.btnBack = function () {
        History.go(-1);
    };

    createVMSelf.toJSON = function () {
        var exclude = ["toJSON", "lstTranThuY", "lstCountry", "uploadFileVM", "noiDungKyVM"];

        var data = {
            fiObjectType: createVMSelf.fiObjectType(),
            fiIdHS: createVMSelf.fiIdHS(),
            fiAttachmentList: createVMSelf.uploadFileVM().toJSON()
        };

        if(data.fiObjectType == 1 || data.fiObjectType == "1") {
            $.extend(
                data,
                createVMSelf.thongtinChungVM().toJSON(),
                createVMSelf.thongTinKhacVM().toJSON(),
                createVMSelf.registerAnimalVM().toJSON(),
                createVMSelf.noiDungKyVM().toJSON()
            );
        } else {
            $.extend(
                data,
                createVMSelf.thongtinChungVM().toJSON(),
                createVMSelf.thongTinKhacVM().toJSON(),
                createVMSelf.registerAnimalProductVM().toJSON(),
                createVMSelf.noiDungKyVM().toJSON()
            );
        }

        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }

        return data;
    }

}

function init(options) {
    // options.maSoThue = hosoUsername;
    // options.tenCongty = hosoCompanyName;
    // options.diaChiCongty = hosoCompanyAddress;
    // options.dienthoaiCongty = hosoCompanyPhoneNumber;
    // options.faxCongty = hosoCompanyFax;
    // options.emailCongty = hosoCompanyEmail;
    options.isView = false;
    if (window.location.pathname.indexOf('view') > -1) {
        $('#mard01View input, #mard01View select, #mard01View textarea').attr('disabled', 'disabled');
        $('#mard01View select').attr('disabled', 'disabled');
        $('#mard01View table a').hide();
        $('#mard01View .tab-content .btn').hide();
        options.isView = true;
    }
    if (idHoSo) {
        var url = '/mard/01/hoso/timkiem?id=' + idHoSo;
        app.makeGet({
            url: url,
            success: function (d) {
                $('#loading01').hide();
                if (d.success) {
                    options.hoso = d.data;
                    var mard01CreateVM = new Mard01CreateVM(options);
                    ko.applyBindings(mard01CreateVM, document.getElementById('mard01Create'));
                }
            },
            error: function (e) {
                $('#loading01').hide();
                app.Alert('Không lấy được dữ liệu hồ sơ');
            }
        });
    } else {
        $('#loading01').hide();
        var mard01CreateVM = new Mard01CreateVM(options);
        ko.applyBindings(mard01CreateVM, document.getElementById('mard01Create'));
    }
}

$(document).ready(function () {
    var options = {};
    $('#loading01').show();

    $.when(
        app.sendGetRequest("/mard/01/danhmuc/quocgia", function (res) {
            options.lstCountry = res.data;
        }),
        app.sendGetRequest("/mard/01/danhmuc/tinhthanh", function (res) {
            options.lstProvince = res.data;
        }),
        app.sendGetRequest("/mard/01/danhmuc/cuakhau?countryCode=VN", function (res) {
            options.lstPort = res.data;
        }),
        app.sendGetRequest("/mard/01/unit", function (res) {
            options.lstUOMWeight = res.data;
        }),
        app.sendGetRequest('/mard/01/danhmuc/dvxl', function (res) {
            var lstTramThuY = [];

            var lstChildPU = res.data[0].lstChildPU;

            lstChildPU.forEach(function (itemChicuc) {
                lstTramThuY.push({
                    id: itemChicuc.fiPUCode,
                    name: itemChicuc.fiPUDescVni,
                    nameVni: itemChicuc.fiPUDescVni,
                    nameEng: itemChicuc.fiPUDesc
                });
                itemChicuc.lstChildPU.forEach(function (itemTram) {
                    lstTramThuY.push({
                        id: itemTram.fiPUCode,
                        name: itemTram.fiPUDescVni,
                        nameVni: itemTram.fiPUDescVni,
                        nameEng: itemTram.fiPUDesc
                    });
                })
            });
            options.lstTramThuY = lstTramThuY;
        }),
        app.sendGetRequest("/mard/01/danhmuc/dinhkem?systemId=1", function (res) {
            options.lstAttachmentType = res.data;
        }),
        app.sendGetRequest("/mard/01/danhmuc/trangthai", function (res) {
            options.lstTrangthai = res.data;
            options.mapTrangthai = {};
            options.lstTrangthai.forEach(function (status) {
                options.mapTrangthai[status.id.toString()] = status.name;
            })
        })
    ).done(function (data) {
        $('#loading01').hide();
        init(options);
    });
});
