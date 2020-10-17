ko.validation.rules.pattern.message = 'Invalid.';
var ERROR_FILL_INPUT = 'Vui lòng nhập trường này';

ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var MAX_PAGE_SIZE = 10;
var mapTrangthai = {};

function ThongBaoApPhiVM(feeItems, hsCode) {
    var self = this;
    self.apphiItems = ko.observableArray(feeItems);
    self.fiHSCode = ko.observable(hsCode);

    self.apphiItems(ko.utils.arrayMap(feeItems, function (item, index) {
        var itemVM = {};
        ko.mapping.fromJS(item, {}, itemVM);
        return itemVM;
    }));
}

function IndexVM(params) {
    self = this;
    self.trangThaiHS = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.loaiHoSo = ko.observable(null);
    self.soCongVan = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.xinRutHoSoVM = ko.observable(null);
    self.maSoThue = ko.observable(null);
    self.xinXoaHoSoVM = ko.observable(null);
    self.YeuCauSuaGCN = ko.observable(null);
    self.fiRequestDate = ko.observable(null);
    self.fiFileName = ko.observable(null);
    self.fiFileAttack = ko.observable(null);
    self.fiReason = ko.observable(null);
    self.YeuCauHuyGCN = ko.observable(null);
    self.thongBaoKhongdatYCXK = ko.observable(new ThongBaoKhongdatYCXK());

    self.thongbaoApphi = ko.observable(new ThongBaoApPhiVM([]));

    self.lichsuXuly = ko.observable(new HistoryPopupView([]));

    mapTrangthai = params.mapTrangthai;

    self.showHoso01VM = ko.observable(null);

    self.Items = ko.observableArray([]);

    self.show13a = ko.observable();
    self.show13b = ko.observable();
    self.showGPChina = ko.observable();
    self.showGPHKGa = ko.observable();
    self.showGPHKLon = ko.observable();
    self.showGPMalay = ko.observable();

    self.totalCount = ko.observable(0);

    self.fiTrangthaiList = ko.observableArray(params.hasOwnProperty('lstTrangthai') ? params.lstTrangthai : []);

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

    self.fiThuTucId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    self.downloadHS = function(data) {
        window.open(app.appContext + "/mard/01/hoso/download/" + data.fiIdHS(), '_blank');
    }


    self.showTBAP = function(hoso) {
        $("#loading01").show();

        app.makeGet({
            url: "/mard/01/apphi?fiNSWFileCode=" + hoso.fiNSWFileCode,
            success: function (d) {
                $("#loading01").hide();
                $("#modal_thongbaoApphi").modal('toggle');
                self.thongbaoApphi(new ThongBaoApPhiVM(d.data));
            },
            error: function (e) {
                $("#loading01").hide();
            }
        });

        return false;
    };

    self.showGP = function (item) {
        var loaiGP = {
            "1":"13a",
            "2":"13b",
            "3":"hkp",
            "4":"m",
            "5":"hkc",
            "6":"cn"
        };

        $("#loading01").show();
        app.makeGet({
            url: "/mard/01/giayphep?fiNSWFileCode=" + item.fiNSWFileCode + "&type=" + loaiGP[item.fiLicenseType.toString()],
            success: function (d) {
                $("#loading01").hide();
                if (item.fiLicenseType == 1) {
                    self.show13a(new GP13A(d.data, item.fiHSStatus));
                    $("#modal_13a").modal('toggle');
                } else if (item.fiLicenseType == 2) {
                    self.show13b(new GP13B(d.data, item.fiHSStatus));
                    $("#modal_13b").modal('toggle');
                } else if (item.fiLicenseType == 3) {
                    self.showGPHKLon(new GPHongKongLon(d.data, item.fiHSStatus));
                    $("#modal_gcn_hk_lon").modal('toggle');
                } else if (item.fiLicenseType == 4) {
                    self.showGPMalay(new GPMalay(d.data, item.fiHSStatus));
                    $("#modal_gcn_malay").modal('toggle');
                } else if (item.fiLicenseType == 5) {
                    self.showGPHKGa(new GPHongKongGa(d.data, item.fiHSStatus));
                    $("#modal_gcn_hk_ga").modal('toggle');
                } else {
                    self.showGPChina(new GPChina(d.data, item.fiHSStatus));
                    $("#modal_gcn_china").modal('toggle');
                }
            },
            error: function (e) {
                $("#loading01").hide();
            }
        });

        return false;
    };


    self.showThongBaoKhongDatYCXK = function(item) {
        self.thongBaoKhongdatYCXK().showTB(item.fiNSWFileCode)
    };


    self.showLSXL = function (item) {
        self.lichsuXuly().show(item.fiNSWFileCode);

        return false;
    };

    self.xinRutHoso = function (hoso) {
        var url = "/mard/01/hoso/xinrutttn";
        var html = '';
        if (hoso.fiHSStatus != 1 && hoso.fiHSStatus != 8) {
            html = [
                $('#cancel-template').html()
            ].join('');
            url = "/mard/01/hoso/xinrut";
        }
        self.pop = app.popup({
            title: 'Xin hủy hồ sơ: ' + hoso.fiNSWFileCode,
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Gửi',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        var val = $('#fiLydo').val();
                        var data = {
                            fiReason: val,
                            fiIdHS: hoso.fiIdHS,
                            fiNSWFileCode: hoso.fiNSWFileCode
                        };
                        data = JSON.stringify(data);

                        $.ajax({
                            async: true,
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + url,
                            data: data,
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading01').show();
                            },
                            success: function (res) {
                                if (res && res.success) {
                                    // 11 - 04, chua tiep nhan
                                    // 14 - 09, da tiep nhan
                                    $('#loading01').hide();
                                    location.reload();
                                } else {
                                    alert(res.message);
                                    $('#loading01').hide();
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading01').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                app.popupRemove(self.pop.selector);
                                $('.modal-scrollable').hide();
                                $('.modal-backdrop').hide();
                            }
                        });
                    }
                }
            ]
        });
    };

    self.xemHoso = function(hoso) {
        window.location.href =  app.appContext + "/mard/01/view/" + hoso.fiIdHS
    };


    self.showHoso = function(hoso){
        self.showHoso01VM(new Hoso01VM(hoso));
        $("#modal_xemhoso").modal('toggle');
    };

    self.suaHoso = function(hoso) {
        window.location.href =  app.appContext + "/mard/01/edit/" + hoso.fiIdHS
    };

    self.xinSuaHoso = function(hoso) {
        window.location.href =  app.appContext + "/mard/01/ycs/" + hoso.fiIdHS
    };



    /**
     * Ấn nút chuyển trang
     * @param {type} newCurrentPage Trang mới
     */
    self.clearForm = function() {
        self.trangThaiHS(null);
        self.maHoSo(null);
        self.soCongVan(null);
        self.ngayTaoTuNgay(null);
        self.ngayTaoDenNgay(null);
        self.ngayCapTuNgay(null);
        self.ngayCapDenNgay(null);
        self.loaiHoSo(null);
    };
    self.paging().currentPage.subscribe(function (newCurrentPage) {
        self.clearForm()
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
            self.trangThaiHS(data.trangThaiHS);
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
            self.searchAfterHasCatgory(page, pushState);
            // app.getCategory('/mard/01/danhmuc', 'HS_TRANGTHAI', null, function (res) {
            //     if (res.success) {
            //         RAW_HS_STATUS = res.data;
            //         self.fiTrangthaiList(mapCategory(RAW_HS_STATUS));
            //         self.searchAfterHasCatgory(page, pushState);
            //     }
            // });
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
            fiHSStatus: self.trangThaiHS(),
            fiHSCode: self.maHoSo(),
            licenseNo: self.soCongVan(),
            sentStartDate: self.ngayTaoTuNgay(),
            sentEndDate: self.ngayTaoDenNgay(),
            licenseStartDate: self.ngayCapTuNgay(),
            licenseEndDate: self.ngayCapDenNgay(),
            size: self.pageSize(),
            page: page,
            sortBy: "fiNSWFileCode",
            order: "desc"
            // page: self.paging().currentPage() <= 0 ? 0 : self.paging().currentPage() - 1
        };

        app.makePost({
            url: "/mard/01/hoso/timkiem",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.Items([]);
                    res.data.data.forEach(function (item) {
                        item.textStatus = mapTrangthai[item.fiHSStatus.toString()];
                        item.isShowAP = item.fiPaymentStatus != null && item.fiPaymentStatus != -1;
                        item.isShowXemHS = item.fiHSStatus !== 6 && item.fiHSStatus >= 2;
                        item.isShowTBKD = [14].includes(item.fiHSStatus);
                        item.isShowXemGP = [3, 11, 12, 15].includes(item.fiHSStatus);
                        item.isShowXinsua = [2, 16, 17].includes(item.fiHSStatus);
                        item.isShowXinrut = [8, 1, 2, 5, 4, 16, 17].includes(item.fiHSStatus);
                        item.isShowSua = [0, 1, 4, 8].includes(item.fiHSStatus);
                        item.isShowXoa = [0].includes(item.fiHSStatus);
                    });

                    self.Items(res.data.data);
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



    self.bXemThongbaoApphi = function(item, e) {
        $("#loading10").show();

        app.makeGet({
            url: "/mard/01/apphi?fiNSWFileCode=" + item.fiNSWFileCode(),
            success: function (d) {
                $("#loading10").hide();
                $("#modal_thongbaoApphi").modal('toggle');
                self.thongbaoApphi(new ThongBaoApPhiVM(d.data));
            },
            error: function (e) {
                $("#loading10").hide();
            }
        });

        return false;
    };

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };
    /**
     * yêu cầu sửa giấy chứng nhận
     *
     */
    self.clearForm = function() {
        self.fiFileName(null);
        self.fiFileAttack(null);
        self.fiReason(null);
    };
    self.yeuCauSuaGCN = function(hoso) {
        self.YeuCauSuaGCN(new YeuCauSuaGCN(hoso.fiNSWFileCode()));
        // self.fiRequestDate = new Date().toJSON().slice(0,10).replace(/-/g,'/');
        $('#modalycsgcn').modal('show');
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = yyyy + '-' + mm + '-' + dd;
        $('#fiRequestDate').val(today);
        self.fiRequestDate(today)
    };
    self.yeuCauHuyGCN = function(hoso) {
        self.YeuCauHuyGCN(new YeuCauHuyGCN(hoso.fiNSWFileCode()));
        $('#modalychgcn').modal('show');
    };
    self.validateYCSGCN = function (fiRequestDate, fiReason) {
        $('.validate').empty();
        var status = true;
        if (fiRequestDate == null || fiRequestDate == '') {
            $('#fiRequestDate-validate').text(ERROR_FILL_INPUT);
            status = false;
        }
        if (fiReason == null || fiReason == '') {
            $('#fiReason-validate').text(ERROR_FILL_INPUT);
            status = false;
        }
        return status;
    };
    self.validateYCSGCN = function (fiRequestDate, fiReason) {
        $('.validate').empty();
        var status = true;
        if (fiRequestDate == null || fiRequestDate == '') {
            $('#fiRequestDate-huy-validate').text(ERROR_FILL_INPUT);
            status = false;
        }
        if (fiReason == null || fiReason == '') {
            $('#fiReason-huy-validate').text(ERROR_FILL_INPUT);
            status = false;
        }
        return status;
    };

    /**
     * Xoá hồ sơ
     *
     */
    self.xoaHoso = function(item) {
        self.xinXoaHoSoVM(new XinXoaHoSoVM(item.fiNSWFileCode));
        $('#modalXoaHoso').modal('show');
    };

    self.deleteProfile = function () {
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/01/hoso/delete?fiNSWFileCode=" + self.xinXoaHoSoVM().fiHSCode() + "&fiTaxCode=" + hosoUsername,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading01').show();
            },
            success: function (res) {
                $('#loading01').hide();
                if (res.success) {
                    app.Alert('Xóa hồ sơ thành công');
                    self.search(self.paging().currentPage(), true);
                    $('#modalXoaHoso').modal('hide');
                } else {
                    app.Alert(res.message);
                }
            },
            error: function (err) {
                // log
            },
            complete: function (jqXHR, textStatus) {
                $('#loading01').hide();
            }
        });
    }

}

function XinXoaHoSoVM (hsCode) {
    xinXoaHoSoVMSelf = this;
    xinXoaHoSoVMSelf.fiHSCode = ko.observable(hsCode);
}

function YeuCauSuaGCN (hsCode) {
    var GCNself = this;
    GCNself.fiHSCode = ko.observable(hsCode);
    GCNself.fiRequestDate = ko.observable(new Date());
    GCNself.fiFileName = ko.observable(null);
    GCNself.fiReason = ko.observable(null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    GCNself.errors = ko.observableArray([]);
    GCNself.validateForm = function() {
        var option = {
            fiReason: GCNself.fiReason
        };
        GCNself.errors = ko.validation.group(option, { deep: true });
        if (GCNself.errors().length > 0) {
            GCNself.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    GCNself.sendYCSGCN = function (data) {
        var file = $("#gcn_file_dinhkem")[0].files[0];
        if (!GCNself.validateForm()) {
            return;
        }
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi yêu cầu sửa giấy chứng nhận?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('#loading01').show();
                        var formData = new FormData();
                        formData.append('file', file);
                        formData.append('fiNSWFileCode', hsCode);
                        formData.append('fiReason', GCNself.fiReason());
                        formData.append('fiFileName', GCNself.fiFileName());

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + '/mard/01/gcn/xinsua',
                            data: formData,
                            processData: false,
                            contentType: false,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                            },
                            success: function (res) {
                                $('#loading01').hide();
                                if (res.success) {
                                    app.Alert("Xin sửa hồ sơ thành công");
                                    location.reload();
                                } else {
                                    app.Alert(res.message)
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading01').hide();
                                app.Alert("Có lỗi xảy ra, vui lòng thử lại sau")
                            },
                            complete: function (jqXHR, textStatus) {
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
                        self.clearForm()
                    }
                }
            ]
        });
    };
}

function YeuCauHuyGCN (hsCode) {
    var GCNself = this;
    GCNself.fiHSCode = ko.observable(hsCode);
    GCNself.fiReason = ko.observable(null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    GCNself.validateForm = function() {
        var option = {
            fiReason: GCNself.fiReason
        };
        GCNself.errors = ko.validation.group(option, { deep: true });
        if (GCNself.errors().length > 0) {
            GCNself.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    GCNself.sendYCHGCN = function () {
        if (!GCNself.validateForm()) {
            return;
        }
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi yêu cầu hủy giấy chứng nhận?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('#loading01').show();
                        var data = {
                            fiReason: GCNself.fiReason(),
                            fiNSWFileCode: hsCode
                        };

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + '/mard/01/hoso/cancelCer',
                            data: JSON.stringify(data),
                            processData: false,
                            contentType: false,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader('Accept', 'application/json');
                                xhr.setRequestHeader('Content-Type', 'application/json');
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                            },
                            success: function (res) {
                                $('#loading01').hide();
                                if (res.success) {
                                    app.Alert("Xin hủy hồ sơ thành công");
                                    location.reload();
                                } else {
                                    app.Alert(res.message)
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading01').hide();
                                app.Alert("Có lỗi xảy ra, vui lòng thử lại sau")
                            },
                            complete: function (jqXHR, textStatus) {
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
                        self.clearForm()
                    }
                }
            ]
        });
    }
}

$(document).ready(function () {
    var init = function (options) {
        var vm = new IndexVM(options);
        ko.applyBindings(vm, document.getElementById('mard01Home'));
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
    var d = {};
    $('#loading01').show();
    $.when(
        app.sendGetRequest("/mard/01/danhmuc/trangthai", function (res) {
            d.lstTrangthai = res.data;
            d.lstTrangthai = res.data;
            d.mapTrangthai = {};
            d.lstTrangthai.forEach(function (status) {
                d.mapTrangthai[status.id.toString()] = status.name;
            })
        })
    ).done(function () {
        init(d);
        $('#loading01').hide();
    });

});
