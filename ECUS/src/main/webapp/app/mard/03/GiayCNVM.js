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

function GiayCNVM(options) {
    var self = this;
    var giayCnhan = options.giayCNVM;
    self.id = ko.observable(giayCnhan ? giayCnhan.id : null);
    self.fiIdHoso = ko.observable(giayCnhan ? giayCnhan.fiIdHoso : null);
    self.fiMaHoso = ko.observable(giayCnhan ? giayCnhan.fiMaHoso : null);
    self.fiLydoSua = ko.observable(giayCnhan ? giayCnhan.fiLydoSua : null);
    self.fiMaCqlx = ko.observable(giayCnhan ? giayCnhan.fiMaCqlx : null);
    self.fiTenCqxl = ko.observable(giayCnhan ? giayCnhan.fiTenCqxl : null);
    self.fiSoGcn = ko.observable(giayCnhan ? giayCnhan.fiSoGcn : null);
    self.fiTendiachiNgXh = ko.observable(giayCnhan ? giayCnhan.fiTendiachiNgXh : null);
    self.fiTenChuhang = ko.observable(giayCnhan ? giayCnhan.fiTenChuhang : null);
    self.fiTendiachiNgNhanhang = ko.observable(giayCnhan ? giayCnhan.fiTendiachiNgNhanhang : null);
    self.fiTenCkXuat = ko.observable(giayCnhan ? giayCnhan.fiTenCkXuat : null);
    self.fiMaCkXuat = ko.observable(giayCnhan ? giayCnhan.fiMaCkXuat : null);
    self.fiTenCkNhap = ko.observable(giayCnhan ? giayCnhan.fiTenCkNhap : null);
    self.fiMaCkNhap = ko.observable(giayCnhan ? giayCnhan.fiMaCkNhap : null);
    self.fiTgLuulaiTung = ko.observable(giayCnhan ? new Date(giayCnhan.fiTgLuulaiTung) : null);
    self.fiTgLuulaiDenng = ko.observable(giayCnhan ? new Date(giayCnhan.fiTgLuulaiDenng) : null);
    self.fiTongso = ko.observable(giayCnhan ? giayCnhan.fiTongso : null);
    self.fiSoContainer = ko.observable(giayCnhan ? giayCnhan.fiSoContainer : null);
    self.fiLotrinh = ko.observable(giayCnhan ? giayCnhan.fiLotrinh : null);
    self.fiGiatriDen = ko.observable(giayCnhan ? new Date(giayCnhan.fiGiatriDen) : null);
    self.fiBacsyThuy = ko.observable(giayCnhan ? giayCnhan.fiBacsyThuy : null);
    self.fiNgayky = ko.observable(giayCnhan ? new Date(giayCnhan.fiNgayky) : null);
    self.fiNguoiky = ko.observable(giayCnhan ? giayCnhan.fiNguoiky : null);
    self.fiNoiky = ko.observable(giayCnhan ? giayCnhan.fiNoiky : null);
    self.fiHoatdong = ko.observable(giayCnhan ? giayCnhan.fiHoatdong : null);
    self.fiNgaytao = ko.observable(giayCnhan ? new Date(giayCnhan.fiNgaytao) : null);
    self.fiNguoitao = ko.observable(giayCnhan ? giayCnhan.fiNguoitao : null);
    self.fiDiachiChuhang = ko.observable(giayCnhan ? giayCnhan.fiDiachiChuhang : null);
    self.fiTrangthai = ko.observable(giayCnhan ? giayCnhan.fiTrangthai : null);
    self.fiTenTrangthai = ko.observable(giayCnhan ? giayCnhan.fiTenTrangthai : null);

    self.lstHanghoaKddv03 = ko.observableArray(giayCnhan ? giayCnhan.lstHanghoaKddv03 : []);
    self.tbdXNCuakhauxuat = ko.observable(giayCnhan ? giayCnhan.tbdXNCuakhauxuat : null);
    self.noidungCNText = ko.observable(giayCnhan && giayCnhan.tbdXNCuakhauxuat ? giayCnhan.tbdXNCuakhauxuat.fiNoidung : null);
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
        var msg = "Bạn chắc chắn muốn gửi yêu cầu sửa giấy chứng nhận";
        self.suaGcnVM = new SuaGcnVM(msg, giayCnhan);

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
                                tbdGcnKiemdichDv03: dataSend,
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
        var msg = "Bạn chắc chắn muốn gửi yêu cầu xin hủy giấy chứng nhận";
        self.xinHuyGcnVM = new XinHuyGcnVM(msg, giayCnhan);

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
                                tbdGcnKiemdichDv03: dataSend,
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
            var url = '/mard/p03/hoso/giayCnkddv/' + options.fiMaHoSo;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.giayCNVM = d.data;
                        var vm = new GiayCNVM(options);
                        ko.applyBindings(vm, document.getElementById('GiayCNVM'));
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