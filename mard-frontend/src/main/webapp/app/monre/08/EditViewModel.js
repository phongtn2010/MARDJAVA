/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);



function Monre08CreateVM(options) {
    
    self = this;

    self.monre08FormVM = ko.observable(new Monre08FormVM(options));
    self.monre08FilesVM = ko.observable(new Monre08FilesVM(options));

    self.btnLuu = ko.observable(false);
    if (self.monre08FormVM().fiIdHoso() > 0) {
        if (self.monre08FormVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }
    
    self.validateFromData = function(){
        var flag = true;
        
        return flag;
    }
    
    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        
        var cb = function (d) {
            self.monre08FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre08FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre08FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre08FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre08FormVM().fiTenTt(d.data.fiTenTt);
            self.monre08FormVM().fiNgaytao(new Date(d.data.fiNgaytao));

            self.monre08FilesVM().fiIdHoso(self.monre08FormVM().fiIdHoso());
            self.monre08FilesVM().fiMaHoso(self.monre08FormVM().fiMaHoso());
            self.monre08FilesVM().assignDocToAttachments();
        };

        if (!self.monre08FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        if (!self.monre08FilesVM().isValidForm()) {
            app.Alert('Bạn chưa chọn đủ các tệp đính kèm!');
            return;
        }

        var fiIdHoso = self.monre08FormVM().fiIdHoso();
        var data = self.monre08FormVM().toJSON();
        
        data["lstDinhKem"] = self.monre08FilesVM().toJSON();

        delete data['__ko_mapping__'];
        
        var url = !fiIdHoso || fiIdHoso <= 0 ? '/monre/08/hoso/taomoi' : '/monre/08/hoso/capnhat';

        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                
                debugger;
                
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
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.monre08FormVM().fiIdHoso(d.data.fiIdHoso);
            self.monre08FormVM().fiMaHoso(d.data.fiMaHoso);
            self.monre08FormVM().fiNguoitao(d.data.fiNguoitao);
            self.monre08FormVM().fiTrangthai(d.data.fiTrangthai);
            self.monre08FormVM().fiTenTt(d.data.fiTenTt);
            self.monre08FormVM().fiNgaytao(new Date(d.data.fiNgaytao));

            self.monre08FilesVM().fiIdHoso(self.monre08FormVM().fiIdHoso());
            self.monre08FilesVM().fiMaHoso(self.monre08FormVM().fiMaHoso());
            self.monre08FilesVM().assignDocToAttachments();

        };

        if (!self.monre08FormVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }
        if (!self.monre08FilesVM().isValidForm()) {
            app.Alert('Bạn chưa chọn đủ các tệp đính kèm!');
            return;
        }

        var fiIdHoso = self.monre08FormVM().fiIdHoso();
        var data = self.monre08FormVM().toJSON();
        data["lstDinhKem"] = self.monre08FilesVM().toJSON();

        delete data['__ko_mapping__'];
         var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ này không ?</b>' ,
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(pop.selector);
                        app.makePost({
                           url: '/monre/08/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
//                                    $('#btnLuu').hide();
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
                                    
                                    setTimeout(function(){
                                        History.go(-1);
                                    }, 500);
                                    
                                    
                                } else {
                                    app.Alert('Không gửi được hồ sơ');
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
                        app.popupRemove(pop.selector);
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
        History.go(-1);
    };
}


$(document).ready(function () {
    
    var options = app.parseQuerystring();
    $.when(
        app.getCategory('/monre/08/danhmuc', 'DVXL', null, function (res) {
            if (res.success) {
                options.lstDonViXuLy = res.data;
            }
        }),
        app.getCategory('/monre/08/danhmuc', 'DINHKEM', null, function (res) {
            if (res.success) {
                options.dmDinhKem = res.data;
            } else {
                options.dmDinhKem = [];
            }
        })
    ).done(function (data) {
        init();
    });

    var init = function () {
        
        if (options && options.fiIdHoso > 0) {
            var url = '/monre/08/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var monre08CreateVM = new Monre08CreateVM(options);
                        ko.applyBindings(monre08CreateVM, document.getElementById('Monre08CreateVM'));
                        $("#fiMaCoQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var monre08CreateVM = new Monre08CreateVM(options);
            ko.applyBindings(monre08CreateVM, document.getElementById('Monre08CreateVM'));
            $("#fiMaCoQuan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

