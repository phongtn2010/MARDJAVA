/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

var DINHKEMDATA = null;
function EditVM(options) {
    self = this;
    self.formVM = ko.validatedObservable(new FormVM(options));
    self.fileVM = ko.validatedObservable(new FileVM(options, self.formVM()));
    self.paymentVM = ko.validatedObservable(new PaymentVM(options, self.formVM()));
    
    self.fiThuTucId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };
    
    self.propTitle = ko.observable(NSWLang["moh_" + options.maThuTuc + "_tenthutuc"]);
    
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI 
                || self.formVM().fiTrangthai() == YC_THANH_TOAN_PHI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI
                || self.formVM().fiTrangthai() == CHO_XAC_NHAN_PHI
                || self.formVM().fiTrangthai() == YC_THANH_TOAN_PHI
                || self.formVM().fiTrangthai() == DA_XAC_NHAN_PHI
                || self.formVM().fiTrangthai() == TU_CHOI_HOSO
                || self.formVM().fiTrangthai() == YC_BO_SUNG) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.formVM().fiSoDkkd(d.data.fiSoDkkd);
            self.formVM().fiLoaihinh(d.data.fiLoaihinh);
        };

        var resultForm = self.formVM().isValidForm();
        if (!resultForm) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        
        var fileIsVaild = self.fileVM().isVaild();
        if(!fileIsVaild){
            app.Alert('File đính kèm cần được cập nhật đầy đủ.');
            return;       
        }
        
        var paymentIsVaild = self.paymentVM().isVaild();
        
        if(!paymentIsVaild){
            app.Alert('Thông tin chứng từ cần được cập nhật đầy đủ.');
            return;       
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();
        
        data.lstThanhToans = self.paymentVM().toJSON();
        data.lstDinhKems = self.fileVM().toJSON();
        //console.log(data);
        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moh/01/hoso/taomoi' : '/moh/01/hoso/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
            }
        });
    };
    
    
    self.verifySignature = function (signature, doc) {
        
        var data = {
            'signatureXml': signature,            
            'messageXml': doc.sign.fiXml,
            'msgFunc': doc.sign.fiFunc,
            'msgType': doc.sign.fiMsgType,
            'documentCode': doc.data.fiMaHoso,
            'ministryCode': 'MOH',
            'proceduceCode': options.maThuTuc
        };
        app.makePost({
            url: '/moh/01/verify',
            data: JSON.stringify(data),
            success: function (d) {
                app.makePost({
                    url: '/moh/01/hoso/guihoso',
                    data: JSON.stringify(doc.data),
                    success: function (d) {
                        app.Alert('Gửi hồ sơ thành công');
                        setTimeout(function () {
                            History.go(-1);
                        }, 1500);
                    },
                    error: function (e) {
                        app.Alert('Gửi hồ sơ không thành công');
                    }
                });
            },
            error: function (e) {
                if(e.hasOwnProperty('message')) {
                    app.Alert(e.message);
                } else {
                    app.Alert('Ký số không thành công, vui lòng thử lại.');
                }
            }
        });
    };
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.formVM().fiSoDkkd(d.data.fiSoDkkd);
            self.formVM().fiLoaihinh(d.data.fiLoaihinh);
            self.btnLuu(false);
            self.btnGui(false);
        };
        
        var resultForm = self.formVM().isValidForm();        
        if (!resultForm) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        
        var fileIsVaild = self.fileVM().isVaild();
        if(!fileIsVaild){
            app.Alert('File đính kèm cần được cập nhật đầy đủ.');
            return;       
        }
        
        var paymentIsVaild = self.paymentVM().isVaild();
        
        if(!paymentIsVaild){
            app.Alert('Thông tin chứng từ cần được cập nhật đầy đủ.');
            return;       
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();
        data.lstThanhToans = self.paymentVM().toJSON();
        data.lstDinhKems = self.fileVM().toJSON();

        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/moh/01/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (!app.requireSigning) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
                                } else {
                                    var result = d.sign;
                                    var onSuccess = function (res) {
                                        if (res.status == 'ok') {
                                            self.verifySignature(res.outputData, d);
                                        } else {
                                            app.Alert('Ký số không thành công, vui lòng thử lại.');
                                        }
                                    };
                                    var onFailed = function (e) {
                                        app.Alert('Ký số không thành công, vui lòng thử lại.');
                                    };

                                    RTVNSignClient.ping(function(res){
                                        RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                    }, function(e){
                                        app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                    });
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được hồ sơ');
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    };
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        document.location = context + '/moh/01/home?maThuTuc=' + options.maThuTuc;
    };

    window.addEventListener('message', function (event) {
        var d = JSON.parse(event.data);
        //console.log(d);
        if (d.action == 'onUploadSuccessFromDVCTTBYTE') {
            $("#dialog").dialog("close");
            if (d.frameId == "frame1") {
                self.formVM().currentAttach.fiMaTep(d.fileId);
                self.formVM().currentAttach.fiTenTep(d.fileName);
                self.formVM().currentAttach.fiDuongDan(d.fileURL);
            } else if (d.frameId == "frame2") {
                self.paymentVM().updateAfterUpload(d);
            }
        }
    });
}


$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();
    var fiMucDichNhapKhau = function () {
        var item = options.maThuTuc;
        var d = item.substring(item.length - 2,  item.length);
        return d;
    };
    $.when(
            app.getCategory('/moh/01/danhmuc', 'DANHMUC_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/moh/01/danhmuc', 'DANHMUC_QUOCGIA', null, function (res) {
                if (res.success) {
                    options.lstQuocGia = res.data;
                } else {
                    options.lstQuocGia = [];
                }
            }),
            app.getCategory('/moh/01/danhmuc', 'DANHMUC_DONVINHAN', null, function (res) {
                if (res.success) {
                    options.lstDonViNhan = res.data;
                } else {
                    options.lstDonViNhan = [];
                }
            }),
            app.getCategory('/moh/01/danhmuc', 'DANHMUC_TAILIEU', fiMucDichNhapKhau(), function (res) {
                if (res.success) {                    
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];                    
                }
            }),
            app.getCategory('/moh/01/danhmuc', 'DANHMUC_MUCDICHNHAPKHAU', null, function (res) {
                if (res.success) {
                    options.lstMucDichNhapKhau = res.data;
                } else {
                    options.lstMucDichNhapKhau = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/01/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;

                        //Lay danh muc quan/huyen theo tinh thanh
                        app.getCategory('/moh/01/danhmuc', 'DANHMUC_QUANHUYEN', options.hoso.fiMaTinh, function (res) {
                            if (res.success) {
                                options.lstQuanHuyen = res.data;
                            } else {
                                options.lstQuanHuyen = [];
                            }

                            var editVM = new EditVM(options);
                            ko.applyBindings(editVM, document.getElementById('EditVM'));

                            $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                            $("#fiMaQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                            $("#fiMaDvNhan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                            $("#fiMaMdichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                            $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, dateFormat: 'dd/mm/yy'});
                        });
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKems = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaDvNhan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaMdichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, dateFormat: 'dd/mm/yy'});
        }
    };
});

