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
}
function init(data) {
    var index26VM = new IndexVM(data);
    ko.applyBindings(index26VM, document.getElementById('index26Page'));
    // index26VM.applyState(options);
    index26VM.searchHoso(1);
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