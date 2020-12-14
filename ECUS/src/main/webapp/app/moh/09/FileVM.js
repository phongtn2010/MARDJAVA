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

function File(item, formVM, index) {
    var self = this;
    self.fiStt = ko.observable((item !== null && item.hasOwnProperty('fiStt')) ? item.fiStt : index);
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

    self.files = ko.observableArray([]);
    

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiMaTep() == null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fiMaTep() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fiMaTep() !== null;
    }, this);

    self.downloadUrl = ko.computed(function () {
        return self.fiDuongDan();
    }, this);

    var eventMethod = window.addEventListener
            ? "addEventListener"
            : "attachEvent";
    var eventer = window[eventMethod];
    var messageEvent = eventMethod == "attachEvent"
            ? "onmessage"
            : "message";

    var lstTemp = [];

    eventer(messageEvent, function (e) {
        if (null !== e.data) {
            lstTemp.push(JSON.parse(e.data));
        }
    });

    self.doUpload = function (item, e) {
        lstTemp = [];

        var url = uploadUrl + self.fiLoaiTep();
        var popup = app.popup({
            title: 'Upload file đính kèm',
            html: '<iframe frameborder="0" id="fileUploadIframe" scrolling="no" width="100%" height="250" />',
            width: 1000,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (null == lstTemp) {
                            app.Alert('Bạn phải upload ít nhất là một file đính kèm trước khi nhấn lưu.');
                            return;
                        } else {
                            for (var i = 0; i < lstTemp.length; i++) {
                                var o = new UrlItem({
                                    'fiDuongDan': lstTemp[i].attachPath,
                                    'fiMaTep': lstTemp[i].attachNswId,
                                    'fiTenTep': lstTemp[i].attachName
                                });
                                self.files.push(o);
                            }
                            if(lstTemp.length > 0) {
                                self.fiTenTep(lstTemp[0].attachName);
                                self.fiDuongDan(lstTemp[0].attachPath);
                                self.fiMaTep(lstTemp[0].attachNswId);
                            }

                            app.popupRemove(popup.selector);
                        }
                    }
                }
            ]
        }, function () {
            $("#fileUploadIframe").attr("src", url);
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
                        self.fiTenTep(null);
                        self.fiDuongDan(null);
                        self.fiMaTep(null);
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
}

function mapFilesVM(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new File(item, formVM, index);
    });
}

function mapTbddinhkem9(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new File(item, formVM, index);
    });
}

function FileVM(options, formVM) {
    var self = this;

    self.lstDinhKems = ko.observableArray([]);
    self.lstGroupDinhKems = ko.observableArray([]);

    if (options && options.fiIdHoso > 0) {
        self.lstDinhKems(mapTbddinhkem9(options.hoso.lstDinhKems, formVM));
    } else {
        var listFiles = [];
        $(options.lstDinhKems).each(function (i, item) {
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
        self.lstDinhKems(mapFilesVM(listFiles, formVM));
    }

    //group file attachment
    var len = self.lstDinhKems().length;
    for (var i = 0; i < len; i++) {
        var item = self.lstDinhKems()[i];
        var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function (el) {
            return el.fiLoaiTep() == item.fiLoaiTep();
        });

        if (idx < 0) {
            if (null != item.fiDuongDan()) {
                item.files.push(new UrlItem({
                    'fiDuongDan': item.fiDuongDan(),
                    'fiMaTep': item.fiMaTep(),
                    'fiTenTep': item.fiTenTep()}));
            }
            self.lstGroupDinhKems.push(item);
        } else {
            var file = self.lstGroupDinhKems()[idx];
            if (null != item.fiDuongDan()) {
                file.files.push(new UrlItem({
                    'fiDuongDan': item.fiDuongDan(),
                    'fiMaTep': item.fiMaTep(),
                    'fiTenTep': item.fiTenTep()}));
            }
        }
    }
    
    //console.log(self.lstGroupDinhKems());

    self.isVaild = function () {
        var isSuccess = true;
        var len = self.lstDinhKems().length;
        for (var i = 0; i <= len - 1; i++) {
            if (self.lstDinhKems()[i].isRequire() && (!self.lstDinhKems()[i].fiMaTep()
                    || !self.lstDinhKems()[i].fiTenTep()
                    || !self.lstDinhKems()[i].fiDuongDan())) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    };

    self.toJSON = function () {
        var len = self.lstDinhKems().length;
        var d = [];
        
        var model = ko.toJS(self);

        var cloneObject = function (obj) {
            var o = {};

            o.fiIdDinhKem = obj.fiIdDinhKem;
            o.fiIdHoso = obj.fiIdHoso;
            o.fiLoaiTep = obj.fiLoaiTep;
            o.fiTenLoaiTep = obj.fiTenLoaiTep;
            o.fiMaTep = null;
            o.fiTenTep = null;
            o.fiDuongDan = null;
            o.fiHoatdong = 1;
            o.fiNguoitao = obj.fiNguoitao;

            o.fiPathLocal = null;
            o.fiGuiid = null;

            return o;
        };
        
        for (var i = 0; i < len; i++) {
            delete model.lstGroupDinhKems[i]['canUpload'];
            delete model.lstGroupDinhKems[i]['canDownload'];
            delete model.lstGroupDinhKems[i]['canDelete'];
            delete model.lstGroupDinhKems[i]['doUpload'];
            delete model.lstGroupDinhKems[i]['doDelete'];
            delete model.lstGroupDinhKems[i]['downloadUrl'];
            delete model.lstGroupDinhKems[i]['fiBatBuoc'];
            delete model.lstGroupDinhKems[i]['isRequire'];
            delete model.lstGroupDinhKems[i]['__ko_mapping__'];
            var t = model.lstGroupDinhKems[i];
            
            if (null !== t.files && t.files.length > 0) {
                for (var j = 0; j < t.files.length; j++) {
                    var o = cloneObject(model.lstGroupDinhKems[i]);
                    
                    o.fiMaTep = t.files[j].fiMaTep;
                    o.fiTenTep = t.files[j].fiTenTep;
                    o.fiDuongDan = t.files[j].fiDuongDan;

                    d.push(o);
                }
            } else {
                var f = cloneObject(model.lstGroupDinhKems[i]);
                d.push(f);
            }
        }
        //console.log(d);
        return d;
    };
}


