var token;

function getToken() {
    var settings = {
        "url" : "https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken",
        "method" : "GET",
        "timeout" : 0,
    };

    $.ajax(settings).done(function(response) {
        token = response.data;
    });
}


function SuaGiayPhepView() {

    var self = this;
    self.show = function(item) {
        var callback = function (html) {
            var pop = app.popup({
                title: '<b style="text-transform: uppercase">' +  NSWLang["mard.20.index.table.th.14"] + " - " + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
                buttons: [
                ]
            }, function(){
                var mTepDinhKemThuocView= new SuaGpPopupViewModel(item);
                //mTepDinhKemThuocView.LoadTepDinhKem();
                ko.applyBindings(mTepDinhKemThuocView, document.getElementById("form-xin-sua-giay-phep-popup"));
            });

            self.appPopup = pop;
        }

        app.complieTemplate({
            ministryCode: "mard",
            code: "20",
            templateName: "xin_sua_giay_phep",
            data: null
        }, callback);
    }
}
setInterval(getToken, 300000);
function SuaGpPopupViewModel(item){
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
    //self.item = item;
    self.totalFileSize = ko.observable(0);
    self.callConfirm = function(affter) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
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
    self.save = function() {

    }
    self.send = function(pop) {
        self.isValid();
        if (self.isValid() == true ){
            //self.save();
            var isOk = app.isFormVaild('form-xin-sua-giay-phep-popup');
            if (!isOk)
                return;
            var data = app.form2Object('#form-xin-sua-giay-phep-popup');
            app.makePost({
                url: '/mard/api/20/send',
                data: JSON.stringify({
                    fiReason: data.reason,
                    fiXml: null,
                    fiIdHoSo: item.fiIdHoSo(),
                    fiAction: 5
                }),
                success: function (d) {
                    app.popupRemove(pop.selector);
                    self.thongBao(NSWLang["mard.20.action.success"], true)
                    //success();
                },
                error: function (e) {
                    self.thongBao(NSWLang["mard.20.action.error"], false)
                    //success();
                }
            });
        }
    }
    function getdata(k, fileTypeCode){
        var fd = new FormData();
        var files = $('#fileUploadGp')[0].files[k];
        fd.append('token',token);
        fd.append('documentType',"BNNPTNT0600007");
        fd.append('fileCode',fileTypeCode);
        fd.append('fileName',files.name);
        fd.append('file', files);

        $.ajax({
            url : 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload',
            type : 'post',
            data : fd,
            contentType : false,
            processData : false,
            async: false,
            success : function(response) {
                if (response.status == "Successful" ) {
                    var tepTin1;
                    tepTin1 = convertObjectToKnockout(response.data, new TepTinModelGP());
                    //tepTin1.fiId(response.data.ItemId);
                    tepTin1.fiSize(files.size);
                    tepTin1.fiIdHoSo(item.fiIdHoSo());
                    //tepTin1.link(response.data.UrlFile);
                    tepTin1.fiFileName(files.name);
                    tepTin1.fiFileTypeCode(3);
                    tepTin1.fiFileGroup(documentType);
                    tepTin1.fiPath(response.data.UrlFile);
                    //self.tbdThanhToan20.fiUuid(d.data.fiUuid);
                    self.addTep(tepTin1);
                    $('#fileUploadGp').val('');

                } else {
                    app.Alert('File upload không thành công vui lòng thử lại');
                    $('#fileUploadGp').val('');
                    getToken();
                }
            },
        });
    }
    self.isValid = function() {
        if (self.teps().length < 1){
            app.Alert( NSWLang["mard.20.tepDinhKem.notValid"]);
            return false;
        }
        return true;
    }
    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
    self.uploadFileChangeEvent = function( elemet, event) {
        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            if (/#|%|&|\*|:|<|>|\?|\/|\{|\}/.test(file.name)) {
                app.Alert( 'Tên tệp không được chứa ký tự đặc biệt sau: ~ " # % & * : < > ? / \ { | }');
                $("#fileUploadGp").val('');
                return false;
            }
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUploadGp').val('');
                app.Alert( NSWLang["mard.20.uploadInfo"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 5;// 5MB

        $(files).each(function(index, item){
            self.totalFileSize(self.totalFileSize() + item.size);
        });
        if (self.totalFileSize() > totalMB) {
            $(files).each(function(index, item){
                self.totalFileSize(self.totalFileSize() - item.size);
            });
            $('#fileUploadGp').val('');
            app.Alert( NSWLang["mard.20.uploadSize"]);
            return false;
        }

        for (var k = 0; k < files.length; k++) {
            getdata(k, 3);

            if(self.teps().length > 0) {
                app.makePost({
                    url: '/mard/20/tbdDinhKem20/create',
                    data: ko.toJSON(self.teps()[k]),
                    error: function (e) {
                        if (null != e.fiId && undefined != e.fiId) {

                        } else {
                            app.Alert('Đã xảy ra lỗi trong quá trình upload');
                            self.removeTep(self.teps()[k]);
                        }
                    }
                });
            }

        }
    }


    self.xoaMotFile = function(item1, position) {

        self.callConfirm(function () {
            var idHS = idHoSo;
            if(item1.fiId() != null && item1.fiId() >0){ // ??? Code này không hiểu trên vẫn có mà
                $.getJSON(app.appContext + '/mard/20/tbdDinhKem20/delete/' + item1.fiId(), function (d) {
                });
            }
            self.totalFileSize(self.totalFileSize() - item1.fiFileByte());
            self.removeTep(item1);
        })

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
                        }, 1000);
                    }
                }
            ]
        }, function(){
            $('button[class="close"]').click(function(){
                app.popupRemove(pop.selector);
                setTimeout(function () {
                    location.reload();
                }, 1000);
            });
        });
    }

}
