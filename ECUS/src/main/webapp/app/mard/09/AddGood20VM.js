var AddGood20VM = function(license, mapQuocgia, mapCuakhau, onAddProduct) {
    var self = this;

    self.productType = ko.observable(license.fiQuarantineType - 3);//1 dong vat, 2 sp dong vat, 3 bot thit xuong, 4 đồng thời động vật, 5 đồng thời sản phẩm động vật
    var goods = mapTbdGoods03(license.lstProduct);
    self.listGood = ko.observableArray(goods);
    var mapGoods = {};
    license.lstProduct.forEach(function (value) {
        mapGoods[value.fiProductCode] = value;
    });
    self.fiProductCode = ko.observable(null).trimmed();
    self.fiProductName = ko.observable(null).trimmed();
    self.fiProductScienceName = ko.observable(null).trimmed();
    self.fiQtyFemale = ko.observable(0).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiQtyMale = ko.observable(0).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiQtyFemaleFixed = ko.observable(0).trimmed();
    self.fiQtyMaleFixed = ko.observable(0).trimmed();
    self.fiAge = ko.observable(null).trimmed();
    self.fiNumber = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiNumberFixed = ko.observable(null).trimmed();
    self.fiNetWeight = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiNetWeightFixed = ko.observable(null).trimmed();
    self.fiPackingType = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiUnitCode = ko.observable(null).trimmed();
    self.fiUnitName = ko.observable(null).trimmed();
    self.fiNWUnitCode = ko.observable(null).trimmed();
    self.fiNWUnitName = ko.observable(null).trimmed();
    self.fiGrossWeight = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiGrossWeightFixed = ko.observable(null).trimmed();
    self.fiGWUnitName = ko.observable(null).trimmed();
    self.fiGWUnitCode = ko.observable(null).trimmed();
    self.fiPurpose = ko.observable(null).trimmed();
    self.fiCountryOriginName = ko.observable(null).trimmed();
    self.fiCountryOrigin = ko.observable(null).trimmed();
    self.fiPortCode = ko.observable(null).trimmed();
    self.fiPortName = ko.observable(null).trimmed();
    self.fiCirculateNo = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.errorMsg = ko.observable(null).trimmed();

    self.isDisableAddButton = ko.observable(false);

    function validateData()  {
        if (license.fiQuarantineType === 4) {
            return self.fiQtyMale.isValid()
                && self.fiQtyFemale.isValid()
                && self.fiCirculateNo.isValid();
        } else {
            return self.fiNumber.isValid()
                && self.fiNetWeight.isValid()
                && self.fiGrossWeight.isValid()
                && self.fiCirculateNo.isValid()
                && self.fiPackingType.isValid();
        }
    }

    self.update = function(index, data) {
        self.fiProductCode(data.fiProductCode());
        self.fiProductName(data.fiProductName());
        self.fiProductScienceName(data.fiProductScienceName());
        self.fiQtyFemale(!data.fiQtyFemale() ? 0 : data.fiQtyFemale());
        self.fiQtyMale(data.fiQtyMale());
        self.fiQtyFemaleFixed(mapGoods[data.fiProductCode()].fiQtyFemale);
        self.fiQtyMaleFixed(mapGoods[data.fiProductCode()].fiQtyMale);
        self.fiAge(data.fiAge());
        self.fiNumber(data.fiNumber());
        self.fiNetWeight(data.fiNetWeight());
        self.fiPackingType(data.fiPackingType());
        self.fiUnitCode(data.fiUnitCode());
        self.fiUnitName(data.fiUnitName());
        self.fiNWUnitCode(data.fiNWUnitCode());
        self.fiNWUnitName(data.fiNWUnitName());
        self.fiGrossWeight(data.fiGrossWeight());
        self.fiGWUnitName(data.fiGWUnitName());
        self.fiGWUnitCode(data.fiGWUnitCode());
        self.fiPurpose(data.fiPurpose());
        self.fiCountryOriginName(data.fiCountryOriginName());
        self.fiCountryOrigin(data.fiCountryOrigin());
        self.fiPortCode(data.fiPortCode());
        self.fiPortName(data.fiPortName());
        self.fiNumberFixed(mapGoods[data.fiProductCode()].fiNumber);
        self.fiNetWeightFixed(mapGoods[data.fiProductCode()].fiNetWeight);
        self.fiGrossWeightFixed(mapGoods[data.fiProductCode()].fiGrossWeight);
        self.fiCirculateNo(data.fiCirculateNo());
        self.fiQtyFemale.clearError();
        self.fiQtyMale.clearError();
        self.fiNumber.clearError();
        self.fiNetWeight.clearError();
        self.fiGrossWeight.clearError();
        if (license.fiQuarantineType == 1 || license.fiQuarantineType == 4) {
            self.setValidationForNumberInput("fiQtyFemale", self.fiQtyFemaleFixed(), 0);
            self.setValidationForNumberInput("fiQtyMale", self.fiQtyMaleFixed(), 0);
        } else {
            self.setValidationForNumberInput("fiNumber", self.fiNumberFixed(), 0);
            self.setValidationForNumberInput("fiNetWeight", self.fiNetWeightFixed(), 0);
            self.setValidationForNumberInput("fiGrossWeight", self.fiGrossWeightFixed(), 0);

        }
        self.errorMsg(data.errorMsg);
    };

    self.addProduct = function () {
        if (validateData()) {
            var data = ko.toJS(self);
            // var good = goods[$("#frmMaHangHoa").prop('selectedIndex') - 1];
            //
            // good.fiCirculateNo = self.fiCirculateNo();

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
            self.fiCirculateNo(null);
            self.errorMsg(null);
            $("#frmMaHangHoa").prop('selectedIndex',0);
            onAddProduct(data);
            $("#modal_addGood").modal('toggle')
        } else {
            self.errorMsg("Vui lòng điền các trường thông tin bắt buộc");
        }
    };

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
        self.fiCirculateNo(null);
        self.errorMsg(null);
        self.fiNumberFixed(null);
        self.fiNetWeightFixed(null);
        self.fiGrossWeightFixed(null);
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
                params: minValue,
                message: "Giá trị cần lớn hơn " + minValue
            }
        }).extend({
            max: {
                params: maxValue,
                message: "Giá trị cần nhỏ hơn " + maxValue
            }
        });
    };


    self.onChooseGood = function () {
        if ($("#frmMaHangHoa").prop('selectedIndex')) {
            var good = goods[$("#frmMaHangHoa").prop('selectedIndex') - 1];
            self.fiProductCode(good.fiProductCode());
            self.fiProductName(good.fiProductName());
            self.fiProductScienceName(good.fiProductScienceName());

            if (license.fiQuarantineType == 1 || license.fiQuarantineType == 4) {
                self.fiAge(good.fiAge());
                self.fiQtyFemale(!good.fiQtyFemale() ? 0 : good.fiQtyFemale());
                self.fiQtyMale(good.fiQtyMale());
                self.fiQtyFemaleFixed(good.fiQtyFemale());
                self.fiQtyMaleFixed(good.fiQtyMale());

                self.setValidationForNumberInput("fiQtyFemale", self.fiQtyFemaleFixed(), 0);
                self.setValidationForNumberInput("fiQtyMale", self.fiQtyMaleFixed(), 0);
            } else {
                self.fiPackingType(good.fiPackingType());
                self.fiNumber(good.fiNumber());
                self.fiUnitCode(good.fiUnitCode());
                self.fiUnitName(good.fiUnitName());
                self.fiNetWeight(good.fiNetWeight());
                self.fiNWUnitCode(good.fiNWUnitCode());
                self.fiNWUnitName(good.fiNWUnitName());


                self.fiNumberFixed(good.fiNumber());
                self.fiNetWeightFixed(good.fiNetWeight());
                self.fiGrossWeightFixed(good.fiGrossWeight());

                self.setValidationForNumberInput("fiNumber", self.fiNumberFixed(), 0);
                self.setValidationForNumberInput("fiNetWeight", self.fiNetWeightFixed(), 0);
                self.setValidationForNumberInput("fiGrossWeight", self.fiGrossWeightFixed(), 0);

                self.fiGrossWeight(good.fiGrossWeight());
                self.fiGWUnitName(good.fiGWUnitName());
                self.fiGWUnitCode(good.fiGWUnitCode());

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
            self.fiCirculateNo(null);
            self.errorMsg(null);
            self.fiNumberFixed(null);
            self.fiNetWeightFixed(null);
            self.fiGrossWeightFixed(null);
        }
    };
};