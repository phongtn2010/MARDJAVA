function XinrutVM(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(item.fiMaHoso);
    self.noidung = ko.observable(null);
}

function CvCkVM(options) {
    var self = this;
    var data = options.congvan;
    self.fiTenDn = ko.observable(data ? user.companyName : null);
    self.fiSoCongVanCap = ko.observable(data ? data.fiSoCv : null);
    self.fiNoiKy = ko.observable(data ? data.fiNoiky : null);
    self.fiNgayky = ko.observable(data ? new Date(data.fiNgayky) : null);
    self.strNgayKy = ko.observable(null);
    if (self.fiNgayky() !== null) {
        var dt = self.fiNgayky();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strViewHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.strNgayKy(strViewHtml);
    }
    self.fiTenCQ = ko.observable(data ? data.fiTenCqxl : null);
    self.fiDiaChiDn = ko.observable(data ? user.companyAddress : null);
    self.fiTenCuaKhauNhap = ko.observable(data ? data.fiTenCkn : null);
    self.fiTenCuaKhauXuat = ko.observable(data ? data.fiTenCkx : null);
    self.fiTenCuaKhauXuatChuyen = ko.observable(data ? data.fiTenCkChuyen : null);
    self.fiSoGcnKdNk = ko.observable(data ? data.fiSoGcn : null);
    self.fiNgayCapGcnXk = ko.observable(data ? new Date(data.fiNgaykyGcn) : null);
    self.fiTgKiemDichDen = ko.observable(data ? new Date(data.fiCoGtDen) : null);
    self.fiNguoiKy = ko.observable(data ? data.fiNguoiky : null);
    self.lstHangHoa03 = ko.observableArray(data ? data.lstHanghoaCv : []);

    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.btnXinrutCv = function () {
        var dataSend = data;
        delete dataSend['__ko_mapping__'];
        var html = [
            $('#xinrutcv-tmpl').html()
        ].join('');
        delete self.xinrutVm;
        delete self.pop;
        delete self.popConfirm;
        var msg = "Bạn chắc chắn muốn gửi yêu cầu xin rút công văn";
        self.xinrutVm = new XinrutVM(msg, dataSend);

        self.pop = app.popup({
            title: 'Xin rút công văn',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        debugger;
                        app.makePost({
                            url: '/mard/p03/hoso/xinRutCv',
                            data: JSON.stringify({
                                fiIdHoso: dataSend.fiIdHoso,
                                fiMaHoso: dataSend.fiMaHoso,
                                reason: self.xinrutVm.noidung(),
                                requestDate: new Date()
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi xin rút công văn chuyển cửa khẩu thành công');
                                    setTimeout(function () {
                                        History.go(-1);
                                    }, 500);
                                } else {
                                    app.Alert('Không gửi được yêu cầu');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });

        ko.applyBindings(self.xinrutVm, document.getElementById('xinrutcv-form'));
        return false;
    };

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoSo !== null) {
            var url = '/mard/p03/hoso/congvan/' + options.fiMaHoSo;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.congvan = d.data;
                        var vm = new CvCkVM(options);
                        ko.applyBindings(vm, document.getElementById('CvCkVM'));
                    } else {
                        msg = d.data.message ? d.data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                        app.Alert(msg);
                    }
                },
                error: function (e) {
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: NSWLang["common_msg_he_thong_chua_san_sang"],
                        function: 'success'
                    });
                }
            });
        }
    };
    init();
});