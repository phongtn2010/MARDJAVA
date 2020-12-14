/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global self */

function FeeResponseVM(options) {

    var self = this;
    var feeResponseVM = options.feeResponseVM;
    self.fiIdThanhtoan = ko.observable(feeResponseVM ? feeResponseVM.fiIdThanhtoan : null);
    self.fiMaHoso = ko.observable(feeResponseVM ? feeResponseVM.fiMaHoso : null);
    self.fiNguoinop = ko.observable(feeResponseVM ? feeResponseVM.fiNguoinop : null);
    self.fiSoTaikhoan = ko.observable(feeResponseVM ? feeResponseVM.fiSoTaikhoan : null);
    self.fiTongtien = ko.observable(feeResponseVM ? feeResponseVM.fiTongtien : null);
    self.fiTongtienChu = ko.observable(feeResponseVM ? feeResponseVM.fiTongtienChu : null);
    self.fiNgaynop = ko.observable(feeResponseVM ? new Date(feeResponseVM.fiNgaynop).toShortDateString() : null);
    self.fiSohoadon = ko.observable(feeResponseVM ? feeResponseVM.fiSohoadon : null);
    self.fiNoidung = ko.observable(feeResponseVM ? feeResponseVM.fiNoidung : null);
    self.fiChuyenvien = ko.observable(feeResponseVM ? feeResponseVM.fiChuyenvien : null);
    self.lstDinhkemTTP = ko.observableArray(mapFiles04VM(feeResponseVM ? feeResponseVM.lstDinhkemTTP : null));

    /**
     * Tro lai man hinh danh sach
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
            var url = '/mard/p04/hoso/thanhtoanphi/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.feeResponseVM = d.data;
                        var vm = new FeeResponseVM(options);
                        ko.applyBindings(vm, document.getElementById('FeeResponseVM'));
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


