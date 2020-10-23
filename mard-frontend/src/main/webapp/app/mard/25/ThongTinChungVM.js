function ThongTinChungVM(data) {
    var ttcVMSelf = this;

    ttcVMSelf.errors = ko.validation.group(ttcVMSelf, {deep: true});

    ttcVMSelf.fiHSStatus = ko.observable((data && data.hasOwnProperty('fiHSStatus')) ? data.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((data && data.hasOwnProperty('fiHSCreatedDate')) ? new Date(data.fiHSCreatedDate) : new Date());
    ttcVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null);
    ttcVMSelf.fiNSWFileCodeReplace = ko.observable((data && data.hasOwnProperty('fiNSWFileCodeReplace')) ? data.fiNSWFileCodeReplace : null);
    ttcVMSelf.fiGDK = ko.observable((data && data.hasOwnProperty('fiGDK')) ? data.fiGDK : null);
    ttcVMSelf.fiGDKFile = ko.observable((data && data.hasOwnProperty('fiGDKFile')) ? data.fiGDKFile : null);

    ttcVMSelf.fiNSWFileCode = ko.observable((data && data.hasOwnProperty('fiNSWFileCode')) ? data.fiNSWFileCode : null);

    //inc_thongtindangky.jsp
    ttcVMSelf.fiSellName = ko.observable((data && data.hasOwnProperty('fiSellName')) ? data.fiSellName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    ttcVMSelf.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : null);
    ttcVMSelf.lstNhom = ko.observableArray((data && data.hasOwnProperty('lstNhom')) ? data.lstNhom : null);
    ttcVMSelf.lstPhanNhom = ko.observableArray((data && data.hasOwnProperty('lstPhanNhom')) ? data.lstPhanNhom : null);
    ttcVMSelf.lstLoai = ko.observableArray((data && data.hasOwnProperty('lstLoai')) ? data.lstLoai : null);
    ttcVMSelf.lstPhanLoai = ko.observableArray((data && data.hasOwnProperty('lstPhanLoai')) ? data.lstPhanLoai : null);
    ttcVMSelf.fiSellCountryCode = ko.observable((data && data.hasOwnProperty('fiSellCountryCode')) ? data.fiSellCountryCode : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSellCountryName = ko.observable((data && data.hasOwnProperty('fiSellCountryName')) ? data.fiSellCountryName : null);

    ttcVMSelf.fiSellAddress = ko.observable((data && data.hasOwnProperty('fiSellAddress')) ? data.fiSellAddress : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSellTel = ko.observable((data && data.hasOwnProperty('fiSellTel')) ? data.fiSellTel : null)  .extend({
        pattern: {
            params: '^0[1-9][0-9]{8,9}$',
            message: "Số điện thoại không hợp lệ."
        }
    });
    ttcVMSelf.fiSellFax = ko.observable((data && data.hasOwnProperty('fiSellFax')) ? data.fiSellFax : null) .extend({
        number: {param: true}
    });
    ttcVMSelf.fiSellExport = ko.observable((data && data.hasOwnProperty('fiSellExport')) ? data.fiSellExport : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiPurchName = ko.observable((data && data.hasOwnProperty('fiPurchName')) ? data.fiPurchName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiPurchTel = ko.observable((data && data.hasOwnProperty('fiPurchTel')) ? data.fiPurchTel : null).extend({
        pattern: {
            params: '^0[1-9][0-9]{8,9}$',
            message: "Số điện thoại không hợp lệ."
        }
    });
    ttcVMSelf.fiPurchAddress = ko.observable((data && data.hasOwnProperty('fiPurchAddress')) ? data.fiPurchAddress : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiPurchFax = ko.observable((data && data.hasOwnProperty('fiPurchFax')) ? data.fiPurchFax : null).extend({
        number: {params: true}
    });
    ttcVMSelf.fiPurchReci = ko.observable((data && data.hasOwnProperty('fiPurchReci')) ? data.fiPurchReci : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiPurchFromDate = ko.observable((data && data.hasOwnProperty('fiPurchFromDate')) ? new Date(data.fiPurchFromDate) : new Date());
    ttcVMSelf.fiPurchToDate = ko.observable((data && data.hasOwnProperty('fiPurchToDate')) ? new Date(data.fiPurchToDate) : null);

    ttcVMSelf.fiProductList = ko.observableArray((data && data.hasOwnProperty('fiProductList')) ? data.fiProductList : []);

    ttcVMSelf.fiProCVMienGiam = ko.observable((data && data.hasOwnProperty('fiProCVMienGiam')) ? data.fiProCVMienGiam : null);
    ttcVMSelf.fiProCVMienGiamNgay = ko.observable((data && data.hasOwnProperty('fiProCVMienGiamNgay')) ? new Date(data.fiProCVMienGiamNgay) : null);

    ttcVMSelf.fiProName = ko.observable((data && data.hasOwnProperty('fiProName')) ? data.fiProName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProCode = ko.observable((data && data.hasOwnProperty('fiProCode')) ? data.fiProCode : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProMadeIn = ko.observable((data && data.hasOwnProperty('fiProMadeIn')) ? data.fiProMadeIn : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProThanhPhan = ko.observable((data && data.hasOwnProperty('fiProThanhPhan')) ? data.fiProThanhPhan : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProColor = ko.observable((data && data.hasOwnProperty('fiProColor')) ? data.fiProColor : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProSoHieu = ko.observable((data && data.hasOwnProperty('fiProSoHieu')) ? data.fiProSoHieu : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProQuyChuan = ko.observable((data && data.hasOwnProperty('fiProQuyChuan')) ? data.fiProQuyChuan : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProCLList = ko.observableArray((data && data.hasOwnProperty('fiProCLList')) ? data.fiProCLList : []);
    ttcVMSelf.EfiProCLTarg = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLCompare = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLContent = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });

    ttcVMSelf.EfiProCLUnitID = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });


    ttcVMSelf.fiProValueVN  = ko.observable((data && data.hasOwnProperty('fiProValueVN ')) ? data.fiProValueVN  : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProValueUSD   = ko.observable((data && data.hasOwnProperty('fiProValueUSD  ')) ? data.fiProValueUSD  : null);

    ttcVMSelf.fiProATList = ko.observableArray((data && data.hasOwnProperty('fiProATList')) ? data.fiProATList : []).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATTarg = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATCompare = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATContent = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProATUnitID = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProSLKLList = ko.observableArray((data && data.hasOwnProperty('fiProSLKLList')) ? data.fiProSLKLList : []);
    ttcVMSelf.EfiProSLKLMass = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLMassTan = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLMassUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProSLKLAmount = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLAmountUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });


    ttcVMSelf.fiPackageUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignName = ko.observable((data && data.hasOwnProperty('fiSignName')) ? data.fiSignName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignPosition = ko.observable((data && data.hasOwnProperty('fiSignPosition')) ? data.fiSignPosition : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignAddress = ko.observable((data && data.hasOwnProperty('fiSignAddress')) ? data.fiSignAddress : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.lstProvince  = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : []);

    ttcVMSelf.fiProIdNhom = ko.observable((data && data.hasOwnProperty('fiProIdNhom')) ? data.fiProIdNhom : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProIdPhanNhom = ko.observable((data && data.hasOwnProperty('fiProIdPhanNhom')) ? data.fiProIdPhanNhom : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProIdLoai = ko.observable((data && data.hasOwnProperty('fiProIdLoai')) ? data.fiProIdLoai : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProIdPhanLoai = ko.observable((data && data.hasOwnProperty('fiProIdPhanLoai')) ? data.fiProIdPhanLoai : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProCountryCode = ko.observable((data && data.hasOwnProperty('fiProCountryCode')) ? data.fiProCountryCode : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProCountryName = ko.observable((data && data.hasOwnProperty('fiProCountryName')) ? data.fiProCountryName : null);
    ttcVMSelf.lstUOMAnimal = ko.observable((data && data.hasOwnProperty('lstUOMAnimal')) ? data.lstUOMAnimal : null);

    ttcVMSelf.errorMsg = ko.observable(null);


    ttcVMSelf.fiRegistrationNo = ko.observable((data && data.hasOwnProperty('fiRegistrationNo')) ? data.fiRegistrationNo : null);
    ttcVMSelf.fiImporterName = ko.observable((data && data.hasOwnProperty('fiImporterName')) ? data.fiImporterName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    ttcVMSelf.fiImporterAddress = ko.observable((data && data.hasOwnProperty('fiImporterAddress')) ? data.fiImporterAddress : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    ttcVMSelf.fiImporterTel = ko.observable((data && data.hasOwnProperty('fiImporterTel')) ? data.fiImporterTel : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            pattern: {
                params: '^0[1-9][0-9]{8,9}$',
                message: "Số điện thoại không hợp lệ."
            }
        });
    ttcVMSelf.fiImporterFax = ko.observable((data && data.hasOwnProperty('fiImporterFax')) ? data.fiImporterFax : null).
    extend({
        number: {params: true}
    });
    ttcVMSelf.fiImporterEmail = ko.observable((data && data.hasOwnProperty('fiImporterEmail')) ? data.fiImporterEmail : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });


    //inc_thongtinkhac.jsp
    ttcVMSelf.fiAddressGath = ko.observable((data && data.hasOwnProperty('fiAddressGath')) ? data.fiAddressGath : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiRegSamFromDate = ko.observable((data && data.hasOwnProperty('fiRegSamFromDate')) ? new Date(data.fiRegSamFromDate) : new Date());
    ttcVMSelf.fiRegSamToDate = ko.observable((data && data.hasOwnProperty('fiRegSamToDate')) ? new Date(data.fiRegSamToDate) : null);
    ttcVMSelf.fiAddressRegSample = ko.observable((data && data.hasOwnProperty('fiAddressRegSample')) ? data.fiAddressRegSample : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiContactName = ko.observable((data && data.hasOwnProperty('fiContactName')) ? data.fiContactName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiContactTel = ko.observable((data && data.hasOwnProperty('fiContactTel')) ? data.fiContactTel : null).extend({
        pattern: {
            params: '^0[1-9][0-9]{8,9}$',
            message: "Số điện thoại không hợp lệ."}
    });
    ttcVMSelf.fiContactAddress = ko.observable((data && data.hasOwnProperty('fiContactAddress')) ? data.fiContactAddress : null);
    ttcVMSelf.fiContactEmail = ko.observable((data && data.hasOwnProperty('fiContactEmail')) ? data.fiContactEmail : null).extend({
        email: {params: true, message: NSWLang["common_msg_invalid_email"]}
    });



    ttcVMSelf.clearForm = function () {

        ttcVMSelf.errorMsg('');
        ttcVMSelf.EfiProCLTarg = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.EfiProCLCompare = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.EfiProCLContent = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        ttcVMSelf.EfiProCLUnitID = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        $("#EfiProCLTargTx").val('');
        $("#EfiProCLContentTx").val('');


        ttcVMSelf.EfiProATTarg= ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.EfiProATCompare= ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.EfiProATContent= ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        ttcVMSelf.EfiProATUnitID= ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        $("#EfiProATTargTx").val('');
        $("#EfiProATContentTx").val('');

        ttcVMSelf.EfiProSLKLMass = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        ttcVMSelf.EfiProSLKLMassTan = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        ttcVMSelf.EfiProSLKLAmount = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        ttcVMSelf.EfiProSLKLAmountUnitCode = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });

        ttcVMSelf.EfiProSLKLMassUnitCode = ko.observable(null).
        extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        $("#EfiProSLKLMass").val('');
        $("#EfiProSLKLMassTan").val('');
        $("#EfiProSLKLAmount").val('');


    }
    ttcVMSelf.addProduct=function(data){
        if (!ttcVMSelf.validate()) return;
        var kl='';
        var sl='';
        for (var i =0;i<ttcVMSelf.fiProSLKLList().length;i++){
            kl+=ttcVMSelf.fiProSLKLList()[i].fiProSLKLMass+' '+ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitName;
            sl+=ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmount+' '+ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitName;
        }

        var item ={
            fiProName: ttcVMSelf.fiProName(),
            fiProductKL: kl,
            fiProductSL: sl,
            fiProThanhPhan: ttcVMSelf.fiProThanhPhan(),
            fiProIdNhom: ttcVMSelf.fiProIdNhom(),
            fiProIdPhanNhom: ttcVMSelf.fiProIdPhanNhom(),
            fiProIdLoai: ttcVMSelf.fiProIdLoai(),
            fiProIdPhanLoai: ttcVMSelf.fiProIdPhanLoai(),
            fiProCode: ttcVMSelf.fiProCode(),
            fiProMadeIn: ttcVMSelf.fiProMadeIn(),
            fiProCountryName: ttcVMSelf.fiProCountryName(),
            fiProCountryCode: ttcVMSelf.fiProCountryCode(),
            fiProValueVN: ttcVMSelf.fiProValueVN(),
            fiProColor: ttcVMSelf.fiProColor(),
            fiProSoHieu: ttcVMSelf.fiProSoHieu(),
            fiProQuyChuan: ttcVMSelf.fiProQuyChuan(),
            fiProValueUSD: ttcVMSelf.fiProValueUSD(),
            fiPackageUnitCode: ttcVMSelf.fiPackageUnitCode(),
            fiProCLList: ttcVMSelf.fiProCLList(),
            fiProSLKLList: ttcVMSelf.fiProSLKLList(),
            fiProATList: ttcVMSelf.fiProATList()
        }
        ttcVMSelf.fiProductList.push(item);
        $("#modal_addAnimal").modal('hide');
    }
    ttcVMSelf.addThongTinChiTieuChatLuong=function () {
        var chiTieuChatLuong = [ttcVMSelf.EfiProCLContent, ttcVMSelf.EfiProCLCompare, ttcVMSelf.EfiProCLUnitID,ttcVMSelf.EfiProCLTarg];
        ttcVMSelf.errors = ko.validation.group(chiTieuChatLuong, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var item = {
            fiProCLTarg: ttcVMSelf.EfiProCLTarg(),
            fiProCLCompare: ttcVMSelf.EfiProCLCompare(),
            fiProCLContent: ttcVMSelf.EfiProCLContent(),
            fiProCLUnitName: ttcVMSelf.EfiProCLUnitID(),
            fiProCLUnitID: ttcVMSelf.EfiProCLUnitID()
        }

        ttcVMSelf.fiProCLList.push(item);
        ttcVMSelf.clearForm();
    }
    ttcVMSelf.addThongTinChiTieuAT=function () {
        var chiTieuAT = [ttcVMSelf.EfiProATContent, ttcVMSelf.EfiProATTarg, ttcVMSelf.EfiProATCompare,ttcVMSelf.EfiProATUnitID];
        ttcVMSelf.errors = ko.validation.group(chiTieuAT, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var item = {
            fiProATTarg: ttcVMSelf.EfiProATTarg(),
            fiProATCompare: ttcVMSelf.EfiProATCompare(),
            fiProATContent: ttcVMSelf.EfiProATContent(),
            fiProATUnitName: ttcVMSelf.EfiProATUnitID(),
            fiProATUnitID: ttcVMSelf.EfiProATUnitID()
        }

        ttcVMSelf.fiProATList.push(item);
        ttcVMSelf.clearForm();
    }
    ttcVMSelf.addThongTinChiTieuKL=function () {
        var chiTieuKL = [ttcVMSelf.EfiProSLKLMass, ttcVMSelf.EfiProSLKLMassTan, ttcVMSelf.EfiProSLKLAmount,ttcVMSelf.EfiProSLKLAmountUnitCode,ttcVMSelf.EfiProSLKLMassUnitCode];
        ttcVMSelf.errors = ko.validation.group(chiTieuKL, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var item = {
            fiProSLKLMass: ttcVMSelf.EfiProSLKLMass(),
            fiProSLKLMassTan:ttcVMSelf.EfiProSLKLMassTan(),
            fiProSLKLMassUnitName: ttcVMSelf.EfiProSLKLMassUnitCode(),
            fiProSLKLAmount: ttcVMSelf.EfiProSLKLAmount(),
            fiProSLKLAmountUnitName: ttcVMSelf.EfiProSLKLAmountUnitCode(),
            fiProSLKLAmountUnitCode: ttcVMSelf.EfiProSLKLAmountUnitCode()
        }

        ttcVMSelf.fiProSLKLList.push(item);
        ttcVMSelf.clearForm();
    }
    ttcVMSelf.validate = function () {
        if (ttcVMSelf.errors().length > 0) {
            ttcVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }
    ttcVMSelf.openUpdateProduct = function (data, index, type) {
        ko.mapping.fromJS(data, {}, ttcVMSelf);
        ttcVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_addAnimal').modal('show');
        } else {
            $('#modal_addAnimal').modal('show');
        }
    }
    ttcVMSelf.removeProduct = function (index) {
        ttcVMSelf.fiProductList.splice(index, 1);
    }

}