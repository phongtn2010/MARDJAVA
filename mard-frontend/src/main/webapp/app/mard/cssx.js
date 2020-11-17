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
var DEFAULT_PAGE_NUM = 1;

function CSSXVM(options) {

    var cssxSelf = this;

    cssxSelf.cssxItems = ko.observableArray([]);
    cssxSelf.macssx = ko.observable(null);
    cssxSelf.tencssx = ko.observable(null);


    cssxSelf.size = ko.observable(MAX_PAGE_SIZE);
    cssxSelf.pagination = ko.observable(new PagingVM({
        pageSize: MAX_PAGE_SIZE,
        totalCount: 0,
        currentPage: 1
    }));
    cssxSelf.sortBy = ko.observable("seafoodprocessorscode");
    cssxSelf.order = ko.observable("asc");
    cssxSelf.currentPage = ko.observable(1);
    cssxSelf.pagination().currentPage.subscribe(function (newCurrentPage) {
        cssxSelf.currentPage(newCurrentPage);
        cssxSelf.searchCSSX(newCurrentPage);
    });



    // self.page = ko.observable(DEFAULT_PAGE_NUM);
    cssxSelf.searchCSSX = function(page) {
        $('#loading08').show();
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/cssx/find/',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (res) {
                if (res.success) {
                    cssxSelf.cssxItems(res.data);
                    cssxSelf.pagination().update({
                        totalCount: res.data.length,
                        pageSize: MAX_PAGE_SIZE,
                        currentPage: page
                    });
                }
                $('#loading08').hide();
            },
            error: function (x, t, m) {
                $('#loading08').hide();
            },
        })
    }

    cssxSelf.updateProcessors = function (item) {
        console.log(item);
    }
    cssxSelf.applyState = function () {
        $.when(
        ).done(function (data) {
            cssxSelf.searchCSSX(1);
        })
    }
}
function init(data) {
    var cssxvm = new CSSXVM(data);
    ko.applyBindings(cssxvm, document.getElementById('cssxHome'));
    cssxvm.applyState();
    // index26VM.applyState(options);
}

$(document).ready(function () {
    var options = {};
    init(options);
});