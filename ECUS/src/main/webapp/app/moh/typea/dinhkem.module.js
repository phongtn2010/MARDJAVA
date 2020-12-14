/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


dinhKemController = function () {};
dinhKemController.prototype = {
    ministryCode: 'moh',
    code: 'typea',
    templates: ['dinhkem'],
    isView: null,
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10
    },
    container: null,
    dialog: null,
    list: [],
    uploadInfor: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.registerEvents();
        this.container = '#' + op.container;
        this.dialog = op.dialog;
        this.isView = op.isView;
        if (obj.data != null) {
            var bh = [];
            obj.data.forEach(function (item) {
                bh.push(item);
            });
            this.list = bh;
        } else {
            this.list = [];
        }
        this.bindList();
    },
    registerEvents: function () {
        var self = this;
        $("#upload").off('click').on('click', function () {
            var loaiTapTin = $("select#fiLoai").val();
            var tenTapTin = filterXSS($("#fiLoai option[value=" + loaiTapTin + "]").html());
            var frameId = "frame1";
            var upload = {frameId: frameId, maTaiLieu: loaiTapTin, tenTaiLieu: tenTapTin};
            app.makePost({
                url: "/moh/01/key",
                data: JSON.stringify(upload),
                success: function (data) {
                    value = data;
                    var url = self.dialog;
                    $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                    $("#dialog").dialog({modal: true, width: 640, height: 300});
                },
                error: function (data) {
                    if (data != null && data.length > 0) {
                        value = data;
                        var url = self.dialog;
                        $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                        $("#dialog").dialog({modal: true, width: 640, height: 300});
                    }
                }
            });
            self.uploadInfor = upload;
        });

        $("#btnThem").off('click').on('click', function () {
            $("#uploadButton #fileIdLabelframe1").html("");
            if (self.uploadInfor != null) {
                self.list.push(self.uploadInfor);
                self.bindGrid();
                self.uploadInfor = null;
            } else {
                app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            }
        });
        $(".upload").off('click').on('click', function () {
            var loaiTapTin = $(this).attr("data-type");
            var tenTapTin = filterXSS($(".nsw-text-underline[data-type=" + loaiTapTin + "]").html());
            var frameId = "frame1";
            var upload = {frameId: frameId, maTaiLieu: loaiTapTin, tenTaiLieu: tenTapTin};
            app.makePost({
                url: "/moh/01/key",
                data: JSON.stringify(upload),
                success: function (data) {
                    value = data;
                    var url = self.dialog;
                    $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                    $("#dialog").dialog({modal: true, width: 640, height: 300});
                },
                error: function (data) {
                    if (data != null && data.length > 0) {
                        value = data;
                        var url = self.dialog;
                        $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                        $("#dialog").dialog({modal: true, width: 640, height: 300});
                    }
                }
            });
            self.uploadInfor = upload;
        });
    },
    bindGrid: function () {
        var self = this;
        var cb = function (html) {
            $(self.container).html(html);
            $(self.container).find('.tooltips').tooltip();
            $(".fa-remove").css("display", self.isView);
        };
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: self.list
        }, cb);
        this.bindGridEvents();
    },
    bindList: function () {
        var self = this;
        $(".dinhkem").html("");
        for (var i = 0; i < self.list.length; i++) {
            var index = i + 1;
            var table = $(".dinhkem[data-type=" + self.list[i].fiLoai + "]");
            var rowNum = parseInt(table.find("tr").length);
            var row = $(document.createElement("tr"));
            row.append("<td>" + (rowNum + 1) + "</td>");
            row.append("<td>" + filterXSS(self.list[i].fiTentaptin) + "</td>");
            row.append("<td>" + filterXSS(self.list[i].fiTenloai) + "</td>");
            row.append("<td><a href=" + self.list[i].fiUrltaptin + "><i class='fa fa-lg fa-download'></i></a></td>");
            if (self.isView !== "none")
                row.append("<td><a><i class='fa fa-lg fa-remove' fileId=" + self.list[i].fiMataptin + " doc=" + index + "></i></a></td>");
            table.append(row);
        }
        this.bindGridEvents();
    },
    bindGridEvents: function () {
        var self = this;

        $(".dinhkem .fa-remove,#listDinhKem .fa-remove").off('click').on('click', function () {
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
//                            app.makePost({
//                                url: "/moh/01/deleteFile/" + fileId,
//                                success: function (xhr) {
//
//                                },
//                                error: function (xhr) {
//                                    if (xhr == true) {
//                                        me.parents("tr").remove();
//                                        self.list.splice(parseInt(index) - 1, 1);
//                                    } else {
//                                    }
//                                }
//                            });
                            self.list.splice(parseInt(index) - 1, 1);

                            self.bindList();
                            $(".modal-header button").click();
                        }
                    }
                ]
            });
        });
    },
    isVaild: function (send) {
        if (this.list === null || (this.list !== null && this.list.length === 0)) {
            app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            return false;
        }
        if (send) {

            var isValid = true;
            var sample = [1, 2, 3, 4, 5, 6, 7, 8];
            var loai = [];
            var l = this.list.length;
            for (i = 0; i < l; i++) {
                loai.push(this.list[i].fiLoai);
            }
            loai.sort(function (a, b) {
                return a - b
            });
//            for(i=0;i<loai.length-1;i++){
//                if(loai[i] == loai[i+1]){
//                    isValid = false;
//                    app.Alert(NSWLang['moh_06_tepdinhkem_thongbao_trunglap']);
//                    return false;
//                }
//            }
            for (i = 0; i < sample.length; i++) {
                if (loai.indexOf(sample[i].toString()) < 0) {
                    isValid = false;
                    break;
                }
            }
            if (this.list !== null && (this.list.length < 8 || !isValid)) {
                app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["moh_06_tepdinhkem_thongbao_thieu"]);
                return false;
            }
        }
        return true;
    },
    save: function () {
        var self = this;
        $("#uploadButton #fileIdLabelframe1").html("");
        if (self.uploadInfor != null) {
            self.list.push(self.uploadInfor);
            self.bindList();
            self.uploadInfor = null;
        } else {
            app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["common_msg_chua_nhap"]);
        }
    }
}
