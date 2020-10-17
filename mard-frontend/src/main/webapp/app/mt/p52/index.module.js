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

        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');
        // danh sach ho so


        var SearchFormModel = function () {
            form = this;
            this.fiMaHoso = ko.observable(null).extend({
                validation: [{
                    validator: function (val, lenght) {
                        return !val || val.length <= lenght;
                    },
                    message: 'Mã hồ sơ không được vượt quá 255 ký tự',
                    params: 255
                }]
            });
            this.fiTrangthai = ko.observable(null);
            this.fiNgaygui = new DateForm();
            this.fiNgaygui.FROM.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaygui.FROM() || !form.fiNgaygui.TO() || form.fiNgaygui.FROM() <= form.fiNgaygui.TO();
                    },
                    message: '"Ngày nộp từ ngày" luôn phải nhỏ hơn "Ngày nộp đến ngày"',
                }
            });
            this.fiNgaygui.TO.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaygui.FROM() || !form.fiNgaygui.TO() || form.fiNgaygui.FROM() <= form.fiNgaygui.TO();
                    },
                    message: '"Ngày nộp từ ngày" luôn phải nhỏ hơn "Ngày nộp đến ngày"',
                }
            });
            this.fiNgaycapphep = new DateForm();
            this.fiNgaycapphep.FROM.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaycapphep.FROM() || !form.fiNgaycapphep.TO() || form.fiNgaycapphep.FROM() <= form.fiNgaycapphep.TO();
                    },
                    message: '"Cấp phép từ ngày" luôn phải nhỏ hơn "Cấp phép đến ngày"',
                }
            });
            this.fiNgaycapphep.TO.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaycapphep.FROM() || !form.fiNgaycapphep.TO() || form.fiNgaycapphep.FROM() <= form.fiNgaycapphep.TO();
                    },
                    message: '"Cấp phép từ ngày" luôn phải nhỏ hơn "Cấp phép đến ngày"',
                }
            });
            this.fiLoaihoso = ko.observable(procedureId);
            this.fiManguoitao = {VALUE: userCustom.username, OPERATOR: '='};
            this.fiSogiayphep = ko.observable(null).extend({
                validation: [{
                    validator: function (val, lenght) {
                        return !val || val.length <= lenght;
                    },
                    message: 'Số giấy phép không được vượt quá 255 ký tự',
                    params: 255
                }]
            });
            this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);

        }


        self.searchForm = new SearchFormModel();
        self.totalData = ko.observable(0);
        self.danhSachHoSo = ko.observableArray(0);
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0});

        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();

        self.searchHoSo = function () {
            self.pagingVM.currentPage(1);
            self.searching(true);
        }

        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/52/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/trangthai/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    var tatca = {};
                    tatca["fiTenTrangthai"] = ko.observable("--- Tất cả ----");
                    tatca["fiTrangthaiId"] = ko.observable(null);
                    self.danhSachTrangThai.push(tatca);
                    for (const item of d.data) {
                        var itemBind = {};
                        if(item.fiTrangthaiId==0 || item.fiTrangthaiId==1 || item.fiTrangthaiId==2
                            || item.fiTrangthaiId ==3 || item.fiTrangthaiId==4 || item.fiTrangthaiId==5
                            || item.fiTrangthaiId==6 || item.fiTrangthaiId==7 ){
                            self.danhSachTrangThai.push(app.convertObjectToObservable(item, itemBind));
                        }
                    }
                }
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

        self.searching = function (showMsg) {
            self.pagingVM.totalCount(0);
            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
            self.danhSachHoSo.removeAll();
            self.searchForm.currentPage(self.pagingVM.currentPage());
            self.searchForm.pageSize(self.pagingVM.pageSize());

            app.makePost({
                url: '/mt/52/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/52/hoso/fullSearchPaging",
                    URL_GET_TOTAL:"/mt/52/hoso/getTotalSearch",
                    METHOD: "POST",
                    REQUEST: app.convertFormObservableJson(self.searchForm)
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        self.pagingVM.totalCount(d.total);
                        self.totalData(d.total);
                        if (d.total == 0) {
                            self.pagingVM.currentPage(0);
                        }
                        for (const item of d.data) {
                            self.danhSachHoSo.push(app.convertObjectToObservable(item, new Tbdhoso()));
                        }
                        if (showMsg) {
                            app.toast({
                                title: NSWLang["common_msg_thong_bao"],
                                message: NSWLang["mt.msg.search.success"],
                                function: 'success'
                            });
                        }
                    } else {
                        app.toast({
                            title: NSWLang["mt.msg.err"],
                            message: data.message,
                            function: 'error'
                        });
                    }
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

        self.goToPage = function (page) {
            if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
                self.pagingVM.setCurrentPage(page);
                self.searching(false);
            }

        };

        self.goToFirst = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
            self.searching(false);
        };

        self.goToPrevious = function () {
            var previous = self.pagingVM.previousPage();
            if (previous != null) {
                self.pagingVM.setCurrentPage(previous);
                self.searching(false);
            }

        };

        self.goToNext = function () {
            var next = self.pagingVM.nextPage();
            if (next != null) {
                self.pagingVM.setCurrentPage(next);
                self.searching(false);
            }

        };

        self.goToLast = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
            self.searching(false);
        };

        self.xemGiayPhep = function (item) {
            location.href = app.appContext + '/mt/52/view/license/' + procedureId +'/'+ item.fiIdHoSo() +'/1';
        }

        self.typeForm = ko.observable('search');

        self.suaHoSo = function (item) {
            location.href = app.appContext + '/mt/52/edit/' + procedureId + "/" + item.fiIdHoSo();
        }
        self.xemHoSo = function (item) {
            location.href = app.appContext + '/mt/52/view/' + procedureId + "/" +  item.fiIdHoSo();
        }
        self.themMoiHoSo = function (item) {
            location.href = app.appContext + '/mt/52/new/'+procedureId;
        }

        self.xoaHoSo = function (item) {
            pop = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"] + ' <b>' + item.fiMaHoSo() + '</b>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.makePost({
                                url: '/mt/52/call_service',
                                data: JSON.stringify({
                                    URL_BACKEND: "/mt/52/hoso/delete_all",
                                    METHOD: "POST",
                                    REQUEST: item.fiIdHoSo()

                                }),
                                success: function (d) {
                                    var msg = '';
                                    var fun = 'success';
                                    if (d.success) {
                                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                        app.popupRemove(pop.selector);
                                        self.searching(false);

                                    } else {
                                        msg = data.message;
                                        fun = 'error';
                                    }
                                    app.toast({
                                        title: NSWLang["common_msg_thong_bao"],
                                        message: msg,
                                        function: fun
                                    });
                                },
                                error: function (e) {
                                    
                                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                }
                            });
                        }
                    }
                ]
            });
        }
        self.danhSachLichSu = ko.observableArray();
        self.xemLichSu = function (item) {
            var url = '/mt/52/history/' + item.fiIdHoSo()+'/1';
            self.danhSachLichSu.removeAll();
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        msg = d.message;
                        var total = 0;
                        if (d.data != null && d.data.length > 0) {
                            total = d.total;
                        }
                        var callback = function (html) {
                            var pop = app.popup({
                                title: NSWLang["sbv_01_lichsh_table_00"] + ' - ' + item.fiMaHoSo(),
                                html: html,
                                width: 960,
                                buttons: [
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
                            code: "p52",
                            templateName: "lich_su_tac_dong",
                            data: d.data
                        }, callback);

                        $('#' + 'lich-su-pagination').pagination({
                            items: total,
                            itemsOnPage: 10,
                            cssStyle: 'light-theme',
                            edges: 2,
                            displayedPages: 5,
                            prevText: NSWLang['monre_01_pagination_trang_truoc'],
                            nextText: NSWLang['monre_01_pagination_trang_sau'],
                            onPageClick: function (pageNumber, event) {
                                var url = '/mt/52/history/' + item.fiIdHoSo() + '/' + pageNumber;
                                app.bindData({
                                    ministryCode: 'mt',
                                    code: 'p52',
                                    templateName: "lich_su_tac_dong_item",
                                    container: '#historyContainer',
                                    url: url,
                                    data: JSON.stringify({})
                                }, function (d) {
                                    
                                });

                                return false;
                            }
                        });

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
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                }
            });
        }

        self.rutHoSo = function (item) {
            var callback = function (html) {
                var pop = app.popupWithLabel({
                    title: "Đề nghị rút hồ sơ" + ' - Mã hồ sơ ' + item.fiMaHoSo(),
                    label: "Lý do rút hồ sơ",
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
                                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn rút hồ sơ ' + ' <b>' + item.fiMaHoSo() + '</b>',
                                    width: 400,
                                    buttons: [
                                        {
                                            name: NSWLang["common_button_toi_chac_chan"],
                                            class: 'btn',
                                            icon: 'fa-check',
                                            action: function () {
                                                app.makePost({
                                                    url: '/mt/52/ycruthoso',
                                                    data: JSON.stringify({
                                                        fiIdHoSo: item.fiIdHoSo(),
                                                        fiLyDoRut: data,
                                                        fiLoaiHoSo: item.fiLoaiHoSo()
                                                    }),
                                                    success: function (d) {

                                                        var fun = 'success';
                                                        if (d.success) {
                                                            app.popupRemove(popConfirm.selector);
                                                            app.popupRemove(pop.selector);
                                                            self.showActionSuccess(true);
                                                            self.showActionError(false);
                                                            self.searching(false);
                                                            app.toast({
                                                                title: NSWLang["common_msg_thong_bao"],
                                                                message: "Yêu cầu rút hồ sơ thành công",
                                                                function: fun
                                                            });

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
                code: "p52",
                templateName: "ly_do",
                data: []
            }, callback);
        }
        self.getTenTrangthai = function (idTrangthai) {
            var match = ko.utils.arrayFirst(self.danhSachTrangThai(), function (item) {
                return item.fiTrangthaiId() == idTrangthai;
            });
            if (match) {
                return match.fiTenTrangthai();
            }
            return '';
        }

    }

    ko.validation.init({
        insertMessages: true,
        messagesOnModified: true,
        decorateElement: true,
        parseInputAttributes: true,
        errorElementClass: 'wrong-field'
    }, true);

    var vm = new ViewModel();

    ko.bindingHandlers.datepicker = {
        init: function (element, valueAccessor, allBindingsAccessor) {
            var options = allBindingsAccessor().datepickerOptions || {};

            $(element).datepicker(options);

            //handle the field changing
            ko.utils.registerEventHandler(element, "change", function () {
                var observable = valueAccessor();
                observable($(element).datepicker("getDate"));
            });

            //handle disposal (if KO removes by the template binding)
            ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
                $(element).datepicker("destroy");
            });

        }
    };
    ko.validation.makeBindingHandlerValidatable('datepicker');

    vm.errors = ko.validation.group(vm, {deep: true});

    ko.applyBindings(vm);
    vm.searching(false);
});
