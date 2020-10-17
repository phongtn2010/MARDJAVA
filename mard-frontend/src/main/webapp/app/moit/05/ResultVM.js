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

function ResultVM(options) {
    var self = this;
    var data = null;
    if (options.vanban) {
        data = options.vanban;
    }
    if (data) {
        ko.mapping.fromJS(data, {}, self);
        self.fiNamdkNk = ko.observable(options.hoso.fiNamdkNk);
        self.fiNamX1 = ko.observable(options.hoso.fiNamdkNk - 1);
        self.fiNgayKy = ko.observable(new Date(data.fiNgayKy));
        self.fileUrl = data.dinhkem ?
                ko.observable(app.appContext + '/moit/05/download/' + data.dinhkem.fiGuiid + '/' + data.dinhkem.fiIdDk) : null;
        self.fiTenTep = data.dinhkem ? ko.observable(data.dinhkem.fiTenTep) : null;

        self.lstLoaiNguyenlieu = ko.observableArray(options ? options.lstLoaiNguyenlieu : []);
        self.lstNguyenlieus = ko.observableArray(data ? data.lstNguyenlieus : []);

        for (i = 0; i < self.lstNguyenlieus().length; i++) {
            for (j = 0; j < self.lstLoaiNguyenlieu().length; j++) {
                if (self.lstNguyenlieus()[i].fiLoaiNguyenlieu === self.lstLoaiNguyenlieu()[j].fiMaLnl) {
                    self.lstNguyenlieus()[i].fiLoaiNguyenlieu = self.lstLoaiNguyenlieu()[j].fiTenLnl;
                }
                break;
            }
        }
    } else {
        self.fiIdVb = ko.observable(null);
        self.fiIdHoso = ko.observable(null);
        self.fiMaHoso = ko.observable(null);
        self.fiTenCqCap = ko.observable(null);
        self.fiSoVanban = ko.observable(null);
        self.fiNgayKy = ko.observable(null);
        self.fiNguoiKy = ko.observable(null);
        self.fiNoidungVanban = ko.observable(null);

        self.fiHoatdong = ko.observable(null);
        self.fiNguoitao = ko.observable(null);
        self.fiNgaytao = ko.observable(null);
        self.fiNgayCn = ko.observable(null);
        self.lstNguyenlieus = ko.observableArray([]);
        self.dinhkem = ko.observable(null);
        self.fiTenTep = ko.observable(null);
        self.fileUrl = ko.observable(null);
        self.fiNamX1= ko.observable(null);
        self.fiNamdkNk =ko.observable(null);
    }
    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }
}

