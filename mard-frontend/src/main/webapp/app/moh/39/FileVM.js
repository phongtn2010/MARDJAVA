/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso, formVM) {
    var self = this;
    
    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiIdHoso = ko.observable((item !== null && item.hasOwnProperty('fiIdHoso')) ? item.fiIdHoso : null);
    self.fiLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiLoaiTep')) ? item.fiLoaiTep : null);
    self.fiTenLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTep')) ? item.fiTenLoaiTep : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiDuongDanTep = ko.observable((item !== null && item.hasOwnProperty('fiDuongDanTep')) ? item.fiDuongDanTep : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);

    self.fiGuiid = ko.observable((item !== null && item.hasOwnProperty('fiGuiid')) ? item.fiGuiid : null);
    self.fiDuongDan = ko.observable((item !== null && item.hasOwnProperty('fiDuongDan')) ? item.fiDuongDan : null);
    self.fiNoidung = ko.observable((item !== null && item.hasOwnProperty('fiNoidung')) ? item.fiNoidung : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);

    self.fiBatBuoc = ko.observable((item !== null && item.hasOwnProperty('fiBatBuoc')) ? item.fiBatBuoc : false);
    self.files = ko.observableArray();
    if (idHoso > 0) {
        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fiLoaiTep === DINHKEMDATA[i].fiLoaiTep) {
                self.fiBatBuoc(DINHKEMDATA[i].fiBatBuoc);
                break;
            }
        }
    }

    self.isRequire = ko.computed(function () {
        return (self.fiBatBuoc() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (null === self.files() || (null !== self.files() && self.files().length === 0));
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

    var eventMethod = window.addEventListener
            ? "addEventListener"
            : "attachEvent";
    var eventer = window[eventMethod];
    var messageEvent = eventMethod === "attachEvent"
            ? "onmessage"
            : "message";
    
    var lstTemp = null;    
    
    eventer(messageEvent, function (e) {
        if (null !== e.data) {
            lstTemp = JSON.parse(e.data);
        }        
    });
    
    
    self.doUpload = function (item, e) {
        lstTemp = null;     
        
        if(!formVM.fiMaTinh()) {
            app.Alert('Bạn phải chọn Tỉnh/Thành phố trước khi thực hiện upload file.');
            return;
        }
        
        var url = uploadUrl + '/haiquan/uploadfile/' + formVM.fiNguoitao() + '/' + formVM.fiMaTinh()+ '/' + self.fiLoaiTep();
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
                            //console.log(lstTemp);  
                            if(null == lstTemp) {
                                app.Alert('Bạn phải upload ít nhất là một file đính kèm trước khi nhấn lưu.');
                                return;
                            } else {
                                for (var i = 0; i < lstTemp.length; i++) {
                                    self.files.push(new UrlItem(lstTemp[i]));
                                }
                                self.fiTenTep(lstTemp[0]);
                                self.fiDuongDan(lstTemp[0]);
                                self.fiDuongDanTep(lstTemp[0]);
                                self.fiIdHoso(idHoso);
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
                        self.fiGuiid(null);
                        self.fiTenTep(null);
                        self.fiDuongDan(null);
                        self.files([]);
                        //formVM.deleteFile(self.fiLoaiTep());
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

function mapFilesVM(data, idHoso, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM({
            'fiIdDk': -1 * new Date().getTime(), 
            'fiLoaiTep': item.fiMaTailieu, 
            'fiTenLoaiTep': item.fiTenTailieu,   
            'fiBatBuoc': item.fiBatBuoc
        }, idHoso, formVM);
    });
}

function mapTbdhsFile39(data, idHoso, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, idHoso, formVM);
    });
}

function UrlItem(d){
    var self = this;
    self.Url = ko.observable(d);
}


