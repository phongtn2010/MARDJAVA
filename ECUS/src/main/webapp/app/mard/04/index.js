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
            url: '/mard/p04/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdlichsu04(res.data, data.currentPage * data.pageSize) : [];
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

function KetQuaXLVM(options) {
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }
}

function IndexVM(params) {
    self = this;
    self.maHoSo = ko.observable(null);
    self.trangThaiHoSo = ko.observable(null);
    self.fiTrangThaiList = ko.observableArray([]);
    self.ngayNopTuNgay = ko.observable(null);
    self.ngayNopDenNgay = ko.observable(null);
    self.ngayCapphepTuNgay = ko.observable(null);
    self.ngayCapphepDenNgay = ko.observable(null);
    self.maLoaiDon = ko.observable(null);
    self.maTrangthaiPhi = ko.observable(null);
    self.lstLoaidon = ko.observableArray([]);
    self.lstTrangthaiPhi = ko.observableArray([]);
    self.totalCount = ko.observable(0);
    self.Items = ko.observableArray([]);
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
            self.maHoSo(data.maHoSo);
            self.ngayNopTuNgay(data.ngayNopTuNgay ? new Date(data.ngayNopTuNgay) : null);
            self.ngayNopDenNgay(data.ngayNopDenNgay ? new Date(data.ngayNopDenNgay) : null);
            self.ngayCapphepTuNgay(data.ngayCapphepTuNgay ? new Date(data.ngayCapphepTuNgay) : null);
            self.ngayCapphepDenNgay(data.ngayCapphepDenNgay ? new Date(data.ngayCapphepDenNgay) : null);
            self.search(data.currentPage ? data.currentPage - 0 : 0, true);
        }
    };
    self.search = function (page, pushState) {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            app.getCategory('/mard/p04/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.fiTrangThaiList(mapCategory(RAW_HS_STATUS, "maTrangthai", "tenTrangthai"));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
            app.getCategory('/mard/p04/danhmuc', 'DM_LOAIDON', null, function (res) {
                if (res.success) {
                    RAW_HS_LOAIDON = res.data;
                    self.lstLoaidon(mapCategory(RAW_HS_LOAIDON, "fiMaLoaidon", "fiTenLoaidon"));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
            app.getCategory('/mard/p04/danhmuc', 'DM_TRANGTHAI_PHI', null, function (res) {
                if (res.success) {
                    RAW_HS_TT_PHI = res.data;
                    self.lstTrangthaiPhi(mapCategory(RAW_HS_TT_PHI, "maTrangthai", "tenTrangthai"));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
        } else {
            self.searchAfterHasCatgory(page, pushState);
        }
    };
    self.searchAfterHasCatgory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();

        var fromNgaynop = $("#ngayNopTuNgay").val();
        var toNgaynop = $("#ngayNopDenNgay").val();
        if (fromNgaynop != null && toNgaynop != null) {
            var f = self.toDate(fromNgaynop);
            var t = self.toDate(toNgaynop);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày nộp đến phải lớn hơn hoặc bằng Ngày nộp từ');
                self.clearfiNgayNopTuNgay();
                self.clearfiNgayNopDenNgay();
                return false;
            }
        }

        var fromNgaycapphep = $("#ngayCapphepTuNgay").val();
        var toNgaycapphep = $("#ngayCapphepDenNgay").val();
        if (fromNgaycapphep != null && toNgaycapphep != null) {
            var f = self.toDate(fromNgaycapphep);
            var t = self.toDate(toNgaycapphep);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày cấp phép đến phải lớn hơn hoặc bằng Ngày cấp phép từ');
                self.clearfiNgayCapphepTuNgay();
                self.clearfiNgayCapphepDenNgay();
                return false;
            }
        }

        var data = {
            maHoSo: self.maHoSo(),
            trangThaiHoSo: self.trangThaiHoSo(),
            ngayNopTuNgay: self.ngayNopTuNgay(),
            ngayNopDenNgay: self.ngayNopDenNgay(),
            ngayCapphepTuNgay: self.ngayCapphepTuNgay(),
            ngayCapphepDenNgay: self.ngayCapphepDenNgay(),
            maLoaiDon: self.maLoaiDon(),
            maTrangthaiPhi: self.maTrangthaiPhi(),
            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/mard/p04/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {

                    self.Items([]);
                    var list = res.data ? mapTbdhoso04(res.data, data.currentPage * data.pageSize) : [];
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
    self.pushState = function (data) {
        if (data.ngayNopTuNgay) {
            data.ngayNopTuNgay = data.ngayNopTuNgay.getTime();
        }
        if (data.ngayNopDenNgay) {
            data.ngayNopDenNgay = data.ngayNopDenNgay.getTime();
        }
        if (data.ngayCapphepTuNgay) {
            data.ngayCapphepTuNgay = data.ngayCapphepTuNgay.getTime();
        }
        if (data.ngayCapphepDenNgay) {
            data.ngayCapphepDenNgay = data.ngayCapphepDenNgay.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };

    self.clearfiNgayNopTuNgay = function () {
        self.ngayNopTuNgay(null);
        $('#ngayNopTuNgay').datepicker('setDate', null);
    };
    self.clearfiNgayNopDenNgay = function () {
        self.ngayNopDenNgay(null);
        $('#ngayNopDenNgay').datepicker('setDate', null);
    };
    self.clearfiNgayCapphepTuNgay = function () {
        self.ngayCapphepTuNgay(null);
        $('#ngayCapphepTuNgay').datepicker('setDate', null);
    };
    self.clearfiNgayCapphepDenNgay = function () {
        self.ngayCapphepDenNgay(null);
        $('#ngayCapphepDenNgay').datepicker('setDate', null);
    };

    self.searchHoSoClick = function () {
        self.search(0, true);
    };

    // button xem chi tiet lich su
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

    self.bDonDangKyClick = function (item) {
        document.location = app.appContext + '/mard/04/xacnhandon?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso();
        return false;
    };

    self.bXemkqKiemDichClick = function (item) {
        switch (item.fiMaTrangthai()) {
            case DACAP_LENH:
            case DACAP_GIULAI:
                document.location = app.appContext + '/mard/04/PhytosanitaryDetain?fiMaHoso=' + item.fiMaHoso() + '&fiMaLoaiKiemtra=' + item.fiMaLoaiKiemtra();
                break;
            case CAPGIAY_CNKD:
            case CAP_CNKD_CHINHSUA:
                document.location = app.appContext + '/mard/04/PhytosanitaryResult?fiMaHoso=' + item.fiMaHoso() + '&fiMaLoaiKiemtra=' + item.fiMaLoaiKiemtra();
                break;
            case DACAP_XNCL:
            case DACAP_XNCL_CHINHSUA:
            case DACAP_XNCL_LAN2:
            case DACAP_XNCL_CHINHSUA_LAN2:
                document.location = app.appContext + '/mard/04/QuanlityResult?fiMaHoso=' + item.fiMaHoso() + '&fiMaLoaiKiemtra=' + item.fiMaLoaiKiemtra();
                break;
            case DACAP_CNTP:
            case DACAP_CNTP_CHINHSUA:
                document.location = app.appContext + '/mard/04/PhytosanitaryFoodSafetyResult?fiMaHoso=' + item.fiMaHoso();
                break;
            case DACAP_ATTP:
            case DACAP_ATTP_CHINHSUA:
                document.location = app.appContext + '/mard/04/FoodSafetyResult?fiMaHoso=' + item.fiMaHoso();
                break;
            case CAPGIAY_TAMCAP:
            case CAPTAM_CNKD:
                document.location = app.appContext + '/mard/04/TemporaryPhytosanitary?fiMaHoso=' + item.fiMaHoso() + '&fiMaLoaiKiemtra=' + item.fiMaLoaiKiemtra();
                break;
            default :
                break;
        }
        return false;

    };

    self.bThongBaoPhiClick = function (item, e) {
        switch (item.fiMaTrangthaiphi()) {
            case THONGBAO_APPHI:
                document.location = app.appContext + '/mard/04/charge?fiMaHoso=' + item.fiMaHoso() + '&fiIdHoso=' + item.fiIdHoso();
                break;
            case YCBS_PHI:
                document.location = app.appContext + '/mard/04/chargeBS?fiMaHoso=' + item.fiMaHoso() + '&fiIdHoso=' + item.fiIdHoso();
                break
            case XACNHAN_PHI:
                document.location = app.appContext + '/mard/04/FeeResponse?fiMaHoso=' + item.fiMaHoso() + '&fiIdHoso=' + item.fiIdHoso();
                break;
            default :
                break;
        }
        return false;
    };

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };

    self.fiTrangThaiClick = function (item, e) {

        switch (item.fiMaTrangthai()) {
            case DA_TIEP_NHAN:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: DA_TIEP_NHAN
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case TUCHOI_HS:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: TUCHOI_HS
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case YC_BOSUNG_HS:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: YC_BOSUNG_HS
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            default:
                app.Alert("Hồ sơ đang ở trạng thái: <b>" + $(e.target).text()) + "</b>";
                break;
        }
    };

    self.fiTrangThaiphiClick = function (item, e) {
        switch (item.fiMaTrangthai()) {
            default:
                app.Alert("Trạng thái phí hồ sơ: <b>" + $(e.target).text()) + "</b>";
                break;
        }
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

    self.kqxlHoSo = function (message, cb) {
        app.makePost({
            url: '/mard/p04/hoso/kqxl',
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

    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/mard/04/view?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

}

var RAW_HS_STATUS = null;
var RAW_HS_LOAIDON = null;
var RAW_HS_TT_PHI = null;
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