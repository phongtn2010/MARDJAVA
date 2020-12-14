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
    self.fiIdGp = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiTenCoquan = ko.observable(null);
    self.fiSoGp = ko.observable(null);
    self.fiNgayky = ko.observable(new Date());
    self.fiNguoiky = ko.observable(null);
    self.fiChucdanhNguoiky = ko.observable(null);
    self.fiDiadiemKy = ko.observable(null);
    self.fiNgayHieuluc = ko.observable(null);
    self.fiNgayHethan = ko.observable(null);
    self.fiThoihan = ko.observable(null);
    self.fiTenDoanhnghiepDk = ko.observable(null);
    self.fiSoDonDk = ko.observable(null);
    self.fiNgayDonDk = ko.observable(null);
    self.fiNguoiDaidien = ko.observable(null);
    self.fiSoCmnd = ko.observable(null);
    self.fiNgaycapCmnd = ko.observable(null);
    self.fiNoicapCmnd = ko.observable(null);
    self.fiLenhxuat = ko.observable(null);
    self.fiCqcLenhxuat = ko.observable(null);
    self.fiTenTeptinGp = ko.observable(null);
    self.fiNoidungTeptinGp = ko.observable(null);
    self.fiTuyenduongTu = ko.observable(null);
    self.fiTuyenduongQua = ko.observable(null);
    self.fiTuyenduongDen = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiTenTt = ko.observable(null);
    self.fiGuiId = ko.observable(null);
    self.fiDuongDan = ko.observable(null);
    self.lstHangHoa = ko.observableArray([]);

    var data = null;
    if (options.vanban) {
        data = options.vanban;

    }
    if (data) {

        ko.mapping.fromJS(data, {}, self);

        self.lstHangHoa = ko.observableArray(data ? data.lstHangHoa : []);
        self.fiNgayky(data ? new Date(data.fiNgayky) : null);
        self.fiNgayHieuluc(data ? new Date(data.fiNgayHieuluc) : null)
        self.fiNgayHethan(data ? new Date(data.fiNgayHethan) : null)
        self.fiNgayDonDk(data ? new Date(data.fiNgayDonDk) : null)
        self.fiNgaycapCmnd(data ? new Date(data.fiNgaycapCmnd) : null)
    }


    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }
    // xu lý dowload ảnh đại diện
    /**
     * check upload 
     */
    self.canUpload = ko.computed(function () {
        return (self.fiTenTeptinGp() == null);
    }, this);


    /**
     * check Download
     */
    self.canDownload = ko.computed(function () {
        return self.fiTenTeptinGp() != null;
    }, this);
    /**
     * url download anh
     */
    self.downloadUrl = ko.computed(function () {
        if (self.fiTenTeptinGp()) {
            return app.appContext + '/bca/02/file/' + self.fiDuongDan() + '/' + self.fiGuiId();
        }
        return null;
    }, this);

    // xu lý dowload ảnh đại diện END
}

