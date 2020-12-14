var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var productValidator = ['fiProductNameVni', 'fiProductName', 'fiPackageTypeVni', 'fiPackageType',
    'fiNumber', 'fiUnitCode', 'fiNetWeight', 'fiNetWeightUnitCode', 'fiFromDateProduct', 'fiToDateProduct', 'fiLotIdentificationNo', 'fiPurposeVni', 'fiPurpose'];
function AddAnimalProductVM (data, options, onAddAnimalProduct) {
    var self = this;
    self.fiHSCode = ko.observable((data && data.hasOwnProperty('fiHSCode')) ? data.fiHSCode : null);
    self.fiProductNameVni = ko.observable((data && data.hasOwnProperty('fiProductNameVni')) ? data.fiProductNameVni : null);
    if (productValidator.includes('fiProductNameVni')) {
        self.fiProductNameVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiProductName = ko.observable((data && data.hasOwnProperty('fiProductName')) ? data.fiProductName : null);
    if (productValidator.includes('fiProductName')) {
        self.fiProductName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPackageTypeVni = ko.observable((data && data.hasOwnProperty('fiPackageTypeVni')) ? data.fiPackageTypeVni : null);
    if (productValidator.includes('fiPackageTypeVni')) {
        self.fiPackageTypeVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPackageType = ko.observable((data && data.hasOwnProperty('fiPackageType')) ? data.fiPackageType : null);
    if (productValidator.includes('fiPackageType')) {
        self.fiPackageType.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNumber = ko.observable((data && data.hasOwnProperty('fiNumber')) ? data.fiNumber : null);
    if (productValidator.includes('fiNumber')) {
        self.fiNumber.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            isInteger: {params: true, message: NSWLang["common_msg_formvalid_isinteger"]},
        });
    }
    self.fiUnitCode = ko.observable((data && data.hasOwnProperty('fiUnitCode')) ? data.fiUnitCode : null);
    if (productValidator.includes('fiUnitCode')) {
        self.fiUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiUnitVni = ko.observable((data && data.hasOwnProperty('fiUnitVni')) ? data.fiUnitVni : null);
    if (productValidator.includes('fiUnitVni')) {
        self.fiUnitVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiUnit = ko.observable((data && data.hasOwnProperty('fiUnit')) ? data.fiUnit : null);
    if (productValidator.includes('fiUnit')) {
        self.fiUnit.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNetWeight = ko.observable((data && data.hasOwnProperty('fiNetWeight')) ? data.fiNetWeight : null);
    if (productValidator.includes('fiNetWeight')) {
        self.fiNetWeight.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNetWeightUnitCode = ko.observable("KG");
    if (productValidator.includes('fiNetWeightUnitCode')) {
        self.fiNetWeightUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNetWeightUnitVni = ko.observable("Kilogram");
    if (productValidator.includes('fiNetWeightUnitVni')) {
        self.fiNetWeightUnitVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNetWeightUnit = ko.observable("Kilogram");
    if (productValidator.includes('fiNetWeightUnit')) {
        self.fiNetWeightUnit.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    self.fiFromDateProduct = ko.observable((data && data.hasOwnProperty('fiFromDateProduct')) ? data.fiFromDateProduct : null);
    if (productValidator.includes('fiFromDateProduct')) {
        self.fiFromDateProduct.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiToDateProduct = ko.observable((data && data.hasOwnProperty('fiToDateProduct')) ? data.fiToDateProduct : null);
    if (productValidator.includes('fiToDateProduct')) {
        self.fiToDateProduct.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiLotIdentificationNo = ko.observable((data && data.hasOwnProperty('fiLotIdentificationNo')) ? data.fiLotIdentificationNo : null);
    if (productValidator.includes('fiLotIdentificationNo')) {
        self.fiLotIdentificationNo.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPurposeVni = ko.observable((data && data.hasOwnProperty('fiPurposeVni')) ? data.fiPurposeVni : null);
    if (productValidator.includes('fiPurposeVni')) {
        self.fiPurposeVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPurpose = ko.observable((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
    if (productValidator.includes('fiPurpose')) {
        self.fiPurpose.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiShipmentvalue = ko.observable((data && data.hasOwnProperty('fiShipmentvalue')) ? data.fiShipmentvalue : null);
    if (productValidator.includes('fiShipmentvalue')) {
        self.fiShipmentvalue.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    self.fiMarkNo = ko.observable((data && data.hasOwnProperty('fiMarkNo')) ? data.fiMarkNo : null);


    self.lstUOMWeight = ko.observableArray(options.lstUOMWeight);

    self.fiNetWeightUnitCode.subscribe(function (item) {
        var unit = self.lstUOMWeight().filter(function (val) {
            return val.fiUnitCode == item;
        })
        self.fiNetWeightUnitVni(unit.length > 0 ? unit[0].fiUnitNameVni : '');
        self.fiNetWeightUnit(unit.length > 0 ? unit[0].fiUnitName : '');
    })

    self.fiUnitCode.subscribe(function (item) {
        var unit = self.lstUOMWeight().filter(function (val) {
            return val.fiUnitCode == item;
        })
        self.fiUnitVni(unit.length > 0 ? unit[0].fiUnitNameVni : '');
        self.fiUnit(unit.length > 0 ? unit[0].fiUnitName : '');
    })

    self.errors = ko.validation.group({
        fiProductNameVni: self.fiProductNameVni,
        fiProductName: self.fiProductName,
        fiPackageTypeVni: self.fiPackageTypeVni,
        fiPackageType: self.fiPackageType,
        fiNumber: self.fiNumber,
        fiUnitCode: self.fiUnitCode,
        fiNetWeight: self.fiNetWeight,
        fiNetWeightUnitCode: self.fiNetWeightUnitCode,
        fiFromDateProduct: self.fiFromDateProduct,
        fiToDateProduct: self.fiToDateProduct,
        fiLotIdentificationNo: self.fiLotIdentificationNo,
        fiPurposeVni: self.fiPurposeVni,
        fiPurpose: self.fiPurpose,
        fiShipmentvalue: self.fiShipmentvalue,
        fiMarkNo: self.fiMarkNo
    })

    self.selectedIndex = ko.observable(null);

    self.clearForm = function () {
        self.fiHSCode(null);
        self.fiProductNameVni(null);
        self.fiProductName(null);
        self.fiPackageTypeVni(null);
        self.fiPackageType(null);
        self.fiNumber(null);
        self.fiUnitCode(null);
        self.fiNetWeight(null);
        self.fiNetWeightUnitCode("KG");
        self.fiFromDateProduct(null);
        self.fiToDateProduct(null);
        self.fiLotIdentificationNo(null);
        self.fiPurposeVni(null);
        self.fiPurpose(null);
        self.fiShipmentvalue(null);
        self.selectedIndex(null);
        self.fiMarkNo(null);
    }

    self.onUpdateAnimalProduct = function (data, index) {
        if (data.fiFromDateProduct) data.fiFromDateProduct = new Date(data.fiFromDateProduct);
        if (data.fiToDateProduct) data.fiToDateProduct = new Date(data.fiToDateProduct);
        ko.mapping.fromJS(data, {}, self);
        self.selectedIndex(index);
    }

    self.addAnimalProduct = function () {
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return;
        }
        var jsonData = JSON.parse(ko.toJSON(self));
        delete jsonData['lstUOMWeight'];
        delete jsonData['selectedIndex'];
        delete jsonData['errors'];

        jsonData['fiNetWeight'] = jsonData['fiNetWeight'] ? Number(jsonData['fiNetWeight']) : null;
        jsonData['fiNumber'] = jsonData['fiNumber'] ? Number(jsonData['fiNumber']) : null;
        jsonData['fiShipmentvalue'] = jsonData['fiShipmentvalue'] ? Number(jsonData['fiShipmentvalue']) : null;

        if (self.selectedIndex() == null) {
            self.clearForm();
            onAddAnimalProduct(jsonData, null)
        } else {
            var index = self.selectedIndex();
            self.clearForm();
            onAddAnimalProduct(jsonData, index);
        }
    }
}

function RegisterAnimalProductVM (data, options) {
    var self = this;
    self.fiTotalAnimalProductByCharVni = ko.observable((data && data.hasOwnProperty('fiTotalAnimalProductByCharVni')) ? data.fiTotalAnimalProductByCharVni : null);
    self.fiTotalAnimalProductByChar = ko.observable((data && data.hasOwnProperty('fiTotalAnimalProductByChar')) ? data.fiTotalAnimalProductByChar : null);

    self.fiAnimalProductTestDepartment = ko.observable((data && data.hasOwnProperty('fiAnimalProductTestDepartment')) ? data.fiAnimalProductTestDepartment : null);
    self.fiAnimalProductTestDate = ko.observable((data && data.hasOwnProperty('fiAnimalProductTestDate')) ? data.fiAnimalProductTestDate ? new Date(data.fiAnimalProductTestDate) : null : null);
    self.fiAnimalProductTestNo = ko.observable((data && data.hasOwnProperty('fiAnimalProductTestNo')) ? data.fiAnimalProductTestNo : null);

    self.fiTemperatureProductName = ko.observable((data && data.hasOwnProperty('fiTemperatureProductName')) ? data.fiTemperatureProductName : null);
    self.fiProcessingNameAddressVni = ko.observable((data && data.hasOwnProperty('fiProcessingNameAddressVni')) ? data.fiProcessingNameAddressVni : null);
    self.fiProcessingNameAddress = ko.observable((data && data.hasOwnProperty('fiProcessingNameAddress')) ? data.fiProcessingNameAddress : null);
    self.fiProcessingTel = ko.observable((data && data.hasOwnProperty('fiProcessingTel')) ? data.fiProcessingTel : null);
    self.fiProcessingFax = ko.observable((data && data.hasOwnProperty('fiProcessingFax')) ? data.fiProcessingFax : null);
    self.fiPortShipmentNameVni = ko.observable((data && data.hasOwnProperty('fiPortShipmentNameVni')) ? data.fiPortShipmentNameVni : null);
    self.fiPortShipmentName = ko.observable((data && data.hasOwnProperty('fiPortShipmentName')) ? data.fiPortShipmentName : null);
    self.fiProcessingNumberRegistration = ko.observable((data && data.hasOwnProperty('fiProcessingNumberRegistration')) ? data.fiProcessingNumberRegistration : null);
    self.fiSlaughterHouseNameAddressVni = ko.observable((data && data.hasOwnProperty('fiSlaughterHouseNameAddressVni')) ? data.fiSlaughterHouseNameAddressVni : null);
    self.fiSlaughterHouseNameAddress = ko.observable((data && data.hasOwnProperty('fiSlaughterHouseNameAddress')) ? data.fiSlaughterHouseNameAddress : null);
    self.fiSlaughterHouseTel = ko.observable((data && data.hasOwnProperty('fiSlaughterHouseTel')) ? data.fiSlaughterHouseTel : null);
    self.fiSlaughterHouseFax = ko.observable((data && data.hasOwnProperty('fiSlaughterHouseFax')) ? data.fiSlaughterHouseFax : null);
    self.fiSlaughterHouseDate = ko.observable((data && data.hasOwnProperty('fiSlaughterHouseDate')) ? data.fiSlaughterHouseDate ? new Date(data.fiSlaughterHouseDate) : null : null);
    self.fiProcesssingDate = ko.observable((data && data.hasOwnProperty('fiProcesssingDate')) ? data.fiProcesssingDate ? new Date(data.fiProcesssingDate) : null : null);

    self.lstTemperatureProductName = ko.observable([{
            id: 1,
            name: "Nhiệt độ phòng"
        }, {
            id: 2,
            name: "Làm mát"
        }, {
            id: 3,
            name: "Đông lạnh"
        }]);


    if (data && data.hasOwnProperty("fiAnimalProductList")) {
        data.fiAnimalProductList.forEach(function(item) {
            item.fiDepartureDateFrom = new Date(item.fiDepartureDateFrom);
        })
    }

    self.fiAnimalProductList = ko.observableArray((data && data.hasOwnProperty("fiAnimalProductList")) ? data.fiAnimalProductList : null);

    self.addAnimalProductVM = ko.observable(new AddAnimalProductVM(null, options,onAddAnimalProduct = function(productJson, index) {
        if (productJson) {
            if (index == null) {
                self.fiAnimalProductList.push(productJson)
            } else {
                self.fiAnimalProductList.splice(index, 1, productJson);
            }
            if ($('#modal_addAnimalProduct').hasClass('in')) {
                $('#modal_addAnimalProduct').modal('hide')
            }
        }
    }));

    self.setUnitCode = function (unitname) {
        var unit = options.lstUOMWeight.filter(function (val) {
            return val.fiUnitNameVni == unitname;
        })
        return unit.length > 0 ? unit[0].fiUnitCode : null;
    }

    self.setUnitName = function (unitname) {
        var unit = options.lstUOMWeight.filter(function (val) {
            return val.fiUnitNameVni == unitname;
        })
        return unit.length > 0 ? unit[0].fiUnitName : null;
    }

    self.addAnimalProductFromExcel = function (e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {
            $('#loading01').show();
            var formData = new FormData();
            formData.append("file", files[0]);

            $.ajax({
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/01/uploadExcel?type=animal_product',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                },
                success: function (res) {
                    $('#loading01').hide();
                    if (res.success == true) {
                        var data = res.data;
                        var hasError = false;
                        data.forEach(function (product) {
                            if (hasError) return true;
                            product.fiUnitCode = self.setUnitCode(product.fiUnitVni);
                            if (!product.fiUnitCode && productValidator.includes('fiUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiUnitVni);
                                hasError = true;
                                return true;
                            }
                            product.fiUnit = self.setUnitName(product.fiUnitVni);
                            if (!product.fiUnit && productValidator.includes('fiUnit')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiUnitVni);
                                hasError = true;
                                return true;
                            }
                            product.fiNetWeightUnitCode = self.setUnitCode("Kilogram (KGM)");
                            if (!product.fiNetWeightUnitCode && productValidator.includes('fiNetWeightUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiNetWeightUnitVni);
                                hasError = true;
                                return true;
                            }
                            product.fiNetWeightUnit = self.setUnitName("Kilogram (KGM)");
                            if (!product.fiNetWeightUnit && productValidator.includes('fiNetWeightUnit')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiNetWeightUnitVni);
                                hasError = true;
                                return true;
                            }
                            productValidator.forEach(function (field) {
                                if (!product[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var fiAnimalProductList = self.fiAnimalProductList();
                            fiAnimalProductList = fiAnimalProductList.concat(data);
                            self.fiAnimalProductList(fiAnimalProductList);
                        }
                    } else {
                        // handle error here
                        app.Alert('File excel tải lên không đúng định dạng');
                    }
                },
                error: function (x, t, m) {
                    $('#loading01').hide();
                },
                complete: function (jqXHR, textStatus) {
                    $(e.target).val("");
                }
            });
        }
    }

    self.toJSON = function () {
        var exclude = ["toJSON", "lstTemperatureProductName", "addAnimalProductVM"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    }

    self.onDeleteProductAnimal = function(item) {
        self.fiAnimalProductList.splice(item, 1);
    };

    self.onUpdateAnimalProduct = function (data, index) {
        self.addAnimalProductVM().onUpdateAnimalProduct(data, index);
    }

}
