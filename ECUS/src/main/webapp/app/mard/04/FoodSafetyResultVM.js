
function FoodSafetyResultVM(options) {
    var self = this;
    var foodSafetyResultVM = options.foodSafetyResultVM;
    self.fiIdAttp = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiIdAttp : null);
    self.fiIdHoso = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiIdHoso : null);
    self.fiMaHoso = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiMaHoso : null);
    self.fiSochungnhan = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiSochungnhan : null);
    self.fiTencq = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTencq : null);
    self.fiTenTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenTochuc : null);
    self.fiDcTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDcTochuc : null);
    self.fiDthoaiTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaiTochuc : null);
    self.fiTentnTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTentnTochuc : null);
    self.fiDctnTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDctnTochuc : null);
    self.fiDthoaitnTochuc = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaitnTochuc : null);
    self.fiTenXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiTenXk : null);
    self.fiDcXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDcXk : null);
    self.fiDthoaiXk = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDthoaiXk : null);
    self.fiSotokhai = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiSotokhai : null);
    self.fiCuakhauDi = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiCuakhauDi : null);
    self.fiCuakhauDen = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiCuakhauDen : null);
    self.fiHoatdong = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytu = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgaytu) : null);
    self.fiNgayden = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgayden) : null);
    self.fiDiadiem = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiDiadiem : null);
    self.fiNoiky = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiNoiky : null);
    self.fiNgayky = ko.observable(foodSafetyResultVM ? new Date(foodSafetyResultVM.fiNgayky) : null);
    self.fiNguoiky = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiNguoiky : null);
    self.fiChucvu = ko.observable(foodSafetyResultVM ? foodSafetyResultVM.fiChucvu : null);
    debugger
    self.lstHangHoa04 = ko.observableArray(foodSafetyResultVM.hangHoa);

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
            var url = '/mard/p04/hoso/giayATTP/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.foodSafetyResultVM = d.data;
                        var vm = new FoodSafetyResultVM(options);
                        ko.applyBindings(vm, document.getElementById('FoodSafetyResultVM'));
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