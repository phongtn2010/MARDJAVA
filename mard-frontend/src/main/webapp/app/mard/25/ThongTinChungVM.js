function ThongTinChungVM(data) {
    var ttcVMSelf = this;

    ttcVMSelf.errors = ko.validation.group(ttcVMSelf);
    ttcVMSelf.fiHSStatus = ko.observable((data && data.hasOwnProperty('fiHSStatus')) ? data.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((data && data.hasOwnProperty('fiHSCreatedDate')) ? new Date(data.fiHSCreatedDate) : new Date());
    ttcVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null);
    ttcVMSelf.fiNSWFileCodeReplace = ko.observable((data && data.hasOwnProperty('fiNSWFileCodeReplace')) ? data.fiNSWFileCodeReplace : null);
    ttcVMSelf.fiGDK = ko.observable((data && data.hasOwnProperty('fiGDK')) ? data.fiGDK : null);
    ttcVMSelf.fiGDKFile = ko.observable((data && data.hasOwnProperty('fiGDKFile')) ? data.fiGDKFile : null);

    ttcVMSelf.fiNSWFileCode = ko.observable((data && data.hasOwnProperty('fiNSWFileCode')) ? data.fiNSWFileCode : null);

    //inc_thongtindangky.jsp
    ttcVMSelf.fiSellName = ko.observable((data && data.hasOwnProperty('fiSellName')) ? data.fiSellName : null);
    ttcVMSelf.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : null);
    ttcVMSelf.lstNhom = ko.observableArray((data && data.hasOwnProperty('lstNhom')) ? data.lstNhom : null);
    ttcVMSelf.lstPhanNhom = ko.observableArray((data && data.hasOwnProperty('lstPhanNhom')) ? data.lstPhanNhom : null);
    ttcVMSelf.lstLoai = ko.observableArray((data && data.hasOwnProperty('lstLoai')) ? data.lstLoai : null);
    ttcVMSelf.lstPhanLoai = ko.observableArray((data && data.hasOwnProperty('lstPhanLoai')) ? data.lstPhanLoai : null);
    ttcVMSelf.fiSellCountryCode = ko.observable((data && data.hasOwnProperty('fiSellCountryCode')) ? data.fiSellCountryCode : null);
    ttcVMSelf.fiSellCountryName = ko.observable((data && data.hasOwnProperty('fiSellCountryName')) ? data.fiSellCountryName : null);

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

    ttcVMSelf.fiProductList = ko.observableArray((data && data.hasOwnProperty('fiProductList')) ? data.fiProductList : []);

    ttcVMSelf.fiProCVMienGiam = ko.observable((data && data.hasOwnProperty('fiProCVMienGiam')) ? data.fiProCVMienGiam : null);
    ttcVMSelf.fiProCVMienGiamNgay = ko.observable((data && data.hasOwnProperty('fiProCVMienGiamNgay')) ? new Date(data.fiProCVMienGiamNgay) : null);

    ttcVMSelf.fiProName = ko.observable((data && data.hasOwnProperty('fiProName')) ? data.fiProName : null);
    ttcVMSelf.fiProCode = ko.observable((data && data.hasOwnProperty('fiProCode')) ? data.fiProCode : null);
    ttcVMSelf.fiProMadeIn = ko.observable((data && data.hasOwnProperty('fiProMadeIn')) ? data.fiProMadeIn : null);
    ttcVMSelf.fiProThanhPhan = ko.observable((data && data.hasOwnProperty('fiProThanhPhan')) ? data.fiProThanhPhan : null);
    ttcVMSelf.fiProColor = ko.observable((data && data.hasOwnProperty('fiProColor')) ? data.fiProColor : null);
    ttcVMSelf.fiProSoHieu = ko.observable((data && data.hasOwnProperty('fiProSoHieu')) ? data.fiProSoHieu : null);
    ttcVMSelf.fiProQuyChuan = ko.observable((data && data.hasOwnProperty('fiProQuyChuan')) ? data.fiProQuyChuan : null);

    ttcVMSelf.fiProCLList = ko.observableArray((data && data.hasOwnProperty('fiProCLList')) ? data.fiProCLList : []);
    ttcVMSelf.EfiProCLTarg = ko.observable(null);
    ttcVMSelf.EfiProCLCompare = ko.observable(null);
    ttcVMSelf.EfiProCLContent = ko.observable(null);
    ttcVMSelf.EfiProCLUnitID = ko.observable(null);


    ttcVMSelf.fiProValueVN  = ko.observable((data && data.hasOwnProperty('fiProValueVN ')) ? data.fiProValueVN  : null);
    ttcVMSelf.fiProValueUSD   = ko.observable((data && data.hasOwnProperty('fiProValueUSD  ')) ? data.fiProValueUSD  : null);

    ttcVMSelf.fiProATList = ko.observableArray((data && data.hasOwnProperty('fiProATList')) ? data.fiProATList : []);
    ttcVMSelf.EfiProATTarg = ko.observable(null);
    ttcVMSelf.EfiProATCompare = ko.observable(null);
    ttcVMSelf.EfiProATContent = ko.observable(null);
    ttcVMSelf.EfiProATUnitID = ko.observable(null);

    ttcVMSelf.fiProSLKLList = ko.observableArray((data && data.hasOwnProperty('fiProSLKLList')) ? data.fiProSLKLList : []);
    ttcVMSelf.EfiProSLKLMass = ko.observable(null);
    ttcVMSelf.EfiProSLKLMassTan = ko.observable(null);
    ttcVMSelf.EfiProSLKLMassUnitCode = ko.observable(null);
    ttcVMSelf.EfiProSLKLAmount = ko.observable(null);
    ttcVMSelf.EfiProSLKLAmountUnitCode = ko.observable(null);


    ttcVMSelf.fiPackageUnitCode = ko.observable(null);
    ttcVMSelf.fiSignName = ko.observable((data && data.hasOwnProperty('fiSignName')) ? data.fiSignName : null);
    ttcVMSelf.fiSignPosition = ko.observable((data && data.hasOwnProperty('fiSignPosition')) ? data.fiSignPosition : null);
    ttcVMSelf.fiSignAddress = ko.observable((data && data.hasOwnProperty('fiSignAddress')) ? data.fiSignAddress : null);

    ttcVMSelf.lstProvince  = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : []);

    ttcVMSelf.fiProIdNhom = ko.observable((data && data.hasOwnProperty('fiProIdNhom')) ? data.fiProIdNhom : null);
    ttcVMSelf.fiProIdPhanNhom = ko.observable((data && data.hasOwnProperty('fiProIdPhanNhom')) ? data.fiProIdPhanNhom : null);
    ttcVMSelf.fiProIdLoai = ko.observable((data && data.hasOwnProperty('fiProIdLoai')) ? data.fiProIdLoai : null);
    ttcVMSelf.fiProIdPhanLoai = ko.observable((data && data.hasOwnProperty('fiProIdPhanLoai')) ? data.fiProIdPhanLoai : null);
    ttcVMSelf.fiProCountryCode = ko.observable((data && data.hasOwnProperty('fiProCountryCode')) ? data.fiProCountryCode : null);
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

    ttcVMSelf.clearForm = function () {

        ttcVMSelf.errorMsg('');
        ttcVMSelf.EfiProCLTarg = ko.observable(null);
        ttcVMSelf.EfiProCLCompare = ko.observable(null);
        ttcVMSelf.EfiProCLContent = ko.observable(null);
        ttcVMSelf.EfiProCLUnitID = ko.observable(null);
        $("#EfiProCLTargTx").val('');
        $("#EfiProCLContentTx").val('');


        ttcVMSelf.EfiProATTarg= ko.observable(null);
        ttcVMSelf.EfiProATCompare= ko.observable(null);
        ttcVMSelf.EfiProATContent= ko.observable(null);
        ttcVMSelf.EfiProATUnitID= ko.observable(null);
        $("#EfiProATTargTx").val('');
        $("#EfiProATContentTx").val('');

        ttcVMSelf.EfiProSLKLMass = ko.observable(null);
        ttcVMSelf.EfiProSLKLMassTan = ko.observable(null);
        ttcVMSelf.EfiProSLKLAmount = ko.observable(null);
        ttcVMSelf.EfiProSLKLAmountUnitCode = ko.observable(null);
        ttcVMSelf.EfiProSLKLMassUnitCode = ko.observable(null);
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