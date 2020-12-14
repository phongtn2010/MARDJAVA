/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function QuyetDinhVM(data) {
    self = this;

    self.fiSoGp = ko.observable(data != null ? data.fiSoGp : '');
    
    self.fiTenDn = ko.observable(data != null ? data.fiTenDn : user.companyName);    
    self.fiDiachiDn = ko.observable(data != null ? data.fiDiachiDn : user.fiDiachiDn);
    self.fiDtDn = ko.observable(data != null ? data.fiDtDn : user.fiDtDn);
    self.fiFaxDn = ko.observable(data != null ? data.fiFaxDn : user.fiFaxDn);
    
    self.hangHoas = ko.observableArray(data != null ? data.hangHoas : []);
    self.fiNgayHhan = ko.observable(data != null ? data.fiNgayHhan : null);
    self.fiNgayHetHanText = ko.observable(data ? new Date(data.fiNgayHhan).toDayFirstString() : null);
    self.fiNguoiKy = ko.observable(data != null ? data.fiNguoiKy : null);
    
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    
//    self.exportHref = ko.observable(app.appContext + "/most/04/hoso/gcn/" + (data !== null ? data.fiIdHoso : 0));
    self.exportHref = ko.observable(app.appContext + "/most/04/gcnfile/" + (data !== null ? data.dinhkem.fiIdDk : 0));
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    if (options && options.fiIdHoso > 0) {
        var url = '/most/04/hoso/quyetdinh';
        app.makePost({
            url: url,
            data: JSON.stringify({
                fiIdHoso: options.fiIdHoso,
                fiMaHoso: options.fiMaHoso
            }),
            success: function (d) {
                if (d.success) {
                    if (d.data != null) {
                    }
                    var resultViewVM = new QuyetDinhVM(d.data);
                    ko.applyBindings(resultViewVM, document.getElementById('Most04View'));
                } else {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            },
            error: function (e) {
                app.Alert('Không lấy được dữ liệu hồ sơ');
            }
        });
    } else {
        app.Alert('Không lấy được dữ liệu hồ sơ')
    }
});



