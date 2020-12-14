/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global self */

function ChargeVM(options) {

    var self = this;
    var chargeVM = options.chargeVM;
    self.phytosanitaryFeeId = ko.observable(chargeVM ? chargeVM.phytosanitaryFeeId : null);
    self.nswFilecode = ko.observable(chargeVM ? chargeVM.nswFilecode : null);
    self.totalFee = ko.observable(chargeVM ? chargeVM.totalFee : null);
    self.note = ko.observable(chargeVM ? chargeVM.note : null);
    self.department = ko.observable(chargeVM ? chargeVM.department : null);
    self.amountInWords = ko.observable(chargeVM ? chargeVM.amountInWords : null);
    self.createrName = ko.observable(chargeVM ? chargeVM.createrName : null);
    self.isActive = ko.observable(null);
    self.createDate = ko.observable(null);
    self.fiDcNgnhan = ko.observable(chargeVM ? chargeVM.fiDcNgnhan : null);
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
            var url = '/mard/p04/hoso/tbphi/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.chargeVM = d.data;
                        var vm = new ChargeVM(options);
                        ko.applyBindings(vm, document.getElementById('ChargeVM'));
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


