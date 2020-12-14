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
    self.fiIdHoso = ko.observable(item.registrationId());
    self.fiMaHoso = ko.observable(item.nswFilecode());
    self.fiMaTrangThai = ko.observable(item.codeStatus());
    self.fiNoidungYc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    var lstVG = [self.fiNoidungYc];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.makeRequest = function (cb) {
       // if (!self.isValidForm())
       //     return;
        app.makePost({
            url: '/mard/p02/hoso/yc-rut',
            data: JSON.stringify({
                fiMaHoso : self.fiMaHoso(),
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiNoidungYc()
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
    debugger;
    var self = this;
    self.fiIdHoso = ko.observable(item.registrationId());
    self.fiMaHoso = ko.observable(item.nswFilecode());
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
            url: '/mard/p02/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdLichsu02(res.data, data.currentPage * data.pageSize) : [];
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

function IndexVM(params) {
    self = this;
    self.trangThaiHoSo = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.totalCount = ko.observable(0);
    self.Items = ko.observableArray([]);
    self.fiTrangThaiList = ko.observableArray([]);
    self.fiCQKTList = ko.observableArray([]);
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));
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
            self.search(data.currentPage ? data.currentPage - 0 : 0, true);
        }
    };
    self.search = function (page, pushState) {
         self.searchAfterHasCatgory(page, pushState);
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            app.getCategory('/mard/p02/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.fiTrangThaiList(mapCategory(RAW_HS_STATUS, "maTrangthai", "tenTrangthai"));
//                    self.searchAfterHasCatgory(page, pushState);
                }
            });
        } 
//        else {
//            self.searchAfterHasCatgory(page, pushState);
//        }
    };
    self.searchAfterHasCatgory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();

        var data = {
            maHoSo: self.maHoSo(),
            ngayTaoTuNgay: self.ngayTaoTuNgay(),
            ngayTaoDenNgay: self.ngayTaoDenNgay(),
            ngayCapTuNgay: self.ngayCapTuNgay(),
            pageSize: self.pageSize(),
            trangThaiHoSo: self.trangThaiHoSo(),
            ngayCapDenNgay: self.ngayCapDenNgay(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };
        debugger;
        app.makePost({
            url: "/mard/p02/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {

                    self.Items([]);
                    var list = res.data ? mapTbdhoso02(res.data, data.currentPage * data.pageSize) : [];
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
    self.pushState = function (data) {
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    self.searchHoSoClick = function () {
        self.search(0, true);
    };
    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mard/02/edit';
        return false;
    };

    self.bXemCvClick = function (item) {
        document.location = app.appContext + '/mard/02/view_gp?nswfileCode=' + item.nswFilecode();
        return false;
    };
    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };
    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/mard/02/view?registrationId=' + item.registrationId();
        return false;
    };
    self.bXemThongBaoClick = function (item, e) {
        document.location = app.appContext + '/mard/02/view_gp?fiIdHoSo=' + item.fiIdHoSo() + '&fiMaHoSo=' + item.fiMaHoSo() + '&tab=cert&maThuTuc=BTTTT0200002';
//        document.location = app.appContext + '/mic/02/view_gp';
        return false;
    };
    self.bXemLichSuClick = function (item, e) {
        debugger;
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
    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/mard/02/edit?registrationId=' + item.registrationId();
        return false;
    };
    /**
     * Xin sua ho so
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXinSuaClick = function (item, e) {
        document.location = app.appContext + '/mard/02/edit?registrationId=' + item.registrationId() + '&requestedit=true';
        return false;
    };
    self.bXoaClick = function (item, e) {
        debugger;
        var html = [
            $('#confirm-tmpl').html()
        ].join('');
        delete self.confirmVM;
        delete self.pop;
        self.confirmVM = new ConfirmMessageVM(NSWLang["common_msg_xoa_ho_so"] + ' ', item.nswFilecode());

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
                            url: '/mard/p02/hoso/xoa/' + item.registrationId(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                var msg = '';
                                if (d.success) {
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                    self.search(self.paging().currentPage());
                                    app.popupRemove(self.pop.selector);
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
    self.bXinRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;
        delete self.popConfirm;
        var msg = (item.codeStatus() !== 1 && item.codeStatus() !== 2) ? "Bạn chắc chắn muốn gửi yêu cầu xin rút hồ sơ:  " : "Bạn chắc chắn muốn hủy hồ sơ: ";
        self.rutHoSoVM = new RutHoSoVM(msg, item);

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
    self.createPopFiTrangThai = function (template, item) {
        var html = [
            $('#' + template).html()
        ].join('');
        self.pop = app.popup({
            title: item.fiTenTrangThai(),
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
    self.fiTrangThaiClick = function (item, e) {

        switch (item.fiMaTrangThai()) {
            case  DA_TIEP_NHAN:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoSo(),
                    fiIdHoSo: item.fiIdHoSo(),
                    fiTrangthai: DA_TIEP_NHAN
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  YC_BOSUNG_HS:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoSo(),
                    fiIdHoSo: item.fiIdHoSo(),
                    fiTrangthai: YC_BOSUNG_HS
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  TC_CAP_GP:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoSo(),
                    fiIdHoSo: item.fiIdHoSo(),
                    fiTrangthai: TC_CAP_GP
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;
            case  THU_HOI_GIAY_PHEP:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoSo(),
                    fiIdHoSo: item.fiIdHoSo(),
                    fiTrangthai: THU_HOI_GIAY_PHEP
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
                break;

            case  CAP_GP:
                document.location = app.appContext + '/mic/02/view_gp?fiIdHoSo=' + item.fiIdHoSo() + '&fiMaHoSo=' + item.fiMaHoSo() + '&tab=cert&maThuTuc=BTTTT0200002';
                break;
            default:
                app.Alert("Hồ sơ đang ở trạng thái: " + $(e.target).text());
                break;
        }

    };
}
var RAW_HS_STATUS = null;
var RAW_HS_CQKT = null;
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