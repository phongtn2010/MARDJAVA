var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var TOKEN_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken';
var UPLOAD_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload';

function ProductVM(data, validator) {
    var productVMSelf = this;
    productVMSelf.fiIdProduct = ko.observable(null);
    productVMSelf.fiProductType = ko.observable(null);
    productVMSelf.fiProductBusinessName = ko.observable(null);
    if (validator.includes('fiProductBusinessName')) {
        productVMSelf.fiProductBusinessName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiProductScienceName = ko.observable(null);
    if (validator.includes('fiProductScienceName')) {
        productVMSelf.fiProductScienceName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiQuantity = ko.observable(null);
    if (validator.includes('fiQuantity')) {
        productVMSelf.fiQuantity.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiPackageUnitCode = ko.observable(null);
    if (validator.includes('fiPackageUnitCode')) {
        productVMSelf.fiPackageUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiPackageUnitName = ko.observable(null);
    if (validator.includes('fiPackageUnitName')) {
        productVMSelf.fiPackageUnitName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiOriginCountryCode = ko.observable(null);
    if (validator.includes('fiOriginCountryCode')) {
        productVMSelf.fiOriginCountryCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiOriginCountryName = ko.observable(null);
    if (validator.includes('fiOriginCountryName')) {
        productVMSelf.fiOriginCountryName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiSizeOrType = ko.observable(null);
    if (validator.includes('fiSizeOrType')) {
        productVMSelf.fiSizeOrType.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    productVMSelf.selectedIndex = ko.observable(null);

    productVMSelf.lstCountry = ko.observable((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);
    productVMSelf.lstPort = ko.observable((data && data.hasOwnProperty('lstPort')) ? data.lstPort : []);
    productVMSelf.lstUOMAnimal = ko.observable((data && data.hasOwnProperty('lstUOMAnimal')) ? data.lstUOMAnimal : []);
    productVMSelf.lstUOMWeight = ko.observable((data && data.hasOwnProperty('lstUOMWeight')) ? data.lstUOMWeight : []);
    productVMSelf.lstUOMSpecialMesurement = ko.observable((data && data.hasOwnProperty('lstUOMSpecialMesurement')) ? data.lstUOMSpecialMesurement : []);

    productVMSelf.fiProductList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.06.tokhai.thong_tin_hang_hoa"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })

    productVMSelf.fiPackageUnitCode.subscribe(function (item) {
        var unit = productVMSelf.lstUOMAnimal().filter(function (val) {
            return val.unitcode == item;
        })
        productVMSelf.fiPackageUnitName(unit.length > 0 ? unit[0].unitname : '');
    })

    productVMSelf.fiOriginCountryCode.subscribe(function (item) {
        var unit = productVMSelf.lstCountry().filter(function (val) {
            return val.countrycode == item;
        })
        productVMSelf.fiOriginCountryName(unit.length > 0 ? unit[0].countryname : '');
    })

    productVMSelf.errorMsg = ko.observable('');

    productVMSelf.errors = ko.validation.group({
        fiProductBusinessName: productVMSelf.fiProductBusinessName,
        fiProductScienceName: productVMSelf.fiProductScienceName,
        fiQuantity: productVMSelf.fiQuantity,
        fiPackageUnitCode: productVMSelf.fiPackageUnitCode,
        fiPackageUnitName: productVMSelf.fiPackageUnitName,
        fiOriginCountryCode: productVMSelf.fiOriginCountryCode,
        fiOriginCountryName: productVMSelf.fiOriginCountryName,
        fiSizeOrType: productVMSelf.fiSizeOrType
    })

    productVMSelf.clearForm = function () {
        productVMSelf.errorMsg('');
        productVMSelf.fiProductBusinessName(null);
        productVMSelf.fiProductScienceName(null);
        productVMSelf.fiQuantity(null);
        if (productVMSelf.fiProductType() != 2 && productVMSelf.fiProductType() != '2') {
            productVMSelf.fiPackageUnitCode(null);
            productVMSelf.fiPackageUnitName(null);
        }
        productVMSelf.fiOriginCountryCode(null);
        productVMSelf.fiOriginCountryName(null);
        productVMSelf.fiSizeOrType(null);
    }

    productVMSelf.validate = function () {
        if (productVMSelf.errors().length > 0) {
            productVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    productVMSelf.getCountryName = function (countrycode) {
        var lstCountry = productVMSelf.lstCountry();
        var pos = lstCountry.find(function (e) {
            return e.countrycode == countrycode;
        })
        if (pos)
            return pos.countryname;
        else return ''
    }

    productVMSelf.getPortName = function (portcode) {
        var lstPort = productVMSelf.lstPort();
        var pos = lstPort.find(function (e) {
            return e.portcode == portcode;
        })
        if (pos)
            return pos.portname;
        else return ''
    }

    productVMSelf.getUnitName = function (unitcode, type) {
        var lstUOMs = [];
        if (type == 1) {
            lstUOMs = productVMSelf.lstUOMAnimal();
        } else if (type == 2) {
            lstUOMs = productVMSelf.lstUOMWeight();
        } else {
            lstUOMs = productVMSelf.lstUOMSpecialMesurement();
        }
        var pos = lstUOMs.find(function (e) {
            return e.unitcode == unitcode;
        })
        if (pos)
            return pos.unitname;
        else return '';
    }

    productVMSelf.setUnitCode = function (unitname) {
        var unit = productVMSelf.lstUOMAnimal().filter(function (val) {
            return val.unitname == unitname;
        })
        return unit.length > 0 ? unit[0].unitcode : '';
    }

    productVMSelf.setCountryCode = function (countryname) {
        var unit = productVMSelf.lstCountry().filter(function (val) {
            return val.countryname == countryname;
        })
        return unit.length > 0 ? unit[0].countrycode : '';
    }

    productVMSelf.addProductFromExcel = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading08').show();
            var formData = new FormData();
            formData.append("file", files[0]);

            $.ajax({
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/06/uploadExcel?type=product',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                },
                success: function (res) {
                    $('#loading08').hide();
                    if (res.success == true) {
                        var data = res.data;
                        var hasError = false;
                        data.forEach(function (product) {
                            if (hasError) return true;
                            product.fiPackageUnitCode = productVMSelf.setUnitCode(product.fiPackageUnitName);
                            if (!product.fiPackageUnitCode) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị: ' + product.fiPackageUnitName);
                                hasError = true;
                                return true;
                            }
                            product.fiOriginCountryCode = productVMSelf.setCountryCode(product.fiOriginCountryName);
                            if (!product.fiOriginCountryCode) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai tên nước: ' + product.fiOriginCountryName);
                                hasError = true;
                                return true;
                            }
                            validator.forEach(function (field) {
                                if (!product[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var productList = productVMSelf.fiProductList();
                            productList = productList.concat(data);
                            productVMSelf.fiProductList(productList);
                        }
                    } else {
                        // handle error here
                        app.Alert('File excel tải lên không đúng định dạng');
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                    $(e.target).val("");
                }
            });
        }
    }

    productVMSelf.openUpdateProduct = function (data, index, type) {
        ko.mapping.fromJS(data, {}, productVMSelf);
        productVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_editProduct1').modal('show');
        } else {
            $('#modal_editProduct2').modal('show');
        }
    }

    productVMSelf.updateProduct = function () {
        if (!productVMSelf.validate()) return;
        var item = {
            fiProductBusinessName: productVMSelf.fiProductBusinessName(),
            fiProductScienceName: productVMSelf.fiProductScienceName(),
            fiQuantity: productVMSelf.fiQuantity(),
            fiSizeOrType: productVMSelf.fiSizeOrType(),
            fiPackageUnitCode: productVMSelf.fiPackageUnitCode(),
            fiPackageUnitName: productVMSelf.fiPackageUnitName(),
            fiOriginCountryCode: productVMSelf.fiOriginCountryCode(),
            fiOriginCountryName: productVMSelf.fiOriginCountryName()
        }
        var index = productVMSelf.selectedIndex();
        productVMSelf.fiProductList.splice(index, 1);
        productVMSelf.fiProductList.splice(index, 0, item);
        productVMSelf.clearForm();
        if ($('#modal_editProduct1').hasClass('in')) {
            $('#modal_editProduct1').modal('hide')
        }
        ;
        if ($('#modal_editProduct2').hasClass('in')) {
            $('#modal_editProduct2').modal('hide')
        }
        ;
    }

    productVMSelf.addProduct = function () {
        if (!productVMSelf.validate()) return;
        var item = {
            fiProductBusinessName: productVMSelf.fiProductBusinessName(),
            fiProductScienceName: productVMSelf.fiProductScienceName(),
            fiQuantity: productVMSelf.fiQuantity(),
            fiSizeOrType: productVMSelf.fiSizeOrType(),
            fiPackageUnitCode: productVMSelf.fiPackageUnitCode(),
            fiPackageUnitName: productVMSelf.fiPackageUnitName(),
            fiOriginCountryCode: productVMSelf.fiOriginCountryCode(),
            fiOriginCountryName: productVMSelf.fiOriginCountryName(),
        }
        productVMSelf.fiProductList.push(item);
        productVMSelf.clearForm();
        if ($('#modal_addAnimal').hasClass('in')) {
            $('#modal_addAnimal').modal('hide')
        }
        ;
        if ($('#modal_addAnimalProduct').hasClass('in')) {
            $('#modal_addAnimalProduct').modal('hide')
        }
    }

    productVMSelf.removeProduct = function (index) {
        productVMSelf.fiProductList.splice(index, 1);
    }
}

function ExporterVM(data, validator) {
    if (!data) data = {};
    var exporterVMSelf = this;
    exporterVMSelf.fiIdExporter = ko.observable(null);
    exporterVMSelf.fiIdHS = ko.observable(null);
    exporterVMSelf.fiExporterCountryName = ko.observable(null);
    if (validator.includes('fiExporterCountryName')) {
        exporterVMSelf.fiExporterCountryName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    exporterVMSelf.fiExporterCountryAddress = ko.observable(null);
    if (validator.includes('fiExporterCountryAddress')) {
        exporterVMSelf.fiExporterCountryAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    exporterVMSelf.errors = ko.validation.group({
        fiExporterCountryName: exporterVMSelf.fiExporterCountryName,
        fiExporterCountryAddress: exporterVMSelf.fiExporterCountryAddress
    })

    exporterVMSelf.selectedIndex = ko.observable(null);

    exporterVMSelf.lstCountry = ko.observable((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);

    exporterVMSelf.fiExporterCountryList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.06.tokhai.thong_tin_cong_ty_xk"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })

    exporterVMSelf.errorMsg = ko.observable('');
    exporterVMSelf.clearForm = function () {
        exporterVMSelf.errorMsg('')
        exporterVMSelf.fiExporterCountryName(null);
        exporterVMSelf.fiExporterCountryAddress(null);
    }

    exporterVMSelf.validate = function () {
        if (exporterVMSelf.errors().length > 0) {
            exporterVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    exporterVMSelf.getCountryName = function (countrycode) {
        var lstCountry = exporterVMSelf.lstCountry();
        var pos = lstCountry.find(function (e) {
            return e.countrycode == countrycode;
        })
        if (pos)
            return pos.countryname;
        else return ''
    }

    exporterVMSelf.openUpdateExporter = function (data, index, type) {
        ko.mapping.fromJS(data, {}, exporterVMSelf);
        exporterVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_editExporter1').modal('show');
        } else {
            $('#modal_editExporter2').modal('show');
        }
    }

    exporterVMSelf.updateExporter = function () {
        if (!exporterVMSelf.validate()) return;
        var item = {
            fiExporterCountryName: exporterVMSelf.fiExporterCountryName(),
            fiExporterCountryAddress: exporterVMSelf.fiExporterCountryAddress(),
        }
        var index = exporterVMSelf.selectedIndex();
        exporterVMSelf.fiExporterCountryList.splice(index, 1);
        exporterVMSelf.fiExporterCountryList.splice(index, 0, item);
        exporterVMSelf.clearForm();
        if ($('#modal_editExporter1').hasClass('in')) {
            $('#modal_editExporter1').modal('hide')
        }
        ;
        if ($('#modal_editExporter2').hasClass('in')) {
            $('#modal_editExporter2').modal('hide')
        }
        ;
    }

    exporterVMSelf.addExporter = function () {
        if (!exporterVMSelf.validate()) return;
        var item = {
            fiExporterCountryName: exporterVMSelf.fiExporterCountryName(),
            fiExporterCountryAddress: exporterVMSelf.fiExporterCountryAddress(),
        }
        exporterVMSelf.fiExporterCountryList.push(item);
        exporterVMSelf.clearForm();
        if ($('#modal_addExporter').hasClass('in')) {
            $('#modal_addExporter').modal('hide')
        }
        if ($('#modal_addAnimalExporter').hasClass('in')) {
            $('#modal_addAnimalExporter').modal('hide')
        }
    }

    exporterVMSelf.removeExporter = function (index) {
        exporterVMSelf.fiExporterCountryList.splice(index, 1);
    }

    exporterVMSelf.addExporterFromExcel = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading08').show();
            var formData = new FormData();
            formData.append("file", files[0]);

            $.ajax({
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/06/uploadExcel?type=exporter',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                },
                success: function (res) {
                    $('#loading08').hide();
                    if (res.success == true) {
                        var data = res.data;
                        var hasError = false;
                        data.forEach(function(exporter) {
                            if (hasError) return true;
                            validator.forEach(function (field) {
                                if (!exporter[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var exporterList = exporterVMSelf.fiExporterCountryList();
                            exporterList = exporterList.concat(data);
                            exporterVMSelf.fiExporterCountryList(exporterList);
                        }
                    } else {
                        // handle error here
                        app.Alert('File excel tải lên không đúng định dạng');
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                    $(e.target).val("");
                }
            });
        }
    }
}

function ProdMfrVM(data, validator) {
    if (!data) data = {};
    var prodMfrVMSelf = this;
    prodMfrVMSelf.fiIdProcessing = ko.observable(null);
    prodMfrVMSelf.fiIdHS = ko.observable(null);
    prodMfrVMSelf.fiProcessingName = ko.observable(null);
    prodMfrVMSelf.isRequireApprovalNumber = ko.observable(null);

    if (validator.includes('fiProcessingName')) {
        prodMfrVMSelf.fiProcessingName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    prodMfrVMSelf.fiProcessingAddress = ko.observable(null);
    if (validator.includes('fiProcessingAddress')) {
        prodMfrVMSelf.fiProcessingAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    prodMfrVMSelf.fiProcessingApprovalNumber = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return prodMfrVMSelf.isRequireApprovalNumber()
                }
            },
        })
    if (validator.includes('fiProcessingApprovalNumber')) {
        prodMfrVMSelf.fiProcessingApprovalNumber.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    prodMfrVMSelf.errors = ko.validation.group({
        fiProcessingName: prodMfrVMSelf.fiProcessingName,
        fiProcessingAddress: prodMfrVMSelf.fiProcessingAddress,
        fiProcessingApprovalNumber: prodMfrVMSelf.fiProcessingApprovalNumber
    })

    prodMfrVMSelf.selectedIndex = ko.observable(null);

    prodMfrVMSelf.fiProcessingList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.06.tokhai.thong_tin_co_so_nuoi_trong"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })

    prodMfrVMSelf.errorMsg = ko.observable('');
    prodMfrVMSelf.clearForm = function () {
        prodMfrVMSelf.errorMsg('')
        prodMfrVMSelf.fiProcessingName(null);
        prodMfrVMSelf.fiProcessingAddress(null);
        prodMfrVMSelf.fiProcessingApprovalNumber(null);
    }

    prodMfrVMSelf.validate = function () {
        if (prodMfrVMSelf.errors().length > 0) {
            prodMfrVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    prodMfrVMSelf.openUpdateProdMfr = function (data, index, type) {
        ko.mapping.fromJS(data, {}, prodMfrVMSelf);
        prodMfrVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_editProdMfr1').modal('show');
        } else {
            $('#modal_editProdMfr2').modal('show');
        }
    }

    prodMfrVMSelf.updateProdMfr = function () {
        if (!prodMfrVMSelf.validate()) return;
        var item = {
            fiIdProcessing: prodMfrVMSelf.fiIdProcessing(),
            fiIdHS: prodMfrVMSelf.fiIdHS(),
            fiProcessingName: prodMfrVMSelf.fiProcessingName(),
            fiProcessingAddress: prodMfrVMSelf.fiProcessingAddress(),
            fiProcessingApprovalNumber: prodMfrVMSelf.fiProcessingApprovalNumber()
        }
        var index = prodMfrVMSelf.selectedIndex();
        prodMfrVMSelf.fiProcessingList.splice(index, 1);
        prodMfrVMSelf.fiProcessingList.splice(index, 0, item);
        prodMfrVMSelf.clearForm();
        if ($('#modal_editProdMfr1').hasClass('in')) {
            $('#modal_editProdMfr1').modal('hide')
        }
        ;
        if ($('#modal_editProdMfr2').hasClass('in')) {
            $('#modal_editProdMfr2').modal('hide')
        }
        ;
    }

    prodMfrVMSelf.addProdMfr = function () {
        if (!prodMfrVMSelf.validate()) return;
        var item = {
            fiIdProcessing: prodMfrVMSelf.fiIdProcessing(),
            fiIdHS: prodMfrVMSelf.fiIdHS(),
            fiProcessingName: prodMfrVMSelf.fiProcessingName(),
            fiProcessingAddress: prodMfrVMSelf.fiProcessingAddress(),
            fiProcessingApprovalNumber: prodMfrVMSelf.fiProcessingApprovalNumber()
        }
        prodMfrVMSelf.fiProcessingList.push(item);
        prodMfrVMSelf.clearForm();
        if ($('#modal_addAnimalProdMfr').is(':visible')) {
            $('#modal_addAnimalProdMfr').modal('toggle')
        }
        if ($('#modal_addProdMfr').is(':visible')) {
            $('#modal_addProdMfr').modal('toggle')
        }
    }

    prodMfrVMSelf.removeProductMfr = function (index) {
        prodMfrVMSelf.fiProcessingList.splice(index, 1);
    }

    prodMfrVMSelf.addProcessingFromExcel = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading08').show();
            var formData = new FormData();
            formData.append("file", files[0]);

            $.ajax({
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/06/uploadExcel?type=processing',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                },
                success: function (res) {
                    $('#loading08').hide();
                    if (res.success == true) {
                        var data = res.data;
                        var hasError = false;
                        data.forEach(function(prodMfr) {
                            if (hasError) return true;
                            validator.forEach(function (field) {
                                if (!prodMfr[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var processingList = prodMfrVMSelf.fiProcessingList();
                            processingList = processingList.concat(data);
                            prodMfrVMSelf.fiProcessingList(processingList);
                        }
                    } else {
                        // handle error here
                        app.Alert('File excel tải lên không đúng định dạng');
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                    $(e.target).val("");
                }
            });
        }
    }
}

function IsoLocationVM(data, validator) {
    if (!data) data = {};
    var isoLocationVMSelf = this;
    isoLocationVMSelf.fiIdQuarLoc = ko.observable(null);
    isoLocationVMSelf.fiIdHS = ko.observable(null);
    isoLocationVMSelf.fiLocationQuarantineName = ko.observable(null);
    if (validator.includes('fiLocationQuarantineName')) {
        isoLocationVMSelf.fiLocationQuarantineName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    isoLocationVMSelf.fiLocationQuarantineAddress = ko.observable(null);
    if (validator.includes('fiLocationQuarantineAddress')) {
        isoLocationVMSelf.fiLocationQuarantineAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    isoLocationVMSelf.errors = ko.validation.group({
        fiLocationQuarantineName: isoLocationVMSelf.fiLocationQuarantineName,
        fiLocationQuarantineAddress: isoLocationVMSelf.fiLocationQuarantineAddress
    })

    isoLocationVMSelf.selectedIndex = ko.observable(null);

    isoLocationVMSelf.fiLocationQuarantineList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.06.tokhai.thong_tin_noi_cach_ly"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })

    isoLocationVMSelf.errorMsg = ko.observable('');
    isoLocationVMSelf.clearForm = function () {
        isoLocationVMSelf.errorMsg('')
        isoLocationVMSelf.fiLocationQuarantineName(null);
        isoLocationVMSelf.fiLocationQuarantineAddress(null);
    }

    isoLocationVMSelf.validate = function () {
        if (isoLocationVMSelf.errors().length > 0) {
            isoLocationVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    isoLocationVMSelf.openUpdateIsoLocation = function (data, index, type) {
        ko.mapping.fromJS(data, {}, isoLocationVMSelf);
        isoLocationVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_editIsoLocation1').modal('show');
        } else {
            $('#modal_editIsoLocation2').modal('show');
        }
    }

    isoLocationVMSelf.updateIsoLocation = function () {
        if (!isoLocationVMSelf.validate()) return;
        var item = {
            fiIdQuarLoc: isoLocationVMSelf.fiIdQuarLoc(),
            fiIdHS: isoLocationVMSelf.fiIdHS(),
            fiLocationQuarantineName: isoLocationVMSelf.fiLocationQuarantineName(),
            fiLocationQuarantineAddress: isoLocationVMSelf.fiLocationQuarantineAddress()
        }
        var index = isoLocationVMSelf.selectedIndex();
        isoLocationVMSelf.clearForm();
        isoLocationVMSelf.fiLocationQuarantineList.splice(index, 1);
        isoLocationVMSelf.fiLocationQuarantineList.splice(index, 0, item);
        if ($('#modal_editIsoLocation1').hasClass('in')) {
            $('#modal_editIsoLocation1').modal('hide')
        }
        ;
        if ($('#modal_editIsoLocation2').hasClass('in')) {
            $('#modal_editIsoLocation2').modal('hide')
        }
        ;
    }

    isoLocationVMSelf.addIsoLocation = function () {
        if (!isoLocationVMSelf.validate()) return;
        var item = {
            fiIdQuarLoc: isoLocationVMSelf.fiIdQuarLoc(),
            fiIdHS: isoLocationVMSelf.fiIdHS(),
            fiLocationQuarantineName: isoLocationVMSelf.fiLocationQuarantineName(),
            fiLocationQuarantineAddress: isoLocationVMSelf.fiLocationQuarantineAddress()
        }
        isoLocationVMSelf.fiLocationQuarantineList.push(item);
        isoLocationVMSelf.clearForm();
        if ($('#modal_addIsoLocation').hasClass('in')) {
            $('#modal_addIsoLocation').modal('toggle')
        }
        if ($('#modal_addAnimalIsoLocation').hasClass('in')) {
            $('#modal_addAnimalIsoLocation').modal('toggle')
        }

    }

    isoLocationVMSelf.removeIsoLocation = function (index) {
        isoLocationVMSelf.fiLocationQuarantineList.splice(index, 1);
    }

    isoLocationVMSelf.addLocationQuaratineFromExcel = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading08').show();
            var formData = new FormData();
            formData.append("file", files[0]);

            $.ajax({
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/06/uploadExcel?type=quaratine',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                },
                success: function (res) {
                    $('#loading08').hide();
                    if (res.success == true) {
                        var data = res.data;
                        var hasError = false;
                        data.forEach(function(quar) {
                            if (hasError) return true;
                            validator.forEach(function (field) {
                                if (!quar[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var quarantineList = isoLocationVMSelf.fiLocationQuarantineList();
                            quarantineList = quarantineList.concat(data);
                            isoLocationVMSelf.fiLocationQuarantineList(quarantineList);
                        }
                    } else {
                        // handle error here
                        app.Alert('File excel tải lên không đúng định dạng');
                    }
                },
                error: function (x, t, m) {
                    $('#loading08').hide();
                },
                complete: function (jqXHR, textStatus) {
                    $(e.target).val("");
                }
            });
        }
    }
}

function UploadFileVM(lstAtch, lstAtchType) {
    var ufVMSelf = this;
    ufVMSelf.lstAtch = ko.observableArray([]);
    ufVMSelf.selectedAttachVM = ko.observable(null);
    ufVMSelf.errorMsg = ko.observable(null);
    ufVMSelf.uploadedFiles = ko.observableArray([]);

    if (lstAtchType) {
        ufVMSelf.lstAtch(mapAttachmentVM(lstAtch, lstAtchType));
    }

    ufVMSelf.addFiles = function (atchVM) {
        ufVMSelf.selectedAttachVM($.extend(true, {}, atchVM));
        ufVMSelf.uploadedFiles([]);
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
                        formData.append('documentType', 'BNNPTNT0600009');
                        formData.append('fileCode', fiMaLoai);
                        formData.append('fileName', fiFileName);
                        formData.append('file', files[0]);

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
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
        var lstFilesCurrent = ufVMSelf.selectedAttachVM().lstFiles();
        var uploadedFiles = ufVMSelf.uploadedFiles();
        ufVMSelf.selectedAttachVM().lstFiles(lstFilesCurrent.concat(uploadedFiles));
        ufVMSelf.uploadedFiles([]);
        var lstAtchTemp = ufVMSelf.lstAtch();
        lstAtchTemp.map(function (value, index) {
            if (value.fiMaLoai() == ufVMSelf.selectedAttachVM().fiMaLoai()) {
                lstAtchTemp[index] = ufVMSelf.selectedAttachVM();
            }
        })
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
    }

    ufVMSelf.doDelete = function (data) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của file này?</b>',
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
            var lstFiles = JSON.parse(ko.toJSON(lstAttachment[i].lstFiles));
            result = result.concat(lstFiles);
        }
        return result;
    }

    ufVMSelf.validate = function () {
        var lstAttachment = ufVMSelf.lstAtch();
        var isMissingFile = false;
        for (var i = 0; i < lstAttachment.length; i++) {
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

var MAX_PAGE_SIZE = 10;
var DEFAULT_PAGE_NUM = 1;
