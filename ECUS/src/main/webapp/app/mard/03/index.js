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
    self.fiIdHoso = ko.observable(item.fiIdHoSo());
    self.fiMaHoso = ko.observable(item.fiMaHoSo());
    self.fiMaTrangThai = ko.observable(item.fiTrangThaiMa());
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
            url: '/mard/p03/hoso/yc-rut',
            data: JSON.stringify({
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
    var self = this;
    self.fiIdHoso = ko.observable(item.fiIdHoSo());
    self.fiMaHoso = ko.observable(item.fiMaHoSo());
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
            url: '/mard/p03/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdlichsu03(res.data, data.currentPage * data.pageSize) : [];
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
function ChiTieuVM(item) {
    
    var self = this;
    self.fiIdHoso = ko.observable(item.registrationProfileId());
    self.fiMaHoso = ko.observable(item.nswfileCode());
    self.ChitieuItems = ko.observableArray([]);

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
            url: '/mard/p04/hoso/chitieu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? MapHangHoaCT04(res.data, data.currentPage * data.pageSize) : [];
                    self.ChitieuItems([]);
                    self.ChitieuItems(list);
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

function TrangthaiFormVM(options) {
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }
}

function IndexVM(params) {
    self = this;
    self.trangThaiHoSo = ko.observable(null);
    self.toChucKiemTra = ko.observable(null);
    self.ngayGuiTuNgay = ko.observable(null);
    self.ngayGuiDenNgay = ko.observable(null);
    self.tenHangHoa = ko.observable(null);


    self.soTiepNhan = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.Items = ko.observableArray([]);
    self.fiTrangThaiList = ko.observableArray([]);
    self.fiCQKTList = ko.observableArray([]);
    self.totalCount = ko.observable(0);
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
            self.ngayGuiTuNgay(data.ngayGuiTuNgay ? new Date(data.ngayGuiTuNgay) : null);
            self.ngayGuiDenNgay(data.ngayGuiDenNgay ? new Date(data.ngayGuiDenNgay) : null);
            self.search(data.currentPage ? data.currentPage - 0 : 0, true);
//            self.search(data.page ? data.page - 0 : 0, false);
        }
    };
    self.search = function (page, pushState) {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            app.getCategory('/mard/p03/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.fiTrangThaiList(mapCategory(RAW_HS_STATUS, "fiMaTrangthai", "fiTenTrangthai"));
                    self.searchAfterHasCatgory(page, pushState);
                }
            });
            app.getCategory('/mard/p03/danhmuc', 'DM_CQXL', null, function (res) {
                if (res.success) {
                    RAW_HS_CQKT = res.data;
                    self.fiCQKTList(mapCategory(RAW_HS_CQKT, "maCoQuan", "tenCoQuan"));
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
        
        var from = $("#ngayGuiTuNgay").val();
        var to = $("#ngayGuiDenNgay").val();
        if (from != null && to != null) {
            var f = self.toDate(from);
            var t = self.toDate(to);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày gửi đến phải lớn hơn hoặc bằng Ngày gửi từ');
                self.clearfiNgayGuiTu();
                self.clearfiNgayGuiDen();
                return false;
            }
        }
        
        var data = {
            maHoSo: self.maHoSo(),
            ngayGuiTuNgay: self.ngayGuiTuNgay(),
            ngayGuiDenNgay: self.ngayGuiDenNgay(),
            tenHangHoa: self.tenHangHoa(),
            pageSize: self.pageSize(),
            trangThaiHoSo: self.trangThaiHoSo(),
            toChucKiemTra: self.toChucKiemTra(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/mard/p03/hoso/timkiem",
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
            error: function (e) { }
        });
    };
    self.pushState = function (data) {
        if (data.ngayGuiTuNgay) {
            data.ngayGuiTuNgay = data.ngayGuiTuNgay.getTime();
        }
        if (data.ngayGuiDenNgay) {
            data.ngayGuiDenNgay = data.ngayGuiDenNgay.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    self.clearfiNgayGuiDen = function(){
        self.ngayGuiDenNgay(null);
        $('#ngayGuiDenNgay').datepicker('setDate', null);
    };
    self.clearfiNgayGuiTu = function(){
        self.ngayGuiTuNgay(null);
        $('#ngayGuiTuNgay').datepicker('setDate', null);
    };
    self.searchHoSoClick = function () {
        self.search(1, true);
    };

    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mard/03/edit';
        return false;
    };

    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/mard/03/edit?fiIdHoSo=' + item.fiIdHoSo();
        return false;
    };

    self.bXinSuaClick = function (item, e) {
        document.location = app.appContext + '/mard/03/edit?fiIdHoSo=' + item.fiIdHoSo() + '&requestedit=true';
        return false;
    };

    self.bXinRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;
        delete self.popConfirm;
        var msg = (item.fiTrangThaiMa() !== 1 && item.fiTrangThaiMa() !== 3) ? "Bạn chắc chắn muốn gửi yêu cầu xin rút hồ sơ:  " : "Bạn chắc chắn muốn rút hồ sơ: ";
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

    self.bXoaClick = function (item, e) {
        var html = [
            $('#confirm-tmpl').html()
        ].join('');
        delete self.confirmVM;
        delete self.pop;
        self.confirmVM = new ConfirmMessageVM(NSWLang["common_msg_xoa_ho_so"] + ' ', item.fiMaHoSo());

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
                            url: '/mard/p03/hoso/xoa/' + item.fiMaHoSo(),
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

    self.bGiayChungnhanlick = function (item) {
        document.location = (item.fiTrangThaiMa() == 17 || item.fiTrangThaiMa() == 19 || item.fiTrangThaiMa() == 22 || item.fiTrangThaiMa() == 24 || (item.fiTrangThaiMa() == 23 && item.fiMaLoaiSp() == 1)) ? app.appContext + '/mard/03/giaycn?fiMaHoSo=' + item.fiMaHoSo() : app.appContext + '/mard/03/giaycnb?fiMaHoSo=' + item.fiMaHoSo();
        return false;
    };

    self.bXemDonkhaibao = function (item) {
        document.location = app.appContext + '/mard/03/donkiemdich?fiIdHoSo=' + item.fiIdHoSo();
        return false;
    };

    self.bTrangthaiClick = function (item, e) {
        switch (item.fiTrangThaiMa()) {
            case TB_APPHI:
                self.createPopFiTrangThai('thongtinapphi-template', item);
                self.thongtinap( item.fiIdHoSo(), function (d) {
                    ko.applyBindings(new TrangthaiFormVM(d.data), document.getElementById('thongtinapphi-form'));
                });
                break;
            case XACNHAN_PHI:
                self.createPopFiTrangThai('thongbaoXnPhi-template', item);
                self.thongbaoXnphi( item.fiIdHoSo(), function (d) {
                    ko.applyBindings(new TrangthaiFormVM(d.data), document.getElementById('thongbaoXnPhi-form'));
                });
                break;
            case LO_HANG_CANXL:
                self.createPopFiTrangThai('lohangxl-template', item);
                self.lohangxl( item.fiIdHoSo(), function (d) {
                    ko.applyBindings(new TrangthaiFormVM(d.data), document.getElementById('lohangxl-form'));
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
            title: item.fiTrangThai(),
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

    self.thongtinap = function (fiIdHoso, cb) {
        app.makePost({
            url: '/mard/p03/thongtinapphi/' + fiIdHoso,
            data: JSON.stringify({}),
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

    self.thongbaoXnphi = function (fiIdHoso, cb) {
        app.makePost({
            url: '/mard/p03/thongbaoXnphi/' + fiIdHoso,
            data: JSON.stringify({}),
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

    self.lohangxl = function (fiIdHoso, cb) {
        app.makePost({
            url: '/mard/p03/lohangxl/' + fiIdHoso,
            data: JSON.stringify({}),
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

    self.bChuyenCkXuat = function (item) {
        document.location = app.appContext + '/mard/03/donxinCk?fiIdHoSo=' + item.fiIdHoSo();
        return false;
    };

    self.bCVChuyenCkClick = function (item) {
        document.location = app.appContext + '/mard/03/cvanCk?fiMaHoSo=' + item.fiMaHoSo();
        return false;
    };

    //todo
    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };

    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/mard/03/view?fiIdHoSo=' + item.fiIdHoSo();
        return false;
    };

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
    self.bXemChiTieuClick = function (item, e) {
        var html = [
            $('#xemchitieu-tmpl').html()
        ].join('');
        delete self.chiTieuVM;
        delete self.chiTieuPop;

        var cb = function () {
            self.chiTieuPop = app.popup({
                title: 'Danh sách chỉ tiêu kiểm tra',
                html: html,
                width: 1000,
                buttons: [
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(self.chiTieuPop.selector);
                        }
                    }
                ]
            }, function () {
                ko.applyBindings(self.chiTieuVM, document.getElementById('xemchitieu-form'));
            });
        };
        self.chiTieuVM = new ChiTieuVM(item);
        self.chiTieuVM.search(cb);
        return false;
    };

    self.guiYcXuly = function (message) {
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mic/p02/hoso/xuly',
            data: JSON.stringify(message),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //
                if (res && res.success) {
                    alert('Đã gửi yêu cầu thành công');
                    self.search(self.paging().currentPage() - 1);
                } else {
                    alert('Đã gửi yêu cầu không thành công');
                }
            },
            error: function (x, t, m) {
                self.clearForm();
            },
            complete: function () {
                $('#loading10').hide();
            }
        });
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