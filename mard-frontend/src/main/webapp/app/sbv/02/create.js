function SBV02CreateVM () {
    var createVMSelf = this;
    createVMSelf.hsxnkv = ko.observable(null);
    createVMSelf.isEditable = ko.observable(true)

    createVMSelf.applyState = function (options) {
        options["fiHSType"] = "1";
        createVMSelf.hsxnkv(new ThongTinHoSoVM(options));
    }

    createVMSelf.saveRegProfile = function () {
        // if (!createVMSelf.kdnkVM().validateForm()) return;
        var body = createVMSelf.hsxnkv().getData();
        console.log(body);
    }

}
    $(document).ready(function () {
        var options = {
            fiTaxCode: hosoUsername,
            fiImporterAddress: hosoCompanyAddress,
            fiImporterName: hosoCompanyName,
            fiImporterTel: hosoCompanyPhoneNumber,
            fiImporterFax: hosoCompanyFax,
            fiImporterEmail: hosoCompanyEmail,
            fiHSStatus: 0
        };
        $('#loading10').show();
        $.when(
            // Get list Cua Khau
            // app.sendGetRequest("/sbv/02/danhmuc/cuakhau", function (res) {
            //     options['lstCuaKhau'] = res.data;
            // }),
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
function init(options) {
    var sbv02CreateVM = new SBV02CreateVM();
    ko.applyBindings(sbv02CreateVM, document.getElementById('sbv02Create'));
    sbv02CreateVM.applyState(options);
}


