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
                title: '<b style="text-transform: uppercase">' + NSWLang["mard.17.TbdThuoc17.fiProductFile"] + ' - ' + item.fiNameOfProduct() + '</b>',
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
            code: "17",
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
    self.fiNameOfProduct = ko.observable();
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
        self.fiNameOfProduct(item.fiNameOfProduct());
        if (idHoSo > 0 && self.item.fiTepDinhKemThuocs().length == 0) {
            $.ajax({
                url: app.appContext + '/mard/17/tbdDinhKem17/findByFiProductId/' + item.fiId(),
                dataType: 'json',
                async: false,
                data: null,
                success: function(d) {
                    
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


  
    self.DanhMucDinhKemThuoc = ko.observableArray([
        { Name : "CoA, CFS, GMP, ...", code : "1", fileTypeCode: "2"},
        { Name : "Giấy tờ liên quan khác", code : "2", fileTypeCode: "2"}
    ]);






    /*self.uploadNewThuoc = function getdata(position,k,code){
        var fd = new FormData();
        var files = $('#fileUploadThuoc' + position)[0].files[k];
        console.log($('#fileUploadThuoc' + position)[0]);
        console.log($('#fileUploadThuoc' + position)[0].files[k]);

        console.log("file : "+files)
        console.log("Name File : "+files.name);

        fd.append('token',token);
        fd.append('documentType',"BNNPTNT0600007");
        fd.append('fileCode',code);
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
                    console.log(response);
                    console.log(response.data.ItemId);
                    console.log(response.data.UrlFile);
                    tepTin1 = new TepTinThuocModel();
                    tepTin1.fiFileName(files.name);
                    tepTin1.fiFileTypeCode(2);
                    tepTin1.fiFileGroup(documentType);
                    tepTin1.fiPath(response.data.UrlFile);
                    console.log("idHoSo: " + idHoSo);
                    if (idHoSo > 0){
                        tepTin1.fiIdHoSo(idHoSo);
                        tepTin1.fiProductId(self.item.fiId());
                    }
                    //tepTin1.fiProductId(self.item.fiId());
                    console.log(ko.toJSON(tepTin1));
                    //self.teps().push(tepTin1);
                    self.addTep(tepTin1);
                    //console.log(ko.toJSON(self.item.fiTepDinhKemThuocs()));
                    console.log("self.item().fiTepDinhKemThuocs().length: " + self.teps().length);
                    $('#fileUploadThuoc' + position).val('');

                } else {
                    alert('file not uploaded');
                    getToken();

                }
            },
        });
    }*/


    self.pageContents = ko.observableArray([]);

    self.totalFileSize = ko.observable(0);
    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];

    
    self.danhMucTeps = ko.observableArray([]);

   /* self.uploadFileChangeEvent = function(loaiTep, position, elemet, event) {
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
                app.Alert( NSWLang["mard.17.uploadInfo"]);
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
            app.Alert( NSWLang["mard.17.uploadSize"]);
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
                app.Alert( NSWLang["mard.17.uploadInfo"]);
                return false;
            }
            var fileLength = file.name.length;
            if( 50 < fileLength){
                app.Alert('Tên tệp không được quá 50 ký tự');
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
            app.Alert( NSWLang["mard.17.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            var fileTypeCode = 2;
            self.uploadNew2( k, fileTypeCode);
        }
    }
    self.uploadNew2 = function getdata(k,fileTypeCode){
        var fd = new FormData();
        var files = $('#fileUploadThuocNew')[0].files[k];
        


        

        fd.append('token',token);
        fd.append('documentType',"BNNPTNT0600008");
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
                    app.Alert('File upload không thành công vui lòng thử lại');
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
            
            if(self.teps().length > 0 ){
                $(self.teps()).each(function(index, loopItem){
                    if(loopItem.fiId() != undefined && loopItem.fiId() !== null){
                        $.getJSON(app.appContext + '/mard/17/tbdDinhKem17/delete/' + loopItem.fiId(), function (d) {
                            self.teps().remove(loopItem);
                            self.totalFileSize(self.totalFileSize() - d.fiSize);
                            self.teps().remove(loopItem);
                        });
                    }
                    else{
                       
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

                $.getJSON(app.appContext + '/mard/17/tbdDinhKem17/delete/' + item1.fiId(), function (d) {

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