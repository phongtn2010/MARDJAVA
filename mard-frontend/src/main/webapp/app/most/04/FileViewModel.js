/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */

function Most04FilesVM(options)
{
    var self = this;
    var hoso = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    
    self.tepDinhKems = ko.observableArray(hoso !== null ? ListTbddinhkem4Model(hoso.tepDinhKems) : null);
    self.fiMaLoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTep = ko.observable(null);
    self.lstLoaiFile = ko.observableArray([]);
    
    self.errorDinhkemText = ko.observable("");
    var fileVG = [self.fiTenLoai, self.fiMaLoai];
    self.fileErrors = ko.validation.group(fileVG, {deep: true, live: true, observable: true});

    self.formData = null;
    
    //HAM XU LY
    /*
     * Khoi tao du lieu form upload
     * @param {type} data
     * @param {type} e
     * @returns {undefined}
     */
    self.fileUpload = function (data, e) {
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        self.formData = new FormData();
        self.formData.append('file', files[0]);
        self.fiTenTep(files[0].name);
    };
    /*
     * Kiem tra form nhap
     * @returns {Boolean}
     */
    self.validateForm = function () {
        if (self.fileErrors().length > 0) {
            self.fileErrors.showAllMessages();
            return false;
        }
        if (!self.formData) {
            app.Alert('Bạn chưa chọn tệp đính kèm');
            return false;
        }
        return true;
    };

    /*
     * Upload file len he thong Bo KHCN
     * @returns {undefined}
     */
    self.uploadClick = function () {
        if (!self.validateForm()) {
            return;
        }

        var fileIp = $('#fiTep')[0].files[0];
        var fileInfo = {
            fiMaLoaiDk: self.fiMaLoai(),
            fiTenLoaiDk: self.fiTenLoai(),
            fiTenTep: self.fiTenTep(),
            fiFilePath: null,
            fiFileName: null,
            fiIdDt: 0,
            fiIdLoaidt: 0,
            fiHoatdong: 0,
            fiNguoitao: null,
            fiNgaytao: new Date().getTime(),
            fiMaHoso: null
        };
        var cb = function (d) {
            var data = d.data;
            if (d.success) {
                if (data.filePath != null) {
                    fileInfo.fiKhcnId = data.filePath;
                    fileInfo.fiIdDk = -1 * new Date().getTime();
                    var item = new Tbddinhkem4(self.tepDinhKems().length + 1, fileInfo);
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
                //console.log(e);
            }
        });
    };
    /*
     * Kiểm tra điều kiện cho các file bắt buộc phải nhập
     * @returns {Boolean}
     */
    self.isValidForm = function () {
        self.errorDinhkemText("");
        if (!self.tepDinhKems() || self.tepDinhKems().length <= 0) {
            self.errorDinhkemText("* Các loại đính kèm sau bắt buộc phải nhập: Tiêu chuẩn công bố áp dụng; Hồ sơ thương nhân ");
            return false;
        }
        var exist = false;
        var exist_check = [];
        for (var i = 0; i < self.tepDinhKems().length; i++) {
            if (self.tepDinhKems()[i].fiMaLoaiDk() - 1 == 0) {
                exist_check.push(1);
            }
        }
        var count = 0;
        if (exist_check.length > 0) {
            for (var i = 0; i < exist_check.length; i++) {
                count += exist_check[i];
            }
        }
        exist = count >= 1 ? true : false;

        if (!exist) {
            self.errorDinhkemText("* Các loại đính kèm sau bắt buộc phải nhập: Tiêu chuẩn công bố áp dụng; Hồ sơ thương nhân ");
            return false;
        }
        return true;
    };

    /*
     * Reset form
     * @returns {undefined}
     */
    self.clearForm = function () {
        self.formData = null;
        self.fiMaLoai(null);
        self.fiTenLoai(null);
        self.fiTenTep(null);
        document.getElementById("fiTep").value = "";
        self.fileErrors.showAllMessages(false);
    };

    /*
     * Xoa file dinh kem
     */
    self.bXoaClick = function (item, e) {
        if (confirm("Bạn có muốn xóa tệp đính kèm")) {
            if (item) {
                self.tepDinhKems.remove(function (f) {
                    return f.fiIdDk() === item.fiIdDk();
                });
            }
        }
    };

    self.toJSON = function () {
        var jsonList = ko.toJS(self.tepDinhKems());
        if (jsonList.length > 0) {
            for (var i = 0; i < jsonList.length; i++) {
                delete jsonList[i]["bXoa"];
                delete jsonList[i]["stt"];
                delete jsonList[i]["downloadUrl"];
                delete jsonList[i]['__ko_mapping__'];
            }
        }
        return jsonList;
    };
    //DANH MUC
    //Lay danh muc Loai file dinh kem
    app.getCategory('/most/04/danhmuc', 'DM_LOAIFILE', null, function (res) {
        if (res.success) {
            self.lstLoaiFile(res.data);
        } else {
            self.lstLoaiFile([]);
        }
    });
}
;
