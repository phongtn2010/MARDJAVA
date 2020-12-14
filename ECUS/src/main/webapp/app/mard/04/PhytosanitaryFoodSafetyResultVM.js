
function PhytosanitaryFoodSafetyResultVM(options) {
    var self = this;
    var foodSafetyResultVM = options.foodSafetyResultVM;
    self.fiIdCntp = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiIdCntp : null);
    self.fiIdHoso = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiIdHoso : null);
    self.fiMaHoso = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiMaHoso : null);
    self.fiSochungnhan = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiSochungnhan : null);
    self.fiTencq = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTencq : null);
    self.fiTenCqktra = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenCqktra : null);
    self.fiTenTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenTochuc : null);
    self.fiDcTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDcTochuc : null);
    self.fiDthoaiTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaiTochuc : null);
    self.fiTenNk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenNk : null);
    self.fiDchiNk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDchiNk : null);
    self.fiDthoaiNk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaiNk : null);
    self.fiTenXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenXk : null);
    self.fiDchiXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDchiXk : null);
    self.fiDthoaiXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaiXk : null);
    self.fiSotokhai = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiSotokhai : null);
    self.fiNuocXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiNuocXk : null);
    self.fiTenSx = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenSx : null);
    self.fiHoatdong = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiDchiSx = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDchiSx : null);
    self.fiMaSx = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiMaSx : null);
    self.fiCkDi = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiCkDi : null);
    self.fiCkDen = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiCkDen : null);
    self.fiNgaytu = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgaytu) : null);
    self.fiNgayden = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgayden) : null);
    self.fiDchiKtra = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDchiKtra : null);
    self.fiNoiky = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiNoiky : null);
    self.fiNgayky = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgayky) : null);
    self.fiNguoiky = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiNguoiky : null);
    self.fiChucvu = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiChucvu : null);

    self.undiscovered = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.undiscovered : null);
    self.objectsPhytosanitary = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.objectsPhytosanitary : null);
    self.objectsPhytosanitaryContent = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.objectsPhytosanitaryContent : null);
    self.detectingOrganisms = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.detectingOrganisms : null);
    self.allowSafety = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.allowSafety : null);
    self.locationAllow = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.locationAllow : null);
    self.locationAllowContent = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.locationAllowContent : null);
    self.allowUse = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.allowUse : null);
    self.notify = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.notify : null);
    self.otherRule = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.otherRule : null);
    self.otherRegulation = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.otherRegulation : null);
    self.licenseOfPhytosanitary = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.licenseOfPhytosanitary : null);
    self.licenseOfPhytosanitaryNo = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.licenseOfPhytosanitaryNo : null);
    self.licenseDate = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.licenseDate) : null);
    self.registrationCertificate = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.registrationCertificate : null);
    self.certificatePhytosanitary = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.certificatePhytosanitary : null);
    self.laboratoryAnalysis = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.laboratoryAnalysis : null);
    self.foodSafetyAnalysis = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.foodSafetyAnalysis : null);
    self.processedWoodExport = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.processedWoodExport : null);
    self.otherBase = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.otherBase : null);
    self.otherBaseContent = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.otherBaseContent : null);

    self.lstHangHoa04 = ko.observableArray(foodSafetyResultVM.hangHoa);
    self.fiPthucKtra = ko.observable(self.lstHangHoa04() ? self.lstHangHoa04()[0].fiPthucKtra : null);

    // if(self.lstHangHoa04 != null){
    //     self.fiSoluong = ko.observable(foodSafetyResultVM.hangHoa[0].fiSoluong);
    //     self.fiKhoiluong = ko.observable(foodSafetyResultVM.hangHoa[0].fiKhoiluong);
    // }

    self.canCu = ko.observable(foodSafetyResultVM.canCu);
    self.chungNhan = ko.observable(foodSafetyResultVM.chungNhan);
    self.quyDinh = ko.observable(foodSafetyResultVM.quyDinh);

    self.signConfirmDateStr = ko.observable(null);
    var dt = self.fiNgayky();
    var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
    var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
    var y = dt.getFullYear();
    var strDateHtml = "Ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
    self.signConfirmDateStr(strDateHtml);

    self.btnTroLaiClick = function () {
        History.go(-1);
    };

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoso !== null) {
            var url = '/mard/p04/hoso/giayCNTP/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.foodSafetyResultVM = d.data;
                        var vm = new PhytosanitaryFoodSafetyResultVM(options);
                        ko.applyBindings(vm, document.getElementById('PhytosanitaryFoodSafetyResultVM'));
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