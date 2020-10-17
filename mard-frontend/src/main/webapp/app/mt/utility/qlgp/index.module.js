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
        var DateForm = function () {
            this.FROM = ko.observable(null);
            this.TO = ko.observable(null);
            this.objectTypeDate = ['FROM', 'TO'];
        }

        var Tbdgiayphep = function () {
            this.viewid = ko.observable();
            this.fiIdHoso = ko.observable();
            this.fiMaHoso = ko.observable();
            this.fiSoGiayphep = ko.observable();
            this.fiNgaycapphep = ko.observable();
            this.fiTrangthai = ko.observable();
            this.fiLinkGiayphep = ko.observable();
            this.fiBienso = ko.observable();
        }


        var SearchFormModel = function () {
            form = this;
            this.fiBienso = ko.observable(null);
            this.fiBienso = ko.observable(null).extend({
                validation: [{
                    validator: function (val, lenght) {
                        return !val || val.length <= lenght;
                    },
                    message: 'Số giấy phép không được vượt quá 255 ký tự',
                    params: 255
                }]
            });
            this.fiSoGiayphep = ko.observable(null).extend({
                validation: [{
                    validator: function (val, lenght) {
                        return !val || val.length <= lenght;
                    },
                    message: 'Số giấy phép không được vượt quá 255 ký tự',
                    params: 255
                }]
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
            this.fiManguoitao = {VALUE: userCustom.username, OPERATOR: '='};
            this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);

        }
        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/qlhs/call_service',
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
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachTrangThai.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
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

        self.searchForm = new SearchFormModel();
        self.totalData = ko.observable(0);
        self.danhSachGiayphep = ko.observableArray(0);
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0});

        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();

        self.searchGiayphep = function () {
            self.pagingVM.currentPage(1);
            self.searching(true);
        }

        self.searching = function (showMsg) {
            self.pagingVM.totalCount(0);
            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
            self.danhSachGiayphep.removeAll();
            self.searchForm.currentPage(self.pagingVM.currentPage());
            self.searchForm.pageSize(self.pagingVM.pageSize());
            if (self.searchForm.fiNgaycapphep.TO() != null)
                self.searchForm.fiNgaycapphep.TO(new Date(self.searchForm.fiNgaycapphep.TO().setDate(self.searchForm.fiNgaycapphep.TO().getDate() + 1)));
            app.makePost({
                url: '/mt/qlgp/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/qlgp/search",
                    URL_GET_TOTAL: "/mt/qlgp/getTotalRecord",
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
                            self.danhSachGiayphep.push(app.convertObjectToObservable(item, new Tbdgiayphep()));
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
            if (item.fiLinkGiayphep()) {
                location.href = item.fiLinkGiayphep();
            }
        }

        self.typeForm = ko.observable('search');

        self.isValidateForm = ko.computed(function () {
            if (!self.searchForm.fiNgaycapphep.FROM || !self.searchForm.fiNgaycapphep.TO || self.searchForm.fiNgaycapphep.FROM <= self.searchForm.fiNgaycapphep.TO) {
                return false
            }
            return true;
        });

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
