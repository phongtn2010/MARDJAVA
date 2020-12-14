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

function ResutlAttachment(item, type, idCongvan, idHoso, fiMaHoso) {
    var self = this;
    self.attachType = ko.observable(type);
    self.downloadUrl = ko.observable(type);
    self.fiIdCv = ko.observable(idCongvan);
    self.fiIdHoso = ko.observable(idHoso);
    self.fiMaHoso = ko.observable(fiMaHoso);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
        
        var url = app.appContext + '/moh/18/result/';
        
        url = url + self.fiIdHoso() + '/' + self.fiMaHoso() + '/'
                + self.attachType() + '/' + self.fiIdCv() + '/' + self.fiGuiid();
        self.downloadUrl(url);
    }
}

function ResultVM(options) {
    var self = this;
    var data = null;
    self.lstDinhKems = ko.observableArray([]);
    self.fiNgayKyText = ko.observable(null);
    self.fiNgayHetHlText = ko.observable(null);
    self.fiCoQuanCap = ko.observable(null);
    self.fiSoCongVan = ko.observable(null);
    self.fiNguoiKy = ko.observable(null);
    
    if (options.vanban) {
        data = options.vanban;
    }
    
    if (null != data) {
        
        ko.mapping.fromJS(data, {}, self);
    
        self.fiNgayKyText = ko.observable(data != null ? new Date(data.fiNgayKy).toDayFirstWithTime() : null);
        self.fiNgayHetHlText = ko.observable(data != null ? new Date(data.fiNgayHetHl).toDayFirstWithTime() : null);
        
        if (data.hasOwnProperty('dinhKemCongVanVi') && null !== data.dinhKemCongVanVi) {
            self.lstDinhKems.push(new ResutlAttachment(data.dinhKemCongVanVi, 1,
                    data.fiIdCv, data.fiIdHoso, data.fiMaHoso));
        }

        if (data.hasOwnProperty('dinhKemCongVanEn') && null !== data.dinhKemCongVanEn) {
            self.lstDinhKems.push(new ResutlAttachment(data.dinhKemCongVanEn, 2,
                    data.fiIdCv, data.fiIdHoso, data.fiMaHoso));
        }
    }

    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }
}

