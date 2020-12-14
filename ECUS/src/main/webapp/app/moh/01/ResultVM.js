/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function TbdgpHanghoa1(data) {
    var self = this;

    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdGpHh = ko.observable(data ? data.fiIdGpHh : null);
    self.fiIdGp = ko.observable(data ? data.fiIdGp : null);
    self.fiTenCp = ko.observable(data ? data.fiTenCp : null);
    self.fiHamLuong = ko.observable(data ? data.fiHamLuong : null);
    self.fiTacDungCp = ko.observable(data ? data.fiTacDungCp : null);
    self.fiDviTinh = ko.observable(data ? data.fiDviTinh : null);
    self.fiSoLuong = ko.observable(data ? data.fiSoLuong : null);
    self.fiTenNsx = ko.observable(data ? data.fiTenNsx : null);
}

var mapTbdgpHanghoa1 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdgpHanghoa1(item);
    });
};


function ResultVM(options) {
    var self = this;
    var data = options;

    ko.mapping.fromJS(data, {}, self);

    self.fiNgayKyText = ko.observable(data != null ? new Date(data.fiNgayKy).toDayFirstString() : null);
    self.fiNgayHethanText = ko.observable(data != null ? new Date(data.fiNgayHethan).toDayFirstString() : null);

    self.fiTenTep = ko.observable(data.hasOwnProperty('dinhKem') && null != data.dinhKem ? data.dinhKem.fiTenTep : null);
    self.fiDuongDan = ko.observable(data.hasOwnProperty('dinhKem') && null != data.dinhKem ? data.dinhKem.fiDuongDan : null);

    self.lstItems = ko.observableArray(null != data ? mapTbdgpHanghoa1(data.lstHangHoas) : []);
    //self.lstNguoiChiuTrachNhiems = ko.observableArray(null != data ? mapNguoiTnVM(data.lstNguoiChiuTrachNhiems) : []);

    self.downloadUrl = ko.observable();

    var url = app.appContext + '/moh/01/result/';
    var guiid = data.hasOwnProperty('dinhKem') && null != data.dinhKem ? data.dinhKem.fiGuiId : null;
    url = url + self.fiIdHoso() + '/' + self.fiMaHoso() + '/'
            + '/' + self.fiIdGp() + '/' + guiid;
    self.downloadUrl(url);
    
    self.propTitle = ko.observable(NSWLang["moh_" + options.maThuTuc + "_tenthutuc"]);

    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    
    var cb = function (_d) {
        
        var resultVM = new ResultVM(_d);
        
        ko.applyBindings(resultVM, document.getElementById('ResultVM'));
    };
    
    if (options && options.fiIdHoso > 0) {
        var url_result = '/moh/01/hoso/gcn';
        app.makePost({
            url: url_result,
            data: JSON.stringify({
                fiIdHoso: options.fiIdHoso,
                fiMaHoso: options.fiMaHoso
            }),
            success: function (d) {
                if (d.success) {
                    if (d.data != null) {
                        var _d = d.data;
                        _d.maThuTuc = options.maThuTuc;
                        cb(_d);
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

