var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var TOKEN_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken';
var UPLOAD_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload';

function ProductVM(data, validator, tablename) {
    var productVMSelf = this;
    productVMSelf.tablename = tablename ? tablename : '';
    productVMSelf.productType = ko.observable(null);
    productVMSelf.fiProductName = ko.observable(null);

    if (validator.includes('fiProductName')) {
        productVMSelf.fiProductName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    productVMSelf.fiProductScienceName = ko.observable(null);
    if (validator.includes('fiProductScienceName')) {
        productVMSelf.fiProductScienceName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiProductCode = ko.observable(null);
    if (validator.includes('fiProductCode')) {
        productVMSelf.fiProductCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiQtyMale = ko.observable(null);
    if (validator.includes('fiQtyMale')) {
        productVMSelf.fiQtyMale.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiQtyFemale = ko.observable(null);
    if (validator.includes('fiQtyFemale')) {
        productVMSelf.fiQtyFemale.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiAge = ko.observable(null);
    if (validator.includes('fiAge')) {
        productVMSelf.fiAge.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiPackingType = ko.observable(null);
    if (validator.includes('fiPackingType')) {
        productVMSelf.fiPackingType.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiNumber = ko.observable(null);
    if (validator.includes('fiNumber')) {
        productVMSelf.fiNumber.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiUnitCode = ko.observable(null);
    if (validator.includes('fiUnitCode')) {
        productVMSelf.fiUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiNetWeight = ko.observable(null);
    if (validator.includes('fiNetWeight')) {
        productVMSelf.fiNetWeight.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiNWUnitCode = ko.observable(null);
    if (validator.includes('fiNWUnitCode')) {
        productVMSelf.fiNWUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiGrossWeight = ko.observable(null);
    if (validator.includes('fiGrossWeight')) {
        productVMSelf.fiGrossWeight.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    }
    productVMSelf.fiGWUnitCode = ko.observable(null);
    if (validator.includes('fiGWUnitCode')) {
        productVMSelf.fiGWUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiPurpose = ko.observable(null);
    if (validator.includes('fiPurpose')) {
        productVMSelf.fiPurpose.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiCountryOrigin = ko.observable(null);
    if (validator.includes('fiCountryOrigin')) {
        productVMSelf.fiCountryOrigin.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiPortName = ko.observable(null);
    if (validator.includes('fiPortName')) {
        productVMSelf.fiPortName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    productVMSelf.fiCirculateNo = ko.observable(null);
    if (validator.includes('fiCirculateNo')) {
        productVMSelf.fiCirculateNo.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }

    productVMSelf.lstCountry = ko.observable((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);
    productVMSelf.lstPort = ko.observable((data && data.hasOwnProperty('lstPort')) ? data.lstPort : []);
    productVMSelf.lstUOMs = ko.observable((data && data.hasOwnProperty('lstUOMs')) ? data.lstUOMs : []);

    productVMSelf.lstProduct = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: productVMSelf.tablename + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            },
            messagesOnModified: false
        })

    productVMSelf.errorMsg = ko.observable('');

    productVMSelf.itemEdit = null;
    productVMSelf.isEdit = ko.observable(false);

    productVMSelf.clearForm = function () {
        productVMSelf.errorMsg('');
        productVMSelf.fiProductName(null);
        productVMSelf.fiProductScienceName(null);
        productVMSelf.fiProductCode(null);
        productVMSelf.fiQtyMale(null);
        productVMSelf.fiQtyFemale(null);
        productVMSelf.fiAge(null);
        productVMSelf.fiPackingType(null);
        productVMSelf.fiNumber(null);
        if (productVMSelf.productType() != 2 && productVMSelf.productType() != '2'
            && productVMSelf.productType() != 3 && productVMSelf.productType() != '3'
            && productVMSelf.productType() != 5 && productVMSelf.productType() != '5') {
            productVMSelf.fiUnitCode(null);
            productVMSelf.fiNWUnitCode(null);
            productVMSelf.fiGWUnitCode(null);
        }
        productVMSelf.fiNetWeight(null);
        productVMSelf.fiGrossWeight(null);
        productVMSelf.fiPurpose(null);
        productVMSelf.fiCountryOrigin(null);
        productVMSelf.fiPortName(null);
        productVMSelf.fiCirculateNo(null);
    };

    productVMSelf.errors = ko.validation.group({
        fiProductName: productVMSelf.fiProductName,
        fiProductScienceName: productVMSelf.fiProductScienceName,
        fiProductCode: productVMSelf.fiProductCode,
        fiQtyMale: productVMSelf.fiQtyMale,
        fiQtyFemale: productVMSelf.fiQtyFemale,
        fiAge: productVMSelf.fiAge,
        fiPackingType: productVMSelf.fiPackingType,
        fiNumber: productVMSelf.fiNumber,
        fiUnitCode: productVMSelf.fiUnitCode,
        fiNetWeight: productVMSelf.fiNetWeight,
        fiNWUnitCode: productVMSelf.fiNWUnitCode,
        fiGrossWeight: productVMSelf.fiGrossWeight,
        fiGWUnitCode: productVMSelf.fiGWUnitCode,
        fiPurpose: productVMSelf.fiPurpose,
        fiCountryOrigin: productVMSelf.fiCountryOrigin,
        fiPortName: productVMSelf.fiPortName,
        fiCirculateNo: productVMSelf.fiCirculateNo
    })

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

    productVMSelf.getUnitName = function (unitcode) {
        var lstUOMs = productVMSelf.lstUOMs();
        var pos = lstUOMs.find(function (e) {
            return e.unitcode == unitcode;
        })
        if (pos)
            return pos.unitname;
        else return '';
    }

    productVMSelf.addProduct = function () {
        if (!productVMSelf.validate()) return;
        var item = {
            fiProductName: productVMSelf.fiProductName(),
            fiProductScienceName: productVMSelf.fiProductScienceName(),
            fiProductCode: productVMSelf.fiProductCode(),
            fiQtyMale: productVMSelf.fiQtyMale(),
            fiQtyFemale: productVMSelf.fiQtyFemale(),
            fiAge: productVMSelf.fiAge(),
            fiPackingType: productVMSelf.fiPackingType(),
            fiNumber: productVMSelf.fiNumber(),
            fiUnitCode: productVMSelf.fiUnitCode(),
            fiNetWeight: productVMSelf.fiNetWeight(),
            fiNWUnitCode: productVMSelf.fiNWUnitCode(),
            fiGrossWeight: productVMSelf.fiGrossWeight(),
            fiGWUnitCode: productVMSelf.fiGWUnitCode(),
            fiPurpose: productVMSelf.fiPurpose(),
            fiCountryOrigin: productVMSelf.fiCountryOrigin(),
            fiPortName: productVMSelf.fiPortName(),
            fiCirculateNo: productVMSelf.fiCirculateNo()
        }

        if (productVMSelf.itemEdit != null) {
            productVMSelf.lstProduct.replace(productVMSelf.itemEdit, item);
        } else {
            productVMSelf.lstProduct.push(item);
        }

        productVMSelf.itemEdit = null;
        productVMSelf.isEdit(false);

        productVMSelf.clearForm();
        if ($('#modal_addAnimal').hasClass('in')) {
            $('#modal_addAnimal').modal('hide')
        }
        if ($('#modal_addAnimalProduct').hasClass('in')) {
            $('#modal_addAnimalProduct').modal('hide')
        }
        if ($('#modal_addBoneMealProduct').hasClass('in')) {
            $('#modal_addBoneMealProduct').modal('hide')
        }
        if ($('#modal_addQltProduct').hasClass('in')) {
            $('#modal_addQltProduct').modal('hide')
        }
        if ($('#modal_addQltAnimalProduct').hasClass('in')) {
            $('#modal_addQltAnimalProduct').modal('hide')
        }
    }

    productVMSelf.removeProduct = function (index) {
        productVMSelf.lstProduct.splice(index, 1);
    };

    productVMSelf.closeForm = function () {
        productVMSelf.clearForm();
        productVMSelf.itemEdit = null;
        productVMSelf.isEdit(false);
    }

    productVMSelf.updateProduct = function (index) {

        var data = productVMSelf.lstProduct()[index];

        productVMSelf.itemEdit = data;
        productVMSelf.isEdit(true);

        productVMSelf.fiProductName(data.fiProductName);
        productVMSelf.fiProductScienceName(data.fiProductScienceName);
        productVMSelf.fiProductCode(data.fiProductCode);
        productVMSelf.fiQtyMale(data.fiQtyMale);
        productVMSelf.fiQtyFemale(data.fiQtyFemale);
        productVMSelf.fiAge(data.fiAge);
        productVMSelf.fiPackingType(data.fiPackingType);
        productVMSelf.fiNumber(data.fiNumber);
        productVMSelf.fiUnitCode(data.fiUnitCode);
        productVMSelf.fiNetWeight(data.fiNetWeight);
        productVMSelf.fiNWUnitCode(data.fiNWUnitCode);
        productVMSelf.fiGrossWeight(data.fiGrossWeight);
        productVMSelf.fiGWUnitCode(data.fiGWUnitCode);
        productVMSelf.fiPurpose(data.fiPurpose);
        productVMSelf.fiCountryOrigin(data.fiCountryOrigin);
        productVMSelf.fiPortName(data.fiPortName);
        productVMSelf.fiCirculateNo(data.fiCirculateNo);
    }

    productVMSelf.setUnitCode = function (unitname) {
        var unit = productVMSelf.lstUOMs().filter(function (val) {
            return val.unitname == unitname;
        })
        return unit.length > 0 ? unit[0].unitcode : null;
    }

    productVMSelf.setCountryCode = function (countryname) {
        var unit = productVMSelf.lstCountry().filter(function (val) {
            return val.countryname == countryname;
        })
        return unit.length > 0 ? unit[0].countrycode : null;
    }

    productVMSelf.addProductFromExcel = function (e, type) {
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
                url: app.appContext + '/mard/08/uploadExcel?type=' + type,
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
                            var temp = Object.assign({}, product)
                            product.fiUnitCode = productVMSelf.setUnitCode(product.fiUnitCode);
                            if (!product.fiUnitCode && validator.includes('fiUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị: ' + temp.fiUnitCode);
                                hasError = true;
                                return true;
                            }
                            product.fiCountryOrigin = productVMSelf.setCountryCode(product.fiCountryOrigin);
                            if (!product.fiCountryOrigin && validator.includes('fiCountryOrigin')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai tên nước: ' + temp.fiCountryOrigin);
                                hasError = true;
                                return true;
                            }
                            product.fiNWUnitCode = productVMSelf.setUnitCode(product.fiNWUnitCode);
                            if (!product.fiNWUnitCode && validator.includes('fiNWUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị: ' + temp.fiNWUnitCode);
                                hasError = true;
                                return true;
                            }
                            product.fiGWUnitCode = productVMSelf.setUnitCode(product.fiGWUnitCode);
                            if (!product.fiGWUnitCode && validator.includes('fiGWUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị: ' + temp.fiGWUnitCode);
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
                            var lstProduct = productVMSelf.lstProduct();
                            lstProduct = lstProduct.concat(data);
                            productVMSelf.lstProduct(lstProduct);
                        }
                    } else {
                        // handle error here
                        app.Alert(res.message);
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

function ProdMfrVM(data, validator, tablename) {
    if (!data) data = {};
    var prodMfrVMSelf = this;
    prodMfrVMSelf.tablename = tablename ? tablename : '';
    prodMfrVMSelf.fiIdMfr = ko.observable(null);
    prodMfrVMSelf.fiIdHS = ko.observable(null);
    prodMfrVMSelf.fiMfrName = ko.observable(null);
    if (validator.includes('fiMfrName')) {
        prodMfrVMSelf.fiMfrName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    prodMfrVMSelf.fiMfrAddress = ko.observable(null);
    if (validator.includes('fiMfrAddress')) {
        prodMfrVMSelf.fiMfrAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    prodMfrVMSelf.fiMfrCountryrigin = ko.observable(null);
    if (validator.includes('fiMfrCountryrigin')) {
        prodMfrVMSelf.fiMfrCountryrigin.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }

    prodMfrVMSelf.isEdit = ko.observable(false);

    prodMfrVMSelf.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);

    prodMfrVMSelf.lstProdMfr = ko.observableArray([])

    prodMfrVMSelf.lstProdMfr = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: prodMfrVMSelf.tablename + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        });

    prodMfrVMSelf.errorMsg = ko.observable('');

    prodMfrVMSelf.itemEdit = null;

    prodMfrVMSelf.getCountryName = function (countrycode) {
        var lstCountry = prodMfrVMSelf.lstCountry();
        var pos = lstCountry.find(function (e) {
            return e.countrycode == countrycode;
        })
        if (pos)
            return pos.countryname;
        else return ''
    }

    prodMfrVMSelf.setCountryCode = function (countryname) {
        var unit = prodMfrVMSelf.lstCountry().filter(function (val) {
            return val.countryname == countryname;
        })
        return unit.length > 0 ? unit[0].countrycode : null;
    }

    prodMfrVMSelf.clearForm = function () {
        prodMfrVMSelf.errorMsg('')
        prodMfrVMSelf.fiIdMfr(null);
        prodMfrVMSelf.fiIdHS(null);
        prodMfrVMSelf.fiMfrName(null);
        prodMfrVMSelf.fiMfrAddress(null);
        prodMfrVMSelf.fiMfrCountryrigin(null);
    }

    prodMfrVMSelf.closeForm = function () {
        prodMfrVMSelf.clearForm();
        prodMfrVMSelf.itemEdit = null;
        prodMfrVMSelf.isEdit(false);
    }

    prodMfrVMSelf.errors = ko.validation.group({
        fiMfrName: prodMfrVMSelf.fiMfrName,
        fiMfrAddress: prodMfrVMSelf.fiMfrAddress,
        fiMfrCountryrigin: prodMfrVMSelf.fiMfrCountryrigin
    })

    prodMfrVMSelf.validate = function () {
        if (prodMfrVMSelf.errors().length > 0) {
            prodMfrVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    prodMfrVMSelf.update = function (index) {

        var data = prodMfrVMSelf.lstProdMfr()[index];

        prodMfrVMSelf.itemEdit = data;
        prodMfrVMSelf.isEdit(true);

        prodMfrVMSelf.fiIdMfr(data.fiIdMfr);
        prodMfrVMSelf.fiIdHS(data.fiIdHS);
        prodMfrVMSelf.fiMfrName(data.fiMfrName);
        prodMfrVMSelf.fiMfrAddress(data.fiMfrAddress);
        prodMfrVMSelf.fiMfrCountryrigin(data.fiMfrCountryrigin);
    }

    prodMfrVMSelf.addProdMfr = function () {
        if (!prodMfrVMSelf.validate()) return;
        var item = {
            fiIdMfr: prodMfrVMSelf.fiIdMfr(),
            fiIdHS: prodMfrVMSelf.fiIdHS(),
            fiMfrName: prodMfrVMSelf.fiMfrName(),
            fiMfrAddress: prodMfrVMSelf.fiMfrAddress(),
            fiMfrCountryrigin: prodMfrVMSelf.fiMfrCountryrigin()
        }

        if (prodMfrVMSelf.itemEdit != null) {
            prodMfrVMSelf.lstProdMfr.replace(prodMfrVMSelf.itemEdit, item);
        } else {
            prodMfrVMSelf.lstProdMfr.push(item);
        }

        prodMfrVMSelf.itemEdit = null;
        prodMfrVMSelf.isEdit(false);

        prodMfrVMSelf.clearForm();
        if ($('#modal_addAnimalProductMfr').hasClass('in')) {
            $('#modal_addAnimalProductMfr').modal('hide')
        }
        if ($('#modal_addBoneMealProdMfr').hasClass('in')) {
            $('#modal_addBoneMealProdMfr').modal('hide')
        }
        if ($('#modal_addQltProdMfr').hasClass('in')) {
            $('#modal_addQltProdMfr').modal('hide')
        }
    }

    prodMfrVMSelf.removeProductMfr = function (index) {
        prodMfrVMSelf.lstProdMfr.splice(index, 1);
    }

    prodMfrVMSelf.addProdMfrFromExcel = function (e) {
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
                url: app.appContext + '/mard/08/uploadExcel?type=prodmfr',
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
                        data.forEach(function (prodmfr) {
                            if (hasError) return true;
                            var temp = Object.assign({}, prodmfr);
                            prodmfr.fiMfrCountryrigin = prodMfrVMSelf.setCountryCode(prodmfr.fiMfrCountryrigin);
                            if (!prodmfr.fiMfrCountryrigin && validator.includes('fiMfrCountryrigin')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai tên nước ' + temp.fiMfrCountryrigin);
                                hasError = true;
                                return true;
                            }
                            validator.forEach(function (field) {
                                if (!prodmfr[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var lstProdMfr = prodMfrVMSelf.lstProdMfr();
                            lstProdMfr = lstProdMfr.concat(data);
                            prodMfrVMSelf.lstProdMfr(lstProdMfr);
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

function ExporterVM(data, validator, tablename) {
    if (!data) data = {};
    var exporterVMSelf = this;
    exporterVMSelf.tablename = tablename ? tablename : '';
    exporterVMSelf.fiIdExporter = ko.observable(null);
    exporterVMSelf.fiIdHS = ko.observable(null);
    exporterVMSelf.fiExporterName = ko.observable(null);
    if (validator.includes('fiExporterName')) {
        exporterVMSelf.fiExporterName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    exporterVMSelf.fiExporterAddress = ko.observable(null);
    if (validator.includes('fiExporterAddress')) {
        exporterVMSelf.fiExporterAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    exporterVMSelf.fiCountryOrigin = ko.observable(null);
    if (validator.includes('fiCountryOrigin')) {
        exporterVMSelf.fiCountryOrigin.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    exporterVMSelf.fiExporterTel = ko.observable(null);
    if (validator.includes('fiExporterTel')) {
        exporterVMSelf.fiExporterTel.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    exporterVMSelf.fiExporterFax = ko.observable(null);
    if (validator.includes('fiExporterFax')) {
        exporterVMSelf.fiExporterFax.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    exporterVMSelf.itemEdit = null;
    exporterVMSelf.isEdit = ko.observable(false);
    exporterVMSelf.lstCountry = ko.observable((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);

    exporterVMSelf.lstExporter = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: exporterVMSelf.tablename + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        });

    exporterVMSelf.errorMsg = ko.observable('');
    exporterVMSelf.clearForm = function () {
        exporterVMSelf.errorMsg('')
        exporterVMSelf.fiIdExporter(null);
        exporterVMSelf.fiIdHS(null);
        exporterVMSelf.fiExporterName(null);
        exporterVMSelf.fiExporterAddress(null);
        exporterVMSelf.fiCountryOrigin(null);
        exporterVMSelf.fiExporterTel(null);
        exporterVMSelf.fiExporterFax(null);
    };

    exporterVMSelf.errors = ko.validation.group({
        fiExporterName: exporterVMSelf.fiExporterName,
        fiExporterAddress: exporterVMSelf.fiExporterAddress,
        fiCountryOrigin: exporterVMSelf.fiCountryOrigin,
        fiExporterTel: exporterVMSelf.fiExporterTel,
        fiExporterFax: exporterVMSelf.fiExporterFax
    })

    exporterVMSelf.update = function (index) {

        var data = exporterVMSelf.lstExporter()[index];

        exporterVMSelf.itemEdit = data;
        exporterVMSelf.isEdit(true);

        exporterVMSelf.fiIdExporter(data.fiIdExporter);
        exporterVMSelf.fiIdHS(data.fiIdHS);
        exporterVMSelf.fiExporterName(data.fiExporterName);
        exporterVMSelf.fiExporterAddress(data.fiExporterAddress);
        exporterVMSelf.fiCountryOrigin(data.fiCountryOrigin);
        exporterVMSelf.fiExporterTel(data.fiExporterTel);
        exporterVMSelf.fiExporterFax(data.fiExporterFax);
    }


    exporterVMSelf.validate = function () {
        if (exporterVMSelf.errors().length > 0) {
            exporterVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    exporterVMSelf.closeForm = function () {
        exporterVMSelf.clearForm();
        exporterVMSelf.itemEdit = null;
        exporterVMSelf.isEdit(false);
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

    exporterVMSelf.setCountryCode = function (countryname) {
        var unit = exporterVMSelf.lstCountry().filter(function (val) {
            return val.countryname == countryname;
        })
        return unit.length > 0 ? unit[0].countrycode : null;
    }

    exporterVMSelf.addExporter = function () {
        if (!exporterVMSelf.validate()) return;
        var item = {
            fiIdExporter: exporterVMSelf.fiIdExporter(),
            fiIdHS: exporterVMSelf.fiIdHS(),
            fiExporterName: exporterVMSelf.fiExporterName(),
            fiExporterAddress: exporterVMSelf.fiExporterAddress(),
            fiCountryOrigin: exporterVMSelf.fiCountryOrigin(),
            fiExporterTel: exporterVMSelf.fiExporterTel(),
            fiExporterFax: exporterVMSelf.fiExporterFax()
        }

        if (exporterVMSelf.itemEdit != null) {
            exporterVMSelf.lstExporter.replace(exporterVMSelf.itemEdit, item);
        } else {
            exporterVMSelf.lstExporter.push(item);
        }

        exporterVMSelf.clearForm();
        exporterVMSelf.isEdit(false);
        exporterVMSelf.itemEdit = null;

        if ($('#modal_addAnimalExporter').hasClass('in')) {
            $('#modal_addAnimalExporter').modal('hide')
        }
        if ($('#modal_addAnimalProductExporter').hasClass('in')) {
            $('#modal_addAnimalProductExporter').modal('hide')
        }
        if ($('#modal_addBoneMealExporter').hasClass('in')) {
            $('#modal_addBoneMealExporter').modal('hide')
        }
        if ($('#modal_addQltExporter').hasClass('in')) {
            $('#modal_addQltExporter').modal('hide')
        }
    }

    exporterVMSelf.removeExporter = function (index) {
        exporterVMSelf.lstExporter.splice(index, 1);
    }

    exporterVMSelf.addExportFromExcel = function (e, type) {
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
                url: app.appContext + '/mard/08/uploadExcel?type=' + type,
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
                        data.forEach(function (exporter) {
                            if (hasError) return true;
                            var temp = Object.assign({}, exporter);
                            exporter.fiCountryOrigin = exporterVMSelf.setCountryCode(exporter.fiCountryOrigin);
                            if (!exporter.fiCountryOrigin && validator.includes('fiCountryOrigin')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai tên nước ' + temp.fiCountryOrigin);
                                hasError = true;
                                return true;
                            }
                            validator.forEach(function (field) {
                                if (!exporter[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var lstExporter = exporterVMSelf.lstExporter();
                            lstExporter = lstExporter.concat(data);
                            exporterVMSelf.lstExporter(lstExporter);
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

function IsoLocationVM(data, validator, tablename) {
    if (!data) data = {};
    var isoLocationVMSelf = this;
    isoLocationVMSelf.tablename = tablename ? tablename : '';
    isoLocationVMSelf.fiIdQuarLoc = ko.observable(null);
    isoLocationVMSelf.fiIdHS = ko.observable(null);
    isoLocationVMSelf.fiIsoLocName = ko.observable(null);
    if (validator.includes('fiIsoLocName')) {
        isoLocationVMSelf.fiIsoLocName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    isoLocationVMSelf.fiIsoLocAddress = ko.observable(null);
    if (validator.includes('fiIsoLocAddress')) {
        isoLocationVMSelf.fiIsoLocAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }

    isoLocationVMSelf.itemEdit = null;
    isoLocationVMSelf.isEdit = ko.observable(false);

    isoLocationVMSelf.lstIsolatedLocation = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: isoLocationVMSelf.tablename + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        });

    isoLocationVMSelf.errorMsg = ko.observable('');
    isoLocationVMSelf.clearForm = function () {
        isoLocationVMSelf.errorMsg('');
        isoLocationVMSelf.fiIdQuarLoc(null);
        isoLocationVMSelf.fiIdHS(null);
        isoLocationVMSelf.fiIsoLocName(null);
        isoLocationVMSelf.fiIsoLocAddress(null);
    }

    isoLocationVMSelf.errors = ko.validation.group({
        fiIsoLocName: isoLocationVMSelf.fiIsoLocName,
        fiIsoLocAddress: isoLocationVMSelf.fiIsoLocAddress
    })

    isoLocationVMSelf.closeForm = function () {
        isoLocationVMSelf.clearForm();
        isoLocationVMSelf.itemEdit = null;
        isoLocationVMSelf.isEdit(false);
    }

    isoLocationVMSelf.update = function (index) {

        var data = isoLocationVMSelf.lstIsolatedLocation()[index];

        isoLocationVMSelf.itemEdit = data;
        isoLocationVMSelf.isEdit(true);

        isoLocationVMSelf.fiIdQuarLoc(data.fiIdQuarLoc);
        isoLocationVMSelf.fiIdHS(data.fiIdHS);
        isoLocationVMSelf.fiIsoLocName(data.fiIsoLocName);
        isoLocationVMSelf.fiIsoLocAddress(data.fiIsoLocAddress);
    }

    isoLocationVMSelf.validate = function () {
        if (isoLocationVMSelf.errors().length > 0) {
            isoLocationVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    isoLocationVMSelf.addIsoLocation = function () {
        if (!isoLocationVMSelf.validate()) return;
        var item = {
            fiIdQuarLoc: isoLocationVMSelf.fiIdQuarLoc(),
            fiIdHS: isoLocationVMSelf.fiIdHS(),
            fiIsoLocName: isoLocationVMSelf.fiIsoLocName(),
            fiIsoLocAddress: isoLocationVMSelf.fiIsoLocAddress()
        }

        if (isoLocationVMSelf.itemEdit != null) {
            isoLocationVMSelf.lstIsolatedLocation.replace(isoLocationVMSelf.itemEdit, item);
        } else {
            isoLocationVMSelf.lstIsolatedLocation.push(item);
        }

        isoLocationVMSelf.itemEdit = null;
        isoLocationVMSelf.isEdit(false);

        isoLocationVMSelf.clearForm();
        if ($('#modal_addIsoLocation').hasClass('in')) {
            $('#modal_addIsoLocation').modal('hide')
        }
    }

    isoLocationVMSelf.removeIsoLocation = function (index) {
        isoLocationVMSelf.lstIsolatedLocation.splice(index, 1);
    }

    isoLocationVMSelf.addLocationQuaratineFromExcel = function (e) {
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
                url: app.appContext + '/mard/08/uploadExcel?type=quaratine',
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
                        data.forEach(function (isoLoc) {
                            if (hasError) return true;
                            validator.forEach(function (field) {
                                if (!isoLoc[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var lstIsolatedLocation = isoLocationVMSelf.lstIsolatedLocation();
                            lstIsolatedLocation = lstIsolatedLocation.concat(data);
                            isoLocationVMSelf.lstIsolatedLocation(lstIsolatedLocation);
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

function MfgFactoryVM(data, validator, tablename) {
    if (!data) data = {};
    var mfgFactoryVMSelf = this;
    mfgFactoryVMSelf.tablename = tablename ? tablename : '';
    mfgFactoryVMSelf.fiIdFactory = ko.observable(null);
    mfgFactoryVMSelf.fiIdHS = ko.observable(null);
    mfgFactoryVMSelf.fiFactoryName = ko.observable(null);
    if (validator.includes('fiFactoryName')) {
        mfgFactoryVMSelf.fiFactoryName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    mfgFactoryVMSelf.fiFactoryAddress = ko.observable(null);
    if (validator.includes('fiFactoryAddress')) {
        mfgFactoryVMSelf.fiFactoryAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    mfgFactoryVMSelf.isEdit = ko.observable(false);

    mfgFactoryVMSelf.lstMfgFactory = ko.observableArray([]);

    mfgFactoryVMSelf.itemEdit = null;

    mfgFactoryVMSelf.errorMsg = ko.observable('');
    mfgFactoryVMSelf.clearForm = function () {
        mfgFactoryVMSelf.errorMsg('')
        mfgFactoryVMSelf.fiIdFactory(null);
        mfgFactoryVMSelf.fiIdHS(null);
        mfgFactoryVMSelf.fiFactoryName(null);
        mfgFactoryVMSelf.fiFactoryAddress(null);
    }

    mfgFactoryVMSelf.errors = ko.validation.group({
        fiFactoryName: mfgFactoryVMSelf.fiFactoryName,
        fiFactoryAddress: mfgFactoryVMSelf.fiFactoryAddress
    })

    mfgFactoryVMSelf.validate = function () {
        if (mfgFactoryVMSelf.errors().length > 0) {
            mfgFactoryVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    mfgFactoryVMSelf.closeForm = function () {
        mfgFactoryVMSelf.clearForm();
        mfgFactoryVMSelf.itemEdit = null;
        mfgFactoryVMSelf.isEdit(false);
    }

    mfgFactoryVMSelf.update = function (index) {

        var data = mfgFactoryVMSelf.lstMfgFactory()[index];

        mfgFactoryVMSelf.itemEdit = data;
        mfgFactoryVMSelf.isEdit(true);

        mfgFactoryVMSelf.fiIdFactory(data.fiIdFactory);
        mfgFactoryVMSelf.fiIdHS(data.fiIdHS);
        mfgFactoryVMSelf.fiFactoryName(data.fiFactoryName);
        mfgFactoryVMSelf.fiFactoryAddress(data.fiFactoryAddress);
    }

    mfgFactoryVMSelf.addMfgFactory = function () {
        if (!mfgFactoryVMSelf.validate()) return;
        var item = {
            fiIdFactory: mfgFactoryVMSelf.fiIdFactory(),
            fiIdHS: mfgFactoryVMSelf.fiIdHS(),
            fiFactoryName: mfgFactoryVMSelf.fiFactoryName(),
            fiFactoryAddress: mfgFactoryVMSelf.fiFactoryAddress()
        }

        if (mfgFactoryVMSelf.itemEdit != null) {
            mfgFactoryVMSelf.lstMfgFactory.replace(mfgFactoryVMSelf.itemEdit, item);
        } else {
            mfgFactoryVMSelf.lstMfgFactory.push(item);
        }

        mfgFactoryVMSelf.itemEdit = null;
        mfgFactoryVMSelf.isEdit(false);

        mfgFactoryVMSelf.clearForm();
        if ($('#modal_addBoneMealMfgFactory').hasClass('in')) {
            $('#modal_addBoneMealMfgFactory').modal('hide')
        }
    }

    mfgFactoryVMSelf.removeMfgFactory = function (index) {
        mfgFactoryVMSelf.lstMfgFactory.splice(index, 1);
    }

    mfgFactoryVMSelf.addMfgFactoryFromExcel = function (e) {
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
                url: app.appContext + '/mard/08/uploadExcel?type=mfgfactory',
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
                        data.forEach(function (mfgFac) {
                            if (hasError) return true;
                            validator.forEach(function (field) {
                                if (!mfgFac[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var lstMfgFactory = mfgFactoryVMSelf.lstMfgFactory();
                            lstMfgFactory = lstMfgFactory.concat(data);
                            mfgFactoryVMSelf.lstMfgFactory(lstMfgFactory);
                        }
                    } else {
                        // handle error here
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

var DocumentsVM = function (currentDocuments, documentTypes) {
    var self = this;

    self.lstDocuments = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.08.table.thong_tin_hd_pdg"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        });

    if (currentDocuments.length > 0) {
        var lstDocuments = []
        currentDocuments.forEach(function (item, index) {
            lstDocuments.push(new Document(item, documentTypes));
        })
        self.lstDocuments(lstDocuments);
    }

    self.onRemove = function (index) {
        self.lstDocuments.splice(index, 1)
    };

    self.onAdd = function () {
        self.lstDocuments.push(new Document(null, documentTypes))
    };

    self.getData = function () {
        var rs = [];
        self.lstDocuments().forEach(function (item) {
            rs.push(item.toJSON());
        });
        return rs
    }
};

var Document = function (data, documentTypes) {
    var document = this;

    document.documentTypes = ko.observableArray(documentTypes);
    document.fiTypeDoc = ko.observable((data && data.hasOwnProperty('fiTypeDoc')) ? data.fiTypeDoc : null)
        .extend({
            required: {message: NSWLang["common_msg_formvaild_required"], params: true}
        });
    document.fiNumber = ko.observable((data && data.hasOwnProperty('fiNumber')) ? data.fiNumber : null)
        .extend({
            required: {message: NSWLang["common_msg_formvaild_required"], params: true},
            minLength: 1,
            maxLength: 255
        });
    document.fiDate = ko.observable((data && data.hasOwnProperty('fiDate')) ? new Date(data.fiDate) : null)

    document.toJSON = function () {
        return {
            fiTypeDoc: document.fiTypeDoc(),
            fiNumber: document.fiNumber(),
            fiDate: document.fiDate()
        }
    };

    return document;
};

function UploadFileVM(lstAtch, lstAtchType) {
    var ufVMSelf = this;
    ufVMSelf.lstAtch = ko.observableArray([]);
    ufVMSelf.selectedAttachVM = ko.observable(null);
    ufVMSelf.errorMsg = ko.observable(null);
    ufVMSelf.uploadedFiles = ko.observableArray([]);

    if (lstAtch) {
        ufVMSelf.lstAtch(mapAttachmentVM(lstAtch, lstAtchType));
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
                        formData.append('documentType', 'BNNPTNT0600011');
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
                                        fiDuongDan: res.data.UrlFile,
                                        fiMaLoai: fiMaLoai,
                                        fiTenLoai: fiTenLoai,
                                        fiTenTep: files[0].name
                                    });
                                    $('#btnfile3').val('');
                                    $("#btnfile20a").val('');
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
        if ($('#modal_addFile20A').hasClass('in')) {
            $('#modal_addFile20A').modal('hide');
        }
    }

    ufVMSelf.saveUpload = function () {
        ufVMSelf.selectedAttachVM().lstFiles(ufVMSelf.uploadedFiles());
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
        if ($('#modal_addFile20A').hasClass('in')) {
            $('#modal_addFile20A').modal('hide');
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
    fileVMSelf.fiMaLoai = ko.observable((options && options.hasOwnProperty('fiMaLoai')) ? options.fiMaLoai : null);
    fileVMSelf.fiTenLoai = ko.observable((options && options.hasOwnProperty('fiTenLoai')) ? options.fiTenLoai : null);
    fileVMSelf.fiTenTep = ko.observable((options && options.hasOwnProperty('fiTenTep')) ? options.fiTenTep : null);
    fileVMSelf.fiNoiDung = ko.observable((options && options.hasOwnProperty('fiNoiDung')) ? options.fiNoiDung : null);
    fileVMSelf.fiHoatdong = ko.observable((options) && options.hasOwnProperty('fiHoatdong') ? options.fiHoatdong : 1);
    fileVMSelf.fiDuongDan = ko.observable((options && options.hasOwnProperty('fiDuongDan')) ? options.fiDuongDan : null);
    fileVMSelf.fiGuid = ko.observable((options && options.hasOwnProperty('fiGuid')) ? options.fiGuid : null);
    fileVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);

    fileVMSelf.downloadFile = function (data) {
        var link = document.createElement('a');
        link.href = data.fiDuongDan();
        link.target = '_blank';
        document.body.appendChild(link);
        link.click();
        link.remove();
    }
}

function getFileNameByUrl(url) {
    url = decodeURI(url);
    var lstString = url.split("\\");
    return lstString[lstString.length - 1];
}

function mapAttachmentVM(lstAtch, lstAtchType) {
    var result = [];

    for (var i = 0; i < lstAtchType.length; i++) {
        var attachmentVM = new AttachmentVM({
            fiTenLoai: lstAtchType[i].name,
            isUploaded: false,
            isRequired: lstAtchType[i].required,
            fiMaLoai: lstAtchType[i].id
        });

        for (var j = 0; j < lstAtch.length; j++) {
            if (lstAtchType[i].id === lstAtch[j].fiMaLoai) {
                var file = new FileVM(lstAtch[j]);
                attachmentVM.lstFiles.push(file);
                attachmentVM.isUploaded(true);
            }
        }

        result.push(attachmentVM)

    }

    return result;
}
