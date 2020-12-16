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

}

function KetQuaXLVM(options) {

}

function IndexVM(data) {
    var index26Self = this;
    index26Self.fiTrangthaiList=ko.observableArray((data && data.hasOwnProperty('fiTrangthaiList')) ? data.fiTrangthaiList :[]);
    index26Self.trangThaiHoSo = ko.observable(null);
    index26Self.maHoSo = ko.observable(null);
    index26Self.loaiHoSo = ko.observable(null);
    index26Self.soCongVan = ko.observable(null);
    index26Self.ngayTaoTuNgay = ko.observable(null);
    index26Self.ngayTaoDenNgay = ko.observable(null);
    index26Self.ngayCapTuNgay = ko.observable(null);
    index26Self.ngayCapDenNgay = ko.observable(null);
    index26Self.selectedHoso = ko.observable(null);

    index26Self.maSoThue = ko.observable(null);

    index26Self.Items = ko.observableArray([]);
    index26Self.size = ko.observable(MAX_PAGE_SIZE);
    index26Self.searchFieldEnter = function(){

    };
    index26Self.sortBy = ko.observable("fiMaHoso");
    index26Self.order = ko.observable("desc");
    index26Self.pagination = ko.observable(new PagingVM({
        pageSize: MAX_PAGE_SIZE,
        totalCount: 0,
        currentPage: 1
    }));

    index26Self.currentPage = ko.observable(1);

    index26Self.pagination().currentPage.subscribe(function (newCurrentPage) {
        index26Self.currentPage(newCurrentPage);
        index26Self.searchHoso(newCurrentPage);
    })
    index26Self.searchHoSoClick = function () {
        index26Self.searchHoso(0, true);
    };
    index26Self.searchHoso = function (page) {
        var filter = {
            maHoSo: index26Self.maHoSo(),
            ngayTaoTuNgay: index26Self.ngayTaoTuNgay(),
            ngayTaoDenNgay: index26Self.ngayTaoDenNgay(),
            soCongVan: index26Self.soCongVan(),
            ngayCapTuNgay: index26Self.ngayCapTuNgay(),
            ngayCapDenNgay: index26Self.ngayCapDenNgay(),
            trangThaiHoSo:index26Self.trangThaiHoSo(),
            page: page,
            size: index26Self.size(),
            sortBy: index26Self.sortBy(),
            order: index26Self.order()
        }
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/26/hoso/timkiem",
            data: JSON.stringify(filter),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                if (res.success) {
                    console.log(res);
                    var list = res.data ? res.data.data : [];
                    index26Self.Items(list);
                    index26Self.pagination().update({
                        totalCount: res.data.total,
                        pageSize: MAX_PAGE_SIZE,
                        currentPage: page
                    })
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
                window.stateChanging = false;
            }
        });
    }
    index26Self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mard/26/create';
        return false;
    };
    index26Self.onEditHS = function (item) {
        console.log(item);
        document.location = app.appContext + '/mard/26/edit/'+item.fiIdHoSo26;
    }

    index26Self.getTrangThaiHS =function (id) {
        var lstProfileStatus = index26Self.fiTrangthaiList();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(id);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return id;
    }
    index26Self.goCopyHS = function (item) {
        document.location = app.appContext + '/mard/26/copy/'+item.fiIdHoSo26;
    }
    index26Self.getHinhThucCB=function(id){
        switch (Number(id)) {
            case 0:
                return "Không có";
            case 1:
                return "<";
            case 2:
                return ">";
            case 3:
                return "=";
            case 4:
                return "<=";
            case 5:
                return ">=";
            case 6:
                return "min-max";
        }
    }
    index26Self.goViewCert =function (item) {
        item.tenTACN=ko.observable(item.fiProductList[0].fiProName);
        item.maSCN=ko.observable(item.fiProductList[0].fiProCode);
        item.nhomTACN=ko.observable(item.fiProductList[0].fiProNameNhom);
        item.loaiTACN=ko.observable(item.fiProductList[0].fiProNameLoai);
        item.hangSX=ko.observable(item.fiProductList[0].fiProMadeIn);
        item.nuocSX=ko.observable(item.fiProductList[0].fiProCountryName);
        item.thanhPhan=ko.observable(item.fiProductList[0].fiProThanhPhan);
        item.dangMau=ko.observable(item.fiProductList[0].fiProColor);
        item.tieuchuan=ko.observable(item.fiProductList[0].fiProSoHieu);
        item.CLList=ko.observableArray(item.fiProductList[0].fiProCLList);
        item.ATList=ko.observableArray(item.fiProductList[0].fiProATList);

        index26Self.selectedHoso(item);
        $("#mard26ViewCert").modal("show");
    }
    index26Self.goDeleteHoso =function (item) {
        index26Self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hồ sơ ' + item.fiMaHoso + '?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(index26Self.pop.selector);
                        $.ajax({
                            async: true,
                            type: 'GET',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + "/mard/26/hoso/delete?fiIdHS=" + item.fiIdHoSo26 + "&fiTaxCode=" + hosoUsername,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading10').show();
                            },
                            success: function (res) {
                                $('#loading10').hide();
                                if (res.success) {
                                    app.Alert('Xóa hồ sơ thành công');
                                    index26Self.searchHoso(index26Self.currentPage());
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (err) {
                            },
                            complete: function (jqXHR, textStatus) {
                                $('#loading10').hide();
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
    index26Self.lichsuXuly = ko.observable(null);
    index26Self.goViewHistory=function(item){
        console.log(item);
        index26Self.lichsuXuly(new LichSu26VM(item));
        index26Self.lichsuXuly().searchLichSu();
    }
    
    index26Self.getTrangThai =function (id) {
        var lstProfileStatus = index26Self.fiTrangthaiList();
        console.log(index26Self.fiTrangthaiList());
        console.log(id);
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(id);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return id;
    }
}
function init(data) {
    var index26VM = new IndexVM(data);
    ko.applyBindings(index26VM, document.getElementById('index26Page'));
    // index26VM.applyState(options);
    index26VM.searchHoso(1);
}
function LichSu26VM(data){
    var self=this;
    self.fiIdHoSo26 =  ko.observable((data && data.hasOwnProperty('fiIdHoSo26')) ? data.fiIdHoSo26 :null);
    self.historyItems =ko.observableArray([]);
    self.fiMaHoso = ko.observable((data && data.hasOwnProperty('fiMaHoso')) ? data.fiMaHoso :null);
    var pageable = { size: 5, number: 0, sort: 'fiCreateDate', direction: 'desc'};
    self.historyPageingVM = new PagingVM({
        pageSize : pageable.size,
        totalCount : 0
    });
    self.historyItems(ko.utils.arrayMap([], function (item) {
        var itemVM = {};
        ko.mapping.fromJS(item, {}, itemVM);
        //    itemVM.fiStatus = ko.observable(mapTrangthai[item.fiStatus.toString()]);
        return itemVM;
    }));
    self.searchLichSu=function () {
        $("#loading10").show();
        pageable.number = self.historyPageingVM.currentPage() - 1;
        app.makeGet({
            url: '/mard/26/hoso/lichsu?fiIdHs=' + self.fiIdHoSo26() + '&p=' + pageable.number + '&s=5',
            success: function(res) {
                $("#loading10").hide();
                self.historyPageingVM.totalCount(res.total);
                self.historyItems(ko.utils.arrayMap(res.data, function (item) {
                    var itemVM = {};
                    ko.mapping.fromJS(item, {}, itemVM);
                    return itemVM;
                }));
                $("#modal_lichsuXuly").modal('toggle');
            },
            error: function (d) {
                $("#loading10").hide();
                self.pageContents.removeAll();
                readArrayObjects(d.content, function (loopItem) {
                    self.pageContents.push(loopItem);
                });
                self.historyPageingVM.totalCount(d.totalElements);
            }
        });
    }
    self.goToPage = function(page) {
        if (page >= self.historyPageingVM.firstPage && page <= self.historyPageingVM.lastPage()) {
            self.historyPageingVM.setCurrentPage(page);
            self.searchingAfterShow();
        }
    };

    self.goToFirst = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.firstPage);
        self.searchingAfterShow();
    };

    self.goToPrevious = function() {
        var previous = self.historyPageingVM.previousPage();
        if (previous != null) {
            self.historyPageingVM.setCurrentPage(previous);
            self.searchingAfterShow();
        }

    };

    self.goToNext = function() {
        var next = self.historyPageingVM.nextPage();
        if (next != null) {
            self.historyPageingVM.setCurrentPage(next);
            self.searchingAfterShow();
        }
    };

    self.goToLast = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.lastPage());
        self.searchingAfterShow();
    };
    self.searchingAfterShow = function() {
        pageable.number = self.historyPageingVM.currentPage() - 1;
        app.makeGet({
            url: '/mard/26/hoso/lichsu?fiIdHs=' + self.fiIdHoSo26() + '&p=' + pageable.number + '&s=5',
            success: function(res) {
                self.historyPageingVM.totalCount(res.total);
                self.historyItems(ko.utils.arrayMap(res.data, function (item) {
                    var itemVM = {};
                    ko.mapping.fromJS(item, {}, itemVM);
                    itemVM.fiHSStatus = ko.observable(mapTrangthai[item.fiHSStatus.toString()]);
                    return itemVM;
                }));

            },
            error: function (d) {
                $("#loading10").hide();
                self.pageContents.removeAll();
                readArrayObjects(d.content, function (loopItem) {
                    self.pageContents.push(loopItem);
                });
                self.historyPageingVM.totalCount(d.totalElements);
            }
        });
    }
}
$(document).ready(function () {
    var options = {};

    $.when(app.sendGetRequest('/mard/26/danhmuc/getby-catno/1',  function (res) {
        if (res.success) {
            options.fiTrangthaiList = res.data;
        }
    })).done(function (data) {
        init(options);
    });

});