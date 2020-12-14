/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var MAX_PAGE_SIZE = 10;

function RutHoSoVM(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiIdHoso = ko.observable(item.fiIdHoso());
    self.fiMaHoso = ko.observable(item.fiMaHoso());
    self.fiMaTrangThai = ko.observable(item.fiTrangthai());
    self.fiNgayRut = ko.observable(new Date());
    self.fiNoidung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    var lstVG = [self.fiNoidung];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.makeRequest = function (cb) {
        if (!self.isValidForm())
            return;
        app.makePost({
            url: '/moh/p03/hoso/yc-rut',
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiNoidung()
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                    cb();
                } else {
                    msg = data.message ? data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                }
                app.Alert(msg);
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    };
}

function HistoryVM(item) {
    var self = this;
    self.fiIdHoso = ko.observable(item.fiIdHoso());
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
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso()
        };

        app.makePost({
            url: '/moh/p03/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdLichsu03(res.data, data.currentPage * data.pageSize) : [];
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
            error: function (e) {
            }
        });
    };
}

function IndexVM(params) {
    self = this;
    self.maHoSo = ko.observable(null);
    self.trangThaiHoSo = ko.observable(null);
    self.ngayNopTuNgay = ko.observable(null);
    self.ngayNopDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.totalCount = ko.observable(0);
    self.Items = ko.observableArray([]);
    self.fiTrangthaiList = ko.observableArray([]);
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));
    self.toDate = function (dateStr) {
        var splits = dateStr.split("/");
        var day = splits[0];
        var month = splits[1];
        var year = splits[2];
        return new Date(year, month - 1, day);
    };

    self.paging().currentPage.subscribe(function (newCurrentPage) {
        if (window.stateChanging) {
            return;
        }
        self.search(newCurrentPage, true);
    });
    self.searchFieldEnter = function () {
        self.search(0, true);
    };
    self.applyState = function (data) {
        if (!data) {
            self.search(0, false);
        } else {
            self.maHoSo(null);
            self.trangThaiHoSo(null);
            self.ngayNopTuNgay(null);
            self.ngayNopDenNgay(null);
            self.ngayCapTuNgay(null);
            self.ngayCapDenNgay(null);
            self.search(data.currentPage ? data.currentPage - 0 : 0, true);
        }
    };
    self.search = function (page, pushState) {
        self.searchAfterHasCatgory(page, pushState);
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            app.getCategory('/moh/p03/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.fiTrangthaiList(mapCategory(RAW_HS_STATUS, "fiMaTrangthai", "fiTenTrangthai"));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
        }
    };
    self.searchAfterHasCatgory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();

        var from = $("#ngayNopTuNgay").val();
        var to = $("#ngayNopDenNgay").val();
        if (from != null && to != null) {
            var f = self.toDate(from);
            var t = self.toDate(to);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày nộp đến phải lớn hơn hoặc bằng ngày nộp từ');
                self.clearfiNgayNopTu();
                self.clearfiNgayNopDen();
                return false;
            }
        }

        var from2 = $("#ngayCapTuNgay").val();
        var to2 = $("#ngayCapDenNgay").val();
        if (from2 != null && to2 != null) {
            var f2 = self.toDate(from2);
            var t2 = self.toDate(to2);
            if (f2.getTime() > t2.getTime()) {
                app.Alert('Ngày cấp phép đến phải lớn hơn hoặc bằng Ngày cấp phép từ');
                self.clearfiNgayCapTu();
                self.clearfiNgayCapDen();
                return false;
            }
        }

        var data = {
            maHoSo: self.maHoSo(),
            trangThaiHoSo: self.trangThaiHoSo(),
            ngayNopTuNgay: self.ngayNopTuNgay(),
            ngayNopDenNgay: self.ngayNopDenNgay(),
            ngayCapTuNgay: self.ngayCapTuNgay(),
            ngayCapDenNgay: self.ngayCapDenNgay(),
            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/moh/p03/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {

                    self.Items([]);
                    var list = res.data ? mapTbdhoso03(res.data, data.currentPage * data.pageSize) : [];
                    self.Items(list);
                    self.paging().update({
                        totalCount: res.data ? res.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: page
                    });
                    self.totalCount(res.data ? res.total : 0);
                    if (pushState) {
                        self.pushState(data);
                    }
                }
            },
            error: function (e) {
            }
        });
    };

    // đưa dữ liệu vào state
    self.pushState = function (data) {
        if (data.ngayNopTuNgay) {
            data.ngayNopTuNgay = data.ngayNopTuNgay.getTime();
        }
        if (data.ngayNopDenNgay) {
            data.ngayNopDenNgay = data.ngayNopDenNgay.getTime();
        }
        if (data.ngayCapTuNgay) {
            data.ngayCapTuNgay = data.ngayCapTuNgay.getTime();
        }
        if (data.ngayNopDenNgay) {
            data.ngayNopDenNgay = data.ngayNopDenNgay.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    self.clearfiNgayNopTu = function () {
        self.ngayNopTuNgay(null);
        $('#ngayNopTuNgay').datepicker('setDate', null);
    };
    self.clearfiNgayNopDen = function () {
        self.ngayNopDenNgay(null);
        $('#ngayNopDenNgay').datepicker('setDate', null);
    };
    self.clearfiNgayCapTu = function () {
        self.ngayCapTuNgay(null);
        $('#ngayCapTuNgay').datepicker('setDate', null);
    };
    self.clearfiNgayCapDen = function () {
        self.ngayCapDenNgay(null);
        $('#ngayCapDenNgay').datepicker('setDate', null);
    };

    // Tìm kiếm hồ sơ
    self.searchHoSoClick = function () {
        self.search(1, true);
    };

    // Thêm mới hồ sơ
    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/moh/03/edit';
        return false;
    };
    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };

    // Xem hồ sơ
    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/moh/03/view?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

    // Xem lịch sử xử lý
    self.bXemLichSuClick = function (item, e) {
        var html = [
            $('#history-tmpl').html()
        ].join('');
        delete self.historyVM;
        delete self.historyPop;

        var cb = function () {
            self.historyPop = app.popup({
                title: 'Lịch sử xử lý hồ sơ',
                html: html,
                width: 1200,
                buttons: [
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(self.historyPop.selector);
                        }
                    }
                ]
            }, function () {
                ko.applyBindings(self.historyVM, document.getElementById('history-form'));
            });
        };
        self.historyVM = new HistoryVM(item);
        self.historyVM.search(cb);
        return false;
    };

    // sửa hồ sơ
    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/moh/03/edit?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

    // xem giấy phép
    self.bXemGpClick = function(item) {
        document.location = app.appContext + '/moh/03/view_gp?fiMaHoso=' + item.fiMaHoso();
        return false;
    };

    //xem trang thai ho so
    self.bTrangthaiClick = function (item, e) {
        switch (item.fiTrangthai()) {
            case DA_TIEP_NHAN:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoso({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: DA_TIEP_NHAN
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case YC_BOSUNG:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoso({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: YC_BOSUNG
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case TU_CHOI_HS:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoso({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: TU_CHOI_HS
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case TC_CAP_GP:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoso({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: TC_CAP_GP
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            default:
                app.Alert("Hồ sơ đang ở trạng thái: " + $(e.target).text());
                break;
        }
    };

    self.createPopFiTrangThai = function (template, item) {
        var html = [
            $('#' + template).html()
        ].join('');
        self.pop = app.popup({
            title: item.fiTenTt(),
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        });
        return self.pop;
    };

    self.kqxlHoso = function (message, cb) {
        app.makePost({
            url: '/moh/p03/hoso/kqxl',
            data: JSON.stringify(message),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    cb(d);
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
    };

    // xóa hồ sơ
    self.bXoaClick = function (item, e) {
        var html = [
            $('#confirm-tmpl').html()
        ].join('');
        delete self.confirmVM;
        delete self.pop;
        self.confirmVM = new ConfirmMessageVM(NSWLang["common_msg_xoa_ho_so"] + ' ', item.fiIdHoso());

        self.pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: html,
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.makePost({
                            url: '/moh/p03/hoso/xoa/' + item.fiIdHoso(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                var msg = '';
                                if (d && d.success) {
                                    msg = 'Xóa dữ liệu hồ sơ thành công.';
                                    setTimeout(function () {
                                        app.popupRemove(self.pop.selector);
                                        History.go(-1);
                                    }, 500);
                                    self.search(self.paging().currentPage());
                                } else {
                                    msg = data.message;
                                }
                                app.Alert(msg);
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
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });

        ko.applyBindings(self.confirmVM, document.getElementById('xoahoso-form'));
        return false;
    };

    // Rút hồ sơ
    self.bXinRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;
        delete self.popConfirm;

        self.rutHoSoVM = new RutHoSoVM('Bạn chắc chắn muốn gửi yêu cầu xin rút hồ sơ:  ', item);

        self.pop = app.popup({
            title: 'Xin rút hồ sơ',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.rutHoSoVM.makeRequest(function () {
                            app.popupRemove(self.pop.selector);
                            self.search(self.paging().currentPage());
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

        ko.applyBindings(self.rutHoSoVM, document.getElementById('ruthoso-form'));
        return false;
    };
}
var RAW_HS_STATUS = null;
$(document).ready(function () {
    var init = function () {
        var vm = new IndexVM();
        ko.applyBindings(vm, document.getElementById('mt-container'));
        vm.applyState(app.parseQuerystring());
        window.stateChangeIsLocal = false;
        window.stateChanging = true;
        $(".select2").select2({placeholder: '-- Tất cả --', width: '100%', allowClear: true});
        (function (window, undefined) {
            History.Adapter.bind(window, 'statechange', function () {
                var state = History.getState();
                if (state.data && !window.stateChangeIsLocal) {
                    window.stateChanging = true;
                    vm.applyState(state.data);
                } else {
                    window.stateChangeIsLocal = false;
                }
            });
        })(window);
    };

    init();
});

function KetQuaXLVM(options) {
    var self = this;
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }
}