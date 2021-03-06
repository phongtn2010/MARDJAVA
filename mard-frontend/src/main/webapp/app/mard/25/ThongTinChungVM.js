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
}