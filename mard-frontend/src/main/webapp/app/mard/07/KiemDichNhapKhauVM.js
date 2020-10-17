function KiemDichNhapKhauVM(options) {
    var kdnkVMSelf = this;

    kdnkVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);
    kdnkVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(options));
    kdnkVMSelf.kyHoSoVM = ko.observable(new KyHoSoVM(options));
    kdnkVMSelf.uploadFileVM = ko.observable(new UploadFileVM(options.fiAttachmentList ? options.fiAttachmentList : []));

    kdnkVMSelf.ttnkVM = ko.observable(new ThongTinNhapKhauVM(options,
        ['fiExporterSelect', 'fiExporterCountryAddress', 'fiProcessingSelect', 'fiProcessingAddress', 'fiPackage',
            'fiContractsNo', 'fiOriginationImport', 'fiPortOfDepartureName', 'fiPortOfDestinationName', 'fiTransportType', 'fiPurposeUse', 'fiLocationOfQuarantine', 'fiQuantityLicense',
        ], 1, onTranshipmentSelected = function (isSelected) {
            if (!isSelected) {
                kdnkVMSelf.lstAtchTypeHTC([]);
            } else {
                kdnkVMSelf.lstAtchTypeHTC(options.lstAtchTypeHTC);
            }
            kdnkVMSelf.updateAtchType();
        }));
    kdnkVMSelf.ttnkVM2 = ko.observable(new ThongTinNhapKhauVM(options,
        ['fiExporter', 'fiExporterCountryAddress', 'fiProcessingName', 'fiProcessingAddress', 'fiPackage',
            'fiContractsNo', 'fiOriginationImport', 'fiPortOfDepartureName', 'fiPortOfDestinationName', 'fiTransportType', 'fiPurposeUse', 'fiLocationOfQuarantine', 'fiQuantityLicense'
        ], 2, onTranshipmentSelected = function (isSelected) {
            if (!isSelected) {
                kdnkVMSelf.lstAtchTypeHTC([]);
            } else {
                kdnkVMSelf.lstAtchTypeHTC(options.lstAtchTypeHTC);
            }
            kdnkVMSelf.updateAtchType();
        }));

    kdnkVMSelf.fiModifyReason = ko.observable((options && options.hasOwnProperty('fiModifyReason')) ? options.fiModifyReason : null);
    if (window.location.href.indexOf("ycs") > -1) {
        kdnkVMSelf.fiModifyReason.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        })
    }
    kdnkVMSelf.fiDepartmentofMonitorCode = ko.observable((options && options.hasOwnProperty('fiDepartmentofMonitorCode')) ? options.fiDepartmentofMonitorCode : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        })
    kdnkVMSelf.fiDepartmentofMonitorName = ko.observable((options && options.hasOwnProperty('fiDepartmentofMonitorName')) ? options.fiDepartmentofMonitorName : null);
    kdnkVMSelf.fiDepartmentofQuarantineCode = ko.observable((options && options.hasOwnProperty('fiDepartmentofQuarantineCode')) ? options.fiDepartmentofQuarantineCode : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        })
    kdnkVMSelf.fiDepartmentofQuarantineName = ko.observable((options && options.hasOwnProperty('fiDepartmentofQuarantineName')) ? options.fiDepartmentofQuarantineName : null);
    kdnkVMSelf.fiRequestOption = ko.observable((options && options.hasOwnProperty('fiRequestOption')) ? options.fiRequestOption : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kdnkVMSelf.fiSelectedRequestOptions = ko.observableArray((options && options.hasOwnProperty('fiRequestOption')) ? options.fiRequestOption.split(',') : []);
    kdnkVMSelf.fiSelectedRequestOptions.subscribe(function (item) {
        kdnkVMSelf.fiRequestOption(kdnkVMSelf.fiSelectedRequestOptions().toString());
    })
    kdnkVMSelf.fiOptionOther = ko.observable((options && options.hasOwnProperty('fiOptionOther')) ? options.fiOptionOther : null);
    kdnkVMSelf.fiPurposeUse = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        })
    kdnkVMSelf.fiLicenseNo = ko.observable((options && options.hasOwnProperty('fiLicenseNo')) ? options.fiLicenseNo : null);
    kdnkVMSelf.fiLicenseDate = ko.observable((options && options.hasOwnProperty('fiLicenseDate')) ? options.fiLicenseDate : null);

    kdnkVMSelf.fiRegType = ko.observable(null);

    kdnkVMSelf.fiCongVan = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return kdnkVMSelf.fiRegType() == 1;
            }
        },
    });

    kdnkVMSelf.lstProfileStatus = ko.observableArray((options && options.hasOwnProperty('lstProfileStatus')) ? options.lstProfileStatus : []);
    kdnkVMSelf.lstPurpose = ko.observableArray((options && options.hasOwnProperty('lstPurpose')) ? options.lstPurpose : []);
    kdnkVMSelf.lstDepartment = ko.observableArray((options && options.hasOwnProperty('lstDepartment')) ? options.lstDepartment : []);
    kdnkVMSelf.lstCongVan = ko.observableArray((options && options.hasOwnProperty('lstCongVan')) ? options.lstCongVan : []);

    kdnkVMSelf.lstAtchType = ko.observableArray([]);
    kdnkVMSelf.lstAtchTypeHTC = ko.observableArray([]);

    kdnkVMSelf.errorMsg = ko.observable(null);

    kdnkVMSelf.getProfileStatus = function (statuscode) {
        var lstProfileStatus = kdnkVMSelf.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == Number(statuscode);
        })
        if (pos)
            return pos.name;
        else {
            if (statuscode == -1 || statuscode == '-1') return "";
            else return statuscode;
        }
    }

    kdnkVMSelf.fiDepartmentofMonitorCode.subscribe(function (item) {
        if (item) {
            var lstDepartment = kdnkVMSelf.lstDepartment()
            for (var i = 0; i < lstDepartment.length; i++) {
                if (lstDepartment[i].id == item) {
                    kdnkVMSelf.fiDepartmentofMonitorName(lstDepartment[i].name);
                    break;
                }
            }
        }
    })

    kdnkVMSelf.fiDepartmentofQuarantineCode.subscribe(function (item) {
        if (item) {
            var lstDepartment = kdnkVMSelf.lstDepartment()
            for (var i = 0; i < lstDepartment.length; i++) {
                if (lstDepartment[i].id == item) {
                    kdnkVMSelf.fiDepartmentofQuarantineName(lstDepartment[i].name);
                    break;
                }
            }
        }
    })

    kdnkVMSelf.fiCongVan.subscribe(function (item) {
        if (item) {
            kdnkVMSelf.ttnkVM().update(item);

            kdnkVMSelf.fiLicenseNo(item.fiDispatchNo);
            kdnkVMSelf.fiLicenseDate(item.fiDispatchDate);
        }
    })

    kdnkVMSelf.fiPurposeUse.subscribe(function (item) {
        if (item) {
            kdnkVMSelf.ttnkVM().fiPurposeUse(item);
            kdnkVMSelf.ttnkVM2().fiPurposeUse(item);
            if (item == 'Làm nguyên liệu gia công, chế biến thực phẩm xuất khẩu'
                || item == 'Hàng làm mẫu thử' || item == 'Sản phẩm động vật thủy sản xuất khẩu bị triệu hồi hoặc bị trả về') {
                kdnkVMSelf.fiRegType(2);
            } else if (item == 'Khác' && kdnkVMSelf.fiOptionOther() != null) {
                var fiOptionOther = kdnkVMSelf.fiOptionOther().toLowerCase().trim().replace(/\s\s+/g, ' ');
                if (fiOptionOther.includes('hàng xuất khẩu bị trả về')) {
                    kdnkVMSelf.fiRegType(2);
                }
            } else {
                kdnkVMSelf.fiRegType(1);
            }
        }
    })

    kdnkVMSelf.fiOptionOther.subscribe(function (item) {
        if (kdnkVMSelf.fiPurposeUse() == 'Khác') {
            if (item) {
                item = item.toLowerCase().trim().replace(/\s\s+/g, ' ');
                if (item.includes('hàng xuất khẩu bị trả về')) {
                    kdnkVMSelf.fiRegType(2);
                } else {
                    kdnkVMSelf.fiRegType(1);
                }
            } else {
                kdnkVMSelf.fiRegType(1);
            }
        }
    })

    kdnkVMSelf.fiRegType.subscribe(function (item) {
        if (item == 2) {
            kdnkVMSelf.fiCongVan(null);
            kdnkVMSelf.fiLicenseNo(null);
            kdnkVMSelf.fiLicenseDate(null);
            kdnkVMSelf.lstAtchType(options.lstAtchTypeGCCB);
            kdnkVMSelf.updateAtchType();
            kdnkVMSelf.ttnkVM2().clearForm();
            kdnkVMSelf.ttnkVM2().productVM().productType(2);
            kdnkVMSelf.ttnkVM2().productVM().fiQuantityOrWeightUnitCode("KG");
        } else if (item == 1) {
            kdnkVMSelf.lstAtchType(options.lstAtchType)
            kdnkVMSelf.updateAtchType();
            kdnkVMSelf.ttnkVM().clearForm();
            kdnkVMSelf.ttnkVM().productVM().productType(1);
        }
    })

    kdnkVMSelf.updateAtchType = function () {
        var lstAtchType = kdnkVMSelf.lstAtchType();
        var lstAtchTypeHTC = kdnkVMSelf.lstAtchTypeHTC();
        kdnkVMSelf.uploadFileVM().updateAtchType(lstAtchType.concat(lstAtchTypeHTC));
    }

    kdnkVMSelf.applyState = function (data) {
        kdnkVMSelf.fiPurposeUse((data && data.hasOwnProperty('fiPurposeUse')) ? data.fiPurposeUse : null);
        if (data && data.hasOwnProperty('lstCongVan')) {
            var lstCongVan = data.lstCongVan;
            for (var i = 0; i < lstCongVan.length; i++) {
                if (lstCongVan[i].fiDispatchNo && (lstCongVan[i].fiDispatchNo == kdnkVMSelf.fiLicenseNo())) {
                    kdnkVMSelf.fiCongVan(lstCongVan[i]);
                    kdnkVMSelf.fiRegType(1);
                    break;
                }
            }
        }
        kdnkVMSelf.ttnkVM().applyState(data);
        kdnkVMSelf.ttnkVM2().applyState(data);
    }

    kdnkVMSelf.errors = ko.validation.group(kdnkVMSelf);

    kdnkVMSelf.validateForm = function () {
        if (!kdnkVMSelf.thongtinChungVM().validate()) {
            kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            return false;
        }
        if (kdnkVMSelf.errors().length > 0) {
            kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            kdnkVMSelf.errors.showAllMessages();
            return false;
        }
        if (kdnkVMSelf.fiRegType() == 2) {
            if (!kdnkVMSelf.ttnkVM2().validate()) {
                kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
                return false;
            }
        } else {
            if (!kdnkVMSelf.ttnkVM().validate()) {
                kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
                return false;
            }
        }
        if (!kdnkVMSelf.kyHoSoVM().validate()) {
            kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            return false;
        }
        kdnkVMSelf.errorMsg(null);
        return true;
    }

    kdnkVMSelf.validateAttachment = function() {
        if (!kdnkVMSelf.uploadFileVM().validate()) {
            kdnkVMSelf.errorMsg(NSWLang["file_msg_chua_chon_file"]);
            return false;
        } else {
            kdnkVMSelf.errorMsg(null);
            return true;
        }
    }

    kdnkVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(kdnkVMSelf));
        var exclude = ['fiDepartmentofQuarantine', 'fiDepartmentofMonitor', 'fiExporterSelect', 'fiProcessingSelect', 'lstCountry', 'lstPort', 'lstProfileStatus', 'lstDepartment', 'lstCongVan', 'lstCVProduct',
            'lstCVLocationQuaratine', 'fiCongVan', 'thongtinChungVM', 'kyHoSoVM', 'uploadFileVM', 'fiRegType'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.fiAttachmentList = kdnkVMSelf.uploadFileVM().getLstAttachments();
        data = $.extend(data, kdnkVMSelf.thongtinChungVM().toJSON());
        data = $.extend(data, kdnkVMSelf.kyHoSoVM().toJSON());
        if (kdnkVMSelf.fiRegType() == 2) {
            data = $.extend(data, kdnkVMSelf.ttnkVM2().getData());
        } else {
            data = $.extend(data, kdnkVMSelf.ttnkVM().getData());
        }

        return data;
    }
}
