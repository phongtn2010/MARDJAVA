function ThongBaoPhiView() {
    var self = this;

    self.show = function(item) {
        var callback = function (html) {
            var pop = app.popup({
                title: NSWLang["mard.19.index.table.thongBaoPhi"] + ' - ' + item.fiDocumentName(),
                html: html,
                width: 1200,
                backdrop: true,
                buttons: [
                    {
                        name: NSWLang["common_button_dong"],
                        class: 'btn',
                        icon: 'fa-remove',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            }, function () {
                var mHistoryPopupView = new XemThongBaoPhiPopupView(item);
                ko.applyBindings(mHistoryPopupView, document.getElementById("pageView"));
            });
        };

        app.complieTemplate({
            ministryCode: "mard",
            code: "19",
            templateName: "thong_bao_thu_phi",
            data: null
        }, callback);
    }
}

function XemThongBaoPhiPopupView(item) {
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
    $(".date-picker").datepicker({
        altFormat: "dd/mm/yy"
    });

    var self = this;
    self.tbdThanhToan19 = new TbdThanhToan19();
    self.tbdThanhToan19.fiIdHoSo(item.fiIdHoSo());
    self.danhSachThanhToanPhi = ko.observableArray([]);
    self.danhSachThongBaoPhi = ko.observableArray([]);
    self.soLuongTien = ko.observable('');
    self.isSaving = ko.observable(true);
    self.showButtonSend = ko.observable(item.fiStatus() == 15 || item.fiStatus() == 20 ? true : false);

    $.getJSON(app.appContext + '/mard/19/tbdThongBaoPhi19/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
        if (d.readyState == 4) {
            return;
        }
        readArrayObjects(d, function (loopItem) {
            self.danhSachThongBaoPhi.push(loopItem);
        });
    });

    $.getJSON(app.appContext + '/mard/19/tbdThanhToan19/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
        if (d.readyState == 4) {
            return;
        }
        readArrayObjects(d, function (loopItem) {
            self.danhSachThanhToanPhi.push(convertObjectToKnockout(loopItem, new TbdThanhToan19()));
        });
    });
    self.save = function() {
        self.tbdThanhToan19.fiIdHoSo(item.fiIdHoSo());
        if (self.tbdThanhToan19.valid.errors().length > 0) {
            showError(self.tbdThanhToan19);
            self.tbdThanhToan19.valid.errors.showAllMessages();
            return;
        }
       self.isSaving(false);
        var url = '/mard/19/tbdThanhToan19/create';
        if (self.tbdThanhToan19.fiId() > 0) {
            url = '/mard/19/tbdThanhToan19/update/' + self.tbdThanhToan19.fiId();
        }
        self.callConfirm(function () {
            app.makePost({
                url: url,
                data: ko.toJSON(convertKnockoutToObject(self.tbdThanhToan19, createObject(self.tbdThanhToan19))),
                error: function (e) {
                    if (e.readyState == 4) {
                        return;
                    }
                    if (self.tbdThanhToan19.fiId() <= 0) {
                        self.danhSachThanhToanPhi.push(convertObjectToKnockout(e, new TbdThanhToan19()));
                        self.danhSachThanhToanPhi.reverse();
                    } else {
                        var findItem = ko.utils.arrayFilter(self.danhSachThanhToanPhi(), function(prod) {
                            return prod.fiId() == self.tbdThanhToan19.fiId();
                        });
                        if (findItem[0]) {
                            convertObjectToKnockout(e, findItem[0]);
                        }
                    }

                    clearDataKnockout(self.tbdThanhToan19);
                    self.tbdThanhToan19.valid.errors.showAllMessages(false);
                    self.soLuongTien('');
                    self.isSaving(true);
                }
            });
        }, NSWLang["mard.16.confirmSave"]);

    }

    self.callConfirm = function(affter, message) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + message,
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        if (affter) {
                            affter();
                        }
                    }
                }
            ]
        });
    }

    self.edit = function(item){
        cloneKnockoutObject(item, self.tbdThanhToan19);
    }

    self.delete = function(item) {
        self.callConfirm(function () {
            $.getJSON(app.appContext + '/mard/19/tbdThanhToan19/delete/'+ item.fiId(), function (d) {
                if (d.readyState == 4) {
                    showToast(NSWLang["mard.19.action.error"], false);
                    return;
                }
                showToast(NSWLang["mard.19.action.success"], true);
                self.danhSachThanhToanPhi.remove(item);
            });
        }, NSWLang["common_msg_xoa_ho_so"]);

    }

    self.send = function(item) {

        self.callConfirm(function () {
            app.makePost({
                url: '/mard/api/19/send',
                data: JSON.stringify({
                    fiReason: null,
                    fiXml: null,
                    fiIdHoSo: item.fiIdHoSo(),
                    fiAction: 4
                }),
                success: function (d) {
                    self.thongBao(NSWLang["mard.19.action.success"] , true);
                    item.fiSended(1);
                    setTimeout(function () {
                        location.reload();
                    }, 1000);
                },
                error: function (e) {
                    self.thongBao(NSWLang["mard.19.action.error"], false);
                }
            });
        }, NSWLang["mard.16.confirmSave"]);


    }
    self.thongBao = function( message, success) {
        var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
        var icon = 'fa fa-check';
        if (!success) {
            cls = 'class="alert alert-danger" style="color: #000;background: red;"';
            icon = 'fa fa-send-o';
        }
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<div '+ cls +' ><i class="'+ icon +'" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>'+ message +'</b></div>',
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_dong"],
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(pop.selector);
                        setTimeout(function () {
                            location.reload();
                        }, 500);
                    }
                }
            ]
        }, function(){
            $('button[class="close"]').click(function(){
                app.popupRemove(pop.selector);
                setTimeout(function () {
                    location.reload();
                }, 500);
            });
        });
    }

    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
    self.uploadFileChangeEvent = function(elemet, event) {
        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fiFileName').val('');
                app.Alert( NSWLang["mard.19.uploadInfo3"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 3;// 3MB
        if (files[0].size > totalMB) {
            $('#fiFileName').val('');
            app.Alert( NSWLang["mard.19.uploadInfo3"]);
            return false;
        }
        for (var k = 0; k < files.length; k++) {
            var param = {};
            param.mcode = "mard";
            param.pcode = "19";
            param.file = files[k];
            app.uploadFile({
                url: '/mard/api/19/uploadFile',
                data: param,
                success: function (d) {
                    if (d.success) {
                        self.tbdThanhToan19.fiUuid(d.data.fiUuid);
                        self.tbdThanhToan19.fiPath(d.data.fiPath);
                        self.tbdThanhToan19.fiFileName(d.data.fiFileName);
                        self.tbdThanhToan19.fiFileCode(d.data.fiFileCode);
                        self.tbdThanhToan19.fiLink(app.appContext +  '/mard/api/19/getfile/' + param.mcode  + '/' + param.pcode + '/' + d.data.fiFileCode);
                    }
                    $('#fiFileName').val('');
                },
                error: function (e) {
                    $('#fiFileName').val('');
                    toastr.error(NSWLang["common_msg_thong_bao"], e.message);
                }
            });

        }

    }

    self.formatCurrency = function(value) {
        var text =  value.toFixed(1).replace(/(\d)(?=(\d{3})+\.)/g, "$1.");
        text = text.substring(0, text.length - 2);
        return text;
    }

    self.numberInputKeyPressEvent = function(event) {

        var x = event.which || event.keyCode;
        var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
        if ($.inArray(x, keys) === -1) {
            return false;
        }

        return true;
    }

    self.numberInputKeyUpEvent = function(event) {
        var value = self.tbdThanhToan19.fiTotalFee().replace(/\./g, '');
        if (value) {
            var so = self.tbdThanhToan19.fiTotalFee();
            self.tbdThanhToan19.fiTotalFeeChar(docso(so));
        }

        return true;
    }

}
