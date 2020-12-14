function XNDONVM(options) {
    var self = this;
    var data = options.xnDon;
    self.fiDiadiemKiemdich = ko.observable(data ? data.fiDiadiemKiemdich : null);
    self.fiThoigianKiemdich = ko.observable(data ? new Date(data.fiThoigianKiemdich) : null);
    self.strThoigianKiemdich = ko.observable();
    if (self.fiThoigianKiemdich() !== null) {
        var dt = self.fiThoigianKiemdich();
        var h = dt.getHours();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strViewHtml = "<b>" + h + "</b> giờ, " + "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.strThoigianKiemdich(strViewHtml);
    }
    self.fiSoVaoso = ko.observable(data ? data.fiSoVaoso : null);
    self.fiNgayky = ko.observable(data ? new Date(data.fiNgayky) : null);
    self.strNgayKy = ko.observable();
    if (self.fiNgayky() !== null) {
        var dt = self.fiNgayky();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strViewHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.strNgayKy(strViewHtml);
    }
    self.fiTenCqxl = ko.observable(data ? data.fiTenCqxl : null);
    self.fiNguoiky = ko.observable(data ? data.fiNguoiky : null);
}
