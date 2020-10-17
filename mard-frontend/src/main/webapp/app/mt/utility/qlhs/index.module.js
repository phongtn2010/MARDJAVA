/**
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

        var Tbdhoso = function () {
            this.viewid = ko.observable();
            this.fiIdHoso = ko.observable();
            this.fiMaHoso = ko.observable();
            this.fiTendoanhnghiep = ko.observable();
            this.fiNgaygui = ko.observable();
            this.fiSoGiayphep = ko.observable();
            this.fiNgaycapphep = ko.observable();
            this.fiTrangthai = ko.observable();
            this.fiMaThutuc = ko.observable();
            this.urlThutuc = ko.observable();
            this.urlGiayphep = ko.observable();
            this.fiManguoitao= ko.observable();
        }


        var SearchFormModel = function () {
            form = this;
            this.fiMaThutuc = ko.observable('-1');
            this.fiMaHoso = ko.observable(null).extend({
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
            this.fiNgaygui = new DateForm();
            this.fiNgaygui.FROM.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaygui.FROM() || !form.fiNgaygui.TO() || form.fiNgaygui.FROM() <= form.fiNgaygui.TO();
                    },
                    message: '"Cấp phép từ ngày" luôn phải nhỏ hơn "Cấp phép đến ngày"',
                }
            });
            this.fiNgaygui.TO.extend({
                validation: {
                    validator: function () {
                        return !form.fiNgaygui.FROM() || !form.fiNgaygui.TO() || form.fiNgaygui.FROM() <= form.fiNgaygui.TO();
                    },
                    message: '"Cấp phép từ ngày" luôn phải nhỏ hơn "Cấp phép đến ngày"',
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
            this.fiManguoitao = {VALUE: userCustom.username, OPERATOR: '='};
            this.fiTrangthai = ko.observable('-1');
            this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);
        }

        self.danhSachThutuc = ko.observableArray();
        self.danhSachTrangThai = ko.observableArray();

        self.loadBefore = function() {
            app.makePost({
                url: '/mt/qlhs/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/thutuc/search",
                    METHOD: "POST",
                    REQUEST: {}
                }),
                success: function (d) {
                    var tatca = {};
                    tatca["fiTenThutuc"] = ko.observable("--- Tất cả ----");
                    tatca["fiMaThutuc"] = ko.observable(null);
                    var selectDefault = {
                        fiIdThutuc : -1,
                        fiMaThutuc : "-1",
                        fiTenThutuc : "--- Tất cả ----",
                        fiTientoTt : "VL1",
                        fiIdNhomTt : 1,
                        fiHoatdong : 1,
                        fiNguoitao : "Admin",
                        fiNgaytao : null,
                        fiNgCapnhat : null
                    };
                    self.danhSachThutuc.push(app.convertObjectToObservable(selectDefault, {}));
                       if (d.data) {
                           d.data.forEach(function (item, index) {
                               self.danhSachThutuc.push(app.convertObjectToObservable(item, {}));
                           });
                       }
                    $(".select2").select2({ placeholder: '', width: '100%'});
                },
                error: function (e) {
                }
            });
            app.makePost({
                url: '/mt/qlhs/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/trangthai/search",
                    METHOD: "POST",
                    REQUEST: {}
                }),
                success: function (d) {
                    var selectDefault = {fiTrangthaiId: -1, fiTenTrangthai: '--- Tất cả ----', fiTriggerTinnhan: 0, fiTrangthaitruoc: null};
                    self.danhSachTrangThai.push(app.convertObjectToObservable(selectDefault, {}));
                    if (d.data) {
                        d.data.forEach(function (item, index) {
                            self.danhSachTrangThai.push(app.convertObjectToObservable(item, {}));
                        });
                    }
                    $(".select2").select2({ placeholder: '', width: '100%'});
                },
                error: function (e) {
                }
            });
        }
        self.loadBefore();
        self.searchForm = new SearchFormModel();
        self.totalData = ko.observable(0);
        self.danhSachHoSo = ko.observableArray(0);
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0});

        self.searchHoSo = function () {
            self.pagingVM.currentPage(1);
            self.searching(true);
        }

        self.getDate = function(d) {
            if (!d) return null;
            return moment(d).format("DD/MM/YYYY");
        }
        self.searching = function (showMsg) {
            var searchItem = {
                maHoSo: self.searchForm.fiMaHoso(),
                maThucTuc: self.searchForm.fiMaThutuc(),
                ngayCapPhepDen: self.getDate(self.searchForm.fiNgaycapphep.TO()),
                ngayCapPhepTu: self.getDate(self.searchForm.fiNgaycapphep.FROM()),
                ngayNopDen: self.getDate(self.searchForm.fiNgaygui.TO()),
                ngayNopTu: self.getDate(self.searchForm.fiNgaygui.FROM()),
                pageIndex: self.pagingVM.currentPage(),
                pageSize: 10,
                soGiayPhep: self.searchForm.fiSoGiayphep(),
                trangThai: self.searchForm.fiTrangthai()
            };
            if (searchItem.trangThai == '-1') searchItem.trangThai = null;
            if (searchItem.maThucTuc == '-1') searchItem.maThucTuc = null;
            console.log(searchItem);

            self.pagingVM.totalCount(0);
            $('#loadingBlock').show();
            self.danhSachHoSo.removeAll();
            self.searchForm.currentPage(self.pagingVM.currentPage());
            self.searchForm.pageSize(self.pagingVM.pageSize());
             app.makePost({
                url: '/mt/qlhs/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/qlhs/search",
                    URL_GET_TOTAL: "/mt/qlhs/getTotalRecord",
                    METHOD: "POST",
                    REQUEST: searchItem
                }),
                success: function (d) {
                    $('#loadingBlock').hide();
                    self.pagingVM.totalCount(d.total);
                    self.totalData(d.total);
                    if (d.total == null || d.total == 0) {
                        self.pagingVM.currentPage(0);
                    }
                    if (d.data) {
                        d.data.forEach(function (item, index) {
                            self.danhSachHoSo.push(app.convertObjectToObservable(item, new Tbdhoso()));
                        })
                    }

                },
                error: function (e) {
                    $('#loadingBlock').hide();
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
            if (item.urlGiayphep()) {
                location.href = context+item.urlGiayphep();
            }
        }

        self.typeForm = ko.observable('search');

        self.isValidateForm = ko.computed(function () {
            if (!self.searchForm.fiNgaygui.FROM || !self.searchForm.fiNgaygui.TO || self.searchForm.fiNgaygui.FROM <= self.searchForm.fiNgaygui.TO) {
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
        self.getTenThuTuc = function (maThuTuc) {
            var match = ko.utils.arrayFirst(self.danhSachThutuc(), function (item) {
                return item.fiMaThutuc() == maThuTuc;
            });
            if (match) {
                return match.fiTenThutuc();
            }
            return '';
        }
        self.xemHoSo = function (item) {
            if (item.urlThutuc()) {
                location.href = context+ item.urlThutuc();
            }
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
