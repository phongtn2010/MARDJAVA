/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */

var CSRF_TOKEN_NAME = $('#csrfHeader').val();
var CSRF_TOKEN_VALUE = $('#csrfToken').val();
function Mard11FilesVM(options)
{
    var self = this;
    self.formData = null;
    
    self.fileUpload = function(data, e){
        var files = e.target.files;
        if(!files || files.length <= 0){
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
        self.fiTenTep(files[0].name);
    };
    
    self.validateForm = function(){
        if(self.fileErrors().length > 0){
            self.fileErrors.showAllMessages();
            return false;
        }
        if(!self.formData){
            alert('Phải chọn tệp đính kèm.');
            return false;
        }
        return true;
    };
    
    /**
     * T?i t?p
     * @returns {undefined}
     */
    self.uploadClick = function(){
        if(!self.validateForm()){
            return;
        }
        self.formData.append("fiTenTep", self.fiTenTep());
        self.formData.append("fiIdHoso", self.fiIdHoso() ? self.fiIdHoso() : 0);
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/11/upload',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if(res && res.success){
                    var item = new Tbddinhkem11(self.lstDinhkem11().length + 1, res.data);
                    self.lstDinhkem11.push(item);
                    self.clearForm();
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
    self.errorDinhkemText = ko.observable("");
    self.isValidForm = function(){
        self.errorDinhkemText("");
        if(!self.lstDinhkem11() || self.lstDinhkem11().length <= 0){
            self.errorDinhkemText("* Phải nhập ít nhất tệp đính kèm: Giấy chứng nhận kiểm dịch của nước xuất khẩu");
            return false;
        }
        return true;
    };
    
    self.clearForm = function(){
        self.formData = null;
        self.fiTenTep(null);
        document.getElementById("fiTep").value = "";
        self.fileErrors.showAllMessages(false);
    };
    
    self.bXoaClick = function(item, e) {
        console.log("fileDinhKem::bXoaClick");
        if(confirm("Bạn có muốn xóa tệp đính kèm")){
            if(item){
                self.lstDinhkem11.remove(function(f) {
                    return f.fiIdDinhkem() == item.fiIdDinhkem();
                });
            }
        }
    };
    
    self.getLstDinhkem11AsJson = function(){
        var jsonList = ko.toJS(self.lstDinhkem11());
        if(jsonList.length > 0){
            for(var i = 0; i < jsonList.length; i++){
                delete jsonList[i]["STT"];
                delete jsonList[i]["bXoa"];
                delete jsonList[i]["downloadUrl"];
                delete jsonList[i]["viewUrl"];
            }
        }
        return jsonList;
    };
    
    self.updateFiIdHoso = function(id){
        self.fiIdHoso(id);
    };
    
    self.fiIdHoso = ko.observable(options.fiIdHoso);
    
    self.fiTenTep = ko.observable(null).extend({
        required : {message : 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 255 ký tự', params : 255}
    });
    
    var hoso = options && options.hoso ? options.hoso : {};
    self.lstDinhkem11 = ko.observableArray(hoso && hoso.lstDinhkem11 ? mapTbddinhkem11(hoso.lstDinhkem11): null);
    var fileVG = self;
    self.fileErrors = ko.validation.group(fileVG, { deep: true, live: true, observable: true });
};
