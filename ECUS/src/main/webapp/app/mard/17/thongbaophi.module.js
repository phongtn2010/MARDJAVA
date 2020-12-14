var token;

const tokenUrl = "https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken";
function getToken() {
    var settings = {
        "url" : tokenUrl,
        "method" : "GET",
        "timeout" : 0,
    };

    $.ajax(settings).done(function(response) {

        token = response.data;
        
    });
}
function ThongBaoPhiView() {
    var self = this;
    self.show = function(item) {
        var callback = function (html) {
            var pop = app.popup({
                title: NSWLang["mard.17.index.table.thongBaoPhi"] + ' - ' + item.fiDocumentName(),
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
            code: "17",
            templateName: "thong_bao_thu_phi",
            data: null
        }, callback);
    }
}
setInterval(getToken, 300000);
function XemThongBaoPhiPopupView(item) {
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
    $(".date-picker").datepicker({
        altFormat: "dd/mm/yy"
    });
    getToken();

    var self = this;
    self.addTep = function (tep){
        var self = this;
        self.teps.push(tep);
    };

    self.removeTep = function (tep){
        var self = this;
        self.teps.remove(tep);
    };
    self.teps = ko.observableArray();
    self.tbdThanhToan17 = new TbdThanhToan17();
    self.tbdThanhToan17.fiIdHoSo(item.fiIdHoSo());
    self.danhSachThanhToanPhi = ko.observableArray([]);
    self.danhSachThongBaoPhi = ko.observableArray([]);
    self.soLuongTien = ko.observable('');
    self.isSaving = ko.observable(true);
    self.showButtonSend = ko.observable(item.fiStatus() == 15 || item.fiStatus() == 21 ? true : false);

    $.getJSON(app.appContext + '/mard/17/tbdThongBaoPhi17/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
        if (d.readyState == 4) {
            return;
        }
        readArrayObjects(d, function (loopItem) {
            self.danhSachThongBaoPhi.push(loopItem);
        });
    });

    $.getJSON(app.appContext + '/mard/17/tbdThanhToan17/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
        if (d.readyState == 4) {
            return;
        }
        readArrayObjects(d, function (loopItem) {
            self.danhSachThanhToanPhi.push(convertObjectToKnockout(loopItem, new TbdThanhToan17()));
        });
    });
    self.save = function() {
        self.tbdThanhToan17.fiIdHoSo(item.fiIdHoSo());
        if (self.tbdThanhToan17.valid.errors().length > 0) {
            showError(self.tbdThanhToan17);
            self.tbdThanhToan17.valid.errors.showAllMessages();
            return;
        }
       self.isSaving(false);
        var url = '/mard/17/tbdThanhToan17/create';
        if (self.tbdThanhToan17.fiId() > 0) {
            url = '/mard/17/tbdThanhToan17/update/' + self.tbdThanhToan17.fiId();
        }
        self.callConfirm(function () {
            app.makePost({
                url: url,
                data: ko.toJSON(convertKnockoutToObject(self.tbdThanhToan17, createObject(self.tbdThanhToan17))),
                error: function (e) {
                    if (e.readyState == 4) {
                        return;
                    }
                    if (self.tbdThanhToan17.fiId() <= 0) {
                        self.danhSachThanhToanPhi.push(convertObjectToKnockout(e, new TbdThanhToan17()));
                        self.danhSachThanhToanPhi.reverse();
                    } else {
                        var findItem = ko.utils.arrayFilter(self.danhSachThanhToanPhi(), function(prod) {
                            return prod.fiId() == self.tbdThanhToan17.fiId();
                        });
                        if (findItem[0]) {
                            convertObjectToKnockout(e, findItem[0]);
                        }
                    }
                    clearDataKnockout(self.tbdThanhToan17);
                    self.tbdThanhToan17.valid.errors.showAllMessages(false);
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
        cloneKnockoutObject(item, self.tbdThanhToan17);
    }

    self.delete = function(item) {
        self.callConfirm(function () {
            $.getJSON(app.appContext + '/mard/17/tbdThanhToan17/delete/'+ item.fiId(), function (d) {
                if (d.readyState == 4) {
                    showToast(NSWLang["mard.17.action.error"], false);
                    return;
                }
                showToast(NSWLang["mard.17.action.success"], true);
                self.danhSachThanhToanPhi.remove(item);
            });
        }, NSWLang["common_msg_xoa_ho_so"]);

    }

    self.send = function(item) {
        self.tbdThanhToan17.fiIdHoSo(item.tbdThanhToan17.fiIdHoSo());
        if (self.tbdThanhToan17.valid.errors().length > 0) {
            showError(self.tbdThanhToan17);
            self.tbdThanhToan17.valid.errors.showAllMessages();
            return;
        }
        else {
        self.callConfirm(function () {
            app.makePost({
                url: '/mard/api/17/saveThanhToanAndSend',
                data: ko.toJSON(convertKnockoutToObject(self.tbdThanhToan17, createObject(self.tbdThanhToan17))),
                success: function (d) {
                    self.thongBao(NSWLang["mard.17.action.success"] , true);
                    item.tbdThanhToan17.fiSended(1);
                    setTimeout(function () {
                        location.reload();
                    }, 1000);
                },
                error: function (e) {
                    self.thongBao(NSWLang["mard.17.action.error"], false);
                }
            });
        }, NSWLang["mard.16.confirmSave"]);
        }


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
    self.totalFileSize = ko.observable(0);
    self.uploadNew = function getdata(k, fileTypeCode){
        var fd = new FormData();
        var files = $('#fileUploadFee')[0].files[k];

        

        fd.append('token',token);
        fd.append('documentType',"BNNPTNT0600008");
        fd.append('fileCode',fileTypeCode);
        fd.append('fileName',files.name);
        fd.append('file', files);

        $.ajax({
            url : 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload',
            type : 'post',
            data : fd,
            async: false,
            contentType : false,
            processData : false,
            success : function(response) {
                if (response.status == "Successful" ) {
                    var tepTin1;
                    
                    tepTin1 = convertObjectToKnockout(response.data, new TepTinModelFee());
                    //tepTin1.fiId(response.data.ItemId);
                    tepTin1.fiSize(files.size);
                    tepTin1.fiIdHoSo(self.tbdThanhToan17.fiIdHoSo());
                    //tepTin1.link(response.data.UrlFile);
                    tepTin1.fiFileName(files.name);
                    tepTin1.fiFileTypeCode(4);
                    tepTin1.fiFileGroup(documentType);
                    tepTin1.fiPath(response.data.UrlFile);
                    //self.tbdThanhToan17.fiUuid(d.data.fiUuid);
                    self.tbdThanhToan17.fiPath(response.data.UrlFile);
                    self.tbdThanhToan17.fiLink(response.data.UrlFile);
                    self.tbdThanhToan17.fiFileName(files.name);
                    self.tbdThanhToan17.fiFileCode(4);
                    
                    self.addTep(tepTin1);
                    $('#fileUploadFee').val('');

                } else {
                    app.Alert('File upload chưa thành công vui lòng thử lại');
					$('#fileUploadFee').val('');
                    getToken();
                }
            },
        });
    }

    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
    self.uploadFileChangeEvent = function( elemet, event) {
        getToken();
        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            if (/#|%|&|\*|:|<|>|\?|\/|\{|\}/.test(file.name)) {
                app.Alert( 'Tên tệp không được chứa ký tự đặc biệt sau: ~ " # % & * : < > ? / \ { | }');
                $('#fileUploadFee').val('');
                return false;
            }
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUploadFee').val('');
                app.Alert( NSWLang["mard.18.uploadInfo"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 50;// 50MB

        $(files).each(function(index, item){
            self.totalFileSize(self.totalFileSize() + item.size);
        });
        if (self.totalFileSize() > totalMB) {
            $(files).each(function(index, item){
                self.totalFileSize(self.totalFileSize() - item.size);
            });
            $('#fileUploadFee').val('');
            app.Alert( NSWLang["mard.18.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            self.uploadNew( k, 4);
            if(self.teps().length > 0){
            app.makePost({
                url: '/mard/17/tbdDinhKem17/create',
                data: ko.toJSON(self.teps()[k]),
                error: function (e) {
                    if(null != e.fiId && undefined != e.fiId){

                    }
                    else{
                        app.Alert('Đã xảy ra lỗi trong quá trình upload');
                        self.removeTep(self.teps()[k]);
                    }
                }
            });
            }
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
        var value = self.tbdThanhToan17.fiTotalFee().replace(/\./g, '');
        if (value) {
            var so = self.tbdThanhToan17.fiTotalFee();
            self.tbdThanhToan17.fiTotalFeeChar(docso(so));
        }

        return true;
    }

}
