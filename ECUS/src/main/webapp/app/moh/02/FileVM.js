/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso) {
    var self = this;
    self.fiIdHoso = ko.observable((item !== null && item.hasOwnProperty('fiIdHoso')) ? item.fiIdHoso : null);
    if (idHoso !== null) {
        self.fiLoaiTailieu = ko.observable((item !== null && item.hasOwnProperty('fiLoaiTailieu')) ? item.fiLoaiTailieu : null);
    } else {
        self.fiLoaiTailieu = ko.observable((item !== null && item.hasOwnProperty('fiLoaiTl')) ? item.fiLoaiTl : null);
    }
    self.fiTenLoaiTl = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTl')) ? item.fiTenLoaiTl : null);
    self.fiTenTailieu = ko.observable((item !== null && item.hasOwnProperty('fiTenTailieu')) ? item.fiTenTailieu : null);
    self.fiBatbuoc = ko.observable((item !== null && item.hasOwnProperty('fiBatBuoc')) ? item.fiBatBuoc : null);

    self.fiIdDinhkem = ko.observable((item !== null && item.hasOwnProperty('fiIdDinhkem')) ? item.fiIdDinhkem : null);
    self.fiDuongdanTl = ko.observable((item !== null && item.hasOwnProperty('fiDuongdanTl')) ? item.fiDuongdanTl : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);
    self.fiSize = ko.observable((item !== null && item.hasOwnProperty('fiSize')) ? item.fiSize : null);

    self.lstFiles = ko.observableArray((item !== null && item.hasOwnProperty('lstFiles')) ? item.lstFiles : []);

    if (DINHKEMDATA != null) {
        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fiLoaiTailieu == DINHKEMDATA[i].fiLoaiTl) {
                self.fiBatbuoc(DINHKEMDATA[i].fiBatBuoc);
                break;
            }
        }
    }
    self.isRequire = ko.computed(function () {
        return (self.fiBatbuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiTenTailieu() === null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fiTenTailieu() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.lstFiles().length > 0;
    }, this);

    self.downloadUrl = ko.computed(function () {
        return self.fiTenTailieu() !== null;
    }, this);

    self.doUpload = function (item, e) {
        $('#loading10').show();
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var nSize = parseFloat((files[0].size/1048576).toString());
        var fileSize = Math.round(nSize * 1000)/1000;

        var fd = new FormData();
        fd.append("uploadfile", files[0]);
        fd.append("fiLoaiTailieu", self.fiLoaiTailieu());

        //Check validate file
        if (!Util.uploadFileNameValidate(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        //check name utf8
        if(Util.hasUnicode(files[0].name)){
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        // check maxlength tên file
        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        $.ajax({
            type: 'POST',
            url: BYT.URL_UPLOAD_FILE_DP,
            data: fd,
            dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            cache: false,
            complete: function (data) {
                $('#loading10').hide();
                debugger;
                var rs = JSON.parse(data.responseText);
                if (rs) {
                    var fileObj = {
                        fiTenTailieu:rs.FileName,
                        fiDuongdanTl:BYT.URL_DOWNLOAD_FILE_DP + rs.FileName,
                        fiSize: fileSize
                    }
                    self.lstFiles.push(fileObj);
                    e.target.value = '';
                }
                if (self.isRequire()) {
                    $("#valid_dinhKem").hide();
                }
            },
            error: function (e) {
                $('#loading10').hide();
                return;
            }
        });

    };

    self.doDownloadFileItem = function (item, e) {
        var url = BYT.URL_DOWNLOAD_FILE_DP + item.fiTenTailieu;
        window.open(url, "_blank");
    }

    self.doDeleteFileItem = function(item, e) {
        self.lstFiles(self.lstFiles().filter(obj => obj.fiTenTailieu !== item.fiTenTailieu));
    }

    self.doDelete = function () {
        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của các file này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstFiles([]);
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

function mapFiles02VM(data, idHoso) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, idHoso);
    });
}



