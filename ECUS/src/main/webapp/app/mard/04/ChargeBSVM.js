/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global self */

function ChargeBSVM(options) {

    var self = this;
    var chargeBSVM = options.chargeBSVM;
    self.fiId = ko.observable(chargeBSVM ? chargeBSVM.fiId : null);
    self.fiMaHoso = ko.observable(chargeBSVM ? chargeBSVM.fiMaHoso : null);
    self.fiTongtien = ko.observable(chargeBSVM ? chargeBSVM.fiTongtien : null);
    self.fiNoidung = ko.observable(chargeBSVM ? chargeBSVM.fiNoidung : null);
    self.fiDonviXuly = ko.observable(chargeBSVM ? chargeBSVM.fiDonviXuly : null);
    self.fiTongtienChu = ko.observable(chargeBSVM ? chargeBSVM.fiTongtienChu : null);
    self.fiChuyenvienXuly = ko.observable(chargeBSVM ? chargeBSVM.fiChuyenvienXuly : null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
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
            var url = '/mard/p04/hoso/tbphibs/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.chargeBSVM = d.data;
                        var vm = new ChargeBSVM(options);
                        ko.applyBindings(vm, document.getElementById('ChargeBSVM'));
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


