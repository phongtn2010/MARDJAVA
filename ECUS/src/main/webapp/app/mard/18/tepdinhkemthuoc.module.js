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
setInterval(getToken, 30000);

function TepDinhKemThuocView() {
    var self = this;
    //self.show = function(item) {
    self.show = function (item, templateName) {
        var callback = function (html) {
            var pop = app.popup({
                title: '<b style="text-transform: uppercase">' + NSWLang["mard.18.TbdThuoc18.fiProductFile"] + ' - ' + item.fiNameOfGoods() + '</b>',
                html: html,
                width: 960,
                buttons: [
                ]
            }, function(){
                var mTepDinhKemThuocView= new TepDinhKemPopupView(item);
                //mTepDinhKemThuocView.LoadTepDinhKem();
                ko.applyBindings(mTepDinhKemThuocView, document.getElementById("form-tep_dinh_kem_thuoc"));
            });

            self.appPopup = pop;
        }

        app.complieTemplate({
            ministryCode: "mard",
            code: "18",
            //templateName: "tep_dinh_kem_thuoc",//param
            templateName: templateName,
            data: null
        }, callback);
    }
}
function TepDinhKemPopupView(item) {
    var self = this;
    getToken();
    self.teps = ko.observableArray();
    self.nameOfGoods = ko.observable();
    self.item = item;

    self.addTep = function (tep){
        var self = this;
        self.teps.push(tep);
    };

    self.removeTep = function (tep){
        var self = this;
        self.teps.remove(tep);
    };

    self.LoadData = function(item){
        self.teps = ko.observableArray(item.fiTepDinhKemThuocs());
        self.nameOfGoods(item.fiNameOfGoods());
        if (idHoSo > 0 && self.item.fiTepDinhKemThuocs().length == 0) {
            $.ajax({
                url: app.appContext + '/mard/18/tbdDinhKem18/findByFiProductId/' + item.fiId(),
                dataType: 'json',
                async: false,
                data: null,
                success: function(d) {
                    debugger;
                    
                    if(d.length > 0){
                        for(var index = 0; index < d.length; index++){
                            var tep = new TepTinThuocModel();
                            tep.fiId(d[index].fiId); //??? sao lai lấy ID vào đây
                            tep.fiFileName(d[index].fiFileName);
                            tep.fiFileTypeCode(d[index].fiFileTypeCode);
                            tep.fiFileGroup(d[index].fiFileGroup);
                            tep.fiPath(d[index].fiPath);
                            self.addTep(tep);
                        }
                    }
                    
                }
            });
        }
    }
    self.LoadData(item);




    self.pageContents = ko.observableArray([]);

    self.totalFileSize = ko.observable(0);
    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];



    /* console.log("self.danhmucdinhkemthuoc0: " + JSON.parse(ko.toJSON(self.DanhMucDinhKemThuoc))[0].code);
     self.danhMucTeps = ko.observableArray([]);
 
     self.uploadFileChangeEvent = function(loaiTep, position, elemet, event) {
         console.log(event);
         console.log(event.target);
         console.log(JSON.stringify(event.target));
         var files = event.target.files;
         for (var i = 0, file; file = files[i]; i++) {
             if (/#|%|&|\*|:|<|>|\?|\/|\{|\}/.test(file.name)) {
                 app.Alert( 'Tên tệp không được chứa ký tự đặc biệt sau: ~ " # % & * : < > ? / \ { | }');
                 $('#fileUpload' + position).val('');
                 return false;
             }
             var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
             if ($.inArray(ext, self.accepFiles) === -1) {
                 $('#fileUpload' + position).val('');
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
             $('#fileUpload' + position).val('');
             app.Alert( NSWLang["mard.18.uploadSize"]);
             return false;
         }
         var findId = idHoSo;
         for (var k = 0; k < files.length; k++) {
             var fileTypeCode = JSON.parse(ko.toJSON(self.DanhMucDinhKemThuoc))[position].code;
 
             self.uploadNewThuoc(position, k, fileTypeCode);
         }
     }*/
    //--------------------------------------------------------------------//
    self.uploadFileChangeEventNew = function( elemet, event) {
        var files = event.target.files;

       
        for (var i = 0, file; file = files[i]; i++) {
            if (/#|%|&|\*|:|<|>|\?|\/|\{|\}/.test(file.name)) {
                app.Alert( 'Tên tệp không được chứa ký tự đặc biệt sau: ~ " # % & * : < > ? / \ { | }');
                $("#fileUploadThuocNew").val('');
                return false;
            }
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUploadThuocNew').val('');
                app.Alert( NSWLang["mard.18.uploadInfo"]);
                return false;
            }
            var fileLength = file.name.length;
            if( 50 < fileLength){
                app.Alert('chitietthuoc.module.js');
                $("#fileUploadThuocNew").val('');
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
            $('#fileUploadThuocNew').val('');
            app.Alert( NSWLang["mard.18.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            var fileTypeCode = 1;
            self.uploadNew2( k, fileTypeCode);
        }
    }
    self.uploadNew2 = function getdata(k,fileTypeCode){
        var fd = new FormData();
        var files = $('#fileUploadThuocNew')[0].files[k];
       

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
            success : function(response) {
                if (response.status == "Successful" ) {
                    var tepTin1;
                    
                    tepTin1 = convertObjectToKnockout(response.data, new TepTinThuocModel());
                    // tepTin1.fiId(response.data.ItemId);
                    tepTin1.fiSize(files.size);
                    //tepTin1.link(response.data.UrlFile);
                    tepTin1.fiFileName(files.name);
                    tepTin1.fiFileTypeCode(2);
                    tepTin1.fiFileGroup(documentType);
                    tepTin1.fiPath(response.data.UrlFile);
                    //tepsNew[position].push(tepTin);
                    
                    self.addTep(tepTin1);

                    $('#fileUploadThuocNew').val('');
                    // console.log(ko.toJSON(self.teps()[1]));
                } else {
                    app.Alert('Upload file không thành công vui lòng thử lại');
					$('#fileUploadThuocNew').val('');
                    getToken();
                }
            },
        });
    }
    //---------------------------------------------------------------------\\
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
    self.xoaTepTin = function() {
        self.callConfirm(function () {
            console.log(self.teps().length);
            if(self.teps().length > 0 ){
                $(self.teps()).each(function(index, loopItem){
                    if(loopItem.fiId() != undefined && loopItem.fiId() !== null){
                        $.getJSON(app.appContext + '/mard/18/tbdDinhKem18/delete/' + loopItem.fiId(), function (d) {
                            self.teps().remove(loopItem);
                            self.totalFileSize(self.totalFileSize() - d.fiSize);

                        });
                    }
                    else{
                        console.log(ko.toJSON(self.teps()));
                        self.totalFileSize(self.totalFileSize() - loopItem.fiSize);
                        self.removeTep(loopItem);
                    }
                });
            }

        })

    }
    self.xoaMotFile = function(item1, position) {

        self.callConfirm(function () {
            var idHS = idHoSo;

            if(item1.fiId() != null && item1.fiId() >0){ // ??? Code này không hiểu trên vẫn có mà

                $.getJSON(app.appContext + '/mard/18/tbdDinhKem18/delete/' + item1.fiId(), function (d) {

                });
            }
            self.totalFileSize(self.totalFileSize() - item1.fiFileByte());
            self.removeTep(item1);


        })


    }
    self.convertData = function() {
        var data = [];
        self.DanhMucDinhKemThuoc().forEach(function(item, index){
            if (item.fiFileGroup  == self.selectedTep()) {
                $(item.fiTepDinhKemThuocs()[index]()).each(function(tIndex, t){
                    data.push(convertKnockoutToObject(t, createObject(t)));
                });
            }
        });
        return data;
    }

}