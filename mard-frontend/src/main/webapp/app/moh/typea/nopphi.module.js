/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

nopPhiController = function () {};
nopPhiController.prototype = {
    ministryCode: 'moh',
    code: 'typea',
    templates: ['thongtinthanhtoan'],
    isView: null,
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10
    },
    container: null,
    pager: null,
    dialog: null,
    list: [],
    taptin: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.registerEvents();
        this.dialog = op.dialog;
        this.container = '#' + op.container;
        this.pager = '#' + op.pager;
        this.isView = op.isView;
        if (op.data != null && op.data.length > 0) {
            this.list = op.data;
        } else {
            this.list = [];
        }
        if (op.isView === "none") {
            $("#form-np input").attr("readonly", "readonly");
            $("#form-np textarea").attr("readonly", "readonly");
            $(".themNopPhi").hide();
        }
        this.bindGrid();
    },
    registerEvents: function () {
        var self = this;
        $("#buttonNopphi").off('click').on('click', function () {
            var loaiTapTin = "12";
            var tenTapTin = filterXSS(NSWLang["moh_06_xac_nhan_nop_phi"]);
            var frameId = "frame3";
            var upload = {frameId: frameId, maTaiLieu: loaiTapTin, tenTaiLieu: tenTapTin};
            app.makePost({
                url: "/moh/01/key",
                data: JSON.stringify(upload),
                error: function (data) {
                    if (data != null && data.length > 0) {
                        value = data;
                        var url = self.dialog;
                        $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                        $("#dialog").dialog({modal: true, width: 640, height: 300, dialogClass: 'plDiaglog'});
                    }
                },
                success: function (data) {
                    value = data;
                    var url = self.dialog;
                    $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                    $("#dialog").dialog({modal: true, width: 640, height: 300});
                }
            });
            self.uploadInfor = upload;
        });
        $("#themNopPhi").off('click').on('click', function () {
            if (app.isFormVaild('form-np') && self.isValid()) {
                var thanhToan = app.form2Object("#form-np");
                thanhToan.dinhKem = self.taptin;
                $("#form-np input").not('.fiLoaiphi').val("");
                $("#fileIdLabelframe3").html("");
                self.list.push(thanhToan);
                self.bindGrid();
                self.taptin = null;

            }
        })
    },
    isValid: function () {
        if (this.taptin == null) {
            app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            return false;
        }
        return true;
    },
    getObject: function () {
        var nopphi = app.form2Object("#form-np");
        return nopphi;
    },
    bindGrid: function () {
        var self = this;
        var cb = function (html) {
            $(self.container).html(html);
            //self.bindEventsGrid();
            $(self.container).find('.tooltips').tooltip();
            var rows = $("#nopphi-container").find("tr");
            $.each(rows, function (index, data) {
                var loaiPhi = $(data).find("td").eq(1).html();
                if (loaiPhi == 1) {
                    $(data).find("td").eq(1).html(NSWLang["moh_06_xac_nhan_nop_phi_nop_moi"]);
                } else {
                    $(data).find("td").eq(1).html(NSWLang["moh_06_xac_nhan_nop_phi_nop_bo_xung"]);
                }
                $(".fa-trash").css("display", self.isView);
            });
        };
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: {
                data: self.list,
                isView: self.isView
            }
        }, cb);
        this.bindGridEvent();
    },
    bindGridEvent: function () {
        var self = this;
        $("#nopphi-container .fa-trash").on('click', function () {
            var fileId = $(this).attr('fileId');
            var index = $(this).attr("doc");
            var me = $(this);
            var pop = app.popup({
                title: NSWLang["common_button_thong_bao"],
                html: '<b>' + NSWLang["common_msg_xoa_ho_so"] + '</b>',
                width: 400,
                height: 100,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            $(".modal-header button").click();
                            app.makePost({
                                url: "/moh/01/deleteFile/" + fileId,
                                success: function (xhr) {
                                },
                                error: function (d) {
                                    me.parents("tr").remove();
                                    self.list.splice(parseInt(index) - 1, 1);
                                }
                            });
                        }
                    }
                ]
            });
        });
    },
    showPaymentInfo: function (info) {
        $("#ttthanhtoan").html("");
        $("#ttthanhtoan").append(info);
    }
};
