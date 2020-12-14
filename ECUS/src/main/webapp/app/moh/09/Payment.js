/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function PaymentVM(data, doc) {
    var self = this;
    
    var loaiTepDinhKem = 5;

    self.fiIdTbPhi = ko.observable(data.hasOwnProperty('fiIdTbPhi') ? data.fiIdTbPhi : null);
    self.fiIdHoso = ko.observable(data.hasOwnProperty('fiIdHoso') ? data.fiIdHoso : null);
    self.fiMaTckt = ko.observable(data.hasOwnProperty('fiMaTckt') ? data.fiMaTckt : null);
    self.fiTenTckt = ko.observable(data.hasOwnProperty('fiTenTckt') ? data.fiTenTckt : null);
    self.fiTongTien = ko.observable(data.hasOwnProperty('fiTongTien') ? data.fiTongTien : null);
    self.fiSoTk = ko.observable(data.hasOwnProperty('fiSoTk') ? data.fiSoTk : null);
    self.fiNganHang = ko.observable(data.hasOwnProperty('fiNganHang') ? data.fiNganHang : null);

    self.fiHoatdong = ko.observable(data.hasOwnProperty('fiHoatdong') ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data.hasOwnProperty('fiNguoitao') ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data.hasOwnProperty('fiNgaytao') ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data.hasOwnProperty('fiNgCapnhat') ? new Date(data.fiNgCapnhat) : null);

    self.fiLoaiTt = ko.observable(data.hasOwnProperty('fiLoaiTt') ? data.fiLoaiTt : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiGhiChu = ko.observable(data.hasOwnProperty('fiGhiChu') ? data.fiGhiChu : null);
    self.lstLoaiThanhToan = ko.observableArray(mapCategory(data.hasOwnProperty('lstLoaiThanhToan') ? data.lstLoaiThanhToan : []));

    self.fiMaTep = ko.observable(null);
    self.fiTenTep = ko.observable(null);
    self.fiDuongDan = ko.observable(null);
    
    self.canUpload = ko.computed(function () {
        return null == self.fiMaTep();
    });

    self.canDownload = ko.computed(function () {
        return null !== self.fiMaTep();
    });
    
    self.showLink = ko.observable(false);
    self.showUpload = ko.observable(false);
    self.keypayLink = ko.observable();
    
    self.onFiMaDvNhanChange = function () {
        
        if (3 == self.fiLoaiTt()) {
            
            var payment = {
                maThuTuc: doc.fiMaThutuc(),
                maHoSo: doc.fiMaHoso()
            };

            app.makePost({
                url: '/moh/09/get-keypay',
                data: JSON.stringify(payment),
                success: function (res) {
                    if (res.success) {
                        self.showLink(true);
                        self.keypayLink(res.data);
                        self.showUpload(false);
                    }
                },
                error: function (e) {}
            });
        } else {
            self.showLink(false);
            self.showUpload(true);
        }
    };
    
    self.removeAttach = ko.computed(function () {
        self.fiMaTep(null);
        self.fiTenTep(null);
        self.fiDuongDan(null);
    });

    var paymentVaild = [self.fiLoaiTt];
    self.paymentErrors = ko.validation.group(paymentVaild, {deep: true, live: true, observable: true});

    self.sendPayment = function (onSuccess, onFail) {
        if (self.paymentErrors().length > 0) {
            self.paymentErrors.showAllMessages();
            return false;
        }

        if (2 == self.fiLoaiTt() && null == self.fiDuongDan()) {
            app.Alert('Chứng từ xác nhận nộp lệ phí phải được tải lên!');
            return;
        }

        var payment = {
            fiIdTtPhi: -1 * new Date().getTime(),
            fiIdHoso: data.fiIdHoso,
            fiLoaiTt: self.fiLoaiTt(),
            fiHoatdong: 1,
            dinhKem: {
                fiMaTep: self.fiMaTep(),
                fiTenTep: self.fiTenTep(),
                fiDuongDan: self.fiDuongDan(),
                fiLoaiTep: loaiTepDinhKem,
                fiTenLoaiTep: "Chứng từ xác nhận nộp phí"
            }
        };
        
        app.makePost({
            url: '/moh/09/send-payment',
            data: JSON.stringify(payment),
            success: function (res) {
                if (onSuccess) {
                    onSuccess();
                }
            },
            error: function (e) { 
                if (onFail) {
                    onFail();
                }
            }
        });
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

        var url = uploadUrl + loaiTepDinhKem;
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
                            self.fiMaTep(lstTemp.attachNswId);
                            self.fiTenTep(lstTemp.attachName);
                            self.fiDuongDan(lstTemp.attachPath);
                            app.popupRemove(popup.selector);
                        }
                    }
                }
            ]
        }, function () {
            $("#fileUploadIframe").attr("src", url);
        });
    };
}

