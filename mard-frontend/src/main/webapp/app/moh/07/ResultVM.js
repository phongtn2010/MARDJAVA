/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);


function ResultVM(options) {
    var self = this;
    var data = options;

    ko.mapping.fromJS(data, {}, self);

    self.fiNgayKyText = ko.observable(data != null ? new Date(data.fiNgayKy).toDayFirstWithTime() : null);
    self.fiHieulucTuText = ko.observable(data != null ? new Date(data.fiHieulucTu).toDayFirstWithTime() : null);
    self.fiHieulucDenText = ko.observable(data != null ? new Date(data.fiHieulucDen).toDayFirstWithTime() : null);

    self.fiTenTep = ko.observable(data.hasOwnProperty('dinhKem') ? data.dinhKem.fiTenTep : null);
    self.fiDuongDan = ko.observable(data.hasOwnProperty('dinhKem') ? data.dinhKem.fiDuongDan : null);
    var urlItems = app.parseQuerystring();
    self.isShowCSBH = ko.computed(function () {        
        return urlItems.maThuTuc == PROCEDUCE.MOH_07;
    });
    
    self.downloadUrl = ko.observable();

    var url = app.appContext + '/moh/07/result/';
    var guiid = data.hasOwnProperty('dinhKem') && null != data.dinhKem ? data.dinhKem.fiGuiId : null;
    url = url + self.fiIdHoso() + '/' + self.fiMaHoso() + '/' + self.fiIdGcn() + '/' + guiid;
    self.downloadUrl(url);
    
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

$(document).ready(function () {
    var options = app.parseQuerystring();

    var cb = function () {
        var resultVM = new ResultVM(options);
        ko.applyBindings(resultVM, document.getElementById('ResultVM'));
    };

    if (options && options.fiIdHoso > 0) {
        var url_result = '/moh/07/hoso/gcn';
        app.makePost({
            url: url_result,
            data: JSON.stringify({
                fiIdHoso: options.fiIdHoso,
                fiMaHoso: options.fiMaHoso
            }),
            success: function (d) {
                if (d.success) {
                    if (d.data != null) {
                        options = d.data;
                        cb();
                    }
                }
            },
            error: function (e) {
                app.Alert('Không lấy được dữ liệu giấy chứng nhận.');
                cb();
            }
        });
    } else {
        app.Alert('Bạn phải chọn hồ sơ cần xem.');
    }
});

