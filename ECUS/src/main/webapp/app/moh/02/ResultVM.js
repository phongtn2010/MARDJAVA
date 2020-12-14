function ResultVM(options) {
    var self = this;
    var giayphep = options.resultVM;

    self.fiIdHoso = ko.observable(giayphep ? giayphep.fiIdHoso : null);
    self.fiCqCap = ko.observable(giayphep ? giayphep.fiCqCap : null);
    self.fiSoCongvan = ko.observable(giayphep ? giayphep.fiSoCongvan : null);
    self.fiNgayky = ko.observable(giayphep ? new Date(giayphep.fiNgayky) : null);
    self.fiNguoiky = ko.observable(giayphep ? giayphep.fiNguoiky : null);
    self.fiTenCongvan = ko.observable(giayphep ? giayphep.fiTenCongvan : null);
    self.fiNoidungTeptin = ko.observable(giayphep ? giayphep.fiNoidungTeptin : null);
    self.fiMst = ko.observable(giayphep ? giayphep.fiMst : null);
    self.fiTendoanhnghiep = ko.observable(giayphep ? giayphep.fiTendoanhnghiep : null);
    self.fiLinkNoidung = ko.observable(giayphep ? giayphep.fiLinkNoidung : null);
    self.lstHanghoa = ko.observableArray(mapHanghoa02(giayphep ? giayphep.lstHanghoa : null));
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.downloadUrlNdCv = ko.computed(function () {
        if (self.fiNoidungTeptin() != null) {
            return app.appContext + '/moh/p02/download/' + self.fiNoidungTeptin() + '/' + self.fiIdHoso();
        }
        return null;
    }, this);
}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.fiMaHoso !== null) {
            var url = '/moh/p02/hoso/giayphep/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.resultVM = d.data;
                        var vm = new ResultVM(options);
                        ko.applyBindings(vm, document.getElementById('ResultVM'));
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