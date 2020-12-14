/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, Storage, CHO_TIEP_NHAN, DA_GUI_THONG_BAO_AP_PHI, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, DA_YC_NOP_BS_PHI, RAW_HS_STATUS, DA_XAC_NHAN_DON_KHAI_BAO_KD, BI_TU_CHOI, YEU_CAU_BO_SUNG, TU_CHOI_YC_XIN_RUT, TU_CHOI_YCCS, THONG_BAO_XU_LY_LO_HANG, TU_CHOI_YC_CS_GCN, QUYET_DINH_XU_LY_VSTY, GCN_14A, GCN_14B, GCN_15A, GCN_15B, GCN_15C, History, App */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var MAX_PAGE_SIZE = 10;


function IndexVM() {

    self = this;
    self.fiIdXe = ko.observable(null);
    self.biensoxe = ko.observable(null);
    self.tenchuxe = ko.observable(null);
    self.Items = ko.observableArray([]);
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
            self.fiIdXe(data.fiIdXe);
            self.biensoxe(data.biensoxe);
            self.tenchuxe(data.tenchuxe);
            self.search(data.page ? data.page - 0 : 0, false);
        }
    };
    /**
     * Tải danh mục + tìm kiếm phương tiện
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.search = function (page, pushState) {
        self.searchAfterHasCatgory(page, pushState);
    }

    /**
     * Tìm kiếm phương tiện sau khi có danh mục
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.searchAfterHasCatgory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();


        var data = {
            biensoxe: self.biensoxe(),
            tenchuxe: self.tenchuxe(),

            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };
        app.makePost({
            url: "/mt/qlpt/phuongtien/search",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.Items([]);
                    var list = res.data ? mapTbdqlPhuongtien(res.data, data.currentPage * data.pageSize) : [];
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
            error: function (e) {}
        });
    };
    /**
     * Đưa dữ liệu vào state
     * @param {type} data
     * @returns {undefined}
     */
    self.pushState = function (data) {

        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    /**
     * Tìm kiếm phương tiện
     * @returns {undefined}
     */
    self.searchPhuongTienClick = function () {
        self.search(0, true);
    };
    /**
     * Chuyển trang tạo mới phương tiện
     * @param {type} e
     * @returns {Boolean}
     */
    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mt/qlpt/edit';
        return false;
    };

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };
    /**
     * Xem phương tiện
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemClick = function (item, e) {
        document.location = app.appContext + '/mt/qlpt/view?fiIdPhuongtien=' + item.fiIdXe();
        return false;
    };

    /**
     * Sửa phương tiện
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/mt/qlpt/edit?fiIdPhuongtien=' + item.fiIdXe();
        return false;
    };

    /**
     * Hủy phương tiện (xóa)
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
        self.confirmVM = new ConfirmMessageVM(NSWLang["common_msg_xoa_phuong_tien"] + ' ', item.fiBksXe());

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
                            url: '/mt/qlpt/phuongtien/xoa/' + item.fiIdXe(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                var msg = '';
                                if (d.success) {
                                    msg = NSWLang["common_msg_xoa_thanh_cong_phuong_tien"] + ' ' + item.fiBksXe();
                                    app.popupRemove(self.pop.selector);
                                    self.search(self.paging().currentPage());
                                } else {
                                    msg = data.message;
                                }
                                app.Alert(msg);
                            },
                            error: function (e) {
                                app.toast({
                                    title: NSWLang["common_msg_cap"],
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
}



$(document).ready(function () {
    $('#loading10').show();
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

    $('#loading10').hide();
});