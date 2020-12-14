function PhytosanitaryResultVM(options) {
    var self = this;
    var phytosanitaryResult = options.phytosanitaryResult;

    self.fiMaLoaiKiemtra = options.fiMaLoaiKiemtra;

    self.fiIdCnkd = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiIdCnkd : null);
    self.fiIdHoso = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiIdHoso : null);
    self.fiMaHoso = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiMaHoso : null);
    self.fiSochungnhan = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiSochungnhan : null);
    self.fiCqKdtv = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiCqKdtv : null);
    self.fiCqCaptren = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiCqCaptren : null);
    self.fiTenChuhang = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiTenChuhang : null);
    self.fiDcCuahang = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiDcCuahang : null);
    self.fiDienthoai = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiDienthoai : null);
    self.fiNoiky = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiNoiky : null);
    self.fiNgayky = ko.observable(phytosanitaryResult ? new Date(phytosanitaryResult.fiNgayky) : null);

    self.fiNguoiky = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiNguoiky : null);
    self.fiChucvu = ko.observable(phytosanitaryResult ? phytosanitaryResult.fiChucvu : null);

    self.licenseOfPhytosanitary = ko.observable(phytosanitaryResult ? phytosanitaryResult.licenseOfPhytosanitary : null);
    self.licenseOfPhytosanitaryNo = ko.observable(phytosanitaryResult ? phytosanitaryResult.licenseOfPhytosanitaryNo : null);
    self.licenseDate = ko.observable(phytosanitaryResult ? new Date(phytosanitaryResult.licenseDate) : null);
    self.registrationCertificate = ko.observable(phytosanitaryResult ? phytosanitaryResult.registrationCertificate : null);
    self.certificatePhytosanitary = ko.observable(phytosanitaryResult ? phytosanitaryResult.certificatePhytosanitary : null);
    self.laboratoryAnalysis = ko.observable(phytosanitaryResult ? phytosanitaryResult.laboratoryAnalysis : null);
    self.processedWoodExport = ko.observable(phytosanitaryResult ? phytosanitaryResult.processedWoodExport : null);
    self.otherBase = ko.observable(phytosanitaryResult ? phytosanitaryResult.otherBase : null);
    self.otherBaseContent = ko.observable(phytosanitaryResult ? phytosanitaryResult.otherBaseContent : null);
    self.undiscovered = ko.observable(phytosanitaryResult ? phytosanitaryResult.undiscovered : null);
    self.objectsPhytosanitary = ko.observable(phytosanitaryResult ? phytosanitaryResult.objectsPhytosanitary : null);
    self.objectsPhytosanitaryContent = ko.observable(phytosanitaryResult ? phytosanitaryResult.objectsPhytosanitaryContent : null);
    self.detectingOrganisms = ko.observable(phytosanitaryResult ? phytosanitaryResult.detectingOrganisms : null);
    self.locationAllow = ko.observable(phytosanitaryResult ? phytosanitaryResult.locationAllow : null);
    self.locationAllowContent = ko.observable(phytosanitaryResult ? phytosanitaryResult.locationAllowContent : null);
    self.allowPlanting = ko.observable(phytosanitaryResult ? phytosanitaryResult.allowPlanting : null);
    self.allowTransit = ko.observable(phytosanitaryResult ? phytosanitaryResult.allowTransit : null);
    self.notify = ko.observable(phytosanitaryResult ? phytosanitaryResult.notify : null);
    self.otherRule = ko.observable(phytosanitaryResult ? phytosanitaryResult.otherRule : null);
    self.otherRegulation = ko.observable(phytosanitaryResult ? phytosanitaryResult.otherRegulation : null);

    self.fiTenPtien = ko.observable(phytosanitaryResult.fiTenPtien);
    self.fiNoidi = ko.observable(phytosanitaryResult.fiNoidi);
    self.fiNoiden = ko.observable(phytosanitaryResult.fiNoiden);

    self.lstHangHoa = ko.observable(phytosanitaryResult.hangHoa);
    if (self.lstHangHoa().length > 0) {
        self.fiTenHanghoaText = ko.observable(null);
        self.fiSoluongText = ko.observable(null);
        self.fiKltinhText = ko.observable(null);
        var hanghoaStr = "";
        var soluongStr = "";
        var khoiluongStr = "";
        for (var i = 0; i < self.lstHangHoa().length; i++) {
            if (i == 0) {
                hanghoaStr = self.lstHangHoa()[0].fiTenChitietHanghoa;
                soluongStr = self.lstHangHoa()[0].fiSoluong + "(" + self.lstHangHoa()[0].fiTenBaobi + ")";
                khoiluongStr = self.lstHangHoa()[0].fiKltinh + "(" + self.lstHangHoa()[0].fiTenDvtinh + ")";
            } else {
                hanghoaStr = hanghoaStr + "; " + self.lstHangHoa()[i].fiTenChitietHanghoa;
                soluongStr = soluongStr + "; " + self.lstHangHoa()[i].fiSoluong + "(" + self.lstHangHoa()[i].fiTenBaobi + ")";
                khoiluongStr = khoiluongStr + "; " + self.lstHangHoa()[i].fiKltinh + "(" + self.lstHangHoa()[i].fiTenDvtinh + ")";
            }
        }
        self.fiTenHanghoaText(hanghoaStr);
        self.fiSoluongText(soluongStr);
        self.fiKltinhText(khoiluongStr);
    }
    self.signConfirmDateStr = ko.observable(null);
    var dt = self.fiNgayky();
    var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
    var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
    var y = dt.getFullYear();
    var strDateHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
    self.signConfirmDateStr(strDateHtml);

    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoso !== null) {
            debugger
            var url = '/mard/p04/hoso/giayCNKDTV/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.phytosanitaryResult = d.data;
                        var vm = new PhytosanitaryResultVM(options);
                        ko.applyBindings(vm, document.getElementById('PhytosanitaryResultVM'));
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