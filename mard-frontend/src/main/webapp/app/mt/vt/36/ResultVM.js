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

var MAX_PAGE_SIZE = 10;

function HistoryVM(item) {
    var self = this;

    self.fiIdGp = ko.observable(item.fiIdGp());
    self.fiSoGp = ko.observable(item.fiSoGp());
    self.fiMaHoso = ko.observable(item.fiMaHoso());
    self.historyItems = ko.observableArray([]);

    self.currentPage = ko.observable(0);
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.totalCount = ko.observable(0);

    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));

    self.paging().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.search(null);
    });

    self.search = function (cb) {
        var data = {
            currentPage: self.currentPage() - 1 < 0 ? 0 : self.currentPage() - 1,
            pageSize: self.pageSize(),
            fiIdGp: self.fiIdGp(),
            fiSoGp: self.fiSoGp(),
            fiMaHoso: self.fiMaHoso()
        };

        app.makePost({
            url: '/mt/36/giayphep/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdgpLichsu36(res.data) : [];
                    self.historyItems([]);
                    self.historyItems(list);
                    self.totalCount(res.data ? res.total : 0);

                    self.paging().update({
                        totalCount: res.data ? res.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: self.currentPage()
                    });
                    if (cb) {
                        cb();
                    }
                }
            },
            error: function (e) { }
        });
    };
}

function GiayPhepVM(item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiGpTuNgayText = ko.observable(item.fiGpTuNgay ? new Date(item.fiGpTuNgay).toDayFirstWithTime() : null);
    self.fiGpDenNgayText = ko.observable(item.fiGpDenNgay ? new Date(item.fiGpDenNgay).toDayFirstWithTime() : null);
    if (item.chuKyCqxl == null) {
        item.chuKyCqxl = {};
    }
    self.fiTenNgKy = ko.observable(item.chuKyCqxl.fiTenNgKy ? item.chuKyCqxl.fiTenNgKy : null);
    self.fiChucDanh = ko.observable(item.chuKyCqxl.fiChucDanh ? item.chuKyCqxl.fiChucDanh : null);
    self.fiDiaDiem = ko.observable(item.chuKyCqxl.fiDiaDiem ? item.chuKyCqxl.fiDiaDiem : null);
    self.fiNgaykyText = ko.observable(item.chuKyCqxl.fiNgayky ? new Date(item.chuKyCqxl.fiNgayky).toDayFirstWithTime() : null);

    //processing checkboc muc dich chuyen di
    if (item.fiMucdich == 1) {
        $("#cbThuongMai").prop('checked', true);
    }
    if (item.fiMucdich == 2) {
        $("#cbCongVu").prop('checked', true);
    }

}

function ResultVM(options) {
    var self = this;

    self.lstGiayPhep = ko.observableArray([]);

    var data = null;
    if (options.giayphep) {
        data = options.giayphep;
    }

    if (data) {
        self.lstGiayPhep(mapTbdgiayphep36(data));
    }

    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }

    self.bXemLichSuClick = function (d) {
        var html = [
            $('#history-tmpl').html()
        ].join('');
        delete self.historyVM;
        delete self.historyPop;

        var cb = function () {
            self.historyPop = app.popup({
                title: 'Lịch sử giấy phép',
                html: html,
                width: 1000,
                buttons: []
            }, function () {
                ko.applyBindings(self.historyVM, document.getElementById('history-form'));
            });
        };
        self.historyVM = new HistoryVM(d);
        self.historyVM.search(cb);
        return false;
    };

    self.makeRequest = function (item, cb) {

        app.makePost({
            url: '/mt/36/giayphep/chitiet',
            data: JSON.stringify({
                fiIdGp: item.fiIdGp()
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    cb(d.data);
                } else {
                    msg = 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                    app.Alert(msg);
                }
            },
            error: function (e) {
                var msg = 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                app.Alert(msg);
            }
        });
    };

    self.bXemThongBaoClick = function (d) {
        var Id = 'div_' + app.generateUUID();

        var html = [
            $('#form-' + d.fiLoaiGp().toString().toLowerCase() + '-template').html()
        ].join('');
        delete self.pop;
        delete self.giayPhepVM;
        self.pop = app.popup({
            title: 'Chi tiết giấy phép',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        }, function (_popup) {
            _popup.find('.form-horizontal').attr('id', Id);

            self.makeRequest(d, function (data) {
                self.giayPhepVM = new GiayPhepVM(data);
                ko.applyBindings(self.giayPhepVM, document.getElementById(Id));
            });
        });
    };

    self.toJson = function () {
        var id = '';
        for (var i = 0; i < self.lstGiayPhep().length; i++) {
            if (self.lstGiayPhep()[i].isChecked()) {
                id += self.lstGiayPhep()[i].fiSoGp() + ',';
            }
        }
        return id.substring(0, id.length - 1);
    };
}

