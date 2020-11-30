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
    cssxSelf.selectedProcessors = ko.observable(null);
    cssxSelf.errors=ko.validation.group(cssxSelf);
    cssxSelf.newProcessors = ko.observable(null);
    cssxSelf.cssxItems = ko.observableArray([]);
    cssxSelf.macssx = ko.observable(null);
    cssxSelf.tencssx = ko.observable(null);

    cssxSelf.fiMaCSSX =ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    cssxSelf.fiIdCSSX =ko.observable(null);
    cssxSelf.fiTenCSSX =ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    cssxSelf.fiDiaChiCSSX =ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    cssxSelf.fiTenCSSXEn =ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    cssxSelf.fiDiaChiCSSXEn =ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    cssxSelf.validate = function () {
        if (cssxSelf.errors().length > 0) {
            cssxSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }
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

    cssxSelf.searchCSSXClick =function(){
        cssxSelf.searchCSSX(0, true);
    }

    cssxSelf.btnAddNewClick =function(){
        cssxSelf.fiIdCSSX(null);
        cssxSelf.fiMaCSSX('');
        cssxSelf.fiTenCSSX('');
        cssxSelf.fiDiaChiCSSX('');
        cssxSelf.fiTenCSSXEn('');
        cssxSelf.fiDiaChiCSSXEn('');
        $("#modal_cssx").modal("show");
    }
    cssxSelf.closePopupCssx=function(){
        cssxSelf.fiIdCSSX(null);
        cssxSelf.fiMaCSSX('');
        cssxSelf.fiTenCSSX('');
        cssxSelf.fiDiaChiCSSX('');
        cssxSelf.fiTenCSSXEn('');
        cssxSelf.fiDiaChiCSSXEn('');
        $("#modal_cssx").modal("hide");
    }
    cssxSelf.updateCssx =function(){
        var getAllForm = [cssxSelf.fiMaCSSX, cssxSelf.fiTenCSSXEn,cssxSelf.fiTenCSSX,cssxSelf.fiDiaChiCSSXEn,cssxSelf.fiDiaChiCSSX];
        cssxSelf.errors = ko.validation.group(getAllForm, {deep: true, live: true, observable: true});
        if (!cssxSelf.validate()) return;
        var data={
            seafoodprocessorsid: cssxSelf.fiIdCSSX(),
            seafoodprocessorscode: cssxSelf.fiMaCSSX(),
            seafoodprocessorsname: cssxSelf.fiTenCSSX(),
            seafoodprocessorsadress: cssxSelf.fiDiaChiCSSX(),
            commercialnameofestablishments: cssxSelf.fiTenCSSXEn(),
            seafoodprocessorsadressen: cssxSelf.fiDiaChiCSSXEn()
        };
        if(!data) {return;}
        cssxSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu cơ sở sản xuất?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(cssxSelf.pop.selector);
                        app.makePost({
                            url: '/mard/cssx/update',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu cơ sở sản xuất thành công');
                                    window.location.href = app.appContext + '/mard/cssx/home';
                                    // cssxSelf.searchCSSXClick();
                                    $("#modal_cssx").modal("hide");
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không lưu được cơ sở sản xuất');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(cssxSelf.pop.selector);
                    }
                }
            ]
        });
    }
    // self.page = ko.observable(DEFAULT_PAGE_NUM);
    cssxSelf.searchCSSX = function(page) {
        var filter ={
            macssx: cssxSelf.macssx(),
            tencssx: cssxSelf.tencssx(),
            page: page,
            size: MAX_PAGE_SIZE,
            sortBy:cssxSelf.sortBy(),
            order: cssxSelf.order()
        }
        $('#loading08').show();
        app.makePost({
            crossDomain: true,
            url: app.appContext + '/mard/danhmuc/cssx',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(filter),
            success: function (res) {
                if (res.success) {
                    cssxSelf.cssxItems(res.data.data);
                    cssxSelf.pagination().update({
                        totalCount: res.data.total,
                        pageSize: res.data.size,
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
        cssxSelf.fiMaCSSX(item.seafoodprocessorscode);
        cssxSelf.fiTenCSSX(item.seafoodprocessorsname);
        cssxSelf.fiDiaChiCSSX(item.seafoodprocessorsadress);
        cssxSelf.fiTenCSSXEn(item.commercialnameofestablishments);
        cssxSelf.fiDiaChiCSSXEn(item.seafoodprocessorsadressen);
        cssxSelf.fiIdCSSX(item.seafoodprocessorsid);
        $("#modal_cssx").modal("show");
    }
    cssxSelf.deleteProcessors =function(item){
        cssxSelf.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá cơ sở sản xuất?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(cssxSelf.pop.selector);
                        app.makePost({
                            url: '/mard/cssx/delete',
                            data: JSON.stringify(item),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Xoá cơ sở sản xuất thành công');
                                    cssxSelf.searchCSSXClick();
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không xoá được cơ sở sản xuất');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(cssxSelf.pop.selector);
                    }
                }
            ]
        });
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