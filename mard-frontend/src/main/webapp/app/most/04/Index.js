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

function RutHoSoVM(fiMsg, fiMaHoso, fiTrangthai) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMaHoso);
    self.fiTrangthai = ko.observable(fiTrangthai);
    self.fiContent = ko.observable(self.fiTrangthai() <= STATUS_CHO_TIEP_NHAN ? 'ly do' : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });

    var lstVG = [self.fiContent];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.fiTrangthai() > 1) {
            if (self.lstErrors().length > 0) {
                self.lstErrors.showAllMessages();
                return false;
            }
        }
        return true;
    };
}

var BoSungTaiLieuVM = function () {
    var self = this;

    self.fiThongtinbosung = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true},
        maxLength: {message: '500 ký tự', params: 500}
    });
    self.fiTenTep = ko.observable(null);
    self.lstDinhkem = ko.observableArray([]);

    var errorVG = [self.fiThongtinbosung];
    self.lstBSErrors = ko.validation.group(errorVG, {deep: true, live: true, observable: true});

    self.formData = null;

    //HAM XU LY
    self.fileUpload = function (data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
        self.fiTenTep(files[0].name);
    };

    self.isValid = function () {
        if (self.lstBSErrors().length > 0) {
            self.lstBSErrors.showAllMessages();
            return false;
        }
        if (self.lstDinhkem().length <= 0) {
            app.Alert('Bạn phải chọn ít nhất một file đính kèm để hoàn thành thao tác này.');
            return false;
        }

        return true;
    };

    self.validateForm = function () {
        if (!self.formData) {
            app.Alert('Bạn chưa chọn tệp đính kèm');
            return false;
        }
        return true;
    };

    self.uploadClick = function () {
        if (!self.validateForm()) {
            return;
        }

        var fileInfo = {
            fiMaLoaiDk: 4,
            fiTenLoaiDk: 'Tài liệu bổ sung',
            fiTenTep: self.fiTenTep()
        };

        var cb = function (d) {
            if (d && d.success) {
                fileInfo.fiKhcnId = d.data.fileId;
                fileInfo.fiIdDk = -1 * new Date().getTime();
                var item = new Tbddinhkem4(self.lstDinhkem().length + 1, fileInfo);
                self.lstDinhkem.push(item);
                self.clearForm();
            } else {
                app.Alert('Upload không thành công, vui lòng thử lại lần nữa!');
            }
        };

        app.uploadFile({
            file: $('#fiTep')[0].files[0],
            mcode: 'most',
            pcode: '01',
            success: function (d) {
                cb(d);
            },
            error: function (e) {
                //console.log(e);
            }
        });


    };

    self.clearForm = function () {
        self.formData = null;
        self.fiTenTep(null);
        document.getElementById("fiTep").value = "";
        self.lstBSErrors.showAllMessages(false);
    };

    self.bXoaClick = function (item, e) {
        if (confirm("Bạn có muốn xóa tệp đính kèm")) {
            if (item) {
                self.lstDinhkem.remove(function (f) {
                    return f.fiIdDk() === item.fiIdDk();
                });
            }
        }
    };

    self.toJSON = function () {
        var jsonList = ko.toJS(self.lstDinhkem());
        if (jsonList.length > 0) {
            for (var i = 0; i < jsonList.length; i++) {
                delete jsonList[i]["bXoa"];
                delete jsonList[i]["stt"];
                delete jsonList[i]["downloadUrl"];
                delete jsonList[i]['__ko_mapping__'];
            }
        }
        return jsonList;
    };
};

var HistoryVM = function (item) {
    var self = this;

    self.fiIdHoso = ko.observable(item.fiIdHoso());
    self.fiMaHoso = ko.observable(item.fiMaHoso());
    self.historyItems = ko.observableArray([]);

    self.currentPage = ko.observable(0);
    self.pageSize = ko.observable(15);
    self.totalCount = ko.observable(0);

    self.historyItems = ko.observableArray([]);


    self.search = function (cb) {
        var data = {
            currentPage: self.currentPage(),
            pageSize: self.pageSize(),
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso()
        };

        app.makePost({
            url: '/most/04/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? ListTbdlichsu4Model(res.data) : [];
                    self.historyItems([]);
                    self.historyItems(list);
                    self.totalCount(res.data ? res.total : 0);
                    cb();
                }
            },
            error: function (e) { }
        });
    };
};

var stringStartsWith = function (string, startsWith) {
    string = string || "";
    if (startsWith.length > string.length)
        return false;
    return string.substring(0, startsWith.length) === startsWith;
};

function danhSachVM()
{
    self = this;
    self.maHoSo = ko.observable(null);
    self.maNhomHangHoa = ko.observable(null);
    self.trangThaiHoSo = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.totalCount = ko.observable(0);

    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.currentPage = ko.observable(0);
    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));
    //Get Status OK?
    self.completeGetStatus = ko.observable(false);
    //Danh trang thai ho so   
    self.fiTrangthaiList = ko.observableArray([]);
    self.lstNhomHangHoa = ko.observableArray([]);
    //Danh sach ho so
    self.most03Items = ko.observableArray([]);
    //Lich su xu ly ho so
    self.historyItems = ko.observableArray([]);

    self.currentPageSubscription = self.paging().currentPage.subscribe(function (newCurrentPage) {
        if (window.stateChanging) {
            return;
        }
        self.search(newCurrentPage, true);
    });

    self.filteredItems = ko.computed(function () {
        var filter = self.maHoSo() != null ? self.maHoSo().toLowerCase() : null;
        if (!filter) {
            return self.most03Items();
        } else {
            return ko.utils.arrayFilter(self.most03Items(), function (item) {
                return stringStartsWith(item.fiMaHoso().toLowerCase(), filter);
            });
        }
    }, self);

    self.initData = function (page, pushState) {
        if (!self.completeGetStatus()) {
            $.when(
                    app.getCategory('/most/04/danhmuc', 'DM_NHOMHH', null, function (res) {
                        if (res.success) {
                            self.lstNhomHangHoa(res.data);
                        } else {
                            self.lstNhomHangHoa([]);
                        }
                    }),
                    app.getCategory('/most/04/danhmuc', 'HS_STATUS', null, function (res) {
                        if (res.success) {
                            self.fiTrangthaiList(res.data);
                        } else {
                            self.fiTrangthaiList([]);
                        }
                    }).done(function (data) {
                self.completeGetStatus(true);
                self.search(page, pushState);
            }));
        } else {
            self.search(page, pushState);
        }
    };

    self.search = function (page, pushState) {
        var self = this;

        var data = {
            maHoSo: self.maHoSo(),
            maNhomHangHoa: self.maNhomHangHoa(),
            trangThaiHoSo: self.trangThaiHoSo(),
            ngayTaoTuNgay: self.ngayTaoTuNgay(),
            ngayTaoDenNgay: self.ngayTaoDenNgay(),
            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: '/most/04/hoso/search',
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    var list = res.data ? ListTbdHosoModel(res.data, self.pageSize(), page) : [];
                    self.most03Items([]);
                    self.most03Items(list);
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
        if (data.fromFiNgaytao) {
            data.fromFiNgaytao = data.fromFiNgaytao.getTime();
        }
        if (data.toFiNgaytao) {
            data.toFiNgaytao = data.toFiNgaytao.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };

    self.applyState = function (data) {
        if (!data) {
            self.initData(1, false);
        } else {
            self.trangThaiHoSo(data.trangThaiHoSo);
            self.maHoSo(data.maHoSo);
            self.ngayTaoTuNgay(data.ngayTaoTuNgay ? new Date(data.ngayTaoTuNgay) : null);
            self.ngayTaoDenNgay(data.ngayTaoDenNgay ? new Date(data.ngayTaoDenNgay) : null);
            self.initData(data.page ? data.page - 0 : 1, false);
        }
    };

    self.onViewHistoryClick = function (item) {
        var html = [
            $('#history-tmpl').html()
        ].join('');
        delete self.historyVM;
        delete self.historyPop;

        var cb = function () {
            self.historyPop = app.popup({
                title: 'Lịch sử xử lý hồ sơ',
                html: html,
                width: 880,
                buttons: []
            }, function () {
                ko.applyBindings(self.historyVM, document.getElementById('history-form'));
            });
        };
        self.historyVM = new HistoryVM(item);
        self.historyVM.search(cb);
    };

    self.onViewDetail = function (item) {
        document.location = app.appContext + '/most/04/view?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/most/04/create';
        return false;
    };

    self.bSuaHoSoClick = function (item, e) {
        document.location = app.appContext + '/most/04/create?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

    self.bXoaHoSoClick = function (item) {
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
                            url: '/most/04/hoso/delete/' + item.fiIdHoso(),
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
                }
            ]
        });

        ko.applyBindings(self.confirmVM, document.getElementById('xoahoso-form'));
        return false;
    };

    self.bRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;

        self.rutHoSoVM = new RutHoSoVM(NSWLang["common_msg_gui_yeu_cau"], '', item.fiTrangthai());

        self.pop = app.popup({
            title: NSWLang["most_04_popup_ruthoso"],
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (!self.rutHoSoVM.isValidForm())
                            return;
                        var data = {
                            fiIdHoso: item.fiIdHoso(),
                            reason: self.rutHoSoVM.fiContent()
                        };
                        app.makePost({
                            url: '/most/04/hoso/yc-rut',
                            data: JSON.stringify(data),
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
                }
            ]
        });

        ko.applyBindings(self.rutHoSoVM, document.getElementById('ruthoso-form'));
        return false;
    };

    self.bBoSungTaiLieuClick = function (item, e) {
        var html = [
            $('#bosungtailieu-tmpl').html()
        ].join('');
        delete self.boSungTaiLieuVM;
        delete self.pop;

        self.boSungTaiLieuVM = new BoSungTaiLieuVM();

        self.pop = app.popup({
            title: NSWLang["most_04_bosungtailieu_popup"] + ' ' + item.fiMaHoso(),
            html: html,
            width: 650,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-send',
                    action: function () {
                        if (!self.boSungTaiLieuVM.isValid()) {
                            return;
                        }

                        var lstDinhkem = self.boSungTaiLieuVM.toJSON();
                        var postData = {
                            fiThongtin: self.boSungTaiLieuVM.fiThongtinbosung(),
                            fiIdHoso: item.fiIdHoso(),
                            lstDinhkem: lstDinhkem
                        };

                        //console.log(postData);
                        app.makePost({
                            url: '/most/04/hoso/bosungtailieu',
                            data: JSON.stringify(postData),
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
                }
            ]
        });
        ko.applyBindings(self.boSungTaiLieuVM, document.getElementById('Most04BoSungTaiLieuForm'));
    };

    self.bXemQuyetDinhClick = function (item, e) {
        document.location = app.appContext + '/most/04/result?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso();
        return false;
    };

    self.onSearchClick = function () {
        self.search(1, true);
    };
}

$(document).ready(function () {
    var vm = new danhSachVM();
    window.stateChanging = true;
    window.stateChangeIsLocal = false;
    ko.applyBindings(vm, document.getElementById('danhSachVM'));
    vm.applyState(app.parseQuerystring());

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
});

