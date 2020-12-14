/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function TbdgcnHanghoa9(d){
    var self = this;
    ko.mapping.fromJS(d, {}, self);
    
    self.resultLable = ko.computed(function(){
        return self.fiDat() == 1 ? 'Đạt':'Không đạt';
    });
    
    self.fiTenPtkt = ko.computed(function(){
        return self.fiPtkt() == 1 ? 'Thường':'Chặt';
    });
};

var mapTbdgcnHanghoa9 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdgcnHanghoa9(item);
    });
};

function ResultVM(options) {
    var self = this;
    var data = options;

    ko.mapping.fromJS(data, {}, self);
    
    var urlParam = app.parseQuerystring();
    
    self.propTitle = ko.observable(NSWLang["moh." + urlParam.maThuTuc + ".tenthutuc"]);
    
    self.fiNgayKyText = ko.observable(null);
    self.fiNgayNkTuText = ko.observable(null);
    self.fifiNgayNkDenText = ko.observable(null);
    
    if(null != data) {
        self.fiNgayKyText(data.fiNgayKy !== null ? new Date(data.fiNgayKy).toDayFirstWithTime() : null);
        self.fiNgayNkTuText(data.fiNgayNkTu !== null ? new Date(data.fiNgayNkTu).toDayFirstWithTime() : null);
        self.fifiNgayNkDenText(data.fiNgayNkDen !== null ? new Date(data.fiNgayNkDen).toDayFirstWithTime() : null); 
    }

    self.fiTenTep = ko.observable((data.hasOwnProperty('dinhKem') && null !== data.dinhKem) ? data.dinhKem.fiTenTep : null);
    self.fiDuongDan = ko.observable((data.hasOwnProperty('dinhKem') && null !== data.dinhKem) ? data.dinhKem.fiDuongDan : null);
    
    self.downloadUrl = ko.observable();
 
    if(null !== data) {
        var url = app.appContext + '/moh/09/result/';
        var guiid = data.hasOwnProperty('dinhKem') && null !== data.dinhKem ? data.dinhKem.fiGuiId : null;
        url = url + self.fiIdHoso() + '/' + self.fiMaHoso() + '/' + self.fiIdGcn() + '/' + guiid;
        self.downloadUrl(url);
    }
    
    self.lstHangHoas = ko.observable(mapTbdgcnHanghoa9(data.lstHangHoas));
    
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
        var url_result = '/moh/09/hoso/gcn';
        app.makePost({
            url: url_result,
            data: JSON.stringify({
                fiIdHoso: options.fiIdHoso,
                fiMaHoso: options.fiMaHoso
            }),
            success: function (d) {
                if (d.success) {
                    if (d.data !== null) {
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

