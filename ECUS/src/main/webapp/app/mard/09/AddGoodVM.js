var AddGoodVM = function(data, onAddProduct) {
    var self = this;
    self.productType = ko.observable(data.fiQuarantineType);//1 dong vat, 2 sp dong vat, 3 bot thit xuong
    var goods = mapTbdGoods03(data.lstProduct);
    var mapGoods = {};
    var mapUOMs = {};
    data.lstProduct.forEach(function (value) {
        mapGoods[value.fiProductCode] = value;
    });

    data.lstUOMs.forEach(function(value) {
        mapUOMs[value.unitcode] = value.unitname
    });

    self.lstUOMs = ko.observable((data && data.hasOwnProperty('lstUOMs')) ? data.lstUOMs : []);
    self.listGood = ko.observableArray(goods);
    self.fiUnitCode = ko.observable(null);
    self.fiProductCode = ko.observable(null).trimmed();
    self.fiProductName = ko.observable(null).trimmed();
    self.fiProductScienceName = ko.observable(null).trimmed();
    self.fiQtyFemale = ko.observable(0).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiQtyMale = ko.observable(0).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiQtyFemaleFixed = ko.observable(0).trimmed();
    self.fiQtyMaleFixed = ko.observable(0).trimmed();
    self.fiAge = ko.observable(null).trimmed();
    self.fiNumber = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiNetWeight = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiNetWeightFixed = ko.observable(null).trimmed();
    self.fiPackingType = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiUnitCode = ko.observable(null).trimmed();
    self.fiUnitName = ko.observable(null).trimmed();
    self.fiNWUnitCode = ko.observable(null).trimmed();
    self.fiNWUnitName = ko.observable(null).trimmed();
    self.fiGrossWeight = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiGWUnitName = ko.observable(null).trimmed();
    self.fiGWUnitCode = ko.observable(null).trimmed();
    self.fiPurpose = ko.observable(null).trimmed();
    self.fiCountryOriginName = ko.observable(null).trimmed();
    self.fiCountryOrigin = ko.observable(null).trimmed();
    self.fiPortCode = ko.observable(null).trimmed();
    self.fiPortName = ko.observable(null).trimmed();
    self.errorMsg = ko.observable(null).trimmed();

    self.isShowNumberLimit = ko.observable(false);
    self.isShowNetWeightLimit = ko.observable(false);
    self.isShowGrossWeightLimit = ko.observable(false);

    self.fiUnitCode.subscribe(function(value) {
        self.fiUnitName(mapUOMs[value]);
    });

    self.fiNWUnitCode.subscribe(function(value) {
        self.fiNWUnitName(mapUOMs[value]);
        self.fiGWUnitCode(value);
    });

    self.fiGWUnitCode.subscribe(function(value) {
        self.fiGWUnitName(mapUOMs[value]);
    });



    function validateData()  {
        if (data.fiQuarantineType === 1) {
            return self.fiQtyMale.isValid()
                && self.fiQtyFemale.isValid();
        } else {
            return self.fiNumber.isValid()
                && self.fiNetWeight.isValid()
                && self.fiGrossWeight.isValid();
        }
    }


    self.isDisableAddButton = ko.observable(false);

    self.onClose = function() {
        self.fiProductCode(null);
        self.fiProductName(null);
        self.fiProductScienceName(null);
        self.fiQtyFemale(null);
        self.fiQtyMale(null);
        self.fiQtyFemaleFixed(null);
        self.fiQtyMaleFixed(null);
        self.fiAge(null);
        self.fiNumber(null);
        self.fiNetWeight(null);
        self.fiPackingType(null);
        self.fiUnitCode(null);
        self.fiUnitName(null);
        self.fiNWUnitCode(null);
        self.fiNWUnitName(null);
        self.fiGrossWeight(null);
        self.fiGWUnitName(null);
        self.fiGWUnitCode(null);
        self.fiPurpose(null);
        self.fiCountryOriginName(null);
        self.fiCountryOrigin(null);
        self.fiPortCode(null);
        self.fiPortName(null);
        self.errorMsg(null);
        self.fiNetWeightFixed(null);

    };

    self.addProduct = function () {
        if (validateData()) {
            var data = ko.toJS(self);
            var good = goods[$("#frmMaHangHoa03").prop('selectedIndex') - 1];

            self.errorMsg(null);

            var excludeForProduct = ["addProduct", "onChooseGood", "fiQtyFemaleFixed",
                "fiQtyMaleFixed", "listGood", "errorMsg", "isDisableAddButton", "setValidationForNumberInput", "update"];


            for (var key in data) {
                if (excludeForProduct.indexOf(key) >= 0) {
                    delete data[key];
                }
            }
            self.fiProductCode(null);
            self.fiProductName(null);
            self.fiProductScienceName(null);
            self.fiQtyFemale(null);
            self.fiQtyMale(null);
            self.fiQtyFemaleFixed(null);
            self.fiQtyMaleFixed(null);
            self.fiAge(null);
            self.fiNumber(null);
            self.fiNetWeight(null);
            self.fiNetWeightFixed(null);
            self.fiPackingType(null);
            self.fiUnitCode(null);
            self.fiUnitName(null);
            self.fiNWUnitCode(null);
            self.fiNWUnitName(null);
            self.fiGrossWeight(null);
            self.fiGWUnitName(null);
            self.fiGWUnitCode(null);
            self.fiPurpose(null);
            self.fiCountryOriginName(null);
            self.fiCountryOrigin(null);
            self.fiPortCode(null);
            self.fiPortName(null);
            self.errorMsg(null);
            $("#frmMaHangHoa03").prop('selectedIndex', 0);
            onAddProduct(data);
            $("#modal_addGood03").modal('toggle')
        } else {
            self.errorMsg("Vui lòng điền các trường thôn tin bắt buộc");
        }
    };

    self.update = function(index, data) {
        self.fiProductCode(data.fiProductCode());
        self.fiProductName(data.fiProductName());
        self.fiProductScienceName(data.fiProductScienceName());
        self.fiQtyFemale(!data.fiQtyFemale() ? 0 : data.fiQtyFemale());
        self.fiQtyMale(data.fiQtyMale());
        self.fiQtyFemaleFixed(mapGoods[data.fiProductCode()].fiQtyFemale);
        self.fiQtyMaleFixed(mapGoods[data.fiProductCode()].fiQtyMale);
        self.fiAge(data.fiAge());
        self.fiNetWeight(Number(data.fiNetWeight()));
        self.fiNumber(Number(data.fiNumber()));
        self.fiPackingType(data.fiPackingType());
        self.fiUnitCode(data.fiUnitCode());
        self.fiUnitName(data.fiUnitName());
        self.fiNWUnitCode(data.fiNWUnitCode());
        self.fiNWUnitName(data.fiNWUnitName());
        self.fiGrossWeight(Number(data.fiGrossWeight()));
        self.fiGWUnitCode(data.fiNWUnitCode());
        self.fiGWUnitName(data.fiNWUnitName());
        self.fiPurpose(data.fiPurpose());
        self.fiCountryOriginName(data.fiCountryOriginName());
        self.fiCountryOrigin(data.fiCountryOrigin());
        self.fiPortCode(data.fiPortCode());
        self.fiPortName(data.fiPortName());

        self.fiNetWeightFixed(mapGoods[data.fiProductCode()].fiNetWeight);

        self.fiQtyFemale.clearError();
        self.fiQtyMale.clearError();
        self.fiNumber.clearError();
        self.fiNetWeight.clearError();
        self.fiGrossWeight.clearError();
        if (data.fiQuarantineType == 1) {
            self.setValidationForNumberInput("fiQtyFemale", self.fiQtyFemaleFixed(), 0);
            self.setValidationForNumberInput("fiQtyMale", self.fiQtyMaleFixed(), 0);
        } else {
            self.setValidationForNumberInput("fiNetWeight", self.fiNetWeightFixed(), 0);
        }
    };

    self.setValidationForNumberInput = function(nameOfField, maxValue, minValue) {
        self[nameOfField].rules.remove(function (item) {
            return item.rule == "min";
        });
        self[nameOfField].rules.remove(function (item) {
            return item.rule == "max";
        });
        self[nameOfField].extend({
            min: {
                params: Number(minValue),
                message: "Giá trị cần lớn hơn " + minValue
            }
        }).extend({
            max: {
                params: Number(maxValue),
                message: "Giá trị cần nhỏ hơn " + maxValue
            }
        });
    };


    self.onChooseGood = function () {
        if ($("#frmMaHangHoa03").prop('selectedIndex')) {

            var good = goods[$("#frmMaHangHoa03").prop('selectedIndex') - 1];
            self.fiProductCode(good.fiProductCode());
            self.fiProductName(good.fiProductName());
            self.fiProductScienceName(good.fiProductScienceName());
            if (data.fiQuarantineType == 1) {
                self.fiQtyFemaleFixed(good.fiQtyFemale());
                self.fiQtyMaleFixed(good.fiQtyMale());
                self.setValidationForNumberInput("fiQtyFemale", self.fiQtyFemaleFixed(), 0);
                self.setValidationForNumberInput("fiQtyMale", self.fiQtyMaleFixed(), 0);

                self.fiAge(good.fiAge());
                self.fiQtyFemale(good.fiQtyFemale());
                self.fiQtyMale(good.fiQtyMale());

            } else {
                self.fiNetWeightFixed(good.fiNetWeight());
                self.fiPackingType(good.fiPackingType());
                self.fiNumber(good.fiNumber());
                self.fiUnitCode(good.fiUnitCode());
                self.fiUnitName(good.fiUnitName());
                self.fiNetWeight(good.fiNetWeight());
                self.fiNWUnitCode(good.fiNWUnitCode());
                self.fiNWUnitName(good.fiNWUnitName());

                self.fiGrossWeight(good.fiGrossWeight());
                self.fiGWUnitName(good.fiNWUnitName());
                self.fiGWUnitCode(good.fiNWUnitCode());

                if (good.fiNumber() < 0) {
                    self.fiNumber(null);
                } else {
                    self.fiNumber(good.fiNumber());
                }

                if (good.fiNetWeight() < 0) {
                    self.fiGrossWeight(null);
                } else {
                    self.fiGrossWeight(good.fiGrossWeight());
                }

                if (good.fiGrossWeight() < 0) {
                    self.fiGrossWeight(null);
                } else {
                    self.fiGrossWeight(good.fiGrossWeight());
                }

                self.setValidationForNumberInput("fiNetWeight", self.fiNetWeightFixed(), 0);

            }

            self.fiPurpose(good.fiPurpose());
            self.fiCountryOrigin(good.fiCountryOrigin());
            self.fiCountryOriginName(good.fiCountryOriginName());
            self.fiPortCode(good.fiPortCode());
            self.fiPortName(good.fiPortName());
        } else {
            self.fiProductCode(null);
            self.fiProductName(null);
            self.fiProductScienceName(null);
            self.fiQtyFemale(null);
            self.fiQtyMale(null);
            self.fiQtyFemaleFixed(null);
            self.fiQtyMaleFixed(null);
            self.fiAge(null);
            self.fiNumber(null);
            self.fiNetWeight(null);
            self.fiPackingType(null);
            self.fiUnitCode(null);
            self.fiUnitName(null);
            self.fiNWUnitCode(null);
            self.fiNWUnitName(null);
            self.fiGrossWeight(null);
            self.fiGWUnitName(null);
            self.fiGWUnitCode(null);
            self.fiPurpose(null);
            self.fiCountryOriginName(null);
            self.fiCountryOrigin(null);
            self.fiPortCode(null);
            self.fiPortName(null);
            self.errorMsg(null);
            self.fiNetWeightFixed(null);
        }
    };
};
