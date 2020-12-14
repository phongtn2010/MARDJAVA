var ERROR_FILL_FORM = 'Vui lòng điền đầy đủ các trường bắt buộc';

var mapTbdhoso08 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso08(index + 1, item);
    });
};

function Tbdhoso08(STT, item) {
    var self = this;
    if (item) {
        // ko.mapping.fromJS(item, {}, self);
        self.fiCreatedDate = ko.observable(item.fiCreatedDate ? new Date(item.fiCreatedDate) : null);
        self.fiCreatedBy = ko.observable(item.fiCreatedBy ? item.fiCreatedBy : null);
        self.fiUpdatedDate = ko.observable(item.fiUpdatedDate ? new Date(item.fiUpdatedDate) : null);
        self.fiUpdatedBy = ko.observable(item.fiUpdatedBy ? item.fiUpdatedBy : null);
        self.fiIdHS = ko.observable(item.fiIdHS ? item.fiIdHS : null);
        self.fiHSCode = ko.observable(item.fiHSCode ? item.fiHSCode : null);
        self.fiHSType = ko.observable(item.fiHSType);
        self.fiHSStatus = ko.observable(item.fiHSStatus);
        self.fiActive = ko.observable(item.fiActive ? item.fiActive : null);
        self.fiTaxCode = ko.observable(item.fiTaxCode ? item.fiTaxCode : null);
        self.fiHSCreatedDate = ko.observable(item.fiHSCreatedDate ? new Date(item.fiHSCreatedDate) : null);
        self.fiRegistrationNo = ko.observable(item.fiRegistrationNo ? item.fiRegistrationNo : null);
        self.fiImporterName = ko.observable(item.fiImporterName ? item.fiImporterName : null);
        self.fiImporterAddress = ko.observable(item.fiImporterAddress ? item.fiImporterAddress : null);
        self.fiImporterTel = ko.observable(item.fiImporterTel ? item.fiImporterTel : null);
        self.fiImporterFax = ko.observable(item.fiImporterFax ? item.fiImporterFax : null);
        self.fiImporterEmail = ko.observable(item.fiImporterEmail ? item.fiImporterEmail : null);
        self.fiIdentityNumber = ko.observable(item.fiIdentityNumber ? item.fiIdentityNumber : null);
        self.fiProcessingDate = ko.observable(item.fiProcessingDate ? new Date(item.fiProcessingDate) : null);
        self.fiIntendedPurpose = ko.observable(item.fiIntendedPurpose ? item.fiIntendedPurpose : null);
        self.fiProvidedDocument = ko.observable(item.fiProvidedDocument ? item.fiProvidedDocument : null);
        self.fiSigningLocation = ko.observable(item.fiSigningLocation ? item.fiSigningLocation : null);
        self.fiSignedDate = ko.observable(item.fiSignedDate ? new Date(item.fiSignedDate) : null);
        self.fiSignedBy = ko.observable(item.fiSignedBy ? item.fiSignedBy : null);
        self.fiSignedByTitle = ko.observable(item.fiSignedByTitle ? item.fiSignedByTitle : null);
        self.fiIdHSParent = ko.observable(item.fiIdHSParent ? item.fiIdHSParent : null);
        self.fiLicensedDate = ko.observable(item.fiLicensedDate ? new Date(item.fiLicensedDate) : null);
        self.fiLicenseNo = ko.observable(item.fiLicenseNo ? item.fiLicenseNo : null);
        self.fiSrcPortName = ko.observable(item.fiSrcPortName ? item.fiSrcPortName : null);
        self.fiDstPortCode = ko.observable(item.fiDstPortCode ? item.fiDstPortCode : null);
        self.fiImportingDateFrom = ko.observable(item.fiImportingDateFrom ? item.fiImportingDateFrom : null);
        self.fiImportingDateTo = ko.observable(item.fiImportingDateTo ? item.fiImportingDateTo : null);
        self.fiStorageLocation = ko.observable(item.fiStorageLocation ? item.fiStorageLocation : null);
        self.fiSamplingDateFrom = ko.observable(item.fiSamplingDateFrom ? item.fiSamplingDateFrom : null);
        self.fiSamplingDateTo = ko.observable(item.fiSamplingDateTo ? item.fiSamplingDateTo : null);
        self.fiSamplingLocation = ko.observable(item.fiSamplingLocation ? item.fiSamplingLocation : null);
        self.fiCirculateNo = ko.observable(item.fiCirculateNo ? item.fiCirculateNo : null);
        self.fiFoodType = ko.observable(item.fiFoodType ? item.fiFoodType : null);
        self.lstProductExporter = ko.observableArray(item.lstProductExporter ? item.lstProductExporter : []);
        self.lstAnimalExporter = ko.observableArray(item.lstAnimalExporter ? item.lstAnimalExporter : []);
        self.lstAnimal = ko.observableArray(item.lstAnimal ? item.lstAnimal : []);
        self.lstIsolatedLocation = ko.observableArray(item.lstIsolatedLocation ? item.lstIsolatedLocation : []);
        self.lstProduct = ko.observableArray(item.lstProduct ? item.lstProduct : []);
        self.lstProdMfr = ko.observableArray(item.lstProdMfr ? item.lstProdMfr : []);
        self.lstMfgFactory = ko.observableArray(item.lstMfgFactory ? item.lstMfgFactory : []);
        self.lstAtch = ko.observableArray(item.lstAtch ? item.lstAtch : []);

        // Types
        self.lstProfileStatus = ko.observableArray(item.lstProfileStatus ? item.lstProfileStatus : []);
        self.lstUOMs = ko.observableArray(item.lstUOMs ? item.lstUOMs : []);
        self.lstPort = ko.observableArray(item.lstPort ? item.lstPort : []);
        self.lstCountry = ko.observableArray(item.lstCountry ? item.lstCountry : []);
        self.lstAtchType = ko.observableArray(item.lstAtchType ? item.lstAtchType: []);

        self.regAnimalVM = ko.observable(new RegAnimalVM(item));
        self.regAnimalFoodVM = ko.observable(new RegAnimalFoodVM(item));
        self.frmAddAttachmentVM = ko.observable(new FrmAddAttachment(item));
        self.regQltVM = ko.observable(null);

        self.lstfiIntendedPurpose = ko.observableArray([
            'Nguyên liệu sản xuất thức ăn cho lợn',
            'Nguyên liệu sản xuất thức ăn cho gia cầm',
            'Nguyên liệu sản xuất thức ăn cho thủy sản',
            'Nguyên liệu sản xuất thức ăn cho động vật cảnh'
        ])
    }
    self.STT = ko.observable(STT);
    self.getUnitName = function (unitcode) {
        var lstUOMs = self.lstUOMAnimal();
        var pos = lstUOMs.find(function (e) {
            return e.unitcode == unitcode;
        })
        if (pos)
            return pos.unitname;
        else return '';
    }
    self.getCountryName = function (countrycode) {
        var lstCountry = self.lstCountry();
        var pos = lstCountry.find(function (e) {
            return e.countrycode == countrycode;
        })
        if (pos)
            return pos.countryname;
        else return ''
    }
    self.getPortName = function (portcode) {
        var lstPort = self.lstPort();
        var pos = lstPort.find(function (e) {
            return e.portcode == portcode;
        })
        if (pos)
            return pos.portname;
        else return ''
    }
    self.getProfileStatus = function (statuscode) {
        var lstProfileStatus = self.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == statuscode;
        })
        if (pos)
            return pos.name;
        else return '';
    }
}

function FrmAddAnimalVM(item) {
    var frmAddAnimalVMSelf = this;
    frmAddAnimalVMSelf.fiAnimalName = ko.observable(item ? item.fiAnimalName : null);
    frmAddAnimalVMSelf.fiQtyMale = ko.observable(item ? item.fiQtyMale : null);
    frmAddAnimalVMSelf.fiQtyFemale = ko.observable(item ? item.fiQtyFemale : null);
    frmAddAnimalVMSelf.fiUnitCode = ko.observable(item ? item.fiUnitCode : null);
    frmAddAnimalVMSelf.fiCountryOrigin = ko.observable(item ? item.fiCountryOrigin : null);
    frmAddAnimalVMSelf.fiPortName = ko.observable(item? item.fiPortName : null);
    frmAddAnimalVMSelf.errorMsg = ko.observable('');

    frmAddAnimalVMSelf.clearForm = function () {
        frmAddAnimalVMSelf.errorMsg('');
    }
}

function FrmAddProductVM(item) {
    var frmAddProductVMSelf = this;
    frmAddProductVMSelf.fiProductName = ko.observable(item ? item.fiProductName : null);
    frmAddProductVMSelf.fiNumber = ko.observable(item ? item.fiNumber : null);
    frmAddProductVMSelf.fiUnitCode = ko.observable(item ? item.fiUnitCode : null);
    frmAddProductVMSelf.fiCountryOrigin = ko.observable(item ? item.fiCountryOrigin : null);
    frmAddProductVMSelf.fiPortName = ko.observable(item? item.fiPortName : null);
    frmAddProductVMSelf.errorMsg = ko.observable('');

    frmAddProductVMSelf.clearForm = function () {
        frmAddProductVMSelf.errorMsg('');
    }
}

function FrmAddAnimalExporterVM(item) {
    var frmAddAnimalExporterSelf = this;
    frmAddAnimalExporterSelf.fiExporterName = ko.observable(item ? item.fiExporterName : null);
    frmAddAnimalExporterSelf.fiExporterAddress = ko.observable(item ? item.fiExporterAddress : null);
    frmAddAnimalExporterSelf.errorMsg = ko.observable('');

    frmAddAnimalExporterSelf.clearForm = function () {
        frmAddAnimalExporterSelf.errorMsg('');
    }
}

function FrmAddProductExporterVM(item) {
    var frmAddProductExporterSelf = this;
    frmAddProductExporterSelf.fiExporterName = ko.observable(item ? item.fiExporterName : null);
    frmAddProductExporterSelf.fiExporterAddress = ko.observable(item ? item.fiExporterAddress : null);
    frmAddProductExporterSelf.errorMsg = ko.observable('');

    frmAddProductExporterSelf.clearForm = function () {
        frmAddProductExporterSelf.errorMsg('');
    }
}

function FrmAddIsolatedLocationVM(item) {
    var frmAddIsolatedLocationSelf = this;
    frmAddIsolatedLocationSelf.fiIsoLocName = ko.observable(item ? item.fiIsoLocName : null);
    frmAddIsolatedLocationSelf.fiIsoLocAddress = ko.observable(item ? item.fiIsoLocAddress : null);
    frmAddIsolatedLocationSelf.errorMsg = ko.observable('');

    frmAddIsolatedLocationSelf.clearForm = function () {
        frmAddIsolatedLocationSelf.errorMsg('');
    }
}

function FrmAddProductMfrVM(item) {
    var frmAddProductMfrSelf = this;
    frmAddProductMfrSelf.fiMfrName = ko.observable(item ? item.fiMfrName : null);
    frmAddProductMfrSelf.fiMfrAddress = ko.observable(item ? item.fiMfrAddress : null);
    frmAddProductMfrSelf.errorMsg = ko.observable('');

    frmAddProductMfrSelf.clearForm = function () {
        frmAddProductMfrSelf.errorMsg('');
    }
}

function FrmAddMfgFactoryVM(item) {
    var frmAddMfgFactorySelf = this;
    frmAddMfgFactorySelf.fiFactoryName = ko.observable(item ? item.fiFactoryName : null);
    frmAddMfgFactorySelf.fiFactoryAddress = ko.observable(item ? item.fiFactoryAddress : null);
    frmAddMfgFactorySelf.errorMsg = ko.observable('');

    frmAddMfgFactorySelf.clearForm = function () {
        frmAddMfgFactorySelf.errorMsg('');
    }
}

function FrmAddAttachment(item) {
    var frmAddAttachmentSelf = this;
    if (item) {
        frmAddAttachmentSelf.lstAtch = ko.observableArray(item.lstAtch ? item.lstAtch : []);
    } else {
        frmAddAttachmentSelf.lstAtch = ko.observableArray([]);
    }
    frmAddAttachmentSelf.frmFile = ko.observable(null);
    frmAddAttachmentSelf.frmFileType = ko.observable(null);
    frmAddAttachmentSelf.errorMsg = ko.observable('');

    frmAddAttachmentSelf.clearForm = function () {
        frmAddAttachmentSelf.errorMsg('');
    }

    frmAddAttachmentSelf.fileChange = function(data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        frmAddAttachmentSelf.frmFile(files[0]);
    }

    frmAddAttachmentSelf.uploadFile = function () {
        if (!frmAddAttachmentSelf.frmFile() || !frmAddAttachmentSelf.frmFileType()) {
            frmAddAttachmentSelf.errorMsg('Vui lòng chọn loại file và file đính kèm');
            return;
        }
        if (Util.uploadFileNameValidate(frmAddAttachmentSelf.frmFile().name) && Util.validateExtension(frmAddAttachmentSelf.frmFile().name)) {
            var reader = new FileReader();
            reader.readAsDataURL(frmAddAttachmentSelf.frmFile());
            reader.onload = function(ev) {
                var fiNoiDung = reader.result;
                var fiTenLoai = frmAddAttachmentSelf.frmFileType().attachtypename;
                var fiMaLoai = frmAddAttachmentSelf.frmFileType().attachtypeid;
                var fiTenTep = frmAddAttachmentSelf.frmFile().name;
                var data = {
                    fiNoiDung: fiNoiDung,
                    fiTenLoai: fiTenLoai,
                    fiMaLoai: fiMaLoai,
                    fiTenTep: fiTenTep
                }
                $('#loading10').show();
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/08/dinhkem/create',
                    data: JSON.stringify(data),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                    },
                    success: function (res) {
                        $('#loading10').hide();
                        frmAddAttachmentSelf.lstAtch.push(res.data);
                        frmAddAttachmentSelf.clearForm();
                        $('#modal_addFile').modal('toggle');
                    },
                    error: function (x, t, m) {
                        $('#loading10').hide();
                    },
                    complete: function (jqXHR, textStatus) {
                    }
                });
            }
            reader.onerror = function (ev) {
            }
        } else {
            return;
        }
    }
}

function RegAnimalVM(item) {
    var selfRegAnimalVM = this;
    if (item) {
        selfRegAnimalVM.lstAnimal = ko.observableArray(item.lstAnimal ? item.lstAnimal : []);
        selfRegAnimalVM.lstAnimalExporter = ko.observableArray(item.lstAnimalExporter ? item.lstAnimalExporter : []);
        selfRegAnimalVM.lstIsolatedLocation = ko.observableArray(item.lstIsolatedLocation ? item.lstIsolatedLocation : []);
        selfRegAnimalVM.lstProduct = ko.observableArray(item.lstProduct ? item.lstProduct : []);
        selfRegAnimalVM.lstProductExporter = ko.observableArray(item.lstProductExporter ? item.lstProductExporter : []);
        selfRegAnimalVM.lstProdMfr = ko.observableArray(item.lstProdMfr ? item.lstProdMfr : []);

        selfRegAnimalVM.fiProcessingDate = ko.observable(item.fiProcessingDate ? new Date(item.fiProcessingDate) : null);
        selfRegAnimalVM.fiIntendedPurpose = ko.observable(item.fiIntendedPurpose ? item.fiIntendedPurpose : null);
        selfRegAnimalVM.fiProvidedDocument = ko.observable(item.fiProvidedDocument ? item.fiProvidedDocument : null);

        selfRegAnimalVM.frmAddAnimalVM = ko.observable(new FrmAddAnimalVM());
        selfRegAnimalVM.frmAddProductVM = ko.observable(new FrmAddProductVM());
        selfRegAnimalVM.frmAddAnimalExporterVM = ko.observable(new FrmAddAnimalExporterVM());
        selfRegAnimalVM.frmAddProductExporterVM = ko.observable(new FrmAddProductExporterVM());
        selfRegAnimalVM.frmAddIsolatedLocationVM = ko.observable(new FrmAddIsolatedLocationVM());
        selfRegAnimalVM.frmAddProductMfrVM = ko.observable(new FrmAddProductMfrVM());
    } else {
        selfRegAnimalVM.lstAnimal = ko.observableArray([]);
        selfRegAnimalVM.lstAnimalExporter = ko.observableArray( []);
        selfRegAnimalVM.lstIsolatedLocation = ko.observableArray( []);
        selfRegAnimalVM.lstProduct = ko.observableArray( []);
        selfRegAnimalVM.lstProductExporter = ko.observableArray([]);
        selfRegAnimalVM.lstProdMfr = ko.observableArray( []);

        selfRegAnimalVM.frmAddAnimalVM = ko.observable(new FrmAddAnimalVM());
        selfRegAnimalVM.frmAddProductVM = ko.observable(new FrmAddProductVM());
        selfRegAnimalVM.frmAddAnimalExporterVM = ko.observable(new FrmAddAnimalExporterVM());
        selfRegAnimalVM.frmAddProductExporterVM = ko.observable(new FrmAddProductExporterVM());
        selfRegAnimalVM.frmAddIsolatedLocationVM = ko.observable(new FrmAddIsolatedLocationVM());
        selfRegAnimalVM.frmAddProductMfrVM = ko.observable(new FrmAddProductMfrVM());
    }

    selfRegAnimalVM.addAnimal = function() {
        var frmAddAnimalVM = selfRegAnimalVM.frmAddAnimalVM();
        if (!frmAddAnimalVM.fiAnimalName() || !frmAddAnimalVM.fiUnitCode() || !frmAddAnimalVM.fiPortName() || !frmAddAnimalVM.fiCountryOrigin() || !frmAddAnimalVM.fiUnitCode()
         && (!frmAddAnimalVM.fiQtyMale() || !frmAddAnimalVM.fiQtyFemale())) {
            frmAddAnimalVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddAnimalVM.clearForm();
            var data = {
                fiAnimalName: frmAddAnimalVM.fiAnimalName(),
                fiUnitCode: frmAddAnimalVM.fiUnitCode().unitcode,
                fiQtyMale: frmAddAnimalVM.fiQtyMale() || 0,
                fiQtyFemale: frmAddAnimalVM.fiQtyFemale() || 0,
                fiCountryOrigin: frmAddAnimalVM.fiCountryOrigin().countrycode,
                fiPortName: frmAddAnimalVM.fiPortName().portcode
            }
            selfRegAnimalVM.lstAnimal.push(data);
            $('#modal_addAnimal').modal('toggle');
        }
    }

    selfRegAnimalVM.addProduct = function () {
        var frmAddProductVM = selfRegAnimalVM.frmAddProductVM();
        if (!frmAddProductVM.fiProductName() || !frmAddProductVM.fiUnitCode() || !frmAddProductVM.fiPortName() || !frmAddProductVM.fiCountryOrigin() || !frmAddProductVM.fiUnitCode()
            && !frmAddProductVM.fiNumber()) {
            frmAddProductVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductVM.clearForm();
            var data = {
                fiProductName: frmAddProductVM.fiProductName(),
                fiUnitCode: frmAddProductVM.fiUnitCode().unitcode,
                fiNumber: frmAddProductVM.fiNumber() || 0,
                fiCountryOrigin: frmAddProductVM.fiCountryOrigin().countrycode,
                fiPortName: frmAddProductVM.fiPortName().portcode
            }
            selfRegAnimalVM.lstProduct.push(data);
            $('#modal_addProduct').modal('toggle');
        }
    }

    selfRegAnimalVM.addProductExporter = function () {
        var frmAddProductExporterVM = selfRegAnimalVM.frmAddProductExporterVM();
        if (!frmAddProductExporterVM.fiExporterName() || !frmAddProductExporterVM.fiExporterAddress()) {
            frmAddProductExporterVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductExporterVM.clearForm();
            var data = {
                fiExporterName: frmAddProductExporterVM.fiExporterName(),
                fiExporterAddress: frmAddProductExporterVM.fiExporterAddress()
            }
            selfRegAnimalVM.lstProductExporter.push(data);
            $('#modal_addProductExporter').modal('toggle');
        }
    }

    selfRegAnimalVM.addAnimalExporter = function () {
        var frmAddAnimalExporterVM = selfRegAnimalVM.frmAddAnimalExporterVM();
        if (!frmAddAnimalExporterVM.fiExporterName() || !frmAddAnimalExporterVM.fiExporterAddress()) {
            frmAddAnimalExporterVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddAnimalExporterVM.clearForm();
            var data = {
                fiExporterName: frmAddAnimalExporterVM.fiExporterName(),
                fiExporterAddress: frmAddAnimalExporterVM.fiExporterAddress()
            }
            selfRegAnimalVM.lstAnimalExporter.push(data);
            $('#modal_addAnimalExporter').modal('toggle');
        }
    }

    selfRegAnimalVM.addIsoLocation = function () {
        var frmAddIsolatedLocation = selfRegAnimalVM.frmAddIsolatedLocationVM();
        if (!frmAddIsolatedLocation.fiIsoLocName() || !frmAddIsolatedLocation.fiIsoLocAddress()) {
            frmAddIsolatedLocation.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddIsolatedLocation.clearForm();
            var data = {
                fiIsoLocName: frmAddIsolatedLocation.fiIsoLocName(),
                fiIsoLocAddress: frmAddIsolatedLocation.fiIsoLocAddress()
            }
            selfRegAnimalVM.lstIsolatedLocation.push(data);
            $('#modal_addIsoLocation').modal('toggle');
        }
    }

    selfRegAnimalVM.addProductMfr = function () {
        var frmAddProductMfrVM = selfRegAnimalVM.frmAddProductMfrVM();
        if (!frmAddProductMfrVM.fiMfrName() || !frmAddProductMfrVM.fiMfrAddress()) {
            frmAddProductMfrVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductMfrVM.clearForm();
            var data = {
                fiMfrName: frmAddProductMfrVM.fiMfrName(),
                fiMfrAddress: frmAddProductMfrVM.fiMfrAddress()
            }
            selfRegAnimalVM.lstProdMfr.push(data);
            $('#modal_addProductMfr').modal('toggle');
        }
    }
}

function RegAnimalFoodVM(item) {
    var selfRegAnimalFoodVM = this;
    if (item) {
        selfRegAnimalFoodVM.lstProduct = ko.observableArray(item.lstProduct ? item.lstProduct : []);
        selfRegAnimalFoodVM.lstProductExporter = ko.observableArray(item.lstProductExporter ? item.lstProductExporter : []);
        selfRegAnimalFoodVM.lstProdMfr = ko.observableArray(item.lstProdMfr ? item.lstProdMfr : []);
        selfRegAnimalFoodVM.lstMfgFactory = ko.observableArray(item.lstMfgFactory ? item.lstMfgFactory : []);

        selfRegAnimalFoodVM.fiProcessingDate = ko.observable(item.fiProcessingDate ? new Date(item.fiProcessingDate) : null);
        selfRegAnimalFoodVM.fiIntendedPurpose = ko.observable(item.fiIntendedPurpose ? item.fiIntendedPurpose : null);
        selfRegAnimalFoodVM.fiProvidedDocument = ko.observable(item.fiProvidedDocument ? item.fiProvidedDocument : null);

        selfRegAnimalFoodVM.frmAddProductVM = ko.observable(new FrmAddProductVM());
        selfRegAnimalFoodVM.frmAddProductExporterVM = ko.observable(new FrmAddProductExporterVM());
        selfRegAnimalFoodVM.frmAddProductMfrVM = ko.observable(new FrmAddProductMfrVM());
        selfRegAnimalFoodVM.frmAddMfgFactoryVM = ko.observable(new FrmAddMfgFactoryVM());
    } else {
        selfRegAnimalFoodVM.lstProduct = ko.observableArray( []);
        selfRegAnimalFoodVM.lstProductExporter = ko.observableArray([]);
        selfRegAnimalFoodVM.lstProdMfr = ko.observableArray([]);
        selfRegAnimalFoodVM.lstMfgFactory = ko.observableArray([]);

        selfRegAnimalFoodVM.fiProcessingDate = ko.observable(null);
        selfRegAnimalFoodVM.fiIntendedPurpose = ko.observable(null);
        selfRegAnimalFoodVM.fiProvidedDocument = ko.observable(null);

        selfRegAnimalFoodVM.frmAddProductVM = ko.observable(new FrmAddProductVM());
        selfRegAnimalFoodVM.frmAddProductExporterVM = ko.observable(new FrmAddProductExporterVM());
        selfRegAnimalFoodVM.frmAddProductMfrVM = ko.observable(new FrmAddProductMfrVM());
        selfRegAnimalFoodVM.frmAddMfgFactoryVM = ko.observable(new FrmAddMfgFactoryVM());
    }

    selfRegAnimalFoodVM.addProduct = function () {
        var frmAddProductVM = selfRegAnimalFoodVM.frmAddProductVM();
        if (!frmAddProductVM.fiProductName() || !frmAddProductVM.fiUnitCode() || !frmAddProductVM.fiPortName() || !frmAddProductVM.fiCountryOrigin() || !frmAddProductVM.fiUnitCode()
            && !frmAddProductVM.fiNumber()) {
            frmAddProductVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductVM.clearForm();
            var data = {
                fiProductName: frmAddProductVM.fiProductName(),
                fiUnitCode: frmAddProductVM.fiUnitCode().unitcode,
                fiNumber: frmAddProductVM.fiNumber() || 0,
                fiCountryOrigin: frmAddProductVM.fiCountryOrigin().countrycode,
                fiPortName: frmAddProductVM.fiPortName().portcode
            }
            selfRegAnimalFoodVM.lstProduct.push(data);
            $('#modal_addProduct2').modal('toggle');
        }
    }

    selfRegAnimalFoodVM.addProductExporter = function () {
        var frmAddProductExporterVM = selfRegAnimalFoodVM.frmAddProductExporterVM();
        if (!frmAddProductExporterVM.fiExporterName() || !frmAddProductExporterVM.fiExporterAddress()) {
            frmAddProductExporterVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductExporterVM.clearForm();
            var data = {
                fiExporterName: frmAddProductExporterVM.fiExporterName(),
                fiExporterAddress: frmAddProductExporterVM.fiExporterAddress()
            }
            selfRegAnimalFoodVM.lstProductExporter.push(data);
            $('#modal_addProductExporter2').modal('toggle');
        }
    }

    selfRegAnimalFoodVM.addProductMfr = function () {
        var frmAddProductMfrVM = selfRegAnimalFoodVM.frmAddProductMfrVM();
        if (!frmAddProductMfrVM.fiMfrName() || !frmAddProductMfrVM.fiMfrAddress()) {
            frmAddProductMfrVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddProductMfrVM.clearForm();
            var data = {
                fiMfrName: frmAddProductMfrVM.fiMfrName(),
                fiMfrAddress: frmAddProductMfrVM.fiMfrAddress()
            }
            selfRegAnimalFoodVM.lstProdMfr.push(data);
            $('#modal_addProductMfr2').modal('toggle');
        }
    }

    selfRegAnimalFoodVM.addMfgFactory = function () {
        var frmAddMfgFactoryVM = selfRegAnimalFoodVM.frmAddMfgFactoryVM();
        if (!frmAddMfgFactoryVM.fiFactoryName() || !frmAddMfgFactoryVM.fiFactoryAddress()) {
            frmAddMfgFactoryVM.errorMsg(ERROR_FILL_FORM);
            return;
        } else {
            frmAddMfgFactoryVM.clearForm();
            var data = {
                fiFactoryName: frmAddMfgFactoryVM.fiFactoryName(),
                fiFactoryAddress: frmAddMfgFactoryVM.fiFactoryAddress()
            }
            selfRegAnimalFoodVM.lstMfgFactory.push(data);
            $('#modal_addMfgFactory').modal('toggle');
        }
    }
}