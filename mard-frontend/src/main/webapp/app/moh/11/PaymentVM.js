/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Payment(data, formVM) {
    var self = this;

    self.fiStt = ko.observable(data.hasOwnProperty('fiStt') ? data.fiStt : 0);
    self.fiIdThanhtoan = ko.observable(data.hasOwnProperty('fiIdThanhtoan') ? data.fiIdThanhtoan : null);
    self.fiIdHoso = ko.observable(data.hasOwnProperty('fiIdHoso') ? data.fiIdHoso : null);
    self.fiNgayNop = ko.observable(data.hasOwnProperty('fiNgayNop') ? new Date(data.fiNgayNop) : null);
    self.fiNguoiNop = ko.observable(data.hasOwnProperty('fiNguoiNop') ? data.fiNguoiNop : null);
    self.fiSdt = ko.observable(data.hasOwnProperty('fiSdt') ? data.fiSdt : null);
    self.fiSoHoadon = ko.observable(data.hasOwnProperty('fiSoHoadon') ? data.fiSoHoadon : null);
    self.fiTongTien = ko.observable(data.hasOwnProperty('fiTongTien') ? data.fiTongTien : null);
    self.fiLoaiPhi = ko.observable(data.hasOwnProperty('fiLoaiPhi') ? data.fiLoaiPhi : null);
    self.fiGhiChu = ko.observable(data.hasOwnProperty('fiGhiChu') ? data.fiGhiChu : null);
    self.fiHoatdong = ko.observable(data.hasOwnProperty('fiHoatdong') ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data.hasOwnProperty('fiNguoitao') ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data.hasOwnProperty('fiNgaytao') ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data.hasOwnProperty('fiNgCapnhat') ? data.fiNgCapnhat : null);

    self.fiNgayNopVn = ko.observable(data.hasOwnProperty('fiNgayNop') ? new Date(data.fiNgayNop).toDayFirstWithTime() : null);
    if (data.hasOwnProperty('fiLoaiPhi')) {
        if (parseInt(data.fiLoaiPhi) == 1) {
            self.fiLoaiPhiText = ko.observable('Nộp mới');
        } else {
            self.fiLoaiPhiText = ko.observable('Bổ sung');
        }
    } else {
        self.fiLoaiPhiText = ko.observable(null);
    }

    var dinhKem = data.hasOwnProperty('lstDinhKems') ? data.lstDinhKems : [];
    self.lstDinhKems = ko.observableArray(dinhKem);
    self.dinhKem = new File(dinhKem.length > 0 ? dinhKem[0] : {}, data.fiIdHoso, formVM);
    self.fileUrl = ko.observable(self.dinhKem.fiDuongDan());
}

function mapTbdhsThanhtoan10(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        item.fiStt = index + 1;
        return new Payment(item, formVM);
    });
}

function PaymentVM(data, formVM) {
    var self = this;

    self.fiIdHoso = ko.observable(null);
    self.fiNgayNop = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiNop = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoHoadon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTongTien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Phải nhập số', params: true},
        maxLength: {message: 'Độ dài tối đa là 10', params: 10}
    });
    self.fiLoaiPhi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiGhiChu = ko.observable(null);
    
    //Attachment Info
    self.fiMaTep = ko.observable(null);
    self.fiTenTep = ko.observable(null);
    self.fiDuongDan = ko.observable(null);
    self.showAttachBtn = ko.computed(function(){
        return null == self.fiMaTep();
    });
    self.showDownload = ko.computed(function(){
        return null != self.fiMaTep();
    });

    var paymentData = data.hasOwnProperty('hoso') ? data.hoso.lstThanhToans : [];
    self.lstThanhToans = ko.observableArray(mapTbdhsThanhtoan10(paymentData, formVM));
    self.lstLoaiPhi = ko.observableArray([{'id': 0, 'name': 'Nộp mới'}, {'id': 1, 'name': 'Nộp bổ sung'}]);

    var paymentVaild = [self.fiNgayNop, self.fiNguoiNop, self.fiSdt, self.fiSoHoadon, self.fiTongTien, self.fiLoaiPhi];
    self.paymentErrors = ko.validation.group(paymentVaild, {deep: true, live: true, observable: true});

    self.toJSON = function () {
        var model = ko.toJS(self);
        var item = null;

        for (var i = 0; i < model.lstThanhToans.length; i++) {
            item = model.lstThanhToans[i];
            delete item['fiNgayNopVn'];
            delete item['fiLoaiPhiText'];
            delete item['fiStt'];
            delete item['fileUrl'];
            delete item['dinhKem'];
            delete item["__ko_mapping__"];
            var files = item.lstDinhKems;
            if(files.length > 0) {                
                delete files[0]['canDelete'];
                delete files[0]['canDownload'];
                delete files[0]['canUpload'];
                delete files[0]['downloadUrl'];
                delete files[0]['fiBatBuoc'];
                delete files[0]['isRequire'];
                delete files[0]["__ko_mapping__"];
            }
        }

        return model.lstThanhToans;
    };
    
    self.isVaild = function(){
        return self.lstThanhToans().length > 0;
    };
    
    self.onDeletePayment = function (item) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của thông tin thanh toán này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstThanhToans.remove(function (o) {
                            return o.fiIdThanhtoan() == item.fiIdThanhtoan();
                        });
                        for (var i = 0; i < self.lstThanhToans().length; i++) {
                            self.lstThanhToans()[i].fiStt(i + 1);
                        }
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

    self.btnSavePaymentClick = function () {
        if (self.paymentErrors().length > 0) {
            self.paymentErrors.showAllMessages();
            return false;
        }
        
        if(null == self.fiMaTep()){
            app.Alert('Chứng từ xác nhận nộp lệ phí phải được tải lên!');
            return;
        }
        
        if(!self.fiNgayNop()) {
            app.Alert('Thông tin ngày nộp phải được cung cấp!');
            return;
        }

        var payment = new Payment({
            fiStt: self.lstThanhToans().length + 1,
            fiIdThanhtoan: -1 * new Date().getTime(),
            fiIdHoso: formVM.fiIdHoso(),
            fiNgayNop: self.fiNgayNop(),
            fiNguoiNop: self.fiNguoiNop(),
            fiSdt: self.fiSdt(),
            fiSoHoadon: self.fiSoHoadon(),
            fiTongTien: self.fiTongTien(),
            fiLoaiPhi: self.fiLoaiPhi(),
            fiGhiChu: self.fiGhiChu(),
            lstDinhKems: [{
                fiMaTep: self.fiMaTep(),
                fiTenTep: self.fiTenTep(),
                fiDuongDan: self.fiDuongDan(),
                fiLoaiTep: "15",
                fiTenLoaiTep: "Hóa đơn thanh toán"
            }]
        }, formVM);

        self.lstThanhToans.push(payment);
        self.clearForm();

    };

    self.clearForm = function () {
        self.fiIdHoso(null);
        self.fiNgayNop(null);
        self.fiNguoiNop(null);
        self.fiSdt(null);
        self.fiSoHoadon(null);
        self.fiTongTien(null);
        self.fiLoaiPhi(null);
        self.fiGhiChu(null);
        self.fiMaTep(null);
        self.fiTenTep(null);
        self.fiDuongDan(null);
        self.paymentErrors.showAllMessages(false);
    };
    
    self.removeAttach = function(){
        self.fiMaTep(null);
        self.fiTenTep(null);
        self.fiDuongDan(null);
    };
    
    self.doUpload = function (item, e) {
        var frameId = "frame2";
        var upload = {frameId: frameId, maTaiLieu: 15, tenTaiLieu: "Hóa đơn thanh toán"};
        var cb = function(d){
            formVM.currentAttach = item;
            //var url = 'http://hanoi.dtt.vn:8234/web/guest/upload/-/nsw/value/';
            $("#frame1").attr("src", uploadUrl + encodeURIComponent(d) + "?t=" + (new Date()).getTime());
            $("#dialog").dialog({modal: true, width: 640, height: 300});
        };
        app.makePost({
            url: "/moh/11/upload/key",
            data: JSON.stringify(upload),
            success: function (data) {
                if (data != null && data.length > 0) {
                    cb(data);
                }
            },
            error: function (data) {
                if (data != null && data.length > 0) {
                    cb(data);
                }
            }
        });
    };
    
    self.updateAfterUpload = function(d){
        self.fiMaTep(d.fileId);
        self.fiTenTep(d.fileName);
        self.fiDuongDan(d.fileURL);
    };
}

