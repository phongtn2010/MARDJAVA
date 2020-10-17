/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function ChargeVM(option) {
    (option);

    var thongbao = option.thongbao;

    self = this;

    self.fiIdTtp = ko.observable(null);
    self.fiIdHoso = ko.observable(option.fiIdHoso);
    self.fiMaHoso = ko.observable( option.fiMaHoso);
    self.fiSotien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiNoidung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiNguoinop = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiNgaynop = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });

    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);


    // thong bao ap phi
    self.fiTongSotien = ko.observable(thongbao ? thongbao.fiTongSotien : null);
    self.fiNoidungTB = ko.observable(thongbao ? thongbao.fiNoidung : null);
    self.fiNgayXl = ko.observable(thongbao ? new Date(thongbao.fiNgayXl) : null);

    self.lstdinhkem = ko.observableArray(mapFilesVM(option.lstdinhkem ? option.lstdinhkem : [], option.fiIdHoso));
    // validate
    var chargeVG = [self.fiSotien, self.fiNoidung,
        self.fiNguoinop, self.fiNgaynop];
    self.chargeErrors = ko.validation.group(chargeVG, {deep: true, live: true, observable: true});

    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorCharge = true;
        var errorDinhkem = true;


        if (self.chargeErrors().length > 0) {
            self.chargeErrors.showAllMessages();
            errorCharge = false;
            return errorCharge;
        }

        

        return errorCharge;
    };

    //Convert to json object
    self.toJSON = function () {
        (self);
        var mapping = {
            ignore: ['btnGuiClick', 'btnTroLaiClick', 'chargeErrors', 'isValidForm', 'toJSON']
        };


        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        return copy;
    };

    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        if (!self.isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        var data = self.toJSON();

        delete data['__ko_mapping__'];

        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(pop.selector);
                        app.makePost({
                            url: '/most/05/hoso/thanhtoanphi',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi Thanh toán phí  thành công');
                                    History.go(-1);
                                } else {
                                    app.Alert('Không gửi được Thanh toán phí');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được Thanh toán phí');
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

var DINHKEMDATA = null;
var HINHTHUC = null;
$(document).ready(function () {
    var options = app.parseQuerystring();
    options.lstdinhkem = [{}];
    $('#loading10').show();

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            app.makePost({
                url: '/most/05/hoso/kqxl',
                data: JSON.stringify({
                    fiIdHoso: options.fiIdHoso,
                    fiMaHoso: options.fiMaHoso,
                    fiTrangthai: 20
                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.thongbao = d.data;
                        var vm = new ChargeVM(options);
                        ko.applyBindings(vm, document.getElementById('ChargeVM'));
                    } else {
                        msg = d.data.message ? d.data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                        app.Alert(msg);
                    }
                },
                error: function (e) {
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: NSWLang["common_msg_he_thong_chua_san_sang"],
                        function: 'success'
                    });
                }
            });
        }
    };

    init();
    $('#loading10').hide();
});

