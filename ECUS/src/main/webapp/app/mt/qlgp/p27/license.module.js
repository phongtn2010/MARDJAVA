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

        self.danhsachgiayphep = ko.observableArray();

        var Page = function(){
            this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);
        }
        self.page = new Page();
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0, currentPage : 1});
        var id_hoso ;
        self.getGiayPhep = function (id) {
            id_hoso = id;
            self.danhsachgiayphep.removeAll();
            self.page.currentPage(self.pagingVM.currentPage());
            app.makePost({
                url: '/mt//qlgp/27/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/27/giayphep/license_detail/" + id,
                    URL_GET_TOTAL:"/mt/27/giayphep/license_detail/getTotal/" + id ,
                    METHOD: "POST",
                    REQUEST: app.convertFormObservableJson(self.page)
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log("seach ok");
                        self.pagingVM.totalCount(d.total);
                        self.totalData(d.total);
                        for (const item of d.data) {
                            var loai = "";
                            if(item.fiLoaiphuongtien == 1){
                                loai = 'Xe khách';
                            }else if(item.fiLoaiphuongtien == 2){
                                loai = 'Xe tải';
                            } else{
                                loai = 'Xe khác';
                            }
                            var gp = app.convertObjectToObservable(item, new Tbdgiayphep());
                            gp.fiLoaiphuongtien(loai);
                            self.danhsachgiayphep.push(gp);
                        }
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
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToFirst = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
            self.getGiayPhep(id_hoso);
        };

        self.goToPrevious = function () {
            var previous = self.pagingVM.previousPage();
            if (previous != null) {
                self.pagingVM.setCurrentPage(previous);
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToNext = function () {
            var next = self.pagingVM.nextPage();
            if (next != null) {
                self.pagingVM.setCurrentPage(next);
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToLast = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
            self.getGiayPhep(id_hoso);
        };

        self.xemChiTietGiayPhep = function (item) {
            console.log(item);
            var callback = function (html) {
                var pop = app.popup({
                    title: 'Xem chi tiết giấy phép - ' + item.fiSoGiayphep(),
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
                ministryCode: "mt/qlgp",
                code: "p27",
                templateName: "license_detail",
                data: item
            }, callback);
        }

        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/qlgp/27/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/trangthai/search",
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
                } else {
                    msg = data.message;
                    fun = 'error';
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
        self.getTenTrangthai = function (idTrangthai) {
            var match = ko.utils.arrayFirst(self.danhSachTrangThai(), function (item) {
                return item.fiTrangthaiId() == idTrangthai;
            });
            if (match) {
                return match.fiTenTrangthai();
            }
            return '';
        }

        if (giayPhepId) {
            self.getGiayPhep(giayPhepId);
        }

        self.dong = function () {
            location.href = app.appContext + '/mt/qlgp/27/home/'+  procedureId;
        }
    }

    var vm = new ViewModel();
    ko.applyBindings(vm);
});
