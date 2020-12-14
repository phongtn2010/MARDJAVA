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
    self.fiIdCapgiayphep = ko.observable(null);
    self.fiCoQuanCap = ko.observable(null);
    self.fiSoGiayPhep = ko.observable(null);
    self.fiNgayKy = ko.observable(null);
    self.fiNguoiKy = ko.observable(null);
    self.fiHieulucTungay = ko.observable(null);
    self.fiHieulucDenngay = ko.observable(null);
    self.fiTenTepTin = ko.observable(null);
    self.fiNoidungTepTin = ko.observable(null);
    self.fiLoaiHs = ko.observable(null);
    self.fiTrangThai = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgaycapnhat = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiGuiid = ko.observable(null);
    self.fiDuongdan = ko.observable(null);

    self.lstDactrungnguon05 = ko.observableArray([]);

    var data = null;
    if (options.giayphep) {
        data = options.giayphep;

    }
    if (data) {
        ko.mapping.fromJS(data, {}, self);
        self.lstDactrungnguon05 = ko.observableArray(data ? data.lstDactrungnguon05 : []);
        self.fiNgayKy(data ? new Date(data.fiNgayKy) : null);
        self.fiHieulucTungay(data ? new Date(data.fiHieulucTungay) : null)
        self.fiHieulucDenngay(data ? new Date(data.fiHieulucDenngay) : null)
    }


    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }
    // xu lý dowload ảnh đại diện
    /**
     * check upload 
     */


    /**
     * check Download
     */
    self.canDownload = ko.computed(function () {
        return self.fiTenTepTin() != null;
    }, this);
    /**
     * url download anh
     */
    self.downloadUrl = ko.computed(function () {
        if (self.fiTenTepTin()) {
            return app.appContext + '/most/p05/file/' + self.fiDuongdan() + '/'  + self.fiGuiid();
        }
        return null;
    }, this);

    // xu lý dowload ảnh đại diện END
}

