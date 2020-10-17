/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);
function YeuCauVM(fiMsg, item, action) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiIdHoso = ko.observable(item.formVM().fiIdHoso());
    self.fiMaHoso = ko.observable(item.formVM().fiMaHoso());
    self.fiTrangthai = ko.observable(item.formVM().fiTrangthai());
    self.fiContent = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    var lstVG = [self.fiContent];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.fiTrangthai() > 1) {
            if (self.lstErrors().length > 0) {
                self.lstErrors.showAllMessages();
                return false;
            }
        }
        if (item.resultVM().toJson() == '') {
            return false;
        }
        return true;
    };

    self.makeRequest = function (cb) {

        app.makePost({
            url: action,
            data: JSON.stringify({
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiContent(),
                fiMaHoso: self.fiMaHoso(),
                fiSoGp: item.resultVM().toJson()
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                    cb();
                } else {
                    msg = data.message ? data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                }
                app.Alert(msg);
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    };
}
function ViewVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.resultVM = ko.observable(new ResultVM(options));
    self.showCert = ko.observable(false);
    if (options.tab) {
        self.showCert(true);
    }


    self.btnTroLaiClick = function () {
        History.go(-1);
    };
   
   

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    $.when(
             app.getCategory('/mic/p02/danhmuc', 'DM_NOICAPGP', null, function (res) {
                if (res.success) {
                    options.lstNoiCP = res.data;
                } else {
                    options.lstNoiCP = [];
                }
            }),
             app.getCategory('/mic/p02/danhmuc', 'DM_MUCDICH', null, function (res) {
                if (res.success) {
                    options.lstMucDich = res.data;
                } else {
                    options.lstMucDich = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_TRANGTHAI', null, function (res) {
                if (res.success) {
                    RAW_HS_STATUS = res.data;
                } else {
                    RAW_HS_STATUS = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_TEVTV', null, function (res) {
                if (res.success) {
                    options.lstDMTenTV = res.data;
                } else {
                    options.lstDMTenTV = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_KIEUIN', null, function (res) {
                if (res.success) {
                    options.lstDMKieuIn = res.data;
                } else {
                    options.lstDMKieuIn = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_CHATLUONG', null, function (res) {
                if (res.success) {
                    options.lstDMChatLuong = res.data;
                } else {
                    options.lstDMChatLuong = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_DVTKHUANKHO', null, function (res) {
                if (res.success) {
                    options.lstDMDvKhuankho = res.data;
                } else {
                    options.lstDMDvKhuankho = [];
                }
            }),
            app.getCategory('/mic/p02/danhmuc', 'DM_DVTTOCDO', null, function (res) {
                if (res.success) {
                    options.lstDMDvTocDo = res.data;
                } else {
                    options.lstDMDvTocDo = [];
                }
            })
            ).done(function (data) {
                
        init();
    });

    var cb = function () {
         DINHKEMDATA = RAW_HS_STATUS;
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
    };

    var init = function () {
        if (options && options.fiIdHoSo > 0) {
            var url = '/mic/p02/hoso/t/' + options.fiIdHoSo;
            var url_result = '/mic/p02/hoso/vanban';
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        if (options.tab) {
                            app.makePost({
                                url: url_result,
                                data: JSON.stringify({
                                    fiIdHoSo: options.fiIdHoSo,
                                    fiMaHoSo: options.fiMaHoSo
                                }),
                                success: function (obj) {
                                    if (obj.success) {
                                        if (obj.data != null) {
                                            options.giayphep = obj.data;
                                            cb();
                                        }
                                    }
                                },
                                error: function (e) {
                                    app.Alert('Không lấy được dữ liệu công văn.');
                                    cb();
                                }
                            });
                        } else {
                            cb();
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        }
    };
});

