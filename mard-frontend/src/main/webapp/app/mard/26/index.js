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
    index26Self.totalCount = ko.observable(0);
    index26Self.pageSize = ko.observable(MAX_PAGE_SIZE);
    index26Self.paging = ko.observable(new PagingVM({
        pageSize: index26Self.pageSize(),
        totalCount: 0
    }));

    index26Self.searchFieldEnter = function(){

    }
    index26Self.searchHoSoClick = function () {
        index26Self.search(0, true);
    };
    index26Self.btnAddNewClick = function (e) {
        document.location = app.appContext + '/mard/26/edit';
        return false;
    };
}
function init(data) {
    var index26VM = new IndexVM(data);
    ko.applyBindings(index26VM, document.getElementById('index26Page'));
    // index26VM.applyState(options);
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