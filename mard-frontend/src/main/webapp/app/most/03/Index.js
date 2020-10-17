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
var DelayVM = function (options) {
    var self = this;

    self.delayDateTo = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true},
        BeforeCurrentDate: {message: "Ngày bạn nhập không được nhỏ hơn ngày hiện tại"}
    });
    self.reason = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true},
        maxLength: {message: '2000 ký tự', params: 500}
    });
    self.fiThoiHanHienTai = ko.observable(options.fiThoiHanHienTai);

    var delayVG = [self.delayDateTo, self.reason];
    self.lstErrors = ko.validation.group(delayVG, {deep: true, live: true, observable: true});

    self.formData = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return;
        }

        return {
            'reason': self.reason(),
            'delayDateTo': self.delayDateTo()
        };
    };

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }
        return true;
    };
};

var CongVanVM = function (item) {
    var self = this;

    self.fiIdCv = ko.observable(null);
    self.fiIdHoso = ko.observable(item.fiIdHoso());
    self.fiMaHoso = ko.observable(item.fiMaHoso());
    self.fiSoCv = ko.observable(null);
    self.fiNgayCap = ko.observable(null);
    self.fiNguoiKy = ko.observable(null);
    self.fiChucVu = ko.observable(null);
    self.fiTenTep = ko.observable(null);
    self.dinhkem = ko.observable(null);

    self.search = function (cb) {
        app.makePost({
            url: '/most/03/hoso/congvan',
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                fiMaHoso: self.fiMaHoso()
            }),
            success: function (res) {
                if (res.success) {
                    var d = res.data ? res.data : null;
                    if (d !== null) {
                        self.fiSoCv(d.fiSoCv);
                        self.fiNgayCap(d.fiNgayCap);
                        self.fiNgayCapTxt = ko.observable(self.fiNgayCap).extend({vnDateShort: true});
                        self.fiNguoiKy(d.fiNguoiKy);
                        self.fiChucVu(d.fiChucVu);
                        self.fiTenTep(d.fiTenTep);
                        self.dinhkem(d.dinhkem);
                        self.downloadUrl = ko.computed(function () {
                            return app.appContext + "/getfile/most/03/" + d.dinhkem.fiGuiId;
                        });
                        cb();
                    } else {
                        app.Alert(res.message);
                    }
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
            fiTrangthai: 0
        };

        app.makePost({
            url: '/most/03/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? ListTbdlichsu3Model(res.data) : [];
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
    self.loaiHoSo = ko.observable(null);
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
    self.lstLoaiHoSo = ko.observableArray([]);
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
                    app.getCategory('/most/03/danhmuc', 'DM_LOAIHOSO', null, function (res) {
                        if (res.success) {
                            self.lstLoaiHoSo(res.data);
                        } else {
                            self.lstLoaiHoSo([]);
                        }
                    }),
                    app.getCategory('/most/03/danhmuc', 'HS_STATUS', null, function (res) {
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
            loaiHoSo: self.loaiHoSo(),
            trangThaiHoSo: self.trangThaiHoSo(),
            ngayTaoTuNgay: self.ngayTaoTuNgay(),
            ngayTaoDenNgay: self.ngayTaoDenNgay(),
            pageSize: self.pageSize(),
            currentPage: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: '/most/03/hoso/search',
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
            error: function (e) {
                window.stateChanging = false;
            }
        });
    };

    self.pushState = function (data) {
        if (data.fromFiNgaytao) {
            data.ngayTaoTuNgay = data.ngayTaoTuNgay();
        }
        if (data.toFiNgaytao) {
            data.ngayTaoDenNgay = data.ngayTaoDenNgay();
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
        document.location = app.appContext + '/most/03/view?fiIdHoso=' + item.fiIdHoso();
        return false;
    };

    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/most/03/create';
        return false;
    };

    self.bSuaHoSoClick = function (item, e) {
        document.location = app.appContext + '/most/03/create?fiIdHoso=' + item.fiIdHoso();
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
                            url: '/most/03/hoso/delete/' + item.fiIdHoso(),
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
    
    self.verifySignature = function(action, signData, dataPostAfterSign){        
        app.makePost({
            url: '/most/03/verify',
            data: JSON.stringify(signData),
            success: function (d) {
                app.makePost({
                    url: action,
                    data: JSON.stringify(dataPostAfterSign),
                    success: function (d) {
                        app.Alert(NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"]);
                        self.search(self.paging().currentPage());
                        app.popupRemove(self.pop.selector);
                    },
                    error: function (e) {
                        app.Alert('Gửi yêu cầu không thành công');
                    }
                });
            },
            error: function (e) {
                if(e.hasOwnProperty('message')) {
                    app.Alert(e.message);
                } else {
                    app.Alert('Ký số không thành công, vui lòng thử lại.');
                }
            }
        });
    };

    self.bRutHoSoClick = function (item, e) {
        var html = [
            $('#ruthoso-tmpl').html()
        ].join('');
        delete self.rutHoSoVM;
        delete self.pop;

        self.rutHoSoVM = new RutHoSoVM(NSWLang["common_msg_gui_yeu_cau"], '', item.fiTrangthai());
        
        self.pop = app.popup({
            title: NSWLang["most_03_popup_ruthoso"],
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
                            reason: self.rutHoSoVM.fiContent(),
                            getXmlNotSend: !app.requireSigning ? 'false' : 'true'
                        };
                        var action = '/most/03/hoso/yc-rut';
                        app.makePost({
                            url: action,
                            data: JSON.stringify(data),
                            success: function (d) {
                                var msg = '';                                
                                if (!app.requireSigning) {
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                    self.search(self.paging().currentPage());
                                    app.popupRemove(self.pop.selector);
                                    app.Alert(msg);
                                } else {
                                    data.getXmlNotSend = 'false';
                                    var result = d.sign;
                                    app.popupRemove(self.pop.selector);
                                    var onSuccess = function (res) {
                                        if (res.status == 'ok') {
                                            var signData = {
                                                'signatureXml': res.outputData,
                                                'messageXml': result.fiXml,
                                                'msgFunc': result.fiFunc,
                                                'msgType': result.fiMsgType,
                                                'documentCode': item.fiMaHoso            
                                            };
                                            self.verifySignature(action, signData, data);
                                        } else {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        }
                                    };
                                    var onFailed = function (e) {
                                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                                    };
                                    
                                    RTVNSignClient.ping(function(res){
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function(e){
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
                    name: NSWLang["common_button_dong"],
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

    self.bGiaHanBoSungClick = function (item, e) {
        var html = [
            $('#xinluihan-tmpl').html()
        ].join('');
        delete self.delayVM;
        delete self.pop;
        
        var cb = function (data) {
            self.delayVM = new DelayVM(data);

            self.pop = app.popup({
                title: NSWLang["most_03_popup_xinluihan_title"] + ' ' + item.fiMaHoso(),
                html: html,
                width: 650,
                buttons: [
                    {
                        name: NSWLang["common_button_gui"],
                        class: 'btn',
                        icon: 'fa-send',
                        action: function () {
                            if (!self.delayVM.isValidForm()) {
                                return;
                            }

                            var formData = self.delayVM.formData();
                            formData.fiIdHoso = item.fiIdHoso();
                            formData.getXmlNotSend = !app.requireSigning ? 'false' : 'true';
                            var action = '/most/03/hoso/yc-giahanbosung';
                            app.makePost({
                                url: action,
                                data: JSON.stringify(formData),
                                success: function (d) {
                                    var msg = '';
                                    if (!app.requireSigning) {
                                        app.popupRemove(self.pop.selector);
                                        self.search(self.paging().currentPage());
                                        app.Alert(NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"]);
                                    } else {
                                        formData.getXmlNotSend = 'false';
                                        var result = d.sign;
                                        app.popupRemove(self.pop.selector);
                                        var onSuccess = function (res) {
                                            if (res.status == 'ok') {
                                                var signData = {
                                                    'signatureXml': res.outputData,
                                                    'messageXml': result.fiXml,
                                                    'msgFunc': result.fiFunc,
                                                    'msgType': result.fiMsgType,
                                                    'documentCode': item.fiMaHoso            
                                                };
                                                self.verifySignature(action, signData, data);
                                            } else {
                                                app.Alert('Ký số không thành công, vui lòng thử lại.');
                                            }
                                        };
                                        var onFailed = function (e) {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        };
                                        
                                        RTVNSignClient.ping(function(res){
                                            RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                        }, function(e){
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
                    }
                ]
            });
            ko.applyBindings(self.delayVM, document.getElementById('xinluihan-form'));
        };

        app.makePost({
            url: '/most/03/hoso/tt-giahan/',
            data: JSON.stringify({fiIdHoso: item.fiIdHoso()}),
            success: function (d) {
                cb({
                    reason: '',
                    delayDateTo: null,
                    fiThoiHanHienTai: d.data != null ? Util.convertToDateTime(d.data) : ''
                });
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

    self.bXemQuyetDinhClick = function (item, e) {
        if (item.fiLoaiHoso() == '1') {
            var html = [
                $('#congvan-tmpl').html()
            ].join('');
            delete self.congVanVM;
            delete self.pop;

            self.congVanVM = new CongVanVM(item);

            var cb = function () {
                self.pop = app.popup({
                    title: 'Công văn nhận đăng ký PDM hồ sơ ' + item.fiMaHoso(),
                    html: html,
                    width: 650,
                    buttons: []
                });
                ko.applyBindings(self.congVanVM, document.getElementById('congvan-form'));
            };

            self.congVanVM.search(cb);

        } else {
            document.location = app.appContext + '/most/03/result?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso();
        }
        return false;
    };

    self.onSearchClick = function () {
        self.search(1, true);
    };
}

$(document).ready(function () {
    var vm = new danhSachVM();
    window.stateChangeIsLocal = false;
    window.stateChanging = true;
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

