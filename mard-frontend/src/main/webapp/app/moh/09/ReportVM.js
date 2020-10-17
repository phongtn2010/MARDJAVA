/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Attachment(d){
    var self = this;
    self.index = -1 * new Date().getTime();
    self.fiMaTep = ko.observable(d ? d.fiMaTep : null);
    self.fiTenTep = ko.observable(d ? d.fiTenTep : null);
    self.fiLoaiTep = ko.observable(d ? d.fiLoaiTep : null);
    self.fiTenLoaiTep = ko.observable(d ? d.fiTenLoaiTep : null);
    self.fiDuongDan = ko.observable(d ? d.fiDuongDan : null);
}

function ReportVM(data) {
    var self = this;
    
    var loaiTepDinhKem = 9;
    
    self.fiIdBaocao = ko.observable(null);
    self.fiIdHoso = ko.observable(data.hasOwnProperty('fiIdHoso') ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data.hasOwnProperty('fiMaHoso') ? data.fiMaHoso : null);
    self.fiNoidung = ko.observable(null);
    self.fiHoatdong = ko.observable(1);
    
    self.lstDinhKems = ko.observableArray([]);

    self.removeAttach = function (item, e) {
        self.lstDinhKems.remove(function (o) {
            return o.index() == item.index();
        });
    };
    
    self.sendReport = function (onSuccess, onFail) {
        if (self.lstDinhKems().length <= 0) {
            app.Alert('Tệp nội dung báo cáo phải được tải lên!');
            return;
        }
        
        var attach = ko.toJS(self.lstDinhKems());
        
        var report = {
            fiIdBaocao: -1 * new Date().getTime(),
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso(),
            fiNoidung: self.fiNoidung(),
            fiHoatdong: self.fiHoatdong(),
            lstDinhKems: attach
        };
        
        app.makePost({
            url: '/moh/09/send-report',
            data: JSON.stringify(report),
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
            
    var lstTemp = [];

    eventer(messageEvent, function (e) {
        if (null !== e.data) {
            lstTemp.push(JSON.parse(e.data));
        }
    });

    self.doUpload = function () {
        lstTemp = [];
        
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
                        if (null == lstTemp || lstTemp.length <= 0) {
                            app.Alert('Bạn phải upload ít nhất là một file đính kèm trước khi nhấn lưu.');
                            return;
                        } else {
                            var len = lstTemp.length;
                            for (var i = 0; i < len; i++) {
                                var attach = new Attachment({
                                    'fiMaTep': lstTemp[i].attachNswId,
                                    'fiTenTep': lstTemp[i].attachName,
                                    'fiDuongDan': lstTemp[i].attachPath,
                                    'fiLoaiTep': loaiTepDinhKem,
                                    'fiTenLoaiTep': 'Báo cáo xử lý lô hàng không đạt'
                                });
                                self.lstDinhKems.push(attach);
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
}



