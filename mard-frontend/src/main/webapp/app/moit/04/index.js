/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, Storage, CHO_TIEP_NHAN, DA_GUI_THONG_BAO_AP_PHI, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, DA_YC_NOP_BS_PHI, RAW_HS_STATUS, DA_XAC_NHAN_DON_KHAI_BAO_KD, BI_TU_CHOI, YEU_CAU_BO_SUNG, TU_CHOI_YC_XIN_RUT, TU_CHOI_YCCS, THONG_BAO_XU_LY_LO_HANG, TU_CHOI_YC_CS_GCN, QUYET_DINH_XU_LY_VSTY, GCN_14A, GCN_14B, GCN_15A, GCN_15B, GCN_15C, History */
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
    self.fiTrangthai = ko.observable(item.fiTrangthai());
    self.fiContent = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    var lstVG = [self.fiContent];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.fiTrangthai() >= 1) {
            if (self.lstErrors().length > 0) {
                self.lstErrors.showAllMessages(true);
                return false;
            }
        }
        return true;
    };

    self.makeRequest = function (cb) {
        if (!self.isValidForm())
            return;

        app.makePost({
            url: '/moit/04/hoso/yc-rut',
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                lyDo: self.fiContent()
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
            url: '/moit/04/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdlichsu1(res.data, data.currentPage * data.pageSize) : [];
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

function KetQuaXLVM(options) {
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }
}

function YeuCauSuaVBVM(options) {
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }
}

function IndexVM(params) {
    self = this;
    self.trangThaiHoSo = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.soVanBan = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.Items = ko.observableArray([]);
    self.totalCount = ko.observable(0);

    self.fiTrangthaiList = ko.observableArray(params.hasOwnProperty('lstTrangThai') ? params.lstTrangThai : []);

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

    /**
     * Ấn nút chuyển trang
     * @param {type} newCurrentPage Trang mới
     */
    self.paging().currentPage.subscribe(function (newCurrentPage) {
        if (window.stateChanging) {
            return;
        }
        self.search(newCurrentPage, true);
    });
    /**
     * Trường tìm kiếm thay đổi
     * @returns {undefined}
     */
    self.searchFieldEnter = function () {
        self.search(0, true);
    };
    /**
     * Đưa dữ liệu từ url xuống form tìm kiếm
     * @param {type} data
     * @returns {undefined}
     */
    self.applyState = function (data) {
        if (!data) {
            self.search(0, false);
        } else {
            self.trangThaiHoSo(data.trangThaiHoSo);
            self.maHoSo(data.maHoSo);
            self.soVanBan(data.soVanBan);
            self.ngayTaoTuNgay(data.ngayTaoTuNgay ? new Date(data.ngayTaoTuNgay) : null);
            self.ngayTaoDenNgay(data.ngayTaoDenNgay ? new Date(data.ngayTaoDenNgay) : null);
            self.ngayCapTuNgay(data.ngayCapTuNgay ? new Date(data.ngayCapTuNgay) : null);
            self.ngayCapDenNgay(data.ngayCapDenNgay ? new Date(data.ngayCapDenNgay) : null);
            self.search(data.page ? data.page - 0 : 0, false);
        }
    };
    /**
     * Tải danh mục + tìm kiếm hồ sơ
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.search = function (page, pushState) {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            app.getCategory('/moit/04/danhmuc', 'HS_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.fiTrangthaiList(mapCategory(RAW_HS_STATUS));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
        } else {
            self.searchAfterHasCatgory(page, pushState);
        }
    };
    /**
     * Tìm kiếm hồ sơ sau khi có danh mục
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.searchAfterHasCatgory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();

        var from = $("#ngayTaoTuNgay").val();
        var to = $("#ngayTaoDenNgay").val();
        if (from != null && to != null) {
            var f = self.toDate(from);
            var t = self.toDate(to);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày nộp đến phải lớn hơn hoặc bằng Ngày nộp từ');
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
                return false;
            }
        }

        var data = {
            trangThaiHoSo: self.trangThaiHoSo(),
            maHoSo: self.maHoSo(),
            soVanBan: self.soVanBan(),
            ngayTaoTuNgay: self.ngayTaoTuNgay(),
            ngayTaoDenNgay: self.ngayTaoDenNgay(),
            ngayCapTuNgay: self.ngayCapTuNgay(),
            ngayCapDenNgay: self.ngayCapDenNgay(),
            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/moit/04/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.Items([]);
                    var list = res.data ? mapTbdhoso1(res.data, data.currentPage * data.pageSize) : [];
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
            error: function (e) { }
        });
    };
    /**
     * Đưa dữ liệu vào state
     * @param {type} data
     * @returns {undefined}
     */
    self.pushState = function (data) {
        if (data.ngayTaoTuNgay) {
            data.ngayTaoTuNgay = data.ngayTaoTuNgay.getTime();
        }
        if (data.ngayTaoDenNgay) {
            data.ngayTaoDenNgay = data.ngayTaoDenNgay.getTime();
        }
        if (data.ngayCapTuNgay) {
            data.ngayCapTuNgay = data.ngayCapTuNgay.getTime();
        }
        if (data.ngayCapDenNgay) {
            data.ngayCapDenNgay = data.ngayCapDenNgay.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    /**
     * Tìm kiếm hồ sơ
     * @returns {undefined}
     */
    self.searchHoSoClick = function () {
        self.search(0, true);
    };
    /**
     * Chuyển trang tạo mới hồ sơ
     * @param {type} e
     * @returns {Boolean}
     */
    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/moit/04/edit';
        return false;
    };

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };
    /**
     * Xem hồ sơ
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/moit/04/view?fiIdHoso=' + item.fiIdHoso();
        return false;
    };
    /**
     * Xem Thông báo
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemThongBaoClick = function (item, e) {
        document.location = app.appContext + '/moit/04/view?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert';
        return false;
    };
    /**
     * Xem Lich su
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
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
                width: 1000,
                buttons: []
            }, function () {
                ko.applyBindings(self.historyVM, document.getElementById('history-form'));
            });
        };
        self.historyVM = new HistoryVM(item);
        self.historyVM.search(cb);
        return false;
    };
    /**
     * Sửa hồ sơ
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/moit/04/edit?fiIdHoso=' + item.fiIdHoso();
        return false;
    };
    
    /**
     * Xin sua ho so
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXinSuaClick = function (item, e) {
        document.location = app.appContext + '/moit/04/edit?fiIdHoso=' + item.fiIdHoso() + '&requestedit=true';
        return false;
    };
    /**
     * Hủy hồ sơ (xóa)
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bXoaClick = function (item, e) {
        var html = [
            $('#confirm-tmpl').html()
        ].join('');
        delete self.confirmVM;
        delete self.pop;
        self.confirmVM = new ConfirmMessageVM(NSWLang["common_msg_xoa_ho_so"] + ' ', item.fiMaHoso());

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
                            url: '/moit/04/hoso/xoa/' + item.fiIdHoso(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                var msg = '';
                                if (d.success) {
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                    app.popupRemove(self.pop.selector);
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
    /**
     * Gửi yêu cầu xin rút
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bXinRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;

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
                }
            ]
        });

        ko.applyBindings(self.rutHoSoVM, document.getElementById('ruthoso-form'));
        return false;
    };

    self.createPopFiTrangThai = function (template, item) {
        var html = [
            $('#' + template).html()
        ].join('');
        self.pop = app.popup({
            title: item.fiTenTrangthai(),
            html: html,
            width: 650,
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
        });
        return self.pop;
    };
    /**
     * Từ trạng thái hồ sơ, hiển thị ra các thông tin khác (như thông báo phí, y/c bổ sung)
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.fiTrangThaiClick = function (item, e) {
        switch (item.fiTrangthai()) {
            case  DA_TIEP_NHAN:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: DA_TIEP_NHAN
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  YC_BO_SUNG:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: YC_BO_SUNG
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  TU_CHOI_HOSO:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: TU_CHOI_HOSO
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  DUOC_CAP_VANBAN:
            case  DIEU_CHINH_VANBAN:
                document.location = app.appContext + '/moit/04/view?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert';
                break;
            case  DA_THU_HOI:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: DA_THU_HOI
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;

            default:
                app.Alert("Hồ sơ đang ở trạng thái: " + $(e.target).text());
                break;
        }

    };

    /**
     * Lay ket qua xu ly ho so
     * @param {type} message
     * @returns {undefined}
     */
    self.kqxlHoSo = function (message, cb) {
        app.makePost({
            url: '/moit/04/hoso/kqxl',
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
}

$(document).ready(function () {
    var d = {};
    $('#loading10').show();
    $.when(app.getCategory('/moit/04/danhmuc', 'DM_TRANGTHAI', null, function (res) {
        if (res.success) {
            d.lstTrangThai = res.data;
        } else {
            d.lstTrangThai = [];
        }
        RAW_HS_STATUS = d.lstTrangThai;
    })).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        var vm = new IndexVM(d);
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
});