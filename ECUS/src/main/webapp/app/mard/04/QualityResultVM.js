/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global self */

function QualityResultVM(options) {
    var self = this;
    var qualityResultVM = options.qualityResultVM;

    self.fiMaLoaiKiemtra = options.fiMaLoaiKiemtra;

    self.fiIdXncl = ko.observable(qualityResultVM ? qualityResultVM.fiIdXncl : null);
    self.fiIdHoso = ko.observable(qualityResultVM ? qualityResultVM.fiIdHoso : null);
    self.fiMaHoso = ko.observable(qualityResultVM ? qualityResultVM.fiMaHoso : null);
    self.fiSochungnhan = ko.observable(qualityResultVM ? qualityResultVM.fiSochungnhan : null);
    self.fiTencq = ko.observable(qualityResultVM ? qualityResultVM.fiTencqKt : null); // co quan kiem tra
    self.fiCqChuquan = ko.observable(qualityResultVM ? qualityResultVM.fiTencqCq : null); // co quan chu quan
    self.fiCkNhap = ko.observable(qualityResultVM ? qualityResultVM.fiCkNhap : null);
    self.fiNgaynhapTu = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgaynhapTu) : null);
    self.fiNgaynhapDen = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgaynhapDen) : null);
    self.fiSohopdong = ko.observable(qualityResultVM ? qualityResultVM.fiSohopdong : null);
    self.fiDanhmuc = ko.observable(qualityResultVM ? qualityResultVM.fiDanhmuc : null);
    self.fiHoadon = ko.observable(qualityResultVM ? qualityResultVM.fiHoadon : null);
    self.fiVandon = ko.observable(qualityResultVM ? qualityResultVM.fiVandon : null);
    self.fiTokhainhap = ko.observable(qualityResultVM ? qualityResultVM.fiTokhainhap : null);
    self.fiGiayXuatxu = ko.observable(qualityResultVM ? qualityResultVM.fiGiayXuatxu : null);
    self.fiGiayLuuhanh = ko.observable(qualityResultVM ? qualityResultVM.fiGiayLuuhanh : null);
    self.fiNguoinhap = ko.observable(qualityResultVM ? qualityResultVM.fiNguoinhap : null);
    self.fiGiaydk = ko.observable(qualityResultVM ? qualityResultVM.fiGiaydk : null);
    self.fiNgaydk = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgaydk) : null);
    self.fiTieuchuan = ko.observable(qualityResultVM ? qualityResultVM.fiTieuchuan : null);
    self.fiTieuchuanKthuat = ko.observable(qualityResultVM ? qualityResultVM.fiTieuchuanKthuat : null);
    self.fiQuydinh = ko.observable(qualityResultVM ? qualityResultVM.fiQuydinh : null);
    self.fiGiayChungnhan = ko.observable(qualityResultVM ? qualityResultVM.fiGiayChungnhan : null);
    self.fiTochuccap = ko.observable(qualityResultVM ? qualityResultVM.fiTochuccap : null);
    self.fiNgaycap = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgaycap) : null);
    self.fiNoicap = ko.observable(qualityResultVM ? qualityResultVM.fiNoicap : null);

    self.fiNoiLohang = ko.observable(qualityResultVM ? qualityResultVM.fiNoiLohang : null);
    self.fiNoiky = ko.observable(qualityResultVM ? qualityResultVM.fiNoiky : null);
    self.fiNgayky = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgayky) : null);
    self.fiNguoiky = ko.observable(qualityResultVM ? qualityResultVM.fiNguoiky : null);
    self.fiChucvu = ko.observable(qualityResultVM ? qualityResultVM.fiChucvu : null);
    self.fiHoatdong = ko.observable(qualityResultVM ? qualityResultVM.fiHoatdong : null);
    self.fiNguoitao = ko.observable(qualityResultVM ? qualityResultVM.fiNguoitao : null);
    self.fiNgaytao = ko.observable(qualityResultVM ? new Date(qualityResultVM.fiNgaytao) : null);

    self.lstHangHoa04 = ko.observableArray(qualityResultVM.hangHoa);

    self.strNgayKy = ko.observable(null);
    var dt = self.fiNgayky();
    var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
    var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
    var y = dt.getFullYear();
    var strDateHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
    self.strNgayKy(strDateHtml);

    self.strNgayDangKy = ko.observable(null);
    var dt = self.fiNgaydk();
    var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
    var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
    var y = dt.getFullYear();
    var strDateHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
    self.strNgayDangKy(strDateHtml);

    /**
     * Tro lai man hinh danh sach
     *
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoso !== null) {
            var url = '/mard/p04/hoso/giayXNCL/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.qualityResultVM = d.data;
                        var vm = new QualityResultVM(options);
                        ko.applyBindings(vm, document.getElementById('QualityResultVM'));
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


