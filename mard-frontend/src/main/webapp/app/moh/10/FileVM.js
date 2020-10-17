/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiMaTep() == null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fiMaTep() != null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fiMaTep() != null;
    }, this);

    self.downloadUrl = ko.computed(function () {
        return self.fiDuongDan();
    }, this);
    
    self.doUpload = function (item, e) {
        
        var upData = {frameId: frameId, maTaiLieu: self.fiLoaiTep(), tenTaiLieu: self.fiTenLoaiTep()};
       
        app.makePost({
            url: "/moh/10/upload/key",
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

function mapFilesVM(data, idHoso, formVM, frameId) {    
    return ko.utils.arrayMap(data, function (item, index) {        
        return new File(item, idHoso, formVM, frameId);
    });
}

function mapTbddinhkem10(data, idHoso, formVM, frameId) {
    return ko.utils.arrayMap(data, function (item, index) {        
        return new File(item, idHoso, formVM, frameId);
    });
}

function FileVM(options, formVM){
    var self = this;
    
    self.lstDinhKems = ko.observableArray([]);
    
    if (options && options.fiIdHoso > 0) {
        self.lstDinhKems(mapTbddinhkem10(options.hoso.lstDinhKems, options.fiIdHoso, formVM, 'frame1'));
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
    
    self.isVaild = function(){
        var isSuccess = true;
        var len = self.lstDinhKems().length;
        for(var i = 0; i <= len - 1; i++ ) {
            if(self.lstDinhKems()[i].isRequire() && (!self.lstDinhKems()[i].fiMaTep()
                    || !self.lstDinhKems()[i].fiTenTep()
                    || !self.lstDinhKems()[i].fiDuongDan())) {
                isSuccess = false;
                break;
            }
        }  
        return isSuccess;
    };
    
    self.toJSON = function(){
        var len = self.lstDinhKems().length;
        var d = [];
        for(var i = 0; i <= len - 1; i++ ) {
            var item = self.lstDinhKems()[i];
            d.push({
                fiIdDinhKem: item.fiIdDinhKem(),
                fiIdDt: item.fiIdDt(),
                fiLoaiDt: item.fiLoaiDt(),
                fiMaTep: item.fiMaTep(),
                fiLoaiTep: item.fiLoaiTep(),
                fiTenTep: item.fiTenTep(),
                fiTenLoaiTep: item.fiTenLoaiTep(),
                fiDuongDan: item.fiDuongDan(),
                fiPathLocal: item.fiPathLocal(),
                fiGuiId: item.fiGuiId()                
            });
        }
        return d;
    };
}


