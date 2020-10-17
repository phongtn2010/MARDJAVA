ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var MAX_PAGE_SIZE = 10;
var CERT_TYPE = {
    1: "Giấy chứng nhận kiểm dịch",
    2: "Giấy chứng nhận vận chuyển"
}


function ThongBaoApPhiVM(feeItems) {
    var self = this;
    self.apphiItems = ko.observableArray(feeItems);

    self.apphiItems(ko.utils.arrayMap(feeItems, function (item, index) {
        var itemVM = {};
        ko.mapping.fromJS(item, {}, itemVM);
        return itemVM;
    }));
}

var mapTrangthai = {};
var mapQuocgia = {};
var mapCuakhau = {};

function IndexVM(params) {
    var self = this;
    self.trangThaiKD = ko.observable(null);
    self.trangThaiGS = ko.observable(null);
    self.fiDepartmentofMonitorCode = ko.observable(null);
    self.fiDepartmentofQuarantineCode = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.loaiHoSo = ko.observable(null);
    self.soCongVan = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.xinRutHoSoVM = ko.observable(null);
    self.maSoThue = ko.observable(null);

    self.selectedHoSo = ko.observable(null);

    self.lichsuXuly = ko.observable(new HistoryPopupView());

    self.thongbaoApphi = ko.observable(new ThongBaoApPhiVM([]));
    self.loHangKD = ko.observable(null);

    self.lstHoso = ko.observableArray([]);
    self.lstGP = ko.observableArray([]);
    self.currentCNKDCert = ko.observable(null);
    self.currentCNVCCert = ko.observable(null);
    self.editGCNVM = ko.observable(null);

    self.xinRutHoSoVM = ko.observable(new XinRutHoSoVM());


    self.totalCount = ko.observable(0);

    // self.lstProfileStatus = ko.observableArray([]);
    mapTrangthai = params.mapTrangthai;
    // mapQuocgia = params.mapQuocgia;
    // mapCuakhau = params.mapCuakhau;
    self.fiTrangthaiList = ko.observableArray(params.hasOwnProperty('lstTrangthai') ? params.lstTrangthai : []);
    self.fiListCoquan = ko.observableArray(params.hasOwnProperty('lstCoquan') ? params.lstCoquan : []);

    self.pageSize = ko.observable(MAX_PAGE_SIZE);

    self.currentPage = ko.observable(null);

    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));


    self.xemTBApphi = function (item, e) {
        $("#loading08").show();

        app.makeGet({
            url: "/mard/07/apphi?fiHSCode=" + item.fiNSWFileCode,
            success: function (d) {
                $("#loading08").hide();
                $("#modal_thongbaoApphi").modal('toggle');
                self.thongbaoApphi(new ThongBaoApPhiVM(d.data));
            },
            error: function (e) {
                $("#loading08").hide();
            }
        });

        return false;
    };

    self.downloadGVC = function(data) {
        window.open(app.appContext + "/mard/07/gcn/download/gvc/" + data.fiNSWFileCode(), '_blank');
    }

    self.downloadCNKD = function(data) {
        window.open(app.appContext + "/mard/07/gcn/download/cnkd/" + data.fiNSWFileCode(), '_blank');
    }


    self.xemLichsu = function (item, e) {

        self.lichsuXuly().show(item.fiNSWFileCode)

        return false;
    };


    self.toDate = function (dateStr) {
        var splits = dateStr.split("/");
        var day = splits[0];
        var month = splits[1];
        var year = splits[2];
        return new Date(year, month - 1, day);
    };

    self.getProfileStatus = function (statuscode) {
        var lstProfileStatus = self.fiTrangthaiList();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == statuscode;
        })
        if (pos)
            return pos.name;
        else {
            if (statuscode == -1 || statuscode == '-1' || statuscode == 33 || statuscode == "33") return "";
            else return statuscode;
        }
    }

    self.fiThuTucId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    /**
     * Ấn nút chuyển trang
     * @param {type} newCurrentPage Trang mới
     */
    self.paging().currentPage.subscribe(function (newCurrentPage) {
        if (window.stateChanging) {
            return;
        }
        self.currentPage(newCurrentPage);
        self.search(newCurrentPage, true);
    });


    self.searchHoSoClick = function () {
        self.search(0, true);
    }


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
            self.trangThaiKD(data.trangThaiKD);
            self.trangThaiGS(data.trangThaiGS);
            self.maHoSo(data.maHoSo);
            self.soCongVan(data.soCongVan);
            self.ngayTaoTuNgay(data.ngayTaoTuNgay ? new Date(data.ngayTaoTuNgay) : null);
            self.ngayTaoDenNgay(data.ngayTaoDenNgay ? new Date(data.ngayTaoDenNgay) : null);
            self.ngayCapTuNgay(data.ngayCapTuNgay ? new Date(data.ngayCapTuNgay) : null);
            self.ngayCapDenNgay(data.ngayCapDenNgay ? new Date(data.ngayCapDenNgay) : null);
            self.loaiHoSo(data.loaiHoSo);
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
            self.searchAfterHasCategory(page, pushState);
            // app.getCategory('/mard/09/danhmuc', 'HS_TRANGTHAI', null, function (res) {
            //     if (res.success) {
            //         RAW_HS_STATUS = res.data;
            //         // self.fiTrangthaiList(mapCategory(RAW_HS_STATUS));
            //         self.searchAfterHasCatgory(page, pushState);
            //     }
            // });
        } else {
            self.searchAfterHasCategory(page, pushState);
        }
    };
    /**
     * Tìm kiếm hồ sơ sau khi có danh mục
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.searchAfterHasCategory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();

        var from = $("#ngayTaoTuNgay").val();
        var to = $("#ngayTaoDenNgay").val();
        if (from != null && to != null) {
            var f = self.toDate(from);
            var t = self.toDate(to);
            if (f.getTime() > t.getTime()) {
                app.Alert('Ngày nộp đến phải lớn hơn hoặc bảng Ngày nộp từ');
                return false;
            }
        }

        var from2 = $("#ngayCapTuNgay").val();
        var to2 = $("#ngayCapDenNgay").val();
        if (from2 != null && to2 != null) {
            var f2 = self.toDate(from2);
            var t2 = self.toDate(to2);
            if (f2.getTime() > t2.getTime()) {
                app.Alert('Ngày cấp phép đến phải lớn hơn hoặc bảng Ngày cấp phép từ');
                return false;
            }
        }
        self.loaiHoSo(parseInt(self.fiThuTucId()) == 12 ? 2 : 1);

        var data = {
            fiKDStatus: self.trangThaiKD(),
            fiGSStatus: self.trangThaiGS(),
            fiHSCode: self.maHoSo(),
            licenseNo: self.soCongVan(),
            fiDepartmentofQuarantineCode: self.fiDepartmentofQuarantineCode(),
            fiDepartmentofMonitorCode: self.fiDepartmentofMonitorCode(),
            sentStartDate: self.ngayTaoTuNgay(),
            sentEndDate: self.ngayTaoDenNgay(),
            licenseStartDate: self.ngayCapTuNgay(),
            licenseEndDate: self.ngayCapDenNgay(),
            size: self.pageSize(),
            page: page,
            sortBy: "fiCreatedDate",
            order: "des"
            // page: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/mard/07/hoso/find",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.lstHoso([]);
                    var list = res.data.data;
                    // var list = res.data ? mapTbdhoso09(res.data.data, (data.page - 1) * data.size) : [];
                    list.forEach(function (item) {
                        item.isShowApphi = item.fiPaymentStatus != -1 && item.fiPaymentStatus != null;
                    })

                    self.lstHoso(list);
                    self.paging().update({
                        totalCount: res.data ? res.data.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: page
                    });
                    self.totalCount(res.data ? res.data.total : 0);
                    if (pushState) {
                        self.pushState(data);
                    }
                }
            },
            error: function (e) {
            }
        });
    };

    self.viewLstGiayPhep = function (item) {
        var code = item.fiNSWFileCode;
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/07/giayphep/view?code=" + code + "&type=all",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                $('#loading08').hide();
                if (res.success) {
                    var lstGP = [];
                    var haveCNKD = false;
                    res.data.cnkd.forEach(function (item) {
                        item.fiCertType = 1;
                        item.fiCertName = CERT_TYPE[item.fiCertType];
                        item.isShowXinSua = item.fiEditStatus == null || item.fiEditStatus
                        haveCNKD = true;
                        lstGP.push(item);
                    })
                    res.data.gvc.forEach(function (item) {
                        item.fiCertType = 2;
                        item.fiCertName = CERT_TYPE[item.fiCertType];
                        item.fiEditStatus = haveCNKD ? 1 : item.fiEditStatus
                        lstGP.push(item);
                    })
                    self.lstGP(lstGP)
                    $('#modal_viewGiayPhep').modal('show');
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
            }
        });
    }

    self.viewGiayPhep = function (item) {
        if (item.fiCertType == 1) {
            self.currentCNKDCert(ko.mapping.fromJS(item));
            $('#modal_viewCNKD').modal('show');
        } else if (item.fiCertType == 2) {
            self.currentCNVCCert(ko.mapping.fromJS(item));
            $('#modal_viewCNVC').modal('show');
        }
    }

    self.xinSuaGCN = function (data) {
        self.editGCNVM(new SuaGCNVM("Xin sửa GCN: " + data.fiCertificateNo, data));
        $("#modal_req_edit_cert").modal('show');
    };

    self.goViewHoSo = function (item, e) {
        window.location.href = app.appContext + "/mard/07/view/" + item.fiIdHS;
        return true;
    }

    self.goEditHoSo = function (item) {
        window.location.href = app.appContext + "/mard/07/edit/" + item.fiIdHS;
        return true;
    }

    self.goYCRHoSo = function(item) {
        self.xinRutHoSoVM().update(item);
        $('#modalXinRut').modal('show');
    }

    self.goYCSHoSo = function (item) {
        window.location.href = app.appContext + "/mard/07/ycs/" + item.fiIdHS;
        return true;
    }

    self.viewDonDK = function (item) {
        item.fiSelectedRequestOptions = item.fiRequestOption ? item.fiRequestOption.split(',') : [];
        self.selectedHoSo(ko.mapping.fromJS(item));
        $('#modal_viewHoso').modal('show');
    }

    self.downloadDonDK = function() {
        window.open(app.appContext + "/mard/07/hoso/download/" + self.selectedHoSo().fiIdHS(), '_blank');
    }

    self.viewLHKD = function (item) {
        var code = item.fiNSWFileCode;
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/07/giayphep/view?code=" + code + "&type=cnkdkd",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                $('#loading08').hide();
                if (res.success) {
                    self.loHangKD(res.data[0])
                    $('#modal_viewLHKD').modal('show');
                } else {
                    app.Alert(res.message);
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
            }
        });
    }

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

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };

    self.deleteHoso = function (item) {
        // return;
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hồ sơ ' + item.fiNSWFileCode + '?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $.ajax({
                            async: true,
                            type: 'GET',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + "/mard/07/hoso/delete?fiNSWFileCode=" + item.fiNSWFileCode + "&fiTaxCode=" + hosoUsername,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading08').show();
                            },
                            success: function (res) {
                                $('#loading08').hide();
                                if (res.success) {
                                    app.Alert('Xóa hồ sơ thành công');
                                    self.search(self.currentPage(), true);
                                } else {
                                    app.Alert(res.message);
                                }
                            },
                            error: function (err) {
                            },
                            complete: function (jqXHR, textStatus) {
                                $('#loading08').hide();
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
        })

    }

    self.requestCancelProfile = function () {
        var body = JSON.parse(ko.toJSON(self.xinRutHoSoVM));
        delete body.errorMsg;

        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi yêu cầu xin rút?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/mard/07/hoso/cancel',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi yêu cầu thành công');
                                    self.search(self.currentPage(), true);
                                    if ($('#modalXinRut').hasClass('in')) {
                                        $('#modalXinRut').modal('hide');
                                    }
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
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
    }
}

function XinRutHoSoVM () {
    var xinRutHoSoVMSelf = this;
    xinRutHoSoVMSelf.fiNSWFileCode = ko.observable(null);
    xinRutHoSoVMSelf.fiRequestedDate = ko.observable(null);
    xinRutHoSoVMSelf.fiReason = ko.observable('');
    xinRutHoSoVMSelf.fiIdHS = ko.observable(null);
    xinRutHoSoVMSelf.fiGSStatus = ko.observable(null);
    xinRutHoSoVMSelf.fiKDStatus = ko.observable(null);
    xinRutHoSoVMSelf.errorMsg = ko.observable('');

    xinRutHoSoVMSelf.clearForm = function () {
        xinRutHoSoVMSelf.errorMsg('')
    }

    xinRutHoSoVMSelf.update = function (data) {
        xinRutHoSoVMSelf.fiNSWFileCode(data.fiNSWFileCode);
        xinRutHoSoVMSelf.fiIdHS(data.fiIdHS);
        xinRutHoSoVMSelf.fiRequestedDate(new Date());
        xinRutHoSoVMSelf.fiGSStatus(data.fiGSStatus);
        xinRutHoSoVMSelf.fiKDStatus(data.fiKDStatus);
    }
}

$(document).ready(function () {
    var d = {};
    $('#loading08').show();
    $.when(app.sendGetRequest("/mard/09/dvxl", function (data) {
            var lstTramThuY = {};
            var lstCoquan = [];
            var lstChildPU = data.data[0].lstChildPU;
            lstChildPU.forEach(function (itemChicuc) {
                lstTramThuY[itemChicuc.fiPUCode] = itemChicuc.fiPUDesc
                lstCoquan.push(itemChicuc);
                itemChicuc.lstChildPU.forEach(function (itemTram) {
                    lstTramThuY[itemTram.fiPUCode] = itemTram.fiPUDesc
                    lstCoquan.push(itemTram);
                })
            });
            d.lstCoquan = lstCoquan;
            d.tramThuY = lstTramThuY;
        }), // Get profile status
        app.sendGetRequest("/mard/07/danhmuc/trangthai?systemId=7", function (res) {
            d.lstTrangthai = res.data;
            var mapTrangthai = {};
            d.lstTrangthai.forEach(function (item) {
                mapTrangthai[item.id.toString()] = item.name
            });
            d.mapTrangthai = mapTrangthai;
        })).done(function (data) {
        init();
        $('#loading08').hide();
    });


    var init = function () {
        $.fn.select2.defaults.set("theme", "bootstrap");
        $(".select2").select2({placeholder: '-- Tất cả --', width: '100%', allowClear: true});

        var vm = new IndexVM(d);
        ko.applyBindings(vm, document.getElementById('mard07'));
        vm.applyState(app.parseQuerystring());
        window.stateChangeIsLocal = false;
        window.stateChanging = true;
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
});
