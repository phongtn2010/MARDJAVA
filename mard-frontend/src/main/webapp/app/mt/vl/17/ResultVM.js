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

    self.fiIdVb = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiSoVanban = ko.observable(null);
    self.fiSoCvanDn = ko.observable(null);
    self.fiNgayCvDn = ko.observable(null);
    self.fiTenDn = ko.observable(null);
    self.fiTuyenDi = ko.observable(null);
    self.fiTuyenDen = ko.observable(null);
    self.fiBenDi = ko.observable(null);
    self.fiMaTinhDi = ko.observable(null);
    self.fiTenTinhDi = ko.observable(null);
    self.fiBenDen = ko.observable(null);
    self.fiMaTinhDen = ko.observable(null);
    self.fiTenTinhDen = ko.observable(null);
    self.fiKhoangcach = ko.observable(null);
    self.fiHanhtrinh = ko.observable(null);
    self.fiMaCkXn = ko.observable(null);
    self.fiTenCkXn = ko.observable(null);
    self.fiSoChuyen = ko.observable(null);
    self.fiDieuSo = ko.observable(null);
    self.fiSoThongtu = ko.observable(null);
    self.fiNgThongtu = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiSoxeTgVt = ko.observable(null);
    self.fiSoGtvtVn = ko.observable(null);
    self.fiSoCcvtLao = ko.observable(null);
    self.fiBenXe = ko.observable(null);
    self.fiTentinhLao = ko.observable(null);
    self.lstXe = ko.observableArray([]);
    self.lstDinhKem = ko.observableArray([]);
    self.TbdvbCqxlky2 = ko.observable(null);
    self.fiNgayky = ko.observable(null);
    self.fiDiaDiem = ko.observable(null);

    if (options.vanban) {
        data = options.vanban;
    }
    if (data) {
        ko.mapping.fromJS(data, {}, self);
        self.fiNgayky(data.chuKyCqxl.fiNgayky);
        self.fiDiaDiem(data.chuKyCqxl.fiDiaDiem);
    } 
    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }
}

