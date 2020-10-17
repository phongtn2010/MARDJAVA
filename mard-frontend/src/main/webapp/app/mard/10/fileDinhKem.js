/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */

var CSRF_TOKEN_NAME = $('#csrfHeader').val();
var CSRF_TOKEN_VALUE = $('#csrfToken').val();
function Mard10FilesVM(options)
{
    var self = this;
    self.formData = null;

    self.fileUpload = function (data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        
        if (Util.uploadFileNameValidate(files[0].name)) {
            self.formData = new FormData();
            self.formData.append('file', files[0]);
            self.fiTenTep(files[0].name);
        } else {            
            return;
        }
        
        if (Util.validateExtension(files[0].name)) {
            self.formData = new FormData();
            self.formData.append('file', files[0]);
            self.fiTenTep(files[0].name);
        } else {            
            return;
        }
    };

    self.validateForm = function () {
        if (self.fileErrors().length > 0) {
            self.fileErrors.showAllMessages();
            return false;
        }
        if (!self.formData) {
            alert('Phải chọn tệp đính kèm.');
            return false;
        }
        return true;
    };

    self.fiMaloaiChange = function () {
        return;
        if (self.fiMaLoai() != 2 && self.fiMaLoai() != 3) {
            return;
        }
        var html = [
            $('#select-attach-template').html()
        ].join('');
        self.pop = app.popup({
            title: 'Chọn Số công văn đã cấp mẫu 14a,b:',
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Chọn',
                    class: 'btn',
                    icon: 'fa-check',
                    action: self.selectedFileClick
                }
            ]
        });
        var SelectedAttachVM = function () {
            var vmSelf = this;
            vmSelf.selected = ko.observable();
            vmSelf.attachments = ko.observableArray([]);
            vmSelf.serverData;
            vmSelf.fetch = function () {
                var type = self.fiMaLoai() == 2 ? "14a" : "14b";
                $.ajax({
                    async: true,
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + "/mard/10/gcn/" + type,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if (res && res.success) {
                            vmSelf.serverData = res.data;
                            vmSelf.attachments(mapCategory(vmSelf.serverData, "fiId" + type, "fiSocv"));
                        }
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
            };
            vmSelf.fetch();

            vmSelf.selectedValue = function () {
                if (!vmSelf.selected()) {
                    return null;
                }
                var type = self.fiMaLoai() == 2 ? "14a" : "14b";
                for (var i = 0; i < vmSelf.serverData.length; i++) {
                    if (vmSelf.serverData[i]["fiId" + type] == vmSelf.selected()) {
                        return vmSelf.serverData[i];
                    }
                }
            };
        };
        self.selectedAttachVM = new SelectedAttachVM();
        ko.applyBindings(self.selectedAttachVM, document.getElementById('select-attach'));
    };

    self.selectedFileClick = function () {
        if (!self.selectedAttachVM.selectedValue()) {
            alert('Phải chọn công văn.');
            return;
        }
        app.popupRemove(self.pop.selector);
        $('.modal-scrollable').hide();
        $('.modal-backdrop').hide();
        var objFiMau = self.selectedAttachVM.selectedValue();
        if (!self.formData) {
            self.formData = new FormData();
        }
        self.formData.append("fiMaLoai", self.fiMaLoai());
        self.formData.append("fiTenLoai", self.fiTenLoai());
        self.formData.append("fiTenTep", objFiMau["fiSocv"]);
        for (var key in objFiMau) {
            self.formData.append(key, objFiMau[key]);
        }
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/upload-14',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if (res && res.success) {
                    var item = new Tbddinhkem10(self.lstDinhkem10().length + 1, res.data);
                    self.lstDinhkem10.push(item);
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

    /**
     * T?i t?p
     * @returns {undefined}
     */
    self.uploadClick = function () {
        if (!self.validateForm()) {
            return;
        }
        self.formData.append("fiMaLoai", self.fiMaLoai());
        self.formData.append("fiTenLoai", self.fiTenLoai());
        self.formData.append("fiTenTep", self.fiTenTep());
        self.formData.append("fiIdHoso", self.fiIdHoso() ? self.fiIdHoso() : 0);
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/upload',
            data: self.formData,
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if (res && res.success) {
                    var item = new Tbddinhkem10(self.lstDinhkem10().length + 1, res.data);
                    self.lstDinhkem10.push(item);
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
    self.isValidForm = function () {
        self.errorDinhkemText("");
        if (!self.lstDinhkem10() || self.lstDinhkem10().length <= 0) {
            self.errorDinhkemText("* Phải nhập ít nhất tệp đính kèm: Giấy chứng nhận kiểm dịch của nước xuất khẩu");
            return false;
        }
        var exist = false;
        for (var i = 0; i < self.lstDinhkem10().length; i++) {
            if (self.lstDinhkem10()[i].fiMaLoai() == 0) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            self.errorDinhkemText("* Phải nhập ít nhất tệp đính kèm: Giấy chứng nhận kiểm dịch của nước xuất khẩu");
            return false;
        }
        return true;
    };

    self.clearForm = function () {
        self.formData = null;
        self.fiMaLoai(null);
        self.fiTenLoai(null);
        self.fiTenTep(null);
        document.getElementById("fiTep").value = "";
        self.fileErrors.showAllMessages(false);
    };

    self.bXoaClick = function (item, e) {
        //console.log("fileDinhKem::bXoaClick");
        if (confirm("Bạn có muốn xóa tệp đính kèm")) {
            if (item) {
                self.lstDinhkem10.remove(function (f) {
                    return f.fiIdDinhkem() == item.fiIdDinhkem();
                });
            }
        }
    };

    self.getLstDinhkem10AsJson = function () {
        var jsonList = ko.toJS(self.lstDinhkem10());
        if (jsonList.length > 0) {
            for (var i = 0; i < jsonList.length; i++) {
                delete jsonList[i]["STT"];
                delete jsonList[i]["bXoa"];
                delete jsonList[i]["downloadUrl"];
                delete jsonList[i]["viewUrl"];
            }
        }
        return jsonList;
    };

    self.updateFiIdHoso = function (id) {
        self.fiIdHoso(id);
    };

    self.fiIdHoso = ko.observable(options.fiIdHoso);

    self.fiMaLoai = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true}
    });
    self.fiTenLoai = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTep = ko.observable(null).extend({
        required: {message: 'Phải nhập', params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaLoaiList = ko.observableArray([]);

    var hoso = options && options.hoso ? options.hoso : {};
    self.lstDinhkem10 = ko.observableArray(hoso && hoso.lstDinhkem10 ? mapTbddinhkem10(hoso.lstDinhkem10) : null);
    var fileVG = self;
    self.fileErrors = ko.validation.group(fileVG, {deep: true, live: true, observable: true});

    getCategory("DINHKEM", null, function (res) {
        if (res.success) {
            if (res.data && res.data.length > 0) {
                self.fiMaLoaiList(mapCategory(res.data, "attachtypecode", "attachtypename"));
            } else {
                self.fiMaLoaiList([new Category(0, 'Giấy chứng nhận kiểm dịch của nước xuất khẩu'), new Category(1, 'Tài liệu khác'), new Category(2, 'Mẫu 14a'), new Category(3, 'Mẫu 14b')]);
            }
        } else {
            self.fiMaLoaiList([new Category(0, 'Giấy chứng nhận kiểm dịch của nước xuất khẩu'), new Category(1, 'Tài liệu khác'), new Category(2, 'Mẫu 14a'), new Category(3, 'Mẫu 14b')]);
        }
    });
}
;
