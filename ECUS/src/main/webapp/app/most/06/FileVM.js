/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, maHoSo) {
    var self = this;

    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiIdHoso = ko.observable((item !== null && item.hasOwnProperty('fiIdHoso')) ? item.fiIdHoso : null);
    self.fiIdTailieu = ko.observable((item !== null && item.hasOwnProperty('fiIdTailieu')) ? item.fiIdTailieu : null);
    self.fiGhichu = ko.observable((item !== null && item.hasOwnProperty('fiGhichu')) ? item.fiGhichu : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiDuongDan = ko.observable((item !== null && item.hasOwnProperty('fiDuongDan')) ? item.fiDuongDan : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);
    self.fiMaTailieu = ko.observable((item !== null && item.hasOwnProperty('fiMaTailieu')) ? item.fiMaTailieu : null);
    self.fiTenTailieu = ko.observable((item !== null && item.hasOwnProperty('fiTenTailieu')) ? item.fiTenTailieu : null);
    self.fiNoidung = ko.observable((item !== null && item.hasOwnProperty('fiNoidung')) ? item.fiNoidung : null);
    self.fiGuiid = ko.observable((item !== null && item.hasOwnProperty('fiGuiid')) ? item.fiGuiid : null);
    self.fiBatBuoc = ko.observable((item !== null && item.hasOwnProperty('fiBatBuoc')) ? item.fiBatBuoc : null);
  
    if (maHoSo != null && DINHKEMDATA != null) {
        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fiMaTailieu == DINHKEMDATA[i].fiMaTailieu) {
                self.fiBatBuoc(DINHKEMDATA[i].fiBatBuoc);
                break;
            }
        }
    }

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiTenTep() === null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fiTenTep() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fiTenTep() !== null;
    }, this);


    self.doUpload = function (item, e) {
        $('#loading10').show();

        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var dt = new Date();
        var y = dt.getFullYear();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);

        app.makePost({
            url: '/most/p05/gettoken',
            data: JSON.stringify({}),
            success: function (d) {
                (d);
                postFile(files, e, d.data.token);
            },
            error: function (e) {
                app.Alert('Lỗi Server: ko lấy được token');
            }
        });
    }

    // upload file
    var postFile = function (files, e, token) {
        (token);
        var fd = new FormData();
        fd.append("file", files[0]);
        fd.append("token", token);
        fd.append("loai_tep_tin", self.fiMaTailieu());
        fd.append("ten_loai_tep", self.fiTenTailieu());
        //Check validate file
        if (!Util.uploadFileNameValidate(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        //no remove this line
//        url: 'http://nsw.varans.vn/api/ApiUpload/UploadFiles',
        e.target.value = '';
        $.ajax({
            type: 'POST',
            url: 'https://vietesoft.com/api/ApiUpload/UploadFiles',
            data: fd,
            dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            complete: function (e, x, s) {
                $('#loading10').hide();
                var data = JSON.parse(e.responseText);
                if (data.data) {
                    var fileInfo = data.data[0];
                    console.log(fileInfo);
                    self.fiIdTailieu(fileInfo.id);
                    self.fiTenTep(fileInfo.name);
                    self.fiDuongDan(fileInfo.url);
                } else {
                    debugger;
                    app.Alert('Lỗi Service: Không thể upload được file đính kèm');
                    return;
                }
            },
            error: function (j, t, e) {
                $('#loading10').hide();
                debugger;
//                app.Alert('Lỗi Service: Không thể upload được file đính kèm');

                return;
            }
        });
    }
    self.doDelete = function (item, e) {
        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của file này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.fiGuiid(null);
                        self.fiTenTep(null);
                        self.fiDuongDan(null);
                        self.fiIdHoso(null);
                        app.popupRemove(pop.selector);
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(pop.selector);
                    }
                }
            ]
        });
        return;
    };

}
function mapFilesVM(data, maHoSo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, maHoSo);
    });
}



