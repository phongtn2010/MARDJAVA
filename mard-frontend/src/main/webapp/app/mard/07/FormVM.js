var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var TOKEN_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken';
var UPLOAD_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload';

function ProductVM(options, validator) {
    var productVMSelf = this;
    productVMSelf.productType = ko.observable(null);
    productVMSelf.selectedIndex = ko.observable(null);
    productVMSelf.fiCodeOfGoods = ko.observable(null);
    productVMSelf.fiSelectedGoods = ko.observable(null);
    productVMSelf.fiNameOfGoods = ko.observable((options && options.hasOwnProperty('fiNameOfGoods')) ? options.fiNameOfGoods : null);
    if (validator.includes('fiNameOfGoods')) {
        productVMSelf.fiNameOfGoods.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiNameSicenceOfGoods = ko.observable((options && options.hasOwnProperty('fiNameSicenceOfGoods')) ? options.fiNameSicenceOfGoods : null);
    if (validator.includes('fiNameSicenceOfGoods')) {
        productVMSelf.fiNameSicenceOfGoods.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiHSCodeOfGoods = ko.observable((options && options.hasOwnProperty('fiHSCodeOfGoods')) ? options.fiHSCodeOfGoods : null);
    if (validator.includes('fiHSCodeOfGoods')) {
        productVMSelf.fiHSCodeOfGoods.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiSpecies = ko.observable((options && options.hasOwnProperty('fiSpecies')) ? options.fiSpecies : null);
    if (validator.includes('fiSpecies')) {
        productVMSelf.fiSpecies.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiValueOfGoods = ko.observable((options && options.hasOwnProperty('fiValueOfGoods')) ? options.fiValueOfGoods : null);
    if (validator.includes('fiValueOfGoods')) {
        productVMSelf.fiValueOfGoods.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiCategoryOfGoods = ko.observable((options && options.hasOwnProperty('fiCategoryOfGoods')) ? options.fiCategoryOfGoods : null);
    if (validator.includes('fiCategoryOfGoods')) {
        productVMSelf.fiCategoryOfGoods.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiClassification = ko.observable((options && options.hasOwnProperty('fiClassification')) ? options.fiClassification : null);
    if (validator.includes('fiClassification')) {
        productVMSelf.fiClassification.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiPreservation = ko.observable((options && options.hasOwnProperty('fiPreservation')) ? options.fiPreservation : null);
    if (validator.includes('fiPreservation')) {
        productVMSelf.fiPreservation.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiSizeOrShape = ko.observable((options && options.hasOwnProperty('fiSizeOrShape')) ? options.fiSizeOrShape : null);
    if (validator.includes('fiSizeOrShape')) {
        productVMSelf.fiSizeOrShape.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiMaxQuantity = ko.observable(0);
    productVMSelf.fiQuantityOrWeight = ko.observable((options && options.hasOwnProperty('fiQuantityOrWeight')) ? options.fiQuantityOrWeight : null);
    if (validator.includes('fiQuantityOrWeight')) {
        productVMSelf.fiQuantityOrWeight.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]},
            max: {
                params: ko.computed(function () {
                    return productVMSelf.fiMaxQuantity();
                }),
                onlyIf: ko.computed(function () {
                    return !(!productVMSelf.fiSelectedGoods())
                }),
                message: function (params, observable) {
                    return NSWLang["common_msg_formvaild_maxvalue"] + " " + params;
                }
            }
        });
    }
    productVMSelf.fiQuantityOrWeightUnitCode = ko.observable((options && options.hasOwnProperty('fiQuantityOrWeightUnitCode')) ? options.fiQuantityOrWeightUnitCode : null);
    if (validator.includes('fiQuantityOrWeightUnitCode')) {
        productVMSelf.fiQuantityOrWeightUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiQuantityOrWeightUnitName = ko.observable((options && options.hasOwnProperty('fiQuantityOrWeightUnitName')) ? options.fiQuantityOrWeightUnitName : null);
    if (validator.includes('fiQuantityOrWeightUnitName')) {
        productVMSelf.fiQuantityOrWeightUnitName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiOriginationCode = ko.observable((options && options.hasOwnProperty('fiOriginationCode')) ? options.fiOriginationCode : null);
    if (validator.includes('fiOriginationCode')) {
        productVMSelf.fiOriginationCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiOriginationName = ko.observable((options && options.hasOwnProperty('fiOriginationName')) ? options.fiOriginationName : null);
    if (validator.includes('fiOriginationName')) {
        productVMSelf.fiOriginationName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    productVMSelf.fiGoodsList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.07.table.thong_tin_hang_hoa"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })
    productVMSelf.lstUOM = ko.observableArray((options && options.hasOwnProperty('lstUOM')) ? options.lstUOM : []);
    productVMSelf.lstCountry = ko.observableArray((options && options.hasOwnProperty('lstCountry')) ? options.lstCountry : []);
    productVMSelf.lstSpecies = ko.observableArray(
        (options && options.hasOwnProperty('lstSpecies')) ? options.lstSpecies : []
    )
    productVMSelf.lstCategory = ko.observableArray(
        (options && options.hasOwnProperty('lstCategory')) ? options.lstCategory : []
    )
    productVMSelf.lstClassification = ko.observableArray(
        (options && options.hasOwnProperty('lstClassification')) ? options.lstClassification : []
    )
    productVMSelf.lstCVProduct = ko.observableArray([]);

    productVMSelf.errorMsg = ko.observable('');

    productVMSelf.fiSelectedGoods.subscribe(function (item) {
        if (item) {
            productVMSelf.fiCodeOfGoods(item.fiId);
            productVMSelf.fiMaxQuantity(item.fiQuantity);
            productVMSelf.fiNameOfGoods(item.fiProductBusinessName);
            productVMSelf.fiNameSicenceOfGoods(item.fiProductScienceName);
            productVMSelf.fiSizeOrShape(item.fiSizeOrType);
            productVMSelf.fiQuantityOrWeight(item.fiQuantity);
            productVMSelf.fiQuantityOrWeightUnitCode(item.fiPackageUnitCode);
            productVMSelf.fiOriginationCode(item.fiOriginCountryCode);
        } else {
            productVMSelf.clearForm();
        }
    })

    productVMSelf.fiQuantityOrWeightUnitCode.subscribe(function (item) {
        if (item) {
            var unit = productVMSelf.lstUOM().filter(function (val) {
                return val.unitcode == item;
            })
            productVMSelf.fiQuantityOrWeightUnitName(unit.length > 0 ? unit[0].unitname : '');
        }
    })

    productVMSelf.fiOriginationCode.subscribe(function (item) {
        if (item) {
            var unit = productVMSelf.lstCountry().filter(function (val) {
                return val.countrycode == item;
            })
            productVMSelf.fiOriginationName(unit.length > 0 ? unit[0].countryname : '');
        }
    })

    productVMSelf.errors = ko.validation.group({
        fiNameOfGoods: productVMSelf.fiNameOfGoods,
        fiNameSicenceOfGoods: productVMSelf.fiNameSicenceOfGoods,
        fiHSCodeOfGoods: productVMSelf.fiHSCodeOfGoods,
        fiSpecies: productVMSelf.fiSpecies,
        fiValueOfGoods: productVMSelf.fiValueOfGoods,
        fiCategoryOfGoods: productVMSelf.fiCategoryOfGoods,
        fiClassification: productVMSelf.fiClassification,
        fiPreservation: productVMSelf.fiPreservation,
        fiSizeOrShape: productVMSelf.fiSizeOrShape,
        fiQuantityOrWeight: productVMSelf.fiQuantityOrWeight,
        fiQuantityOrWeightUnitName: productVMSelf.fiQuantityOrWeightUnitName,
        fiOriginationName: productVMSelf.fiOriginationName,
        fiQuantityOrWeightUnitCode: productVMSelf.fiQuantityOrWeightUnitCode,
        fiOriginationCode: productVMSelf.fiOriginationCode
    })


    productVMSelf.clearForm = function () {
        productVMSelf.errorMsg('');
        productVMSelf.fiCodeOfGoods(null);
        productVMSelf.selectedIndex(null);
        productVMSelf.fiSelectedGoods(null);
        productVMSelf.fiNameOfGoods(null);
        productVMSelf.fiNameSicenceOfGoods(null);
        productVMSelf.fiHSCodeOfGoods(null);
        productVMSelf.fiSpecies(null);
        productVMSelf.fiValueOfGoods(null);
        productVMSelf.fiCategoryOfGoods(null);
        productVMSelf.fiClassification(null);
        productVMSelf.fiPreservation(null);
        productVMSelf.fiSizeOrShape(null);
        productVMSelf.fiQuantityOrWeight(null);
        if (productVMSelf.productType() != 2 && productVMSelf.productType() != '2') {
            productVMSelf.fiQuantityOrWeightUnitCode(null);
            productVMSelf.fiQuantityOrWeightUnitName(null);
        }
        productVMSelf.fiOriginationCode(null);
        productVMSelf.fiOriginationName(null);
    }

    productVMSelf.validate = function () {
        if (productVMSelf.errors().length > 0) {
            productVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    productVMSelf.update = function (data) {
        ko.mapping.fromJS(data, {}, productVMSelf);
        // productVMSelf.fiSelectedGoods(data.fiSelectedGoods);
    }

    productVMSelf.openUpdateModal = function (data, index) {
        if (productVMSelf.lstCVProduct().length > 0) {
            if (!data.fiSelectedGoods) {
                var selectedProduct = productVMSelf.lstCVProduct().filter(function (product) {
                    return product.fiId == data.fiCodeOfGoods;
                });
                productVMSelf.fiSelectedGoods(selectedProduct[0]);
            } else {
                productVMSelf.fiSelectedGoods(data.fiSelectedGoods);
            }
        }
        productVMSelf.update(data);
        productVMSelf.selectedIndex(index);
        $('#modal_editProduct').modal('show');
    }

    productVMSelf.openUpdateModal2 = function (data, index) {
        productVMSelf.update(data);
        productVMSelf.selectedIndex(index);
        $('#modal_editProduct2').modal('show');
    }

    productVMSelf.addProduct = function () {
        if (!productVMSelf.validate()) return;
        var item = {
            fiSelectedGoods: productVMSelf.fiSelectedGoods(),
            fiCodeOfGoods: productVMSelf.fiCodeOfGoods(),
            fiNameOfGoods: productVMSelf.fiNameOfGoods(),
            fiNameSicenceOfGoods: productVMSelf.fiNameSicenceOfGoods(),
            fiHSCodeOfGoods: productVMSelf.fiHSCodeOfGoods(),
            fiSpecies: productVMSelf.fiSpecies(),
            fiValueOfGoods: productVMSelf.fiValueOfGoods(),
            fiCategoryOfGoods: productVMSelf.fiCategoryOfGoods(),
            fiClassification: productVMSelf.fiClassification(),
            fiPreservation: productVMSelf.fiPreservation(),
            fiSizeOrShape: productVMSelf.fiSizeOrShape(),
            fiQuantityOrWeight: productVMSelf.fiQuantityOrWeight(),
            fiQuantityOrWeightUnitCode: productVMSelf.fiQuantityOrWeightUnitCode(),
            fiQuantityOrWeightUnitName: productVMSelf.fiQuantityOrWeightUnitName(),
            fiOriginationCode: productVMSelf.fiOriginationCode(),
            fiOriginationName: productVMSelf.fiOriginationName()
        }

        var fiGoodList = productVMSelf.fiGoodsList();
        var existedGoods = fiGoodList.findIndex(function (goods) {
            return goods.fiCodeOfGoods != null && goods.fiCodeOfGoods == item.fiCodeOfGoods;
        })
        if (existedGoods > -1) {
            fiGoodList.splice(existedGoods, 1, item);
        } else {
            fiGoodList.push(item);
        }
        productVMSelf.fiGoodsList(fiGoodList);
        productVMSelf.clearForm();
        if ($('#modal_addProduct').hasClass('in')) {
            $('#modal_addProduct').modal('hide')
        }
        if ($('#modal_addProduct2').hasClass('in')) {
            $('#modal_addProduct2').modal('hide')
        }
    }

    productVMSelf.updateProduct = function () {
        if (!productVMSelf.validate()) return;
        var item = {
            fiCodeOfGoods: productVMSelf.fiCodeOfGoods(),
            fiNameOfGoods: productVMSelf.fiNameOfGoods() ? (productVMSelf.fiNameOfGoods().fiProductBusinessName ? productVMSelf.fiNameOfGoods().fiProductBusinessName : productVMSelf.fiNameOfGoods()) : null,
            fiNameSicenceOfGoods: productVMSelf.fiNameSicenceOfGoods(),
            fiHSCodeOfGoods: productVMSelf.fiHSCodeOfGoods(),
            fiSpecies: productVMSelf.fiSpecies(),
            fiValueOfGoods: productVMSelf.fiValueOfGoods(),
            fiCategoryOfGoods: productVMSelf.fiCategoryOfGoods(),
            fiClassification: productVMSelf.fiClassification(),
            fiPreservation: productVMSelf.fiPreservation(),
            fiSizeOrShape: productVMSelf.fiSizeOrShape(),
            fiQuantityOrWeight: productVMSelf.fiQuantityOrWeight(),
            fiQuantityOrWeightUnitCode: productVMSelf.fiQuantityOrWeightUnitCode(),
            fiQuantityOrWeightUnitName: productVMSelf.fiQuantityOrWeightUnitName(),
            fiOriginationCode: productVMSelf.fiOriginationCode(),
            fiOriginationName: productVMSelf.fiOriginationName()
        }


        var index = productVMSelf.selectedIndex();
        if (index > -1 && (item.fiCodeOfGoods == null || item.fiCategoryOfGoods == "")) {
            productVMSelf.fiGoodsList.splice(index, 1);
            productVMSelf.fiGoodsList.splice(index, 0, item);
        } else {
            var fiGoodList = productVMSelf.fiGoodsList();
            var existedGoods = fiGoodList.findIndex(function (goods) {
                return goods.fiCodeOfGoods != null && goods.fiCodeOfGoods == item.fiCodeOfGoods;
            })
            if (existedGoods > -1) {
                fiGoodList.splice(existedGoods, 1, item);
            } else {
                fiGoodList.push(item);
            }


            productVMSelf.fiGoodsList(fiGoodList);
        }

        productVMSelf.clearForm();
        if ($('#modal_editProduct').hasClass('in')) {
            $('#modal_editProduct').modal('hide')
        }
        if ($('#modal_editProduct2').hasClass('in')) {
            $('#modal_editProduct2').modal('hide')
        }
    }

    productVMSelf.removeProduct = function (index) {
        productVMSelf.fiGoodsList.splice(index, 1);
    }
}

var SuaGCNVM = function (title, cert) {
    var self = this;

    self.title = ko.observable(title);
    self.lstAtch = ko.observableArray([]);
    self.fiReason = ko.observable(null);

    self.onAddFile = function () {
        self.lstAtch.push(new AttachSuaGCNVM())
    };

    self.onDelete = function (index) {
        self.lstAtch.splice(index, 1)
    };

    self.fileChange = function (fileVM, file) {
        if (file) {
            $('#loading08').show();
            var fiTenLoai = "Tệp đính kèm xin sửa GCN";
            var fiMaLoai = '-1';
            var fiFileName = file.name;

            // var formData = new FormData();
            // formData.append('file', file);
            // formData.append('fiTenLoai', fiTenLoai);
            // formData.append('fiMaLoai', fiMaLoai);
            //
            // $.ajax({
            //     type: 'POST',
            //     cache: false,
            //     crossDomain: true,
            //     url: app.appContext + '/mard/07/dinhkem/create',
            //     data: formData,
            //     processData: false,
            //     contentType: false,
            //     beforeSend: function (xhr) {
            //         xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            //     },
            //     success: function (res) {
            //         $('#loading08').hide();
            //         if (res.success == true) {
            //             fileVM.fiDuongDan(res.data);
            //         } else {
            //             alert("Có lỗi khi tải tệp!!!")
            //         }
            //     },
            //     error: function (x, t, m) {
            //         $('#loading08').hide();
            //     },
            //     complete: function (jqXHR, textStatus) {
            //     }
            // });

            // Upload file
            var token = null;

            $.ajax({
                type: 'GET',
                cache: false,
                url: TOKEN_URL,
                success: function (response) {
                    if (response.status == 'Successful') {
                        token = response.data;
                        var formData = new FormData();
                        formData.append('token', token);
                        formData.append('documentType', 'BNNPTNT0600010');
                        formData.append('fileCode', fiMaLoai);
                        formData.append('fileName', fiFileName);
                        formData.append('file', file);

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            url: UPLOAD_URL,
                            data: formData,
                            processData: false,
                            contentType: false,
                            success: function (res) {
                                $('#loading08').hide();
                                if (res.status == 'Successful') {
                                    fileVM.fiDuongDan(res.data.UrlFile);
                                    fileVM.fiGuid(res.data.ItemId);
                                } else {
                                    alert("Có lỗi khi tải tệp!!!");
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading08').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                            }
                        })
                    } else {
                        alert("Có lỗi khi tải tệp!!!");
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                }
            });
        }
    };

    self.onSend = function () {
        var data = ko.toJS(self);
        var dataToAdd = {
            fiCertType: cert.fiCertType,
            fiReason: data.fiReason,
            // lstAtch: data.lstAtch,
            fiNSWFileCode: cert.fiNSWFileCode,
            fiCertificateNo: cert.fiCertificateNo
        };

        app.makePost({
            url: '/mard/07/giayphep/edit',
            data: JSON.stringify(dataToAdd),
            success: function (res) {
                if (res.success) {
                    app.Alert('Gửi yêu cầu thành công');
                    if ($('#modal_req_edit_cert').hasClass('in')) {
                        $('#modal_req_edit_cert').modal('hide')
                    }
                } else {
                    app.Alert('Có lỗi khi gửi yêu cầu');
                    if ($('#modal_req_edit_cert').hasClass('in')) {
                        $('#modal_req_edit_cert').modal('hide')
                    }
                }

            },
            error: function (res) {
                app.Alert('Có lỗi khi gửi yêu cầu');
                if ($('#modal_req_edit_cert').hasClass('in')) {
                    $('#modal_req_edit_cert').modal('hide')
                }
            }
        })

    };

    return self;
};

var AttachSuaGCNVM = function () {
    var selfAt = this;

    selfAt.fiMaLoai = ko.observable(-1);

    selfAt.fiTenLoai = ko.observable("Tệp đính kèm xin sửa GCN");

    selfAt.fiTenTep = ko.observable(null);

    selfAt.fiDuongDan = ko.observable(null);

    selfAt.fiGuid = ko.observable(null);

};

function UploadFileVM(lstAtch) {
    var ufVMSelf = this;
    ufVMSelf.lstAtch = ko.observableArray([]);
    ufVMSelf.selectedAttachVM = ko.observable(null);
    ufVMSelf.errorMsg = ko.observable(null);
    ufVMSelf.uploadedFiles = ko.observableArray([]);

    ufVMSelf.updateAtchType = function(lstAtchType) {
        if (lstAtchType) {
            ufVMSelf.lstAtch(mapAttachmentVM(lstAtch, lstAtchType));
        }
    }

    ufVMSelf.addFiles = function (atchVM) {
        ufVMSelf.selectedAttachVM($.extend(true, {}, atchVM));
        var lstFiles = [];
        ufVMSelf.uploadedFiles(lstFiles.concat(ufVMSelf.selectedAttachVM().lstFiles()));
    }

    ufVMSelf.fileChange = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading08').show();
            var fiTenLoai = ufVMSelf.selectedAttachVM().fiTenLoai();
            var fiMaLoai = ufVMSelf.selectedAttachVM().fiMaLoai();
            var fiFileName = files[0].name;

            // Upload file
            var token = null;

            $.ajax({
                type: 'GET',
                cache: false,
                url: TOKEN_URL,
                success: function (response) {
                    if (response.status == 'Successful') {
                        token = response.data;
                        var formData = new FormData();
                        formData.append('token', token);
                        formData.append('documentType', 'BNNPTNT0600010');
                        formData.append('fileCode', fiMaLoai);
                        formData.append('fileName', fiFileName);
                        formData.append('file', files[0]);

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            url: UPLOAD_URL,
                            data: formData,
                            processData: false,
                            contentType: false,
                            success: function (res) {
                                $('#loading08').hide();
                                if (res.status == 'Successful') {
                                    var file = new FileVM({
                                        fiGuid: res.data.ItemId,
                                        fiPath: res.data.UrlFile,
                                        fiFileTypeCode: fiMaLoai,
                                        fiFileTypeName: fiTenLoai,
                                        fiFileName: fiFileName,
                                        fiActive: 0
                                    })
                                    $('#btnfile3').val('');
                                    ufVMSelf.uploadedFiles.push(file);
                                    ufVMSelf.selectedAttachVM().isUploaded(true);
                                    ufVMSelf.errorMsg('');
                                } else {
                                    ufVMSelf.errorMsg('Có lỗi tải file lên');
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading08').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                $(e.target).val("");
                            }
                        })
                    } else {
                        ufVMSelf.errorMsg('Có lỗi tải file lên');
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                }
            });
        }
    }

    ufVMSelf.removeFileUpload = function (file) {
        ufVMSelf.uploadedFiles.remove(function (item) {
            return item.fiGuid() == file.fiGuid();
        })
    }

    ufVMSelf.cancelUpload = function () {
        ufVMSelf.uploadedFiles([]);
        ufVMSelf.selectedAttachVM().isUploaded(false);
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
    }

    ufVMSelf.saveUpload = function () {
        ufVMSelf.selectedAttachVM().lstFiles(ufVMSelf.uploadedFiles());
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
    }

    ufVMSelf.doDelete = function (data) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hết các tệp của mục này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        data.lstFiles([]);
                        data.isUploaded(false);
                        $('.upload-file').prop("value", "");
                        app.popupRemove(popConfirm.selector);
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(popConfirm.selector);
                    }
                }
            ]
        });
        return;
    }

    ufVMSelf.getLstAttachments = function () {
        var lstAttachment = ufVMSelf.lstAtch();
        var result = [];
        for (var i = 0; i < lstAttachment.length; i++) {
            var lstFiles = JSON.parse(ko.toJSON(lstAttachment[i].lstFiles()));
            result = result.concat(lstFiles);
        }
        return result;
    }

    ufVMSelf.validate = function () {
        var lstAttachment = ufVMSelf.lstAtch();
        var isMissingFile = false;
        for (var i = 0; i< lstAttachment.length; i++) {
            if (lstAttachment[i].isRequired() && lstAttachment[i].lstFiles().length == 0) {
                isMissingFile = true;
                break;
            }
        }
        return !isMissingFile;
    }
}

function AttachmentVM(options) {
    var atchVMSelf = this;
    atchVMSelf.fiMaLoai = ko.observable((options && options.hasOwnProperty('fiMaLoai')) ? options.fiMaLoai : null);
    atchVMSelf.fiTenLoai = ko.observable((options && options.hasOwnProperty('fiTenLoai')) ? options.fiTenLoai : null);
    atchVMSelf.isUploaded = ko.observable((options && options.hasOwnProperty('isUploaded')) ? options.isUploaded : false);
    atchVMSelf.isRequired = ko.observable((options && options.hasOwnProperty('isRequired')) ? options.isRequired : false);
    atchVMSelf.errorMsg = ko.observable(null);

    atchVMSelf.lstFiles = ko.observableArray([]);
}

function FileVM(options) {
    var fileVMSelf = this;
    fileVMSelf.fiIdDinhkem = ko.observable((options && options.hasOwnProperty('fiIdDinhkem')) ? options.fiIdDinhkem : null);
    fileVMSelf.fiFileTypeCode = ko.observable((options && options.hasOwnProperty('fiFileTypeCode')) ? options.fiFileTypeCode : null);
    fileVMSelf.fiFileTypeName = ko.observable((options && options.hasOwnProperty('fiFileTypeName')) ? options.fiFileTypeName : null);
    fileVMSelf.fiFileName = ko.observable((options && options.hasOwnProperty('fiFileName')) ? options.fiFileName : null);
    fileVMSelf.fiActive = ko.observable((options && options.hasOwnProperty('fiActive')) ? options.fiActive : null);
    fileVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);
    fileVMSelf.fiPath = ko.observable((options && options.hasOwnProperty('fiPath')) ? options.fiPath : null);
    fileVMSelf.fiGuid = ko.observable((options && options.hasOwnProperty('fiGuid')) ? options.fiGuid : null);

    fileVMSelf.downloadFile = function (data) {
        var link = document.createElement('a');
        link.href = data.fiPath();
        link.target = '_blank';
        document.body.appendChild(link);
        link.click();
        link.remove();
        // window.location = data.fiPath();
        // return true;
    }
}

function mapAttachmentVM(lstAtch, lstAtchType) {
    var result = [];

    for (var i = 0; i < lstAtchType.length; i++) {
        var attachmentVM = new AttachmentVM({
            fiTenLoai: lstAtchType[i].atchTypeName,
            isUploaded: false,
            isRequired: lstAtchType[i].required,
            fiMaLoai: lstAtchType[i].atchTypeId
        });

        for (var j = 0; j < lstAtch.length; j++) {
            if (lstAtchType[i].atchTypeId === lstAtch[j].fiFileTypeCode) {
                var file = new FileVM(lstAtch[j]);
                attachmentVM.lstFiles.push(file);
                attachmentVM.isUploaded(true);
            }
        }
        result.push(attachmentVM)

    }

    return result;
}
