/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    debugger;
    $("#sign17").hide();
    $("#sign18").hide();
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    
    //Thong tin chung
    self.registrationId = ko.observable(null);
    self.nswFilecode = ko.observable(null);
    self.nameOfRegistration = ko.observable(null);
    self.addressOfRegistration = ko.observable(null);
    self.tel = ko.observable(null);
    self.fax = ko.observable(null);
    self.email = ko.observable(null);
    self.noOfRegistration = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.typeProduct = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.nameTypeProduct = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.templateType = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.nameTemplateType = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.companyName = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.signAddress = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.signDate = ko.observable(null);
    self.signLocation = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.signName = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.isActive = ko.observable(null);
    self.codeStatus = ko.observable(null);
    self.nameStatus = ko.observable(null);
    self.createBy = ko.observable(null);
    self.reason = ko.observable(null);
    self.createDate = ko.observable(null);
    self.createDateText = ko.observable(null);
    self.banKhai17 = ko.observable(null);
    self.banKhai18 = ko.observable(null);
    self.lstHinhThucKT = ko.observableArray(mapCategory(options.hasOwnProperty('lstHinhThucKT') ? options.lstHinhThucKT : [], "fiMa", "fiTen"));
    self.lstLoaiDon = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiDon') ? options.lstLoaiDon : [], "fiMa", "fiTen"));
    self.lstLoaiSP = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiSP') ? options.lstLoaiSP : [], "fiMa", "fiTen"));
    self.lstDinhKem02 = ko.observableArray([]);
    var lydoVG = [self.reason]
    var hosoVG = [self.nameOfRegistration, self.addressOfRegistration, self.noOfRegistration, self.typeProduct, self.companyName
                , self.signAddress, self.signLocation, self.signName];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.lydoErrors = ko.validation.group(lydoVG, {deep: true, live: true, observable: true});
    self.htcErrors = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //upload templ
    self.fiTepTemp = ko.observable(null);
    self.canTemp = ko.computed(function () {
        return self.fiTepTemp() === null;
    }, this);

    self.canDeleteTemp = ko.computed(function () {
        return self.fiTepTemp() !== null;
    }, this);


    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        debugger;
        self.nameOfRegistration(hoso !== null && hoso.hasOwnProperty('nameOfRegistration') ? hoso.nameOfRegistration : user.companyName);
        self.addressOfRegistration(hoso !== null && hoso.hasOwnProperty('addressOfRegistration') ? hoso.addressOfRegistration : user.companyAddress);
        self.tel(hoso !== null && hoso.hasOwnProperty('tel') ? hoso.tel : user.companyPhoneNumber);
        if (hoso !== null) {
            self.registrationId(hoso.hasOwnProperty('registrationId') ? hoso.registrationId : null);
            self.nswFilecode(hoso.hasOwnProperty('nswFilecode') ? hoso.nswFilecode : null);
            self.nameOfRegistration(hoso.hasOwnProperty('nameOfRegistration') ? hoso.nameOfRegistration : null);
            self.addressOfRegistration(hoso.hasOwnProperty('addressOfRegistration') ? hoso.addressOfRegistration : null);
            self.tel(hoso.hasOwnProperty('tel') ? hoso.tel : null);
            self.fax(hoso.hasOwnProperty('fax') ? hoso.fax : null);
            self.email(hoso.hasOwnProperty('email') ? hoso.email : null);
            self.noOfRegistration(hoso.hasOwnProperty('noOfRegistration') ? hoso.noOfRegistration : null);
            self.typeProduct(hoso.hasOwnProperty('typeProduct') ? hoso.typeProduct : null);
            self.nameTypeProduct(hoso.hasOwnProperty('nameTypeProduct') ? hoso.nameTypeProduct : null);
            self.templateType(hoso.hasOwnProperty('templateType') ? hoso.templateType : null);
            self.nameTemplateType(hoso.hasOwnProperty('nameTemplateType') ? hoso.nameTemplateType : null);
            self.companyName(hoso.hasOwnProperty('companyName') ? hoso.companyName : null);
            self.signAddress(hoso.hasOwnProperty('signAddress') ? hoso.signAddress : null);
            self.signDate(hoso.hasOwnProperty('signDate') ? new Date(hoso.signDate) : null);
            self.signLocation(hoso.hasOwnProperty('signLocation') ? hoso.signLocation : null);
            self.signName(hoso.hasOwnProperty('signName') ? hoso.signName : null);
            self.isActive(hoso.hasOwnProperty('isActive') ? hoso.isActive : null);
            self.codeStatus(hoso.hasOwnProperty('codeStatus') ? hoso.codeStatus : null);
            self.nameStatus(hoso.hasOwnProperty('nameStatus') ? hoso.nameStatus : null);
            self.createBy(hoso.hasOwnProperty('createBy') ? hoso.createBy : null);
            self.reason(hoso.hasOwnProperty('reason') ? hoso.reason : null);
            self.createDate(hoso.hasOwnProperty('createDate') ? new Date(hoso.createDate) : null);
            self.lstDinhKem02(mapFiles02VM(hoso.hasOwnProperty('lstDinhKem02') ? hoso.lstDinhKem02 : [], self.registrationId()));
            if (self.templateType() == 17) {
                var otp17 = {
                    lstBanKhai17:hoso.hasOwnProperty('banKhai17') ? hoso.banKhai17 : [],
                    lstDvTinh: options.hasOwnProperty('lstDvTinh') ? options.lstDvTinh : []
                };
                self.banKhai17(new BanKhai17FormVM(otp17));
                self.banKhai18(new BanKhai18FormVM(options)); //khoi tao 1 form 18 null
                $("#regis17").show();
                $("#sign17").show();
            } else {
                var otp18 = {
                    lstBanKhai18:hoso.hasOwnProperty('banKhai18') ? hoso.banKhai18 : [],
                    lstDvTinh: options.hasOwnProperty('lstDvTinh') ? options.lstDvTinh : []
                };
                self.banKhai18(new BanKhai18FormVM(otp18));
                self.banKhai17(new BanKhai17FormVM(options)); //khoi tao 1 form 17 null
                $("#regis18").show();
                $("#sign18").show();
            }
            self.createDateText = ko.observable(self.createDate() ? new Date(self.createDate()).toDayFirstWithTime() : null);
        } else {
            self.banKhai17(new BanKhai17FormVM(options));
            self.banKhai18(new BanKhai18FormVM(options));
            getDmTeptin();
        }
    };

    function getDmTeptin() {
        app.getCategory('/mard/p02/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                self.lstDinhKem02(mapFiles02VM(res.data, self.registrationId()));
            } else {
                self.lstDinhKem02([]);
            }
        });
    }

    self.init(hosoInfo);

//XU LY SU KIEN BUTTON, TABLE
//    validate md nk khac
    // validate dinh dang email
    self.changeTypeRegis = function () {
        $("#regis17").hide();
        $("#regis18").hide();
        $("#sign17").hide();
        $("#sign18").hide();
        if (self.templateType() == 17) {
            $("#regis17").show();
            $("#sign17").show();
        } else {
            $("#regis18").show();
            $("#sign18").show();
        }

    };

    self.validFile = function () {
        var errorDinhkem = true;
        if (!self.lstDinhKem02() || self.lstDinhKem02().length <= 0) {
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.lstDinhKem02() && self.lstDinhKem02().length > 0) {
            for (var i = 0; i < self.lstDinhKem02().length; i++) {
                var attach = self.lstDinhKem02()[i];
                if (attach.isRequired()) {
                    if (!attach.fileId() || !attach.fileName()) {
                        $("#dinhkem_valid").show();
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }
        return errorDinhkem;

    };
//VALIDATE DATA ON FORM
//Convert to json object
    self.isValidForm = function () {
        var errorHoso = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
        }
        return errorHoso;
    };
    self.toJSON = function () {

        var mapping = {

            ignore: ['init', 'isValidForm', 'pop', 'toJSON',
                'lstDonViTinh', 'lstHinhThucKT', 'lstLoaiDon', 'lstLoaiSP',
                'hosoErrors', 'lydoErrors', 'htcErrors', 'errorDinhKemMessage',
                'canTemp', 'canDeleteTemp', 'doDeleteTemp', 'fiTepTemp', 'changeTypeRegis', 'createDateText', 'validFile'
            ]
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        for (var i = 0; i < copy.lstDinhKem02.length; i++) {
            delete copy.lstDinhKem02[i]['canUpload'];
            delete copy.lstDinhKem02[i]['canDownload'];
            delete copy.lstDinhKem02[i]['canDelete'];
            delete copy.lstDinhKem02[i]['doUpload'];
            delete copy.lstDinhKem02[i]['doDelete'];
            delete copy.lstDinhKem02[i]['downloadUrl'];
            delete copy.lstDinhKem02[i]['isRequire'];
            delete copy.lstDinhKem02[i]['isRequired'];
            delete copy.lstDinhKem02[i]['attachmentId'];
            delete copy.lstDinhKem02[i]["__ko_mapping__"];
        }


        delete copy['__ko_mapping__'];
        return copy;
    };
}
;
function BanKhai17FormVM(options) {
    var self = this;
    var bankhai17 = options.lstBanKhai17;
    self.regisGood17Id = ko.observable(bankhai17 ? bankhai17.regisGood17Id : null);
    self.nswFilecode = ko.observable(bankhai17 ? bankhai17.nswFilecode : null);
    self.testMethod = ko.observable(bankhai17 ? bankhai17.testMethod : null);
    self.registrationId = ko.observable(bankhai17 ? bankhai17.registrationId : null);
    self.totalQuantity = ko.observable(bankhai17 ? bankhai17.totalQuantity : null);
    self.importGate = ko.observable(bankhai17 ? bankhai17.importGate : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.exportGate = ko.observable(bankhai17 ? bankhai17.exportGate : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.executionTime = ko.observable(bankhai17 ? bankhai17.executionTime : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.stayTime = ko.observable(bankhai17 ? bankhai17.stayTime : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.route = ko.observable(bankhai17 ? bankhai17.route : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.attachedDoc = ko.observable(bankhai17 ? bankhai17.attachedDoc : null);
    // self.ctyTu17 = ko.observable(new CtyTu17Form(options));
    // self.ctyDen17 = ko.observable(new CtyDen17Form(options));
    self.ctyTu17 = ko.observableArray(MapCtyTu17(bankhai17 ? bankhai17.ctyTu17 : null));
    self.ctyDen17 = ko.observableArray(MapCtyDen17(bankhai17 ? bankhai17.ctyDen17 : null));

    self.lstDvTinh = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTinh') ? options.lstDvTinh : [], "quantityUnitCode", "quantityUnitName"));
    self.lstHangHoa17 = ko.observableArray(MapHangHoa17(bankhai17 ? bankhai17.lstHangHoa17 : null));
    var banKhaiVG = [self.executionTime, self.stayTime, self.route, self.importGate, self.exportGate];
    self.banKhaiErrors = ko.validation.group(banKhaiVG, {deep: true, live: true, observable: true});
    self.toJSON = function () {

        var exclude = ['toJSON', 'btnAddNewClickHH', "removePopupHH", "fiStt"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    //HuongMK
    self.btnAddNewClickCtyTu = function(){
        var item = new ctyTu17({
            fiStt: self.ctyTu17().length + 1,
            fromCompanyId: -1 * new Date().getTime()
        });
        self.ctyTu17.push(item);
    }
    self.btnAddNewClickCtyDen = function(){
        var item = new ctyDen17 ({
            fiStt: self.ctyDen17().length + 1,
            toCompanyId: -1 * new Date().getTime()
        });
        self.ctyDen17.push(item);
    }

    self.countSoluongHH = function(item) {
        var count = 0;
        for (var i = 0; i < self.lstHangHoa17().length; i++) {
            if (self.lstHangHoa17()[i].quantily() !== undefined && self.lstHangHoa17()[i].quantily() !== "") {
                count = count + parseInt(self.lstHangHoa17()[i].quantily(), 10);
            } else {
                count = count + 0;
            }
        }
        self.totalQuantity(count);
    }
    //HuongMK

    self.btnAddNewClickHH = function () {
        var item = new hanghoa17({
            goodSort: self.lstHangHoa17().length + 1,
            goodId: -1 * new Date().getTime()
        });
        self.lstHangHoa17.push(item);
        $("#quantityUnitCode-" + item.goodSort()).select2({placeholder: '--- Chọn ---', width: '100%', allowClear: true});
    };

    self.removePopupHH = function (item) {
        self.lstHangHoa17.remove(function (o) {
            return o.goodId() === item.goodId();
        });
        for (var i = 0; i < self.lstHangHoa17().length; i++) {
            self.lstHangHoa17()[i].goodSort(i + 1);
        }
    };

    self.removePopupCtyTu17 = function (item) {
        self.ctyTu17.remove(function (o) {
            return o.fromCompanyId() === item.fromCompanyId();
        });
        for (var i = 0; i < self.ctyTu17().length; i++) {
            self.ctyTu17()[i].fiStt(i+1);
        }
    };

    self.removePopupCtyDen17 = function (item) {
        self.ctyDen17.remove(function (o) {
            return o.toCompanyId() === item.toCompanyId();
        });
        for (var i = 0; i < self.ctyDen17().length; i++) {
            self.ctyDen17()[i].fiStt(i+1);
        }
    }

    self.isValid = function () {
        var errorHH = true;
        if (!self.lstHangHoa17() || self.lstHangHoa17().length <= 0) {
            $('#hh_valid').show();
            errorHH = false;
        }
        if (self.lstHangHoa17() && self.lstHangHoa17().length > 0) {
            for (var i = 0; i < self.lstHangHoa17().length; i++) {
                var hh = self.lstHangHoa17()[i];
                if (!hh.goodName() || hh.goodName().trim() == "") {
                    $("#goodName_" + hh.fiStt()).show();
                    errorHH = false;
                }
                if (!hoadon.quantily()) {
                    $("#quantily_" + hh.fiStt()).show();
                    errorHH = false;
                }

                if (!hoadon.quantityUnitName() || hh.quantityUnitName().trim() == "") {
                    $("#quantityUnitName_" + hh.fiStt()).show();
                    errorHH = false;
                }
                if (!hoadon.exporterState() || hh.exporterState().trim() == "") {
                    $("#exporterState_" + hh.fiStt()).show();
                    errorHH = false;
                }
            }
        }
        if (self.banKhaiErrors().length > 0) {
            self.banKhaiErrors.showAllMessages();
            errorHH = false;
        }
        return  errorHH;
    };

}
;
function HangHoa17Form(options) {
    var self = this;
    var hangHoa = options.lstBanKhai17.lstHangHoa17;
    self.goodId = ko.observable(hangHoa ? hangHoa.goodId : null);
    // self.fiStt = ko.observable(hangHoa ? hangHoa.fiStt : null);
    self.goodSort = ko.observable(hangHoa ? hangHoa.goodSort : null);
    self.goodName = ko.observable(hangHoa ? hangHoa.goodName : null);
    self.quantily = ko.observable(hangHoa ? hangHoa.quantily : null);
    self.quantityUnitCode = ko.observable(hangHoa ? hangHoa.quantityUnitCode : null);
    self.quantityUnitName = ko.observable(hangHoa ? hangHoa.quantityUnitName : null);
    self.exporterState = ko.observable(hangHoa ? hangHoa.exporterState : null);
    self.regisGood17Id = ko.observable(hangHoa ? hangHoa.regisGood17Id : null);
    self.regisGood18Id = ko.observable(hangHoa ? hangHoa.regisGood18Id : null);

    self.toJSON = function () {

        var exclude = ["toJSON", "fiStt", ];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

}
;
function CtyTu17Form(data) {
    var self = this;
    var ctyTu = data && data.lstBanKhai17 ? data.lstBanKhai17.ctyTu17 : null;
    self.fromCompanyId = ko.observable(ctyTu ? ctyTu.fromCompanyId : null);
    self.fromCompanyName = ko.observable(ctyTu ? ctyTu.fromCompanyName : null);
    self.fromCompanyAddress = ko.observable(ctyTu ? ctyTu.fromCompanyAddress : null);
    self.regisGood17Id = ko.observable(ctyTu ? ctyTu.regisGood17Id : null);
    self.regisGood18Id = ko.observable(ctyTu ? ctyTu.regisGood18Id : null);
}
;

function CtyDen17Form(data) {
    var self = this;
    var CtyDen = data && data.lstBanKhai17 ? data.lstBanKhai17.ctyDen17 : null;
    self.toCompanyId = ko.observable(CtyDen ? CtyDen.toCompanyId : null);
    self.toCompanyName = ko.observable(CtyDen ? CtyDen.toCompanyName : null);
    self.toCompanyAddress = ko.observable(CtyDen ? CtyDen.toCompanyAddress : null);
    self.regisGood17Id = ko.observable(CtyDen ? CtyDen.regisGood17Id : null);
    self.regisGood18Id = ko.observable(CtyDen ? CtyDen.regisGood18Id : null);
}
;

function BanKhai18FormVM(options) {
    var self = this;
    var bankhai18 = options.lstBanKhai18;
    self.regisGood18Id = ko.observable(bankhai18 ? bankhai18.regisGood18Id : null);
    self.nswFilecode = ko.observable(bankhai18 ? bankhai18.nswFilecode : null);
    self.registrationId = ko.observable(bankhai18 ? bankhai18.registrationId : null);
    self.importGate = ko.observable(bankhai18 ? bankhai18.importGate : null);
    self.purpose = ko.observable(bankhai18 ? bankhai18.purpose : null);
    self.executionTime = ko.observable(bankhai18 ? bankhai18.executionTime : null);
    self.attachedDoc = ko.observable(bankhai18 ? bankhai18.attachedDoc : null);
    self.exportGate = ko.observable(bankhai18 ? bankhai18.exportGate : null);
    self.totalQuantity = ko.observable(bankhai18 ? bankhai18.totalQuantity : null);
    self.route = ko.observable(bankhai18 ? bankhai18.route : null);
    self.lstHangHoa18 = ko.observableArray(MapHangHoa17(bankhai18 ? bankhai18.lstHangHoa18 : null));
    self.ctyTu18 = ko.observableArray(MapCtyTu18(bankhai18 ? bankhai18.ctyTu18 : null));
    self.ctyDen18 = ko.observableArray(MapCtyDen18(bankhai18 ? bankhai18.ctyDen18 : null));

    self.lstDvTinh = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTinh') ? options.lstDvTinh : [], "quantityUnitCode", "quantityUnitName"));
    self.lstNgoaiQuan18 = ko.observableArray(MapKhoNgoai18(bankhai18 ? bankhai18.lstNgoaiQuan18 : null));
    var banKhai18VG = [];
    self.banKhai18Errors = ko.validation.group(banKhai18VG, {deep: true, live: true, observable: true});
    self.toJSON = function () {

        var exclude = ["btnAddNewClickHH", "btnAddNewClickKN", "removePopupKN", "toJSON", "fiStt"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.countSoluongHH18 = function(item) {
        var count = 0;
        for (var i = 0; i < self.lstHangHoa18().length; i++) {
            if (self.lstHangHoa18()[i].quantily() !== undefined && self.lstHangHoa18()[i].quantily() !== "") {
                count = count + parseInt(self.lstHangHoa18()[i].quantily(), 10);
            } else {
                count = count + 0;
            }
        }
        self.totalQuantity(count);
    }

    //HuongMK
    self.btnAddNewClickCtyTu18 = function(){
        var item = new ctyTu17({
            fiStt: self.ctyTu18().length + 1,
            fromCompanyId: -1 * new Date().getTime()
        });
        self.ctyTu18.push(item);
    };

    self.removePopupCtyTu18 = function (item) {
        self.ctyTu18.remove(function (o) {
            return o.fromCompanyId() === item.fromCompanyId();
        });
        for (var i = 0; i < self.ctyTu18().length; i++) {
            self.ctyTu18()[i].fiStt(i + 1);
        }
    };

    self.btnAddNewClickCtyDen18 = function(){
        var item = new ctyDen17 ({
            fiStt: self.ctyDen18().length + 1,
            toCompanyId: -1 * new Date().getTime()
        });
        self.ctyDen18.push(item);
    };

    self.removePopupCtyDen18 = function (item) {
        self.ctyDen18.remove(function (o) {
            return o.toCompanyId() === item.toCompanyId();
        });
        for (var i = 0; i < self.ctyDen18().length; i++) {
            self.ctyDen18()[i].fiStt(i + 1);
        }
    };
    //HuongMK

    self.btnAddNewClickHH = function () {
        var item = new hanghoa17({
            goodSort: self.lstHangHoa18().length + 1,
            goodId: -1 * new Date().getTime()
        });
        self.lstHangHoa18.push(item);
        $("#quantityUnitCode-" + item.goodSort()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.removePopupHH = function (item) {
        self.lstHangHoa18.remove(function (o) {
            return o.goodId() === item.goodId();
        });
        for (var i = 0; i < self.lstHangHoa18().length; i++) {
            self.lstHangHoa18()[i].fiStt(i + 1);
        }
    };

    self.btnAddNewClickKN = function () {
        var item = new khoNgoai18({
            fiStt: self.lstNgoaiQuan18().length + 1,
            bondedListId: -1 * new Date().getTime()
        });
        self.lstNgoaiQuan18.push(item);
    };
    self.removePopupKN = function (item) {
        self.lstNgoaiQuan18.remove(function (o) {
            return o.bondedListId() === item.bondedListId();
        });
        for (var i = 0; i < self.lstNgoaiQuan18().length; i++) {
            self.lstNgoaiQuan18()[i].fiStt(i + 1);
        }
    };
    
    self.isValid = function () {
        
    }
}
;

function KhoNgoai18Form(options) {
    var self = this;
    var khoNgoai = options.lstBanKhai18;
    self.fiStt = ko.observable(khoNgoai ? khoNgoai.fiStt : null);
    self.bondedListId = ko.observable(khoNgoai ? khoNgoai.bondedListId : null);
    self.bondedName = ko.observable(khoNgoai ? khoNgoai.bondedName : null);
    self.certificateNo = ko.observable(khoNgoai ? khoNgoai.certificateNo : null);
    self.certificateDate = ko.observable(khoNgoai ? new Date(khoNgoai.certificateDate) : null);
    self.certificateDateValid = ko.observable(khoNgoai ? new Date(khoNgoai.certificateDateValid) : null);
    self.contractNo = ko.observable(khoNgoai ? khoNgoai.contractNo : null);
    self.contractDate = ko.observable(khoNgoai ? new Date(khoNgoai.contractDate) : null);
    self.contractDateValid = ko.observable(khoNgoai ? new Date(khoNgoai.contractDateValid) : null);
    self.regisGood18Id = ko.observable(khoNgoai ? khoNgoai.regisGood18Id : null);
}
;

function CtyTu18Form(data) {
    var self = this;
    var ctyTu = data && data.lstBanKhai18 ? data.lstBanKhai18.ctyTu18 : null;
    self.fromCompanyId = ko.observable(ctyTu ? ctyTu.fromCompanyId : null);
    self.fromCompanyName = ko.observable(ctyTu ? ctyTu.fromCompanyName : null);
    self.fromCompanyAddress = ko.observable(ctyTu ? ctyTu.fromCompanyAddress : null);
    self.regisGood17Id = ko.observable(ctyTu ? ctyTu.regisGood17Id : null);
    self.regisGood18Id = ko.observable(ctyTu ? ctyTu.regisGood18Id : null);
}
;

function CtyDen18Form(data) {
    var self = this;
    var CtyDen = data && data.lstBanKhai18 ? data.lstBanKhai18.ctyDen18 : null;
    self.toCompanyId = ko.observable(CtyDen ? CtyDen.toCompanyId : null);
    self.toCompanyName = ko.observable(CtyDen ? CtyDen.toCompanyName : null);
    self.toCompanyAddress = ko.observable(CtyDen ? CtyDen.toCompanyAddress : null);
    self.regisGood17Id = ko.observable(CtyDen ? CtyDen.regisGood17Id : null);
    self.regisGood18Id = ko.observable(CtyDen ? CtyDen.regisGood18Id : null);
}
;




    