var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';
var animalValidator = ['fiAnimalTypeVni', 'fiAnimalType', 'fiBreedVni', 'fiBreed', 'fiAge', 'fiSex', 'fiNumber',
    'fiAnimalNetWeight', 'fiAnimalUnitCode', 'fiPurposeVni', 'fiPurpose'];
function AnimalVM(data, options, onAddAnimal) {
    var self = this;

    self.fiHSCode = ko.observable((data && data.hasOwnProperty('fiHSCode')) ? data.fiHSCode : null);
    self.fiAnimalTypeVni = ko.observable((data && data.hasOwnProperty('fiAnimalTypeVni')) ? data.fiAnimalTypeVni : null);
    if (animalValidator.includes('fiAnimalTypeVni')) {
        self.fiAnimalTypeVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiAnimalType = ko.observable((data && data.hasOwnProperty('fiAnimalType')) ? data.fiAnimalType : null);
    if (animalValidator.includes('fiAnimalType')) {
        self.fiAnimalType.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiBreedVni = ko.observable((data && data.hasOwnProperty('fiBreedVni')) ? data.fiBreedVni : null);
    if (animalValidator.includes('fiBreedVni')) {
        self.fiBreedVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiBreed = ko.observable((data && data.hasOwnProperty('fiBreed')) ? data.fiBreed : null);
    if (animalValidator.includes('fiBreed')) {
        self.fiBreed.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiAge = ko.observable((data && data.hasOwnProperty('fiAge')) ? data.fiAge : null);
    if (animalValidator.includes('fiAge')) {
        self.fiAge.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiSex = ko.observable((data && data.hasOwnProperty('fiSex')) ? data.fiSex : "1");
    if (animalValidator.includes('fiSex')) {
        self.fiSex.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiNumber = ko.observable((data && data.hasOwnProperty('fiNumber')) ? data.fiNumber : null);
    if (animalValidator.includes('fiNumber')) {
        self.fiNumber.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            isInteger: {params: true, message: NSWLang["common_msg_formvalid_isinteger"]},
        });
    }
    self.fiAnimalNetWeight = ko.observable((data && data.hasOwnProperty('fiAnimalNetWeight')) ? data.fiAnimalNetWeight : null);
    if (animalValidator.includes('fiAnimalNetWeight')) {
        self.fiAnimalNetWeight.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            isInteger: {params: true, message: NSWLang["common_msg_formvalid_isinteger"]},
        });
    }
    self.fiAnimalUnitCode = ko.observable("KG");
    if (animalValidator.includes('fiAnimalUnitCode')) {
        self.fiAnimalUnitCode.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiAnimalUnitVni = ko.observable("Kilogram");
    if (animalValidator.includes('fiAnimalUnitVni')) {
        self.fiAnimalUnitVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiAnimalUnit = ko.observable("Kilogram");
    if (animalValidator.includes('fiAnimalUnit')) {
        self.fiAnimalUnit.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPurposeVni = ko.observable((data && data.hasOwnProperty('fiPurposeVni')) ? data.fiPurposeVni : null);
    if (animalValidator.includes('fiPurposeVni')) {
        self.fiPurposeVni.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiPurpose = ko.observable((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
    if (animalValidator.includes('fiPurpose')) {
        self.fiPurpose.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    self.fiShipmentvalue = ko.observable((data && data.hasOwnProperty('fiShipmentvalue')) ? data.fiShipmentvalue : null);
    if (animalValidator.includes('fiShipmentvalue')) {
        self.fiShipmentvalue.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }

    self.lstUOMWeight = ko.observableArray(options.lstUOMWeight);
    self.fiAnimalUnitCode.subscribe(function (item) {
        var unit = self.lstUOMWeight().filter(function (val) {
            return val.fiUnitCode == item;
        })
        self.fiAnimalUnitVni(unit.length > 0 ? unit[0].fiUnitNameVni : '');
        self.fiAnimalUnit(unit.length > 0 ? unit[0].fiUnitName : '');
    })

    self.selectedIndex = ko.observable(null);

    self.errors = ko.validation.group({
        fiAnimalTypeVni: self.fiAnimalTypeVni,
        fiAnimalType: self.fiAnimalType,
        fiBreedVni: self.fiBreedVni,
        fiBreed: self.fiBreed,
        fiAge: self.fiAge,
        fiSex: self.fiSex,
        fiNumber: self.fiNumber,
        fiAnimalNetWeight: self.fiAnimalNetWeight,
        fiAnimalUnitCode: self.fiAnimalUnitCode,
        fiAnimalUnitVni: self.fiAnimalUnitVni,
        fiAnimalUnit: self.fiAnimalUnit,
        fiPurposeVni: self.fiPurposeVni,
        fiPurpose: self.fiPurpose,
        fiShipmentvalue: self.fiShipmentvalue
    })

    self.onUpdateAnimal = function (data, index) {
        self.selectedIndex(index);
        ko.mapping.fromJS(data, {}, self);
    }

    self.clearForm = function() {
        self.fiHSCode(null);
        self.fiAnimalTypeVni(null);
        self.fiAnimalType(null);
        self.fiBreedVni(null);
        self.fiBreed(null);
        self.fiAge(null);
        self.fiSex(1);
        self.fiNumber(null);
        self.fiAnimalNetWeight(null);
        self.fiAnimalUnitCode("KG");
        self.fiPurposeVni(null);
        self.fiPurpose(null);
        self.fiShipmentvalue(null);
        self.selectedIndex(null);
    }

    self.addAnimal = function () {
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return;
        }
        var jsonData = JSON.parse(ko.toJSON(self));
        delete jsonData['selectedIndex'];
        delete jsonData['lstUOMWeight'];
        delete jsonData['errors'];
        jsonData['fiAnimalNetWeight'] = jsonData['fiAnimalNetWeight'] ? Number(jsonData['fiAnimalNetWeight']) : null;
        jsonData['fiNumber'] = jsonData['fiNumber'] ? Number(jsonData['fiNumber']) : null;
        jsonData['fiShipmentvalue'] = jsonData['fiShipmentvalue'] ? Number(jsonData['fiShipmentvalue']) : null;

        if (self.selectedIndex() != null) {
            var index = self.selectedIndex();
            self.clearForm();
            onAddAnimal(jsonData, index);
        } else {
            self.clearForm();
            onAddAnimal(jsonData, null);
        }
    }
}


function VaccinVM(data, onAddVaccin) {
    var self = this;
    self.fiVaccinationAgainstName = ko.observable((data && data.hasOwnProperty('fiVaccinationAgainstName')) ? data.fiVaccinationAgainstName : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiVaccinationAgainstDate = ko.observable((data && data.hasOwnProperty('fiVaccinationAgainstDate')) ? new Date(data.fiVaccinationAgainstDate) : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.errorMsg = ko.observable('');

    self.selectedIndex = ko.observable(null);

    self.clearForm = function() {
        self.fiVaccinationAgainstName(null);
        self.fiVaccinationAgainstDate(null);
        self.selectedIndex(null);
    };

    self.onUpdateVaccin = function (data, index) {
        self.selectedIndex(index);
        self.fiVaccinationAgainstName(data.fiVaccinationAgainstName ? data.fiVaccinationAgainstName: null);
        self.fiVaccinationAgainstDate(data.fiVaccinationAgainstDate ? new Date(data.fiVaccinationAgainstDate) : null);
    };

    self.validateForm = function() {
        var option = {
            fiVaccinationAgainstName: self.fiVaccinationAgainstName,
            fiVaccinationAgainstDate: self.fiVaccinationAgainstDate
        };

        self.errors = ko.validation.group(option, { deep: true });
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    self.addVaccin = function () {
        if (!self.validateForm()) {
            return;
        }
        var jsonData = JSON.parse(ko.toJSON(self));
        delete jsonData['isEdit'];
        delete jsonData['selectedIndex'];

        if (self.selectedIndex() == null) {
            self.clearForm();
            onAddVaccin(jsonData, null);
        } else {
            var index = self.selectedIndex();
            self.clearForm();
            onAddVaccin(jsonData, index);
        }
    }
}

function TestVM(data, onAddTest) {
    var self = this;
    self.fiTestName = ko.observable((data && data.hasOwnProperty('fiVaccinationAgainstName')) ? data.fiVaccinationAgainstName : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiTestNumber = ko.observable((data && data.hasOwnProperty('fiVaccinationAgainstName')) ? data.fiVaccinationAgainstName : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiTestDate = ko.observable((data && data.hasOwnProperty('fiVaccinationAgainstName')) ? new Date(data.fiVaccinationAgainstName) : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.selectedIndex = ko.observable(null);

    self.clearForm = function(){
        self.fiTestName(null);
        self.fiTestNumber(null);
        self.fiTestDate(null);
    };

    self.validateForm = function() {
        var option = {
            fiTestName: self.fiTestName,
            fiTestNumber: self.fiTestNumber,
            fiTestDate: self.fiTestDate
        };

        self.errors = ko.validation.group(option, { deep: true });
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    self.onUpdateTest = function (data, index) {
        self.selectedIndex(index);
        self.fiTestName(data.fiTestName ? data.fiTestName : null);
        self.fiTestNumber(data.fiTestNumber ? data.fiTestNumber : null);
        self.fiTestDate(data.fiTestDate? new Date(data.fiTestDate) : null);
    };

    self.addTest = function () {
        if (!self.validateForm()) {
            return;
        }
        var jsonData = JSON.parse(ko.toJSON(self));
        delete jsonData['selectedIndex'];

        if (self.selectedIndex() == null) {
            self.clearForm();
            onAddTest(jsonData, null);
        } else {
            var index = self.selectedIndex();
            self.clearForm();
            onAddTest(jsonData, index);
        }
    }
}

function RegisterAnimalVM(data, options) {
    var self = this;
    self.fiTotalAnimalByCharVni = ko.observable((data && data.hasOwnProperty('fiTotalAnimalByCharVni')) ? data.fiTotalAnimalByCharVni : null);
    self.fiTotalAnimalByChar = ko.observable((data && data.hasOwnProperty('fiTotalAnimalByChar')) ? data.fiTotalAnimalByChar : null);
    self.fiDeparturePlaceOfAnimalVni = ko.observable((data && data.hasOwnProperty('fiDeparturePlaceOfAnimalVni')) ? data.fiDeparturePlaceOfAnimalVni : null);
    self.fiDeparturePlaceOfAnimal = ko.observable((data && data.hasOwnProperty('fiDeparturePlaceOfAnimal')) ? data.fiDeparturePlaceOfAnimal : null);
    self.fiAnimalHealthStatus = ko.observable((data && data.hasOwnProperty('fiAnimalHealthStatus')) ? data.fiAnimalHealthStatus : null);
    self.fiDiseaseSafeName = ko.observable((data && data.hasOwnProperty('fiDiseaseSafeName')) ? data.fiDiseaseSafeName : null);
    self.fiDecisionNo = ko.observable((data && data.hasOwnProperty('fiDecisionNo')) ? data.fiDecisionNo : null);
    self.fiDecisionDate = ko.observable((data && data.hasOwnProperty('fiDecisionDate')) ? data.fiDecisionDate ? new Date(data.fiDecisionDate) : null : null);
    self.fiDecisionDepartment = ko.observable((data && data.hasOwnProperty('fiDecisionDepartment')) ? data.fiDecisionDepartment : null);
    self.itemEdit = null;

    if (data && data.hasOwnProperty("fiAnimalList")) {
        data.fiAnimalList.forEach(function (item) {
            item.fiDepartureDateFrom = new Date(item.fiDepartureDateFrom);
        })
    }

    if (data && data.hasOwnProperty("fiTestList")) {
        data.fiTestList.forEach(function (item) {
            item.fiTestDate = new Date(item.fiTestDate);
        })
    }

    if (data && data.hasOwnProperty("fiVaccinList")) {
        data.fiVaccinList.forEach(function (item) {
            item.fiVaccinationAgainstDate = new Date(item.fiVaccinationAgainstDate);
        })
    }

    self.fiVaccinList = ko.observableArray((data && data.hasOwnProperty("fiVaccinList")) ? data.fiVaccinList : null);
    self.fiTestList = ko.observableArray((data && data.hasOwnProperty("fiTestList")) ? data.fiTestList : null);
    self.fiAnimalList = ko.observableArray((data && data.hasOwnProperty("fiAnimalList")) ? data.fiAnimalList : null);

    self.addVaccinVM = ko.observable(new VaccinVM(null, onAddVaccin = function (vaccinJson, index) {
        $('.validate').empty();

        if (vaccinJson) {
            if (index == null) {
                self.fiVaccinList.push(vaccinJson);
            } else {
                self.fiVaccinList.splice(index, 1, vaccinJson);
            }
            if ($('#modal_addVaccin').hasClass('in')) {
                $('#modal_addVaccin').modal('hide')
            }
        }
    }));

    self.addVaccineFromExcel = function (e) {
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
                url: app.appContext + '/mard/01/uploadExcel?type=vaccine',
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
                        var fiVaccinList = self.fiVaccinList();
                        fiVaccinList = fiVaccinList.concat(data);
                        self.fiVaccinList(fiVaccinList);
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

    self.addTestVM = ko.observable(new TestVM(null, onAddTest = function (testJson, index) {
        $('.validate').empty();

        if (testJson) {
            if (index == null) {
                self.fiTestList.push(testJson);
            } else {
                self.fiTestList.splice(index, 1, testJson);
            }
        }
        if ($('#modal_addTest').hasClass('in')) {
            $('#modal_addTest').modal('hide')
        }
    }));

    self.addTestFromExcel = function (e) {
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
                url: app.appContext + '/mard/01/uploadExcel?type=test',
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
                        var fiTestList = self.fiTestList();
                        fiTestList = fiTestList.concat(data);
                        self.fiTestList(fiTestList);
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

    self.addAnimalVM = ko.observable(new AnimalVM(null, options, onAddAnimal = function (animalJson, index) {
        $('.validate').empty();

        if (animalJson) {
            if (index == null) {
                self.fiAnimalList.push(animalJson);
            } else {
                self.fiAnimalList.splice(index, 1, animalJson);
            }
            if ($('#modal_addAnimal').hasClass('in')) {
                $('#modal_addAnimal').modal('hide')
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

    self.addAnimalFromExcel = function (e) {
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
                url: app.appContext + '/mard/01/uploadExcel?type=animal',
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
                            product.fiAnimalUnitCode = self.setUnitCode(product.fiAnimalUnitVni);
                            if (!product.fiAnimalUnitCode && animalValidator.includes('fiAnimalUnitCode')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiAnimalUnitVni);
                                hasError = true;
                                return true;
                            }
                            product.fiAnimalUnit = self.setUnitName(product.fiAnimalUnitVni);
                            if (!product.fiAnimalUnit && animalValidator.includes('fiAnimalUnit')) {
                                app.Alert('File excel tải lên không đúng định dạng. Sai đơn vị ' + product.fiAnimalUnitVni);
                                hasError = true;
                                return true;
                            }
                            animalValidator.forEach(function (field) {
                                if (!product[field]) {
                                    app.Alert('File excel tải lên không đúng định dạng. Thiếu thông tin bắt buộc');
                                    hasError = true;
                                    return true;
                                }
                            })
                        })
                        if (!hasError) {
                            var fiAnimalList = self.fiAnimalList();
                            fiAnimalList = fiAnimalList.concat(data);
                            self.fiAnimalList(fiAnimalList);
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
        var exclude = ["toJSON", "addVaccinVM", "addTestVM", "addAnimalVM", "addAnimal", "addAnimalProductVM"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.onDeleteAnimal = function (item) {
        self.fiAnimalList.splice(item, 1);
    };

    self.onUpdateAnimal = function (data, item) {
        data.fiSex = data.fiSex.toString();
        self.addAnimalVM().onUpdateAnimal(data, item);
    };

    self.onDeleteTest = function (item) {
        self.fiTestList.splice(item, 1);
    };

    self.onUpdateTest = function (data, item) {
        self.addTestVM().onUpdateTest(data, item);
    }

    self.onDeleteVaccin = function (item) {
        self.fiVaccinList.splice(item, 1);
    };

    self.onUpdateVaccin = function (data, item) {
        self.addVaccinVM().onUpdateVaccin(data, item);
    }
}


