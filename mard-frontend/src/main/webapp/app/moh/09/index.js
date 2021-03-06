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
            url: '/moh/09/hoso/yc-rut',
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiContent()
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
            url: '/moh/09/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdlichsu9(res.data) : [];
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
    var self = this;
    if (options) {
        ko.mapping.fromJS(options, {}, this);
    }

    self.isVisibleLink = ko.observable(false);
    self.fiLinkCvan = ko.observable(null);
    if (options) {
        if (options.hasOwnProperty('dinhKem')) {
            var dinhKem = options.dinhKem;
            if (null != dinhKem) {
                self.isVisibleLink((null != dinhKem.fiDuongDan && dinhKem.fiDuongDan.trim().length > 0) ? true : false);
                self.fiLinkCvan(dinhKem.fiDuongDan);
            }
        }
    }
}

function IndexVM(params) {
    self = this;
    self.trangThaiHoSo = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.maThuTuc = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.soChungnhan = ko.observable(null);
    self.soTiephan = ko.observable(null);
    self.coQuanKiemTra = ko.observable(null);

    self.Items = ko.observableArray([]);
    self.totalCount = ko.observable(0);

    self.lstTrangThai = ko.observableArray(params.hasOwnProperty('lstTrangThai') ? params.lstTrangThai : []);
    self.lstCoQuanKiemTra = ko.observableArray(params.hasOwnProperty('lstCoQuanKiemTra') ? params.lstCoQuanKiemTra : []);

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

    self.fiThuTucId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };
    var query = app.parseQuerystring();
    self.title = ko.observable(NSWLang["moh." + query.maThuTuc + ".tenthutuc"]);

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
            self.soChungnhan(data.soChungnhan);
            self.soTiephan(data.soTiephan);
            self.ngayTaoTuNgay(data.ngayTaoTuNgay ? new Date(data.ngayTaoTuNgay) : null);
            self.ngayTaoDenNgay(data.ngayTaoDenNgay ? new Date(data.ngayTaoDenNgay) : null);
            self.maThuTuc(data.maThuTuc);

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
            app.getCategory('/moh/07/danhmuc', 'DANHMUC_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                    self.lstTrangThai(mapCategory(RAW_HS_STATUS));
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
                app.Alert('Ngày gửi đến phải lớn hơn hoặc bảng Ngày gửi từ');
                return false;
            }
        }

        var data = {
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1,
            trangThaiHoSo: self.trangThaiHoSo(),
            maHoSo: self.maHoSo(),
            maThuTuc: self.maThuTuc(),
            ngayTaoDenNgay: self.ngayTaoDenNgay(),
            ngayTaoTuNgay: self.ngayTaoTuNgay(),
            pageSize: self.pageSize(),
            soChungnhan: self.soChungnhan(),
            soTiephan: self.soTiephan()
        };

        app.makePost({
            url: "/moh/09/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.Items([]);
                    var list = res.data ? mapTbdhoso9(res.data, data.currentPage * data.pageSize) : [];
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
        document.location = app.appContext + '/moh/' + self.fiThuTucId() + '/edit?maThuTuc=' + self.maThuTuc();
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
        document.location = app.appContext + '/moh/09/view?fiIdHoso=' + item.fiIdHoso() + '&maThuTuc=' + self.maThuTuc();
        return false;
    };
    /**
     * Xem Thông báo
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemThongBaoClick = function (item, e) {
        document.location = app.appContext + '/moh/09/result?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert&maThuTuc=' + self.maThuTuc();
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
        document.location = app.appContext + '/moh/09/edit?fiIdHoso=' + item.fiIdHoso() + '&maThuTuc=' + self.maThuTuc();
        
        return false;
    };

    self.bGuiHoSoClick = function (item, e) {
        delete self.pop;
        var html = [
            $('#confirm-tmpl').html()
        ].join('');
        
        self.verifySignature = function (signature, doc) {

            var data = {
                'signatureXml': signature,
                'messageXml': doc.sign.fiXml,
                'msgFunc': doc.sign.fiFunc,
                'msgType': doc.sign.fiMsgType,
                'documentCode': doc.data.fiMaHoso,
                'ministryCode': 'MOH',
                'proceduceCode': self.maThuTuc()
            };
            app.makePost({
                url: '/moh/09/verify',
                data: JSON.stringify(data),
                success: function (d) {
                    app.makePost({
                        url: '/moh/09/hoso/guihoso',
                        data: JSON.stringify(doc.data),
                        success: function (d) {
                            app.Alert('Gửi hồ sơ thành công');
                            setTimeout(function () {
                                History.go(-1);
                            }, 1500);
                        },
                        error: function (e) {
                            app.Alert('Gửi hồ sơ không thành công');
                        }
                    });
                },
                error: function (e) {
                    if (e.hasOwnProperty('message')) {
                        app.Alert(e.message);
                    } else {
                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                    }
                }
            });
        };

        self.confirmVM = new ConfirmMessageVM('Bạn chắc chắn muốn gửi hồ sơ này? ', item.fiMaHoso());

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
                            url: '/moh/09/hoso/send',
                            data: JSON.stringify(ko.toJS(item)),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    app.popupRemove(self.pop.selector);
                                    app.Alert('Gửi hồ sơ thành công');
                                    self.search(self.paging().currentPage());

                                } else {
                                    var result = d.sign;
                                    var onSuccess = function (res) {
                                        app.popupRemove(self.pop.selector);
                                        if (res.status == 'ok') {
                                            self.verifySignature(res.outputData, d);
                                        } else {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        }
                                    };
                                    var onFailed = function (e) {
                                        app.popupRemove(self.pop.selector);
                                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                                    };

                                    RTVNSignClient.ping(function (res) {
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function (e) {
                                        app.popupRemove(self.pop.selector);
                                        app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                    });
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
                            url: '/moh/09/hoso/xoa/' + item.fiIdHoso(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                var msg = '';
                                if (d.success) {
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                    app.popupRemove(self.pop.selector);
                                    self.search(self.paging().currentPage());
                                } else {
                                    msg = d.message;
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
        delete self.popConfirm;

        self.rutHoSoVM = new RutHoSoVM('Gửi yêu cầu xin rút hồ sơ:  ', item);

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
                        self.popConfirm = app.popup({
                            title: NSWLang["common_msg_thong_bao"],
                            html: '<b>Bạn chắc chắn muốn thực hiện thao tác này?</b>',
                            width: 450,
                            buttons: [
                                {
                                    name: NSWLang["common_button_toi_chac_chan"],
                                    class: 'btn',
                                    icon: 'fa-save',
                                    action: function () {
                                        self.rutHoSoVM.makeRequest(function () {
                                            app.popupRemove(self.popConfirm.selector);
                                            app.popupRemove(self.pop.selector);
                                            self.search(self.paging().currentPage());
                                        });
                                    }
                                },
                                {
                                    name: 'Huỷ',
                                    class: 'btn',
                                    icon: 'fa-close',
                                    action: function () {
                                        app.popupRemove(self.popConfirm.selector);
                                    }
                                }
                            ]
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
//        var TAO_MOI = 0;
//        var CHO_THONG_BAO_PHI = 1;
//        var DA_XAC_NHAN_PHI = 2;
//        var YC_BO_SUNG = 3;
//        var DA_RUT_HOSO = 4;
//        var DA_BO_SUNG_HOSO = 5;
//        var TU_CHOI_CAP_PHEP = 7;
//        var DUOC_CAP_GIAYPHEP = 8;
//        var YC_NOP_LAI_PHI = 9;
//        var THANH_TOAN_PHI_BOSUNG = 10;
//        var THONG_BAO_AP_PHI = 11;
//        var CHO_XAC_NHAN_PHI = 12;
//        var DA_GUI_BAO_CAO_XU_LY = 13;
        switch (item.fiTrangthai()) {
            case  DUOC_CAP_GIAYPHEP:
                document.location = app.appContext + '/moh/09/result?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert&maThuTuc=' + self.maThuTuc();
                break;
            case  TU_CHOI_CAP_PHEP:
                self.createPopFiTrangThai('kqxl-template', item);
                self.kqxlHoSo({
                    fiMaHoso: item.fiMaHoso(),
                    fiIdHoso: item.fiIdHoso(),
                    fiTrangthai: item.fiTrangthai()
                }, function (d) {
                    ko.applyBindings(new KetQuaXLVM(d.data), document.getElementById('kqxl-form'));
                });
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
            url: '/moh/09/hoso/kqxl',
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

    self.bSendPaymentClick = function (item, e) {
        var html = [
            $('#payment-tmpl').html()
        ].join('');
        delete self.paymentVM;
        delete self.paymentPopup;
        
        function onSuccess(d) {  
            d.data.lstLoaiThanhToan = params.lstLoaiThanhToan;
            self.paymentVM = new PaymentVM(d.data);
            self.paymentPopup = app.popup({
                title: 'Thông tin lệ phí hồ sơ',
                html: html,
                width: 800,
                buttons: [
                    {
                        name: NSWLang["common_button_gui"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.paymentVM.sendPayment(function () {
                                app.Alert('Gửi thông tin xác nhận phí thành công.');
                                app.popupRemove(self.paymentPopup.selector);
                                self.search(self.paging().currentPage());
                            }, function () {
                                app.Alert('Gửi thông tin xác nhận phí KHÔNG thành công.');
                            });
                        }
                    }
                ]
            }, function(p){
                ko.applyBindings(self.paymentVM, document.getElementById('payment-form'));
            });
        }

        app.makePost({
            url: '/moh/09/get-payment/' + item.fiIdHoso(),
            data: JSON.stringify({ }),
            success: function (res) {
                onSuccess(res);
            },
            error: function (e) { }
        });
        
        return false;
    };
    
    self.bSendReportClick = function (item, e) {
        var html = [
            $('#report-tmpl').html()
        ].join('');
        delete self.reportVM;
        delete self.reportPopup;
        var obj = ko.toJS(item);        
        
        self.reportVM = new ReportVM(obj);
        self.reportPopup = app.popup({
            title: 'Thông báo xử lý lô hàng không đạt',
            html: html,
            width: 800,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.reportVM.sendReport(function () {
                            app.Alert('Gửi thông báo xử lý lô hàng không đạt thành công.');
                            app.popupRemove(self.reportPopup.selector);
                        });
                    }
                }
            ]
        }, function(p){
            if(null !== self.reportVM) {
                ko.applyBindings(self.reportVM, document.getElementById('report-form'));
            }
        });        
        
        return false;
    };
}

$(document).ready(function () {
    var d = {};
    function init() {
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
    }

    $('#loading10').show();
    $.when(
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_TRANGTHAI', null, function (res) {
                if (res.success) {
                    d.lstTrangThai = res.data;
                } else {
                    d.lstTrangThai = [];
                }
                RAW_HS_STATUS = d.lstTrangThai;

            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_COQUANKIEMTRA', null, function (res) {
                if (res.success) {
                    d.lstCoQuanKiemTra = res.data;
                } else {
                    d.lstCoQuanKiemTra = [];
                }
            }),
            app.getCategory('/moh/09/danhmuc', 'DANHMUC_LOAITHANHTOAN', null, function (res) {
                if (res.success) {
                    d.lstLoaiThanhToan = res.data;
                } else {
                    d.lstLoaiThanhToan = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

});