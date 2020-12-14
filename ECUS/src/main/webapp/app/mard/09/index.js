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
ko.bindingHandlers.formattedTime = {
    update: function(element, valueAccessor) {
        var date = new Date(ko.unwrap(valueAccessor()));
        $(element).text("ngày " + date.getDate() + " tháng " + (date.getMonth()+1) + " năm " + date.getFullYear());
    }
};
ko.bindingHandlers.datetime = {
    update: function(element, valueAccessor) {
        var date = new Date(ko.unwrap(valueAccessor()));
        $(element).text(moment(date).format('DD/MM/YYYY HH:mm'));
    }
};

var formatCurrency = function (amount) {
    return amount.toLocaleString('vi-VI', {style : 'currency', currency : 'VND'});
};

ko.validation.makeBindingHandlerValidatable("datepicker");

var MAX_PAGE_SIZE = 15;

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
            url: '/mard/12/hoso/lichsu',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdlichsu12(res.data) : [];
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


function XinRutHoSoVM (item) {
    var xinRutHoSoVMSelf = this;
    xinRutHoSoVMSelf.fiHSCode = ko.observable(item.fiHSCode());
    xinRutHoSoVMSelf.hideReason = ko.observable(item.fiHSStatus() === 1);
    xinRutHoSoVMSelf.fiReason = ko.observable('').extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    xinRutHoSoVMSelf.fiIdHS = ko.observable(item.fiIdHS());
    xinRutHoSoVMSelf.errorMsg = ko.observable('');

    xinRutHoSoVMSelf.clearForm = function () {
        xinRutHoSoVMSelf.errorMsg('')
    };

    xinRutHoSoVMSelf.sendRequestDeleteProfile = function () {

        var option = {
            fiReason: xinRutHoSoVMSelf.fiReason
        };

        if (!xinRutHoSoVMSelf.hideReason()) {
            var errors = ko.validation.group(option, { deep: true });
            if (errors().length > 0) {
                errors.showAllMessages();
                return false;
            }
        }

        var data = ko.toJS(xinRutHoSoVMSelf);
        app.makePost({
            url: '/mard/09/xinrut',
            data: JSON.stringify(data),
            success: function (res) {
                app.Alert("Xin rút hồ sơ thành công");
                $("#modalXinRut").modal('hide');
                location.reload();

            },
            error: function (res) {
                app.Alert(res.message);
                $("#modalXinRut").modal('hide');
            }
        })
    }
}

function KetQuaXLVM(options) {
    if (options) {
        ko.mapping.fromJS(options, {}, this);
        if (this.fiTrangthai() == 4 && this.attach && this.attach()) {
            var url = app.appContext + '/mard/12/result/';
            
            url = url + this.fiIdHoso() + '/' + this.fiMaHoso() + '/'
                    + this.attach.fiIdDk() + '/' + this.attach.fiGuiId();
            this.downloadUrl = ko.observable(url);
            this.visibleFile = ko.observable(true);
            this.fiTenTep = ko.observable(this.attach.fiTenTep());
            
        } else {
            this.downloadUrl = ko.observable(null);
            this.visibleFile = ko.observable(false);
            this.fiTenTep = ko.observable(null);
        }
    }
}

function XemHoSo03DV(item) {
    var self = this;
    var model = ko.toJS(item);
    ko.mapping.fromJS(model, {}, self);
    self.isShowXacNhanDon = ko.observable(model.fiRegistrationConfirm != null);
}

function XemHoSo03SPDV(item) {
    var self = this;
    var model = ko.toJS(item);
    ko.mapping.fromJS(model, {}, self);
    self.isShowXacNhanDon = ko.observable(model.fiRegistrationConfirm != null);
    self.fiRegistrationConfirm = ko.observable(new RegistrationConfirm(model.fiRegistrationConfirm, item));
}

function XemHoSo20SPDV(item) {
    var self = this;
    var model = ko.toJS(item);
    ko.mapping.fromJS(model, {}, self);
    self.isShowXacNhanDon = ko.observable(model.fiRegistrationConfirm != null);
    self.fiRegistrationConfirm = ko.observable(new RegistrationConfirm(model.fiRegistrationConfirm, item));
}

function XemHoSo20DV(item) {
    var self = this;
    var model = ko.toJS(item);
    ko.mapping.fromJS(model, {}, self);
    self.isShowXacNhanDon = ko.observable(model.fiRegistrationConfirm != null);
    self.fiRegistrationConfirm = ko.observable(new RegistrationConfirm(model.fiRegistrationConfirm, item));
}

function GiayPhepVM(item) {
    var self = this;
    ko.mapping.fromJS(item, {}, self);
    self.fiCertificateNo = ko.observable(item.fiCertificateNo || item.fiQuanlityCerNo);

    var cerType = {
        "1": "gvca",
        "2": "gvcb",
        "5": "xncl",
        "4": "cnkdb",
        "3": "cnkda"
    };
    self.fiLinkFile = ko.observable("/mard/09/download/" + cerType[item.fiCerType ? item.fiCerType.toString() : "-1"] + "/" + item.fiNSWFileCode + "?certNo=" + encodeURI(item.fiCertificateNo));
    var cerTypeNames = {
        "1": "Giấy vận chuyển",
        "2": "Giấy vận chuyển",
        "5": "Giấy xác nhận chất lượng",
        "4": "Giấy chứng nhận kiểm dịch",
        "3": "Giấy chứng nhận kiểm dịch"
    };
    var certStatusString = {
        null: "",
        "0": "",
        "1": "Chờ tiếp nhận yêu cầu sửa",
        "2": "Từ chối sửa",
        "3": "Đồng ý yêu cầu sửa",
        "4": "Đã cấp GCN chỉnh sửa"
    };
    self.isShowXinSua = ko.observable([null, 0, 2, 4].includes(item.fiEditStatus));
    self.fiCertStatusString = ko.observable(certStatusString[item.fiEditStatus ? item.fiEditStatus.toString() : "0"]);
    self.fiCerType = ko.observable(cerTypeNames[item.fiCerType ? item.fiCerType.toString() : "-1"]);
    self.fiCerTypeNo = ko.observable(item.fiCerType);
    self.fiSignResultDate = ko.observable(item.fiSignConfirmDate || item.fiSignResultDate);
}

function LichSuXuLyVM(mahoso, historyItems) {
    var self = this;
    self.fiHSCode = ko.observable(mahoso);
    self.historyItems = ko.observableArray(historyItems);

    self.historyItems(ko.utils.arrayMap(historyItems, function (item, index) {
        var itemVM = {};
        ko.mapping.fromJS(item, {}, itemVM);
        itemVM.fiStatus = ko.observable(mapTrangthai[item.fiStatus.toString()]);
        return itemVM;
    }));

}

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

function XemDanhSachGCNVM(
    lstQualityCer,
    lstQuarantineCer,
    lstTransportDoc,
    fiQualityRejectCer,
    isShowGVC,
    isShowCNKD,
    isShowXNCL,
    isShowThongbaoKhongdat,
    fiHSCode,
    fiIdHS,
    fiHSProductType) {
    var self = this;

    self.items = ko.observableArray([]);
    app.makeGet({
        url: '/mard/09/giayphep/view' + '?type=' + 'all' + '&code=' + fiHSCode,
        success: function (res) {
            if (res.success) {
                $("#modal_dsGiayphep").modal('toggle');
                res.data.cnkd.forEach(function (item) {
                    if ([1,4].includes(fiHSProductType)){
                        //DONG VAT
                        item.fiCerType = 3;
                    } else {
                        item.fiCerType = 4;
                    }
                    self.items.push(new GiayPhepVM(item));
                });
                res.data.gvc.forEach(function (item){
                    if ([1,4].includes(fiHSProductType)){
                        //DONG VAT
                        item.fiCerType = 1;
                    } else {
                        item.fiCerType = 2;
                    }
                    self.items.push(new GiayPhepVM(item));
                });
                res.data.xncl.forEach(function (item) {
                    item.fiCerType = 5;
                    self.items.push(new GiayPhepVM(item));
                });
            }
        },
        error: function (e) { }
    });

    self.lstTransportDoc = lstTransportDoc;
    self.lstQuarantineCer = lstQuarantineCer;
    self.lstQualityCer = lstQualityCer;
    self.fiQualityRejectCer = ko.observable(fiQualityRejectCer);

    self.currentTransportCert = ko.observable(null);

    self.currentQualityCert = ko.observable(null);

    self.currentQuarantineCert = ko.observable(null);

    self.fiCriteriaAnalysisNoText = ko.observable(null);

    self.fiHSCode = ko.observable(fiHSCode);

    self.titleEdit = ko.observable(new SuaGCNVM("Xin sửa GCN: ", fiHSCode, function (success) {

    }));

    self.editGCNVM = ko.observable(null);

    self.xinSua = function (data) {

        self.editGCNVM(new SuaGCNVM("Xin sửa GCN: " + data.fiCertificateNo(), data, function (ok) {
            data.fiEditStatus(1);
            data.fiCertStatusString("Chờ tiếp nhận yêu cầu sửa")
        }));
        $("#modal_req_edit_cert").modal('toggle');
    };

    self.xemGiayPhep = function (cert) {
        switch (cert.fiCerTypeNo()) {
            case 1: {
                self.currentTransportCert(cert);
                $("#modal_xemGVCDV").modal('toggle');
                break;
            }
            case 2: {
                self.currentTransportCert(cert);
                $("#modal_xemGVCSPDV").modal('toggle');
                break;
            }
            case 3: {
                self.currentQuarantineCert(cert);
                $("#modal_xemCNKDDV").modal('toggle');
                break;
            }
            case 4: {
                self.currentQuarantineCert(cert);
                $("#modal_xemCNKDSPDV").modal('toggle');
                break;
            }
            case 5: {
                var certsText = "";
                self.currentQualityCert(cert);
                self.currentQualityCert().lstGood().forEach(function(good, index) {
                    certsText += good.fiCriteriaAnalysisNo() + ", "
                });
                self.fiCriteriaAnalysisNoText(certsText.substr(0, certsText.length - 2));
                $("#modal_xemXNCL").modal('toggle');
                break;
            }

        }
    };
}



var mapTrangthai = {};
var mapQuocgia = {};
var mapCuakhau = {};
var mapDonviTinh = {};

function IndexVM(params) {
    self = this;
    self.trangThaiKD = ko.observable(null);
    self.trangThaiGS = ko.observable(null);
    self.maHoSo = ko.observable(null);
    self.loaiHoSo = ko.observable(null);
    self.soCongVan = ko.observable(null);
    self.ngayTaoTuNgay = ko.observable(null);
    self.ngayTaoDenNgay = ko.observable(null);
    self.ngayCapTuNgay = ko.observable(null);
    self.ngayCapDenNgay = ko.observable(null);
    self.lichsuXuly = ko.observable(new HistoryPopupView());
    self.thongbaoApphi = ko.observable(new ThongBaoApPhiVM([]));
    self.xinRutHoSoVM = ko.observable(null);
    self.maSoThue = ko.observable(null);

    self.xemHoSo03DV = ko.observable(null);

    self.xemHoSo03SPDV = ko.observable(null);

    self.xemHoSo20DV = ko.observable(null);

    self.xemHoSo20SPDV = ko.observable(null);

    self.tbXNCLKhongdat = ko.observable(new TBXNCLKhongDatVM());

    self.tbKhongcapCNKD = ko.observable(new TBKhongcapCNKDVM());

    self.xem = ko.observable(null);

    self.xemDanhsachGCN = ko.observable(new XemDanhSachGCNVM());

    self.Items = ko.observableArray([]);

    self.totalCount = ko.observable(0);

    mapTrangthai = params.mapTrangthai;
    mapQuocgia = params.mapQuocgia;
    mapCuakhau = params.mapCuakhau;

    self.fiTrangthaiList = ko.observableArray(params.hasOwnProperty('lstTrangthai') ? params.lstTrangthai : []);

    self.pageSize = ko.observable(MAX_PAGE_SIZE);

    self.fiRegistrationConfirm = ko.observable(null);

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


    /**
     * Sửa hồ sơ
     * @param item
     * @param e
     */
    self.bSuaHoso = function(item, e) {
        window.location.href =  app.appContext + "/mard/09/edit/" + item.fiIdHS()
    };

    self.bXemHoso = function(item, e) {
        window.location.href =  app.appContext + "/mard/09/xem/" + item.fiIdHS()
    };

    self.bXinsua = function(item, e) {
        window.location.href =  app.appContext + "/mard/09/ycs/" + item.fiIdHS()
    };

    self.bXinrut = function(item) {
        self.xinRutHoSoVM(new XinRutHoSoVM(item));
        $('#modalXinRut').modal('show');
    };

    self.bXoaHoso = function(item) {
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/mard/09/hoso/delete',
                            data: JSON.stringify({
                                "fiNSWFileCode": item.fiHSCode()
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Xóa hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/09/';
                                } else {
                                    app.Alert(d.message)
                                }
                            },
                            error: function (e) {
                                app.Alert('Không xóa được hồ sơ');
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
            self.searchAfterHasCatgory(page, pushState);
            // app.getCategory('/mard/09/danhmuc', 'HS_TRANGTHAI', null, function (res) {
            //     if (res.success) {
            //         RAW_HS_STATUS = res.data;
            //         // self.fiTrangthaiList(mapCategory(RAW_HS_STATUS));
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
            fiKDStatus: self.trangThaiKD(),
            fiGSStatus: self.trangThaiGS(),
            fiHSCode: self.maHoSo(),
            licenseNo: self.soCongVan(),
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
            url: "/mard/09/hoso/find",
            data: JSON.stringify(data),
            success: function (res) {
                window.stateChanging = false;
                if (res.success) {
                    self.Items([]);
                    res.data.data.forEach(function (item) {
                        item.lstSeller.forEach(function (value) {
                            value.fiSellerStateName = mapQuocgia[value.fiSellerStateCode];
                        });

                        item.fiImportCountryName = mapQuocgia[item.fiImportCountryCode];

                        if (item.fiBuyer) {
                            item.fiBuyer.fiPortOfDestinationName = item.fiBuyer.fiPortOfDestinationName;
                        }


                        item.fiLinkFile = "/mard/09/hoso/download/03/" + item.fiIdHS;

                        item.isShowApphi = item.fiPaymentStatus != -1 && item.fiPaymentStatus != null;
                        item.isShowHS = [3, 7, 8, 9, 11, 13, 14, 15, 16, 17, 18, 19, 20].includes(item.fiGSStatus) || [3, 7, 8, 9, 11, 13, 14, 15, 16, 17, 18, 19, 20].includes(item.fiKDStatus)
                        item.isShowGVC = (item.fiKDStatus == 15 || item.fiGSStatus == 15);
                        item.isShowCNKD = item.fiGSStatus == 16;
                        item.isShowXNCL = [19].includes(item.fiGSStatus);
                        item.isShowThongbaoKhongdat = false;
                        item.isShowXemCongVan = item.fiHaveTransport || item.isShowGVC || item.isShowCNKD || item.isShowXNCL || [20, 18].includes(item.fiGSStatus);
                        item.isShowXemTB = item.fiFailXncl === 1;

                        item.isShowXinsua = [3, 9, 10, 12, 13, 14].includes(item.fiGSStatus) || [3, 9, 10, 12, 13, 14].includes(item.fiKDStatus);

                        item.isShowKhongcapCNKD = item.fiFailCnkd === 1;

                        item.isShowXND = item.fiRegistrationComfirmNo != null;

                        item.isShowXinrut = [1, 3, 7, 9, 10, 12, 13, 14].includes(item.fiGSStatus) || [1, 3, 7, 9, 10, 12, 13, 14].includes(item.fiKDStatus);
                        // item.isShowXinrut = true;
                        item.isShowSua = [0, 1, 7].includes(item.fiGSStatus) || [0, 1, 7].includes(item.fiKDStatus);
                        item.isShowRut = [1, 6, 7].includes(item.fiGSStatus) || [1, 6, 7].includes(item.fiKDStatus);
                        item.isShowXoa = [0].includes(item.fiGSStatus) || [0].includes(item.fiKDStatus);

                        item.fiKDStatus = mapTrangthai[item.fiKDStatus ? item.fiKDStatus.toString() : "0"];
                        item.fiGSStatus = mapTrangthai[item.fiGSStatus ? item.fiGSStatus.toString() : "0"];

                        if (item.fiMonitoringLocTime === 0) {
                            item.fiMonitoringLocTime = null;
                        }
                    });

                    var list = res.data ? mapTbdhoso09(res.data.data, (data.page - 1) * data.size) : [];

                    self.Items(list);
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

    self.bXemTbKhongcap = function (item) {
        self.tbXNCLKhongdat().showThongbao(item)
    };

    self.bXemTbKhongcapCNKD = function(item) {
        self.tbKhongcapCNKD().showThongbao(item)
    };


    self.bXemThongbaoApphi = function(item, e) {
        $("#loading10").show();

        app.makeGet({
            url: "/mard/09/apphi?fiHSCode=" + item.fiHSCode(),
            success: function (d) {
                self.thongbaoApphi(new ThongBaoApPhiVM(d.data, item.fiHSCode()));
                $("#loading10").hide();
                $("#modal_thongbaoApphi").modal('toggle');

            },
            error: function (e) {
                $("#loading10").hide();
            }
        });

        return false;
    };

    /**
     * Xem hồ sơ
     */
    self.bXemHoSo = function(item, e){
        item.fiKinhGui = ko.observable(params.tramThuY[item.fiQuarantineDepartmentCode()]);
        item.fiExportCountryName = ko.observable(params.mapQuocgia[item.fiExportCountryCode()]);

        var productType = item.fiProductType();

        if (productType === 1) {
            self.xemHoSo03DV(new XemHoSo03DV(item));
            $("#modal_XemHoso03DV").modal('toggle');
        }

        if (productType === 2 || productType === 3) {
            self.xemHoSo03SPDV(new XemHoSo03SPDV(item));
            $("#modal_XemHoso03SPDV").modal('toggle');
        }

        if (productType === 4) {
            self.xemHoSo20DV(new XemHoSo20DV(item));
            $("#modal_XemHoso20DV").modal('toggle');
        }

        if (productType === 5) {
            self.xemHoSo20SPDV(new XemHoSo20SPDV(item));
            $("#modal_XemHoso20SPDV").modal('toggle');
        }
    };

    /**
     * Chuyển trang tạo mới hồ sơ
     * @param {type} e
     * @returns {Boolean}
     */
    self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mard/' + self.fiThuTucId() + '/edit?maThuTuc=' + self.loaiHoSo();
        return false;
    };

    /**
     * Xem danh sách giấy phép
     * @param e
     */

    self.btnXemGiayphepClick = function  (item, e) {
        self.xemDanhsachGCN(new XemDanhSachGCNVM(
            item.lstQualityCer,
            item.lstAnimalQuarantineCer,
            item.lstAnimalTransportDoc,
            item.fiQualityRejectCer,
            item.isShowGVC,
            item.isShowCNKD,
            item.isShowXNCL,
            item.isShowThongbaoKhongdat,
            item.fiHSCode(),
            item.fiIdHS(),
            item.fiProductType()
        ));
    };

    self.bXemXacnhanDon = function(item) {
        $("#loading10").show();
        app.makeGet({
            url: "/mard/09/hoso/xnd?id=" + item.fiHSCode(),
            success: function (d) {
                $("#loading10").hide();

                self.fiRegistrationConfirm(new RegistrationConfirm(d.data, item));
                $("#modal_xemXacnhandon").modal('toggle');
            },
            error: function (e) {
                $("#loading10").hide();
            }
        });
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
        document.location = app.appContext + '/mard/' + self.fiThuTucId() + '/view?fiIdHoso=' + item.fiIdHoso() + '&maThuTuc=' + self.loaiHoSo();
        return false;
    };
    /**
     * Xem Thông báo
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemThongBaoClick = function (item, e) {
        document.location = app.appContext + '/mard/' + self.fiThuTucId() + '/view?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert&maThuTuc=' + self.loaiHoSo();
        return false;
    };

    /**
     * Xem Lich su
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemLichSuClick = function (item, e) {
        self.lichsuXuly().show(item.fiHSCode());
        return false;
    };
    /**
     * Sửa hồ sơ
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bSuaClick = function (item, e) {
        document.location = app.appContext + '/mard/' + self.fiThuTucId() + '/edit?fiIdHoso=' + item.fiIdHoso() + '&maThuTuc=' + self.loaiHoSo();
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
                            url: '/mard/12/hoso/xoa/' + item.fiIdHoso(),
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

    self.createPopFiTrangThai = function (template, item) {
        var html = [
            $('#' + template).html()
        ].join('');
        self.pop = app.popup({
            title: item.fiTenTt(),
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
            case DUOC_CAP_GIAYPHEP:
                document.location = app.appContext + '/mard/' + self.fiThuTucId() + '/view?fiIdHoso=' + item.fiIdHoso() + '&fiMaHoso=' + item.fiMaHoso() + '&tab=cert&maThuTuc=' + self.loaiHoSo();
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
     * Gửi yêu cầu xử lý nghiệp vụ
     * @param {type} message
     * @param {type} message
     * @returns {undefined}
     */
    self.guiYcXuly = function (message) {
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/' + self.fiThuTucId() + '/hoso/xuly',
            data: JSON.stringify(message),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if (res && res.success) {
                    alert('Đã gửi yêu cầu thành công');
                    self.search(self.paging().currentPage() - 1);
                } else {
                    alert(res.message);
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
    /**
     * Lay ket qua xu ly ho so
     * @param {type} message
     * @returns {undefined}
     */
    self.kqxlHoSo = function (message, cb) {
        app.makePost({
            url: '/mard/12/hoso/kqxl',
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
    $.when(
        app.sendGetRequest("/mard/09/dvxl", function (data) {
        var lstTramThuY = {};

        var lstChildPU = data.data[0].lstChildPU;

        lstChildPU.forEach(function(itemChicuc) {
            lstTramThuY[itemChicuc.fiPUCode] = itemChicuc.fiPUDesc
            itemChicuc.lstChildPU.forEach(function (itemTram) {
                lstTramThuY[itemTram.fiPUCode] = itemTram.fiPUDesc
            })
        });
        d.tramThuY = lstTramThuY;
    }), app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
        d.lstUOMWeight = res.data;
        d.lstUOMWeight.forEach(function (value) {
            mapDonviTinh[value.portcode] = value.portname
        });
    }), app.sendGetRequest("/mard/08/danhmuc/quocgia", function (res) {
        d.lstQuocgia = res.data;
        var mapQuocgia = {};
        d.lstQuocgia.forEach(function (item) {
            mapQuocgia[item.countrycode] = item.countryname
        });
        d.mapQuocgia = mapQuocgia;
    }), app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (res) {
        d.lstCuakhau = res.data;
        var mapCuakhau = {};
        d.lstCuakhau.forEach(function (value) {
            mapCuakhau[value.portcode] = value.portname
        });
        d.mapCuakhau = mapCuakhau;
    }), app.sendGetRequest("/mard/08/danhmuc/statusHoso?systemId=9", function (res) {
        d.lstTrangthai = res.data;
        var mapTrangthai = {};
        d.lstTrangthai.forEach(function (item) {
            mapTrangthai[item.id.toString()] = item.name
        });
        d.mapTrangthai = mapTrangthai;
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
    }
});

