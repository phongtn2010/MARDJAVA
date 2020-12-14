function SuaGcnVM(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(item.fiMaHoso);
    self.fiNoidungYc = ko.observable(null);
}

function XinHuyGcnVM(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(item.fiMaHoso);
    self.lydoHuy = ko.observable(null);
}

function GiayCNVM16b(options) {
    var self = this;
    var giayCnhan = options.giayCNVM;
    self.id = ko.observable(giayCnhan ? giayCnhan.id : null);
    self.fiIdHoso = ko.observable(giayCnhan ? giayCnhan.fiIdHoso : null);
    self.fiMaHoso = ko.observable(giayCnhan ? giayCnhan.fiMaHoso : null);
    self.fiTrangthai = ko.observable(giayCnhan ? giayCnhan.fiTrangthai : null);
    self.fiTenTrangthai = ko.observable(giayCnhan ? giayCnhan.fiTenTrangthai : null);
    self.fiLydo = ko.observable(giayCnhan ? giayCnhan.fiLydo : null);
    self.fiMaCqxl = ko.observable(giayCnhan ? giayCnhan.fiMaCqxl : null);
    self.fiTenCqxl = ko.observable(giayCnhan ? giayCnhan.fiTenCqxl : null);
    self.fiSoGcn = ko.observable(giayCnhan ? giayCnhan.fiSoGcn : null);
    self.fiTenNgXh = ko.observable(giayCnhan ? giayCnhan.fiTenNgXh : null);
    self.fiTenChuhang = ko.observable(giayCnhan ? giayCnhan.fiTenChuhang : null);
    self.fiDiachiChuhang = ko.observable(giayCnhan ? giayCnhan.fiDiachiChuhang : null);
    self.fiNguoiNhanhang = ko.observable(giayCnhan ? giayCnhan.fiNguoiNhanhang : null);
    self.fiTenCkx = ko.observable(giayCnhan ? giayCnhan.fiTenCkx : null);
    self.fiMaCkx = ko.observable(giayCnhan ? giayCnhan.fiMaCkx : null);
    self.fiTenCkn = ko.observable(giayCnhan ? giayCnhan.fiTenCkn : null);
    self.fiMaCkn = ko.observable(giayCnhan ? giayCnhan.fiMaCkn : null);
    self.fiTgTung = ko.observable(giayCnhan ? new Date(giayCnhan.fiTgTung) : null);
    self.fiTgDenng = ko.observable(giayCnhan ? new Date(giayCnhan.fiTgDenng) : null);
    self.fiSoContainer = ko.observable(giayCnhan ? giayCnhan.fiSoContainer : null);
    self.fiLotrinh = ko.observable(giayCnhan ? giayCnhan.fiLotrinh : null);
    self.fiGiatriDenng = ko.observable(giayCnhan ? new Date(giayCnhan.fiGiatriDenng) : null);
    self.fiBacsy = ko.observable(giayCnhan ? giayCnhan.fiBacsy : null);
    self.fiNgayky = ko.observable(giayCnhan ? new Date(giayCnhan.fiNgayky) : null);
    self.fiNguoiky = ko.observable(giayCnhan ? giayCnhan.fiNguoiky : null);
    self.fiNoiky = ko.observable(giayCnhan ? giayCnhan.fiNoiky : null);
    self.fiHoatdong = ko.observable(giayCnhan ? giayCnhan.fiHoatdong : null);
    self.fiNgaytao = ko.observable(giayCnhan ? new Date(giayCnhan.fiNgaytao) : null);
    self.fiNguoitao = ko.observable(giayCnhan ? giayCnhan.fiNguoitao : null);

    self.lstHanghoaSpdv = ko.observableArray(giayCnhan ? giayCnhan.lstHanghoaSpdv : []);
    self.tbdGcnKdspdvXnck03 = ko.observable(giayCnhan ? giayCnhan.tbdGcnKdspdvXnck03 : null);
    self.noidungCNText = ko.observable(giayCnhan && giayCnhan.tbdGcnKdspdvXnck03 ? giayCnhan.tbdGcnKdspdvXnck03.fiNoidung : null);
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    self.btnXinSuaGCNClick = function () {
        var dataSend = giayCnhan;
        delete dataSend['__ko_mapping__'];
        var html = [
            $('#suaGCN-tmpl').html()
        ].join('');
        delete self.suaGcnVM;
        delete self.pop;

        delete self.popConfirm;

        self.suaGcnVM = new SuaGcnVM('Bạn chắc chắn muốn gửi yêu cầu sửa giấy chứng nhận', giayCnhan);

        self.pop = app.popup({
            title: 'Xin sửa giấy chứng nhận',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.makePost({
                            url: '/mard/p03/hoso/yc-suaGCN',
                            data: JSON.stringify({
                                fiIdHoso: giayCnhan.fiIdHoso,
                                fiMaHoso: giayCnhan.fiMaHoso,
                                reason: self.suaGcnVM.fiNoidungYc(),
                                tbdGcnKdspdv03: dataSend,
                                fiSoGcn: giayCnhan.fiSoGcn,
                                requestDate: new Date()
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi xin sửa giấy chứng nhận thành công');
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

        ko.applyBindings(self.suaGcnVM, document.getElementById('suaGCN-form'));
        return false;
    };

    self.btnDNXinHuyGCN = function () {
        var dataSend = giayCnhan;
        delete dataSend['__ko_mapping__'];
        var html = [
            $('#xinhuyGcn-tmpl').html()
        ].join('');
        delete self.xinHuyGcnVM;
        delete self.pop;
        delete self.popConfirm;

        self.xinHuyGcnVM = new XinHuyGcnVM('Bạn chắc chắn muốn gửi yêu cầu xin hủy giấy chứng nhận', giayCnhan);

        self.pop = app.popup({
            title: 'Xin hủy giấy chứng nhận',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.makePost({
                            url: '/mard/p03/hoso/xinHuyGCN',
                            data: JSON.stringify({
                                fiIdHoso: giayCnhan.fiIdHoso,
                                fiMaHoso: giayCnhan.fiMaHoso,
                                reason: self.xinHuyGcnVM.lydoHuy(),
                                tbdGcnKdspdv03: dataSend,
                                fiSoGcn: giayCnhan.fiSoGcn,
                                requestDate: new Date()
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi xin hủy giấy chứng nhận thành công');
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

        ko.applyBindings(self.xinHuyGcnVM, document.getElementById('xinhuyGcn-form'));
        return false;
    };
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoSo !== null) {
            var url = '/mard/p03/hoso/giayCnkdspdv/' + options.fiMaHoSo;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.giayCNVM = d.data;
                        var vm = new GiayCNVM16b(options);
                        ko.applyBindings(vm, document.getElementById('GiayCNVM16b'));
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