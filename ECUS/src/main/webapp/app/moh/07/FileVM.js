/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function arrayFirstIndexOf(array, predicate, predicateOwner) {
    for (var i = 0, j = array.length; i < j; i++) {
        if (predicate.call(predicateOwner, array[i])) {
            return i;
        }
    }
    return -1;
}

function UrlItem(d) {
    var self = this;
    self.fiTenTep = ko.observable(d.fiTenTep);
    self.fiDuongDan = ko.observable(d.fiDuongDan);
    self.fiMaTep = ko.observable(d.fiMaTep);
}

function File(item, idHoso, formVM, frameId) {
    var self = this;

    self.fiIdDinhKem = ko.observable((item !== null && item.hasOwnProperty('fiIdDinhKem')) ? item.fiIdDinhKem : null);
    self.fiIdDt = ko.observable((item !== null && item.hasOwnProperty('fiIdDt')) ? item.fiIdDt : null);
    self.fiLoaiDt = ko.observable((item !== null && item.hasOwnProperty('fiLoaiDt')) ? item.fiLoaiDt : null);
    self.fiMaTep = ko.observable((item !== null && item.hasOwnProperty('fiMaTep')) ? item.fiMaTep : null);
    self.fiLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiLoaiTep : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiTenLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTep')) ? item.fiTenLoaiTep : null);
    self.fiDuongDan = ko.observable((item !== null && item.hasOwnProperty('fiDuongDan')) ? item.fiDuongDan : null);
    self.fiPathLocal = ko.observable((item !== null && item.hasOwnProperty('fiPathLocal')) ? item.fiPathLocal : null);
    self.fiGuiId = ko.observable((item !== null && item.hasOwnProperty('fiGuiId')) ? item.fiGuiId : null);

    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);
    self.fiBatBuoc = ko.observable((item !== null && item.hasOwnProperty('fiBatBuoc')) ? item.fiBatBuoc : false);

    self.files = ko.observableArray();

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return true;
    }, this);

    self.canDownload = ko.computed(function () {
        return null !== self.files() && self.files().length > 0;
    }, this);

    self.canDelete = ko.computed(function () {
        return null !== self.files() && self.files().length > 0;
    }, this);

    self.downloadUrl = ko.computed(function () {
        return self.fiDuongDan();
    }, this);

    self.doUpload = function (item, e) {
        var upData = {frameId: frameId, maTaiLieu: self.fiLoaiTep(), tenTaiLieu: self.fiTenLoaiTep()};
        app.makePost({
            url: "/moh/07/upload/key",
            data: JSON.stringify(upData),
            success: function (d) {
                formVM.currentAttach = item;
                $("#frame1").attr("src", uploadUrl + encodeURIComponent(d) + "?t=" + (new Date()).getTime());
                $("#dialog").dialog({modal: true, width: 640, height: 300});
            },
            error: function (d) {
                if (d != null && d.length > 0) {
                    formVM.currentAttach = item;
                    $("#frame1").attr("src", uploadUrl + encodeURIComponent(d) + "?t=" + (new Date()).getTime());
                    $("#dialog").dialog({modal: true, width: 640, height: 300});
                }
            }
        });
    };

    self.doDelete = function (item, e) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của file này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.fiMaTep(null);
                        self.fiTenTep(null);
                        self.fiDuongDan(null);
                        self.files([]);
                        app.popupRemove(popConfirm.selector);
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(popConfirm.selector);
                    }
                }
            ]
        });
        return;
    };

    self.showMe = ko.computed(function () {
        //TODO: them id can hien thi tu Quan
        return formVM.fiQtxlNhanh() == '1' && formVM.fiMaThutuc() == PROCEDUCE.MOH_07;
    }, this);
}

function mapFilesVM(data, idHoso, formVM, frameId) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new File(item, idHoso, formVM, frameId);
    });
}

function mapTbddinhkem7(data, idHoso, formVM, frameId) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new File(item, idHoso, formVM, frameId);
    });
}

function FileVM(options, formVM) {
    var self = this;

    self.lstDinhKems = ko.observableArray([]);
    self.lstGroupDinhKems = ko.observableArray([]);

    if (options && options.fiIdHoso > 0) {
        self.lstDinhKems(mapTbddinhkem7(options.hoso.lstDinhKems, options.fiIdHoso, formVM, 'frame1'));
    } else {
        var listFiles = [];
        $(options.lstDinhKems).each(function (index, item) {
            var pItem = {
                fiIdDinhKem: null,
                fiIdDt: null,
                fiLoaiDt: null,
                fiLoaiTep: item.fiMaTailieu,
                fiTenLoaiTep: item.fiTenTailieu,
                fiMaTep: null,
                fiTenTep: null,
                fiDuongDan: null,
                fiPathLocal: null,
                fiGuiId: null,
                fiBatBuoc: item.fiBatBuoc
            };
            listFiles.push(pItem);
        });
        self.lstDinhKems(mapFilesVM(listFiles, null, formVM, 'frame1'));
    }

    //group file attachment
    var len = self.lstDinhKems().length;

    for (var i = 0; i < len; i++) {
        var item = self.lstDinhKems()[i];
        var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function (el) {
            return el.fiLoaiTep() === item.fiLoaiTep();
        });

        if (idx < 0) {
            if (null !== item.fiDuongDan()) {
                item.files.push(new UrlItem({
                    fiTenTep: item.fiTenTep(),
                    fiDuongDan: item.fiDuongDan(),
                    fiMaTep: item.fiMaTep()
                }));
            }
            self.lstGroupDinhKems.push(item);
        } else {
            var exitItem = self.lstGroupDinhKems()[idx];
            if (null !== item.fiDuongDan()) {
                exitItem.files.push(new UrlItem({
                    fiTenTep: item.fiTenTep(),
                    fiDuongDan: item.fiDuongDan(),
                    fiMaTep: item.fiMaTep()
                }));
            }
        }
        
    }

    self.refreshFileType = function () {
        self.lstGroupDinhKems([]);
        
        var len = self.lstDinhKems().length;
        for (var i = 0; i < len; i++) {
            var item = self.lstDinhKems()[i];
            var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function (el) {
                return el.fiLoaiTep() === item.fiLoaiTep();
            });

            if (idx < 0) {
                if (null !== item.fiDuongDan()) {
                    item.files.push(new UrlItem({
                        fiTenTep: item.fiTenTep(),
                        fiDuongDan: item.fiDuongDan(),
                        fiMaTep: item.fiMaTep()
                    }));
                }
                self.lstGroupDinhKems.push(item);
            } else {
                var exitItem = self.lstGroupDinhKems()[idx];
                if (null !== item.fiDuongDan()) {
                    exitItem.files.push(new UrlItem({
                        fiTenTep: item.fiTenTep(),
                        fiDuongDan: item.fiDuongDan(),
                        fiMaTep: item.fiMaTep()
                    }));
                }
            }
        }
    };

    self.updateAfterUpload = function (item, d) {
        var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function (el) {
            return el.fiLoaiTep() === item.fiLoaiTep();
        });

        item.fiTenTep(d.fileName);
        item.fiDuongDan(d.fileURL);
        item.fiMaTep(d.fileId);

        if (idx >= 0) {
            var exitItem = self.lstGroupDinhKems()[idx];
            exitItem.files.push(new UrlItem({
                fiTenTep: d.fileName,
                fiDuongDan: d.fileURL,
                fiMaTep: d.fileId
            }));
        }
    };

    self.isVaild = function () {
        var isSuccess = true;
        var len = self.lstGroupDinhKems().length;
        for (var i = 0; i <= len - 1; i++) {
            if (self.lstGroupDinhKems()[i].isRequire()
                    && self.lstGroupDinhKems()[i].files().length == 0) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    };

    self.toJSON = function () {
        var data = ko.toJS(self);
        var len = data.lstGroupDinhKems.length;
        var d = [];
        var cloneObject = function (obj) {
            var o = {};
            o.fiDuongDan = null;
            o.fiGuiId = null;
            o.fiPathLocal = null;
            o.fiHoatdong = 1;
            o.fiIdDinhKem = obj.fiIdDinhKem;
            o.fiIdDt = obj.fiIdDt;
            o.fiLoaiTep = obj.fiLoaiTep;
            o.fiNguoitao = obj.fiNguoitao;
            o.fiTenLoaiTep = obj.fiTenLoaiTep;
            o.fiTenTep = null;
            return o;
        };

        for (var i = 0; i < len; i++) {
            delete data.lstGroupDinhKems[i]['canUpload'];
            delete data.lstGroupDinhKems[i]['canDownload'];
            delete data.lstGroupDinhKems[i]['canDelete'];
            delete data.lstGroupDinhKems[i]['doUpload'];
            delete data.lstGroupDinhKems[i]['doDelete'];
            delete data.lstGroupDinhKems[i]['downloadUrl'];
            delete data.lstGroupDinhKems[i]['fiBatBuoc'];
            delete data.lstGroupDinhKems[i]['isRequire'];
            delete data.lstGroupDinhKems[i]['__ko_mapping__'];
            var t = data.lstGroupDinhKems[i];
            if (null !== t.files && t.files.length > 0) {
                for (var j = 0; j < t.files.length; j++) {
                    var o = cloneObject(data.lstGroupDinhKems[i]);
                    o.fiTenTep = t.files[j].fiTenTep;
                    o.fiDuongDan = t.files[j].fiDuongDan;
                    o.fiMaTep = t.files[j].fiMaTep;
                    d.push(o);
                }
            } else {
                d.push(t);
            }
        }
        return d;
    };
}


