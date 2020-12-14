function PhytosanitaryDetainVM(options) {
    var self = this;

    self.fiMaLoaiKiemtra = options.fiMaLoaiKiemtra;

    var phytosanitaryDetainVM = options.phytosanitaryDetainVM;
    if (phytosanitaryDetainVM != null) {
        self.fiIdLenh = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiIdLenh : null);
        self.fiIdHoso = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiIdHoso : null);
        self.fiMaHoso = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiMaHoso : null);
        self.fiSoChungnhan = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiSoChungnhan : null);
        self.fiTenCqKdtv = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenCqKdtv : null);
        self.fiTenCqKdtvEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenCqKdtvEn : null);
        self.fiTenCqCaptren = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenCqCaptren : null);
        self.fiTenCqCaptrenEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenCqCaptrenEn : null);
        self.fiKinhgui = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiKinhgui : null);
        self.fiKinhguiEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiKinhguiEn : null);
        self.fiTenChuhang = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenChuhang : null);
        self.fiTenChuhangEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenChuhangEn : null);
        self.fiDcChuhang = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiDcChuhang : null);
        self.fiDcChuhangEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiDcChuhangEn : null);
        self.fiTenNgnhan = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenNgnhan : null);
        self.fiTenNgnhanEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenNgnhanEn : null);
        self.fiDcNgnhan = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiDcNgnhan : null);
        self.fiDcNgnhanEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiDcNgnhanEn : null);

        self.fiMaPtien = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiMaPtien : null);
        self.fiTenPtien = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenPtien : null);
        self.fiTenPtienEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenPtienEn : null);
        self.fiMaQuoctich = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiMaQuoctich : null);
        self.fiTenQuoctich = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenQuoctich : null);
        self.fiTenQuoctichEn = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiTenQuoctichEn : null);
        self.fiDichhai = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiDichhai : null);
        self.fiNgayky = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiNgayky : null);
        self.fiNguoiky = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiNguoiky : null);
        self.fiChucvu = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiChucvu : null);
        self.fiNoinhan = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fiNoinhan : null);

        self.lstHangHoa04 = ko.observableArray(phytosanitaryDetainVM.lstHangHoa);

        self.fumigation = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fumigation : null);
        self.fumigant = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.fumigant : null);
        self.fumigationDateFrom = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.fumigationDateFrom : null).toShortDateString());
        self.fumigationDateTo = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.fumigationDateTo : null).toShortDateString());
        self.place = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.place : null);
        self.regulations = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.regulations : null);
        self.reexPort = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.reexPort : null);
        self.reexportDateFrom = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.reexportDateFrom : null).toShortDateString());
        self.reexportDateTo = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.reexportDateTo : null).toShortDateString());
        self.destroy = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.destroy : null);
        self.destroyDateFrom = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.destroyDateFrom : null).toShortDateString());
        self.destroyDateTo = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.destroyDateTo : null).toShortDateString());
        self.otherMeasures = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.otherMeasures : null);
        self.otherMeasuresContent = ko.observable(phytosanitaryDetainVM ? phytosanitaryDetainVM.otherMeasuresContent : null);
        self.otherMeasuresFrom = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.otherMeasuresFrom : null).toShortDateString());
        self.otherMeasuresTo = ko.observable(new Date(phytosanitaryDetainVM ? phytosanitaryDetainVM.otherMeasuresTo : null).toShortDateString());
    }

    self.btnTroLaiClick = function () {
        History.go(-1);
    };

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoso !== null) {
            var url = '/mard/p04/hoso/giulaiVaxuly/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.phytosanitaryDetainVM = d.data;
                        var vm = new PhytosanitaryDetainVM(options);
                        ko.applyBindings(vm, document.getElementById('PhytosanitaryDetainVM'));
                    } else {
                        msg = d.data.message ? d.data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                        app.Alert(msg);
                    }
                },
                error: function (e) {
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: NSWLang["common_msg_he_thong_chua_san_sang"],
                        function: 'success'
                    });
                }
            });
        }
    };
    init();
});