/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, DA_TIEP_NHAN, YEU_CAU_BO_SUNG, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, RAW_HS_STATUS, History */
ko.validation.rules.pattern.message = 'Invalid.';

ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);
    
function Mard10CreateVM(options){
    self = this;
    
    self.mard10FormVM = ko.validatedObservable(new Mard10FormVM(options));
    self.mard10FilesVM = ko.observable(new Mard10FilesVM(options));
    
    self.fiLydoSua = ko.observable(null);
    self.tabFiLydoSua = ko.observable(options && options.edit);

    self.fiLydoHuy = ko.observable(null);
    self.tabFiLydoHuy = ko.observable(options && options.del);
    self.btnLuu = ko.dependentObservable(function (){
        return !options || !options.edit;
    }, self);
    
    self.btnTai = ko.computed(function(){
        return options && options.fiIdHoso > 0 || self.mard10FormVM().fiIdHoso() > 0;
    }, self);
    self.exportHref = ko.computed(function(){
        if(options && options.fiIdHoso){
            return app.appContext + "/mard/10/hoso/bieumau/" + options.fiIdHoso;
        }
        else{
            return app.appContext + "/mard/10/hoso/bieumau/" + self.mard10FormVM().fiIdHoso();
        }
    }, self);
    
    self.clearForm = function(){
        
    };
    
    /**
     * Khi chon tep excel de upload
     * @param {type} data
     * @param {type} e
     * @returns {undefined}
     */
    self.fileUpload = function(data, e){
        var files = e.target.files;
        if(!files || files.length <= 0){
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
    };
    
    /**
     * Day excel len server de lay du lieu
     * @returns {undefined}
     */
    self.btnImportClick = function(){
        if(!self.formData){
            alert('Phải chọn tệp excel (có đuôi xslx) chứa nội dung hồ sơ');
            return;
        }
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/hoso/excel',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if(res && res.success){
                    // Đưa dữ liệu từ excel vào form
                    self.mard10FormVM().import(res.data);
                }
            },
            error: function (x, t, m) {
                self.clearForm();
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });  
    };
    
    /**
     * Thực hiện lưu và gửi
     * @returns {undefined}
     */
    self.btnGuiClick = function(){
        if(self.tabFiLydoSua() && !self.fiLydoSua()){
            alert('Phải nhập lý do sửa');
            $('#a-tab-mard10-3').trigger('click');
            return;
        }
        else{
            if(!self.mard10FormVM().isValidForm()){
                alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
                $('#a-tab-mard10-1').trigger('click');
                return;
            }
            if(!self.mard10FilesVM().isValidForm()){
                alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
                $('#a-tab-mard10-2').trigger('click');
                return;
            }
            
            var fiLydoSua = self.fiLydoSua();
            var fiIdHoso = self.mard10FormVM().fiIdHoso();
            var fiMaHoso = self.mard10FormVM().fiMaHoso();
            var fiTrangthai = self.mard10FormVM().fiTrangthai();
            var data = self.mard10FormVM().toJSON();
            data.fiLydoSua = fiLydoSua;
            data["lstDinhkem10"] = self.mard10FilesVM().getLstDinhkem10AsJson();
            // Trường hợp tạo mới và gửi luôn
            var isNew = !fiIdHoso || fiIdHoso <= 0 || !fiTrangthai || fiTrangthai == 0;
            var url = !fiIdHoso || fiIdHoso <= 0 ? app.appContext + '/mard/10/hoso/taomoi' : (fiTrangthai == DA_TIEP_NHAN ? app.appContext + "/mard/10/hoso/yc-capnhap" : app.appContext + '/mard/10/hoso/capnhap');
            $.ajax({
                async: true,
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: url,
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                    $('#loading10').show();
                },
                success: function (res) {
                    //console.log("res -> ", res);
                    if(res && res.success){
                        // Gán fiIdHoso
                        self.mard10FormVM().fiIdHoso(res.data.fiIdHoso);
                        // Bắt đầu gửi hồ sơ đi
                        var data;
                        if(isNew){
                            data = {
                                type : "10",
                                "function" : "01",
                                fiIdHoso : fiIdHoso,
                                fiMaHoso : fiMaHoso,
                                reason :fiLydoSua
                            };
                        }
                        else{
                            if(fiTrangthai == YEU_CAU_BO_SUNG){
                                data = {
                                    type : "10",
                                    "function" : "03",
                                    fiIdHoso : fiIdHoso,
                                    fiMaHoso : fiMaHoso,
                                    reason :fiLydoSua
                                };
                            }
                            else if(fiTrangthai == DA_TIEP_NHAN){
                                data = {
                                    type : "16",
                                    "function" : "12",
                                    fiIdHoso : fiIdHoso,
                                    fiMaHoso : fiMaHoso,
                                    reason :fiLydoSua
                                };
                                
                            }
                            else{
                                data = {
                                    type : "10",
                                    "function" : "02",
                                    fiIdHoso : fiIdHoso,
                                    fiMaHoso : fiMaHoso,
                                    reason :fiLydoSua
                                };
                            }
                        }
                        self.guiYcXuly(data);
                    }
                    else{
                        alert('Gửi dữ liệu không thành công');
                        History.go(-1);
                    }
                },
                error: function (x, t, m) {
                    $('#loading10').hide();
                },
                complete: function (jqXHR, textStatus) {
                    //$('#loading10').hide();
                }
            });
        }
    };
    
    /**
     * Quay tro lai trang truoc
     * @returns {Boolean}
     */
    self.btnTroLaiClick = function(){
        History.go(-1);
    };
    
    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function(){
        if(!self.mard10FormVM().isValidForm()){
            alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-mard10-1').trigger('click');
            return;
        }
        if(!self.mard10FilesVM().isValidForm()){
            alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            $('#a-tab-mard10-2').trigger('click');
            return;
        }
        var fiIdHoso = self.mard10FormVM().fiIdHoso();
        var data = self.mard10FormVM().toJSON();
        data["lstDinhkem10"] = self.mard10FilesVM().getLstDinhkem10AsJson();
        var url = !fiIdHoso || fiIdHoso <= 0 ? app.appContext + '/mard/10/hoso/taomoi' : app.appContext + '/mard/10/hoso/capnhap';
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: url,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if(res && res.success){
                    alert('Lưu dữ liệu thành công');
                    self.mard10FormVM().fiIdHoso(res.data.fiIdHoso);
                    self.mard10FormVM().fiMaHoso(res.data.fiMaHoso);
                    self.mard10FormVM().fiNguoiCn(res.data.fiNguoiCn);
                    self.mard10FormVM().fiNguoitao(res.data.fiNguoitao);
                    self.mard10FormVM().fiTrangthai(res.data.fiTrangthai);
                    self.mard10FormVM().lstHanghoa10(mapTbdhanghoa10(res.data.lstHanghoa10));
                    
                    self.mard10FilesVM().fiIdHoso(res.data.fiIdHoso);
                    self.mard10FilesVM().lstDinhkem10(mapTbddinhkem10(res.data.lstDinhkem10));
                }
                else{
                    alert('Lưu dữ liệu không thành công');
                }
            },
            error: function (x, t, m) {
                // log
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
    
    /**
     * Gửi hồ sơ
     * @param {type} data
     * @returns {undefined}
     */
    self.guiYcXuly = function(data){
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/hoso/xuly',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                // Thông báo kết quả
                if(res && res.success){
                    alert('Đã gửi yêu cầu thành công');
                    History.go(-1);
                }
                else{
                    alert('Đã gửi yêu cầu không thành công');
                    History.go(-1);
                }
            },
            error: function (x, t, m) {
                // log
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
};

$(document).ready(function(){
    if(!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0){
        getCategory("HS_STATUS", null, function(res){
            if(res.success){
                RAW_HS_STATUS = res.data;
                init();
            }
        });
    }
    var init = function(){
        var options = app.parseQuerystring();
        if(options && options.fiIdHoso > 0){
            $.ajax({
                async: true,
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + '/mard/10/hoso/t/' + options.fiIdHoso,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                    $('#loading10').show();
                },
                success: function (res) {
                    if(res.success){
                        options.hoso = res.data;
                        // TODO: Kiểm tra trạng thái xem có đc sửa ko, ko thì redirect về index
                        var mard10CreateVM = new Mard10CreateVM(options);
                        ko.applyBindings(mard10CreateVM, document.getElementById('mard10Create'));
                    }
                },
                error: function (x, t, m) {
                    alert('Lỗi khi thực hiện yêu cầu');
                },
                complete: function (jqXHR, textStatus) {
                    $('#loading10').hide();
                }
            });
        }
        else{
            var mard10CreateVM = new Mard10CreateVM(options);
            ko.applyBindings(mard10CreateVM, document.getElementById('mard10Create'));
        }
    };
});