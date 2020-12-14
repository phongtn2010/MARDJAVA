/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */

function Most03FilesVM(options)
{
    var self = this;
    var hoso = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(options.fiIdHoso);

    self.fiMaLoai = ko.observable(null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTep = ko.observable(null);

    self.lstLoaiFile = ko.observableArray([]);
    self.errorDinhkemText = ko.observable("");

    self.tepDinhKems = ko.observableArray(hoso !== null ? ListTbddinhkem3Model(hoso.tepDinhKems) : null);
    var fileVG = [self.fiTenLoai, self.fiMaLoai];
    self.fileErrors = ko.validation.group(fileVG, {deep: true, live: true, observable: true});

    self.formData = null;

    //HAM XU LY
    self.fileUpload = function (data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
        self.fiTenTep(files[0].name);
    };

    self.validateForm = function () {
      
        if(!self.fiMaLoai){
            app.Alert('Bạn chưa chọn loại tệp đính kèm');
            return false;
        }
        if (!self.formData) {
            app.Alert('Bạn chưa chọn tệp đính kèm');
            return false;
        }
        
        if (!Util.validateFieExtensionByDom('fiTep')) {
             return false;
        }
        
        var cloneArray = self.tepDinhKems();
        var maLoaiLst = [];
        for(var i=0; i<cloneArray.length; i++){
            maLoaiLst.push(cloneArray[i].fiMaLoai());
        }
        
        if(maLoaiLst.indexOf(self.fiMaLoai())>-1){
            app.Alert('Mỗi loại tập tin chỉ được nhập 1 file');
            return false;
        }       
       
        if (self.fileErrors().length > 0) {
            self.fileErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.uploadClick = function () {
        if (!self.validateForm()) {
            return;
        }

        var fileIp = $('#fiTep')[0].files[0];
        var fileInfo = {
            fiMaLoai: self.fiMaLoai(),
            fiTenLoai: self.fiTenLoai(),
            fiTenTep: self.fiTenTep(),
            fiIdHoso: self.fiIdHoso() ? self.fiIdHoso() : 0,
            fiFileSize: fileIp.size
        };
        
        var cb = function (d) {
            var data = d.data;
            if (d.success) {
                if (data.filePath != null) {
                    fileInfo.fiMostId = data.filePath;
                    fileInfo.fiIdDinhkem = -1 * new Date().getTime();
                    var item = new Tbddinhkem3(self.tepDinhKems().length + 1, fileInfo);
                    self.tepDinhKems.push(item);
                    self.clearForm();
                } else {
                    app.Alert('Upload không thành công, vui lòng thử lại lần nữa!');
                }
            } else {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: data.message,
                    function: 'success'
                });
            }
        };
                
        app.uploadFile({
            file: fileIp,
            mcode: 'most',
            pcode: '01',
            success: function (d) {
                cb(d);
            },
            error: function (e) {
                console.log(e);
            }
        });
    };

    self.isValidForm = function () {
        return true;
        self.errorDinhkemText("");
        if (!self.tepDinhKems() || self.tepDinhKems().length <= 0) {
            self.errorDinhkemText("* Các loại đính kèm sau bắt buộc phải nhập: Bộ tài liệu kỹ thuật của mẫu; Bộ hồ sơ kết quả thử nghiệm, đánh giá mẫu; Tài liệu về việc xây dựng và áp dụng biện pháp quản lý");
            return false;
        }
        var exist = false;
        var exist_check = [];
        for (var i = 0; i < self.tepDinhKems().length; i++) {
            if (self.tepDinhKems()[i].fiMaLoai() - 1 == 0) {
                exist_check.push(1);
            } else if (self.tepDinhKems()[i].fiMaLoai() - 4 == 0) {
                exist_check.push(1);
            } else if (self.tepDinhKems()[i].fiMaLoai() - 5 == 0) {
                exist_check.push(1);
            }
        }
        var count = 0;
        if (exist_check.length > 0) {
            for (var i = 0; i < exist_check.length; i++) {
                count += exist_check[i];
            }
        }
        exist = count >= 3 ? true : false;        

        if (!exist) {
            self.errorDinhkemText("* Các loại đính kèm sau bắt buộc phải nhập: Bộ tài liệu kỹ thuật của mẫu; Bộ hồ sơ kết quả thử nghiệm, đánh giá mẫu; Tài liệu về việc xây dựng và áp dụng biện pháp quản lý");
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
        if (confirm("Bạn có muốn xóa tệp đính kèm")) {
            if (item) {
                self.tepDinhKems.remove(function (f) {
                    return f.fiIdDinhkem() === item.fiIdDinhkem();
                });
            }
        }
    };

    self.toJSON = function () {
        var jsonList = ko.toJS(self.tepDinhKems());
        if (jsonList.length > 0) {
            for (var i = 0; i < jsonList.length; i++) {
                delete jsonList[i]["bXoa"];
                delete jsonList[i]["downloadUrl"];
                delete jsonList[i]['__ko_mapping__'];
            }
        }
        return jsonList;
    };

    self.updateFiIdHoso = function (id) {
        self.fiIdHoso(id);
    };

    //DANH MUC
    //Lay danh muc Loai file dinh kem
    app.getCategory('/most/03/danhmuc', 'DM_LOAIFILE', null, function (res) {
        if (res.success) {
            self.lstLoaiFile(res.data);
        } else {
            self.lstLoaiFile([]);
        }
    });
}
;
