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



function GiayPhepVM(item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiNgaykyText = ko.observable(item.fiNgayky ? new Date(item.fiNgayky).toDayFirstWithTime() : null);
    self.fiNgayHethanText = ko.observable(item.fiNgayHethan ? new Date(item.fiNgayHethan).toDayFirstWithTime() : null);
    self.fiNgayHieulucText = ko.observable(item.fiNgayHieuluc ? new Date(item.fiNgayHieuluc).toDayFirstWithTime() : null);
    self.fiNgaycapCmndText = ko.observable(item.fiNgaycapCmnd ? new Date(item.fiNgaycapCmnd).toDayFirstWithTime() : null);

    self.fiTrangthai = ko.observable(item.fiTrangthai);
    self.isChecked = ko.observable(false);
    self.isDisable = ko.dependentObservable(function () {
        // return True
        return [YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;

    }, self)

    self.fiGuiIdGp = ko.observable(item ? item.fiGuiIdGp : null);
    self.fiDuongDanGp = ko.observable(item ? item.fiDuongDanGp : null);
    self.fiTenTepgp = ko.observable(item ? item.fiTenTepgp : null);
    self.fiGuiIdAnh = ko.observable(item ? item.fiGuiIdAnh : null);
    self.fiDuongDanAnh = ko.observable(item ? item.fiDuongDanAnh : null);
    self.fiTenAnh = ko.observable(item ? item.fiTenAnh : null);

    // xu lý dowload ảnh đại diện
    /**
     * check Download
     */
    self.canDownloadAnh = ko.computed(function () {
        return self.fiTenAnh() != null;
    }, this);
    /**
     * url download anh
     */
    self.downloadUrlAnh = ko.computed(function () {
        if (self.fiTenAnh()) {
            return app.appContext + '/bca/01/file/'+self.fiDuongDanAnh()+'/' + self.fiGuiIdAnh();
        }
        return null;
    }, this);
    // xu lý dowload ảnh đại diện END
    // xu lý dowload Giay phep
    /**
     * check Download
     */
    self.canDownloadGp = ko.computed(function () {
        return self.fiTenTepgp() != null;
    }, this);
    /**
     * url download anh
     */
    self.downloadUrlGp = ko.computed(function () {
        if (self.fiTenTepgp()) {
            return app.appContext + '/bca/01/file/bca/01/'+self.fiDuongDanGp()+'/' + self.fiGuiIdGp();
        }
        return null;
    }, this);
    // xu lý dowload Giay phep END
}

function ResultVM(options) {
    var self = this;

    self.lstGiayPhep = ko.observableArray([]);

    var data = null;
    if (options.giayphep) {
        data = options.giayphep;
    }

    if (data) {
        self.lstGiayPhep(mapTbdgiayphep01(data));
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
            url: '/bca/01/hoso/giayphep/chitiet',
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
            $('#form-template').html()
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

