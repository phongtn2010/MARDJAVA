/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function QuyetDinhVM(data) {
    self = this;

    self.fiIdQd = ko.observable(data != null ? data.fiIdQd : '');
    self.fiSoQd = ko.observable(data != null ? data.fiSoQd : '');
    self.fiThongTinCongTy = ko.observable(user ? user.companyName + '(' + user.companyAddress + ')' : '');
    self.fiTenCongTy = ko.observable(user ? user.companyName : '');
    self.lstHanghoa = ko.observableArray(data != null ? data.hangHoas : []);
    self.fiNgayHetHan = ko.observable(data != null ? data.fiNgayHetHan : null);
    self.fiNgayHetHanText = ko.observable(data ? new Date(data.fiNgayHetHan).toDayFirstString() : null);
    self.fiNguoiKyQD = ko.observable(data != null ? data.fiNguoiKyQD : null);
    self.fiSoLuongMau = ko.observable(data != null ? data.hangHoas.length : 0);

    self.fiThongTinHangHoa = ko.computed(function () {
        var dic = {};
        var text = '';
        ko.utils.arrayForEach(this.lstHanghoa(), function (item) {
           
            var kieu = Util.boDauTiengViet(item.fiKieu);
            if (dic.hasOwnProperty(kieu)) {
                dic[kieu].count = dic[kieu].count + 1;
            } else {
                dic[kieu] = {count: 1, kieu: item.fiKieu, name: item.fiTenHh, nsx: item.fiTenNsx, qgsx: item.fiTenQg};
            }
            
        });
        //console.log(dic);
        for (var prop in dic) {
            if (!dic.hasOwnProperty(prop))
                continue;
            text += dic[prop]['count'] + ' ' + dic[prop]['name'] + ', kiểu ' + dic[prop]['kieu'] + ', hãng ' + dic[prop]['nsx'] + '-' + dic[prop]['qgsx'] + ' sản xuất;'
        }
        return text;
    }, self);

    self.showTCTab = ko.observable(data != null && data.fiSoCvTuchoi != null ? true : false);
    self.dinhkem1VM = ko.observable(new DinhKemQuyetDinhVM(data));
    self.dinhkem2VM = ko.observable(new CongVanTuChoiVM(data));

    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    self.exportHref = ko.observable(app.appContext + "/most/03/quyetDinhFile/" + (data !== null ? data.fiMaHoso : 0)+ "/8");
}

function DinhKemQuyetDinhVM(data) {
    var self = this;
    self.files = ko.observableArray((data !== null && data.hasOwnProperty('dinhKems')) ? ListTbddinhkem3QDModel(data.dinhKems) : []);
    self.dinhKems = ko.computed(function () {
        return ko.utils.arrayFilter(self.files(), function (item) {
            return parseInt(item.fiMaLoai()) <= 9;
        });
    }, self);
}

function CongVanTuChoiVM(data) {
    var self = this;
    self.showTCTab = ko.observable(data != null && data.fiSoCvTuchoi != null ? true : false);
    self.files = ko.observableArray((data !== null && data.hasOwnProperty('dinhKems')) ? ListTbddinhkem3QDModel(data.dinhKems) : []);
    self.dinhKems = ko.computed(function () {
        return ko.utils.arrayFilter(self.files(), function (item) {
            return parseInt(item.fiMaLoai()) >= 8;
        });
    }, self);
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    if (options && options.fiIdHoso > 0) {
        var url = '/most/03/hoso/quyetdinh';
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
                    ko.applyBindings(resultViewVM, document.getElementById('Most03View'));
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



