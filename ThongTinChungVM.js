function ThongTinChungVM(data) {
    var ttcVMSelf = this;
    ttcVMSelf.fiHSStatus = ko.observable((data && data.hasOwnProperty('fiHSStatus')) ? data.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((data && data.hasOwnProperty('fiHSCreatedDate')) ? new Date(data.fiHSCreatedDate) : new Date());
    ttcVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null);

    ttcVMSelf.fiNSWFileCode = ko.observable((data && data.hasOwnProperty('fiNSWFileCode')) ? data.fiNSWFileCode : null);

    //inc_thongtindangky.jsp
    ttcVMSelf.fiSellName = ko.observable((data && data.hasOwnProperty('fiSellName')) ? data.fiSellName : null);
    ttcVMSelf.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : null);

    ttcVMSelf.fiSellAddress = ko.observable((data && data.hasOwnProperty('fiSellAddress')) ? data.fiSellAddress : null);
    ttcVMSelf.fiSellTel = ko.observable((data && data.hasOwnProperty('fiSellTel')) ? data.fiSellTel : null);
    ttcVMSelf.fiSellFax = ko.observable((data && data.hasOwnProperty('fiSellFax')) ? data.fiSellFax : null);
    ttcVMSelf.fiSellExport = ko.observable((data && data.hasOwnProperty('fiSellExport')) ? data.fiSellExport : null);

    ttcVMSelf.fiPurchName = ko.observable((data && data.hasOwnProperty('fiPurchName')) ? data.fiPurchName : null);
    ttcVMSelf.fiPurchTel = ko.observable((data && data.hasOwnProperty('fiPurchTel')) ? data.fiPurchTel : null);
    ttcVMSelf.fiPurchAddress = ko.observable((data && data.hasOwnProperty('fiPurchAddress')) ? data.fiPurchAddress : null);
    ttcVMSelf.fiPurchFax = ko.observable((data && data.hasOwnProperty('fiPurchFax')) ? data.fiPurchFax : null);
    ttcVMSelf.fiPurchReci = ko.observable((data && data.hasOwnProperty('fiPurchReci')) ? data.fiPurchReci : null);
    ttcVMSelf.fiPurchFromDate = ko.observable((data && data.hasOwnProperty('fiPurchFromDate')) ? new Date(data.fiPurchFromDate) : new Date());
    ttcVMSelf.fiPurchToDate = ko.observable((data && data.hasOwnProperty('fiPurchToDate')) ? new Date(data.fiPurchToDate) : null);

    ttcVMSelf.fiProductList = ko.observableArray((data && data.hasOwnProperty('fiProductList')) ? data.fiProductList : null);

    ttcVMSelf.fiProCVMienGiam = ko.observable((data && data.hasOwnProperty('fiProCVMienGiam')) ? data.fiProCVMienGiam : null);
    ttcVMSelf.fiProCVMienGiamNgay = ko.observable((data && data.hasOwnProperty('fiProCVMienGiamNgay')) ? new Date(data.fiProCVMienGiamNgay) : null);

    ttcVMSelf.fiProName = ko.observable((data && data.hasOwnProperty('fiProName')) ? data.fiProName : null);
    ttcVMSelf.fiProCode = ko.observable((data && data.hasOwnProperty('fiProCode')) ? data.fiProCode : null);
    ttcVMSelf.fiProMadeIn = ko.observable((data && data.hasOwnProperty('fiProMadeIn')) ? data.fiProMadeIn : null);
    ttcVMSelf.fiProThanhPhan = ko.observable((data && data.hasOwnProperty('fiProThanhPhan')) ? data.fiProThanhPhan : null);
    ttcVMSelf.fiProColor = ko.observable((data && data.hasOwnProperty('fiProColor')) ? data.fiProColor : null);
    ttcVMSelf.fiProSoHieu = ko.observable((data && data.hasOwnProperty('fiProSoHieu')) ? data.fiProSoHieu : null);
    ttcVMSelf.fiProQuyChuan = ko.observable((data && data.hasOwnProperty('fiProQuyChuan')) ? data.fiProQuyChuan : null);


    ttcVMSelf.fiProCLUnitID = ko.observable((data && data.hasOwnProperty('fiProCLUnitID')) ? data.fiProCLUnitID : null);
    ttcVMSelf.fiProCLList = ko.observableArray((data && data.hasOwnProperty('fiProCLList')) ? data.fiProCLList : null);
    ttcVMSelf.fiProCLTarg = ko.observable((data && data.hasOwnProperty('fiProCLTarg')) ? data.fiProCLTarg : null);
    ttcVMSelf.fiProCLCompare = ko.observable((data && data.hasOwnProperty('fiProCLCompare')) ? data.fiProCLCompare : null);
    ttcVMSelf.fiProCLContent = ko.observable((data && data.hasOwnProperty('fiProCLContent')) ? data.fiProCLContent : null);
    ttcVMSelf.fiProSLKLMass = ko.observable((data && data.hasOwnProperty('fiProSLKLMass')) ? data.fiProSLKLMass : null);
    ttcVMSelf.fiProSLKLMassUnitCode = ko.observable((data && data.hasOwnProperty('fiProSLKLMassUnitCode')) ? data.fiProSLKLMassUnitCode : null);
    ttcVMSelf.fiProSLKLAmountUnitCode = ko.observable((data && data.hasOwnProperty('fiProSLKLAmountUnitCode')) ? data.fiProSLKLAmountUnitCode : null);
    ttcVMSelf.fiProSLKLMassTan  = ko.observable((data && data.hasOwnProperty('fiProSLKLMassTan ')) ? data.fiProSLKLMassTan  : null);
    ttcVMSelf.fiProSLKLAmount  = ko.observable((data && data.hasOwnProperty('fiProSLKLAmount ')) ? data.fiProSLKLAmount  : null);
    ttcVMSelf.fiProSLKLAmountUnitName  = ko.observable((data && data.hasOwnProperty('fiProSLKLAmountUnitName ')) ? data.fiProSLKLAmountUnitName  : null);
    ttcVMSelf.fiPackageUnitCode  = ko.observable((data && data.hasOwnProperty('fiPackageUnitCode ')) ? data.fiPackageUnitCode  : null);
    ttcVMSelf.fiProValueVN  = ko.observable((data && data.hasOwnProperty('fiProValueVN ')) ? data.fiProValueVN  : null);
    ttcVMSelf.fiProValueUSD   = ko.observable((data && data.hasOwnProperty('fiProValueUSD  ')) ? data.fiProValueUSD  : null);

    ttcVMSelf.fiProATList = ko.observableArray((data && data.hasOwnProperty('fiProATList')) ? data.fiProATList : null);
    ttcVMSelf.fiProATTarg = ko.observable((data && data.hasOwnProperty('fiProATTarg')) ? data.fiProATTarg : null);
    ttcVMSelf.fiProATCompare = ko.observable((data && data.hasOwnProperty('fiProATCompare')) ? data.fiProATCompare : null);
    ttcVMSelf.fiProATContent = ko.observable((data && data.hasOwnProperty('fiProATContent')) ? data.fiProATContent : null);


    ttcVMSelf.fiProIdNhom = ko.observable((data && data.hasOwnProperty('fiProIdNhom')) ? data.fiProIdNhom : null);
    ttcVMSelf.fiProIdPhanNhom = ko.observable((data && data.hasOwnProperty('fiProIdPhanNhom')) ? data.fiProIdPhanNhom : null);
    ttcVMSelf.fiProIdLoai = ko.observable((data && data.hasOwnProperty('fiProIdLoai')) ? data.fiProIdLoai : null);
    ttcVMSelf.fiProIdPhanLoai = ko.observable((data && data.hasOwnProperty('fiProIdPhanLoai')) ? data.fiProIdPhanLoai : null);
    ttcVMSelf.fiProCountryCode = ko.observable((data && data.hasOwnProperty('fiProCountryCode')) ? data.fiProCountryCode : null);
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
        });
    ttcVMSelf.fiImporterFax = ko.observable((data && data.hasOwnProperty('fiImporterFax')) ? data.fiImporterFax : null);
    ttcVMSelf.fiImporterEmail = ko.observable((data && data.hasOwnProperty('fiImporterEmail')) ? data.fiImporterEmail : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });

    //inc_thongtinkhac.jsp
    ttcVMSelf.fiAddressGath = ko.observable((data && data.hasOwnProperty('fiAddressGath')) ? data.fiAddressGath : null);
    ttcVMSelf.fiRegSamFromDate = ko.observable((data && data.hasOwnProperty('fiRegSamFromDate')) ? new Date(data.fiRegSamFromDate) : new Date());
    ttcVMSelf.fiRegSamToDate = ko.observable((data && data.hasOwnProperty('fiRegSamToDate')) ? new Date(data.fiRegSamToDate) : null);
    ttcVMSelf.fiAddressRegSample = ko.observable((data && data.hasOwnProperty('fiAddressRegSample')) ? data.fiAddressRegSample : null);

    ttcVMSelf.fiContactName = ko.observable((data && data.hasOwnProperty('fiContactName')) ? data.fiContactName : null);
    ttcVMSelf.fiContactTel = ko.observable((data && data.hasOwnProperty('fiContactTel')) ? data.fiContactTel : null);
    ttcVMSelf.fiContactAddress = ko.observable((data && data.hasOwnProperty('fiContactAddress')) ? data.fiContactAddress : null);
    ttcVMSelf.fiContactEmail = ko.observable((data && data.hasOwnProperty('fiContactEmail')) ? data.fiContactEmail : null);

    addProduct=function(){

    }
}