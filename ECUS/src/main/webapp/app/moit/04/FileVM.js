/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso) {
    var self = this;

    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiIdHoso = ko.observable((item !== null && item.hasOwnProperty('fiIdHoso')) ? item.fiIdHoso : null);
    self.fiIdTailieu = ko.observable((item !== null && item.hasOwnProperty('fiIdTailieu')) ? item.fiIdTailieu : null);
    self.fiLoaiTlieu = ko.observable((item !== null && item.hasOwnProperty('fiLoaiTlieu')) ? item.fiLoaiTlieu : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiNoidung = ko.observable((item !== null && item.hasOwnProperty('fiNoidung')) ? item.fiNoidung : null);
    self.fiDuongDan = ko.observable((item !== null && item.hasOwnProperty('fiDuongDan')) ? item.fiDuongDan : null);
    self.fiGuiid = ko.observable((item !== null && item.hasOwnProperty('fiGuiid')) ? item.fiGuiid : null);

    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);

    self.fiTenLoaiTl = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTl')) ? item.fiTenLoaiTl : null);
    self.fiBatBuoc = ko.observable((item !== null && item.hasOwnProperty('fiBatBuoc')) ? item.fiBatBuoc : null);

    if (idHoso > 0) {
        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fiLoaiTlieu === DINHKEMDATA[i].fiLoaiTlieu) {
                self.fiBatBuoc(DINHKEMDATA[i].fiBatBuoc);
                break;
            }
        }
    }

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiTenTep() == null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fiTenTep() != null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fiTenTep() != null;
    }, this);

    self.downloadUrl = ko.computed(function () {
        if (self.fiTenTep()) {
            if (self.fiIdHoso() == null) {
                return app.appContext + '/moit/04/file/moit/04/' + self.fiGuiid();
            } else {
                return app.appContext + '/moit/04/download/' + self.fiGuiid() + '/' + self.fiIdDk();
            }
        }
        return null;
    }, this);

    self.doUpload = function (item, e) {

        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var fd = new FormData();
        fd.append("file", files[0]);
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

        if (!Util.validateAttachByFile(files[0])) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        var cb = function (d) {
            var data = d.data;
            if (d.success) {
                item.fiGuiid(data.fileCode);
                item.fiTenTep(data.fileName);
                item.fiDuongDan(data.filePath);
                item.fiIdHoso(idHoso);
            } else {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: data.message,
                    function: 'success'
                });
            }
        };

        app.uploadFile({
            file: files[0],
            mcode: 'moit',
            pcode: '04',
            url: '/moit/04/upload',
            success: function (d) {
                e.target.value = '';
                cb(d);
            },
            error: function (e) {
                
            }
        });
    };
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

function mapFilesVM(data, idHoso) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, idHoso);
    });
}


