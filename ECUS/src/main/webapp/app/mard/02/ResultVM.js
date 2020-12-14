function SuaCvVM(fiMsg, item) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMsg.nswfileCode);
    self.fiNoidungYc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    var lstVG = [self.fiNoidungYc];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }
        return true;
    };

}
function ResultVM(options) {
    debugger;
    console.log(options);
    var self = this;
    var congVan = options.resultVM;
    self.quarantineCerId = ko.observable(congVan ? congVan.quarantineCerId : null);
    self.nswFilecode = ko.observable(congVan ? congVan.nswFilecode : null);
    self.typeProduct = ko.observable(congVan ? congVan.typeProduct : null);
    self.dispatchNo = ko.observable(congVan ? congVan.dispatchNo : null);
    self.summary = ko.observable(congVan ? congVan.summary : null);
    self.companyname = ko.observable(congVan ? congVan.companyname : null);
    self.preamble = ko.observable(congVan ? congVan.preamble : null);
    self.importGate = ko.observable(congVan ? congVan.importGate : null);
    self.exportGate = ko.observable(congVan ? congVan.exportGate : null);
    self.executionTime = ko.observable(congVan ? congVan.executionTime : null);
    self.responseContent = ko.observable(congVan ? congVan.responseContent : null);
    self.recipient = ko.observable(congVan ? congVan.recipient : null);
    self.signConfirmDate = ko.observable(congVan ? new Date(congVan.signConfirmDate) : null);
    self.signConfirmName = ko.observable(congVan ? congVan.signConfirmName : null);
    self.signConfirmAddress = ko.observable(congVan ? congVan.signConfirmAddress : null);
    self.signConfirmLocation = ko.observable(congVan ? congVan.signConfirmLocation : null);
    self.signConfirmAddress = ko.observable(congVan ? congVan.signConfirmAddress : null);
    self.reasonEdit = ko.observable(congVan ? congVan.reasonEdit : null);


    //TamDT
    self.rsDay = ko.observable(null);
    self.rsMonth = ko.observable(null);
    self.rsYear = ko.observable(null);
    self.rsDateFormat = ko.observable(null);

    if(self.signConfirmDate() !== null || self.signConfirmDate() !== undefined){
        self.rsDay(self.signConfirmDate().getDay());
        self.rsMonth(self.signConfirmDate().getMonth()+1);
        self.rsYear(self.signConfirmDate().getFullYear());
        self.rsDateFormat(self.rsDay()+"/"+self.rsMonth()+"/"+self.rsYear());
    }

    self.hanghoa = ko.observableArray(congVan ? congVan.hanghoa : []);

    console.log("HANG HOA: ",self.hanghoa());

    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    self.btnXinSuaCVClick = function () {
        debugger;
        var dataSend = congVan;
        delete dataSend['__ko_mapping__'];
        var html = [
            $('#suaCV-tmpl').html()
        ].join('');
        delete self.suaCvVM;
        delete self.pop;

        delete self.popConfirm;

        self.suaCvVM = new SuaCvVM('Bạn chắc chắn muốn gửi yêu cầu sửa công văn', congVan);

        self.pop = app.popup({
            title: 'Xin sửa công văn',
            html: html,
            width: 500,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.makePost({
                            url: '/mard/p02/hoso/yc-suaCV',
                            data: JSON.stringify({
                                fiMahoso: congVan.nswFilecode,
                                reason: self.suaCvVM.fiNoidungYc(),
                                tbdQuarantineCer02: dataSend
                            }),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi xin sửa công văn thành công');
//                                    cb(d);
                                    setTimeout(function () {
                                        History.go(-1);
                                    }, 500);
                                } else {
                                    app.Alert('Không gửi được yêu cầu');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }

            ]
        });

        ko.applyBindings(self.suaCvVM, document.getElementById('suaCV-form'));
        return false;
    }


}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        if (options && options.nswfileCode !== null) {
            var url = '/mard/p02/hoso/congVan/' + options.nswfileCode;
            app.makePost({
                url: url,
                data: JSON.stringify({

                }),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.resultVM = d.data;
                        var vm = new ResultVM(options);
                        ko.applyBindings(vm, document.getElementById('ResultVM'));
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
});