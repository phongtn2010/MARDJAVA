
function ProductVM(d, formVM) {
    var self = this;
    
    var query = app.parseQuerystring();
    
    var loaiFile = '1';
    
    self.isKtChat = ko.computed(function () {
        return query.maThuTuc == 'BYTE0500010';
    }, self);
    
    self.tenPtKt = ko.computed(function () {
        if(query.maThuTuc == 'BYTE0500010')
            return 'Kiểm tra chặt';
        else 
            return 'Kiểm tra thông thường';
    }, self);

    self.fiStt = ko.observable(d.hasOwnProperty('fiStt') ? d.fiStt : 1);
    self.fiIdHanghoa = ko.observable(d.hasOwnProperty('fiIdHanghoa') ? d.fiIdHanghoa : null);
    self.fiIdHoso = ko.observable(d.hasOwnProperty('fiIdHoso') ? d.fiIdHoso : formVM.fiIdHoso());
    self.fiTenHh = ko.observable(d.hasOwnProperty('fiTenHh') ? d.fiTenHh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMaNhomHh = ko.observable(d.hasOwnProperty('fiMaNhomHh') ? d.fiMaNhomHh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenNhomHh = ko.observable(d.hasOwnProperty('fiTenNhomHh') ? d.fiTenNhomHh : null);
    self.fiTenNsx = ko.observable(d.hasOwnProperty('fiTenNsx') ? d.fiTenNsx : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiNsx = ko.observable(d.hasOwnProperty('fiDiachiNsx') ? d.fiDiachiNsx : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiPtkt = ko.observable(self.isKtChat() ? 2 : 1);
    self.fiTenPtkt = ko.observable(NSWLang["moh." + query.maThuTuc + ".phuongthuckt"]);
    self.fiSoVbxnPtkt = ko.observable(d.hasOwnProperty('fiSoVbxnPtkt') ? d.fiSoVbxnPtkt : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isKtChat();
            }
        }        
    });
    self.fiSoCongbo = ko.observable(d.hasOwnProperty('fiSoCongbo') ? d.fiSoCongbo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(formVM.fiNguoitao());

    self.fiMaTep = ko.observable(d.hasOwnProperty('fiMaTep') ? d.fiMaTep : null);
    self.fiDuongDan = ko.observable(d.hasOwnProperty('fiDuongDan') ? d.fiDuongDan : null);
    self.fiTenTep = ko.observable(d.hasOwnProperty('fiTenTep') ? d.fiTenTep : null);
    //console.log(d);
    if (d.hasOwnProperty('dinhKem')) {
        self.fiMaTep(d.dinhKem.fiMaTep);
        self.fiTenTep(d.dinhKem.fiTenTep);
        self.fiDuongDan(d.dinhKem.fiDuongDan);
    }
    
    self.fiIdNguoiTn = ko.observable(d.hasOwnProperty('fiIdNguoiTn') ? d.fiIdNguoiTn : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenNgTn = ko.observable(d.hasOwnProperty('fiTenNgTn') ? d.fiTenNgTn : null);
    
    self.fiMaQgXuatxu = ko.observable(d.hasOwnProperty('fiMaQgXuatxu') ? d.fiMaQgXuatxu : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenQgXuatxu = ko.observable(d.hasOwnProperty('fiTenQgXuatxu') ? d.fiTenQgXuatxu : null);

    self.canUpload = ko.computed(function () {
        return null == self.fiDuongDan();
    });

    self.canDownload = ko.computed(function () {
        return null != self.fiDuongDan();
    });

    var vg = [self.fiTenHh, self.fiMaNhomHh, self.fiTenNsx, 
        self.fiDiachiNsx, self.fiSoCongbo, self.fiDuongDan, self.fiSoVbxnPtkt];
    self.formErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

    self.lstNhomSanPham = ko.observableArray(mapCategory(d.hasOwnProperty('lstNhomSanPham') ? d.lstNhomSanPham : []));
    self.lstNguoiChiuTrachNhiems = ko.observableArray(mapCategory(d.hasOwnProperty('lstNguoiChiuTrachNhiems') 
        ? d.lstNguoiChiuTrachNhiems : [], "fiIdNguoiTn", "fiTenNgTn"));
    self.lstQuocGia = ko.observableArray(mapCategory(d.hasOwnProperty('lstQuocGia') ? d.lstQuocGia : [], "fiMaQg", "fiTenQg"));
    
    self.onFiMaNhomHhChange = function () {
        if (self.fiMaNhomHh()) {

            self.fiTenNhomHh(null);

            var index = self.lstNhomSanPham.firstIndexOf(function (item) {
                return item.id == self.fiMaNhomHh();
            });

            if (index >= 0) {
                self.fiTenNhomHh(self.lstNhomSanPham()[index].name);
            }
        }
    };
    
    self.onFiIdNguoiTnChange = function () {
        if (self.fiIdNguoiTn()) {

            self.fiTenNgTn(null);

            var index = self.lstNguoiChiuTrachNhiems.firstIndexOf(function (item) {
                return item.id == self.fiIdNguoiTn();
            });

            if (index >= 0) {
                self.fiTenNgTn(self.lstNguoiChiuTrachNhiems()[index].name);
            }
        }
    };
    
    self.onFiMaQgXuatxuChange = function () {
        if (self.fiMaQgXuatxu()) {

            self.fiTenQgXuatxu(null);

            var index = self.lstQuocGia.firstIndexOf(function (item) {
                return item.id == self.fiMaQgXuatxu();
            });

            if (index >= 0) {
                self.fiTenQgXuatxu(self.lstQuocGia()[index].name);
            }
        }
    };
    
    var eventMethod = window.addEventListener
            ? "addEventListener"
            : "attachEvent";
    var eventer = window[eventMethod];
    var messageEvent = eventMethod == "attachEvent"
            ? "onmessage"
            : "message";

    var lstTemp = null;

    eventer(messageEvent, function (e) {
        if (null !== e.data) {
            lstTemp = JSON.parse(e.data);
        }
    });

    self.doUpload = function () {
        lstTemp = null;

        var url = uploadUrl + loaiFile;
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
                        if (!self.isVaild()) {
                            return;
                        }
                        if (null == lstTemp) {
                            app.Alert('Bạn phải upload ít nhất là một file đính kèm trước khi nhấn lưu.');
                            return;
                        } else {
                            self.fiDuongDan(lstTemp.attachPath);
                            self.fiMaTep(lstTemp.attachNswId);
                            self.fiTenTep(lstTemp.attachName);
                            app.popupRemove(popup.selector);
                        }
                    }
                }
            ]
        }, function () {
            $("#fileUploadIframe").attr("src", url);
        });
    };

    self.doDelete = function () {
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
                        self.fiDuongDan(null);
                        self.fiMaTep(null);
                        self.fiTenTep(null);
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

    self.isVaild = function () {
        if (self.formErrors().length > 0) {
            self.formErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.toJson = function () {
        return {
            fiIdHanghoa: self.fiIdHanghoa(),
            fiIdHoso: self.fiIdHoso(),
            fiTenHh: self.fiTenHh(),
            fiMaNhomHh: self.fiMaNhomHh(),
            fiTenNhomHh: self.fiTenNhomHh(),
            fiTenNsx: self.fiTenNsx(),
            fiDiachiNsx: self.fiDiachiNsx(),
            fiPtkt: self.fiPtkt(),
            fiSoVbxnPtkt: self.fiSoVbxnPtkt(),
            fiSoCongbo: self.fiSoCongbo(),
            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao(),
            fiIdNguoiTn: self.fiIdNguoiTn(),
            fiTenNgTn: self.fiTenNgTn(),
            fiMaQgXuatxu: self.fiMaQgXuatxu(),
            fiTenQgXuatxu: self.fiTenQgXuatxu(),
            dinhKem: {
                fiIdDt: '',
                fiLoaiDt: '',                
                fiLoaiTep: '1',
                fiTenLoaiTep: 'Bản tự công bố sản phẩm (bao gồm nhãn sản phẩm và bản tiêu chuẩn sản phẩm)',
                fiMaTep: self.fiMaTep(),
                fiTenTep: self.fiTenTep(),
                fiDuongDan: self.fiDuongDan(),
                fiPathLocal: '',
                fiGuiId: ''
            }
        };
    };
}

function mapProductVM(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {   
        item.fiStt = index + 1;
        return new ProductVM(item, formVM);
    });
}