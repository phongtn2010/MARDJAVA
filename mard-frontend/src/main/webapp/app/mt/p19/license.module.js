/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {

    function ViewModel() {

        var self = this;

        self.contextPath = ko.observable($('#contextPath').val());
        self.totalData = ko.observable(0);
        self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.giayphep = new Tbdgiayphep();

        self.getGiayPhep = function (id) {
            app.makeGet({
                url: '/mt/19/xemgiayphep/' + id,
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                        self.pagingVM.totalCount(d.total);
                        self.totalData(d.total);
                        self.giayphep = app.convertObjectToObservable(d.data, self.giayphep);
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }

        if (giayPhepId) {
            self.getGiayPhep(giayPhepId);
        }
        self.suaGiayPhep = function(id) {
            var callback = function (html) {
                var pop = app.popupWithLabel({
                    title: "Đề nghị sửa giấy phép"  + ' - Số giấy phép' + self.giayphep.fiSoGiayphep(),
                    label:"Lý do sửa giấy phép",
                    html: html,
                    width: 960,
                    buttons: [
                        {
                            name: NSWLang["common_button_gui"],
                            class: 'btn blue',
                            icon: 'fa fa-paper-plane',
                            action: function () {
                                var isOk = app.isFormVaild('form-ly-do-popup');
                                if (!isOk)
                                    return;

                                var data = app.form2Value('#form-ly-do-popup');
                                var popConfirm = app.popup({
                                    title: NSWLang["common_msg_thong_bao"],
                                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn yêu cầu sửa giấy phép ' + ' <b>' + self.giayphep.fiSoGiayphep() + '</b>',
                                    width: 400,
                                    buttons: [
                                        {
                                            name: NSWLang["common_button_toi_chac_chan"],
                                            class: 'btn',
                                            icon: 'fa-check',
                                            action: function () {
                                                app.makePost({
                                                    url: '/mt/19/ycsuagiayphep',
                                                    data:  JSON.stringify({fiIdGiayphep: self.giayphep.fiIdGiayphep(), fiLydo: data,fiIdHoso:  self.giayphep.fiIdHoso(),fiLoaihoso:procedureId}),
                                                    success: function (d) {

                                                        var fun = 'success';
                                                        if (d.success) {
                                                            app.popupRemove(popConfirm.selector);
                                                            app.popupRemove(pop.selector);
                                                            self.showActionSuccess(true);
                                                            self.showActionError(false);
                                                            app.toast({
                                                                title: NSWLang["common_msg_thong_bao"],
                                                                message: "Yêu cầu sửa giấy phép thành công",
                                                                function: fun
                                                            });
                                                            location.href = app.appContext + '/mt/19/home/'+  procedureId;
                                                        } else {
                                                            self.showActionSuccess(false);
                                                            self.showActionError(true);
                                                        }


                                                    },
                                                    error: function (e) {
                                                        
                                                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                                        app.popupRemove(popConfirm.selector);
                                                        self.showActionSuccess(false);
                                                        self.showActionError(true);
                                                    }
                                                });
                                            }
                                        }
                                    ]
                                });

                            }
                        },
                        {
                            name: NSWLang["common_button_dong"],
                            class: 'btn red',
                            icon: 'fa-remove',
                            action: function () {
                                app.popupRemove(pop.selector);
                            }
                        }
                    ]
                });
            };

            app.complieTemplate({
                ministryCode: "mt",
                code: "p19",
                templateName: "ly_do",
                data: []
            }, callback);
        }

        self.traGiayPhep = function(id) {
            var callback = function (html) {
                var pop = app.popupWithLabel({
                    title: "Đề nghị trả giấy phép"   + ' - Số giấy phép' + self.giayphep.fiSoGiayphep(),
                    label:"Lý do trả giấy phép",
                    html: html,
                    width: 960,
                    buttons: [
                        {
                            name: NSWLang["common_button_gui"],
                            class: 'btn blue',
                            icon: 'fa fa-paper-plane',
                            action: function () {

                                var isOk = app.isFormVaild('form-ly-do-popup');

                                if (!isOk)
                                    return;

                                var data = app.form2Value('#form-ly-do-popup');
                                var popConfirm = app.popup({
                                    title: NSWLang["common_msg_thong_bao"],
                                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn yêu cầu trả giấy phép ' + ' <b>' + self.giayphep.fiSoGiayphep() + '</b>',
                                    width: 400,
                                    buttons: [
                                        {
                                            name: NSWLang["common_button_toi_chac_chan"],
                                            class: 'btn',
                                            icon: 'fa-check',
                                            action: function () {
                                                app.makePost({
                                                    url: '/mt/19/yctragiayphep',
                                                    data:  JSON.stringify({fiIdGiayphep:  self.giayphep.fiIdGiayphep(), fiLydo: data,fiIdHoso:  self.giayphep.fiIdHoso(),fiLoaihoso:procedureId}),
                                                    success: function (d) {

                                                        var fun = 'success';
                                                        if (d.success) {
                                                            app.popupRemove(popConfirm.selector);
                                                            app.popupRemove(pop.selector);
                                                            self.showActionSuccess(true);
                                                            self.showActionError(false);
                                                            app.toast({
                                                                title: NSWLang["common_msg_thong_bao"],
                                                                message: "Yêu cầu trả giấy phép thành công",
                                                                function: fun
                                                            });
                                                            location.href = app.appContext + '/mt/19/home/'+  procedureId;
                                                        } else {
                                                            self.showActionSuccess(false);
                                                            self.showActionError(true);
                                                        }


                                                    },
                                                    error: function (e) {
                                                        
                                                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                                        app.popupRemove(popConfirm.selector);
                                                        self.showActionSuccess(false);
                                                        self.showActionError(true);
                                                    }
                                                });
                                            }
                                        }
                                    ]
                                });
                            }
                        },
                        {
                            name: NSWLang["common_button_dong"],
                            class: 'btn red',
                            icon: 'fa-remove',
                            action: function () {
                                app.popupRemove(pop.selector);
                            }
                        }
                    ]
                });
            };

            app.complieTemplate({
                ministryCode: "mt",
                code: "p19",
                templateName: "ly_do",
                data: []
            }, callback);
        }
        self.dong = function () {
        	if(type==1){
        		location.href = app.appContext + '/mt/19/home/'+  procedureId;
        	}else{
        		location.href = app.appContext + '/mt/qlhs/home';
        	}
            
        }
    }

    var vm = new ViewModel();
    ko.applyBindings(vm);
});
