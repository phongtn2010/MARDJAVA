ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var xemGCNVM;

function showCV1() {
    $('#tab_cert_mard08_1').show()
    $('#tab_cert_mard08_2').hide()
}

function showCV2() {
    $('#tab_cert_mard08_2').show()
    $('#tab_cert_mard08_1').hide()
}

function Mard08CertVM() {
    self2 = this;
    xemGCNVM = this;
    self2.vsty = {
        hosoCompanyName: ko.observable(null),
        fiIdCV: ko.observable(null),
        fiCorrDocCode: ko.observable(null),
        fiHSCode: ko.observable(null),
        fiHSCreatedDate: ko.observable(null),
        fiDispatchNo: ko.observable(null),
        fiSummary: ko.observable(null),
        fiPreamble: ko.observable(null),
        fiContent: ko.observable(null),
        fiCompanyTaxCode: ko.observable(null),
        fiCompanyName: ko.observable(null),
        fiCompanyAddress: ko.observable(null),
        fiExecutionTime: ko.observable(null),
        fiPurpose: ko.observable(null),
        fiRecipient: ko.observable(null),
        fiSignConfirmAddress: ko.observable(null),
        fiSignConfirmDate: ko.observable(null),
        fiSignConfirmName: ko.observable(null),
        fiSignConfirmTitle: ko.observable(null),
        fiEditReason: ko.observable(null),
        lstAnimal: ko.observableArray([]),
        lstCompany: ko.observableArray([]),
        lstIsoLoc: ko.observableArray([])
    };

    self2.cnkd = {
        hosoCompanyName: ko.observable(null),
        fiIdCV: ko.observable(null),
        fiCorrDocCode: ko.observable(null),
        fiHSCode: ko.observable(null),
        fiHSCreatedDate: ko.observable(null),
        fiDispatchNo: ko.observable(null),
        fiQuarantineNo: ko.observable(null),
        fiReportInfo: ko.observable(null),
        fiSummary: ko.observable(null),
        fiPreamble: ko.observable(null),
        fiContent: ko.observable(null),
        fiCompanyTaxCode: ko.observable(null),
        fiCompanyName: ko.observable(null),
        fiCompanyAddress: ko.observable(null),
        fiExecutionTime: ko.observable(null),
        fiPurpose: ko.observable(null),
        fiRecipient: ko.observable(null),
        fiSignConfirmAddress: ko.observable(null),
        fiSignConfirmDate: ko.observable(null),
        fiSignConfirmName: ko.observable(null),
        fiSignConfirmTitle: ko.observable(null),
        fiEditReason: ko.observable(null),
        lstProduct: ko.observableArray([]),
        lstCompany: ko.observableArray([]),
        lstMfr: ko.observableArray([])
    };

    self2.showCV1 = showCV1;
    self2.showCV2 = showCV2;

    self2.fillVSTY = function(data) {
        self2.vsty.fiIdCV(data.vsty.fiIdCV);
        self2.vsty.fiCorrDocCode(data.vsty.fiCorrDocCode);
        self2.vsty.fiHSCode(data.vsty.fiHSCode);
        self2.vsty.fiHSCreatedDate(data.vsty.fiHSCreatedDate);
        self2.vsty.fiDispatchNo(data.vsty.fiDispatchNo);
        self2.vsty.fiSummary(data.vsty.fiSummary);
        self2.vsty.fiPreamble(data.vsty.fiPreamble);
        var vstyContent = data.vsty.fiContent.replace(new RegExp('\r?\n','g'), '<br />');
        var vstyRecipient = data.vsty.fiRecipient.replace(new RegExp('\r?\n','g'), '<br />');
        self2.vsty.fiContent(vstyContent);
        self2.vsty.fiCompanyTaxCode(data.vsty.fiCompanyTaxCode);
        self2.vsty.fiCompanyName(data.vsty.fiCompanyName);
        self2.vsty.fiCompanyAddress(data.vsty.fiCompanyAddress);
        self2.vsty.fiExecutionTime(data.vsty.fiExecutionTime);
        self2.vsty.fiPurpose(data.vsty.fiPurpose);
        self2.vsty.fiRecipient(vstyRecipient);
        self2.vsty.fiSignConfirmAddress(data.vsty.fiSignConfirmAddress);
        self2.vsty.fiSignConfirmDate(data.vsty.fiSignConfirmDate);
        self2.vsty.fiSignConfirmName(data.vsty.fiSignConfirmName);
        self2.vsty.fiExecutionTime(data.vsty.fiExecutionTime);
        self2.vsty.fiSignConfirmTitle(data.vsty.fiSignConfirmTitle);
        self2.vsty.fiEditReason(data.vsty.fiEditReason);

        data.vsty.lstAnimal.forEach(function(item, index) {
            item.index = index + 1;
            item.fiQty = item.fiQtyMale + item.fiQtyFemale
        });
        data.vsty.lstCompany.forEach(function(item, index) {
            item.index = index + 1;
        });
        data.vsty.lstIsoLoc.forEach(function(item, index) {
            item.index = index + 1;
        });

        self2.vsty.lstAnimal(data.vsty.lstAnimal);
        self2.vsty.lstCompany(data.vsty.lstCompany);
        self2.vsty.lstIsoLoc(data.vsty.lstIsoLoc);
        var fiSignedDate = new Date(data.cnkd.fiSignConfirmDate);
        self2.vsty.fiSignConfirmDate("ngày " + fiSignedDate.getDate() + ", tháng " + fiSignedDate.getMonth() + ", năm " + fiSignedDate.getFullYear());

        self2.cnkd.fiIdCV(data.cnkd.fiIdCV);
        self2.cnkd.fiCorrDocCode(data.cnkd.fiCorrDocCode);
        self2.cnkd.fiHSCode(data.cnkd.fiHSCode);
        self2.cnkd.fiHSCreatedDate(data.cnkd.fiHSCreatedDate);
        self2.cnkd.fiDispatchNo(data.cnkd.fiDispatchNo);
        self2.cnkd.fiQuarantineNo(data.cnkd.fiQuarantineNo);
        self2.cnkd.fiReportInfo(data.cnkd.fiReportInfo);
        self2.cnkd.fiSummary(data.cnkd.fiSummary);
        self2.cnkd.fiPreamble(data.cnkd.fiPreamble);
        var cnkdContent = data.cnkd.fiContent.replace(new RegExp('\r?\n','g'), '<br />');
        var cnkdRecipient = data.cnkd.fiRecipient.replace(new RegExp('\r?\n','g'), '<br />');
        self2.cnkd.fiContent(cnkdContent);
        self2.cnkd.fiCompanyTaxCode(data.cnkd.fiCompanyTaxCode);
        self2.cnkd.fiCompanyName(data.cnkd.fiCompanyName);
        self2.cnkd.fiCompanyAddress(data.cnkd.fiCompanyAddress);
        self2.cnkd.fiExecutionTime(data.cnkd.fiExecutionTime);
        self2.cnkd.fiPurpose(data.cnkd.fiPurpose);
        self2.cnkd.fiRecipient(cnkdRecipient);
        self2.cnkd.fiSignConfirmAddress(data.cnkd.fiSignConfirmAddress);
        self2.cnkd.fiSignConfirmDate(data.cnkd.fiSignConfirmDate);
        self2.cnkd.fiSignConfirmName(data.cnkd.fiSignConfirmName);
        self2.cnkd.fiExecutionTime(data.cnkd.fiExecutionTime);
        self2.cnkd.fiSignConfirmTitle(data.cnkd.fiSignConfirmTitle);
        self2.cnkd.fiEditReason(data.cnkd.fiEditReason);

        data.cnkd.lstProduct.forEach(function(item, index) {
            item.index = index + 1;
            item.fiQty = item.fiQtyMale + item.fiQtyFemale
        });
        data.cnkd.lstCompany.forEach(function(item, index) {
            item.index = index + 1;
        });
        data.cnkd.lstMfr.forEach(function(item, index) {
            item.index = index + 1;
        });

        self2.cnkd.lstProduct(data.cnkd.lstProduct);
        self2.cnkd.lstCompany(data.cnkd.lstCompany);
        self2.cnkd.lstMfr(data.cnkd.lstMfr);
        var cnkdSignedDate = new Date(data.cnkd.fiSignConfirmDate);
        self2.cnkd.fiSignConfirmDate("ngày " + cnkdSignedDate.getDate() + ", tháng " + cnkdSignedDate.getMonth() + ", năm " + cnkdSignedDate.getFullYear());
    };
    self2.closeModal = function() {
        $('#gcn08View').hide()
    };

    self2.searchFieldEnter = function () {
        self2.search(1, true);
    };
}



$(document).ready(function () {
    var vm = new Mard08CertVM();
    ko.applyBindings(vm, document.getElementById('gcn08View'));
    showCV1()
});