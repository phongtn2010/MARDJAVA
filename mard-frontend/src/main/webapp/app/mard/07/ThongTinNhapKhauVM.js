function ThongTinNhapKhauVM(options, validator, type, onTranshipmentSelected) {
    var ttnkVMSelf = this;
    var prodValidator = [];
    if (type == 1) {
        prodValidator = ['fiNameOfGoods',
            'fiSizeOrShape', 'fiQuantityOrWeight', 'fiQuantityOrWeightUnitName', 'fiOriginationName'];
    } else if (type == 2) {
        prodValidator = ['fiNameOfGoods',
            'fiSizeOrShape', 'fiQuantityOrWeight', 'fiQuantityOrWeightUnitCode', 'fiOriginationCode']
    }
    ttnkVMSelf.lstUOM = ko.observableArray((options && options.hasOwnProperty('lstUOM')) ? options.lstUOM : []);
    ttnkVMSelf.productVM = ko.observable(new ProductVM(options, prodValidator));
    ttnkVMSelf.fiExporterSelect = ko.observable(null);
    if (validator.includes('fiExporterSelect')) {
        ttnkVMSelf.fiExporterSelect.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiExporter = ko.observable(null);
    if (validator.includes('fiExporter')) {
        ttnkVMSelf.fiExporter.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiExporterCountryAddress = ko.observable(null);
    if (validator.includes('fiExporterCountryAddress')) {
        ttnkVMSelf.fiExporterCountryAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiProcessingSelect = ko.observable(null);
    if (validator.includes('fiProcessingSelect')) {
        ttnkVMSelf.fiProcessingSelect.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiProcessingName = ko.observable(null);
    if (validator.includes('fiProcessingName')) {
        ttnkVMSelf.fiProcessingName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiProcessingAddress = ko.observable(null);
    if (validator.includes('fiProcessingAddress')) {
        ttnkVMSelf.fiProcessingAddress.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiPackage = ko.observable(null);
    if (validator.includes('fiPackage')) {
        ttnkVMSelf.fiPackage.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiQuantityPackage = ko.observable(null);
    ttnkVMSelf.fiContractsNo = ko.observable(null);
    if (validator.includes('fiContractsNo')) {
        ttnkVMSelf.fiContractsNo.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiOriginationImport = ko.observable(null);
    if (validator.includes('fiOriginationImport')) {
        ttnkVMSelf.fiOriginationImport.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiOriginationTransit = ko.observable(null);
    if (validator.includes('fiOriginationTransit')) {
        ttnkVMSelf.fiOriginationTransit.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiPortOfDepartureName = ko.observable(null);
    if (validator.includes('fiPortOfDepartureName')) {
        ttnkVMSelf.fiPortOfDepartureName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiPortOfDestinationName = ko.observable(null);
    if (validator.includes('fiPortOfDestinationName')) {
        ttnkVMSelf.fiPortOfDestinationName.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiTransportType = ko.observable(null);
    if (validator.includes('fiTransportType')) {
        ttnkVMSelf.fiTransportType.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiPurposeUse = ko.observable(null);
    if (validator.includes('fiPurposeUse')) {
        ttnkVMSelf.fiPurposeUse.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiLocationOfQuarantineId = ko.observable(null);
    if (validator.includes('fiLocationOfQuarantineId')) {
        ttnkVMSelf.fiLocationOfQuarantineId.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiLocationOfQuarantine = ko.observable(null);
    if (validator.includes('fiLocationOfQuarantine')) {
        ttnkVMSelf.fiLocationOfQuarantine.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiLocationOfGrow = ko.observable(null);
    if (validator.includes('fiLocationOfGrow')) {
        ttnkVMSelf.fiLocationOfGrow.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiDateOfQuarantineFrom = ko.observable(null);
    if (validator.includes('fiDateOfQuarantineFrom')) {
        ttnkVMSelf.fiDateOfQuarantineFrom.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiDateOfQuarantineTo = ko.observable(null);
    if (validator.includes('fiDateOfQuarantineTo')) {
        ttnkVMSelf.fiDateOfQuarantineTo.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiLocationOfMonitor = ko.observable(null);
    if (validator.includes('fiLocationOfMonitor')) {
        ttnkVMSelf.fiLocationOfMonitor.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiDateOfMonitorFrom = ko.observable(null);
    if (validator.includes('fiDateOfMonitorFrom')) {
        ttnkVMSelf.fiDateOfMonitorFrom.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiDateOfMonitorTo = ko.observable(null);
    if (validator.includes('fiDateOfMonitorTo')) {
        ttnkVMSelf.fiDateOfMonitorTo.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    }
    ttnkVMSelf.fiQuantityLicense = ko.observable(null);
    if (validator.includes('fiQuantityLicense')) {
        ttnkVMSelf.fiQuantityLicense.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]},
            max: {
                params: 99,
                message: NSWLang["common_msg_formvaild_maxvalue"] + " " + 100
            }
        });
    }

    ttnkVMSelf.fiDateOfCatchFrom = ko.observable(null);
    ttnkVMSelf.fiDateOfCatchTo = ko.observable(null);
    ttnkVMSelf.fiLocationOfCatch = ko.observable(null);
    ttnkVMSelf.fiMethodCatch = ko.observable(null);
    // Hang trung chuyen
    ttnkVMSelf.fiTransshipmentGoods = ko.observable(false);
    ttnkVMSelf.fiTransshipmentGoods.subscribe(function (item) {
            onTranshipmentSelected(item);
    })
    ttnkVMSelf.fiBusinessNumberofRegistration = ko.observable(null)
    ttnkVMSelf.fiNameOfRepresentRegistration = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiTotalOfGoodsWeight = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
            min: {params: 0.0000001, message: NSWLang["common_msg_formvaild_positivenumber"]}
        });
    ttnkVMSelf.fiTotalOfGoodsWeightUnitCode = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        })
    ttnkVMSelf.fiTotalOfGoodsWeightUnitName = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        })
    ttnkVMSelf.fiTotalOfGoodsWeightUnitCode.subscribe(function (item) {
        if (item) {
            var unit = ttnkVMSelf.lstUOM().filter(function (val) {
                return val.unitcode == item;
            })
            ttnkVMSelf.fiTotalOfGoodsWeightUnitName(unit.length > 0 ? unit[0].unitname : '');
        }
    })
    ttnkVMSelf.fiNameOfFishingShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiCodeOfFishingShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiOriginationOfFishingShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiNameOfTransferShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiCodeOfTransferShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiOriginationOfTransferShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiNameOfContainerShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiCodeOfContainerShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiOriginationOfContainerShip = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiLoadingUnLoadingTimeFrom = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiLoadingUnLoadingTimeTo = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });
    ttnkVMSelf.fiLoadingUnloadingPlace = ko.observable(null)
        .extend({
            required: {
                message: NSWLang["common_msg_formvaild_required"],
                onlyIf: function () {
                    return ttnkVMSelf.fiTransshipmentGoods()
                }
            },
        });

    // ttnkVMSelf.fiGoodsList = ko.observableArray((options && options.hasOwnProperty('fiGoodsList')) ? options.fiGoodsList : []);

    ttnkVMSelf.lstRequestOption = ko.observableArray([
        "Nhập khẩu", "Kho ngoại quan", "Quá cảnh", "Tạm xuất tái nhập", "Nhập khẩu làm NLCBXK", "Chuyển khẩu", "Hàng mẫu"
    ])

    ttnkVMSelf.lstCountry = ko.observableArray((options && options.hasOwnProperty('lstCountry')) ? options.lstCountry : []);
    ttnkVMSelf.lstPort = ko.observableArray((options && options.hasOwnProperty('lstPort')) ? options.lstPort : []);
    ttnkVMSelf.lstCVProduct = ko.observableArray([]);
    ttnkVMSelf.lstCVLocationQuaratine = ko.observableArray([]);
    ttnkVMSelf.fiExporterList = ko.observableArray([]);

    ttnkVMSelf.fiExporterSelect.subscribe(function (item) {
        if (item) {
            ttnkVMSelf.fiExporterCountryAddress(item.fiExporterCountryAddress);
            ttnkVMSelf.fiExporter(item.fiExporterCountryName);
        }
    })

    ttnkVMSelf.fiProcessingSelect.subscribe(function (item) {
        if (item) {
            ttnkVMSelf.fiProcessingAddress(item.fiProcessingAddress);
            ttnkVMSelf.fiProcessingName(item.fiProcessingName);
        }
    })

    ttnkVMSelf.fiLocationOfQuarantineId.subscribe(function (item) {
        if (item) {
            var unit = ttnkVMSelf.lstCVLocationQuaratine().filter(function (val) {
                return val.fiIdQuarLoc == item;
            });
            ttnkVMSelf.fiLocationOfQuarantine(unit.length > 0 ? unit[0].fiLocationQuarantineName : '');
        }
    })

    ttnkVMSelf.openChooseExporter = function(){
        $("#modal_selectExporter").modal("show")
    }

    ttnkVMSelf.errors = ko.validation.group({
        fiExporter: ttnkVMSelf.fiExporter,
        fiExporterCountryAddress: ttnkVMSelf.fiExporterCountryAddress,
        fiProcessingName: ttnkVMSelf.fiProcessingName,
        fiProcessingAddress: ttnkVMSelf.fiProcessingAddress,
        fiPackage: ttnkVMSelf.fiPackage,
        fiContractsNo: ttnkVMSelf.fiContractsNo,
        fiOriginationImport: ttnkVMSelf.fiOriginationImport,
        fiOriginationTransit: ttnkVMSelf.fiOriginationTransit,
        fiPortOfDepartureName: ttnkVMSelf.fiPortOfDepartureName,
        fiPortOfDestinationName: ttnkVMSelf.fiPortOfDestinationName,
        fiTransportType: ttnkVMSelf.fiTransportType,
        fiPurposeUse: ttnkVMSelf.fiPurposeUse,
        fiLocationOfQuarantineId: ttnkVMSelf.fiLocationOfQuarantineId,
        fiLocationOfQuarantine: ttnkVMSelf.fiLocationOfQuarantine,
        fiLocationOfGrow: ttnkVMSelf.fiLocationOfGrow,
        fiDateOfQuarantineFrom: ttnkVMSelf.fiDateOfQuarantineFrom,
        fiDateOfQuarantineTo: ttnkVMSelf.fiDateOfQuarantineTo,
        fiLocationOfMonitor: ttnkVMSelf.fiLocationOfMonitor,
        fiDateOfMonitorFrom: ttnkVMSelf.fiDateOfMonitorFrom,
        fiDateOfMonitorTo: ttnkVMSelf.fiDateOfMonitorTo,
        fiQuantityLicense: ttnkVMSelf.fiQuantityLicense,
        fiNameOfRepresentRegistration: ttnkVMSelf.fiNameOfRepresentRegistration,
        fiTotalOfGoodsWeight: ttnkVMSelf.fiTotalOfGoodsWeight,
        fiNameOfFishingShip: ttnkVMSelf.fiNameOfFishingShip,
        fiCodeOfFishingShip: ttnkVMSelf.fiCodeOfFishingShip,
        fiOriginationOfFishingShip: ttnkVMSelf.fiOriginationOfFishingShip,
        fiNameOfTransferShip: ttnkVMSelf.fiNameOfTransferShip,
        fiCodeOfTransferShip: ttnkVMSelf.fiCodeOfTransferShip,
        fiOriginationOfTransferShip: ttnkVMSelf.fiOriginationOfTransferShip,
        fiNameOfContainerShip: ttnkVMSelf.fiNameOfContainerShip,
        fiCodeOfContainerShip: ttnkVMSelf.fiCodeOfContainerShip,
        fiOriginationOfContainerShip: ttnkVMSelf.fiOriginationOfContainerShip,
        fiLoadingUnLoadingTimeFrom: ttnkVMSelf.fiLoadingUnLoadingTimeFrom,
        fiLoadingUnLoadingTimeTo: ttnkVMSelf.fiLoadingUnLoadingTimeTo,
        fiLoadingUnloadingPlace: ttnkVMSelf.fiLoadingUnloadingPlace,
        fiGoodsList: ttnkVMSelf.productVM().fiGoodsList
    }, { deep: true });

    ttnkVMSelf.validate = function () {
        if (ttnkVMSelf.errors().length > 0) {
            ttnkVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    ttnkVMSelf.update = function (item) {
        ttnkVMSelf.clearForm();

        ttnkVMSelf.productVM().lstCVProduct(item.fiProductList);
        ttnkVMSelf.lstCVLocationQuaratine(item.fiLocationQuarantineList);

        ttnkVMSelf.fiPortOfDestinationName(item.fiBordergateName);
        if (item.fiExporterCountryList.length > 0) {
            var lstExportStr = '';
            var lstExporterAddressStr = '';
            item.fiExporterCountryList.forEach(function (exporter) {
                lstExportStr += exporter.fiExporterCountryName + '; ';
                lstExporterAddressStr += exporter.fiExporterCountryAddress + '; ';
            });
            ttnkVMSelf.fiExporter(lstExportStr);
            ttnkVMSelf.fiExporterCountryAddress(lstExporterAddressStr);
        }
        if (item.fiProcessingList.length > 0) {
            var lstProcessingStr = '';
            var lstProcessingAddressStr = '';
            item.fiProcessingList.forEach(function (proces) {
                lstProcessingStr += proces.fiProcessingName + '; ';
                lstProcessingAddressStr += proces.fiProcessingAddress + '; ';
            });
            ttnkVMSelf.fiProcessingName(lstProcessingStr);
            ttnkVMSelf.fiProcessingAddress(lstProcessingAddressStr);
        }
    }

    ttnkVMSelf.applyState = function (data) {
        ttnkVMSelf.fiExporter((data && data.hasOwnProperty('fiExporter')) ? data.fiExporter : null);
        ttnkVMSelf.fiExporterCountryAddress((data && data.hasOwnProperty('fiExporterCountryAddress')) ? data.fiExporterCountryAddress : null);
        ttnkVMSelf.fiProcessingName((data && data.hasOwnProperty('fiProcessingName')) ? data.fiProcessingName : null);
        ttnkVMSelf.fiProcessingAddress((data && data.hasOwnProperty('fiProcessingAddress')) ? data.fiProcessingAddress : null);
        ttnkVMSelf.fiPackage((data && data.hasOwnProperty('fiPackage')) ? data.fiPackage : null);
        ttnkVMSelf.fiQuantityPackage((data && data.hasOwnProperty('fiQuantityPackage')) ? data.fiQuantityPackage : null);
        ttnkVMSelf.fiContractsNo((data && data.hasOwnProperty('fiContractsNo')) ? data.fiContractsNo : null);
        ttnkVMSelf.fiOriginationImport((data && data.hasOwnProperty('fiOriginationImport')) ? data.fiOriginationImport : null);
        ttnkVMSelf.fiOriginationTransit((data && data.hasOwnProperty('fiOriginationTransit')) ? data.fiOriginationTransit : null);
        ttnkVMSelf.fiPortOfDepartureName((data && data.hasOwnProperty('fiPortOfDepartureName')) ? data.fiPortOfDepartureName : null);
        ttnkVMSelf.fiPortOfDestinationName((data && data.hasOwnProperty('fiPortOfDestinationName')) ? data.fiPortOfDestinationName : null);
        ttnkVMSelf.fiTransportType((data && data.hasOwnProperty('fiTransportType')) ? data.fiTransportType : null);
        ttnkVMSelf.fiPurposeUse((data && data.hasOwnProperty('fiPurposeUse')) ? data.fiPurposeUse : null);
        ttnkVMSelf.fiLocationOfQuarantine((data && data.hasOwnProperty('fiLocationOfQuarantine')) ? data.fiLocationOfQuarantine : null);
        ttnkVMSelf.fiLocationOfGrow((data && data.hasOwnProperty('fiLocationOfGrow')) ? data.fiLocationOfGrow : null);
        ttnkVMSelf.fiDateOfQuarantineFrom(data.fiDateOfQuarantineFrom ? new Date(data.fiDateOfQuarantineFrom) : null);
        ttnkVMSelf.fiDateOfQuarantineTo(data.fiDateOfQuarantineTo ? new Date(data.fiDateOfQuarantineTo) : null);
        ttnkVMSelf.fiLocationOfMonitor((data && data.hasOwnProperty('fiLocationOfMonitor')) ? data.fiLocationOfMonitor : null);
        ttnkVMSelf.fiDateOfMonitorFrom(data.fiDateOfMonitorFrom ? new Date(data.fiDateOfMonitorFrom) : null);
        ttnkVMSelf.fiDateOfMonitorTo(data.fiDateOfMonitorTo ? new Date(data.fiDateOfMonitorTo) : null);
        ttnkVMSelf.fiQuantityLicense((data && data.hasOwnProperty('fiQuantityLicense')) ? data.fiQuantityLicense : null);

        ttnkVMSelf.fiExporterList([]);

        ttnkVMSelf.fiTransshipmentGoods((data && data.hasOwnProperty('fiTransshipmentGoods')) ? (data.fiTransshipmentGoods == 0 ? false : true) : false);
        ttnkVMSelf.fiBusinessNumberofRegistration((data && data.hasOwnProperty('fiBusinessNumberofRegistration')) ? data.fiBusinessNumberofRegistration : null);
        ttnkVMSelf.fiNameOfRepresentRegistration((data && data.hasOwnProperty('fiNameOfRepresentRegistration')) ? data.fiNameOfRepresentRegistration : null);
        ttnkVMSelf.fiTotalOfGoodsWeight((data && data.hasOwnProperty('fiTotalOfGoodsWeight')) ? data.fiTotalOfGoodsWeight : null);
        ttnkVMSelf.fiTotalOfGoodsWeightUnitCode((data && data.hasOwnProperty('fiTotalOfGoodsWeightUnitCode')) ? data.fiTotalOfGoodsWeightUnitCode : null);
        ttnkVMSelf.fiTotalOfGoodsWeightUnitName((data && data.hasOwnProperty('fiTotalOfGoodsWeightUnitName')) ? data.fiTotalOfGoodsWeightUnitName : null);
        ttnkVMSelf.fiNameOfFishingShip((data && data.hasOwnProperty('fiNameOfFishingShip')) ? data.fiNameOfFishingShip : null);
        ttnkVMSelf.fiCodeOfFishingShip((data && data.hasOwnProperty('fiCodeOfFishingShip')) ? data.fiCodeOfFishingShip : null);
        ttnkVMSelf.fiOriginationOfFishingShip((data && data.hasOwnProperty('fiOriginationOfFishingShip')) ? data.fiOriginationOfFishingShip : null);
        ttnkVMSelf.fiNameOfTransferShip((data && data.hasOwnProperty('fiNameOfTransferShip')) ? data.fiNameOfTransferShip : null);
        ttnkVMSelf.fiCodeOfTransferShip((data && data.hasOwnProperty('fiCodeOfTransferShip')) ? data.fiCodeOfTransferShip : null);
        ttnkVMSelf.fiOriginationOfTransferShip((data && data.hasOwnProperty('fiOriginationOfTransferShip')) ? data.fiOriginationOfTransferShip : null);
        ttnkVMSelf.fiNameOfContainerShip((data && data.hasOwnProperty('fiNameOfContainerShip')) ? data.fiNameOfContainerShip : null);
        ttnkVMSelf.fiCodeOfContainerShip((data && data.hasOwnProperty('fiCodeOfContainerShip')) ? data.fiCodeOfContainerShip : null);
        ttnkVMSelf.fiOriginationOfContainerShip((data && data.hasOwnProperty('fiOriginationOfContainerShip')) ? data.fiOriginationOfContainerShip : null);
        ttnkVMSelf.fiLoadingUnloadingPlace((data && data.hasOwnProperty('fiLoadingUnloadingPlace')) ? data.fiLoadingUnloadingPlace : null);
        ttnkVMSelf.fiLoadingUnLoadingTimeFrom(data.fiLoadingUnLoadingTimeFrom ? new Date(data.fiLoadingUnLoadingTimeFrom) : null);
        ttnkVMSelf.fiLoadingUnLoadingTimeTo(data.fiLoadingUnLoadingTimeTo ? new Date(data.fiLoadingUnLoadingTimeTo) : null);

        ttnkVMSelf.fiDateOfCatchFrom(data.fiDateOfCatchFrom ? new Date(data.fiDateOfCatchFrom) : null);
        ttnkVMSelf.fiDateOfCatchTo(data.fiDateOfCatchTo ? new Date(data.fiDateOfCatchTo) : null);
        ttnkVMSelf.fiLocationOfCatch((data && data.hasOwnProperty('fiLocationOfCatch')) ? data.fiLocationOfCatch : null);
        ttnkVMSelf.fiMethodCatch((data && data.hasOwnProperty('fiMethodCatch')) ? data.fiMethodCatch : null);

        if (data.fiGoodsList) {
            ttnkVMSelf.productVM().fiGoodsList(data.fiGoodsList)
        }

        if (data && data.hasOwnProperty('fiLocationOfQuarantine')) {
            var lstCVLocationQuaratine = ttnkVMSelf.lstCVLocationQuaratine();
            for (var i = 0; i < lstCVLocationQuaratine.length; i++) {
                if (lstCVLocationQuaratine[i].fiLocationQuarantineName == data.fiLocationOfQuarantine) {
                    ttnkVMSelf.fiLocationOfQuarantineId(lstCVLocationQuaratine[i].fiIdQuarLoc);
                    break;
                }
            }
        }
    }

    ttnkVMSelf.clearForm = function () {
        ttnkVMSelf.fiExporterSelect(null);
        ttnkVMSelf.fiExporter(null);
        ttnkVMSelf.fiExporterCountryAddress(null);
        ttnkVMSelf.fiProcessingSelect(null);
        ttnkVMSelf.fiProcessingName(null);
        ttnkVMSelf.fiProcessingAddress(null);
        ttnkVMSelf.fiPackage(null);
        ttnkVMSelf.fiQuantityPackage(null);
        ttnkVMSelf.fiContractsNo(null);
        ttnkVMSelf.fiOriginationImport(null);
        ttnkVMSelf.fiOriginationTransit(null);
        ttnkVMSelf.fiPortOfDepartureName(null);
        ttnkVMSelf.fiPortOfDestinationName(null);
        ttnkVMSelf.fiTransportType(null);
        ttnkVMSelf.fiLocationOfQuarantineId(null);
        ttnkVMSelf.fiLocationOfQuarantine(null);
        ttnkVMSelf.fiLocationOfGrow(null);
        ttnkVMSelf.fiDateOfQuarantineFrom(null);
        ttnkVMSelf.fiDateOfQuarantineTo(null);
        ttnkVMSelf.fiLocationOfMonitor(null);
        ttnkVMSelf.fiDateOfMonitorFrom(null);
        ttnkVMSelf.fiDateOfMonitorTo(null);
        ttnkVMSelf.fiQuantityLicense(null);

        ttnkVMSelf.fiTransshipmentGoods(null);
        ttnkVMSelf.fiBusinessNumberofRegistration(null);
        ttnkVMSelf.fiNameOfRepresentRegistration(null);
        ttnkVMSelf.fiTotalOfGoodsWeight(null);
        ttnkVMSelf.fiTotalOfGoodsWeightUnitCode(null);
        ttnkVMSelf.fiTotalOfGoodsWeightUnitName(null);
        ttnkVMSelf.fiNameOfFishingShip(null);
        ttnkVMSelf.fiCodeOfFishingShip(null);
        ttnkVMSelf.fiOriginationOfFishingShip(null);
        ttnkVMSelf.fiNameOfTransferShip(null);
        ttnkVMSelf.fiCodeOfTransferShip(null);
        ttnkVMSelf.fiOriginationOfTransferShip(null);
        ttnkVMSelf.fiNameOfContainerShip(null);
        ttnkVMSelf.fiCodeOfContainerShip(null);
        ttnkVMSelf.fiOriginationOfContainerShip(null);
        ttnkVMSelf.fiLoadingUnloadingPlace(null);
        ttnkVMSelf.fiLoadingUnLoadingTimeFrom(null);
        ttnkVMSelf.fiLoadingUnLoadingTimeTo(null);
        ttnkVMSelf.fiDateOfCatchFrom(null);
        ttnkVMSelf.fiDateOfCatchTo(null);
        ttnkVMSelf.fiLocationOfCatch(null);
        ttnkVMSelf.fiMethodCatch(null);

        ttnkVMSelf.productVM().fiGoodsList([]);
    }

    ttnkVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(ttnkVMSelf));
        data.fiGoodsList = ttnkVMSelf.productVM().fiGoodsList();
        var exclude = ['lstRequestOption', 'lstPurpose', 'lstCountry', 'lstPort', 'lstProfileStatus', 'productVM', 'ttnkVM', 'ttnkVM2', 'lstPurpose',
            'lstDepartment', 'lstCongVan', 'lstCVProduct', 'lstCVLocationQuaratine'
        ]
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.fiTransshipmentGoods = ttnkVMSelf.fiTransshipmentGoods() ? 1 : 0;
        data.fiDateOfQuarantineFrom = ttnkVMSelf.fiDateOfQuarantineFrom() ? ttnkVMSelf.fiDateOfQuarantineFrom().getTime() : null;
        data.fiDateOfQuarantineTo = ttnkVMSelf.fiDateOfQuarantineTo() ? ttnkVMSelf.fiDateOfQuarantineTo().getTime() : null;
        data.fiDateOfMonitorFrom = ttnkVMSelf.fiDateOfMonitorFrom() ? ttnkVMSelf.fiDateOfMonitorFrom().getTime() : null;
        data.fiDateOfMonitorTo = ttnkVMSelf.fiDateOfMonitorTo() ? ttnkVMSelf.fiDateOfMonitorTo().getTime() : null;
        data.fiDateOfCatchFrom = ttnkVMSelf.fiDateOfCatchFrom() ? ttnkVMSelf.fiDateOfCatchFrom().getTime() : null;
        data.fiDateOfCatchTo = ttnkVMSelf.fiDateOfCatchTo() ? ttnkVMSelf.fiDateOfCatchTo().getTime() : null;
        data.fiLoadingUnLoadingTimeFrom = ttnkVMSelf.fiLoadingUnLoadingTimeFrom() ? ttnkVMSelf.fiLoadingUnLoadingTimeFrom().getTime() : null;
        data.fiLoadingUnLoadingTimeTo = ttnkVMSelf.fiLoadingUnLoadingTimeTo() ? ttnkVMSelf.fiLoadingUnLoadingTimeTo().getTime() : null;
        return data;
    }
}
