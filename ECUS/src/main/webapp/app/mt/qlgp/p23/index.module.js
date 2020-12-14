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
            this.fiSogiayphep = ko.observable(null).extend({
                validation: [{
                    validator: function (val, lenght) {
                        return !val || val.length <= lenght;
                    },
                    message: 'Số giấy phép không được vượt quá 255 ký tự',
                    params: 255
                }]
            });
            this.fiTrangthaiSearch = ko.observable(null);
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
            this.fiManguoitao = {VALUE: ko.observable(null), OPERATOR: '='};
            this.fiLoaihoso = ko.observable(procedureId);
            this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);

        }


        self.searchForm = new SearchFormModel();
        self.totalData = ko.observable(0);
        self.danhSachHoSo = ko.observableArray(0);
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0});

        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();

        self.searchHoSo = function () {
            console.log(self.searchForm);
            self.pagingVM.currentPage(1);
            self.searching(true);
        }

        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/qlgp/23/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/trangthai/getTrangthaiForViewGP",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
                if (d.success) {
                    var tatca = {};
                    tatca["fiTenTrangthai"] = ko.observable("--- Tất cả ----");
                    tatca["fiTrangthaiId"] = ko.observable(null);
                    self.danhSachTrangThai.push(tatca);
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachTrangThai.push(app.convertObjectToObservable(item, itemBind));
                    }
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
                $('html,body').scrollTop(0);
            }
        });

        self.searching = function (showMsg) {
            self.pagingVM.totalCount(0);
            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
            self.danhSachHoSo.removeAll();
            self.searchForm.currentPage(self.pagingVM.currentPage());
            self.searchForm.pageSize(self.pagingVM.pageSize());
            if (self.searchForm.fiTrangthaiSearch() == null) {
                self.searchForm.fiTrangthai = {VALUE: [7, 8, 9, 10, 11]};
            } else {
                self.searchForm.fiTrangthai = self.searchForm.fiTrangthaiSearch();
            }
            if (self.searchForm.fiNgaygui.TO() != null)
                self.searchForm.fiNgaygui.TO(new Date(self.searchForm.fiNgaygui.TO().setDate(self.searchForm.fiNgaygui.TO().getDate() + 1)));
            if (self.searchForm.fiNgaycapphep.TO() != null)
                self.searchForm.fiNgaycapphep.TO(new Date(self.searchForm.fiNgaycapphep.TO().setDate(self.searchForm.fiNgaycapphep.TO().getDate() + 1)));

            app.makePost({
                url: '/mt/qlgp/23/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/23/hoso/fullSearchPagingFCAP",
                    URL_GET_TOTAL: "/mt/23/hoso/getTotalSearchFCAP",
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
                    console.log(e);
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
            location.href = app.appContext + '/mt/qlgp/23/view/license/' + procedureId + '/' + item.fiIdHoso();
        }

        self.typeForm = ko.observable('search');

        self.xemHoSo = function (item) {
            location.href = app.appContext + '/mt/qlgp/23/view/' + procedureId + "/" + item.fiIdHoso();
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
