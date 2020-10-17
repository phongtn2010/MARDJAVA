/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var triggerTab = function (tab) {
    var $tab = $('#' + tab);
    if ($tab.length > 0) {// ?
        $tab.trigger('click');
    }
};
function ThongBaoVM(options) {
    debugger;
    self = this;
    var data = null;
    var code = '';
    console.log(options);
    
    if (options.thongbao) {
        data = options.thongbao;

        if (data) {
            code = data.dinhkem != null ? data.dinhkem.fiTenteptin : '';
        }
    }

    ko.mapping.fromJS(data, {}, self);
    
    self.fiNgayKy = ko.observable(data != null ? new Date(data.fiNgayKy).toDayFirstWithTime() : null);
    if (data != null) {
        self.lstNguongen9(data.hasOwnProperty('lstNguongen9') ? mapTbdnguongen9(data.lstNguongen9) : []);
        self.lstMaugen9(data.hasOwnProperty('lstMaugen9') ? mapTbdMauGen9(data.lstMaugen9) : []);
        self.fiTenTep = ko.observable(data.dinhkem != null ? data.dinhkem.fiTenTep : null);
        self.fiTenLoaiTep = ko.observable(data.dinhkem != null ? data.dinhkem.fiTenLoaiTep : null);
        self.fiDuongdan = ko.observable(data.dinhkem != null ? data.dinhkem.fiDuongdan : null);
        self.fiTenTepTin = ko.observable(data.dinhkem != null ? data.dinhkem.fiTenteptin : null);
        self.fiMucDich = ko.observable(data != null ? data.fiMucDich.toString() : null);
        self.fiThoiGianBatDau = ko.observable(data != null ? new Date(data.fiThoiGianBatDau).toDayFirstWithTime() : null);
        self.fiThoiGianKetThuc = ko.observable(data != null ? new Date(data.fiThoiGianKetThuc).toDayFirstWithTime() : null);
        self.fiCachThucThuThap = ko.observable(data != null ? data.fiCachThucThuThap : null);
        self.fiNguoiDaiDien = ko.observable(data != null ? data.fiNguoiDaiDien : null);
        self.fiDiaChiCc = ko.observable(data != null ? data.fiDiaChiCc : null);
        self.fiChucVuCc = ko.observable(data != null ? data.fiChucVuCc : null);
        self.fiSdtCc = ko.observable(data != null ? data.fiSdtCc : null);
        self.fiFaxCc = ko.observable(data != null ? data.fiFaxCc : null);
        self.fiSuDungNguonGen = ko.observable(data != null ? data.fiSuDungNguonGen : null);
        self.fiSoLuong = ko.observable(data != null ? data.fiSoLuong : null);
        if (self.fiMucDich() == 1) {
            $('#fiMucdich').prop('checked', true);
        }
        if (self.fiMucDich() == 2) {
            $('#fiHoctap').prop('checked', true);
        }




    }
    self.lstLohangNk = ko.observable(data != null ? data.lstLohangNk : null);

    self.exportHref = ko.observable(app.appContext + '/monre/09/tbfile/' + options.fiIdHoso + '/' + options.fiMaHoso + '/' + code);

    if (options.tab == "mau") {
        triggerTab('a-tab-monre09-2');
    }
    self.editMauGenClick = function (item) {
        self.MauGenClick(item);
        return false;
    };
    self.MauGenClick = function (item) {
        var html = [
            $('#mauGen-template').html()
        ].join('');
        delete self.thongTinMauGenpop;
        delete self.mauGen09FormVM;
        options.mauGen = item;
        self.mauGen = new mauGen09FormVM(options);
        self.mauGen.slcNguonGen = ko.observableArray(mapCategory(self.lstNguongen9(), "fiIdNguongen", "fiTenThongThuong"));

        self.thongTinMauGenpop = app.popup({
            title: 'Mẫu nguồn gen dự kiến tiếp cận',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.thongTinMauGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
                function () {
                    ko.applyBindings(self.mauGen, document.getElementById('mauGen-vm'));
                });
        return false;
    };
    self.editTTGenClick = function (item) {
        self.NguonGenDKClick(item);
        return false;
    };
    self.NguonGenDKClick = function (item) {

        var html = [
            $('#NguonGen-template').html()
        ].join('');
        delete self.NguonGenpop;
        delete self.ThongTinGen09FormVM;
        options.tTGen = item;
        self.ttGen = new ThongTinGen09FormVM(options);
        self.NguonGenpop = app.popup({
            title: 'Nguồn gen đăng ký tiếp cận',
            html: html,
            width: 1000,
            buttons: [

                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.NguonGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
                function () {
                    ko.applyBindings(self.ttGen, document.getElementById('NguonGenpop'));
                });
        return false;
    };
}