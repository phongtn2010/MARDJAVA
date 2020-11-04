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

function getDateText(val) {
    var d = new Date(val);
    var year = d.getFullYear();
    var month = ("0" + (d.getMonth() + 1)).substr(-2);
    var day = ("0" + d.getDate()).substr(-2);

    return  'ngày ' + day + ' tháng ' + month + ' năm ' + year;
}
function ResultVM(options) {
    var self = this;

    self.tenDN = ko.observable(user.companyName);
    self.fiIdCv = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiSoCv = ko.observable(null);
    self.fiTtApdung = ko.observable(null);
    self.fiLoaiDon = ko.observable(null);
    self.fiNgayKy = ko.observable(null);
    self.fiNgayHetHl = ko.observable(null);
    self.fiDiadiemKy = ko.observable(null);
    self.fiNguoiKy = ko.observable(null);
    self.fiCqgsBac = ko.observable(null);
    self.fiCqgsTrung = ko.observable(null);
    self.fiCqgsNam = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);

    self.lstHanghoas = ko.observableArray([]);
    self.lstHanghoasUnique = ko.observableArray([]);
    self.fiNgaygui = ko.observable(null);
    self.fiNgayKyText = ko.observable(null);
    self.fiNgayKyText2 = ko.observable(null);

    self.fiCheDo = ko.observable(null);
    self.fiNgayHetHieuLuc = ko.observable(null);

    var data = null;
    if (options.vanban) {
        data = options.vanban;
    }
    if (data) {
        ko.mapping.fromJS(data[0], {}, self);
        self.fiNgaygui(options.hoso.fiNgaygui ? new Date(options.hoso.fiNgaygui).toDayFirstString() : null);
        self.fiNgayKyText2(data[0].fiNgayKy ? new Date(data[0].fiNgayKy).toDayFirstString() : null);
        self.fiNgayKyText(data[0].fiNgayKy ? getDateText(data[0].fiNgayKy) : null);
        self.fiNgayHetHieuLuc(data[0].fiNgayHetHl ? new Date(data[0].fiNgayHetHl).toDayFirstString() : null);
        self.lstHanghoas(mapTbdhsHanghoa12(data[0].lstHanghoas));
        self.lstHanghoasUnique(mapTbdhsHanghoa12(uniqueTbdhsHanghoa12(data[0].lstHanghoas)));
        
        if (parseInt(options.maThuTuc) === 2 || self.fiLoaiDon() === 2) {
            self.fiCheDo('kiểm tra giảm');
        } else {
            self.fiCheDo('miễn kiểm tra chất lượng');
        }
    }

    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }

}

